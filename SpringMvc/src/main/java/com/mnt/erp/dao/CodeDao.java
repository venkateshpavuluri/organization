/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Code;

/**
 * @author kirangangone
 * @version 1.0
 *@build 0.0
 */
public interface CodeDao 
{
	
	public String saveCode(Code code,String userId,String userName);
	public Long duplicateCheckCode(String code,String codeGroupId);
	public Long duplicateCheckCodeUpdate(String code,String codeGroupId,int id);
	public List<Object[]> getCodeGroupId();
	public List<Object[]> basicSearchCode(String label, String operator,String searchName);
	public List<Object> editCode(int cId);
	public String updateCode(Code code);
	public String deleteCode(int id);
	/*public List<Object[]> getCustomerInvoiceId();
	public List<Object[]> getVendorInvoiceId();
	public String addCreditNote(Object object);
	public Long checkCreditNote(String creditNote);
	
	public List<Object[]> setCreditNoteAdvanceSearch(String purchase);
	public List<Object[]> basicSearchCredit(String label, String operator,
			String searchName); 
	
	public String deleteCreditNoteDetailList(int id); 
	
	public int updateCheckCredit(String pno, int custId);
	public String deleteCode(int id); */
	}
