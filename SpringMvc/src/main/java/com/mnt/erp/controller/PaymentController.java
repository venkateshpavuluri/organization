/**
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Payment;
import com.mnt.erp.bean.PaymentWithHold;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.VendorInvoice;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PaymentService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 *
 */
@Controller
public class PaymentController {
	public static Logger logger=Logger.getLogger(PaymentController.class);
	
	@Autowired
	PopulateService populateService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	XmlLabelsService xmlService;
	String sql;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;
	@Autowired
	DateConversionService dateService;
	@RequestMapping(value = "/paymentHome", method = RequestMethod.GET)
	public String gotoPayment(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");

			HttpSession session=request.getSession(false);
			List<String> list=menuService.getPrivilige("paymentHome.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
			model.addAttribute("paymentForm", new Payment());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "paymentView";
	}

	@RequestMapping(value = "/paymentAdd", method = RequestMethod.POST)
	public String paymentAdd(@ModelAttribute("paymentForm") Payment payment, HttpServletRequest request,
			HttpServletResponse response,Model model) {
	int successid=0;
		
		Long id = 0l;
	
		List<PaymentWithHold> paymentWithHolds=null;
		PaymentWithHold withHold=null;
	//	String duplicate = null;
		String res=null;
		try {
			payment.setPostingDate(dateService.dateFormat(dateService.dateParse(payment.getPostingDate(),"au"),"au"));
			payment.setChequeDate(dateService.dateFormat(dateService.dateParse(payment.getChequeDate(),"au"),"au"));
			payment.setChequeIssuedDate(dateService.dateFormat(dateService.dateParse(payment.getChequeIssuedDate(),"au"),"au"));
			payment.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse(payment.getChequeClearanceDate(),"au"),"au"));
			response.setCharacterEncoding("UTF-8");
			id = paymentService.duplicateCheck(payment.getPaymentNo());

			if (id == 0) {
				withHold=new PaymentWithHold();
				paymentWithHolds=new ArrayList<PaymentWithHold>();
				withHold.setWithHoldAmount(payment.getWithHoldAmount());
				withHold.setWithHoldReason(payment.getWithHoldReason());
				paymentWithHolds.add(withHold);
				payment.setPaymentWithhold(paymentWithHolds);
				if(payment.getVendorInvoiceId().equals(""))
				{
					payment.setVendorInvoiceId(null);
				}
				successid = paymentService.savePaymentDetails(payment);
				model.addAttribute("organization", new Organization());
				if (successid!=0) {
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Payment","ROW" ,String.valueOf(payment.getPaymentId()),"1",modifiedDate,session.getAttribute("userName").toString());
					res="redirect:paymentHome.mnt?list=" +"success"+"";
				} else {
					res= "redirect:paymentHome.mnt?listwar=" +"fail"+ "";
				}
			} else {

				request.setAttribute("duplicate", "Payment Number  is already exists. Please try some other name");
				payment.setAid(1);
				return "paymentView";
			}

		} catch (Exception e) {

			res= "redirect:paymentHome.mnt?listwar=" +"fail"+ "";
			
		}
		return res;
	}
	@RequestMapping(value = "/paymentSearch", method = RequestMethod.GET)
	public String searchOrganization(@ModelAttribute("paymentForm") Payment payment,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		//String msg = null;
		//String materialUpadte = null;
		//List<String> list = null;
		List<Payment> payments = null;
	//	int id = organization.getOrgId();
		String dbField = payment.getXmlLabel();
		String operation = payment.getOperations();
		String basicSearchId = payment.getBasicSearchId();

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
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			if (basicSearchId == "") {

				payments = paymentService.searchPayment();
				logger.info("list of values r=="+payments);

			} else {
			
				payments=paymentService.basicSearchPayment(dbField, operation, basicSearchId);
						
			}
			request.setAttribute("paymentSearch", payments);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "paymentView";
	}
	
	
	@RequestMapping(value = "/paymentEditHome", method = RequestMethod.GET)
	public String editPayment(@ModelAttribute("paymentForm") Payment payment,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		//String msg = null;
		//String materialUpadte = null;
		//List<String> list = null;
		List<Payment> payments = null;
		Payment paymentEdit=null;
		Iterator<Payment> iterator = null;
	
		int id = Integer.parseInt(request.getParameter("paymentEdit"));
		logger.info("payment id isss==="+id);
		try {
			response.setCharacterEncoding("UTF-8");
			payments =paymentService.editPaymentDetails(id); 

		
			if(payments!=null)
			{
			iterator = payments.iterator();
		
			while (iterator.hasNext()) {
				//sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.customerDetails,p.vendorInvoiceDetails,p.customerInvoiceDetails,p.chequeNo,p.chequeDate,p.paymentStatus,p.description,p.chequeIssuedBy,p.chequeIssuedDate,p.chequeClearanceStatus,p.chequeClearanceDate,p.organizationDetails,p.currencyDetails,p.paymentMethodDetails from Payment p ";
				Payment objects=(Payment)iterator.next();
			
				//sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankId,p.paymentTypeId,p.vendorId,p.customerId,p.vendorInvoiceId,p.customerInvoiceId,p.chequeNo,p.chequeDate,p.paymentStatus,p.description,p.chequeIssuedBy,p.chequeIssuedDate,p.chequeClearanceStatus,p.chequeClearanceDate,p.orgId,p.currecyId,p.paymentMethodId,p.paymentTypeId from Payment p ";			
				payment.setPaymentId(objects.getPaymentId());
				payment.setAccountNoEdit(objects.getAccountNo());
			//logger.info("account no iss==="+(String)objects[1]+"payment id==="+(Integer)objects[0]);
			payment.setPostingDateEdit(dateService.dateFormat(dateService.dateParse(objects.getPostingDate(),"se"),"se"));
			payment.setPaymentNoEdit(objects.getPaymentNo());
			payment.setAmountEdit(objects.getAmount());
			payment.setBankIdEdit(objects.getBankId());
          
               
			payment.setPaymentTypeIdEdit(objects.getPaymentTypeId());
			payment.setVendorIdEdit(objects.getVendorId());

			payment.setVendorInvoiceIdEdit(objects.getVendorInvoiceId());
               
        
			payment.setChequeNoEdit(objects.getChequeNo());
                payment.setChequeDateEdit(dateService.dateFormat(dateService.dateParse(objects.getChequeDate(),"se"),"se"));
                payment.setPaymentStatusEdit(objects.getPaymentStatus());
                payment.setDescriptionEdit(objects.getDescription());
                payment.setChequeIssuedByEdit(objects.getChequeIssuedBy());
                payment.setChequeIssuedDateEdit(dateService.dateFormat(dateService.dateParse(objects.getChequeIssuedDate(),"se"),"se"));
                payment.setChequeClearanceStatusEdit(objects.getChequeClearanceStatus());

                payment.setChequeClearanceDateEdit(dateService.dateFormat(dateService.dateParse(objects.getChequeClearanceDate(),"se"),"se"));
                payment.setOrgIdEdit(objects.getOrgId());

                payment.setCurrecyIdEdit(objects.getCurrecyId());
  

             
                payment.setPaymentMethodIdEdit(objects.getPaymentMethodId());
                List<PaymentWithHold> holds=(List<PaymentWithHold>)objects.getPaymentWithhold();
                if(holds!=null)
                {
                	Iterator paywithHold=holds.iterator();
                	while(paywithHold.hasNext())
                	{
                		PaymentWithHold hold=(PaymentWithHold)paywithHold.next();
                		payment.setWithHoldAmount(hold.getWithHoldAmount());
                		payment.setWithHoldReason(hold.getWithHoldReason());
                		payment.setPaymentwithholdid(hold.getPaymentWithHoldId());
                		logger.info("paymentwitholdid==="+hold.getPaymentWithHoldId());
                	}
                }
                
            

			}
			}

		
	request.setAttribute("paymentEditValues", "organizations");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "paymentView";
	}
	
	@RequestMapping(value="/paymentUpdate", method = RequestMethod.POST)
	public String updatePayment(
			@ModelAttribute("paymentForm") Payment payment,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int  msg = 0;
		Long duplicateId = 0l;
		List<PaymentWithHold> paymentWithHolds=null;
		PaymentWithHold hold=null;
		try {
			response.setCharacterEncoding("UTF-8");
		
			duplicateId = paymentService.updateDuplicateCheck(payment.getPaymentNoEdit(), payment.getPaymentId());
logger.info("duplicate id iss==="+duplicateId);
			if (duplicateId == 0) {
				hold=new PaymentWithHold();
				paymentWithHolds=new ArrayList<PaymentWithHold>();
				hold.setPaymentWithHoldId(payment.getPaymentwithholdid());
				logger.info("update==="+payment.getPaymentwithholdid()+"=="+payment.getPaymentId());
				hold.setWithHoldAmount(payment.getWithHoldAmount());
				hold.setWithHoldReason(payment.getWithHoldReason());
				paymentWithHolds.add(hold);
				payment.setPaymentWithhold(paymentWithHolds);
				msg =paymentService.updatePayment(payment);
				if (msg==1) {
					request.setAttribute("paymentUpdate",
							"Payment Data is updated Successfully");
				} else {
					request.setAttribute("paymentUpdateError",
							"Payment Data is not updated properly");
				}
			} else {

				request.setAttribute("paymentEditValues", "hello");
				request.setAttribute("paymentUpdateDuplicate",
						"Payment Numeber is already exists. Please try some other name");
				return "paymentView";
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("paymentUpdateError",
					"Payment Data is not updated properly");
			return "paymentView";
		}
		model.addAttribute("paymentForm", new Payment());
		return "paymentView";
	}

	
	@RequestMapping(value = "/paymentDelete", method = RequestMethod.GET)
	public String deletepayment(
			@ModelAttribute("paymentForm") Payment payment,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		int msg = 0;
		int id = 0;
		try {
			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request
					.getParameter("paymentCodeDelete"));
			logger.info("delete id iss==="+id);
			msg = paymentService.deletePayment(id);
			if (msg==1) {
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Payment","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("paymentDelete",
						"Payment Data is deleted Successfully");
			} else {
				request.setAttribute("paymentDeleteError",
						"Payment Data  is not deleted properly ");
			}
		} catch (Exception e) {
			request.setAttribute("paymentDeleteError",
					"Payment Data  is not deleted properly ");
			e.printStackTrace();
		}
		model.addAttribute("paymentForm", new Payment());
		return "paymentView";
	}
	
	
	
	@ModelAttribute("orgDetails")
	public Map<Integer, String> populateOrganigationIds() {
	
	
			sql="select o.orgId,o.orgName from Organization o";
			Map<Integer, String> map = populateOrgDetails(sql);
		return map;
	}

	
	@ModelAttribute("paymentMethodDetails")
	public Map<Integer, String> populatePaymentMethodDetails() {
		sql="select o.paymentMethodId,o.paymentMethodName from PaymentMethod o";
		Map<Integer, String> map = populateOrgDetails(sql);
		
		return map;
	}
	
	@ModelAttribute("vendorDetails")
	public Map<Integer, String> populateVendorDetails() {
	
	
			sql="select o.vendorId,o.vendorName from Vendor o";
			Map<Integer, String> map = populateOrgDetails(sql);
		return map;
	}
	
	/*@ModelAttribute("customerDetails")
	public Map<Integer, String> populateCustomerDetails() {
		
	
			sql="select o.customerId,o.customerName from CustomerBean o";
			Map<Integer, String> map = populateOrgDetails(sql);
		return map;
	}*/
	@ModelAttribute("vendorInvoiceDetails")
	public Map<Integer, String> populateVendorInvoiceDetails() {
		
	
			sql="select o.vendorinvoiceid,o.vendorinvoiceno from VendorInvoice o";
			Map<Integer, String> map = populateOrgDetails(sql);
		return map;
	}
	/*@ModelAttribute("customerInvoiceDetails")
	public Map<Integer, String> populateCustomerInvoiceDetails() {
		
	
			sql="select o.customerinvoiceid,o.customerinvoiceno from CustomerInvoice o";
			Map<Integer, String> map = populateOrgDetails(sql);
			return map;
	}*/
	@ModelAttribute("paymentTypeDetails")
	public Map<Integer, String> populatePaymentTypeDetails() {
		
	
			sql="select o.paymentTypeId,o.paymentType from PaymentType o";
			
			Map<Integer, String> map =populateOrgDetails(sql);
		return map;
	}
	@ModelAttribute("currencyDetails")
	public Map<Integer, String> populateCurrencyDetails() {
			sql="select o.currencyId,o.currency from Currency o";
			Map<Integer, String> map =populateOrgDetails(sql);
		return map;
	}
	
	@ModelAttribute("bankDetails")
	public Map<Integer, String> populateBankDetails() {
			sql="select o.bankid,o.bankname from HouseBankBean o";
			Map<Integer, String> map =populateOrgDetails(sql);
		return map;
	}
	
	public Map<Integer,String> populateOrgDetails(String sql)
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> list = null;
		
		try {
			list = populateService.poPulate(sql);
			Iterator<Object[]> 	iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;	
		
	}
	
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "paymentId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value="/paymentAdvanceSearch",method=RequestMethod.GET)
	public  String paymentAdvanceSearch(@ModelAttribute("paymentForm") Payment payment,HttpServletRequest request,HttpServletResponse response)
	{
		
		String name1="paymentId",s1=null,s2=null;

		 List<Object[]> returnString = null;
		List<Payment> payments=null;
		payments=new ArrayList<Payment>();
		payment.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			
			for (Object[] object : returnString) {
				Payment o=new Payment();
				
				s1=(String)object[0];
				s2=(String)object[1];
				o.setFirstLabel(s1);
				
				o.setSecondLabel(s2);
				payments.add(o);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  request.setAttribute("paymentSearchAdvance",payments);
		  return "paymentView";
	}
	
	
	
	@RequestMapping(value = "/paymentdvanceSearchOperations", method= RequestMethod.POST)
	public  String paymentAdvanceSearchOperations(@ModelAttribute Payment payment,HttpServletRequest request,HttpServletResponse response,Model model)
	{   
	
	  List<Payment>  paymentlist=new ArrayList<Payment>();
	    String columns=payment.getFirstLabel();
	    String operations=payment.getOperations1();
	    String advanceSearchText=payment.getAdvanceSearchText();
	   List<Object[]> objectsArray=null;
	   List<Payment> listOfPayments=null;
	   logger.info("search params=="+columns+"=="+operations+"=="+advanceSearchText);
	   if(advanceSearchText!=null)
	   {
   	    if(advanceSearchText.length()!=0)
   	    {
   	  
	    objectsArray= paymentService.getPaymentAdvance(columns, operations, advanceSearchText);
   	    }
   	    else
   	    {
   	     objectsArray= paymentService.getPayment("ALL");
   	    }
	   }
   	 listOfPayments=new ArrayList<Payment>();
	Iterator<Object[]>	iterator=objectsArray.iterator();
		while(iterator.hasNext())
		{
			payment=new Payment();
			Object[] objects=(Object[])iterator.next();
			payment.setPaymentId((Integer)objects[0]);
			payment.setAccountNo((String)objects[1]);
			payment.setPostingDate((String)objects[2]);
			payment.setPaymentNo((String)objects[3]);
			payment.setAmount((String)objects[4]);
			HouseBankBean bankBean=(HouseBankBean)objects[5];
			payment.setBankName(bankBean.getBankname());
			Vendor vendor=(Vendor)objects[7];
			payment.setVendorName(vendor.getVendorName());
			/*CustomerBean customerBean=(CustomerBean)objects[8];
			payment.setCustomerName(customerBean.getCustomerName());*/
			VendorInvoice vendorInvoice=(VendorInvoice)objects[8];
			payment.setVendorInvName(vendorInvoice.getVendorinvoiceno());
			/*CustomerInvoice customerInvoice=(CustomerInvoice)objects[10];
			payment.setCustomerInvName(customerInvoice.getCustomerinvoiceno());*/
			listOfPayments.add(payment);	
		}
	
	   request.setAttribute("paymentSearch",listOfPayments);
       model.addAttribute("paymentForm",new Payment());
	       
	    return "paymentView";
		}

	
	
	
}
