/**
 * @Copyright MNTSOFT 
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.MaterialCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MaterialCategoryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Gkiran
 * @version 1.0v
 * @Date -09-2013
 */

@Controller
@Scope("request")
public class MaterialCategoryController {

	@Autowired
	MaterialCategoryService categoryService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	String msa;
	MaterialCategory material2;
	String materialAdd;
	List<String> list;
	Long count;
	List<MaterialCategory> MaterialCategory;
	String name;
	List<Object[]> objects=null;
	Iterator<Object[]> iterator;
	MaterialCategory mm;
	int id = 0;
	List<Object[]> listObject;
	Object[] objectsArray;
	List<MaterialCategory> materialsList;
	String msg;
	HttpSession session;

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/materialCategory", method = RequestMethod.GET)
	public ModelAndView getMaterialCategory(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("materialCategory.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("materialCategoryHome", "materialCategoryForm",
				new MaterialCategory());
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/materialCategoryAdd", method = RequestMethod.POST)
	public String saveMaterialCategory(
			@ModelAttribute("materialCategoryForm") MaterialCategory materialCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, ModelMap model) {
		response.setCharacterEncoding("UTF-8");
		String url = null;

		try {
			count = categoryService.checkDuplicateMaterial(materialCategory
					.getMaterialCategory());
			if (count == 0) {
				session = request.getSession(false);
				msa = categoryService.setMaterialCategorySave(materialCategory,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());
				material2 = new MaterialCategory();
				model.addAttribute("materialCategoryForm", material2);
				if (msa.equals("S")) {
					list = new ArrayList<String>();
					list.add("2");
					url = "redirect:materialCategory.mnt?list=" + list + "";

				} else {
					list = new ArrayList<String>();
					list.add("2");
					url = "redirect:materialCategory.mnt?listwar=" + list + "";
				}
			} else {
				materialCategory.setDuplicateMessage(1);
				request.setAttribute("materialDuplicateAdd",
						"Warning ! Material Category  is aleardy exists. Please try some other name");
				return "materialCategoryHome";

			}

		} catch (Exception e) {
			list = new ArrayList<String>();
			list.add("2");
			url = "redirect:materialCategory.mnt?listwar=" + list + "";

		}

		return url;
		// return "materialHome";
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/materialCategorySearch", method = RequestMethod.GET)
	public String searchMaterialCategory(
			@ModelAttribute("materialCategoryForm") MaterialCategory materialCategory,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<Object[]> objects=null;
		response.setCharacterEncoding("UTF-8");
		MaterialCategory = new ArrayList<MaterialCategory>();
		name = materialCategory.getMaterialCategory();
		String dbField = materialCategory.getXmlLabel();
		String operation = materialCategory.getOperations();
		String basicSearchId = materialCategory.getBasicSearchId();

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
		if (basicSearchId.length() != 0) {
			objects = categoryService.basicSearchMaterialCategory(dbField,
					operation, basicSearchId);
		} else {

			objects = categoryService.getMaterialCategory("All");
		}
		if(!objects.isEmpty()){
		iterator = objects.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.MaterialCategory();
			Object[] objects2 = (Object[]) iterator.next();
			mm.setMaterialCategoryId((Integer) objects2[0]);
			mm.setMaterialCategory((String) objects2[1]);
			mm.setMaterialCategoryCode((String) objects2[2]);
			MaterialCategory.add(mm);
		}
		request.setAttribute("materialCategorySearch", MaterialCategory);
		}else{
			request.setAttribute("materialCategoryNoData", "Nothing found to display");
		}

		return "materialCategoryHome";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/materialCategoryEdit", method = RequestMethod.GET)
	public String materialCategoryEdit(
			@ModelAttribute MaterialCategory materialDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		id = Integer.parseInt(request.getParameter("materialCategoryEdit"));
		materialsList = new ArrayList<MaterialCategory>();
		try {

			listObject = categoryService.getMaterialId(id);
			iterator = listObject.iterator();
			
			while (iterator.hasNext()) {
				objectsArray = (Object[]) iterator.next();

				materialDisplay
						.setMaterialCategoryIdEdit((Integer) objectsArray[0]);
				materialDisplay
						.setMaterialCategoryEdit((String) objectsArray[1]);
				materialDisplay
						.setMaterialCategoryCodeEdit((String) objectsArray[2]);
				materialDisplay
						.setMaterialCategoryEditUpdate((String) objectsArray[1]);

				materialsList.add(materialDisplay);

			}

			request.setAttribute("materialCategoryValues", materialsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}

		model.addAttribute("materialCategoryForm", materialDisplay);
		return "materialCategoryHome";
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/materialCategoryUpdate", method = RequestMethod.POST)
	public String updateMaterial(
			@ModelAttribute MaterialCategory materialCategory,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		try {
			count = categoryService.checkDuplicateMaterialUpdate(
					materialCategory.getMaterialCategoryEdit(),
					materialCategory.getMaterialCategoryIdEdit());
			if (count == 0) {
				materialCategory.setMaterialCategory(materialCategory
						.getMaterialCategoryEdit());
				materialCategory.setMaterialCategoryCode(materialCategory
						.getMaterialCategoryCodeEdit());
				msg = categoryService.updateMaterialCategory(materialCategory);

				if (msg.equals("S")) {
					request.setAttribute("materialCategoryUpadte",
							"$uccess : Material Category Data is updated successfully");
				} else {
					String fail = "Error ! : Material Category data is not updated properly";
					request.setAttribute("materialCategoryUpadteError", fail);
					model.addAttribute("materialCategoryForm",
							new MaterialCategory());
					return "materialCategoryHome";
				}
			} else {
				model.addAttribute("materialCategoryForm", materialCategory);
				request.setAttribute("materialCategoryValues",
						request.getParameter("materialCategoryValuesForword"));
				materialCategory.setDuplicateMessageEdit(1);
				request.setAttribute("materialDuplicateAddEdit",
						"Warning ! Material Category  is aleardy exists. Please try some other name");
				return "materialCategoryHome";
			}

		} catch (Exception e) {
			 e.printStackTrace();

			String fail = "Error ! : Material Category data is not saved properly";
			request.setAttribute("materialCategoryUpadteError", fail);
			return "materialCategoryHome";
		}

		model.addAttribute("materialCategoryForm", new MaterialCategory());
		return "materialCategoryHome";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/materialCategoryDelete", method = RequestMethod.GET)
	public ModelAndView materialCategoryDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		try {
			id = Integer.parseInt(request
					.getParameter("materialCategoryDelete"));
			msg = categoryService.materialCategoryDelete(id);
			if (msg.equals("S")) {
				request.setAttribute("materialCategoryDelete",
						"$uccess : Material Category Data is deleted successfully");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Material Category", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
			} else {
				String fail = "Error ! : Material Category data is not deleted properly";
				request.setAttribute("materialCategoryDeleteError", fail);
				return new ModelAndView("materialCategoryHome",
						"materialCategoryForm", new MaterialCategory());

			}

		} catch (Exception e) {
			// e.printStackTrace();
			String fail = "Error ! : Material Category data is not deleted properly";
			request.setAttribute("materialCategoryDeleteError", fail);
			return new ModelAndView("materialCategoryHome",
					"materialCategoryForm", new MaterialCategory());

		}
		return new ModelAndView("materialCategoryHome", "materialCategoryForm",
				new MaterialCategory());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "materialCategoryId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
