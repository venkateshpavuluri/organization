

/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * This is purchaseReqLine pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class PurchaseReqLine {
private int purchaseReqLine_Id;
private int purchaseReq_Id;
private String material_Id;
private String qty;
private String uom;
private String requiredDate;
private String status_Id;
private String plant_Id;
private String storageLoc_Id; 
/*Edit names*/
private String materiaName;
private String uomname;
private String statuName;
private String plantname;
private String storageLoName;
/*Edit Properties*/

private String material_IdEdit;
private String qtyEdit;
private String uomEdit;
private String requiredDateEdit;
private String status_IdEdit;
private String plant_IdEdit;
private String storegeLoc_IdEdit;
private int purchaseReqLine_IdEdit;




private int purchaseReqId;

private Material material;
private Uom uomDetails;
private Status statusDetails;
private Plant plantDetails;
private StorageLocation storageLocationDetails;
 







public int getPurchaseReqId() {
	return purchaseReqId;
}
public void setPurchaseReqId(int purchaseReqId) {
	this.purchaseReqId = purchaseReqId;
}
public Material getMaterial() {
	return material;
}
public void setMaterial(Material material) {
	this.material = material;
}
public Uom getUomDetails() {
	return uomDetails;
}
public void setUomDetails(Uom uomDetails) {
	this.uomDetails = uomDetails;
}
public Status getStatusDetails() {
	return statusDetails;
}
public void setStatusDetails(Status statusDetails) {
	this.statusDetails = statusDetails;
}
public Plant getPlantDetails() {
	return plantDetails;
}

public String getMateriaName() {
	return materiaName;
}
public String getUomname() {
	return uomname;
}
public String getStatuName() {
	return statuName;
}
public String getPlantname() {
	return plantname;
}
public String getStorageLoName() {
	return storageLoName;
}
public void setPlantDetails(Plant plantDetails) {
	this.plantDetails = plantDetails;
}
public StorageLocation getStorageLocationDetails() {
	return storageLocationDetails;
}
public void setStorageLocationDetails(StorageLocation storageLocationDetails) {
	this.storageLocationDetails = storageLocationDetails;
}
public int getPurchaseReqLine_IdEdit() {
	return purchaseReqLine_IdEdit;
}
public void setPurchaseReqLine_IdEdit(int purchaseReqLine_IdEdit) {
	this.purchaseReqLine_IdEdit = purchaseReqLine_IdEdit;
}
public String getMaterial_IdEdit() {
	return material_IdEdit;
}
public void setMaterial_IdEdit(String material_IdEdit) {
	this.material_IdEdit = material_IdEdit;
}
public String getQtyEdit() {
	return qtyEdit;
}
public void setQtyEdit(String qtyEdit) {
	this.qtyEdit = qtyEdit;
}
public String getUomEdit() {
	return uomEdit;
}
public void setUomEdit(String uomEdit) {
	this.uomEdit = uomEdit;
}
public String getRequiredDateEdit() {
	return requiredDateEdit;
}
public void setRequiredDateEdit(String requiredDateEdit) {
	this.requiredDateEdit = requiredDateEdit;
}
public String getStatus_IdEdit() {
	return status_IdEdit;
}
public void setStatus_IdEdit(String status_IdEdit) {
	this.status_IdEdit = status_IdEdit;
}
public String getPlant_IdEdit() {
	return plant_IdEdit;
}
public void setPlant_IdEdit(String plant_IdEdit) {
	this.plant_IdEdit = plant_IdEdit;
}
public String getStoregeLoc_IdEdit() {
	return storegeLoc_IdEdit;
}
public void setStoregeLoc_IdEdit(String storegeLoc_IdEdit) {
	this.storegeLoc_IdEdit = storegeLoc_IdEdit;
}
public String getMaterial_Id() {
	return material_Id;
}
public void setMaterial_Id(String material_Id) {
	this.material_Id = material_Id;
}
public int getPurchaseReqLine_Id() {
	return purchaseReqLine_Id;
}
public void setPurchaseReqLine_Id(int purchaseReqLine_Id) {
	this.purchaseReqLine_Id = purchaseReqLine_Id;
}
public int getPurchaseReq_Id() {
	return purchaseReq_Id;
}
public void setPurchaseReq_Id(int purchaseReq_Id) {
	this.purchaseReq_Id = purchaseReq_Id;
}
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
}
public String getUom() {
	return uom;
}
public void setUom(String uom) {
	this.uom = uom;
}
public String getRequiredDate() {
	return requiredDate;
}
public void setRequiredDate(String requiredDate) {
	this.requiredDate = requiredDate;
}
public String getStatus_Id() {
	return status_Id;
}
public void setStatus_Id(String status_Id) {
	this.status_Id = status_Id;
}
public String getPlant_Id() {
	return plant_Id;
}
public void setPlant_Id(String plant_Id) {
	this.plant_Id = plant_Id;
}
public String getStorageLoc_Id() {
	return storageLoc_Id;
}
public void setStorageLoc_Id(String storageLoc_Id) {
	this.storageLoc_Id = storageLoc_Id;
}
public void setMateriaName(String materiaName) {
	this.materiaName = materiaName;
}
public void setUomname(String uomname) {
	this.uomname = uomname;
}
public void setStatuName(String statuName) {
	this.statuName = statuName;
}
public void setPlantname(String plantname) {
	this.plantname = plantname;
}
public void setStorageLoName(String storageLoName) {
	this.storageLoName = storageLoName;
}

}
