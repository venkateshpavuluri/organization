/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class PaymentWithHold {	
	private int paymentWithHoldId;
	private int paymentId;
	private String withHoldReason;
	private String withHoldAmount;
	/**
	 * @return the withHoldReason
	 */
	public String getWithHoldReason() {
		return withHoldReason;
	}
	/**
	 * @param withHoldReason the withHoldReason to set
	 */
	public void setWithHoldReason(String withHoldReason) {
		this.withHoldReason = withHoldReason;
	}
	/**
	 * @return the withHoldAmount
	 */
	public String getWithHoldAmount() {
		return withHoldAmount;
	}
	/**
	 * @param withHoldAmount the withHoldAmount to set
	 */
	public void setWithHoldAmount(String withHoldAmount) {
		this.withHoldAmount = withHoldAmount;
	}
	/**
	 * @return the paymentWithHoldId
	 */
	public int getPaymentWithHoldId() {
		return paymentWithHoldId;
	}
	/**
	 * @param paymentWithHoldId the paymentWithHoldId to set
	 */
	public void setPaymentWithHoldId(int paymentWithHoldId) {
		this.paymentWithHoldId = paymentWithHoldId;
	}
	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
}
