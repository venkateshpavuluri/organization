package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.mnt.erp.bean.InterviewRound;

import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class InterviewRoundController {

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

    @RequestMapping(value = "/interviewRound", method = RequestMethod.GET)
    public String getInterviewRound(
	    @ModelAttribute InterviewRound interviewround,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
//	 List<String> list=menuService.getPrivilige("interviewRound.mnt",
//	 session.getAttribute("userId").toString());
//	 session.setAttribute("privilegeList",list);
	model.addAttribute("interviewround", new InterviewRound());

	return "interviewroundView";
    }

    @RequestMapping(value = "/interviewAdd", method = RequestMethod.POST)
    @RequestScoped
    public String saveInterviewRound(

    @ModelAttribute("interviewround") InterviewRound interviewRound,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from InterviewRound o where  o.interviewRound='"
		    + interviewRound.getInterviewRound() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(interviewRound);

		map.addAttribute("interviewround", interviewRound);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "InterviewRound", "ROW", String
				    .valueOf(interviewRound
					    .getInterviewRoundId()), "1",
			    modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("interviewround", new InterviewRound());
		    return "redirect:interviewRound.mnt?list=" + "success" + "";
		} else {
		    return "redirect:interviewRound.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! interviewround is already exists";

		interviewRound.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "interviewroundView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:interviewround.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchInterview", method = RequestMethod.GET)
    public String searchInterviewRound(
	    @ModelAttribute("interviewround") InterviewRound interviewRound,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<InterviewRound> interviewList = null;
	try {
	    // int iid = interviewRound.getInterviewRoundId();
	    interviewList = new ArrayList<InterviewRound>();
	    String dbField = interviewRound.getXmlLabel();
	    String operation = interviewRound.getOperations();
	    String basicSearchId = interviewRound.getBasicSearchId();

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
		sql = "select intr.interviewRoundId, intr.interviewRound from InterviewRound intr";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    InterviewRound interviewSearch = new InterviewRound();
		    interviewSearch.setInterviewRoundId((Integer) obj[0]);
		    interviewSearch.setInterviewRound((String) obj[1]);

		    interviewList.add(interviewSearch);
		}

	    } else {

		// list = accountgroupservice.searchAccountGroupsWithId(iid);
		sql = "select intr.interviewRoundId, intr.interviewRound from InterviewRound intr where intr."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    InterviewRound interviewsearch = new InterviewRound();
		    interviewsearch.setInterviewRoundId((Integer) obj[0]);
		    interviewsearch.setInterviewRound((String) obj[1]);

		    interviewList.add(interviewsearch);
		}

	    }
	    request.setAttribute("licenceBeans", interviewList);
	    // model.addAttribute("accountGroup", new AccountGroupBean());
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "interviewroundView";
    }

    @RequestMapping(value = "/interviewEdit", method = RequestMethod.GET)
    public String editInterviewRound(
	    @ModelAttribute("interviewround") InterviewRound interviewRound,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("interviewEdit"));
	// List<Licence> licenceEdit = null;
	try {

	    sql = "select intr.interviewRoundId, intr.interviewRound from InterviewRound intr where intr.interviewRoundId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		interviewRound.setInterviewRoundId((Integer) obj[0]);
		interviewRound.setInterviewEdit((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "interviewroundView";

    }

    @RequestMapping(value = "/interviewUpdate", method = RequestMethod.POST)
    public String updateInterviewRound(
	    @ModelAttribute("interviewround") InterviewRound interviewRound,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String licenceName = interviewRound.getInterviewEdit();
	int licenceId = interviewRound.getInterviewRoundId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from InterviewRound ab where ab.interviewRound='"
		    + licenceName
		    + "'and ab.interviewRoundId!='"
		    + licenceId
		    + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		interviewRound.setInterviewRound(interviewRound
			.getInterviewEdit());

		int message = dao.updateDetails(interviewRound);

		if (message != 0) {
		    request.setAttribute("InterviewUpdate",
			    "Interview Round Data Updated Successfully");

		} else {
		    request.setAttribute("InterviewUpdateFail",
			    "Interview Round data not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! interview data is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "interviewroundView";
	    }
	    model.addAttribute("interviewround", new InterviewRound());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "interviewroundView";
    }

    @RequestMapping(value = "/interviewRoundDelete", method = RequestMethod.GET)
    public String interviewRoundDelete(HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request
		    .getParameter("interviewRoundDelete"));
	    InterviewRound licence = new InterviewRound();
	    licence.setInterviewRoundId(groupId);

	    int msg = dao.deleteDetails(licence);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "InterviewRound", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("InterviewRoundDelete",
			"Interviewround Data is Deleted Successfully");
	    } else {
		request.setAttribute("InterviewRoundDeleteFail",
			"Interviewround data is deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("interviewround", new InterviewRound());
	return "interviewroundView";
    }

    @ModelAttribute("xmlInterviewItems")
    
    public Map<String, String> populatLabelDetails() {
	String name = "interviewRound";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
