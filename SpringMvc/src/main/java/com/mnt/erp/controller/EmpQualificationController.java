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
import com.mnt.erp.bean.EmpQualification;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Qualification;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EmpQualificationService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class EmpQualificationController {
	
	@Autowired 
	EmpQualificationService empqService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/EmpQualification", method = RequestMethod.GET)
	public ModelAndView getEmpQualification(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("EmpQualification.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("empQualificationHome", "empQualificationCommand",
				new EmpQualification());
	}

	@ModelAttribute("Employees")
	public Map<Integer, String> employeesGet() {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = empqService.selectEmployee();
			Iterator<Object[]> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@ModelAttribute("Qualification")
	public Map<Integer, String> qualificationGet() {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = empqService.selectQualification();
			Iterator<Object[]> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}



	@RequestMapping(value = "/empQualificationAdd", method = RequestMethod.POST)
	public String saveMaintenancePlan(
			@ModelAttribute("empQualificationCommand") EmpQualification empQualificationAdd,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		String msg = null;
		String res=null;
		HttpSession session=null;
	
	
	
			try {
			
				session=request.getSession(false);
				
				msg = empqService.saveEmpQualificationDetails(empQualificationAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					res = "redirect:EmpQualification.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:EmpQualification.mnt?listwar=" + "fail" + "";
				}

			}

			catch (Exception e) {
				e.printStackTrace();
			}

			return res;

			
		

	}
	
	@RequestMapping(value = "/empQualificationSearch", method = RequestMethod.GET)
	public ModelAndView searchEmpQualification(
			@ModelAttribute("empQualificationCommand") EmpQualification empQualificationSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		List<Object[]> list = null;
		List<EmpQualification> empQualification = null;
		try {
			String dbField = empQualificationSearch.getXmlLabel();
			String operation = empQualificationSearch.getOperations();
			String basicSearchId = empQualificationSearch.getBasicSearchId();

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
				empQualification = new ArrayList<EmpQualification>();
				list = empqService.searchEmpQualification();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					EmpQualification empq = new EmpQualification();
					empq.setEmpQual_Id((Integer) objects[0]);
					Employee emp=((Employee) objects[1]);
					empq.setEmpName(emp.getfName()+"--"+emp.getEmployeeNo());
					Qualification qual=((Qualification) objects[2]);
					empq.setQualificationName(qual.getQualification());
					empq.setYearPassed((String) objects[3]);
					empq.setGrade((String) objects[4]);
					empq.setBoard((String) objects[5]);
					empq.setTotMarks((String) objects[6]);
					empq.setPercentage((String) objects[7]);
				    
					empQualification.add(empq);
				}
			} else {
				list = empqService.basicSearchEmpQualification(dbField, operation, basicSearchId);
				empQualification = new ArrayList<EmpQualification>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					EmpQualification empq = new EmpQualification();
					empq.setEmpQual_Id((Integer) objects[0]);
					Employee emp=((Employee) objects[1]);
					empq.setEmpName(emp.getfName()+"--"+emp.getEmployeeNo());
					Qualification qual=((Qualification) objects[2]);
					empq.setQualificationName(qual.getQualification());
					empq.setYearPassed((String) objects[3]);
					empq.setGrade((String) objects[4]);
					empq.setBoard((String) objects[5]);
					empq.setTotMarks((String) objects[6]);
					empq.setPercentage((String) objects[7]);
				    
					empQualification.add(empq);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("empqvalue", "empqvalue");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("empQualificationHome");
		modelAndView.addObject("EmpQualification", empQualification);
		return modelAndView;
	}

	@RequestMapping(value = "/empQualificationEdit", method = RequestMethod.GET)
	public String workCenterEdit(
			@ModelAttribute("empQualificationCommand") EmpQualification empQualificationEdit,
			BindingResult result, HttpServletRequest request, Model model) {

		List<Object[]> list = null;
		EmpQualification empQualification = null;
		int id = Integer.parseInt(request.getParameter("empQualificationId"));

		try {
			list = empqService.searchEmpQualificationWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				empQualification = new EmpQualification();
				empQualification.setEmpQual_IdEdit((Integer) objects[0]);
				empQualification.setEmployee_IdEdit((String) objects[1]);
				empQualification.setQualification_IdEdit((String) objects[2]);
				empQualification.setYearPassedEdit((String) objects[3]);
				empQualification.setGradeEdit((String) objects[4]);
				empQualification.setBoardEdit((String) objects[5]);
				empQualification.setTotMarksEdit((String) objects[6]);
				empQualification.setPercentageEdit((String) objects[7]);
				
				

			}

			model.addAttribute("empQualificationCommand", empQualification);

			request.setAttribute("eqEditvalues", "eqEditvalues");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "empQualificationHome";

	}
    
	
	@RequestMapping(value = "/empQualificationUpdate", method = RequestMethod.POST)
	public String updateEmpQualification(
			@ModelAttribute("empQualificationCommand") EmpQualification empQualificationUpdate,
			HttpServletRequest request, Model model) {

		String msg = null;

		empQualificationUpdate.setEmpQual_Id(empQualificationUpdate.getEmpQual_IdEdit());
		empQualificationUpdate.setEmployee_Id(empQualificationUpdate.getEmployee_IdEdit());
		empQualificationUpdate.setQualification_Id(empQualificationUpdate.getQualification_IdEdit());
		empQualificationUpdate.setYearPassed(empQualificationUpdate.getYearPassedEdit());
		empQualificationUpdate.setGrade(empQualificationUpdate.getGradeEdit());
		empQualificationUpdate.setBoard(empQualificationUpdate.getBoardEdit());
		empQualificationUpdate.setTotMarks(empQualificationUpdate.getTotMarksEdit());
		empQualificationUpdate.setPercentage(empQualificationUpdate.getPercentageEdit());
		

			msg = empqService.updateEmpQualification(empQualificationUpdate);

			

			if (msg.equals("S")) {
				request.setAttribute("empQualificationUpdate","Employee has been updated");
			}
			else{
				request.setAttribute("empQualificationUpdateError","Employee has not been updated");
				
			}

			return "empQualificationHome";
		} 
	

	@RequestMapping(value = "/empQualificationDelete", method = RequestMethod.GET)
	public ModelAndView workCenterDelete(
			@ModelAttribute("empQualificationCommand") EmpQualification empQualificationDelet,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("empQualificationId"));
        HttpSession session=null;
		try {
			String msg = empqService.deleteEmpQualification(id);
			if (msg.equals("S")) {
				
				request.setAttribute("empQualificationDeleted","Employee Qualification has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employee Qualification","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				

			} else {
				request.setAttribute("empQualificationDeletedError","Employee Qualification has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("empQualificationHome", "empQualificationCommand",
				new EmpQualification());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "empQual";
		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}



}
