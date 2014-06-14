package com.mnt.erp.bean;

public class MaterialPrice {
	private int materialPrice_Id;
	private String material_Id;
	private String amount;
	private String currency_Id;
	private String batchNo;
	private String perUnit;
	private String uOM_Id;
	private String validFrom;
	private String validTo;
	private String org_Id;
	private int aid;
	private Material material;
	private String materialName;
 
	
	//search properties
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	//Edit properties
	
	private int materialPrice_IdEdit;
	private String material_IdEdit;
	private String batchNoEdit;
	private String amountEdit;
	private String currency_IdEdit;
	private String perUnitEdit;
	private String uOM_IdEdit;
	private String validFromEdit;
	private String validToEdit;
	private String org_IdEdit;
	
	//get methods
	public String getMaterial_Id() {
		return material_Id;
	}
	public String getAmount() {
		return amount;
	}
	public String getCurrency_Id() {
		return currency_Id;
	}
	public String getPerUnit() {
		return perUnit;
	}
	public String getuOM_Id() {
		return uOM_Id;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public String getOrg_Id() {
		return org_Id;
	}
	public int getAid() {
		return aid;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getMaterial_IdEdit() {
		return material_IdEdit;
	}
	public String getAmountEdit() {
		return amountEdit;
	}
	
	public Material getMaterial() {
		return material;
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
	public int getMaterialPrice_Id() {
		return materialPrice_Id;
	}
	public int getMaterialPrice_IdEdit() {
		return materialPrice_IdEdit;
	}
	public String getCurrency_IdEdit() {
		return currency_IdEdit;
	}
	public String getPerUnitEdit() {
		return perUnitEdit;
	}
	public String getuOM_IdEdit() {
		return uOM_IdEdit;
	}
	
	public String getBatchNoEdit() {
		return batchNoEdit;
	}
	public String getValidFromEdit() {
		return validFromEdit;
	}
	public String getValidToEdit() {
		return validToEdit;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	public String getOrg_IdEdit() {
		return org_IdEdit;
	}
	
	//set methods
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setCurrency_Id(String currency_Id) {
		this.currency_Id = currency_Id;
	}
	public void setPerUnit(String perUnit) {
		this.perUnit = perUnit;
	}
	public void setuOM_Id(String uOM_Id) {
		this.uOM_Id = uOM_Id;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public void setOrg_Id(String org_Id) {
		this.org_Id = org_Id;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setMaterial_IdEdit(String material_IdEdit) {
		this.material_IdEdit = material_IdEdit;
	}
	public void setAmountEdit(String amountEdit) {
		this.amountEdit = amountEdit;
	}
	public void setCurrency_IdEdit(String currency_IdEdit) {
		this.currency_IdEdit = currency_IdEdit;
	}
	public void setPerUnitEdit(String perUnitEdit) {
		this.perUnitEdit = perUnitEdit;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setMaterialPrice_Id(int materialPrice_Id) {
		this.materialPrice_Id = materialPrice_Id;
	}
	public void setMaterialPrice_IdEdit(int materialPrice_IdEdit) {
		this.materialPrice_IdEdit = materialPrice_IdEdit;
	}
	public void setuOM_IdEdit(String uOM_IdEdit) {
		this.uOM_IdEdit = uOM_IdEdit;
	}
	public void setValidFromEdit(String validFromEdit) {
		this.validFromEdit = validFromEdit;
	}
	public void setValidToEdit(String validToEdit) {
		this.validToEdit = validToEdit;
	}
	public void setOrg_IdEdit(String org_IdEdit) {
		this.org_IdEdit = org_IdEdit;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
	public void setBatchNoEdit(String batchNoEdit) {
		this.batchNoEdit = batchNoEdit;
	}
	
	
	
	
	

	
	

}
