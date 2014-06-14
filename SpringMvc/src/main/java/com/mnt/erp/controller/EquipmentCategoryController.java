package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.bean.EquipmentCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EquipmentCategoryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author ybusireddy
 * @version 25-09-2013
 */
@Controller
public class EquipmentCategoryController {

	@Autowired
	EquipmentCategoryService equipmentCategoryService;
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/equipmentCategoryHome", method = RequestMethod.GET)
	@RequestScoped
	public String getEquipmentCategoryHome(
			@ModelAttribute EquipmentCategory equipmentCategory,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("equipmentCategoryHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("equipmentCategory", equipmentCategory);
		return "equipmentCategoryHome";
	}

	@RequestMapping(value = "/addEquipmentCategory", method = RequestMethod.POST)
	@RequestScoped
	public String saveEquipmentCategory(
			@ModelAttribute EquipmentCategory equipmentCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		HttpSession session=null;
		String res=null;

		String equipmentCategoryCheck = equipmentCategory
				.getEquipmentCategory();
		long checkType = equipmentCategoryService
				.checkEquipmentCategory(equipmentCategoryCheck);

		if (checkType == 0) {
			try {
				msg = equipmentCategoryService
						.saveEquipmentCategoryDetails(equipmentCategory);
				status.setComplete();

				if (msg.equals("S")) {
					int id=equipmentCategory.getEquipmentCategoryId();
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Production Plan Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
					res = "redirect:equipmentCategoryHome.mnt?list=" + "success" + "";
					
				} else {
					res = "redirect:equipmentCategoryHome.mnt?listwar=" + "fail" + "";
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {

			request.setAttribute("addEquipmentCategoryDuplicate",
					"Equipment Category Already Exists Choose Another One");
			equipmentCategory.setAid(1);
			return "equipmentCategoryHome";
		}
		return res;
	}

	@ModelAttribute("selectEquipmentCategoryType")
	public Map<Integer, String> getEquipmentCategoryType() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = equipmentCategoryService.selectEquipmentCategory();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objs = (Object[]) iterator.next();
				map.put((Integer) objs[0], (String) objs[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	@RequestMapping(value = "/searchEquipmentCategory", method = RequestMethod.GET)
	@RequestScoped
	public String searchEquipmentCategory(
			@ModelAttribute EquipmentCategory equipmentCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;
		List<EquipmentCategory> equipmentCategorySearch = null;
		String dbField = equipmentCategory.getXmlLabel();
		String operation = equipmentCategory.getOperations();
		String basicSearchId = equipmentCategory.getBasicSearchId();

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

		if (basicSearchId != "") {

			try {
				equipmentCategorySearch = new ArrayList<EquipmentCategory>();
				// list =
				// equipmentCategoryService.searchEquipmentCategoryWithId(searchEquipmentCategoryId);
				list = equipmentCategoryService.basicSearchEquipment(dbField,
						operation, basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					EquipmentCategory equipmentCategory2 = new EquipmentCategory();
					Object[] objs = (Object[]) iterator.next();
					equipmentCategory2
							.setEquipmentCategoryId((Integer) objs[0]);
					equipmentCategory2.setEquipmentCategory((String) objs[1]);
					equipmentCategorySearch.add(equipmentCategory2);
				}

				request.setAttribute("equipmentCategorySearch",
						equipmentCategorySearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "equipmentCategoryHome";
		} else {

			try {
				equipmentCategorySearch = new ArrayList<EquipmentCategory>();
				list = equipmentCategoryService.searchEquipmentCategory();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					EquipmentCategory equipmentCategory2 = new EquipmentCategory();
					Object[] objs = (Object[]) iterator.next();
					equipmentCategory2
							.setEquipmentCategoryId((Integer) objs[0]);
					equipmentCategory2.setEquipmentCategory((String) objs[1]);
					equipmentCategorySearch.add(equipmentCategory2);
				}

				request.setAttribute("equipmentCategorySearch",
						equipmentCategorySearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "equipmentCategoryHome";

		}
	}

	@RequestMapping(value = "/equipmentCategoryEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String equipmentCategoryEdit(
			@ModelAttribute EquipmentCategory equipmentCategoryDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request
				.getParameter("equipmentCategoryIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<EquipmentCategory> equipmentCategoryList = new ArrayList<EquipmentCategory>();

		try {

			list = equipmentCategoryService.searchEquipmentCategoryWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				equipmentCategoryDisplay
						.setEquipmentCategoryIdEdit((Integer) object[0]);
				equipmentCategoryDisplay
						.setEquipmentCategoryEdit((String) object[1]);
				equipmentCategoryList.add(equipmentCategoryDisplay);
			}
			request.setAttribute("equipmentCategoryValues",
					equipmentCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "equipmentCategoryHome";

	}

	@RequestMapping(value = "/equipmentCategoryUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateEquipmentCategory(
			@ModelAttribute EquipmentCategory equipmentCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		String equipmentCategoryUpdate = null;

		int equipmentCategoryId = equipmentCategory
				.getEquipmentCategoryIdEdit();
		String equipmentCategoryEdit = equipmentCategory
				.getEquipmentCategoryEdit();

		equipmentCategory.setEquipmentCategoryId(equipmentCategoryId);
		equipmentCategory.setEquipmentCategory(equipmentCategoryEdit);
		long checkDuplicate = equipmentCategoryService
				.updateCheckEquipmentCategory(equipmentCategoryEdit,
						equipmentCategoryId);
		if (checkDuplicate == 0) {
			try {
				msg = equipmentCategoryService.updateEquipmentCategory(equipmentCategory);
				if(msg.equals("S")){
					request.setAttribute("equCategoryUpdate","Equipment Category has been updated");
				}
				else{
					request.setAttribute("equCategoryUpdateError","Equipment Category has not been deleted");
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateEquipmentCategoryDuplicate",
					"Equipment Category Already Exists Choose Another One");
			request.setAttribute("equipmentCategoryValues",
					"equipmentCategoryList");
			return "equipmentCategoryHome";
		}
		return "equipmentCategoryHome";
	}

	@RequestMapping(value = "/equipmentCategoryDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView deleteEquipmentCategory(
			@ModelAttribute EquipmentCategory equipmentCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("equipmentCategoryIdDelete"));
		String msg = null;
		try {
			msg = equipmentCategoryService.deleteEquipmentCategory(id);
			if(msg.equals("S")){
				
				request.setAttribute("equipmentCategoryDelete","Equipment Category has been deleted");
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Code Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}
			else{
				request.setAttribute("equipmentCategoryDeleteError","Equipment Category has not been deleted");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("equipmentCategoryHome", "equipmentCategory",
				new EquipmentCategory());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "equipmentId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
