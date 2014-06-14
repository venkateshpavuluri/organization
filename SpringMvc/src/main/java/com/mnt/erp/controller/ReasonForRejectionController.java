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
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.ReasonForRejection;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ReasonForRejectionService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 29-10-2013
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class ReasonForRejectionController {

	@Autowired
	ReasonForRejectionService rfrService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;

	HttpSession session;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "reasonForRejectionId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/RFR", method = RequestMethod.GET)
	public ModelAndView getRFR(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("RFR.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("rfrHome", "rfrCommand",
				new ReasonForRejection());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */

	@RequestMapping(value = "/RFRejection", method = RequestMethod.POST)
	public String addRFR(
			@ModelAttribute("rfrCommand") ReasonForRejection rfrAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		String rfrUpadte = null;
		String checkReasonForRejection = rfrAdd.getReasonForRejection();
		int list1 = rfrService.checkDuplicate(checkReasonForRejection);
		if (list1 == 0) {
			try {
				ReasonForRejection rfr = new ReasonForRejection();
				rfr.setReasonForRejection(request
						.getParameter("reasonForRejection"));
				msg = rfrService.addReasonForRejection(rfr);
				if (msg.equals("S")) {
					Date date = new Date();
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Reason For Rejection", "ROW", String.valueOf(rfr
									.getReasonForRejectionId()), "1",
							modifiedDate, session.getAttribute("userName")
									.toString());
					model.addAttribute("rfrCommand", new ReasonForRejection());
					return "redirect:RFR.mnt?list=" + "success" + "";
				}
				else {
					model.addAttribute("rfrCommand", new ReasonForRejection());
					return "redirect:RFR.mnt?listwar=" + "fail" + "";
				}
				
			} catch (Exception e) {
				model.addAttribute("rfrCommand", new ReasonForRejection());
				e.printStackTrace();
				return "redirect:RFR.mnt?listwar=" + "fail" + "";
			}

		} else {

			rfrAdd.setAid(1);
			request.setAttribute("addRFRDuplicate",
					"Reason For Rejection is Already Exists Please try some other name");
			return "rfrHome";
		}
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfrSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchRFR(
			@ModelAttribute("rfrCommand") ReasonForRejection rfrSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ReasonForRejection> rfReject = null;
		List<Object[]> list = null;

		try {

			String dbField = rfrSearch.getXmlLabel();
			String operation = rfrSearch.getOperations();
			String basicSearchId = rfrSearch.getBasicSearchId();

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

				list = rfrService.searchReasonForRejection();
				rfReject = new ArrayList<ReasonForRejection>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					ReasonForRejection rfrList = new ReasonForRejection();
					rfrList.setReasonForRejectionId((Integer) objects[0]);
					rfrList.setReasonForRejection((String) objects[1]);
					rfReject.add(rfrList);
				}
				
			} else {
				list = rfrService.basicSearchRFR(dbField, operation,
						basicSearchId);
				rfReject = new ArrayList<ReasonForRejection>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					ReasonForRejection rfrList = new ReasonForRejection();
					rfrList.setReasonForRejectionId((Integer) objects[0]);
					rfrList.setReasonForRejection((String) objects[1]);
					rfReject.add(rfrList);
				}
							}
			if (rfReject!=null) {
				request.setAttribute("rfrSearchNoData",
						"Nothing found to display");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("rfrHome");
		modelAndView.addObject("rfrCommand");
		request.setAttribute("rfrSearch", rfReject);
		return modelAndView;
	}

	/*
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/reasonForRejectionIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String rFREdit(@ModelAttribute ReasonForRejection rfrEdit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request
				.getParameter("reasonForRejectionIdEdit"));
		List<Object[]> list = null;
		List<ReasonForRejection> rfReject = new ArrayList<ReasonForRejection>();
		Object[] objects = null;
		try {

			list = rfrService.searchReasonForRejectionWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				rfrEdit.setReasonForRejectionIdEditt((Integer) objects[0]);
				rfrEdit.setReasonForRejectionEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		rfReject.add(rfrEdit);
		request.setAttribute("list", rfReject);
		model.addAttribute("rfrCommand", rfrEdit);

		return "rfrHome";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfrEdit", method = RequestMethod.POST)
	public String updateRFR(
			@ModelAttribute("rfrCommand") ReasonForRejection rfrUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int chekId = rfrUpdate.getReasonForRejectionIdEditt();
		String checkReasonForRejection = rfrUpdate.getReasonForRejectionEditt();
		int list1 = rfrService.checkEditDuplicate(checkReasonForRejection,
				chekId);
		if (list1 == 0) {

			try {
				rfrUpdate.setReasonForRejectionId(rfrUpdate
						.getReasonForRejectionIdEditt());
				rfrUpdate.setReasonForRejection(rfrUpdate
						.getReasonForRejectionEditt());
				msg = rfrService.updateReasonForRejection(rfrUpdate);
				if (msg.equals("S")) {
					request.setAttribute("rfrUpadte",
							"Reason For Rejection Data Updated Successfully ");
				} else {
					request.setAttribute("rfrUpadteError",
							"Reason For Rejection Data Did not Updated");
				}
			} catch (Exception e) {
				request.setAttribute("rfrUpadteError",
						"Reason For Rejection Data  Did not Updated");
				e.printStackTrace();
			}

			model.addAttribute("rfrCommand", new ReasonForRejection());
			return "rfrHome";
		} else {
			request.setAttribute("list", "RFR");
			request.setAttribute("addRFRDuplicate",
					"Reason For Rejection is Already Exists Please try some other name");
			return "rfrHome";
		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/reasonForRejectionIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteRFR(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int RFRId = 0;
		try {
			RFRId = Integer.parseInt(request
					.getParameter("reasonForRejectionIdDelete"));
			String msg = rfrService.deleteReasonForRejection(RFRId);
			if (msg.equals("S")) {
				request.setAttribute("rfrDelete",
						"Reason For Rejection Data  Deleted Successfully");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Reason For Rejection", "ROW", String
						.valueOf(RFRId), "1", modifiedDate, session
						.getAttribute("userName").toString());
			} else {
				request.setAttribute("rfrDeleteError",
						"Reason For Rejection Data  Did Not Deleted");
			}

		} catch (Exception e) {
			request.setAttribute("rfrDeleteError",
					"Reason For Rejection Data  Did Not Deleted");
			e.printStackTrace();
		}
		return new ModelAndView("rfrHome", "rfrCommand",
				new ReasonForRejection());
	}

}
