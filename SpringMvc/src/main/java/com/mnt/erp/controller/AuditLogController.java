/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.AuditLogDetail;
import com.mnt.erp.bean.BomCategory;
import com.mnt.erp.bean.physicalVerificationLine;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BomCategoryService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Gkiran
 * @version 1.0v
 * @Date 28-10-2013
 */

@Controller
public class AuditLogController {

	@Autowired
	AuditLogService auditLogService; 
	@Autowired
	XmlLabelsService xmlService;

	String msa = null;
	AuditLog bom2 = null;
	String bomUpadte = null;
	List<String> list = null;
	Long count = null;
	List<AuditLog> auditLogsList = null;
	String name = null;
	List<Object[]> objects = null;
	Iterator<Object[]> iterator = null;
	AuditLog mm = null;
	int id = 0;
	List<Object[]> listObject = null;
	Object[] objectsArray = null;
	List<AuditLog> bomsList = null;
	List<AuditLogDetail> bomsListDetails = null;
	String msg = null;

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/auditLog", method = RequestMethod.GET)
	public ModelAndView getAuditLog() {
		return new ModelAndView("auditLog", "auditLogForm",
				new AuditLog());
	}

	
	
	/* * **********************************************************************************************************************************
	*/ 
	@RequestMapping(value = "/auditLogSearch", method = RequestMethod.GET)
	public String searchMaterial(@ModelAttribute AuditLog auditLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		auditLogsList = new ArrayList<AuditLog>();
		//name = auditLog.getOperation();
		String dbField = auditLog.getXmlLabel();
		String operation = auditLog.getOperations();
		String basicSearchId = auditLog.getBasicSearchId();

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
		if (basicSearchId.length() != 0) {
			//objects = categoryService.getBomCategory(bomCategory.getBomCategory());
			objects=auditLogService.basicSearchAuditLog(dbField, operation, basicSearchId);
					
		} else {
			objects = auditLogService.getAuditLog("ALL");
		}
			
		 if(objects!=null)
		 {	
		iterator = objects.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.AuditLog();
			Object[] objects2 = (Object[]) iterator.next();
			mm.setAuditLog_Id((Integer) objects2[0]);
			mm.setUserId((String) objects2[1]);
			String op=(String) objects2[2];
			if(op.equals("A"))
				op="ADD";
			if(op.equals("E"))
				op="EDIT";
			if(op.equals("M"))
				op="UPDATE";
			if(op.equals("S"))
				op="SEARCH";
			if(op.equals("D"))
				op="DELETE";
			mm.setOperation(op);
			mm.setObjectChanged((String) objects2[3]);
			mm.setObjectType((String) objects2[4]);
			mm.setStatus((String) objects2[5]);
			mm.setTimeStamp((String) objects2[6]);
			mm.setUserName((String) objects2[7]);
			auditLogsList.add(mm);
		}

		}

		request.setAttribute("auditLogSearch", auditLogsList);
		model.addAttribute("auditLogForm", new AuditLog());
		return "auditLog";

	}

	
	
	
	@RequestMapping(value = "/auditLogDetailEdit", method = RequestMethod.POST)
	public @ResponseBody String getAuditEditDetails( HttpServletResponse response,
			HttpServletRequest request){
		response.setCharacterEncoding("UTF-8");
		id = Integer.parseInt(request.getParameter("auditLogDetailsEdit"));
		String jsondataChild="";
		try {
			bomsListDetails=new ArrayList<AuditLogDetail>();
			List<Object> listObject = auditLogService.getAuditLogDetailId(id);
			Iterator<Object> itrr = listObject.iterator();
			int count=1;
			while (itrr.hasNext()) {
				Object o = itrr.next();
				AuditLogDetail cc = (AuditLogDetail) o;
				AuditLogDetail mm=new AuditLogDetail();
				mm.setAuditLogDetail_Id(cc.getAuditLogDetail_Id());
				mm.setAuditLog_Id(id);
				mm.setNewValue(cc.getNewValue());
				mm.setOldValue(cc.getOldValue());
				mm.setCount(count);
				//System.out.println("cc.getOldValue()"+cc.getOldValue());
				bomsListDetails.add(mm);
				count++;
			}
			ObjectMapper mapper = new ObjectMapper();
		    jsondataChild=mapper.writeValueAsString(bomsListDetails);
		} catch (Exception e) {
		      e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}

		return jsondataChild;
	}

	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "auditId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
