/**
 @author Sailajach

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

import com.mnt.erp.bean.MaterialType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MaterialTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class MaterialTypeController {
	List<Object[]> list = null;
	@Autowired
	MaterialTypeService materialTypeService;
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/materialType", method = RequestMethod.GET)
	public ModelAndView getMaterialType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("materialType.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("materialTypeHome", "materialTypeCommand",
				new MaterialType());

	}

	/*
	 * =================================Add
	 * Method=======================================
	 */
	@RequestMapping(value = "/materialType", method = RequestMethod.POST)
	public String addMaterialTypeDetails(
			@ModelAttribute("materialTypeCommand") MaterialType material_type,
			HttpServletRequest request, HttpServletResponse response,
			Model model)

	{
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		String materialTypeSave = null;
        HttpSession session=null;
        String res=null;
		String checkMTType = material_type.getMaterialTypeName();
		String checkMTTypeCode = material_type.getMaterialTypeCode();
		int list1 = materialTypeService.checkDuplicate(checkMTType,
				checkMTTypeCode);
		if (list1 == 0) {
			try {
				session=request.getSession(false);
				

				msg = materialTypeService.addMaterialTypeDetails(material_type, session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg=="S"){
					materialTypeSave = "Material Type has been saved successfully";
					list.add("2");
					res = "redirect:materialType.mnt?success="
							+ materialTypeSave + "&list=" + list + "";
				}
				else
				{
					materialTypeSave = "Material Type is not saved properly";
					list.add("2");
					res = "redirect:materialType.mnt?warning="
							+ materialTypeSave + "&listwar=" + list + "";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			

		} else {
			material_type.setAid(1);
			request.setAttribute("addMTDuplicate",
					"Material Type is Already Exists Please try some other name");
			return "materialTypeHome";
		}
		return res;

	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/materialTypeSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchMaterialType(
			@ModelAttribute("materialTypeCommand") MaterialType material,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<MaterialType> materialtype = null;
		List<Object[]> list = null;
		try {
			int id = material.getMaterialType();

			String dbField = material.getXmlLabel();
			String operation = material.getOperations();
			String basicSearchId = material.getBasicSearchId();

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
				materialtype = new ArrayList<MaterialType>();
				list = materialTypeService.searchMaterialType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					MaterialType materialtypelist = new MaterialType();
					materialtypelist.setMaterialType((Integer) objects[0]);
					materialtypelist.setMaterialTypeName((String) objects[1]);
					materialtypelist.setMaterialTypeCode((String) objects[2]);
					materialtype.add(materialtypelist);

				}

			} else {
				list = materialTypeService.basicSearchMaterialType(dbField,
						operation, basicSearchId);
				materialtype = new ArrayList<MaterialType>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					MaterialType materialtypelist = new MaterialType();
					materialtypelist.setMaterialType((Integer) objects[0]);
					materialtypelist.setMaterialTypeName((String) objects[1]);
					materialtypelist.setMaterialTypeCode((String) objects[2]);
					materialtype.add(materialtypelist);
				}
				if (materialtype!=null) {
					request.setAttribute("mtSearchNoData",
							"Nothing found to display");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("materialTypeHome");
		modelAndView.addObject("materialTypeCommand");
		request.setAttribute("materialTypeSearch", materialtype);
		return modelAndView;
	}

	/*
	 * =================================Edit
	 * Method=======================================
	 */
	@RequestMapping(value = "/materialTypeIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String materialTypeEdit(@ModelAttribute MaterialType materialtype,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("materialTypeIdEdit"));
		List<Object[]> list = null;
		List<MaterialType> materialtypes = new ArrayList<MaterialType>();
		Object[] objects = null;
		try {

			list = materialTypeService.searchMaterialTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				materialtype.setMaterialTypeEdit((Integer) objects[0]);
				materialtype.setMaterialTypeNameEdit((String) objects[1]);
				materialtype.setMaterialTypeCodeEdit((String) objects[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		materialtypes.add(materialtype);
		request.setAttribute("list", materialtypes);
		model.addAttribute("materialTypeCommand", materialtype);

		return "materialTypeHome";
	}

	/*
	 * =================================Update
	 * Method=======================================
	 */
	@RequestMapping(value = "/materialTypeEdit", method = RequestMethod.POST)
	public String updateMaterialType(
			@ModelAttribute("materialTypeCommand") MaterialType materialtype,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;

		String checkMTType = materialtype.getMaterialTypeNameEdit();
		String checkMTTypeCode = materialtype.getMaterialTypeCodeEdit();
		int checkId = materialtype.getMaterialTypeEdit();
		int list1 = materialTypeService.checkEditDuplicate(checkMTType,
				checkMTTypeCode, checkId);
		if (list1 == 0) {
			try {
				materialtype
						.setMaterialType(materialtype.getMaterialTypeEdit());
				materialtype.setMaterialTypeCode(materialtype
						.getMaterialTypeCodeEdit());
				materialtype.setMaterialTypeName(materialtype
						.getMaterialTypeNameEdit());

				msg = materialTypeService.updateMaterialType(materialtype);
				if (msg.equals("S")){
					request.setAttribute("materialTypeUpadte",
							"Material Type has been updated successfully");
			}
				else{
					request.setAttribute("materialTypeUpadteError",
							"Material Type has not been updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			return "materialTypeHome";
		} else {
			request.setAttribute("list", "materialType");
			request.setAttribute("editMTDuplicate",
					"Material Type is Already Exists Please try some other name");
			return "materialTypeHome";
		}

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/materialTypeIdDelete", method = RequestMethod.GET)
	public ModelAndView materialTypeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
        HttpSession session=null;
		int id = 0;
		try {
			id = Integer.parseInt(request
					.getParameter("materialTypeIdDelete"));
			String msg = materialTypeService.materialTypeDelete(id);
			if (msg.equals("S"))
			{
				request.setAttribute("meterialTypeDelete",
						"Material Type has been deleted successfully");
				session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Agreement Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}
			else{
				request.setAttribute("meterialTypeDeleteError", "Material Type has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("materialTypeHome", "materialTypeCommand",
				new MaterialType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "materialType";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
