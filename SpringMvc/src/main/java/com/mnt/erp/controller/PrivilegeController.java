/**
 * 
 */
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
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Privilege;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PrivilegeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 *
 */
@Controller
public class PrivilegeController {
	
@Autowired
PrivilegeService privilegeService;
@Autowired
XmlLabelsService xmlService;
@Autowired
MenuService menuService;
@Autowired AuditLogService auditLogService;
HttpSession session;
@RequestMapping(value="/privilegeHome",method=RequestMethod.GET)
@RequestScoped
public ModelAndView privilegeType(
		@ModelAttribute("privilegeAdd") Privilege privilege,
		SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	 session=request.getSession(false);
	List<String> list=menuService.getPrivilige("privilegeHome.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
	return new ModelAndView("privilegeHome","privilegeAdd",new Privilege());
}
@RequestMapping(value="/privilegeAdd",method=RequestMethod.GET)
@RequestScoped


public String savePrivilegeDetails(
		@ModelAttribute("privilegeAdd") @Valid Privilege privilege,
		BindingResult result, DefaultSessionAttributeStore store,
		WebRequest request1, HttpServletRequest request,
		SessionStatus status, Model model,HttpServletResponse response) {

	String msa = null;
	String url=null;
	List<String> list=null;
	
	
	//String privilegefailUpdate = null;
	
	Long duplicateId=0l;

	try {
		//here we set the CharacterEncoding to resonse becoz of Localization Concept 
		response.setCharacterEncoding("UTF-8");
		if (result.hasErrors()) {
			privilege.setAid(1);
		return "privilegeHome";
		}
		//this method is used to check the Duplicates
		duplicateId=privilegeService.duplicatePrivilegeCheck(privilege.getPrivilege());
		if(duplicateId==0)
		{
			list=new ArrayList<String>();
			session=request.getSession(false);
			//here ther is no duplicates 
			// saveMaterialDetails this method is used to save Material Details
		msa = privilegeService.savePrivilegeDetails(privilege,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
		model.addAttribute("privilegeAdd",new Privilege());
		if (msa.equals("S")) {
			list.add("1");
			url="redirect:privilegeHome.mnt?list="
					+ list + "";
		}
		else
		{
			list.add("1");
			url="redirect:privilegeHome.mnt?listwar="
					+ list + "";
			
		}
		model.addAttribute("privilegeAdd", privilege);
		}
		else
		{
			
			request.setAttribute("PrivilegeDuplicate","Privilege Name '"+privilege.getPrivilege()+"' Already exist");
			privilege.setAid(1);
			return "privilegeHome";
		}
	
	} catch (Exception e) {
		e.printStackTrace();
		list.add("1");
		model.addAttribute("privilegeAdd", privilege);
		url="redirect:privilegeHome.mnt?listwar="
				+ list + "";
				}

	return url;
}
@RequestMapping(value = "/privilegeSearch", method = RequestMethod.GET)
@Scope("request")
@RequestScoped
public String searchPrivilege(@ModelAttribute Privilege privilegeSearch,
		BindingResult bindingResult, HttpServletRequest request,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	
	List<Object[]> list = null;
	
	List<Privilege> privilegeBean = new ArrayList<Privilege>();


	try {
		String dbField = privilegeSearch.getXmlLabel();
		String operation = privilegeSearch.getOperations();
		String basicSearchId = privilegeSearch.getBasicSearchId();
		
		if (operation.equals("_%")) {
			operation=" like ";
			basicSearchId = basicSearchId +"%";

		} else if (operation.equals("%_")) {
			operation=" like ";
			basicSearchId = "%" + basicSearchId;

		} else if (operation.equals("%_%")) {
			operation=" like ";
			basicSearchId =  "%"  + basicSearchId + "%" ;

		}
		if (basicSearchId == "") {
			list = privilegeService.searchPrivilege();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Privilege p = new Privilege();
				Object[] obj = (Object[]) iterator.next();
				p.setPrivilegeid((String) obj[0]);
				p.setPrivilege((String) obj[1]);
				
				privilegeBean.add(p);

			}
		}
			else {
				list = privilegeService.basicSearchPrivilege(dbField, operation,basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Privilege r = new Privilege();
					Object[] obj = (Object[]) iterator.next();
					r.setPrivilegeid((String) obj[0]);
					r.setPrivilege((String) obj[1]);
					
					privilegeBean.add(r);
				}
			}			request.setCharacterEncoding("UTF-8");
		request.setAttribute("privilegeSearch", privilegeBean);

	} catch (Exception e) {
		e.printStackTrace();
	}
	model.addAttribute("privilegeAdd", privilegeSearch);

	
	return "privilegeHome";
}



@ModelAttribute("PrivilegeSearchNames")
public Map<String, String> populateprivilegeSearchNames() {
	List<Object[]> listvalues = null;
	Iterator<Object[]> iterator = null;
	Map<String, String> map = null;
	try {
		listvalues = privilegeService.selectPrivilegeNames();
		map = new HashMap<String, String>();
		iterator = listvalues.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();

			// list.add((String)objects[1]);
			map.put((String) objects[0], (String) objects[1]);

		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}
@RequestMapping(value = "/privilegeEditHome", method = RequestMethod.GET)
@Scope("request")
@RequestScoped
public String privilegeEdit(@ModelAttribute Privilege privilegeDisplay,
		HttpServletRequest request, Model model,HttpServletResponse response) {
	String privilegename = request.getParameter("privilegeDetEdit");
	response.setCharacterEncoding("UTF-8");
	List<Object[]> list = null;
	Object[] object = null;


	List<Privilege> privilegesList = new ArrayList<Privilege>();

	try {

		list = privilegeService.searchPrivilegeWithId(privilegename);

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			object = (Object[]) iterator.next();
			privilegeDisplay.setPrivilegeidEdit((String) object[0]);
			privilegeDisplay.setPrivilegeEdit((String) object[1]);
			
			

			privilegesList.add(privilegeDisplay);

		}
		request.setAttribute("privilegeValues", privilegesList);

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		list = null;
		object = null;
	}
	model.addAttribute("privilegeAdd", privilegeDisplay);
	return "privilegeHome";
	/*
	 * return new
	 * ModelAndView("materialHome","materialAdd",materialDisplay);
	 */
}

@RequestMapping(value = "/privilegeUpdate", method = RequestMethod.POST)
@RequestScoped
public String updatePrivilege(@ModelAttribute("privilegeAdd") Privilege privilege,
		HttpServletRequest request, Model model,HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	Long duplicateId=0l;
	try {
		duplicateId=privilegeService.updateDuplicateCheck(privilege.getPrivilegeEdit(),privilege.getPrivilegeidEdit());
		
		if(duplicateId==0)
		{
		privilege.setPrivilegeid(privilege.getPrivilegeidEdit());
		privilege.setPrivilege(privilege.getPrivilegeEdit());
		

		String msg = privilegeService.updatePrivilege(privilege);

		if (msg.equals("S")) {
			request.setAttribute("privilegeUpadteSuccess",
					"Privilege Details Updated Successfully");
		}
		else
		{
			request.setAttribute("privilegeUpadteFail",
					"Privilege Details Did Not Updated");
		}
		}
		else
		{
			request.setAttribute("privilegeEditDuplicate","Privilege Already Exists");
			request.setAttribute("privilegeValues","hello");
			return"privilegeHome";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	model.addAttribute("privilegeAdd", new Privilege());
	/* return new ModelAndView("Home","materialAdd",new Material()); */
	return "privilegeHome";

}
@RequestMapping(value = "/privilegeDelete", method = RequestMethod.GET)
@RequestScoped
public ModelAndView privilegeDelete(HttpServletRequest request,HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String privilegeid= null;
	String delmsg1 = null; 
	String delmsg2 = null; 
	try {
		privilegeid = request.getParameter("privilegeidDelete");
		String msg = privilegeService.privilegeDelete(privilegeid);
		String delmsg = msg;
		String[] delmsgpart = delmsg.split(",");
		delmsg1 = delmsgpart[0]; 
		delmsg2 = delmsgpart[1]; 
		if (delmsg1.equals("S"))
		{
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Privilege","ROW" ,String.valueOf(privilegeid),"1",modifiedDate,session.getAttribute("userName").toString());
			request.setAttribute("privilegeDeleteSuccess",
					"Privilege "+delmsg2+" Deleted Successfully");
		}
		else
		{
			request.setAttribute("privilegeDeleteFail",
					"privilege Did Not Deleted");
		}
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("privilegeDeleteFail",
				"privilege "+delmsg2+" Did Not Deleted");
	}
	return new ModelAndView("privilegeHome", "privilegeAdd", new Privilege());
}

@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
	String name="privilegeId";

	Map<String, String> map =null;

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}
}
