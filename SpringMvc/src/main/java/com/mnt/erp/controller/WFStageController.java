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
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.WFStageService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * 
 */
@Controller
public class WFStageController {
	@Autowired
	WFStageService wfstageService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	HttpSession session;

	List<WFStage> wfstageList = null;
	List<WFStage> wfstage1 = null;
	List<Object[]> objectsArray = null;
	Iterator<Object[]> iterator = null;
	Object[] objects2 = null;
	WFStage mm = null;

	@RequestMapping(value = "/wfstageHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView wfstageType(
			@ModelAttribute("wfstageAdd") WFStage wfstage,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("wfstageHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("wfstageHome", "wfstageAdd", new WFStage());
	}

	@RequestMapping(value = "/wfstageAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveWFStageDetails(
			@ModelAttribute("wfstageAdd") @Valid WFStage wfstage,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		HttpSession sess = request.getSession();
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String createdDate = formatter.format(currentDate.getTime());

		wfstage.setWfstageCreatedDate(createdDate.toString());
		wfstage.setWfstageCreatedBy(sess.getAttribute("userId").toString());

		String wfStageSave = null;
		String msa = null;
		Long duplicateId = 0l;
		String res = null;

		try {

			// this method is used to check the Duplicates
			duplicateId = wfstageService.duplicateWFStageCheck(wfstage
					.getWfstageName());
			if (duplicateId == 0) {

				msa = wfstageService.saveWFStageDetails(wfstage, sess
						.getAttribute("userId").toString(),
						sess.getAttribute("userName").toString());

				if (msa.equals("S")) {
					wfStageSave = "Work Flow Stage has been saved successfully";

					res = "redirect:wfstageHome.mnt?list=" + "success" + "";

				}

				else {
					wfStageSave = "Work Flow Stage has not been saved properly";

					res = "redirect:wfstageHome.mnt?listwar=" + "fail" + "";
				}
			} else {
				request.setAttribute("WFStageDuplicate", "Name Already exist");
				wfstage.setAid(1);
				return "wfstageHome";
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return res;
	}

	@ModelAttribute("ProcessSearchIds")
	public Map<String, String> populatewfstageSearchIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfstageService.selectProcessIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				map.put((String) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfstageSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchWFStage(@ModelAttribute WFStage wfstageSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<WFStage> wfstageBean = new ArrayList<WFStage>();

		try {

			String dbField = wfstageSearch.getXmlLabel();
			String operation = wfstageSearch.getOperations();
			String basicSearchId = wfstageSearch.getBasicSearchId();

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
				list = wfstageService.searchWFStage();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFStage r = new WFStage();

					Object[] object = (Object[]) iterator.next();
					r.setWfstageId((String) object[0]);
					r.setWfstageProcessGUID((String) object[1]);
					r.setWfstageStage((String) object[2]);
					r.setWfstageName((String) object[3]);
					r.setWfstageDescription((String) object[4]);
					r.setWfstageType((String) object[5]);
					r.setWfprocessname((String) object[6]);

					wfstageBean.add(r);

				}
			} else {
				list = wfstageService.basicSearchWFStage(dbField, operation,
						basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFStage r = new WFStage();
					Object[] object = (Object[]) iterator.next();
					r.setWfstageId((String) object[0]);
					r.setWfstageProcessGUID((String) object[1]);
					r.setWfstageStage((String) object[2]);
					r.setWfstageName((String) object[3]);
					r.setWfstageDescription((String) object[4]);
					r.setWfstageType((String) object[5]);
					r.setWfprocessname((String) object[6]);

					wfstageBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("wfstageSearch", wfstageBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfstageAdd", wfstageSearch);

		return "wfstageHome";
	}

	@ModelAttribute("WFStageSearchNames")
	public Map<String, String> populatewfstageSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfstageService.selectWFStageNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				map.put((String) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfstageEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String wfstageEdit(@ModelAttribute WFStage wfstageDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String wfstagename = request.getParameter("wfstageDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<WFStage> wfstagesList = new ArrayList<WFStage>();

		try {

			list = wfstageService.searchWFStageWithId(wfstagename);

			Iterator<Object[]> iterator = list.iterator();

			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();

				wfstageDisplay.setWfstageIdEdit((String) object[0]);
				wfstageDisplay.setWfstageProcessGUIDEdit((String) object[1]);
				wfstageDisplay.setWfstageStageEdit((String) object[2]);
				wfstageDisplay.setWfstageNameEdit((String) object[3]);
				wfstageDisplay.setWfstageDescriptionEdit((String) object[4]);
				wfstageDisplay.setWfstageTypeEdit((String) object[5]);
				wfstageDisplay.setWfstageCreatedByEdit((String) object[6]);
				wfstageDisplay.setWfstageCreatedDateEdit((String) object[7]);

				wfstagesList.add(wfstageDisplay);

			}
			request.setAttribute("wfstageValues", wfstagesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("wfstageAdd", wfstageDisplay);
		return "wfstageHome";

	}

	@RequestMapping(value = "/wfstageUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateWFStage(@ModelAttribute("wfstageAdd") WFStage wfstage,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = wfstageService.updateDuplicateCheck(
					wfstage.getWfstageNameEdit(), wfstage.getWfstageIdEdit());

			if (duplicateId == 0) {
				wfstage.setWfstageId(wfstage.getWfstageIdEdit());
				wfstage.setWfstageProcessGUID(wfstage
						.getWfstageProcessGUIDEdit());
				wfstage.setWfstageStage(wfstage.getWfstageStageEdit());
				wfstage.setWfstageName(wfstage.getWfstageNameEdit());
				wfstage.setWfstageDescription(wfstage
						.getWfstageDescriptionEdit());
				wfstage.setWfstageType(wfstage.getWfstageTypeEdit());
				wfstage.setWfstageCreatedBy(wfstage.getWfstageCreatedByEdit());
				wfstage.setWfstageCreatedDate(wfstage
						.getWfstageCreatedDateEdit());

				HttpSession sess = request.getSession();
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String updatedDate = formatter.format(currentDate.getTime());

				wfstage.setWfstageUpdatedDate(updatedDate);

				wfstage.setWfstageUpdatedBy(sess.getAttribute("userId")
						.toString());

				String msg = wfstageService.updateWFStage(wfstage);

				if (msg.equals("S")) {
					request.setAttribute("wfstageUpadteSuccess",
							"WFStage Details Updated Successfully");
				} else {

					request.setAttribute("wfstageUpadteFail",
							"WFStage Details has not Updated");

				}
			} else {
				request.setAttribute("wfstageEditDuplicate",
						"WFStage Name Already exist");
				request.setAttribute("wfstageValues", "hello");
				return "wfstageHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfstageAdd", new WFStage());

		return "wfstageHome";

	}

	@RequestMapping(value = "/wfstageDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView stageDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wfstageid = null;

		try {
			wfstageid = request.getParameter("wfstageidDelete");
			String msg = wfstageService.wfstageDelete(wfstageid);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Process Stage", "ROW", String
						.valueOf(wfstageid), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("wfstageDelete",
						"WFStage has been deleted Successfully");
			} else {
				request.setAttribute("wfstageDeleteError",
						"WFStage has not been Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ModelAndView("wfstageHome", "wfstageAdd", new WFStage());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "wfstageId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/wfstageAdvanceSearch", method = RequestMethod.GET)
	public String wfstageAdvanceSearch(
			@ModelAttribute("wfstageAdd") WFStage wfstage,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "wfstageId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		wfstageList = new ArrayList();
		wfstage.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			for (Object[] object : returnString) {
				WFStage v = new WFStage();

				s1 = (String) object[0];
				s2 = (String) object[1];

				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				wfstageList.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("wfstageSearchAdvance", wfstageList);

		return "wfstageHome";
	}

	@RequestMapping(value = "/wfstageAdvanceSearchOperations", method = RequestMethod.POST)
	public String wfstageAdvanceSearchOperations(
			@ModelAttribute WFStage wfstage, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		wfstage1 = new ArrayList<WFStage>();
		String columns = wfstage.getFirstLabel();
		String operations = wfstage.getOperations1();
		String advanceSearchText = wfstage.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = wfstageService.getWFStageAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = wfstageService.searchWFStage();
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.WFStage();
			objects2 = (Object[]) iterator.next();
			mm.setWfstageId((String) objects2[0]);
			mm.setWfstageProcessGUID((String) objects2[1]);
			mm.setWfstageStage((String) objects2[2]);
			mm.setWfstageName((String) objects2[3]);
			mm.setWfstageDescription((String) objects2[4]);
			mm.setWfstageType((String) objects2[5]);
			mm.setWfprocessname((String) objects2[6]);

			wfstage1.add(mm);
		}

		request.setAttribute("wfstageSearch", wfstage1);
		model.addAttribute("wfstageAdd", new WFStage());

		return "wfstageHome";
	}
}
