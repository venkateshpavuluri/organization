/**
copyright MNTSoft
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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.BillingType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BillingTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author A Nikesh
 * @version 1.0 05-11-2013
 * @build 0.0
 * 
 */
@Controller
public class BillingTypeController {

	@Autowired
	BillingTypeService billingtypeService;
	
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired 
	AuditLogService auditLogService;
	@RequestMapping(value = "/billingtypeHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView billingType(
			@ModelAttribute("billingtypeAdd") BillingType billingtype,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("billingtypeHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("billingtypeHome", "billingtypeAdd",
				new BillingType());
	}

	@RequestMapping(value = "/billingtypeAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveBillingTypeDetails(
			@ModelAttribute("billingtypeAdd") @Valid BillingType billingtypeAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msa = null;
		Long duplicateId = 0l;
		String res=null;
		HttpSession session=null;
		int id=billingtypeAdd.getBillingtypeId();

		try {
			// here we set the CharacterEncoding to resonse becoz of
			// Localization Concept
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				billingtypeAdd.setAid(1);
				return "billingtypeHome";
			}
			// this method is used to check the Duplicates
			duplicateId = billingtypeService
					.duplicateBillingTypeCheck(billingtypeAdd.getBillingtype());
			if (duplicateId == 0) {
		
				msa = billingtypeService.saveBillingTypeDetails(billingtypeAdd);
				
				model.addAttribute("billingtypeAdd", new BillingType());
				if (msa.equals("S")) {
					
					res="redirect:billingtypeHome.mnt?list="+"success"+"";
					
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Billing Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
					
				} 
				else {

					res="redirect:billingtypeHome.mnt?listwar="+"fail"+"";
				}
			} else {

				request.setAttribute("BillingTypeDuplicate","BillingType Name  Already exist");
				billingtypeAdd.setAid(1);
				return "billingtypeHome";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return res;

	}

	@RequestMapping(value = "/billingtypeSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchBillingType(
			@ModelAttribute BillingType billingtypeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<BillingType> billingTypeBean = new ArrayList<BillingType>();

		BillingType billingtypesearch = null;
		try {
			int id = billingtypeSearch.getBillingtypeId();
			String dbField = billingtypeSearch.getXmlLabel();
			String operation = billingtypeSearch.getOperations();
			String basicSearchId = billingtypeSearch.getBasicSearchId();

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
				list = billingtypeService.searchBillingType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					BillingType vt = new BillingType();
					Object[] obj = (Object[]) iterator.next();
					vt.setBillingtypeId((Integer) obj[0]);
					vt.setBillingtype((String) obj[1]);
					billingTypeBean.add(vt);

				}
			} else {
				list = billingtypeService.basicSearchBillingType(dbField,
						operation, basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					BillingType vt = new BillingType();
					Object[] obj = (Object[]) iterator.next();
					vt.setBillingtypeId((Integer) obj[0]);
					vt.setBillingtype((String) obj[1]);
					billingTypeBean.add(vt);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("billingtypeSearch", billingTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("billingtypeAdd", billingtypeSearch);

		return "billingtypeHome";
	}

	@ModelAttribute("BillingTypeSearchNames")
	public Map<String, String> populatebillingtypeSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = billingtypeService.selectBillingTypeNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String desigId = Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/billingtypeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String billingtypeEdit(
			@ModelAttribute BillingType billingtypeDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String billingtypename = request.getParameter("billingtypeDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<BillingType> billingtypesList = new ArrayList<BillingType>();

		try {

			list = billingtypeService.searchBillingTypeWithId(billingtypename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				billingtypeDisplay.setBillingtypeIdEdit((Integer) object[0]);
				billingtypeDisplay.setBillingtypeEdit((String) object[1]);


				billingtypesList.add(billingtypeDisplay);

			}
			request.setAttribute("billingtypeValues", billingtypesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("billingtypeAdd", billingtypeDisplay);
		return "billingtypeHome";

	}

	@RequestMapping(value = "/billingtypeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateBillingType(
			@ModelAttribute("billingtypeAdd") BillingType billingtype,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = billingtypeService.updateDuplicateCheck(
					billingtype.getBillingtypeEdit(),
					billingtype.getBillingtypeIdEdit());

			if (duplicateId == 0) {
				billingtype
						.setBillingtypeId(billingtype.getBillingtypeIdEdit());
				billingtype.setBillingtype(billingtype.getBillingtypeEdit());
				/* billingtype.setStatus(billingtype.getStatusEdit()); */

				String msg = billingtypeService.updateBillingType(billingtype);

				if (msg.equals("S")) {
					request.setAttribute("billingtypeUpadteSuccess","Billing Type has been updated");
				} else {
					request.setAttribute("billingtypeUpadteError","Billing Type has not been updated");
				}
			} else {
				request.setAttribute("billingtypeEditDuplicate",
						"BillingType Already exist");
				request.setAttribute("billingtypeValues", "hello");

				return "billingtypeHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "billingtypeHome";

	}

	@RequestMapping(value = "/billingtypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView billingtypeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int billingtypeId = 0;
		HttpSession session=null;

		try {
			billingtypeId = Integer.parseInt(request
					.getParameter("billingtypeIdDelete"));
			String msg = billingtypeService.billingtypeDelete(billingtypeId);

						if (msg.equals("S")) 
							{
								request.setAttribute("billingTypeDelete","Billing Type has been deleted");
								session=request.getSession(false);
								Date date = new Date();
								String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
								auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Billing Type","ROW" ,String.valueOf(billingtypeId),"1",modifiedDate,session.getAttribute("userName").toString());
							}
			 else {
				request.setAttribute("billingTypeDeleteError","Billing Type has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("billingtypeHome", "billingtypeAdd",
				new BillingType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "billingTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
