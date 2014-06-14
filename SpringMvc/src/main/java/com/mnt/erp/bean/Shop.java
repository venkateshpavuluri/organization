package com.mnt.erp.bean;

public class Shop {
private int shop_Id;
private String shopCode;
private String shopName;
private String description;
private String plant_Id;
private int aid;


//Edit properties
private int shop_IdEdit;
private String shopCodeEdit;
private String shopNameEdit;
private String descriptionEdit;
private String plant_IdEdit;




private String xmlLabel;
private String operations;
private String basicSearchId;




//getter methods
public int getShop_Id() {
	return shop_Id;
}
public String getShopCode() {
	return shopCode;
}
public String getShopName() {
	return shopName;
}
public String getDescription() {
	return description;
}
public String getPlant_Id() {
	return plant_Id;
}
public int getShop_IdEdit() {
	return shop_IdEdit;
}
public String getShopCodeEdit() {
	return shopCodeEdit;
}
public String getShopNameEdit() {
	return shopNameEdit;
}
public String getDescriptionEdit() {
	return descriptionEdit;
}
public String getPlant_IdEdit() {
	return plant_IdEdit;
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
public void setAid(int aid) {
	this.aid = aid;
}
//setter methods
public void setShop_Id(int shop_Id) {
	this.shop_Id = shop_Id;
}
public void setShopCode(String shopCode) {
	this.shopCode = shopCode;
}
public void setShopName(String shopName) {
	this.shopName = shopName;
}
public void setDescription(String description) {
	this.description = description;
}
public void setPlant_Id(String plant_Id) {
	this.plant_Id = plant_Id;
}
public void setShop_IdEdit(int shop_IdEdit) {
	this.shop_IdEdit = shop_IdEdit;
}
public void setShopCodeEdit(String shopCodeEdit) {
	this.shopCodeEdit = shopCodeEdit;
}
public void setShopNameEdit(String shopNameEdit) {
	this.shopNameEdit = shopNameEdit;
}
public void setDescriptionEdit(String descriptionEdit) {
	this.descriptionEdit = descriptionEdit;
}
public void setPlant_IdEdit(String plant_IdEdit) {
	this.plant_IdEdit = plant_IdEdit;
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
