/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author tparvathi
 *
 */
public class ObjectBean {
private int objectId;
private String object;
private int aid;
//basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;

public int getObjectId() {
	return objectId;
}
public void setObjectId(int objectId) {
	this.objectId = objectId;
}
public String getObject() {
	return object;
}
public void setObject(String object) {
	this.object = object;
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
