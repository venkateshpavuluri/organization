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
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.EmpAdvance;
import com.mnt.erp.bean.EmpAdvancePayments;
import com.mnt.erp.bean.ChartofAccount;
import com.mnt.erp.service.AccountGroupService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmpAdvPaymentsService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class EmpAdvPaymentsController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	EmpAdvPaymentsService empadvpaymentservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;
	
	@RequestMapping(value = "/eapHome", method = RequestMethod.GET)
	public String getEmpadv(
			@ModelAttribute EmpAdvancePayments eapbean,
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
       
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("eapHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		
		model.addAttribute("EAP", new EmpAdvancePayments());

		return "eapHome";
	}

	
	@ModelAttribute("empAdvIds")
	public Map<Integer, String> populateAdvType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = empadvpaymentservice.selectEmpadv();
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
	
	@RequestMapping(value = "/saveeap", method = RequestMethod.POST)
	@RequestScoped
	public String saveEAP(
			
			@ModelAttribute("EAP") EmpAdvancePayments eaBean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String mess = null;
		String res=null;
		try {
				session=request.getSession(false);
				eaBean.setPaiddate(dateService.dateFormat(dateService.dateParse(eaBean.getPaiddate(), "au"), "au"));
				mess = empadvpaymentservice.saveEmpAdvPayments(eaBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (mess.equals("S")) {
					
					res = "redirect:eapHome.mnt?list=" + "success" + "";
				}
				else{
					
					res = "redirect:eapHome.mnt?listwar=" + "fail" + "";
				}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@RequestMapping(value = "/searchEap", method = RequestMethod.GET)
	public String searcheaps(
			@ModelAttribute("EAP") EmpAdvancePayments searcheaBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<EmpAdvancePayments> eaBeans = new ArrayList<EmpAdvancePayments>();
			String dbField = searcheaBean.getXmlLabel();
			String operation = searcheaBean.getOperations();
			String basicSearchId = searcheaBean.getBasicSearchId();

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

				list = empadvpaymentservice.searchEmpAdvPayments();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmpAdvancePayments eapbean = new EmpAdvancePayments();
					eapbean.setEapId((Integer)obj[0]);
					EmpAdvance ep=(EmpAdvance)obj[1];
					eapbean.setEmpadvId(ep.getAdvanceAmount());
					eapbean.setPaidamount((String)obj[2]);
					eapbean.setPaiddate(dateService.dateFormat(
							dateService.dateParse((String) obj[3], "ss"), "ss"));
					eapbean.setMonth((Integer)obj[4]);
					eaBeans.add(eapbean);
				}

			} else {

				// list = empadvpaymentservice.searchAccountGroupsWithId(iid);
				list = empadvpaymentservice.basicSearchEmpadvpay(dbField,operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmpAdvancePayments eapbean = new EmpAdvancePayments();
					eapbean.setEapId((Integer)obj[0]);
					EmpAdvance ep=(EmpAdvance)obj[1];
					eapbean.setEmpadvId(ep.getAdvanceAmount());
					eapbean.setPaidamount((String)obj[2]);
					eapbean.setPaiddate(dateService.dateFormat(
							dateService.dateParse((String) obj[3], "ss"), "ss"));
					eapbean.setMonth((Integer)obj[4]);
					eaBeans.add(eapbean);
				}

			}
			request.setAttribute("eaBeans", eaBeans);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "eapHome";
	}

	/*@ModelAttribute("eapSearch")
	public Map<Integer, String> populateeapids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = empadvpaymentservice.searchEmpAdvPayments();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				map.put((Integer) obj[0], ((String) obj[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
*/
	@RequestMapping(value = "/eapEdit", method = RequestMethod.GET)
	public String editEap(
			@ModelAttribute("EAP") EmpAdvancePayments EditeaBean,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("eapedit"));

		try {
			List<EmpAdvancePayments> eapBeans = new ArrayList<EmpAdvancePayments>();
			list = empadvpaymentservice.searchEmpAdvPaymentsWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				EditeaBean.setEapId((Integer)obj[0]);
				EditeaBean.setEmpadvId((String)obj[1]);
				EditeaBean.setPaidamount((String)obj[2]);
				EditeaBean.setPaiddate((String)obj[3]);
				EditeaBean.setMonth((Integer)obj[4]);
				eapBeans.add(EditeaBean);
			}
			request.setAttribute("editvalues", eapBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "eapHome";

	}

	@RequestMapping(value = "/eappUpdate", method = RequestMethod.POST)
	public String updateeap(
			@ModelAttribute("EAP") EmpAdvancePayments UpdateeaBean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int eapid = UpdateeaBean.getEapId();
		try {

			UpdateeaBean.getEapId();
			UpdateeaBean.getEmpadvId();
			UpdateeaBean.getPaidamount();
			UpdateeaBean.setPaiddate(dateService.dateFormat(dateService.dateParse(UpdateeaBean.getPaiddate(), "au"), "au"));
			UpdateeaBean.getMonth();
				String message = empadvpaymentservice.updateEmpAdvPayments(UpdateeaBean);

				if (message.equals("S")) {
					
					request.setAttribute("accountGroupUpdate","Employee Advance Payments has been updated");
					
				}
				else{
					
					request.setAttribute("accountGroupUpdateError","Employee Advance Payments has not been updated");
					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "eapHome";
	}

	@RequestMapping(value = "/eapDelete", method = RequestMethod.GET)
	public ModelAndView eapDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try {
			id = Integer.parseInt(request.getParameter("eapdelete"));

			String msg = empadvpaymentservice.deleteEmpAdvPayments(id);
			if (msg.equals("S")){
				request.setAttribute("accountGroupDelete","Employee Advance Payments has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employee Advance  Payments","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("accountGroupDeleteError","Employee Advance Payments has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("eapHome", "EAP",new EmpAdvancePayments());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "eapId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
