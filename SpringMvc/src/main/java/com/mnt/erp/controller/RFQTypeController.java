/**
@copyrights MNTSoft

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
import com.mnt.erp.bean.RFQType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.RFQTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class RFQTypeController {

	@Autowired
	RFQTypeService rfq_service;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/RFQType", method = RequestMethod.GET)
	public ModelAndView getRFQType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("RFQType.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("rfqTypeAdd", "rfqTypeCommand", new RFQType());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfqType", method = RequestMethod.POST)
	public String addRFQType(@ModelAttribute("rfqTypeCommand") RFQType rfq,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String checkRFQType = rfq.getRfqType();
		HttpSession session = null;
		String rfqTypeAdd = null;
		String res = null;
		int list1 = rfq_service.checkDuplicate(checkRFQType);
		if (list1 == 0) {

			try {
				session = request.getSession(false);
				RFQType rfqType = new RFQType();
				rfqType.setRfqType(request.getParameter("rfqType"));
				msg = rfq_service.addRFQType(rfqType,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());
				if (msg == "S") {
					rfqTypeAdd = "RFQ Type has been saved successfully";
					list.add("2");
					res = "redirect:RFQType.mnt?success=" + rfqTypeAdd
							+ "&list=" + list + "";
				} else {
					rfqTypeAdd = "RFQ Type has not been saved";
					list.add("2");
					res = "redirect:RFQType.mnt?success=" + rfqTypeAdd
							+ "&listwar=" + list + "";
				}
			} catch (Exception e) {
				rfqTypeAdd = "RFQ Type has not been saved";
				list.add("2");
				res = "redirect:RFQType.mnt?success=" + rfqTypeAdd
						+ "&listwar=" + list + "";
				e.printStackTrace();
			}

		} else {

			rfq.setAid(1);
			request.setAttribute("addRFQDuplicate",
					"RFQ Type is Already Exists Please try some other name");
			return "rfqTypeAdd";
		}
		return res;
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfqTypeSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchRFQType(
			@ModelAttribute("rfqTypeCommand") RFQType rfqType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<RFQType> rfType = null;
		List<Object[]> list = null;
		try {
			int id = rfqType.getRfqTypeId();
			String dbField = rfqType.getXmlLabel();
			String operation = rfqType.getOperations();
			String basicSearchId = rfqType.getBasicSearchId();

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

				list = rfq_service.searchRFQType();
				rfType = new ArrayList<RFQType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					RFQType rfList = new RFQType();
					rfList.setRfqTypeId((Integer) objects[0]);
					rfList.setRfqType((String) objects[1]);
					rfType.add(rfList);

				}

			} else {
				list = rfq_service.basicSearchRFQType(dbField, operation,
						basicSearchId);
				rfType = new ArrayList<RFQType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					RFQType rfList = new RFQType();
					rfList.setRfqTypeId((Integer) objects[0]);
					rfList.setRfqType((String) objects[1]);
					rfType.add(rfList);
				}
				if (rfType != null) {
					request.setAttribute("rfqTypeSearchNoData",
							"Nothing found to display");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("rfqTypeSearch");
		modelAndView.addObject("rfqTypeCommand");
		request.setAttribute("rfqTypeSearch", rfType);
		return modelAndView;
	}

	/*
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfqTypeIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String rfqTypeEdit(@ModelAttribute RFQType rfqType,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("rfqTypeIdEdit"));
		List<Object[]> list = null;
		List<RFQType> rfq_Type = new ArrayList<RFQType>();
		Object[] objects = null;
		try {

			list = rfq_service.searchRFQTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				rfqType.setRfqTypeIdEditt((Integer) objects[0]);
				rfqType.setRfqTypeEditt((String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		rfq_Type.add(rfqType);
		request.setAttribute("list", rfq_Type);
		model.addAttribute("rfqTypeCommand", rfqType);

		return "rfqTypeEdit";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfqTypeEdit", method = RequestMethod.POST)
	public String updateRFQType(
			@ModelAttribute("rfqTypeCommand") RFQType rfqType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int checkId = rfqType.getRfqTypeIdEditt();
		String checkRFQType = rfqType.getRfqTypeEditt();
		int list1 = rfq_service.checkEditDuplicate(checkRFQType, checkId);
		if (list1 == 0) {
			try {

				rfqType.setRfqTypeId(rfqType.getRfqTypeIdEditt());
				rfqType.setRfqType(rfqType.getRfqTypeEditt());
				msg = rfq_service.updateRFQType(rfqType);

				if (msg.equals("S")) {

					request.setAttribute("rfqTypeUpadte",
							"RFQ Type has been updated successfully ");

				} else {

					request.setAttribute("rfqTypeUpadteError",
							"RFQ Type has not been updated");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("rfqTypeCommand", new RFQType());
			return "rfqTypeEdit";
		} else {
			request.setAttribute("list", "rfq");
			request.setAttribute("addRFQDuplicate",
					"RFQ Type is Already Exists Please try some other name");
			return "rfqTypeEdit";
		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/rfqTypeIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteRFQType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session = null;
		try {
			id = Integer.parseInt(request.getParameter("rfqTypeIdDelete"));
			String msg = rfq_service.deleteRFQType(id);
			if (msg.equals("S")) {
				request.setAttribute("rfqTypeDelete",
						"RFQ Type has been deleted");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "RFQ Type", "ROW",
						String.valueOf(id), "1", modifiedDate, session
								.getAttribute("userName").toString());
			} else {
				request.setAttribute("rfqTypeDeleteError",
						"RFQ Type has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("rfqTypeEdit", "rfqTypeCommand", new RFQType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "rfqTypeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
