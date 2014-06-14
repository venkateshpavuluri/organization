package com.mnt.erp.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Project;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProjectService;
import com.mnt.erp.service.XmlLabelsService;



/**
 * @author kirangangone
 * @version 1.0 04-01-2014
 * @build 0.0
 * 
 */

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	MenuService menuService;
	
	@RequestMapping(value = "/Project", method = RequestMethod.GET)
	public ModelAndView getProject(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("Project.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
				return new ModelAndView("projectHome","projectCommand",new Project());

	}
	
	
	@ModelAttribute("orgId")
	public Map<Integer, String> getProjectGroupId() {
		List<Object[]> projectListvalues = null;
		Iterator<Object[]> projectIterator = null;
		Object[] projectObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			projectListvalues = projectService.getOrgId();
			projectIterator = projectListvalues.iterator();
			while (projectIterator.hasNext()) {
				projectObjects = (Object[]) projectIterator.next();
				map.put((Integer) projectObjects[0], (String) projectObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}


	@ModelAttribute("projectId")
	public Map<Integer, String> getProjectId() {
		List<Object[]> projectListvalues = null;
		Iterator<Object[]> projectIterator = null;
		Object[] projectObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			projectListvalues = projectService.getProjectId();
			projectIterator = projectListvalues.iterator();
			while (projectIterator.hasNext()) {
				projectObjects = (Object[]) projectIterator.next();
				map.put((Integer) projectObjects[0], (String) projectObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	
	@ModelAttribute("managerId")
	public Map<Integer, String> getManagerId() {
		List<Object[]> projectListvalues = null;
		Iterator<Object[]> projectIterator = null;
		Object[] projectObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			projectListvalues = projectService.getManagerId();
			projectIterator = projectListvalues.iterator();
			while (projectIterator.hasNext()) {
				projectObjects = (Object[]) projectIterator.next();
				map.put((Integer) projectObjects[0], (String) projectObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	
	@ModelAttribute("statusId")
	public Map<Integer, String> getStatusId() {
		List<Object[]> projectListvalues = null;
		Iterator<Object[]> projectIterator = null;
		Object[] projectObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			projectListvalues = projectService.getStatusId();
			projectIterator = projectListvalues.iterator();
			while (projectIterator.hasNext()) {
				projectObjects = (Object[]) projectIterator.next();
				map.put((Integer) projectObjects[0], (String) projectObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	
	@ModelAttribute("salesOrder")
	public Map<Integer, String> getSalesOrderId() {
		List<Object[]> projectListvalues = null;
		Iterator<Object[]> projectIterator = null;
		Object[] projectObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			projectListvalues = projectService.getSalesOrder();
			projectIterator = projectListvalues.iterator();
			while (projectIterator.hasNext()) {
				projectObjects = (Object[]) projectIterator.next();
				map.put((Integer) projectObjects[0], (String) projectObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "project";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	@RequestMapping(value = "/projectCheck", method = RequestMethod.POST)
	public @ResponseBody
	String projectDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("project");
			String id=request.getParameter("projectId");
			if(id.equalsIgnoreCase("0"))
			{
			beforeCreditNoteNoValue = projectService.duplicateCheckProject(beforeCreditNoteNo,"");
			}
			else
			{
				beforeCreditNoteNoValue = projectService.duplicateCheckProject(beforeCreditNoteNo,id);
				
			}
		
			Project creditNote = new Project();
			if (beforeCreditNoteNoValue != 0) {
				creditNote.setProjectDuplicate(1);
				creditNote.setProjectName("");
				msa = "Warning ! Project aleardy exists. Please try some other one";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				creditNote.setProjectDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}
	
	
	@RequestMapping(value = "/projectAdd", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("projectCommand") Project projectAdd,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		boolean flag = false;
		String res=null;
		HttpSession session=null;
		int id=projectAdd.getProjectId();
		

		int checkCreditNote = projectService.duplicateCheckProject(projectAdd.getProjectName(),"");
		if (checkCreditNote == 0) {
			try {
				String status=projectAdd.getStatus_Id();
				if(status.equals("")){
					projectAdd.setStatus_Id(null);
				}
				String project=projectAdd.getParentProject_Id();
				if(project.equals("")){
					projectAdd.setParentProject_Id(null);
				}
				String manager=projectAdd.getProjectManager();
				if(manager.equals("")){
					projectAdd.setProjectManager(null);
				}
				flag = projectService.saveProject(projectAdd);
			
				if(flag==true)
				{
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Production Order Process","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
					
					res = "redirect:Project.mnt?list=" + "success" + "";
				}
				
				else
				{
					res = "redirect:Project.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
			System.out.println("this is working");
			//projectAdd.setAid(1);
			
			request.setAttribute("projectAddCheck","Warning ! Project Name aleardy exists. Please try some other Name");
			

			return "projectHome";

		}
		return res;
	}
	
	
	
	
	@RequestMapping(value = "/projectSearch", method = RequestMethod.GET)
	public String searchProject(
			@ModelAttribute("projectCommand") Project project,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Project> projectList = new ArrayList<Project>();
		List<Object[]> projectObjecList = null;
		Iterator<Object[]> projectIterator = null;
		Object[] projectObjects = null;
		try {
			
			String dbField = project.getXmlLabelBasic();
			String operation = project.getOperations();
			String basicSearchId = project.getBasicSearchId();

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
				projectObjecList = projectService.basicSearchProject("","","");

			} else {

				projectObjecList = projectService.basicSearchProject(dbField, operation,
						basicSearchId);
			}
			projectIterator = projectObjecList.iterator();
			while (projectIterator.hasNext()) {
				projectObjects = (Object[]) projectIterator.next();
				Project cb = new Project();
				cb.setProjectName(((String) projectObjects[0]));
				cb.setProjectId((Integer)projectObjects[2]);
				cb.setOrgId((String)projectObjects[1]);
				Organization oo=(Organization)projectObjects[3];
				cb.setOrgId(oo.getOrgName());
				cb.setStartDT((String)projectObjects[4]);
				cb.setFinishDT((String)projectObjects[5]);
		
			 	projectList.add(cb);

			}

			request.setAttribute("projectList", projectList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "projectHome";

	}
	
	
	
	@RequestMapping(value = "/projectEdit", method = RequestMethod.GET)
	public String projectEdit(
			@ModelAttribute("projectCommand") Project project,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Project> projectEditList = new ArrayList<Project>();


		int purcId = Integer.parseInt(request.getParameter("projectId"));

			try {

			List<Object> projectList = projectService.editProject(purcId);
			Iterator<Object> projectIterator = projectList.iterator();
			if (projectIterator.hasNext()) {
				Object oo = projectIterator.next();
				Project ccb = (Project)oo;
				project.setProjectIdEdit(ccb.getProjectId());
				project.setProjectNameEdit(ccb.getProjectName());
				project.setOrgidEdit(ccb.getOrgId());
				project.setSalesOrderIdEdit(ccb.getSalesOrderId());
				project.setStartDTEdit(ccb.getStartDT());
				project.setFinishDTEdit(ccb.getFinishDT());
				project.setParentProject_IdEdit(ccb.getParentProject_Id());
				project.setProjectManagerEdit(ccb.getProjectManager());
				project.setStatus_IdEdit(ccb.getStatus_Id());
						

				}
				
			projectEditList.add(project);
		

			request.setAttribute("projectEditList", projectEditList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "projectHome";
	}
	
	
	
	
	@RequestMapping(value = "/projectUpdate", method = RequestMethod.POST)
	public String projectUpdate(
			@ModelAttribute("projectCommand") Project projectUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		boolean flag=false;
	
		projectUpdate.setProjectId(projectUpdate.getProjectIdEdit());
		projectUpdate.setProjectName(projectUpdate.getProjectNameEdit());
		projectUpdate.setOrgId(projectUpdate.getOrgidEdit());
		projectUpdate.setSalesOrderId(projectUpdate.getSalesOrderIdEdit());
		projectUpdate.setStartDT(projectUpdate.getStartDTEdit());
		projectUpdate.setFinishDT(projectUpdate.getFinishDTEdit());
		projectUpdate.setParentProject_Id(projectUpdate.getParentProject_IdEdit());
		projectUpdate.setProjectManager(projectUpdate.getProjectManagerEdit());
		projectUpdate.setStatus_Id(projectUpdate.getStatus_IdEdit());
		String status=projectUpdate.getStatus_IdEdit();
		if(status.equals("")){
			projectUpdate.setStatus_Id(null);
		}
		String project=projectUpdate.getParentProject_IdEdit();
		if(project.equals("")){
			projectUpdate.setParentProject_Id(null);
		}
		String manager=projectUpdate.getProjectManagerEdit();
		if(manager.equals("")){
			projectUpdate.setProjectManager(null);
		}
		flag = projectService.updateProject(projectUpdate);

		if (flag==true) {
			request.setAttribute("projectUpdate","Project has been updated");
			
		} else {
			request.setAttribute("projectUpdateError","Project has not been updated");
			
		}
		return "projectHome";
	}
	
	
	
	
	@RequestMapping(value = "/projectDelete", method = RequestMethod.GET)
	public ModelAndView projectDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		try {
			
			int id = Integer.parseInt(request.getParameter("projectId"));
		 boolean msg = projectService.deleteProject(id);
			if (msg==true)
			{
				session=request.getSession(false);
				 Date date = new Date();
				 String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				 auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Project","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("projectDelete","Project has been deleted");
			}
			else
			{
				request.setAttribute("projectDeleteError","Project has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("projectHome", "projectCommand",new Project());
	}
	
}
