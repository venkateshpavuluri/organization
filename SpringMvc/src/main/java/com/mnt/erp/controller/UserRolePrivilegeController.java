/**
 * 
 */
package com.mnt.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

import com.mnt.erp.bean.MenuItems;
import com.mnt.erp.bean.Privilege;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.bean.UserRolePrivilege;
import com.mnt.erp.bean.Users;
import com.mnt.erp.dao.UserRolePrivilegeDao;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.UserRolePrivilegeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 * 
 */
@Controller
public class UserRolePrivilegeController {

	static Logger logger = Logger.getLogger(UserRolePrivilegeController.class);

	@Autowired
	PopulateService populateService;
	@Autowired
	ERPDao erpDao;
	@Autowired
	UserRolePrivilegeService userRolePrivilegeService;
	@Autowired
	UserRolePrivilegeDao userRolePrivilegeDao;
	@Autowired
	MenuService menuService;

	@Autowired
	XmlLabelsService xmlService;
	List<Object[]> list = null;

	@RequestMapping(value = "/userRolePrivilegeHome", method = RequestMethod.GET)
	public String gotoUserRolePrivilege(
			@ModelAttribute("userRolePrivilege") UserRolePrivilege userRolePrivilege,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige(
				"userRolePrivilegeHome.mnt", session.getAttribute("userId")
						.toString());
		session.setAttribute("privilegeList", list);
		getUserPrivilegeDetails(request);
		return "userRolePriView";
	}

