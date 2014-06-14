/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 *@version 1.0 06-02-2014
 */
public class ReceiptWithHold implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recWithHoldId;
	private int receiptId;
	private String withHoldReason;
	private String withHoldAmount;
	
	//Setter And Getter Methods
	
	public int getRecWithHoldId() {
		return recWithHoldId;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public String getWithHoldReason() {
		return withHoldReason;
	}
	public String getWithHoldAmount() {
		return withHoldAmount;
	}
	public void setRecWithHoldId(int recWithHoldId) {
		this.recWithHoldId = recWithHoldId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public void setWithHoldReason(String withHoldReason) {
		this.withHoldReason = withHoldReason;
	}
	public void setWithHoldAmount(String withHoldAmount) {
		this.withHoldAmount = withHoldAmount;
	}
	
	

}
