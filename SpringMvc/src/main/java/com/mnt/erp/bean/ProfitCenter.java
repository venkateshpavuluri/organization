package com.mnt.erp.bean;

public class ProfitCenter {
private int profitCenterId;
private String profitCenter;
private int aid;

//basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;

//Edit properties
private int profitCenterIdEdit;
private String profitCenterEdit;

//getter methods
public int getProfitCenterId() {
	return profitCenterId;
}
public String getProfitCenter() {
	return profitCenter;
}
public String getXmlLabel() {
	return xmlLabel;
}
public String getOperations() {
	return operations;
}
public String getBasicSearchId() {
	return basicSearchId;
}
public int getProfitCenterIdEdit() {
	return profitCenterIdEdit;
}
public String getProfitCenterEdit() {
	return profitCenterEdit;
}

//setter methods
public void setProfitCenterId(int profitCenterId) {
	this.profitCenterId = profitCenterId;
}
public void setProfitCenter(String profitCenter) {
	this.profitCenter = profitCenter;
}
public void setXmlLabel(String xmlLabel) {
	this.xmlLabel = xmlLabel;
}
public void setOperations(String operations) {
	this.operations = operations;
}
public void setBasicSearchId(String basicSearchId) {
	this.basicSearchId = basicSearchId;
}
public void setProfitCenterIdEdit(int profitCenterIdEdit) {
	this.profitCenterIdEdit = profitCenterIdEdit;
}
public void setProfitCenterEdit(String profitCenterEdit) {
	this.profitCenterEdit = profitCenterEdit;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}


}
