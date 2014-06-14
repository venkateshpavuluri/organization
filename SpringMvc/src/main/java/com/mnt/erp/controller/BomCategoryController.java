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

import com.mnt.erp.bean.BomCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BomCategoryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Gkiran
 * @version 1.0v
 * @Date -09-2013
 */

@Controller
public class BomCategoryController {

	@Autowired
	BomCategoryService categoryService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;

	String msa = null;
	HttpSession session = null;
	BomCategory bom2 = null;
	String bomUpadte = null;
	List<String> list = null;
	Long count = null;
	List<BomCategory> BomCategory = null;
	String name = null;
	List<Object[]> objects = null;
	Iterator<Object[]> iterator = null;
	BomCategory mm = null;
	int id = 0;
	List<Object[]> listObject = null;
	Object[] objectsArray = null;
	List<BomCategory> bomsList = null;
	String msg = null;
	Date date = new Date();
	String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(date);

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/bomCategory", method = RequestMethod.GET)
	public ModelAndView getBomCategory(HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("bomCategory.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("bomCategory", "bomCategoryForm",
				new BomCategory());
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/bomCategoryAdd", method = RequestMethod.POST)
	public String saveMaterial(
			@ModelAttribute("bomCategoryForm") BomCategory bomCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, ModelMap model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		try {
			// int i=10/0;
			count = categoryService.checkDuplicateBomCategory(bomCategory
					.getBomCategory());
			if (count == 0) {
				msa = categoryService.setBomCategorySave(bomCategory);
				bom2 = new BomCategory();
				model.addAttribute("bomCategoryForm", bom2);
				if (msa.equals("success")) {
					list = new ArrayList<String>();
					list.add("2");
					String ObjectId = Integer.toString(bomCategory
							.getBomCategoryId());

					auditLogService.setAuditLogSaveRelation(session
							.getAttribute("userId").toString(), "A",
							"BomCategory", "ROW", ObjectId, "1", modifiedDate,
							null, null, session.getAttribute("userName")
									.toString());
					bomUpadte = "$uccess : Bom Category Data is saved successfully";
				} else {
					String fail = "Error ! : Bom Category data is not saved properly";
					request.setAttribute("addfail", fail);
					return "bomCategory";
				}
			} else {
				bomCategory.setDuplicateMessageBomCategory(1);
				request.setAttribute("bomCategoryDuplicateAdd",
						"BOM Category aleardy exists!");
				return "bomCategory";

			}

		} catch (Exception e) {
			String fail = "Error ! : Bom Category data is not saved properly";
			request.setAttribute("addfail", fail);
			return "bomCategory";

		}

		return "redirect:bomCategory.mnt?success=" + bomUpadte + "";
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/bomCategorySearch", method = RequestMethod.GET)
	public String searchMaterial(
			@ModelAttribute("bomCategoryForm") BomCategory bomCategory,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		try {
			response.setCharacterEncoding("UTF-8");
			BomCategory = new ArrayList<BomCategory>();
			name = bomCategory.getBomCategory();
			String dbField = bomCategory.getXmlLabel();
			String operation = bomCategory.getOperations();
			String basicSearchId = bomCategory.getBasicSearchId();

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
				objects = categoryService.basicSearchBomCategory(dbField,
						operation, basicSearchId);

			} else {
				objects = categoryService.getBomCategory("ALL");
			}
			iterator = objects.iterator();
			while (iterator.hasNext()) {
				mm = new com.mnt.erp.bean.BomCategory();
				Object[] objects2 = (Object[]) iterator.next();
				mm.setBomCategoryId((Integer) objects2[0]);
				mm.setBomCategory((String) objects2[1]);
				BomCategory.add(mm);

			}
			auditLogService.setAuditLogSave(userId, "S", "BomCategory",
					"TABLE", "0", "1", modifiedDate,
					session.getAttribute("userName").toString());
			request.setAttribute("bomCategorySearch", BomCategory);
		}

		catch (Exception e) {

			auditLogService.setAuditLogSave(userId, "S", "BomCategory",
					"TABLE", "0", "0", modifiedDate,
					session.getAttribute("userName").toString());

		}
		return "bomCategory";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/bomCategoryEdit", method = RequestMethod.GET)
	public String bomCategoryEdit(@ModelAttribute BomCategory bomDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		id = Integer.parseInt(request.getParameter("bomCategoryEdit"));
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		try {
			listObject = categoryService.getBomId(id);
			iterator = listObject.iterator();
			bomsList = new ArrayList<BomCategory>();
			while (iterator.hasNext()) {
				objectsArray = (Object[]) iterator.next();
				bomDisplay.setBomCategoryIdEdit((Integer) objectsArray[0]);
				bomDisplay.setBomCategoryEdit((String) objectsArray[1]);
				bomDisplay.setBomCategoryEditUpdate((String) objectsArray[1]);
				bomsList.add(bomDisplay);
			}
			auditLogService.setAuditLogSave(userId, "E", "BomCategory", "ROW",
					request.getParameter("bomCategoryEdit"), "1", modifiedDate,
					session.getAttribute("userName").toString());

			request.setAttribute("bomCategoryValues", bomsList);

		} catch (Exception e) {
			auditLogService.setAuditLogSave(userId, "E", "BomCategory", "ROW",
					request.getParameter("bomCategoryEdit"), "0", modifiedDate,
					session.getAttribute("userName").toString());
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		model.addAttribute("bomCategoryForm", bomDisplay);

		return "bomCategory";
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/bomCategoryUpdate", method = RequestMethod.POST)
	public String updateMaterial(@ModelAttribute BomCategory bomCategory,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		try {

			bomCategory.setBomCategory(bomCategory.getBomCategoryEdit());
			count = categoryService.checkDuplicateBomCategoryUpdate(
					bomCategory.getBomCategoryEdit(),
					bomCategory.getBomCategoryIdEdit());
			if (count == 0) {
				msg = categoryService.updateBomCategory(bomCategory);

				if (msg.equals("success")) {
					request.setAttribute("bomUpadte",
							"$uccess : Bom Category Data is updated successfully");
					auditLogService.setAuditLogSaveRelation(userId, "M",
							"BomCategory", "ROW", Integer.toString(bomCategory
									.getBomCategoryIdEdit()), "1",
							modifiedDate, bomCategory
									.getBomCategoryEditUpdate(), bomCategory
									.getBomCategoryEdit(), session
									.getAttribute("userName").toString());
				} else {

					String fail = "Error ! : Bom Category data is not updated properly";
					request.setAttribute("updatefail", fail);
					return "bomCategory";

				}

			} else {

				bomCategory.setBomCategoryEdit(bomCategory
						.getBomCategoryEditUpdate());
				model.addAttribute("bomCategoryForm", bomCategory);
				request.setAttribute("bomCategoryValues",
						request.getParameter("bomCategoryValuesForword"));
				bomCategory.setDuplicateMessageBomCategoryUpdate(1);
				request.setAttribute("bomCategoryDuplicateUpdate",

				"BOM Category aleardy exists!");
				return "bomCategory";

			}

		} catch (Exception e) {
			auditLogService.setAuditLogSave(userId, "M", "BomCategory", "ROW",
					Integer.toString(bomCategory.getBomCategoryIdEdit()), "0",
					modifiedDate, session.getAttribute("userName").toString());
			request.setAttribute("updatefail",
					"Error ! : Bom Category data is not updated properly");
			model.addAttribute("bomCategoryForm", new BomCategory());
			return "bomCategory";
		}

		model.addAttribute("bomCategoryForm", new BomCategory());

		return "bomCategory";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/bomCategoryDelete", method = RequestMethod.GET)
	public ModelAndView BomDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();

		try {

			id = Integer.parseInt(request.getParameter("bomCategoryDelete"));
			msg = categoryService.bomCategoryDelete(id);
			if (msg.equals("success")) {
				auditLogService.setAuditLogSave(userId, "D", "BomCategory",
						"ROW", Integer.toString(id), "1", modifiedDate, session
								.getAttribute("userName").toString());
				request.setAttribute("deleteSus",
						"$uccess : Bom Category Data is deleted successfully");
			} else {
				request.setAttribute("deletefail",
						"Error ! : Bom Category data is not deleted properly");
				return new ModelAndView("bomCategory", "bomCategoryForm",
						new BomCategory());
			}

		} catch (Exception e) {
			auditLogService.setAuditLogSave(userId, "D", "BomCategory", "ROW",
					Integer.toString(id), "0", modifiedDate, session
							.getAttribute("userName").toString());
			request.setAttribute("deletefail",
					"Error ! : Bom Category data is not deleted properly");
			return new ModelAndView("bomCategory", "bomCategoryForm",
					new BomCategory());
			// e.printStackTrace();
		}
		return new ModelAndView("bomCategory", "bomCategoryForm",
				new BomCategory());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "bomCategoryId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
