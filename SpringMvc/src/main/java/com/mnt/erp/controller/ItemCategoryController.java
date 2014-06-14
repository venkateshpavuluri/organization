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
import com.mnt.erp.bean.ItemCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.ItemCategoryService;
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
public class ItemCategoryController {

	@Autowired
	ItemCategoryService ic_service;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;

	@RequestMapping(value = "/ItemCategory", method = RequestMethod.GET)
	public ModelAndView getItemCategory(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ItemCategory.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("itemCategoryAdd", "itemCategoryCommand",
				new ItemCategory());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */

	@RequestMapping(value = "/itemCategory", method = RequestMethod.POST)
	public String addItemCategory(
			@ModelAttribute("itemCategoryCommand") ItemCategory itemCat,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		
		String msg = null;
		String itemCategoryUpadte = null;
		String checkItemCategory = itemCat.getItemCategory();
		int list1 = ic_service.checkDuplicate(checkItemCategory);
		if (list1 == 0) {

			try {

				ItemCategory itemCategory = new ItemCategory();
				itemCategory.setItemCategory(request
						.getParameter("itemCategory"));
				session=request.getSession(false);
				msg = ic_service.addItemCategory(itemCategory,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				request.setAttribute("itemcategoryadd",
						"Item Category Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (msg.equals("S")) {
		
				model.addAttribute("itemCategoryCommand", new ItemCategory());
				return "redirect:ItemCategory.mnt?list=" +"success"+ "";
			}
			else
			{
				model.addAttribute("itemCategoryCommand", new ItemCategory());
				return "redirect:ItemCategory.mnt?listwar=" +"fail"+ "";
			}

			
		} else {

			itemCat.setAid(1);
			request.setAttribute("addItemDuplicate",
					"Item Category is Already Exists Please try some other name");
			return "itemCategoryAdd";
		}
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/itemCategorySearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchItemCategory(
			@ModelAttribute("itemCategoryCommand") ItemCategory itemCategory,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ItemCategory> icType = null;
		List<Object[]> list = null;
		try {
			int id = itemCategory.getItemCategoryId();
			String dbField = itemCategory.getXmlLabel();
			String operation = itemCategory.getOperations();
			String basicSearchId = itemCategory.getBasicSearchId();

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

				list = ic_service.searchItemCategory();
				icType = new ArrayList<ItemCategory>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					ItemCategory icList = new ItemCategory();
					icList.setItemCategoryId((Integer) objects[0]);
					icList.setItemCategory((String) objects[1]);
					icType.add(icList);
				}

			} else {
				list = ic_service.basicSearchItemCategory(dbField, operation,
						basicSearchId);
				icType = new ArrayList<ItemCategory>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					ItemCategory icList = new ItemCategory();
					icList.setItemCategoryId((Integer) objects[0]);
					icList.setItemCategory((String) objects[1]);
					icType.add(icList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("itemCategorySearch");
		modelAndView.addObject("itemCategoryCommand");
		request.setAttribute("itemCategorySearch", icType);
		return modelAndView;
	}

	/** =================================Edit Method=======================================*/
	@RequestMapping(value = "/itemCategoryIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String itemCategoryEdit(@ModelAttribute ItemCategory itemCategory,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("itemCategoryIdEdit"));
		List<Object[]> list = null;
		List<ItemCategory> item_category_types = new ArrayList<ItemCategory>();
		Object[] objects = null;
		try {

			list = ic_service.searchItemCategoryWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				itemCategory.setItemCategoryIdEditt((Integer) objects[0]);
				itemCategory.setItemCategoryEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		item_category_types.add(itemCategory);
		request.setAttribute("list", item_category_types);
		model.addAttribute("itemCategoryCommand", itemCategory);

		return "itemCategoryEdit";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/itemCategoryEdit", method = RequestMethod.POST)
	public String updateItemCategory(
			@ModelAttribute("itemCategoryCommand") ItemCategory itemCategory,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int chekId = itemCategory.getItemCategoryIdEditt();
		String checkItemCategory = itemCategory.getItemCategoryEditt();
		int list1 = ic_service.checkEditDuplicate(checkItemCategory, chekId);
		if (list1 == 0) {

			try {
				itemCategory.setItemCategoryId(itemCategory
						.getItemCategoryIdEditt());
				itemCategory.setItemCategory(itemCategory
						.getItemCategoryEditt());
				msg = ic_service.updateItemCategory(itemCategory);
				if (msg.equals("S"))
				{
					request.setAttribute("itemCategoryUpadte",
							"Item Category Data Updated Successfully ");
				}
				else
				{
					request.setAttribute("itemCategoryUpadteError",
							"Item Category Data did not Updated");	
				}
			} catch (Exception e) {
				request.setAttribute("itemCategoryUpadteError",
						"Item Category Data did not Updated");
				e.printStackTrace();
			}

			model.addAttribute("itemCategoryCommand", new ItemCategory());
			return "itemCategoryEdit";
		} else {
			request.setAttribute("list", "Item");
			request.setAttribute("addItemDuplicate",
					"Item Category is Already Exists Please try some other name");
			return "itemCategoryEdit";
		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/itemCategoryIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteItemCategory(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int itemCategoryId = 0;
		try {
			itemCategoryId = Integer.parseInt(request
					.getParameter("itemCategoryIdDelete"));
			String msg = ic_service.deleteItemCategory(itemCategoryId);
			if (msg.equals("S"))
			{
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Item Category","ROW" ,String.valueOf(itemCategoryId),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("itemCategoryDelete",
						"Item Category Data Deleted Successfully");
			}
			else
			{
				request.setAttribute("itemCategoryDeleteError",
						"Item Category Data Deleted Successfully");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("itemCategoryEdit", "itemCategoryCommand",
				new ItemCategory());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "itemCategoryId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
