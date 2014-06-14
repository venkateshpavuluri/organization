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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.BreakTimeBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.ProcessTypeBean;
import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BreakTimeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.ShiftService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author devi
 *
 */
@Controller
public class BreakTimeController {
	Logger logger=Logger.getLogger(BreakTimeController.class);
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	ShiftService shiftService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	BreakTimeService breakService;
	@Autowired
	MenuService menuService;
	@Autowired
	OrganizationService organizationService;
	@Autowired
	ERPDao dao;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession session;
	
	@RequestMapping(value = "/BreakTime", method = RequestMethod.GET)
	public String getBrTime(@ModelAttribute BreakTimeBean btBean,
			SessionStatus status, Model model, HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("BreakTime.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
				System.out.println("list"+list.size());
		model.addAttribute("BreakTime", btBean);
		return "BTHome";

	}
	@RequestMapping(value = "/addBRTime", method = RequestMethod.POST)
	public String saveBrTime(@ModelAttribute("BreakTime") BreakTimeBean breakBean,
			Model model, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus) {
		response.setCharacterEncoding("UTF-8");
		String msg,res = null;
		
		String breaksuccessdup = null;
		List<String> list = null;
		String name = breakBean.getBreakTimecode();
		Long id = 0L;

		try {
			id = breakService.getBreakTimecount(name);
			if (id == 0) {
				session=request.getSession(false);
				msg = breakService.saveBreakTime(breakBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				 
				
				if (msg.equals("S")) 
					res = "redirect:BreakTime.mnt?list=" + "success" + "";
					
				else
					res = "redirect:BreakTime.mnt?listwar=" + "fail" + "";
				
			} else {
				breaksuccessdup = "Warning ! Shift Code is already exists. Please try some other name";
				breakBean.setBreakhide(1);
				request.setAttribute("shiftsuccessdup", breaksuccessdup);
				return "BTHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:BreakTime.mnt?listwar=" + "fail" + "";
		}

		return res;

	}
	@ModelAttribute("shift")
	public Map<Integer, String> shift() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = breakService.selectshiftservice();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	@ModelAttribute("organization")
	public Map<Integer, String> org() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = breakService.selectorgservice();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	@RequestMapping(value = "/searchBRTime", method = RequestMethod.GET)
	public String searchBrTimeIds(@ModelAttribute("BreakTime") BreakTimeBean breakBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = breakBean.getBreakTimeId();
			List<BreakTimeBean> btBeans = new ArrayList<BreakTimeBean>();
			String dbField = breakBean.getXmlLabel();
			String operation = breakBean.getOperations();
			String basicSearchId = breakBean.getBasicSearchId();
            
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
				list = breakService.searchBreakTimeService();
				
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					BreakTimeBean btbean2 = new BreakTimeBean();
					btbean2.setBreakTimeId((Integer) obj[0]);
					btbean2.setBreakTimecode((String) obj[1]);
					btbean2.setStarttime((String) obj[2]);
					btbean2.setEndtime((String) obj[3]);
					btbean2.setLength((String) obj[4]);
					ShiftBean sbean=((ShiftBean)obj[5]);
					btbean2.setShift(sbean.getShift());
					Organization orgbean=((Organization)obj[6]);
					btbean2.setOrganization(orgbean.getOrgName());
					btBeans.add(btbean2);
				}

			} else {

				list = breakService.basicSearchBreakTime(dbField, operation,basicSearchId);
				
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					BreakTimeBean btbean2 = new BreakTimeBean();
					btbean2.setBreakTimeId((Integer) obj[0]);
					btbean2.setBreakTimecode((String) obj[1]);
					btbean2.setStarttime((String) obj[2]);
					btbean2.setEndtime((String) obj[3]);
					btbean2.setLength((String) obj[4]);
					ShiftBean sbean=((ShiftBean)obj[5]);
					btbean2.setShift(sbean.getShift());
					Organization orgbean=((Organization)obj[6]);
					btbean2.setOrganization(orgbean.getOrgName());
				
					btBeans.add(btbean2);
				}
			}
			request.setAttribute("breakBeans", btBeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "BTHome";
	}
	
	@RequestMapping(value = "/breakTimeEdit", method = RequestMethod.GET)
	public String editBrTime(@ModelAttribute("BreakTime") BreakTimeBean brBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("breakedit"));

		try {
			List<BreakTimeBean> brBeans = new ArrayList<BreakTimeBean>();
			list = breakService.searchBreakTimeServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				brBean.setBreakTimeIdEdit((Integer) obj[0]);
				brBean.setBreakTimecodeEdit((String) obj[1]);
				brBean.setStarttimeEdit((String) obj[2]);
				brBean.setEndtimeEdit((String) obj[3]);
				brBean.setLengthEdit((String) obj[4]);
				brBean.setShiftEdit((String) obj[5]);
				brBean.setOrganizationEdit((String) obj[6]);
				brBeans.add(brBean);
			}
			request.setAttribute("editvalues", brBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "BTHome";

	}
	@RequestMapping(value = "/breakUpdate", method = RequestMethod.POST)
	public String updateBrTime(@ModelAttribute("BreakTime") BreakTimeBean brBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = brBean.getBreakTimecodeEdit();
		int breakId = brBean.getBreakTimeIdEdit();
		
		Long id = 0l;
		
		String BreakTimeUpdate=null;
		try {
			id = breakService.getBreakTimecountedit(name, breakId);

			if (id == 0) {
				brBean.setBreakTimeId(brBean.getBreakTimeIdEdit());
				brBean.setBreakTimecode(brBean.getBreakTimecodeEdit());
				brBean.setStarttime(brBean.getStarttimeEdit());
				brBean.setEndtime(brBean.getEndtimeEdit());
				brBean.setLength(brBean.getLengthEdit());
				brBean.setShift(brBean.getShiftEdit());
				brBean.setOrganization(brBean.getOrganizationEdit());
					   dao.updateDetails(brBean);
					   
			   request.setAttribute("breakTimeUpdate", "Break Time Details Updated Successfully");
					
					
				}
			
				
			 else {
				
				 BreakTimeUpdate = "Break Time already exists choose another one";
				 logger.info("update doesn't works success");
					return "redirect:BreakTime.mnt?BreakTimeUpdate="
					+ BreakTimeUpdate + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			  request.setAttribute("breakTimeUpdateErr", "Break Time Details Doesn't Updated");

		}
		 model.addAttribute("BreakTime", new BreakTimeBean());
		return "BTHome";
	}
	@RequestMapping(value = "/breakTimeDelete", method = RequestMethod.GET)
	@RequestScoped
	public String brTimeDetailsDelete(@ModelAttribute("BreakTime") BreakTimeBean brBean,HttpServletRequest request,
			HttpServletResponse response,Model model) {
		
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		
		try {
			Id = Integer.parseInt(request.getParameter("breakdelete"));

			String msg = breakService.deleteBreakTimeService(Id);
			if (msg.equals("S")){
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Break Time","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				request.setAttribute("breakDel", "Break Time Details Deleted Successfully");
			}	else
				request.setAttribute("breakDelErr", "Break Time Details Doesn't Deleted ");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("breakDelErr", "Break Time Details Doesn't Deleted ");
		}
		 model.addAttribute("BreakTime", new BreakTimeBean());
		 return "BTHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "BreakCode";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
