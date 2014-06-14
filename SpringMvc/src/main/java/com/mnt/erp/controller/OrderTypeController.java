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

import com.mnt.erp.bean.OrderType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrderTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class OrderTypeController {

	@Autowired
	OrderTypeService ot_service;
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;


	@RequestMapping(value = "/OrderType", method = RequestMethod.GET)
	public ModelAndView getOrderType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("OrderType.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("orderTypeAdd", "orderTypeCommand",
				new OrderType());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */
	@RequestMapping(value = "/OrderType", method = RequestMethod.POST)
	public String addOrderType(
			@ModelAttribute("orderTypeCommand") OrderType orderType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String orderUpadte = null;
		HttpSession session=null;
		String res=null;
		String checkOTType = orderType.getOrderType();
		int list1 = ot_service.checkDuplicate(checkOTType);
		if (list1 == 0) {
			try {

				OrderType order_type = new OrderType();
				order_type.setOrderType(request.getParameter("orderType"));
				session=request.getSession(false);
				msg = ot_service.addOrderType(order_type,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:OrderType.mnt?listwar=" + "fail" + "";
			}

			if (msg.equals("S")) {
				res = "redirect:OrderType.mnt?list=" + "success" + "";
			}

			

		} else {
			orderType.setAid(1);
			request.setAttribute("addOTDuplicate",
					"Order Type is Already Exists Please try some other name");
			return "orderTypeAdd";
		}
		return "redirect:OrderType.mnt?list=" + "success" + "";
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/orderTypeSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchOrderType(
			@ModelAttribute("orderTypeCommand") OrderType order_type,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<OrderType> otType = null;
		List<Object[]> list = null;
		try {
			int id = order_type.getOrderTypeId();
			String dbField = order_type.getXmlLabel();
			String operation = order_type.getOperations();
			String basicSearchId = order_type.getBasicSearchId();

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
				list = ot_service.searchOrderType();
				otType = new ArrayList<OrderType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					OrderType otList = new OrderType();
					otList.setOrderTypeId((Integer) objects[0]);
					otList.setOrderType((String) objects[1]);
					otType.add(otList);

				}

			} else {
				list = ot_service.basicSearchOrderType(dbField, operation,
						basicSearchId);
				otType = new ArrayList<OrderType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					OrderType otList = new OrderType();
					otList.setOrderTypeId((Integer) objects[0]);
					otList.setOrderType((String) objects[1]);
					otType.add(otList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("orderTypeSearch");
		modelAndView.addObject("orderTypeCommand");
		request.setAttribute("orderTypeSearch", otType);
		return modelAndView;
	}

	/*
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/orderTypeIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String orderTypeEdit(@ModelAttribute OrderType order_type,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("orderTypeIdEdit"));
		List<Object[]> list = null;
		List<OrderType> ordertypes = new ArrayList<OrderType>();
		Object[] objects = null;
		try {

			list = ot_service.searchOrderTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				order_type.setOrderTypeIdEditt((Integer) objects[0]);
				order_type.setOrderTypeEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		ordertypes.add(order_type);
		request.setAttribute("list", ordertypes);
		model.addAttribute("orderTypeCommand", order_type);

		return "orderTypeEdit";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/orderTypeEdit", method = RequestMethod.POST)
	public String updateOrderType(
			@ModelAttribute("orderTypeCommand") OrderType order_type,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int checkId = order_type.getOrderTypeIdEditt();
		String checkOTType = order_type.getOrderTypeEditt();
		int list1 = ot_service.checkEditDuplicate(checkOTType, checkId);
		if (list1 == 0) {

			try {

				order_type.setOrderTypeId(order_type.getOrderTypeIdEditt());
				order_type.setOrderType(order_type.getOrderTypeEditt());
				msg = ot_service.updateOrderType(order_type);
				if(msg.equals("S"))
				request.setAttribute("orderUpadte",
						"Order Type Data Updated Successfully ");
				else
					request.setAttribute("orderUpadteErr",
							"Order Type Data not updated ");
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("orderTypeCommand", new OrderType());
			return "orderTypeEdit";
		} else {
			request.setAttribute("list", "Order");
			request.setAttribute("addOTDuplicate",
					"Order Type is Already Exists Please try some other name");
			return "orderTypeEdit";
		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/orderTypeIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteOrderType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int orderTypeId = 0;
		HttpSession session=null;
		try {
			orderTypeId = Integer.parseInt(request
					.getParameter("orderTypeIdDelete"));
			String msg = ot_service.deleteOrderType(orderTypeId);
			if (msg.equals("S"))
			{
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","orderType","ROW" ,String.valueOf(orderTypeId),"1",modifiedDate,session.getAttribute("userName").toString());
				
				request.setAttribute("orderDel",
						"Order Type Data Deleted Successfully");
   		}
			else
				request.setAttribute("orderDelErr",
						"Order Type Data Deleted Successfully");
				
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("orderTypeEdit", "orderTypeCommand",
				new OrderType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "orderTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
