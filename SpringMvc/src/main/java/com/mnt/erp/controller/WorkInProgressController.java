/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.JobCardBean;
import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkCenter;
import com.mnt.erp.bean.WorkInProgressBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.WorkInProgressService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 17-04-2014
 */
@Controller
public class WorkInProgressController {

	private static final Logger log = Logger
			.getLogger(WorkInProgressController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	WorkInProgressService wipService;
	@Autowired
	PopulateService populateService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;

	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	List<Object> obj = null;
	String message = null;
	HttpSession session = null;
	boolean flag = true;

	@RequestMapping(value = "/wipHome", method = RequestMethod.GET)
	public ModelAndView wipHome(
			@ModelAttribute("wipCmd") WorkInProgressBean wipBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("wipHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("wipHome", "wipCmd", wipBean);
	}

	@ModelAttribute("empSelect")
	public Map<Integer, String> populateEmp() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.employee_Id,m.fName from Employee m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("equipmentSelect")
	public Map<Integer, String> populateEquipment() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.equipmentId,m.equipmentName from EquipmentBean m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("jobCardSelect")
	public Map<Integer, String> populatJobCard() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.jobCardId,s.prodBatchId from JobCardBean s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("shiftSelect")
	public Map<Integer, String> populateShift() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.shiftId,s.shift from ShiftBean s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("workCenterSelect")
	public Map<Integer, String> populateWC() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.workCenter_Id,s.workCenterName from WorkCenter s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("uomSelect")
	public Map<Integer, String> populateUom() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.uom_Id,s.uom from Uom s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/checkwipAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkwipAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, WorkInProgressBean sqdupBean) {
		response.setCharacterEncoding("UTF-8");
		String bdNo = request.getParameter("wipNo");
		Long checkCustName = wipService.checkWIPCout(bdNo);
		if (checkCustName != 0) {

			message = "Warning ! WIP No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/checkWIPUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkwipUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, WorkInProgressBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String bdNo = request.getParameter("wipNo");
		int bdId = Integer.parseInt(request.getParameter("wipId"));
		long checkCustName = wipService.updateCheckWIP(bdNo, bdId);

		if (checkCustName != 0) {

			message = "Warning ! WIP No  is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/wipAdd", method = RequestMethod.POST)
	public String saveWIP(@ModelAttribute("wipCmd") WorkInProgressBean wipBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wipSave = null;
		try {
			WorkInProgressBean addBean = (WorkInProgressBean) wipBean;
			HttpSession session = request.getSession();
			if (addBean.getRemarks() == "") {
				addBean.setRemarks(null);
			}
			addBean.setWorkDay(dateService.dateFormat(
					dateService.dateParse(addBean.getWorkDay(), "au"), "au"));
			flag = wipService.saveWIPDetails(addBean);

			if (flag == true) {
				Date date = new Date();
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "WIP", "ROW", String.valueOf(addBean
						.getWipId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				wipSave = "WIP Data Saved Successfully";

			} else {
				wipSave = "WIP Data Insertion Failures";
				return "redirect:wipHome.mnt?addwipFail=" + wipSave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:wipHome.mnt?addwipsus=" + wipSave + "";

	}

	@RequestMapping(value = "/wipSearch", method = RequestMethod.GET)
	public String searchwip(
			@ModelAttribute("wipCmd") WorkInProgressBean wipBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<WorkInProgressBean> wipList = new ArrayList<WorkInProgressBean>();
		try {

			String dbField = wipBeanSearch.getXmlLabel();
			String operation = wipBeanSearch.getOperations();
			String basicSearchId = wipBeanSearch.getBasicSearchId();

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
				list = wipService.searchWIP();

			} else {

				list = wipService.basicSearchWIP(dbField, operation,
						basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				WorkInProgressBean wip = new WorkInProgressBean();
				wip.setWipId((Integer) objects[0]);
				wip.setWorkDay(dateService.dateFormat(
						dateService.dateParse((String) objects[1], "se"), "se"));
				wip.setQtyPlanned((String) objects[2]);
				wip.setQtyManufactured((String) objects[3]);

				ShiftBean dp = ((ShiftBean) objects[4]);
				wip.setShiftId(dp.getShift());
				WorkCenter eq = ((WorkCenter) objects[5]);
				wip.setWorkcenterId(eq.getWorkCenterName());
				EquipmentBean mp = ((EquipmentBean) objects[6]);
				wip.setEquipmentId(mp.getEquipmentName());
				Uom u = ((Uom) objects[7]);
				wip.setUomId(u.getUom());
				JobCardBean j = ((JobCardBean) objects[8]);
				wip.setJobcardId(String.valueOf(j.getJobCardId()));
				/*
				 * Employee st = ((Employee) objects[9]);
				 * wip.setEmpId(st.getEmployeeNo());
				 */

				wipList.add(wip);
			}
			request.setAttribute("wipList", wipList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "wipHome";

	}

	@RequestMapping(value = "/wipDelete", method = RequestMethod.GET)
	public String wipDelete(
			@ModelAttribute("wipCmd") WorkInProgressBean wipBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wipDelete = null;
		int wipId = Integer.parseInt(request.getParameter("wipId"));
		try {
			flag = wipService.deleteWIP(wipId);
			if (flag == true) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "WIP", "ROW", String.valueOf(wipId),
						"1", modifiedDate, session.getAttribute("userName")
								.toString());
				wipDelete = "WIP Deleted Successfully";

			} else {
				wipDelete = "WIP Deletion Failed due to Conatraint Violation";
				return "redirect:wipHome.mnt?DeletewipFail=" + wipDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:wipHome.mnt?Deletewipsus=" + wipDelete + "";

	}

	@RequestMapping(value = "/wipEdit", method = RequestMethod.GET)
	public String wipEdit(@ModelAttribute("wipCmd") WorkInProgressBean wipEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("wipId"));
		List<WorkInProgressBean> wipBean = new ArrayList<WorkInProgressBean>();
		WorkInProgressBean isp = null;
		try {
			obj = wipService.searchWIPWithId(id);
			Iterator<Object> iterator = obj.iterator();
			if (iterator.hasNext()) {
				Object obj = iterator.next();
				isp = (WorkInProgressBean) obj;
				isp.setWorkDay(dateService.dateFormat(
						dateService.dateParse(isp.getWorkDay(), "se"), "se"));
				wipBean.add(isp);

			}
			model.addAttribute("wipCmd", isp);
			request.setAttribute("wipEdit", wipBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "wipHome";

	}

	@RequestMapping(value = "/wipUpdate", method = RequestMethod.POST)
	public String wipUpdate(
			@ModelAttribute("wipCmd") WorkInProgressBean wipUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String wipUpadted = null;

		try {
			WorkInProgressBean upBean = (WorkInProgressBean) wipUpdate;
			if (upBean.getRemarks() == "") {
				upBean.setRemarks(null);
			}
			upBean.setWorkDay(dateService.dateFormat(
					dateService.dateParse(upBean.getWorkDay(), "au"), "au"));
			flag = wipService.updateWIP(upBean);

			if (flag == true) {
				wipUpadted = "WIP Data Updated Successfully";

			} else {
				wipUpadted = "WIP Data Updation Failed";
				return "redirect:wipHome.mnt?updatewipFail=" + wipUpadted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:wipHome.mnt?updatewipssus=" + wipUpadted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "wip";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
