/**
 *copyright MNTSoft
 * 
 */
package com.mnt.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.mnt.erp.bean.Warehouse;
import com.mnt.erp.bean.Warehouse;
import com.mnt.erp.service.WarehouseService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * @version 1.0 12-11-2013
 * @build 0.0
 * 
 */
@Controller
public class WarehouseController {
	@Autowired
	WarehouseService warehouseService;
	@Autowired
	XmlLabelsService xmlService;
	List<Warehouse> warehouseList = null;
	List<Warehouse> warehouse1 = null;
	List<Object[]> objectsArray = null;
	Iterator<Object[]> iterator = null;
	Object[] objects2 = null;
	Warehouse mm = null;

	@RequestMapping(value = "/warehouseHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView WareHouse(
			@ModelAttribute("warehouseAdd") Warehouse wareHouse,
			SessionStatus status, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("warehouseHome", "warehouseAdd",
				new Warehouse());
	}

	@RequestMapping(value = "/warehouseAdd", method = RequestMethod.GET)
	@RequestScoped
	public String savewareHouseDetails(
			@ModelAttribute("warehouseAdd") @Valid Warehouse warehouseAddd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msa = null;
		Long duplicateId = 0l;

		try {
			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				warehouseAddd.setAid(1);
				return "warehouseHome";
			}
			// this method is used to check the Duplicates
			duplicateId = warehouseService
					.duplicateWareHouseCheck(warehouseAddd.getWarehouse());
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveStorageTypeDetails this method is used to save
				// StorageType Details
				msa = warehouseService.saveWareHouseDetails(warehouseAddd);
				model.addAttribute("warehouseAdd", new Warehouse());
				if (msa.equals("success")) {
					warehouseAddd.setAid(0);
					request.setAttribute("warehouseSave",
							"WareHouse Details Saved Successfully");
					model.addAttribute("warehouseAdd", warehouseAddd);
					return "warehouseHome";
				} else if (msa.equals("failure")) {

					warehouseAddd.setAid(1);
					request.setAttribute("warehouseSaveFail",
							"Error occurred while saving WareHouse details");
					model.addAttribute("warehouseAdd", warehouseAddd);
					return "warehouseHome";
				}
			} else {

				request.setAttribute("WareHouseDuplicate",
						"WareHouse Name  Already exist");
				warehouseAddd.setAid(1);
				return "warehouseHome";
			}

