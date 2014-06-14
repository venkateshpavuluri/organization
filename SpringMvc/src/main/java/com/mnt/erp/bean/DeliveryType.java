/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

/**
 * This is DeliveryType pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class DeliveryType {
	
private int deliveryType_Id;
private String deliveryType;
private int aid;
private int eid;
private String xmlLabel;
private String operations;
private String basicSearchId;

/*Edit Properties*/

private String editDeliveryType;
private int editDeliveryType_Id;


/*getter methods of DeliveryType*/

public int getEid() {
	return eid;
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
public int getAid() {
	return aid;
}
public String getDeliveryType() {
	return deliveryType;
}

public int getDeliveryType_Id() {
	return deliveryType_Id;
}

public String getEditDeliveryType() {
	return editDeliveryType;
}

public int getEditDeliveryType_Id() {
	return editDeliveryType_Id;
}

/*setter methods of DeliveryType*/

public void setEid(int eid) {
	this.eid = eid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public void setEditDeliveryType_Id(int editDeliveryType_Id) {
	this.editDeliveryType_Id = editDeliveryType_Id;
}

public void setEditDeliveryType(String editDeliveryType) {
	this.editDeliveryType = editDeliveryType;
}

public void setDeliveryType_Id(int deliveryType_Id) {
	this.deliveryType_Id = deliveryType_Id;
}

public void setDeliveryType(String deliveryType) {
	this.deliveryType = deliveryType;
}

}
