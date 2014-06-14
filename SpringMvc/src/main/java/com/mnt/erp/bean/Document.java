package com.mnt.erp.bean;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Document {
private int documentId;
private int aid;

private String documentUID;
private String documentName;
private String documentNo;
private String documentCategoryId;
private String documentTypeId;
private String documentPart;
private String version;
private String descripion;
private String departmentId;
private String employeeId;
private String path;
private String statusId;
private String parentDocId;

private List<DocumentObject> documentObject;
private DocumentCategory documentCategory;
private String documentCategoryName;
private DocumentType documentType;
private String documentTypeName;
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
private Status status;
private String statusName;
private ObjectBean objectBean;
private String objectName;
private MultipartFile documentFile;
private MultipartFile documentFileEdit;
public MultipartFile getDocumentFile() {
	return documentFile;
}
public void setDocumentFile(MultipartFile documentFile) {
	this.documentFile = documentFile;
}
public MultipartFile getDocumentFileEdit() {
	return documentFileEdit;
}
public void setDocumentFileEdit(MultipartFile documentFileEdit) {
	this.documentFileEdit = documentFileEdit;
}
private int[] documentEditt;
//child properties
private int documentObjectId;
private String objectId;
private String objectRefId;

//basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;

//Edit properties

private int documentObjectIdEdit;
//private int documentIdEdit;
private String objectIdEdit;
private String objectRefIdEdit;
public int getDocumentId() {
	return documentId;
}
public void setDocumentId(int documentId) {
	this.documentId = documentId;
}
public String getDocumentUID() {
	return documentUID;
}
public void setDocumentUID(String documentUID) {
	this.documentUID = documentUID;
}
public String getDocumentName() {
	return documentName;
}

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public void setDocumentName(String documentName) {
	this.documentName = documentName;
}
public String getDocumentNo() {
	return documentNo;
}
public void setDocumentNo(String documentNo) {
	this.documentNo = documentNo;
}
public String getDocumentCategoryId() {
	return documentCategoryId;
}
public void setDocumentCategoryId(String documentCategoryId) {
	this.documentCategoryId = documentCategoryId;
}
public String getDocumentTypeId() {
	return documentTypeId;
}
public void setDocumentTypeId(String documentTypeId) {
	this.documentTypeId = documentTypeId;
}
public String getDocumentPart() {
	return documentPart;
}
public void setDocumentPart(String documentPart) {
	this.documentPart = documentPart;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public String getDescripion() {
	return descripion;
}
public void setDescripion(String descripion) {
	this.descripion = descripion;
}
public String getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(String departmentId) {
	this.departmentId = departmentId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getStatusId() {
	return statusId;
}
public void setStatusId(String statusId) {
	this.statusId = statusId;
}
public String getParentDocId() {
	return parentDocId;
}
public void setParentDocId(String parentDocId) {
	this.parentDocId = parentDocId;
}
public List<DocumentObject> getDocumentObject() {
	return documentObject;
}
public void setDocumentObject(List<DocumentObject> documentObject) {
	this.documentObject = documentObject;
}
public int getDocumentObjectId() {
	return documentObjectId;
}
public void setDocumentObjectId(int documentObjectId) {
	this.documentObjectId = documentObjectId;
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
public int getDocumentObjectIdEdit() {
	return documentObjectIdEdit;
}
public void setDocumentObjectIdEdit(int documentObjectIdEdit) {
	this.documentObjectIdEdit = documentObjectIdEdit;
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
public DocumentCategory getDocumentCategory() {
	return documentCategory;
}
public void setDocumentCategory(DocumentCategory documentCategory) {
	this.documentCategory = documentCategory;
}
public String getDocumentCategoryName() {
	return documentCategoryName;
}
public void setDocumentCategoryName(String documentCategoryName) {
	this.documentCategoryName = documentCategoryName;
}
public DocumentType getDocumentType() {
	return documentType;
}
public void setDocumentType(DocumentType documentType) {
	this.documentType = documentType;
}
public String getDocumentTypeName() {
	return documentTypeName;
}
public void setDocumentTypeName(String documentTypeName) {
	this.documentTypeName = documentTypeName;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public String getStatusName() {
	return statusName;
}
public void setStatusName(String statusName) {
	this.statusName = statusName;
}
public int[] getDocumentEditt() {
	return documentEditt;
}
public void setDocumentEditt(int[] documentEditt) {
	this.documentEditt = documentEditt;
}



}
