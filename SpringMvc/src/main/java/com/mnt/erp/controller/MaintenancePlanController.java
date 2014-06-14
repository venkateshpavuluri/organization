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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.MaintenancePlan;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.maintenanceTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaintenancePlanService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class MaintenancePlanController {
	
	private static Logger logger=Logger.getLogger(MaintenancePlanController.class);
	
	@Autowired
	MaintenancePlanService mainPlanService;
	
	@Autowired
	PlantService plantService;
	
	@Autowired
	StatusService statusService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/MaintenancePlan", method = RequestMethod.GET)
	public ModelAndView getMaintenancePlan(HttpServletRequest request) {

		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("MaintenancePlan.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("MaintenancePlanHome", "maintenancePlanCommand",
				new MaintenancePlan());
	}

	
	/* To Get Status Id Values */

	@ModelAttribute("status")
	public Map<Integer, String> statusIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = statusService.searchStatus();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}
	
	
	 //To Get Plant Id Values 
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

	@ModelAttribute("equipment")
	public Map<Integer, String> equipmentGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = mainPlanService.selectEquipment();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	
	
	@ModelAttribute("shift")
	public Map<Integer, String> shiftGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = mainPlanService.selectShift();
					iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}

		return map;
	}
	
	@ModelAttribute("maintenanceType")
	public Map<Integer, String> maintenanceTypeGet() {
		
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = mainPlanService.selectMaintenanceType();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@RequestMapping(value = "/maintenancePlanCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkname(HttpServletRequest request, HttpServletResponse response,
			MaintenancePlan maintenancePlancheck) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		Long mainplan =null;

		try {
		
			String equipment = request.getParameter("equipment_Id");
		
			String planedDate=request.getParameter("plannedDT");
		
			mainplan = mainPlanService.checkMaintenancePlanCout(equipment, planedDate);

			if (mainplan != 0) {
				maintenancePlancheck.setAid(2);
				request.setAttribute("addMaintenancePlanDuplicate","Warning ! Maintenance Plan already exists!");
				msg = "Warning ! Maintenance Plan already exists!";

			}
			if (mainplan == 0) {
				maintenancePlancheck.setAid(2);
				request.setAttribute("addMaintenancePlanDuplicate","Warning ! Maintenance Plan already exists!");
				msg = "";
			}
		}
        catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/maintenancePlanAdd", method = RequestMethod.POST)
	public String saveMaintenancePlan(
			@ModelAttribute("maintenancePlanCommand") MaintenancePlan maintenancePlanAdd,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		String msg = null;
		String res=null;
		HttpSession session=null;
		int id=maintenancePlanAdd.getMaintenancePlan_Id();
		
			try {
				maintenancePlanAdd.setPlannedDT(dateService.dateFormat(dateService.dateParse(maintenancePlanAdd.getPlannedDT(),"au"),"au"));	
				msg = mainPlanService.saveMaintenancePlanDetails(maintenancePlanAdd);

			}

			catch (Exception e) {
				e.printStackTrace();
			}

			if (msg.equals("S")) {
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Maintenance Plan","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
				
				res = "redirect:MaintenancePlan.mnt?list=" + "success" + "";
			}
			else
			{
				res = "redirect:MaintenancePlan.mnt?listwar=" + "fail" + "";
			}

			return res;
		

	}
	
	@RequestMapping(value = "/maintenancePlanSearch", method = RequestMethod.GET)
	public ModelAndView searchMaintenancePlan(
			@ModelAttribute("maintenancePlanCommand") MaintenancePlan maintenancePlanSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		List<Object[]> list = null;
		List<MaintenancePlan> maintenancePlans = null;
		try {
			
			String dbField = maintenancePlanSearch.getXmlLabel();
			String operation = maintenancePlanSearch.getOperations();
			String basicSearchId = maintenancePlanSearch.getBasicSearchId();

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
				maintenancePlans = new ArrayList<MaintenancePlan>();
				list = mainPlanService.searchMaintenancePlan();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					MaintenancePlan mp = new MaintenancePlan();
					mp.setMaintenancePlan_Id((Integer) objects[0]);
				    maintenanceTypeBean mtbean=((maintenanceTypeBean) objects[1]);
				    mp.setMaintenanceTypeName(mtbean.getMaintenanceType());
					Plant plant = ((Plant) objects[2]);
					mp.setPlantName(plant.getPlantName());
					EquipmentBean equBean=((EquipmentBean) objects[3]);
					mp.setEquipmentName(equBean.getEquipmentName());
					mp.setPlannedDT(dateService.dateFormat(dateService.dateParse((String) objects[4],"se"),"se"));
					ShiftBean shift = ((ShiftBean) objects[5]);
					mp.setShiftName(shift.getShift());
					mp.setDescription((String) objects[6]);
					Status status = ((Status) objects[7]);
					mp.setStatusName(status.getStatus());
					maintenancePlans.add(mp);
				}
			} else {
				list = mainPlanService.basicSearchMaintenancePlan(dbField, operation,
						basicSearchId);
				maintenancePlans = new ArrayList<MaintenancePlan>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					MaintenancePlan mp = new MaintenancePlan();
					mp.setMaintenancePlan_Id((Integer) objects[0]);
				    maintenanceTypeBean mtbean=((maintenanceTypeBean) objects[1]);
				    mp.setMaintenanceTypeName(mtbean.getMaintenanceType());
					Plant plant = ((Plant) objects[2]);
					mp.setPlantName(plant.getPlantName());
					EquipmentBean equBean=((EquipmentBean) objects[3]);
					mp.setEquipmentName(equBean.getEquipmentName());
					mp.setPlannedDT(dateService.dateFormat(dateService.dateParse((String) objects[4],"se"),"se"));
					ShiftBean shift = ((ShiftBean) objects[5]);
					mp.setShiftName(shift.getShift());
					mp.setDescription((String) objects[6]);
					Status status = ((Status) objects[7]);
					mp.setStatusName(status.getStatus());
					maintenancePlans.add(mp);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("mpvalue", "mpvalue");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("MaintenancePlanHome");
		modelAndView.addObject("MaintenancePlan", maintenancePlans);
		return modelAndView;
	}

	@RequestMapping(value = "/maintenancePlanEdit", method = RequestMethod.GET)
	public String editMaintenancePlan(
			@ModelAttribute("maintenancePlanCommand") MaintenancePlan maintenancePlanEdit,
			BindingResult result, HttpServletRequest request, Model model) {

		List<Object[]> list = null;
		MaintenancePlan maintenancePlan = null;
		int id = Integer.parseInt(request.getParameter("maintenancePlanId"));

		try {
			list = mainPlanService.searchMaintenancePlanWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				maintenancePlan = new MaintenancePlan();
				maintenancePlan.setMaintenancePlan_IdEdit(id);
				maintenancePlan.setMaintenanceType_IdEdit((String) objects[1]);
				maintenancePlan.setPlant_IdEdit((String) objects[2]);
				maintenancePlan.setEquipment_IdEdit((String) objects[3]);
				maintenancePlan.setPlannedDTEdit(dateService.dateFormat(dateService.dateParse((String) objects[4],"se"),"se"));
				maintenancePlan.setShift_IdEdit((String) objects[5]);
				maintenancePlan.setDescriptionEdit((String) objects[6]);
				maintenancePlan.setStatus_IdEdit((String) objects[7]);
				

			}

			model.addAttribute("maintenancePlanCommand", maintenancePlan);

			request.setAttribute("mpEditvalues", "mpEditvalues");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "MaintenancePlanHome";

	}
    
	@RequestMapping(value = "/maintenancePlanEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, MaintenancePlan maintenancePlancheck) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		Long mplanEdit = null;
      
		try {

			String equipment = request.getParameter("equipment_IdEdit");
			
			String planedDate=request.getParameter("plannedDTEdit");
			
			int maintenancePlanId = Integer.parseInt(request.getParameter("maintenancePlan_IdEdit"));
			mplanEdit = mainPlanService.updateCheckMaintenancePlan(equipment, planedDate, maintenancePlanId);
			
			if (mplanEdit != 0) {
				maintenancePlancheck.setMaintenancePlan_IdEdit(1);
				request.setAttribute("addMaintenancePlanEditDuplicate","Warning ! Maintenance Plan already exists!");
			
				msg = "Warning ! Maintenance Plan already exists!";
               }
			
			if (mplanEdit == 0) {
				maintenancePlancheck.setMaintenancePlan_IdEdit(1);
				request.setAttribute("addMaintenancePlanEditDuplicate","Warning ! Maintenance Plan already exists!");
				
				msg = "";
			   }
		    } 
		    catch (Exception e) {
		    	e.printStackTrace();
		     }
		return msg;
	}
	@RequestMapping(value = "/maintenancePlanUpdate", method = RequestMethod.POST)
	public String updateMaintenancePlan(
			@ModelAttribute("maintenancePlanCommand") MaintenancePlan maintenancePlanUpdate,
			HttpServletRequest request, Model model) {

		String msg = null;
		try{
		maintenancePlanUpdate.setMaintenancePlan_Id(maintenancePlanUpdate.getMaintenancePlan_IdEdit());
		maintenancePlanUpdate.setMaintenanceType_Id(maintenancePlanUpdate.getMaintenanceType_IdEdit());
		maintenancePlanUpdate.setPlant_Id(maintenancePlanUpdate.getPlant_IdEdit());
		maintenancePlanUpdate.setEquipment_Id(maintenancePlanUpdate.getEquipment_IdEdit());
		maintenancePlanUpdate.setPlannedDT(dateService.dateFormat(dateService.dateParse(maintenancePlanUpdate.getPlannedDTEdit(),"au"),"au"));
		maintenancePlanUpdate.setShift_Id(maintenancePlanUpdate.getShift_IdEdit());
		maintenancePlanUpdate.setDescription(maintenancePlanUpdate.getDescriptionEdit());
		maintenancePlanUpdate.setStatus_Id(maintenancePlanUpdate.getStatus_IdEdit());
		

			msg = mainPlanService.updateMaintenancePlan(maintenancePlanUpdate);

		
			if (msg.equals("S")) {
			request.setAttribute("maintenancePlanUpdate","Maintenance Plan has been updated");
			}
			
			else{
		    request.setAttribute("maintenancePlanUpdateError","Maintenance Plan has not been updated");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
          return "MaintenancePlanHome";
		} 
	

	@RequestMapping(value = "/maintenancePlanDelete", method = RequestMethod.GET)
	public ModelAndView maintenancePlanDelete(
			@ModelAttribute("maintenancePlanCommand") MaintenancePlan maintenancePlanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("maintenancePlanId"));
		HttpSession session=null;
		try {
			String msg = mainPlanService.deleteMaintenancePlan(id);
			if (msg.equals("S")) {
				
			 request.setAttribute("maintenacePlanDelete","Maintenance Plan has been deleted");
			 session=request.getSession(false);
			 Date date = new Date();
			 String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			 auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Maintenance Plan","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			
			} else {
				request.setAttribute("maintenacePlanDeleteError","Maintenance Plan has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("MaintenancePlanHome", "maintenancePlanCommand",new MaintenancePlan());
		
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "maintenanPlanId";
		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}


}
