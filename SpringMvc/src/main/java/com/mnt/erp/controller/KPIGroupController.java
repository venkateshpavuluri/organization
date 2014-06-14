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

import com.mnt.erp.bean.KPIGroupBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
@Controller
public class KPIGroupController {
	@Autowired
	ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session = null;

	@RequestMapping(value = "/KPIGroupHome", method = RequestMethod.GET)
	public ModelAndView KPIGroupHome(
			@ModelAttribute("KPIGroupCmd") KPIGroupBean KPIGroupBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("KPIGroupHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("KPIGroupHome", "KPIGroupCmd", KPIGroupBean);
	}

	@RequestMapping(value = "/KPIGroupAdd", method = RequestMethod.POST)
	public String saveKPIGroup(
			@ModelAttribute("KPIGroupCmd") KPIGroupBean KPIGroupBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String KPIGroupSave = null;
		String KPIGroupName = KPIGroupBean.getKPIGroup();
		KPIGroupBean ltBean = (KPIGroupBean) KPIGroupBean;
		String sql = "select count(*) from KPIGroupBean lt where lt.KPIGroup='"
				+ KPIGroupName + "'";
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
							"KPI Group", "ROW", String.valueOf(ltBean
									.getKPIGroupId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					KPIGroupSave = "KPI Group Data Saved Successfully";
				} else {
					KPIGroupSave = "KPI Group Data Insertion Failures";
					return "redirect:KPIGroupHome.mnt?addKPIGroupFail="
							+ KPIGroupSave + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				KPIGroupSave = "KPI Group Data Insertion Failures";
				return "redirect:KPIGroupHome.mnt?addKPIGroupFail="
						+ KPIGroupSave + "";
			}
		} else {
			KPIGroupBean.setKgId(1);
			request.setAttribute("addKPIGroupDuplicate",
					"KPI Group already exists!");

			return "KPIGroupHome";

		}

		return "redirect:KPIGroupHome.mnt?addKPIGroupsus=" + KPIGroupSave + "";

	}

	@RequestMapping(value = "/KPIGroupSearch", method = RequestMethod.GET)
	public String searchKPIGroup(

	@ModelAttribute("KPIGroupCmd") KPIGroupBean KPIGroupSearch, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<KPIGroupBean> KPIGroupList = new ArrayList<KPIGroupBean>();

		try {
			String dbField = KPIGroupSearch.getXmlLabel();
			String operation = KPIGroupSearch.getOperations();
			String basicSearchId = KPIGroupSearch.getBasicSearchId();

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
				String sql = "select lt.KPIGroupId,lt.KPIGroup from KPIGroupBean lt order by lt.KPIGroup ";
				list = erpDao.searchDetails(sql);

			} else {
				String sql = "select lt.KPIGroupId,lt.KPIGroup from KPIGroupBean lt where lt."
						+ dbField
						+ " "
						+ operation
						+ " '"
						+ basicSearchId
						+ "'order by lt.KPIGroup";
				list = erpDao.searchDetails(sql);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				KPIGroupBean ab = new KPIGroupBean();
				Object[] oblt = (Object[]) iterator.next();
				ab.setKPIGroupId((Integer) oblt[0]);
				ab.setKPIGroup((String) oblt[1]);
				KPIGroupList.add(ab);
			}

			request.setAttribute("KPIGroupList", KPIGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "KPIGroupHome";

	}

	@RequestMapping(value = "/KPIGroupEdit", method = RequestMethod.GET)
	public String KPIGroupEdit(

	@ModelAttribute("KPIGroupCmd") KPIGroupBean KPIgroupEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("KPIGroupId"));
		List<Object[]> list = null;
		List<KPIGroupBean> KPIGroupEdit = new ArrayList<KPIGroupBean>();
		try {
			list = erpDao
					.searchDetails("select lt.KPIGroupId,lt.KPIGroup from KPIGroupBean lt where lt.KPIGroupId="
							+ id + "");
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				KPIgroupEdit.seteKPIGroupId((Integer) obj[0]);
				KPIgroupEdit.seteKPIGroup((String) obj[1]);
				KPIGroupEdit.add(KPIgroupEdit);
			}
			request.setAttribute("KPIGroupEdit", KPIGroupEdit);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "KPIGroupHome";

	}

	@RequestMapping(value = "/KPIGroupUpdate", method = RequestMethod.POST)
	public String KPIGroupUpdate(

	@ModelAttribute("KPIGroupCmd") KPIGroupBean KPIGroupUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String KPIGroupUpadted = null;

		String KPIGroup = KPIGroupUpdate.geteKPIGroup();
		int KPIGroupId = KPIGroupUpdate.geteKPIGroupId();

		KPIGroupUpdate.setKPIGroupId(KPIGroupId);
		KPIGroupUpdate.setKPIGroup(KPIGroup);
		Long checkUpdate = erpDao
				.duplicateCheck("select count(*) from KPIGroupBean lt where lt.KPIGroup='"
						+ KPIGroup
						+ "' and lt.KPIGroupId!='"
						+ KPIGroupId
						+ "'");
		if (checkUpdate == 0) {

			try {

				int msg = erpDao.updateDetails(KPIGroupUpdate);

				if (msg != 0) {
					KPIGroupUpadted = "KPI Group Data Updated Successfully";

				} else {
					KPIGroupUpadted = "KPI Group Data Updation Failed";
					return "redirect:KPIGroupHome.mnt?updateKPIGroupFail="
							+ KPIGroupUpadted + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:KPIGroupHome.mnt?updateKPIGroupFail="
						+ KPIGroupUpadted + "";
			}

		} else {

			request.setAttribute("updateKPIGroupDuplicate",
					"KPI Group already exists!");
			request.setAttribute("KPIGroupEdit", "KPIGroupEdit");
			return "KPIGroupHome";

		}
		return "redirect:KPIGroupHome.mnt?updateKPIGroupsus=" + KPIGroupUpadted
				+ "";
	}

	@RequestMapping(value = "/KPIGroupDelete", method = RequestMethod.GET)
	public String KPIGroupDelete(

	@ModelAttribute("KPIGroupCmd") KPIGroupBean KPIGroupDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String KPIGroupDeleted = null;
		int id = Integer.parseInt(request.getParameter("KPIGroupId"));
		KPIGroupDelete.setKPIGroupId(id);
		try {

			int msg = erpDao.deleteDetails(KPIGroupDelete);
			if (msg != 0) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "KPI Group", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				KPIGroupDeleted = "KPI Group  Deleted Successfully";
			} else {

				KPIGroupDeleted = "KPI Group  Deletion Failed";
				return "redirect:KPIGroupHome.mnt?deleteKPIGroupFail="
						+ KPIGroupDeleted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:KPIGroupHome.mnt?deleteKPIGroupFail="
					+ KPIGroupDeleted + "";
		}

		return "redirect:KPIGroupHome.mnt?deleteKPIGroupsus=" + KPIGroupDeleted
				+ "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "KPIGroupId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
