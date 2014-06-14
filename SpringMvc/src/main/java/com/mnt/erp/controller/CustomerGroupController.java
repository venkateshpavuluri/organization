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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CustomerGroup;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CustomerGroupService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class CustomerGroupController {

	@Autowired
	CustomerGroupService cg_service;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/CustomerGroup", method = RequestMethod.GET)
	public ModelAndView getCustomerGroup(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("CustomerGroup.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("custGroupAdd", "custGroupCommand",
				new CustomerGroup());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */
	@RequestMapping(value = "/CustGroup", method = RequestMethod.POST)
	public String addCustomerGroup(
			@ModelAttribute("custGroupCommand") CustomerGroup custGrp,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String customerUpadte = null;
		HttpSession session = null;
		String checkCustGroup = custGrp.getCustGroup();
		int list1 = cg_service.checkDuplicate(checkCustGroup);
		if (list1 == 0) {

			try {

				CustomerGroup cust_group = new CustomerGroup();
				cust_group.setCustGroup(request.getParameter("custGroup"));
				session = request.getSession(false);
				msg = cg_service.addCustomerGroup(cust_group, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());

			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:CustomerGroup.mnt?listwar=" + "fail" + "";
			}

			if (msg.equals("S")) {
				return "redirect:CustomerGroup.mnt?list=" + "success" + "";
			} else {
				return "redirect:CustomerGroup.mnt?listwar=" + "fail" + "";
			}

		} else {
			custGrp.setAid(1);
			request.setAttribute("addCustDuplicate",
					"Customer Group is Already Exists Please try some other name");
			return "custGroupAdd";
		}
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/custGroupSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchCustomerGroup(
			@ModelAttribute("custGroupCommand") CustomerGroup cust_group,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CustomerGroup> cgType = null;
		List<Object[]> list = null;
		try {
			int id = cust_group.getCustGroupId();
			String dbField = cust_group.getXmlLabel();
			String operation = cust_group.getOperations();
			String basicSearchId = cust_group.getBasicSearchId();

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

				list = cg_service.searchCustomerGroup();
				cgType = new ArrayList<CustomerGroup>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					CustomerGroup cgList = new CustomerGroup();
					cgList.setCustGroupId((Integer) objects[0]);
					cgList.setCustGroup((String) objects[1]);
					cgType.add(cgList);

				}

			} else {
				list = cg_service.basicSearchCustomerGroup(dbField, operation,
						basicSearchId);
				cgType = new ArrayList<CustomerGroup>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					CustomerGroup cgList = new CustomerGroup();
					cgList.setCustGroupId((Integer) objects[0]);
					cgList.setCustGroup((String) objects[1]);
					cgType.add(cgList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("custGroupSearch");
		modelAndView.addObject("custGroupCommand");
		request.setAttribute("custGroupSearch", cgType);
		return modelAndView;
	}

	/*
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/custGroupIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String custGroupEdit(@ModelAttribute CustomerGroup cust_group,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("custGroupIdEdit"));

		List<Object[]> list = null;

		List<CustomerGroup> custtypes = new ArrayList<CustomerGroup>();
		Object[] objects = null;
		try {

			list = cg_service.searchCustomerGroupWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				cust_group.setCustGroupIdEditt((Integer) objects[0]);
				cust_group.setCustGroupEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		custtypes.add(cust_group);
		request.setAttribute("list", custtypes);
		model.addAttribute("custGroupCommand", cust_group);
		return "custGroupEdit";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/custGroupEdit", method = RequestMethod.POST)
	public String updateCustomerGroup(
			@ModelAttribute("custGroupCommand") CustomerGroup cust_group,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String checkCustGroup = cust_group.getCustGroupEditt();
		int id = cust_group.getCustGroupIdEditt();

		int list1 = cg_service.checkEditDuplicate(checkCustGroup, id);
		if (list1 == 0) {

			try {
				cust_group.setCustGroupId(cust_group.getCustGroupIdEditt());
				cust_group.setCustGroup(cust_group.getCustGroupEditt());
				msg = cg_service.updateCustomerGroup(cust_group);
				if (msg.equals("S"))
					request.setAttribute("customerUpadte",
							"Customer Group Data Updated Successfully ");
				else {
					request.setAttribute("customerUpadteErr",
							"Customer Group Data doesn't updated properly");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("custGroupCommand", new CustomerGroup());
			return "custGroupEdit";
		} else {
			request.setAttribute("list", "customer");
			request.setAttribute("addCustDuplicate",
					"Customer Group is Already Exists Please try some other name");
			return "custGroupEdit";

		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/custGroupIdDelete", method = RequestMethod.GET)
	public ModelAndView CustomerGroupDelete(HttpServletRequest request,
			@ModelAttribute("custGroupCommand") CustomerGroup cust_group,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		int custGroupId = 0;
		try {
			custGroupId = Integer.parseInt(request
					.getParameter("custGroupIdDelete"));
			String msg = cg_service.CustomerGroupDelete(custGroupId);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "CustGroup", "ROW", String
						.valueOf(custGroupId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				request.setAttribute("customerDel",
						"Customer Group Data Deleted Successfully");
			} else
				request.setAttribute("customerDelErr",
						"Customer Group Data doesn't deleted properly");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ModelAndView("custGroupEdit", "custGroupCommand",
				new CustomerGroup());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "custGroupId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
