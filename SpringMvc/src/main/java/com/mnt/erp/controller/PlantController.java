/**
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CountryService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.XmlLabelsService;


/**
 * @author pvenkateswarlu
 * @version 1.0 20-09-2013
 */
@Controller
public class PlantController {
	@Autowired
	PlantService plantService;
	@Autowired
	CountryService countryService;
	@Autowired
	OrganizationService organizationService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	List<Plant> plant1 = null;
	String name = null;
	Plant pl = null;
	Object[] objects2 = null;
	
	List<Object[]> objectsArray = null;
	int id = 0;
	Iterator<Object[]> iterator = null;
	List<Plant> plantList = null;

	@ModelAttribute("country")
	public Map<Integer, String> populateCountry() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		try {
			list = countryService.getCountryIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("orgName")
	public Map<Integer, String> populateOrgName() {
		Map<Integer, String> map =new HashMap<Integer, String>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		try {
			list = organizationService.getOrganizationIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/plantHome", method = RequestMethod.GET)
	public String gotoPlant(Model model, HttpServletResponse response,HttpServletRequest request) {
		try {
			response.setCharacterEncoding("UTF-8");
			model.addAttribute("plant", new Plant());
			HttpSession session=request.getSession(false);
			List<String> list=menuService.getPrivilige("plantHome.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "plant";
	}

	@RequestMapping(value = "/plantAdd", method = RequestMethod.POST)
	@Scope("request")
	public String savePlant(@ModelAttribute Plant plant, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String msg = null;
		String materialUpadte = null;
	
String result=null;
HttpSession session=null;
		Long id = 0l;
		try {
			response.setCharacterEncoding("UTF-8");
			id = plantService.getPlantNameCount(plant.getPlantName());
			if (id == 0) {
				session=request.getSession(false);
				msg = plantService.savePlantDetails(plant,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (msg.equals("S")) {
					materialUpadte = "Plant Data is saved Successfully";
					result="redirect:plantHome.mnt?list="
					+"sucess"+"";
				} else {
					materialUpadte = "Plant Data Data is not saved properly";
					result="redirect:plantHome.mnt?listw="
							+"plant"+ "";
				}
			} else {
				plant.setAid(1);
				request.setAttribute("duplicate",
						"Plant Name is already exists . Please try some other name ");
				return "plant";

			}
			model.addAttribute("plant", new Plant());
		} catch (Exception e) {
			materialUpadte = "Plant Data Data is not saved properly";
			
			result="redirect:plantHome.mnt?listw="
					+ "Fail" + "";
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/plantSearch", method = RequestMethod.GET)
	
	public String searchPlant(@ModelAttribute("plant") Plant plant, Model model,
			HttpServletRequest request, HttpServletResponse response)

	{
		
		List<Plant> list = null;
		
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			id = plant.getPlantId();
			String dbField = plant.getXmlLabel();
			String operation = plant.getOperations();
			String basicSearchId = plant.getBasicSearchId();

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
				list = plantService.searchPlantDetails();
			} else {
				// list = plantService.searchPlantDetails(id);
				list = plantService.basicSearchPlant(dbField, operation,
						basicSearchId);
			}
			
			request.setAttribute("plantSearch", list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "plant";
	}

	@ModelAttribute("plantIds")
	public Map<Integer, String> populatePlantIds() {
		Map<Integer, String> map = null;
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		try {
			map = new HashMap<Integer, String>();
			list = plantService.getPlantIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/plantEdit", method = RequestMethod.GET)
	public String editPlant(@ModelAttribute("plant") Plant plant, Model model,
			HttpServletRequest request, HttpServletResponse response) {

		

		List<Plant> plants = null;
		Iterator<Plant> iterator = null;
		Plant plantEditor = null;
		Plant plantEdit = null;
		int id = 0;
		try {
			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request.getParameter("plantEdit"));
			plants = plantService.searchPlantDetails(id);

			plantEdit = new Plant();
			iterator = plants.iterator();
			while (iterator.hasNext()) {
				plantEditor = (Plant) iterator.next();
				plantEdit.setAdd1Edit(plantEditor.getAdd1());
				plantEdit.setAdd2Edit(plantEditor.getAdd2());
				plantEdit.setAdd3Edit(plantEditor.getAdd3());
				plantEdit.setCityEdit(plantEditor.getCity());
				plantEdit.setCountryEdit(plantEditor.getCountry());
				plantEdit.setFaxEdit(plantEditor.getFax());
				plantEdit.setMobileEdit(plantEditor.getMobile());
				plantEdit.setOrgIdEdit(plantEditor.getOrgId());
				plantEdit.setPhoneEdit(plantEditor.getPhone());
				plantEdit.setPlantNameEdit(plantEditor.getPlantName());
				plantEdit.setPlantIdEdit(plantEditor.getPlantId());
				plantEdit.setStateEdit(plantEditor.getState());
			}
			model.addAttribute("plant", plantEdit);
			request.setAttribute("plantValues", plants);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "plant";
	}

	@RequestMapping(value = "/plantUpdate", method = RequestMethod.POST)
	public String updatePlant(@ModelAttribute("plant") Plant plant,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String msg = null;
		Long dupId = 0l;
		try {
			response.setCharacterEncoding("UTF-8");
			dupId = plantService.updateDuplicate(plant.getPlantNameEdit(),
					plant.getPlantIdEdit());
			if (dupId == 0) {

				msg = plantService.updatePlantDetails(plant);
				if (msg.equals("S")) {
					request.setAttribute("plantUpdate","Plant Data is Updated successfully");
				} else {
					request.setAttribute("plantUpdateError",
							"Plant Data is not Updated properly");

				}
			} else {
				request.setAttribute("plantValues", "plantvalues");
				request.setAttribute("plantDuplicate",
						"Plant Name is already exists. Please try some other name");
				return "plant";
			}
		} catch (Exception e) {
			request.setAttribute("plantUpdateError",
					"Plant Data is not Updated properly");

			e.printStackTrace();
		}
		model.addAttribute("plant", new Plant());
		return "plant";
	}

	@RequestMapping(value = "/plantDelete", method = RequestMethod.GET)
	public String deletePlant(@ModelAttribute Plant plant, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String msg = null;
		HttpSession session=null;
		int id = 0;
		try {
			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request.getParameter("plantDelete"));
			plant.setPlantId(id);
			plant.setCountrysList(new CountrysList());
			plant.setOrganization(new Organization());
			msg = plantService.deletePlantDetails(plant);
			if (msg.equals("S")) {
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Plant","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				request.setAttribute("plantDelete",
						"Plant Data is deleted Successfully");
			} else {

				request.setAttribute("plantDeleteError",
						"Plant Data is not deleted properly");
			}
		} catch (Exception e) {

			request.setAttribute("plantDeleteError",
					"Plant Data is not deleted properly");
			e.printStackTrace();
		}
		model.addAttribute("plant", new Plant());
		return "plant";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "plantId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value="/plantAdvanceSearch",method=RequestMethod.GET)
	public  String plantAdvanceSearch(@ModelAttribute("plant") Plant plant,HttpServletRequest request,HttpServletResponse response)
	{
		
		String name1="plant",s1=null,s2=null;

		 List<Object[]> returnString = null;
		
		 plantList=new ArrayList<Plant>();
		 plant.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			
			for (Object[] object : returnString) {
				Plant p=new Plant();
				
				s1=(String)object[0];
				s2=(String)object[1];
				p.setFirstLabel(s1);
				
				p.setSecondLabel(s2);
				plantList.add(p);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  request.setAttribute("plantSearchAdvance",plantList);
		  return "plant";
	}
	
	
	
	@RequestMapping(value = "/plantAdvanceSearchOperations", method= RequestMethod.POST)
	public  String plantAdvanceSearchOperations(@ModelAttribute Plant plant,HttpServletRequest request,HttpServletResponse response,Model model)
	{   
	
		plant1=new ArrayList<Plant>();
	    String columns=plant.getFirstLabel();
	    String operations=plant.getOperations1();
	    String advanceSearchText=plant.getAdvanceSearchText();
	   
   	    if(advanceSearchText.length()!=0)
   	    {
   	  
	    objectsArray= plantService.getPlantAdvance(columns, operations, advanceSearchText);
   	    }
   	    else
   	    {
   	     objectsArray= plantService.getPlant("ALL");
   	    }
	    iterator=objectsArray.iterator();
	   while(iterator.hasNext())
	   {
		   pl=new com.mnt.erp.bean.Plant();
		  objects2=(Object[])iterator.next();
		  
		  pl.setPlantId((Integer)objects2[0]);
		  pl.setPlantName((String)objects2[1]);
		  pl.setAdd1((String)objects2[2]);
		  pl.setAdd2((String)objects2[3]);
		  pl.setAdd3((String)objects2[4]);
		  pl.setCity((String)objects2[5]);
		  pl.setState((String)objects2[6]);
		  pl.setPhone((String)objects2[7]);
		  pl.setFax((String) objects2[8]);
		  pl.setMobile((String) objects2[9]);

		  Organization organization = new Organization();
		  organization = (Organization) objects2[10];
		  pl.setOrgId(String.valueOf(organization.getOrgId()));
		  pl.setOrgName(organization.getOrgName());

		  CountrysList countrysList = new CountrysList();
		  countrysList = (CountrysList) objects2[11];
		  pl.setCountryName(countrysList.getCountryName());
		
		   plant1.add(pl);
		 
	   }
	
	   request.setAttribute("plantSearch",plant1);
       model.addAttribute("plant",new Plant());
	       
	    return "plant";
		}

}
