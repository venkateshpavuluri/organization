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
import com.mnt.erp.bean.BonusTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class BonusTypeController {
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

    @RequestMapping(value = "/bonusTypeHome", method = RequestMethod.GET)
    public String getBonusType(
	    @ModelAttribute("bonusTypeCmd") BonusTypeBean bonusTypeBean,
	    SessionStatus status, Model model, HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("bonusTypeHome.mnt",
		session.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	// model.addAttribute("activityCmd", new ActivityBean());
	return "bonusTypeView";
    }

    @RequestMapping(value = "/addBonusType", method = RequestMethod.POST)
    @RequestScoped
    public String saveBonusType(

    @ModelAttribute("bonusTypeCmd") BonusTypeBean bonusTypeBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from BonusTypeBean o where  o.bonusType='"
		    + bonusTypeBean.getBonusType() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(bonusTypeBean);

		map.addAttribute("bonusTypeBean", bonusTypeBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "BonusTypeBean", "ROW", String
				    .valueOf(bonusTypeBean.getBonusTypeId()),
			    "1", modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("bonusTypeCmd", new BonusTypeBean());
		    return "redirect:bonusTypeHome.mnt?list=" + "success" + "";
		} else {
		    return "redirect:bonusTypeHome.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Bonus Type is already exists";

		bonusTypeBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "bonusTypeView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:bonusTypeHome.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchBonusType", method = RequestMethod.GET)
    public String searchBonusType(
	    @ModelAttribute("bonusTypeCmd") BonusTypeBean bonusTypeBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<BonusTypeBean> bonusTypeList = null;
	try {
	    bonusTypeBean.getBonusTypeId();
	    bonusTypeList = new ArrayList<BonusTypeBean>();
	    String dbField = bonusTypeBean.getXmlLabel();
	    String operation = bonusTypeBean.getOperations();
	    String basicSearchId = bonusTypeBean.getBasicSearchId();

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
		sql = "select a.bonusTypeId,a.bonusType from BonusTypeBean a";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    BonusTypeBean bonusSearch = new BonusTypeBean();
		    bonusSearch.setBonusTypeId((Integer) obj[0]);
		    bonusSearch.setBonusType((String) obj[1]);

		    bonusTypeList.add(bonusSearch);
		}

	    } else {

		sql = "select a.bonusTypeId,a.bonsuType from BonusTypeBean a where a."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    BonusTypeBean bonusSearch = new BonusTypeBean();
		    bonusSearch.setBonusTypeId((Integer) obj[0]);
		    bonusSearch.setBonusType((String) obj[1]);

		    bonusTypeList.add(bonusSearch);
		}

	    }
	    request.setAttribute("bonusBeans", bonusTypeList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "bonusTypeView";
    }

    @RequestMapping(value = "/editBonusType", method = RequestMethod.GET)
    public String editBonusType(
	    @ModelAttribute("bonusTypeCmd") BonusTypeBean bonusTypeBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("bonusTypeId"));
	try {

	    sql = "select a.bonusTypeId,a.bonusType from BonusTypeBean a where a.bonusTypeId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		bonusTypeBean.setBonusTypeId((Integer) obj[0]);
		bonusTypeBean.setBonusType((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "bonusTypeView";

    }

    @RequestMapping(value = "/updateBonusType", method = RequestMethod.POST)
    public String updateBonusType(
	    @ModelAttribute("bonusTypeCmd") BonusTypeBean bonusTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String bonusName = bonusTypeBean.getBonusType();
	int bonusId = bonusTypeBean.getBonusTypeId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from BonusTypeBean ab where ab.bonusType='"
		    + bonusName + "'and ab.bonusTypeId!='" + bonusId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		bonusTypeBean.setBonusType(bonusTypeBean.getBonusType());

		int message = dao.updateDetails(bonusTypeBean);

		if (message != 0) {
		    request.setAttribute("BonusTypeUpdate",
			    "Bonus Type Updated Successfully");

		} else {
		    request.setAttribute("BonusTypeUpdateFail",
			    "Bonus Type Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Bonus Type is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "bonusTypeView";
	    }
	    model.addAttribute("bonusTypeCmd", new BonusTypeBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "bonusTypeView";
    }

    @RequestMapping(value = "/deleteBonusType", method = RequestMethod.GET)
    public String deleteBonusType(
	    @ModelAttribute("bonusTypeCmd") BonusTypeBean bonusTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("bonusTypeId"));
	    BonusTypeBean deleteBean = new BonusTypeBean();
	    deleteBean.setBonusTypeId(groupId);

	    int msg = dao.deleteDetails(deleteBean);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "BonusTypeBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("BonusTypeDelete",
			"Bonus Type is Deleted Successfully");
	    } else {
		request.setAttribute("BonusTypeDeleteFail",
			"Bonus Type is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("bonusTypeCmd", new BonusTypeBean());
	return "bonusTypeView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "bonusType";
	Map<String, String> map = null;
	try {
	    map = xmlService.populateXmlLabels(name);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
