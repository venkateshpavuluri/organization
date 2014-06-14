/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.controller;

/**
 * @author pvenkateswarlu
 *@version 1.0 18-09-2013
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.OrganizationType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CountryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.OrganizationTypeService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class OrganizationController {
	@Autowired
	OrganizationTypeService organizationTypeService;
	@Autowired
	CountryService countryService;
	@Autowired
	OrganizationService organizationService;
	@Autowired
	MenuService menuService;
	@Autowired
	ReloadableResourceBundleMessageSource messageSource;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	ServletContext context;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	CookieLocaleResolver localeResolver;

	static Logger logger = Logger.getLogger(OrganizationController.class);

	List<Organization> organization1 = null;
	String name = null;
	Organization org = null;
	Object[] objects2 = null;

	List<Object[]> objectsArray = null;
	int id = 0;
	Iterator<Object[]> iterator = null;
	List<Organization> organizationList = null;

	@RequestMapping(value = "/organizationHome", method = RequestMethod.GET)
	public String gotoOrganization(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			model.addAttribute("organization", new Organization());
			HttpSession session = request.getSession(false);
			List<String> list = menuService.getPrivilige(
					"organizationHome.mnt", session.getAttribute("userId")
							.toString());
			session.setAttribute("privilegeList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "organization";
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

	@ModelAttribute("country")
	public Map<Integer, String> populateCountry() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		try {
			list = countryService.getCountryIds();
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

	@RequestMapping(value = "/organizationAdd", method = RequestMethod.POST)
	@Scope("request")
	public String saveOrganization(@ModelAttribute Organization organization,
			Model model, BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("imageFile") MultipartFile file1) {
		String msg = null;
		Long id = 0l;
		String res = null;
		HttpSession session = null;
		try {
			response.setCharacterEncoding("UTF-8");
			id = organizationService.duplicateCheck(organization.getOrgName());
			session = request.getSession(false);
			if (id == 0) {

				MultipartFile file = organization.getImageFile();

				organization.setImage(file1.getBytes());
				msg = organizationService.saveOrganizationDetails(organization,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());
				model.addAttribute("organization", new Organization());

				if (msg.equals("S")) {
					res = "redirect:organizationHome.mnt?list=" + "org" + "";
				} else {
					res = "redirect:organizationHome.mnt?listwar=" + "fail"
							+ "";
				}
			} else {

				request.setAttribute("duplicate",
						"Organization Name  is already exists. Please try some other name");
				organization.setAid(1);
				return "organization";
			}

		} catch (Exception e) {
			res = "redirect:organizationHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();

		}
		return res;

	}

	@ModelAttribute("orgName")
	public Map<Integer, String> populateOrgName() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		try {
			list = organizationService.getOrganizationIds();
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

	@RequestMapping(value = "/orgnizationSearch", method = RequestMethod.GET)
	public String searchOrganization(
			@ModelAttribute("organization") Organization organization,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<Organization> organizations = null;
		String dbField = organization.getXmlLabel();
		String operation = organization.getOperations();
		String basicSearchId = organization.getBasicSearchId();

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
		try {
			response.setCharacterEncoding("UTF-8");
			if (basicSearchId == "") {
				organizations = organizationService.searchOrganization();

			} else {
				organizations = organizationService.basicSearchOrganization(
						dbField, operation, basicSearchId);
			}
			request.setAttribute("organizationSearch", organizations);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "organization";
	}

	@RequestMapping(value = "/organizationEditHome", method = RequestMethod.GET)
	public String editOrganization(@ModelAttribute Organization organization,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<Organization> organizations = null;
		Iterator<Organization> iterator = null;
		Organization organizationEdit = null;
		int id = Integer.parseInt(request.getParameter("organizationEdit"));

		try {
			response.setCharacterEncoding("UTF-8");
			organizations = organizationService.searchOrganizationWithId(id);
			request.setAttribute("imageId", id);

			organizationEdit = new Organization();
			iterator = organizations.iterator();
			while (iterator.hasNext()) {
				organization = (Organization) iterator.next();
				organizationEdit.setOrgIdEdit(organization.getOrgId());
				organizationEdit.setAdd1Edit(organization.getAdd1());
				organizationEdit.setAdd2Edit(organization.getAdd2());
				organizationEdit.setAdd3Edit(organization.getAdd3());
				organizationEdit.setCityEdit(organization.getCity());
				organizationEdit.setCountryIdEdit(organization.getCountryId());
				organizationEdit.setEmailEdit(organization.getEmail());
				organizationEdit.setFaxEdit(organization.getFax());
				organizationEdit.setOrgTypeIdEdit(organization.getOrgTypeId());
				organizationEdit.setStateEdit(organization.getState());
				organizationEdit.setOrgNameEdit(organization.getOrgName());

				organizationEdit.setPhoneEdit(organization.getPhone());

				byte[] bytes = organization.getImage();
				if (bytes != null) {
					organizationEdit.setImageEdit(bytes);
					if (bytes.length > 0) {
						request.setAttribute("image", "image iss");
					}
				}

			}
			model.addAttribute("organization", organizationEdit);
			request.setAttribute("organizationValues", organizations);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "organization";
	}

	@RequestMapping(value = "/organizationUpdate", method = RequestMethod.POST)
	public String updateOrganization(
			@ModelAttribute("organization") Organization organization,
			Model model, HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("imageFile") MultipartFile file1) {
		String msg = null;
		Long duplicateId = 0l;
		try {
			response.setCharacterEncoding("UTF-8");
			duplicateId = organizationService.updateDuplicateCheck(
					organization.getOrgNameEdit(), organization.getOrgIdEdit());

			if (duplicateId == 0) {
				MultipartFile file = organization.getImageFile();

				if (file1.getBytes().length != 0) {
					organization.setImageEdit(file1.getBytes());
				}

				msg = organizationService.updateOrganization(organization);
				if (msg.equals("S")) {
					request.setAttribute("organizationUpdate",
							"Organization Data is updated Successfully");
				} else {
					request.setAttribute("organizationUpdateError",
							"Organization Data is not updated properly");
				}
			} else {

				request.setAttribute("organizationValues", "hello");
				request.setAttribute("orgUpdateDuplicate",
						"Organization Name is already exists. Please try some other name");
				return "organization";
			}

		} catch (Exception e) {
			request.setAttribute("organizationUpdateError",
					"Organization Data is not updated properly");
			e.printStackTrace();
		}
		model.addAttribute("organization", new Organization());
		return "organization";
	}

	@RequestMapping(value = "/organizationDelete", method = RequestMethod.GET)
	public String deleteOrganization(
			@ModelAttribute("organization") Organization organization,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String msg = null;
		int id = 0;
		HttpSession session = null;
		try {

			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request
					.getParameter("organizationCodeDelete"));
			msg = organizationService.deleteOrganization(id);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Organization", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());

				request.setAttribute("orgDelete",
						"Organization Data is deleted Successfully");
			} else {
				request.setAttribute("orgDeleteError",
						"Organization Data  is not deleted properly ");
			}
		} catch (Exception e) {
			request.setAttribute("orgDeleteError",
					"Organization Data  is not deleted properly ");
			e.printStackTrace();
		}
		model.addAttribute("organization", new Organization());
		return "organization";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "organizationId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/organiztionAdvanceSearch", method = RequestMethod.GET)
	public String organizationAdvanceSearch(
			@ModelAttribute("organization") Organization organization,
			HttpServletRequest request, HttpServletResponse response) {
		String name1 = "organization", s1 = null, s2 = null;
		List<Object[]> returnString = null;

		organizationList = new ArrayList<Organization>();
		organization.setAdvanceSearchHidden(1);
		List<Organization> refList = new ArrayList<Organization>();

		try {
			returnString = xmlService.populateXml(name1);

			for (Object[] object : returnString) {
				Organization o = new Organization();
				if ((boolean) object[2].equals("false")) {
					s1 = (String) object[0];
					s2 = (String) object[1];
					o.setFirstLabel(s1);
					o.setSecondLabel(s2);
					organizationList.add(o);
				} else {

					o.setFirstLabel((String) object[0]);
					o.setSecondLabel((String) object[1]);
					refList.add(o);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("organizationSearchAdvance", organizationList);
		request.setAttribute("refList", refList);
		return "organization";
	}

	@RequestMapping(value = "/organiztionAdvanceSearchOperations", method = RequestMethod.POST)
	public String organizationAdvanceSearchOperations(
			@ModelAttribute Organization organization,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		organization1 = new ArrayList<Organization>();
		String columns = organization.getFirstLabel();
		String operations = organization.getOperations1();
		String advanceSearchText = organization.getAdvanceSearchText();

		if (advanceSearchText.length()>3) {
			objectsArray = organizationService.getOrganizationAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = organizationService.getOrganization("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			org = new com.mnt.erp.bean.Organization();
			objects2 = (Object[]) iterator.next();
			org.setOrgId((Integer) objects2[0]);
			org.setOrgName((String) objects2[1]);
			org.setAdd1((String) objects2[2]);
			org.setAdd2((String) objects2[3]);
			org.setAdd3((String) objects2[4]);
			org.setCity((String) objects2[5]);
			org.setState((String) objects2[6]);
			CountrysList countrysList = new CountrysList();
			countrysList = (CountrysList) objects2[7];

			org.setCountry(countrysList.getCountryName());
			org.setPhone((String) objects2[8]);
			org.setFax((String) objects2[9]);
			org.setEmail((String) objects2[10]);

			OrganizationType organizationType = new OrganizationType();
			organizationType = (OrganizationType) objects2[11];
			org.setOrgTypeId(String.valueOf(organizationType.getOrgTypeId()));
			org.setOrgType(organizationType.getOrgType());
			organization1.add(org);

		}

		request.setAttribute("organizationSearch", organization1);
		model.addAttribute("organization", new Organization());

		return "organization";
	}

	@RequestMapping(value = "/imageEdit", method = RequestMethod.GET)
	public @ResponseBody
	String EditImage(@ModelAttribute Organization organization,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setContentType("image/jpg");
		try {
			int id = Integer.parseInt(request.getParameter("imageid"));
			List<Organization> organizations = organizationService
					.searchOrganizationWithId(id);
			Iterator<Organization> iterator = organizations.iterator();
			while (iterator.hasNext()) {
				organization = (Organization) iterator.next();
				request.setAttribute("imageValues", "image");
				byte[] bytes = organization.getImage();
				response.setContentType("image/jpg");
				if (bytes != null && bytes.length > 0) {
					response.getOutputStream().write(bytes);
				} else {
					byte[] ki = { 'N', 'O', ' ', 'I', 'M', 'A', 'G', 'E' };
					response.getOutputStream().write(ki);
				}
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "organization";
	}

}
