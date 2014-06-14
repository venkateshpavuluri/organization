package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.AwardTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class AwardTypeController {
    List<Object[]> list = null;
    Iterator<Object[]> iterator = null;
    String sql;
    @Autowired
    ERPDao dao;
    @Autowired
    XmlLabelsService xmlService;
    @Autowired
    MenuService menuService;
    @Autowired
    AuditLogService auditLogService;
    HttpSession session;

    @RequestMapping(value = "/awardTypeHome", method = RequestMethod.GET)
    public String getAwardType(
	    @ModelAttribute("awardTypeCmd") AwardTypeBean awardTypeBean,
	    SessionStatus status, Model model, HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("awardTypeHome.mnt",
		session.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("awardTypeCmd", new AwardTypeBean());
	return "awardTypeView";
    }

    @RequestMapping(value = "/addAwardType", method = RequestMethod.POST)
    @RequestScoped
    public String saveAwardType(

    @ModelAttribute("awardTypeCmd") AwardTypeBean awardTypeBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from AwardTypeBean o where  o.awardType='"
		    + awardTypeBean.getAwardType() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(awardTypeBean);

		map.addAttribute("awardTypeBean", awardTypeBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "AwardTypeBean", "ROW", String
				    .valueOf(awardTypeBean.getAwardTypeId()),
			    "1", modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("awardTypeCmd", new AwardTypeBean());
		    return "redirect:awardTypeHome.mnt?list=" + "success" + "";
		} else {
		    return "redirect:awardTypeHome.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Award Type is already exists";

		awardTypeBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "awardTypeView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:awardTypeHome.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchAwardType", method = RequestMethod.GET)
    public String searchAwardType(
	    @ModelAttribute("awardTypeCmd") AwardTypeBean awardTypeBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<AwardTypeBean> awardTypeList = null;
	try {
	    awardTypeBean.getAwardTypeId();
	    awardTypeList = new ArrayList<AwardTypeBean>();
	    String dbField = awardTypeBean.getXmlLabel();
	    String operation = awardTypeBean.getOperations();
	    String basicSearchId = awardTypeBean.getBasicSearchId();

	    if (operation.equals("_%")) {
		operation = " like ";
		basicSearchId = basicSearchId + "%";

	    } else if (operation.equals("%_")) {
		operation = " like ";
		basicSearchId = "%" + basicSearchId;

	    } else if (operation.equals("%_%")) {
		operation = " like ";
		basicSearchId = "%" + basicSearchId + "%";

	    }

	    if (basicSearchId == "") {
		sql = "select a.awardTypeId,a.awardType from AwardTypeBean a";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    AwardTypeBean awardSearch = new AwardTypeBean();
		    awardSearch.setAwardTypeId((Integer) obj[0]);
		    awardSearch.setAwardType((String) obj[1]);

		    awardTypeList.add(awardSearch);
		}

	    } else {

		sql = "select a.awardTypeId,a.awardType from AwardTypeBean a where a."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    AwardTypeBean awardSearch = new AwardTypeBean();
		    awardSearch.setAwardTypeId((Integer) obj[0]);
		    awardSearch.setAwardType((String) obj[1]);

		    awardTypeList.add(awardSearch);
		}

	    }
	    request.setAttribute("awardBeans", awardTypeList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "awardTypeView";
    }

    @RequestMapping(value = "/editAwardType", method = RequestMethod.GET)
    public String editAwardType(
	    @ModelAttribute("awardTypeCmd") AwardTypeBean awardTypeBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("awardTypeId"));
	try {

	    sql = "select a.awardTypeId,a.awardType from AwardTypeBean a where a.awardTypeId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		awardTypeBean.setAwardTypeId((Integer) obj[0]);
		awardTypeBean.setAwardType((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "awardTypeView";

    }

    @RequestMapping(value = "/updateAwardType", method = RequestMethod.POST)
    public String updateAwardType(
	    @ModelAttribute("awardTypeCmd") AwardTypeBean awardTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String awardName = awardTypeBean.getAwardType();
	int awardId = awardTypeBean.getAwardTypeId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from AwardTypeBean ab where ab.awardType='"
		    + awardName + "'and ab.awardTypeId!='" + awardId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		awardTypeBean.setAwardType(awardTypeBean.getAwardType());

		int message = dao.updateDetails(awardTypeBean);

		if (message != 0) {
		    request.setAttribute("AwardTypeUpdate",
			    "Award Type Updated Successfully");

		} else {
		    request.setAttribute("AwardTypeUpdateFail",
			    "Award Type Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Award Type is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "awardTypeView";
	    }
	    model.addAttribute("awardTypeCmd", new AwardTypeBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "awardTypeView";
    }

    @RequestMapping(value = "/deleteAwardType", method = RequestMethod.GET)
    public String deleteAwardType(
	    @ModelAttribute("awardTypeCmd") AwardTypeBean awardTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("awardTypeId"));
	    AwardTypeBean deleteBean = new AwardTypeBean();
	    deleteBean.setAwardTypeId(groupId);

	    int msg = dao.deleteDetails(deleteBean);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "AwardTypeBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("AwardTypeDelete",
			"Award Type is Deleted Successfully");
	    } else {
		request.setAttribute("AwardTypeDeleteFail",
			"Award Type is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("awardTypeCmd", new AwardTypeBean());
	return "awardTypeView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "awardType";
	Map<String, String> map = null;
	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
