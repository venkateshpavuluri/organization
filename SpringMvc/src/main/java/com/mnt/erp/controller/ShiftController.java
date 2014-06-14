package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0   
 */
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ShiftService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
@Scope("request")
public class ShiftController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	ShiftService shiftService;
	@Autowired
	MenuService menuService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession session;

	@RequestMapping(value = "/shiftHome", method = RequestMethod.GET)
	public String getShift(@ModelAttribute ShiftBean shiftBean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("shiftHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("Shift", shiftBean);
		return "shiftHome";

	}

	@RequestMapping(value = "/saveShift", method = RequestMethod.POST)
	public String saveShift(@ModelAttribute("Shift") ShiftBean shiftBean,
			Model model, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		ShiftBean shiftBean2 = null;
		String shiftsuccess = null;
		String shiftsuccessdup = null;
		List<String> list = null;
		String name = shiftBean.getShiftcode();
		Long id = 0L;

		try {
			id = shiftService.getShiftcount(name);
			if (id == 0) {
				session=request.getSession();

				msg = shiftService.saveShiftService(shiftBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				shiftBean2 = new ShiftBean();
				map.addAttribute("Shift", shiftBean2);
				if (msg.equals("S")) {
					list = new ArrayList<String>();
					list.add("$1");
					shiftsuccess = "Shift Details Data Saved Successfully";
					model.addAttribute("Shift", new ShiftBean());
				}
				else
				{
					list = new ArrayList<String>();
					list.add("$1");
					shiftsuccess = "Shift Details Not Data Saved";
					model.addAttribute("Shift", new ShiftBean());
					return "redirect:shiftHome.mnt?success=" + shiftsuccess + "&listwar="
					+ list + "";
				}
				
			} else {
				shiftsuccessdup = "Warning ! Shift Code is already exists. Please try some other name";
				shiftBean.setShifthide(1);
				request.setAttribute("shiftsuccessdup", shiftsuccessdup);
				return "shiftHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:shiftHome.mnt?success=" + shiftsuccess + "&list="
				+ list + "";

	}

	@ModelAttribute("shiftSearch")
	public Map<Integer, String> populateShiftids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = shiftService.selectShiftService();
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

	@RequestMapping(value = "/searchShift", method = RequestMethod.GET)
	public String searchshiftIds(@ModelAttribute("Shift") ShiftBean shiftBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = shiftBean.getShiftId();
			List<ShiftBean> shiftBeans = new ArrayList<ShiftBean>();
			String dbField = shiftBean.getXmlLabel();
			String operation = shiftBean.getOperations();
			String basicSearchId = shiftBean.getBasicSearchId();

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
				list = shiftService.searchShiftService();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					ShiftBean shiftBean2 = new ShiftBean();
					shiftBean2.setShiftId((Integer) obj[0]);
					shiftBean2.setShiftcode((String) obj[1]);
					shiftBean2.setShift((String) obj[2]);
					shiftBean2.setStarttime((String) obj[3]);
					shiftBean2.setEndtime((String) obj[4]);
					shiftBean2.setWorkhrs((String) obj[5]);
					shiftBeans.add(shiftBean2);
				}

			} else {

				list = shiftService.basicSearchAccoutGroup(dbField, operation,
						basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					ShiftBean shiftBean2 = new ShiftBean();
					shiftBean2.setShiftId((Integer) obj[0]);
					shiftBean2.setShiftcode((String) obj[1]);
					shiftBean2.setShift((String) obj[2]);
					shiftBean2.setStarttime((String) obj[3]);
					shiftBean2.setEndtime((String) obj[4]);
					shiftBean2.setWorkhrs((String) obj[5]);
					shiftBeans.add(shiftBean2);
				}
			}
			request.setAttribute("shiftBeans", shiftBeans);
			// model.addAttribute("Shift", new ShiftBean());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "shiftHome";
	}

	@RequestMapping(value = "/shiftEdit", method = RequestMethod.GET)
	public String editShift(@ModelAttribute("Shift") ShiftBean shiftBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("shiftedit"));

		try {
			List<ShiftBean> shiftBeans = new ArrayList<ShiftBean>();
			list = shiftService.searchShiftServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				shiftBean.setShiftIdedit((Integer) obj[0]);
				shiftBean.setShiftcodeedit((String) obj[1]);
				shiftBean.setShiftedit((String) obj[2]);
				shiftBean.setStarttimeedit((String) obj[3]);
				shiftBean.setEndtimeedit((String) obj[4]);
				shiftBean.setWorkhrsedit((String) obj[5]);
				shiftBeans.add(shiftBean);
			}
			request.setAttribute("editvalues", shiftBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "shiftHome";

	}

	@RequestMapping(value = "/shiftUpdate", method = RequestMethod.POST)
	public String updateshift(@ModelAttribute("Shift") ShiftBean shiftBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = shiftBean.getShiftcodeedit();
		int shiftid = shiftBean.getShiftIdedit();
		Long id = 0l;
		String shiftsuccessdupedit = null;
		try {
			id = shiftService.getShiftcountedit(name, shiftid);

			if (id == 0) {
				shiftBean.setShiftId(shiftBean.getShiftIdedit());
				shiftBean.setShiftcode(shiftBean.getShiftcodeedit());
				shiftBean.setShift(shiftBean.getShiftedit());
				shiftBean.setStarttime(shiftBean.getStarttimeedit());
				shiftBean.setEndtime(shiftBean.getEndtimeedit());
				shiftBean.setWorkhrs(shiftBean.getWorkhrsedit());
				String message = shiftService.updateShiftService(shiftBean);
				if (message.equals("S")) {
					request.setAttribute("ShiftUpdate",
							"Shift Details Data Updated Successfully");
					model.addAttribute("Shift", new ShiftBean());
				}
				else
				{
					request.setAttribute("ShiftUpdateError",
							"Shift Details Data Updated Successfully");
				}

			} else {
				shiftsuccessdupedit = "Warning ! Shift Code is already exists. Please try some other name";
				shiftBean.setShiftdupedit(1);
				request.setAttribute("shiftsuccessdupedit", shiftsuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "shiftHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "shiftHome";
	}

	@RequestMapping(value = "/shiftDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView shiftDetailsDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		try {
			Id = Integer.parseInt(request.getParameter("shiftdelete"));

			String msg = shiftService.deleteShiftService(Id);
			if (msg.equals("S"))
			{
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Shift","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				request.setAttribute("ShiftDelete",
						"ShiftDetails Deleted Successfully");
			}
			else
			{
				request.setAttribute("ShiftDeleteError",
						"ShiftDetails Deleted Successfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("shiftHome", "Shift", new ShiftBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "shiftId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
