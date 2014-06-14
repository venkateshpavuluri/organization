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
import com.mnt.erp.bean.ActivityBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class ActivityController {

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

    @RequestMapping(value = "/activityHome", method = RequestMethod.GET)
    public String getActivity(
	    @ModelAttribute("activityCmd") ActivityBean activity,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("activityHome.mnt",
		session.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("activityCmd", new ActivityBean());

	return "activityView";
    }

    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    @RequestScoped
    public String saveActivity(

    @ModelAttribute("activityCmd") ActivityBean activityBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from ActivityBean o where  o.activity='"
		    + activityBean.getActivity()+ "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(activityBean);

		map.addAttribute("activityBean", activityBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "ActivityBean", "ROW", String.valueOf(activityBean
				    .getActivityId()), "1", modifiedDate,
			    session.getAttribute("userName").toString());
		    model.addAttribute("activityCmd", new ActivityBean());
		    return "redirect:activityHome.mnt?list=" + "success" + "";
		} else {
		    return "redirect:activityHome.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Activity is already exists";

		activityBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "activityView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:activityHome.mnt?listwar=" + "fail" + "";
	}
    }
    @RequestMapping(value = "/searchActivity", method = RequestMethod.GET)
    public String searchActivity(@ModelAttribute("activityCmd") ActivityBean activityBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<ActivityBean> activityList = null;
	try {
	     activityBean.getActivityId();
	    activityList = new ArrayList<ActivityBean>();
	    String dbField = activityBean.getXmlLabel();
	    String operation = activityBean.getOperations();
	    String basicSearchId = activityBean.getBasicSearchId();

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
		sql = "select a.activityId,a.activity from ActivityBean a";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    ActivityBean activitySearch = new ActivityBean();
		    activitySearch.setActivityId((Integer) obj[0]);
		    activitySearch.setActivity((String) obj[1]);

		    activityList.add(activitySearch);
		}

	    } else {

		sql = "select a.activityId,a.activity from ActivityBean a where a."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    ActivityBean activitySearch = new ActivityBean();
		    activitySearch.setActivityId((Integer) obj[0]);
		    activitySearch.setActivity((String) obj[1]);

		    activityList.add(activitySearch);
		}

	    }
	    request.setAttribute("activityBeans", activityList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "activityView";
    }

    @RequestMapping(value = "/editActivity", method = RequestMethod.GET)
    public String editActivity(@ModelAttribute("activityCmd") ActivityBean activityBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("activityId"));
	try {

	    sql = "select a.activityId,a.activity from ActivityBean a where a.activityId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		activityBean.setActivityId((Integer) obj[0]);
		activityBean.setActivityEdit((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "activityView";

    }

    @RequestMapping(value = "/updateActivity", method = RequestMethod.POST)
    public String updateActivity(@ModelAttribute("activityCmd") ActivityBean activityBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String licenceName = activityBean.getActivityEdit();
	int licenceId = activityBean.getActivityId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from ActivityBean ab where ab.activity='"
		    + licenceName + "'and ab.activityId!='" + licenceId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		activityBean.setActivity(activityBean.getActivityEdit());

		int message = dao.updateDetails(activityBean);

		if (message != 0) {
		    request.setAttribute("ActivityUpdate",
			    "Activity Data Updated Successfully");

		} else {
		    request.setAttribute("ActivityUpdateFail",
			    "Activity Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Activity is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "activityView";
	    }
	    model.addAttribute("activityCmd", new ActivityBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "activityView";
    }

    @RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
    public String deleteActivity(@ModelAttribute("activityCmd")ActivityBean activityBean,
	    HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("activityId"));
	    ActivityBean licence = new ActivityBean();
	    licence.setActivityId(groupId);

	    int msg = dao.deleteDetails(licence);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "ActivityBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("ActivityDelete",
			"Activity Data is Deleted Successfully");
	    } else {
		request.setAttribute("ActivityDeleteFail",
			"Activity Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("activityCmd", new ActivityBean());
	return "activityView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "activity";

	Map<String, String> map =null;

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
