/**
/**
@Copyright MNTSOFT
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
import com.mnt.erp.bean.PaymentType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PaymentTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author sailajach
 * @version 1.0 10-12-2013
 * @Build 0.0
 *
 */
@Controller
@Scope("request")
public class PaymentTypeController {
	@Autowired
	PaymentTypeService ptypeService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/paymentType", method = RequestMethod.GET)
	public ModelAndView getPaymentType(HttpServletRequest request,HttpServletResponse response)
	{		
			response.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession(false);
			List<String> list = menuService.getPrivilige("paymentType.mnt",
					session.getAttribute("userId").toString());
			session.setAttribute("privilegeList", list);
		return new ModelAndView("paymentTypeHome", "paymentTypeCommand",new PaymentType());

	}
	/*=================================Add Method=======================================*/
	@RequestMapping(value = "/PaymentType", method = RequestMethod.POST)
	public String savePaymentType(@ModelAttribute("paymentTypeCommand") PaymentType payTypeAdd,
			HttpServletRequest request,
			HttpServletResponse response,Model model)
	{
		
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String msg = null;
		String res=null;
		String checkPaymentType=payTypeAdd.getPaymentType();
		int list1=ptypeService.checkDuplicate(checkPaymentType);
		if(list1==0)
		{
			
			try 
			{
				session=request.getSession(false);
				msg=ptypeService.addPaymentType(payTypeAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S")){
					res = "redirect:paymentType.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:paymentType.mnt?listwar=" + "fail" + "";
				}
				
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		
		
		}
		else
		{
			 payTypeAdd.setAid(1);
	         request.setAttribute("addPTDuplicate","Payment Type is Already Exists Please try some other name");
             return "paymentTypeHome";
		}
		
		return res;
	}
	/*=================================Search Method=======================================*/
	@RequestMapping(value = "/paymentTypeSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchPaymentType(
			@ModelAttribute("paymentTypeCommand") PaymentType payment_typeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		List<PaymentType> ptType = null;
		List<Object[]> list = null;
		try
		{
			
			String dbField = payment_typeSearch.getXmlLabel();
			String operation = payment_typeSearch.getOperations();
			String basicSearchId = payment_typeSearch.getBasicSearchId();

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
			
				list = ptypeService.searchPaymentType();
			ptType = new ArrayList<PaymentType>();
			}
			else 
			{
				list = ptypeService.basicSearchPaymentType(dbField, operation, basicSearchId);
              
			ptType = new ArrayList<PaymentType>();
				
			}
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) 
			{
				Object[] objects = (Object[]) iterator.next();
				PaymentType ptList = new PaymentType();
				ptList.setPaymentTypeId((Integer)objects[0]);
				ptList.setPaymentType((String) objects[1]);
				ptType.add(ptList);
			}

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("paymentTypeValues","paymentTypeValues");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paymentTypeHome");
		modelAndView.addObject("paymentTypeCommand");
		request.setAttribute("paymentTypeSearch",ptType);
		
		return modelAndView;
	}
	/*=================================Edit Method=======================================*/
	@RequestMapping(value = "/paymentTypeIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String paymentTypeEdit(
			@ModelAttribute PaymentType payment_typeEdit,
			BindingResult result, HttpServletRequest request,HttpServletResponse response,Model model) 
	{
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("paymentTypeIdEdit"));

		List<Object[]> list = null;
		
		List<PaymentType> paymenttypes=new ArrayList<PaymentType>();
		Object[] objects = null;
		try
		{

			list = ptypeService.searchPaymentTypeWithId(id);
	
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) 
			{
				objects = (Object[]) iterator.next();
				 payment_typeEdit.setPaymentTypeIdEditt((Integer)objects[0]);
				 payment_typeEdit.setPaymentTypeEditt((String)objects[1]);
				
				
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
		paymenttypes.add(payment_typeEdit);
		request.setAttribute("list",paymenttypes);
		model.addAttribute("paymentTypeCommand",payment_typeEdit);

		return "paymentTypeHome";
	}
	/*=================================Update Method=======================================*/
	@RequestMapping(value = "/paymentTypeEdit", method = RequestMethod.POST)
	public String updatePaymentType(@ModelAttribute("paymentTypeCommand") PaymentType payment_typeUpdate,
			HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
			String msg = null;
			int checkId=payment_typeUpdate.getPaymentTypeIdEditt();
			String checkPaymentType=payment_typeUpdate.getPaymentTypeEditt();
			int list1=ptypeService.checkEditDuplicate(checkPaymentType,checkId);
			if(list1==0)
			{
				try 
				{
				
				
					payment_typeUpdate.setPaymentTypeId(payment_typeUpdate.getPaymentTypeIdEditt());
					payment_typeUpdate.setPaymentType(payment_typeUpdate.getPaymentTypeEditt());
				    msg= ptypeService.updatePaymentType(payment_typeUpdate);
					if(msg.equals("S")){
					request.setAttribute("paymentUpadte","Payment Type has been updated");
					}
					else{
						request.setAttribute("paymentUpadteError","Payment Type has not been updated");
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
			else
			{
				request.setAttribute("list","paymentType");
				request.setAttribute("addPTDuplicate","Payment Type is Already Exists Please try some other name");
	            return "paymentTypeHome";
			}
			return "paymentTypeHome";
	}
	/*=================================Delete Method=======================================*/
	@RequestMapping(value = "/paymentTypeIdDelete", method = RequestMethod.GET)
	public ModelAndView deletePaymentType(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try
		{
			 id = Integer.parseInt(request.getParameter("paymentTypeIdDelete"));
			 String msg=ptypeService.deletePaymentType(id);
			 if(msg.equals("S")){
			 request.setAttribute("paymentTypeDelete","Payment Type has been deleted");
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Payment Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			 
			 }
			 else{
				 request.setAttribute("paymentTypeDeleteError","Payment Type has not been deleted"); 
			 }
				 

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("paymentTypeHome", "paymentTypeCommand",new PaymentType());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "paymentTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	


}
