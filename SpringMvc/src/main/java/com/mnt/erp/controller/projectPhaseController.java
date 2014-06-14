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

import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ProjectPhaseBean;


import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProjectService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.projectPhaseService;

@Controller
public class projectPhaseController {
	@Autowired
	projectPhaseService PPService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ERPDao dao;
	@Autowired
	XmlLabelsService xmlService;
	String sus = null;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/ProjectPhaseHome", method = RequestMethod.GET)
	public String getProjectPhaseHome(
			@ModelAttribute("ProjectPhase") ProjectPhaseBean prbean, SessionStatus status,
			HttpServletResponse response, HttpServletRequest request, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ProjectPhaseHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("ProjectPhase", new ProjectPhaseBean());
		return "ProjectPhaseHome";
	}
	@RequestMapping(value = "/addProjectPhase", method = RequestMethod.POST)
	@RequestScoped
	public String saveProjectPhase(
			@ModelAttribute("ProjectPhase") ProjectPhaseBean prbean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int isa = 0;
		String projectPhaseSave,result =null;
		HttpSession session=null;

		String projectPhaseCheck = prbean.getProjectPhase();
		
		long res=dao.duplicateCheck("select count(*) from ProjectPhaseBean ag where ag.projectPhase='"+projectPhaseCheck+"'");
		
		if (res == 0) 
		{
			try {
				
				isa=dao.saveDetails(prbean);
				if(isa!=0)
				{
					session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","rojectphase","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());		
				result = "redirect:ProjectPhaseHome.mnt?list=" + "success" + "";							
				}						
				else
					
					result = "redirect:ProjectPhaseHome.mnt?listwar=" + "fail" + "";	
				
			} catch (Exception e) {
				e.printStackTrace();
				projectPhaseSave = "Project Phase doesn't  saved Successfully";
			}
		}
		else {
	 
			
			prbean.setAid(1);
			request.setAttribute("addProjectPhaseDuplicate",
					"Project Phase Already Exists Choose Another One");

			return "ProjectPhaseHome";

		}
		
		return result;
	}
	@RequestMapping(value = "/searchProjectPhase", method = RequestMethod.GET)
	@RequestScoped
	public String searchProjectPhase(
			@ModelAttribute("ProjectPhase") ProjectPhaseBean prbean,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<ProjectPhaseBean> projectPhaseSearch = new ArrayList<ProjectPhaseBean>();
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
				
				
				list=dao.searchDetails("select e.projectPhase_Id,e.projectPhase,e.projectBean from ProjectPhaseBean e where e."
						+ dbField + "" +operation +"'"+basicSearchId+"'order by e.projectPhase");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {
				projectPhaseSearch = new ArrayList<ProjectPhaseBean>();
			
			list=dao.searchDetails("select e.projectPhase_Id,e.projectPhase,e.projectBean from ProjectPhaseBean e order by e.projectPhase");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			ProjectPhaseBean ptbean = new ProjectPhaseBean();
			Object[] objs = (Object[]) iterator.next();
			ptbean.setProjectPhase_Id((Integer) objs[0]);
			ptbean.setProjectPhase((String) objs[1]);
			Project projectBean=((Project)objs[2]);
			ptbean.setProject(projectBean.getProjectName());
			projectPhaseSearch.add(ptbean);
			
		}
		
		request.setAttribute("projectPhaseSearch", projectPhaseSearch);

		return "ProjectPhaseHome";
	}
	@RequestMapping(value = "/projectPhaseEditHome", method = RequestMethod.GET)

	public String projectResourceTypeIdEdit(
			@ModelAttribute("ProjectPhase") ProjectPhaseBean ptbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("projectPhaseIdEdit"));
				
		List<Object[]> list = null;
		Object[] object = null;

		List<ProjectPhaseBean> qubean1 = new ArrayList<ProjectPhaseBean>();

		try {

			list = PPService.searchProjectPhaseWithId(id);
	         
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				ptbean.setProjectPhase_IdEdit((Integer) object[0]);
				ptbean.setProjectPhaseEdit((String) object[1]);
			
				ptbean.setProjectEdit((String)object[2]);
				
				
									
				qubean1.add(ptbean);
			}
			request.setAttribute("projectPhaseValues", qubean1);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "ProjectPhaseHome";

	}
	@RequestMapping(value = "/projectPhaseDelete", method = RequestMethod.GET)
	public String deleteProjectresourceType(
		@ModelAttribute("ProjectPhase") ProjectPhaseBean prod,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, SessionStatus status,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	String projectPhaseDelete=null;
	HttpSession session=null;
	int id = Integer.parseInt(request.getParameter("projectPhaseIdDelete"));
		
		
		try
		{
			 
			 String msg=PPService.deleteProjectPhase(id);
			 if(msg.equals("S"))
			 {
				 session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","projPhase","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			
			 	 request.setAttribute("projDel", "Project Phase Details Deleted Successfully");
			 } else
				 
				 request.setAttribute("projDelErr", "Project Phase Details Doesn't Deleted ");
			
		} 
	catch (Exception e) {
		e.printStackTrace();
		 request.setAttribute("projDelErr", "Project Phase Details Doesn't Deleted ");
		 
	}

		model.addAttribute("ProjectPhase", new ProjectPhaseBean());
		return "ProjectPhaseHome";
	}
	@RequestMapping(value = "/projectPhaseUpdate", method = RequestMethod.POST)

	public String updateProjectPhase(
		@ModelAttribute("ProjectPhase") ProjectPhaseBean prod,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");

	String isa = null;
	String projectPhaseUpdate = null;

	int projectPhaseId = prod.getProjectPhase_IdEdit();
	String projectPhaseEdit = prod.getProjectPhaseEdit();
    
	prod.setProjectPhase_Id(projectPhaseId);
	prod.setProjectPhase(projectPhaseEdit);
	prod.setProject(prod.getProjectEdit());


		long checkDuplicate=dao.duplicateCheck("select count(*) from  ProjectPhaseBean ag where ag.projectPhase='"
					+ projectPhaseEdit + "' and ag.projectResourceType_Id!='" + projectPhaseId + "'")	;
	if (checkDuplicate == 0) {
		try {
			
			dao.updateDetails(prod);	
			request.setAttribute("projectUpdate", "ProjectPhase Details Updated Successfully");
			
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("projectUpdateErr", "ProjectPhase Details Doesn't Updated ");
		}
	} else {
		request.setAttribute("projectUpdateDup", "Project Resource Type already exists choose another one");
		return "ProjectPhaseHome";
	
	}

	return "ProjectPhaseHome";
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
	String name = "projectPhase";

	Map<String, String> map = new HashMap<String, String>();

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
	}

	@ModelAttribute("project")
	public Map<Integer, String> shift() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = PPService.selectProjectService();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	

}
