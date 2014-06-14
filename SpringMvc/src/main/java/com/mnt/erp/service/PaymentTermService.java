
/**

 *
 */
package com.mnt.erp.service;

import java.util.List;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public interface PaymentTermService 
{

	public String addPaymentTerms(Object object,String userId,String userName);
	public List<Object[]> searchPaymentTerms();
	public List<Object[]> searchPaymentTermsWithId(int id);
	public String updatePaymentTerms(Object object);
	public String deletePaymentTerms(int id);
	public int checkDuplicate(String checkPaymentTermName);
	public int checkEditDuplicate(String checkPaymentTermName,int id);
	public List<Object[]> basicSearchPaymentTerm(String label,String operator,String searchName);

}
