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

import com.mnt.erp.bean.WAction;
import com.mnt.erp.bean.WFAction;
import com.mnt.erp.bean.WFStage;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.WFActionService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * 
 */
@Controller
public class WFActionController {
	@Autowired
	WFActionService wfactionService;
	@Autowired
	MenuService menuService;

	@Autowired
	XmlLabelsService xmlService;
	List<WFAction> wfactionList = null;
	List<WFAction> wfaction1 = null;
	List<Object[]> objectsArray = null;
	Iterator<Object[]> iterator = null;
	Object[] objects2 = null;
	WFAction mm = null;

	@Autowired
	AuditLogService auditLogService;
	HttpSession sess;

	@RequestMapping(value = "/wfactionHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView wfactionType(
			@ModelAttribute("wfactionAdd") WFAction wfaction,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("wfactionHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("wfactionHome", "wfactionAdd", new WFAction());
	}

	@RequestMapping(value = "/wfactionAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveWFActionDetails(
			@ModelAttribute("wfactionAdd") @Valid WFAction wfaction,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		sess = request.getSession();
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String createdDate = formatter.format(currentDate.getTime());
		wfaction.setWfactionCreatedBy(sess.getAttribute("userId").toString());
		wfaction.setWfactionCreateddate(createdDate);
	
		String msa = null;
		String res = null;
		String wfActionSave = null;
		Long duplicateId = 0l;

		try {

			// this method is used to check the Duplicates
			duplicateId = wfactionService.duplicateWFActionCheck(
					wfaction.getWfactionName(), wfaction.getWfactionStepGUID());
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveWFActionDetails this method is used to save WFAction
				// Details

				msa = wfactionService.saveWFActionDetails(wfaction, sess
						.getAttribute("userId").toString(),
						sess.getAttribute("userName").toString());
				model.addAttribute("wfactionAdd", new WFAction());
				if (msa.equals("S")) {
					
					res = "redirect:wfactionHome.mnt?list=" +"success" + "";

				} else {
				
					res = "redirect:wfactionHome.mnt?listwar=" +"fail"+ "";

				}
			} else {

				request.setAttribute(
						"WFActionDuplicate",
						"Warning ! Step Name or Action Name is already exists. Please try some other name");
				wfaction.setAid(1);
				return "wfactionHome";
			}

		} catch (Exception e) {
		
			res = "redirect:wfactionHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();

		}
		return res;
	}

