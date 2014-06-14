package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0   
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.VerificationtypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VerificationTypeService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class VerificationTypeController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	VerificationTypeService verificationtypeservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	HttpSession session = null;

	@RequestMapping(value = "/verificationHome", method = RequestMethod.GET)
	public String getVerificationType(
			@ModelAttribute VerificationtypeBean vBean, SessionStatus status,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("verificationHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		response.setCharacterEncoding("UTF-8");
		model.addAttribute("verificationtype", new VerificationtypeBean());

		return "verificationHome";
	}

	@RequestMapping(value = "/verificationsave", method = RequestMethod.POST)
	@RequestScoped
	public String saveVerificationType(
			@ModelAttribute("verificationtype") VerificationtypeBean vBean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		String mess = null;
		VerificationtypeBean vBean1 = null;
		String VTSuccess = null;
		String VTSuccessdup = null;
		List<String> list = null;
		String name = vBean.getVerificationtype();
		Long id = 0L;

		try {
			id = verificationtypeservice.getVerificationTypeCount(name);
			if (id == 0) {
				session = request.getSession(false);
				mess = verificationtypeservice.saveVerificationTypeservice(
						vBean, session.getAttribute("userId").toString(),
						session.getAttribute("userName").toString());
				vBean1 = new VerificationtypeBean();
				map.addAttribute("verificationtype", vBean1);
				if (mess.equals("S")) {

					model.addAttribute("verificationtype",
							new VerificationtypeBean());
					return "redirect:verificationHome.mnt?list=" + "success"
							+ "";
				} else {
					return "redirect:verificationHome.mnt?listwar=" + "fail"
							+ "";
				}

			} else {
				VTSuccessdup = "Warning ! Verification Type is already exists. Please try some other name";
				vBean.setVerificationtypehide(1);
				request.setAttribute("VTSuccessdup", VTSuccessdup);

				return "verificationHome";
			}

		} catch (Exception e) {

			e.printStackTrace();
			return "redirect:verificationHome.mnt?listwar=" + "fail" + "";
		}

	}

	@RequestMapping(value = "/searchVerificationType", method = RequestMethod.GET)
	public String searchVerificationtype(
			@ModelAttribute("verificationtype") VerificationtypeBean vBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = vBean.getVerificationtypeid();
			List<VerificationtypeBean> vBean1 = new ArrayList<VerificationtypeBean>();
			String dbField = vBean.getXmlLabel();
			String operation = vBean.getOperations();
			String basicSearchId = vBean.getBasicSearchId();

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

				list = verificationtypeservice.searchVerificationType();

			} else {

				list = verificationtypeservice.basicSearchVerificationType(
						dbField, operation, basicSearchId);
			}
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				VerificationtypeBean vBean2 = new VerificationtypeBean();
				vBean2.setVerificationtypeid((Integer) obj[0]);
				vBean2.setVerificationtype((String) obj[1]);
				vBean1.add(vBean2);
			}
			request.setAttribute("vBean1", vBean1);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "verificationHome";
	}

	@ModelAttribute("verificationsearch")
	public Map<Integer, String> populateVerificationtypeids() {

		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = verificationtypeservice.selectVerificationType();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				map.put((Integer) obj[0], ((String) obj[1]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/verificationTypeedit", method = RequestMethod.GET)
	public String editVerificationtype(
			@ModelAttribute("verificationtype") VerificationtypeBean vBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("verificationtypeedit"));

		try {
			List<VerificationtypeBean> vBean1 = new ArrayList<VerificationtypeBean>();
			list = verificationtypeservice.searchVerificationTypeWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				vBean.setVerificationtypeeditid((Integer) obj[0]);
				vBean.setVerificationtypeedit((String) obj[1]);
				vBean1.add(vBean);
			}
			request.setAttribute("editvalues", vBean1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "verificationHome";

	}

	@RequestMapping(value = "/VerificationTypeUpdate", method = RequestMethod.POST)
	public String updateVerificationtype(
			@ModelAttribute("verificationtype") VerificationtypeBean vBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = vBean.getVerificationtypeedit();
		int vtid = vBean.getVerificationtypeeditid();
		String VTSuccessdupedit = null;

		Long id = 0L;
		try {

			id = verificationtypeservice.getVerificationTypeCountedit(name,
					vtid);

			if (id == 0) {
				vBean.setVerificationtypeid(vBean.getVerificationtypeeditid());

				vBean.setVerificationtype(vBean.getVerificationtypeedit());

				String message = verificationtypeservice
						.updateVerificationType(vBean);

				if (message.equals("S")) {
					request.setAttribute("Verificationtypeupdate",
							"Verification Type Data Updated Successfully");
					model.addAttribute("verificationtype",
							new VerificationtypeBean());
				} else {
					request.setAttribute("VerificationtypeupdateError",
							"Verification Type Data did not Updated");
				}
			} else {
				VTSuccessdupedit = "Warning ! Verification Type is already exists. Please try some other name";
				vBean.setVerificationtypehideedit(1);
				request.setAttribute("VTSuccessdupedit", VTSuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "verificationHome";
			}
		} catch (Exception e) {
			request.setAttribute("VerificationtypeupdateError",
					"Verification Type Data did not Updated");
			e.printStackTrace();
		}

		return "verificationHome";
	}

	@RequestMapping(value = "/VerificationtypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView verificationTypeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int groupId = 0;
		try {
			groupId = Integer.parseInt(request
					.getParameter("verificationDelete"));

			String msg = verificationtypeservice
					.deleteVerificationType(groupId);
			if (msg.equals("S")) {
				request.setAttribute("Verificationtypedelete",
						"Verification Type Data is Deleted Successfully");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Stock Type", "ROW", String
						.valueOf(groupId), "1", modifiedDate, session
						.getAttribute("userName").toString());
			} else {
				request.setAttribute("VerificationtypedeleteError",
						"Verification Type Data is Not Deleted Properly");
			}
		} catch (Exception e) {
			request.setAttribute("VerificationtypedeleteError",
					"Verification Type Data is Not Deleted Properly");
			e.printStackTrace();
		}
		return new ModelAndView("verificationHome", "verificationtype",
				new VerificationtypeBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "verificationtypeid";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
