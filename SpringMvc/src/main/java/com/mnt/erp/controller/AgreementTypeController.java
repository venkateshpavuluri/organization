/*
 * @Copyright MNTSOFT
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.AgreementType;
import com.mnt.erp.service.AgreementTypeService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
public class AgreementTypeController {

	@Autowired
	AgreementTypeService agservice;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/Agreementtype", method = RequestMethod.GET)
	public ModelAndView getAgreementType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Agreementtype.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("AgreementTypeadd", "AgreementTypeadd",
				new AgreementType());
	}

	@RequestMapping(value = "/AgreementTypeadd", method = RequestMethod.POST)
	public String saveAgreementType(
			@ModelAttribute("AgreementTypeadd") AgreementType agreementType,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();
		String msg = null;
		String agreementTypeAdd = null;

		String res = null;
		HttpSession session=null;
		int agreementTypeList1 = 0;
		String agreementTyp = agreementType.getAgreementType();
		agreementTypeList1 = agservice.agreementTypeDuplicate(agreementTyp);

		if (agreementTypeList1 == 0) {

			try {
				session=request.getSession(false);
				msg = agservice.saveAgreementType(agreementType,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					agreementTypeAdd = "Agreement Type has been saved successfully";
					list.add("2");
					res = "redirect:Agreementtype.mnt?success="
							+ agreementTypeAdd + "&list=" + list + "";
				} else {
					agreementTypeAdd = "Agreement Type is not saved properly";
					list.add("2");
					res = "redirect:Agreementtype.mnt?warning="
							+ agreementTypeAdd + "&listwar=" + list + "";
				}

			} catch (Exception e) {
				
				agreementTypeAdd = "Agreement Type is not saved properly";
				list.add("2");
				res = "redirect:Agreementtype.mnt?warning="
						+ agreementTypeAdd + "&listwar=" + list + "";
				e.printStackTrace();
			}

		

		}

		else {

			agreementType.setAid(1);

			request.setAttribute("addAgreementTypeDuplicate",
					"Agreement Type Already Exists Please try some other name");

			return "AgreementTypeadd";

		}
		return res;
	}

	@RequestMapping(value = "/AgreementTypeSearch", method = RequestMethod.GET)
	public ModelAndView searchAgreementType(
			@ModelAttribute("AgreementTypeadd") AgreementType agreementType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<AgreementType> agreementsType = null;
		try {
			int id = agreementType.getAgreementType_Id();
			String dbField = agreementType.getXmlLabel();
			String operation = agreementType.getOperations();
			String basicSearchId = agreementType.getBasicSearchId();

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
				List<Object[]> list = agservice.searchAgreementType(id);
				agreementsType = new ArrayList<AgreementType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					AgreementType at = new AgreementType();
					at.setAgreementType_Id((Integer) objects[0]);
					at.setAgreementType((String) objects[1]);
					agreementsType.add(at);
				}

			} else {

				List<Object[]> list = agservice.basicSearchAgreementType(
						dbField, operation, basicSearchId);
				agreementsType = new ArrayList<AgreementType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					AgreementType agt = new AgreementType();
					agt.setAgreementType_Id((Integer) objects[0]);
					agt.setAgreementType((String) objects[1]);
					agreementsType.add(agt);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("agtvalues", "agtvalues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AgreementTypeadd");
		modelAndView.addObject("agreementType", agreementsType);
		return modelAndView;
	}

	@RequestMapping(value = "/AgreementTypeEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editAgreementType(
			@ModelAttribute("AgreementTypeadd") AgreementType agreementType,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("agreementTypeEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = agservice.editAgreementTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				agreementType.setEditAgreementType_Id((Integer) objects[0]);
				agreementType.setEditAgreementType((String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("agreementTypevalues", "agreementTypevalues");
		return "AgreementTypeadd";

	}

	@RequestMapping(value = "/AgreementTypeUpdate", method = RequestMethod.POST)
	public String updateAgreementType(
			@ModelAttribute("AgreementTypeadd") AgreementType agreementType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int agreementTypeEditList = 0;

		String agreementTyp = agreementType.getEditAgreementType();
		int id = agreementType.getEditAgreementType_Id();
		agreementTypeEditList = agservice.agreementTypeEditDuplicate(
				agreementTyp, id);
		if (agreementTypeEditList == 0) {

			try {
				String msg = agservice.updateAgreementType(agreementType);

				if (msg == "S") {

					request.setAttribute("agreementTypeUpdate",
							"Agreement Type has been updated successfully");

				}

				else {

					request.setAttribute("agreementTypeUpdateError",
							"Agreement Type has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("AgreementTypeadd", new AgreementType());

			return "AgreementTypeadd";

		} else {

			request.setAttribute("agreementTypevalues", "agreementTypevalues");
			request.setAttribute("editAgreementTypeDuplicate",
					"Agreement Type Already Exists Please try some other name");

			return "AgreementTypeadd";
		}

	}

	@RequestMapping(value = "/AgreementTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteAgreementType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("agreementDelete"));
			
			String msg = agservice.agreementTypeDelete(id);
			
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Agreement Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("agreementTypedelete",
						"Agreement Type has been deleted successfully");
			} else {
				request.setAttribute("agreementTypedeleteError",
						"Agreement Type has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("AgreementTypeadd", "AgreementTypeadd",
				new AgreementType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "agreementType_Id";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
