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
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.productionPlanTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.productionPlanTypeService;

@Controller
public class prodPlanTypeController {
	Logger logger=Logger.getLogger(prodPlanTypeController.class);
@Autowired
productionPlanTypeService prodService;
@Autowired
XmlLabelsService xmlService;
@Autowired
MenuService menuService;
@Autowired
ERPDao dao;
@Autowired
AuditLogService auditLogService;

HttpSession session;
String sus = null;
@RequestMapping(value = "/ProdPlanTypeHome", method = RequestMethod.GET)
public String getProdPlanTypeHome(
		@ModelAttribute("ProdPlanType") productionPlanTypeBean pbean, SessionStatus status,HttpServletRequest request,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession(false);
	List<String> list=menuService.getPrivilige("ProdPlanTypeHome.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
	model.addAttribute("ProdPlanType", new productionPlanTypeBean());
	return "ProdPlanTypeHome";
}
@RequestMapping(value = "/addProdPlanType", method = RequestMethod.POST)
@RequestScoped
public String saveProdPlanType(
		@ModelAttribute("ProdPlanType") productionPlanTypeBean pbean,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	int isa = 0;

	String result=null;

	String prodPlanTypeCheck = pbean.getProductionPlanType();
	
	long res=dao.duplicateCheck("select count(*) from productionPlanTypeBean ag where ag.productionPlanType='"+prodPlanTypeCheck+"'");
	
	if (res == 0) 
	{
		try {
			
			isa=dao.saveDetails(pbean);
			if(isa!=0)
			{
			session=request.getSession(false);
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Production Plan Type","ROW" ,String.valueOf(isa),"1",modifiedDate,session.getAttribute("userName").toString());		
			result = "redirect:ProdPlanTypeHome.mnt?list=" + "success" + "";
			}
			else{
				result = "redirect:ProdPlanTypeHome.mnt?listwar=" + "fail" + "";
			}
										
		
			
             
			
		} catch (Exception e) {
			result = "redirect:ProdPlanTypeHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
			
		}
	}
	else {
 
		
		pbean.setAid(1);
		request.setAttribute("addProdPlanTypeDuplicate",
				"Production plan Type Already Exists Choose Another One");

		return "ProdPlanTypeHome";

	}
	
	return result;
}
@RequestMapping(value = "/searchProdPlanType", method = RequestMethod.GET)
@RequestScoped
public String searchProdPlanType(
		@ModelAttribute("ProdPlanType") productionPlanTypeBean pbean,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	
	List<Object[]> list = null;
	
	List<productionPlanTypeBean> prodPlanTypeSearch = new ArrayList<productionPlanTypeBean>();
	String dbField = pbean.getXmlLabel();
	String operation = pbean.getOperations();
	String basicSearchId = pbean.getBasicSearchId();
	 
	pbean.setXmlLabel(dbField);
	pbean.setOperations(operation);
	pbean.setBasicSearchId(basicSearchId);
	
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
			
			
			list=dao.searchDetails("select e.productionPlanTypeId,e.productionPlanType from productionPlanTypeBean e where e."
					+ dbField + " " + operation +"  '"+basicSearchId+"' order by e.productionPlanType");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} else {

		try {
			prodPlanTypeSearch = new ArrayList<productionPlanTypeBean>();
		
		list=dao.searchDetails("select e.productionPlanTypeId,e.productionPlanType from productionPlanTypeBean e order by e.productionPlanType");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Iterator<Object[]> iterator = list.iterator();
	while (iterator.hasNext()) {
		productionPlanTypeBean plbean = new productionPlanTypeBean();
		Object[] objs = (Object[]) iterator.next();
		plbean.setProductionPlanTypeId((Integer)objs[0]);
		plbean.setProductionPlanType((String)objs[1]);
		prodPlanTypeSearch.add(plbean);
		
	}
	
	request.setAttribute("prodPlanTypeSearch", prodPlanTypeSearch);

	return "ProdPlanTypeHome";
}
@RequestMapping(value = "/ProdPlanTypeEditHome", method = RequestMethod.GET)

public String prodPlanTypeEdit(
		@ModelAttribute("ProdPlanType") productionPlanTypeBean plbean,
		HttpServletRequest request, HttpServletResponse response,
		Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("prodPlanTypeIdEdit"));
			
	List<Object[]> list = null;
	Object[] object = null;

	List<productionPlanTypeBean> ppbean = new ArrayList<productionPlanTypeBean>();

	try {

		list = prodService.searchProductionPlanTypeWithId(id);
		
         
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			object = (Object[]) iterator.next();
			plbean.setProductionPlanTypeIdEdit((Integer)object[0]);
			plbean.setProductionPlanTypeNameEdit((String) object[1]);
								
			ppbean.add(plbean);
		}
		request.setAttribute("prodPlanTypeValues", ppbean);

	} catch (Exception e) {
		e.printStackTrace();
	} 
	return "ProdPlanTypeHome";

}
@RequestMapping(value = "/ProdPlanTypeDelete", method = RequestMethod.GET)
public ModelAndView deleteProdPlanType(
	@ModelAttribute("ProdPlanType") productionPlanTypeBean prod,
	DefaultSessionAttributeStore store, WebRequest request1,
	HttpServletRequest request, SessionStatus status,
	HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("prodPlanTypeIdDelete"));

	
	
