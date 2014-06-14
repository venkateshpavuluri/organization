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

import com.mnt.erp.bean.Department;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DepartmentService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/departmentHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView departmentType(
			@ModelAttribute("departmentAdd") Department department,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("departmentHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("departmentHome", "departmentAdd",
				new Department());
	}

	@RequestMapping(value = "/departmentAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveDepartmentDetails(
			@ModelAttribute("departmentAdd") @Valid Department departmentAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {

		String msa,res = null;
		Long duplicateId = 0l;
		HttpSession session=null;

		try {
			
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				departmentAdd.setAid(1);
				return "departmentHome";
			}
			
			duplicateId = departmentService
					.duplicateDepartmentCheck(departmentAdd.getDepartment());
			if (duplicateId == 0) {
				
				session=request.getSession(false);
				msa = departmentService.saveDepartmentDetails(departmentAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (msa.equals("S")) {
					res = "redirect:departmentHome.mnt?list=" + "success" + "";
					
				} else {
					res = "redirect:departmentHome.mnt?listwar=" + "success" + "";
					
				}
			} else {

				request.setAttribute("DepartmentDuplicate",
						"Department Name  Already exist");
				departmentAdd.setAid(1);
				return "departmentHome";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:departmentHome.mnt?listwar=" + "success" + "";
			
		}
          return "redirect:departmentHome.mnt?list=" + "success" + "";
	}

	@RequestMapping(value = "/departmentSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchDepartment(@ModelAttribute Department departmentSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<Department> departmentBean = new ArrayList<Department>();

		try {

			String dbField = departmentSearch.getXmlLabel();
			String operation = departmentSearch.getOperations();
			String basicSearchId = departmentSearch.getBasicSearchId();

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
				list = departmentService.searchDepartment();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Department r = new Department();
					Object[] obj = (Object[]) iterator.next();
					r.setDepartmentId((Integer) obj[0]);
					r.setDepartment((String) obj[1]);

					departmentBean.add(r);

				}
			} else {
				list = departmentService.basicSearchDepartment(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Department r = new Department();
					Object[] obj = (Object[]) iterator.next();
					r.setDepartmentId((Integer) obj[0]);
					r.setDepartment((String) obj[1]);

					departmentBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("departmentSearch", departmentBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("departmentAdd", departmentSearch);

		return "departmentHome";
	}

	@ModelAttribute("DepartmentSearchNames")
	public Map<String, String> populatedepartmentSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = departmentService.selectDepartmentNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String deptId = Integer.toString((Integer) objects[0]);
				map.put(deptId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/departmentEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String departmentEdit(@ModelAttribute Department departmentDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String departmentname = request.getParameter("departmentDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<Department> departmentsList = new ArrayList<Department>();

		try {

			list = departmentService.searchDepartmentWithId(departmentname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				departmentDisplay.setDepartmentIdEdit((Integer) object[0]);
				departmentDisplay.setDepartmentEdit((String) object[1]);

				/* departmentDisplay.setStatusEdit((String) object[2]); */

				departmentsList.add(departmentDisplay);

			}
			request.setAttribute("departmentValues", departmentsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("departmentAdd", departmentDisplay);
		return "departmentHome";

	}

	@RequestMapping(value = "/departmentUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateDepartment(
			@ModelAttribute("departmentAdd") Department department,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = departmentService.updateDuplicateCheck(
					department.getDepartmentEdit(),
					department.getDepartmentIdEdit());

			if (duplicateId == 0) {
				department.setDepartmentId(department.getDepartmentIdEdit());
				department.setDepartment(department.getDepartmentEdit());
				/* department.setStatus(department.getStatusEdit()); */

				String msg = departmentService.updateDepartment(department);

				if (msg.equals("S")) {
					request.setAttribute("departmentUpadteSuccess",
							"Department Details Updated Successfully");
				} else {
					

					request.setAttribute("departmentUpadteFail",
							"Department Details has Not Updated");
					
				}
			} else {
				request.setAttribute("departmentEditDuplicate",
						"Department Name Already exist");
				request.setAttribute("departmentValues", "hello");

				return "departmentHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("departmentAdd", new Department());

		return "departmentHome";

	}

	@RequestMapping(value = "/departmentDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView departmentDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int departmentId = 0;

		String delmsg1 = null;
		String delmsg2 = null;
		HttpSession session=null;
		try {
			departmentId = Integer.parseInt(request
					.getParameter("departmentIdDelete"));
			String msg = departmentService.departmentDelete(departmentId);

			String delmsg = msg;
			String[] delmsgpart = delmsg.split(",");
			delmsg1 = delmsgpart[0];
			delmsg2 = delmsgpart[1];
			if (delmsg1.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","dept","ROW" ,String.valueOf(departmentId),"1",modifiedDate,session.getAttribute("userName").toString());
			
				request.setAttribute("departmentDelSuccess"," Deleted Successfully");
			} else {
				request.setAttribute("departmentDelFail","Deletion Failed"); 
						
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("departmentHome", "departmentAdd",
				new Department());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "departmentId";

		Map<String, String> map =null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
