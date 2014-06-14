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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.TrainingCategory;
import com.mnt.erp.bean.TrainingSchedule;
import com.mnt.erp.bean.TrainingScheduleDetail;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.TrainingScheduleService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author devi
 *
 */
@Controller
public class TrainingScheduleController {
	@Autowired
	TrainingScheduleService tScheduleService;
	@Autowired
	PopulateService populateService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;
	
	String msg;
	List<Object[]> list;
	static Logger logger = Logger.getLogger(TrainingScheduleController.class);

	@RequestMapping(value = "/trainingScheduleHome", method = RequestMethod.GET)
	public String tScheduleHome(@ModelAttribute("TrainingSchedule") TrainingSchedule tsche,
			HttpServletResponse response, Model model,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("trainingScheduleHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		response.setCharacterEncoding("UTF-8");
		return "trainingScheduleHome";
	}

	@ModelAttribute("employeeDetails")
	public Map<Integer, String> populatEmployeeids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select d.employee_Id,d.fName from Employee d");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	

	@ModelAttribute("orgDetails")
	public Map<Integer, String> populatOrganizationids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select d.orgId,d.orgName from Organization d");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	
	@ModelAttribute("trainingCategoryDetails")
	public Map<Integer, String> populatTrainingCategoryids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select d.trainingCategoryId,d.trainingCategory from TrainingCategory d");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@RequestMapping(value = "/saveTSchedule", method = RequestMethod.POST)
	public String SaveTSchedule(@ModelAttribute("TrainingSchedule") TrainingSchedule tsche,
			HttpServletResponse response, Model model,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		String[] employeeIds = null;
		
		TrainingScheduleDetail scheduleLine = null;
	    List<TrainingScheduleDetail> scheduleLinesofSet = null;
		
		String result = null;
		HttpSession session=null;
		try {
			tsche.setDate(dateService.dateFormat(dateService.dateParse(tsche.getDate(),"au"),"au"));
			TrainingSchedule trais=new TrainingSchedule();
			BeanUtils.copyProperties(trais, tsche);
			employeeIds = tsche.getEmployeeId().split(",");
			
			scheduleLinesofSet = new ArrayList<TrainingScheduleDetail>();
			for (int i = 0; i < employeeIds.length; i++) {
				scheduleLine = new TrainingScheduleDetail();
				scheduleLine.setEmployeeId(Integer.parseInt(employeeIds[i]));
						
				
				scheduleLinesofSet.add(scheduleLine);

			}
			trais.setTrainScheduleDetails(scheduleLinesofSet);
			
			session=request.getSession(false);
			msg = tScheduleService.saveTrainingSchedule(trais,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
		

			if (msg.equals("S")) {
				result = "redirect:trainingScheduleHome.mnt?list=" + "success" + "";
				
			} else {
				result = "redirect:trainingScheduleHome.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			result = "redirect:trainingScheduleHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}

		return result;
	}
	
	@RequestMapping(value = "/searchTSchedule", method = RequestMethod.GET)
	public String searchTSchedule(
			@ModelAttribute("TrainingSchedule") TrainingSchedule tsche,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		Iterator<Object[]> iterator = null;
		TrainingSchedule scheduleSearchDetails = null;
		List<TrainingSchedule> listofschedules = null;
		try {
			int iid= tsche.getTrainingSchedule_Id();
			

			String dbField = tsche.getXmlLabel();
			String operation = tsche.getOperations();
			String basicSearchId = tsche.getBasicSearchId();
			listofschedules = new ArrayList<TrainingSchedule>();

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
				list = tScheduleService.searchTrainingSchedule();
				
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					scheduleSearchDetails = new TrainingSchedule();

					scheduleSearchDetails.setTrainingSchedule_Id((Integer) obj[0]);
					scheduleSearchDetails.setDate(dateService.dateFormat(dateService.dateParse((String) obj[1],"se"),"se"));
					scheduleSearchDetails.setTime((String) obj[2]);
					scheduleSearchDetails.setVenue((String) obj[3]);
					scheduleSearchDetails.setTriner((String)obj[4]);
					TrainingCategory tcat = (TrainingCategory) obj[5];
					scheduleSearchDetails.setTrainingCategoryId(String.valueOf(tcat.getTrainingCategoryId()));
					scheduleSearchDetails.setTrainingCategory(tcat.getTrainingCategory());
					Organization org = (Organization) obj[6];
					scheduleSearchDetails.setOrg_Id(String.valueOf(org.getOrgId()));
					scheduleSearchDetails.setOrg_Name(org.getOrgName());
					
					listofschedules.add(scheduleSearchDetails);

				}

			} else {

				list= tScheduleService.basicSearchTrainingSchedule(dbField, operation, basicSearchId);
				

				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					scheduleSearchDetails = new TrainingSchedule();

					scheduleSearchDetails.setTrainingSchedule_Id((Integer) obj[0]);
					scheduleSearchDetails.setDate(dateService.dateFormat(dateService.dateParse((String) obj[1],"se"),"se"));
					scheduleSearchDetails.setTime((String) obj[2]);
					scheduleSearchDetails.setVenue((String) obj[3]);
					scheduleSearchDetails.setTriner((String)obj[4]);
					TrainingCategory tcat = (TrainingCategory) obj[5];
					scheduleSearchDetails.setTrainingCategoryId(String.valueOf(tcat.getTrainingCategoryId()));
					scheduleSearchDetails.setTrainingCategory(tcat.getTrainingCategory());
					Organization org = (Organization) obj[6];
					scheduleSearchDetails.setOrg_Id(String.valueOf(org.getOrgId()));
					scheduleSearchDetails.setOrg_Name(org.getOrgName());
					
					listofschedules.add(scheduleSearchDetails);


				}
			}
			request.setAttribute("listofDNotes", listofschedules);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "trainingScheduleHome";
	}
	
	@RequestMapping(value = "/tScheduleEdit", method = RequestMethod.GET)
	public String editTSchedule(
			@ModelAttribute("TrainingSchedule") TrainingSchedule tsche,
			BindingResult result, HttpServletRequest request, Model model,
			HttpServletResponse response) {

		int tScheduleId = 0;
		response.setCharacterEncoding("UTF-8");
		Iterator<TrainingSchedule> iterator = null;
		List<TrainingScheduleDetail> listOfTSLines = null;
		Iterator<TrainingScheduleDetail> tslIterator = null;
		TrainingSchedule tsForChildEdit = null;
		List<TrainingSchedule> tslforchildEdit = null;
		List<TrainingSchedule> tScheduleDetails = null;
		List<String> listofstrings = null;
		try {
			tScheduleId=Integer.parseInt(request.getParameter("tsEditId"));
			tScheduleDetails = tScheduleService.editTrainingScheduleDetails(tScheduleId);
			
			tslforchildEdit = new ArrayList<TrainingSchedule>();
			
			iterator = tScheduleDetails.iterator();

			while (iterator.hasNext()) {
				TrainingSchedule obj = (TrainingSchedule) iterator.next();
           tsche.setTrainingSchedule_IdEdit(obj.getTrainingSchedule_Id());
           tsche.setDateEdit(dateService.dateFormat(dateService.dateParse(obj.getDate(),"se"),"se"));
           tsche.setTimeEdit(obj.getTime());
           tsche.setVenueEdit(obj.getVenue());
           tsche.setTrainerEdit(obj.getTriner());
           TrainingCategory tcat = obj.getTrainingDetails();
           tsche.setTrainingCategoryIdEdit(String.valueOf(tcat.getTrainingCategoryId()));
           tsche.setTrainingCategoryEdit(tcat.getTrainingCategory());
			Organization org=obj.getOrgDetails();
			tsche.setOrg_IdEdit(String.valueOf(org.getOrgId()));
			tsche.setOrg_NameEdit(org.getOrgName());
			
			listOfTSLines=obj.getTrainScheduleDetails();
				
				

			}
			tslIterator = listOfTSLines.iterator();
			while (tslIterator.hasNext()) {
				tsForChildEdit = new TrainingSchedule();
				TrainingScheduleDetail vacancyDetailLine = (TrainingScheduleDetail) tslIterator
						.next();
				
				tsForChildEdit.setTrainingScheduleDet_IdEdit(String.valueOf(vacancyDetailLine.getTrainingScheduleDet_Id()));
				Employee emp=(Employee)vacancyDetailLine.getEmpDetails();
				tsForChildEdit.setEmployeeIdEdit(String.valueOf(emp.getEmployee_Id()));
				tsForChildEdit.setEmpNameEdit(emp.getfName());	
				
     								
				tslforchildEdit.add(tsForChildEdit);
			}

			listofstrings = new ArrayList<String>();
			listofstrings.add("1");
			request.setAttribute("editvalues", listofstrings);
			request.setAttribute("tScheduleLinedetails", tslforchildEdit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trainingScheduleHome";

	}

	@RequestMapping(value = "/tScheduleUpdate", method = RequestMethod.POST)
	public String tScheduleUpdate(
			@ModelAttribute("TrainingSchedule") TrainingSchedule tsche, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		
		String checked = "",  s2 = "1";
		int ss = 0;
		TrainingScheduleDetail tScheduleLine = null;
		List<TrainingScheduleDetail> tScheduleLines = null;
		List<TrainingScheduleDetail> childDelete = null;

		try {
			model.addAttribute("TrainingSchedule", new TrainingSchedule());
			tScheduleLines = new ArrayList<TrainingScheduleDetail>();
			tsche.setTrainingSchedule_Id(tsche.getTrainingSchedule_IdEdit());
			tsche.setDate(dateService.dateFormat(dateService.dateParse(tsche.getDateEdit(),"au"),"au"));
			tsche.setTime(tsche.getTimeEdit());
			tsche.setVenue(tsche.getVenueEdit());
			tsche.setTriner(tsche.getTrainerEdit());
			tsche.setTrainingCategoryId(tsche.getTrainingCategoryIdEdit());
			tsche.setOrg_Id(tsche.getOrg_IdEdit());
			
			childDelete = new ArrayList<TrainingScheduleDetail>();
            String	tSchedulelineid =tsche.getTrainingScheduleDet_IdEdit();
          
        	String[] tslineIdArray = tSchedulelineid.split(",");
        	
		    String[] empIdEdit = tsche.getEmployeeIdEdit().split(",");
		   
			
			
			if (empIdEdit != null) {
				for (int i = 0; i < empIdEdit.length; i++) {
					int dllineId = Integer.parseInt(empIdEdit[i]);
					if (dllineId == 0) {
						tScheduleLine = new TrainingScheduleDetail();
						tScheduleLine.setTrainingScheduleDet_Id(Integer.parseInt(tslineIdArray[i]));
						tScheduleLine.setEmployeeId(Integer.parseInt(empIdEdit[i]));
					
						tScheduleLine.setEmpDetails(new Employee());
						
						tScheduleLines.add(tScheduleLine);
					} else {
						
						tScheduleLine = new TrainingScheduleDetail();
						tScheduleLine.setTrainingScheduleDet_Id(Integer.parseInt(tslineIdArray[i]));
						tScheduleLine.setEmployeeId(Integer.parseInt(empIdEdit[i]));
						tScheduleLine.setEmpDetails(new Employee());
						
						
						
						ss = Integer.parseInt(tslineIdArray[i]);
						checked = request.getParameter("Checkdelete" + ss);
					
						
						if(s2.equals(checked))
						{
							TrainingScheduleDetail vline = new TrainingScheduleDetail();
							vline.setTrainingScheduleDet_Id(ss);
							childDelete.add(tScheduleLine);
						}
		
						else {
							
							tScheduleLines.add(tScheduleLine);
		
						}
					

					}

				}
				
				tsche.setTrainScheduleDetails(tScheduleLines);
				tScheduleService.deleteChildRecords(childDelete);
				msg=tScheduleService.updateTrainingScheduleDetails(tsche);
				
			
				if (msg.equals("S")) {
					request.setAttribute("TScheduleUpdate",
							"Training Schedule Details Updated Successfully");
				} else {
					request.setAttribute("TScheduleUpdateErr",
							"Training Schedule Data is not updated properly");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("TrainingSchedule", new TrainingSchedule());
		return "trainingScheduleHome";
	}
	@RequestMapping(value = "/tScheduleDelete", method = RequestMethod.GET)
	public String deleteTSchedule(
			@ModelAttribute("TrainingSchedule") TrainingSchedule tsche,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int deleId = Integer.parseInt(request.getParameter("tsdelId"));
			HttpSession session=null;
			msg = tScheduleService.deleteTrainingSchedule(deleId);
			

			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Tschedule","ROW" ,String.valueOf(deleId),"1",modifiedDate,session.getAttribute("userName").toString());
			
				request.setAttribute("TScheduleDel",
						"Training Schedule Details Deleted Successfully");
			} else {
				request.setAttribute("TScheduleDelErr",
						"Training Schedule Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 model.addAttribute("TrainingSchedule", new TrainingSchedule());
			return "trainingScheduleHome";
	}
	
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "Triner";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}


}