	@ModelAttribute("StepSearchIds")
	public Map<String, String> populatewfstepSearchStageIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfactionService.selectStepIds();
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
	@ModelAttribute("WfActions")
	public Map<Integer, String> populatewfActionIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = null;
		try {
			listvalues = wfactionService.selectActionIds();
			map = new HashMap<Integer, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfactionSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchWFAction(@ModelAttribute WFAction wfactionSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<WFAction> wfactionBean = new ArrayList<WFAction>();

		try {

			String dbField = wfactionSearch.getXmlLabel();
			String operation = wfactionSearch.getOperations();
			String basicSearchId = wfactionSearch.getBasicSearchId();

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
				list = wfactionService.searchWFAction();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFAction r = new WFAction();
					Object[] object = (Object[]) iterator.next();
					r.setWfactionId((String) object[0]);
					r.setWfactionStepGUID((String) object[1]);
					r.setWfactionAction((String) object[2]);
					WAction waction=(WAction)object[3];
					r.setWfactionName(waction.getwAction());
					r.setWfactionType((String) object[4]);
					r.setWfactionCondition((String) object[5]);
					r.setWfactionDirection((String) object[6]);
					r.setWfactionGotoStep((String) object[7]);
					r.setWfactionEmail((String) object[8]);
					r.setWfactionComments((String) object[9]);
					r.setWfactionMessage((String) object[10]);
					r.setWfactionMessageDetails((String) object[11]);
					r.setWfstepName((String) object[12]);

					wfactionBean.add(r);

				}
			} else {
				list = wfactionService.basicSearchWFAction(dbField, operation,
						basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFAction r = new WFAction();
					Object[] object = (Object[]) iterator.next();
					r.setWfactionId((String) object[0]);
					r.setWfactionStepGUID((String) object[1]);
					r.setWfactionAction((String) object[2]);
					WAction waction=(WAction)object[3];
					r.setWfactionName(waction.getwAction());
					r.setWfactionType((String) object[4]);
					r.setWfactionCondition((String) object[5]);
					r.setWfactionDirection((String) object[6]);
					r.setWfactionGotoStep((String) object[7]);
					r.setWfactionEmail((String) object[8]);
					r.setWfactionComments((String) object[9]);
					r.setWfactionMessage((String) object[10]);
					r.setWfactionMessageDetails((String) object[11]);
					r.setWfstepName((String) object[12]);

					wfactionBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("wfactionSearch", wfactionBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfactionAdd", wfactionSearch);

		return "wfactionHome";
	}

	@ModelAttribute("WFActionSearchNames")
	public Map<String, String> populatewfactionSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfactionService.selectWFActionNames();
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

	@RequestMapping(value = "/wfactionEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String wfactionEdit(@ModelAttribute WFAction wfactionDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String wfactionname = request.getParameter("wfactionDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<WFAction> wfactionsList = new ArrayList<WFAction>();

		try {

			list = wfactionService.searchWFActionWithId(wfactionname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				wfactionDisplay.setWfactionIdEdit((String) object[0]);
				wfactionDisplay.setWfactionStepGUIDEdit((String) object[1]);
				wfactionDisplay.setWfactionActionEdit((String) object[2]);
				wfactionDisplay.setwActionIdEdit((String) object[3]);
				wfactionDisplay.setWfactionTypeEdit((String) object[4]);
				wfactionDisplay.setWfactionConditionEdit((String) object[5]);
				wfactionDisplay.setWfactionDirectionEdit((String) object[6]);
				wfactionDisplay.setWfactionGotoStepEdit((String) object[7]);
				wfactionDisplay.setWfactionEmailEdit((String) object[8]);
				wfactionDisplay.setWfactionCommentsEdit((String) object[9]);
				wfactionDisplay.setWfactionMessageEdit((String) object[10]);
				wfactionDisplay
						.setWfactionMessageDetailsEdit((String) object[11]);
				wfactionDisplay.setWfactionCreatedByEdit((String) object[12]);
				wfactionDisplay.setWfactionCreateddateEdit((String) object[13]);
				wfactionsList.add(wfactionDisplay);

			}
			request.setAttribute("wfactionValues", wfactionsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("wfactionAdd", wfactionDisplay);
		return "wfactionHome";

	}

	@RequestMapping(value = "/wfactionUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateWFAction(
			@ModelAttribute("wfactionAdd") WFAction wfaction,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {

			duplicateId = wfactionService.updateDuplicateCheck(
					wfaction.getWfactionNameEdit(),
					wfaction.getWfactionStepGUIDEdit(),

					wfaction.getWfactionIdEdit());

			if (duplicateId == 0) {
				wfaction.setWfactionId(wfaction.getWfactionIdEdit());
				wfaction.setWfactionStepGUID(wfaction.getWfactionStepGUIDEdit());
				wfaction.setWfactionAction(wfaction.getWfactionActionEdit());
				wfaction.setwActionId(wfaction.getwActionIdEdit());
				wfaction.setWfactionType(wfaction.getWfactionTypeEdit());
				wfaction.setWfactionCondition(wfaction
						.getWfactionConditionEdit());
				wfaction.setWfactionDirection(wfaction
						.getWfactionDirectionEdit());
				wfaction.setWfactionGotoStep(wfaction.getWfactionGotoStepEdit());
				wfaction.setWfactionEmail(wfaction.getWfactionEmailEdit());

				wfaction.setWfactionComments(wfaction.getWfactionCommentsEdit());
				wfaction.setWfactionMessage(wfaction.getWfactionMessageEdit());

				wfaction.setWfactionMessageDetails(wfaction
						.getWfactionMessageDetailsEdit());
				wfaction.setWfactionCreatedBy(wfaction
						.getWfactionCreatedByEdit());
				wfaction.setWfactionCreateddate(wfaction
						.getWfactionCreateddateEdit());
				HttpSession sess = request.getSession();

				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String updatedDate = formatter.format(currentDate.getTime());
				wfaction.setWfactionUpdatedBy(sess.getAttribute("userId")
						.toString());

				wfaction.setWfactionupdateDate(updatedDate);

				String msg = wfactionService.updateWFAction(wfaction);

				if (msg.equals("S")) {
					request.setAttribute("wfactionUpadteSuccess",
							"Work Flow Action has been updated successfully");
				} else {
					request.setAttribute("wfactionUpadteError",
							"Work Flow Action has not been updated");
				}
			} else {
				request.setAttribute(
						"wfactionEditDuplicate",
						"Warning ! Step Name or Action Name is already exists. Please try some other name");
				request.setAttribute("wfactionValues", "wfactionValues");
				return "wfactionHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfactionAdd", new WFAction());

		return "wfactionHome";

	}

	@RequestMapping(value = "/wfactionDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView actionDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wfactionid = null;

		try {
			wfactionid = request.getParameter("wfactionidDelete");
			String msg = wfactionService.wfactionDelete(wfactionid);

			if (msg.equals("S")) {
				sess = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(sess.getAttribute("userId")
						.toString(), "D", "Process Action", "ROW", String
						.valueOf(wfactionid), "1", modifiedDate, sess
						.getAttribute("userName").toString());

				request.setAttribute("wfActionDeleteSuccess",
						"Work Flow Action has been deleted");
			} else {
				request.setAttribute("wfActionDeleteError",
						"Work Flow Action has not been deleted");
			}
		} catch (Exception e) {
			request.setAttribute("wfActionDeleteError",
					"Work Flow Action has not been deleted");
			e.printStackTrace();
			
		}
		return new ModelAndView("wfactionHome", "wfactionAdd", new WFAction());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "wfactionId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfactionAdvanceSearch", method = RequestMethod.GET)
	public String wfactionAdvanceSearch(
			@ModelAttribute("wfactionAdd") WFAction wfaction,
			HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("came to search");
		// String
		// advanceSearchHidden=request.getParameter("advanceSearchHidden");

		String name1 = "wfactionId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// WFAction v=null;
		wfactionList = new ArrayList();
		wfaction.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			// Iterator it=returnString.iterator();
			for (Object[] object : returnString) {
				WFAction v = new WFAction();

				s1 = (String) object[0];
				s2 = (String) object[1];

				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				wfactionList.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("wfactionSearchAdvance", wfactionList);

		return "wfactionHome";
	}

	@RequestMapping(value = "/wfactionAdvanceSearchOperations", method = RequestMethod.POST)
	public String wfactionAdvanceSearchOperations(
			@ModelAttribute WFAction wfaction, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		wfaction1 = new ArrayList<WFAction>();
		String columns = wfaction.getFirstLabel();
		String operations = wfaction.getOperations1();
		String advanceSearchText = wfaction.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = wfactionService.getWFActionAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = wfactionService.searchWFAction();
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.WFAction();
			objects2 = (Object[]) iterator.next();
			mm.setWfactionId((String) objects2[0]);
			mm.setWfactionStepGUID((String) objects2[1]);
			mm.setWfactionAction((String) objects2[2]);
			mm.setWfactionName((String) objects2[3]);
			mm.setWfactionType((String) objects2[4]);
			mm.setWfactionCondition((String) objects2[5]);
			mm.setWfactionDirection((String) objects2[6]);
			mm.setWfactionGotoStep((String) objects2[7]);
			mm.setWfactionEmail((String) objects2[8]);
			mm.setWfactionComments((String) objects2[9]);
			mm.setWfactionMessage((String) objects2[10]);
			mm.setWfactionMessageDetails((String) objects2[11]);
			mm.setWfstepName((String) objects2[12]);

			/*
			 * String blocked=(String)objects2[13]; if(blocked.equals("0")) {
			 * blocked="YES"; } else { blocked="NO"; }
			 */

			wfaction1.add(mm);

		}

		/*
		 * ModelAndView model=new ModelAndView();
		 * model.setViewName("BomCategorySearch");
		 * model.addObject("searchBom",BomCategory); return model;
		 */

		// return new ModelAndView("MaterialCategorySearch");

		request.setAttribute("wfactionSearch", wfaction1);
		model.addAttribute("wfactionAdd", new WFAction());

		return "wfactionHome";
	}
}
