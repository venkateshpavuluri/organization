/**
 * 
 */
package com.mnt.erp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Payment;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.VendorInvoice;
import com.mnt.erp.dao.PaymentDao;

/**
 * @author venkateshp
 *
 */
public class PaymentServiceImpl implements PaymentService {
public static Logger logger=Logger.getLogger(PaymentServiceImpl.class);
	/**
	 * @return the dao
	 */
	public PaymentDao getDao() {
		return dao;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(PaymentDao dao) {
		this.dao = dao;
	}
	PaymentDao dao;
	String msg;
	@Autowired
	DateConversionService dateService;
	@Override
	public int savePaymentDetails(Object object) {
		// TODO Auto-generated method stub
		int id=0;
		try
		{
			id=dao.savePaymentDetails(object);
			
		}
		catch(Exception e)
		{
			
		}
		
		
		return id;
	}
	@Override
	public Long duplicateCheck(String name) {
		// TODO Auto-generated method stub
		long id=dao.duplicateCheck(name);
		return id;
	}
	@Override
	public List<Payment> searchPayment() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		Iterator<Object[]> iterator=null;
		List<Payment> listOfPayments=null;
		Payment payment=null;
		try
		{
			
			//sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.organizationDetails,p.bankDetails,p.paymentTypeDetails,p.vendorDetails from Payment p ";
		//	sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.vendorInvoiceDetails,p.customerInvoiceDetails from Payment p ";
			list=dao.searchPayment();
			listOfPayments=new ArrayList<Payment>();
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				payment=new Payment();
				Object[] objects=(Object[])iterator.next();
				payment.setPaymentId((Integer)objects[0]);
				payment.setAccountNo((String)objects[1]);
				payment.setPostingDate(dateService.dateFormat(dateService.dateParse((String)objects[2],"se"),"se"));
				payment.setPaymentNo((String)objects[3]);
				payment.setAmount((String)objects[4]);
				HouseBankBean bankBean=(HouseBankBean)objects[5];
				payment.setBankName(bankBean.getBankname());
				Vendor vendor=(Vendor)objects[7];
				payment.setVendorName(vendor.getVendorName());
				listOfPayments.add(payment);	
			}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listOfPayments;
	}
	@Override
	public List<Payment> basicSearchPayment(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
	
		List<Object[]> list=null;
		Iterator<Object[]> iterator=null;
		List<Payment> listOfPayments=null;
		Payment payment=null;
		try
		{
			
			//sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.organizationDetails,p.bankDetails,p.paymentTypeDetails,p.vendorDetails from Payment p ";
		//	sql="select p.paymentId,p.accountNo,p.postingDate,p.paymentNo,p.amount,p.bankDetails,p.paymentTypeDetails,p.vendorDetails,p.vendorInvoiceDetails,p.customerInvoiceDetails from Payment p ";
			list=dao.basicSearchPayment(dbField, operation, basicSearchId);
			listOfPayments=new ArrayList<Payment>();
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				payment=new Payment();
				Object[] objects=(Object[])iterator.next();
				
				payment.setPaymentId((Integer)objects[0]);
				logger.info("payment id iss=="+(Integer)objects[0]);
				
				payment.setAccountNo((String)objects[1]);
				payment.setPostingDate(dateService.dateFormat(dateService.dateParse((String)objects[2],"se"),"se"));
				payment.setPaymentNo((String)objects[3]);
				payment.setAmount((String)objects[4]);
				HouseBankBean bankBean=(HouseBankBean)objects[5];
				payment.setBankName(bankBean.getBankname());
				Vendor vendor=(Vendor)objects[7];
				payment.setCustomerName(vendor.getVendorName());
			/*	CustomerBean customerBean=(CustomerBean)objects[8];
				payment.setCustomerName(customerBean.getCustomerName());*/
				VendorInvoice vendorInvoice=(VendorInvoice)objects[8];
				payment.setVendorInvName(vendorInvoice.getVendorinvoiceno());
				/*CustomerInvoice customerInvoice=(CustomerInvoice)objects[10];
				payment.setCustomerInvName(customerInvoice.getCustomerinvoiceno());*/
				listOfPayments.add(payment);	
			}
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listOfPayments;
	}
	@Override
	public List<Payment> editPaymentDetails(int paymentId) {
		// TODO Auto-generated method stub
		List<Payment> list=null;
		try
		{
			list=dao.editPaymentDetails(paymentId);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return list;
	}
	@Override
	public Long updateDuplicateCheck(String paymentNo, int paymentId) {
		// TODO Auto-generated method stub
		Long id=0l;
		try
		{
		id=dao.updateDuplicateCheck(paymentNo, paymentId);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public int updatePayment(Object object) {
		// TODO Auto-generated method stub
		int id=0;
		try
		{
			Payment payment=(Payment)object;
		
			payment.setAccountNo(payment.getAccountNoEdit());
			payment.setAmount(payment.getAmountEdit());
			payment.setBankId(payment.getBankIdEdit());
			payment.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse(payment.getChequeClearanceDateEdit(),"au"),"au"));
			payment.setChequeClearanceStatus(payment.getChequeClearanceStatusEdit());
			payment.setChequeDate(dateService.dateFormat(dateService.dateParse(payment.getChequeDateEdit(),"au"),"au"));
			payment.setChequeIssuedBy(payment.getChequeIssuedByEdit());
			payment.setChequeIssuedDate(dateService.dateFormat(dateService.dateParse(payment.getChequeIssuedDateEdit(),"au"),"au"));
		payment.setChequeNo(payment.getChequeNoEdit());
		payment.setCurrecyId(payment.getCurrecyIdEdit());
		/*payment.setCustomerId(payment.getCustomerIdEdit());
		payment.setCustomerInvoiceId(payment.getCustomerInvoiceIdEdit());*/
		payment.setDescription(payment.getDescriptionEdit());
		payment.setOrgId(payment.getOrgIdEdit());
		payment.setPaymentMethodId(payment.getPaymentMethodIdEdit());
		payment.setPaymentNo(payment.getPaymentNoEdit());
		payment.setPaymentStatus(payment.getPaymentStatusEdit());
		payment.setPaymentTypeId(payment.getPaymentTypeIdEdit());
		payment.setPostingDate(dateService.dateFormat(dateService.dateParse(payment.getPostingDateEdit(),"au"),"au"));
		payment.setVendorId(payment.getVendorIdEdit());
		payment.setVendorInvoiceId(payment.getVendorInvoiceIdEdit());
		if(payment.getVendorInvoiceIdEdit().equals(""))
		{
			payment.setVendorInvoiceId(null);
		}
		//payment.setOrganizationDetails(new Organization());
		
        id=dao.updatePayment(payment);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public int deletePayment(int id) {
		// TODO Auto-generated method stub
		int successId=0;
		try
		{
			successId=dao.deletePayment(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return successId;
	}
	@Override
	public List<Object[]> getPaymentAdvance(String columns, String opeator,
			String advanceSearchText) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String column[]=columns.split(",");
		logger.info("opeator is=="+opeator);
		String op[]=opeator.split(",");
		logger.info("search text is=="+advanceSearchText);
		String advanceSearch[]=advanceSearchText.split(",");
		String finalStringForSearch="";
		
		for(int i=0;i<advanceSearch.length;i++){
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			if (op[i].equals("_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = advanceSearch[i] +"%";
				

			} else if (op[i].equals("%_")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = "%" + advanceSearch[i];

			} else if (op[i].equals("%_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

			} else if (op[i].equals("=")) {
				column[i]=column[i];
				op[i]=" = ";
				advanceSearch[i] =   advanceSearch[i]  ;

			} else if (op[i].equals("!=")) {
				column[i]=column[i];
				op[i]=" != ";
				advanceSearch[i] =   advanceSearch[i]  ;

			}
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			finalStringForSearch=finalStringForSearch+"  p."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
		}
		
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = dao.paymentAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = dao.paymentAdvanceSearch("ALL");
		}
		return list;
	}
	@Override
	public List<Object[]> getPayment(String payment) {
		// TODO Auto-generated method stub
		List<Object[]> list=dao.getPayment(payment);
		return list;
	}
	

}
