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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeLeave;
import com.mnt.erp.bean.LeaveTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmployeeLeaveService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.mail.MailService;



/**
 * @author kirangangone
 * @version 1.0 04-01-2014
 * @build 0.0
 * 
 */

@Controller
@Scope("request")
public class EmployeeLeaveController {
	private static Logger logger=Logger.getLogger(EmployeeLeaveController.class);
	@Autowired
	public org.springframework.mail.javamail.JavaMailSenderImpl mailSender;
	@Autowired
	EmployeeLeaveService employeeLeaveService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
    public MailService	userRegistrationService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	@Autowired
	DateConversionService dateService;
	@RequestMapping(value = "/EmployeeLeave", method = RequestMethod.GET)
	public ModelAndView getPurchaseOrder(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("EmployeeLeave.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
				return new ModelAndView("employeeLeaveHome","employeeLeaveCommand",new EmployeeLeave());
	}
	@ModelAttribute("leaveTypeIdDetails")
	public Map<Integer, String> getEmployeeLeaveGroupId() {
		List<Object[]> employeeLeaveListvalues = null;
		Iterator<Object[]> employeeLeaveIterator = null;
		Object[] employeeLeaveObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			employeeLeaveListvalues = employeeLeaveService.getAllSelectId("leaveTypeIdDetails");
			employeeLeaveIterator = employeeLeaveListvalues.iterator();
			while (employeeLeaveIterator.hasNext()) {
				employeeLeaveObjects = (Object[]) employeeLeaveIterator.next();
				map.put((Integer) employeeLeaveObjects[0], (String) employeeLeaveObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	@ModelAttribute("reptMgrIdDetails")
	public Map<Integer, String> getReptMgrIdDetails() {
		List<Object[]> employeeLeaveListvalues = null;
		Iterator<Object[]> employeeLeaveIterator = null;
		Object[] employeeLeaveObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			employeeLeaveListvalues = employeeLeaveService.getAllSelectId("reptMgrIdDetails");
			employeeLeaveIterator = employeeLeaveListvalues.iterator();
			while (employeeLeaveIterator.hasNext()) {
				employeeLeaveObjects = (Object[]) employeeLeaveIterator.next();
				map.put((Integer) employeeLeaveObjects[0], (String) employeeLeaveObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	@ModelAttribute("employeeIdDetails")
	public Map<Integer, String> getEmployeeIdDetails() {
		List<Object[]> employeeLeaveListvalues = null;
		Iterator<Object[]> employeeLeaveIterator = null;
		Object[] employeeLeaveObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			employeeLeaveListvalues = employeeLeaveService.getAllSelectId("employeeIdDetails");
			employeeLeaveIterator = employeeLeaveListvalues.iterator();
			while (employeeLeaveIterator.hasNext()) {
				employeeLeaveObjects = (Object[]) employeeLeaveIterator.next();
				map.put((Integer) employeeLeaveObjects[0], (String) employeeLeaveObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	@ModelAttribute("status")
	public Map<Integer, String> getStatusDetails() {
		List<Object[]> employeeLeaveListvalues = null;
		Iterator<Object[]> employeeLeaveIterator = null;
		Object[] employeeLeaveObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			employeeLeaveListvalues = employeeLeaveService.getAllSelectId("status");
			employeeLeaveIterator = employeeLeaveListvalues.iterator();
			while (employeeLeaveIterator.hasNext()) {
				employeeLeaveObjects = (Object[]) employeeLeaveIterator.next();
				map.put((Integer) employeeLeaveObjects[0], (String) employeeLeaveObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "employeeLeave";

		Map<String, String> map =null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/employeeLeaveCheck", method = RequestMethod.POST)
	public @ResponseBody
	String creditNoteNoDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("employeeLeave");
			String id=request.getParameter("employeeLeaveId");
			if(id.equalsIgnoreCase("0"))
			{
			beforeCreditNoteNoValue = employeeLeaveService.duplicateCheckEmployeeLeave(beforeCreditNoteNo,"");
			}
			else
			{
			beforeCreditNoteNoValue = employeeLeaveService.duplicateCheckEmployeeLeave(beforeCreditNoteNo,id);
			}
			
			EmployeeLeave creditNote = new EmployeeLeave();
			
			if (beforeCreditNoteNoValue != 0) {
				
				creditNote.setStartDate("");
				msa = "Warning ! EmployeeLeave aleardy exists. Please try some other no";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}
	
	
	@RequestMapping(value = "/employeeLeaveAdd", method = RequestMethod.GET)
	public String addPurchaseOrder(@ModelAttribute("employeeLeaveCommand") EmployeeLeave employeeLeaveAdd,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		boolean flag = false;
		Date date = new Date();
		String res=null;
		HttpSession session=null;
		int id=employeeLeaveAdd.getEmployeeLeaveId();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		employeeLeaveAdd.setCreatedDate(modifiedDate);
		String emailCCList =employeeLeaveAdd.getEmailCCList();
		 String[] splitedEmail = emailCCList.split(",");
		 mailSender.setHost("smtp.gmail.com");
		 mailSender.setPort(587);
		 mailSender.setUsername("p.venkatesh59@gmail.com");
		 mailSender.setPassword("Venkatesh");
		int checkCreditNote = employeeLeaveService.duplicateCheckEmployeeLeave(employeeLeaveAdd.getStartDate(),"");
		if (checkCreditNote == 0) {
			try {
				logger.debug("date iss==="+dateService.dateFormat(dateService.dateParse(employeeLeaveAdd.getReportingDate(),"au"),"au")+"=="+dateService.dateFormat(dateService.dateParse(employeeLeaveAdd.getStartDate(),"au"),"au")+"=="+dateService.dateFormat(dateService.dateParse(employeeLeaveAdd.getEndDate(),"au"),"au"));
				employeeLeaveAdd.setReportingDate(dateService.dateFormat(dateService.dateParse(employeeLeaveAdd.getReportingDate(),"au"),"au"));
				employeeLeaveAdd.setStartDate(dateService.dateFormat(dateService.dateParse(employeeLeaveAdd.getStartDate(),"au"),"au"));
				employeeLeaveAdd.setEndDate(dateService.dateFormat(dateService.dateParse(employeeLeaveAdd.getEndDate(),"au"),"au"));
				flag = employeeLeaveService.saveEmployeeLeave(employeeLeaveAdd);
				Set<String> set=new HashSet<String>();
				for (String string : splitedEmail) {
				set.add(string);
				}				 				 	
	 			userRegistrationService.setUserEmailIds(set);
	 		    userRegistrationService.uponSuccessfulRegistration(splitedEmail);
				if(flag==true)
				{
					res = "redirect:EmployeeLeave.mnt?list=" + "success" + "";
					session=request.getSession(false);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Employee Leave","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				}
				else
				{
					res = "redirect:EmployeeLeave.mnt?listwar=" + "fail" + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			request.setAttribute("fail","Warning ! EmployeeLeave  aleardy exists. Please try some other EmployeeLeave");
		}
		return res;
	}
	@RequestMapping(value = "/employeeLeaveSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("employeeLeaveCommand") EmployeeLeave employeeLeave,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmployeeLeave> employeeLeaveList = new ArrayList<EmployeeLeave>();
		List<Object[]> employeeLeaveObjecList = null;
		Iterator<Object[]> employeeLeaveIterator = null;
		Object[] employeeLeaveObjects = null;
		try {
			String dbField = employeeLeave.getXmlLabelBasic();
			String operation = employeeLeave.getOperations();
			String basicSearchId = employeeLeave.getBasicSearchId();
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
				
				employeeLeaveObjecList = employeeLeaveService.basicSearchEmployeeLeave("","","");

			} else {

				employeeLeaveObjecList = employeeLeaveService.basicSearchEmployeeLeave(dbField, operation,
						basicSearchId);
			}
			employeeLeaveIterator = employeeLeaveObjecList.iterator();
			while (employeeLeaveIterator.hasNext()) {
				employeeLeaveObjects = (Object[]) employeeLeaveIterator.next();
				EmployeeLeave cb = new EmployeeLeave();
				cb.setEmployeeLeaveId((Integer)employeeLeaveObjects[0]);
				LeaveTypeBean leaveTypeBean=(LeaveTypeBean)employeeLeaveObjects[1]; 
				Employee employeeMgr=(Employee)employeeLeaveObjects[2];
				Employee employeeEmp=(Employee)employeeLeaveObjects[3];
				cb.setEmployeeId(employeeEmp.getfName());
				cb.setReptMgrId(employeeMgr.getfName());
				cb.setLeaveTypeId(leaveTypeBean.getLeaveType());
				cb.setStartDate(dateService.dateFormat(dateService.dateParse((String)employeeLeaveObjects[9], "se"), "se"));
				cb.setEndDate(dateService.dateFormat(dateService.dateParse((String)employeeLeaveObjects[11], "se"), "se"));
				//cb.setReportingDate(dateService.dateFormat(dateService.dateParse((String)employeeLeaveObjects[11], "se"), "se"));
				cb.setEndDate((String)employeeLeaveObjects[11]);
					employeeLeaveList.add(cb);
			}
			request.setAttribute("employeeLeaveList", employeeLeaveList);
			employeeLeave.setBasicSearchId("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "employeeLeaveHome";
	}
	@RequestMapping(value = "/employeeLeaveEdit", method = RequestMethod.GET)
	public String creditNoteEdit(
			@ModelAttribute("employeeLeaveCommand") EmployeeLeave employeeLeave,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmployeeLeave> employeeLeaveEditList = new ArrayList<EmployeeLeave>();
		int purcId = Integer.parseInt(request.getParameter("employeeLeaveId"));
		try {
			List<Object> employeeLeaveList = employeeLeaveService.editEmployeeLeave(purcId);
			Iterator<Object> employeeLeaveIterator = employeeLeaveList.iterator();
			if (employeeLeaveIterator.hasNext()) {
				Object oo = employeeLeaveIterator.next();
				EmployeeLeave ccb = (EmployeeLeave)oo;
				employeeLeave.setEmployeeLeaveId(ccb.getEmployeeLeaveId());
				employeeLeave.setEmployeeId(ccb.getEmployeeId());
				employeeLeave.setLeaveTypeId(ccb.getLeaveTypeId());
				employeeLeave.setReptMgrId(ccb.getReptMgrId());
				employeeLeave.setNoOfAvailableCL(ccb.getNoOfAvailableCL());
				employeeLeave.setNoOfAvailableCFL(ccb.getNoOfAvailableCFL());
				employeeLeave.setStartDate(dateService.dateFormat(dateService.dateParse(ccb.getStartDate(), "se"), "se"));
				employeeLeave.setsDayPart(ccb.getsDayPart());
				employeeLeave.setEndDate(dateService.dateFormat(dateService.dateParse(ccb.getEndDate(), "se"), "se"));
				employeeLeave.seteDayPart(ccb.geteDayPart());
				employeeLeave.setRecursiveHalf(ccb.getRecursiveHalf());
				employeeLeave.setReportingDate(dateService.dateFormat(dateService.dateParse(ccb.getReportingDate(), "se"), "se"));
				employeeLeave.setReason(ccb.getReason());
				employeeLeave.setMobile(ccb.getMobile());
				employeeLeave.setResidence(ccb.getResidence());
				employeeLeave.setOtherNo(ccb.getOtherNo());
				employeeLeave.setCreatedDate(ccb.getCreatedDate());
				employeeLeave.setCreatedBy(ccb.getCreatedBy());
				employeeLeave.setUpdatedDate(ccb.getUpdatedDate());
				employeeLeave.setUpdatedBy(ccb.getUpdatedBy());
				employeeLeave.setStatusId(ccb.getStatusId());
				employeeLeave.setDeclineReason(ccb.getDeclineReason());
				employeeLeave.setApprovedBy(ccb.getApprovedBy());
				employeeLeave.setNarration(ccb.getNarration());
				employeeLeave.setEmailCCList(ccb.getEmailCCList());
				employeeLeave.setDays(ccb.getDays());
				}
			employeeLeaveEditList.add(employeeLeave);
			request.setAttribute("employeeLeaveEditList", employeeLeaveEditList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "employeeLeaveHome";
	}
	@RequestMapping(value = "/employeeLeaveUpdate", method = RequestMethod.POST)
	public String empLeaveUpdate(
			@ModelAttribute("employeeLeaveCommand") EmployeeLeave employeeLeaveUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try{
		boolean flag=false;
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		employeeLeaveUpdate.setUpdatedDate(modifiedDate);
		
		employeeLeaveUpdate.setStartDate(dateService.dateFormat(dateService.dateParse(employeeLeaveUpdate.getStartDate(),"au"),"au"));
		employeeLeaveUpdate.setEndDate(dateService.dateFormat(dateService.dateParse(employeeLeaveUpdate.getEndDate(),"au"),"au"));
		employeeLeaveUpdate.setStartDate(dateService.dateFormat(dateService.dateParse(employeeLeaveUpdate.getReportingDate(),"au"),"au"));
		flag = employeeLeaveService.updateEmployeeLeave(employeeLeaveUpdate);
		if (flag==true) {
			
			request.setAttribute("empLeaveUpdate","Employee Leave has been updated");
		}
		else {
			
			request.setAttribute("empLeaveUpdateError", "Employee Leave has not been updated");
		}
		}catch(Exception e){
			
		}
		return "employeeLeaveHome";
	}
	@RequestMapping(value = "/employeeLeaveDelete", method = RequestMethod.GET)
	public ModelAndView BomDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			int id = Integer.parseInt(request.getParameter("employeeLeaveId"));
			boolean msg = employeeLeaveService.deleteEmployeeLeave(id);
			if (msg==true)
			{
			 request.setAttribute("empLeaveDelete","Employee Leave has been deleted");
			 session=request.getSession(false);
			 Date date = new Date();
			 String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			 auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employee Leave","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else
			{
			 request.setAttribute("empLeaveDeleteError","Employee Leave has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("employeeLeaveHome", "employeeLeaveCommand",new EmployeeLeave());
	}
	
}
