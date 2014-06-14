

/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

import java.util.List;


/**
 * This is GoodsReceipt pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class GoodsReceipt {
	
private int aid;
private int goodsReceipt_Id;
private String goodsReceiptType_Id;
private String goodsReceiptType;
private String goodsReceiptTypeNum;
private String receivingID;
private String receivingDate;
private String receivingStatus;
private String memo;
private String vendor_Id;
private String shippingAddress;
private String dCNumber;
private String dCDate;
private String transportAgency;
private String docketNum;
private String docketDate;
private String totalPackages;
private String weight;
private String weightUOM;
private String receivingAddress;
private String freightCharges;
private String totalValue;
private String prodOrder_Id;
private String batch_Id;
private String routeCard_Id;
private String createdBy;
private String createdDTTM;
private String modifiedBy;
private String modifiedDTTM;
private String[] material_Id;
private String uom_Id;
private String statusId;
private String storageLocationId;
private float stockEdit;
private int avalQty;
private Integer[] stockEditt;
private int totHidden;
private int lastValue;
private String xmlLabel;
private String operations;
private String basicSearchId;
private String matids;

private String firstLabel;
private String secondLabel;
private String operations1;
private String advanceSearchText;
private int advanceSearchHidden;



//Edit properties
private int goodsReceipt_IdEdit;
private String goodsReceiptType_IdEdit;
private String goodsReceiptTypeEdit;
private String goodsReceiptTypeNumEdit;
private String receivingIDEdit;
private String receivingDateEdit;
private String receivingStatusEdit;
private String memoEdit;
private String vendor_IdEdit;
private String shippingAddressEdit;
private String dCNumberEdit;
private String dCDateEdit;
private String transportAgencyEdit;

public int getAvalQty() {
	return avalQty;
}



public void setAvalQty(int avalQty) {
	this.avalQty = avalQty;
}


private String materialHidden;
private String qtyHidden;
public int getTotHidden() {
	return totHidden;
}



public void setTotHidden(int totHidden) {
	this.totHidden = totHidden;
}


private String docketNumEdit;
private String docketDateEdit;
private String totalPackagesEdit;
private String weightEdit;
private String weightUOMEdit;
private String receivingAddressEdit;
private String freightChargesEdit;
private String totalValueEdit;
private String prodOrder_IdEdit;
private String batch_IdEdit;
private String routeCard_IdEdit;
private String createdByEdit;
private String createdDTTMEdit;
private String modifiedByEdit;
private String modifiedDTTMEdit;
private String[] material_IdEdit;
private String uom_IdEdit;
private String statusIdEdit;
private String storageLocationIdEdit;

private List<GoodsReceiptLine> goodsReceiptLine;
/*child pojo values*/

private Integer[] goodsReceiptLineNum;

private String description;
private String[] batchNo;
private float[] receivedQty;
private String[] quantityUOM;
private float[] qtyInspected;
private float[] qtyAccepted;
private float[] qtyRejected;
private float[] qtyReturned;
private String[] inspection;
private String[] qAStatus;
private Integer[] inspectedBy;
private String[] inspectedDTTM;
private String[] vendorMaterialNbr;

private String[] materialSpecs;
private float[] qtyLength;
private String[] qtyLengthUOM;
private float[] qtyWeight;
private String[] qtyWeightUOM;

 
/*properties for drop down values*/

/*private String materialids;*/
private String materialids;
private String qtyuoms;
private String qAstatus;
private String QlUom;
private String QwUom;
private String Storagelocs;

/*private String materialids;*/
private String materialidsEdit;
private String qtyuomsEdit;
private String qAstatusEdit;
private String QlUomEdit;
private String QwUomEdit;
private String storagelocsEdit;


/*Edit names*/
private String materialName;
private String qtyUomName;
private String statusName;
private String qtylname;
private String qtywname;
private String storagelocName;
private Uom uomDetails;

/*child pojo array edit values*/
private Integer[] goodsReceiptLineNumEdit;


