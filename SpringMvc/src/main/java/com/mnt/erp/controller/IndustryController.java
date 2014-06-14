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
import com.mnt.erp.bean.Industry;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.IndustryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author ybusireddy
 * @version 19-09-2013
 */

@Controller
public class IndustryController {
	@Autowired
	IndustryService industryService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	MenuService menuService;
	
	HttpSession session;

	@RequestMapping(value = "/industryHome", method = RequestMethod.GET)
	@RequestScoped
	public String getIndustryHome(@ModelAttribute Industry industry1,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("industryHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		
		model.addAttribute("industry", industry1);
		return "industryHome";
	}

	@RequestMapping(value = "/addIndustry", method = RequestMethod.POST)
	@RequestScoped
	public String saveIndustry(@ModelAttribute Industry industry,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String isa = null;
		String industrySave = null;

		String industryType = industry.getIndustryType();
		int checkType = industryService.checkIndustryType(industryType);
		if (checkType == 0) {
			try {
				session=request.getSession(false);
				isa = industryService.saveIndustryDetails(industry,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				status.setComplete();

				if (isa.equals("IndustrySuccess")) {
					
					industrySave = "IndustryDetails Saved Successfully";
				} else {
					industrySave = "IndustryDetails Insertion Failed";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:industryHome.mnt?addIndustrySuccess="
					+ industrySave + "";
		} else {
			request.setAttribute("addIndustryDuplicate",
					"IndustryType Already Existed Choose Another One");
			industry.setAid(1);
			return "industryHome";
		}
	}

	@ModelAttribute("industryType")
	public Map<Integer, String> getIndustryType() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = industryService.selectIndustryId();
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

	@RequestMapping(value = "/searchIndustry", method = RequestMethod.GET)
	@RequestScoped
	public String searchIndustryType(@ModelAttribute Industry industry,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;
		int searchIndustryTypeId = industry.getIndustryTypeId();
		List<Industry> industrySearch = null;
		String dbField = industry.getXmlLabel();
		String operation = industry.getOperations();
		String basicSearchId = industry.getBasicSearchId();

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
				industrySearch = new ArrayList<Industry>();
				// list =
				// industryService.searchIndustryWithId(searchIndustryTypeId);
				list = industryService.basicSearchIndustryType(dbField,
						operation, basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Industry industry2 = new Industry();
					Object[] objs = (Object[]) iterator.next();
					industry2.setIndustryTypeId((Integer) objs[0]);
					industry2.setIndustryType((String) objs[1]);
					industrySearch.add(industry2);
				}

				request.setAttribute("industrySearch", industrySearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "industryHome";
		} else {

			try {
				industrySearch = new ArrayList<Industry>();
				list = industryService.searchIndustry();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Industry industry2 = new Industry();
					Object[] objs = (Object[]) iterator.next();
					industry2.setIndustryTypeId((Integer) objs[0]);
					industry2.setIndustryType((String) objs[1]);
					industrySearch.add(industry2);
				}
				request.setAttribute("industrySearch", industrySearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "industryHome";

		}
	}

	@RequestMapping(value = "/industryEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String industryEdit(@ModelAttribute Industry industryDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("industryTypeIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<Industry> industryList = new ArrayList<Industry>();

		try {

			list = industryService.searchIndustryWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				industryDisplay.setIndustryTypeIdEdit((Integer) object[0]);
				industryDisplay.setIndustryTypeEdit((String) object[1]);
				industryList.add(industryDisplay);
			}
			request.setAttribute("industryValues", industryList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "industryHome";

	}

	@RequestMapping(value = "/industryUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateIndustry(@ModelAttribute Industry industry,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		String isa = null;
		String industryUpdate = null;
		int industryTypeId = industry.getIndustryTypeIdEdit();
		String industryType = industry.getIndustryTypeEdit();

		industry.setIndustryTypeId(industryTypeId);
		industry.setIndustryType(industryType);
		int indCheck = industryService.updateCheckIndustryType(industryType,
				industryTypeId);
		if (indCheck == 0) {
			try {
				isa = industryService.updateIndustry(industry);
				industryUpdate = "Industry Details Updated Successfully";
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateIndustryDuplicate",
					"IndustryType Already Existed Choose Another One");
			request.setAttribute("industryValues", "industryList");
			return "industryHome";
		}

		return "redirect:industryHome.mnt?industryUpdate=" + industryUpdate
				+ "";

	}

	@RequestMapping(value = "/industryDelete", method = RequestMethod.GET)
	@RequestScoped
	public String deleteIndustry(@ModelAttribute Industry industry,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("industryTypeIdDelete"));
		String isa = null;
		try {
			isa = industryService.deleteIndustry(id);
			if(isa.equals("Industry Details Deleted Successfully"))
			{
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Industry","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:industryHome.mnt?industryDelete=" + isa + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "industryTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
