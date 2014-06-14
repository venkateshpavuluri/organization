package com.mnt.erp.bean;

public class ProductionOrderType {
	private int prodOrderTypeId;
	private String prodOrderType;
	private int prodOrderTypeIdEdit;
	private String prodOrderTypeNameEdit;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private int aid;
	
	
	public int getProdOrderTypeId() {
		return prodOrderTypeId;
	}
	public void setProdOrderTypeId(int prodOrderTypeId) {
		this.prodOrderTypeId = prodOrderTypeId;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getProdOrderType() {
		return prodOrderType;
	}
	public void setProdOrderType(String prodOrderType) {
		this.prodOrderType = prodOrderType;
	}
	
	public int getProdOrderTypeIdEdit() {
		return prodOrderTypeIdEdit;
	}
	public void setProdOrderTypeIdEdit(int prodOrderTypeIdEdit) {
		this.prodOrderTypeIdEdit = prodOrderTypeIdEdit;
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
	public String getProdOrderTypeNameEdit() {
		return prodOrderTypeNameEdit;
	}
	public void setProdOrderTypeNameEdit(String prodOrderTypeNameEdit) {
		this.prodOrderTypeNameEdit = prodOrderTypeNameEdit;
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
