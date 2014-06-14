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

import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PaymentTermService;
import com.mnt.erp.service.XmlLabelsService;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
@Controller
	@Scope("request")
public class PaymentTermController
{
	@Autowired
	PaymentTermService pt_service;
	
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/PaymentTerms", method = RequestMethod.GET)
	public ModelAndView getPaymentTerm(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("PaymentTerms.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("paymentTermAdd", "paymentTermCommand",new PaymentTerms());

	}
	/*=================================Add Method=======================================*/
	@RequestMapping(value = "/PaymentTerm", method = RequestMethod.POST)
	public String addPaymentTerms(@ModelAttribute("paymentTermCommand") PaymentTerms payTerms,
			HttpServletRequest request,
			HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		HttpSession session=null;
		String checkPaymentTermName=payTerms.getPaymentTermName();
		int list1=pt_service.checkDuplicate(checkPaymentTermName);
		if(list1==0)
		{
			try 
			{
			
				PaymentTerms paymentTerm = new PaymentTerms();
				session=request.getSession(false);
				paymentTerm.setPaymentTermName(request.getParameter("paymentTermName"));
				msg=pt_service.addPaymentTerms(paymentTerm,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S")){
					res = "redirect:PaymentTerms.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:PaymentTerms.mnt?listwar=" + "fail" + "";
				}
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	
		}
		else
		{
			 payTerms.setAid(1);
	         request.setAttribute("addPTDuplicate","Payment Term is Already Exists Please try some other name");
             return "paymentTermAdd";
		}
		return res;
	}
	/*=================================Search Method=======================================*/
	@RequestMapping(value = "/paymentTermSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchPaymentTerms(
			@ModelAttribute("paymentTermCommand") PaymentTerms payment_term,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		List<PaymentTerms> ptType = null;
		List<Object[]> list = null;
		try
		{
			String dbField = payment_term.getXmlLabel();
			String operation = payment_term.getOperations();
			String basicSearchId = payment_term.getBasicSearchId();

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
			
				list = pt_service.searchPaymentTerms();
				ptType = new ArrayList<PaymentTerms>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext())
				{
					Object[] objects = (Object[]) iterator.next();
					PaymentTerms ptList = new PaymentTerms();
					ptList.setPaymentTermId((Integer)objects[0]);
					ptList.setPaymentTermName((String)objects[1]);
					ptType.add(ptList);
					
				}

			}
			else 
			{
				list = pt_service.basicSearchPaymentTerm(dbField, operation, basicSearchId);
              
				ptType = new ArrayList<PaymentTerms>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					PaymentTerms ptList = new PaymentTerms();
					ptList.setPaymentTermId((Integer)objects[0]);
					ptList.setPaymentTermName((String) objects[1]);
					
					
					ptType.add(ptList);
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        request.setAttribute("paymentTermValues","paymentTermValues");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paymentTermSearch");
		modelAndView.addObject("paymentTermCommand");
		request.setAttribute("paymentTermSearch",ptType);
		
		return modelAndView;
	}
	/*=================================Edit Method=======================================*/
	@RequestMapping(value = "/paymentTermIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String paymentTermEdit(
			@ModelAttribute PaymentTerms payment_term,
			BindingResult result, HttpServletRequest request,HttpServletResponse response,Model model) 
	{
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("paymentTermIdEdit"));

		List<Object[]> list = null;
		
		List<PaymentTerms> paymenttypes=new ArrayList<PaymentTerms>();
		Object[] objects = null;
		try
		{

			list = pt_service.searchPaymentTermsWithId(id);
	
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) 
			{
				objects = (Object[]) iterator.next();
				 payment_term.setPaymentTermIdEditt((Integer)objects[0]);
				 payment_term.setPaymentTermNameEditt((String)objects[1]);
				
				
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			list = null;
			objects = null;
		}
		paymenttypes.add(payment_term);
		request.setAttribute("list",paymenttypes);
		model.addAttribute("paymentTermCommand",payment_term);

		return "paymentTermEdit";
	}
	/*=================================Update Method=======================================*/
	@RequestMapping(value = "/paymentTermEdit", method = RequestMethod.POST)
	public String updatePaymentTerms(@ModelAttribute("paymentTermCommand") PaymentTerms payment_term,
			HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
			String msg = null;
			int checkId=payment_term.getPaymentTermIdEditt();
			String checkPaymentTermName=payment_term.getPaymentTermNameEditt();
			int list1=pt_service.checkEditDuplicate(checkPaymentTermName,checkId);
			if(list1==0)
			{
				try 
				{
				
				
					payment_term.setPaymentTermId(payment_term.getPaymentTermIdEditt());
					payment_term.setPaymentTermName(payment_term.getPaymentTermNameEditt());
				    msg= pt_service.updatePaymentTerms(payment_term);
					if(msg.equals("S")){
					request.setAttribute("paymentTermUpdate","Payment Term has been updated");
					}
					else{
						request.setAttribute("paymentTermUpdateError","Payment Term has not been updated");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
			else
			{
				request.setAttribute("list","paymentTerm");
				request.setAttribute("addPTDuplicate","Payment Term is Already Exists Please try some other name");
	            return "paymentTermEdit";
			}
		 return "paymentTermEdit";
           
	}
	/*=================================Delete Method=======================================*/
	@RequestMapping(value = "/paymentTermIdDelete", method = RequestMethod.GET)
	public ModelAndView deletePaymentTerms(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try
		{
			 id = Integer.parseInt(request.getParameter("paymentTermIdDelete"));
			 String msg=pt_service.deletePaymentTerms(id);
			 if(msg.equals("S")){
			 request.setAttribute("paymentTermDelete","Payment Term has been deleted");
			 
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Payment Term","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			 
			 }
			 else{
				 request.setAttribute("paymentTermDeleteError","Payment Term has not been deleted");
			 }

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("paymentTermEdit", "paymentTermCommand",new PaymentTerms());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "paymentTermId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
