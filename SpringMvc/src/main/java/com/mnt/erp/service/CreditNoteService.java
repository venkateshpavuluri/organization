/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface CreditNoteService  
{
	
/*	
	public List<Object[]> basicSearchPurchase(String label, String operator,String searchName);
	
	
	*/
	public String addCreditNote(Object object) ;
	public List<Object[]> getCustomerInvoiceId();
	public List<Object[]> getVendorInvoiceId();
	public Long checkCreditNote(String creditNote);
	public List<Object[]> getCreditNoteAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> basicSearchCreditNote();
	public List<Object[]> basicSearchCredit(String label, String operator,String searchName);
	public List<Object> editCreditNoteWithId(int id);
	public String deleteCreditNoteDetailList(int id);
	public String updateCreditNote(Object object);
	public int updateCheckCredit(String pno, int custId);
	public String deleteCreditNote(int id);
}
