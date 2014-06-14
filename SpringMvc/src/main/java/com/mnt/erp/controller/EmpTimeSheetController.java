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

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.ActivityBean;

import com.mnt.erp.bean.BreakTimeBean;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeTimeSheet;


import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EmpTimeSheetService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author devi
 *
 */
@Controller
public class EmpTimeSheetController {
	@Autowired
	MenuService menuService;
	@Autowired
	EmpTimeSheetService etsService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	
	
	HttpSession session;
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	
	@RequestMapping(value = "/EmpTimeSheet", method = RequestMethod.GET)
	public String getEmpTimeSheet(@ModelAttribute EmployeeTimeSheet btBean,
			SessionStatus status, Model model, HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("EmpTimeSheet.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("EmpTimeSheet", btBean);
		return "EmpTimeSheet";

	}
	@RequestMapping(value = "/addEmpTimeSheet", method = RequestMethod.POST)
	public String saveEmpTimeSheet(@ModelAttribute("EmpTimeSheet") EmployeeTimeSheet empBean,
			Model model, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus) {
		response.setCharacterEncoding("UTF-8");
		String msg,res = null;
		
		List<String> list = null;
		String name = empBean.getEmployee();
		Long id = 0L;

		try {
			id = etsService.getEmpTimeSheetCount(name);
			if (id == 0) {
				session=request.getSession(false);
				msg = etsService.saveEmpTimeSheet(empBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				 
				
				if (msg.equals("S")) 
					res = "redirect:EmpTimeSheet.mnt?list=" + "success" + "";
					
				else
					res = "redirect:EmpTimeSheet.mnt?listwar=" + "fail" + "";
				
			} else {
				empBean.setAid(1);
				request.setAttribute("addEmpTimeSheetDuplicate",
						"EmpTime sheet is already exists. Please try some other name");

				return "EmpTimeSheet";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:EmpTimeSheet.mnt?listwar=" + "fail" + "";
		}

		return res;

	}
	
	@RequestMapping(value = "/searchEmpTimeSheet", method = RequestMethod.GET)
	public String searchEmpTimeSheetIds(@ModelAttribute("EmpTimeSheet") EmployeeTimeSheet eBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid =eBean.getEmployeeTimeSheet_Id();
			List<EmployeeTimeSheet> btBeans = new ArrayList<EmployeeTimeSheet>();
			String dbField = eBean.getXmlLabel();
			String operation = eBean.getOperations();
			String basicSearchId = eBean.getBasicSearchId();
            
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
				list = etsService.searchEmpTimeSheet();
				
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmployeeTimeSheet btbean2=new  EmployeeTimeSheet();
					btbean2.setEmployeeTimeSheet_Id((Integer)obj[0]);
					Employee empBean=((Employee) obj[1]);
					btbean2.setEmployee(empBean.getfName());
					btbean2.setTimeSheetDT((String) obj[2]);
					ActivityBean actBean=((ActivityBean) obj[3]);
					btbean2.setActivity(actBean.getActivity());
					btbean2.setTimeSpent((String) obj[4]);
					btBeans.add(btbean2);
				}

			} else {

				list = etsService.basicSearchEmpTimeSheet(dbField, operation,basicSearchId);
				System.out.println("from control");
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmployeeTimeSheet btbean2=new  EmployeeTimeSheet();
					btbean2.setEmployeeTimeSheet_Id((Integer)obj[0]);
					Employee empBean=((Employee) obj[1]);
					btbean2.setEmployee(empBean.getfName());
					btbean2.setTimeSheetDT((String) obj[2]);
					ActivityBean actBean=((ActivityBean) obj[3]);
					btbean2.setActivity(actBean.getActivity());
					btbean2.setTimeSpent((String) obj[4]);
					btBeans.add(btbean2);
				}
			}
			request.setAttribute("empTimeSheet", btBeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "EmpTimeSheet";
	}
	
	@RequestMapping(value = "/empTimeSheetEdit", method = RequestMethod.GET)
	public String editEmpTimeSheet(@ModelAttribute("EmpTimeSheet") EmployeeTimeSheet brBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("empSheetEdit"));

		try {
			List<EmployeeTimeSheet> brBeans = new ArrayList<EmployeeTimeSheet>();
			list = etsService.searchEmpTimeSheetWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				brBean.setEmployeeTimeSheet_Id((Integer) obj[0]);
				brBean.setEmployee((String) obj[1]);
				brBean.setTimeSheetDT((String) obj[2]);
				brBean.setActivity((String)obj[3]);
				brBean.setTimeSpent((String) obj[4]);
				
				brBeans.add(brBean);
			}
			request.setAttribute("editvalues", brBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "EmpTimeSheet";

	}
	@RequestMapping(value = "/empTimeSheetUpdate", method = RequestMethod.POST)
	public String updateEmpTimeSheet(@ModelAttribute("EmpTimeSheet") EmployeeTimeSheet brBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = brBean.getEmployee();
		int breakId = brBean.getEmployeeTimeSheet_Id();
		
		Long id = 0l;
		
		
		try {
			id = etsService.getEmpTimeSheetCountEdit(name, breakId);

			if (id == 0) {
			    brBean.setEmployeeTimeSheet_Id(brBean.getEmployeeTimeSheet_Id());
			    brBean.setEmployee(brBean.getEmployee());
			    brBean.setTimeSheetDT(brBean.getTimeSheetDT());
			    brBean.setActivity(brBean.getActivity());
			    brBean.setTimeSpent(brBean.getTimeSpent());
				
			  etsService.updateEmpTimeSheet(brBean);
					   
			   request.setAttribute("empTimeSheetUpdate", "emptimeSheet Details Updated Successfully");
					
					
				}
			
				
			 else {
				 request.setAttribute("updateEmptimesheetDuplicate",
							"empTime sheet is already exists. Please try some other name");
					request.setAttribute("editvalues", "editvalues");
					return "EmpTimeSheet";
			}
		} catch (Exception e) {
			e.printStackTrace();
			  request.setAttribute("empTimeSheetUpdateErr", "EmpTime Sheet Details Doesn't Updated");

		}
		 model.addAttribute("EmpTimeSheet", new EmployeeTimeSheet());
		return "EmpTimeSheet";
	}
	
	@RequestMapping(value = "/empTimeSheetDelete", method = RequestMethod.GET)
	@RequestScoped
	public String empTimeSheetDelete(@ModelAttribute("EmpTimeSheet") EmployeeTimeSheet brBean,HttpServletRequest request,
			HttpServletResponse response,Model model) {
		
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		
		try {
			Id = Integer.parseInt(request.getParameter("empSheetDelete"));

			String msg = etsService.deleteEmpTimeSheet(Id);
			if (msg.equals("S")){
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Break Time","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				request.setAttribute("empTimeSheetDel", "EmpTimeSheet Details Deleted Successfully");
			}	else
				request.setAttribute("empTimeSheetDelErr", "EmpTimeSheet Details Doesn't Deleted ");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("empTimeSheetDelErr", "empTimeSheet Details Doesn't Deleted ");
		}
		 model.addAttribute("EmpTimeSheet", new EmployeeTimeSheet());
		 return "EmpTimeSheet";
	}
	
	@ModelAttribute("employee")
	public Map<Integer, String> employee() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = etsService.selectEmpService();
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

	
	@ModelAttribute("activity")
	public Map<Integer, String> activity() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = etsService.selectActivityService();
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

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "empName";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
