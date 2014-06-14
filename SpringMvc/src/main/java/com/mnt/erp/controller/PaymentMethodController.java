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

import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PaymentMethodService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class PaymentMethodController {
	@Autowired
	PaymentMethodService pm_service;
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/PaymentMethod", method = RequestMethod.GET)
	public ModelAndView getPaymentMethod(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("PaymentMethod.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		return new ModelAndView("paymentMethodAdd", "paymentMethodCommand",
				new PaymentMethod());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */
	@RequestMapping(value = "/PaymentMethod", method = RequestMethod.POST)
	public String addPaymentMethods(
			@ModelAttribute("paymentMethodCommand") PaymentMethod payment,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		HttpSession session=null;
		String checkPMethodName = payment.getPaymentMethodName();
		int list1 = pm_service.checkDuplicate(checkPMethodName);
		if (list1 == 0) {

			try {

				PaymentMethod payment_Method = new PaymentMethod();
				payment_Method.setPaymentMethodName(request
						.getParameter("paymentMethodName"));
				session=request.getSession(false);
				msg = pm_service.addPaymentMethods(payment_Method,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
                if(msg.equals("S")){
                	res = "redirect:PaymentMethod.mnt?list=" + "success" + "";
                }
                else{
                	res = "redirect:PaymentMethod.mnt?listwar=" + "fail" + "";
                }
				
			} catch (Exception e) {
				res = "redirect:PaymentMethod.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
			}
			
			
		} else {
			payment.setAid(1);
			request.setAttribute("addPMDuplicate",
					"Payment Method is Already Exists Please try some other name");
			return "paymentMethodAdd";
		}
		return res;
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/paymentMethodSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchPaymentMethods(
			@ModelAttribute("paymentMethodCommand") PaymentMethod payment_Method,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<PaymentMethod> pmType = null;
		List<Object[]> list = null;
		try {
			String dbField = payment_Method.getXmlLabel();
			String operation = payment_Method.getOperations();
			String basicSearchId = payment_Method.getBasicSearchId();

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

				list = pm_service.searchPaymentMethods();
				pmType = new ArrayList<PaymentMethod>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					PaymentMethod pmList = new PaymentMethod();
					pmList.setPaymentMethodId((Integer) objects[0]);
					pmList.setPaymentMethodName((String) objects[1]);
					pmType.add(pmList);

				}

			} else {
				list = pm_service.basicSearchPaymentMethod(dbField, operation,
						basicSearchId);

				pmType = new ArrayList<PaymentMethod>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					PaymentMethod pmList = new PaymentMethod();
					pmList.setPaymentMethodId((Integer) objects[0]);
					pmList.setPaymentMethodName((String) objects[1]);
					pmType.add(pmList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paymentMethodSearch");
		modelAndView.addObject("paymentMethodCommand");
		request.setAttribute("paymentMethodSearch", pmType);

		return modelAndView;
	}

	/*
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/paymentMethodIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String paymentMethodEdit(
			@ModelAttribute PaymentMethod payment_Method, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("paymentMethodIdEdit"));
		List<Object[]> list = null;
		List<PaymentMethod> paymentmethodtypes = new ArrayList<PaymentMethod>();
		Object[] objects = null;
		try {

			list = pm_service.searchPaymentMethodsWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				payment_Method.setPaymentMethodIdEditt((Integer) objects[0]);
				payment_Method.setPaymentMethodNameEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		paymentmethodtypes.add(payment_Method);
		request.setAttribute("list", paymentmethodtypes);
		model.addAttribute("paymentMethodCommand", payment_Method);

		return "paymentMethodEdit";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/paymentMethodEdit", method = RequestMethod.POST)
	public String updatePaymentMethods(
			@ModelAttribute("paymentMethodCommand") PaymentMethod payment_Method,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int checkId = payment_Method.getPaymentMethodIdEditt();
		String checkPMethodName = payment_Method.getPaymentMethodNameEditt();
		int list1 = pm_service.checkEditDuplicate(checkPMethodName, checkId);
		if (list1 == 0) {

			try {

				payment_Method.setPaymentMethodId(payment_Method
						.getPaymentMethodIdEditt());
				payment_Method.setPaymentMethodName(payment_Method
						.getPaymentMethodNameEditt());
				msg = pm_service.updatePaymentMethods(payment_Method);
				if (msg.equals("S")){
					request.setAttribute("paymentMethodUpadte",
							"Payment Method has been updated ");
				}
				else{
					request.setAttribute("paymentMethodUpadteError",
							"Payment Method has not been updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		} else {
			request.setAttribute("list", "paymentMethod");
			request.setAttribute("addPMDuplicate",
					"Payment Method is Already Exists Please try some other name");
			return "paymentMethodEdit";
		}
		return "paymentMethodEdit";
	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/paymentMethodIdDelete", method = RequestMethod.GET)
	public ModelAndView deletePaymentMethods(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int paymentMethodId = 0;
		HttpSession session=null;
		try {
			paymentMethodId = Integer.parseInt(request
					.getParameter("paymentMethodIdDelete"));
			String msg = pm_service.deletePaymentMethods(paymentMethodId);
			if (msg.equals("S")){
				request.setAttribute("paymentMethodDelete","Payment Method has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Payment Method","ROW" ,String.valueOf(paymentMethodId),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("paymentMethodDeleteError","Payment Method has been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("paymentMethodEdit", "paymentMethodCommand",
				new PaymentMethod());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "paymentMethodId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
