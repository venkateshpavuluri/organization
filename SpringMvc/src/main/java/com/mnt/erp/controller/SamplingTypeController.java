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

import com.mnt.erp.bean.SamplingType;
import com.mnt.erp.service.SamplingTypeService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class SamplingTypeController {
	@Autowired
	SamplingTypeService samplingTypeservice;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/SamplingType", method = RequestMethod.GET)
	public ModelAndView getSamplingType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("SamplingType.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("SamplingTypeHome", "SamplingTypeadd",
				new SamplingType());
	}

	@RequestMapping(value = "/SamplingTypeadd", method = RequestMethod.POST)
	public String saveSamplingType(
			@ModelAttribute("SamplingTypeadd") SamplingType SamplingType,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();
		String msg = null;
		String SamplingTypeAdd = null;

		String res = null;
		HttpSession session=null;
		int SamplingTypeList1 = 0;
		String samplingTyps = SamplingType.getSamplingTypeName();
		SamplingTypeList1 = samplingTypeservice.samplingTypeDuplicate(samplingTyps);

		if (SamplingTypeList1 == 0) {

			try {
				session=request.getSession(false);
				msg = samplingTypeservice.saveSamplingType(SamplingType,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					SamplingTypeAdd = "Sampling Type has been saved successfully";
					list.add("2");
					res = "redirect:SamplingType.mnt?success="
							+ SamplingTypeAdd + "&list=" + list + "";
				} else {
					SamplingTypeAdd = "Sampling Type is not saved properly";
					list.add("2");
					res = "redirect:SamplingType.mnt?warning="
							+ SamplingTypeAdd + "&listwar=" + list + "";
				}

			} catch (Exception e) {
				
				SamplingTypeAdd = "Sampling Type is not saved properly";
				list.add("2");
				res = "redirect:SamplingType.mnt?warning="
						+ SamplingTypeAdd + "&listwar=" + list + "";
				e.printStackTrace();
			}

		

		}

		else {

			SamplingType.setAid(1);

			request.setAttribute("addSamplingTypeDuplicate",
					"Sampling Type Already Exists Please try some other name");

			return "SamplingTypeHome";

		}
		return res;
	}

	@RequestMapping(value = "/SamplingTypeSearch", method = RequestMethod.GET)
	public ModelAndView searchSamplingType(
			@ModelAttribute("SamplingTypeadd") SamplingType SamplingType,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SamplingType> samplingTypeList = null;
		try {
			int id = SamplingType.getSamplingTypeId();
			String dbField = SamplingType.getXmlLabel();
			String operation = SamplingType.getOperations();
			String basicSearchId = SamplingType.getBasicSearchId();

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
				List<Object[]> list = samplingTypeservice.searchSamplingType(id);
				samplingTypeList = new ArrayList<SamplingType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					SamplingType at = new SamplingType();
					at.setSamplingTypeId((Integer) objects[0]);
					at.setSamplingTypeName((String) objects[1]);
					samplingTypeList.add(at);
				}

			} else {

				List<Object[]> list = samplingTypeservice.basicSearchSamplingType(
						dbField, operation, basicSearchId);
				samplingTypeList = new ArrayList<SamplingType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					SamplingType agt = new SamplingType();
					agt.setSamplingTypeId((Integer) objects[0]);
					agt.setSamplingTypeName((String) objects[1]);
					samplingTypeList.add(agt);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("agtvalues", "agtvalues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("SamplingTypeHome");
		modelAndView.addObject("SamplingType", samplingTypeList);
		return modelAndView;
	}

	@RequestMapping(value = "/SamplingTypeEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editSamplingType(
			@ModelAttribute("SamplingTypeadd") SamplingType SamplingType,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("samplingTypeEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = samplingTypeservice.editSamplingTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				SamplingType.setSamplingTypeIdEdit((Integer) objects[0]);
				SamplingType.setSamplingTypeNameEdit((String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("SamplingTypevalues", "SamplingTypevalues");
		return "SamplingTypeHome";

	}

	@RequestMapping(value = "/SamplingTypeUpdate", method = RequestMethod.POST)
	public String updateSamplingType(
			@ModelAttribute("SamplingTypeadd") SamplingType SamplingType,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int SamplingTypeEditList = 0;

		String samplingTyp = SamplingType.getSamplingTypeNameEdit();
		int id = SamplingType.getSamplingTypeIdEdit();
		SamplingTypeEditList = samplingTypeservice.samplingTypeEditDuplicate(
				samplingTyp, id);
		if (SamplingTypeEditList == 0) {

			try {
				String msg = samplingTypeservice.updateSamplingType(SamplingType);

				if (msg == "S") {

					request.setAttribute("SamplingTypeUpdate",
							"Sampling Type has been updated successfully");

				}

				else {

					request.setAttribute("SamplingTypeUpdateError",
							"Sampling Type has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("SamplingTypeadd", new SamplingType());

			return "SamplingTypeHome";

		} else {

			request.setAttribute("SamplingTypevalues", "SamplingTypevalues");
			request.setAttribute("editSamplingTypeDuplicate",
					"Sampling Type Already Exists Please try some other name");

			return "SamplingTypeHome";
		}

	}

	@RequestMapping(value = "/SamplingTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteSamplingType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("samplingTypeDelete"));
			
			String msg = samplingTypeservice.samplingTypeDelete(id);
			
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Sampling Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("SamplingTypedelete",
						"Sampling Type has been deleted successfully");
			} else {
				request.setAttribute("SamplingTypedeleteError",
						"Sampling Type has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("SamplingTypeHome", "SamplingTypeadd",
				new SamplingType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "SamplingTypeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
