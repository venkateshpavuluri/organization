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

import com.mnt.erp.bean.Designation;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DesignationService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class DesignationController {

	@Autowired
	DesignationService designationService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/designationHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView designationType(
			@ModelAttribute("designationAdd") Designation designation,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("designationHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("designationHome", "designationAdd",
				new Designation());
	}

	@RequestMapping(value = "/designationAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveDesignationDetails(
			@ModelAttribute("designationAdd") @Valid Designation designationAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {

		String msa,res = null;
		Long duplicateId = 0l;
		HttpSession session=null;

		try {
			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				designationAdd.setAid(1);
				return "designationHome";
			}
			// this method is used to check the Duplicates
			duplicateId = designationService
					.duplicateDesignationCheck(designationAdd.getDesignation());
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveDesignationDetails this method is used to save
				// Designation Details
				session=request.getSession(false);
				msa = designationService.saveDesignationDetails(designationAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (msa.equals("S")) {
					res = "redirect:designationHome.mnt?list=" + "success" + "";
					
				} else {
                     
					res = "redirect:designationHome.mnt?listwar=" + "fail" + "";
				}
			} else {

				request.setAttribute("DesignationDuplicate",
						"Designation Name  Already exist");
				designationAdd.setAid(1);
				return "designationHome";
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:designationHome.mnt?listwar=" + "fail" + "";
			
		}
       return "redirect:designationHome.mnt?list=" + "success" + "";
	}

	@RequestMapping(value = "/designationSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchDesignation(
			@ModelAttribute Designation designationSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<Designation> designationBean = new ArrayList<Designation>();

		try {
			String dbField = designationSearch.getXmlLabel();
			String operation = designationSearch.getOperations();
			String basicSearchId = designationSearch.getBasicSearchId();

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
				list = designationService.searchDesignation();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Designation r = new Designation();
					Object[] obj = (Object[]) iterator.next();
					r.setDesignationId((Integer) obj[0]);
					r.setDesignation((String) obj[1]);

					designationBean.add(r);

				}
			} else {
				list = designationService.basicSearchDesignation(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Designation r = new Designation();
					Object[] obj = (Object[]) iterator.next();
					r.setDesignationId((Integer) obj[0]);
					r.setDesignation((String) obj[1]);

					designationBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("designationSearch", designationBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("designationAdd", designationSearch);

		return "designationHome";
	}

	@ModelAttribute("DesignationSearchNames")
	public Map<String, String> populatedesignationSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = designationService.selectDesignationNames();
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

	@RequestMapping(value = "/designationEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String designationEdit(
			@ModelAttribute Designation designationDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String designationname = request.getParameter("designationDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<Designation> designationsList = new ArrayList<Designation>();

		try {

			list = designationService.searchDesignationWithId(designationname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				designationDisplay.setDesignationIdEdit((Integer) object[0]);
				designationDisplay.setDesignationEdit((String) object[1]);

				/* designationDisplay.setStatusEdit((String) object[2]); */

				designationsList.add(designationDisplay);

			}
			request.setAttribute("designationValues", designationsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("designationAdd", designationDisplay);
		return "designationHome";

	}

	@RequestMapping(value = "/designationUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateDesignation(
			@ModelAttribute("designationAdd") Designation designation,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = designationService.updateDuplicateCheck(
					designation.getDesignationEdit(),
					designation.getDesignationIdEdit());

			if (duplicateId == 0) {
				designation
						.setDesignationId(designation.getDesignationIdEdit());
				designation.setDesignation(designation.getDesignationEdit());
			

				String msg = designationService.updateDesignation(designation);

				if (msg.equals("S")) {
					request.setAttribute("designationUpadteSuccess",
							"Designation Details Updated Successfully");
				} else {
					

					request.setAttribute("designationUpadteFail",
							"Designation Details has Not Updated");
					
				}
			} else {
				request.setAttribute("designationEditDuplicate",
						"Designation Name Already exist");
				request.setAttribute("designationValues", "hello");

				return "designationHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("designationAdd", new Designation());

		return "designationHome";

	}

	@RequestMapping(value = "/designationDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView designationDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int designationId = 0;

		String delmsg1 = null;
		String delmsg2 = null;
		try {
			designationId = Integer.parseInt(request
					.getParameter("designationIdDelete"));
			String msg = designationService.designationDelete(designationId);

			String delmsg = msg;
			String[] delmsgpart = delmsg.split(",");
			delmsg1 = delmsgpart[0];
			delmsg2 = delmsgpart[1];
			HttpSession session=null;
			if (delmsg1.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","desg","ROW" ,String.valueOf(designationId),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("designationDeleteSuccess", " Deleted Successfully");
			} else {
				request.setAttribute("designationDeleteFail", " Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("designationHome", "designationAdd",
				new Designation());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "designationId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
