package com.mnt.erp.bean;

public class VendorMaterial {
	
private int vendorId;
private int materialId;
private String materialName;

private int vendorMatId;
private int materialIdEdit;
private String materialNameEdit;

/**
 * @return the vendorId
 */
public int getVendorId() {
	return vendorId;
}

/**
 * @return the materialIdEdit
 */
public int getMaterialIdEdit() {
	return materialIdEdit;
}

/**
 * @param materialIdEdit the materialIdEdit to set
 */
public void setMaterialIdEdit(int materialIdEdit) {
	this.materialIdEdit = materialIdEdit;
}

/**
 * @param vendorId the vendorId to set
 */
public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}

/**
 * @return the materialId
 */
public int getMaterialId() {
	return materialId;
}

/**
 * @param materialId the materialId to set
 */
public void setMaterialId(int materialId) {
	this.materialId = materialId;
}

/**
 * @return the vendorMatId
 */
public int getVendorMatId() {
	return vendorMatId;
}

/**
 * @param vendorMatId the vendorMatId to set
 */
public void setVendorMatId(int vendorMatId) {
	this.vendorMatId = vendorMatId;
}

/**
 * @return the materialName
 */
public String getMaterialName() {
	return materialName;
}

/**
 * @param materialName the materialName to set
 */
public void setMaterialName(String materialName) {
	this.materialName = materialName;
}

/**
 * @return the materialNameEdit
 */
public String getMaterialNameEdit() {
	return materialNameEdit;
}

/**
 * @param materialNameEdit the materialNameEdit to set
 */
public void setMaterialNameEdit(String materialNameEdit) {
	this.materialNameEdit = materialNameEdit;
}



	
}

