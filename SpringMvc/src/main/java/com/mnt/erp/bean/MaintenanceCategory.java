/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author tparvathi
 *
 */
public class MaintenanceCategory {
private int maintenanceCategoryId;
private String maintenanceCategory;
private String maintananceCategoryEdit;
private int aid;
private String xmlLabel;
private String operations;
private String basicSearchId;

public String getMaintananceCategoryEdit() {
    return maintananceCategoryEdit;
}
public void setMaintananceCategoryEdit(String maintananceCategoryEdit) {
    this.maintananceCategoryEdit = maintananceCategoryEdit;
}
public int getAid() {
    return aid;
}
public void setAid(int aid) {
    this.aid = aid;
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
public int getMaintenanceCategoryId() {
	return maintenanceCategoryId;
}
public void setMaintenanceCategoryId(int maintenanceCategoryId) {
	this.maintenanceCategoryId = maintenanceCategoryId;
}
public String getMaintenanceCategory() {
	return maintenanceCategory;
}
public void setMaintenanceCategory(String maintenanceCategory) {
	this.maintenanceCategory = maintenanceCategory;
}

}
