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



import com.mnt.erp.bean.Education;
import com.mnt.erp.bean.Skill;

import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class EducationController {
	List<Object[]>list=null;
	Iterator<Object[]> iterator = null;
	@Autowired
        ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;
	
	@RequestMapping(value = "/educationHome", method = RequestMethod.GET)
	public String geteducation(
			@ModelAttribute Education ebean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		 session=request.getSession(false);
			List<String> list=menuService.getPrivilige("educationHome.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
		model.addAttribute("EducationCMD", new Education());

		return "educationHome";
	}
	

	@RequestMapping(value = "/saveeducation", method = RequestMethod.POST)
	public String se(
			@ModelAttribute("EducationCMD")  Education ebean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
		SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		int msg = 0;
	
	
		String educationsuccessdup = null;
		//List<String> list = null;
		String name = ebean.getEducation();
		Long id = 0L;
		try {
			id = erpDao.duplicateCheck("select count(*) from Education ab where ab.education='"
					+ name + "'");
			
			if (id == 0) {

				msg=erpDao.saveDetails(ebean);
			
	
        
				if (msg>=1) {
					Date date = new Date();
					session=request.getSession(false);
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Education","ROW" ,String.valueOf(ebean.getEducationid()),"1",modifiedDate,session.getAttribute("userName").toString());
					
					return "redirect:educationHome.mnt?list="+"success";
				}
				else {
				
					return "redirect:educationHome.mnt?listwar="+"fail";
				}
			}

			else {
				educationsuccessdup = "Warning ! Education is already exists. Please try some other name ";
				ebean.setEhide(1);
				request.setAttribute("educationsuccessdup",educationsuccessdup);
				return "educationHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:educationHome.mnt?listwar="+"fail";
		
		}
	
	}
	@RequestMapping(value = "/searcheducation", method = RequestMethod.GET)
	public String searcheducation(
			@ModelAttribute("EducationCMD") Education ebean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = ebean.getEducationid();
			List<Education> ebeans = new ArrayList<Education>();
			String dbField = ebean.getXmlLabel();
			String operation = ebean.getOperations();
			String basicSearchId = ebean.getBasicSearchId();

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
			 list=	erpDao.searchDetails("select ag.educationid,ag.education from Education ag order by ag.education");
			
			 iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Education educationbean = new Education();
					educationbean.setEducationid((Integer)obj[0]);
					educationbean.setEducation((String)obj[1]);
					ebeans.add(educationbean);

				}

			} else {
				list =erpDao.searchDetails("select ag.educationid,ag.education from Education ag where ag."
					+ dbField + "" + operation + "'"+basicSearchId+"' order by ag.education ");
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Education educationbean = new Education();
					educationbean.setEducationid((Integer)obj[0]);
					educationbean.setEducation((String)obj[1]);
					ebeans.add(educationbean);
				}
			}
			request.setAttribute("ebeans", ebeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "educationHome";
	}

	@RequestMapping(value = "/educationEdit", method = RequestMethod.GET)
	public String editeducation(
			@ModelAttribute("EducationCMD") Education ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("educationedit"));

		try {
			List<Education> ebeans = new ArrayList<Education>();
			list = erpDao.searchDetails("select ag.educationid,ag.education from Education ag where ag.educationid="
					+ id + "");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				ebean.setEducationidedit((Integer)obj[0]);
				ebean.setEducationedit((String)obj[1]);
				ebeans.add(ebean);
			}
			request.setAttribute("editvalues", ebeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "educationHome";

	}

		@RequestMapping(value = "/educationUpdate", method = RequestMethod.POST)
	public String updateeducation(
			@ModelAttribute("EducationCMD") Education ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = ebean.getEducationedit();
		int imid = ebean.getEducationidedit();
		Long iid = 0l;
		String educationdupedit = null;
		try {
			iid =erpDao.duplicateCheck("select count(*) from Education ab where ab.education='"
					+ name + "'and ab.educationid!='" + imid + "'");
			if (iid == 0) {
				ebean.setEducation(ebean.getEducationedit());
				ebean.setEducationid(ebean.getEducationidedit());

				int message = erpDao.updateDetails(ebean);
				if (message==1) {
					request.setAttribute("educationUpdate","Education Data Updated Successfully");
				}
				else
				{
					request.setAttribute("educationUpdateFail","Education Data Did not Updated");
				}
			} else {
				educationdupedit = "Warning ! Education is already exists. Please try some other name ";
				ebean.setEhideedit(1);
				request.setAttribute("educationdupedit",educationdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "educationHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("educationUpdateFail","Education Data Did not Updated");
			return "educationHome";
		}
		model.addAttribute("EducationCMD", new Education());
		return "educationHome";
	}

	@RequestMapping(value = "/educationDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView educationDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		try {
			Id = Integer.parseInt(request.getParameter("educationdelete"));
			Education educationbean=new Education();
			educationbean.setEducationid(Id);
			int msg = erpDao.deleteDetails(educationbean);
			if (msg==1)
			{
				Date date = new Date();
				session=request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Education","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("educationDelete",
						"Education  Data is Deleted Successfully");
			}
			else
			{
				request.setAttribute("educationDeleteFail","Education  Data is Did not Deleted");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("educationDeleteFail","Education  Data is Did not Deleted");
			return new ModelAndView("educationHome", "EducationCMD",
					new Education());
		}
		return new ModelAndView("educationHome", "EducationCMD",
				new Education());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "educationid";

		Map<String, String> map =null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
