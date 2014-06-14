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

import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesOffice;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesGroupService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class SalesGroupController {
	@Autowired
	SalesGroupService sgservice;

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/SalesGroup", method = RequestMethod.GET)
	public ModelAndView getSalesGroup(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("SalesOffice.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("SalesGroupHome", "salesGroupCommand",
				new SalesGroup());
	}

	@ModelAttribute("salesOffice")
	public Map<Integer, String> salesOfficeIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = sgservice.salesOfficeIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@RequestMapping(value = "/salesGroupadd", method = RequestMethod.POST)
	public String saveSalesGroup(
			@ModelAttribute("salesGroupCommand") SalesGroup salesGroupSave,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();
		HttpSession session = null;
		String sgroup = salesGroupSave.getSalesGroup();
		int list1 = 0;
		list1 = sgservice.salesGroupDuplicate(sgroup);

		String msg = null;
		String salesGroupSaved = null;
		if (list1 == 0) {
			try {
				session = request.getSession(false);
				msg = sgservice.saveSalesGroup(salesGroupSave, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());

			}

			catch (Exception e) {
				e.printStackTrace();
				return "redirect:SalesGroup.mnt?list=" + "fail" + "";
			}

			if (msg.equals("S")) {
				return "redirect:SalesGroup.mnt?list=" + "success" + "";
			} else {

				return "redirect:SalesGroup.mnt?listwar=" + "fail" + "";
			}

		} else {
			salesGroupSave.setAid(1);
			request.setAttribute("addSalesGroupDuplicate",
					"Sales Group Already Exists Please try some other name");

			return "SalesGroupHome";
		}

	}

	@RequestMapping(value = "/SalesGroupSearch", method = RequestMethod.GET)
	public ModelAndView searchSalesGroup(
			@ModelAttribute("salesGroupCommand") SalesGroup salesGroupSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object[]> list = null;
		List<SalesGroup> salesGroups = null;
		try {
			int id = salesGroupSearch.getSalesGroup_Id();
			String dbField = salesGroupSearch.getXmlLabel();
			String operation = salesGroupSearch.getOperations();
			String basicSearchId = salesGroupSearch.getBasicSearchId();

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
				list = sgservice.searchSalesGroup();

			} else {
				list = sgservice.basicSearchSalesGroup(dbField, operation,
						basicSearchId);

			}
			salesGroups = new ArrayList<SalesGroup>();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				SalesGroup dt = new SalesGroup();
				dt.setSalesGroup_Id((Integer) objects[0]);
				dt.setSalesGroup((String) objects[1]);
				SalesOffice saBean = ((SalesOffice) objects[2]);
				dt.setSalesOffice(saBean.getSalesOffice());
				salesGroups.add(dt);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("SalesGroupSearch", "SalesGroupSearch");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("SalesGroupHome");
		modelAndView.addObject("salesGroup", salesGroups);
		return modelAndView;
	}

	@RequestMapping(value = "/SalesGroupEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editSalesGroup(
			@ModelAttribute("salesGroupCommand") SalesGroup salesGroupEdit,
			BindingResult result, HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("salesGroupId"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = sgservice.editSalesGroupWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				salesGroupEdit.setSalesGroup_IdEdit(id);
				salesGroupEdit.setSalesOfficeIdEdit((String) objects[1]);
				salesGroupEdit.setSalesGroupEdit((String) objects[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			list = null;
			objects = null;
		}

		model.addAttribute("salesGroupCommand", salesGroupEdit);
		request.setAttribute("sgvalues", "sgvalues");

		return "SalesGroupHome";
	}

	@RequestMapping(value = "/SalesGroupEdit", method = RequestMethod.POST)
	public String updateSalesGroup(
			@ModelAttribute("salesGroupCommand") SalesGroup salesGroupUpdate,
			HttpServletRequest request, Model model) {
		List<String> list = new ArrayList<String>();
		int id = salesGroupUpdate.getSalesGroup_IdEdit();
		String sgroup = salesGroupUpdate.getSalesGroupEdit();
		int list2 = 0;
		list2 = sgservice.salesGroupEditDuplicate(sgroup, id);

		if (list2 == 0) {
			try {

				salesGroupUpdate.setSalesGroup_Id(salesGroupUpdate
						.getSalesGroup_IdEdit());
				salesGroupUpdate.setSalesOfficeId(salesGroupUpdate
						.getSalesOfficeIdEdit());
				salesGroupUpdate.setSalesGroupEdit(salesGroupUpdate
						.getSalesGroupEdit());
				String msg = sgservice.updateSalesGroup(salesGroupUpdate);
				if (msg == "S") {
					request.setAttribute("sgupdate",
							"Sales Group has been updated successfully");
				} else {
					request.setAttribute("sgupdateerr",
							"Sales Group has not been updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("salesGroupCommand", new SalesGroup());
			return "SalesGroupHome";

		}

		else {

			request.setAttribute("sgvalues", "sgvalues");
			request.setAttribute("editSalesGroupDuplicate",
					"Sales Group Already Exists Please try some other name");

			return "SalesGroupHome";
		}
	}

	@RequestMapping(value = "/SalesGroupDelete", method = RequestMethod.GET)
	public ModelAndView deleteSalesGroup(HttpServletRequest request,
			HttpServletResponse response) {
		int id = 0;
		String msa = null;
		HttpSession session = null;
		try {
			id = Integer.parseInt(request.getParameter("salesGroupId"));
			String msg = sgservice.deleteSalesGroup(id);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Salesgroup", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());

				request.setAttribute("sdelete",
						"Sales Group has been deleted successfully");
			} else {
				request.setAttribute("sdeleteerr",
						"Sales Group has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("SalesGroupHome", "salesGroupCommand",
				new SalesGroup());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesGroup_Id";
		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
