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


import com.mnt.erp.bean.EmploymentType;


import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class EmploymentTypeController {
	List<Object[]>list=null;
	Iterator<Object[]> iterator = null;
	@Autowired
        ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	
	HttpSession session;
	
	@RequestMapping(value = "/employmenttypeHome", method = RequestMethod.GET)
	public String getET(
			@ModelAttribute EmploymentType etbean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		 session=request.getSession(false);
			List<String> list=menuService.getPrivilige("employmenttypeHome.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
		
		model.addAttribute("EmploymentTypeCMD", new EmploymentType());

		return "employmenttypeHome";
	}

	@RequestMapping(value = "/saveET", method = RequestMethod.POST)
	public String saveET(
			@ModelAttribute("EmploymentTypeCMD")  EmploymentType etbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		int msg = 0;
		EmploymentType etbean1 = null;
		String ETsuccess = null;
		String ETsuccessdup = null;
		//List<String> list = null;
		String name = etbean.getEmploymenttype();
		Long id = 0L;
		try {
			id = erpDao.duplicateCheck("select count(*) from EmploymentType ab where ab.employmenttype='"
					+ name + "'");
			
			if (id == 0) {

				msg=erpDao.saveDetails(etbean);
				etbean1 = new EmploymentType();
               map.addAttribute("EmploymentTypeCMD", etbean1);
				if (msg>=1) {
					
					Date date = new Date();
					session=request.getSession(false);
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Employeement Type","ROW" ,String.valueOf(etbean.getEmploymenttypeid()),"1",modifiedDate,session.getAttribute("userName").toString());
					
					return "redirect:employmenttypeHome.mnt?list="+"success";
				}
				else {
					return "redirect:employmenttypeHome.mnt?listwar="+"fail";
				}
			}

			else {
				ETsuccessdup = "Warning ! Employment Type is already exists. Please try some other name ";
				etbean.setEthide(1);
				request.setAttribute("ETsuccessdup",ETsuccessdup);
				return "employmenttypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:employmenttypeHome.mnt?listwar="+"fail";
		}
		

	}
	@RequestMapping(value = "/searchET", method = RequestMethod.GET)
	public String searchET(
			@ModelAttribute("EmploymentTypeCMD") EmploymentType etbean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = etbean.getEmploymenttypeid();
			List<EmploymentType> ebeans = new ArrayList<EmploymentType>();
			String dbField = etbean.getXmlLabel();
			String operation = etbean.getOperations();
			String basicSearchId = etbean.getBasicSearchId();

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
			 list=	erpDao.searchDetails("select ag.employmenttypeid,ag.employmenttype from EmploymentType ag order by ag.employmenttype ");
			
			 iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmploymentType ETbean = new EmploymentType();
					ETbean.setEmploymenttypeid((Integer)obj[0]);
					ETbean.setEmploymenttype((String)obj[1]);
					ebeans.add(ETbean);

				}

			} else {
				list =erpDao.searchDetails("select ag.employmenttypeid,ag.employmenttype from EmploymentType ag where ag."
					+ dbField + "" + operation + "'"+basicSearchId+"' order by ag.employmenttype ");
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					EmploymentType ETbean = new EmploymentType();
					ETbean.setEmploymenttypeid((Integer)obj[0]);
					ETbean.setEmploymenttype((String)obj[1]);
					ebeans.add(ETbean);
				}
			}
			request.setAttribute("etbeans", ebeans);
			/* model.addAttribute("EmploymentTypeCMD", new EmploymentType());*/
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "employmenttypeHome";
	}

	@RequestMapping(value = "/ETEdit", method = RequestMethod.GET)
	public String editET(
			@ModelAttribute("EmploymentTypeCMD") EmploymentType etbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("etedit"));

		try {
			List<EmploymentType> etbeans = new ArrayList<EmploymentType>();
			list = erpDao.searchDetails("select ag.employmenttypeid,ag.employmenttype from EmploymentType ag where ag.employmenttypeid="
					+ id + "");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				etbean.setEmploymenttypeidedit((Integer)obj[0]);
				etbean.setEmploymenttypeedit((String)obj[1]);
				etbeans.add(etbean);
			}
			request.setAttribute("editvalues", etbeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "employmenttypeHome";

	}

		@RequestMapping(value = "/ETUpdate", method = RequestMethod.POST)
	public String updateET(
			@ModelAttribute("EmploymentTypeCMD") EmploymentType etbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = etbean.getEmploymenttypeedit();
		int imid = etbean.getEmploymenttypeidedit();
		Long iid = 0l;
		String ETdupedit = null;
		try {
			iid =erpDao.duplicateCheck("select count(*) from EmploymentType ab where ab.employmenttype='"
					+ name + "'and ab.employmenttypeid!='" + imid + "'");
			if (iid == 0) {
				etbean.setEmploymenttypeid(etbean.getEmploymenttypeidedit());
				etbean.setEmploymenttype(etbean.getEmploymenttypeedit());

				int message = erpDao.updateDetails(etbean);
				if (message==1) {
					request.setAttribute("ETUpdate","Employment Type Data Updated Successfully");
				}
				else
				{
					request.setAttribute("ETUpdateFail","Employment Type did not Data Updated");
				}
			} else {
				ETdupedit = "Warning ! Employment Type is already exists. Please try some other name ";
				etbean.setEthideedit(1);
				request.setAttribute("ETdupedit",ETdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "employmenttypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("EmploymentTypeCMD", new EmploymentType());
		return "employmenttypeHome";
	}

	@RequestMapping(value = "/ETDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView ETDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		try {
			Id = Integer.parseInt(request.getParameter("etdelete"));
			EmploymentType ETbean=new EmploymentType();
			ETbean.setEmploymenttypeid(Id);
			int msg = erpDao.deleteDetails(ETbean);
			if (msg==1)
			{
				Date date = new Date();
				session=request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Employeement Type","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("ETDelete",
						"Employment Type  Data is Deleted Successfully");
			}
			else
			{
				request.setAttribute("ETDeleteFail",
						"Employment Type  Data is did not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ETDeleteFail",
					"Employment Type  Data is did not Deleted");
			return new ModelAndView("employmenttypeHome", "EmploymentTypeCMD",
					new EmploymentType());
		}
		return new ModelAndView("employmenttypeHome", "EmploymentTypeCMD",
				new EmploymentType());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "employmenttypeid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
