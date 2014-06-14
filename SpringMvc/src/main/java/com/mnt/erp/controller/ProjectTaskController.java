/**
 * 
 */
package com.mnt.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.mnt.erp.bean.Employee;

import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ProjectTask;
import com.mnt.erp.bean.ProjectTaskDocument;
import com.mnt.erp.bean.ProjectTaskResource;


import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.ProjectTaskService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author devi
 * 
 */
@Controller
public class ProjectTaskController {
	@Autowired
	PopulateService populateService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	ProjectTaskService PTaskService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	ERPDao erpDao;
	@Autowired
	ServletContext servletContext;

	String msg;
	List<Object[]> list;
	MultipartFile[] file = null;
	ProjectTaskDocument ptaskDocument = null;
	File filePath;
	String filePathToGraphsDir = null, filePathToGraphsDir1 = null;

	@RequestMapping(value = "/projectTaskHome", method = RequestMethod.GET)
	public String projectTaskHome(
			@ModelAttribute("ProjectTask") ProjectTask ptask,
			HttpServletResponse response, Model model,
			HttpServletRequest request) {
			response.setCharacterEncoding("UTF-8");
		return "projectTaskHome";
	}

	@ModelAttribute("projectIds")
	public Map<Integer, String> populatProjectIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select d.projectId,d.projectName from Project d");
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

