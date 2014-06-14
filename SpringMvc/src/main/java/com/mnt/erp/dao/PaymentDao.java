/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Payment;

/**
 * @author venkateshp
 *
 */
public interface PaymentDao {

	
	public int savePaymentDetails(Object object);
	public Long duplicateCheck(String name);
	public List<Object[]> searchPayment(); 
	public List<Object[]> basicSearchPayment(String dbField,String operation,String basicSearchId);
	public List<Payment> editPaymentDetails(int paymentId);
	public Long updateDuplicateCheck(String orgName,int orgId);
	public int updatePayment(Object object);
	public int deletePayment(int id);
	public List<Object[]> paymentAdvanceSearch(String payment);
	public List<Object[]> getPayment(String payment);
}
