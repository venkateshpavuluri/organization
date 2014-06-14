/**
copyright MNT Soft
 * 
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.mnt.erp.bean.Vehicle;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VehicleService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * @version 1.0 29-10-2013
 * @build 0.0
 * 
 */
@Controller
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	List<Vehicle> vehicleList = null;
	List<Vehicle> vehicle1 = null;
	List<Object[]> objectsArray = null;
	Iterator<Object[]> iterator = null;
	Object[] objects2 = null;
	Vehicle mm = null;

	@RequestMapping(value = "/vehicleHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView vehicleType(
			@ModelAttribute("vehicleAdd") Vehicle vehicle,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("vehicleHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("vehicleHome", "vehicleAdd", new Vehicle());
	}

	@RequestMapping(value = "/vehicleAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveVehicleDetails(
			@ModelAttribute("vehicleAdd") @Valid Vehicle vehicleAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String createdDate = formatter.format(currentDate.getTime());
		vehicleAdd.setCreateDate(createdDate);
		String msa = null;
		Long duplicateId = 0l;
		HttpSession session = null;
		String res = null;

		try {

			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				vehicleAdd.setAid(1);
				return "vehicleHome";
			}

			duplicateId = vehicleService.duplicateVehicleCheck(vehicleAdd
					.getRegistrationNum());
			if (duplicateId == 0) {
				session = request.getSession(false);
				msa = vehicleService.saveVehicleDetails(vehicleAdd, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());
				model.addAttribute("vehicleAdd", new Vehicle());
				if (msa.equals("S")) {
					res = "redirect:vehicleHome.mnt?list=" + "success" + "";

				} else {
					res = "redirect:vehicleHome.mnt?listwar=" + "fail" + "";

				}
			} else {

				request.setAttribute("VehicleDuplicate",
						"Vehicle Registration Number  Already exist");
				vehicleAdd.setAid(1);
				return "vehicleHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:vehicleHome.mnt?listwar=" + "fail" + "";

		}

		return "redirect:vehicleHome.mnt?list=" + "success" + "";
	}

	@ModelAttribute("VehicleTypeIds")
	public Map<String, String> populateVehicleTypeIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = vehicleService.selectVehicleTypeIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				String vehid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));

				map.put(vehid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/vehicleSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchVehicle(@ModelAttribute Vehicle vehicleSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<Vehicle> vehicleBean = new ArrayList<Vehicle>();

		try {

			String dbField = vehicleSearch.getXmlLabel();
			String operation = vehicleSearch.getOperations();
			String basicSearchId = vehicleSearch.getBasicSearchId();

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
				list = vehicleService.searchVehicle();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Vehicle vt = new Vehicle();
					Object[] obj = (Object[]) iterator.next();
					vt.setVehicleId((Integer) obj[0]);
					vt.setVehicleTypeId((String) obj[1]);
					vt.setVehicleMade((String) obj[2]);
					vt.setVehicleModel((String) obj[3]);
					vt.setDriverId((String) obj[4]);
					vt.setRegistrationNum((String) obj[5]);
					vt.setPermit((String) obj[6]);
					vt.setAdvetisementTax((String) obj[7]);
					vt.setRoadTax((String) obj[8]);
					vt.setProfessionalTax((String) obj[9]);
					vt.setInsurance((String) obj[10]);
					vt.setFitness((String) obj[11]);
					vt.setPollution((String) obj[12]);
					vt.setVehicleType((String) obj[13]);

					vehicleBean.add(vt);

				}
			} else {
				list = vehicleService.basicSearchVehicle(dbField, operation,
						basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Vehicle vt = new Vehicle();
					Object[] obj = (Object[]) iterator.next();
					vt.setVehicleId((Integer) obj[0]);
					vt.setVehicleTypeId((String) obj[1]);
					vt.setVehicleMade((String) obj[2]);
					vt.setVehicleModel((String) obj[3]);
					vt.setDriverId((String) obj[4]);
					vt.setRegistrationNum((String) obj[5]);
					vt.setPermit((String) obj[6]);
					vt.setAdvetisementTax((String) obj[7]);
					vt.setRoadTax((String) obj[8]);
					vt.setProfessionalTax((String) obj[9]);
					vt.setInsurance((String) obj[10]);
					vt.setFitness((String) obj[11]);
					vt.setPollution((String) obj[12]);
					vt.setVehicleType((String) obj[13]);
					vehicleBean.add(vt);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("vehicleSearch", vehicleBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("vehicleAdd", vehicleSearch);

		return "vehicleHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "vehicleId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("VehicleSearchNames")
	public Map<String, String> populatevehicleSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = vehicleService.selectVehicleNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String desigId = Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/vehicleEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String vehicleEdit(@ModelAttribute Vehicle vehicleDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String vehiclename = request.getParameter("vehicleDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

		try {

			list = vehicleService.searchVehicleWithId(vehiclename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();

				vehicleDisplay.setVehicleIdEdit((Integer) object[0]);
				vehicleDisplay.setVehicleTypeIdEdit((String) object[1]);
				vehicleDisplay.setVehicleMadeEdit((String) object[2]);
				vehicleDisplay.setVehicleModelEdit((String) object[3]);
				vehicleDisplay.setDriverIdEdit((String) object[4]);
				vehicleDisplay.setRegistrationNumEdit((String) object[5]);
				vehicleDisplay.setPermitEdit((String) object[6]);
				vehicleDisplay.setAdvetisementTaxEdit((String) object[7]);
				vehicleDisplay.setRoadTaxEdit((String) object[8]);
				vehicleDisplay.setProfessionalTaxEdit((String) object[9]);
				vehicleDisplay.setInsuranceEdit((String) object[10]);
				vehicleDisplay.setFitnessEdit((String) object[11]);
				vehicleDisplay.setPollutionEdit((String) object[12]);
				vehicleDisplay.setCreateDateEdit((String) object[13]);

				vehiclesList.add(vehicleDisplay);

			}

			request.setAttribute("vehicleValues", vehiclesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("vehicleAdd", vehicleDisplay);
		return "vehicleHome";

	}

	@RequestMapping(value = "/vehicleUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateVehicle(@ModelAttribute("vehicleAdd") Vehicle vehicle,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = vehicleService.updateDuplicateCheck(
					vehicle.getRegistrationNumEdit(),
					vehicle.getVehicleIdEdit());

			if (duplicateId == 0) {

				vehicle.setVehicleId(vehicle.getVehicleIdEdit());
				vehicle.setVehicleTypeId(vehicle.getVehicleTypeIdEdit());
				vehicle.setVehicleMade(vehicle.getVehicleMadeEdit());
				vehicle.setVehicleModel(vehicle.getVehicleModelEdit());
				vehicle.setDriverId(vehicle.getDriverIdEdit());
				vehicle.setRegistrationNum(vehicle.getRegistrationNumEdit());
				vehicle.setPermit(vehicle.getPermitEdit());
				vehicle.setAdvetisementTax(vehicle.getAdvetisementTaxEdit());
				vehicle.setRoadTax(vehicle.getRoadTaxEdit());
				vehicle.setProfessionalTax(vehicle.getProfessionalTaxEdit());
				vehicle.setInsurance(vehicle.getInsuranceEdit());
				vehicle.setFitness(vehicle.getFitnessEdit());
				vehicle.setPollution(vehicle.getPollutionEdit());
				vehicle.setCreateDate(vehicle.getCreateDateEdit());
				/* vehicle.setStatus(vehicle.getStatusEdit()); */

				String msg = vehicleService.updateVehicle(vehicle);

				if (msg.equals("S")) {
					request.setAttribute("vehicleUpadteSuccess",
							"Vehicle Details Updated Successfully");
				} else {

					request.setAttribute("vehicleUpadteFail",
							"Vehicle Details has Not Updated");

				}
			} else {
				request.setAttribute("vehicleEditDuplicate",
						"Registration Number Already exist");
				request.setAttribute("vehicleValues", "vehicleValues");

				return "vehicleHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("vehicleAdd", new Vehicle());

		return "vehicleHome";

	}

	@RequestMapping(value = "/vehicleDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView materialDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String vehicleid = null;
		HttpSession session = null;

		try {
			vehicleid = request.getParameter("vehicleIdDelete");

			String msg = vehicleService.vehicleDelete(vehicleid);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "vehicle", "ROW", String
						.valueOf(vehicleid), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("vehicleDel",
						"Vehicle details Deleted Successfully");
			} else {
				request.setAttribute("vehicleDelErr",
						"vehicle details Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ModelAndView("vehicleHome", "vehicleAdd", new Vehicle());
	}

	@RequestMapping(value = "/vehicleAdvanceSearch", method = RequestMethod.GET)
	public String vehicleAdvanceSearch(
			@ModelAttribute("vehicleAdd") Vehicle vehicle,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "vehicleId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Vehicle v=null;
		vehicleList = new ArrayList();
		vehicle.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			// Iterator it=returnString.iterator();
			for (Object[] object : returnString) {
				Vehicle v = new Vehicle();

				s1 = (String) object[0];
				s2 = (String) object[1];

				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				vehicleList.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("vehicleSearchAdvance", vehicleList);

		return "vehicleHome";
	}

	@RequestMapping(value = "/vehicleAdvanceSearchOperations", method = RequestMethod.POST)
	public String vehicleAdvanceSearchOperations(
			@ModelAttribute Vehicle vehicle, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		vehicle1 = new ArrayList<Vehicle>();
		String columns = vehicle.getFirstLabel();
		String operations = vehicle.getOperations1();
		String advanceSearchText = vehicle.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {
			objectsArray = vehicleService.getVehicleAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = vehicleService.searchVehicle();
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.Vehicle();
			objects2 = (Object[]) iterator.next();
			mm.setVehicleId((Integer) objects2[0]);
			mm.setVehicleTypeId((String) objects2[1]);
			mm.setVehicleMade((String) objects2[2]);
			mm.setVehicleModel((String) objects2[3]);
			mm.setDriverId((String) objects2[4]);
			mm.setRegistrationNum((String) objects2[5]);
			mm.setPermit((String) objects2[6]);
			mm.setAdvetisementTax((String) objects2[7]);
			mm.setRoadTax((String) objects2[8]);
			mm.setProfessionalTax((String) objects2[9]);
			mm.setInsurance((String) objects2[10]);
			mm.setFitness((String) objects2[11]);
			mm.setPollution((String) objects2[12]);
			mm.setVehicleType((String) objects2[13]);

			vehicle1.add(mm);

		}

		request.setAttribute("vehicleSearch", vehicle1);
		model.addAttribute("vehicleAdd", new Vehicle());

		return "vehicleHome";
	}

}
