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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;


import com.mnt.erp.bean.workIncedenceBean;
import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;

import com.mnt.erp.service.MenuService;

import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.workIncedenceService;

@Controller
public class workIncedenceController {
	private Logger logger=Logger.getLogger(workIncedenceController.class);
@Autowired
workIncedenceService wservice;

@Autowired
MenuService menuService;
@Autowired
ERPDao dao;
@Autowired
XmlLabelsService xmlService;

HttpSession session;
String sus = null;

@Autowired
AuditLogService auditLogService;

@RequestMapping(value = "/WIHome", method = RequestMethod.GET)
public String getWorkIncedenceHome(
		@ModelAttribute("workIncedence") workIncedenceBean wbean, SessionStatus status,HttpServletRequest request,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession(false);
	List<String> list=menuService.getPrivilige("WIHome.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
	model.addAttribute("workIncedence", new workIncedenceBean());
	return "WIHome";
}
@RequestMapping(value = "/addWorkIncedence", method = RequestMethod.POST)
@RequestScoped
public String saveWorkIncedence(
		@ModelAttribute("workIncedence") workIncedenceBean wrbean,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	int isa = 0;
	String result=null;
	HttpSession session=null;

	String workIncedenceCheck = wrbean.getWorkIncedence();
	
	long res=dao.duplicateCheck("select count(*) from workIncedenceBean ag where ag.workIncedence='"+workIncedenceCheck+"'");
	
	if (res == 0) 
	{
		try {
			
			isa=dao.saveDetails(wrbean);
			
			if(isa!=0)
			{
				session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Work Incedence","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());
			result = "redirect:WIHome.mnt?list=" + "success" + "";
			}
				
			else{
				result = "redirect:WIHome.mnt?listwar=" + "fail" + "";
			}
			
			status.setComplete();
			
             
			
		} catch (Exception e) {
			result = "redirect:WIHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
			
		}
	}
	else {
 
		
		wrbean.setAid(1);
		request.setAttribute("addWorkIncedenceDuplicate",
				"Work Incedence Already Exists Choose Another One");

		return "WIHome";

	}
	
	return result;
}
@RequestMapping(value = "/searchWorkIncedence", method = RequestMethod.GET)
@RequestScoped
public String searchWorkIncedence(
		@ModelAttribute("workIncedence") workIncedenceBean wbean,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	
	List<Object[]> list = null;
	
	List<workIncedenceBean> workIncedenceSearch = new ArrayList<workIncedenceBean>();
	String dbField = wbean.getXmlLabel();
	String operation = wbean.getOperations();
	String basicSearchId = wbean.getBasicSearchId();
	 
	wbean.setXmlLabel(dbField);
	wbean.setOperations(operation);
	wbean.setBasicSearchId(basicSearchId);
	
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
	
	if (basicSearchId != "") {

		try {
			
			
			list=dao.searchDetails("select e.workIncedenceId,e.workIncedence from workIncedenceBean e where e."
					+ dbField + " " + operation +"  '"+basicSearchId+"'order by e.workIncedence ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} else {

		try {
			workIncedenceSearch = new ArrayList<workIncedenceBean>();
		
		list=dao.searchDetails("select e.workIncedenceId,e.workIncedence from workIncedenceBean e order by e.workIncedence");
		logger.info("work:"+list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Iterator<Object[]> iterator = list.iterator();
	while (iterator.hasNext()) {
		workIncedenceBean wibean = new workIncedenceBean();
		Object[] objs = (Object[]) iterator.next();
		wibean.setWorkIncedenceId((Integer) objs[0]);
		wibean.setWorkIncedence((String) objs[1]);
		workIncedenceSearch.add(wibean);
		
	}
	
	request.setAttribute("workIncedenceSearch", workIncedenceSearch);

	return "WIHome";
}
@RequestMapping(value = "/workIncedenceEditHome", method = RequestMethod.GET)

public String WorkIncedenceIdEdit(
		@ModelAttribute("workIncedence") workIncedenceBean POTbean,
		HttpServletRequest request, HttpServletResponse response,
		Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("workIncedenceIdEdit"));
			
	List<Object[]> list = null;
	Object[] object = null;

	List<workIncedenceBean> POTbean1 = new ArrayList<workIncedenceBean>();

	try {

		list = wservice.searchWorkIncedenceWithId(id);
         
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			object = (Object[]) iterator.next();
			POTbean.setWorkIncedenceIdEdit((Integer) object[0]);
			POTbean.setWorkIncedenceNameEdit((String) object[1]);
								
			POTbean1.add(POTbean);
		}
		request.setAttribute("workIncedenceValues", POTbean1);

	} catch (Exception e) {
		e.printStackTrace();
	} 
	return "WIHome";

}
@RequestMapping(value = "/workIncedenceDelete", method = RequestMethod.GET)
public String deleteWorkIncedence(
	@ModelAttribute("workIncedence") workIncedenceBean prod,
	DefaultSessionAttributeStore store, WebRequest request1,
	HttpServletRequest request, SessionStatus status,
	HttpServletResponse response, Model model) {
response.setCharacterEncoding("UTF-8");
int id = Integer.parseInt(request.getParameter("workIncedenceIdDelete"));
	
	
	try
	{
		 
		 String msg=wservice.deleteWorkIncedence(id);
		 
		 if(msg.equals("S"))
		 {
			 	session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Work Incedence","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("workIncedenceDelete","Work Incedence has been deleted");
		 }
		 else{
			 request.setAttribute("workIncedenceDeleteError","Work Incedence has not been deleted"); 
		 }
		
	} 
catch (Exception e) {
	e.printStackTrace();
}

 return "WIHome";

}
@RequestMapping(value = "/workIncedenceUpdate", method = RequestMethod.POST)

public String updateWorkIncedence(
	@ModelAttribute("workIncedence") workIncedenceBean prod,
	HttpServletRequest request, HttpServletResponse response,
	SessionStatus status, Model model) {
response.setCharacterEncoding("UTF-8");



int workIncedenceId = prod.getWorkIncedenceIdEdit();
String workIncedenceEdit = prod.getWorkIncedenceNameEdit();

prod.setWorkIncedenceId(workIncedenceId);
prod.setWorkIncedence(workIncedenceEdit);


	long checkDuplicate=dao.duplicateCheck("select count(*) from  workIncedenceBean ag where ag.workIncedence='"
				+ workIncedenceEdit + "' and ag.workIncedenceId!='" + workIncedenceId + "'")	;
if (checkDuplicate == 0) {
	try {
		
		int msg=dao.updateDetails(prod);	
		if(msg!=0){
		request.setAttribute("workIncedenceUpdate","Work Incedence has been updated");
		}
		else{
	     request.setAttribute("workIncedenceUpdateError","Work Incedence has not been updated");
		}
	
	}

	catch (Exception e) {
		e.printStackTrace();
	}
} else {

	request.setAttribute("workIncedenceValues","workIncedenceValues");
	request.setAttribute("workIncedenceUpdateCheck","Work Incedence already exists");
}

return "WIHome";
}
@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
String name = "workIncedence";

Map<String, String> map = new HashMap<String, String>();

try {
	map = xmlService.populateXmlLabels(name);

} catch (Exception e) {
	e.printStackTrace();
}
return map;
}

}
