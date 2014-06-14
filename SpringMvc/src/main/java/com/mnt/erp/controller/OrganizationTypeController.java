/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.controller;

/**
 * @author pvenkateswarlu
 *@version 19-09-2013
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.mnt.erp.bean.OrganizationType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationTypeService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class OrganizationTypeController {
	private static Logger logger=Logger.getLogger(OrganizationTypeController.class);
	String msg = null;

	@Autowired
	OrganizationTypeService organizationTypeService;

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/organizationTypeHome", method = RequestMethod.GET)
	public String gotoOrganizationTypeHome(
			@ModelAttribute OrganizationType organizationType, Model model,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");
			String ho=null;
			logger.info(ho.charAt(1));
			model.addAttribute("organizationType", new OrganizationType());
			HttpSession session = request.getSession(false);
			List<String> list = menuService.getPrivilige(
					"organizationTypeHome.mnt", session.getAttribute("userId")
							.toString());
			session.setAttribute("privilegeList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "organizationType";
	}

	@RequestMapping(value = "/organizationTypeAdd", method = RequestMethod.POST)
	public String organizationAdd(
			@ModelAttribute OrganizationType organizationType, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String materialUpadte = null;
		List<String> list = null;
		Long duplicateId = 0l;
		String result = null;
		HttpSession session = null;
		try {
			response.setCharacterEncoding("UTF-8");
			duplicateId = organizationTypeService
					.duplicateCheck(organizationType.getOrgType());

			if (duplicateId == 0) {
				session = request.getSession(false);
				list = new ArrayList<String>();
				msg = organizationTypeService.saveOrganizationType(
						organizationType, session.getAttribute("userId")
								.toString(), session.getAttribute("userName")
								.toString());

				if (msg.equals("S")) {
					materialUpadte = "Organization Type Data is saved successfully";
					list.add("38wjk");
					result = "redirect:organizationTypeHome.mnt?success="
							+ materialUpadte + "&list=" + list + "";
				} else {
					materialUpadte = "Organization Type Data is  not saved properly";
					list.add("38wjk");
					result = "redirect:organizationTypeHome.mnt?warning="
							+ materialUpadte + "&listw=" + list + "";
				}

			} else {
				request.setAttribute("duplicate",
						"Organization Type  is already exists. Please try some other name");
				organizationType.setAid(1);
				return "organizationType";
			}
			model.addAttribute("organizationType", new OrganizationType());

		} catch (Exception e) {
			materialUpadte = "Organization Type Data is  not saved properly";
			list.add("38wjk");
			result = "redirect:organizationTypeHome.mnt?warning="
					+ materialUpadte + "&listw=" + list + "";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/organizationTypeSearch", method = RequestMethod.GET)
	public String searchOrganization(
			@ModelAttribute OrganizationType organizationType, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		Iterator<Object[]> iterator = null;
		List<Object[]> list = null;
		Object[] objects = null;
		OrganizationType organizationTypevalues = null;
		List<OrganizationType> organizationTypes = null;
		int id = 0;
		try {
			response.setCharacterEncoding("UTF-8");
			id = organizationType.getOrgTypeId();
			request.setCharacterEncoding("UTF-8");
			String dbField = organizationType.getXmlLabel();
			String operation = organizationType.getOperations();
			String basicSearchId = organizationType.getBasicSearchId();

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
			organizationTypes = new ArrayList<OrganizationType>();
			if (basicSearchId == "") {
				list = organizationTypeService.searchOrganizationType();
			} else {
				list = organizationTypeService.basicSearchOrgType(dbField,
						operation, basicSearchId);
			}
				iterator = list.iterator();
				while (iterator.hasNext()) {
					objects = (Object[]) iterator.next();
					organizationTypevalues = new OrganizationType();
					organizationTypevalues.setOrgTypeId((Integer) objects[0]);
					organizationTypevalues.setOrgType((String) objects[1]);
					organizationTypes.add(organizationTypevalues);

				}
			
			
				request.setAttribute("organizationTypeSearch",
						organizationTypes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "organizationType";
	}

	@ModelAttribute("organizationIds")
	public Map<Integer, String> populateOrganigationIds() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		try {
			list = organizationTypeService.getOrganizationTypeIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/organizationTypeEditHome", method = RequestMethod.GET)
	public String EditOrganizationType(
			@ModelAttribute("organizationType") OrganizationType organizationType,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		Iterator<Object[]> iterator = null;
		List<Object[]> list = null;
		Object[] objects = null;
		OrganizationType organizationTypevalues = null;
		List<OrganizationType> organizationTypes = null;
		int id = 0;
		try {

			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request.getParameter("organizationTypeEdit"));

			organizationTypes = new ArrayList<OrganizationType>();
			list = organizationTypeService.searchOrganizationTypeWithId(id);

			iterator = list.iterator();
			while (iterator.hasNext()) {
				iterator = list.iterator();
				while (iterator.hasNext()) {
					objects = (Object[]) iterator.next();

					organizationType.setOrgTypeIdEdit((Integer) objects[0]);
					organizationType.setOrgTypeEdit((String) objects[1]);
					organizationTypes.add(organizationType);
				}
				request.setAttribute("organizationTypeValues",
						organizationTypes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return
		// "redirect:organizationTypeHome.mnt?success="+materialUpadte+"&list="+list+"";
		return "organizationType";
	}

	@RequestMapping(value = "/organizationTypeUpdate", method = RequestMethod.POST)
	public String updateOrganizationType(
			@ModelAttribute("organizationType") OrganizationType organizationType,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		int id = 0;
		String orgTypeUpdate = null;
		Long duplicateId = 0l;
		try {
			response.setCharacterEncoding("UTF-8");

			duplicateId = organizationTypeService.updateDuplicateCheck(
					organizationType.getOrgTypeEdit(),
					organizationType.getOrgTypeIdEdit());

			if (duplicateId == 0) {
				organizationType.setOrgTypeId(organizationType
						.getOrgTypeIdEdit());
				organizationType.setOrgType(organizationType.getOrgTypeEdit());
				msg = organizationTypeService
						.updateOrganization(organizationType);
				if (msg.equals("S")) {
					orgTypeUpdate = "U";
					request.setAttribute("orgTypeUpdate", orgTypeUpdate);
				} else {

					request.setAttribute("orgTypeUpdateError", "U");

				}

				model.addAttribute("organizationType", new OrganizationType());
			} else {
				request.setAttribute("organizationTypeValues", "values");
				request.setAttribute("orgTypeUpdateDuplicate",
						"Organization Type  is already exists. Please try some other name");
				return "organizationType";

			}
		} catch (Exception e) {
			request.setAttribute("orgTypeUpdateError", "U");
			e.printStackTrace();
		}

		// return
		// "redirect:organizationTypeHome.mnt?success="+materialUpadte+"&list="+list+"";
		return "organizationType";
	}

	@RequestMapping(value = "/organizationTypeDelete", method = RequestMethod.GET)
	public String deleteOrganizationType(
			@ModelAttribute OrganizationType organizationType, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		int id = 0;
		String orgTypeUpdate = null;
		OrganizationType organizationType2 = null;
		try {
			response.setCharacterEncoding("UTF-8");

			id = Integer.parseInt(request
					.getParameter("organizationTypeCodeDelete"));
			organizationType.setOrgTypeId(id);
			msg = organizationTypeService
					.deleteOrganizationType(organizationType);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Organization Type", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());

				orgTypeUpdate = "D";
				request.setAttribute("orgTypeUpdate", orgTypeUpdate);
			} else {
				request.setAttribute("orgTypeUpdateError", "D");
				// orgTypeUpdate =
				// "Organization Type  data  is not  deleted properly";
			}
			organizationType2 = new OrganizationType();

			model.addAttribute("organizationType", organizationType2);
		} catch (Exception e) {
			request.setAttribute("orgTypeUpdateError", "D");
			e.printStackTrace();
		}
		// return
		// "redirect:organizationTypeHome.mnt?success="+materialUpadte+"&list="+list+"";
		return "organizationType";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "orgTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
