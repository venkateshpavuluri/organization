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
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.ProcessTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.processTypeService;
@Controller
public class processTypeController {
	public static Logger logger=Logger.getLogger(processTypeController.class);
	@Autowired
	processTypeService processTypeService;
	@Autowired
	ERPDao dao;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;

	String sus = null;
	@RequestMapping(value = "/ProcessHome", method = RequestMethod.GET)
	public String getProcessTypeHome(
			@ModelAttribute("processType") ProcessTypeBean PrBeanbean, SessionStatus status,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ProcessHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("processType", new ProcessTypeBean());
		return "ProcessHome";
	}
	@RequestMapping(value = "/addProcessType", method = RequestMethod.POST)
	public String saveProcessType(
			@ModelAttribute("processType") ProcessTypeBean Prbean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int isa = 0;
		String result=null;
		HttpSession session=null;
		String processCheck = Prbean.getProcesstype();
		long res=dao.duplicateCheck("select count(*) from ProcessTypeBean ag where ag.processtype='"+processCheck+"'");
		
		if (res == 0) 
		{
			try {
				
				isa=dao.saveDetails(Prbean);
				logger.info("isa save id=="+isa);
				if(isa!=0)
				{
					session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Process Type","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());
				result = "redirect:ProcessHome.mnt?list=" + "success" + "";
				}
				status.setComplete();
				
	             
				
			} catch (Exception e) {
				result = "redirect:ProcessHome.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
					}
			
		} else {
	 
			
			Prbean.setAid(1);
			request.setAttribute("addProcessTypeDuplicate",
					"ProcessType Already Exists Choose Another One");

			return "ProcessHome";

		}
		
		return result;
	}
	@RequestMapping(value = "/searchProcessType", method = RequestMethod.GET)
	public String searchProcessType(
			@ModelAttribute("processType") ProcessTypeBean POTbean,
			HttpServletRequest request, HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<ProcessTypeBean> processTypeSearch = new ArrayList<ProcessTypeBean>();
		String dbField = POTbean.getXmlLabel();
		String operation = POTbean.getOperations();
		String basicSearchId = POTbean.getBasicSearchId();
		 
		POTbean.setXmlLabel(dbField);
		POTbean.setOperations(operation);
		POTbean.setBasicSearchId(basicSearchId);
		
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
				
				
				list=dao.searchDetails("select e.processtypeid,e.processtype from ProcessTypeBean e where e."
						+ dbField + " " + operation +"  '"+basicSearchId+"'order by e.processtype ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			try {
				processTypeSearch = new ArrayList<ProcessTypeBean>();
			
			list=dao.searchDetails("select e.processtypeid,e.processtype from ProcessTypeBean e order by e.processtype");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			ProcessTypeBean processbean = new ProcessTypeBean();
			Object[] objs = (Object[]) iterator.next();
			processbean.setProcesstypeid((Integer) objs[0]);
			processbean.setProcesstype((String) objs[1]);
			processTypeSearch.add(processbean);
			
		}
		
		request.setAttribute("processTypeSearch", processTypeSearch);

		return "ProcessHome";
	}
	@RequestMapping(value = "/processTypeEditHome", method = RequestMethod.GET)

	public String ProcessTypeIdEdit1(
			@ModelAttribute("processType") ProcessTypeBean POTbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("processTypeIdEdit"));
				
		List<Object[]> list = null;
		Object[] object = null;

		List<ProcessTypeBean> POTbean1 = new ArrayList<ProcessTypeBean>();

		try {

			list = processTypeService.searchProcessTypeWithId(id);
	         
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				POTbean.setProcessTypeIdEdit((Integer) object[0]);
				POTbean.setProcessTypeNameEdit((String) object[1]);
									
				POTbean1.add(POTbean);
			}
			request.setAttribute("processTypeValues", POTbean1);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "ProcessHome";

	}
	@RequestMapping(value = "/processTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteProcessType(
		@ModelAttribute("processType") ProcessTypeBean prod,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, SessionStatus status,
		HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("processTypeIdDelete"));	
		HttpSession session=null;
		
		try
		{
			 
			 String msg=processTypeService.deleteProcessType(id);
			 if(msg.equals("S"))
			 {
				 	session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Process Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				    request.setAttribute("processTypeDelete","Process Type has been deleted");
			 }
			 else{
				 request.setAttribute("processTypeDeleteError","Process Type has not been deleted");
			 }
			
		} 
	catch (Exception e) {
		e.printStackTrace();
	}

		return new ModelAndView("ProcessHome", "processType",new ProcessTypeBean());

	}
	@RequestMapping(value = "/processTypeUpdate", method = RequestMethod.POST)

	public String updateProcessType(
		@ModelAttribute("processType") ProcessTypeBean prod,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");

	int processTypeId = prod.getProcessTypeIdEdit();
	String processTypeEdit = prod.getProcessTypeNameEdit();

	prod.setProcesstypeid(processTypeId);
	prod.setProcesstype(processTypeEdit);
	int res=0;


		long checkDuplicate=dao.duplicateCheck("select count(*) from  ProcessTypeBean ag where ag.processtype='"
					+ processTypeEdit + "' and ag.processtypeid!='" + processTypeId + "'")	;
	if (checkDuplicate == 0) {
		try {
			
			res=dao.updateDetails(prod);
			if(res!=0){
				request.setAttribute("processTypeUpdate","Process Type has been updated");
			}
			else{
				request.setAttribute("processTypeUpdateError", "Process Type has not been updated");
			}
		
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	} else {
       request.setAttribute("processTypeValues", "processTypeValues");
		request.setAttribute("processTypeUpdateCheck", "Process Type is aleady exists");
		return "ProcessHome";
	}

	return "ProcessHome";
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
	String name = "processType";

	Map<String, String> map =null;

	try {
		map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
	}

}