	try
	{
		 
		 String msg=prodService.deleteProductionPlanType(id);
		 if(msg.equals("S"))
		 {
			 	session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Production Plan Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("prodPlanTypeDelete", "Production Plan Type has been deleted");
		 }
		 else
		 {
			 request.setAttribute("prodPlanTypeDeleteError", "Production Plan Type has not been deleted");
		 }
		 
		 
		
	} 
catch (Exception e) {
	e.printStackTrace();
}

	return new ModelAndView("ProdPlanTypeHome", "ProdPlanType",
			new productionPlanTypeBean());

}
@RequestMapping(value = "/ProdPlanTypeUpdate", method = RequestMethod.POST)

public String updateProdPlanType(
	@ModelAttribute("ProdPlanType") productionPlanTypeBean prod,
	HttpServletRequest request, HttpServletResponse response,
	SessionStatus status, Model model) {
response.setCharacterEncoding("UTF-8");

int prodPlanTypeId = prod.getProductionPlanTypeIdEdit();
String prodPlanTypeEdit = prod.getProductionPlanTypeNameEdit();

prod.setProductionPlanTypeId(prodPlanTypeId);
prod.setProductionPlanType(prodPlanTypeEdit);


	long checkDuplicate=dao.duplicateCheck("select count(*) from  productionPlanTypeBean ag where ag.productionPlanType='"
				+ prodPlanTypeEdit + "' and ag.productionPlanTypeId!='" + prodPlanTypeId + "'")	;
if (checkDuplicate == 0) {
	
	try {
		
		int msg=dao.updateDetails(prod);
		
		if(msg!=0){
			request.setAttribute("productionPlanTypeUpdate", "Production Plan Type has been updated");
		}
		else{
			request.setAttribute("productionPlanTypeUpdateError", "Production Plan Type has not been updated");
		}
	}

	catch (Exception e) {
		e.printStackTrace();
	}
}
else {
	request.setAttribute("prodPlanTypeValues", "prodPlanTypeValues");
request.setAttribute("ProductionPlanTypeUpdateDuplicate", "Production Plan Type already exist choose another one");
return "ProdPlanTypeHome";
	
}

return "ProdPlanTypeHome";
}
@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
String name = "prodPlanType";

Map<String, String> map =null;

try {
	map = xmlService.populateXmlLabels(name);

} catch (Exception e) {
	e.printStackTrace();
}
return map;
}


}
