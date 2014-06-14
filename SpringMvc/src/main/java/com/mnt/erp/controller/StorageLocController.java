/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.StorageLocOrg;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CountryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.StorageLocationService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author pvenkateswarlu
 * @version 1.0 23-09-2013
 */
@Controller
public class StorageLocController {
	@Autowired
	PlantService plantService;
	@Autowired
	CountryService countryService;
	@Autowired
	OrganizationService organizationService;
	@Autowired
	StorageLocationService storageLocationService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	List<StorageLocation> storage1;
	String name;
	StorageLocation sl;
	Object[] objects2;

	List<Object[]> objectsArray;
	int id = 0;
	Iterator<Object[]> iterator;
	List<StorageLocation> storageList;

	String msg;
	String storageUpadte;
	List<String> list;
	int[] orgids;
	StorageLocOrg storageLocOrg;
	Set<StorageLocOrg> listLocOrgs;

	@ModelAttribute("plantIds")
	public Map<Integer, String> populatePlantIds() {
		Map<Integer, String> map = null;
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		try {
			map = new HashMap<Integer, String>();
			list = plantService.getPlantIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
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

	@ModelAttribute("storageName")
	public Map<Integer, String> populatestorageName() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		try {
			list = storageLocationService.getStorageIds();
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

	@RequestMapping(value = "/storageLocHome", method = RequestMethod.GET)
	public String gotoStorage(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");
			model.addAttribute("storageLocation", new StorageLocation());
			HttpSession session = request.getSession(false);
			List<String> list = menuService.getPrivilige("storageLocHome.mnt",
					session.getAttribute("userId").toString());
			session.setAttribute("privilegeList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "storageLoc";
	}

	@RequestMapping(value = "/storageLocAdd", method = RequestMethod.POST)
	public String saveStorageLocation(
			@ModelAttribute StorageLocation storageLocation, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		Long duplicateId = 0l;
		String result = null;
		HttpSession session = null;
		try {
			response.setCharacterEncoding("UTF-8");
			duplicateId = storageLocationService.duplicateCheck(storageLocation
					.getStorageLocation());
			if (duplicateId == 0) {
				session = request.getSession(false);
				msg = storageLocationService.saveStoragLocation(
						storageLocation, session.getAttribute("userId")
								.toString(), session.getAttribute("userName")
								.toString());
				if (msg.equals("S")) {

					result = "redirect:storageLocHome.mnt?list=" + "success"
							+ "";
				} else {

					result = "redirect:storageLocHome.mnt?listw=" + "fail" + "";
				}

				model.addAttribute("storageLocation", new StorageLocation());
			} else {
				storageLocation.setAid(1);
				request.setAttribute("duplicate",
						"Storage Location is already exists. Please try some other name");
				return "storageLoc";

			}

		} catch (Exception e) {

			result = "redirect:storageLocHome.mnt?listw=" + "fail" + "";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/storageSearch", method = RequestMethod.GET)
	public String searchStorageLocation(
			@ModelAttribute StorageLocation storageLocation, Model model,
			HttpServletRequest request, HttpServletResponse response) {

		List<StorageLocation> list = null;
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			// int id = storageLocation.getStorageLocationId();
			String dbField = storageLocation.getXmlLabel();
			String operation = storageLocation.getOperations();
			String basicSearchId = storageLocation.getBasicSearchId();

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

				list = storageLocationService.searchStorageLocation();

			} else {
				// list = storageLocationService.searchStorageWithId(id);
				list = storageLocationService.basicSearchStorageLoc(dbField,
						operation, basicSearchId);
			}
			request.setAttribute("storageSearch", list);
			model.addAttribute("storageLocation", storageLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "storageLoc";
	}

	@RequestMapping(value = "/storageLocEdit", method = RequestMethod.GET)
	public String editStorageLocation(
			@ModelAttribute StorageLocation storageLocation, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		int id = 0;
		List<StorageLocation> list = null;
		Iterator<StorageLocation> iterator = null;
		StorageLocation location = null;
		Set<StorageLocOrg> storageLocOrgs = null;
		List<Integer> integers = null;
		StorageLocOrg locOrg = null;
		try {
			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request.getParameter("storageLocEdit"));
			integers = new ArrayList<Integer>();
			list = storageLocationService.searchStorageWithId(id);

			storageLocOrgs = new HashSet<StorageLocOrg>();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				location = (StorageLocation) iterator.next();
				storageLocation.setStorageLocationIdEdit(location
						.getStorageLocationId());
				storageLocation.setStorageLocationEdit(location
						.getStorageLocation());
				storageLocation.setAdd1Edit(location.getAdd1());
				storageLocation.setAdd2Edit(location.getAdd2());
				storageLocation.setAdd3Edit(location.getAdd3());
				storageLocation.setCityEdit(location.getCity());
				storageLocation.setCountryEdit(location.getCountry());
				storageLocation.setFaxEdit(location.getFax());
				storageLocation.setMobileEdit(location.getMobile());
				storageLocation.setPhoneEdit(location.getPhone());
				storageLocation.setPlantIdEdit(location.getPlantId());
				storageLocation.setStateEdit(location.getState());
				storageLocation.setZipEdit(location.getZip());

			}
			request.setAttribute("storageSearchEdit", list);
			model.addAttribute("storageLocation", storageLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "storageLoc";
	}

	@RequestMapping(value = "/storageDelete", method = RequestMethod.GET)
	public String deleteStorage(
			@ModelAttribute StorageLocation storageLocation, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String msg = null;
		int id = Integer.parseInt(request.getParameter("storageDelete"));
		HttpSession session = null;
		try {
			response.setCharacterEncoding("UTF-8");
			storageLocation.setStorageLocationId(id);
			msg = storageLocationService.deleteStorageLoc(storageLocation);
			if (msg.equals("S")) {

				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Storage Location", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				request.setAttribute("storageDelete",
						"Storage Location Data is deleted successfully");
			} else {
				request.setAttribute("storageDeleteError",
						"Storage Location Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("storageLocation", new StorageLocation());
		return "storageLoc";
	}

	@RequestMapping(value = "/storageUpdate", method = RequestMethod.POST)
	public String updateStorage(
			@ModelAttribute("storageLocation") StorageLocation storageLocation,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String msg = null;
		Long dupId = 0l;
		try {
			response.setCharacterEncoding("UTF-8");
			dupId = storageLocationService.updateDuplicateCheck(
					storageLocation.getStorageLocationEdit(),
					storageLocation.getStorageLocationIdEdit());
			if (dupId == 0) {

				storageLocation.setStorageLocationId(storageLocation
						.getStorageLocationIdEdit());

				storageLocation.setAdd1(storageLocation.getAdd1Edit());
				storageLocation.setAdd2(storageLocation.getAdd2Edit());
				storageLocation.setAdd3(storageLocation.getAdd3Edit());
				storageLocation.setCity(storageLocation.getCityEdit());
				storageLocation.setCountry(storageLocation.getCountryEdit());
				storageLocation.setFax(storageLocation.getFaxEdit());
				storageLocation.setMobile(storageLocation.getMobileEdit());
				/*
				 * orgids = storageLocation.getOrgIdEdit();
				 * 
				 * listLocOrgs = new HashSet<StorageLocOrg>(); for (Integer
				 * integer : orgids) { storageLocOrg = new StorageLocOrg();
				 * storageLocOrg.setOrgId(integer);
				 * 
				 * listLocOrgs.add(storageLocOrg); }
				 * storageLocation.setStorageLocOrgs(listLocOrgs);
				 */
				storageLocation.setPhone(storageLocation.getPhoneEdit());
				storageLocation.setPlantId(storageLocation.getPlantIdEdit());
				storageLocation.setState(storageLocation.getStateEdit());
				storageLocation.setStorageLocation(storageLocation
						.getStorageLocationEdit());
				storageLocation.setZip(storageLocation.getZipEdit());
				msg = storageLocationService
						.updateStorageLocation(storageLocation);

				if (msg.equals("S")) {
					request.setAttribute("storageUpdate",
							"Storage Location Data is updated successfully");
				} else {
					request.setAttribute("storageUpdateError",
							"Storage Location Data is not updated properly");
				}
			} else {
				request.setAttribute("storageSearchEdit", "Edit Tab Active");
				request.setAttribute("storageLocUpdateDup",
						"Storage Location Name is already exists. Please try some other name");
				return "storageLoc";
			}
		} catch (Exception e) {
			request.setAttribute("storageUpdateError",
					"Storage Location Data is not updated properly");

			e.printStackTrace();
			return "storageLoc";
		}
		model.addAttribute("storageLocation", new StorageLocation());
		return "storageLoc";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "storageLocationId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/storageAdvanceSearch", method = RequestMethod.GET)
	public String storageAdvanceSearch(
			@ModelAttribute("storageLocation") StorageLocation storage,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "storage", s1 = null, s2 = null;

		List<Object[]> returnString = null;

		storageList = new ArrayList<StorageLocation>();
		storage.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);

			for (Object[] object : returnString) {
				StorageLocation s = new StorageLocation();

				s1 = (String) object[0];
				s2 = (String) object[1];
				s.setFirstLabel(s1);

				s.setSecondLabel(s2);
				storageList.add(s);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("storageSearchAdvance", storageList);
		return "storageLoc";
	}

	@RequestMapping(value = "/storageAdvanceSearchOperations", method = RequestMethod.POST)
	public String storageAdvanceSearchOperations(
			@ModelAttribute StorageLocation storage,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		storage1 = new ArrayList<StorageLocation>();
		String columns = storage.getFirstLabel();
		String operations = storage.getOperations1();
		String advanceSearchText = storage.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = storageLocationService.getStorageAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = storageLocationService.getStorage("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			sl = new com.mnt.erp.bean.StorageLocation();
			objects2 = (Object[]) iterator.next();

			sl.setStorageLocationId((Integer) objects2[0]);
			sl.setStorageLocation((String) objects2[1]);
			sl.setAdd1((String) objects2[2]);
			sl.setAdd2((String) objects2[3]);
			sl.setAdd3((String) objects2[4]);
			sl.setCity((String) objects2[5]);
			CountrysList countrysList = new CountrysList();
			countrysList = (CountrysList) objects2[12];
			sl.setState((String) objects2[6]);
			sl.setPhone((String) objects2[7]);
			sl.setFax((String) objects2[8]);
			sl.setMobile((String) objects2[9]);
			sl.setZip((String) objects2[10]);
			sl.setCountry(String.valueOf(countrysList.getCountryId()));
			sl.setCountryName(countrysList.getCountryName());
			Plant plant = new Plant();
			plant = (Plant) objects2[11];
			sl.setPlantId(String.valueOf(plant.getPlantId()));
			sl.setPlantName(plant.getPlantName());
			storage1.add(sl);
		}
		request.setAttribute("storageSearch", storage1);
		model.addAttribute("storage", new StorageLocation());
		storage.setAdvanceSearchHidden(0);
		return "storageLoc";
	}

}
