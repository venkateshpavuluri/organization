/**
@copyright MNTSOFT
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
import com.mnt.erp.bean.ReasonForMovement;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ReasonForMovementService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 30-10-2013
 * @build 0.0
 *
 */
@Controller
@Scope("request")
public class ReasonForMovementController {
	
	@Autowired
	ReasonForMovementService rfmService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession session;
	
	
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name="reasonForMovementId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/RFM", method = RequestMethod.GET)
	public ModelAndView getRFM(HttpServletRequest request,HttpServletResponse response) 
	{
		response.setCharacterEncoding("UTF-8");
		 session=request.getSession(false);
		List<String> list=menuService.getPrivilige("RFM.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		
		return new ModelAndView("rfmHome", "rfmCommand",new ReasonForMovement());

	}
   /*=================================Add Method=======================================*/
	
	@RequestMapping(value = "/RFMovement", method = RequestMethod.POST)
	public String addRFM(@ModelAttribute("rfmCommand") ReasonForMovement rfmAdd,HttpServletRequest request,HttpServletResponse response,Model model)
	{
		    response.setCharacterEncoding("UTF-8");
	        List<String> list=new ArrayList<String>();
			String msg = null;
			String rfmUpadte=null; 
			String checkReasonForMovement=rfmAdd.getReasonForMovement();
			int list1=rfmService.checkDuplicate(checkReasonForMovement);
			if(list1==0)
			{
			
				try 
				{
					
					ReasonForMovement rfm = new ReasonForMovement();
					rfm.setReasonForMovement(request.getParameter("reasonForMovement"));
				    msg=rfmService.addReasonForMovement(rfm);
				    if(msg.equals("S"))
				    {
				    	model.addAttribute("rfmCommand",new ReasonForMovement());
				    	session=request.getSession(false);
				    	Date date = new Date();
						String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Reason For Movement","ROW" ,String.valueOf(rfmAdd.getReasonForMovementId()),"1",modifiedDate,session.getAttribute("userName").toString());
			return "redirect:RFM.mnt?list="+"success"+"";
				    }
				    else
				    {
				    	model.addAttribute("rfmCommand",new ReasonForMovement());
				    	return "redirect:RFM.mnt?list="+"fail"+"";
				    }
				}
				catch (Exception e) 
				{
					e.printStackTrace();
					return "redirect:RFM.mnt?list="+"fail"+"";
				}
			}
			else
			{

				 rfmAdd.setAid(1);
		         request.setAttribute("addRFMDuplicate","Reason For Movement is Already Exists Please try some other name");
		         return "rfmHome";
			}
   }
	/*=================================Search Method=======================================*/
	@RequestMapping(value = "/rfmSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchRFM(@ModelAttribute("rfmCommand") ReasonForMovement rfmSearch,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) 
	{
		response.setCharacterEncoding("UTF-8");
		List<ReasonForMovement> rfMovement = null;
		List<Object[]> list = null;
		
		try 
		{
			String dbField = rfmSearch.getXmlLabel();
			String operation = rfmSearch.getOperations();
			String basicSearchId = rfmSearch.getBasicSearchId();
			
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
			if (basicSearchId =="")
			{
				
				list = rfmService.searchReasonForMovement();
				rfMovement = new ArrayList<ReasonForMovement>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					ReasonForMovement rfmList = new ReasonForMovement();
					rfmList.setReasonForMovementId((Integer)objects[0]);
					rfmList.setReasonForMovement((String)objects[1]);
					rfMovement.add(rfmList);
				}
				
			} 
			else
			{
				list = rfmService.basicSearchRFM(dbField, operation,
						basicSearchId);
				rfMovement = new ArrayList<ReasonForMovement>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					ReasonForMovement rfmList = new ReasonForMovement();
					rfmList.setReasonForMovementId((Integer)objects[0]);
					rfmList.setReasonForMovement((String) objects[1]);
					rfMovement.add(rfmList);
				}
				if (rfMovement!=null) {
					request.setAttribute("rfmSearchNoData",
							"Nothing found to display");
				}
			}
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("rfmHome");
		modelAndView.addObject("rfmCommand");
		request.setAttribute("rfmSearch",rfMovement);
		return modelAndView;
	}
	/*=================================Edit Method=======================================*/
	@RequestMapping(value = "/reasonForMovementIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String rfmEdit(@ModelAttribute ReasonForMovement rfmEdit,BindingResult result, HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("reasonForMovementIdEdit"));
		List<Object[]> list = null;
		List<ReasonForMovement> rfMovement=new ArrayList<ReasonForMovement>();
		Object[] objects = null;
		try
		{

			list = rfmService.searchReasonForMovementWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) 
			{
				objects = (Object[]) iterator.next();
				rfmEdit.setReasonForMovementIdEditt((Integer)objects[0]);
				rfmEdit.setReasonForMovementEditt((String)objects[1]);
				
				
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
		rfMovement.add(rfmEdit);
		request.setAttribute("list",rfMovement);
		model.addAttribute("rfmCommand",rfmEdit);

		return "rfmHome";
	}
	/*=================================Update Method=======================================*/
	@RequestMapping(value = "/rfmEdit", method = RequestMethod.POST)
	public String updateRFM(@ModelAttribute("rfmCommand") ReasonForMovement rfmUpdate,HttpServletRequest request,HttpServletResponse response,Model model) 
	{
		    response.setCharacterEncoding("UTF-8");
		    String msg = null;
			int chekId=rfmUpdate.getReasonForMovementIdEditt();
			String checkReasonForMovement=rfmUpdate.getReasonForMovementEditt();
			int list1=rfmService.checkEditDuplicate(checkReasonForMovement,chekId);
			if(list1==0)
			{
			
				try 
				{
					rfmUpdate.setReasonForMovementId(rfmUpdate.getReasonForMovementIdEditt());
					rfmUpdate.setReasonForMovement(rfmUpdate.getReasonForMovementEditt());
					 msg= rfmService.updateReasonForMovement(rfmUpdate);
					if(msg.equals("S"))
					{
					request.setAttribute("rfmUpadte","Reason For Movement Data Updated Successfully ");
				} 
				else
				{
					request.setAttribute("rfmUpadteError","Reason For Movement Data did not Updated ");
				}
				}
				catch (Exception e)
				{
					request.setAttribute("rfmUpadteError","Reason For Movement Data did not Updated ");
					e.printStackTrace();
				}
				
				model.addAttribute("rfmCommand",new ReasonForMovement());
				return "rfmHome";
			}
			else
			{
				request.setAttribute("list","RFM");
				request.setAttribute("addRFMDuplicate","Reason For Movement is Already Exists Please try some other name");
	            return "rfmHome";
			}
           
	}
	/*=================================Delete Method=======================================*/
	@RequestMapping(value = "/reasonForMovementIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteRFM(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		int RFMId = 0;
		try 
		{
			RFMId = Integer.parseInt(request.getParameter("reasonForMovementIdDelete"));
			 String msg=rfmService.deleteReasonForMovement(RFMId);
			 if(msg.equals("S"))
			 {
			 request.setAttribute("rfmDelete","Reason For Movement Data Deleted Successfully");
			 session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Reason For Movement","ROW" ,String.valueOf(RFMId),"1",modifiedDate,session.getAttribute("userName").toString());
			 }
			 else
			 {
				 request.setAttribute("rfmDeleteError","Reason For Movement Data did not Deleted");
			 }

		} 
		catch (Exception e)
		{
			 request.setAttribute("rfmDeleteError","Reason For Movement Data did not Deleted");
			e.printStackTrace();
		}
		return new ModelAndView("rfmHome", "rfmCommand",new ReasonForMovement());
	}




}
