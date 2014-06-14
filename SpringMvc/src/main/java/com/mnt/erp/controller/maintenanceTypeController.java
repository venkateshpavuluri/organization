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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;


import com.mnt.erp.bean.maintenanceTypeBean;
import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;

import com.mnt.erp.service.MenuService;

import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.maintenanceTypeService;

@Controller
public class maintenanceTypeController {
	
	private static Logger logger=Logger.getLogger(maintenanceTypeController.class);
	@Autowired
	maintenanceTypeService mservice;
	@Autowired
	ERPDao dao;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	AuditLogService auditLogService;


	@Autowired
	MenuService menuService;

	String sus = null;
	@RequestMapping(value = "/MaintenanceHome", method = RequestMethod.GET)
	public String getMaintenanceType(SessionStatus status,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("MaintenanceHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		model.addAttribute("maintenanceType", new maintenanceTypeBean());
		return "MaintenanceHome";
	}
	@RequestMapping(value = "/addMaintenanceType", method = RequestMethod.POST)
	@RequestScoped
	public String saveMaintenanceType(
			@ModelAttribute("maintenanceType") maintenanceTypeBean mbean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int isa = 0;
		String result=null;
		HttpSession session;

		String maintenanceCheck = mbean.getMaintenanceType();
		long res=dao.duplicateCheck("select count(*) from maintenanceTypeBean ag where ag.maintenanceType='"+maintenanceCheck+"'");
		
		if (res == 0) 
		{
			try {
				
				isa=dao.saveDetails(mbean);
				logger.info("maintanance id iss=="+isa);
				if(isa!=0)
				{
					session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Maintenance Type","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());
			result = "redirect:MaintenanceHome.mnt?list=" + "success" + "";
				}
				
					
				status.setComplete();
				
				
			} catch (Exception e) {
				result = "redirect:MaintenanceHome.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
				
			}
			
		} else {
	 
			
			mbean.setAid(1);
			request.setAttribute("addMaintenanceTypeDuplicate",
					"MaintenanceType Already Exists Choose Another One");

			return "MaintenanceHome";

		}
		
		return result;
	}
	@RequestMapping(value = "/searchMaintenanceType", method = RequestMethod.GET)
	@RequestScoped
	public String searchMaintenanceType(
			@ModelAttribute("maintenanceType") maintenanceTypeBean mbean,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<maintenanceTypeBean> maintenanceTypeSearch = new ArrayList<maintenanceTypeBean>();
		String dbField = mbean.getXmlLabel();
		String operation = mbean.getOperations();
		String basicSearchId = mbean.getBasicSearchId();
		 
		mbean.setXmlLabel(dbField);
		mbean.setOperations(operation);
		mbean.setBasicSearchId(basicSearchId);
		
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
				
				
				list=dao.searchDetails("select e.maintenanceTypeId,e.maintenanceType from maintenanceTypeBean e where e."
						+ dbField + " " + operation +"  '"+basicSearchId+"' order by e.maintenanceType ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {
				maintenanceTypeSearch = new ArrayList<maintenanceTypeBean>();
			
			list=dao.searchDetails("select e.maintenanceTypeId,e.maintenanceType from com.mnt.erp.bean.maintenanceTypeBean e order by e.maintenanceType");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			maintenanceTypeBean mtbean = new maintenanceTypeBean();
			Object[] objs = (Object[]) iterator.next();
			mtbean.setMaintenanceTypeId((Integer) objs[0]);
			mtbean.setMaintenanceType((String) objs[1]);
			maintenanceTypeSearch.add(mtbean);
			
			
		}
		
		request.setAttribute("maintenanceTypeSearch", maintenanceTypeSearch);

		return "MaintenanceHome";
	}
	@RequestMapping(value = "/maintenanceTypeEditHome", method = RequestMethod.GET)

	public String MaintenanceTypeEdit(
			@ModelAttribute("maintenanceType") maintenanceTypeBean mbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("maintenanceTypeIdEdit"));
				
		List<Object[]> list = null;
		Object[] object = null;

		List<maintenanceTypeBean> mbean1 = new ArrayList<maintenanceTypeBean>();

		try {

			list = mservice.searchMaintenanceTypeWithId(id);
	         
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				
				mbean.setMaintenanceTypeIdEdit((Integer) object[0]);
				mbean.setMaintenanceTypeNameEdit((String) object[1]);
									
				mbean1.add(mbean);
			}
			request.setAttribute("maintenanceTypeValues", mbean1);

		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		return "MaintenanceHome";

	}
	@RequestMapping(value = "/maintenanceTypeDelete", method = RequestMethod.GET)
	public String deleteMaintenanceType(
		@ModelAttribute("maintenanceType") maintenanceTypeBean prod,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, SessionStatus status,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("maintenanceTypeIdDelete"));
	HttpSession session;
		
		try
		{
			 
			 String msg=mservice.deleteMaintenanceType(id);
			 if(msg.equals("S"))
			 {
				 
				 session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Maintenance Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				 
				request.setAttribute("maintenanceTypeDelete","Maintenance Type has been deleted");
			 
			 }
			 else{
				 request.setAttribute("maintenanceTypeDeleteError","Maintenance Type has not been deleted");
			 }
		} 
	catch (Exception e) {
		e.printStackTrace();
	}

	return "MaintenanceHome";

	}
	@RequestMapping(value = "/maintenanceTypeUpdate", method = RequestMethod.POST)

	public String updateMaintenanceType(
		@ModelAttribute("maintenanceType") maintenanceTypeBean prod,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");

	int res=0;

	int maintenanceTypeId = prod.getMaintenanceTypeIdEdit();
	String maintenanceTypeEdit = prod.getMaintenanceTypeNameEdit();

	prod.setMaintenanceTypeId(maintenanceTypeId);
	prod.setMaintenanceType(maintenanceTypeEdit);


		long checkDuplicate=dao.duplicateCheck("select count(*) from  maintenanceTypeBean ag where ag.maintenanceType='"
					+ maintenanceTypeEdit + "' and ag.maintenanceTypeId!='" + maintenanceTypeId + "'")	;
	if (checkDuplicate == 0) {
		try {
			
			res=dao.updateDetails(prod);	
			if(res!=0){
				request.setAttribute("maintenanceTypeUpdate","Maintenance Type has been updated");
			}
			else{
				request.setAttribute("maintenanceTypeUpdateError","Maintenance Type has not been updated");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	} else {

		request.setAttribute("maintenanceTypeValues", "maintenanceTypeValues");
		request.setAttribute("maintenanceTypedupUpdate","Maintenance Type alredy exists");
		return "MaintenanceHome";
	}

	return "MaintenanceHome";
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
	String name = "maintenanceType";

	Map<String, String> map =null;

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
	}
}
