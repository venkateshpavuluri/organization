/**
copyright MNTSoft
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

import com.mnt.erp.bean.VehicleType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VehicleTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * @version 1.0 28-10-2013
 * @build 0.0
 * 
 */
@Controller
public class VehicleTypeController {

	@Autowired
	VehicleTypeService vehicletypeService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/vehicletypeHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView vehicleType(
			@ModelAttribute("vehicletypeAdd") VehicleType vehicletype,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("vehicletypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("vehicletypeHome", "vehicletypeAdd",
				new VehicleType());
	}

	@RequestMapping(value = "/vehicletypeAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveVehicleTypeDetails(
			@ModelAttribute("vehicletypeAdd") @Valid VehicleType vehicletypeAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msa = null;
		Long duplicateId = 0l;
		HttpSession session = null;
		String res = null;

		try {
			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				vehicletypeAdd.setAid(1);
				return "vehicletypeHome";
			}

			duplicateId = vehicletypeService
					.duplicateVehicleTypeCheck(vehicletypeAdd.getVehicletype());
			if (duplicateId == 0) {

				session = request.getSession(false);
				msa = vehicletypeService.saveVehicleTypeDetails(vehicletypeAdd,
						session.getAttribute("userId").toString(), session
								.getAttribute("userName").toString());

				if (msa.equals("S")) {
					res = "redirect:vehicletypeHome.mnt?list=" + "success" + "";

				} else {
					res = "redirect:vehicletypeHome.mnt?listwar=" + "fail" + "";

				}

			} else {
				vehicletypeAdd.setAid(1);
				request.setAttribute("VehicleTypeDuplicate",
						"VehicleType Name  Already exist");
				return "vehicletypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:vehicletypeHome.mnt?listwar=" + "fail" + "";

		}

		return res;

	}

	@RequestMapping(value = "/vehicletypeSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchVehicleType(
			@ModelAttribute VehicleType vehicletypeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<VehicleType> vehicleTypeBean = new ArrayList<VehicleType>();

		VehicleType vehicletypesearch = null;
		try {
			int id = vehicletypeSearch.getVehicletypeId();
			String dbField = vehicletypeSearch.getXmlLabel();
			String operation = vehicletypeSearch.getOperations();
			String basicSearchId = vehicletypeSearch.getBasicSearchId();

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
				list = vehicletypeService.searchVehicleType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					VehicleType vt = new VehicleType();
					Object[] obj = (Object[]) iterator.next();
					vt.setVehicletypeId((Integer) obj[0]);
					vt.setVehicletype((String) obj[1]);
					vehicleTypeBean.add(vt);

				}
			} else {
				list = vehicletypeService.basicSearchVehicleType(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					VehicleType vt = new VehicleType();
					Object[] obj = (Object[]) iterator.next();
					vt.setVehicletypeId((Integer) obj[0]);
					vt.setVehicletype((String) obj[1]);
					vehicleTypeBean.add(vt);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("vehicletypeSearch", vehicleTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("vehicletypeAdd", vehicletypeSearch);

		return "vehicletypeHome";
	}

	@ModelAttribute("VehicleTypeSearchNames")
	public Map<String, String> populatevehicletypeSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = vehicletypeService.selectVehicleTypeNames();
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

	@RequestMapping(value = "/vehicletypeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String vehicletypeEdit(
			@ModelAttribute VehicleType vehicletypeDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String vehicletypename = request.getParameter("vehicletypeDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<VehicleType> vehicletypesList = new ArrayList<VehicleType>();

		try {

			list = vehicletypeService.searchVehicleTypeWithId(vehicletypename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				vehicletypeDisplay.setVehicletypeIdEdit((Integer) object[0]);
				vehicletypeDisplay.setVehicletypeEdit((String) object[1]);

				/* vehicletypeDisplay.setStatusEdit((String) object[2]); */

				vehicletypesList.add(vehicletypeDisplay);

			}
			request.setAttribute("vehicletypeValues", vehicletypesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("vehicletypeAdd", vehicletypeDisplay);
		return "vehicletypeHome";

	}

	@RequestMapping(value = "/vehicletypeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateVehicleType(
			@ModelAttribute("vehicletypeAdd") VehicleType vehicletype,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = vehicletypeService.updateDuplicateCheck(
					vehicletype.getVehicletypeEdit(),
					vehicletype.getVehicletypeIdEdit());

			if (duplicateId == 0) {
				vehicletype
						.setVehicletypeId(vehicletype.getVehicletypeIdEdit());
				vehicletype.setVehicletype(vehicletype.getVehicletypeEdit());

				String msg = vehicletypeService.updateVehicleType(vehicletype);

				if (msg.equals("S")) {
					request.setAttribute("vehicletypeUpadteSuccess",
							"VehicleType Details Updated Successfully");
				} else {

					request.setAttribute("vehicletypeUpadteFail",
							"VehicleType Details has Not Updated");

				}
			} else {
				request.setAttribute("vehicletypeEditDuplicate",
						"VehicleType Name Already exist");
				request.setAttribute("vehicletypeValues", "vehicletypeValues");

				return "vehicletypeHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("vehicletypeAdd", new VehicleType());

		return "vehicletypeHome";

	}

	@RequestMapping(value = "/vehicletypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView vehicletypeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int vehicletypeId = 0;
		HttpSession session = null;
		try {
			vehicletypeId = Integer.parseInt(request
					.getParameter("vehicletypeIdDelete"));
			String msg = vehicletypeService.vehicletypeDelete(vehicletypeId);
			
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "vehicletype", "ROW", String
						.valueOf(vehicletypeId), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("vehicleDel", " Deleted Successfully");
			} else {
				request.setAttribute("vehicleDelErr", " Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("vehicleDelErr", " Did Not Deleted");
		}
		return new ModelAndView("vehicletypeHome", "vehicletypeAdd",
				new VehicleType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "vehicleTypeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
