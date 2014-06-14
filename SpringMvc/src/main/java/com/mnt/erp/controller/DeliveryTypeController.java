/*
 * @Copyright MNTSOFT
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.DeliveryType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DeliveryTypeServiceImpl;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
@Controller
public class DeliveryTypeController {
	@Autowired
	DeliveryTypeServiceImpl dtservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;


	@RequestMapping(value = "/DeliveryType", method = RequestMethod.GET)
	public ModelAndView getDeliveryType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("DeliveryType.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("DeliveryTypeadd", "DeliveryTypeCommand",
				new DeliveryType());
	}

	@RequestMapping(value = "/DeliveryTypeAdd", method = RequestMethod.POST)
	public String saveDeliveryType(
			@ModelAttribute("DeliveryTypeCommand") DeliveryType DeliveryType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String deliveryTypeSave= null;
		HttpSession session=null;
		String res=null;
		int list1 = 0;
		String deliverytype = DeliveryType.getDeliveryType();
		list1 = dtservice.deliveryTypeDuplicate(deliverytype);
		if (list1 == 0) {
			try {
				session=request.getSession(false);
				msg = dtservice.saveDeliveryType(DeliveryType,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if (msg.equals("S")) {
					
					res = "redirect:DeliveryType.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:DeliveryType.mnt?listwar=" + "fail" + "";
				}
				
			
			}
			
			catch (Exception e) {
				res = "redirect:DeliveryType.mnt?listwar=" + "fail" + "";
				
				e.printStackTrace();
			} 

			
		} else {
			
			DeliveryType.setAid(1);
			request.setAttribute("addDeliveryTypeDuplicate",
					"Delivery Type is aleardy exists Please try some other name");

			return "DeliveryTypesearch";
		}
		return res;

	}

	@RequestMapping(value = "/DeliveryTypeSearch", method = RequestMethod.GET)
	public ModelAndView searchDeliveryType(
			@ModelAttribute("DeliveryTypeCommand") DeliveryType deliveryType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<DeliveryType> deliverType = null;
		try {
			int id = deliveryType.getDeliveryType_Id();
			String dbField = deliveryType.getXmlLabel();
			String operation = deliveryType.getOperations();
			String basicSearchId = deliveryType.getBasicSearchId();

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

				List<Object[]> list = dtservice.searchDeliveryType(id);
				deliverType = new ArrayList<DeliveryType>();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					DeliveryType dt = new DeliveryType();
					dt.setDeliveryType_Id((Integer) objects[0]);
					dt.setDeliveryType((String) objects[1]);
					deliverType.add(dt);
				}

			} else {

				List<Object[]> list = dtservice.basicSearchDeliveryType(
						dbField, operation, basicSearchId);
				deliverType = new ArrayList<DeliveryType>();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					DeliveryType dt = new DeliveryType();
					dt.setDeliveryType_Id((Integer) objects[0]);
					dt.setDeliveryType((String) objects[1]);
					deliverType.add(dt);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
        
		request.setAttribute("dtvalue", "dtvalue");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DeliveryTypesearch");
		modelAndView.addObject("DeliveryType", deliverType);
		return modelAndView;
	}

	@RequestMapping(value = "/DeliveryTypeIdEdit", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editDeliveryType(
			@ModelAttribute("DeliveryTypeCommand") DeliveryType deliveryType,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("DeliveryTypeIdEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = dtservice.editDeliveryTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				deliveryType.setDeliveryType_Id(id);
				deliveryType.setEditDeliveryType((String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		request.setAttribute("dtvalues", "dtvalues");
		return "DeliveryTypesearch";
		
	}

	@RequestMapping(value = "/deliveryTypeEdit", method = RequestMethod.POST)
	public String updateDeliveryType(
			@ModelAttribute("DeliveryTypeCommand") DeliveryType deliveryType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg =null;
		String deliverytypes = deliveryType.getEditDeliveryType();
		int id = deliveryType.getDeliveryType_Id();
		int list2 = 0;
	
		list2 = dtservice.delivertyTypeEditDuplicate(deliverytypes, id);
		if (list2 == 0) {
			try {
				msg = dtservice.updateDeliveryType(deliveryType);
				if(msg=="S"){
				request.setAttribute("deliveryTypeUpdate",
						"Delivery Type has been updated successfully");
				}
				else
				{
					request.setAttribute("deliveryTypeUpdateError",
							"Delivery Type has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("DeliveryTypeCommand", new DeliveryType());
			return "DeliveryTypesearch";

		} else {
			
			request.setAttribute("addDeliveryTypeDuplicate",
					"Delivery Type is aleardy exists Please try some other name");
			request.setAttribute("dtvalues", "dtvalues");

			return "DeliveryTypesearch";
			
		}
	}

	@RequestMapping(value = "/DeliveryTypeIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteDeliveryType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		String msg = null;
		try {
			id = Integer.parseInt(request.getParameter("DeliveryTypeIdDelete"));
			msg = dtservice.deleteDeliveryType(id);
			if (msg.equals("S")){
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","deliveryType","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
		
				request.setAttribute("deliveryTypedelete", "Delivery Type has been deleted successfully");
			}
			else
			{
				request.setAttribute("deliveryTypedeleteError", "Delivery Type has not been deleted");
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("DeliveryTypesearch", "DeliveryTypeCommand",
				new DeliveryType());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "deliveryType_Id";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
