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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.MRPType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.MrpTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author sailajach
 * @version 1.0 25-01-2014
 * @build 0.0
 *
 */
@Controller
public class MrpTypeController {
	
	@Autowired
	MrpTypeService mrt_service;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/mrptype", method = RequestMethod.GET)
	public ModelAndView getMrpType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("mrptype.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("mrpTypeHome", "mrpTypeCommand",
				new MRPType());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */

	@RequestMapping(value = "/mrpType", method = RequestMethod.POST)
	public String addMrpType(
			@ModelAttribute("mrpTypeCommand") MRPType mrType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String res=null;
		HttpSession session=null;
		String checkMrpType = mrType.getMrpType();
		int id=mrType.getMrpTypeId();
		int list1 = mrt_service.checkDuplicate(checkMrpType);
		if (list1 == 0) {

			try {

				MRPType mrpType = new MRPType();
				mrpType.setMrpType(request
						.getParameter("mrpType"));
				msg = mrt_service.addMrpType(mrpType);
				if(msg=="S")
				{
					res = "redirect:mrptype.mnt?list=" + "success" + "";
					
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","MRP Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
					
				}
				else
				{
					res = "redirect:mrptype.mnt?listwar=" + "fail" + "";
				}

				
			
			} catch (Exception e) {
				res = "redirect:mrptype.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
			}
			

		} else {

			mrType.setAid(1);
			request.setAttribute("addMRPDuplicate",
					"MRP Type is Already Exists Please try some other name");
			return "mrpTypeHome";
		}
		return res;
		
	}
	/*
	 * ===========================Duplicate checking for
	 * add========================
	 */
	@RequestMapping(value = "/mrpTypeDuplicateAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkquotNo(HttpServletRequest request,
			HttpServletResponse response, MRPType mrp) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String before = request.getParameter("mrpType");
			pname = mrt_service.checkDuplicate(before);
			if (pname != 0) {
				mrp.setAid(2);

				request.setAttribute("addMRPDuplicate",
						"Warning ! MRP Type already exists!");

				mrp.setMrpType("");

				msg = "Warning ! MRP Type already exists!";

			}
			if (pname == 0) {
				mrp.setAid(2);
				request.setAttribute("addMRPDuplicate",
						"Warning ! MRP Type already exists!");
				mrp.setMrpType("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/mrpTypeSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchItemCategory(
			@ModelAttribute("mrpTypeCommand") MRPType mRPType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<MRPType> mrpType = null;
		List<Object[]> list = null;
		try {
			int id = mRPType.getMrpTypeId();
			String dbField = mRPType.getXmlLabel();
			String operation = mRPType.getOperations();
			String basicSearchId = mRPType.getBasicSearchId();

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

				list = mrt_service.searchMrpType();
				mrpType = new ArrayList<MRPType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					MRPType mrpList = new MRPType();
					mrpList.setMrpTypeId((Integer) objects[0]);
					mrpList.setMrpType((String) objects[1]);
					mrpType.add(mrpList);
				}

			} else {
				list = mrt_service.basicSearchMrpType(dbField, operation,
						basicSearchId);
				mrpType = new ArrayList<MRPType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					MRPType mrpList = new MRPType();
					mrpList.setMrpTypeId((Integer) objects[0]);
					mrpList.setMrpType((String) objects[1]);
					mrpType.add(mrpList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mrpTypeHome");
		modelAndView.addObject("mrpTypeCommand");
		request.setAttribute("mrpTypeSearch", mrpType);
		return modelAndView;
	}
	/**
	 * ========================================Duplicate Checking for edit===========================*/
	@RequestMapping(value = "/mrpTypeDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, MRPType mrp) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String beforeedit = request.getParameter("mrpTypeEdit");
	
			int iid = Integer.parseInt(request.getParameter("mrpid"));

			pname = mrt_service.checkEditDuplicate(beforeedit, iid);
			if (pname != 0) {
				mrp.setMrpTypeIdEditt(1);
				request.setAttribute("updateMRPDuplicate",
						"Warning ! MRP Type already exists!");
				mrp.setMrpTypeEditt("");

				msg = "Warning ! MRP Type already exists!";

			}
			if (pname == 0) {
				mrp.setMrpTypeIdEditt(1);
				request.setAttribute("updateMRPDuplicate",
						"Warning ! MRP Type already exists!");
				mrp.setMrpTypeEditt("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	/** =================================Edit Method=======================================*/
	@RequestMapping(value = "/mrpTypeIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String itemCategoryEdit(@ModelAttribute MRPType mrpType,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("mrpTypeIdEdit"));
		List<Object[]> list = null;
		List<MRPType> mrp_type = new ArrayList<MRPType>();
		Object[] objects = null;
		try {

			list = mrt_service.searchMrpTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				mrpType.setMrpTypeIdEditt((Integer) objects[0]);
				mrpType.setMrpTypeEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		mrp_type.add(mrpType);
		request.setAttribute("list", mrp_type);
		model.addAttribute("mrpTypeCommand", mrpType);

		return "mrpTypeHome";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/mrpTypeEdit", method = RequestMethod.POST)
	public String updateItemCategory(
			@ModelAttribute("mrpTypeCommand") MRPType mrpType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int chekId = mrpType.getMrpTypeIdEditt();
		String checkMrpType = mrpType.getMrpTypeEditt();
		int list1 = mrt_service.checkEditDuplicate(checkMrpType, chekId);
		if (list1 == 0) {

			try {
				mrpType.setMrpTypeId(mrpType
						.getMrpTypeIdEditt());
				mrpType.setMrpType(mrpType
						.getMrpTypeEditt());
				msg = mrt_service.updateMrpType(mrpType);
				if (msg.equals("S")){
					request.setAttribute("mrpTypeUpadte","MRP Type has been updated");
					
				}
				else{
					request.setAttribute("mrpTypeUpadteError","MRP Type has not been updated");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("mrpTypeCommand", new MRPType());
			return "mrpTypeHome";
		} else {
			request.setAttribute("list", "MRP");
			request.setAttribute("editMRPDuplicate",
					"Warning ! MRP Type already exists!");
			return "mrpTypeHome";
		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/mrpTypeIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteMrpType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int mrpTypeId = 0;
		try {
			mrpTypeId = Integer.parseInt(request
					.getParameter("mrpTypeIdDelete"));
			String msg = mrt_service.deleteMrpType(mrpTypeId);
			HttpSession session=null;
			if (msg.equals("S")){
				request.setAttribute("mrpTypeDelete","MRP Type has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","MRP Type","ROW" ,String.valueOf(mrpTypeId),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("mrpTypeDeleteError",
						"MRP Type has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("mrpTypeHome", "mrpTypeCommand",
				new MRPType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "mrpTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	

}
