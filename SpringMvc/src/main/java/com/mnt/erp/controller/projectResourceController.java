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

import com.mnt.erp.bean.BreakTimeBean;
import com.mnt.erp.bean.Designation;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ProjectResourceTypeBean;
import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.projectResourceBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DesignationService;
import com.mnt.erp.service.EmployeeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProjectService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.projectResourceService;
import com.mnt.erp.service.projectResourceTypeService;

@Controller
public class projectResourceController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	EmployeeService empService;
	@Autowired
	ProjectService projectService;
	@Autowired
	DesignationService desgService;
	@Autowired
	projectResourceTypeService prtService;
	@Autowired
	UomService uomService;
	@Autowired
	projectResourceService prService;
	@Autowired 
	XmlLabelsService xmlService;
	@Autowired
	ERPDao dao;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@RequestMapping(value = "/ProjectResourceHome", method = RequestMethod.GET)
	public String getProjectResource(@ModelAttribute("ProjectResource") projectResourceBean prBean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ProjectResourceHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("ProjectResource", prBean);
		return "ProjectResourceHome";

	}
	@RequestMapping(value = "/addProjectResource", method = RequestMethod.POST)
	public String saveProjectResource(@ModelAttribute("ProjectResource") projectResourceBean prBean,
			Model model, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus) {
		response.setCharacterEncoding("UTF-8");
		String msg,res = null;
		projectResourceBean prbean2 = null;
		String prsuccess = null;
		String prsuccessdup = null;
		List<String> list = null;
		HttpSession session=null;
		int pid = prBean.getProjectResource_Id();
		Long id = 0L;

		try {
			id = prService.getProjectResourcecount(pid);
			if (id == 0) {
				session=request.getSession(false);
				msg = prService.saveProjectResource(prBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
              
				
				if (msg.equals("S")) 
					res = "redirect:ProjectResourceHome.mnt?list=" + "success" + "";
				else
					res = "redirect:ProjectResourceHome.mnt?listwar=" + "fail" + "";
					
				
			} else {
				prsuccessdup = "Warning ! Project Resource is already exists. Please try some other name";
				
				request.setAttribute("PRSuccessDup", prsuccessdup);
				return "ProjectResourceHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:ProjectResourceHome.mnt?listwar=" + "fail" + "";
		}

		return res;
	}
	
	@ModelAttribute("employee")
	public Map<Integer, String> employee() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = prService.selectEmployeeService();
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
	@ModelAttribute("project")
	public Map<Integer, String> project() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = prService.selectProjectService();
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
	@ModelAttribute("designation")
	public Map<Integer, String> designation() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = prService.selectDesgService();
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
	@ModelAttribute("prtype")
	public Map<Integer, String> prttype() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = prService.selectPrtypeService();
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
	@ModelAttribute("uom")
	public Map<Integer, String> uom() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = prService.selectUomService();
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
	@RequestMapping(value = "/searchProjectResource", method = RequestMethod.GET)
	public String searchProjectResourceIds(@ModelAttribute("ProjectResource") projectResourceBean prBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = prBean.getProjectResource_Id();
			List<projectResourceBean> prBeans = new ArrayList<projectResourceBean>();
			String dbField = prBean.getXmlLabel();
			String operation = prBean.getOperations();
			String basicSearchId = prBean.getEmployee();
            
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
				list = prService.searchProjectResourceService();
				
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					projectResourceBean prbean2 = new projectResourceBean();
					prbean2.setProjectResource_Id((Integer) obj[0]);
					Employee ebean=((Employee)obj[1]);
					prbean2.setEmployee(ebean.getfName());
					Project pbean=((Project)obj[2]);
					prbean2.setProject(pbean.getProjectName());
					Designation dbean=((Designation)obj[3]);
					prbean2.setDesignation(dbean.getDesignation());
					prbean2.setStDate((String)obj[4]);
					prbean2.setEndDate((String)obj[5]);
					ProjectResourceTypeBean prtbean=((ProjectResourceTypeBean)obj[6]);
					prbean2.setPrtype(prtbean.getProjectResourceType());
					prbean2.setStdCostHr((Float)obj[7]);
					prbean2.setOtCostHr((Float)obj[8]);
					Uom ubean=((Uom)obj[9]);
					prbean2.setUom(ubean.getUom());
					prBeans.add(prbean2);
					
					
					
				}

			} else {

				
				list = prService.basicSearchProjectResource(dbField, operation,basicSearchId);
				
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					projectResourceBean prbean2 = new projectResourceBean();
					prbean2.setProjectResource_Id((Integer) obj[0]);
					Employee ebean=((Employee)obj[1]);
					prbean2.setEmployee(ebean.getfName());
					Project pbean=((Project)obj[2]);
					prbean2.setProject(pbean.getProjectName());
					Designation dbean=((Designation)obj[3]);
					prbean2.setDesignation(dbean.getDesignation());
					prbean2.setStDate((String)obj[4]);
					prbean2.setEndDate((String)obj[5]);
					ProjectResourceTypeBean prtbean=((ProjectResourceTypeBean)obj[6]);
					prbean2.setPrtype(prtbean.getProjectResourceType());
					prbean2.setStdCostHr((Float)obj[7]);
					prbean2.setOtCostHr((Float)obj[8]);
					Uom ubean=((Uom)obj[9]);
					prbean2.setUom(ubean.getUom());
					prBeans.add(prbean2);
				}
			}
			request.setAttribute("projectResourceList", prBeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "ProjectResourceHome";
	}
	
	@RequestMapping(value = "/projectResourceEdit", method = RequestMethod.GET)
	public String editProjectResource(@ModelAttribute("ProjectResource") projectResourceBean prBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("projectResourceEdit"));
          
		try {
			List<projectResourceBean> prBeans =null;
			list = prService.searchProjectResourceServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				 prBeans = new ArrayList<projectResourceBean>();
				prBean.setProjectResource_IdEdit((Integer)obj[0]);
				prBean.setEmployeeEdit((String)obj[1]);
				prBean.setProjectEdit((String)obj[2]);
				prBean.setDesignationEdit((String)obj[3]);
				prBean.setStDateEdit((String)obj[4]);
				prBean.setEndDateEdit((String)obj[5]);
				prBean.setPrtypeEdit((String)obj[6]);
				prBean.setStdCostHrEdit((Float)obj[7]);
				prBean.setOtCostHrEdit((Float)obj[8]);
				prBean.setUomEdit((String)obj[9]);
				prBeans.add(prBean);
				
				
				
			}
		
			request.setAttribute("editvalues", prBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ProjectResourceHome";

	}
	@RequestMapping(value = "/projectResourceUpdate", method = RequestMethod.POST)
	public String updateProjectResource(@ModelAttribute("ProjectResource") projectResourceBean prBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		
		int pid = prBean.getProjectResource_IdEdit();
		
		String name=prBean.getEmployeeEdit();
		
		Long id = 0l;
		String msg=null;
		String PRUpdate=null;
		try {
			id = prService.getProjectResourcecountedit(name,pid);
            
			if (id == 0) {
				prBean.setProjectResource_Id(prBean.getProjectResource_IdEdit());
				prBean.setEmployee(prBean.getEmployeeEdit());				
				prBean.setProject(prBean.getProjectEdit());
				prBean.setDesignation(prBean.getDesignationEdit());
				prBean.setStDate(prBean.getStDateEdit());
				prBean.setEndDate(prBean.getEndDateEdit());
				prBean.setPrtype(prBean.getPrtypeEdit());
				prBean.setStdCostHr(prBean.getStdCostHrEdit());
				prBean.setOtCostHr(prBean.getOtCostHrEdit());
				prBean.setUom(prBean.getUomEdit());
	            msg=prService.updateProjectResourceService(prBean);	
	               if(msg=="S")
	               {
	            	   request.setAttribute("projResourceUpdate", "Project Resource Details Updated Successfully");
					  
	               }
					
				}

			 else {
				request.setAttribute("projResourceUpDup", "Project Resource already exists choose another one");
				 return "ProjectResourceHome";
				
					
			}
		} 
		
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("projResourceUpdateErr", "Project Resource Details Doesn't Updated ");
		}

		model.addAttribute("ProjectResource", new projectResourceBean());
		return "ProjectResourceHome";
	}
	@RequestMapping(value = "/projectResourceDelete", method = RequestMethod.GET)
	@RequestScoped
	public String PRDetailsDelete(@ModelAttribute("ProjectResource") projectResourceBean prBean,HttpServletRequest request,
			HttpServletResponse response,Model model) {
		
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		String PRdelete=null;
		HttpSession session=null;
		try {
			Id = Integer.parseInt(request.getParameter("projectResourceDelete"));

			String msg = prService.deleteProjectResourceService(Id);
			if (msg.equals("S"))
			{
					session=request.getSession(false);
					Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","assertType","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("projResourceDel", "Project Resource Details Deleted Successfully");
					
				}
				
				else
				request.setAttribute("projResourceDelErr", "Project Resource Details Doesn't Deleted");	
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("projResourceDelErr", "Project Resource Details Doesn't Deleted");	
		}
		model.addAttribute("ProjectResource", new projectResourceBean());
		return "ProjectResourceHome";
	}
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "ProjectResource";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
