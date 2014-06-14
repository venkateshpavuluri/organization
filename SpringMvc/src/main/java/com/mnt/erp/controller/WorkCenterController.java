/*
 * @Copyright MNTSOFT
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CapacityCategory;
import com.mnt.erp.bean.Plant;

import com.mnt.erp.bean.WorkCenter;
import com.mnt.erp.bean.WorkCenterCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CapacityCategoryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.WorkCenterCategoryService;
import com.mnt.erp.service.WorkCenterService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
@Controller
public class WorkCenterController {

	@Autowired
	PlantService plantService;

	@Autowired
	CapacityCategoryService capcategoryService;

	@Autowired
	WorkCenterCategoryService wcService;

	@Autowired
	WorkCenterService wcservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/WorkCenter", method = RequestMethod.GET)
	public ModelAndView getWorkCenter(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("WorkCenter.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		return new ModelAndView("WorkCenterHome", "WorkCeterCommand",
				new WorkCenter());
	}

	/* To Get Plant Id Values */
	@ModelAttribute("plant")
	public Map<Integer, String> plantIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = plantService.getPlantIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* To Get Plant Id Values */
	@ModelAttribute("shop")
	public Map<Integer, String> shoopIdGet() {

		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = wcservice.getShopIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* Method Ended */

	/* To Get CapacityCategory Id Values */
	@ModelAttribute("CapacityCategory")
	public Map<Integer, String> capacityCategoryIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = capcategoryService.selectCapacityCategoryNames();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* Method Ended */

	/* To Get WorkCeterCategory Id Values */
	@ModelAttribute("WorkCeterCategory")
	public Map<Integer, String> WorkCeterCategoryIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = wcService.WorkCeterCategoryIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}

		return map;
	}

	/* Method Ended */

	@RequestMapping(value = "/WorkCeteradd", method = RequestMethod.POST)
	public String saveWorkCenter(
			@ModelAttribute("WorkCeterCommand") WorkCenter workCenter,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();

		String msg = null;
		String workCentersave = null;
		String wname = null;
		int list1 = 0;
		String res = null;
		wname = workCenter.getWorkCenterName();
		list1 = wcservice.checkWorkCenter(wname);
		if (list1 == 0) {

			try {

				msg = wcservice.saveWorkCenterDetails(workCenter);

			}

			catch (Exception e) {
				e.printStackTrace();
			}

			if (msg.equals("S")) {
				res = "redirect:WorkCenter.mnt?list=" + "success" + "";
				
			} else {
				res = "redirect:WorkCenter.mnt?listwar=" + "fail" + "";
			}

		} else {
			workCenter.setAid(1);
			request.setAttribute("addWorkCentreDuplicate",
					"Work Center Name Already Exists Please try some other name");

			return "WorkCenterHome";
		}
		return res;

	}

	@RequestMapping(value = "/WorkCenterSearch", method = RequestMethod.GET)
	public ModelAndView searchWorkCenter(
			@ModelAttribute("WorkCeterCommand") WorkCenter workCenterSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		List<Object[]> list = null;
		List<WorkCenter> workCenterTypes = null;
		try {
			String dbField = workCenterSearch.getXmlLabel();
			String operation = workCenterSearch.getOperations();
			String basicSearchId = workCenterSearch.getBasicSearchId();

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
				workCenterTypes = new ArrayList<WorkCenter>();
				list = wcservice.searchWorkCenter();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					WorkCenter dt = new WorkCenter();
					dt.setWorkCenter_Id((Integer) objects[0]);
					dt.setWorkCenterName((String) objects[1]);
					Plant plant = ((Plant) objects[2]);
					dt.setPlantName(plant.getPlantName());
					CapacityCategory capacity = ((CapacityCategory) objects[3]);
					dt.setCapcategory(capacity.getCapcategory());
					WorkCenterCategory wcategory = ((WorkCenterCategory) objects[4]);
					dt.setWorkCeterCategory(wcategory.getWorkCenterCategory());
					workCenterTypes.add(dt);
				}
			} else {
				list = wcservice.basicSearchWorkCenter(dbField, operation,
						basicSearchId);
				workCenterTypes = new ArrayList<WorkCenter>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					WorkCenter dt = new WorkCenter();
					dt.setWorkCenter_Id((Integer) objects[0]);
					dt.setWorkCenterName((String) objects[1]);
					Plant plant = ((Plant) objects[2]);
					dt.setPlantName(plant.getPlantName());
					CapacityCategory capacity = ((CapacityCategory) objects[3]);
					dt.setCapcategory(capacity.getCapcategory());
					WorkCenterCategory wcategory = ((WorkCenterCategory) objects[4]);
					dt.setWorkCeterCategory(wcategory.getWorkCenterCategory());
					workCenterTypes.add(dt);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("wcvalue", "wcvalue");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WorkCenterHome");
		modelAndView.addObject("workCenter", workCenterTypes);
		return modelAndView;
	}

	@RequestMapping(value = "/workcenterEditHome", method = RequestMethod.GET)
	public String editWorkCenter(
			@ModelAttribute("WorkCeterCommand") WorkCenter workCenterEdit,
			BindingResult result, HttpServletRequest request, Model model) {

		List<Object[]> list = null;
		WorkCenter w = null;
		int prid = Integer.parseInt(request.getParameter("workcenterId"));

		try {
			list = wcservice.searchWorkCenterWithId(prid);
			Iterator<Object[]> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				w = new WorkCenter();
				w.setWorkCenter_IdEdit(prid);
				w.setWorkCenterNameEdit((String) objects[1]);
				w.setPlant_IdEdit((String) objects[2]);
				w.setShop_IdEdit((String) objects[3]);
				w.setCapacityCategory_IdEdit((String) objects[4]);
				w.setWorkCeterCategory_IdEdit((String) objects[5]);

			}

			model.addAttribute("WorkCeterCommand", w);

			request.setAttribute("wcvalues", "wcvalues");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "WorkCenterHome";

	}

	@RequestMapping(value = "/WorkCeterEdit", method = RequestMethod.POST)
	public String updateWorkCenter(
			@ModelAttribute("WorkCeterCommand") WorkCenter workCenterUpdate,
			HttpServletRequest request, Model model) {

		String msg = null;

		String wname = null;
		int list1 = 0;
		int id = 0;
		wname = workCenterUpdate.getWorkCenterNameEdit();
		;
		id = workCenterUpdate.getWorkCenter_IdEdit();

		list1 = wcservice.updateCheckWorkCenter(wname, id);
		if (list1 == 0) {
			workCenterUpdate.setWorkCenter_Id(workCenterUpdate
					.getWorkCenter_IdEdit());

			workCenterUpdate.setWorkCenterName(workCenterUpdate
					.getWorkCenterNameEdit());

			workCenterUpdate.setPlant_Id(workCenterUpdate.getPlant_IdEdit());
			workCenterUpdate.setShop_Id(workCenterUpdate.getShop_IdEdit());
			workCenterUpdate.setCapacityCategory_Id(workCenterUpdate
					.getCapacityCategory_IdEdit());

			workCenterUpdate.setWorkCeterCategory_Id(workCenterUpdate
					.getWorkCeterCategory_IdEdit());

			msg = wcservice.updateWorkCenter(workCenterUpdate);

			if (msg.equals("S")) {

				request.setAttribute("workcenterupdate","Work Center has been updated successfully");

			} else {
				request.setAttribute("workcenterupdateError","Work Center has not been updated");
			}

		} else {
		
			request.setAttribute("wcvalues", "wcvalues");
			request.setAttribute("editWorkCentreDuplicate",
					"Work Center Name Already Exists Please try some other name");

			return "WorkCenterHome";
		}
		
		return "WorkCenterHome";
	}

	@RequestMapping(value = "/workcenterDelete", method = RequestMethod.GET)
	public ModelAndView workCenterDelete(
			@ModelAttribute("WorkCeterCommand") WorkCenter workCenterDelet,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("workcenterId"));
        HttpSession session=null;
		try {
			String msg = wcservice.deleteWorkCenter(id);

			if (msg.equals("S")) {
				request.setAttribute("workCenterDelete","Work Center has been deleted successfully");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Code Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			

			} else {

				request.setAttribute("workCenterDeleteError",
						"Work Center Data Deletion Failed due to constraint violation!");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("WorkCenterHome", "WorkCeterCommand",
				new WorkCenter());

		
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "workCenter_Id";
		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
