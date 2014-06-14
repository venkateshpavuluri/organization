/**
copyright MNTSoft
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

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

import com.mnt.erp.bean.StorageType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.StorageTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
@Controller
public class StorageTypeController {
	@Autowired
	StorageTypeService storagetypeService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	
	
	@RequestMapping(value="/storagetypeHome",method=RequestMethod.GET)
	@RequestScoped
	public ModelAndView storageType(
			@ModelAttribute("storagetypeAdd") StorageType storagetype,
			SessionStatus status, HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("storagetypeHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("storagetypeHome","storagetypeAdd",new StorageType());
	}
	@RequestMapping(value="/storagetypeAdd",method=RequestMethod.GET)
	@RequestScoped
	public String saveStorageTypeDetails(
			@ModelAttribute("storagetypeAdd") @Valid StorageType storagetypeAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msa,res = null;
		Long duplicateId=0l;
		HttpSession session=null;

		try {
			//here we set the CharacterEncoding to resonse becoz of Localization Concept 
			response.setCharacterEncoding("UTF-8");
			
			//this method is used to check the Duplicates
			duplicateId=storagetypeService.duplicateStorageTypeCheck(storagetypeAdd.getStoragetype());
			if(duplicateId==0)
			{
				//here there are no duplicates 
				// saveStorageTypeDetails this method is used to save StorageType Details
				session=request.getSession(false);
			msa = storagetypeService.saveStorageTypeDetails(storagetypeAdd, session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			
			if (msa.equals("S")) {
				
				res = "redirect:storagetypeHome.mnt?list=" + "success" + "";
			}
			else 
				res = "redirect:storagetypeHome.mnt?listwar=" + "fail" + "";

			}
			else
			{
				
				request.setAttribute("StorageTypeDuplicate","StorageType Name  Already exist");
				storagetypeAdd.setAid(1);
				return "storagetypeHome";
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:storagetypeHome.mnt?listwar=" + "fail" + "";
				
		}
		return res;

	}

	@RequestMapping(value = "/storagetypeSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchStorageType(@ModelAttribute StorageType storagetypeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		List<Object[]> list = null;
		
		List<StorageType> storageTypeBean = new ArrayList<StorageType>();

	
		try {
			int id = storagetypeSearch.getStoragetypeId();
			String dbField = storagetypeSearch.getXmlLabel();
			String operation = storagetypeSearch.getOperations();
			String basicSearchId = storagetypeSearch.getBasicSearchId();
			
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
				list = storagetypeService.searchStorageType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					StorageType vt = new StorageType();
					Object[] obj = (Object[]) iterator.next();
					vt.setStoragetypeId((Integer) obj[0]);
					vt.setStoragetype((String) obj[1]);
					storageTypeBean.add(vt);

				}
			}
				else {
					list = storagetypeService.basicSearchStorageType(dbField, operation,
							basicSearchId);
					
					Iterator<Object[]> iterator = list.iterator();
					while (iterator.hasNext()) {
						StorageType vt = new StorageType();
						Object[] obj = (Object[]) iterator.next();
						vt.setStoragetypeId((Integer) obj[0]);
						vt.setStoragetype((String) obj[1]);
						storageTypeBean.add(vt);
					}
				}			request.setCharacterEncoding("UTF-8");
			request.setAttribute("storagetypeSearch", storageTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("storagetypeAdd", storagetypeSearch);

		
		return "storagetypeHome";
	}
	@ModelAttribute("StorageTypeSearchNames")
	public Map<String, String> populatestoragetypeSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = storagetypeService.selectStorageTypeNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String desigId=Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/storagetypeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String storagetypeEdit(@ModelAttribute StorageType storagetypeDisplay,
			HttpServletRequest request, Model model,HttpServletResponse response) {
		String storagetypename = request.getParameter("storagetypeDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;


		List<StorageType> storagetypesList = new ArrayList<StorageType>();

		try {

			list = storagetypeService.searchStorageTypeWithId(storagetypename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				storagetypeDisplay.setStoragetypeIdEdit((Integer) object[0]);
				storagetypeDisplay.setStoragetypeEdit((String) object[1]);
				
				storagetypesList.add(storagetypeDisplay);

			}
			request.setAttribute("storagetypeValues", storagetypesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("storagetypeAdd", storagetypeDisplay);
		return "storagetypeHome";
		
	}

	@RequestMapping(value = "/storagetypeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateStorageType(@ModelAttribute("storagetypeAdd") StorageType storagetype,
			HttpServletRequest request, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId=0l;
		try {
			duplicateId=storagetypeService.updateDuplicateCheck(storagetype.getStoragetypeEdit(),storagetype.getStoragetypeIdEdit());
			
			if(duplicateId==0)
			{
			storagetype.setStoragetypeId(storagetype.getStoragetypeIdEdit());
			storagetype.setStoragetype(storagetype.getStoragetypeEdit());
				

			String msg = storagetypeService.updateStorageType(storagetype);

			if (msg.equals("S")) {
				request.setAttribute("storagetypeUpadteSuccess",
						"StorageType Details Updated Successfully");
			}
			else
			{
								
				request.setAttribute("storagetypeUpadteFail",
						"StorageType Details has Not Updated");
				return"storagetypeHome";
			}
			}
			else
			{
				request.setAttribute("storagetypeEditDuplicate","StorageType Name Already exist");
				request.setAttribute("storagetypeValues","hello");
				
				return"storagetypeHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("storagetypeAdd", new StorageType());
		
		return "storagetypeHome";

	}
	@RequestMapping(value = "/storagetypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView storagetypeDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int storagetypeId= 0;
		
		
		String delmsg1 = null; 
		String delmsg2 = null; 
		HttpSession session=null;
		try {
			storagetypeId = Integer.parseInt(request.getParameter("storagetypeIdDelete"));
			String msg = storagetypeService.storagetypeDelete(storagetypeId);
			
			String delmsg = msg;
			String[] delmsgpart = delmsg.split(",");
			 delmsg1 = delmsgpart[0]; 
		delmsg2 = delmsgpart[1]; 
			if (delmsg1.equals("S"))
			{
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","assertType","ROW" ,String.valueOf(storagetypeId),"1",modifiedDate,session.getAttribute("userName").toString());
					request.setAttribute("storageDel",
						"StorageType "+delmsg2+" Deleted Successfully");
			}
			else
			{
				request.setAttribute("storageDelFail",
						"storagetype "+delmsg2+" Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("storageDelFail",
					"storagetype "+delmsg2+" Did Not Deleted");
		}
		return new ModelAndView("storagetypeHome", "storagetypeAdd", new StorageType());
	}
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name="storageTypeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
}
