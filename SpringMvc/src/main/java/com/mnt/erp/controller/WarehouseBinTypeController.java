/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.WarehouseBinType;
import com.mnt.erp.service.WarehouseBinTypeService;
import com.mnt.erp.service.XmlLabelsService;
/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
@Controller
public class WarehouseBinTypeController {

	@Autowired
	WarehouseBinTypeService warehousebintypeService;
	@Autowired
	XmlLabelsService xmlService;
	@RequestMapping(value="/warehousebintypeHome",method=RequestMethod.GET)
	@RequestScoped
	public ModelAndView warehousebinType(
			@ModelAttribute("warehousebintypeAdd") WarehouseBinType warehousebintype,
			SessionStatus status, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("warehousebintypeHome","warehousebintypeAdd",new WarehouseBinType());
	}
	@RequestMapping(value="/warehousebintypeAdd",method=RequestMethod.GET)
	@RequestScoped
	public String saveWarehouseBinTypeDetails(
			@ModelAttribute("warehousebintypeAdd") @Valid WarehouseBinType warehousebintypeAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msa = null;
		Long duplicateId=0l;

		try {
			//here we set the CharacterEncoding to resonse becoz of Localization Concept 
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				warehousebintypeAdd.setAid(1);
			return "warehousebintypeHome";
			}
			//this method is used to check the Duplicates
			duplicateId=warehousebintypeService.duplicateWarehouseBinTypeCheck(warehousebintypeAdd.getWarehousebintype());
			if(duplicateId==0)
			{
				//here there are no duplicates 
				// saveWarehouseBinTypeDetails this method is used to save WarehouseBinType Details
			msa = warehousebintypeService.saveWarehouseBinTypeDetails(warehousebintypeAdd);
			model.addAttribute("warehousebintypeAdd",new WarehouseBinType());
			if (msa.equals("success")) {
				warehousebintypeAdd.setAid(0);
				request.setAttribute("warehousebintypeSave", "WarehouseBinType Details Saved Successfully");
				model.addAttribute("warehousebintypeAdd", warehousebintypeAdd);
				return "warehousebintypeHome";
			}
			else if (msa.equals("failure"))
			{
				
				warehousebintypeAdd.setAid(1);
				request.setAttribute("warehousebintypeSaveFail", "Error occurred while saving WarehouseBinType details");
				model.addAttribute("warehousebintypeAdd", warehousebintypeAdd);
				return "warehousebintypeHome";
			}
			}
			else
			{
				
				request.setAttribute("WarehouseBinTypeDuplicate","WarehouseBinType Name  Already exist");
				warehousebintypeAdd.setAid(1);
				return "warehousebintypeHome";
			}
			
		return "warehousebintypeHome";	
		} catch (Exception e) {
			e.printStackTrace();
			warehousebintypeAdd.setAid(1);
			request.setAttribute("warehousebintypeSaveFail", "Error occurred while saving WarehouseBinType details");
			model.addAttribute("warehousebintypeAdd", warehousebintypeAdd);
			return "warehousebintypeHome";	
		}

	}

	@RequestMapping(value = "/warehousebintypeSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchWarehouseBinType(@ModelAttribute WarehouseBinType warehousebintypeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<WarehouseBinType> warehousebinTypeBean = new ArrayList<WarehouseBinType>();

		WarehouseBinType warehousebintypesearch = null;
		try {
			int id = warehousebintypeSearch.getWarehousebintypeId();
			String dbField = warehousebintypeSearch.getXmlLabel();
			String operation = warehousebintypeSearch.getOperations();
			String basicSearchId = warehousebintypeSearch.getBasicSearchId();
			
			if (operation.equals("_%")) {
				operation=" like ";
				basicSearchId = basicSearchId +"%";

			} else if (operation.equals("%_")) {
				operation=" like ";
				basicSearchId = "%" + basicSearchId;

			} else if (operation.equals("%_%")) {
				operation=" like ";
				basicSearchId =  "%"  + basicSearchId + "%" ;

			}
			if (basicSearchId == "") {
				list = warehousebintypeService.searchWarehouseBinType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					WarehouseBinType vt = new WarehouseBinType();
					Object[] obj = (Object[]) iterator.next();
					vt.setWarehousebintypeId((Integer) obj[0]);
					vt.setWarehousebintype((String) obj[1]);
					warehousebinTypeBean.add(vt);

				}
			}
				else {
					list = warehousebintypeService.basicSearchWarehouseBinType(dbField, operation,
							basicSearchId);
					// list = assertService.searchAssertTypeWithId(id);
					Iterator<Object[]> iterator = list.iterator();
					while (iterator.hasNext()) {
						WarehouseBinType vt = new WarehouseBinType();
						Object[] obj = (Object[]) iterator.next();
						vt.setWarehousebintypeId((Integer) obj[0]);
						vt.setWarehousebintype((String) obj[1]);
						warehousebinTypeBean.add(vt);
					}
				}			request.setCharacterEncoding("UTF-8");
			request.setAttribute("warehousebintypeSearch", warehousebinTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("warehousebintypeAdd", warehousebintypeSearch);

		
		return "warehousebintypeHome";
	}
	@ModelAttribute("WarehouseBinTypeSearchNames")
	public Map<String, String> populatewarehousebintypeSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = warehousebintypeService.selectWarehouseBinTypeNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
			
				String desigId=Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/warehousebintypeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String warehousebintypeEdit(@ModelAttribute WarehouseBinType warehousebintypeDisplay,
			HttpServletRequest request, Model model,HttpServletResponse response) {
		String warehousebintypename = request.getParameter("warehousebintypeDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;


		List<WarehouseBinType> warehousebintypesList = new ArrayList<WarehouseBinType>();

		try {

			list = warehousebintypeService.searchWarehouseBinTypeWithId(warehousebintypename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				warehousebintypeDisplay.setWarehousebintypeIdEdit((Integer) object[0]);
				warehousebintypeDisplay.setWarehousebintypeEdit((String) object[1]);
				
				/*warehousebintypeDisplay.setStatusEdit((String) object[2]);*/
				
				

				warehousebintypesList.add(warehousebintypeDisplay);

			}
			request.setAttribute("warehousebintypeValues", warehousebintypesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("warehousebintypeAdd", warehousebintypeDisplay);
		return "warehousebintypeHome";
		
	}

	@RequestMapping(value = "/warehousebintypeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateWarehouseBinType(@ModelAttribute("warehousebintypeAdd") WarehouseBinType warehousebintype,
			HttpServletRequest request, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId=0l;
		try {
			duplicateId=warehousebintypeService.updateDuplicateCheck(warehousebintype.getWarehousebintypeEdit(),warehousebintype.getWarehousebintypeIdEdit());
			
			if(duplicateId==0)
			{
			warehousebintype.setWarehousebintypeId(warehousebintype.getWarehousebintypeIdEdit());
			warehousebintype.setWarehousebintype(warehousebintype.getWarehousebintypeEdit());
			/*warehousebintype.setStatus(warehousebintype.getStatusEdit());*/
			

			String msg = warehousebintypeService.updateWarehouseBinType(warehousebintype);

			if (msg.equals("WarehouseBinType Details Updated Successfully")) {
				request.setAttribute("warehousebintypeUpadteSuccess",
						"WarehouseBinType Details Updated Successfully");
			}
			else
			{request.setAttribute("warehousebintypeValues","hello");
				
				request.setAttribute("warehousebintypeUpadteFail",
						"WarehouseBinType Details has Not Updated");
				return"warehousebintypeHome";
			}
			}
			else
			{
				request.setAttribute("warehousebintypeEditDuplicate","WarehouseBinType Name Already exist");
				request.setAttribute("warehousebintypeValues","hello");
				
				return"warehousebintypeHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("warehousebintypeAdd", new WarehouseBinType());
		
		return "warehousebintypeHome";

	}
	@RequestMapping(value = "/warehousebintypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView warehousebintypeDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int warehousebintypeId= 0;
		
		
		String delmsg1 = null; 
		String delmsg2 = null; 
		try {
			warehousebintypeId = Integer.parseInt(request.getParameter("warehousebintypeIdDelete"));
			String msg = warehousebintypeService.warehousebintypeDelete(warehousebintypeId);
			
			String delmsg = msg;
			String[] delmsgpart = delmsg.split(",");
			 delmsg1 = delmsgpart[0]; 
		delmsg2 = delmsgpart[1]; 
			if (delmsg1.equals("WarehouseBinType Details Deleted Successfully"))
			{
				request.setAttribute("warehousebintypeUpadteSuccess",
						"WarehouseBinType "+delmsg2+" Deleted Successfully");
			}
			else
			{
				request.setAttribute("warehousebintypeUpadteFail",
						"warehousebintype "+delmsg2+" Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("warehousebintypeUpadteFail",
					"warehousebintype "+delmsg2+" Did Not Deleted");
		}
		return new ModelAndView("warehousebintypeHome", "warehousebintypeAdd", new WarehouseBinType());
	}
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name="warehousebinTypeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
