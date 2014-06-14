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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.mnt.erp.bean.InspectionDecision;
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.inspectionDecisionService;

/**
 * @author devi
 *
 */
@Controller
public class InspectionDecisionController {
	@Autowired
	inspectionDecisionService idService;
	
	@Autowired
	ERPDao dao;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	AuditLogService auditLogService;

	HttpSession session;


	@Autowired
	MenuService menuService;

	String sus = null;

	@RequestMapping(value = "/InspectionDecisionHome", method = RequestMethod.GET)
	public String getInspDecisionHome(
			@ModelAttribute("InspectionDecision") InspectionDecision ibean, SessionStatus status,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("InspectionDecisionHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("InspectionDecision", new InspectionDecision());
		return "InspectionDecisionHome";
	}
	@ModelAttribute("InspectionLotOrigin")
	public Map<Integer, String> shift() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = idService.selectInspectionDecisionservice();
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
	@RequestMapping(value = "/addInspectionDecision", method = RequestMethod.POST)
	@RequestScoped
	public String saveInspDecision(
			@ModelAttribute("InspectionDecision") InspectionDecision ibean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int isa = 0;
		String result =null;
		

		String inspDecisionCheck = ibean.getDecision();
		
		long res=dao.duplicateCheck("select count(*) from InspectionDecision ag where ag.decision='"+inspDecisionCheck+"'");
		
		if (res == 0) 
		{
			try {
				
				isa=dao.saveDetails(ibean);
				if(isa!=0)
				{
					session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","InspectionDecision","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());		
				}
				result = "redirect:InspectionDecisionHome.mnt?list=" + "success" + "";							
				
				
			} catch (Exception e) {
				e.printStackTrace();
				result = "redirect:InspectionDecisionHome.mnt?listwar=" + "fail" + "";
			}
		}
		else {
	 
			
			ibean.setAid(1);
			request.setAttribute("addInspDecisionDuplicate",
					"InspDecision Already Exists Choose Another One");

			return "InspectionDecisionHome";

		}
		
		return result;
	}
	
	@RequestMapping(value = "/searchInspectionDecision", method = RequestMethod.GET)
	@RequestScoped
	public String searchinspDecision(
			@ModelAttribute("InspectionDecision") InspectionDecision idbean,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<InspectionDecision> inspDecisionSearch = new ArrayList<InspectionDecision>();
		String dbField = idbean.getXmlLabel();
		String operation = idbean.getOperations();
		String basicSearchId = idbean.getBasicSearchId();
		 
		idbean.setXmlLabel(dbField);
		idbean.setOperations(operation);
		idbean.setBasicSearchId(basicSearchId);
		
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
				
				list=dao.searchDetails("select e.inspDecision_Id,e.inspectBean,e.decision from InspectionDecision e where e."
						+ dbField + " " + operation +"'"+basicSearchId+"'  ");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {
				inspDecisionSearch = new ArrayList<InspectionDecision>();
			
			list=dao.searchDetails("select e.inspDecision_Id,e.inspectBean,e.decision from InspectionDecision e");
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			InspectionDecision ibean = new InspectionDecision();
			Object[] objs = (Object[]) iterator.next();
			ibean.setInspDecision_Id((Integer)objs[0]);
			InsplotOrigin insplotOrigin=(InsplotOrigin)objs[1];
			ibean.setInspLotOrigin(insplotOrigin.getInsplotorigin());
			ibean.setDecision((String)objs[2]);
			inspDecisionSearch.add(ibean);
			
			
		}
		
		request.setAttribute("inspDecisionSearch", inspDecisionSearch);

		return "InspectionDecisionHome";
	}
	
	@RequestMapping(value = "/inspDecisionEditHome", method = RequestMethod.GET)

	public String inspDecisionIdEdit(
			@ModelAttribute("InspectionDecision") InspectionDecision ibean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("InspDecisionIdEdit"));
				
		List<Object[]> list = null;
		Object[] object = null;

		List<InspectionDecision> idbean = new ArrayList<InspectionDecision>();

		try {

			list = idService.searchInspectionDecisionWithId(id);
	         
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				ibean.setInspDecision_IdEdit((Integer)object[0]);
				ibean.setInspLotOriginEdit((String)object[1]);
				ibean.setDecisionEdit((String)object[2]);
				idbean.add(ibean);
			}
			request.setAttribute("inspDecisionValues", idbean);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "InspectionDecisionHome";

	}
	@RequestMapping(value = "/inspDecisionUpdate", method = RequestMethod.POST)

	public String updateInspDecision(
		@ModelAttribute("InspectionDecision") InspectionDecision ibean,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");

	int inspdecisionId = ibean.getInspDecision_IdEdit();
	String inspLotOrigin= ibean.getInspLotOriginEdit();
	String decision = ibean.getDecisionEdit();
	
	
	
		long checkDuplicate=dao.duplicateCheck("select count(*) from  InspectionDecision ag where ag.decision='"
					+ decision + "' and ag.inspDecision_Id!='" + inspdecisionId + "'")	;
		
	if (checkDuplicate == 0) {
		try {
			ibean.setInspDecision_Id(inspdecisionId);
			ibean.setInspLotOrigin(inspLotOrigin);
			ibean.setDecision(decision);
            idService.updateInspectionDecision(ibean);
			
			request.setAttribute("inspDecisionUpdate", "insp Details Updated Successfully");
			
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("inspUpdateErr", "insp Details Doesn't Updated ");
		}
	} else {
		
		request.setAttribute("inspUpdateDup", "insp already exists choose another one");
		request.setAttribute("inspDecisionValues", "inspDecisionValues");
		return "InspectionDecisionHome";

	}

	return "InspectionDecisionHome";
	}
	@RequestMapping(value = "/inspDecisionDelete", method = RequestMethod.GET)
	public String deleteinspDecision(
		@ModelAttribute("InspectionDecision") InspectionDecision prod,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, SessionStatus status,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");

	int id = Integer.parseInt(request.getParameter("inspDecisionIdDelete"));
		
		
		try
		{
			 
			 String msg=idService.deleteInspectionDecision(id);
			 if(msg.equals("S"))
			 {
				 session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","InspectionDecision","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				 request.setAttribute("inspDecisionDelete", "Inspection Details Deleted Successfully");
				
			 }
			 
			
		} 
	catch (Exception e) {
		e.printStackTrace();
		 request.setAttribute("inspDecisionDeleteErr", "Inspection Details Doesn't Deleted");
	}

	 model.addAttribute("InspectionDecision", new InspectionDecision());
	 return "InspectionDecisionHome";

	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
	String name = "decision";

	Map<String, String> map = new HashMap<String, String>();

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
	}
}
