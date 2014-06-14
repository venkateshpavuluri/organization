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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.mnt.erp.bean.Qualification;

import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;

import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.qualificationService;

@Controller
public class QualificationController {
@Autowired
qualificationService QService;
@Autowired
ERPDao dao;
@Autowired
XmlLabelsService xmlService;

@Autowired
AuditLogService auditLogService;

HttpSession session;


@Autowired
MenuService menuService;

String sus = null;
@RequestMapping(value = "/QHome", method = RequestMethod.GET)
public String getQualificationHome(
		@ModelAttribute("Qualification") Qualification qbean, SessionStatus status,HttpServletRequest request,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");

	HttpSession session=request.getSession(false);
	List<String> list=menuService.getPrivilige("QHome.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
	model.addAttribute("Qualification", new Qualification());
	return "QHome";
}
@RequestMapping(value = "/addQualification", method = RequestMethod.POST)
@RequestScoped
public String saveQualification(
		@ModelAttribute("Qualification") Qualification qbean,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	int isa = 0;
	String result =null;
	

	String qualificationCheck = qbean.getQualification();
	
	long res=dao.duplicateCheck("select count(*) from Qualification ag where ag.qualification='"+qualificationCheck+"'");
	
	if (res == 0) 
	{
		try {
			
			isa=dao.saveDetails(qbean);
			if(isa!=0)
			{
				session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Qualification","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());		
			}
			result = "redirect:QHome.mnt?list=" + "success" + "";							
			
			
		} catch (Exception e) {
			e.printStackTrace();
			result = "redirect:QHome.mnt?listwar=" + "fail" + "";
		}
	}
	else {
 
		
		qbean.setAid(1);
		request.setAttribute("addQualificationDuplicate",
				"Qualification Already Exists Choose Another One");

		return "QHome";

	}
	
	return result;
}
@RequestMapping(value = "/searchQualification", method = RequestMethod.GET)
@RequestScoped
public String searchQualification(
		@ModelAttribute("Qualification") Qualification qbean,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	
	List<Object[]> list = null;
	
	List<Qualification> qualificationSearch = new ArrayList<Qualification>();
	String dbField = qbean.getXmlLabel();
	String operation = qbean.getOperations();
	String basicSearchId = qbean.getBasicSearchId();
	 
	qbean.setXmlLabel(dbField);
	qbean.setOperations(operation);
	qbean.setBasicSearchId(basicSearchId);
	
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
			
			
			list=dao.searchDetails("select e.qualification_Id,e.qualification from Qualification e where e."
					+ dbField + " " + operation +"  '"+basicSearchId+"' order by e.qualification ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} else {

		try {
			qualificationSearch = new ArrayList<Qualification>();
		
		list=dao.searchDetails("select e.qualification_Id,e.qualification from Qualification e order by e.qualification");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Iterator<Object[]> iterator = list.iterator();
	while (iterator.hasNext()) {
		Qualification qlbean = new Qualification();
		Object[] objs = (Object[]) iterator.next();
		qlbean.setQualification_Id((Integer) objs[0]);
		qlbean.setQualification((String) objs[1]);
		qualificationSearch.add(qlbean);
		
	}
	
	request.setAttribute("qualificationSearch", qualificationSearch);

	return "QHome";
}
@RequestMapping(value = "/qualificationEditHome", method = RequestMethod.GET)

public String qualificationIdEdit(
		@ModelAttribute("Qualification") Qualification qubean,
		HttpServletRequest request, HttpServletResponse response,
		Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("qualificationIdEdit"));
			
	List<Object[]> list = null;
	Object[] object = null;

	List<Qualification> qubean1 = new ArrayList<Qualification>();

	try {

		list = QService.searchQualificationWithId(id);
         
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			object = (Object[]) iterator.next();
			qubean.setQualification_IdEdit((Integer) object[0]);
			qubean.setQualificationEdit((String) object[1]);
								
			qubean1.add(qubean);
		}
		request.setAttribute("qualificationValues", qubean1);

	} catch (Exception e) {
		e.printStackTrace();
	} 
	return "QHome";

}
@RequestMapping(value = "/qualificationDelete", method = RequestMethod.GET)
public String deleteQualification(
	@ModelAttribute("Qualification") Qualification prod,
	DefaultSessionAttributeStore store, WebRequest request1,
	HttpServletRequest request, SessionStatus status,
	HttpServletResponse response, Model model) {
response.setCharacterEncoding("UTF-8");

int id = Integer.parseInt(request.getParameter("qualificationIdDelete"));
	
	
	try
	{
		 
		 String msg=QService.deleteQualification(id);
		 if(msg.equals("S"))
		 {
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Qualification","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			 request.setAttribute("qualDelete", "Qualification Details Deleted Successfully");
			
		 }
		 
		
	} 
catch (Exception e) {
	e.printStackTrace();
	 request.setAttribute("qualDeleteErr", "Qualification Details Doesn't Deleted");
}

 model.addAttribute("Qualification", new Qualification());
 return "QHome";

}
@RequestMapping(value = "/qualificationUpdate", method = RequestMethod.POST)

public String updateQualification(
	@ModelAttribute("Qualification") Qualification prod,
	HttpServletRequest request, HttpServletResponse response,
	SessionStatus status, Model model) {
response.setCharacterEncoding("UTF-8");

int qualificationId = prod.getQualification_IdEdit();
String qualificationEdit = prod.getQualificationEdit();

prod.setQualification_Id(qualificationId);
prod.setQualification(qualificationEdit);


	long checkDuplicate=dao.duplicateCheck("select count(*) from  Qualification ag where ag.qualification='"
				+ qualificationEdit + "' and ag.qualification_Id!='" + qualificationId + "'")	;
if (checkDuplicate == 0) {
	try {
		
		dao.updateDetails(prod);	
		request.setAttribute("qualUpdate", "qualification Details Updated Successfully");
		
	}

	catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("qualUpdateErr", "qualification Details Doesn't Updated ");
	}
} else {
	
	request.setAttribute("qualUpdateDup", "qualification already exists choose another one");
	request.setAttribute("qualificationValues", "qualificationValues");
	return "QHome";

}

return "QHome";
}
@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
String name = "qualification";

Map<String, String> map = new HashMap<String, String>();

try {
	map = xmlService.populateXmlLabels(name);

} catch (Exception e) {
	e.printStackTrace();
}
return map;
}

}
