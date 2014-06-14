/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class InvoiceToPay {
	private String vendor;
	private String vendorInvoiceNo;
	private String amount;
	private String pendingAmount;
	private String recievedAmount;
	private String date;
	private String currency;
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getVendorInvoiceNo() {
		return vendorInvoiceNo;
	}
	public void setVendorInvoiceNo(String vendorInvoiceNo) {
		this.vendorInvoiceNo = vendorInvoiceNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPendingAmount() {
		return pendingAmount;
	}
	public void setPendingAmount(String pendingAmount) {
		this.pendingAmount = pendingAmount;
	}
	public String getRecievedAmount() {
		return recievedAmount;
	}
	public void setRecievedAmount(String recievedAmount) {
		this.recievedAmount = recievedAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
	
	
}
