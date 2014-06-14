/*
 * @Copyright MNTSOFT
 * 
 */
/*
 * @Copyright MNTSOFT
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.OrgPlants;
import com.mnt.erp.bean.PurOrgPlant;
import com.mnt.erp.bean.PurOrgCompany;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.PurchaseOrganizationService;
import com.mnt.erp.service.StockTransferService;
import com.mnt.erp.service.XmlLabelsService;

/**
 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
public class PurchaseOrganizationController {
	List<Object[]> list = null;
	@Autowired
	PurchaseOrganizationService poservice;
	@Autowired
	PlantService pservice;
	@Autowired
	OrganizationService organizationService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired 
	StockTransferService stockTransService;

	@RequestMapping(value = "/porganization", method = RequestMethod.GET)
	public ModelAndView getPurchaseOrganization(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("porganization.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("purchaseadd", "poadd",
				new PurchaseOrganization());
	}

	@ModelAttribute("PurOrgPlant")
	public Map<Integer, String> purOrgPlant() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {

			listvalues = pservice.selectPlantDetails();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("PurOrgCompany")
	public Map<Integer, String> PurOrgCompany() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = organizationService.selectOrganizationDetails();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/forStorLocIdsPurchaseOrganization", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> storLocIds(HttpServletRequest request,
			HttpServletResponse response, StockTransferBean stBean) {
		response.setCharacterEncoding("UTF-8");
		
		String org=request.getParameter("plantId");
		
		Map<Integer, String> map = null;
	     	
			
		
			
			Iterator<OrgPlants> itr = null;
		
			try {
				List<OrgPlants> list = null;
				list = poservice.selectPlants(org);
				map = new HashMap<Integer, String>();
				
				itr = list.iterator();
				while (itr.hasNext()) {
					OrgPlants	objectsh = (OrgPlants) itr.next();
				map.put(objectsh.getPlantId(),objectsh.getPlantName());
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

	     /* }*/
		
	

		return map;

	}
	@RequestMapping(value = "/purchaseOrganizationAdd", method = RequestMethod.POST)
	public String savePurchaseOrganization(
			@ModelAttribute("poadd") PurchaseOrganization purchaseOrganization,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		String res=null;
		Integer[] orgids = null;
		Integer[] orgids1 = null;
		PurOrgPlant purOrgPlant = null;
		PurOrgCompany purOrgCompany = null;
		List<PurOrgCompany> purcom = null;
		List<PurOrgPlant> listLocOrgs = null;
		List<String> list= new ArrayList<String>();
		String purchaseOrganizatinSave = null;
		int list1 = 0;
		HttpSession session=null;
		String purOrg = purchaseOrganization.getPurOrg();
		list1 = poservice.purchaseOrganizationDuplicate(purOrg);
		if (list1 == 0) {
			try {
				session=request.getSession(false);
				orgids = purchaseOrganization.getPlantId();
				orgids1 = purchaseOrganization.getOrgId();

				purcom = new ArrayList<PurOrgCompany>();
				listLocOrgs = new ArrayList<PurOrgPlant>();
				for (Integer integer : orgids1) {
					purOrgCompany = new PurOrgCompany();
					purOrgCompany.setOrg_Id(integer);

					purcom.add(purOrgCompany);

				}
				for (Integer integer : orgids) {
					purOrgPlant = new PurOrgPlant();
					purOrgPlant.setPlant_Id(integer);

					listLocOrgs.add(purOrgPlant);
				}
				purchaseOrganization.setPurOrgPlants(listLocOrgs);
				purchaseOrganization.setPurOrgCompany(purcom);

				msg = poservice.savePurchaseOrganization(purchaseOrganization,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if (msg.equals("S")) {
					purchaseOrganizatinSave = "Purchase Organization has been saved Successfully";
					list.add("2");
					res = "redirect:porganization.mnt?success=" + purchaseOrganizatinSave
							+ "&list=" + list + "";
				}
				else{
					purchaseOrganizatinSave = "Purchase Organization has not been saved";
					list.add("2");
					res = "redirect:porganization.mnt?warning=" + purchaseOrganizatinSave
							+ "&listwar=" + list + "";
				}

			}

			catch (Exception e) {
				purchaseOrganizatinSave = "Purchase Organization has not been saved";
				list.add("2");
				res = "redirect:porganization.mnt?warning=" + purchaseOrganizatinSave
						+ "&listwar=" + list + "";
				e.printStackTrace();
			}

			
		}

		else {
			
			purchaseOrganization.setAid(1);
			request.setAttribute("addPurchaseOrganizationDuplicate",
					"Purchase Organization Already Exists Please try some other name");

			return "purchasesearch";
		}
		return res;

	}

	@RequestMapping(value = "/posearch", method = RequestMethod.GET)
	public ModelAndView searchPurchaseOrganization(
			@ModelAttribute("poadd") PurchaseOrganization purchaseOrganization,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		
		try {
			
			String dbField = purchaseOrganization.getXmlLabel();
			String operation = purchaseOrganization.getOperations();
			String basicSearchId = purchaseOrganization.getBasicSearchId();

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
				list = poservice.searchPurchaseOrganization();

			}
			else{
				list=poservice.basicSearchPurchaseOrganization(dbField, operation, basicSearchId);
				
			}

			request.setAttribute("purchaseOrganizationll", list);
			

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("prvalues", "prvalues");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("purchasesearch");
		modelAndView.addObject("purchaseOrganization", list);
		return modelAndView;
	}

	@RequestMapping(value = "/purOrgEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editPurchaseOrganization(
			@ModelAttribute("poadd") PurchaseOrganization purchaseOrganization,
			BindingResult result, HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("purOrgEdit"));
		List<PurchaseOrganization> list = null;
		PurchaseOrganization objects = null;
		List<PurOrgCompany> porcom = null;
		List<PurOrgPlant> porgplant = null;
		PurOrgCompany company = null;
		PurOrgPlant proplant = null;
		List<Integer> plantinteger = new ArrayList<Integer>();
		List<Integer> cominte = new ArrayList<Integer>();
		try {
			list = poservice.editPurchaseOrganization(id);
			Iterator<PurchaseOrganization> iterator = list.iterator();
			while (iterator.hasNext()) {

				objects = (PurchaseOrganization) iterator.next();
				purchaseOrganization.setPurOrg_Id(objects.getPurOrg_Id());
				purchaseOrganization.setEditpurOrg(objects.getPurOrg());				
				porcom = objects.getPurOrgCompany();
				porgplant = objects.getPurOrgPlants();

			}

			Iterator<PurOrgCompany> iterator2 = porcom.iterator();
			while (iterator2.hasNext()) {
				company = (PurOrgCompany) iterator2.next();
				cominte.add(company.getOrg_Id());
			}

			Iterator<PurOrgPlant> iterator3 = porgplant.iterator();
			while (iterator3.hasNext()) {
				proplant = (PurOrgPlant) iterator3.next();
				plantinteger.add(proplant.getPlant_Id());
			}

			Integer[] newarray = new Integer[plantinteger.size()];

			for (int i = 0; i < plantinteger.size(); i++) {
				newarray[i] = plantinteger.get(i);
			}
			Integer[] newarray1 = new Integer[cominte.size()];
			for (int i = 0; i < cominte.size(); i++) {
				newarray1[i] = cominte.get(i);
			}
			purchaseOrganization.setEditplantId(newarray);
			purchaseOrganization.setEditorgId(newarray1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		request.setAttribute("povalues", "povalues");
		return "purchasesearch";
		
	}

	@RequestMapping(value = "/poedit", method = RequestMethod.POST)
	public String updatePurchaseOrganization(
			@ModelAttribute("poadd") PurchaseOrganization po,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		Integer[] orgids = null;
		Integer[] orgids1 = null;
		PurOrgPlant purOrgPlant = null;
		PurOrgCompany purOrgCompany = null;
		List<PurOrgCompany> purcom = null;
		List<PurOrgPlant> listLocOrgs = null;
		String purorg = po.getEditpurOrg();
		int id = po.getPurOrg_Id();
		int list2 = 0;
	
		list2 = poservice.purchaseOrganizationEditDuplicate(purorg, id);

		if (list2 == 0) {
			try {

				orgids = po.getEditplantId();
				orgids1 = po.getEditorgId();
				purcom = new ArrayList<PurOrgCompany>();
				listLocOrgs = new ArrayList<PurOrgPlant>();

				for (Integer integer : orgids1) {
					purOrgCompany = new PurOrgCompany();
					purOrgCompany.setOrg_Id(integer);
					purcom.add(purOrgCompany);

				}

				for (Integer integer : orgids) {
					purOrgPlant = new PurOrgPlant();
					purOrgPlant.setPlant_Id(integer);
					listLocOrgs.add(purOrgPlant);
				}

				po.setPurOrgPlants(listLocOrgs);
				po.setPurOrgCompany(purcom);
				po.setPurOrg(po.getEditpurOrg());
				msg = poservice.updatePurchaseOrganization(po);
				
				if(msg=="S"){
					
				request.setAttribute("purOrgUpadte",
						"Purchase Organization has been updated successfully");
				
				}
				else{
					
				request.setAttribute("purOrgUpadteError",
							"Purchase Organization has not been updated successfully");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAttribute("poadd", new PurchaseOrganization());
			return "purchasesearch";
		} else {
			
			request.setAttribute("addPurchaseOrganizationDuplicate",
					"Purchase Organization Already Exists Please try some other name");
			request.setAttribute("povalues", "povalues");

			return "purchasesearch";
		}

	}

	@RequestMapping(value = "/purOrgDelete.mnt", method = RequestMethod.GET)
	public ModelAndView deletePurchaseOrganization(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("purOrgDelete"));
			String msg = poservice.deletePurchaseOrganization(id);
			HttpSession session=null;
			if (msg.equals("S")){
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Purchase Organization","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("purOrgDelete",
						"Purchase Organization has been deleted successfully");
				
			}
			else
			{
				request.setAttribute("purOrgDeleteError",
						"PurchaseOrganization Data Deletion Failed due to constraint violation!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("purchasesearch", "poadd",
				new PurchaseOrganization());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "purOrg_Id";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
