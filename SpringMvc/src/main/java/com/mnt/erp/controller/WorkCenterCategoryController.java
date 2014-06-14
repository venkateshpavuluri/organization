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

import com.mnt.erp.bean.WorkCenterCategory;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.WorkCenterCategoryService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 28-10-2013
 * @build 0.0
 *
 */
@Controller
@Scope("request")
public class WorkCenterCategoryController
{
	@Autowired
	WorkCenterCategoryService wcService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name="workCenterCategoryId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/WCCategory", method = RequestMethod.GET)
	public ModelAndView getWCCategory(HttpServletRequest request,HttpServletResponse response) 
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("WCCategory.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		
		return new ModelAndView("wccHome", "wccCommand",new WorkCenterCategory());

	}
   /*=================================Add Method=======================================*/
	
	@RequestMapping(value = "/wcCategory", method = RequestMethod.POST)
	public String addWCCategory(@ModelAttribute("wccCommand") WorkCenterCategory wccAdd,HttpServletRequest request,HttpServletResponse response,Model model)
	{
		    response.setCharacterEncoding("UTF-8");
			String msg = null;
			String res=null;
			HttpSession session=null;
			String checkWCCategory=wccAdd.getWorkCenterCategory();
			int list1=wcService.checkDuplicate(checkWCCategory);
			if(list1==0)
			{
			
				try 
				{
					session=request.getSession(false);
					WorkCenterCategory wcCategory = new WorkCenterCategory();
					wcCategory.setWorkCenterCategory(request.getParameter("workCenterCategory"));
				    msg=wcService.addWorkCenterCategory(wcCategory,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
					if(msg.equals("S"))
					{
						res = "redirect:WCCategory.mnt?list=" + "success" + "";
					}
					
					else{
						res = "redirect:WCCategory.mnt?listwar=" + "fail" + "";
					}
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
			else
			{
				
				 wccAdd.setAid(1);
		         request.setAttribute("addWCDuplicate","Work Center Category is Already Exists Please try some other name");
		         return "wccHome";
			}
			return res;
   }
	/*=================================Search Method=======================================*/
	@RequestMapping(value = "/wccSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchWCCategory(@ModelAttribute("wccCommand") WorkCenterCategory wccSearch,BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response) 
	{
		response.setCharacterEncoding("UTF-8");
		List<WorkCenterCategory> wcCat = null;
		List<Object[]> list = null;
		
		try 
		{
			String dbField = wccSearch.getXmlLabel();
			String operation = wccSearch.getOperations();
			String basicSearchId = wccSearch.getBasicSearchId();
			
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
				
				list = wcService.searchWorkCenterCategory();
				wcCat = new ArrayList<WorkCenterCategory>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					WorkCenterCategory wccList = new WorkCenterCategory();
					wccList.setWorkCenterCategoryId((Integer)objects[0]);
					wccList.setWorkCenterCategory((String)objects[1]);
					wcCat.add(wccList);
				}

			} 
			else
			{
				list = wcService.basicSearchWCC(dbField, operation,
						basicSearchId);
				wcCat = new ArrayList<WorkCenterCategory>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) 
				{
					Object[] objects = (Object[]) iterator.next();
					WorkCenterCategory wccList = new WorkCenterCategory();
					wccList.setWorkCenterCategoryId((Integer)objects[0]);
					wccList.setWorkCenterCategory((String) objects[1]);
					wcCat.add(wccList);
				}

			}
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("wccHome");
		modelAndView.addObject("wccCommand");
		request.setAttribute("wcCategorySearch",wcCat);
		return modelAndView;
	}
	/*=================================Edit Method=======================================*/
	@RequestMapping(value = "/wcCategoryIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String wcCategoryEdit(@ModelAttribute WorkCenterCategory wccEdit,BindingResult result, HttpServletRequest request,HttpServletResponse response,Model model)
	{
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("wcCategoryIdEdit"));
		List<Object[]> list = null;
		List<WorkCenterCategory> wcCategory=new ArrayList<WorkCenterCategory>();
		Object[] objects = null;
		try
		{

			list = wcService.searchWorkCenterCategoryWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) 
			{
				objects = (Object[]) iterator.next();
				wccEdit.setWorkCenterCategoryIdEditt((Integer)objects[0]);
				 wccEdit.setWorkCenterCategoryEditt((String)objects[1]);
				
				
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
		wcCategory.add(wccEdit);
		request.setAttribute("list",wcCategory);
		model.addAttribute("wccCommand",wccEdit);

		return "wccHome";
	}
	/*=================================Update Method=======================================*/
	@RequestMapping(value = "/wcCategoryEdit", method = RequestMethod.POST)
	public String updateWCCategory(@ModelAttribute("wccCommand") WorkCenterCategory wccUpdate,HttpServletRequest request,HttpServletResponse response,Model model) 
	{
		    response.setCharacterEncoding("UTF-8");
		    String msg = null;
			int chekId=wccUpdate.getWorkCenterCategoryIdEditt();
			String checkWCCategory=wccUpdate.getWorkCenterCategoryEditt();
			int list1=wcService.checkEditDuplicate(checkWCCategory,chekId);
			if(list1==0)
			{
			
				try 
				{
					wccUpdate.setWorkCenterCategoryId(wccUpdate.getWorkCenterCategoryIdEditt());
					wccUpdate.setWorkCenterCategory(wccUpdate.getWorkCenterCategoryEditt());
					 msg= wcService.updateWorkCenterCategory(wccUpdate);
					if(msg.equals("S")){
					request.setAttribute("wcCategoryUpadte","Work Center Category has been updated");
					}
					else{
						request.setAttribute("wcCategoryUpadteError","Work Center Category has not been updated");
					}
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				model.addAttribute("wccCommand",new WorkCenterCategory());
				return "wccHome";
			}
			else
			{
				request.setAttribute("list","WCC");
				request.setAttribute("addWCCDuplicate","Work Center Category is Already Exists Please try some other name");
	            return "wccHome";
			}
           
	}
	/*=================================Delete Method=======================================*/
	@RequestMapping(value = "/wcCategoryIdDelete", method = RequestMethod.GET)
	public ModelAndView deleteWCCategory(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		try 
		{
			id = Integer.parseInt(request.getParameter("wcCategoryIdDelete"));
			 String msg=wcService.deleteWorkCenterCategory(id);
			 if(msg.equals("S")){
				 
				 request.setAttribute("wcCategoryDelete","Work Center Category has been deleted");
				 session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Code Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				 
			 }
			 else{
				 
				 request.setAttribute("wcCategoryDeleteError","Work Center Category has not been deleted"); 
			 }

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("wccHome", "wccCommand",new WorkCenterCategory());
	}


}
