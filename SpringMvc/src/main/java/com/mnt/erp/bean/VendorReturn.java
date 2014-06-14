/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 * 
 */
public class VendorReturn {

	private int vendorReturnId;
	private String vendorReturnNo;
	private String vendorReturnDate;
	private String reference;
	private String description;
	private String purchaseOrderId;
	private String goodsReceiptId;
	private int aid;
	private float stockEdit;
	private String rejQty;
	private float oldQty;

	private String[] material_Id;
	private String mId;
	private Integer[] quantity;
	private String[] uom_Id;
	private String uomm;
	private float[] price;
	private String[] reasonForRejectionId;
	private String rfrId;
	private String[] storageLocationId;
	private String stLId;
	private String[] batchNo;
	private String batch;

	private int vendorReturnIdEditt;
	private String vendorReturnNoEditt;
	private String vendorReturnDateEditt;
	private String referenceEditt;
	private String descriptionEditt;
	private String purchaseOrderIdEditt;
	private String goodsReceiptIdEdit;
	private int aidEditt;

	private int[] vendorReturnLineIdEditt;

	public String getGoodsReceiptId() {
		return goodsReceiptId;
	}

	public float getOldQty() {
		return oldQty;
	}

	public void setOldQty(float oldQty) {
		this.oldQty = oldQty;
	}

	public void setGoodsReceiptId(String goodsReceiptId) {
		this.goodsReceiptId = goodsReceiptId;
	}

	private String[] material_IdEditt;
	private String mIdEditt;
	private Integer[] quantityEditt;
	private String[] uom_IdEditt;
	private String[] batchNoEdit;
	private String uommEditt;

	public String getRejQty() {
		return rejQty;
	}

	public void setRejQty(String rejQty) {
		this.rejQty = rejQty;
	}

	private float[] priceEditt;
	private String[] reasonForRejectionIdEditt;
	private String rfrIdEditt;
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	private String[] storageLocationIdEditt;
	private String stLIdEditt;

	/* =========================Basic Search=========================== */
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	/* =========================Advanced Search======================== */
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	

	public String getGoodsReceiptIdEdit() {
		return goodsReceiptIdEdit;
	}

	public void setGoodsReceiptIdEdit(String goodsReceiptIdEdit) {
		this.goodsReceiptIdEdit = goodsReceiptIdEdit;
	}

	

	/* ==========================Beans=============================== */
	private PurchaseOrder purchaseOrderBean;
	private ReasonForRejection rfrBean;
	private StorageLocation storageBean;

	public PurchaseOrder getPurchaseOrderBean() {
		return purchaseOrderBean;
	}

	public String[] getBatchNo() {
		return batchNo;
	}

	public String[] getBatchNoEdit() {
		return batchNoEdit;
	}

	public void setBatchNo(String[] batchNo) {
		this.batchNo = batchNo;
	}

	public void setBatchNoEdit(String[] batchNoEdit) {
		this.batchNoEdit = batchNoEdit;
	}

	public void setPurchaseOrderBean(PurchaseOrder purchaseOrderBean) {
		this.purchaseOrderBean = purchaseOrderBean;
	}

	public ReasonForRejection getRfrBean() {
		return rfrBean;
	}

	public void setRfrBean(ReasonForRejection rfrBean) {
		this.rfrBean = rfrBean;
	}

	public StorageLocation getStorageBean() {
		return storageBean;
	}

	public void setStorageBean(StorageLocation storageBean) {
		this.storageBean = storageBean;
	}

	/* ========================Others==================== */
	// private Material materialDetails;
	private String materialName;
	// private Uom uomDetails;
	private String uomName;
	// private ReasonForRejection rfrDetails;
	private String rfrName;
	// private StorageLocation storageDetails;
	private String storageName;

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getRfrName() {
		return rfrName;
	}

