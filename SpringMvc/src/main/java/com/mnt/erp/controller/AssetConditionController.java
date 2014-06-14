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
import com.mnt.erp.bean.AssetConditionBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class AssetConditionController {
    
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

    @RequestMapping(value = "/assetConditionHome", method = RequestMethod.GET)
    public String getAssetCondition(
	    @ModelAttribute("assetConditionCmd") AssetConditionBean assetConditionBean,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("assetConditionHome.mnt",
		session.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("assetConditionCmd", new AssetConditionBean());

	return "assetConditionView";
    }

    @RequestMapping(value = "/addAssetCondition", method = RequestMethod.POST)
    @RequestScoped
    public String saveAssetCondition(

    @ModelAttribute("assetConditionCmd") AssetConditionBean assetConditionBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from AssetConditionBean o where  o.assetCondition='"
		    + assetConditionBean.getAssetCondition()+"'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(assetConditionBean);

		map.addAttribute("assetConditionBean", assetConditionBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "AssetConditionBean", "ROW", String.valueOf(assetConditionBean
				    .getAssetConditionId()), "1", modifiedDate,
			    session.getAttribute("userName").toString());
		    model.addAttribute("assetConditionCmd", new AssetConditionBean());
		    return "redirect:assetConditionHome.mnt?list=" + "success" + "";
		} else {
		    return "redirect:assetConditionHome.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Asset Condition is already exists";

		assetConditionBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "assetConditionView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:assetConditionHome.mnt?listwar=" + "fail" + "";
	}
    }
    @RequestMapping(value = "/searchAssetCondition", method = RequestMethod.GET)
    public String searchAssetCondition(@ModelAttribute("assetConditionCmd") AssetConditionBean assetConditionBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<AssetConditionBean> assetConditionList = null;
	try {
	     assetConditionBean.getAssetConditionId();
	    assetConditionList = new ArrayList<AssetConditionBean>();
	    String dbField = assetConditionBean.getXmlLabel();
	    String operation = assetConditionBean.getOperations();
	    String basicSearchId = assetConditionBean.getBasicSearchId();

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
		sql = "select n.assetConditionId,n.assetCondition, n.assetConditionCode from AssetConditionBean n";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    AssetConditionBean assetConditionSearch = new AssetConditionBean();
		    assetConditionSearch.setAssetConditionId((Integer) obj[0]);
		    assetConditionSearch.setAssetCondition((String) obj[1]);
		    assetConditionSearch.setAssetConditionCode((String) obj[2]);

		    assetConditionList.add(assetConditionSearch);
		}

	    } else {

		sql = "select a.assetConditionId,a.assetCondition,a.assetConditionCode from AssetConditionBean a where a."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    AssetConditionBean assetConditionSearch = new AssetConditionBean();
		    assetConditionSearch.setAssetConditionId((Integer) obj[0]);
		    assetConditionSearch.setAssetCondition((String) obj[1]);
		    assetConditionSearch.setAssetConditionCode((String) obj[2]);

		    assetConditionList.add(assetConditionSearch);
		}

	    }
	    request.setAttribute("assetConditionBeans", assetConditionList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "assetConditionView";
    }
    @RequestMapping(value = "/editAssetCondition", method = RequestMethod.GET)
    public String editAssetCondition(@ModelAttribute("assetConditionCmd") AssetConditionBean assetConditionBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("assetConditionId"));
	try {

	    sql = "select a.assetConditionId,a.assetCondition,a.assetConditionCode from AssetConditionBean a where a.assetConditionId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		assetConditionBean.setAssetConditionId((Integer) obj[0]);
		assetConditionBean.setAssetCondition((String) obj[1]);
		assetConditionBean.setAssetConditionCode((String)obj[2]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "assetConditionView";

    }

    @RequestMapping(value = "/updateAssetCondition", method = RequestMethod.POST)
    public String updateAssetCondition(@ModelAttribute("assetConditionCmd") AssetConditionBean assetConditionBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String assetConditionName = assetConditionBean.getAssetCondition();
	int assetConditionId = assetConditionBean.getAssetConditionId();
	//String assetConditionCode =  assetConditionBean.getAssetConditionCode();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from AssetConditionBean ab where ab.assetCondition='"
		    + assetConditionName + "'and ab.assetConditionId!='" + assetConditionId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		assetConditionBean.setAssetCondition(assetConditionBean.getAssetCondition());

		int message = dao.updateDetails(assetConditionBean);

		if (message != 0) {
		    request.setAttribute("AssetConditionUpdate",
			    "Asset Condition Data Updated Successfully");

		} else {
		    request.setAttribute("AssetConditionUpdateFail",
			    "Asset Condition Data Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Asset Condition is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "assetConditionView";
	    }
	    model.addAttribute("assetConditionCmd", new AssetConditionBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "assetConditionView";
    }

    @RequestMapping(value = "/deleteAssetCondition", method = RequestMethod.GET)
    public String deleteAssetCondition(@ModelAttribute("assetConditionCmd")AssetConditionBean assetConditionBean,
	    HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("assetConditionId"));
	    AssetConditionBean deleteBean = new AssetConditionBean();
	    deleteBean.setAssetConditionId(groupId);

	    int msg = dao.deleteDetails(deleteBean);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "AssetConditionBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("AssetConditionDelete",
			"Asset Condition Data is Deleted Successfully");
	    } else {
		request.setAttribute("AssetConditionDeleteFail",
			"Asset Condition Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("assetConditionCmd", new AssetConditionBean());
	return "assetConditionView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "assetCondition";

	Map<String, String> map =null;

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }

}
