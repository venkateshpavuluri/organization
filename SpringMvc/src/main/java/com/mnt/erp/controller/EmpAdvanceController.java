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
import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.EmpAdvance;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.LoanTypeBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmpAdvanceService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class EmpAdvanceController {
	@Autowired
	EmpAdvanceService empAdvanceService;
	 @Autowired
	    PopulateService populateService;
		@Autowired
		DateConversionService dateService;
	 @Autowired
	    XmlLabelsService xmlService;
@RequestMapping(value="/EmpAdvance",method=RequestMethod.GET)
public ModelAndView getEmpAdvance(HttpServletRequest request,
		HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	return new ModelAndView("EmpAdvanceHome", "empAdvanceCommand",
			new EmpAdvance());
}
@ModelAttribute("loanType")
public Map<Integer, String> populateLoanType() {
List<Object[]> listvalues = null;
Map<Integer, String> map = null;
Iterator<Object[]> iterator = null;
try {
    map = new HashMap<Integer, String>();
    listvalues = populateService
	    .poPulate("select l.loanTypeId,l.loanType from LoanTypeBean l");

    iterator = listvalues.iterator();
    while (iterator.hasNext()) {
	Object[] objects = (Object[]) iterator.next();
	// list.add((String)objects[1]);
	map.put((Integer) objects[0], (String) objects[1]);

    }

} catch (Exception e) {
    e.printStackTrace();
}

return map;
}
@ModelAttribute("employee")
public Map<Integer, String> populateEmployee() {
List<Object[]> listvalues = null;
Map<Integer, String> map = null;
Iterator<Object[]> iterator = null;
try {
    map = new HashMap<Integer, String>();
    listvalues = populateService
	    .poPulate("select e.employee_Id,e.fName from Employee e");

    iterator = listvalues.iterator();
    while (iterator.hasNext()) {
	Object[] objects = (Object[]) iterator.next();
	// list.add((String)objects[1]);
	map.put((Integer) objects[0], (String) objects[1]);

    }

} catch (Exception e) {
    e.printStackTrace();
}

return map;
}

@ModelAttribute("currency")
public Map<Integer, String> populateCurrency() {
List<Object[]> listvalues = null;
Map<Integer, String> map = null;
Iterator<Object[]> iterator = null;
try {
    map = new HashMap<Integer, String>();
    listvalues = populateService
	    .poPulate("select c.currencyId,c.currency from Currency c");

    iterator = listvalues.iterator();
    while (iterator.hasNext()) {
	Object[] objects = (Object[]) iterator.next();
	// list.add((String)objects[1]);
	map.put((Integer) objects[0], (String) objects[1]);

    }

} catch (Exception e) {
    e.printStackTrace();
}

return map;
}

@ModelAttribute("status")
public Map<Integer, String> populateStatus() {
List<Object[]> listvalues = null;
Map<Integer, String> map = null;
Iterator<Object[]> iterator = null;
try {
    map = new HashMap<Integer, String>();
    listvalues = populateService
	    .poPulate("select s.statusId,s.status from Status s");

    iterator = listvalues.iterator();
    while (iterator.hasNext()) {
	Object[] objects = (Object[]) iterator.next();
	// list.add((String)objects[1]);
	map.put((Integer) objects[0], (String) objects[1]);

    }

} catch (Exception e) {
    e.printStackTrace();
}

return map;
}
@ModelAttribute("payMode")
public Map<Integer, String> populatePayMode() {
List<Object[]> listvalues = null;
Map<Integer, String> map = null;
Iterator<Object[]> iterator = null;
try {
    map = new HashMap<Integer, String>();
    listvalues = populateService
	    .poPulate("select p.payMode_Id,p.payMode from PayModeBean p");

    iterator = listvalues.iterator();
    while (iterator.hasNext()) {
	Object[] objects = (Object[]) iterator.next();
	// list.add((String)objects[1]);
	map.put((Integer) objects[0], (String) objects[1]);

    }

} catch (Exception e) {
    e.printStackTrace();
}

return map;
}

@ModelAttribute("bank")
public Map<Integer, String> populateBank() {
List<Object[]> listvalues = null;
Map<Integer, String> map = null;
Iterator<Object[]> iterator = null;
try {
    map = new HashMap<Integer, String>();
    listvalues = populateService
	    .poPulate("select b.bankid,b.bankname from HouseBankBean b");

    iterator = listvalues.iterator();
    while (iterator.hasNext()) {
	Object[] objects = (Object[]) iterator.next();
	// list.add((String)objects[1]);
	map.put((Integer) objects[0], (String) objects[1]);

    }

} catch (Exception e) {
    e.printStackTrace();
}

return map;
}
@RequestMapping(value = "/EmpAdvanceAdd", method = RequestMethod.POST)
public String saveEmpAdvance(
		@ModelAttribute("empAdvanceCommand") EmpAdvance EmpAdvance,
		HttpServletRequest request, Model model,
		HttpServletResponse response) {

	List<String> list = new ArrayList<String>();
	String msg = null;
	String empAdvanceCommand = null;
	

	String res = null;
	HttpSession session=null;
	int EmpAdvanceList1 = 0;
	String agreementTyp = EmpAdvance.getEmployeeId();
	EmpAdvanceList1 = empAdvanceService.EmpAdvanceDuplicate(agreementTyp);

	if (EmpAdvanceList1 == 0) {

		try {
			EmpAdvance.setsTDT(dateService.dateFormat(dateService.dateParse(EmpAdvance.getsTDT(), "au"),"au"));
			session=request.getSession(false);
			msg = empAdvanceService.saveEmpAdvance(EmpAdvance,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

			if (msg.equals("S")) {
				empAdvanceCommand = "Agreement Type has been saved successfully";
				list.add("2");
				res = "redirect:EmpAdvance.mnt?success="
						+ empAdvanceCommand + "&list=" + list + "";
			} else {
				empAdvanceCommand = "Agreement Type is not saved properly";
				list.add("2");
				res = "redirect:EmpAdvance.mnt?warning="
						+ empAdvanceCommand + "&listwar=" + list + "";
			}

		} catch (Exception e) {
			
			empAdvanceCommand = "Agreement Type is not saved properly";
			list.add("2");
			res = "redirect:EmpAdvance.mnt?warning="
					+ empAdvanceCommand + "&listwar=" + list + "";
			e.printStackTrace();
		}

	

	}

	else {

		EmpAdvance.setAid(1);

		request.setAttribute("addEmpAdvanceDuplicate",
				"Agreement Type Already Exists Please try some other name");

		return "EmpAdvanceHome";

	}
	return res;
}

@RequestMapping(value = "/EmpAdvanceSearch", method = RequestMethod.GET)
public ModelAndView searchEmpAdvance(
		@ModelAttribute("empAdvanceCommand") EmpAdvance EmpAdvance,
		BindingResult bindingResult, HttpServletRequest request,
		HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<EmpAdvance> agreementsType = null;
	try {
		int id = EmpAdvance.getEmpAdvanceId();
		String dbField = EmpAdvance.getXmlLabel();
		String operation = EmpAdvance.getOperations();
		String basicSearchId = EmpAdvance.getBasicSearchId();

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
			List<Object[]> list = empAdvanceService.searchEmpAdvance(id);
			agreementsType = new ArrayList<EmpAdvance>();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				EmpAdvance at = new EmpAdvance();
				at.setEmpAdvanceId((Integer) objects[0]);
				LoanTypeBean loanType=(LoanTypeBean)objects[1];
				at.setLoanTypeName(loanType.getLoanType());
				Employee emp=(Employee)objects[2];
				at.setEmpName(emp.getfName());
				at.setAdvanceAmount((String)objects[3]);
				Currency currency=(Currency)objects[4];
				at.setCurrencyName(currency.getCurrency());
				at.setRepayAmountPM((String)objects[5]);
				Status status=(Status)objects[6];
				at.setStatusName(status.getStatus());
				
				agreementsType.add(at);
			}

		} else {

			List<Object[]> list = empAdvanceService.basicSearchEmpAdvance(
					dbField, operation, basicSearchId);
			agreementsType = new ArrayList<EmpAdvance>();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				EmpAdvance agt = new EmpAdvance();
				agt.setEmpAdvanceId((Integer) objects[0]);
				LoanTypeBean loanType=(LoanTypeBean)objects[1];
				agt.setLoanTypeName(loanType.getLoanType());
				Employee emp=(Employee)objects[2];
				agt.setEmpName(emp.getfName());
				agt.setAdvanceAmount((String)objects[3]);
				Currency currency=(Currency)objects[4];
				agt.setCurrencyName(currency.getCurrency());
				agt.setRepayAmountPM((String)objects[5]);
				Status status=(Status)objects[6];
				agt.setStatusName(status.getStatus());
				agreementsType.add(agt);

			}

		}
	}

	catch (Exception e) {
		e.printStackTrace();
	}
	request.setAttribute("agtvalues", "agtvalues");

	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("EmpAdvanceHome");
	modelAndView.addObject("EmpAdvance", agreementsType);
	return modelAndView;
}

