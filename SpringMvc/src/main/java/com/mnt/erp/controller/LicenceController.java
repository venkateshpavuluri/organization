package com.mnt.erp.controller;

/*
 @author venkatesh
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import com.mnt.erp.bean.Licence;
import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class LicenceController {

	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String sql;

	@Autowired 
	ERPDao dao;
	
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession session;
	

	@RequestMapping(value = "/licence", method = RequestMethod.GET)
	public String getLicence(
			@ModelAttribute Licence licence,
			SessionStatus status, Model model,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		 session=request.getSession(false);
			List<String> list=menuService.getPrivilige("licence.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
		model.addAttribute("licence", new Licence());

		return "licenceView";
	}

	@RequestMapping(value = "/licenceAdd", method = RequestMethod.POST)
	@RequestScoped
	public String saveLicences(
			
			@ModelAttribute("licence") Licence licence,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		int mess = 0;


		String AGSuccessdup = null;
	
		
		Long id = 0L;
		try {
			sql="select count(*) from Licence o where  o.licence='" + licence.getLicence()
					+ "'";
			id =dao.duplicateCheck(sql);
		
			if (id == 0) {
				 mess=dao.saveDetails(licence);
			
				map.addAttribute("licence", licence);
				if (mess!=0) {
					 Date date = new Date();
						session=request.getSession(false);
						String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Licence","ROW" ,String.valueOf(licence.getLicenceId()),"1",modifiedDate,session.getAttribute("userName").toString());
					model.addAttribute("licence", new Licence());
					return "redirect:licence.mnt?list="
					+"success"+ "";
				}
				else
				{
					return "redirect:licence.mnt?listwar="
							+"fail"+ "";
				}
			} else {
				AGSuccessdup = "Warning ! Licence is already exists. Please try some other name";
			
				licence.setAid(1);
				request.setAttribute("AGSuccessdup", AGSuccessdup);
				return "licenceView";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:licence.mnt?listwar="
			+"fail"+ "";
		}

	

	}

	@RequestMapping(value = "/searchlicence", method = RequestMethod.GET)
	public String searchLicences(
			@ModelAttribute("licence") Licence licence,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<Licence> licences =null;
		try {
			int iid = licence.getLicenceId();
			licences = new ArrayList<Licence>();
			String dbField = licence.getXmlLabel();
			String operation = licence.getOperations();
			String basicSearchId = licence.getBasicSearchId();

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
sql="select ag.licenceId,ag.licence from Licence ag order by ag.licence ";
				list =dao.searchDetails(sql);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Licence licencesearch = new Licence();
					licencesearch.setLicenceId((Integer)obj[0]);
					licencesearch.setLicence((String)obj[1]);
					
					licences.add(licencesearch);
				}

			} else {

			
sql = "select ag.licenceId,ag.licence from Licence ag where ag."
						+ dbField + "" +""+ operation +"'"+ basicSearchId+"'ag.licence";
				list = dao.searchDetails(sql);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Licence licencesearch = new Licence();
					licencesearch.setLicenceId((Integer)obj[0]);
					licencesearch.setLicence((String)obj[1]);
					
					licences.add(licencesearch);
				}

			}
			request.setAttribute("licenceBeans", licences);
		
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "licenceView";
	}



	@RequestMapping(value = "/licenceedit", method = RequestMethod.GET)
	public String editLicence(
			@ModelAttribute("licence") Licence licence,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("licenceedit"));

		try {
			
			sql="select ag.licenceId,ag.licence from Licence ag where ag.licenceId='"+id+"'";
			
			list=dao.searchDetails(sql);
			
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				
			
				licence.setLicenceId((Integer)obj[0]);
				licence.setLicenceEdit((String)obj[1]);
			
			}
			request.setAttribute("editvalues","df");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "licenceView";

	}

	@RequestMapping(value = "/licenceUpdate", method = RequestMethod.POST)
	public String updateLicence(
			@ModelAttribute("licence") Licence licence,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String licenceName =licence.getLicenceEdit();
		int licenceId = licence.getLicenceId();
	
		String AGSuccessdupedit = null;

		Long id = 0L;
		try {
		sql = "select count(*) from Licence ab where ab.licence='"
					+ licenceName + "'and ab.licenceId!='" + licenceId + "'";
			id =dao.duplicateCheck(sql);

			if (id == 0) {
				
				licence.setLicence(licence.getLicenceEdit());
				int message =dao.updateDetails(licence);
				if (message!=0) {
					request.setAttribute("licenceUpdate",
							"Licence Data Updated Successfully");
					model.addAttribute("licence", new Licence());
				}
				else
				{
					request.setAttribute("licenceUpdateFail",
							"Licence Data Did not Updated");
					model.addAttribute("licence", new Licence());
				}
			} else {
				AGSuccessdupedit = "Warning ! Licence is already exists. Please try some other name";
		
				request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "licenceView";
			}
			model.addAttribute("licence",new Licence());
		} catch (Exception e) {
			request.setAttribute("licenceUpdateFail",
					"Licence Data Did not Updated");
			e.printStackTrace();
			return "licenceView";
		}

		return "licenceView";
	}

	@RequestMapping(value = "/licenceDelete", method = RequestMethod.GET)
	public String licenceDelete(HttpServletRequest request,HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		int groupId = 0;
		try {
			groupId = Integer.parseInt(request
					.getParameter("licenceDelete"));
			Licence licence=new Licence();
			licence.setLicenceId(groupId);

			int  msg =dao.deleteDetails(licence);
			if (msg!=0)
			{
				Date date = new Date();
				session=request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Licence","ROW" ,String.valueOf(groupId),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("licenceDelete","Licence Data is Deleted Successfully");
			}
			else
			{
				request.setAttribute("licenceDeleteFail","Licence Data is did not Deleted");
			}
		} catch (Exception e) {
			request.setAttribute("licenceDeleteFail","Licence Data is did not Deleted");
			e.printStackTrace();
			return "licenceView";
		}
		model.addAttribute("licence",new Licence());
		return "licenceView";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "licenceId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
