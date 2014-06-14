package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0   
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
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
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.StockCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.StockCategoryService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class StockCategoryController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	StockCategoryService stockCategoryService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	HttpSession session;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/stockCategoryHome", method = RequestMethod.GET)
	public String getStockCategory(@ModelAttribute StockCategory stockCategory,
			SessionStatus status, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("stockCategoryHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		response.setCharacterEncoding("UTF-8");
		model.addAttribute("stockCategoryForm", new StockCategory());

		return "stockCategoryAdd";
	}

	@RequestMapping(value = "/stockCategoryAdd", method = RequestMethod.POST)
	@RequestScoped
	public String saveStockCategory(
			@ModelAttribute("stockCategoryForm") StockCategory stockCategory,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		String mess = null;

		String stockSuccessdup = null;

		String name = null;
		Long id = 0L;
		String result = null;
		try {
			name = stockCategory.getStockCategoryName();
			id = stockCategoryService.getStockCategoryDuplicateCount(name);

			if (id == 0) {
				session = request.getSession(false);
				mess = stockCategoryService.saveStockCategory(stockCategory,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());
				session = request.getSession(false);

				if (mess.equals("S")) {

					result = "redirect:stockCategoryHome.mnt?list=" + "Success"
							+ "";
				} else {

					result = "redirect:stockCategoryHome.mnt?listw=" + "Fail"
							+ "";
				}

			} else {
				stockSuccessdup = " Stock Category  is already exists. Please try some other name ";
				stockCategory.setAid(1);
				request.setAttribute("stockSuccessdup", stockSuccessdup);

				return "stockCategoryAdd";
			}

		} catch (Exception e) {

			result = "redirect:stockCategoryHome.mnt?listw=" + "Fail" + "";
			e.printStackTrace();
		}

		return result;

	}

	@RequestMapping(value = "/stockCategorySearch", method = RequestMethod.GET)
	public String searchStockCategory(
			@ModelAttribute("stockCategoryForm") StockCategory stockCategory,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String dbField = null;
		String operation = null;
		String basicSearchId = null;
		List<StockCategory> list = null;
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = stockCategory.getStockCategoryId();

			dbField = stockCategory.getXmlLabel();
			operation = stockCategory.getOperations();
			basicSearchId = stockCategory.getBasicSearchId();

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

				list = stockCategoryService.searchStockCategory();

			} else {

				// list = accountgroupservice.searchAccountGroupsWithId(iid);
				list = stockCategoryService.basicSearchStockCategory(dbField,
						operation, basicSearchId);

			}
			if(list.isEmpty()){
				request.setAttribute("stockCategoryNoData", "Nothing found to display");
			}else{
				request.setAttribute("stockCategoryDisplay", list);
			}

			
			// model.addAttribute("verificationtype", new
			// VerificationtypeBean());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "stockCategoryAdd";
	}

	@RequestMapping(value = "/stackCategoryEditHome", method = RequestMethod.GET)
	public String editStockCategory(
			@ModelAttribute("stockCategoryForm") StockCategory stockCategory,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<StockCategory> stockCategories = null;
		int id = 0;
		Iterator<StockCategory> iterator = null;
		StockCategory category = null;
		StockCategory stock = null;
		try {
			id = Integer.parseInt(request.getParameter("stockCategoryedit"));
			stockCategories = stockCategoryService
					.searchStockCategoryWithId(id);
			iterator = stockCategories.iterator();
			while (iterator.hasNext()) {
				category = new StockCategory();
				stock = (StockCategory) iterator.next();
				category.setStockCategoryIdEdit(stock.getStockCategoryId());
				category.setStockCategoryNameEdit(stock.getStockCategoryName());
				model.addAttribute("stockCategoryForm", category);
			}
			request.setAttribute("stockCategoryEditValues", stockCategories);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stockCategoryAdd";

	}

	@RequestMapping(value = "/stockCategoryUpdate", method = RequestMethod.POST)
	public String updateStockCategory(
			@ModelAttribute("stockCategoryForm") StockCategory stockCategory,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = null;
		int sid = 0;
		String VTSuccessdupedit = null;

		Long id = 0L;
		try {
			name = stockCategory.getStockCategoryNameEdit();
			sid = stockCategory.getStockCategoryIdEdit();

			id = stockCategoryService.getStockCategoryCountedit(name, sid);

			if (id == 0) {
				stockCategory.setStockCategoryId(sid);
				stockCategory.setStockCategoryName(name);

				String message = stockCategoryService
						.updateStockCategory(stockCategory);

				if (message.equals("S")) {
					request.setAttribute("stockCategoryUpdate",
							"Stock Category Data is updated successfully");
				} else {
					request.setAttribute("stockCategoryUpdateError",
							"Stock Category Data is not updated properly");
				}

				model.addAttribute("stockCategoryForm", new StockCategory());

			} else {
				VTSuccessdupedit = "Stock Category  is already exists. Please try some other name ";
				// vBean.setVerificationtypehideedit(1);
				request.setAttribute("stockUpdateDuplicate", VTSuccessdupedit);
				request.setAttribute("stockCategoryEditValues", "editvalues");
				return "stockCategoryAdd";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "stockCategoryAdd";
	}

	@RequestMapping(value = "/stockCategoryDelete", method = RequestMethod.GET)
	@RequestScoped
	public String stockCategoryDelete(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int groupId = 0;

		try {
			groupId = Integer.parseInt(request
					.getParameter("stockCategoryDelete"));
			model.addAttribute("stockCategoryForm", new StockCategory());
			String msg = stockCategoryService.deleteStockCategory(groupId);
			if (msg.equals("S")) {
				request.setAttribute("stockCategoryDelete",
						"Stock Category Data is deleted successfully");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Stock Category", "ROW", String
						.valueOf(groupId), "1", modifiedDate, session
						.getAttribute("userName").toString());

			} else {
				request.setAttribute("stockCategoryDeleteError",
						"Stock Category Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "stockCategoryAdd";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "stockCategoryId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
