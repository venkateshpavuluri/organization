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

import com.mnt.erp.bean.WFProcess;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.WFProcessService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * 
 */
@Controller
public class WFProcessController {
	@Autowired
	WFProcessService wfprocessService;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	HttpSession session;

	@RequestMapping(value = "/wfprocessHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView wfprocessType(
			@ModelAttribute("wfprocessAdd") WFProcess wfprocess,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("wfprocessHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("wfprocessHome", "wfprocessAdd",
				new WFProcess());
	}

	@RequestMapping(value = "/wfprocessAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveWFProcessDetails(
			@ModelAttribute("wfprocessAdd") @Valid WFProcess wfprocess,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {

		String msa = null;

		String url = null;
		String sucmsg = null;
		Long duplicateId = 0l;

		try {
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				wfprocess.setAid(1);
				return "wfprocessHome";
			}
			duplicateId = wfprocessService.duplicateWFProcessCheck(wfprocess
					.getWfprocessName());
			if (duplicateId == 0) {

				session = request.getSession(false);
				msa = wfprocessService.saveWFProcessDetails(wfprocess, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());

				model.addAttribute("wfprocessAdd", new WFProcess());
				if (msa.equals("S")) {

					url = "redirect:wfprocessHome.mnt?list=" + "success" + "";
					model.addAttribute("wfprocessAdd", wfprocess);
				} else {

					url = "redirect:wfprocessHome.mnt?listwar=" + "fail" + "";
				}
			} else {
				request.setAttribute("WFProcessDuplicate", "WFProcess Name '"
						+ wfprocess.getWfprocessName() + "' Already exist");
				wfprocess.setAid(1);
				return "wfprocessHome";
			}

		} catch (Exception e) {
			e.printStackTrace();

			sucmsg = "process";
			url = "redirect:wfprocessHome.mnt?listwar=" + "fail" + "";

		}
		model.addAttribute("wfprocessAdd", wfprocess);
		return url;

	}

	@RequestMapping(value = "/wfprocessSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchWFProcess(@ModelAttribute WFProcess wfprocessSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<WFProcess> wfprocessBean = new ArrayList<WFProcess>();

		try {

			String dbField = wfprocessSearch.getXmlLabel();
			String operation = wfprocessSearch.getOperations();
			String basicSearchId = wfprocessSearch.getBasicSearchId();

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
				list = wfprocessService.searchWFProcess();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFProcess r = new WFProcess();
					Object[] obj = (Object[]) iterator.next();
					r.setWfprocessId((String) obj[0]);
					r.setWfprocessName((String) obj[1]);
					r.setWfprocessVersionNo((String) obj[2]);

					wfprocessBean.add(r);

				}
			} else {
				list = wfprocessService.basicSearchWFProcess(dbField,
						operation, basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WFProcess r = new WFProcess();
					Object[] obj = (Object[]) iterator.next();
					r.setWfprocessId((String) obj[0]);
					r.setWfprocessName((String) obj[1]);
					r.setWfprocessVersionNo((String) obj[2]);

					wfprocessBean.add(r);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("wfprocessSearch", wfprocessBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfprocessAdd", wfprocessSearch);

		return "wfprocessHome";
	}

	@ModelAttribute("WFProcessSearchNames")
	public Map<String, String> populatewfprocessSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = wfprocessService.selectWFProcessNames();
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

	@RequestMapping(value = "/wfprocessEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String wfprocessEdit(@ModelAttribute WFProcess wfprocessDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String wfprocessname = request.getParameter("wfprocessDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<WFProcess> wfprocesssList = new ArrayList<WFProcess>();

		try {

			list = wfprocessService.searchWFProcessWithId(wfprocessname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				wfprocessDisplay.setWfprocessIdEdit((String) object[0]);
				wfprocessDisplay.setWfprocessNameEdit((String) object[1]);
				wfprocessDisplay.setWfprocessVersionNoEdit((String) object[2]);

				wfprocesssList.add(wfprocessDisplay);

			}
			request.setAttribute("wfprocessValues", wfprocesssList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("wfprocessAdd", wfprocessDisplay);
		return "wfprocessHome";
	}

	@RequestMapping(value = "/wfprocessUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateWFProcess(
			@ModelAttribute("wfprocessAdd") WFProcess wfprocess,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = wfprocessService.updateDuplicateCheck(
					wfprocess.getWfprocessNameEdit(),
					wfprocess.getWfprocessIdEdit());

			if (duplicateId == 0) {
				wfprocess.setWfprocessId(wfprocess.getWfprocessIdEdit());
				wfprocess.setWfprocessName(wfprocess.getWfprocessNameEdit());
				wfprocess.setWfprocessVersionNo(wfprocess
						.getWfprocessVersionNoEdit());

				String msg = wfprocessService.updateWFProcess(wfprocess);

				if (msg.equals("S")) {
					request.setAttribute("wfprocessUpadteSuccess",
							"WFProcess Details Updated Successfully");
				} else {
					request.setAttribute("wfprocessUpadteFail",
							"WFProcess Details Did Not Updated");
				}
			} else {
				request.setAttribute("wfprocessEditDuplicate",
						"WFProcess Name Already Exists");
				request.setAttribute("wfprocessValues", "hello");
				return "wfprocessHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("wfprocessAdd", new WFProcess());
		return "wfprocessHome";

	}

	@RequestMapping(value = "/wfprocessDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView wfProcessDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wfprocessid = null;

		String delmsg1 = null;
		String delmsg2 = null;
		try {
			wfprocessid = request.getParameter("wfprocessidDelete");
			String msg = wfprocessService.wfprocessDelete(wfprocessid);

			if (msg.equals("S")) {

				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Bussiness Process", "ROW", String
						.valueOf(wfprocessid), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("wfprocessDeleteSuccess",
						"WFProcess Deleted Successfully");
			} else {
				request.setAttribute("wfprocessDeleteFail", "wfprocess "
						+ delmsg2 + " Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("wfprocessDeleteFail", "wfprocess " + delmsg2
					+ " Did Not Deleted");
		}
		return new ModelAndView("wfprocessHome", "wfprocessAdd",
				new WFProcess());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "wfprocessId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
