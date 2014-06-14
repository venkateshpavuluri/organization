/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author kirangangone
 * @version 1.0
 *@build 0.0
 */
public interface CreditNoteDao 
{
	public List<Object[]> getCustomerInvoiceId();
	public List<Object[]> getVendorInvoiceId();
	public String addCreditNote(Object object);
	public Long checkCreditNote(String creditNote);
	public List<Object[]> basicSearchCreditNote();
	public List<Object[]> setCreditNoteAdvanceSearch(String purchase);
	public List<Object[]> basicSearchCredit(String label, String operator,
			String searchName); 
	public List<Object> editCreditNoteWithId(int cId);
	public String deleteCreditNoteDetailList(int id); 
	public String updateCreditNote(Object object);
	public int updateCheckCredit(String pno, int custId);
	public String deleteCreditNote(int id); 
	/*	
	
	
	
	
	
	


	
	
	
	public List<Object[]> purchaseOrderNumGet(String s);
	public List<Object[]> getStepUser();*/
	
	//public String saveWorkFlowListDaoDetails(Object object);

	
}