@RequestMapping(value = "/EmpAdvanceEditHome", method = RequestMethod.GET)
@org.springframework.context.annotation.Scope("request")
public String editEmpAdvance(
		@ModelAttribute("empAdvanceCommand") EmpAdvance EmpAdvance,
		BindingResult result, HttpServletRequest request,
		HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("EmpAdvanceEdit"));
	List<Object[]> list = null;
	Object[] objects = null;
	try {
		list = empAdvanceService.editEmpAdvanceWithId(id);
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			objects = (Object[]) iterator.next();
			EmpAdvance.setEmpAdvanceId((Integer) objects[0]);
			EmpAdvance.setLoanTypeId((String)objects[1]);
			EmpAdvance.setEmployeeId((String)objects[2]);
			EmpAdvance.setAdvanceAmount((String)objects[3]);
			EmpAdvance.setCurrencyId((String)objects[4]);
			EmpAdvance.setRepayAmountPM((String)objects[5]);
			EmpAdvance.setStatusId((String)objects[6]);
			EmpAdvance.setDescription((String)objects[7]);
			EmpAdvance.setPayModeId((String)objects[8]);
			EmpAdvance.setBankId((String)objects[9]);
			EmpAdvance.setBranch((String)objects[10]);
			EmpAdvance.setIsFixedAmount((Boolean)objects[11]);
			EmpAdvance.setFixedAmount((String)objects[12]);
			EmpAdvance.setIsEMI((Boolean)objects[13]);
			EmpAdvance.setNoofInstallments((String)objects[14]);
			EmpAdvance.setsTDT(dateService.dateFormat(dateService.dateParse((String)objects[15], "se"),"se"));
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	request.setAttribute("EmpAdvancevalues", "EmpAdvancevalues");
	return "EmpAdvanceHome";

}

