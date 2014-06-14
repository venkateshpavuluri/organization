/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

/**
 * This is GoodsReceiptLine pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */


public final class GoodsReceiptLine {
	
private int goodsReceiptLine_Id;
private int goodsReceipt_Id;
private int goodsReceiptLineNum;
private String material_Id;
private String batchNo;
private float receivedQty;
private String quantityUOM;
private float qtyInspected;
private float qtyAccepted;
private float qtyRejected;
private float qtyReturned;
private String inspection;
private String qAStatus;
private int inspectedBy;
private String inspectedDTTM;
private String vendorMaterialNbr;
private String materialSpecs;
private String storageLocationId;
private float qtyLength;
private String qtyLengthUOM;
private float qtyWeight;
private String qtyWeightUOM;
private String createdBy;
private String createdDTTM;
private String modifiedBy;
private String modifiedDTTM;
private float stockEdit;
/*properties*/
private Material materialDetails;
private Uom uomDetails;
private Uom qtylUomDetails;
private Uom qtywUomDetails;
private Status statusDetails;
private StorageLocation storagelocDetails;

/*Edit names*/
private String materialName;
private String qtyUomName;
private String statusName;
private String qtylname;
private String qtywname;
private String storagelocName;

/*Editproperties*/

private int goodsReceiptLine_IdEdit;
private int goodsReceipt_IdEdit;
private int goodsReceiptLineNumEdit;
private String material_IdEdit;
private String batchNoEdit;
private float receivedQtyEdit;
private String quantityUOMEdit;
private float qtyInspectedEdit;
private float qtyAcceptedEdit;
private float qtyRejectedEdit;
private float qtyReturnedEdit;
private String inspectionEdit;
private String qAStatusEdit;
private int inspectedByEdit;
private String inspectedDTTMEdit;
private String vendorMaterialNbrEdit;
private String materialSpecsEdit;
private float qtyLengthEdit;
private String qtyLengthUOMEdit;
private float qtyWeightEdit;
private String storageLocationIdEdit;
private String qtyWeightUOMEdit;
private String storagelocsEdit;




/*getter methods of GoodsReceiptLine*/





public int getGoodsReceiptLine_Id() {
	return goodsReceiptLine_Id;
}
public int getGoodsReceiptLineNumEdit() {
	return goodsReceiptLineNumEdit;
}
public int getGoodsReceiptLine_IdEdit() {
	return goodsReceiptLine_IdEdit;
}
public int getGoodsReceipt_IdEdit() {
	return goodsReceipt_IdEdit;
}

public Uom getQtylUomDetails() {
	return qtylUomDetails;
}
public Uom getQtywUomDetails() {
	return qtywUomDetails;
}
public String getMaterial_IdEdit() {
	return material_IdEdit;
}
public float getReceivedQtyEdit() {
	return receivedQtyEdit;
}
public String getQuantityUOMEdit() {
	return quantityUOMEdit;
}
public float getQtyInspectedEdit() {
	return qtyInspectedEdit;
}
public float getQtyAcceptedEdit() {
	return qtyAcceptedEdit;
}
public float getQtyRejectedEdit() {
	return qtyRejectedEdit;
}
public float getQtyReturnedEdit() {
	return qtyReturnedEdit;
}
public String getInspectionEdit() {
	return inspectionEdit;
}

public float getStockEdit() {
	return stockEdit;
}
public String getqAStatusEdit() {
	return qAStatusEdit;
}
public int getInspectedByEdit() {
	return inspectedByEdit;
}
public String getInspectedDTTMEdit() {
	return inspectedDTTMEdit;
}
public String getVendorMaterialNbrEdit() {
	return vendorMaterialNbrEdit;
}


public String getMaterialSpecsEdit() {
	return materialSpecsEdit;
}
public float getQtyLengthEdit() {
	return qtyLengthEdit;
}
public String getQtyLengthUOMEdit() {
	return qtyLengthUOMEdit;
}
public float getQtyWeightEdit() {
	return qtyWeightEdit;
}
public String getQtyWeightUOMEdit() {
	return qtyWeightUOMEdit;
}
public int getGoodsReceipt_Id() {
	return goodsReceipt_Id;
}
public int getGoodsReceiptLineNum() {
	return goodsReceiptLineNum;
}
public String getMaterial_Id() {
	return material_Id;
}

public float getReceivedQty() {
	return receivedQty;
}
public String getQuantityUOM() {
	return quantityUOM;
}
public float getQtyInspected() {
	return qtyInspected;
}


public String getBatchNo() {
	return batchNo;
}
public String getStorageLocationId() {
	return storageLocationId;
}
public StorageLocation getStoragelocDetails() {
	return storagelocDetails;
}
public String getStoragelocName() {
	return storagelocName;
}
public String getBatchNoEdit() {
	return batchNoEdit;
}
public String getStorageLocationIdEdit() {
	return storageLocationIdEdit;
}
public float getQtyAccepted() {
	return qtyAccepted;
}
public float getQtyRejected() {
	return qtyRejected;
}
public float getQtyReturned() {
	return qtyReturned;
}
public String getInspection() {
	return inspection;
}
public String getqAStatus() {
	return qAStatus;
}
public int getInspectedBy() {
	return inspectedBy;
}
public String getInspectedDTTM() {
	return inspectedDTTM;
}
public String getVendorMaterialNbr() {
	return vendorMaterialNbr;
}
public String getMaterialSpecs() {
	return materialSpecs;
}
public float getQtyLength() {
	return qtyLength;
}
public String getQtyLengthUOM() {
	return qtyLengthUOM;
}
public float getQtyWeight() {
	return qtyWeight;
}
public String getQtyWeightUOM() {
	return qtyWeightUOM;
}
public String getCreatedBy() {
	return createdBy;
}

public Material getMaterialDetails() {
	return materialDetails;
}
public Uom getUomDetails() {
	return uomDetails;
}
public Status getStatusDetails() {
	return statusDetails;
}
public String getCreatedDTTM() {
	return createdDTTM;
}
public String getModifiedBy() {
	return modifiedBy;
}

public String getStoragelocsEdit() {
	return storagelocsEdit;
}
public String getMaterialName() {
	return materialName;
}
public String getQtyUomName() {
	return qtyUomName;
}

public String getStatusName() {
	return statusName;
}
public String getQtylname() {
	return qtylname;
}
public String getQtywname() {
	return qtywname;
}
public String getModifiedDTTM() {
	return modifiedDTTM;
}

/*setter methods of GoodsReceiptLine*/



public void setGoodsReceiptLine_Id(int goodsReceiptLine_Id) {
	this.goodsReceiptLine_Id = goodsReceiptLine_Id;
}
public void setGoodsReceiptLine_IdEdit(int goodsReceiptLine_IdEdit) {
	this.goodsReceiptLine_IdEdit = goodsReceiptLine_IdEdit;
}
public void setGoodsReceipt_IdEdit(int goodsReceipt_IdEdit) {
	this.goodsReceipt_IdEdit = goodsReceipt_IdEdit;
}

public void setMaterial_IdEdit(String material_IdEdit) {
	this.material_IdEdit = material_IdEdit;
}
public void setReceivedQtyEdit(float receivedQtyEdit) {
	this.receivedQtyEdit = receivedQtyEdit;
}
public void setQuantityUOMEdit(String quantityUOMEdit) {
	this.quantityUOMEdit = quantityUOMEdit;
}
public void setQtyInspectedEdit(float qtyInspectedEdit) {
	this.qtyInspectedEdit = qtyInspectedEdit;
}
public void setQtyAcceptedEdit(float qtyAcceptedEdit) {
	this.qtyAcceptedEdit = qtyAcceptedEdit;
}
public void setQtyRejectedEdit(float qtyRejectedEdit) {
	this.qtyRejectedEdit = qtyRejectedEdit;
}
public void setQtyReturnedEdit(float qtyReturnedEdit) {
	this.qtyReturnedEdit = qtyReturnedEdit;
}
public void setInspectionEdit(String inspectionEdit) {
	this.inspectionEdit = inspectionEdit;
}
public void setqAStatusEdit(String qAStatusEdit) {
	this.qAStatusEdit = qAStatusEdit;
}
public void setInspectedByEdit(int inspectedByEdit) {
	this.inspectedByEdit = inspectedByEdit;
}
public void setInspectedDTTMEdit(String inspectedDTTMEdit) {
	this.inspectedDTTMEdit = inspectedDTTMEdit;
}
public void setVendorMaterialNbrEdit(String vendorMaterialNbrEdit) {
	this.vendorMaterialNbrEdit = vendorMaterialNbrEdit;
}
public void setMaterialSpecsEdit(String materialSpecsEdit) {
	this.materialSpecsEdit = materialSpecsEdit;
}
public void setQtyLengthEdit(float qtyLengthEdit) {
	this.qtyLengthEdit = qtyLengthEdit;
}
public void setQtyLengthUOMEdit(String qtyLengthUOMEdit) {
	this.qtyLengthUOMEdit = qtyLengthUOMEdit;
}
public void setQtyWeightEdit(float qtyWeightEdit) {
	this.qtyWeightEdit = qtyWeightEdit;
}
public void setQtyWeightUOMEdit(String qtyWeightUOMEdit) {
	this.qtyWeightUOMEdit = qtyWeightUOMEdit;
}
public void setGoodsReceipt_Id(int goodsReceipt_Id) {
	this.goodsReceipt_Id = goodsReceipt_Id;
}
public void setGoodsReceiptLineNum(int goodsReceiptLineNum) {
	this.goodsReceiptLineNum = goodsReceiptLineNum;
}
public void setMaterial_Id(String material_Id) {
	this.material_Id = material_Id;
}

public void setReceivedQty(float receivedQty) {
	this.receivedQty = receivedQty;
}
public void setQuantityUOM(String quantityUOM) {
	this.quantityUOM = quantityUOM;
}
public void setQtyInspected(float qtyInspected) {
	this.qtyInspected = qtyInspected;
}
public void setQtyAccepted(float qtyAccepted) {
	this.qtyAccepted = qtyAccepted;
}
public void setQtyRejected(float qtyRejected) {
	this.qtyRejected = qtyRejected;
}
public void setQtyReturned(float qtyReturned) {
	this.qtyReturned = qtyReturned;
}
public void setInspection(String inspection) {
	this.inspection = inspection;
}


public void setqAStatus(String qAStatus) {
	this.qAStatus = qAStatus;
}
public void setInspectedBy(int inspectedBy) {
	this.inspectedBy = inspectedBy;
}
public void setInspectedDTTM(String inspectedDTTM) {
	this.inspectedDTTM = inspectedDTTM;
}
public void setVendorMaterialNbr(String vendorMaterialNbr) {
	this.vendorMaterialNbr = vendorMaterialNbr;
}
public void setMaterialSpecs(String materialSpecs) {
	this.materialSpecs = materialSpecs;
}
public void setQtyLength(float qtyLength) {
	this.qtyLength = qtyLength;
}

public void setStoragelocsEdit(String storagelocsEdit) {
	this.storagelocsEdit = storagelocsEdit;
}
public void setQtyLengthUOM(String qtyLengthUOM) {
	this.qtyLengthUOM = qtyLengthUOM;
}
public void setQtyWeight(float qtyWeight) {
	this.qtyWeight = qtyWeight;
}
public void setQtyWeightUOM(String qtyWeightUOM) {
	this.qtyWeightUOM = qtyWeightUOM;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public void setCreatedDTTM(String createdDTTM) {
	this.createdDTTM = createdDTTM;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public void setModifiedDTTM(String modifiedDTTM) {
	this.modifiedDTTM = modifiedDTTM;
}
public void setGoodsReceiptLineNumEdit(int goodsReceiptLineNumEdit) {
	this.goodsReceiptLineNumEdit = goodsReceiptLineNumEdit;
}
public void setMaterialDetails(Material materialDetails) {
	this.materialDetails = materialDetails;
}
public void setUomDetails(Uom uomDetails) {
	this.uomDetails = uomDetails;
}
public void setStatusDetails(Status statusDetails) {
	this.statusDetails = statusDetails;
}
public void setMaterialName(String materialName) {
	this.materialName = materialName;
}
public void setQtyUomName(String qtyUomName) {
	this.qtyUomName = qtyUomName;
}

public void setStatusName(String statusName) {
	this.statusName = statusName;
}
public void setQtylname(String qtylname) {
	this.qtylname = qtylname;
}
public void setQtywname(String qtywname) {
	this.qtywname = qtywname;
}
public void setQtylUomDetails(Uom qtylUomDetails) {
	this.qtylUomDetails = qtylUomDetails;
}
public void setQtywUomDetails(Uom qtywUomDetails) {
	this.qtywUomDetails = qtywUomDetails;
}
public void setBatchNo(String batchNo) {
	this.batchNo = batchNo;
}
public void setStorageLocationId(String storageLocationId) {
	this.storageLocationId = storageLocationId;
}
public void setStoragelocDetails(StorageLocation storagelocDetails) {
	this.storagelocDetails = storagelocDetails;
}
public void setStoragelocName(String storagelocName) {
	this.storagelocName = storagelocName;
}
public void setBatchNoEdit(String batchNoEdit) {
	this.batchNoEdit = batchNoEdit;
}
public void setStorageLocationIdEdit(String storageLocationIdEdit) {
	this.storageLocationIdEdit = storageLocationIdEdit;
}
public void setStockEdit(float stockEdit) {
	this.stockEdit = stockEdit;
}



}
