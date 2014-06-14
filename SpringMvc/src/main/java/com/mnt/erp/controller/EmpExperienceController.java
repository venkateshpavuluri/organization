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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Designation;
import com.mnt.erp.bean.EmpExperience;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmpExperienceService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;



/**
 * @author kirangangone
 * @version 1.0 01-02-2014
 * @build 0.0
 * 
 */

@Controller
@Scope("request")
public class EmpExperienceController {
	@Autowired
	EmpExperienceService empExperienceService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	PopulateService populateService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	DateConversionService dateService;
	@RequestMapping(value = "/EmpExperience", method = RequestMethod.GET)
	public ModelAndView getEmpExp(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("EmpExperience.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
				return new ModelAndView("empExperienceHome","empExperienceCommand",new EmpExperience());

	}
	
	
	

	@ModelAttribute("employee_Id")
	public Map<Integer, String> populateEmployeeIdDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>();
						listvalues = populateService
					.poPulate("select m.employee_Id,m.fName from Employee m");

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
	
	@ModelAttribute("designation_Id")
	public Map<Integer, String> populateDesignationIdDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>(); 
						listvalues = populateService
					.poPulate("select m.designationId,m.designation from Designation m");

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
	
	
	@ModelAttribute("redDesigntion_Id")
	public Map<Integer, String> populateRedDesigntion_IdDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>(); 
			listvalues = populateService.poPulate("select m.designationId,m.designation from Designation m");

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
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "empExperience";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	@RequestMapping(value = "/empExperienceCheck", method = RequestMethod.POST)
	public @ResponseBody
	String empExpDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("employee_Id");
			String designation_Id = request.getParameter("designation_Id");
			String company = request.getParameter("company");
			String id=request.getParameter("empExperienceId");
			if(id.equalsIgnoreCase("0"))
			{
			beforeCreditNoteNoValue = empExperienceService.duplicateCheckEmpExperience(beforeCreditNoteNo,designation_Id,company,"");
			}
			else
			{
				beforeCreditNoteNoValue = empExperienceService.duplicateCheckEmpExperience(beforeCreditNoteNo,designation_Id,company,id);
				
			}
			
			EmpExperience e = new EmpExperience();
			if (beforeCreditNoteNoValue != 0) {
				e.setDuplicate(1);
				msa = "Warning ! Employee Experience aleardy exists.";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				e.setDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}
	
	
	@RequestMapping(value = "/empExperienceAdd", method = RequestMethod.POST)
	public String empExpSave(@ModelAttribute("empExperienceCommand") EmpExperience empExperienceAdd,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		HttpSession session=null;
		int id=empExperienceAdd.getExperience_Id();
		int checkCreditNote =0;
		if (checkCreditNote == 0) {
			try {
				empExperienceAdd.setTodate(dateService.dateFormat(dateService.dateParse(empExperienceAdd.getTodate(),"au"),"au"));
				empExperienceAdd.setFromDT(dateService.dateFormat(dateService.dateParse(empExperienceAdd.getFromDT(),"au"),"au"));
				msg = empExperienceService.saveEmpExperience(empExperienceAdd);
			
				if(msg.equals("S"))
				{
					res = "redirect:EmpExperience.mnt?list=" + "success" + "";
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Employee Experience","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
					
					
					
				}
				else
				{
					res = "redirect:EmpExperience.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				res = "redirect:EmpExperience.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
				
			}
		} else {
		
			request.setAttribute("fail","Warning ! EmpExperience  aleardy exists. Please try some other Chart of Account ");
			return "empExperienceHome";

		}
		return res;
	}
	
	
	
	
	@RequestMapping(value = "/empExperienceSearch", method = RequestMethod.GET)
	public String empExpSearch(
			@ModelAttribute("empExperienceCommand") EmpExperience empExperience,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmpExperience> empExperienceList = new ArrayList<EmpExperience>();
		List<Object[]> empExperienceObjecList = null;
		Iterator<Object[]> empExperienceIterator = null;
		Object[] empExperienceObjects = null;
		try {
			
			String dbField = empExperience.getXmlLabelBasic();
			String operation = empExperience.getOperations();
			String basicSearchId = empExperience.getBasicSearchId();

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
				empExperienceObjecList = empExperienceService.basicSearchEmpExperience("","","");

			} else {

				empExperienceObjecList = empExperienceService.basicSearchEmpExperience(dbField, operation,
						basicSearchId);
			}
			empExperienceIterator = empExperienceObjecList.iterator();
			while (empExperienceIterator.hasNext()) {
				empExperienceObjects = (Object[]) empExperienceIterator.next();
				EmpExperience cb = new EmpExperience();
				
			
				 cb.setExperience_Id((Integer)empExperienceObjects[0]);
				
				 cb.setFromDT(dateService.dateFormat(dateService.dateParse((String)empExperienceObjects[2],"se"),"se"));
				 cb.setTodate(dateService.dateFormat(dateService.dateParse((String)empExperienceObjects[3],"se"),"se"));
				 cb.setDesignation_Id((String)empExperienceObjects[4]);
				 cb.setCompany((String)empExperienceObjects[5]);
				 cb.setCompPhone((String)empExperienceObjects[6]);
				 cb.setReferenceName((String)empExperienceObjects[7]);
				 cb.setRedDesigntion_Id((String)empExperienceObjects[8]);
				 cb.setEmail((String)empExperienceObjects[9]);
				 Employee emp=(Employee)empExperienceObjects[10];
				 cb.setEmployee_Id((String)emp.getfName());
				 Designation dep=(Designation)empExperienceObjects[11];
				 cb.setDesignation_Id((String)dep.getDesignation());
				 Designation redDep=(Designation)empExperienceObjects[12];
				 cb.setRedDesigntion_Id((String)redDep.getDesignation());
				empExperienceList.add(cb);

			}

			request.setAttribute("empExperienceList", empExperienceList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "empExperienceHome";

	}
	
	
	
	@RequestMapping(value = "/empExperienceEdit", method = RequestMethod.GET)
	public String empExpEdit(
			@ModelAttribute("empExperienceCommand") EmpExperience empExperience,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmpExperience> empExperienceEditList = new ArrayList<EmpExperience>();
		int purcId = Integer.parseInt(request.getParameter("experience_Id"));

		try {

			List<Object> empExperienceList = empExperienceService.editEmpExperience(purcId);
			Iterator<Object> empExperienceIterator = empExperienceList.iterator();
			if (empExperienceIterator.hasNext()) {
				Object oo = empExperienceIterator.next();
				EmpExperience ccb = (EmpExperience)oo;
				empExperience.setExperience_Id(ccb.getExperience_Id());
					
				empExperience.setFromDT(dateService.dateFormat(dateService.dateParse(ccb.getFromDT(),"se"),"se"));
				empExperience.setTodate(dateService.dateFormat(dateService.dateParse(ccb.getTodate(),"se"),"se"));
				empExperience.setDesignation_Id(ccb.getDesignation_Id());
				empExperience.setCompany(ccb.getCompany());
				empExperience.setCompPhone(ccb.getCompPhone());
				empExperience.setRedDesigntion_Id(ccb.getRedDesigntion_Id());
				empExperience.setReferenceName(ccb.getReferenceName());
				empExperience.setEmail(ccb.getEmail());
				empExperience.setEmployee_Id(ccb.getEmployee_Id());
				empExperience.setDesignation_Id(ccb.getDesignation_Id());
				empExperience.setRedDesigntion_Id(ccb.getRedDesigntion_Id());
				
				

				}
				
			empExperienceEditList.add(empExperience);
		

			request.setAttribute("empExperienceEditList", empExperienceEditList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "empExperienceHome";
	}
	
	
	
	
	@RequestMapping(value = "/empExperienceUpdate", method = RequestMethod.POST)
	public String empExpUpdate(
			@ModelAttribute("empExperienceCommand") EmpExperience empExperienceUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg=null;
		
		try{
			
		empExperienceUpdate.setTodate(dateService.dateFormat(dateService.dateParse(empExperienceUpdate.getTodate(),"au"),"au"));
	
		empExperienceUpdate.setFromDT(dateService.dateFormat(dateService.dateParse(empExperienceUpdate.getFromDT(),"au"),"au"));
		msg = empExperienceService.updateEmpExperience(empExperienceUpdate);
		if (msg.equals("S")) {
			
			request.setAttribute("empExpUpdate", "Employee Experience has been updated");

		} else {
			
			request.setAttribute("empExpUpdateError","Employee Experience has not been updated");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "empExperienceHome";
	}
	
	
	
	
	@RequestMapping(value = "/empExperienceDelete", method = RequestMethod.GET)
	public ModelAndView empExpDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		try {
			
			int id = Integer.parseInt(request.getParameter("experience_Id"));
			String msg = empExperienceService.deleteEmpExperience(id);
			if (msg.equals("S"))
			{
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employee Experience","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("empExpDelete","Employee Experience has been deleted");
			}
			else
			{
				request.setAttribute("empExpDeleteError", "Employee Experience has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("empExperienceHome", "empExperienceCommand",new EmpExperience());
		
	}
	
}
