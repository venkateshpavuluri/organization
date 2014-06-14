package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.InspectionType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.InspectionTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class InspectionTypeController {
	@Autowired
	InspectionTypeService inspectionTypeService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/inspectionTypeHome", method = RequestMethod.GET)
	@RequestScoped
	public String getInspectionTypeHome(
			@ModelAttribute InspectionType inspectionType,
			SessionStatus status,HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("inspectionTypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("inspectionType", inspectionType);
		return "inspectionTypeHome";
	}

	@RequestMapping(value = "/addInspectionType", method = RequestMethod.POST)
	@RequestScoped
	public String saveInspectionType(
			@ModelAttribute InspectionType inspectionType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		String inspectionTypeSave = null;
		HttpSession session=null;
		String res=null;
		List<String> list = new ArrayList<String>();

		String inspectionTypeCheck = inspectionType.getInspectionType();
		long checkType = inspectionTypeService
				.checkInspectionType(inspectionTypeCheck);

		if (checkType == 0) {
			try {
				session=request.getSession(false);
				msg = inspectionTypeService.saveInspectionTypeDetails(inspectionType,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					
					inspectionTypeSave = "Inspection Type has been Saved";
					list.add("2");
					res = "redirect:inspectionTypeHome.mnt?success="
							+ inspectionTypeSave + "&list=" + list + "";
					
				} else {
					
					inspectionTypeSave = "Inspection Type has not been saved";
					list.add("2");
					res = "redirect:inspectionTypeHome.mnt?warning="
							+ inspectionTypeSave + "&listwar=" + list + "";
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {

			inspectionType.setAid(1);
			request.setAttribute("addInspectionTypeDuplicate",
					"Inspection Type Already Exists Choose Another One");

			return "inspectionTypeHome";

		}
		return res;
	}

	@ModelAttribute("selectInspectionType")
	public Map<Integer, String> getInspectionType() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = inspectionTypeService.selectInspectionType();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objs = (Object[]) iterator.next();
				map.put((Integer) objs[0], (String) objs[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/searchInspectionType", method = RequestMethod.GET)
	@RequestScoped
	public String searchInspectionType(
			@ModelAttribute InspectionType inspectionType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;
		List<InspectionType> inspectionTypeSearch = null;
		String dbField = inspectionType.getXmlLabel();
		String operation = inspectionType.getOperations();
		String basicSearchId = inspectionType.getBasicSearchId();

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
		if (basicSearchId != "") {

			try {
				inspectionTypeSearch = new ArrayList<InspectionType>();
				// list =
				// inspectionTypeService.searchInspectionTypeWithId(searchInspectionTypeId);
				list = inspectionTypeService.basicSearchInspectionType(dbField,
						operation, basicSearchId);

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					InspectionType inspectionType2 = new InspectionType();
					Object[] objs = (Object[]) iterator.next();
					inspectionType2.setInspectionTypeId((Integer) objs[0]);
					inspectionType2.setInspectionType((String) objs[1]);
					inspectionTypeSearch.add(inspectionType2);
				}

				request.setAttribute("inspectionTypeSearch",
						inspectionTypeSearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "inspectionTypeHome";
		} else {

			try {
				inspectionTypeSearch = new ArrayList<InspectionType>();
				list = inspectionTypeService.searchInspectionType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					InspectionType inspectionType2 = new InspectionType();
					Object[] objs = (Object[]) iterator.next();
					inspectionType2.setInspectionTypeId((Integer) objs[0]);
					inspectionType2.setInspectionType((String) objs[1]);
					inspectionTypeSearch.add(inspectionType2);
				}

				request.setAttribute("inspectionTypeSearch",
						inspectionTypeSearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "inspectionTypeHome";

		}
	}

	@RequestMapping(value = "/inspectionTypeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String inspectionTypeEdit(
			@ModelAttribute InspectionType inspectionTypeDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inspectionTypeIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<InspectionType> inspectionTypeList = new ArrayList<InspectionType>();

		try {

			list = inspectionTypeService.searchInspectionTypeWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				inspectionTypeDisplay
						.setInspectionTypeIdEdit((Integer) object[0]);
				inspectionTypeDisplay.setInspectionTypeEdit((String) object[1]);
				inspectionTypeList.add(inspectionTypeDisplay);
			}
			request.setAttribute("inspectionTypeValues", inspectionTypeList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "inspectionTypeHome";

	}

	@RequestMapping(value = "/inspectionTypeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateInspectionType(
			@ModelAttribute InspectionType inspectionType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		int inspectionTypeId = inspectionType.getInspectionTypeIdEdit();
		String inspectionTypeEdit = inspectionType.getInspectionTypeEdit();

		inspectionType.setInspectionTypeId(inspectionTypeId);
		inspectionType.setInspectionType(inspectionTypeEdit);
		long checkDuplicate = inspectionTypeService.updateCheckInspectionType(
				inspectionTypeEdit, inspectionTypeId);
		if (checkDuplicate == 0) {
			try {
				msg = inspectionTypeService
						.updateInspectionType(inspectionType);
				if(msg=="S"){
					request.setAttribute("inspectionTypeUpdate", "Inspection Type has been updated");
				}
				else{
					request.setAttribute("inspectionTypeUpdateError", "Inspection Type has not been updated");
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			request.setAttribute("updateInspectionTypeDuplicate",
					"Inspection Type Already Exists Choose Another One");
			request.setAttribute("inspectionTypeValues", "inspectionTypeList");
			return "inspectionTypeHome";

		}
		return "inspectionTypeHome";
	}

	@RequestMapping(value = "/inspectionTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteInspectionType(
			@ModelAttribute("inspectionType") InspectionType inspectionType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = Integer.parseInt(request
				.getParameter("inspectionTypeIdDelete"));
		String msg = null;
		try {
			msg = inspectionTypeService.deleteInspectionType(id);
			if(msg=="S"){
				request.setAttribute("inspectionDelete", "Inspection Type has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Inspection Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("inspectionDeleteError", "Inspection Type has been deleted");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("inspectionTypeHome", "inspectionType",
				new InspectionType());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "inspectionTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
