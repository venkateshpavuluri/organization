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
import com.mnt.erp.bean.EmpAdvanceReceipts;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmpAdvReceiptsService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class EmpAdvReceiptsController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	EmpAdvReceiptsService empadvreceiptservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;
	
	@RequestMapping(value = "/earHome", method = RequestMethod.GET)
	public String getEmpadv(
			@ModelAttribute EmpAdvanceReceipts eapbean,
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
       
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("earHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		
		model.addAttribute("EAR", new EmpAdvanceReceipts());

		return "earHome";
	}

	
	@ModelAttribute("empAdvIds")
	public Map<Integer, String> populateAdvType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = empadvreceiptservice.selectEmpadv();
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
	
	@RequestMapping(value = "/saveear", method = RequestMethod.POST)
	@RequestScoped
	public String saveEAR(
			
			@ModelAttribute("EAR") EmpAdvanceReceipts eaBean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String mess = null;
		String res=null;
		try {
				session=request.getSession(false);
				eaBean.setReceiveddate(dateService.dateFormat(dateService.dateParse(eaBean.getReceiveddate(), "au"), "au"));
				mess = empadvreceiptservice.saveEmpAdvReceipts(eaBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (mess.equals("S")) {
					
					res = "redirect:earHome.mnt?list=" + "success" + "";
				}
				else{
					
					res = "redirect:earHome.mnt?listwar=" + "fail" + "";
				}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@RequestMapping(value = "/searchEar", method = RequestMethod.GET)
	public String searchears(
			@ModelAttribute("EAR") EmpAdvanceReceipts searcheaBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<EmpAdvanceReceipts> eaBeans = new ArrayList<EmpAdvanceReceipts>();
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

				list = empadvreceiptservice.searchEmpAdvReceipts();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmpAdvanceReceipts eapbean = new EmpAdvanceReceipts();
					eapbean.setEarId((Integer)obj[0]);
					EmpAdvance ep=(EmpAdvance)obj[1];
					eapbean.setEaradvId(ep.getAdvanceAmount());
					eapbean.setReceivedamount((String)obj[2]);
					eapbean.setReceiveddate(dateService.dateFormat(
							dateService.dateParse((String) obj[3], "ss"), "ss"));
					eapbean.setMonth((Integer)obj[4]);
					eaBeans.add(eapbean);
				}

			} else {

				// list = empadvreceiptservice.searchAccountGroupsWithId(iid);
				list = empadvreceiptservice.basicSearchEmpadvrec(dbField,operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmpAdvanceReceipts eapbean = new EmpAdvanceReceipts();
					eapbean.setEarId((Integer)obj[0]);
					EmpAdvance ep=(EmpAdvance)obj[1];
					eapbean.setEaradvId(ep.getAdvanceAmount());
					eapbean.setReceivedamount((String)obj[2]);
					eapbean.setReceiveddate(dateService.dateFormat(
							dateService.dateParse((String) obj[3], "ss"), "ss"));
					eapbean.setMonth((Integer)obj[4]);
					eaBeans.add(eapbean);
				}

			}
			request.setAttribute("eaBeans", eaBeans);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "earHome";
	}

	/*@ModelAttribute("eapSearch")
	public Map<Integer, String> populateeapids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = empadvreceiptservice.searchEmpAdvPayments();
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
	@RequestMapping(value = "/earEdit", method = RequestMethod.GET)
	public String editEap(
			@ModelAttribute("EAR") EmpAdvanceReceipts EditeaBean,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("earedit"));

		try {
			List<EmpAdvanceReceipts> eapBeans = new ArrayList<EmpAdvanceReceipts>();
			list = empadvreceiptservice.searchEmpAdvReceiptsWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				EditeaBean.setEarId((Integer)obj[0]);
				EditeaBean.setEaradvId((String)obj[1]);
				EditeaBean.setReceivedamount((String)obj[2]);
				EditeaBean.setReceiveddate((String)obj[3]);
				EditeaBean.setMonth((Integer)obj[4]);
				eapBeans.add(EditeaBean);
			}
			request.setAttribute("editvalues", eapBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "earHome";

	}

	@RequestMapping(value = "/earUpdate", method = RequestMethod.POST)
	public String updateeap(
			@ModelAttribute("EAR") EmpAdvanceReceipts UpdateeaBean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int eapid = UpdateeaBean.getEarId();
		try {

			UpdateeaBean.getEarId();
			UpdateeaBean.getEaradvId();
			UpdateeaBean.getReceivedamount();
			UpdateeaBean.setReceiveddate(dateService.dateFormat(dateService.dateParse(UpdateeaBean.getReceiveddate(), "au"), "au"));
			UpdateeaBean.getMonth();
				String message = empadvreceiptservice.updateEmpAdvReceipts(UpdateeaBean);

				if (message.equals("S")) {
					
					request.setAttribute("accountGroupUpdate","Employee Advance Receipts has been updated");
					
				}
				else{
					
					request.setAttribute("accountGroupUpdateError","Employee Advance Receipts has not been updated");
					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "earHome";
	}

	@RequestMapping(value = "/earDelete", method = RequestMethod.GET)
	public ModelAndView eapDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try {
			id = Integer.parseInt(request.getParameter("eardelete"));

			String msg = empadvreceiptservice.deleteEmpAdvReceipts(id);
			if (msg.equals("S")){
				request.setAttribute("accountGroupDelete","Employee Advance Receipts has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employee Advance  Receipts","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("accountGroupDeleteError","Employee Advance Receipts has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("earHome", "EAR",new EmpAdvanceReceipts());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "earId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
