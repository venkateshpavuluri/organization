/**
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

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CapacityCategory;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CapacityCategoryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class CapacityCategoryController {
	@Autowired
	CapacityCategoryService capcategoryService;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/capcategoryHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView capcategory(
			@ModelAttribute("capcategoryAdd") CapacityCategory capcategoryAdd,
			SessionStatus status, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("capcategoryHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("capcategoryHome", "capcategoryAdd",
				new CapacityCategory());
	}

	@RequestMapping(value = "/capcategoryAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveCapacityCategoryDetails(
			@ModelAttribute("capcategoryAdd") @Valid CapacityCategory capcategoryAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {

		String msg = null;
		Long duplicateId = 0l;
		String res = null;
		HttpSession session = null;
		response.setCharacterEncoding("UTF-8");
		session=request.getSession(false);
		try {

			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				capcategoryAdd.setAid(1);
				return "capcategoryHome";
			}
			// this method is used to check the Duplicates
			duplicateId = capcategoryService
					.duplicateCapacityCategoryCheck(capcategoryAdd
							.getCapcategory());
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveCapacityCategoryDetails this method is used to save
				// CapacityCategory Details
				msg = capcategoryService
						.saveCapacityCategoryDetails(capcategoryAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					res = "redirect:capcategoryHome.mnt?list=" + "success" + "";

				} else {
					res = "redirect:capcategoryHome.mnt?listwar=" + "fail" + "";

				}
			} else {

				request.setAttribute("CapacityCategoryDuplicate",
						"Capacity Category Name  Already exist");
				capcategoryAdd.setAid(1);
				return "capcategoryHome";
			}

		} catch (Exception e) {
			res = "redirect:capcategoryHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = "/capcategorySearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchCapacityCategory(
			@ModelAttribute CapacityCategory capcategorySearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<CapacityCategory> capcategoryBean = new ArrayList<CapacityCategory>();

		try {

			String dbField = capcategorySearch.getXmlLabel();
			String operation = capcategorySearch.getOperations();
			String basicSearchId = capcategorySearch.getBasicSearchId();

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
				list = capcategoryService.searchCapacityCategory();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					CapacityCategory r = new CapacityCategory();
					Object[] obj = (Object[]) iterator.next();
					r.setCapcategoryId((Integer) obj[0]);
					r.setCapcategory((String) obj[1]);

					capcategoryBean.add(r);

				}
			} else {
				list = capcategoryService.basicSearchCapacityCategory(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					CapacityCategory r = new CapacityCategory();
					Object[] obj = (Object[]) iterator.next();
					r.setCapcategoryId((Integer) obj[0]);
					r.setCapcategory((String) obj[1]);

					capcategoryBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("capcategorySearch", capcategoryBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("capcategoryAdd", capcategorySearch);

		return "capcategoryHome";
	}

	@ModelAttribute("CapacityCategorySearchNames")
	public Map<String, String> populatecapcategorySearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		// HttpServletResponse response=null;
		// response.setCharacterEncoding("UTF-8");
		try {
			listvalues = capcategoryService.selectCapacityCategoryNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String desigId = Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/capcategoryEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String capcategoryEdit(
			@ModelAttribute CapacityCategory capcategoryDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String capcategoryname = request.getParameter("capcategoryDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		response.setCharacterEncoding("UTF-8");
		List<CapacityCategory> capcategorysList = new ArrayList<CapacityCategory>();

		try {

			list = capcategoryService
					.searchCapacityCategoryWithId(capcategoryname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				capcategoryDisplay.setCapcategoryIdEdit((Integer) object[0]);
				capcategoryDisplay.setCapcategoryEdit((String) object[1]);

				capcategorysList.add(capcategoryDisplay);

			}
			request.setAttribute("capcategoryValues", capcategorysList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("capcategoryAdd", capcategoryDisplay);
		return "capcategoryHome";

	}

	@RequestMapping(value = "/capcategoryUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateCapacityCategory(
			@ModelAttribute("capcategoryAdd") CapacityCategory capcategory,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = capcategoryService.updateDuplicateCheck(
					capcategory.getCapcategoryEdit(),
					capcategory.getCapcategoryIdEdit());

			if (duplicateId == 0) {
				capcategory
						.setCapcategoryId(capcategory.getCapcategoryIdEdit());
				capcategory.setCapcategory(capcategory.getCapcategoryEdit());
				/* capcategory.setStatus(capcategory.getStatusEdit()); */

				String msg = capcategoryService
						.updateCapacityCategory(capcategory);

				if (msg.equals("S")) {
					request.setAttribute("capcategoryUpadteSuccess",
							"Capacity Category Details Updated Successfully");
				} else {
					
					request.setAttribute("capcategoryUpadteFail","Capacity Category Details has Not Updated");
					
				}
			} else {
				request.setAttribute("capcategoryEditDuplicate",
						"Capacity Category Name Already exist");
				request.setAttribute("capcategoryValues", "hello");

				return "capcategoryHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "capcategoryHome";

	}

	@RequestMapping(value = "/capcategoryDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView capcategoryDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int capcategoryId = 0;
          String msg=null;
          HttpSession session=null;
		try {
			capcategoryId = Integer.parseInt(request.getParameter("capcategoryIdDelete"));
			msg = capcategoryService.capcategoryDelete(capcategoryId);
			if(msg.equals("S")){
				request.setAttribute("capCategoryDeleted", "Capacity Category has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Capacity Category","ROW" ,String.valueOf(capcategoryId),"1",modifiedDate,session.getAttribute("userName").toString());

				
				
			}
			else{
				request.setAttribute("capCategoryDeleteError", "Capacity Category has not been deleted");
			}

			
			
					} catch (Exception e) {
			e.printStackTrace();
					
		}
		return new ModelAndView("capcategoryHome", "capcategoryAdd",
				new CapacityCategory());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "capcategoryId";

		Map<String, String> map =null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
