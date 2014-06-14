/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author tparvathi
 *
 */
public class PrevMaintenanceSchCat {
private int prevMaintenanceSchCatId;
private int prevMaintenanceSchId;
private String maintenanceCategoryId;
private String maintenanceTypeId;
private String schDT;
private String PrevMainEditt;

public String getPrevMainEditt() {
	return PrevMainEditt;
}
public void setPrevMainEditt(String prevMainEditt) {
	PrevMainEditt = prevMainEditt;
}
private MaintenanceCategory maintenanceCategory;
private maintenanceTypeBean maintenanceTypeDetails;
private String maintenanceCategoryName;
private String maintenanceTypeBeanName;
//Edit properties
private int prevMaintenanceSchCatIdEdit;
private int prevMaintenanceSchIdEdit;
private String maintenanceCategoryIdEdit;
private String maintenanceTypeIdEdit;
private String schDTEdit;
public int getPrevMaintenanceSchCatId() {
	return prevMaintenanceSchCatId;
}
public void setPrevMaintenanceSchCatId(int prevMaintenanceSchCatId) {
	this.prevMaintenanceSchCatId = prevMaintenanceSchCatId;
}
public int getPrevMaintenanceSchId() {
	return prevMaintenanceSchId;
}
public void setPrevMaintenanceSchId(int prevMaintenanceSchId) {
	this.prevMaintenanceSchId = prevMaintenanceSchId;
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
public int getPrevMaintenanceSchCatIdEdit() {
	return prevMaintenanceSchCatIdEdit;
}
public void setPrevMaintenanceSchCatIdEdit(int prevMaintenanceSchCatIdEdit) {
	this.prevMaintenanceSchCatIdEdit = prevMaintenanceSchCatIdEdit;
}
public int getPrevMaintenanceSchIdEdit() {
	return prevMaintenanceSchIdEdit;
}
public void setPrevMaintenanceSchIdEdit(int prevMaintenanceSchIdEdit) {
	this.prevMaintenanceSchIdEdit = prevMaintenanceSchIdEdit;
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

}
