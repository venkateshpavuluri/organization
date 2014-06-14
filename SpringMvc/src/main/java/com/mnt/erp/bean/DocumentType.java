package com.mnt.erp.bean;

public class DocumentType {

	private int documentType_Id;
	private String documentType;
	private int aid;

    /*Basic search field*/
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	/*Edit properties*/
	private int documentType_IdEdit;
	private String documentTypeEdit;
	
	
	
	/*getter methods*/
	
	public int getDocumentType_Id() {
		return documentType_Id;
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

	public int getAid() {
		return aid;
	}

	public String getDocumentType() {
		return documentType;
	}
	public int getDocumentType_IdEdit() {
		return documentType_IdEdit;
	}
	public String getDocumentTypeEdit() {
		return documentTypeEdit;
	}
	
	/*setter methods*/
	

	public void setDocumentType_Id(int documentType_Id) {
		this.documentType_Id = documentType_Id;
	}
	
	public void setDocumentType_IdEdit(int documentType_IdEdit) {
		this.documentType_IdEdit = documentType_IdEdit;
	}
	public void setDocumentTypeEdit(String documentTypeEdit) {
		this.documentTypeEdit = documentTypeEdit;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
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
	
	
}
