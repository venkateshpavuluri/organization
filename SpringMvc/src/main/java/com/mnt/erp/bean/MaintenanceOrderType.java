package com.mnt.erp.bean;



/*
 * @author Naresh
 * @version 1.0  18-09-2013
 */

public class MaintenanceOrderType {

	private int maintOrderType_Id;
	private String maintOrderType;
    private int aid;
	
	private int maintOrderType_IdEdit;
	private String maintOrderTypeEdit;
	
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	//getter methods
	
	public int getMaintOrderType_Id() {
		return maintOrderType_Id;
	}
	public String getMaintOrderType() {
		return maintOrderType;
	}
	public int getAid() {
		return aid;
	}
	public int getMaintOrderType_IdEdit() {
		return maintOrderType_IdEdit;
	}
	public String getMaintOrderTypeEdit() {
		return maintOrderTypeEdit;
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
	
	//setter methods
	
	public void setMaintOrderType_Id(int maintOrderType_Id) {
		this.maintOrderType_Id = maintOrderType_Id;
	}
	public void setMaintOrderType(String maintOrderType) {
		this.maintOrderType = maintOrderType;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setMaintOrderType_IdEdit(int maintOrderType_IdEdit) {
		this.maintOrderType_IdEdit = maintOrderType_IdEdit;
	}
	public void setMaintOrderTypeEdit(String maintOrderTypeEdit) {
		this.maintOrderTypeEdit = maintOrderTypeEdit;
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