			return "warehouseHome";
		} catch (Exception e) {
			e.printStackTrace();
			warehouseAddd.setAid(1);
			request.setAttribute("warehouseSaveFail",
					"Error occurred while saving WareHouse details");
			model.addAttribute("warehouseAdd", warehouseAddd);
			return "warehouseHome";
		}

	}

	@ModelAttribute("CountrySearchIds")
	public Map<String, String> populatecountrySearchIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = warehouseService.selectCountryIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				String cid = objects[0].toString();
				map.put(cid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/warehouseSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchStorageType(@ModelAttribute Warehouse warehouseSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<Warehouse> warehouseBean = new ArrayList<Warehouse>();
		try {
			String dbField = warehouseSearch.getXmlLabel();
			String operation = warehouseSearch.getOperations();
			String basicSearchId = warehouseSearch.getBasicSearchId();

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
				list = warehouseService.searchWareHouse();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Warehouse wh = new Warehouse();
					Object[] obj = (Object[]) iterator.next();
					wh.setWarehouseId((Integer) obj[0]);
					wh.setWarehouse((String) obj[1]);
					wh.setAddress((String) obj[2]);
					wh.setCity((String) obj[3]);
					wh.setState((String) obj[4]);
					wh.setCountryId((String) obj[5]);
					wh.setZip((String) obj[6]);
					wh.setPhone1((String) obj[7]);
					wh.setPhone2((String) obj[8]);
					wh.setFax((String) obj[9]);
					wh.setCountryName((String) obj[10]);

					warehouseBean.add(wh);

				}
			} else {
				list = warehouseService.basicSearchWareHouse(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Warehouse wh = new Warehouse();
					Object[] obj = (Object[]) iterator.next();
					wh.setWarehouseId((Integer) obj[0]);
					wh.setWarehouse((String) obj[1]);
					wh.setAddress((String) obj[2]);
					wh.setCity((String) obj[3]);
					wh.setState((String) obj[4]);
					wh.setCountryId((String) obj[5]);
					wh.setZip((String) obj[6]);
					wh.setPhone1((String) obj[7]);
					wh.setPhone2((String) obj[8]);
					wh.setFax((String) obj[9]);
					wh.setCountryName((String) obj[10]);

					warehouseBean.add(wh);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("warehouseSearch", warehouseBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("warehouseAdd", warehouseSearch);

		return "warehouseHome";
	}

	@ModelAttribute("warehouseSearchNames")
	public Map<String, String> populatewarehouseSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = warehouseService.selectWareHouseNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String whid = Integer.toString((Integer) objects[0]);
				map.put(whid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "warehouseId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/warehouseEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String warehouseEdit(@ModelAttribute Warehouse warehouseDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String warehousename = request.getParameter("warehouseDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<Warehouse> warehousesList = new ArrayList<Warehouse>();

		try {

			list = warehouseService.searchWareHouseWithId(warehousename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();

				warehouseDisplay.setWarehouseIdEdit((Integer) object[0]);
				warehouseDisplay.setWarehouseEdit((String) object[1]);
				warehouseDisplay.setAddressEdit((String) object[2]);
				warehouseDisplay.setCityEdit((String) object[3]);
				warehouseDisplay.setStateEdit((String) object[4]);
				warehouseDisplay.setCountryIdEdit((String) object[5]);
				warehouseDisplay.setZipEdit((String) object[6]);
				warehouseDisplay.setPhone1Edit((String) object[7]);
				warehouseDisplay.setPhone2Edit((String) object[8]);
				warehouseDisplay.setFaxEdit((String) object[9]);

				warehousesList.add(warehouseDisplay);

			}
			request.setAttribute("warehouseValues", warehousesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("warehouseAdd", warehouseDisplay);
		return "warehouseHome";

	}

	@RequestMapping(value = "/warehouseUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateStorageType(
			@ModelAttribute("warehouseAdd") Warehouse warehouse,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = warehouseService.updateDuplicateCheck(
					warehouse.getWarehouseEdit(),
					warehouse.getWarehouseIdEdit());

			if (duplicateId == 0) {
				warehouse.setWarehouseId(warehouse.getWarehouseIdEdit());
				warehouse.setWarehouse(warehouse.getWarehouseEdit());
				warehouse.setAddress(warehouse.getAddressEdit());
				warehouse.setCity(warehouse.getCityEdit());
				warehouse.setState(warehouse.getStateEdit());
				warehouse.setCountryId(warehouse.getCountryIdEdit());
				warehouse.setZip(warehouse.getZipEdit());
				warehouse.setPhone1(warehouse.getPhone1Edit());
				warehouse.setPhone2(warehouse.getPhone2Edit());
				warehouse.setFax(warehouse.getFaxEdit());

				String msg = warehouseService.updateWareHouse(warehouse);

				if (msg.equals("Warehouse Details Updated Successfully")) {
					request.setAttribute("warehouseUpadteSuccess",
							"Warehouse Details Updated Successfully");
				} else {
					request.setAttribute("warehouseValues", "hello");

					request.setAttribute("warehouseUpadteFail",
							"Warehouse Details has Not Updated");
					return "warehouseHome";
				}
			} else {
				request.setAttribute("warehouseEditDuplicate",
						"Warehouse Name Already exist");
				request.setAttribute("warehouseValues", "hello");

				return "warehouseHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("warehouseAdd", new Warehouse());

		return "warehouseHome";

	}

	@RequestMapping(value = "/warehouseDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView warehouseDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int warehouseId = 0;

		try {
			warehouseId = Integer.parseInt(request
					.getParameter("warehouseIdDelete"));
			String msg = warehouseService.WareHouseDelete(warehouseId);

			if (msg.equals("Warehouse Details Deleted Successfully")) {
				request.setAttribute("warehouseUpadteSuccess",
						"Warehouse Deleted Successfully");
			} else {
				request.setAttribute("warehouseUpadteFail",
						"warehouse Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("warehouseUpadteFail",
					"warehouse Did Not Deleted");
		}
		return new ModelAndView("warehouseHome", "warehouseAdd",
				new Warehouse());
	}

	@RequestMapping(value = "/warehouseAdvanceSearch", method = RequestMethod.GET)
	public String warehouseAdvanceSearch(
			@ModelAttribute("warehouseAdd") Warehouse warehouse,
			HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("came to search");
		// String
		// advanceSearchHidden=request.getParameter("advanceSearchHidden");

		String name1 = "warehouseId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Warehouse v=null;
		warehouseList = new ArrayList();
		warehouse.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			// Iterator it=returnString.iterator();
			for (Object[] object : returnString) {
				Warehouse v = new Warehouse();

				s1 = (String) object[0];
				s2 = (String) object[1];

				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				warehouseList.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("warehouseSearchAdvance", warehouseList);

		return "warehouseHome";
	}

	@RequestMapping(value = "/warehouseAdvanceSearchOperations", method = RequestMethod.POST)
	public String warehouseAdvanceSearchOperations(
			@ModelAttribute Warehouse warehouse, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		warehouse1 = new ArrayList<Warehouse>();
		String columns = warehouse.getFirstLabel();
		String operations = warehouse.getOperations1();
		String advanceSearchText = warehouse.getAdvanceSearchText();
		// System.out.println("advanceSearchText"+advanceSearchText);
		// System.out.println("First Labels "+name);
		// System.out.println("kiran u selected"+name);
		if (advanceSearchText.length() != 0) {
			// System.out.println("came to advance"+advanceSearchText.length());
			objectsArray = warehouseService.getWarehouseAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = warehouseService.searchWareHouse();
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.Warehouse();
			objects2 = (Object[]) iterator.next();
			mm.setWarehouseId((Integer) objects2[0]);
			mm.setWarehouse((String) objects2[1]);
			mm.setAddress((String) objects2[2]);
			mm.setCity((String) objects2[3]);
			mm.setState((String) objects2[4]);
			mm.setCountryId((String) objects2[5]);
			mm.setZip((String) objects2[6]);
			mm.setPhone1((String) objects2[7]);
			mm.setPhone2((String) objects2[8]);
			mm.setFax((String) objects2[9]);
			mm.setCountryName((String) objects2[10]);

			/*
			 * String blocked=(String)objects2[13]; if(blocked.equals("0")) {
			 * blocked="YES"; } else { blocked="NO"; }
			 */

			warehouse1.add(mm);
			// System.out.println((String)objects2[0]);
		}

		/*
		 * ModelAndView model=new ModelAndView();
		 * model.setViewName("BomCategorySearch");
		 * model.addObject("searchBom",BomCategory); return model;
		 */

		// return new ModelAndView("MaterialCategorySearch");

		request.setAttribute("warehouseSearch", warehouse1);
		model.addAttribute("warehouseAdd", new Warehouse());

		return "warehouseHome";
	}
}
