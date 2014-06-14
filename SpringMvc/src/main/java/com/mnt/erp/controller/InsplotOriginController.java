/**
copyright MNTSoft
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
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.InsplotOriginService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * @version 1.0 31-10-2013
 * @build 0.0
 * 
 */
@Controller
public class InsplotOriginController {
	@Autowired
	InsplotOriginService insplotoriginService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/insplotoriginHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView vehicleType(
			@ModelAttribute("insplotoriginAdd") InsplotOrigin insplotorigin,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
         
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("insplotoriginHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("insplotoriginHome", "insplotoriginAdd",
				new InsplotOrigin());
	}

	@RequestMapping(value = "/insplotoriginAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveInsplotOriginDetails(
			@ModelAttribute("insplotoriginAdd") @Valid InsplotOrigin insplotoriginAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String msg = null;
		Long duplicateId = 0l;
		String res=null;

		try {
			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				insplotoriginAdd.setAid(1);
				return "insplotoriginHome";
			}
			// this method is used to check the Duplicates
			duplicateId = insplotoriginService
					.duplicateInsplotOriginCheck(insplotoriginAdd
							.getInsplotorigin());
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveInsplotOriginDetails this method is used to save
				// InsplotOrigin Details
				session=request.getSession(false);
				msg = insplotoriginService
						.saveInsplotOriginDetails(insplotoriginAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				model.addAttribute("insplotoriginAdd", new InsplotOrigin());
				if (msg.equals("S")) {
					
					res = "redirect:insplotoriginHome.mnt?list=" + "success" + "";
					
				} else {
					res = "redirect:insplotoriginHome.mnt?listwar=" + "fail" + "";
					
				}
			} else {

				request.setAttribute("InsplotOriginDuplicate",
						"Warning ! Inspection Lot Orgin already exists!");
				insplotoriginAdd.setAid(1);
				return "insplotoriginHome";
			}
		
			
		} catch (Exception e) {
			res = "redirect:CharacteristicTypeHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
			
		}
		return res;

	}

	@RequestMapping(value = "/insplotoriginSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchInsplotOrigin(
			@ModelAttribute InsplotOrigin insplotoriginSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<InsplotOrigin> insplotOrigin = new ArrayList<InsplotOrigin>();

		InsplotOrigin insplotoriginsearch = null;
		try {
			int id = insplotoriginSearch.getInsplotoriginId();
			String dbField = insplotoriginSearch.getXmlLabel();
			String operation = insplotoriginSearch.getOperations();
			String basicSearchId = insplotoriginSearch.getBasicSearchId();

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
				list = insplotoriginService.searchInsplotOrigin();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					InsplotOrigin vt = new InsplotOrigin();
					Object[] obj = (Object[]) iterator.next();
					vt.setInsplotoriginId((Integer) obj[0]);
					vt.setInsplotorigin((String) obj[1]);
					insplotOrigin.add(vt);

				}
			} else {
				list = insplotoriginService.basicSearchInsplotOrigin(dbField,
						operation, basicSearchId);
			
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					InsplotOrigin vt = new InsplotOrigin();
					Object[] obj = (Object[]) iterator.next();
					vt.setInsplotoriginId((Integer) obj[0]);
					vt.setInsplotorigin((String) obj[1]);
					insplotOrigin.add(vt);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("insplotoriginSearch", insplotOrigin);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("insplotoriginAdd", insplotoriginSearch);

		return "insplotoriginHome";
	}

	@ModelAttribute("InsplotOriginSearchNames")
	public Map<String, String> populateinsplotoriginSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = insplotoriginService.selectInsplotOriginNames();
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

	@RequestMapping(value = "/insplotoriginEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String insplotoriginEdit(
			@ModelAttribute InsplotOrigin insplotoriginDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String insplotoriginname = request.getParameter("insplotoriginDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<InsplotOrigin> insplotoriginsList = new ArrayList<InsplotOrigin>();

		try {

			list = insplotoriginService
					.searchInsplotOriginWithId(insplotoriginname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				insplotoriginDisplay
						.setInsplotoriginIdEdit((Integer) object[0]);
				insplotoriginDisplay.setInsplotoriginEdit((String) object[1]);


				insplotoriginsList.add(insplotoriginDisplay);

			}
			request.setAttribute("insplotoriginValues", insplotoriginsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("insplotoriginAdd", insplotoriginDisplay);
		return "insplotoriginHome";

	}

	@RequestMapping(value = "/insplotoriginUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateInsplotOrigin(
			@ModelAttribute("insplotoriginAdd") InsplotOrigin insplotorigin,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = insplotoriginService.updateDuplicateCheck(
					insplotorigin.getInsplotoriginEdit(),
					insplotorigin.getInsplotoriginIdEdit());

			if (duplicateId == 0) {
				insplotorigin.setInsplotoriginId(insplotorigin
						.getInsplotoriginIdEdit());
				insplotorigin.setInsplotorigin(insplotorigin
						.getInsplotoriginEdit());

				String msg = insplotoriginService
						.updateInsplotOrigin(insplotorigin);

				if (msg.equals("S")) {
					
					request.setAttribute("insplotoriginUpadte","InsplotOrigin has been updated Successfully");
					
				}
				else {
				
					request.setAttribute("insplotoriginUpadteError","InsplotOrigin  has not been Updated");
					
				}
			} else {
				request.setAttribute("insplotoriginEditDuplicate",
						"Warning ! Inspection Lot Orgin already exists!");
				request.setAttribute("insplotoriginValues", "insplotoriginValues");

				return "insplotoriginHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("insplotoriginAdd", new InsplotOrigin());

		return "insplotoriginHome";

	}

	@RequestMapping(value = "/insplotoriginDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView insplotoriginDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try {
			id = Integer.parseInt(request
					.getParameter("insplotoriginIdDelete"));
			String msg = insplotoriginService
					.insplotoriginDelete(id);

		
		
			if (msg.equals("S")) {
				request.setAttribute("insplotOriginDelete","InsplotOrigin has been saved");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Insp Lot Origin","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				
				
			} else {
				request.setAttribute("insplotOriginDeleteError",
						"insplotOrigin has not been saved");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("insplotoriginHome", "insplotoriginAdd",
				new InsplotOrigin());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "insplotOriginId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