	@ModelAttribute("projectResourceIds")
	public Map<Integer, String> populatProjectResourceIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		try {
			list = erpDao
					.searchDetails("select d.projectResource_Id,d.empBean from projectResourceBean d");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				Employee employee = (Employee) object[1];
				map.put((Integer) object[0], employee.getfName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/saveProjectTask", method = RequestMethod.POST)
	public String SaveProjectTask(@ModelAttribute("ProjectTask") ProjectTask ptask,
			HttpServletResponse response, Model model,
			HttpServletRequest request,
			@RequestParam("file") MultipartFile file1) {
		response.setCharacterEncoding("UTF-8");
		String document = null;
		String[] documentPath = null;
		ProjectTaskDocument ptDoc = null;
		Set<ProjectTaskDocument> ptdocSet = null;
		List<com.mnt.erp.bean.ProjectTaskResource> prbeanlist = null;

		String result = null;
		HttpSession session = null;

		String resumesFile, originalPath = null;

		try {

			prbeanlist = new ArrayList<com.mnt.erp.bean.ProjectTaskResource>();
			document = ptask.getDocumentPath();

			com.mnt.erp.bean.ProjectTaskResource prbean = new com.mnt.erp.bean.ProjectTaskResource();
			prbean.setProjectResourceId(ptask.getProjectResource_Id());
			prbeanlist.add(prbean);

			documentPath = ptask.getDocumentPath().split(",");
			ptdocSet = new HashSet<ProjectTaskDocument>();
			session = request.getSession(false);

			for (int i = 0; i < documentPath.length; i++) {

				resumesFile = servletContext.getRealPath("/Documents");
				Date date = new Date();
				String dt = date.getYear() + date.getMonth() + date.getDay()
						+ date.getHours() + date.getMinutes()
						+ date.getSeconds() + "" + System.currentTimeMillis()
						+ file1.getOriginalFilename();
				originalPath = resumesFile + "\\" + dt;
				
				InputStream inputStream = file1.getInputStream();

				java.io.OutputStream outputStream = new FileOutputStream(
						new File(originalPath));
				int read1 = 0;
				byte[] bytes1 = new byte[1024];

				while ((read1 = inputStream.read(bytes1)) != -1) {
					outputStream.write(bytes1, 0, read1);
				}
				outputStream.flush();
				inputStream.close();
				outputStream.close();
				ptDoc = new ProjectTaskDocument();
				ptDoc.setDocumentPath(originalPath);
				ptDoc.setProjectTaskDocument(documentPath[i]);
				ptdocSet.add(ptDoc);

			}
			ptask.setPTaskDetails(ptdocSet);
			ptask.setProjectTaskResources(prbeanlist);
			session = request.getSession(false);
			msg = PTaskService.saveProjectTask(ptask,
					session.getAttribute("userId").toString(), session
							.getAttribute("userName").toString());

			if (msg.equals("S")) {
				result = "redirect:projectTaskHome.mnt?list=" + "success" + "";

			} else {
				result = "redirect:projectTaskHome.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			result = "redirect:projectTaskHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "/projectTaskSearch", method = RequestMethod.GET)
	public String searchProjectTask(
			@ModelAttribute("ProjectTask") ProjectTask ptask,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		Iterator<Object[]> iterator = null;
		ProjectTask projectDetails = null;
		List<ProjectTask> listofptasks = null;
		try {
			int iid = ptask.getProjectTaskId();

			String dbField = ptask.getXmlLabel();
			String operation = ptask.getOperations();
			String basicSearchId = ptask.getBasicSearchId();
			listofptasks = new ArrayList<ProjectTask>();

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
				list = PTaskService.searchProjectTask();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					projectDetails = new ProjectTask();

					projectDetails.setProjectTaskId((Integer) obj[0]);
					projectDetails.setProjectTask((String) obj[1]);
					Project pbean = ((Project) obj[2]);
					projectDetails.setProjectName(pbean.getProjectName());
					projectDetails.setPlantStartDt((String) obj[3]);
					projectDetails.setPlantEndDt((String) obj[4]);
					projectDetails.setActualStartDt((String) obj[5]);
					projectDetails.setActualEndDt((String) obj[6]);
					projectDetails.setDurationHrs((String) obj[7]);
					projectDetails.setPredessor((String) obj[8]);
					projectDetails.setPercentComplete((String) obj[9]);
					projectDetails.setMilestone((Boolean) obj[10]);

					listofptasks.add(projectDetails);

				}

			} else {

				list = PTaskService.basicSearchProjectTask(dbField, operation,
						basicSearchId);

				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					projectDetails = new ProjectTask();

					projectDetails.setProjectTaskId((Integer) obj[0]);
					projectDetails.setProjectTask((String) obj[1]);
					Project pbean = ((Project) obj[2]);
					projectDetails.setProjectName(pbean.getProjectName());
					projectDetails.setPlantStartDt((String) obj[3]);
					projectDetails.setPlantEndDt((String) obj[4]);
					projectDetails.setActualStartDt((String) obj[5]);
					projectDetails.setActualEndDt((String) obj[6]);
					projectDetails.setDurationHrs((String) obj[7]);
					projectDetails.setPredessor((String) obj[8]);
					projectDetails.setPercentComplete((String) obj[9]);
					projectDetails.setMilestone((Boolean) obj[10]);

					listofptasks.add(projectDetails);

				}
			}
			request.setAttribute("listofptasks", listofptasks);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "projectTaskHome";
	}

	@RequestMapping(value = "/projectTaskDelete", method = RequestMethod.GET)
	public String deleteProjectTask(
			@ModelAttribute("ProjectTask") ProjectTask ptask,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int deleId = Integer.parseInt(request.getParameter("ptaskDelete"));
			HttpSession session = null;
			msg = PTaskService.deleteProjectTask(deleId);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "projecttask", "ROW", String
						.valueOf(deleId), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("projectTaskDel",
						"ProjectTask Details Deleted Successfully");
			} else {
				request.setAttribute("projectTaskDelErr",
						"ProjectTask Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "projectTaskHome";
	}

	@RequestMapping(value = "/projectTaskEditHome", method = RequestMethod.GET)
	public String editProjectTask(@ModelAttribute("ProjectTask") ProjectTask ptask,
			BindingResult result, HttpServletRequest request, Model model,
			HttpServletResponse response) {

		int ptaskId = 0;
		response.setCharacterEncoding("UTF-8");
		Iterator<ProjectTask> iterator = null;
		Set<ProjectTaskDocument> listOfptasks = null;
		Iterator<ProjectTaskDocument> ptaskIterator = null;
		Iterator<ProjectTaskResource> projectTaskResourceIterator = null;

		ProjectTaskResource projectResourceBean = null;
		List<ProjectTask> ptaskforchildEdit = null;
		List<ProjectTask> ptaskDetails = null;
		List<ProjectTaskResource> projectTaskResourceDetails = null;
		String pdoc = null;

		try {
			ptaskId = Integer.parseInt(request.getParameter("ptaskEdit"));
			ptaskforchildEdit = new ArrayList<ProjectTask>();
			ptaskDetails = PTaskService.editProjectTaskDetails(ptaskId);

			projectTaskResourceDetails = new ArrayList<ProjectTaskResource>();
			listOfptasks = new HashSet<ProjectTaskDocument>();
			
			iterator = ptaskDetails.iterator();

			while (iterator.hasNext()) {

				ProjectTask obj = (ProjectTask) iterator.next();
				ptask.setProjectTaskIdEdit(obj.getProjectTaskId());

				ptask.setProjectTaskEdit(obj.getProjectTask());
				ptask.setProjectIdEdit(obj.getProjectId());
				ptask.setPlantStartDtEdit(obj.getPlantStartDt());

				ptask.setPlantEndDtEdit(obj.getPlantEndDt());
				ptask.setActualStartDtEdit(obj.getActualStartDt());
				ptask.setActualEndDtEdit(obj.getActualEndDt());
				ptask.setDurationHrsEdit(obj.getDurationHrs());
				ptask.setPredessorEdit(obj.getPredessor());
				ptask.setPercentCompleteEdit(obj.getPercentComplete());
				ptask.setMilestoneEdit(obj.getMilestone());

				projectTaskResourceDetails = obj.getProjectTaskResources();
				projectTaskResourceIterator = projectTaskResourceDetails
						.iterator();
				while (projectTaskResourceIterator.hasNext()) {

					projectResourceBean = (ProjectTaskResource) projectTaskResourceIterator
							.next();

					ptask.setProjectResource_IdEdit(projectResourceBean
							.getProjectResourceId());
					ptask.setProjectTaskResId(projectResourceBean
							.getProjectTaskResourceId());

				}
				listOfptasks = obj.getPTaskDetails();

				ptaskIterator = listOfptasks.iterator();
				while (ptaskIterator.hasNext()) {

					ProjectTaskDocument ptaskdocLine = (ProjectTaskDocument) ptaskIterator
							.next();
					ProjectTask projectTask = new ProjectTask();
					projectTask.setProjectTaskDocId(ptaskdocLine
							.getProjectTaskDocId());
					projectTask.setProjectTaskDocumentEdit(ptaskdocLine
							.getProjectTaskDocument());
					projectTask.setDocumentPathEdit(ptaskdocLine
							.getDocumentPath());
					ptaskforchildEdit.add(projectTask);

				}
			}
			model.addAttribute("ProjectTask", ptask);

			request.setAttribute("editvalues", "");
			request.setAttribute("pTaskDocumentsValues", ptaskforchildEdit);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "projectTaskHome";

	}

	@RequestMapping(value = "/updateProjectTask", method = RequestMethod.POST)
	public String projectTaskUpdate(
			@ModelAttribute("ProjectTask") ProjectTask ptask, Model model,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file1) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;

		String checked = "", s2 = "1";
		int ss = 0;
		ProjectTaskDocument ptaskDetailLine = null;
		List<ProjectTaskResource> taskResources = null;
		Set<ProjectTaskDocument> ptaskDetailLines = null;
		List<ProjectTaskDocument> childDelete = null;
		String dbResumePath = null;

		try {
			childDelete = new ArrayList<ProjectTaskDocument>();
			ptaskDetailLines = new HashSet<ProjectTaskDocument>();
			taskResources = new ArrayList<ProjectTaskResource>();
			ptask.setProjectTaskId(ptask.getProjectTaskIdEdit());
			ptask.setProjectTask(ptask.getProjectTaskEdit());
			ptask.setProjectId(ptask.getProjectIdEdit());
			ptask.setPlantStartDt(ptask.getPlantStartDtEdit());
			ptask.setPlantEndDt(ptask.getPlantEndDtEdit());
			ptask.setActualStartDt(ptask.getActualStartDtEdit());
			ptask.setActualEndDt(ptask.getActualEndDtEdit());
			ptask.setDurationHrs(ptask.getDurationHrsEdit());
			ptask.setPredessor(ptask.getPredessorEdit());
			ptask.setPercentComplete(ptask.getPercentCompleteEdit());
			ptask.setMilestone(ptask.getMilestoneEdit());

			childDelete = new ArrayList<ProjectTaskDocument>();
			ProjectTaskResource taskResource = new ProjectTaskResource();
			taskResource
					.setProjectResourceId(ptask.getProjectResource_IdEdit());
			taskResource.setProjectTaskResourceId(ptask.getProjectTaskResId());
			taskResources.add(taskResource);
			ptask.setProjectTaskResources(taskResources);

			String[] projTaskDocId = String.valueOf(
					ptask.getProjectTaskDocIdEdit()).split(",");
			String[] projectDocPath = ptask.getDocumentPathEdit().split(",");
			String[] projDocName = ptask.getProjectTaskDocumentEdit()
					.split(",");
		
			for (int i = 0; i < projDocName.length; i++) {
				int prjTaskDocId = Integer.parseInt(projTaskDocId[i]);

				if (prjTaskDocId == 0) {
					ProjectTaskDocument document = new ProjectTaskDocument();
					document.setProjectTaskDocId(Integer
							.valueOf(projTaskDocId[i]));
					document.setProjectTaskDocument(projDocName[i]);
					if (file1.getBytes().length > 0) {
						InputStream inputStream = file1.getInputStream();
						String resumesFile = servletContext
								.getRealPath("/Documents");
						Date date = new Date();
						String dt = date.getYear() + date.getMonth()
								+ date.getDay() + date.getHours()
								+ date.getMinutes() + date.getSeconds() + ""
								+ System.currentTimeMillis();
						String originalPath = resumesFile + "\\" + dt + ".txt";

						java.io.OutputStream outputStream = new FileOutputStream(
								new File(originalPath));
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
						outputStream.flush();
						inputStream.close();
						outputStream.close();
						dbResumePath = originalPath;

					} else {
						dbResumePath = projectDocPath[i];
					}
					document.setDocumentPath(dbResumePath);
					ptaskDetailLines.add(document);
				}

				else {

					ProjectTaskDocument document = new ProjectTaskDocument();
					document.setProjectTaskDocId(Integer
							.valueOf(projTaskDocId[i]));
					document.setProjectTaskDocument(projDocName[i]);

					if (file1.getBytes().length > 0) {
						InputStream inputStream = file1.getInputStream();
						String resumesFile = servletContext
								.getRealPath("/Documents");
						Date date = new Date();
						String dt = date.getYear() + date.getMonth()
								+ date.getDay() + date.getHours()
								+ date.getMinutes() + date.getSeconds() + ""
								+ System.currentTimeMillis();
						String originalPath = resumesFile + "\\" + dt + ".txt";

						java.io.OutputStream outputStream = new FileOutputStream(
								new File(originalPath));
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
						outputStream.flush();
						inputStream.close();
						outputStream.close();
						dbResumePath = originalPath;

					} else {
						dbResumePath = projectDocPath[i];
					}
					document.setDocumentPath(dbResumePath);
					
					String checkDoc = null;

					ss = Integer.parseInt(projTaskDocId[i]);
				
					checked = request.getParameter("Checkdelete" + ss);

					
					String[] checkPrevious = ptask.getCheckPrevious()
							.split(",");
					
					if (checkPrevious != null) {
						for (int l = 0; l < checkPrevious.length; l++) {
							if (checkPrevious[l].equals("1")) {

								checkDoc = request.getParameter(projTaskDocId[i]
												+ "Checkdelete");
								
								if (checkDoc.equals("0")) {
									ptaskDetailLines.add(document);

								}
								if (checkDoc.equals("1")) {

									ProjectTaskDocument document2 = new ProjectTaskDocument();
									document2.setProjectTaskDocId(Integer.parseInt(projTaskDocId[i]));
									
									childDelete.add(document2);
								}
							}

						}
					}
					/*if(checked.equals("0"))
					{
						vacancyDetailLines.add(document);
					}
					else
					{
						ProjectTaskDocument document2 = new ProjectTaskDocument();
						document2.setProjectTaskDocId(Integer.parseInt(projTaskDocId[i]));
						System.out.println("delete id iss==== "+ projTaskDocId[i]);
						childDelete.add(document2);
					}*/

					ptask.setPTaskDetails(ptaskDetailLines);

					PTaskService.deleteChildRecords(childDelete);
					msg = PTaskService.updateProjectTaskDetails(ptask);

					if (msg.equals("S")) {
						request.setAttribute("ptaskUpdate",
								"Ptask Details Updated Successfully");
					} else {
						request.setAttribute("ptaskUpdateErr",
								"ptask Details is not updated properly");
					}

				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ProjectTask", new ProjectTask());
		return "projectTaskHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "projectTask";

		Map<String, String> map = new LinkedHashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
