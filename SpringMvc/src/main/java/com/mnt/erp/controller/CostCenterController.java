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

import com.mnt.erp.bean.CostCenter;
import com.mnt.erp.service.CostCenterService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class CostCenterController {

	CostCenterService costCenterService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/CostCenter", method = RequestMethod.GET)
	public ModelAndView getCostCenter(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("CostCenter.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("CostCenterHome", "CostCenteradd",
				new CostCenter());
	}

	@RequestMapping(value = "/CostCenteradd", method = RequestMethod.POST)
	public String saveCostCenter(
			@ModelAttribute("CostCenteradd") CostCenter CostCenter,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();
		String msg = null;
		String CostCenterAdd = null;

		String res = null;
		HttpSession session=null;
		int CostCenterList1 = 0;
		String costCenter = CostCenter.getCostCenter();
		CostCenterList1 = costCenterService.costCenterDuplicate(costCenter);

		if (CostCenterList1 == 0) {

			try {
				session=request.getSession(false);
				msg = costCenterService.saveCostCenter(CostCenter,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					CostCenterAdd = "Cost Center has been saved successfully";
					list.add("2");
					res = "redirect:CostCenter.mnt?success="
							+ CostCenterAdd + "&list=" + list + "";
				} else {
					CostCenterAdd = "Cost Center is not saved properly";
					list.add("2");
					res = "redirect:CostCenter.mnt?warning="
							+ CostCenterAdd + "&listwar=" + list + "";
				}

			} catch (Exception e) {
				
				CostCenterAdd = "Cost Center is not saved properly";
				list.add("2");
				res = "redirect:CostCenter.mnt?warning="
						+ CostCenterAdd + "&listwar=" + list + "";
				e.printStackTrace();
			}

		

		}

		else {

			CostCenter.setAid(1);

			request.setAttribute("addCostCenterDuplicate",
					"Cost Center Already Exists Please try some other name");

			return "CostCenterHome";

		}
		return res;
	}

	@RequestMapping(value = "/CostCenterSearch", method = RequestMethod.GET)
	public ModelAndView searchCostCenter(
			@ModelAttribute("CostCenteradd") CostCenter CostCenter,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CostCenter> costCenters = null;
		try {
			int id = CostCenter.getCostCenterId();
			String dbField = CostCenter.getXmlLabel();
			String operation = CostCenter.getOperations();
			String basicSearchId = CostCenter.getBasicSearchId();

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
				List<Object[]> list = costCenterService.searchCostCenter(id);
				costCenters = new ArrayList<CostCenter>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					CostCenter at = new CostCenter();
					at.setCostCenterId((Integer) objects[0]);
					at.setCostCenter((String) objects[1]);
					costCenters.add(at);
				}

			} else {

				List<Object[]> list = costCenterService.basicSearchCostCenter(
						dbField, operation, basicSearchId);
				costCenters = new ArrayList<CostCenter>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					CostCenter agt = new CostCenter();
					agt.setCostCenterId((Integer) objects[0]);
					agt.setCostCenter((String) objects[1]);
					costCenters.add(agt);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("agtvalues", "agtvalues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CostCenterHome");
		modelAndView.addObject("CostCenter", costCenters);
		return modelAndView;
	}

	@RequestMapping(value = "/CostCenterEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editCostCenter(
			@ModelAttribute("CostCenteradd") CostCenter CostCenter,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("costCenterEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = costCenterService.editCostCenterWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				CostCenter.setCostCenterIdEdit((Integer) objects[0]);
				CostCenter.setCostCenterEdit((String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("CostCentervalues", "CostCentervalues");
		return "CostCenterHome";

	}

	@RequestMapping(value = "/CostCenterUpdate", method = RequestMethod.POST)
	public String updateCostCenter(
			@ModelAttribute("CostCenteradd") CostCenter CostCenter,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int CostCenterEditList = 0;

		String costCent = CostCenter.getCostCenterEdit();
		int id = CostCenter.getCostCenterIdEdit();
		CostCenterEditList = costCenterService.costCenterEditDuplicate(
				costCent, id);
		if (CostCenterEditList == 0) {

			try {
				String msg = costCenterService.updateCostCenter(CostCenter);

				if (msg == "S") {

					request.setAttribute("CostCenterUpdate",
							"Cost Center has been updated successfully");

				}

				else {

					request.setAttribute("CostCenterUpdateError",
							"Cost Center has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("CostCenteradd", new CostCenter());

			return "CostCenterHome";

		} else {

			request.setAttribute("CostCentervalues", "CostCentervalues");
			request.setAttribute("editCostCenterDuplicate",
					"Cost Center Already Exists Please try some other name");

			return "CostCenterHome";
		}

	}

	@RequestMapping(value = "/CostCenterDelete", method = RequestMethod.GET)
	public ModelAndView deleteCostCenter(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("costCenterDelete"));
			
			String msg = costCenterService.costCenterDelete(id);
			
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Cost Center","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("CostCenterdelete",
						"Cost Center has been deleted successfully");
			} else {
				request.setAttribute("CostCenterdeleteError",
						"Cost Center has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("CostCenterHome", "CostCenteradd",
				new CostCenter());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "CostCenterId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
