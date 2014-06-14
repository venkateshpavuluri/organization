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

import com.mnt.erp.bean.Role;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.RoleService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Nikesh
 *
 */
@Controller
public class RoleController {

	@Autowired
	RoleService roleservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session=null;
	
	@RequestMapping(value="/roleHome",method=RequestMethod.GET)
	@RequestScoped
	public ModelAndView roleType(
			@ModelAttribute("roleAdd") Role role,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("roleHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("roleHome","roleAdd",new Role());
	}
	
	@RequestMapping(value="/roleAdd",method=RequestMethod.GET)
	@RequestScoped
	public String saveRoleDetails(
			@ModelAttribute("roleAdd") @Valid Role roleAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model,HttpServletResponse response) {

		String msa = null;
		Long duplicateId=0l;
		String url=null;
		List<String> list=null;

		try {
			//here we set the CharacterEncoding to resonse becoz of Localization Concept 
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				roleAdd.setAid(1);
			return "roleHome";
			}
			//this method is used to check the Duplicates
			duplicateId=roleservice.duplicateRoleCheck(roleAdd.getRole());
			if(duplicateId==0)
			{
				list=new ArrayList<String>();
				//here there are no duplicates 
				// saveRoleDetails this method is used to save Role Details
				session=request.getSession(false);
			msa = roleservice.saveRoleDetails(roleAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			model.addAttribute("roleAdd",new Role());
			if (msa.equals("S")) {
				
			
				list.add("1");
				model.addAttribute("roleAdd", roleAdd);
			url= "redirect:roleHome.mnt?list="
				+ list + "";
				
			}
			else 
			{
				
			
				model.addAttribute("roleAdd", roleAdd);
				list.add("1");
				model.addAttribute("roleAdd", roleAdd);
			url= "redirect:roleHome.mnt?listwar="
				+ list + "";
		
			}
			}
			else
			{
				
				request.setAttribute("RoleDuplicate","Role Name  Already exist");
				roleAdd.setAid(1);
				return "roleHome";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			list.add("1");
			model.addAttribute("roleAdd", roleAdd);
		url= "redirect:roleHome.mnt?listwar="
			+ list + "";
			model.addAttribute("roleAdd", roleAdd);
			return url;
		}
return url;
	
	
	}

	

	@RequestMapping(value = "/roleSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchRole(@ModelAttribute Role roleSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model)  {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<Role> roleBean = new ArrayList<Role>();

	
		try {
	
			String dbField = roleSearch.getXmlLabel();
			String operation = roleSearch.getOperations();
			String basicSearchId = roleSearch.getBasicSearchId();
			
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
				list = roleservice.searchRole();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Role r = new Role();
					Object[] obj = (Object[]) iterator.next();
					r.setRoleid((String) obj[0]);
					r.setRole((String) obj[1]);
					r.setAdgroup((String) obj[2]);
					roleBean.add(r);

				}
			}
				else {
					list = roleservice.basicSearchRole(dbField, operation,
							basicSearchId);
					// list = assertService.searchAssertTypeWithId(id);
					Iterator<Object[]> iterator = list.iterator();
					while (iterator.hasNext()) {
						Role r = new Role();
						Object[] obj = (Object[]) iterator.next();
						r.setRoleid((String) obj[0]);
						r.setRole((String) obj[1]);
						r.setAdgroup((String) obj[2]);
						roleBean.add(r);
					}
				}			request.setCharacterEncoding("UTF-8");
			request.setAttribute("roleSearch", roleBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("roleAdd", roleSearch);

		
		return "roleHome";
	}
	

	@ModelAttribute("RoleSearchNames")
	public Map<String, String> populateroleSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = roleservice.selectRoleNames();
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
	@RequestMapping(value = "/roleEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String roleEdit(@ModelAttribute Role roleDisplay,
			HttpServletRequest request, Model model,HttpServletResponse response) {
		String rolename = request.getParameter("roleDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

	
		List<Role> rolesList = new ArrayList<Role>();

		try {

			list = roleservice.searchRoleWithId(rolename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				roleDisplay.setRoleidEdit((String) object[0]);
				roleDisplay.setRoleEdit((String) object[1]);
				
				/*roleDisplay.setStatusEdit((String) object[2]);*/
				roleDisplay.setAdgroupEdit((String) object[2]);
				

				rolesList.add(roleDisplay);

			}
			request.setAttribute("roleValues", rolesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("roleAdd", roleDisplay);
		return "roleHome";
		
	}

	@RequestMapping(value = "/roleUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateRole(@ModelAttribute("roleAdd") Role role,
			HttpServletRequest request, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId=0l;
		try {
			duplicateId=roleservice.updateDuplicateCheck(role.getRoleEdit(),role.getRoleidEdit());
			
			if(duplicateId==0)
			{
			role.setRoleid(role.getRoleidEdit());
			role.setRole(role.getRoleEdit());
			/*role.setStatus(role.getStatusEdit());*/
			role.setAdgroup(role.getAdgroupEdit());

			String msg = roleservice.updateRole(role);

			if (msg.equals("S")) {
				request.setAttribute("roleUpadteSuccess",
						"Role Details Updated Successfully");
			}
			else
			{
				request.setAttribute("roleValues","hello");
				
				request.setAttribute("roleUpadteFail",
						"Role Details has Not Updated");
				return"roleHome";
			}
			}
			else
			{
				request.setAttribute("roleEditDuplicate","Role Name sAlready exist");
				request.setAttribute("roleValues","hello");
				
				return"roleHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("roleAdd", new Role());
		
		return "roleHome";

	}
	@RequestMapping(value = "/roleDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView roleDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String roleid= null;
		
		
		String delmsg1 = null; 
		String delmsg2 = null; 
		try {
			roleid = request.getParameter("roleidDelete");
			String msg = roleservice.roleDelete(roleid);
			
			
		
			if (msg.equals("S"))
			{
				 session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Role","ROW" ,String.valueOf(roleid),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("roleDeleteSuccess",
						"Role  Deleted Successfully");
			}
			else
			{
				request.setAttribute("roleDeleteFail",
						"role "+delmsg2+" Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("roleDeleteFail",
					"role "+delmsg2+" Did Not Deleted");
		}
		return new ModelAndView("roleHome", "roleAdd", new Role());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name="roleId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
