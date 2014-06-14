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

import com.mnt.erp.bean.Status;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author ybusireddy
 * @version 23-09-2013
 */

@Controller
public class StatusController {

	@Autowired
	StatusService statusService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	HttpSession  session;
	@RequestMapping(value = "/statusHome", method = RequestMethod.GET)
	@RequestScoped
	public String getStatusHome(@ModelAttribute Status status1,
			SessionStatus status, HttpServletResponse response, Model model,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("statusHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("status", status1);
		return "statusHome";
	}

	@RequestMapping(value = "/addStatus", method = RequestMethod.POST)
	@RequestScoped
	public String saveStatus(@ModelAttribute Status status1,
			SessionStatus status, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String ss = null;
		String statusSave = null;

		String getstatus = status1.getStatus();
		int checkStatus = statusService.checkStatus(getstatus);

		if (checkStatus == 0) {
			try {
				session=request.getSession(false);
				ss = statusService.saveStatusDetails(status1,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if (ss.equals("StatusSuccess")) {
					statusSave = "StatusDetails Saved Successfully";
				} else {
					statusSave = "StatusDetails Insertion Failed";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:statusHome.mnt?addStatusSuccess=" + statusSave
					+ "";
		} else {

			request.setAttribute("addStatusDuplicate",
					"Status Already Exists Choose Another One");
			status1.setAid(1);
			return "statusHome";
		}

	}

	@ModelAttribute("statusSelect")
	public Map<Integer, String> getStatus() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = statusService.selectStatusId();
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

	@RequestMapping(value = "/searchStatus", method = RequestMethod.GET)
	@RequestScoped
	public String searchStatus(@ModelAttribute Status status1,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;
		int searchStatusId = status1.getStatusId();
		List<Status> statusSearch = new ArrayList<Status>();
		String dbField = status1.getXmlLabel();
		String operation = status1.getOperations();
		String basicSearchId = status1.getBasicSearchId();

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

			try {
				list = statusService.searchStatus();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Status status2 = new Status();
					Object[] objs = (Object[]) iterator.next();
					status2.setStatusId((Integer) objs[0]);
					status2.setStatus((String) objs[1]);
					statusSearch.add(status2);
				}

				request.setAttribute("statusSearch", statusSearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "statusHome";
		} else {

			try {
				statusSearch = new ArrayList<Status>();
				list = statusService.basicSearchStatus(dbField, operation,
						basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Status status2 = new Status();
					Object[] objs = (Object[]) iterator.next();
					status2.setStatusId((Integer) objs[0]);
					status2.setStatus((String) objs[1]);
					statusSearch.add(status2);
				}
				request.setAttribute("statusSearch", statusSearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "statusHome";

		}
	}

	@RequestMapping(value = "/statusEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String statusEdit(@ModelAttribute Status statusDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("statusIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<Status> statusList = new ArrayList<Status>();

		try {

			list = statusService.searchStatusWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				statusDisplay.setStatusIdEdit((Integer) object[0]);
				statusDisplay.setStatusEdit((String) object[1]);
				statusList.add(statusDisplay);
			}
			request.setAttribute("statusValues", statusList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "statusHome";

	}

	@RequestMapping(value = "/statusUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateStatus(@ModelAttribute Status status1,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String ss = null;
		String statusUpdate = null;

		int statusId = status1.getStatusIdEdit();
		String stutusEdit = status1.getStatusEdit();

		status1.setStatusId(statusId);
		status1.setStatus(stutusEdit);
		int checkStatus = statusService.updateCheckStatus(stutusEdit, statusId);
		if (checkStatus == 0) {
			try {
				ss = statusService.updateStatus(status1);
				if (ss.equals("StatusUpdateSuccess")) {
					statusUpdate = "Status Details Updated Successfully";
				} else {
					statusUpdate = "Status Details Updation Failed";
				}

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateStatusDuplicate",
					"Status Already Exists Choose Another One");
			request.setAttribute("statusValues", "statusList");
			return "statusHome";
		}
		return "redirect:statusHome.mnt?statusUpdate=" + statusUpdate + "";
	}

	@RequestMapping(value = "/statusDelete", method = RequestMethod.GET)
	@RequestScoped
	public String deleteStatus(@ModelAttribute Status status1,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request,HttpServletResponse response, SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("statusIdDelete"));
		String ss = null;
		try {
			ss = statusService.deleteStatus(id);
			if(ss.equals("Status Details Deleted Successfully"))
			{
			session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Status","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:statusHome.mnt?statusDelete=" + ss + "";

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "statusId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
