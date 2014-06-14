/**
 * 
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.mnt.erp.bean.WFStage;
import com.mnt.erp.bean.WFStep;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.WFStepService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * 
 */
@Controller
public class WFStepController {

	@Autowired
	WFStepService wfstepService;

	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession sess;

	List<WFStep> wfstepList = null;
	List<WFStep> wfstep1 = null;
	List<Object[]> objectsArray = null;
	Iterator<Object[]> iterator = null;
	Object[] objects2 = null;
	WFStep mm = null;

	@RequestMapping(value = "/wfstepHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView wfstepType(@ModelAttribute("wfstepAdd") WFStep wfstep,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("wfstepHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("wfstepHome", "wfstepAdd", new WFStep());
	}

	@RequestMapping(value = "/wfstepAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveWFStepDetails(
			@ModelAttribute("wfstepAdd") @Valid WFStep wfstep,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		 sess = request.getSession(false);
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String createdDate = formatter.format(currentDate.getTime());
		wfstep.setWfstepCreatedBy(sess.getAttribute("userId").toString());
		wfstep.setWfstepCreatedDate(createdDate);
		
		String msg = null;
		String res=null;
		String wfStepSave=null;

		Long duplicateId = 0l;

		try {
			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			
			// this method is used to check the Duplicates
			String sid=wfstep.getWfstepStageGUID();
			System.out.println("stagename"+sid);
			String stepName=wfstep.getWfstepName();
			
			duplicateId = wfstepService.duplicateWFStepCheck(sid,stepName);
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveRoleDetails this method is used to save Role Details

				msg = wfstepService.saveWFStepDetails(wfstep,sess.getAttribute("userId").toString(),sess.getAttribute("userName").toString());
				model.addAttribute("wfstepAdd", new WFStep());
				if (msg.equals("S")) {
                    
					
					res = "redirect:wfstepHome.mnt?list=" + "success" + "";
					

				} else {
				
					res = "redirect:wfstepHome.mnt?listwar=" + "fail" + "";
				}
			} else {

				request.setAttribute("WFStepDuplicate", "WFStep Name");
				wfstep.setAid(1);
				return "wfstepHome";
			}

			
		} catch (Exception e) {
			


			res = "redirect:wfstepHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
			
		}
		return res;

	}

	@ModelAttribute("StageSearchIds")
	public Map<String, String> populatewfstepSearchStageIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfstepService.selectStageIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				map.put((String) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("RolesSearchIds")
	public Map<String, String> populatewfstepSearchRoleIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfstepService.selectRoleIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				map.put((String) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfstepSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchWFStep(@ModelAttribute WFStep wfstepSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<WFStep> wfstepBean = new ArrayList<WFStep>();

		try {

			String dbField = wfstepSearch.getXmlLabel();
			String operation = wfstepSearch.getOperations();
			String basicSearchId = wfstepSearch.getBasicSearchId();

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
				list = wfstepService.searchWFStep();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFStep r = new WFStep();
					Object[] object = (Object[]) iterator.next();
					r.setWfstepid((String) object[0]);
					r.setWfstepStageGUID((String) object[1]);
					r.setWfstepStep((String) object[2]);
					r.setWfstepName((String) object[3]);
					r.setWfstepType((String) object[4]);
					r.setWfstepStatus((String) object[5]);
					r.setWfstepAssignedTo((String) object[6]);
					r.setWfstageName((String) object[7]);
					r.setRole((String) object[8]);

					wfstepBean.add(r);

				}
			} else {
				list = wfstepService.basicSearchWFStep(dbField, operation,
						basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFStep r = new WFStep();
					Object[] object = (Object[]) iterator.next();
					r.setWfstepid((String) object[0]);
					r.setWfstepStageGUID((String) object[1]);
					r.setWfstepStep((String) object[2]);
					r.setWfstepName((String) object[3]);
					r.setWfstepType((String) object[4]);
					r.setWfstepStatus((String) object[5]);
					r.setWfstepAssignedTo((String) object[6]);
					r.setWfstageName((String) object[7]);
					r.setRole((String) object[8]);

					wfstepBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("wfstepSearch", wfstepBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfstepAdd", wfstepSearch);

		return "wfstepHome";
	}

	
	@ModelAttribute("WFStepSearchNames")
	public Map<String, String> populatewfstepSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfstepService.selectWFStepNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				map.put((String) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfstepEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String wfstepEdit(@ModelAttribute WFStep wfstepDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String wfstepname = request.getParameter("wfstepDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<WFStep> wfstepsList = new ArrayList<WFStep>();

		try {

			list = wfstepService.searchWFStepWithId(wfstepname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				wfstepDisplay.setWfstepidEdit((String) object[0]);
				wfstepDisplay.setWfstepStageGUIDEdit((String) object[1]);
				wfstepDisplay.setWfstepStepEdit((String) object[2]);
				wfstepDisplay.setWfstepNameEdit((String) object[3]);
				wfstepDisplay.setWfstepTypeEdit((String) object[4]);
				wfstepDisplay.setWfstepStatusEdit((String) object[5]);
				wfstepDisplay.setWfstepAssignedToEdit((String) object[6]);
				wfstepDisplay.setWfstepCreatedByEdit((String) object[7]);
				wfstepDisplay.setWfstepCreatedDateEdit((String) object[8]);

				wfstepsList.add(wfstepDisplay);

			}
			request.setAttribute("wfstepValues", wfstepsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("wfstepAdd", wfstepDisplay);
		return "wfstepHome";
		/*
		 * return new
		 * ModelAndView("materialHome","materialAdd",materialDisplay);
		 */
	}

	@RequestMapping(value = "/wfstepUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateWFStep(@ModelAttribute("wfstepAdd") WFStep wfstep,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = wfstepService.updateDuplicateCheck(wfstep.getWfstepNameEdit(), wfstep.getWfstepidEdit(),wfstep.getWfstepStageGUIDEdit());

			if (duplicateId == 0) {
				wfstep.setWfstepid(wfstep.getWfstepidEdit());
				wfstep.setWfstepStageGUID(wfstep.getWfstepStageGUIDEdit());
				wfstep.setWfstepStatus(wfstep.getWfstepStatusEdit());
				wfstep.setWfstepStep(wfstep.getWfstepStepEdit());
				wfstep.setWfstepAssignedTo(wfstep.getWfstepAssignedToEdit());
				wfstep.setWfstepName(wfstep.getWfstepNameEdit());
				wfstep.setWfstepType(wfstep.getWfstepTypeEdit());
				wfstep.setWfstepCreatedBy(wfstep.getWfstepCreatedByEdit());
				wfstep.setWfstepCreatedDate(wfstep.getWfstepCreatedDateEdit());
				HttpSession sess = request.getSession();

				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String updatedDate = formatter.format(currentDate.getTime());

				wfstep.setWfstepUpdatedBy(sess.getAttribute("userId")
						.toString());

				wfstep.setWfstepUpdatedDate(updatedDate);

				String msg = wfstepService.updateWFStep(wfstep);

				if (msg.equals("S")) {
					request.setAttribute("wfstepUpadteSuccess",
							"Work Flow Step has been updated Successfully");
				} else {
					request.setAttribute("wfstepUpadteFail",
							"Work Flow Step has not been updated");
				}
			} else {
				request.setAttribute("wfstepEditDuplicate",
						"Name Already Exists");
				request.setAttribute("wfstepValues", "wfstepValues");
				return "wfstepHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfstepAdd", new WFStep());
		/* return new ModelAndView("Home","materialAdd",new Material()); */
		return "wfstepHome";

	}

	@RequestMapping(value = "/wfstepDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView wfStepDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wfstepid = null;

		try {
			wfstepid = request.getParameter("wfstepidDelete");
			String msg = wfstepService.wfstepDelete(wfstepid);
			
			if (msg.equals("S")) {
				sess=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(sess.getAttribute("userId").toString(),"D","Process Step","ROW" ,String.valueOf(wfstepid),"1",modifiedDate,sess.getAttribute("userName").toString());
				request.setAttribute("wfstepDeleteSuccess",
						"Work Flow Step has been deleted");
			} else {
				request.setAttribute("wfstepDeleteError",
						"Work Flow Step has not been deleted");
			}
		} catch (Exception e) {
			request.setAttribute("wfstepDeleteError",
					"Work Flow Step has not been deleted");
			e.printStackTrace();
			
		}
		return new ModelAndView("wfstepHome", "wfstepAdd", new WFStep());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "wfstepId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfstepAdvanceSearch", method = RequestMethod.GET)
	public String wfstepAdvanceSearch(
			@ModelAttribute("wfstepAdd") WFStep wfstep,
			HttpServletRequest request, HttpServletResponse response) {
		

		String name1 = "wfstepId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		
		wfstepList = new ArrayList();
		wfstep.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			// Iterator it=returnString.iterator();
			for (Object[] object : returnString) {
				WFStep v = new WFStep();

				s1 = (String) object[0];
				s2 = (String) object[1];

				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				wfstepList.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("wfstepSearchAdvance", wfstepList);

		return "wfstepHome";
	}

	@RequestMapping(value = "/wfstepAdvanceSearchOperations", method = RequestMethod.POST)
	public String wfstepAdvanceSearchOperations(@ModelAttribute WFStep wfstep,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		wfstep1 = new ArrayList<WFStep>();
		String columns = wfstep.getFirstLabel();
		String operations = wfstep.getOperations1();
		String advanceSearchText = wfstep.getAdvanceSearchText();
		// System.out.println("advanceSearchText"+advanceSearchText);
		// System.out.println("First Labels "+name);
		// System.out.println("kiran u selected"+name);
		if (advanceSearchText.length() != 0) {
			// System.out.println("came to advance"+advanceSearchText.length());
			objectsArray = wfstepService.getWFStepAdvance(columns, operations,
					advanceSearchText);
		} else {
			objectsArray = wfstepService.searchWFStep();
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.WFStep();
			objects2 = (Object[]) iterator.next();
			mm.setWfstepid((String) objects2[0]);
			mm.setWfstepStageGUID((String) objects2[1]);
			mm.setWfstepStep((String) objects2[2]);
			mm.setWfstepName((String) objects2[3]);
			mm.setWfstepType((String) objects2[4]);
			mm.setWfstepStatus((String) objects2[5]);
			mm.setWfstepAssignedTo((String) objects2[6]);
			mm.setWfstageName((String) objects2[7]);
			mm.setRole((String) objects2[8]);

			/*
			 * String blocked=(String)objects2[13]; if(blocked.equals("0")) {
			 * blocked="YES"; } else { blocked="NO"; }
			 */

			wfstep1.add(mm);
			// System.out.println((String)objects2[0]);
		}

		/*
		 * ModelAndView model=new ModelAndView();
		 * model.setViewName("BomCategorySearch");
		 * model.addObject("searchBom",BomCategory); return model;
		 */

		// return new ModelAndView("MaterialCategorySearch");

		request.setAttribute("wfstepSearch", wfstep1);
		model.addAttribute("wfstepAdd", new WFStep());

		return "wfstepHome";
	}

}
