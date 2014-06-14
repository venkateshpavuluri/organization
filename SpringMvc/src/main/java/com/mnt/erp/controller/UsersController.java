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
import java.util.Set;

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

import com.mnt.erp.bean.Function;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Role;
import com.mnt.erp.bean.ThemeBean;
import com.mnt.erp.bean.UserGroup;
import com.mnt.erp.bean.UserOrganizationBean;
import com.mnt.erp.bean.UserRoles;
import com.mnt.erp.bean.Users;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.UsersService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class UsersController {
	@Autowired
	UsersService usersService;

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "usersId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/usersHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView getUsers(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("usersHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("usersHome", "usersAdd", new Users());
	}

	@RequestMapping(value = "/usersAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveUsersDetails(
			@ModelAttribute("usersAdd") @Valid Users usersAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {

		String msa = null;
		Long duplicateId = 0l;
		String url = null;
		List<String> list = null;
		response.setCharacterEncoding("UTF-8");

		try {
			if (result.hasErrors()) {
				usersAdd.setAid(1);
				return "usersHome";
			}
			duplicateId = usersService.duplicateUsersCheck(usersAdd
					.getUserName());
			if (duplicateId == 0) {
				list = new ArrayList<String>();
				session = request.getSession(false);
				// saveUsersDetails this method is used to save Role Details
				msa = usersService.saveUsersDetails(usersAdd, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());
				model.addAttribute("usersAdd", new Users());
				if (msa.equals("success")) {
					list.add("1");
					url = "redirect:usersHome.mnt?list=" + list + "";
					model.addAttribute("usersAdd", usersAdd);
				} else {
					list.add("1");
					url = "redirect:usersHome.mnt?listwar=" + list + "";
					model.addAttribute("usersAdd", usersAdd);
				}
			} else {
				request.setAttribute("UsersDuplicate",
						"Users Name  Already exist");
				usersAdd.setAid(1);
				return "usersHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			list.add("1");
			url = "redirect:usersHome.mnt?listwar=" + list + "";
			model.addAttribute("usersAdd", usersAdd);

		}
		return url;
	}

	@ModelAttribute("RolesSearchIds")
	public Map<String, String> populateSearchRoleIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usersService.selectRoleIds();
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

	@ModelAttribute("themeIds")
	public Map<String, String> populateThemeIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usersService.selectThemeService();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				String tid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));

				map.put(tid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	
	@ModelAttribute("UsersGroupSearchIds")
	public Map<String, String> populateusergroupSearchIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usersService.selectUserGroupIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String ugid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));

				map.put(ugid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("FunctionSearchIds")
	public Map<String, String> populatefunctionSearchIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usersService.selectFunctionIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String fid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));
				map.put(fid, (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("OrganizationSearchIds")
	public Map<String, String> populateorganizationSearchIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usersService.selectOrganizationIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				String oid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));
				map.put(oid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/usersSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchUsers(@ModelAttribute Users users,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		List<Users> list = null;

		try {
			response.setCharacterEncoding("UTF-8");

			list = new ArrayList<Users>();

			String usersname = users.getBasicSearchId();

			if (usersname.equals("")) {

				list = usersService.searchUsers();

				Iterator<Users> iter = list.iterator();
				while (iter.hasNext()) {

					Users user = (Users) iter.next();

					List<UserRoles> lis = user.getUserRolesset();
					Iterator<UserRoles> it = lis.iterator();
					ArrayList<String> al = new ArrayList<String>();
					while (it.hasNext()) {
						UserGroup ug = (UserGroup) user.getUsergroupBean();
						user.setUsergroupName(ug.getUsergroup());
						Function fg = (Function) user.getFunctionBean();
						user.setFunctionName(fg.getFunctionName());
						UserRoles use = (UserRoles) it.next();
						Role gh = (Role) use.getRoleset();
						al.add(gh.getRole());
						ThemeBean tb=(ThemeBean) user.getTbean();
						user.setTheme(tb.getTheme());

					}
					StringBuilder builder = new StringBuilder();
					for (String value : al) {
						builder.append(value);
						builder.append(",");
					}
					String text = builder.toString();
					user.setRoleDisplay(text.length() > 0 ? text.substring(0,
							text.length() - 1) : "");
					Set<UserOrganizationBean> listorg = user.getUserorgbean();
					Iterator<UserOrganizationBean> iterate = listorg.iterator();
					ArrayList<String> alorg = new ArrayList<String>();
					while (iterate.hasNext()) {
						UserOrganizationBean useb = (UserOrganizationBean) iterate
								.next();
						Organization org = (Organization) useb.getOrgbean();
						alorg.add(org.getOrgName());
					}
					StringBuilder builder2 = new StringBuilder();
					for (String res : alorg) {
						builder2.append(res);
						builder2.append(",");
					}
					String show = builder2.toString();
					user.setOrganizationName(show.length() > 0 ? show
							.substring(0, show.length() - 1) : "");

				}

			}

			else {
				list = usersService.searchUsersWithName(usersname);

				Iterator<Users> iterator = list.iterator();
				while (iterator.hasNext()) {
					Users user = (Users) iterator.next();
					List<UserRoles> lis = user.getUserRolesset();
					Iterator<UserRoles> it = lis.iterator();
					ArrayList<String> al = new ArrayList<String>();
					while (it.hasNext()) {
						UserRoles use = (UserRoles) it.next();
						Role gh = (Role) use.getRoleset();
						al.add(gh.getRole());
					}
					user.setRoleName(al);
					Set<UserOrganizationBean> listorg = user.getUserorgbean();
					Iterator<UserOrganizationBean> iterate = listorg.iterator();
					ArrayList<String> alorg = new ArrayList<String>();
					while (iterate.hasNext()) {
						UserOrganizationBean useb = (UserOrganizationBean) iterate
								.next();
						Organization org = (Organization) useb.getOrgbean();
						alorg.add(org.getOrgName());

					}
					user.setOrganizationId(alorg);

				}
			}

			request.setCharacterEncoding("UTF-8");
			request.setAttribute("usersSearch", list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("usersAdd", users);

		return "usersHome";
	}

	@ModelAttribute("usersSearchNames")
	public Map<String, String> populateusersSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = usersService.selectUsersNames();
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

	@RequestMapping(value = "/usersEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String usersEdit(@ModelAttribute Users usersDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String usersname = request.getParameter("usersDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Users> list = null;
		List<Users> usersList = new ArrayList<Users>();
		try {

			list = usersService.searchUsersWithId(usersname);
			Iterator<Users> iterator = list.iterator();
			while (iterator.hasNext()) {

				Users user = (Users) iterator.next();

				List<UserRoles> lis = user.getUserRolesset();
				Iterator<UserRoles> it = lis.iterator();

				ArrayList<String> al = new ArrayList<String>();
				while (it.hasNext()) {
					UserRoles use = (UserRoles) it.next();
					Role gh = (Role) use.getRoleset();
					al.add(gh.getRoleid());

				}
				Set<UserOrganizationBean> listorg = user.getUserorgbean();
				Iterator<UserOrganizationBean> iterate = listorg.iterator();
				ArrayList<String> alorg = new ArrayList<String>();
				while (iterate.hasNext()) {
					UserOrganizationBean useb = (UserOrganizationBean) iterate
							.next();
					Organization org = (Organization) useb.getOrgbean();
					String orgidd = Integer.toString(org.getOrgId());
					alorg.add(orgidd);

				}

				usersDisplay.setUser_IdEdit(user.getUser_Id());
				usersDisplay.setUserNameEdit(user.getUserName());
				usersDisplay.setPasswordEdit(user.getPassword().trim());
				usersDisplay.setIsActiveEdit(user.getIsActive());
				usersDisplay.setUsergroupIdEdit(user.getUsergroupId());

				usersDisplay.setFunctionIdEdit(user.getFunctionId());
				// usersDisplay.setOrganizationIdEdit(user.getOrganizationId());
				usersDisplay.setOrganizationIdEdit(alorg);
				usersDisplay.setRoleNameEdit(al);
				usersDisplay.setValidToEdit(user.getValidTo());
				usersDisplay.setValidFromEdit(user.getValidFrom());
                usersDisplay.setThemeEdit(user.getTheme());
				user.setRoleName(al);
				usersList.add(usersDisplay);
			}

			request.setAttribute("usersValues", usersList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
		}
		model.addAttribute("usersAdd", usersDisplay);
		return "usersHome";

	}

	@RequestMapping(value = "/usersUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateUsers(@ModelAttribute("usersAdd") Users users,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = usersService.updateDuplicateCheck(
					users.getUserNameEdit(), users.getUser_IdEdit());

			if (duplicateId == 0) {
				users.setUser_Id(users.getUser_IdEdit());
				String upass = users.getPasswordEdit();
				String[] password = upass.split(",");
				String pass1 = password[1];
				users.setUserName(users.getUserNameEdit());
				users.setPassword(pass1);
				users.setIsActive(users.getIsActiveEdit());
				users.setUsergroupId(users.getUsergroupIdEdit());
				users.setFunctionId(users.getFunctionIdEdit());
				users.setOrganizationId(users.getOrganizationIdEdit());
				users.setValidFrom(users.getValidFromEdit());
				users.setValidTo(users.getValidToEdit());
				users.setTheme(users.getThemeEdit());
				String msg = usersService.updateUsers(users);
				UserRoles userRoles = new UserRoles();
				Iterator<String> iterator = null;

				iterator = users.getRoleNameEdit().iterator();
				String uid = users.getUser_IdEdit();
				String msgur = usersService.userRolesDelete(uid);

				String msg1 = usersService.saveUserRoles(users);

				UserOrganizationBean userorgbean = new UserOrganizationBean();
				Iterator<String> iterr = null;

				iterr = users.getOrganizationIdEdit().iterator();
				String uidd = users.getUser_IdEdit();
				String msguorg = usersService.userOrganizationDelete(uidd);

				String msgog = usersService.saveUserOrganization(users);

				if (msg.equals("S")) {
					request.setAttribute("usersUpadteSuccess",
							"Users Details Updated Successfully");
				} else {
					request.setAttribute("usersValues", "hello");

					request.setAttribute("usersUpadteFail",
							"Users Details has Not Updated");
					return "usersHome";
				}
			} else {
				request.setAttribute("usersEditDuplicate",
						"Users Name Already exist");
				request.setAttribute("usersValues", "hello");

				return "usersHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("usersAdd", new Users());

		return "usersHome";

	}

	@RequestMapping(value = "/usersDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView usersDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String userid = null;

		String delmsg1 = null;
		String delmsg2 = null;
		try {
			userid = request.getParameter("usersidDelete");

			String msgur = usersService.userRolesDelete(userid);
			String msgor = usersService.userOrganizationDelete(userid);
			String msg = usersService.usersDelete(userid);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "User", "ROW",
						String.valueOf(userid), "1", modifiedDate, session
								.getAttribute("userName").toString());

				request.setAttribute("usersDeleteSuccess",
						"Users  Deleted Successfully");
			} else {
				request.setAttribute("usersDeleteFail", "Users Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("usersDeleteFail", "users " + delmsg2
					+ " Did Not Deleted");
		}
		return new ModelAndView("usersHome", "usersAdd", new Users());
	}

}
