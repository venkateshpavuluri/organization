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

import com.mnt.erp.bean.EmployeeGroup;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EmployeeGroupService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * 
 */
@Controller
public class EmployeeGroupController {

	@Autowired
	EmployeeGroupService employeeGroupService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;


	@RequestMapping(value = "/employeeGroupHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView employeeGroupType(
			@ModelAttribute("employeeGroupAdd") EmployeeGroup employeeGroup,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("employeeGroupHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("employeeGroupHome", "employeeGroupAdd",
				new EmployeeGroup());
	}

	@RequestMapping(value = "/employeeGroupAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveEmployeeGroupDetails(
			@ModelAttribute("employeeGroupAdd") @Valid EmployeeGroup employeeGroupAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {

		String msa,res = null;
		Long duplicateId = 0l;
		HttpSession session=null;

		try {
			
			response.setCharacterEncoding("UTF-8");
			/*if (result.hasErrors()) {
				employeeGroupAdd.setAid(1);
				return "employeeGroupHome";
			}*/
			// this method is used to check the Duplicates
			duplicateId = employeeGroupService
					.duplicateEmployeeGroupCheck(employeeGroupAdd
							.getEmployeeGroup());
			if (duplicateId == 0) {
				
				session=request.getSession(false);
				msa = employeeGroupService
						.saveEmployeeGroupDetails(employeeGroupAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (msa.equals("S")) {
					res = "redirect:employeeGroupHome.mnt?list=" + "success" + "";
				} else{
					res = "redirect:employeeGroupHome.mnt?listwar=" + "fail" + "";
				}
			} else {

				request.setAttribute("EmployeeGroupDuplicate",
						"EmployeeGroup Name  Already exist");
				employeeGroupAdd.setAid(1);
				return "employeeGroupHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:employeeGroupHome.mnt?listwar=" + "fail" + "";
			
		}
     return  "redirect:employeeGroupHome.mnt?list=" + "success" + "";
	}

	@RequestMapping(value = "/employeeGroupSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchEmployeeGroup(
			@ModelAttribute EmployeeGroup employeeGroupSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<EmployeeGroup> employeeGroupBean = new ArrayList<EmployeeGroup>();

		try {

			String dbField = employeeGroupSearch.getXmlLabel();
			String operation = employeeGroupSearch.getOperations();
			String basicSearchId = employeeGroupSearch.getBasicSearchId();

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
				list = employeeGroupService.searchEmployeeGroup();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					EmployeeGroup r = new EmployeeGroup();
					Object[] obj = (Object[]) iterator.next();
					r.setEmployeeGroupId((Integer) obj[0]);
					r.setEmployeeGroup((String) obj[1]);

					employeeGroupBean.add(r);

				}
			} else {
				list = employeeGroupService.basicSearchEmployeeGroup(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					EmployeeGroup r = new EmployeeGroup();
					Object[] obj = (Object[]) iterator.next();
					r.setEmployeeGroupId((Integer) obj[0]);
					r.setEmployeeGroup((String) obj[1]);

					employeeGroupBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("employeeGroupSearch", employeeGroupBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("employeeGroupAdd", employeeGroupSearch);

		return "employeeGroupHome";
	}

	@ModelAttribute("EmployeeGroupSearchNames")
	public Map<String, String> populateemployeeGroupSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = employeeGroupService.selectEmployeeGroupNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String empGrpId = Integer.toString((Integer) objects[0]);
				map.put(empGrpId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/employeeGroupEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String employeeGroupEdit(
			@ModelAttribute EmployeeGroup employeeGroupDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String employeeGroupname = request.getParameter("employeeGroupDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<EmployeeGroup> employeeGroupsList = new ArrayList<EmployeeGroup>();

		try {

			list = employeeGroupService
					.searchEmployeeGroupWithId(employeeGroupname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				employeeGroupDisplay
						.setEmployeeGroupIdEdit((Integer) object[0]);
				employeeGroupDisplay.setEmployeeGroupEdit((String) object[1]);

				/* employeeGroupDisplay.setStatusEdit((String) object[2]); */

				employeeGroupsList.add(employeeGroupDisplay);

			}
			request.setAttribute("employeeGroupValues", employeeGroupsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("employeeGroupAdd", employeeGroupDisplay);
		return "employeeGroupHome";

	}

	@RequestMapping(value = "/employeeGroupUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateEmployeeGroup(
			@ModelAttribute("employeeGroupAdd") EmployeeGroup employeeGroup,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = employeeGroupService.updateDuplicateCheck(
					employeeGroup.getEmployeeGroupEdit(),
					employeeGroup.getEmployeeGroupIdEdit());

			if (duplicateId == 0) {
				employeeGroup.setEmployeeGroupId(employeeGroup
						.getEmployeeGroupIdEdit());
				employeeGroup.setEmployeeGroup(employeeGroup
						.getEmployeeGroupEdit());
				/* employeeGroup.setStatus(employeeGroup.getStatusEdit()); */

				String msg = employeeGroupService
						.updateEmployeeGroup(employeeGroup);

				if (msg.equals("S")) {
					request.setAttribute("employeeGroupUpadteSuccess",
							"EmployeeGroup Details Updated Successfully");
				} else {
					
					request.setAttribute("employeeGroupUpadteFail",
							"EmployeeGroup Details has Not Updated");
					
				}
			} else {
				request.setAttribute("employeeGroupEditDuplicate",
						"EmployeeGroup Name Already exist");
				request.setAttribute("employeeGroupValues", "hello");

				return "employeeGroupHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("employeeGroupAdd", new EmployeeGroup());

		return "employeeGroupHome";

	}

	@RequestMapping(value = "/employeeGroupDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView employeeGroupDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int employeeGroupId = 0;

		String delmsg1 = null;
		String delmsg2 = null;
		HttpSession session=null;
		try {
			employeeGroupId = Integer.parseInt(request
					.getParameter("employeeGroupIdDelete"));
			String msg = employeeGroupService
					.employeeGroupDelete(employeeGroupId);

			String delmsg = msg;
			String[] delmsgpart = delmsg.split(",");
			delmsg1 = delmsgpart[0];
			delmsg2 = delmsgpart[1];
			if (delmsg1.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","empGroup","ROW" ,String.valueOf(employeeGroupId),"1",modifiedDate,session.getAttribute("userName").toString());
			
				request.setAttribute("employeeGroupDelSuccess",
						 " Deleted Successfully");
			} else {
				request.setAttribute("employeeGroupDelFail",
						 " Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("employeeGroupHome", "employeeGroupAdd",
				new EmployeeGroup());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "employeeGroupId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
