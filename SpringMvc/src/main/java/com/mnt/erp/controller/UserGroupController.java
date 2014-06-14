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

import com.mnt.erp.bean.UserGroup;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.UserGroupService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class UserGroupController {
	@Autowired
	UserGroupService usergroupService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;

	@RequestMapping(value = "/usergroupHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView usergroupType(
			@ModelAttribute("usergroupAdd") UserGroup usergroup,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("usergroupHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("usergroupHome", "usergroupAdd",
				new UserGroup());
	}

	@RequestMapping(value = "/usergroupAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveUserGroupDetails(
			@ModelAttribute("usergroupAdd") @Valid UserGroup usergroupAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msg = null;
		Long duplicateId = 0l;
		String res = null;
		String userGroupSave = null;

		try {

			duplicateId = usergroupService.duplicateUserGroupCheck(usergroupAdd
					.getUsergroup());
			if (duplicateId == 0) {
				
				session = request.getSession(false);
				msg = usergroupService.saveUserGroupDetails(usergroupAdd,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());
				model.addAttribute("usergroupAdd", new UserGroup());
				if (msg.equals("S")) {

					userGroupSave = "User Group has been saved successfully";
					list.add("2");
					res = "redirect:usergroupHome.mnt?success=" + userGroupSave
							+ "&list=" + list + "";
				} else {
					userGroupSave = "User Group has not been saved";
					list.add("2");
					res = "redirect:usergroupHome.mnt?warning=" + userGroupSave
							+ "&listwar=" + list + "";

				}
			} else {

				request.setAttribute("UserGroupDuplicate",
						"UserGroup Name  Already exist");
				usergroupAdd.setAid(1);
				return "usergroupHome";
			}

		} catch (Exception e) {
			userGroupSave = "User Group has not been saved";
			list.add("2");
			res = "redirect:usergroupHome.mnt?warning=" + userGroupSave
					+ "&listwar=" + list + "";

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = "/usergroupSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchUserGroup(@ModelAttribute UserGroup usergroupSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<UserGroup> userGroupBean = new ArrayList<UserGroup>();

		try {

			String dbField = usergroupSearch.getXmlLabel();
			String operation = usergroupSearch.getOperations();
			String basicSearchId = usergroupSearch.getBasicSearchId();

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
				list = usergroupService.searchUserGroup();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					UserGroup vt = new UserGroup();
					Object[] obj = (Object[]) iterator.next();
					vt.setUsergroupId((Integer) obj[0]);
					vt.setUsergroup((String) obj[1]);
					userGroupBean.add(vt);

				}
			} else {
				list = usergroupService.basicSearchUserGroup(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					UserGroup vt = new UserGroup();
					Object[] obj = (Object[]) iterator.next();
					vt.setUsergroupId((Integer) obj[0]);
					vt.setUsergroup((String) obj[1]);
					userGroupBean.add(vt);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("usergroupSearch", userGroupBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("usergroupAdd", usergroupSearch);

		return "usergroupHome";
	}

	@ModelAttribute("UserGroupSearchNames")
	public Map<String, String> populateusergroupSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usergroupService.selectUserGroupNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String desigId = Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "userGroupId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/usergroupEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String usergroupEdit(@ModelAttribute UserGroup usergroupDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String usergroupname = request.getParameter("usergroupDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<UserGroup> usergroupsList = new ArrayList<UserGroup>();

		try {

			list = usergroupService.searchUserGroupWithId(usergroupname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				usergroupDisplay.setUsergroupIdEdit((Integer) object[0]);
				usergroupDisplay.setUsergroupEdit((String) object[1]);

				usergroupsList.add(usergroupDisplay);
			}
			request.setAttribute("usergroupValues", usergroupsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("usergroupAdd", usergroupDisplay);
		return "usergroupHome";

	}

	@RequestMapping(value = "/usergroupUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateUserGroup(
			@ModelAttribute("usergroupAdd") UserGroup usergroup,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = usergroupService.updateDuplicateCheck(
					usergroup.getUsergroupEdit(),
					usergroup.getUsergroupIdEdit());

			if (duplicateId == 0) {
				usergroup.setUsergroupId(usergroup.getUsergroupIdEdit());
				usergroup.setUsergroup(usergroup.getUsergroupEdit());
				/* usergroup.setStatus(usergroup.getStatusEdit()); */

				String msg = usergroupService.updateUserGroup(usergroup);

				if (msg.equals("S")) {

					request.setAttribute("usergroupUpdateSuccess",
							"User Group has been updated successfully");
				} else {
					request.setAttribute("usergroupUpdateError",
							"User Group has not been updated");

				}
			} else {
				request.setAttribute("usergroupEditDuplicate",
						"User Group Name Already exist");
				request.setAttribute("usergroupValues", "usergroupValues");

				return "usergroupHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("usergroupAdd", new UserGroup());

		return "usergroupHome";

	}

	@RequestMapping(value = "/usergroupDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView usergroupDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int usergroupId = 0;

		String msg = null;
		try {
			usergroupId = Integer.parseInt(request
					.getParameter("usergroupIdDelete"));
			msg = usergroupService.usergroupDelete(usergroupId);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "User Group", "ROW", String
						.valueOf(usergroupId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				request.setAttribute("usergroupDeleteSuccess",
						"User Group has been deleted successfully");
			} else {
				request.setAttribute("usergroupDeleteError",
						"User Group has not been deleted");
			}
		} catch (Exception e) {
			request.setAttribute("usergroupDeleteError",
					"User Group has not been deleted");
			e.printStackTrace();

		}
		return new ModelAndView("usergroupHome", "usergroupAdd",
				new UserGroup());
	}
}
