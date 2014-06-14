package com.mnt.erp.bean;

/**
 * 
 * @Author parvathi
 * @Date 27-3-2014
 */
public class SamplingType {
private int samplingTypeId;
private String samplingTypeName;
private int aid;

//basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;

//Edit  properties
private int samplingTypeIdEdit;
private String samplingTypeNameEdit;

//getter methods
public int getSamplingTypeId() {
	return samplingTypeId;
}
public String getSamplingTypeName() {
	return samplingTypeName;
}
public int getAid() {
	return aid;
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
public int getSamplingTypeIdEdit() {
	return samplingTypeIdEdit;
}
public String getSamplingTypeNameEdit() {
	return samplingTypeNameEdit;
}
//setters methods
public void setSamplingTypeId(int samplingTypeId) {
	this.samplingTypeId = samplingTypeId;
}
public void setSamplingTypeName(String samplingTypeName) {
	this.samplingTypeName = samplingTypeName;
}
public void setAid(int aid) {
	this.aid = aid;
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
public void setSamplingTypeIdEdit(int samplingTypeIdEdit) {
	this.samplingTypeIdEdit = samplingTypeIdEdit;
}
public void setSamplingTypeNameEdit(String samplingTypeNameEdit) {
	this.samplingTypeNameEdit = samplingTypeNameEdit;
}


}
