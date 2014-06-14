/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author tparvathi
 * @date 27-3-2014
 */
public class CostCenter {
private int costCenterId;
private String costCenter;
private int aid;


//basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;

//Edit properties
private int costCenterIdEdit;
private String costCenterEdit;

//getter methods

public int getCostCenterId() {
	return costCenterId;
}
public String getCostCenter() {
	return costCenter;
}
public String getXmlLabel() {
	return xmlLabel;
}

public int getAid() {
	return aid;
}
public String getOperations() {
	return operations;
}
public String getBasicSearchId() {
	return basicSearchId;
}
public int getCostCenterIdEdit() {
	return costCenterIdEdit;
}
public String getCostCenterEdit() {
	return costCenterEdit;
}

//setter methods

public void setCostCenterId(int costCenterId) {
	this.costCenterId = costCenterId;
}
public void setCostCenter(String costCenter) {
	this.costCenter = costCenter;
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
public void setCostCenterIdEdit(int costCenterIdEdit) {
	this.costCenterIdEdit = costCenterIdEdit;
}
public void setCostCenterEdit(String costCenterEdit) {
	this.costCenterEdit = costCenterEdit;
}
public void setAid(int aid) {
	this.aid = aid;
}




}
