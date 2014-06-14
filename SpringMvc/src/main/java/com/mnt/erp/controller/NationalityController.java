package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.mnt.erp.bean.Nationality;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class NationalityController {
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
	
	@RequestMapping(value = "/nationalityHome", method = RequestMethod.GET)
	public String getNationality(
			@ModelAttribute Nationality ebean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("nationalityHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("NationalityCMD", new Nationality());

		return "nationalityHome";
	}
	

	@RequestMapping(value = "/saveNationality", method = RequestMethod.POST)
	public String se(
			@ModelAttribute("NationalityCMD")  Nationality ebean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		int msg = 0;
		Nationality ebean1 = null;
		String Nationalitysuccess = null;
		String Nationalitysuccessdup = null;
		String res=null;
		//List<String> list = null;
		String name = ebean.getNationality();
		Long id = 0L;
		try {
			id = erpDao.duplicateCheck("select count(*) from Nationality ab where ab.nationality='"
					+ name + "'");
			
			if (id == 0) {

				msg=erpDao.saveDetails(ebean);
				if(id!=null)
				{
			HttpSession session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","nationality","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				}
				ebean1 = new Nationality();
               map.addAttribute("NationalityCMD", ebean1);
				if (msg>=1) {
					 
					 res = "redirect:nationalityHome.mnt?list=" + "success" + "";
				}
				else {
					 res = "redirect:nationalityHome.mnt?listwar=" + "fail" + "";
				}
			}

			else {
				Nationalitysuccessdup = "Warning ! Nationality is already exists. Please try some other name ";
				ebean.setNhide(1);
				request.setAttribute("Nationalitysuccessdup",Nationalitysuccessdup);
				return "nationalityHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:nationalityHome.mnt?listwar=" + "fail" + "";
		}
		
		return "redirect:nationalityHome.mnt?list=" + "success" + "";

	}
	@RequestMapping(value = "/searchNationality", method = RequestMethod.GET)
	public String searchNationality(
			@ModelAttribute("NationalityCMD") Nationality ebean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = ebean.getNationalityid();
			List<Nationality> ebeans = new ArrayList<Nationality>();
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
			 list=	erpDao.searchDetails("select ag.nationalityid,ag.nationality from Nationality ag order by ag.nationality");
			
			 iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Nationality Nationalitybean = new Nationality();
					Nationalitybean.setNationalityid((Integer)obj[0]);
					Nationalitybean.setNationality((String)obj[1]);
					ebeans.add(Nationalitybean);

				}

			} else {
				list =erpDao.searchDetails("select ag.nationalityid,ag.nationality from Nationality ag where ag."
					+ dbField + "" + operation + "'"+basicSearchId+"' order by ag.nationality");
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Nationality Nationalitybean = new Nationality();
					Nationalitybean.setNationalityid((Integer)obj[0]);
					Nationalitybean.setNationality((String)obj[1]);
					ebeans.add(Nationalitybean);
				}
			}
			request.setAttribute("ebeans", ebeans);
			 
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "nationalityHome";
	}

	@RequestMapping(value = "/NationalityEdit", method = RequestMethod.GET)
	public String editNationality(
			@ModelAttribute("NationalityCMD") Nationality ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("Nationalityedit"));

		try {
			List<Nationality> ebeans = new ArrayList<Nationality>();
			list = erpDao.searchDetails("select ag.nationalityid,ag.nationality from Nationality ag where ag.nationalityid="
					+ id + "");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				ebean.setNationalityidedit((Integer)obj[0]);
				ebean.setNationalityedit((String)obj[1]);
				ebeans.add(ebean);
			}
			request.setAttribute("editvalues", ebeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "nationalityHome";

	}

		@RequestMapping(value = "/NationalityUpdate", method = RequestMethod.POST)
	public String updateNationality(
			@ModelAttribute("NationalityCMD") Nationality ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = ebean.getNationalityedit();
		int imid = ebean.getNationalityidedit();
		Long iid = 0l;
		String Nationalitydupedit = null;
		try {
			iid =erpDao.duplicateCheck("select count(*) from Nationality ab where ab.nationality='"
					+ name + "'and ab.nationalityid!='" + imid + "'");
			if (iid == 0) {
				ebean.setNationality(ebean.getNationalityedit());
				ebean.setNationalityid(ebean.getNationalityidedit());

				int message = erpDao.updateDetails(ebean);
				if (message==1) {
					request.setAttribute("NationalityUpdate","Nationality Data Updated Successfully");
				}
			} else {
				Nationalitydupedit = "Warning ! Nationality is already exists. Please try some other name ";
				ebean.setNhideedit(1);
				request.setAttribute("Nationalitydupedit",Nationalitydupedit);
				request.setAttribute("editvalues", "editvalues");
				return "nationalityHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("NationalityUpdateErr","Nationality Data doesn't Updated Properly");
		}
		model.addAttribute("NationalityCMD", new Nationality());
		return "nationalityHome";
	}

	@RequestMapping(value = "/NationalityDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView NationalityDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		HttpSession session=null;
		try {
			Id = Integer.parseInt(request.getParameter("Nationalitydelete"));
			Nationality Nationalitybean=new Nationality();
			Nationalitybean.setNationalityid(Id);
			int msg = erpDao.deleteDetails(Nationalitybean);
			if (msg==1)
				session=request.getSession(false);
			Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","nationality","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
		
				request.setAttribute("NationalityDelete",
						"Nationality  Data is Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("NationalityDeleteErr",
					"Nationality  Data is not Deleted ");
		}
		return new ModelAndView("nationalityHome", "NationalityCMD",
				new Nationality());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "nationalityid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
