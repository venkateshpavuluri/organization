/**
 @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.PurchaseGroup;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.service.PurchaseGroupService;
import com.mnt.erp.service.PurchaseOrganizationService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 26-10-2013
 * @build 0.0
 *
 */
@Controller
@Scope("request")
public class PurchaseGroupController
{
	private Logger logger=Logger.getLogger(PurchaseGroupController.class);
	@Autowired
	PurchaseGroupService pgService;
	@Autowired
	PurchaseOrganizationService poService;
	@Autowired
	XmlLabelsService xmlService;

	Object[] objects = null;
	String msg=null;
	/*=============================Purchase Organization Values================*/
	@ModelAttribute("purchaseOrganization")
	public Map<Integer, String> selectPurchaseOrg() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = poService.selectPurchaseOrg();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@RequestMapping(value = "/PurchaseGroup", method = RequestMethod.GET)
	public ModelAndView getPurchaseGroup(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
				return new ModelAndView("purchaseGroupHome", "purchaseGroupCommand",new PurchaseGroup());

	}

	/*=================================Add Method=======================================*/
	@RequestMapping(value = "/purchaseGroupAdd", method = RequestMethod.POST)
	public String addPurchaseGroup(@ModelAttribute("purchaseGroupCommand") PurchaseGroup purchaseAdd, HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
	
        List<String> list=new ArrayList<String>();
		String msg = null;
		String purchaseUpadte=null;
		 String checkPurchaseGroup=purchaseAdd.getPurchaseGroup();
		 int list1=pgService.checkDuplicate(checkPurchaseGroup);
			if(list1==0)
			{	
		   try
		   {
				msg=pgService.addPurchaseGroup(purchaseAdd);
				request.setAttribute("purchasegroup", "Purchase Group Details Successfully Saved");
		   }
		   catch (Exception e) 
		   {
				e.printStackTrace();
		   } 
		   if(msg.equals("Purchase Group Details Successfully Saved"))
		   {
			   purchaseUpadte="Purchase Group Data Saved Successfully";
			    list.add("2");
		   }
				model.addAttribute("purchaseGroupCommand",new PurchaseGroup());
				return "redirect:PurchaseGroup.mnt?success="+purchaseUpadte+"&list="+list+"";
			}
			else
			{
				purchaseAdd.setAid(1);
	            request.setAttribute("addPGDuplicate","Purchase Group is Already Exists Please try some other name");
	            return "purchaseGroupHome";
			}
	  }
   	  
	/*=================================Search Method=======================================*/
	@RequestMapping(value = "/purchaseGroupSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchPurchaseGroup(@ModelAttribute("purchaseGroupCommand") PurchaseGroup purchaseGrpSearch,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) 
	{
		response.setCharacterEncoding("UTF-8");
		List<PurchaseGroup> pGroup = null;
		List<Object[]> list = null;
		try 
		{
			int id = purchaseGrpSearch.getPurchaseGroupId();
			String dbField = purchaseGrpSearch.getXmlLabel();
			String operation = purchaseGrpSearch.getOperations();
			String basicSearchId = purchaseGrpSearch.getBasicSearchId();

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
			
				list = pgService.searchPurchaseGroup();
				pGroup = new ArrayList<PurchaseGroup>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					PurchaseGroup pgList = new PurchaseGroup();
					pgList.setPurchaseGroupId((Integer)objects[0]);
					PurchaseOrganization poBean=((PurchaseOrganization)objects[1]);
					pgList.setPurOrg(poBean.getPurOrg());
					pgList.setPurchaseGroup((String)objects[2]);
					pGroup.add(pgList);
				
				}

			} 
			else
			{
				list = pgService.basicSearchPurchaseGroup(dbField, operation, basicSearchId);
				pGroup = new ArrayList<PurchaseGroup>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					PurchaseGroup pgList = new PurchaseGroup();
					pgList.setPurchaseGroupId((Integer)objects[0]);
					PurchaseOrganization poBean = (PurchaseOrganization) objects[1];
					pgList.setPurOrg(poBean.getPurOrg());
					pgList.setPurchaseGroup((String) objects[2]);
					pGroup.add(pgList);
				}

			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		request.setAttribute("purchaseGroupSearchVlaue", "purchaseGroupSearch");

		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("purchaseGroupHome");
	    modelAndView.addObject("purchaseGroupSearch",pGroup);
		return modelAndView;
	}
	/*=================================Edit Method=======================================*/
	@RequestMapping(value = "/purchaseGroupIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String purchaseGroupEdit(@ModelAttribute PurchaseGroup purchaseEdit,BindingResult result, HttpServletRequest request,
			HttpServletResponse response,Model model) 
	{
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("purchaseGroupIdEdit"));
		List<PurchaseGroup> list = null;
		List<PurchaseGroup> purchaseGroups=new ArrayList<PurchaseGroup>();
		
