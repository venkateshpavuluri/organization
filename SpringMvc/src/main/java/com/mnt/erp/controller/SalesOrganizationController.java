package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0 27Sep2013
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
import javax.validation.Valid;

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

import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.SalesOrganizationBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesOrganizationService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class SalesOrganizationController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	SalesOrganizationService soservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/salesOrganizationHome", method = RequestMethod.GET)
	public String getSalesOrganization(
			@ModelAttribute SalesOrganizationBean SalesOrganizationbean,
			SessionStatus status, HttpServletResponse response, Model model,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		model.addAttribute("SalesOrganization", new SalesOrganizationBean());
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("salesOrganizationHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return "salesOrganizationHome";
	}

	@RequestMapping(value = "/saveSalesOrg", method = RequestMethod.POST)
	public String saveSalesOrganization(
			@ModelAttribute("SalesOrganization") @Valid SalesOrganizationBean sobean,
			BindingResult result, HttpServletRequest request,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		SalesOrganizationBean sobean2 = null;
		String salessuccess = null;
		String salessuccessdup = null;
		List<String> list = null;
		String name = sobean.getSalesorganization();
		Long id = 0L;
		String res=null;
		HttpSession session=null;
		
		try {
			id = soservice.getSalesOrgCount(name);
			if (id == 0) {
				session=request.getSession(false);
				msg = soservice.saveSalesOrgService(sobean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if (msg=="S") 
					res="redirect:salesOrganizationHome.mnt?list=" + "success" + "";
				else
					res="redirect:salesOrganizationHome.mnt?listwar=" + "fail" + "";
			}
			else {
				sobean.setSohide(1);
				request.setAttribute("salesOrgDup", "sales Organization already exists choose anotherone");
				return "salesOrganizationHome";
			}
			
		} catch (Exception e) {
			res="redirect:salesOrganizationHome.mnt?listwar=" + "fail" + "";
			
			e.printStackTrace();
		}
		return res;
	}

	@ModelAttribute("SalesOrganizationSearch")
	public Map<Integer, String> populateSalesOrganizationids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = soservice.selectSalesOrgService();
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

	@ModelAttribute("OrgSearch")
	public Map<Integer, String> populateSalesOrgids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = soservice.selectOrg();
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

	@RequestMapping(value = "/searchSalesOrganization", method = RequestMethod.GET)
	public String searchSalesOrganizationIds(
			@ModelAttribute("SalesOrganization") SalesOrganizationBean sobean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = sobean.getSalesorgId();
			List<SalesOrganizationBean> sobeans = new ArrayList<SalesOrganizationBean>();
			String dbField = sobean.getXmlLabel();
			String operation = sobean.getOperations();
			String basicSearchId = sobean.getBasicSearchId();

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
				list = soservice.searchSalesOrgService();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					SalesOrganizationBean sobean2 = new SalesOrganizationBean();
					sobean2.setSalesorgId((Integer) obj[0]);
					sobean2.setSalesorganization((String) obj[1]);
					
					Organization orgbean = ((Organization) obj[2]);
					sobean2.setOrganizationname((orgbean.getOrgName()));
					sobeans.add(sobean2);

				}

			} else {

			
				list = soservice.basicSearchSalesOrg(dbField, operation,
						basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					SalesOrganizationBean sobean2 = new SalesOrganizationBean();
					sobean2.setSalesorgId((Integer) obj[0]);
					sobean2.setSalesorganization((String) obj[1]);
					Organization orgbean = ((Organization) obj[2]);
					sobean2.setOrganizationname((orgbean.getOrgName()));
					sobeans.add(sobean2);
				}
			}
			request.setAttribute("sobeans", sobeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "salesOrganizationHome";
	}

	@RequestMapping(value = "/SalesOrgEdit", method = RequestMethod.GET)
	public String editSalesOrganization(
			@ModelAttribute("SalesOrganization") SalesOrganizationBean sobean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("soedit"));

		try {
			List<SalesOrganizationBean> sobeans = new ArrayList<SalesOrganizationBean>();
			list = soservice.searchSalesOrgServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				sobean.setEsalesorgId((Integer) obj[0]);
				sobean.setEsalesorganization((String) obj[1]);
				sobean.setEorgId((String) obj[2]);
				sobeans.add(sobean);
			}
			request.setAttribute("editvalues", sobeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesOrganizationHome";

	}

	@RequestMapping(value = "/SalesOrganizationUpdate", method = RequestMethod.POST)
	public String updateInpectionMethod(
			@ModelAttribute("SalesOrganization") SalesOrganizationBean sobean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = sobean.getEsalesorganization();
		int imid = sobean.getEsalesorgId();
		Long iid = 0l;
		String sosuccessdupedit = null;
		try {
			iid = soservice.getSalesOrgCountedit(name, imid);
			if (iid == 0) {
				sobean.setSalesorgId(sobean.getEsalesorgId());
				sobean.setSalesorganization(sobean.getEsalesorganization());
				sobean.setOrgId(sobean.getEorgId());

				String message = soservice.updateSalesOrgService(sobean);
				if (message
						.equals("S")) {
					request.setAttribute("SalesOrganizationUpdate",
							"Sales Organization Data Updated Successfully");
				}else{
					request.setAttribute("salesOrgErr",
							"Sales Organization Data doesn't updated propely");
				}
			} else {
				
				sobean.setSohideedit(1);
				request.setAttribute("salesOrgupdatedup",
						"Sales Organization already Exists please Enter Other");
				request.setAttribute("editvalues", "editvalues");
			
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("SalesOrganization", new SalesOrganizationBean());
		return "salesOrganizationHome";
	}

	@RequestMapping(value = "/soDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView SalesOrganizationDetailsDelete(
			@ModelAttribute("SalesOrganization") SalesOrganizationBean salesorg,
			HttpServletRequest request, HttpServletResponse response) {
		int Id = 0;
		HttpSession session=null;
		response.setCharacterEncoding("UTF-8");
		try {
			Id = Integer.parseInt(request.getParameter("sdelete"));

			String msg = soservice.deleteSalesOrgService(Id);
			if (msg.equals("S"))
			{
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","SalesOrg","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
							
				request.setAttribute("SalesOrganizationDelete",
						"Sales Organization Details Deleted Successfully");
			}
			else {

				request.setAttribute("salesOrgDelErr",
						"Sales org doesn't delete properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("salesOrganizationHome", "SalesOrganization",
				new SalesOrganizationBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesorgId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
