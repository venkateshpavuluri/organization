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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.LeaveTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
@Controller
public class LeaveTypeController {
	@Autowired
	ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session = null;

	@RequestMapping(value = "/leaveTypeHome", method = RequestMethod.GET)
	public ModelAndView leaveTypeHome(
			@ModelAttribute("leaveTypeCmd") LeaveTypeBean leaveBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("leaveTypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("leaveTypeHome", "leaveTypeCmd", leaveBean);
	}

	@RequestMapping(value = "/leaveTypeAdd", method = RequestMethod.POST)
	public String saveleaveType(
			@ModelAttribute("leaveTypeCmd") LeaveTypeBean LeaveTypeBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String leaveTypeSave = null;
		String leaveName = LeaveTypeBean.getLeaveType();
		LeaveTypeBean ltBean = (LeaveTypeBean) LeaveTypeBean;
		String sql = "select count(*) from LeaveTypeBean lt where lt.leaveType='"
				+ leaveName + "'";
		Long checkJob = erpDao.duplicateCheck(sql);

		if (checkJob == 0) {
			try {
				int msg = erpDao.saveDetails(ltBean);
				status.setComplete();
				if (msg != 0) {
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date());
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Leave Type", "ROW", String.valueOf(ltBean
									.getLeaveTypeId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					leaveTypeSave = "Leave Type Data Saved Successfully";
				} else {
					leaveTypeSave = "Leave Type Data Insertion Failures";
					return "redirect:leaveTypeHome.mnt?addLeaveFail="
							+ leaveTypeSave + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				leaveTypeSave = "Leave Type Data Insertion Failures";
				return "redirect:leaveTypeHome.mnt?addLeaveFail="
						+ leaveTypeSave + "";
			}
		} else {
			LeaveTypeBean.setLtId(1);
			request.setAttribute("addleaveTypeDuplicate",
					"Leave Type already exists!");

			return "leaveTypeHome";

		}

		return "redirect:leaveTypeHome.mnt?addLeavesus=" + leaveTypeSave + "";

	}

	@RequestMapping(value = "/leaveTypeSearch", method = RequestMethod.GET)
	public String searchleaveType(

	@ModelAttribute("leaveTypeCmd") LeaveTypeBean leaveTypeSearch, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<LeaveTypeBean> leaveTypeList = new ArrayList<LeaveTypeBean>();

		try {
			String dbField = leaveTypeSearch.getXmlLabel();
			String operation = leaveTypeSearch.getOperations();
			String basicSearchId = leaveTypeSearch.getBasicSearchId();

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
				String sql = "select lt.leaveTypeId,lt.leaveType from LeaveTypeBean lt order by lt.leaveType";
				list = erpDao.searchDetails(sql);

			} else {
				String sql = "select lt.leaveTypeId,lt.leaveType from LeaveTypeBean lt where lt."
						+ dbField
						+ " "
						+ operation
						+ " '"
						+ basicSearchId
						+ "'order by lt.leaveType";
				list = erpDao.searchDetails(sql);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				LeaveTypeBean ab = new LeaveTypeBean();
				Object[] oblt = (Object[]) iterator.next();
				ab.setLeaveTypeId((Integer) oblt[0]);
				ab.setLeaveType((String) oblt[1]);
				leaveTypeList.add(ab);
			}

			request.setAttribute("leaveTypeList", leaveTypeList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "leaveTypeHome";

	}

	@RequestMapping(value = "/leaveTypeEdit", method = RequestMethod.GET)
	public String leaveTypeEdit(

	@ModelAttribute("leaveTypeCmd") LeaveTypeBean leavetypeEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("leaveTypeId"));
		List<Object[]> list = null;
		List<LeaveTypeBean> leaveTypeEdit = new ArrayList<LeaveTypeBean>();
		try {
			list = erpDao
					.searchDetails("select lt.leaveTypeId,lt.leaveType from LeaveTypeBean lt where lt.leaveTypeId="
							+ id + "");
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				leavetypeEdit.setEleaveTypeId((Integer) obj[0]);
				leavetypeEdit.setEleaveType((String) obj[1]);
				leaveTypeEdit.add(leavetypeEdit);
			}
			request.setAttribute("leaveTypeEdit", leaveTypeEdit);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "leaveTypeHome";

	}

	@RequestMapping(value = "/leaveTypeUpdate", method = RequestMethod.POST)
	public String leaveTypeUpdate(

	@ModelAttribute("leaveTypeCmd") LeaveTypeBean leaveTypeUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String leaveTypeUpadted = null;

		String leaveType = leaveTypeUpdate.getEleaveType();
		int leaveTypeId = leaveTypeUpdate.getEleaveTypeId();

		leaveTypeUpdate.setLeaveTypeId(leaveTypeId);
		leaveTypeUpdate.setLeaveType(leaveType);
		Long checkUpdate = erpDao
				.duplicateCheck("select count(*) from LeaveTypeBean lt where lt.leaveType='"
						+ leaveType
						+ "' and lt.leaveTypeId!='"
						+ leaveTypeId
						+ "'");
		if (checkUpdate == 0) {

			try {

				int msg = erpDao.updateDetails(leaveTypeUpdate);

				if (msg != 0) {
					leaveTypeUpadted = "Leave Type Data Updated Successfully";

				} else {
					leaveTypeUpadted = "Leave Type Data Updation Failed";
					return "redirect:leaveTypeHome.mnt?updateLeaveFail="
							+ leaveTypeUpadted + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:leaveTypeHome.mnt?updateLeaveFail="
						+ leaveTypeUpadted + "";
			}

		} else {

			request.setAttribute("updateleaveTypeDuplicate",
					"Leave Type already exists!");
			request.setAttribute("leaveTypeEdit", "leaveTypeEdit");
			return "leaveTypeHome";

		}
		return "redirect:leaveTypeHome.mnt?updateLeavesus=" + leaveTypeUpadted
				+ "";
	}

	@RequestMapping(value = "/leaveTypeDelete", method = RequestMethod.GET)
	public String leaveTypeDelete(

	@ModelAttribute("leaveTypeCmd") LeaveTypeBean leaveTypeDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String leaveTypeDeleted = null;
		int id = Integer.parseInt(request.getParameter("leaveTypeId"));
		leaveTypeDelete.setLeaveTypeId(id);
		try {

			int msg = erpDao.deleteDetails(leaveTypeDelete);
			if (msg != 0) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Leave Type", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				leaveTypeDeleted = "Leave Type  Deleted Successfully";
			} else {

				leaveTypeDeleted = "Leave Type  Deletion Failed";
				return "redirect:leaveTypeHome.mnt?deleteLeaveFail="
						+ leaveTypeDeleted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:leaveTypeHome.mnt?deleteLeaveFail="
					+ leaveTypeDeleted + "";
		}

		return "redirect:leaveTypeHome.mnt?deleteLeavesus=" + leaveTypeDeleted
				+ "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "leaveTypeId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
