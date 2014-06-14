/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 *
 */
public class VendorReturnLine {
	
	
	private int vendorReturnLineId;
	private int vendorReturnId;
	private String material_Id;
	private int quantity;
	private String uom_Id;
	private float price;
	private String reasonForRejectionId;
	private String storageLocationId;
	private float stockEdit;
	private String batchNo;
	
	private int vendorReturnLineIdEditt;
	private int vendorReturnIdEditt;
	private String material_IdEditt;
	private int quantityEditt;
	private String uom_IdEditt;
	private float priceEditt;
	private String reasonForRejectionIdEditt;
	private String storageLocationIdEditt;
	private String batchNoEdit;
	
	/*========================Others====================*/
	private Material materialDetails;
	private String materialName;
	private Uom uomDetails;
	private String uomName;
	private ReasonForRejection rfrDetails;
	private String rfrName;
	private StorageLocation storageDetails;
	private String storageName;


	/*==========================Getters=====================*/
	
	public int getVendorReturnLineId() {
		return vendorReturnLineId;
	}
	public int getVendorReturnId() {
		return vendorReturnId;
	}
	public String getMaterial_Id() {
		return material_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getUom_Id() {
		return uom_Id;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public float getPrice() {
		return price;
	}
	public String getReasonForRejectionId() {
		return reasonForRejectionId;
	}
	public String getStorageLocationId() {
		return storageLocationId;
	}
	public int getVendorReturnLineIdEditt() {
		return vendorReturnLineIdEditt;
	}
	public int getVendorReturnIdEditt() {
		return vendorReturnIdEditt;
	}
	public String getMaterial_IdEditt() {
		return material_IdEditt;
	}
	public int getQuantityEditt() {
		return quantityEditt;
	}
	public String getUom_IdEditt() {
		return uom_IdEditt;
	}
	public float getPriceEditt() {
		return priceEditt;
	}
	public String getBatchNoEdit() {
		return batchNoEdit;
	}
	public void setBatchNoEdit(String batchNoEdit) {
		this.batchNoEdit = batchNoEdit;
	}
	public String getReasonForRejectionIdEditt() {
		return reasonForRejectionIdEditt;
	}
	public String getStorageLocationIdEditt() {
		return storageLocationIdEditt;
	}
	
	public Material getMaterialDetails() {
		return materialDetails;
	}
	public String getMaterialName() {
		return materialName;
	}
	public Uom getUomDetails() {
		return uomDetails;
	}
	public String getUomName() {
		return uomName;
	}
	public ReasonForRejection getRfrDetails() {
		return rfrDetails;
	}
	public String getRfrName() {
		return rfrName;
	}
	public StorageLocation getStorageDetails() {
		return storageDetails;
	}
	public String getStorageName() {
		return storageName;
	}
	
	public float getStockEdit() {
		return stockEdit;
	}
	
	/*===========================Setters=====================*/
	public void setVendorReturnLineId(int vendorReturnLineId) {
		this.vendorReturnLineId = vendorReturnLineId;
	}
		public void setVendorReturnId(int vendorReturnId) {
		this.vendorReturnId = vendorReturnId;
	}
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setReasonForRejectionId(String reasonForRejectionId) {
		this.reasonForRejectionId = reasonForRejectionId;
	}
	public void setStorageLocationId(String storageLocationId) {
		this.storageLocationId = storageLocationId;
	}
	public void setVendorReturnLineIdEditt(int vendorReturnLineIdEditt) {
		this.vendorReturnLineIdEditt = vendorReturnLineIdEditt;
	}
	public void setVendorReturnIdEditt(int vendorReturnIdEditt) {
		this.vendorReturnIdEditt = vendorReturnIdEditt;
	}
	public void setMaterial_IdEditt(String material_IdEditt) {
		this.material_IdEditt = material_IdEditt;
	}
	public void setQuantityEditt(int quantityEditt) {
		this.quantityEditt = quantityEditt;
	}
	public void setUom_IdEditt(String uom_IdEditt) {
		this.uom_IdEditt = uom_IdEditt;
	}
	public void setPriceEditt(float priceEditt) {
		this.priceEditt = priceEditt;
	}
	public void setReasonForRejectionIdEditt(String reasonForRejectionIdEditt) {
		this.reasonForRejectionIdEditt = reasonForRejectionIdEditt;
	}
	public void setStorageLocationIdEditt(String storageLocationIdEditt) {
		this.storageLocationIdEditt = storageLocationIdEditt;
	}
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public void setRfrDetails(ReasonForRejection rfrDetails) {
		this.rfrDetails = rfrDetails;
	}
	public void setRfrName(String rfrName) {
		this.rfrName = rfrName;
	}
	public void setStorageDetails(StorageLocation storageDetails) {
		this.storageDetails = storageDetails;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public void setStockEdit(float stockEdit) {
		this.stockEdit = stockEdit;
	}

}
