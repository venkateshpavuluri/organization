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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
public class UomController {
	public static Logger logger = Logger.getLogger(UomController.class);
	@Autowired
	UomService uomService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/MeasuresHome", method = RequestMethod.GET)
	public ModelAndView getUom(HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("MeasuresHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("measuresHome", "measuresAdd", new Uom());
	}

	@RequestMapping(value = "/measuresAdd", method = RequestMethod.POST)
	public String saveUom(@ModelAttribute("measuresAdd") Uom uom,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		String msa = null;
		String uomsave = null;
		HttpSession session = null;
		String uomCheck = uom.getUom();
		String uomCodeCheck = uom.getUomCode();
		int list1 = uomService.uomDuplicate(uomCheck, uomCodeCheck);
		String returnMesg = null;
		if (list1 == 0) {
			try {
				uom.setUom(request.getParameter("uom"));
				uom.setUomCode(request.getParameter("uomCode"));
				session = request.getSession(false);
				msa = uomService.saveUomDetails(uom,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());

				request.setAttribute("uomvalues",
						"Uom has been saved successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (msa.equals("S")) {
				uomsave = "Uom has been saved successfully";

				returnMesg = "redirect:MeasuresHome.mnt?list=" + "success" + "";
			}

			else {
				uomsave = "Uom has been not saved successfully";

				returnMesg = "redirect:MeasuresHome.mnt?listwar=" + "fail" + "";
			}

			model.addAttribute("measuresHome", new Uom());

		} else {

			uom.setAid(1);
			request.setAttribute("addUomDuplicate",
					"Uom Already Exists Choose Another One");

			return "measuresHome";

		}
		return returnMesg;
	}

	@RequestMapping(value = "/uomSearch", method = RequestMethod.GET)
	public ModelAndView searchUom(@ModelAttribute("measuresAdd") Uom uom,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Uom> Uom = null;
		try {
			int id = uom.getUom_Id();
			String dbField = uom.getXmlLabel();
			String operation = uom.getOperations();
			String basicSearchId = uom.getBasicSearchId();

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
				List<Object[]> list = uomService.searchUom(id);
				Uom = new ArrayList<Uom>();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					Uom uomlist = new Uom();
					uomlist.setUom_Id((Integer) objects[0]);
					uomlist.setUom((String) objects[1]);
					uomlist.setUomCode((String) objects[2]);
					Uom.add(uomlist);
				}
			} else {
				List<Object[]> list = uomService.basicSearchUOM(dbField,
						operation, basicSearchId);
				Uom = new ArrayList<Uom>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					Uom uomlist = new Uom();
					uomlist.setUom_Id((Integer) objects[0]);
					uomlist.setUom((String) objects[1]);
					uomlist.setUomCode((String) objects[2]);
					Uom.add(uomlist);

				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("uomvalue", "uomvalue");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("measuresHome");
		modelAndView.addObject("uom", Uom);
		return modelAndView;
	}

	@RequestMapping(value = "/UomEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editUom(@ModelAttribute("measuresAdd") Uom uom,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("uomEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = uomService.editUomWithId(id);
			Iterator<Object[]> iterator = list.iterator();

			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				uom.setEditUom_id((Integer) objects[0]);
				uom.setEditUom((String) objects[1]);
				uom.setEditUomCode((String) objects[2]);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			list = null;
			objects = null;
		}
		request.setAttribute("uomvalues", "uomvalues");
		return "measuresedit";

	}

	@RequestMapping(value = "/uomEdit", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute("measuresAdd") Uom uom,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		String uo = uom.getEditUom();
		String uoc = uom.getEditUomCode();
		int id = uom.getEditUom_id();
		String msg = null;
		int list2 = 0;
		list2 = uomService.uomEditDuplicate(uo, uoc, id);
		if (list2 == 0) {
			try {
				msg = uomService.updateUom(uom);
				if (msg.equals("S")) {
					request.setAttribute("UomUpdate",
							"Uom has been updated successfully");
				} else {
					request.setAttribute("UomUpdateError",
							"Uom has not been  updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("measuresAdd", new Uom());
			return "measuresedit";
		}

		else {

			request.setAttribute("addUomDuplicate",
					"Uom Already Exists Choose Another One");
			request.setAttribute("uomvalues", "uomvalues");

			return "measuresHome";

		}

	}

	@RequestMapping(value = "/UomDelete", method = RequestMethod.GET)
	public ModelAndView deleteUom(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		String msa = null;
		HttpSession session = null;
		try {
			id = Integer.parseInt(request.getParameter("uomDelete"));
			msa = uomService.deleteUom(id);
			if (msa.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Uom", "ROW", String.valueOf(id),
						"1", modifiedDate, session.getAttribute("userName")
								.toString());
				request.setAttribute("UomDelete",
						"Uom has been deleted successfully");
			}

			else {
				request.setAttribute("UomDeleteError",
						"Uom has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("measuresedit", "measuresAdd", new Uom());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "uom_Id";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
