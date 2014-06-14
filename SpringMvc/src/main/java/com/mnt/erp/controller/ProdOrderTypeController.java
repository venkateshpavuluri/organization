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
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.ProductionOrderType;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.prodOrderTypeService;

@Controller
public class ProdOrderTypeController {
@Autowired
prodOrderTypeService POTService;
@Autowired
ERPDao dao;
@Autowired
XmlLabelsService xmlService;
String sus = null;

@Autowired
AuditLogService auditLogService;

@Autowired
MenuService menuService;

HttpSession session;

@RequestMapping(value = "/POTHome", method = RequestMethod.GET)
public String getProdOrderTypeHome(
		@ModelAttribute("ProdOrderType") ProductionOrderType POTbean, SessionStatus status,HttpServletRequest request,
		HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	HttpSession session=request.getSession(false);
	List<String> list=menuService.getPrivilige("POTHome.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
	model.addAttribute("ProdOrderType", new ProductionOrderType());
	return "POTHome";
}
@RequestMapping(value = "/addProdOrderType", method = RequestMethod.POST)
@RequestScoped
public String saveProdOrderType(
		@ModelAttribute("ProdOrderType") ProductionOrderType POTbean,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	String result = null;
	String prodOrderTypeCheck = POTbean.getProdOrderType();
	long res=dao.duplicateCheck("select count(*) from ProductionOrderType ag where ag.prodOrderType='"+prodOrderTypeCheck+"'");
	
	if (res == 0) 
	{
		try {
			session=request.getSession(false);
		int save=dao.saveDetails(POTbean);
	
		if(save!=0)
		{
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Production Order Type","ROW" ,String.valueOf(save),"1",modifiedDate,session.getAttribute("userName").toString());		
		}				
			status.setComplete();
			result = "redirect:POTHome.mnt?list=" + "success" + "";
				
			
		} catch (Exception e) {
			result = "redirect:POTHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}
		
	} else {
 
		
		POTbean.setAid(1);
		request.setAttribute("addProdOrderTypeDuplicate",
				"ProdOrderType  Already Exists Choose Another One");

		return "POTHome";

	}
	
	return result;
}
@RequestMapping(value = "/searchProdOrderType", method = RequestMethod.GET)
@RequestScoped
public String searchProdOrderType(
		@ModelAttribute("ProdOrderType") ProductionOrderType POTbean,
		DefaultSessionAttributeStore store, WebRequest request1,
		HttpServletRequest request, HttpServletResponse response,
		SessionStatus status, Model model) {
	response.setCharacterEncoding("UTF-8");
	
	List<Object[]> list = null;
	
	List<ProductionOrderType> prodOrderTypeSearch = new ArrayList<ProductionOrderType>();
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
			
			
			list=dao.searchDetails("select e.prodOrderTypeId,e.prodOrderType from ProductionOrderType e where e."
					+ dbField + " " + operation +"  '"+basicSearchId+"'order by e.prodOrderType ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} else {

		try {
			prodOrderTypeSearch = new ArrayList<ProductionOrderType>();
		
		list=dao.searchDetails("select e.prodOrderTypeId,e.prodOrderType from ProductionOrderType e order by e.prodOrderType");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Iterator<Object[]> iterator = list.iterator();
	while (iterator.hasNext()) {
		ProductionOrderType prodOrder2 = new ProductionOrderType();
		Object[] objs = (Object[]) iterator.next();
		prodOrder2.setProdOrderTypeId((Integer) objs[0]);
		prodOrder2.setProdOrderType((String) objs[1]);
		prodOrderTypeSearch.add(prodOrder2);
		
	}
	
	request.setAttribute("prodOrderTypeSearch", prodOrderTypeSearch);

	return "POTHome";
}
@RequestMapping(value = "/prodOrderTypeEditHome", method = RequestMethod.GET)

public String ProdOrderTypeIdEdit1(
		@ModelAttribute("ProdOrderType") ProductionOrderType POTbean,
		HttpServletRequest request, HttpServletResponse response,
		Model model) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("prodOrderTypeIdEdit"));
			
	List<Object[]> list = null;
	Object[] object = null;

	List<ProductionOrderType> POTbean1 = new ArrayList<ProductionOrderType>();

	try {

		list = POTService.searchProdOrderTypeWithId(id);
         
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			object = (Object[]) iterator.next();
			POTbean.setProdOrderTypeIdEdit((Integer) object[0]);
					

			POTbean.setProdOrderTypeNameEdit((String) object[1]);
			
					
			POTbean1.add(POTbean);
		}
		request.setAttribute("prodOrderTypeValues", POTbean1);

	} catch (Exception e) {
		e.printStackTrace();
	} 
	return "POTHome";

}
@RequestMapping(value = "/prodOrderTypeDelete", method = RequestMethod.GET)
public ModelAndView deleteProdOrderType(
	@ModelAttribute("ProdOrderType") ProductionOrderType prod,
	DefaultSessionAttributeStore store, WebRequest request1,
	HttpServletRequest request, SessionStatus status,
	HttpServletResponse response, Model model) {
response.setCharacterEncoding("UTF-8");
int id = Integer.parseInt(request.getParameter("prodOrderTypeIdDelete"));
		
String prodOrderTypeDelete = null;
try {
	
	prodOrderTypeDelete=POTService.deleteProdOrderType(id);
	if (prodOrderTypeDelete.equals("S")) {
		session=request.getSession(false);
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Production Order Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
		request.setAttribute("prodOrderTypeDelete","Production Order Type has been deleted");
		
	} else {
	request.setAttribute("prodOrderTypeDeleteError","Production Order Type has not been deleted");	
	}
}

catch (Exception e) {
	e.printStackTrace();
}

return new ModelAndView("POTHome", "ProdOrderType",
		new ProductionOrderType());

}
@RequestMapping(value = "/prodOrderTypeUpdate", method = RequestMethod.POST)

public String updateProdOrderType(
	@ModelAttribute("ProdOrderType") ProductionOrderType prod,
	HttpServletRequest request, HttpServletResponse response,
	SessionStatus status, Model model) {
response.setCharacterEncoding("UTF-8");

int res=0;
int prodOrderTypeId = prod.getProdOrderTypeIdEdit();
String prodOrderTypeEdit = prod.getProdOrderTypeNameEdit();

prod.setProdOrderTypeId(prodOrderTypeId);
prod.setProdOrderType(prodOrderTypeEdit);


	long checkDuplicate=dao.duplicateCheck("select count(*) from  ProductionOrderType ag where ag.prodOrderType='"
				+ prodOrderTypeEdit + "' and ag.prodOrderTypeId!='" + prodOrderTypeId + "'")	;
if (checkDuplicate == 0) {
	try {
		
		res=dao.updateDetails(prod);	
		if(res!=0){
			request.setAttribute("prodOrderTypeUpdate", "Production Order Type has been updated");
		}
		else{
			request.setAttribute("prodOrderTypeUpdateError", "Production Order Type has not been updated");
		}
	}

	catch (Exception e) {
		e.printStackTrace();
	}
} else {
	request.setAttribute("prodOrderTypeValues", "prodOrderTypeValues");
	request.setAttribute("prodOrderTypeUpdateCheck", "Production Order Type has not been updated");
	return "POTHome";
	
}

return "POTHome";
}

@ModelAttribute("xmlItems")
public Map<String, String> populatLabelDetails() {
String name = "prodOrderType";

Map<String, String> map =null;

try {
	map = xmlService.populateXmlLabels(name);

} catch (Exception e) {
	e.printStackTrace();
}
return map;
}
}
