package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0 27Sep2013
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
import javax.validation.Valid;

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

import com.mnt.erp.bean.InspectionMethodBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.InspectionMethodService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class InspectionMethodController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	InspectionMethodService inspectionservice;
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/inspectionHome", method = RequestMethod.GET)
	public String getInspectionMethod(
			@ModelAttribute InspectionMethodBean inspectionmethodbean,
			SessionStatus status, Model model, HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("inspectionHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("InspectionMethod", new InspectionMethodBean());

		return "inspectionHome";
	}

	@RequestMapping(value = "/saveInspection", method = RequestMethod.POST)
	public String saveInspectionMethod(
			@ModelAttribute("InspectionMethod") @Valid InspectionMethodBean inspectionMethodBean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		InspectionMethodBean inspectionMethodBean2 = null;
		String inspectionSave = null;
		String inspectionsuccessdup = null;
		HttpSession session=null;
		List<String> list =  new ArrayList<String>();
		String res=null;
		String name = inspectionMethodBean.getInspectionmethod();
		Long id = 0L;
		try {
			session=request.getSession(false);
			id = inspectionservice.getInspectionMethodCount(name);
			if (id == 0) {

				msg = inspectionservice.saveInspectionMethodService(inspectionMethodBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				inspectionMethodBean2 = new InspectionMethodBean();

				map.addAttribute("InspectionMethod", inspectionMethodBean2);
				if (msg.equals("S")) {
					inspectionSave = "Inspection Method has been saved successfully";
					list.add("2");
					res = "redirect:inspectionHome.mnt?success="
							+ inspectionSave + "&list=" + list + "";
				}
				
				else{
					inspectionSave = "Inspection Method has not been saved";
					list.add("2");
					res = "redirect:inspectionHome.mnt?warning="
							+ inspectionSave + "&listwar=" + list + "";
				}
			}

			else {
				inspectionsuccessdup = "Warning ! InspectionMethod is already exists. Please try some other name ";
				inspectionMethodBean.setInspectionmethodhide(1);
				request.setAttribute("inspectionsuccessdup",
						inspectionsuccessdup);
				return "inspectionHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
return res;
		

	}

	@ModelAttribute("inspectionmethodSearch")
	public Map<Integer, String> populateInspectionMethodids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = inspectionservice.selectInspectionMethodService();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/searchInspectionMethod", method = RequestMethod.GET)
	public String searchInspectionMethodIds(
			@ModelAttribute("InspectionMethod") InspectionMethodBean inspectionMethodBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = inspectionMethodBean.getInspectionmethodid();
			List<InspectionMethodBean> inspectionMethodBeans = new ArrayList<InspectionMethodBean>();
			String dbField = inspectionMethodBean.getXmlLabel();
			String operation = inspectionMethodBean.getOperations();
			String basicSearchId = inspectionMethodBean.getBasicSearchId();

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
				list = inspectionservice.searchInspectionMethodService();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					InspectionMethodBean inspectionMethodBean2 = new InspectionMethodBean();
					inspectionMethodBean2
							.setInspectionmethodid((Integer) obj[0]);
					inspectionMethodBean2.setInspectionmethod((String) obj[1]);
					inspectionMethodBeans.add(inspectionMethodBean2);

				}

			} else {

				// list =
				// inspectionservice.searchInspectionMethodServiceWithId(iid);
				list = inspectionservice.basicSearchInspectionMethod(dbField,
						operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					InspectionMethodBean inspectionMethodBean2 = new InspectionMethodBean();
					inspectionMethodBean2
							.setInspectionmethodid((Integer) obj[0]);
					inspectionMethodBean2.setInspectionmethod((String) obj[1]);
					inspectionMethodBeans.add(inspectionMethodBean2);
				}
			}
			request.setAttribute("inspectionMethodBeans", inspectionMethodBeans);
			// model.addAttribute("InspectionMethod", new
			// InspectionMethodBean());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "inspectionHome";
	}

	@RequestMapping(value = "/inspectionEdit", method = RequestMethod.GET)
	public String editInspectionMethod(
			@ModelAttribute("InspectionMethod") InspectionMethodBean inspectionMethodBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inspectionedit"));

		try {
			List<InspectionMethodBean> inspectionMethodBeans = new ArrayList<InspectionMethodBean>();
			list = inspectionservice.searchInspectionMethodServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				inspectionMethodBean
						.setInspectionmethodidedit((Integer) obj[0]);
				inspectionMethodBean.setInspectionmethodedit((String) obj[1]);
				inspectionMethodBeans.add(inspectionMethodBean);
			}
			request.setAttribute("editvalues", inspectionMethodBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inspectionHome";

	}

	@RequestMapping(value = "/inspectionMethodUpdate", method = RequestMethod.POST)
	public String updateInpectionMethod(
			@ModelAttribute("InspectionMethod") InspectionMethodBean inspectionMethodBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = inspectionMethodBean.getInspectionmethodedit();
		int imid = inspectionMethodBean.getInspectionmethodidedit();
		Long iid = 0l;
		String inspectionsuccessdupedit = null;
		try {
			iid = inspectionservice.getInspectionMethodCountedit(name, imid);
			if (iid == 0) {
				inspectionMethodBean.setInspectionmethodid(inspectionMethodBean
						.getInspectionmethodidedit());
				inspectionMethodBean.setInspectionmethod(inspectionMethodBean
						.getInspectionmethodedit());

				String message = inspectionservice
						.updateInspectionMethodService(inspectionMethodBean);
				if (message.equals("S")) {
					request.setAttribute("InspectionMethodUpdate",
							"Inspection Method Data Updated Successfully");
					
				}
				else{
					request.setAttribute("InspectionMethodUpdateError",
							"Inspection Method Data Updated Successfully");
				}
			} else {
				inspectionsuccessdupedit = "Warning ! InspectionMethod is already exists. Please try some other name ";
				inspectionMethodBean.setInspectionmethodhideedit(1);
				request.setAttribute("inspectionsuccessdupedit",
						inspectionsuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "inspectionHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("InspectionMethod", new InspectionMethodBean());
		return "inspectionHome";
	}

	@RequestMapping(value = "/inspectionDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView InspectionMethodDetailsDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("inspectiondelete"));
			String msg = inspectionservice.deleteInspectionMethodService(id);
			if (msg.equals("S")){
				session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Agreement Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("inspectionMethodDelete",
						"Inspection Method Data has been deleted");
		}
			else{
				request.setAttribute("inspectionMethodDeleteError",
						"Inspection Method Data has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("inspectionHome", "InspectionMethod",
				new InspectionMethodBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "inspectionMethodId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