	public void setRfrName(String rfrName) {
		this.rfrName = rfrName;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	/* ==========================Child POJO Object===================== */

	private List<VendorReturnLine> vendorReturnLine;

	public List<VendorReturnLine> getVendorReturnLine() {
		return vendorReturnLine;
	}

	public void setVendorReturnLine(List<VendorReturnLine> vendorReturnLine) {
		this.vendorReturnLine = vendorReturnLine;
	}

	/* ===========================Getters============================== */

	public int getVendorReturnId() {
		return vendorReturnId;
	}

	public String getVendorReturnNo() {
		return vendorReturnNo;
	}

	public String getVendorReturnDate() {
		return vendorReturnDate;
	}

	public String getReference() {
		return reference;
	}

	public String getDescription() {
		return description;
	}

	public String getPurchaseOrderId() {
		return purchaseOrderId;
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

	

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public int getAid() {
		return aid;
	}

	public String[] getMaterial_Id() {
		return material_Id;
	}

	public String getmId() {
		return mId;
	}

	public Integer[] getQuantity() {
		return quantity;
	}

	public String[] getUom_Id() {
		return uom_Id;
	}

	public String getUomm() {
		return uomm;
	}

	public float[] getPrice() {
		return price;
	}

	public String[] getReasonForRejectionId() {
		return reasonForRejectionId;
	}

	public String getRfrId() {
		return rfrId;
	}

	public String[] getStorageLocationId() {
		return storageLocationId;
	}

	public String getStLId() {
		return stLId;
	}

	public int getVendorReturnIdEditt() {
		return vendorReturnIdEditt;
	}

	public String getVendorReturnNoEditt() {
		return vendorReturnNoEditt;
	}

	public String getVendorReturnDateEditt() {
		return vendorReturnDateEditt;
	}

	public String getReferenceEditt() {
		return referenceEditt;
	}

	public String getDescriptionEditt() {
		return descriptionEditt;
	}

	public String getPurchaseOrderIdEditt() {
		return purchaseOrderIdEditt;
	}

	public int getAidEditt() {
		return aidEditt;
	}

	public String[] getMaterial_IdEditt() {
		return material_IdEditt;
	}

	public String getmIdEditt() {
		return mIdEditt;
	}

	public Integer[] getQuantityEditt() {
		return quantityEditt;
	}

	public String[] getUom_IdEditt() {
		return uom_IdEditt;
	}

	public String getUommEditt() {
		return uommEditt;
	}

	public float[] getPriceEditt() {
		return priceEditt;
	}

	public String[] getReasonForRejectionIdEditt() {
		return reasonForRejectionIdEditt;
	}

	public String getRfrIdEditt() {
		return rfrIdEditt;
	}

	public String[] getStorageLocationIdEditt() {
		return storageLocationIdEditt;
	}

	public String getStLIdEditt() {
		return stLIdEditt;
	}

	public int[] getVendorReturnLineIdEditt() {
		return vendorReturnLineIdEditt;
	}

	public float getStockEdit() {
		return stockEdit;
	}

	/* ===========================Setters===================== */

	public void setVendorReturnLineIdEditt(int[] vendorReturnLineIdEditt) {
		this.vendorReturnLineIdEditt = vendorReturnLineIdEditt;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setVendorReturnId(int vendorReturnId) {
		this.vendorReturnId = vendorReturnId;
	}

	public void setVendorReturnNo(String vendorReturnNo) {
		this.vendorReturnNo = vendorReturnNo;
	}

	public void setVendorReturnDate(String vendorReturnDate) {
		this.vendorReturnDate = vendorReturnDate;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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

	

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public String getLabels() {
		return labels;
	}

	public String getDbField() {
		return dbField;
	}

	public String getAsOpts() {
		return asOpts;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	public void setMaterial_Id(String[] material_Id) {
		this.material_Id = material_Id;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}

	public void setUom_Id(String[] uom_Id) {
		this.uom_Id = uom_Id;
	}

	public void setUomm(String uomm) {
		this.uomm = uomm;
	}

	public void setPrice(float[] price) {
		this.price = price;
	}

	public void setReasonForRejectionId(String[] reasonForRejectionId) {
		this.reasonForRejectionId = reasonForRejectionId;
	}

	public void setRfrId(String rfrId) {
		this.rfrId = rfrId;
	}

	public void setStorageLocationId(String[] storageLocationId) {
		this.storageLocationId = storageLocationId;
	}

	public void setStLId(String stLId) {
		this.stLId = stLId;
	}

	public void setVendorReturnIdEditt(int vendorReturnIdEditt) {
		this.vendorReturnIdEditt = vendorReturnIdEditt;
	}

	public void setVendorReturnNoEditt(String vendorReturnNoEditt) {
		this.vendorReturnNoEditt = vendorReturnNoEditt;
	}

	public void setVendorReturnDateEditt(String vendorReturnDateEditt) {
		this.vendorReturnDateEditt = vendorReturnDateEditt;
	}

	public void setReferenceEditt(String referenceEditt) {
		this.referenceEditt = referenceEditt;
	}

	public void setDescriptionEditt(String descriptionEditt) {
		this.descriptionEditt = descriptionEditt;
	}

	public void setPurchaseOrderIdEditt(String purchaseOrderIdEditt) {
		this.purchaseOrderIdEditt = purchaseOrderIdEditt;
	}

	public void setAidEditt(int aidEditt) {
		this.aidEditt = aidEditt;
	}

	public void setMaterial_IdEditt(String[] material_IdEditt) {
		this.material_IdEditt = material_IdEditt;
	}

	public void setmIdEditt(String mIdEditt) {
		this.mIdEditt = mIdEditt;
	}

	public void setQuantityEditt(Integer[] quantityEditt) {
		this.quantityEditt = quantityEditt;
	}

	public void setUom_IdEditt(String[] uom_IdEditt) {
		this.uom_IdEditt = uom_IdEditt;
	}

	public void setUommEditt(String uommEditt) {
		this.uommEditt = uommEditt;
	}

	public void setPriceEditt(float[] priceEditt) {
		this.priceEditt = priceEditt;
	}

	public void setReasonForRejectionIdEditt(String[] reasonForRejectionIdEditt) {
		this.reasonForRejectionIdEditt = reasonForRejectionIdEditt;
	}

	public void setRfrIdEditt(String rfrIdEditt) {
		this.rfrIdEditt = rfrIdEditt;
	}

	public void setStorageLocationIdEditt(String[] storageLocationIdEditt) {
		this.storageLocationIdEditt = storageLocationIdEditt;
	}

	public void setStLIdEditt(String stLIdEditt) {
		this.stLIdEditt = stLIdEditt;
	}

	public void setStockEdit(float stockEdit) {
		this.stockEdit = stockEdit;
	}

}