private float[] receivedQtyEdit;
private String[] quantityUOMEdit;
private float[] qtyInspectedEdit;
private float[] qtyAcceptedEdit;
private float[] qtyRejectedEdit;
private float[] qtyReturnedEdit;
private String[] inspectionEdit;
private String[] qAStatusEdit;
private Integer[] inspectedByEdit;
private String[] inspectedDTTMEdit;
private String[] vendorMaterialNbrEdit;
private String[] materialSpecsEdit;
private float[] qtyLengthEdit;
private String[] qtyLengthUOMEdit;
private float[] qtyWeightEdit;
private String[] qtyWeightUOMEdit;
private String[] batchNoEdit;

/*Editproperties*/

private int[] goodsReceiptLine_IdEdit;


/*getter methods of GoodsReceipt*/



public String getFirstLabel() {
	return firstLabel;
}



public void setFirstLabel(String firstLabel) {
	this.firstLabel = firstLabel;
}



public String getSecondLabel() {
	return secondLabel;
}



public void setSecondLabel(String secondLabel) {
	this.secondLabel = secondLabel;
}



public String getOperations1() {
	return operations1;
}



public void setOperations1(String operations1) {
	this.operations1 = operations1;
}



public Uom getUomDetails() {
	return uomDetails;
}



public void setUomDetails(Uom uomDetails) {
	this.uomDetails = uomDetails;
}



public String getAdvanceSearchText() {
	return advanceSearchText;
}



public Integer[] getStockEditt() {
	return stockEditt;
}



public void setStockEditt(Integer[] stockEditt) {
	this.stockEditt = stockEditt;
}



public String getStorageLocationId() {
	return storageLocationId;
}







public float getStockEdit() {
	return stockEdit;
}



public String getStorageLocationIdEdit() {
	return storageLocationIdEdit;
}



public void setAdvanceSearchText(String advanceSearchText) {
	this.advanceSearchText = advanceSearchText;
}



public int getAdvanceSearchHidden() {
	return advanceSearchHidden;
}



public void setAdvanceSearchHidden(int advanceSearchHidden) {
	this.advanceSearchHidden = advanceSearchHidden;
}



