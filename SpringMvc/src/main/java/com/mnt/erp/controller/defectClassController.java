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

import com.mnt.erp.bean.DefectClassBean;

import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;

import com.mnt.erp.service.MenuService;

import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.defectClassService;

@Controller
public class defectClassController {
	private Logger logger=Logger.getLogger(defectClassController.class);
@Autowired
defectClassService dService;
@Autowired
XmlLabelsService xmlService;
@Autowired
MenuService menuService;
@Autowired
ERPDao dao;
@Autowired
AuditLogService auditLogService;
HttpSession session;

String sus=null;

@RequestMapping(value = "/DefectHome", method = RequestMethod.GET)
public String getDefectClassHome(
		@ModelAttribute("defectClass") DefectClassBean wbean, SessionStatus status,HttpServletRequest request,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession(false);
	List<String> list=menuService.getPrivilige("DefectHome.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
	model.addAttribute("defectClass", new DefectClassBean());
	return "DefectHome";
}
@RequestMapping(value = "/addDefectClass", method = RequestMethod.POST)
@RequestScoped
public String saveDefectClass(
		@ModelAttribute("defectClass") DefectClassBean dbean,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	int isa = 0;
	String msg =null;
	

	String defectCheck = dbean.getDefectClass();
	
	long res=dao.duplicateCheck("select count(*) from DefectClassBean ag where ag.defectClass='"+defectCheck+"'");
	
	if (res == 0) 
	{
		try {
			
			isa=dao.saveDetails(dbean);
			
			if(isa!=0)
			{
				session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Defect Class","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());		
			}
										
			status.setComplete();
			msg = "redirect:DefectHome.mnt?list=" + "success" + "";
			
             
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "redirect:DefectHome.mnt?listwar=" + "fail" + "";
		}
	}
	else {
 
		
		dbean.setAid(1);
		request.setAttribute("addDefectClassDuplicate",
				"Defect class Already Exists Choose Another One");

		return "DefectHome";

	}
	
	return msg;
}
@RequestMapping(value = "/searchDefectClass", method = RequestMethod.GET)
@RequestScoped
public String searchDefectClass(
		@ModelAttribute("defectClass") DefectClassBean debean,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	
	List<Object[]> list = null;
	
	List<DefectClassBean> defectSearch = new ArrayList<DefectClassBean>();
	String dbField = debean.getXmlLabel();
	String operation = debean.getOperations();
	String basicSearchId = debean.getBasicSearchId();
	 
	debean.setXmlLabel(dbField);
	debean.setOperations(operation);
	debean.setBasicSearchId(basicSearchId);
	
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
			
			
			list=dao.searchDetails("select e.defectClassId,e.defectClass from DefectClassBean e where e."
					+ dbField + " " + operation +"  '"+basicSearchId+"' order by e.defectClass");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} else {

		try {
			defectSearch = new ArrayList<DefectClassBean>();
		
		list=dao.searchDetails("select e.defectClassId,e.defectClass from DefectClassBean e order by e.defectClass");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Iterator<Object[]> iterator = list.iterator();
	while (iterator.hasNext()) {
		DefectClassBean dbean = new DefectClassBean();
		Object[] objs = (Object[]) iterator.next();
		dbean.setDefectClassId((Integer) objs[0]);
		dbean.setDefectClass((String) objs[1]);
		defectSearch.add(dbean);
		
	}
	
	request.setAttribute("defectSearch", defectSearch);

	return "DefectHome";
}
@RequestMapping(value = "/defectClassEditHome", method = RequestMethod.GET)

public String DefectClassIdEdit(
		@ModelAttribute("defectClass") DefectClassBean debean,
		HttpServletRequest request, HttpServletResponse response,
		Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("defectClassIdEdit"));
			
	List<Object[]> list = null;
	Object[] object = null;

	List<DefectClassBean> dbean = new ArrayList<DefectClassBean>();

	try {

		list = dService.searchDefectClassWithId(id);
         
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			object = (Object[]) iterator.next();
			debean.setDefectClassIdEdit((Integer) object[0]);
			debean.setDefectClassNameEdit((String) object[1]);
								
			dbean.add(debean);
		}
		request.setAttribute("defectClassValues", dbean);

	} catch (Exception e) {
		e.printStackTrace();
	} 
	return "DefectHome";

}
@RequestMapping(value = "/defectClassDelete", method = RequestMethod.GET)
public String deleteDefectClass(
	@ModelAttribute("defectClass") DefectClassBean dbean,
	DefaultSessionAttributeStore store, WebRequest request1,
	HttpServletRequest request, SessionStatus status,
	HttpServletResponse response, Model model) {
response.setCharacterEncoding("UTF-8");

int id = Integer.parseInt(request.getParameter("defectClassIdDelete"));
	
	
	try
	{
		 
		 String msg=dService.deleteDefectClass(id);
		 if(msg.equals("S"))
		 {
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Defect Class","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			 request.setAttribute("defectDelete", "Defect Class Details Deleted Successfully");
			
		 }
		 
		
	} 
catch (Exception e) {
	 request.setAttribute("defectDeleteErr", "Defect Class Details Doesn't Deleted");
	e.printStackTrace();
}

	model.addAttribute("defectClass", new DefectClassBean());
	return "DefectHome";

}
@RequestMapping(value = "/defectClassUpdate", method = RequestMethod.POST)

public String updateDefectClass(
	@ModelAttribute("defectClass") DefectClassBean deBean,
	HttpServletRequest request, HttpServletResponse response,
	SessionStatus status, Model model) {
response.setCharacterEncoding("UTF-8");



int defectId = deBean.getDefectClassIdEdit();
String defectEdit = deBean.getDefectClassNameEdit();

deBean.setDefectClassId(defectId);
deBean.setDefectClass(defectEdit);


	long checkDuplicate=dao.duplicateCheck("select count(*) from  DefectClassBean ag where ag.defectClass='"
				+ defectEdit + "' and ag.defectClassId!='" + defectId + "'");
	
if (checkDuplicate == 0) {
	try {
		
		dao.updateDetails(deBean);	
		request.setAttribute("defectUpdate",  "Defect Class Details Updated Successfully");
		
	}

	catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("defectUpdateErr",  "Defect Class Details Not Updated");
	}
} else {

	
	request.setAttribute("defectUpdateDup",  "Defect Class already exist try another one");
	request.setAttribute("defectClassValues", "defectClassValues");
	return "DefectHome";
}
model.addAttribute("defectClass", new DefectClassBean());
return "DefectHome";
}
@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
String name = "defectClass";

Map<String, String> map =null;

try {
	map = xmlService.populateXmlLabels(name);

} catch (Exception e) {
	e.printStackTrace();
}
return map;
}

}
