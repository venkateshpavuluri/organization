package com.mnt.erp.bean;

import java.util.List;

public class PrevMaintenance {
private int prevMaintenanceSchId;
private int aid;
private String prevMaintenanceSchNo;
private String equipmentId;
private List<PrevMaintenanceSchCat> prevMaintenanceSchCat;
private EquipmentBean equipmentBean;
private String equipmentName;
private String maintenanceCategoryName;
private String maintenanceTypeBeanName;
private int[] PrevMainEditt;
private MaintenanceCategory maintenanceCategory;
private maintenanceTypeBean maintenanceTypeDetails;
//Edit properties
private int prevMaintenanceSchIdEdit;
private String prevMaintenanceSchNoEdit;
private String equipmentIdEdit;
//PrevMaintenanceSchCat properties

private int prevMaintenanceSchCatId;
private String maintenanceCategoryId;
private String maintenanceTypeId;
private String schDT;

//PrevMaintenanceSchCat Edit properties
private int prevMaintenanceSchCatIdEdit;
private String maintenanceCategoryIdEdit;
private String maintenanceTypeIdEdit;
private String schDTEdit;
//basic search properties

private String xmlLabel;
private String operations;
private String basicSearchId;
public int getPrevMaintenanceSchId() {
	return prevMaintenanceSchId;
}
public String getPrevMaintenanceSchNo() {
	return prevMaintenanceSchNo;
}
public String getEquipmentId() {
	return equipmentId;
}
public int getPrevMaintenanceSchIdEdit() {
	return prevMaintenanceSchIdEdit;
}
public String getPrevMaintenanceSchNoEdit() {
	return prevMaintenanceSchNoEdit;
}
public String getEquipmentIdEdit() {
	return equipmentIdEdit;
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
public void setPrevMaintenanceSchId(int prevMaintenanceSchId) {
	this.prevMaintenanceSchId = prevMaintenanceSchId;
}
public void setPrevMaintenanceSchNo(String prevMaintenanceSchNo) {
	this.prevMaintenanceSchNo = prevMaintenanceSchNo;
}
public void setEquipmentId(String equipmentId) {
	this.equipmentId = equipmentId;
}
public void setPrevMaintenanceSchIdEdit(int prevMaintenanceSchIdEdit) {
	this.prevMaintenanceSchIdEdit = prevMaintenanceSchIdEdit;
}
public void setPrevMaintenanceSchNoEdit(String prevMaintenanceSchNoEdit) {
	this.prevMaintenanceSchNoEdit = prevMaintenanceSchNoEdit;
}
public void setEquipmentIdEdit(String equipmentIdEdit) {
	this.equipmentIdEdit = equipmentIdEdit;
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
public List<PrevMaintenanceSchCat> getPrevMaintenanceSchCat() {
	return prevMaintenanceSchCat;
}
public void setPrevMaintenanceSchCat(
		List<PrevMaintenanceSchCat> prevMaintenanceSchCat) {
	this.prevMaintenanceSchCat = prevMaintenanceSchCat;
}
public int getPrevMaintenanceSchCatId() {
	return prevMaintenanceSchCatId;
}
public void setPrevMaintenanceSchCatId(int prevMaintenanceSchCatId) {
	this.prevMaintenanceSchCatId = prevMaintenanceSchCatId;
}
public String getMaintenanceCategoryId() {
	return maintenanceCategoryId;
}
public void setMaintenanceCategoryId(String maintenanceCategoryId) {
	this.maintenanceCategoryId = maintenanceCategoryId;
}
public String getMaintenanceTypeId() {
	return maintenanceTypeId;
}
public void setMaintenanceTypeId(String maintenanceTypeId) {
	this.maintenanceTypeId = maintenanceTypeId;
}
public String getSchDT() {
	return schDT;
}
public void setSchDT(String schDT) {
	this.schDT = schDT;
}
public EquipmentBean getEquipmentBean() {
	return equipmentBean;
}
public void setEquipmentBean(EquipmentBean equipmentBean) {
	this.equipmentBean = equipmentBean;
}
public String getEquipmentName() {
	return equipmentName;
}
public void setEquipmentName(String equipmentName) {
	this.equipmentName = equipmentName;
}
public String getMaintenanceCategoryName() {
	return maintenanceCategoryName;
}
public void setMaintenanceCategoryName(String maintenanceCategoryName) {
	this.maintenanceCategoryName = maintenanceCategoryName;
}
public String getMaintenanceTypeBeanName() {
	return maintenanceTypeBeanName;
}
public void setMaintenanceTypeBeanName(String maintenanceTypeBeanName) {
	this.maintenanceTypeBeanName = maintenanceTypeBeanName;
}
public int getPrevMaintenanceSchCatIdEdit() {
	return prevMaintenanceSchCatIdEdit;
}
public void setPrevMaintenanceSchCatIdEdit(int prevMaintenanceSchCatIdEdit) {
	this.prevMaintenanceSchCatIdEdit = prevMaintenanceSchCatIdEdit;
}
public String getMaintenanceCategoryIdEdit() {
	return maintenanceCategoryIdEdit;
}
public void setMaintenanceCategoryIdEdit(String maintenanceCategoryIdEdit) {
	this.maintenanceCategoryIdEdit = maintenanceCategoryIdEdit;
}
public String getMaintenanceTypeIdEdit() {
	return maintenanceTypeIdEdit;
}
public void setMaintenanceTypeIdEdit(String maintenanceTypeIdEdit) {
	this.maintenanceTypeIdEdit = maintenanceTypeIdEdit;
}
public String getSchDTEdit() {
	return schDTEdit;
}
public void setSchDTEdit(String schDTEdit) {
	this.schDTEdit = schDTEdit;
}
public MaintenanceCategory getMaintenanceCategory() {
	return maintenanceCategory;
}
public void setMaintenanceCategory(MaintenanceCategory maintenanceCategory) {
	this.maintenanceCategory = maintenanceCategory;
}
public maintenanceTypeBean getMaintenanceTypeDetails() {
	return maintenanceTypeDetails;
}
public void setMaintenanceTypeDetails(maintenanceTypeBean maintenanceTypeDetails) {
	this.maintenanceTypeDetails = maintenanceTypeDetails;
}
public int[] getPrevMainEditt() {
	return PrevMainEditt;
}
public void setPrevMainEditt(int[] prevMainEditt) {
	PrevMainEditt = prevMainEditt;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}



}
