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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.TaxCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.TaxCategoryService;
import com.mnt.erp.service.XmlLabelsService;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
	@Controller
	@Scope("request")
public class TaxCategoryController
{

	@Autowired
	TaxCategoryService  tc_service;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/Category", method = RequestMethod.GET)
	public ModelAndView getTaxCategory(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Category.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("taxCategoryAdd", "taxCategoryCommand",new TaxCategory());
    }
	/*=================================Add Method=======================================*/
	@RequestMapping(value = "/TaxCategory", method = RequestMethod.POST)
	public String addTaxCategory(@ModelAttribute("taxCategoryCommand") TaxCategory tax_cat,
			HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		String checkTCType=tax_cat.getTaxCategory();
		String checkTCTypeCode=tax_cat.getTaxCategoryCode();
		HttpSession session=null;
		int list1=tc_service.checkDuplicate(checkTCType,checkTCTypeCode);
		if(list1==0)
		{
		   	try
	    	{
		   		session=request.getSession(false);
			   	TaxCategory taxCat = new TaxCategory();
				taxCat.setTaxCategory(request.getParameter("taxCategory"));
				taxCat.setTaxCategoryCode(request.getParameter("taxCategoryCode"));
			    msg=tc_service.addTaxCategory(taxCat,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			    if(msg.equals("S"))
				{
			    	res = "redirect:Category.mnt?list=" + "success" + "";
				}
			
			   	else{
			   		res = "redirect:Category.mnt?listwar=" + "fail" + "";
			   	}
				
		    }
			catch (Exception e)
			{
				e.printStackTrace();
			}
		   	
			
		}
		else
		{
			tax_cat.setAid(1);
            request.setAttribute("addTaxDuplicate","Tax Category is Already Exists Please try some other name");
            return "taxCategoryAdd";
			
		}
		return res;
	}
	/*=================================Search Method=======================================*/
	@RequestMapping(value = "/taxCategorySearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchTaxCategory(@ModelAttribute("taxCategoryCommand") TaxCategory taxCat,
			BindingResult bindingResult, HttpServletRequest request,	HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
			List<TaxCategory> taxcattype = null;
			List<Object[]> list = null;
		    try 
		    {
			    int id = taxCat.getTaxCategoryId();
			    String dbField = taxCat.getXmlLabel();
				String operation = taxCat.getOperations();
				String basicSearchId = taxCat.getBasicSearchId();

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

				
					list = tc_service.searchTaxCategory();
					taxcattype = new ArrayList<TaxCategory>();
					Iterator<Object[]> iterator = list.iterator();
					while (iterator.hasNext())
					{
						Object[] objects = (Object[]) iterator.next();
						TaxCategory taxcatList = new TaxCategory();
						taxcatList.setTaxCategoryId((Integer)objects[0]);
						taxcatList.setTaxCategory((String)objects[1]);
						taxcatList.setTaxCategoryCode((String)objects[2]);
						taxcattype.add(taxcatList);
					}
			    } 
			    else 
			    {
					list = tc_service.basicSearchTaxCategory(dbField, operation, basicSearchId);
	          		taxcattype = new ArrayList<TaxCategory>();
					Iterator<Object[]> iterator = list.iterator();
					while (iterator.hasNext()) 
					{
						Object[] objects = (Object[]) iterator.next();
						TaxCategory taxcatList = new TaxCategory();
						taxcatList.setTaxCategoryId((Integer) objects[0]);
						taxcatList.setTaxCategory((String) objects[1]);
						taxcatList.setTaxCategoryCode((String)objects[2]);
						taxcattype.add(taxcatList);
				}
		      }
		    }
		    catch (Exception e)
		    {
			      e.printStackTrace();
		    }

			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("taxCategorySearch");
			modelAndView.addObject("taxCategoryCommand");
			request.setAttribute("taxCategorySearch",taxcattype);
			return modelAndView;
	}
	/*=================================Edit Method=======================================*/
	@RequestMapping(value = "/taxCategoryIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String taxCategoryEdit(@ModelAttribute TaxCategory taxcattype,BindingResult result,
			HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("taxCategoryIdEdit"));
		List<Object[]> list = null;
		List<TaxCategory> taxtypes=new ArrayList<TaxCategory>();
		Object[] objects = null;
		try
		{

			list = tc_service.searchTaxCategoryWithId(id);
			Iterator<Object[]> iterator = list.iterator();
   			while (iterator.hasNext()) 
   			{
			   	 objects = (Object[]) iterator.next();
				 taxcattype.setTaxCategoryIdEdit((Integer)objects[0]);
				 taxcattype.setTaxCategoryEdit((String)objects[1]);
				 taxcattype.setTaxCategoryCodeEdit((String)objects[2]);
			
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			list = null;
			objects = null;
		}
		taxtypes.add(taxcattype);
		request.setAttribute("list",taxtypes);
		model.addAttribute("taxCategoryCommand",taxcattype);
		return "taxCategoryEdit";
	}
	/*=================================Update Method=======================================*/
	@RequestMapping(value = "/taxCategoryEdit", method = RequestMethod.POST)
	public String updateTaxCategory(@ModelAttribute("taxCategoryCommand") TaxCategory taxcategory,
			HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int checkId=taxcategory.getTaxCategoryIdEdit();
		String checkTCType=taxcategory.getTaxCategoryEdit();
		String checkTCTypeCode=taxcategory.getTaxCategoryCodeEdit();
		int list1=tc_service.checkEditDuplicate(checkTCType,checkTCTypeCode,checkId);
	
		if(list1==0)
		{
			try
			{
				
				taxcategory.setTaxCategoryId(taxcategory.getTaxCategoryIdEdit());
				taxcategory.setTaxCategoryCode(taxcategory.getTaxCategoryCodeEdit());
				taxcategory.setTaxCategory(taxcategory.getTaxCategoryEdit());
				msg= tc_service.updateTaxCategory(taxcategory);
				if(msg.equals("S")){
				request.setAttribute("taxUpadte","Tax Category has been updated");
				}
				else{
					request.setAttribute("taxUpadteError","Tax Category has not been updated");
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			model.addAttribute("taxCategoryCommand",new TaxCategory());
			return "taxCategoryEdit";
		}
		else
		{ 
			request.setAttribute("list","taxCategory");
			request.setAttribute("addTaxDuplicate","Tax Category is Already Exists Please try some other name");
            return "taxCategoryEdit";
		}
           
	}
	/*=================================Delete Method=======================================*/
	@RequestMapping(value = "/taxCategoryIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteTaxCategory(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		try
		{
			 id = Integer.parseInt(request.getParameter("taxCategoryIdDelete"));
			 String msg=tc_service.deleteTaxCategory(id);
			 if(msg.equals("S")){
			 request.setAttribute("taxcategoryDelete","Tax Category has been deleted");
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Tax Category","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			 }
			 else{
				 request.setAttribute("taxcategoryDeleteError","Tax Category has not been deleted");
			 }

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("taxCategoryEdit", "taxCategoryCommand",new TaxCategory());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "taxCategoryId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
