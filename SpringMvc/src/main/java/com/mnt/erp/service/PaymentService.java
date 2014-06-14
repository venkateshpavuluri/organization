/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Payment;


/**
 * @author venkateshp
 *
 */
public interface PaymentService {
	public int savePaymentDetails(Object object);
	public Long duplicateCheck(String name);
	public java.util.List<Payment> searchPayment();
public java.util.List<Payment>	basicSearchPayment(String dbField,String operation,String basicSearchId);
public List<Payment> editPaymentDetails(int paymentId);
public Long updateDuplicateCheck(String paymentNo,int paymentId);
public int updatePayment(Object object);
public int deletePayment(int id);
public List<Object[]> getPaymentAdvance(String columns,String opeator,String advanceSearchText);
public List<Object[]> getPayment(String payment);
}
