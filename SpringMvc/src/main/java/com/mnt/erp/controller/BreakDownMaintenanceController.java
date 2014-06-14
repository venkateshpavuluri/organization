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

import com.mnt.erp.bean.BreakDownMaintenance;
import com.mnt.erp.bean.Department;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.MaintenanceProblemType;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BreakDownMaintenanceService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0  16-04-2014
 */
@Controller
public class BreakDownMaintenanceController {
	private static final Logger log = Logger
			.getLogger(BreakDownMaintenanceController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	BreakDownMaintenanceService breakDownService;
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

	@RequestMapping(value = "/breakDownHome", method = RequestMethod.GET)
	public ModelAndView breakDownHome(
			@ModelAttribute("breakDownCmd") BreakDownMaintenance breakDownBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("breakDownHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("breakDownHome", "breakDownCmd", breakDownBean);
	}

	@ModelAttribute("deptSelect")
	public Map<Integer, String> populateOrgIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.departmentId,m.department from Department m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("equipmentSelect")
	public Map<Integer, String> populatePTIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.equipmentId,m.equipmentName from EquipmentBean m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("statusSelect")
	public Map<Integer, String> populatStatusIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.statusId,s.status from Status s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("maintenanceSelect")
	public Map<Integer, String> populateMPT() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.maintenanceProblemType_Id,s.maintenanceProblemType from MaintenanceProblemType s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/checkbreakDownAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkRecAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, BreakDownMaintenance sqdupBean) {
		response.setCharacterEncoding("UTF-8");
		String bdNo = request.getParameter("breakDownNo");
		Long checkCustName = breakDownService.checkBreakDownCout(bdNo);
		if (checkCustName != 0) {

			message = "Warning ! Break Down No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/checkbreakDownUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkRecUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, BreakDownMaintenance dupBean) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String bdNo = request.getParameter("breakDownNo");
		int bdId = Integer.parseInt(request.getParameter("breakDownId"));
		long checkCustName = breakDownService
				.updateCheckBreakDown(bdNo, bdId);

		if (checkCustName != 0) {

			message = "Warning ! Break Down No  is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/breakDownAdd", method = RequestMethod.POST)
	public String saveBreakDown(
			@ModelAttribute("breakDownCmd") BreakDownMaintenance recBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String recSave = null;
		try {
			BreakDownMaintenance addBean = (BreakDownMaintenance) recBean;
			HttpSession session = request.getSession();
			Date date = new Date();
			addBean.setRecordedDT(dateService.dateFormat(
					dateService.dateParse(addBean.getRecordedDT(), "au"), "au"));
			flag = breakDownService.saveBreakDownDetails(addBean);

			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Break Down", "ROW", String
						.valueOf(addBean.getBreakdownMaintenace_Id()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				recSave = "Break Down Data Saved Successfully";

			} else {
				recSave = "Break Down Data Insertion Failures";
				return "redirect:breakDownHome.mnt?addRecFail=" + recSave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:breakDownHome.mnt?addRecsus=" + recSave + "";

	}

	@RequestMapping(value = "/breakDownSearch", method = RequestMethod.GET)
	public String searchBreakDown(
			@ModelAttribute("breakDownCmd") BreakDownMaintenance breakDownBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<BreakDownMaintenance> breakDownList = new ArrayList<BreakDownMaintenance>();
		try {

			String dbField = breakDownBeanSearch.getXmlLabel();
			String operation = breakDownBeanSearch.getOperations();
			String basicSearchId = breakDownBeanSearch.getBasicSearchId();

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
				list = breakDownService.searchBreakDown();

			} else {

				list = breakDownService.basicSearchBreakDown(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				BreakDownMaintenance rb = new BreakDownMaintenance();
				rb.setBreakdownMaintenace_Id((Integer) objects[0]);
				rb.setProblem((String) objects[1]);
				rb.setRecordedDT(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));

				Department dp = ((Department) objects[3]);
				rb.setDepartment_Id(dp.getDepartment());
				EquipmentBean eq = ((EquipmentBean) objects[4]);
				rb.setEquipment_Id(eq.getEquipmentName());
				MaintenanceProblemType mp = ((MaintenanceProblemType) objects[5]);
				rb.setMaintenanceProblemType_Id(mp.getMaintenanceProblemType());
				Status st = ((Status) objects[6]);
				rb.setStatus_Id(st.getStatus());
				rb.setBreakDownNo((String) objects[7]);
				breakDownList.add(rb);
			}
			request.setAttribute("breakDownList", breakDownList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "breakDownHome";

	}

	@RequestMapping(value = "/breakDownDelete", method = RequestMethod.GET)
	public String breakDownDelete(
			@ModelAttribute("breakDownCmd") BreakDownMaintenance breakDownBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String breakDownDelete = null;
		int recId = Integer.parseInt(request.getParameter("breakDownId"));
		try {
			flag = breakDownService.deleteBreakDown(recId);
			if (flag == true) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "breakDown", "ROW", String
						.valueOf(recId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				breakDownDelete = "Break Down Deleted Successfully";

			} else {
				breakDownDelete = "Break Down Deletion Failed due to Conatraint Violation";
				return "redirect:breakDownHome.mnt?DeleteRecFail="
						+ breakDownDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:breakDownHome.mnt?DeleteRecsus=" + breakDownDelete
				+ "";

	}

	@RequestMapping(value = "/breakDownEdit", method = RequestMethod.GET)
	public String breakDownEdit(
			@ModelAttribute("breakDownCmd") BreakDownMaintenance recEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("breakDownId"));
		List<BreakDownMaintenance> breakDownBean = new ArrayList<BreakDownMaintenance>();
		BreakDownMaintenance isp = null;
		try {
			obj = breakDownService.searchBreakDownWithId(id);
			Iterator<Object> iterator = obj.iterator();
			if (iterator.hasNext()) {
				Object obj = iterator.next();
				isp = (BreakDownMaintenance) obj;
				isp.setRecordedDT(dateService.dateFormat(
						dateService.dateParse(isp.getRecordedDT(), "se"), "se"));
				breakDownBean.add(isp);

			}
			model.addAttribute("breakDownCmd", isp);
			request.setAttribute("breakDownEdit", breakDownBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "breakDownHome";

	}

	@RequestMapping(value = "/breakDownUpdate", method = RequestMethod.POST)
	public String breakDownUpdate(
			@ModelAttribute("breakDownCmd") BreakDownMaintenance recUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String recUpadted = null;

		try {
			BreakDownMaintenance upBean = (BreakDownMaintenance) recUpdate;
			upBean.setRecordedDT(dateService.dateFormat(
					dateService.dateParse(upBean.getRecordedDT(), "au"), "au"));
			flag = breakDownService.updateBreakDown(upBean);

			if (flag == true) {
				recUpadted = "Break Down Data Updated Successfully";

			} else {
				recUpadted = "Break Down Data Updation Failed";
				return "redirect:breakDownHome.mnt?updateRecFail=" + recUpadted
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:breakDownHome.mnt?updateRecssus=" + recUpadted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "breakDown";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
