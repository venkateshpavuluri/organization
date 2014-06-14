/**
 @copyright MNT SOFT 
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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeAttendance;
import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EmployeeAttendanceService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author sailajach
 * @version 01-02-2014
 * @build 0.0
 *
 */
@Controller
@Scope("request")
public class EmployeeAttendanceController {
	
	private Logger logger=Logger.getLogger(EmployeeAttendanceController.class);
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	EmployeeAttendanceService empAttendanceService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	Object[] objects = null;
	String msg = null;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "employeeAttendance";

		Map<String, String> map =null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* =============================Employee Values================ */
	@ModelAttribute("employee")
	public Map<Integer, String> selectEmployee() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = empAttendanceService.getEmployeeNames();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}
	
	/* =============================Shift Values================ */
	@ModelAttribute("shift")
	public Map<Integer, String> selectShift() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues =empAttendanceService.getShifts();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@RequestMapping(value = "/employeeAttendance", method = RequestMethod.GET)
	public ModelAndView getEmployeeAttendance(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("employeeAttendance.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		return new ModelAndView("empAttendanceHome", "empAttendanceCommand",
				new EmployeeAttendance());

	}
	/* ===========================Duplicate checking for add========================*/
	@RequestMapping(value = "/employeeAttendanceDuplicateAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, EmployeeAttendance empAtt) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int eaname = 0;

		try {

			String emp = request.getParameter("employee_Id");
			String date=request.getParameter("date");
			String shift=request.getParameter("shiftId");
			
			eaname = empAttendanceService.checkDuplicate(emp,date,shift);
			if (eaname != 0) {
				empAtt.setAid(2);

				request.setAttribute("addEmployeeAttendanceDuplicate",
						"Employee Attendance with this date and Shift is Already Exists Please try some other");

				empAtt.setEmployee_Id("");
				empAtt.setDate("");
				empAtt.setShiftId("");

				msg = "Employee Attendance with this date and Shift is Already Exists Please try some other";

			}
			if (eaname == 0) {
				empAtt.setAid(2);
				request.setAttribute("addEmployeeAttendanceDuplicate",
						"Employee Attendance with this date and Shift is Already Exists Please try some other");
				empAtt.setEmployee_Id("");
				empAtt.setDate("");
				empAtt.setShiftId("");

				msg = "";

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	/*=================================Add Method=======================================*/
	@RequestMapping(value = "/empAttAdd", method = RequestMethod.POST)
	public String addEmployeeAttendance(
			@ModelAttribute("empAttendanceCommand") EmployeeAttendance empAttendanceAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		HttpSession session=null;
		String checkEmployee=empAttendanceAdd.getEmployee_Id();
		String checkShift=empAttendanceAdd.getShiftId();	
		String checkDate = empAttendanceAdd.getDate();
		int id=empAttendanceAdd.getEmpAttendanceId();
		int list1 = empAttendanceService.checkDuplicate(checkEmployee,checkShift,checkDate);
		if (list1 == 0) {
			try {
				if(empAttendanceAdd.getOverTime()==null||empAttendanceAdd.getOverTime()=="")
				{
					empAttendanceAdd.setOverTime("0");
					
				}
				msg = empAttendanceService.addEmployeeAttendance(empAttendanceAdd);
				if(msg.equals("S")){
					
					res = "redirect:employeeAttendance.mnt?list=" + "success" + "";
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Employee Attendance","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
					
					
					
					
					
					
					
					
				}
				else{
					
					res = "redirect:employeeAttendance.mnt?listwar=" + "fail" + "";
					
				}
				
			} catch (Exception e) {
				
				res = "redirect:employeeAttendance.mnt?listwar=" + "fail" + "";
				
				e.printStackTrace();
			}
			
		} else {
			empAttendanceAdd.setAid(1);
			request.setAttribute("adddEmpAttDuplicate",
					"Employee Attendance is Already Exists Please try some other name");
			return "empAttendanceHome";
		}
		return res;
	}

	/*
	 * =================================Search
	 * Method=======================================
	 */
	@RequestMapping(value = "/empAttSearch", method = RequestMethod.GET)
	public ModelAndView searchEmployeeAttendance(
			@ModelAttribute("empAttendanceCommand") EmployeeAttendance empAttendanceSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmployeeAttendance> empAtt = null;
		List<Object[]> list = null;
		try {
		
			String dbField = empAttendanceSearch.getXmlLabel();
			String operation = empAttendanceSearch.getOperations();
			String basicSearchId = empAttendanceSearch.getBasicSearchId();

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
				list = empAttendanceService.searchEmployeeAttendance();
				empAtt = new ArrayList<EmployeeAttendance>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					EmployeeAttendance empAttList = new EmployeeAttendance();
					
					empAttList.setEmpAttendanceId((Integer) objects[0]);
					
					Employee employeeBean = ((Employee) objects[1]);
					empAttList.setfName(employeeBean.getfName());
					
					empAttList.setDate((String)objects[2]);
					
					ShiftBean shiftBean=((ShiftBean)objects[3]);
					empAttList.setShift(shiftBean.getShift());
					
					empAttList.setInTime((String)objects[4]);
					empAttList.setOutTime((String)objects[5]);
					empAttList.setAttendance((String)objects[6]);
					empAttList.setOverTime((String)objects[7]);
					empAtt.add(empAttList);

				}

			} else {
				list = empAttendanceService.basicSearchEmployeeAttendance(dbField, operation,
						basicSearchId);
				empAtt = new ArrayList<EmployeeAttendance>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					EmployeeAttendance empAttList = new EmployeeAttendance();
					
					empAttList.setEmpAttendanceId((Integer) objects[0]);
					
					Employee employeeBean = ((Employee) objects[1]);
					empAttList.setfName(employeeBean.getfName());
					
					empAttList.setDate((String)objects[2]);
					
					ShiftBean shiftBean=((ShiftBean)objects[3]);
					empAttList.setShift(shiftBean.getShift());
					
					empAttList.setInTime((String)objects[4]);
					empAttList.setOutTime((String)objects[5]);
					empAttList.setAttendance((String)objects[6]);
					empAttList.setOverTime((String)objects[7]);
					empAtt.add(empAttList);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("empAttendanceSearchS", "empAttendanceSearchS");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("empAttendanceHome");
		modelAndView.addObject("empAttendanceCommand");
		request.setAttribute("employeeAttendanceValue", empAtt);
		return modelAndView;
	}

	/* ===========================Duplicate checking for Edit========================*/
	@RequestMapping(value = "/employeeAttendanceEditDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkEditDuplicate(HttpServletRequest request,
			HttpServletResponse response, EmployeeAttendance empAttEdit) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int eaname = 0;

		try {

			String empEditt = request.getParameter("employee_IdEditt");
		    String dateEditt=request.getParameter("dateEditt");
			String shiftEditt=request.getParameter("shiftIdEditt");
			
			eaname = empAttendanceService.checkDuplicate(empEditt,dateEditt,shiftEditt);
			if (eaname != 0) {
				empAttEdit.setAid(2);

				request.setAttribute("addEmployeeAttendanceDuplicate",
						"Employee Attendance with this date and Shift is Already Exists Please try some other");

				empAttEdit.setEmployee_IdEditt("");
				empAttEdit.setDateEditt("");
				empAttEdit.setShiftIdEditt("");

				msg = "Employee Attendance with this date and Shift is Already Exists Please try some other";

			}
			if (eaname == 0) {
				empAttEdit.setAid(2);
				request.setAttribute("editEmployeeAttendanceDuplicate",
						"Employee Attendance with this date and Shift is Already Exists Please try some other");
				empAttEdit.setEmployee_Id("");
				empAttEdit.setDate("");
				empAttEdit.setShiftId("");

				msg = "";

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	/** =================================Edit Method=======================================*/
	@RequestMapping(value = "/employeeAttendanceIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String employeeAttendanceEdit(@ModelAttribute EmployeeAttendance empAttEdit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("employeeAttendanceIdEdit"));
		List<Object[]> list = null;
		List<EmployeeAttendance> empAtt = new ArrayList<EmployeeAttendance>();
		Object[] objects = null;
		try {

			list = empAttendanceService.searchEmployeeAttendanceWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				
				empAttEdit.setEmpAttendanceIdEditt((Integer)objects[0]);
				empAttEdit.setEmployee_IdEditt((String)objects[1]);
				empAttEdit.setDateEditt((String)objects[2]);
				empAttEdit.setShiftIdEditt((String)objects[3]);
				empAttEdit.setInTimeEditt((String)objects[4]);
				empAttEdit.setOutTimeEditt((String)objects[5]);
				empAttEdit.setAttendanceEditt((String)objects[6]);
				empAttEdit.setOverTimeEditt((String)objects[7]);
				empAtt.add(empAttEdit);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}

		request.setAttribute("list", empAtt);
		model.addAttribute("empAttendanceCommand", empAttEdit);

		return "empAttendanceHome";
	}

	/** =================================Update Method=======================================*/
	@RequestMapping(value = "/empAttEdit", method = RequestMethod.POST)
	public String updateEmployeeAttendance(
			@ModelAttribute("empAttendanceCommand") EmployeeAttendance empAttUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int id = empAttUpdate.getEmpAttendanceIdEditt();
		String  checkEmployee = empAttUpdate.getEmployee_IdEditt();
		String checkShift=empAttUpdate.getShiftIdEditt();
		String checkDate=empAttUpdate.getDateEditt();
		int list1 = empAttendanceService.checkEditDuplicate(checkEmployee,checkShift,checkDate, id);
		if (list1 == 0) {
			try {
				empAttUpdate.setEmpAttendanceId(empAttUpdate.getEmpAttendanceIdEditt());
				empAttUpdate.setEmployee_Id(empAttUpdate.getEmployee_IdEditt());
				empAttUpdate.setDate(empAttUpdate.getDateEditt());
				empAttUpdate.setShiftId(empAttUpdate.getShiftIdEditt());
				empAttUpdate.setInTime(empAttUpdate.getInTimeEditt());
				empAttUpdate.setOutTime(empAttUpdate.getOutTimeEditt());
				empAttUpdate.setAttendance(empAttUpdate.getAttendanceEditt());
				if(empAttUpdate.getOverTimeEditt()==null||empAttUpdate.getOverTimeEditt()=="")
				{
					empAttUpdate.setOverTime("0");
				}
				else
				{
					empAttUpdate.setOverTime(empAttUpdate.getOverTimeEditt());
				}
				
			

				msg = empAttendanceService.updateEmployeeAttendance(empAttUpdate);
				if(msg.equals("S")){
					request.setAttribute("empAttendanceUpdate","Employee Attendance has been updated");
				}
				else{
					request.setAttribute("empAttendanceUpdateError", "Employee Attendance has not been updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		} else {
			request.setAttribute("list", "empAtt");
			request.setAttribute("addEmpAttDuplicate",
					"Employee Attendance is Already Exists Please try some other name");
			return "empAttendanceHome";
		}
		return "empAttendanceHome";
	}

	/** =================================Delete Method=======================================*/
	
	@RequestMapping(value = "/employeeAttendanceIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteEmployeeAttendance(@ModelAttribute("empAttendanceCommand") EmployeeAttendance empAttDelete, Model model,HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int employeeAttendanceId = 0;
		HttpSession session=null;
		try {
			employeeAttendanceId = Integer.parseInt(request.getParameter("employeeAttendanceIdDelete"));

			String msg = empAttendanceService.deleteEmployeeAttendance(employeeAttendanceId);
			if (msg.equals("S")) {
			request.setAttribute("empAttendanceDelete","Employee Attendance has been deleted");	
			session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employee Attendance","ROW" ,String.valueOf(employeeAttendanceId),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}else{
				
				request.setAttribute("empAttendanceDeleteError","Employee Attendance has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("empAttendanceHome", "empAttendanceCommand",new EmployeeAttendance());
		
	}


}
