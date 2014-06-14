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
import com.mnt.erp.bean.ValuationCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ValuationCategoryService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class ValuationCategoryController {
	@Autowired
	ValuationCategoryService valuationCategoryService;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/valuationCategoryHome", method = RequestMethod.GET)
	@RequestScoped
	public String getvaluationCategoryHome(
			@ModelAttribute ValuationCategory valuationCategory,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request, Model model) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige(
				"valuationCategoryHome.mnt", session.getAttribute("userId")
						.toString());
		session.setAttribute("privilegeList", list);

		model.addAttribute("valuationCategory", valuationCategory);
		return "valuationCategoryHome";
	}

	@RequestMapping(value = "/addValuationCategory", method = RequestMethod.POST)
	@RequestScoped
	public String saveValuationCategory(
			@ModelAttribute ValuationCategory valuationCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		String res = null;
		HttpSession session = null;
		String valuationCategoryCheck = valuationCategory
				.getValuationCategory();
		int checkValuationCategory = valuationCategoryService
				.checkValuationCategory(valuationCategoryCheck);
		if (checkValuationCategory == 0) {
			try {
				session = request.getSession(false);
				msg = valuationCategoryService.saveValuationCategoryDetails(
						valuationCategory, session.getAttribute("userId")
								.toString(), session.getAttribute("userName")
								.toString());
				status.setComplete();

				if (msg.equals("S")) {
					res = "redirect:valuationCategoryHome.mnt?list="
							+ "success" + "";
				} else {
					res = "redirect:valuationCategoryHome.mnt?listwar="
							+ "fail" + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			request.setAttribute("addValuationCategoryDuplicate",
					"Valuation Category Already Exists Choose Another One");
			valuationCategory.setAid(1);
			return "valuationCategoryHome";

		}
		return res;
	}

	@ModelAttribute("selectValuationCategory")
	public Map<Integer, String> getValuationCategory() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = valuationCategoryService.selectValuationCategory();
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

	@RequestMapping(value = "/searchValuationCategory", method = RequestMethod.GET)
	@RequestScoped
	public String searchValuationCategory(
			@ModelAttribute ValuationCategory valuationCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;
		List<ValuationCategory> valuationCategorySearch = new ArrayList<ValuationCategory>();
		String dbField = valuationCategory.getXmlLabel();
		String operation = valuationCategory.getOperations();
		String basicSearchId = valuationCategory.getBasicSearchId();

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

			try {
				// valuationCategorySearch = new ArrayList<ValuationCategory>();
				list = valuationCategoryService.searchValuationCategory();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					ValuationCategory valuationCategory2 = new ValuationCategory();
					Object[] objs = (Object[]) iterator.next();
					valuationCategory2
							.setValuationCategoryId((Integer) objs[0]);
					valuationCategory2.setValuationCategory((String) objs[1]);
					valuationCategorySearch.add(valuationCategory2);
				}

				request.setAttribute("valuationCategorySearch",
						valuationCategorySearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "valuationCategoryHome";
		} else {

			try {
				valuationCategorySearch = new ArrayList<ValuationCategory>();
				list = valuationCategoryService.basicSearchValuationCategory(
						dbField, operation, basicSearchId);

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					ValuationCategory valuationCategory2 = new ValuationCategory();
					Object[] objs = (Object[]) iterator.next();
					valuationCategory2
							.setValuationCategoryId((Integer) objs[0]);
					valuationCategory2.setValuationCategory((String) objs[1]);
					valuationCategorySearch.add(valuationCategory2);
				}

				request.setAttribute("valuationCategorySearch",
						valuationCategorySearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "valuationCategoryHome";

		}
	}

	@RequestMapping(value = "/valuationCategoryEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String valuationCategoryEdit(
			@ModelAttribute ValuationCategory valuationCategoryDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request
				.getParameter("valuationCategoryIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<ValuationCategory> valuationCategoryList = new ArrayList<ValuationCategory>();

		try {

			list = valuationCategoryService.searchValuationCategoryWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				valuationCategoryDisplay
						.setValuationCategoryIdEdit((Integer) object[0]);
				valuationCategoryDisplay
						.setValuationCategoryEdit((String) object[1]);
				valuationCategoryList.add(valuationCategoryDisplay);
			}
			request.setAttribute("valuationCategoryValues",
					valuationCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "valuationCategoryHome";

	}

	@RequestMapping(value = "/valuationCategoryUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateValuationCategory(
			@ModelAttribute ValuationCategory valuationCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;

		int valuationCategoryId = valuationCategory
				.getValuationCategoryIdEdit();
		String valuationCategoryEdit = valuationCategory
				.getValuationCategoryEdit();

		valuationCategory.setValuationCategoryId(valuationCategoryId);
		valuationCategory.setValuationCategory(valuationCategoryEdit);
		int checkDuplication = valuationCategoryService
				.updateCheckValuationCategory(valuationCategoryEdit,
						valuationCategoryId);
		if (checkDuplication == 0) {
			try {
				msg = valuationCategoryService
						.updateValuationCategory(valuationCategory);

				if (msg.equals("S")) {
					request.setAttribute("valuationCategoryUpdate",
							"Valuation Category has been updated");
				} else {
					request.setAttribute("valuationCategoryUpdateError",
							"Valuation Category has not been updated");
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateValuationCategoryDuplicate",
					"Valuation Category Already Exists Choose Another One");
			request.setAttribute("valuationCategoryValues",
					"valuationCategoryList");

			return "valuationCategoryHome";
		}
		return "valuationCategoryHome";
	}

	@RequestMapping(value = "/valuationCategoryDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView deleteValuationCategory(
			@ModelAttribute ValuationCategory valuationCategory,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		int id = Integer.parseInt(request
				.getParameter("valuationCategoryIdDelete"));
		String msg = null;
		try {
			msg = valuationCategoryService.deleteValuationCategory(id);
			if (msg.equals("S")) {
				request.setAttribute("valuationCategoryDelete",
						"Valuation Category has been deleted");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Valuation Category", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());

			} else {
				request.setAttribute("valuationCategoryDeleteError",
						"Valuation Category has not been deleted");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("valuationCategoryHome", "valuationCategory",
				new ValuationCategory());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "valuationCategoryId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
