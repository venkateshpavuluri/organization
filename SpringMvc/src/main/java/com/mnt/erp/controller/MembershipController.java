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

import com.mnt.erp.bean.MembershipBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
@Controller
public class MembershipController {
	@Autowired
	ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session = null;

	@RequestMapping(value = "/membershipHome", method = RequestMethod.GET)
	public ModelAndView membershipHome(
			@ModelAttribute("membershipCmd") MembershipBean membershipBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("membershipHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("membershipHome", "membershipCmd",
				membershipBean);
	}

	@RequestMapping(value = "/membershipAdd", method = RequestMethod.POST)
	public String savemembership(
			@ModelAttribute("membershipCmd") MembershipBean membershipBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String membershipSave = null;
		String membershipName = membershipBean.getMembership();
		MembershipBean ltBean = (MembershipBean) membershipBean;
		String sql = "select count(*) from MembershipBean lt where lt.membership='"
				+ membershipName + "'";
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
							"Membership", "ROW", String.valueOf(ltBean
									.getMembershipId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					membershipSave = "Membership Data Saved Successfully";
				} else {
					return "redirect:membershipHome.mnt?addmembershipFail="
							+ membershipSave + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				membershipSave = "Membership Data Insertion Failures";
				return "redirect:membershipHome.mnt?addmembershipFail="
						+ membershipSave + "";
			}
		} else {
			membershipBean.setMsId(1);
			request.setAttribute("addmembershipDuplicate",
					"Membership already exists!");

			return "membershipHome";

		}

		return "redirect:membershipHome.mnt?addmembershipsus=" + membershipSave
				+ "";

	}

	@RequestMapping(value = "/membershipSearch", method = RequestMethod.GET)
	public String searchmembership(

	@ModelAttribute("membershipCmd") MembershipBean membershipSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<MembershipBean> membershipList = new ArrayList<MembershipBean>();

		try {
			String dbField = membershipSearch.getXmlLabel();
			String operation = membershipSearch.getOperations();
			String basicSearchId = membershipSearch.getBasicSearchId();

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
				String sql = "select lt.membershipId,lt.membership from MembershipBean lt order by lt.membership";
				list = erpDao.searchDetails(sql);

			} else {
				String sql = "select lt.membershipId,lt.membership from MembershipBean lt where lt."
						+ dbField
						+ " "
						+ operation
						+ " '"
						+ basicSearchId
						+ "'order by lt.membership";
				list = erpDao.searchDetails(sql);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				MembershipBean ab = new MembershipBean();
				Object[] oblt = (Object[]) iterator.next();
				ab.setMembershipId((Integer) oblt[0]);
				ab.setMembership((String) oblt[1]);
				membershipList.add(ab);
			}

			request.setAttribute("membershipList", membershipList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "membershipHome";

	}

	@RequestMapping(value = "/membershipEdit", method = RequestMethod.GET)
	public String membershipEdit(

	@ModelAttribute("membershipCmd") MembershipBean membersEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("membershipId"));
		List<Object[]> list = null;
		List<MembershipBean> membershipEdit = new ArrayList<MembershipBean>();
		try {
			list = erpDao
					.searchDetails("select lt.membershipId,lt.membership from MembershipBean lt where lt.membershipId="
							+ id + "");
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				membersEdit.setEmembershipId((Integer) obj[0]);
				membersEdit.setEmembership((String) obj[1]);
				membershipEdit.add(membersEdit);
			}
			request.setAttribute("membershipEdit", membershipEdit);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
		}
		return "membershipHome";

	}

	@RequestMapping(value = "/membershipUpdate", method = RequestMethod.POST)
	public String membershipUpdate(

	@ModelAttribute("membershipCmd") MembershipBean membershipUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String membershipUpadted = null;

		String membership = membershipUpdate.getEmembership();
		int membershipId = membershipUpdate.getEmembershipId();

		membershipUpdate.setMembershipId(membershipId);
		membershipUpdate.setMembership(membership);
		Long checkUpdate = erpDao
				.duplicateCheck("select count(*) from MembershipBean lt where lt.membership='"
						+ membership
						+ "' and lt.membershipId!='"
						+ membershipId + "'");
		if (checkUpdate == 0) {
			try {
				int msg = erpDao.updateDetails(membershipUpdate);
				if (msg != 0) {
					membershipUpadted = "Membership Data Updated Successfully";

				} else {
					membershipUpadted = "Membership Data Updation Failed";
					return "redirect:membershipHome.mnt?updatemembershipFail="
							+ membershipUpadted + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:membershipHome.mnt?updatemembershipFail="
						+ membershipUpadted + "";
			}

		} else {

			request.setAttribute("updatemembershipDuplicate",
					"Membership already exists!");
			request.setAttribute("membershipEdit", "membershipEdit");
			return "membershipHome";

		}
		return "redirect:membershipHome.mnt?updatemembershipsus="
				+ membershipUpadted + "";
	}

	@RequestMapping(value = "/membershipDelete", method = RequestMethod.GET)
	public String membershipDelete(

	@ModelAttribute("membershipCmd") MembershipBean membershipDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String membershipDeleted = null;
		int id = Integer.parseInt(request.getParameter("membershipId"));
		membershipDelete.setMembershipId(id);
		try {

			int msg = erpDao.deleteDetails(membershipDelete);
			if (msg != 0) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Membership ", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				membershipDeleted = "Membership  Deleted Successfully";
			} else {
				membershipDeleted = "Membership  Deletion Failed";
				return "redirect:membershipHome.mnt?deletemembershipFail="
						+ membershipDeleted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:membershipHome.mnt?deletemembershipFail="
					+ membershipDeleted + "";
		}

		return "redirect:membershipHome.mnt?deletemembershipsus="
				+ membershipDeleted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "membershipId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
