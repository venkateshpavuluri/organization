package com.mnt.erp.bean;

public class EmpAdvanceReceipts {
private int earId;
private String earadvId;
private String receivedamount;
private String receiveddate;
private int month;
private String xmlLabel;
private String operations;
private String basicSearchId;
private EmpAdvance empadvrecbean;

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

public EmpAdvance getEmpadvrecbean() {
	return empadvrecbean;
}
public void setEmpadvrecbean(EmpAdvance empadvrecbean) {
	this.empadvrecbean = empadvrecbean;
}
public int getEarId() {
	return earId;
}
public void setEarId(int earId) {
	this.earId = earId;
}
public String getEaradvId() {
	return earadvId;
}
public void setEaradvId(String earadvId) {
	this.earadvId = earadvId;
}
public String getReceivedamount() {
	return receivedamount;
}
public void setReceivedamount(String receivedamount) {
	this.receivedamount = receivedamount;
}
public String getReceiveddate() {
	return receiveddate;
}
public void setReceiveddate(String receiveddate) {
	this.receiveddate = receiveddate;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}

}