	@RequestMapping(value = "/forUsers", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> userIds(HttpServletRequest request,
			HttpServletResponse response, StockTransferBean stBean) {
		response.setCharacterEncoding("UTF-8");
		List<Users> users = null;
		String roleId = request.getParameter("roleId");
		Iterator<Users> iterator = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			users = userRolePrivilegeService.getUsers(roleId);
			iterator = users.iterator();
			while (iterator.hasNext()) {
				Users usersdata = (Users) iterator.next();
				map.put("0", "--Select--");
				map.put(usersdata.getUser_Id(), usersdata.getUserName());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/userRolePlgAdd", method = RequestMethod.POST)
	public String userPrivilegesAdd(
			@ModelAttribute("userRolePrivilege") UserRolePrivilege userRolePrivilege,
			HttpServletRequest request, HttpServletResponse response,
			StockTransferBean stBean, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> listofMenusPris = null;
		UserRolePrivilege userRolePrivileges = null;
		List<UserRolePrivilege> listofuserRolePris = null;
		Privilege privilege = null;
		MenuItems menu = null;
		String roleId = request.getParameter("roleId");

		Iterator<Object[]> iterator = null;
		List<String> list = null;
		String url = null;
		try {
			getUserPrivilegeDetails(request);

			listofuserRolePris = new ArrayList<UserRolePrivilege>();
			listofMenusPris = userRolePrivilegeService.getMenusAndPrivilegs();
			iterator = listofMenusPris.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				privilege = (Privilege) objects[0];
				menu = (MenuItems) objects[1];
				String msg = request.getParameter(menu.getTitle() + ""
						+ privilege.getPrivilege());
				if (msg != null) {
					if (msg.equals("on")) {
						userRolePrivileges = new UserRolePrivilege();
						String roleIds = userRolePrivilege.getRoleId();
						String userIds = userRolePrivilege.getUserId();
						userRolePrivileges.setRoleId(roleIds);
						userRolePrivileges.setUserId(userIds);

						userRolePrivileges.setMenuId(String.valueOf(menu
								.getMenuId()));
						userRolePrivileges.setPrivilegeId(privilege
								.getPrivilegeid());
						listofuserRolePris.add(userRolePrivileges);
					}
				}
			}
			int suumsg = userRolePrivilegeService
					.saveUserRolePriviligeDetails(listofuserRolePris);
			if (suumsg == 1) {
				list = new ArrayList<String>();
				list.add("1");
				url = "redirect:userRolePrivilegeHome.mnt?list=" + list + "";

			} else {
				list = new ArrayList<String>();
				list.add("1");
				url = "redirect:userRolePrivilegeHome.mnt?listwar=" + list + "";

			}
			model.addAttribute("userRolePrivilege", new UserRolePrivilege());

		} catch (Exception e) {
			list = new ArrayList<String>();
			list.add("1");
			url = "redirect:userRolePrivilegeHome.mnt?listwar=" + list + "";
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping(value = "/userRolePrivlegeSearch", method = RequestMethod.GET)
	public String searchUserRolePrivlege(
			@ModelAttribute("userRolePrivilege") UserRolePrivilege userRolePrivilege,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// String msg = null;
		// String materialUpadte = null;
		// List<String> list = null;
		List<UserRolePrivilege> userRolePrivileges = null;
		// int id = organization.getOrgId();
		String dbField = userRolePrivilege.getXmlLabel();
		String operation = userRolePrivilege.getOperations();
		String basicSearchId = userRolePrivilege.getBasicSearchId();

		try {
			response.setCharacterEncoding("UTF-8");
			getUserPrivilegeDetails(request);

			if (basicSearchId == "") {

				userRolePrivileges = userRolePrivilegeService
						.searchUserRolePriviligeDetails();

			} else {

				String sql = null;
				String ids = null;
				if (dbField.equals("userId")) {
					sql = "select u.user_Id from Users u where u.userName='"
							+ basicSearchId + "'";
					ids = userRolePrivilegeService.getIds(sql);
				} else if (dbField.equals("roleId")) {
					sql = "select r.roleid from Role r where r.role='"
							+ basicSearchId + "'";
					ids = userRolePrivilegeService.getIds(sql);
				}

				if (operation.equals("_%")) {
					operation = " like ";
					ids = ids + "%";

				} else if (operation.equals("%_")) {
					operation = " like ";
					ids = "%" + ids;

				} else if (operation.equals("%_%")) {
					operation = " like ";
					ids = "%" + ids + "%";

				}

				userRolePrivileges = userRolePrivilegeService
						.basicSearchUserRolePriviligeDetails(dbField,
								operation, ids);

			}
			// model.addAttribute("userRolePrivilege",new UserRolePrivilege());
			request.setAttribute("userRolePrivilegesSearch", userRolePrivileges);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "userRolePriView";
	}

	@RequestMapping(value = "/userRolepriedit", method = RequestMethod.GET)
	public String editUserRolePrivilegs(
			@ModelAttribute("userRolePrivilege") UserRolePrivilege userRolePrivilege,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		// String msg = null;
		// String materialUpadte = null;
		// List<String> list = null;
		List<Object[]> listofvalues = null;
		String userId = request.getParameter("useriedit");
		String roleId = request.getParameter("roleIdEdit");
		userRolePrivilege.setUserIdEdit(userId);
		userRolePrivilege.setRoleIdEdit(roleId);
		Map<String, List<Privilege>> map = null;
		List<String> listofPrivilege = null;
		Privilege finalObjuspr = null;
		List<Privilege> lisfinalObjuspr = null;

		try {
			getUserPrivilegeDetails(request);
			map = new HashMap<String, List<Privilege>>();
			response.setCharacterEncoding("UTF-8");
			list = userRolePrivilegeService.getMenus();
			map = new LinkedHashMap<String, List<Privilege>>();
			listofPrivilege = new ArrayList<String>();

			Iterator<Object[]> iterator = list.iterator();
			if (iterator != null) {

				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					String main1 = (String) objects[2];
					// logger.info("List of menu objects are==="+objects[3]);
					lisfinalObjuspr = new ArrayList<Privilege>();
					if (main1 == null) {
					} else if (main1.equals("#")) {
					}
					List<Privilege> listofpris = userRolePrivilegeService
							.getprivilegeNames((Integer) objects[0]);
					List<Privilege> listOfUserRolePri = userRolePrivilegeService
							.getPrivilegeDetailsForEdit(userId, roleId,
									(Integer) objects[0]);
					Iterator<Privilege> liobjrpriiterator = listofpris
							.iterator();
					while (liobjrpriiterator.hasNext()) {
						Privilege liobjpri = (Privilege) liobjrpriiterator
								.next();
						finalObjuspr = new Privilege();
						boolean flag = false;
						if (listOfUserRolePri.size() != 0) {
							Iterator<Privilege> lisuserobjPriv = listOfUserRolePri
									.iterator();
							while (lisuserobjPriv.hasNext()) {
								Privilege lisuserObjpri = (Privilege) lisuserobjPriv
										.next();
								Privilege finalObjuspr1 = new Privilege();
								String edname = liobjpri.getPrivilege();
								String exname = "kk";
								if (lisuserObjpri.getPrivilege().equals(
										liobjpri.getPrivilege())) {
									String priceheck = lisuserObjpri
											.getPrivilege() + "check";
									finalObjuspr1.setPrivilege(priceheck);
								}
								Iterator<Privilege> iteedit = listOfUserRolePri
										.iterator();
								while (iteedit.hasNext()) {
									Privilege editPrivilegeo = (Privilege) iteedit
											.next();
									if (liobjpri.getPrivilege().equals(
											editPrivilegeo.getPrivilege())) {
										flag = true;
									}

								}
								if (flag == false) {
									finalObjuspr1.setPrivilege(liobjpri
											.getPrivilege());
									flag = true;
								}

								lisfinalObjuspr.add(finalObjuspr1);

							}

						} else {
							finalObjuspr.setPrivilege(liobjpri.getPrivilege());
							lisfinalObjuspr.add(finalObjuspr);
						}
					}
					map.put((String) objects[1], lisfinalObjuspr);
				}
			}
			request.setAttribute("editvalues", "c");
			request.setAttribute("editprivileges", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userRolePriView";
	}

	@RequestMapping(value = "/userRolepriDelete", method = RequestMethod.GET)
	public String deleteUserRolePrivileges(
			@ModelAttribute("userRolePrivilege") UserRolePrivilege userRolePrivilege,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int msg = 0;
		int id = 0;
		String url = null;
		String userId = request.getParameter("userRolepriDelete");
		String roleId = request.getParameter("roleIdDelete");

		try {
			getUserPrivilegeDetails(request);
			response.setCharacterEncoding("UTF-8");

			logger.info("delete id iss==" + id);
			msg = userRolePrivilegeService.deleteUserRolePris(roleId, userId);

			if (msg == 1) {

				request.setAttribute("userRolePriDelete",
						"UserRolePrivileges Data Deleted Successfully");
			} else {
				request.setAttribute("userRolePriDeleteError",
						"UserRolePrivileges Data is not  Deleted properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userRolePriView";
	}

	@RequestMapping(value = "/userRolePlgUpdate", method = RequestMethod.POST)
	public String roleUserUpdate(
			@ModelAttribute("userRolePrivilege") UserRolePrivilege userRolePrivilege,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int msg = 0;
		int id = 0;
		List<Object[]> listofMenusPris = null;
		UserRolePrivilege userRolePrivileges = null;
		List<UserRolePrivilege> listofuserRolePris = null;
		Privilege privilege = null;
		MenuItems menu = null;

		getUserPrivilegeDetails(request);
		Iterator<Object[]> iterator = null;
		try {
			getUserPrivilegeDetails(request);
			listofuserRolePris = new ArrayList<UserRolePrivilege>();
			listofMenusPris = userRolePrivilegeService.getMenusAndPrivilegs();
			iterator = listofMenusPris.iterator();
			String roleIdsa = userRolePrivilege.getRoleIdEdit();
			String userIdsa = userRolePrivilege.getUserIdEdit();
			String privilegeName = null;
			String msgq = null;
			String uppris = null;
			int savmsg = 0;
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				privilege = (Privilege) objects[0];
				menu = (MenuItems) objects[1];
				privilegeName = privilege.getPrivilege() + "check";
				uppris = request.getParameter(menu.getTitle() + ""
						+ privilegeName);
				msgq = request.getParameter(menu.getTitle() + ""
						+ privilege.getPrivilege());

				userRolePrivileges = new UserRolePrivilege();
				if (msgq != null) {
					if (msgq.equals("on")) {

						String roleIds = userRolePrivilege.getRoleIdEdit();
						String userIds = userRolePrivilege.getUserIdEdit();
						userRolePrivileges.setRoleId(roleIds);
						userRolePrivileges.setUserId(userIds);
						userRolePrivileges.setMenuId(String.valueOf(menu
								.getMenuId()));
						userRolePrivileges.setPrivilegeId(privilege
								.getPrivilegeid());
						listofuserRolePris.add(userRolePrivileges);
					}
				}
				if (uppris != null) {
					if (uppris.equals("on")) {
						String roleIds = userRolePrivilege.getRoleIdEdit();
						String userIds = userRolePrivilege.getUserIdEdit();
						userRolePrivileges.setRoleId(roleIds);
						userRolePrivileges.setUserId(userIds);
						userRolePrivileges.setMenuId(String.valueOf(menu
								.getMenuId()));
						userRolePrivileges.setPrivilegeId(privilege
								.getPrivilegeid());
						listofuserRolePris.add(userRolePrivileges);
					}
				}

			}
			String succmsg = userRolePrivilegeService
					.deleteUserrolePriswithuidpid(userIdsa, roleIdsa);
			savmsg = userRolePrivilegeService
					.saveUserRolePriviligeDetails(listofuserRolePris);

			if (savmsg == 1) {
				request.setAttribute("userRolePriUpdate",
						"UserRolePrivileges Data Updated Successfully");
			} else {
				request.setAttribute("userRolePriUpdateError",
						"UserRolePrivileges Data is not  Updated properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userRolePriView";
	}

	public String getUserPrivilegeDetails(HttpServletRequest request) {
		Iterator<Object[]> iterator = null;
		HashMap<String, List<Privilege>> menuPrivileges = null;
		List<String> main = null;
		List<String> sub = null;
		List<String> listofMenus = null;
		List<String> listofPrivilege = null;
		try {
			main = new ArrayList<String>();
			sub = new ArrayList<String>();

			menuPrivileges = new LinkedHashMap<String, List<Privilege>>();

			list = userRolePrivilegeService.getMenus();

			listofPrivilege = new ArrayList<String>();
			iterator = list.iterator();
			if (iterator != null) {
				listofMenus = new ArrayList<String>();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					String main1 = (String) objects[2];
					// logger.info("List of menu objects are==="+objects[3]);

					/*
					 * if (main1 == null) { main.add((String) objects[1]); }
					 * 
					 * else if (main1.equals("#")) { sub.add((String)
					 * objects[1]); } else {
					 */
					List<Privilege> listofpris = userRolePrivilegeService
							.getprivilegeNames((Integer) objects[0]);
					listofMenus.add((String) objects[1]);
					menuPrivileges.put((String) objects[1], listofpris);

				}
			}

			/* geting privilegs */
			list = userRolePrivilegeService.getPrivileges();
			Iterator<Object[]> iterator1 = list.iterator();
			while (iterator1.hasNext()) {
				Object[] objects = (Object[]) iterator1.next();
				listofPrivilege.add((String) objects[1]);

			}
			// request.setAttribute("menus",listofMenus);
			request.setAttribute("privileges", listofPrivilege);
			request.setAttribute("mapofprivileges", menuPrivileges);

			// model.addAttribute("userRolePrivilege", new UserRolePrivilege());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@ModelAttribute("roles")
	public Map<String, String> populateRole() {
		Map<String, String> map = null;
		try {
			String sql = "select r.roleid,r.role from Role r";
			map = populateService.populatePopUp(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("users")
	public Map<String, String> populateUsers() {
		Map<String, String> map = null;
		try {
			String sql = "select r.user_Id,r.userName from Users r";
			map = populateService.populatePopUp(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "userRolePrivilegeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// userRpDuplicateCheck

	@RequestMapping(value = "/userRpDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkrfqnameEdit(HttpServletRequest request,
			HttpServletResponse response, Model model,
			UserRolePrivilege userRolePrivilege) {

		Long pname = null;
		String msgedit = null;
		try {

			String userId = request.getParameter("userId");
			String roleId = request.getParameter("roleId");
			logger.info("userrole priviliges duplicate check iss ajax call==");

			pname = userRolePrivilegeService.userPrivDuplicateCheck(userId,
					roleId);
			logger.info("userrole priviliges duplicate check iss==" + pname);

			if (pname != 0) {

				msgedit = "Warning !This User and Role  is already exists";

			}
			if (pname == 0) {
				msgedit = null;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msgedit;
	}

}
