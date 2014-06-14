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

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.Holiday;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 *
 */
@Controller
public class HolidayController {
	
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String sql;

	@Autowired 
	ERPDao dao;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;
	
	@Autowired
	XmlLabelsService xmlService;

	@RequestMapping(value = "/holidayHome", method = RequestMethod.GET)
	public String getHoliday(
			@ModelAttribute Holiday holiday,
			SessionStatus status, Model model,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		 session=request.getSession(false);
			List<String> list=menuService.getPrivilige("holidayHome.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
		model.addAttribute("holiday", new Holiday());

		return "holidayView";
	}

	@RequestMapping(value = "/holidayAdd", method = RequestMethod.POST)
	@RequestScoped
	public String saveHolidays(
			
			@ModelAttribute("holiday") Holiday holiday,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		int mess = 0;

		String liSuccess = null;
		String AGSuccessdup = null;
		List<String> list = null;
		Long id = 0L;
		try {
			sql="select count(*) from Holiday o where  o.holidayName='" + holiday.getHolidayName()
					+ "'";
			id =dao.duplicateCheck(sql);
		
			if (id == 0) {
				 mess=dao.saveDetails(holiday);
				map.addAttribute("holiday", holiday);
				if (mess!=0) {
					 Date date = new Date();
						session=request.getSession(false);
						String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Holiday","ROW" ,String.valueOf(holiday.getHolidayId()),"1",modifiedDate,session.getAttribute("userName").toString());
					model.addAttribute("holiday", new Holiday());
					return "redirect:holidayHome.mnt?list="+ "success" + "";
				}
				else
				{
					return "redirect:holidayHome.mnt?listwar="+ "fail" + "";
				}
			} else {
				AGSuccessdup = "Warning ! Holiday is already exists. Please try some other name";
			
				holiday.setAid(1);
				request.setAttribute("AGSuccessdup", AGSuccessdup);
				return "holidayView";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:holidayHome.mnt?listwar="+ "fail" + "";
		}

	}

	@RequestMapping(value = "/searchholiday", method = RequestMethod.GET)
	public String searchHolidays(
			@ModelAttribute("holiday") Holiday holiday,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<Holiday> holidays =null;
		try {
			String iid = holiday.getHolidayName();
			holidays = new ArrayList<Holiday>();
			String dbField = holiday.getXmlLabel();
			String operation = holiday.getOperations();
			String basicSearchId = holiday.getBasicSearchId();
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
sql="select ag.holidayId,ag.holidayDate,ag.holidayName from Holiday ag order by ag.holidayName";
				list =dao.searchDetails(sql);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Holiday holidaysearch = new Holiday();
					holidaysearch.setHolidayId((Integer)obj[0]);
					holidaysearch.setHolidayDate((String)obj[1]);
					holidaysearch.setHolidayName((String)obj[2]);
					
					holidays.add(holidaysearch);
				}

			} else {

				
sql = "select ag.holidayId,ag.holidayDate,ag.holidayName  from Holiday ag where ag."
						+ dbField + ""+operation +"'"+ basicSearchId+"'";

				list = dao.searchDetails(sql);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Holiday holidaysearch = new Holiday();
					holidaysearch.setHolidayId((Integer)obj[0]);
					holidaysearch.setHolidayDate((String)obj[1]);
					holidaysearch.setHolidayName((String)obj[2]);
					holidays.add(holidaysearch);
				}

			}
			request.setAttribute("holidayValues", "holidayValues");
			request.setAttribute("holidayBeans", holidays);
		
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "holidayView";
	}



	@RequestMapping(value = "/holidayedit", method = RequestMethod.GET)
	public String editHoliday(
			@ModelAttribute("holiday") Holiday holiday,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("holidayedit"));

		try {
			
			sql="select ag.holidayId,ag.holidayDate,ag.holidayName from Holiday ag where ag.holidayId='"+id+"'";
			
			list=dao.searchDetails(sql);
			
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				
			
				holiday.setHolidayId((Integer)obj[0]);
				holiday.setHolidayDate((String)obj[1]);
				holiday.setHolidayName((String)obj[2]);
				
			
			}
			request.setAttribute("editvalues","df");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "holidayView";

	}

	@RequestMapping(value = "/holidayUpdate", method = RequestMethod.POST)
	public String updateHoliday(
			@ModelAttribute("holiday") Holiday holiday,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String holidayName =holiday.getHolidayName();
		int holidayId = holiday.getHolidayId();
	
		String AGSuccessdupedit = null;

		Long id = 0L;
		try {
		sql = "select count(*) from Holiday ab where ab.holidayName='"
					+ holidayName + "'and ab.holidayId!='" + holidayId + "'";
			id =dao.duplicateCheck(sql);

			if (id == 0) {
				int message =dao.updateDetails(holiday);

				if (message!=0) {
					request.setAttribute("holidayUpdate",
							"Holiday Data Updated Successfully");
				
				}
				else
				{
					request.setAttribute("holidayUpdateFail",
							"Holiday Data Updated Successfully");
				
				
				}
			} else {
				AGSuccessdupedit = "Warning ! Holiday is already exists. Please try some other name";
		
				request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "holidayView";
			}
			model.addAttribute("holiday",new Holiday());
		} catch (Exception e) {
			e.printStackTrace();
			return "holidayView";
		}
		return "holidayView";
	}

	@RequestMapping(value = "/holidayDelete", method = RequestMethod.GET)
	public String holidayDelete(HttpServletRequest request,HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		int groupId = 0;
		try {
			groupId = Integer.parseInt(request
					.getParameter("holidayDelete"));
			Holiday holiday=new Holiday();
			holiday.setHolidayId(groupId);

			int  msg =dao.deleteDetails(holiday);
			if (msg!=0)
			{
				 Date date = new Date();
					session=request.getSession(false);
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Holiday","ROW" ,String.valueOf(groupId),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("holidayDelete",
						"holiday Data is Deleted Successfully");
			}
			else
			{
				request.setAttribute("holidayDeleteFail",
						"holiday Data is Did not Deleted");
				
			}
		} catch (Exception e) {
			request.setAttribute("holidayDeleteFail","holiday Data is Did not Deleted");
			e.printStackTrace();
		}
		model.addAttribute("holiday",new Holiday());
		return "holidayView";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "holidayId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
