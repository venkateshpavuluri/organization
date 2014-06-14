/**
 * @author Srinivas

 */
package com.mnt.erp.controller;

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
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.VendorInvoice;
import com.mnt.erp.bean.VendorInvoiceLine;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VendorInvoiceService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class VendorInvoiceController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String msg = null;
	String msgedit=null;
	@Autowired
   VendorInvoiceService viservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
    HttpSession session;
    @Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/vendorInvoiceHome", method = RequestMethod.GET)
	public String getRfq(
			@ModelAttribute VendorInvoice vibean,
			SessionStatus status, Model model,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("vendorInvoiceHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("VENDORINVOICE", new VendorInvoice());

		return "vendorInvoiceHome";
	}
	@RequestMapping(value = "/VIDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkviname(HttpServletRequest request,
			HttpServletResponse response,VendorInvoice vibean) {
		
		Long pname=null;
		
		
		try {

			String before = request.getParameter("vinno");
			
			 pname=viservice.getVICount(before);
			if (pname!=0) {
				vibean.setVendorinvoiceno("");
			msg = "Warning ! Vendor Invoice No is already exists. Please try some other name";
			}
			if (pname==0) {
				vibean.setVendorinvoiceno("");
				msg  = "";
		}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return msg;
	}
	@RequestMapping(value = "/savevendorinvoice", method = RequestMethod.POST)
	public String savevi(
			@ModelAttribute("VENDORINVOICE")  VendorInvoice vibean,
			BindingResult result, HttpServletRequest request,HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		
		String visuccess = null;
		List<String> list = null;
		List<VendorInvoiceLine> villist=new ArrayList<VendorInvoiceLine>();
		try {
			vibean.setVendorinvoicedate(dateService.dateFormat(dateService.dateParse(vibean.getVendorinvoicedate(),"au"),"au"));
			vibean.setPostingdate(dateService.dateFormat(dateService.dateParse(vibean.getPostingdate(),"au"),"au"));
				String material = vibean.getMaterialid();
				int qtty[]=vibean.getQty();
				if(qtty!=null){
				List<String> mlist = Arrays.asList(material.split(","));
				Object[] materials=mlist.toArray();
				
				String uomid=vibean.getUomid();
				List<String> ulist = Arrays.asList(uomid.split(","));
				Object[] uomids=ulist.toArray();
				String price[]=vibean.getPrice();
				String tax[]=vibean.getTax();

				for (int r = 0; r < qtty.length; r++) {

					VendorInvoiceLine vendorlinebean = new VendorInvoiceLine();
					vendorlinebean.setMaterialid(materials[r].toString());
					vendorlinebean.setQty(qtty[r]);
					vendorlinebean.setUomid(uomids[r].toString());
					vendorlinebean.setPrice(price[r]);
					vendorlinebean.setTax(tax[r]);
				   villist.add(vendorlinebean);

				}
				vibean.setVendorinvoicelinebean(villist);
				//System.out.println(msg);
				}
				
				msg=viservice.saveVendorInvoiceservice(vibean);
				if(msg=="S"){
				visuccess = "Vendor Invoice Data Saved Successfully!";
				session=request.getSession(false);
				 Date date1 = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
	     auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Vendor Invoice","ROW" ,String.valueOf(vibean.getVendorinvoiceid()),"1",modifiedDate,session.getAttribute("userName").toString());
				return "redirect:vendorInvoiceHome.mnt?list=" + "success"+ "";
				}else{
				
					return "redirect:vendorInvoiceHome.mnt?listwar=" + "fail"+ "";
				}
			
			
		}
		 catch (Exception e) {
			e.printStackTrace();
			return "redirect:vendorInvoiceHome.mnt?listwar=" + "fail"+ "";
		}
		
	}
	

	@ModelAttribute("currency")
	public Map<Integer, String> populateCurrency() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = viservice.selectcurrencyservice();
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
	@ModelAttribute("po")
	public Map<Integer, String> populatePO() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = viservice.selectpurchaseOrderservice();
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
			list = viservice.selectorgservice();
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
		@ModelAttribute("vendor")
	public Map<Integer, String> populateVendor() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = viservice.selectVendorservice();
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
			list = viservice.selectMaterialservice();
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
			list = viservice.selectUOMservice();
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
		@RequestMapping(value = "/searchVendorinvoice", method = RequestMethod.GET)
	public String searchvi(
			@ModelAttribute("VENDORINVOICE") VendorInvoice vibean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = vibean.getVendorinvoiceid();
			List<VendorInvoice> vibeans = new ArrayList<VendorInvoice>();
			String dbField = vibean.getXmlLabel();
			String operation = vibean.getOperations();
			String basicSearchId = vibean.getBasicSearchId();

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
				list =viservice.searchVendorInvoiceservice();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					VendorInvoice vibean2 = new VendorInvoice();
					vibean2.setVendorinvoiceid((Integer)obj[0]);
					vibean2.setVendorinvoiceno((String)obj[1]);
					vibean2.setVendorinvoicedate(dateService.dateFormat(dateService.dateParse((String)obj[2],"se"),"se"));
					vibean2.setPostingdate(dateService.dateFormat(dateService.dateParse((String)obj[3],"se"),"se"));
					vibean2.setAmount((Float)obj[4]);
					Currency cur=(Currency)obj[5];
					vibean2.setCurrencyid(cur.getCurrency());
					vibean2.setReference((String)obj[6]);
					vibean2.setDescription((String)obj[7]);
					PurchaseOrder po=(PurchaseOrder)obj[8];
					vibean2.setPurchaseorderid(po.getPurchaseOrderNo());
					Organization org=(Organization)obj[9];
					vibean2.setOrgid(org.getOrgName());
					vibean2.setFy((String)obj[10]);
					Vendor vv=(Vendor)obj[11];
					vibean2.setVendorid(vv.getVendorName());
					vibeans.add(vibean2);
					

				}

			} else {

				list = viservice.basicSearchVendorInvoiceservice(dbField, operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					
					Object[] obj = (Object[]) iterator.next();
					VendorInvoice vibean2 = new VendorInvoice();
					vibean2.setVendorinvoiceid((Integer)obj[0]);
					vibean2.setVendorinvoiceno((String)obj[1]);
					vibean2.setVendorinvoicedate(dateService.dateFormat(dateService.dateParse((String)obj[2],"se"),"se"));
					vibean2.setPostingdate(dateService.dateFormat(dateService.dateParse((String)obj[3],"se"),"se"));

					vibean2.setAmount((Float)obj[4]);

					Currency cur=(Currency)obj[5];
					vibean2.setCurrencyid(cur.getCurrency());
					vibean2.setReference((String)obj[6]);
					vibean2.setDescription((String)obj[7]);
					PurchaseOrder po=(PurchaseOrder)obj[8];
					vibean2.setPurchaseorderid(po.getPurchaseOrderNo());
					Organization org=(Organization)obj[9];
					vibean2.setOrgid(org.getOrgName());
					vibean2.setFy((String)obj[10]);
					Vendor vv=(Vendor)obj[11];
					vibean2.setVendorid(vv.getVendorName());
					vibeans.add(vibean2);
				}
			}
			request.setAttribute("vibeans", vibeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "vendorInvoiceHome";
	}
			@RequestMapping(value = "/vendorinvoiceEdit", method = RequestMethod.GET)
		public String editvi(
				@ModelAttribute("VENDORINVOICE") VendorInvoice vibean,
				BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model) {
				response.setCharacterEncoding("utf-8");
			List<VendorInvoice> viedit = new ArrayList<VendorInvoice>();
			List<VendorInvoiceLine> vilinelist = new ArrayList<VendorInvoiceLine>();
			// int processId = processBean.getProcessid();
			int viId = Integer.parseInt(request.getParameter("viedit"));

			try {
				List<VendorInvoice> list = viservice.EditVendorInvoiceservice(viId);
				//System.out.println(list);
				Iterator<VendorInvoice> iter = list.iterator();
				if (iter.hasNext()) {
					Object object = iter.next();
					VendorInvoice vib = (VendorInvoice) object;
					
					vibean.setEditvendorinvoiceid(vib.getVendorinvoiceid());
					
					vibean.setEditvendorinvoiceno(vib.getVendorinvoiceno());
					vibean.setEditvendorinvoicedate(dateService.dateFormat(dateService.dateParse(vib.getVendorinvoicedate(),"se"),"se"));
					vibean.setEditpostingdate(dateService.dateFormat(dateService.dateParse(vib.getPostingdate(),"se"),"se"));
					vibean.setEditcurrencyid(vib.getCurrencyid());
					vibean.setEditamount( vib.getAmount());
					vibean.setEditreference(vib.getReference());
					vibean.setEditdescription(vib.getDescription());
					vibean.setEditpurchaseorderid(vib.getPurchaseorderid());
					vibean.setEditorgid(vib.getOrgid());
					vibean.setEditfy(vib.getFy());	
					vibean.setEditvendorid(vib.getVendorid());
					
				
                    List<VendorInvoiceLine> listEdit =vib.getVendorinvoicelinebean();
					Iterator<VendorInvoiceLine> iterate = listEdit.iterator();
					while (iterate.hasNext()) {
						Object object2 = iterate.next();
						VendorInvoiceLine viledit = (VendorInvoiceLine) object2;
						VendorInvoiceLine vilineedit = new VendorInvoiceLine();
						vilineedit.setEditvendorinvoicelineid(viledit.getVendorinvoicelineid());
						Material mm=viledit.getMaterialdetail();
						vilineedit.setEditmaterialid(viledit.getMaterialid());
						vilineedit.setMaterialidName(mm.getMaterialName());
						//System.out.println(mm.getMaterialName());
						vilineedit.setEditqty(viledit.getQty());
						Uom uom=viledit.getUomdetail();
						vilineedit.setEdituomid(viledit.getUomid());
						vilineedit.setUomidName(uom.getUom());
						vilineedit.setEditprice(viledit.getPrice());
						vilineedit.setEdittax(viledit.getTax());
						vilinelist.add(vilineedit);
					}
					vibean.setEditvendorinvoicelinebean(vilinelist);
					
					viedit.add(vibean);

				}
				request.setAttribute("editvalues", viedit);
				request.setAttribute("vilinelist", vilinelist);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "vendorInvoiceHome";

		}
			@RequestMapping(value = "/VIDuplicateEditCheck", method = RequestMethod.POST)
			public @ResponseBody
			String checkrfqnameEdit(HttpServletRequest request,
					HttpServletResponse response,VendorInvoice vibean) {
				
				Long pname=null;
				
				
				try {

					String beforeedit = request.getParameter("vinameedit");
					int id=Integer.parseInt(request.getParameter("vieditid"));
					
					 pname=viservice.getVICountedit(beforeedit, id);
					if (pname!=0) {
						
						
						vibean.setEditvendorinvoiceno("");
						
						msgedit = "Warning ! Vendor Invoice No is already exists. Please try some other name";
						
					}
					if (pname==0) {
						
						vibean.setEditvendorinvoiceno("");
						
						msgedit  = null;
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return msgedit;
			}
				@RequestMapping(value = "/viUpdate", method = RequestMethod.POST)
		public String viUpdate(
				@ModelAttribute("VENDORINVOICE") VendorInvoice viUpdate,
				Model model, HttpServletRequest request,
				HttpServletResponse response) {
			response.setCharacterEncoding("UTF-8");
			List<VendorInvoiceLine> vilinelist = new ArrayList<VendorInvoiceLine>();
			String msg = null;
			String vilUpdate = null;
			String checked="",s1="0",s2="1";
			int ss=0;
			try {
			viUpdate.setVendorinvoiceid(viUpdate.getEditvendorinvoiceid());
			//System.out.println("invoice id is"+viUpdate.getEditvendorinvoiceid());
			viUpdate.setVendorinvoiceno(viUpdate.getEditvendorinvoiceno());
		//.out.println("che"+viUpdate.getEditvendorinvoiceno());
			viUpdate.setVendorinvoicedate(dateService.dateFormat(dateService.dateParse(viUpdate.getEditvendorinvoicedate(),"au"),"au"));
			viUpdate.setPostingdate(dateService.dateFormat(dateService.dateParse(viUpdate.getEditpostingdate(),"au"),"au"));
			viUpdate.setAmount(viUpdate.getEditamount());
			viUpdate.setCurrencyid(viUpdate.getEditcurrencyid());
			viUpdate.setReference(viUpdate.getEditreference());
			viUpdate.setDescription(viUpdate.getEditdescription());
			viUpdate.setPurchaseorderid(viUpdate.getEditpurchaseorderid());
			viUpdate.setOrgid(viUpdate.getEditorgid());
			viUpdate.setFy(viUpdate.getEditfy());
			viUpdate.setVendorid(viUpdate.getEditvendorid());
			
			
			int vilineid[] =viUpdate.getEditvendorinvoicelineid();
		//		System.out.println("dfs"+ vilineid[0]);
			String tax[]=viUpdate.getEdittax();
			if(tax!=null){
			String vimaterialid=viUpdate.getEditmaterialid();
			
			List<String> vimateriallist = Arrays.asList(vimaterialid.split(","));
			Object[] materialarray=vimateriallist.toArray();
			int qty[]=viUpdate.getEditqty();
			String uomid=viUpdate.getEdituomid();
			List<String> viuomlist=Arrays.asList(uomid.split(","));
			Object[] uom=viuomlist.toArray();
			
			String price[]=viUpdate.getEditprice();
		
					//System.out.println(tax);

			if (vimaterialid != null) {

				for (int r = 0; r < tax.length; r++) {
					int vilId = vilineid[r];
					if (vilId == 0) {
						
						VendorInvoiceLine vilinebean = new VendorInvoiceLine();
						vilinebean.setVendorinvoicelineid(vilineid[r]);
						vilinebean.setMaterialid(materialarray[r].toString());
						vilinebean.setQty(qty[r]);
						vilinebean.setUomid(uom[r].toString());
						vilinebean.setPrice(price[r]);
						vilinebean.setTax(tax[r]);
						vilinelist.add(vilinebean);

					} else {
							
                       VendorInvoiceLine vilinebean = new VendorInvoiceLine();
                        vilinebean.setVendorinvoicelineid(vilineid[r]);
						vilinebean.setMaterialid(materialarray[r].toString());
						vilinebean.setQty(qty[r]);
						vilinebean.setUomid(uom[r].toString());
						vilinebean.setPrice(price[r]);
						vilinebean.setTax(tax[r]);
						vilinelist.add(vilinebean);
						ss=vilineid[r];
					//	System.out.println("ss issss==="+ss);
						checked=request.getParameter("Checkdelete"+ss);
						//System.out.println("cheack values is" +checked);
						if(s2.equals(checked) )
						{
							
							
							viservice.deleteChildDetailsService(ss);
						//	System.out.println("Delete"+ss);
							
						}
						if(s1.equals(checked) || checked==null)
						{
							vilinelist.add(vilinebean);
							
						}
						
					}
					
					
				}
			}
			
			}
			
				
				viUpdate.setVendorinvoicelinebean(vilinelist);
				msg = viservice.updateVendorInvoiceservice(viUpdate);
				
				if (msg.equals("S")) {
					session=request.getSession(false);
					 Date date1 = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		     auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"U","Vendor Invoice","ROW" ,String.valueOf(viUpdate.getVendorinvoiceid()),"1",modifiedDate,session.getAttribute("userName").toString());
					request.setAttribute("VIUpdateSuccess",
							"Vendor Invoice Data Updated Successfully");
					model.addAttribute("VENDORINVOICE", new VendorInvoice());
				
				} else {
					vilUpdate = "Oops ! Vendor Invoice No Already Exists";
					request.setAttribute("VIUpdateFail",vilUpdate);
				}
			} catch (Exception e) {
				e.printStackTrace();
				vilUpdate = "Oops ! Vendor Invoice No Already Exists";
				request.setAttribute("VIUpdateFail",vilUpdate);
			}

			return "vendorInvoiceHome";
		}
		@RequestMapping(value = "/viDelete", method = RequestMethod.GET)
		public String viDelete(
				@ModelAttribute("VENDORINVOICE") VendorInvoice viDelete,
				Model model, HttpServletRequest request,
				HttpServletResponse response) {
			response.setCharacterEncoding("UTF-8");
			String rfqDelete = null;
			int rId = Integer.parseInt(request.getParameter("videlid"));
			

			try {
				String msg = viservice.deleteVendorInvoiceservice(rId);
				if (msg.equals("S")) {
					session=request.getSession(false);
					 Date date1 = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		     auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Vendor Invoice","ROW" ,String.valueOf(rId),"1",modifiedDate,session.getAttribute("userName").toString());
					request.setAttribute("VIDeleteSuccess",
							"Vendor Invoice Data Deleted Successfully");
					model.addAttribute("VENDORINVOICE", new VendorInvoice());
				} else {
					rfqDelete = "Vendor Invoice Data is Not Deleted Properly";
					request.setAttribute("VIDeleteFail",
							"Vendor Invoice Data is Not Deleted Properly");
					model.addAttribute("VENDORINVOICE", new VendorInvoice());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "vendorInvoiceHome";

		}
		@ModelAttribute("xmlItems")
		public Map<String, String> populatLabelDetails() {
			String name = "vendorinvoiceid";

			Map<String, String> map = new HashMap<String, String>();

			try {
				map = xmlService.populateXmlLabels(name);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}
		@RequestMapping(value="/viAdvanceSearch",method=RequestMethod.GET)
		public  String viAdvanceSearch(@ModelAttribute("VENDORINVOICE") VendorInvoice vibean,HttpServletRequest request,HttpServletResponse response)
		{
			response.setCharacterEncoding("UTF-8");
			//System.out.println("came to search");
		//String advanceSearchHidden=request.getParameter("advanceSearchHidden");
		
		List<VendorInvoice> vilist=null;
			
			String name1="vendorinvoiceid",s1=null,s2=null;

			 List<Object[]> returnString = null;
			
			 vilist=new ArrayList();
			 vibean.setAdvanceSearchHidden(1);
			try {
				returnString = xmlService.populateXml(name1);
				Iterator it=returnString.iterator();
				for (Object[] object : returnString) {
					VendorInvoice v=new VendorInvoice();
					
					s1=(String)object[0];
					s2=(String)object[1];
					v.setFirstLabel(s1);
					v.setSecondLabel(s2);
					vilist.add(v);
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			  request.setAttribute("viSearchAdvance",vilist);
			  
		return "vendorInvoiceHome";
		}
		@RequestMapping(value = "/viAdvanceSearchOperations", method= RequestMethod.POST)
		public  String viAdvanceSearchOperations(@ModelAttribute VendorInvoice vibean,HttpServletRequest request,HttpServletResponse response,Model model)
		{   
			List<VendorInvoice> vibeans=null;
			List<Object[]> objectsArray = null;
			
			response.setCharacterEncoding("UTF-8");
			vibeans=new ArrayList<VendorInvoice>();
		    String columns=vibean.getFirstLabel();
		    String operations=vibean.getOperations1();
		    String advanceSearchText=vibean.getAdvanceSearchText();
		   
	   	    if(advanceSearchText.length()!=0)
	   	    {
	   	    //	System.out.println("came to advance"+advanceSearchText.length());
		    objectsArray= viservice.VendorInvoiceadvance(columns, operations, advanceSearchText);
	   	    }
	   	    else
	   	    {
	   	     objectsArray= viservice.getVendorInvoice("ALL");
	   	    }
		    iterator=objectsArray.iterator();
		   while(iterator.hasNext())
		   {
				Object[] obj = (Object[]) iterator.next();
				VendorInvoice vibean2 = new VendorInvoice();
				vibean2.setVendorinvoiceid((Integer)obj[0]);
				vibean2.setVendorinvoiceno((String)obj[1]);
				vibean2.setVendorinvoicedate((String)obj[2]);
				vibean2.setPostingdate((String)obj[3]);

				vibean2.setAmount((Float)obj[4]);

				vibean2.setAmount((Integer)obj[4]);

				Currency cur=(Currency)obj[5];
				vibean2.setCurrencyid(cur.getCurrency());
				vibean2.setReference((String)obj[6]);
				vibean2.setDescription((String)obj[7]);
				PurchaseOrder po=(PurchaseOrder)obj[8];
				vibean2.setPurchaseorderid(po.getPurchaseOrderNo());
				Organization org=(Organization)obj[9];
				vibean2.setOrgid(org.getOrgName());
				vibean2.setFy((String)obj[10]);
				Vendor vv=(Vendor)obj[11];
				vibean2.setVendorid(vv.getVendorName());
				vibeans.add(vibean2);
		   }
		   
		   request.setAttribute("vibeans",vibeans);
	       model.addAttribute("VENDORINVOICE",new VendorInvoice());
		       
		    return "vendorInvoiceHome";
			}
		
		
		
	}

