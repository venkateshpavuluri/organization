/**
@Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author sailajach
 *  @version 1.0 10-12-2013
 * @Build 0.0
 *
 */
public interface PaymentTypeService {
	
	public String addPaymentType(Object object,String userId,String userName);
	public List<Object[]> searchPaymentType();
	public List<Object[]> searchPaymentTypeWithId(int id);
	public String updatePaymentType(Object object);
	public String deletePaymentType(int id);
	public int checkDuplicate(String checkPaymentType);
	public int checkEditDuplicate(String checkPaymentType,int id);
	public List<Object[]> basicSearchPaymentType(String label,String operator,String searchName);

}
