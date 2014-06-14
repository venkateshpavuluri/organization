/**
@Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author sailajach
 * @version 1.0 10-12-2013
 * @Build 0.0
 * 
 *
 */
public class PaymentType {
	
	/*=======================Bean properties======================*/
	private int paymentTypeId;
	private String paymentType;
	
	private int paymentTypeIdEditt;
	private String paymentTypeEditt;
	
	private int aid;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	
	/*=====================Getters and Setters====================*/
	
	public int getPaymentTypeId() {
		return paymentTypeId;
	}
	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getPaymentTypeIdEditt() {
		return paymentTypeIdEditt;
	}
	public void setPaymentTypeIdEditt(int paymentTypeIdEditt) {
		this.paymentTypeIdEditt = paymentTypeIdEditt;
	}
	public String getPaymentTypeEditt() {
		return paymentTypeEditt;
	}
	public void setPaymentTypeEditt(String paymentTypeEditt) {
		this.paymentTypeEditt = paymentTypeEditt;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	

}
