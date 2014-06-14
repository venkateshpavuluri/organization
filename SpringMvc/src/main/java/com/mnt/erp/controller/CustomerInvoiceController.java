package com.mnt.erp.controller;

/**
 * @author Srinivas

 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.CustomerInvoiceLine;
import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Uom;

import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CustomerInvoiceService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class CustomerInvoiceController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String msg = null;
	String msgedit = null;
	@Autowired
	CustomerInvoiceService ciservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession session=null;
	
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/CustomerInvoiceHome", method = RequestMethod.GET)
	public String getRfq(@ModelAttribute CustomerInvoice cibean,
			SessionStatus status, Model model, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		 session=request.getSession(false);
		List<String> list=menuService.getPrivilige("CustomerInvoiceHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		
		

		model.addAttribute("CUSTOMERINVOICE", new CustomerInvoice());
		return "CustomerInvoiceHome";
	}
	@RequestMapping(value = "/CIDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkciname(HttpServletRequest request,
			HttpServletResponse response, CustomerInvoice cibean) {
		
		Long pname = null;

		try {

			String before = request.getParameter("cinno");

			pname = ciservice.getCICount(before);
			if (pname != 0) {
				cibean.setCustomerinvoiceno("");
				msg = "Warning ! Customer Invoice No is already exists. Please try some other name";
			}
			if (pname == 0) {
				cibean.setCustomerinvoiceno("");
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/savecustomerinvoice", method = RequestMethod.POST)
	public String saveci(
			@ModelAttribute("CUSTOMERINVOICE") CustomerInvoice cibean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");

		String cisuccess = null;
		List<String> list = null;
		List<CustomerInvoiceLine> cillist = new ArrayList<CustomerInvoiceLine>();
		try {
			cibean.setCustomerinvoicedate(dateService.dateFormat(dateService.dateParse(cibean.getCustomerinvoicedate(),"au"),"au"));
			cibean.setPostingdate(dateService.dateFormat(dateService.dateParse(cibean.getPostingdate(),"au"),"au"));
			
			String material = cibean.getMaterialid();
			int qtty[] = cibean.getQty();
			if(qtty!=null){
			List<String> mlist = Arrays.asList(material.split(","));
			Object[] materials = mlist.toArray();
			
			String uomid = cibean.getUomid();
			List<String> ulist = Arrays.asList(uomid.split(","));
			Object[] uomids = ulist.toArray();
			String price[] = cibean.getPrice();
			String tax[] = cibean.getTax();

			for (int r = 0; r < qtty.length; r++) {

				CustomerInvoiceLine linebean = new CustomerInvoiceLine();
				linebean.setMaterialid(materials[r].toString());
				linebean.setQty(qtty[r]);
				linebean.setUomid(uomids[r].toString());
				linebean.setPrice(price[r]);
				linebean.setTax(tax[r]);
				cillist.add(linebean);

			}
			cibean.setCustomerinvoicelinebean(cillist);
			}
		
			msg=ciservice.saveCustomerInvoiceservice(cibean);
			if(msg=="S"){
			session=request.getSession(false);
			 Date date1 = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Customer Invoice","ROW" ,String.valueOf(cibean.getCustomerinvoiceid()),"1",modifiedDate,session.getAttribute("userName").toString());

			cisuccess = "Customer Invoice Data Saved Successfully";
			return "redirect:CustomerInvoiceHome.mnt?list=" +"success"+ "";
			}else{
				return "redirect:CustomerInvoiceHome.mnt?listwar=" +"fail"+ "";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return "redirect:CustomerInvoiceHome.mnt?listwar=" +"fail"+ "";
		}
	}

	@ModelAttribute("currency")
	public Map<Integer, String> populateCurrency() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = ciservice.selectcurrencyservice();
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

	@ModelAttribute("deliverynote")
	public Map<Integer, String> populatePO() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = ciservice.selectDeliveryNoteservice();
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

	@ModelAttribute("org")
	public Map<Integer, String> populateOrg() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = ciservice.selectorgservice();
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

	@ModelAttribute("materialid")
	public Map<Integer, String> populatMaterialids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = ciservice.selectMaterialservice();
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

	@ModelAttribute("uom")
	public Map<Integer, String> populatUomids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = ciservice.selectUOMservice();
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

	@RequestMapping(value = "/searchCustomerinvoice", method = RequestMethod.GET)
	public String searchci(
			@ModelAttribute("CUSTOMERINVOICE") CustomerInvoice cibean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {

			//int iid = cibean.getCustomerinvoiceid();
			List<CustomerInvoice> cibeans = new ArrayList<CustomerInvoice>();
			String dbField = cibean.getXmlLabel();
			String operation = cibean.getOperations();
			String basicSearchId = cibean.getBasicSearchId();

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
				list = ciservice.selectCustomerInvoiceservice();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					CustomerInvoice cibean2 = new CustomerInvoice();
					cibean2.setCustomerinvoiceid((Integer) obj[0]);
					cibean2.setCustomerinvoiceno((String) obj[1]);
					cibean2.setCustomerinvoicedate(dateService.dateFormat(dateService.dateParse((String) obj[2],"se"),"se"));
					cibean2.setPostingdate(dateService.dateFormat(dateService.dateParse((String) obj[3],"se"),"se"));
					DeliveryNote dn = (DeliveryNote) obj[4];
					cibean2.setDeliverynoteid(dn.getDeliveryNoteDate());
					cibean2.setAmount((Float) obj[5]);
					Currency cur = (Currency) obj[6];
					cibean2.setCurrencyid(cur.getCurrency());
					cibean2.setReference((String) obj[7]);
					cibean2.setDescription((String) obj[8]);

					Organization org = (Organization) obj[9];
					cibean2.setOrgid(org.getOrgName());
					cibean2.setFy((String) obj[10]);
					cibeans.add(cibean2);

				}

			} else {

				list = ciservice.basicSearchCustomerInvoiceservice(dbField,
						operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {

					Object[] obj = (Object[]) iterator.next();
					CustomerInvoice cibean2 = new CustomerInvoice();
					cibean2.setCustomerinvoiceid((Integer) obj[0]);
					cibean2.setCustomerinvoiceno((String) obj[1]);
					cibean2.setCustomerinvoicedate(dateService.dateFormat(dateService.dateParse((String) obj[2],"se"),"se"));
					cibean2.setPostingdate(dateService.dateFormat(dateService.dateParse((String) obj[3],"se"),"se"));
					DeliveryNote dn = (DeliveryNote) obj[4];
					cibean2.setDeliverynoteid(dn.getDeliveryNoteDate());
					cibean2.setAmount((Float) obj[5]);
					Currency cur = (Currency) obj[6];
					cibean2.setCurrencyid(cur.getCurrency());
					cibean2.setReference((String) obj[7]);
					cibean2.setDescription((String) obj[8]);

					Organization org = (Organization) obj[9];
					cibean2.setOrgid(org.getOrgName());
					cibean2.setFy((String) obj[10]);
					cibeans.add(cibean2);
				}
			}
			request.setAttribute("cibeans", cibeans);
			// System.out.println(cibeans);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "CustomerInvoiceHome";
	}

	@RequestMapping(value = "/customerinvoiceEdit", method = RequestMethod.GET)
	public String editci(
			@ModelAttribute("CUSTOMERINVOICE") CustomerInvoice cibean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("utf-8");
		List<CustomerInvoice> ciedit = new ArrayList<CustomerInvoice>();
		List<CustomerInvoiceLine> cilinelist = new ArrayList<CustomerInvoiceLine>();
		// int processId = processBean.getProcessid();
		int ciId = Integer.parseInt(request.getParameter("ciedit"));

		try {
			List<CustomerInvoice> list = ciservice
					.EditCustomerInvoiceservice(ciId);
			// System.out.println(list);
			Iterator<CustomerInvoice> iter = list.iterator();
			if (iter.hasNext()) {
				Object object = iter.next();
				CustomerInvoice cib = (CustomerInvoice) object;

				cibean.setEditcustomerinvoiceid(cib.getCustomerinvoiceid());

				cibean.setEditcustomerinvoiceno(cib.getCustomerinvoiceno());
				cibean.setEditcustomerinvoicedate(dateService.dateFormat(dateService.dateParse(cib.getCustomerinvoicedate(),"se"),"se"));
				cibean.setEditpostingdate(dateService.dateFormat(dateService.dateParse(cib.getPostingdate(),"se"),"se"));
				cibean.setEditdeliverynoteid(cib.getDeliverynoteid());
				cibean.setEditcurrencyid(cib.getCurrencyid());
				cibean.setEditamount(cib.getAmount());
				cibean.setEditreference(cib.getReference());
				cibean.setEditdescription(cib.getDescription());
				cibean.setEditorgid(cib.getOrgid());
				cibean.setEditfy(cib.getFy());

				List<CustomerInvoiceLine> listEdit = cib
						.getCustomerinvoicelinebean();
				Iterator<CustomerInvoiceLine> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					CustomerInvoiceLine viledit = (CustomerInvoiceLine) object2;
					CustomerInvoiceLine vilineedit = new CustomerInvoiceLine();
					vilineedit.setEditcustomerinvoicelineid(viledit
							.getCustomerinvoicelineid());
					// System.out.println("id iss"+viledit.getVendorinvoicelineid());
					Material mm = viledit.getMaterialdetail();
					vilineedit.setEditmaterialid(viledit.getMaterialid());
					vilineedit.setMaterialidName(mm.getMaterialName());
					// System.out.println(mm.getMaterialName());
					vilineedit.setEditqty(viledit.getQty());
					Uom uom = viledit.getUomdetail();
					vilineedit.setEdituomid(viledit.getUomid());
					vilineedit.setUomidName(uom.getUom());
					vilineedit.setEditprice(viledit.getPrice());
					vilineedit.setEdittax(viledit.getTax());
					cilinelist.add(vilineedit);
				}
				cibean.setEditcustomerinvoicelinebean(cilinelist);

				ciedit.add(cibean);

			}
			request.setAttribute("editvalues", ciedit);
			request.setAttribute("cilinelist", cilinelist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "CustomerInvoiceHome";

	}
	@RequestMapping(value = "/CIDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkcinameEdit(HttpServletRequest request,
			HttpServletResponse response, CustomerInvoice cibean) {
		
		Long pname = null;

		

		try {

			String beforeedit = request.getParameter("cinameedit");
			int id = Integer.parseInt(request.getParameter("cieditid"));
			
			pname = ciservice.getCICountedit(beforeedit, id);
			if (pname != 0) {

				cibean.setEditcustomerinvoiceno("");

				msgedit = "Warning ! Customer Invoice No is already exists. Please try some other name";

			}
			if (pname == 0) {

				cibean.setEditcustomerinvoiceno("");

				msgedit = null;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msgedit;
	}
	@RequestMapping(value = "/customerinvoiceUpdate", method = RequestMethod.POST)
	public String ciUpdate(
			@ModelAttribute("CUSTOMERINVOICE") CustomerInvoice ciUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CustomerInvoiceLine> cilinelist = new ArrayList<CustomerInvoiceLine>();
		String msg = null;
		String cilUpdate = null;
		String checked = "", s1 = "0", s2 = "1";
		int ss = 0;
		try{
		ciUpdate.setCustomerinvoiceid(ciUpdate.getEditcustomerinvoiceid());
		ciUpdate.setCustomerinvoiceno(ciUpdate.getEditcustomerinvoiceno());
		ciUpdate.setCustomerinvoicedate(dateService.dateFormat(dateService.dateParse(ciUpdate.getEditcustomerinvoicedate(),"au"),"au"));
		ciUpdate.setPostingdate(dateService.dateFormat(dateService.dateParse(ciUpdate.getEditpostingdate(),"au"),"au"));
		ciUpdate.setDeliverynoteid(ciUpdate.getEditdeliverynoteid());
		ciUpdate.setAmount(ciUpdate.getEditamount());
		ciUpdate.setCurrencyid(ciUpdate.getEditcurrencyid());
		ciUpdate.setReference(ciUpdate.getEditreference());
		ciUpdate.setDescription(ciUpdate.getEditdescription());
		ciUpdate.setOrgid(ciUpdate.getEditorgid());
		ciUpdate.setFy(ciUpdate.getEditfy());
		
		
		int vilineid[] = ciUpdate.getEditcustomerinvoicelineid();
		
		String tax[] = ciUpdate.getEdittax();
		if (tax != null) {
		String vimaterialid = ciUpdate.getEditmaterialid();
		List<String> vimateriallist = Arrays.asList(vimaterialid.split(","));
		Object[] materialarray = vimateriallist.toArray();
		int qty[] = ciUpdate.getEditqty();
		
		String uomid = ciUpdate.getEdituomid();
		List<String> viuomlist = Arrays.asList(uomid.split(","));
		Object[] uom = viuomlist.toArray();
		String price[] = ciUpdate.getEditprice();
		
		
		if (vimaterialid != null) {
			for (int r = 0; r < tax.length; r++) {
				int vilId = vilineid[r];
				
				if (vilId == 0) {

					CustomerInvoiceLine cilinebean = new CustomerInvoiceLine();
					cilinebean.setCustomerinvoicelineid(vilineid[r]);
					cilinebean.setMaterialid(materialarray[r].toString());
					cilinebean.setQty(qty[r]);
					cilinebean.setUomid(uom[r].toString());
					cilinebean.setPrice(price[r]);
					cilinebean.setTax(tax[r]);
					cilinelist.add(cilinebean);

				} else {

					CustomerInvoiceLine cilinebean = new CustomerInvoiceLine();
					cilinebean.setCustomerinvoicelineid(vilineid[r]);
					cilinebean.setMaterialid(materialarray[r].toString());
					cilinebean.setQty(qty[r]);
					cilinebean.setUomid(uom[r].toString());
					cilinebean.setPrice(price[r]);
					cilinebean.setTax(tax[r]);
					cilinelist.add(cilinebean);
					ss = vilineid[r];
					checked = request.getParameter("Checkdelete" + ss);
					if (s2.equals(checked)) {
                     ciservice.deleteChildDetailsService(ss);
				      }
					if (s1.equals(checked) || checked == null) {
						cilinelist.add(cilinebean);
						//ciUpdate.setCustomerinvoicelinebean(cilinelist);
					}

				}

			}
		
		}
		}
	
			//if(msgedit==null){
			ciUpdate.setCustomerinvoicelinebean(cilinelist);
			msg = ciservice.updateCustomerInvoiceservice(ciUpdate);
            if (msg.equals("S")) {
            	 Date date1 = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"U","Customer Invoice","ROW" ,String.valueOf(ciUpdate.getCustomerinvoiceid()),"1",modifiedDate,session.getAttribute("userName").toString());
            	
				request.setAttribute("CIUpdateSuccess",
						"Customer Invoice Data Updated Successfully");
				model.addAttribute("CUSTOMERINVOICE", new CustomerInvoice());
            // }
            }else {
            	request.setAttribute("CIUpdateFail",
						"Customer Invoice Data Did Not Updated");
			}
		} catch (Exception e) {
			request.setAttribute("CIUpdateFail",
					"Customer Invoice Data Did Not Updated");
			e.printStackTrace();
		}

		return "CustomerInvoiceHome";
	}

	@RequestMapping(value = "/ciDelete", method = RequestMethod.GET)
	public String ciDelete(
			@ModelAttribute("CUSTOMERINVOICE") CustomerInvoice ciDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String CIDelete = null;
		int rId = Integer.parseInt(request.getParameter("cidelid"));

		try {
			String msg = ciservice.deleteCustomerInvoiceservice(rId);
			if (msg.equals("S")) {
				 Date date1 = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Customer Invoice","ROW" ,String.valueOf(rId),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("CIDeleteSuccess",
						"Customer Invoice Data Deleted Successfully");
				model.addAttribute("CUSTOMERINVOICE", new CustomerInvoice());
			} else {
				CIDelete = "Customer Invoice Data is Not Deleted Properly";
				request.setAttribute("CIDeleteFail",
						"Customer Invoice Data Did not Deleted");
				model.addAttribute("CUSTOMERINVOICE", new CustomerInvoice());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "CustomerInvoiceHome";

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "customerinvoiceid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/ciAdvanceSearch", method = RequestMethod.GET)
	public String ciAdvanceSearch(
			@ModelAttribute("CUSTOMERINVOICE") CustomerInvoice cibean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		// System.out.println("came to search");
		// String
		// advanceSearchHidden=request.getParameter("advanceSearchHidden");

		List<CustomerInvoice> vilist = null;

		String name1 = "customerinvoiceid", s1 = null, s2 = null;

		List<Object[]> returnString = null;

		vilist = new ArrayList();
		cibean.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator<Object[]> it = returnString.iterator();
			for (Object[] object : returnString) {
				CustomerInvoice v = new CustomerInvoice();

				s1 = (String) object[0];
				s2 = (String) object[1];
				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				vilist.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("ciSearchAdvance", vilist);

		return "CustomerInvoiceHome";
	}

	@RequestMapping(value = "/ciAdvanceSearchOperations", method = RequestMethod.POST)
	public String ciAdvanceSearchOperations(
			@ModelAttribute CustomerInvoice cibean, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<CustomerInvoice> cibeans = null;
		List<Object[]> objectsArray = null;

		response.setCharacterEncoding("UTF-8");
		cibeans = new ArrayList<CustomerInvoice>();
		String columns = cibean.getFirstLabel();
		String operations = cibean.getOperations1();
		String advanceSearchText = cibean.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {
			// System.out.println("came to advance"+advanceSearchText.length());
			objectsArray = ciservice.CustomerInvoiceadvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = ciservice.getCustomerInvoice("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			CustomerInvoice cibean2 = new CustomerInvoice();
			cibean2.setCustomerinvoiceid((Integer) obj[0]);
			cibean2.setCustomerinvoiceno((String) obj[1]);
			cibean2.setCustomerinvoicedate((String) obj[2]);
			cibean2.setPostingdate((String) obj[3]);
			DeliveryNote dn = (DeliveryNote) obj[4];
			cibean2.setDeliverynoteid(dn.getDeliveryNoteDate());
			cibean2.setAmount((Float) obj[5]);
			Currency cur = (Currency) obj[6];
			cibean2.setCurrencyid(cur.getCurrency());
			cibean2.setReference((String) obj[7]);
			cibean2.setDescription((String) obj[8]);
			Organization org = (Organization) obj[9];
			cibean2.setOrgid(org.getOrgName());
			cibean2.setFy((String) obj[10]);
			cibeans.add(cibean2);
		}

		request.setAttribute("cibeans", cibeans);
		model.addAttribute("CUSTOMERINVOICE", new CustomerInvoice());

		return "CustomerInvoiceHome";
	}

	

	

}