@RequestMapping(value = "/EmpAdvanceUpdate", method = RequestMethod.POST)
public String updateEmpAdvance(
		@ModelAttribute("empAdvanceCommand") EmpAdvance EmpAdvance,
		HttpServletRequest request, HttpServletResponse response,
		Model model) {
	response.setCharacterEncoding("UTF-8");

	int EmpAdvanceEditList = 0;

	String agreementTyp = EmpAdvance.getEmployeeId();
	int id = EmpAdvance.getEmpAdvanceId();
	EmpAdvanceEditList = empAdvanceService.EmpAdvanceEditDuplicate(
			agreementTyp, id);
	if (EmpAdvanceEditList == 0) {

		try {
			EmpAdvance.setsTDT(dateService.dateFormat(dateService.dateParse(EmpAdvance.getsTDT(), "au"),"au"));
			String msg = empAdvanceService.updateEmpAdvance(EmpAdvance);

			if (msg == "S") {

				request.setAttribute("EmpAdvanceUpdate",
						"Agreement Type has been updated successfully");

			}

			else {

				request.setAttribute("EmpAdvanceUpdateError",
						"Agreement Type has not been updated");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		

	} else {

		request.setAttribute("EmpAdvancevalues", "EmpAdvancevalues");
		request.setAttribute("editEmpAdvanceDuplicate",
				"Agreement Type Already Exists Please try some other name");

		return "EmpAdvanceHome";
	}
	model.addAttribute("empAdvanceCommand", new EmpAdvance());

	return "EmpAdvanceHome";
}

@RequestMapping(value = "/EmpAdvanceDelete", method = RequestMethod.GET)
public ModelAndView deleteEmpAdvance(HttpServletRequest request,
		HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	HttpSession session=null;
	int id = 0;

	try {
		id = Integer.parseInt(request.getParameter("EmpAdvanceDelete"));
		
		String msg = empAdvanceService.EmpAdvanceDelete(id);
		
		if (msg.equals("S")) {
			session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			//auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Agreement Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			request.setAttribute("EmpAdvancedelete",
					"Agreement Type has been deleted successfully");
		} else {
			request.setAttribute("EmpAdvancedeleteError",
					"Agreement Type has not been deleted");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return new ModelAndView("EmpAdvanceHome", "empAdvanceCommand",
			new EmpAdvance());
}

@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
	String name = "EmpAdvance";

	Map<String, String> map =null;

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}

}
