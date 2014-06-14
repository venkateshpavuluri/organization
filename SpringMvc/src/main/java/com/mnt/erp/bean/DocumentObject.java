package com.mnt.erp.bean;

public class DocumentObject {
private int documentObjectId;
private int documentId;
private String objectId;
private String objectRefId;

//Edit properties

private int documentObjectIdEdit;
private int documentIdEdit;
private String objectIdEdit;
private String objectRefIdEdit;
private ObjectBean objectBean;
private String objectName;
public int getDocumentObjectId() {
	return documentObjectId;
}
public void setDocumentObjectId(int documentObjectId) {
	this.documentObjectId = documentObjectId;
}
public int getDocumentId() {
	return documentId;
}
public void setDocumentId(int documentId) {
	this.documentId = documentId;
}
public String getObjectId() {
	return objectId;
}
public void setObjectId(String objectId) {
	this.objectId = objectId;
}
public String getObjectRefId() {
	return objectRefId;
}
public void setObjectRefId(String objectRefId) {
	this.objectRefId = objectRefId;
}
public int getDocumentObjectIdEdit() {
	return documentObjectIdEdit;
}
public void setDocumentObjectIdEdit(int documentObjectIdEdit) {
	this.documentObjectIdEdit = documentObjectIdEdit;
}
public int getDocumentIdEdit() {
	return documentIdEdit;
}
public void setDocumentIdEdit(int documentIdEdit) {
	this.documentIdEdit = documentIdEdit;
}
public String getObjectIdEdit() {
	return objectIdEdit;
}
public void setObjectIdEdit(String objectIdEdit) {
	this.objectIdEdit = objectIdEdit;
}
public String getObjectRefIdEdit() {
	return objectRefIdEdit;
}
public void setObjectRefIdEdit(String objectRefIdEdit) {
	this.objectRefIdEdit = objectRefIdEdit;
}
public ObjectBean getObjectBean() {
	return objectBean;
}
public void setObjectBean(ObjectBean objectBean) {
	this.objectBean = objectBean;
}
public String getObjectName() {
	return objectName;
}
public void setObjectName(String objectName) {
	this.objectName = objectName;
}


}
