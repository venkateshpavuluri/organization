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



import com.mnt.erp.bean.TerminationReason;

import com.mnt.erp.daojar.ERPDao;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class TerminationReasonController {
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
	
	
	@RequestMapping(value = "/terminationreasonHome", method = RequestMethod.GET)
	public String getTerminationReason(
			@ModelAttribute TerminationReason ebean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("terminationreasonHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("TRCMD", new TerminationReason());

		return "terminationreasonHome";
	}
	

	@RequestMapping(value = "/saveTerminationReason", method = RequestMethod.POST)
	public String se(
			@ModelAttribute("TRCMD")  TerminationReason ebean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		int msg = 0;
		TerminationReason ebean1 = null;
		String TerminationReasonsuccess = null;
		String TerminationReasonsuccessdup,res = null;
		
		//List<String> list = null;
		String name = ebean.getTerminationreason();
		Long id = 0L;
		try {
			id = erpDao.duplicateCheck("select count(*) from TerminationReason ab where ab.terminationreason='"
					+ name + "'");
			
			if (id == 0) {

				msg=erpDao.saveDetails(ebean);
				if(id!=null)
				{
			HttpSession session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","termination","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				}
				ebean1 = new TerminationReason();
               map.addAttribute("TRCMD", ebean1);
				if (msg>=1) {
					res = "redirect:terminationreasonHome.mnt?list=" + "success" + "";
					
				}
				else {
					res = "redirect:terminationreasonHome.mnt?listwar=" + "fail" + "";
					
				}
			}

			else {
				TerminationReasonsuccessdup = "Warning ! Termination Reason is already exists. Please try some other name ";
				ebean.setThide(1);
				request.setAttribute("TerminationReasonsuccessdup",TerminationReasonsuccessdup);
				return "terminationreasonHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:terminationreasonHome.mnt?listwar=" + "fail" + "";
		}
		
		return "redirect:terminationreasonHome.mnt?list=" + "success" + "";

	}
	@RequestMapping(value = "/searchTerminationReason", method = RequestMethod.GET)
	public String searchTerminationReason(
			@ModelAttribute("TRCMD") TerminationReason ebean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = ebean.getTerminationreasonid();
			List<TerminationReason> ebeans = new ArrayList<TerminationReason>();
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
			 list=	erpDao.searchDetails("select ag.terminationreasonid,ag.terminationreason from TerminationReason ag order by ag.terminationreason");
			
			 iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					TerminationReason TerminationReasonbean = new TerminationReason();
					TerminationReasonbean.setTerminationreasonid((Integer)obj[0]);
					TerminationReasonbean.setTerminationreason((String)obj[1]);
					ebeans.add(TerminationReasonbean);

				}

			} else {
				list =erpDao.searchDetails("select ag.terminationreasonid,ag.terminationreason from TerminationReason ag where ag."
					+ dbField + "" + operation + "'"+basicSearchId+"' ");
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					TerminationReason TerminationReasonbean = new TerminationReason();
					TerminationReasonbean.setTerminationreasonid((Integer)obj[0]);
					TerminationReasonbean.setTerminationreason((String)obj[1]);
					ebeans.add(TerminationReasonbean);
				}
			}
			request.setAttribute("termValues","termValues");
			request.setAttribute("ebeans", ebeans);
			 model.addAttribute("TRCMD", new TerminationReason());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "terminationreasonHome";
	}

	@RequestMapping(value = "/TerminationReasonEdit", method = RequestMethod.GET)
	public String editTerminationReason(
			@ModelAttribute("TRCMD") TerminationReason ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("TerminationReasonedit"));

		try {
			List<TerminationReason> ebeans = new ArrayList<TerminationReason>();
			list = erpDao.searchDetails("select ag.terminationreasonid,ag.terminationreason from TerminationReason ag where ag.terminationreasonid="
					+ id + "");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				ebean.setTerminationreasonidedit((Integer)obj[0]);
				ebean.setTerminationreasonedit((String)obj[1]);
				ebeans.add(ebean);
			}
			request.setAttribute("editvalues", ebeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "terminationreasonHome";

	}

		@RequestMapping(value = "/TerminationReasonUpdate", method = RequestMethod.POST)
	public String updateTerminationReason(
			@ModelAttribute("TRCMD") TerminationReason ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = ebean.getTerminationreasonedit();
		int imid = ebean.getTerminationreasonidedit();
		Long iid = 0l;
		String TerminationReasondupedit = null;
		try {
			iid =erpDao.duplicateCheck("select count(*) from TerminationReason ab where ab.terminationreason='"
					+ name + "'and ab.terminationreasonid!='" + imid + "'");
			if (iid == 0) {
				ebean.setTerminationreason(ebean.getTerminationreasonedit());
				ebean.setTerminationreasonid(ebean.getTerminationreasonidedit());

				int message = erpDao.updateDetails(ebean);
				if (message==1) {
					request.setAttribute("TerminationReasonUpdate","Termination Reason Data Updated Successfully");
				}
			} else {
				TerminationReasondupedit = "Warning ! Termination Reason is already exists. Please try some other name ";
				ebean.setThideedit(1);
				request.setAttribute("TerminationReasondupedit",TerminationReasondupedit);
				request.setAttribute("editvalues", "editvalues");
				return "terminationreasonHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("TerminationReasonUpdateErr","Termination Reason Data doesn't Updated ");
			
		}
		model.addAttribute("TRCMD", new TerminationReason());
		return "terminationreasonHome";
	}

	@RequestMapping(value = "/TerminationReasonDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView TerminationReasonDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int Id = 0;
		try {
			Id = Integer.parseInt(request.getParameter("TerminationReasondelete"));
			TerminationReason TerminationReasonbean=new TerminationReason();
			TerminationReasonbean.setTerminationreasonid(Id);
			int msg = erpDao.deleteDetails(TerminationReasonbean);
			if (msg==1)
			{
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","termination","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
			
				
				request.setAttribute("TerminationReasonDelete",
						"Termination Reason  Data is Deleted Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("TerminationReasonDeleteErr",
					"Termination Reason  Data is not deleted");
		}
		return new ModelAndView("terminationreasonHome", "TRCMD",
				new TerminationReason());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "terminationreasonid";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
