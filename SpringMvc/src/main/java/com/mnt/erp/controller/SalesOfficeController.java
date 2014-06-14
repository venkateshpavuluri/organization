/**
@copyright MNTSOFT
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.SalesAreaBean;
import com.mnt.erp.bean.SalesOffice;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesAreaService;
import com.mnt.erp.service.SalesOfficeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 31-10-2013
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class SalesOfficeController {
	@Autowired
	SalesOfficeService soService;

	@Autowired
	SalesAreaService saService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	Object[] objects = null;
	String msg = null;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesOfficeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* =============================Sales Area Values================ */
	@ModelAttribute("salesarea")
	public Map<Integer, String> selectSalesArea() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = saService.selectSalesArea();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@RequestMapping(value = "/SalesOffice", method = RequestMethod.GET)
	public ModelAndView getSalesOffice(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("SalesOffice.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("salesOfficeHome", "sOCommand",
				new SalesOffice());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */
	@RequestMapping(value = "/sOAdd", method = RequestMethod.POST)
	public String addSalesOffice(
			@ModelAttribute("sOCommand") SalesOffice soAdd,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");

		List<String> list = new ArrayList<String>();
		String msg = null;
		String res = null;

		String checkSalesOffice = soAdd.getSalesOffice();
		HttpSession session = null;
		int list1 = soService.checkDuplicate(checkSalesOffice);
		if (list1 == 0) {
			try {
				session = request.getSession(false);
				msg = soService.addSalesOffice(soAdd,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());

				if (msg.equals("S")) {

					res = "redirect:SalesOffice.mnt?list=" + "success" + "";
				} else {
					res = "redirect:SalesOffice.mnt?listwar=" + "fial" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				return res = "redirect:SalesOffice.mnt?list=" + "fial" + "";
			}
		} else {
			soAdd.setAid(1);
			request.setAttribute("adddSODuplicate",
					"Sales Office is Already Exists Please try some other name");

			return "salesOfficeHome";
		}
		return res;

	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/sOSearch", method = RequestMethod.GET)
	public ModelAndView searchSalesOffice(
			@ModelAttribute("sOCommand") SalesOffice soSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SalesOffice> sGroup = null;
		List<Object[]> list = null;
		try {
			// int id = soSearch.getSalesOfficeId();

			String dbField = soSearch.getXmlLabel();
			String operation = soSearch.getOperations();
			String basicSearchId = soSearch.getBasicSearchId();

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
				list = soService.searchSalesOffice();
				sGroup = new ArrayList<SalesOffice>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					SalesOffice soList = new SalesOffice();
					soList.setSalesOfficeId((Integer) objects[0]);
					soList.setSalesOffice((String) objects[1]);
					SalesAreaBean saBean = ((SalesAreaBean) objects[2]);
					soList.setSalesArea(saBean.getSalesArea());
					sGroup.add(soList);

				}

			} else {
				list = soService.basicSearchSales(dbField, operation,
						basicSearchId);
				sGroup = new ArrayList<SalesOffice>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					SalesOffice soList = new SalesOffice();
					soList.setSalesOfficeId((Integer) objects[0]);
					/* soList.setSalesArea((String)objects[1]); */
					soList.setSalesOffice((String) objects[1]);
					SalesAreaBean saBean = ((SalesAreaBean) objects[2]);
					soList.setSalesArea(saBean.getSalesArea());
					sGroup.add(soList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("salesOfficeHome");
		modelAndView.addObject("sOCommand");
		request.setAttribute("sOSearch", sGroup);
		return modelAndView;
	}

	/**
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/salesOfficeIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String salesOfficeEdit(@ModelAttribute SalesOffice soEdit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("salesOfficeIdEdit"));
		List<Object[]> list = null;
		List<SalesOffice> sales = new ArrayList<SalesOffice>();
		Object[] objects = null;
		try {

			list = soService.searchSalesOfficeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				soEdit.setSalesOfficeIdEditt((Integer) objects[0]);

				soEdit.setSalesOfficeEditt((String) objects[1]);
				soEdit.setSalesAreaIdEditt((String) objects[2]);
				sales.add(soEdit);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}

		request.setAttribute("list", sales);
		model.addAttribute("sOCommand", soEdit);

		return "salesOfficeHome";
	}

	/**
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/sOEdit", method = RequestMethod.POST)
	public String updatePurchaseGroup(
			@ModelAttribute("sOCommand") SalesOffice salesUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int checkId = salesUpdate.getSalesOfficeIdEditt();
		String checkSalesOffice = salesUpdate.getSalesOfficeEditt();
		int list1 = soService.checkEditDuplicate(checkSalesOffice, checkId);
		if (list1 == 0) {
			try {
				salesUpdate.setSalesOfficeId(salesUpdate
						.getSalesOfficeIdEditt());
				salesUpdate.setSalesOffice(salesUpdate.getSalesOfficeEditt());
				salesUpdate.setSalesAreaId(salesUpdate.getSalesAreaIdEditt());

				msg = soService.updateSalesOffice(salesUpdate);
				if (msg.equals("S")) {
					request.setAttribute("sOUpadte",
							"Sales Office Data Updated Successfully ");
				} else {
					request.setAttribute("sOUpadteerr",
							"Sales Office Data doesn't updated properly");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("sOCommand", new SalesOffice());
			return "salesOfficeHome";
		} else {
			request.setAttribute("list", "SalesOffice");
			request.setAttribute("addSODuplicate",
					"Sales Office is Already Exists Please try some other name");
			return "salesOfficeHome";
		}

	}

	/**
	 * =================================Delete
	 * Method=======================================
	 */

	@RequestMapping(value = "/salesOfficeIdDelete", method = RequestMethod.GET)
	public String deleteSalesOffice(
			@ModelAttribute("sOCommand") SalesOffice so, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int salesOfficeId = 0;
		String sOUpadte = null;
		List<String> list = new ArrayList<String>();
		HttpSession session = null;
		try {
			salesOfficeId = Integer.parseInt(request
					.getParameter("salesOfficeIdDelete"));

			String msg = soService.deleteSalesOffice(salesOfficeId);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Salesoffice", "ROW", String
						.valueOf(salesOfficeId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				request.setAttribute("soDelete",
						"Sales Office Data Deleted Successfully");

			} else {

				request.setAttribute("salesOfficeErr",
						"Sales Office Data Deletion Failed ");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("sOCommand", new SalesOffice());
		return "salesOfficeHome";
	}

}
