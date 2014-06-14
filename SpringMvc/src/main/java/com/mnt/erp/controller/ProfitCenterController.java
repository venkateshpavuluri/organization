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

import com.mnt.erp.bean.ProfitCenter;
import com.mnt.erp.service.ProfitCenterService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class ProfitCenterController {
	@Autowired
	ProfitCenterService profitCenterservice;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/ProfitCenter", method = RequestMethod.GET)
	public ModelAndView getProfitCenter(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("ProfitCenter.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("ProfitCenterHome", "ProfitCenteradd",
				new ProfitCenter());
	}

	@RequestMapping(value = "/ProfitCenteradd", method = RequestMethod.POST)
	public String saveProfitCenter(
			@ModelAttribute("ProfitCenteradd") ProfitCenter ProfitCenter,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();
		String msg = null;
		String ProfitCenterAdd = null;

		String res = null;
		HttpSession session=null;
		int ProfitCenterList1 = 0;
		String profitCenter = ProfitCenter.getProfitCenter();
		ProfitCenterList1 = profitCenterservice.profitCenterDuplicate(profitCenter);

		if (ProfitCenterList1 == 0) {

			try {
				session=request.getSession(false);
				msg = profitCenterservice.saveProfitCenter(ProfitCenter,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					ProfitCenterAdd = "Profit Center has been saved successfully";
					list.add("2");
					res = "redirect:ProfitCenter.mnt?success="
							+ ProfitCenterAdd + "&list=" + list + "";
				} else {
					ProfitCenterAdd = "Profit Center is not saved properly";
					list.add("2");
					res = "redirect:ProfitCenter.mnt?warning="
							+ ProfitCenterAdd + "&listwar=" + list + "";
				}

			} catch (Exception e) {
				
				ProfitCenterAdd = "Profit Center is not saved properly";
				list.add("2");
				res = "redirect:ProfitCenter.mnt?warning="
						+ ProfitCenterAdd + "&listwar=" + list + "";
				e.printStackTrace();
			}

		

		}

		else {

			ProfitCenter.setAid(1);

			request.setAttribute("addProfitCenterDuplicate",
					"Profit Center Already Exists Please try some other name");

			return "ProfitCenterHome";

		}
		return res;
	}

	@RequestMapping(value = "/ProfitCenterSearch", method = RequestMethod.GET)
	public ModelAndView searchProfitCenter(
			@ModelAttribute("ProfitCenteradd") ProfitCenter ProfitCenter,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ProfitCenter> profitCenter = null;
		try {
			int id = ProfitCenter.getProfitCenterId();
			String dbField = ProfitCenter.getXmlLabel();
			String operation = ProfitCenter.getOperations();
			String basicSearchId = ProfitCenter.getBasicSearchId();

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
				List<Object[]> list = profitCenterservice.searchProfitCenter(id);
				profitCenter = new ArrayList<ProfitCenter>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					ProfitCenter at = new ProfitCenter();
					at.setProfitCenterId((Integer) objects[0]);
					at.setProfitCenter((String) objects[1]);
					profitCenter.add(at);
				}

			} else {

				List<Object[]> list = profitCenterservice.basicSearchProfitCenter(
						dbField, operation, basicSearchId);
				profitCenter = new ArrayList<ProfitCenter>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					ProfitCenter agt = new ProfitCenter();
					agt.setProfitCenterId((Integer) objects[0]);
					agt.setProfitCenter((String) objects[1]);
					profitCenter.add(agt);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("agtvalues", "agtvalues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ProfitCenterHome");
		modelAndView.addObject("ProfitCenter", profitCenter);
		return modelAndView;
	}

	@RequestMapping(value = "/ProfitCenterEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editProfitCenter(
			@ModelAttribute("ProfitCenteradd") ProfitCenter ProfitCenter,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("profitCenterEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = profitCenterservice.editProfitCenterWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				ProfitCenter.setProfitCenterIdEdit((Integer) objects[0]);
				ProfitCenter.setProfitCenterEdit((String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("ProfitCentervalues", "ProfitCentervalues");
		return "ProfitCenterHome";

	}

	@RequestMapping(value = "/ProfitCenterUpdate", method = RequestMethod.POST)
	public String updateProfitCenter(
			@ModelAttribute("ProfitCenteradd") ProfitCenter ProfitCenter,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int ProfitCenterEditList = 0;

		String profitCent = ProfitCenter.getProfitCenterEdit();
		int id = ProfitCenter.getProfitCenterIdEdit();
		ProfitCenterEditList = profitCenterservice.profitCenterEditDuplicate(
				profitCent, id);
		if (ProfitCenterEditList == 0) {

			try {
				String msg = profitCenterservice.updateProfitCenter(ProfitCenter);

				if (msg == "S") {

					request.setAttribute("ProfitCenterUpdate",
							"Profit Center has been updated successfully");

				}

				else {

					request.setAttribute("ProfitCenterUpdateError",
							"Profit Center has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("ProfitCenteradd", new ProfitCenter());

			return "ProfitCenterHome";

		} else {

			request.setAttribute("ProfitCentervalues", "ProfitCentervalues");
			request.setAttribute("editProfitCenterDuplicate",
					"Profit Center Already Exists Please try some other name");

			return "ProfitCenterHome";
		}

	}

	@RequestMapping(value = "/ProfitCenterDelete", method = RequestMethod.GET)
	public ModelAndView deleteProfitCenter(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("profitCenterDelete"));
			
			String msg = profitCenterservice.profitCenterDelete(id);
			
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Profit Center","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("ProfitCenterdelete",
						"Profit Center has been deleted successfully");
			} else {
				request.setAttribute("ProfitCenterdeleteError",
						"Profit Center has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("ProfitCenterHome", "ProfitCenteradd",
				new ProfitCenter());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "ProfitCenterId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
