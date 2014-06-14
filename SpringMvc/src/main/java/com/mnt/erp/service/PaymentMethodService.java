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
public interface PaymentMethodService
{
	
	public String addPaymentMethods(Object object,String userId,String userName);
	public List<Object[]> searchPaymentMethods();
	public List<Object[]> searchPaymentMethodsWithId(int id);
	public String updatePaymentMethods(Object object);
	public String deletePaymentMethods(int id);
	public int checkDuplicate(String checkPMethodName);
	public int checkEditDuplicate(String checkPMethodName,int id);
	public List<Object[]> basicSearchPaymentMethod(String label,String operator,String searchName);
}