public String getGoodsReceiptType() {
	return goodsReceiptType;
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



public String[] getBatchNo() {
	return batchNo;
}



public String getStoragelocs() {
	return Storagelocs;
}






public String getStoragelocsEdit() {
	return storagelocsEdit;
}



public String getStoragelocName() {
	return storagelocName;
}



public String[] getBatchNoEdit() {
	return batchNoEdit;
}



public int[] getGoodsReceiptLine_IdEdit() {
	return goodsReceiptLine_IdEdit;
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

public List<GoodsReceiptLine> getGoodsReceiptLine() {
	return goodsReceiptLine;
}


public void setStockEdit(float stockEdit) {
	this.stockEdit = stockEdit;
}



public int getAid() {
	return aid;
}


public Integer[] getGoodsReceiptLineNum() {
	return goodsReceiptLineNum;
}


public String getDescription() {
	return description;
}





public Integer[] getGoodsReceiptLineNumEdit() {
	return goodsReceiptLineNumEdit;
}


public float[] getReceivedQtyEdit() {
	return receivedQtyEdit;
}


public String[] getQuantityUOMEdit() {
	return quantityUOMEdit;
}


public float[] getQtyInspectedEdit() {
	return qtyInspectedEdit;
}


public float[] getQtyAcceptedEdit() {
	return qtyAcceptedEdit;
}


public float[] getQtyRejectedEdit() {
	return qtyRejectedEdit;
}


public float[] getQtyReturnedEdit() {
	return qtyReturnedEdit;
}


public String[] getInspectionEdit() {
	return inspectionEdit;
}


public String[] getqAStatusEdit() {
	return qAStatusEdit;
}


public Integer[] getInspectedByEdit() {
	return inspectedByEdit;
}


public String[] getInspectedDTTMEdit() {
	return inspectedDTTMEdit;
}


public String[] getVendorMaterialNbrEdit() {
	return vendorMaterialNbrEdit;
}


public String[] getMaterialSpecsEdit() {
	return materialSpecsEdit;
}


public float[] getQtyLengthEdit() {
	return qtyLengthEdit;
}


public String[] getQtyLengthUOMEdit() {
	return qtyLengthUOMEdit;
}


public float[] getQtyWeightEdit() {
	return qtyWeightEdit;
}


public String[] getQtyWeightUOMEdit() {
	return qtyWeightUOMEdit;
}


public float[] getReceivedQty() {
	return receivedQty;
}


public String[] getQuantityUOM() {
	return quantityUOM;
}


public float[] getQtyInspected() {
	return qtyInspected;
}


public float[] getQtyAccepted() {
	return qtyAccepted;
}


public float[] getQtyRejected() {
	return qtyRejected;
}


public float[] getQtyReturned() {
	return qtyReturned;
}


public String[] getInspection() {
	return inspection;
}


public String[] getqAStatus() {
	return qAStatus;
}


public Integer[] getInspectedBy() {
	return inspectedBy;
}


public String[] getInspectedDTTM() {
	return inspectedDTTM;
}


public String[] getVendorMaterialNbr() {
	return vendorMaterialNbr;
}


public String[] getMaterialSpecs() {
	return materialSpecs;
}


public float[] getQtyLength() {
	return qtyLength;
}


public String[] getQtyLengthUOM() {
	return qtyLengthUOM;
}


public float[] getQtyWeight() {
	return qtyWeight;
}


public String getMaterialids() {
	return materialids;
}


public String[] getQtyWeightUOM() {
	return qtyWeightUOM;
}


public String getUom_Id() {
	return uom_Id;
}


public String getStatusId() {
	return statusId;
}


public String[] getMaterial_Id() {
	return material_Id;
}
public int getGoodsReceipt_Id() {
	return goodsReceipt_Id;
}
public String getGoodsReceiptType_Id() {
	return goodsReceiptType_Id;
}
public String getGoodsReceiptTypeNum() {
	return goodsReceiptTypeNum;
}
public String getReceivingID() {
	return receivingID;
}
public String getReceivingDate() {
	return receivingDate;
}
public String getReceivingStatus() {
	return receivingStatus;
}
public String getMemo() {
	return memo;
}
public String getVendor_Id() {
	return vendor_Id;
}
public String getShippingAddress() {
	return shippingAddress;
}
public String getdCNumber() {
	return dCNumber;
}
public String getdCDate() {
	return dCDate;
}







public String getQtyuoms() {
	return qtyuoms;
}


public String getqAstatus() {
	return qAstatus;
}


public String getQlUom() {
	return QlUom;
}


public String getQwUom() {
	return QwUom;
}


public String getTransportAgency() {
	return transportAgency;
}
public String getDocketNum() {
	return docketNum;
}
public String getDocketDate() {
	return docketDate;
}
public String getTotalPackages() {
	return totalPackages;
}
public String getWeight() {
	return weight;
}
public String getWeightUOM() {
	return weightUOM;
}
public String getReceivingAddress() {
	return receivingAddress;
}
public String getFreightCharges() {
	return freightCharges;
}
public String getTotalValue() {
	return totalValue;
}
public String getProdOrder_Id() {
	return prodOrder_Id;
}
public String getBatch_Id() {
	return batch_Id;
}
public String getRouteCard_Id() {
	return routeCard_Id;
}
public String getCreatedBy() {
	return createdBy;
}
public String getCreatedDTTM() {
	return createdDTTM;
}
public String getModifiedBy() {
	return modifiedBy;
}

public int getGoodsReceipt_IdEdit() {
	return goodsReceipt_IdEdit;
}


public String getGoodsReceiptType_IdEdit() {
	return goodsReceiptType_IdEdit;
}


public String getGoodsReceiptTypeEdit() {
	return goodsReceiptTypeEdit;
}


public String getGoodsReceiptTypeNumEdit() {
	return goodsReceiptTypeNumEdit;
}


public String getReceivingIDEdit() {
	return receivingIDEdit;
}


public String getReceivingDateEdit() {
	return receivingDateEdit;
}


public String getReceivingStatusEdit() {
	return receivingStatusEdit;
}


public String getMemoEdit() {
	return memoEdit;
}


public String getVendor_IdEdit() {
	return vendor_IdEdit;
}


public String getShippingAddressEdit() {
	return shippingAddressEdit;
}


public String getdCNumberEdit() {
	return dCNumberEdit;
}


public String getdCDateEdit() {
	return dCDateEdit;
}


public String getTransportAgencyEdit() {
	return transportAgencyEdit;
}


public String getDocketNumEdit() {
	return docketNumEdit;
}


public String getDocketDateEdit() {
	return docketDateEdit;
}


public String getTotalPackagesEdit() {
	return totalPackagesEdit;
}


public String getWeightEdit() {
	return weightEdit;
}


public String getWeightUOMEdit() {
	return weightUOMEdit;
}


public String getReceivingAddressEdit() {
	return receivingAddressEdit;
}


public String getFreightChargesEdit() {
	return freightChargesEdit;
}


public String getTotalValueEdit() {
	return totalValueEdit;
}


public String getProdOrder_IdEdit() {
	return prodOrder_IdEdit;
}


public String getBatch_IdEdit() {
	return batch_IdEdit;
}


public String getRouteCard_IdEdit() {
	return routeCard_IdEdit;
}


public String getCreatedByEdit() {
	return createdByEdit;
}


public String getCreatedDTTMEdit() {
	return createdDTTMEdit;
}


public String getModifiedByEdit() {
	return modifiedByEdit;
}


public String getModifiedDTTMEdit() {
	return modifiedDTTMEdit;
}


public String[] getMaterial_IdEdit() {
	return material_IdEdit;
}


public String getUom_IdEdit() {
	return uom_IdEdit;
}


public String getStatusIdEdit() {
	return statusIdEdit;
}


public String getMaterialidsEdit() {
	return materialidsEdit;
}


public String getQtyuomsEdit() {
	return qtyuomsEdit;
}


public String getqAstatusEdit() {
	return qAstatusEdit;
}


public String getQlUomEdit() {
	return QlUomEdit;
}


public String getQwUomEdit() {
	return QwUomEdit;
}


public String getModifiedDTTM() {
	return modifiedDTTM;
}


/*setter methods of GoodsReceipt */



public void setGoodsReceipt_Id(int goodsReceipt_Id) {
	this.goodsReceipt_Id = goodsReceipt_Id;
}
public void setAid(int aid) {
	this.aid = aid;
}


public void setGoodsReceiptLine(List<GoodsReceiptLine> goodsReceiptLine) {
	this.goodsReceiptLine = goodsReceiptLine;
}


public void setGoodsReceipt_IdEdit(int goodsReceipt_IdEdit) {
	this.goodsReceipt_IdEdit = goodsReceipt_IdEdit;
}


public void setGoodsReceiptType_IdEdit(String goodsReceiptType_IdEdit) {
	this.goodsReceiptType_IdEdit = goodsReceiptType_IdEdit;
}


public void setGoodsReceiptTypeEdit(String goodsReceiptTypeEdit) {
	this.goodsReceiptTypeEdit = goodsReceiptTypeEdit;
}


public void setGoodsReceiptTypeNumEdit(String goodsReceiptTypeNumEdit) {
	this.goodsReceiptTypeNumEdit = goodsReceiptTypeNumEdit;
}


public void setReceivingIDEdit(String receivingIDEdit) {
	this.receivingIDEdit = receivingIDEdit;
}


public void setReceivingDateEdit(String receivingDateEdit) {
	this.receivingDateEdit = receivingDateEdit;
}


public void setReceivingStatusEdit(String receivingStatusEdit) {
	this.receivingStatusEdit = receivingStatusEdit;
}


public void setMemoEdit(String memoEdit) {
	this.memoEdit = memoEdit;
}


public void setVendor_IdEdit(String vendor_IdEdit) {
	this.vendor_IdEdit = vendor_IdEdit;
}


public void setShippingAddressEdit(String shippingAddressEdit) {
	this.shippingAddressEdit = shippingAddressEdit;
}


public void setdCNumberEdit(String dCNumberEdit) {
	this.dCNumberEdit = dCNumberEdit;
}


public void setdCDateEdit(String dCDateEdit) {
	this.dCDateEdit = dCDateEdit;
}


public void setTransportAgencyEdit(String transportAgencyEdit) {
	this.transportAgencyEdit = transportAgencyEdit;
}


public void setDocketNumEdit(String docketNumEdit) {
	this.docketNumEdit = docketNumEdit;
}


public void setDocketDateEdit(String docketDateEdit) {
	this.docketDateEdit = docketDateEdit;
}


public void setTotalPackagesEdit(String totalPackagesEdit) {
	this.totalPackagesEdit = totalPackagesEdit;
}


public void setWeightEdit(String weightEdit) {
	this.weightEdit = weightEdit;
}


public void setWeightUOMEdit(String weightUOMEdit) {
	this.weightUOMEdit = weightUOMEdit;
}


public void setReceivingAddressEdit(String receivingAddressEdit) {
	this.receivingAddressEdit = receivingAddressEdit;
}


public void setFreightChargesEdit(String freightChargesEdit) {
	this.freightChargesEdit = freightChargesEdit;
}


public void setTotalValueEdit(String totalValueEdit) {
	this.totalValueEdit = totalValueEdit;
}


public void setProdOrder_IdEdit(String prodOrder_IdEdit) {
	this.prodOrder_IdEdit = prodOrder_IdEdit;
}


public void setBatch_IdEdit(String batch_IdEdit) {
	this.batch_IdEdit = batch_IdEdit;
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



public void setRouteCard_IdEdit(String routeCard_IdEdit) {
	this.routeCard_IdEdit = routeCard_IdEdit;
}


public void setCreatedByEdit(String createdByEdit) {
	this.createdByEdit = createdByEdit;
}


public void setCreatedDTTMEdit(String createdDTTMEdit) {
	this.createdDTTMEdit = createdDTTMEdit;
}


public void setModifiedByEdit(String modifiedByEdit) {
	this.modifiedByEdit = modifiedByEdit;
}


public void setModifiedDTTMEdit(String modifiedDTTMEdit) {
	this.modifiedDTTMEdit = modifiedDTTMEdit;
}


public void setMaterial_IdEdit(String[] material_IdEdit) {
	this.material_IdEdit = material_IdEdit;
}


public void setUom_IdEdit(String uom_IdEdit) {
	this.uom_IdEdit = uom_IdEdit;
}


public void setStatusIdEdit(String statusIdEdit) {
	this.statusIdEdit = statusIdEdit;
}


public void setGoodsReceiptLineNum(Integer[] goodsReceiptLineNum) {
	this.goodsReceiptLineNum = goodsReceiptLineNum;
}


public void setDescription(String description) {
	this.description = description;
}
 

public void setMaterialids(String materialids) {
	this.materialids = materialids;
}


public void setReceivedQty(float[] receivedQty) {
	this.receivedQty = receivedQty;
}


public void setQuantityUOM(String[] quantityUOM) {
	this.quantityUOM = quantityUOM;
}


public void setQtyInspected(float[] qtyInspected) {
	this.qtyInspected = qtyInspected;
}


public void setQtyAccepted(float[] qtyAccepted) {
	this.qtyAccepted = qtyAccepted;
}


public void setQtyRejected(float[] qtyRejected) {
	this.qtyRejected = qtyRejected;
}


public void setQtyReturned(float[] qtyReturned) {
	this.qtyReturned = qtyReturned;
}


public void setInspection(String[] inspection) {
	this.inspection = inspection;
}


public void setqAStatus(String[] qAStatus) {
	this.qAStatus = qAStatus;
}


public void setInspectedBy(Integer[] inspectedBy) {
	this.inspectedBy = inspectedBy;
}


public void setInspectedDTTM(String[] inspectedDTTM) {
	this.inspectedDTTM = inspectedDTTM;
}


public void setVendorMaterialNbr(String[] vendorMaterialNbr) {
	this.vendorMaterialNbr = vendorMaterialNbr;
}


public void setMaterialSpecs(String[] materialSpecs) {
	this.materialSpecs = materialSpecs;
}


public void setQtyLength(float[] qtyLength) {
	this.qtyLength = qtyLength;
}


public void setQtyLengthUOM(String[] qtyLengthUOM) {
	this.qtyLengthUOM = qtyLengthUOM;
}


public void setQtyWeight(float[] qtyWeight) {
	this.qtyWeight = qtyWeight;
}


public void setQtyWeightUOM(String[] qtyWeightUOM) {
	this.qtyWeightUOM = qtyWeightUOM;
}


public void setUom_Id(String uom_Id) {
	this.uom_Id = uom_Id;
}


public void setStatusId(String statusId) {
	this.statusId = statusId;
}


public void setGoodsReceiptType_Id(String goodsReceiptType_Id) {
	this.goodsReceiptType_Id = goodsReceiptType_Id;
}
public void setGoodsReceiptTypeNum(String goodsReceiptTypeNum) {
	this.goodsReceiptTypeNum = goodsReceiptTypeNum;
}
public void setReceivingID(String receivingID) {
	this.receivingID = receivingID;
}
public void setReceivingDate(String receivingDate) {
	this.receivingDate = receivingDate;
}
public void setReceivingStatus(String receivingStatus) {
	this.receivingStatus = receivingStatus;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public void setVendor_Id(String vendor_Id) {
	this.vendor_Id = vendor_Id;
}
public void setShippingAddress(String shippingAddress) {
	this.shippingAddress = shippingAddress;
}
public void setdCNumber(String dCNumber) {
	this.dCNumber = dCNumber;
}
public void setdCDate(String dCDate) {
	this.dCDate = dCDate;
}
public void setTransportAgency(String transportAgency) {
	this.transportAgency = transportAgency;
}
public void setDocketNum(String docketNum) {
	this.docketNum = docketNum;
}
public void setDocketDate(String docketDate) {
	this.docketDate = docketDate;
}
public void setTotalPackages(String totalPackages) {
	this.totalPackages = totalPackages;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public void setWeightUOM(String weightUOM) {
	this.weightUOM = weightUOM;
}
public void setReceivingAddress(String receivingAddress) {
	this.receivingAddress = receivingAddress;
}
public void setFreightCharges(String freightCharges) {
	this.freightCharges = freightCharges;
}
public void setTotalValue(String totalValue) {
	this.totalValue = totalValue;
}
public void setProdOrder_Id(String prodOrder_Id) {
	this.prodOrder_Id = prodOrder_Id;
}
public void setBatch_Id(String batch_Id) {
	this.batch_Id = batch_Id;
}
public void setRouteCard_Id(String routeCard_Id) {
	this.routeCard_Id = routeCard_Id;
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
public void setMaterial_Id(String[] material_Id) {
	this.material_Id = material_Id;
}

public void setGoodsReceiptType(String goodsReceiptType) {
	this.goodsReceiptType = goodsReceiptType;
}


public void setGoodsReceiptLine_IdEdit(int[] goodsReceiptLine_IdEdit) {
	this.goodsReceiptLine_IdEdit = goodsReceiptLine_IdEdit;
}


public void setGoodsReceiptLineNumEdit(Integer[] goodsReceiptLineNumEdit) {
	this.goodsReceiptLineNumEdit = goodsReceiptLineNumEdit;
}


public void setReceivedQtyEdit(float[] receivedQtyEdit) {
	this.receivedQtyEdit = receivedQtyEdit;
}


public void setQuantityUOMEdit(String[] quantityUOMEdit) {
	this.quantityUOMEdit = quantityUOMEdit;
}


public void setQtyInspectedEdit(float[] qtyInspectedEdit) {
	this.qtyInspectedEdit = qtyInspectedEdit;
}


public void setQtyAcceptedEdit(float[] qtyAcceptedEdit) {
	this.qtyAcceptedEdit = qtyAcceptedEdit;
}


public void setQtyRejectedEdit(float[] qtyRejectedEdit) {
	this.qtyRejectedEdit = qtyRejectedEdit;
}


public void setQtyReturnedEdit(float[] qtyReturnedEdit) {
	this.qtyReturnedEdit = qtyReturnedEdit;
}


public void setInspectionEdit(String[] inspectionEdit) {
	this.inspectionEdit = inspectionEdit;
}


public void setqAStatusEdit(String[] qAStatusEdit) {
	this.qAStatusEdit = qAStatusEdit;
}


public void setInspectedByEdit(Integer[] inspectedByEdit) {
	this.inspectedByEdit = inspectedByEdit;
}


public void setInspectedDTTMEdit(String[] inspectedDTTMEdit) {
	this.inspectedDTTMEdit = inspectedDTTMEdit;
}


public void setVendorMaterialNbrEdit(String[] vendorMaterialNbrEdit) {
	this.vendorMaterialNbrEdit = vendorMaterialNbrEdit;
}


public void setMaterialSpecsEdit(String[] materialSpecsEdit) {
	this.materialSpecsEdit = materialSpecsEdit;
}


public void setQtyLengthEdit(float[] qtyLengthEdit) {
	this.qtyLengthEdit = qtyLengthEdit;
}


public void setQtyLengthUOMEdit(String[] qtyLengthUOMEdit) {
	this.qtyLengthUOMEdit = qtyLengthUOMEdit;
}


public void setQtyWeightEdit(float[] qtyWeightEdit) {
	this.qtyWeightEdit = qtyWeightEdit;
}


public void setQtyWeightUOMEdit(String[] qtyWeightUOMEdit) {
	this.qtyWeightUOMEdit = qtyWeightUOMEdit;
}



public void setQtyuoms(String qtyuoms) {
	this.qtyuoms = qtyuoms;
}


public void setqAstatus(String qAstatus) {
	this.qAstatus = qAstatus;
}


public void setQlUom(String qlUom) {
	QlUom = qlUom;
}


public void setMaterialidsEdit(String materialidsEdit) {
	this.materialidsEdit = materialidsEdit;
}


public void setQtyuomsEdit(String qtyuomsEdit) {
	this.qtyuomsEdit = qtyuomsEdit;
}


public void setqAstatusEdit(String qAstatusEdit) {
	this.qAstatusEdit = qAstatusEdit;
}


public void setQlUomEdit(String qlUomEdit) {
	QlUomEdit = qlUomEdit;
}


public void setQwUomEdit(String qwUomEdit) {
	QwUomEdit = qwUomEdit;
}


public void setQwUom(String qwUom) {
	QwUom = qwUom;
}



public void setBatchNo(String[] batchNo) {
	this.batchNo = batchNo;
}



public void setStoragelocs(String storagelocs) {
	Storagelocs = storagelocs;
}



public void setStorageLocationId(String storageLocationId) {
	this.storageLocationId = storageLocationId;
}



public void setStorageLocationIdEdit(String storageLocationIdEdit) {
	this.storageLocationIdEdit = storageLocationIdEdit;
}







public void setStoragelocsEdit(String storagelocsEdit) {
	this.storagelocsEdit = storagelocsEdit;
}



public void setStoragelocName(String storagelocName) {
	this.storagelocName = storagelocName;
}



public void setBatchNoEdit(String[] batchNoEdit) {
	this.batchNoEdit = batchNoEdit;
}



public String getMaterialHidden() {
	return materialHidden;
}



public void setMaterialHidden(String materialHidden) {
	this.materialHidden = materialHidden;
}



public String getQtyHidden() {
	return qtyHidden;
}



public void setQtyHidden(String qtyHidden) {
	this.qtyHidden = qtyHidden;
}



public int getLastValue() {
	return lastValue;
}



public void setLastValue(int lastValue) {
	this.lastValue = lastValue;
}



public String getMatids() {
	return matids;
}



public void setMatids(String matids) {
	this.matids = matids;
}



}
