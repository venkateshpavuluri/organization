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
import com.mnt.erp.bean.VendGroup;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VendorGourpServiceImpl;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
public class VendorGroupController {

	@Autowired
	VendorGourpServiceImpl vendorGroupService;
	
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/Vendgroup", method = RequestMethod.GET)
	public ModelAndView getVendGroup(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Vendgroup.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("VendGroupadd", "vendorGroupAdd",
				new VendGroup());
	}

	@RequestMapping(value = "/vendorGroupAdd", method = RequestMethod.POST)
	public String saveVendGroup(
			@ModelAttribute("vendorGroupAdd") VendGroup vendGroup,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String vendorGoupSave = null;
		int list1 = 0;
		String res = null;
		HttpSession session=null;
		String vendorGroupCheck = vendGroup.getVendorGroup();
		String vendorGroupCodeCheck = vendGroup.getVendorGroupCode();
		list1 = vendorGroupService.vendorDuplicate(vendorGroupCheck,
				vendorGroupCodeCheck);
		if (list1 == 0) {
			try {
				session=request.getSession(false);
				msg = vendorGroupService.saveVendorGroup(vendGroup,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					vendorGoupSave = "Vendor Group has been saved successfully";
					list.add("2");
					res = "redirect:Vendgroup.mnt?success=" + vendorGoupSave
							+ "&list=" + list + "";
				} else {
					vendorGoupSave = "Vendor Group has not been saved";
					list.add("2");
					res = "redirect:Vendgroup.mnt?warning=" + vendorGoupSave
							+ "&listwar=" + list + "";
				}
			}

			catch (Exception e) {
				vendorGoupSave = "Vendor Group has not been saved";
				list.add("2");
				res = "redirect:Vendgroup.mnt?warning=" + vendorGoupSave
						+ "&listwar=" + list + "";
				e.printStackTrace();
			}
		} 
		else {

			vendGroup.setAid(1);
			request.setAttribute("addVendGroupDuplicate",
					"Vendor Group Already Exists Please try some other name");

			return "VendGroupadd";
		}

		return res;
	}

	@RequestMapping(value = "/VendGroupSearch", method = RequestMethod.GET)
	public ModelAndView searchVendGroup(
			@ModelAttribute("vendorGroupAdd") VendGroup vendGroup,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<VendGroup> VendGroup = null;
		try {
			int id = vendGroup.getVendorGroup_Id();
			String dbField = vendGroup.getXmlLabel();
			String operation = vendGroup.getOperations();
			String basicSearchId = vendGroup.getBasicSearchId();

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
				List<Object[]> list = vendorGroupService.searchVendorGroup(id);
				VendGroup = new ArrayList<VendGroup>();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					VendGroup vg = new VendGroup();
					vg.setVendorGroup_Id((Integer) objects[0]);
					vg.setVendorGroup((String) objects[1]);
					vg.setVendorGroupCode((String) objects[2]);
					VendGroup.add(vg);
				}
			} else {
				List<Object[]> list = vendorGroupService
						.basicSearchVendorGroup(dbField, operation,
								basicSearchId);
				VendGroup = new ArrayList<VendGroup>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					VendGroup vg = new VendGroup();
					vg.setVendorGroup_Id((Integer) objects[0]);
					vg.setVendorGroup((String) objects[1]);
					vg.setVendorGroupCode((String) objects[2]);
					VendGroup.add(vg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("vendorSearch", "vendorSearch");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("VendGroupadd");
		modelAndView.addObject("VendorGroup", VendGroup);
		return modelAndView;
	}

	@RequestMapping(value = "/VendorGroupEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editVendGroup(
			@ModelAttribute("vendorGroupAdd") VendGroup vendGroup,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("VendorGroupEdit"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = vendorGroupService.editVendorGroupWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				vendGroup.setEditVendorGroup_Id((Integer) objects[0]);
				vendGroup.setEditVendorGroup((String) objects[1]);
				vendGroup.setEditVendorGroupCode((String) objects[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		request.setAttribute("vgvalues", "vgvalues");
		return "VendGroupadd";

	}

	@RequestMapping(value = "/VendorGroupEdit", method = RequestMethod.POST)
	public String updateVendGroup(
			@ModelAttribute("vendorGroupAdd") VendGroup vendGroup,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String vendorGroupCheck = vendGroup.getEditVendorGroup();
		String vendorGroupCodeCheck = vendGroup.getEditVendorGroupCode();
		int id = vendGroup.getEditVendorGroup_Id();
		int list2 = 0;
		String msg = null;
		list2 = vendorGroupService.vendorEditDuplicate(vendorGroupCheck,
				vendorGroupCodeCheck, id);
		if (list2 == 0) {
			try {
				msg = vendorGroupService.updateVendorGroup(vendGroup);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (msg == "S") {
				request.setAttribute("vendorGroupUpdate",
						"Vendor Group has been updated successfully");
			} else {
				request.setAttribute("vendorGroupUpdateError",
						"Vendor Group has not been updated");
			}

			return "VendGroupadd";
		} else {

			request.setAttribute("editVendGroupDuplicate",
					"Vendor Group Already Exists Please try some other name");
			request.setAttribute("vgvalues", "vgvalues");

			return "VendGroupadd";
		}

	}

	@RequestMapping(value = "/VendorGroupDelete", method = RequestMethod.GET)
	public ModelAndView deleteVendGroup(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;

		try {
			id = Integer.parseInt(request.getParameter("vendorGroupDelete"));

			String msg = vendorGroupService.deleteVendorGroup(id);

			if (msg.equals("S")){
				session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Vendor Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("vendorGroupDelete",
						"Vendor Group has been deleted successfully");
			}
			else {
				request.setAttribute("vendorGroupDeleteError",
						"Vendor Group has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("VendGroupadd", "vendorGroupAdd",
				new VendGroup());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "vendorGroup_Id";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
