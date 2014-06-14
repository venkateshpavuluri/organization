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

import com.mnt.erp.bean.ProjectResourceTypeBean;
import com.mnt.erp.bean.Qualification;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.projectResourceTypeService;

@Controller
public class projectResourceTypeController {
	@Autowired
	projectResourceTypeService PRTService;
	@Autowired
	ERPDao dao;
	@Autowired
	XmlLabelsService xmlService;
	String sus = null;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/ProjectResourceTypeHome", method = RequestMethod.GET)
	public String getProjectResourceTypeHome(
			@ModelAttribute("ProjectResourceType") ProjectResourceTypeBean prbean, SessionStatus status,
			HttpServletResponse response, Model model,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ProjectResourceTypeHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("ProjectResourceType", new ProjectResourceTypeBean());
		return "ProjectResourceTypeHome";
	}
	@RequestMapping(value = "/addProjectResourceType", method = RequestMethod.POST)
	@RequestScoped
	public String saveProjectResourceType(
			@ModelAttribute("ProjectResourceType") ProjectResourceTypeBean prbean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		String isa,result =null;
		String projResourceTypeSave =null;
		HttpSession session=null;

		String projResourceTypeCheck = prbean.getProjectResourceType();
		
		long res=dao.duplicateCheck("select count(*) from ProjectResourceTypeBean ag where ag.projectResourceType='"+projResourceTypeCheck+"'");
		
		if (res == 0) 
		{
			try {
				session=request.getSession(false);
				isa=PRTService.saveProjectResourceType(prbean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
	              
				
				//isa=dao.saveDetails(prbean);
				if (isa.equals("S")) 
					result = "redirect:ProjectResourceTypeHome.mnt?list=" + "success" + "";
				else
					result = "redirect:ProjectResourceTypeHome.mnt?listwar=" + "fail" + "";
					
	             
				
			} catch (Exception e) {
				e.printStackTrace();
				result = "redirect:ProjectResourceTypeHome.mnt?listwar=" + "fail" + "";
			}
		}
		else {
	 
			
			prbean.setAid(1);
			request.setAttribute("addProjectResourceTypeDuplicate",
					"Project Resource Type Already Exists Choose Another One");

			return "ProjectResourceTypeHome";

		}
		
		return result;
	}
	@RequestMapping(value = "/searchProjectResourceType", method = RequestMethod.GET)
	@RequestScoped
	public String searchProjectResourceType(
			@ModelAttribute("ProjectResourceType") ProjectResourceTypeBean prbean,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<ProjectResourceTypeBean> projResourceTypeSearch = new ArrayList<ProjectResourceTypeBean>();
		String dbField = prbean.getXmlLabel();
		String operation = prbean.getOperations();
		String basicSearchId = prbean.getBasicSearchId();
		 
		prbean.setXmlLabel(dbField);
		prbean.setOperations(operation);
		prbean.setBasicSearchId(basicSearchId);
		
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
				
				
				list=dao.searchDetails("select e.projectResourceType_Id,e.projectResourceType from ProjectResourceTypeBean e where e."
						+ dbField + " " + operation +"  '"+basicSearchId+"' order by e.projectResourceType ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {
				projResourceTypeSearch = new ArrayList<ProjectResourceTypeBean>();
			
			list=dao.searchDetails("select e.projectResourceType_Id,e.projectResourceType from ProjectResourceTypeBean e order by e.projectResourceType");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			ProjectResourceTypeBean ptbean = new ProjectResourceTypeBean();
			Object[] objs = (Object[]) iterator.next();
			ptbean.setProjectResourceType_Id((Integer) objs[0]);
			ptbean.setProjectResourceType((String) objs[1]);
			projResourceTypeSearch.add(ptbean);
			
		}
		
		request.setAttribute("projResourceTypeSearch", projResourceTypeSearch);

		return "ProjectResourceTypeHome";
	}
	@RequestMapping(value = "/projectResourceTypeEditHome", method = RequestMethod.GET)

	public String projectResourceTypeIdEdit(
			@ModelAttribute("ProjectResourceType") ProjectResourceTypeBean ptbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("projectResourceTypeIdEdit"));
				
		List<Object[]> list = null;
		Object[] object = null;

		List<ProjectResourceTypeBean> qubean1 = new ArrayList<ProjectResourceTypeBean>();

		try {

			list = PRTService.searchProjectResourceTypeWithId(id);
	         
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				ptbean.setProjectResourceType_IdEdit((Integer) object[0]);
				ptbean.setProjectResourceTypeEdit((String) object[1]);
									
				qubean1.add(ptbean);
			}
			request.setAttribute("projectResourceTypeValues", qubean1);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "ProjectResourceTypeHome";

	}
	@RequestMapping(value = "/projectResourceTypeDelete", method = RequestMethod.GET)
	public String deleteProjectresourceType(
		@ModelAttribute("ProjectResourceType") ProjectResourceTypeBean prod,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, SessionStatus status,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	String projResourceTypeDelete=null;
	HttpSession session=null;
	int id = Integer.parseInt(request.getParameter("projectResourceTypeIdDelete"));
		
		
		try
		{
			 
			 String msg=PRTService.deleteProjectResourceType(id);
			 if(msg.equals("S"))
			 {
				 session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","projResourceType","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
		     request.setAttribute("ProjResourceDel", "Project Resource Type Details Deleted Successfully");
				 
			 }
			
		} 
	catch (Exception e) {
		e.printStackTrace();
		 request.setAttribute("ProjResourceDelErr", "Project Resource Type Details Doesn't Deleted ");
		 
	}

	 model.addAttribute("ProjectResourceType", new ProjectResourceTypeBean());
	 return "ProjectResourceTypeHome";
	}
	@RequestMapping(value = "/projectResourceTypeUpdate", method = RequestMethod.POST)

	public String updateProjectResourceType(
		@ModelAttribute("ProjectResourceType") ProjectResourceTypeBean prod,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");

	String isa = null;
	String projResourceTypeUpdate = null;

	int projectResourceTypeId = prod.getProjectResourceType_IdEdit();
	String projectResourceTypeEdit = prod.getProjectResourceTypeEdit();

	prod.setProjectResourceType_Id(projectResourceTypeId);
	prod.setProjectResourceType(projectResourceTypeEdit);


		long checkDuplicate=dao.duplicateCheck("select count(*) from  ProjectResourceTypeBean ag where ag.projectResourceType='"
					+ projectResourceTypeEdit + "' and ag.projectResourceType_Id!='" + projectResourceTypeId + "'")	;
	if (checkDuplicate == 0) {
		try {
			
			dao.updateDetails(prod);	
			request.setAttribute("projResourceTypeUp", "Project Resource Type Details Updated Successfully");
			
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("projResourceTypeUpErr", "Project Resource Type Details Doesn't Updated ");
		}
	} else {
		request.setAttribute("projresupDup", "Project Resource Type already exists choose another one");
		request.setAttribute("projectResourceTypeValues","projectResourceTypeValues");
		

	}

	 model.addAttribute("ProjectResourceType", new ProjectResourceTypeBean());
	 return "ProjectResourceTypeHome";
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
	String name = "projectResourceType";

	Map<String, String> map = new HashMap<String, String>();

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
	}

}
