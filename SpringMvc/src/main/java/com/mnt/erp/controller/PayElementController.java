package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.mnt.erp.bean.PayElementBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PayElementService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class PayElementController {
	@Autowired
	PayElementService payelementService;
	@Autowired
	ERPDao dao;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@Autowired
	XmlLabelsService xmlService;
	String sus = null;

	@RequestMapping(value = "/PEHome", method = RequestMethod.GET)
	public String getPayElementHome(
			@ModelAttribute PayElementBean payelement, SessionStatus status,
			HttpServletResponse response, Model model,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("PEHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("PayElement", new PayElementBean());
		return "PEHome";
	}
	@RequestMapping(value = "/addPayElement", method = RequestMethod.POST)
	@RequestScoped
	public String savePayElement(
			@ModelAttribute ("PayElement")PayElementBean payelement,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		String isa,res= null;
		
		HttpSession session=null;

		String payelementCheck = payelement.getPayelement();
		long checkType = payelementService.checkPayElement(payelementCheck);
		
		if (checkType == 0) {
			try {
				session=request.getSession(false);
				isa = payelementService.savePayElement(payelement,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
												
				status.setComplete();
                 
				if (isa.equals("S"))
				{
					res = "redirect:PEHome.mnt?list=" + "success" + "";
					
				} else {
					res = "redirect:PEHome.mnt?listwar=" + "fail" + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:PEHome.mnt?listwar=" + "fail" + "";
			}
			
		} else {

			request.setAttribute("payElementDup",  "payelement already exist choose another one");
			return "PEHome";
			
		}
		
		return  "redirect:PEHome.mnt?list=" + "success" + "";
	}
	@RequestMapping(value = "/searchPayElement", method = RequestMethod.GET)
	@RequestScoped
	public String searchPayelement(
			@ModelAttribute("PayElement") PayElementBean payelement,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<PayElementBean> payelementSearch = new ArrayList<PayElementBean>();
		String dbField = payelement.getXmlLabel();
		String operation = payelement.getOperations();
		String basicSearchId = payelement.getBasicSearchId();
		 
		payelement.setXmlLabel(dbField);
		payelement.setOperations(operation);
		payelement.setBasicSearchId(basicSearchId);
		
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
		if (basicSearchId != "") {

			try {
				
				
				list=dao.searchDetails("select e.payelementId,e.payelement,e.payelementType from PayElementBean e where e."
						+ dbField + " " + operation +"  '"+basicSearchId+"' order by e.payelement");

				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {
				payelementSearch = new ArrayList<PayElementBean>();
			
			list=dao.searchDetails("select e.payelementId,e.payelement,e.payelementType from PayElementBean e order by e.payelement");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			PayElementBean payelement2 = new PayElementBean();
			Object[] objs = (Object[]) iterator.next();
			payelement2.setPayelementId((Integer) objs[0]);
			payelement2.setPayelement((String) objs[1]);
			payelement2.setPayelementType((String)objs[2]);
			payelementSearch.add(payelement2);
			
		}
		request.setAttribute("payelementSearch", payelementSearch);

		return "PEHome";
	}
@RequestMapping(value = "/payElementEditHome", method = RequestMethod.GET)
	
	public String payElementEdit(
			@ModelAttribute("PayElement") PayElementBean payelementDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("payelementIdEdit"));
				
		List<Object[]> list = null;
		Object[] object = null;

		List<PayElementBean> payelement = new ArrayList<PayElementBean>();

		try {

			list = payelementService.searchPayElementWithId(id);
             
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				payelementDisplay.setPayelementIdEdit((Integer) object[0]);
				payelementDisplay.setPayelementEdit((String) object[1]);
				payelementDisplay.setPayelementTypeEdit((String) object[2]);
						
				payelement.add(payelementDisplay);
			}
			request.setAttribute("payElementValues", payelement);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "PEHome";

	}
@RequestMapping(value = "/payElementDelete", method = RequestMethod.GET)
public String deletePayElement(
		@ModelAttribute("PayElement") PayElementBean pay,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, SessionStatus status,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("payElementIdDelete"));
			
	String msg = null;
	HttpSession session=null;
	try {
		pay.setPayelementId(id);
		dao.deleteDetails(pay);
		session=request.getSession(false);
		Date date = new Date();
	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","payelement","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
	request.setAttribute("PayDel", "payelement Details Deleted Successfully");
				
				

	}
	
	catch (Exception e) {
		e.printStackTrace();

		request.setAttribute("PayDelErr", "payelement Doesn't Deleted Successfully");
		
	}
	model.addAttribute("PayElement", new PayElementBean());
	return "PEHome";

}
@RequestMapping(value = "/payElementUpdate", method = RequestMethod.POST)

public String updatePayElement(
		@ModelAttribute("PayElement") PayElementBean pays,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");

	String isa = null;
	String payElementUpdate = null;

	int payelementId = pays.getPayelementIdEdit();
	String payelementEdit = pays.getPayelementEdit();
    String payelementTypeEdit=pays.getPayelementTypeEdit();
	pays.setPayelementId(payelementId);
	pays.setPayelement(payelementEdit);
	pays.setPayelementType(payelementTypeEdit);
	
		long checkDuplicate=dao.duplicateCheck("select count(*) from  PayElementBean ag where ag.payelement='"
					+ payelementEdit + "' and ag.payelementId!='" + payelementId + "'")	;
	if (checkDuplicate == 0) {
		try {
			
			dao.updateDetails(pays);	
			request.setAttribute("PayUpdate", "payelement Details Updated Successfully");
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("PayUpdateErr", "payelement Doesn't Updated Successfully");
		}
	} else {

		
		request.setAttribute("payUpdateDup", "payelement already exist choose another one");
		request.setAttribute("payElementValues", "payelement values");
		
			return "PEHome";

	}
	model.addAttribute("PayElement", new PayElementBean());
	return "PEHome";
}

@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
	String name = "Payelement";

	Map<String, String> map =null;

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}
}