		try
		{
			list = pgService.searchPurchaseGroupWithId(id);
			Iterator<PurchaseGroup> iterator = list.iterator();
			while (iterator.hasNext()) 
			{
				Object	objects =  iterator.next();
				PurchaseGroup pg=(PurchaseGroup)objects;
				purchaseEdit.setPurchaseGroupIdEditt(pg.getPurchaseGroupId());
				purchaseEdit.setPurOrg_IdEditt(pg.getPurOrg_Id());
				purchaseEdit.setPurchaseGroupEditt(pg.getPurchaseGroup());
				
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
		purchaseGroups.add(purchaseEdit);
		request.setAttribute("list",purchaseGroups);
		model.addAttribute("purchaseGroupCommand",purchaseEdit);

		return "purchaseGroupHome";
	}
	/*=================================Update Method=======================================*/
	@RequestMapping(value = "/purchaseGroupEdit", method = RequestMethod.POST)
	public String updatePurchaseGroup(@ModelAttribute("purchaseGroupCommand") PurchaseGroup purchaseUpdate,HttpServletRequest request,
			HttpServletResponse response,Model model) 
	{
		response.setCharacterEncoding("UTF-8");
		
		int checkId=purchaseUpdate.getPurchaseGroupIdEditt();
        String checkPurchaseGroup=purchaseUpdate.getPurchaseGroupEditt();
		int list1=pgService.checkEditDuplicate(checkPurchaseGroup,checkId);
		if(list1==0)
		{
		try
			{
			
				purchaseUpdate.setPurchaseGroupId(purchaseUpdate.getPurchaseGroupIdEditt());
				purchaseUpdate.setPurOrg_Id(purchaseUpdate.getPurOrg_IdEditt());
				purchaseUpdate.setPurchaseGroup(purchaseUpdate.getPurchaseGroupEditt());
			    msg= pgService.updatePurchaseGroup(purchaseUpdate);
				request.setAttribute("purchaseUpadte","purchase Group Data Updated Successfully ");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			model.addAttribute("purchaseGroupCommand",new PurchaseGroup());
			return "purchaseGroupHome";
		}
		else
		{
			request.setAttribute("list","PurchaseGroup");
			request.setAttribute("addPGDuplicate","PurchaseGroup is Already Exists Please try some other name");
            return "purchaseGroupHome";
		}
	}
		
	
	/*=================================Delete Method=======================================*/
	@RequestMapping(value = "/purchaseGroupIdDelete", method = RequestMethod.GET)
	public String deletePurchaseGroup(@ModelAttribute("purchaseGroupCommand") PurchaseGroup purchaseDelte,Model model,HttpServletRequest request,HttpServletResponse response)
	{ 
		String purchaseUpadte=null;
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		int purchaseGroupId = 0;
		try
		{
			 purchaseGroupId = Integer.parseInt(request.getParameter("purchaseGroupIdDelete"));
			 String msg=pgService.deletePurchaseGroup(purchaseGroupId);
			 if(msg.equals("Deleted"))
			 {
				 purchaseUpadte = "Purchase Group Data Deleted Successfully";
					list.add("2");
				
			 }
			 else 
			 {
				String  purchaseUpadteF = "Purchase Group Data Deletion Failed Due to Constraint Violation";
				 request.setAttribute("purchaseUpadteF", purchaseUpadteF);
					return "purchaseGroupHome";
				}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "redirect:PurchaseGroup.mnt?success="+purchaseUpadte +"&list="+list+"";
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "purchaseGroupId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
 }

