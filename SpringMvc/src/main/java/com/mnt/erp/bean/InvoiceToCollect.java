/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class InvoiceToCollect {
private String customer;
private String customerNo;
private String amount;
private String pendingAmount;
private String recievedAmount;
private String date;
private String currency;


public String getRecievedAmount() {
	return recievedAmount;
}
public void setRecievedAmount(String recievedAmount) {
	this.recievedAmount = recievedAmount;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public String getCustomer() {
	return customer;
}
public void setCustomer(String customer) {
	this.customer = customer;
}
public String getCustomerNo() {
	return customerNo;
}
public void setCustomerNo(String customerNo) {
	this.customerNo = customerNo;
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
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}


}
