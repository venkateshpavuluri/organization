/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 * 
 */
public class GoodsIssueLine {

	private int goodsIssueLineId;
	private String goodsIssueId;
	private String materialId;
	private String qty;
	private String qtyAcc;
	private String uOMId;
	private String batchNo;
	private String plantId;
	private String storageLocationId;

	private String materialName;
	private String uOMName;
	private String plantName;
	private String storageLocationName;

	private Material materialDetails;
	private Uom uomDetails;
	private Plant plantDetails;
	private StorageLocation storageLocDetails;
	
	
	
	public int getGoodsIssueLineId() {
		return goodsIssueLineId;
	}
	public String getGoodsIssueId() {
		return goodsIssueId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public String getQty() {
		return qty;
	}
	public String getQtyAcc() {
		return qtyAcc;
	}
	public String getuOMId() {
		return uOMId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public String getPlantId() {
		return plantId;
	}
	public String getStorageLocationId() {
		return storageLocationId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getuOMName() {
		return uOMName;
	}
	public String getPlantName() {
		return plantName;
	}
	public String getStorageLocationName() {
		return storageLocationName;
	}
	public Material getMaterialDetails() {
		return materialDetails;
	}
	public Uom getUomDetails() {
		return uomDetails;
	}
	public Plant getPlantDetails() {
		return plantDetails;
	}
	public StorageLocation getStorageLocDetails() {
		return storageLocDetails;
	}
	public void setGoodsIssueLineId(int goodsIssueLineId) {
		this.goodsIssueLineId = goodsIssueLineId;
	}
	public void setGoodsIssueId(String goodsIssueId) {
		this.goodsIssueId = goodsIssueId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public void setQtyAcc(String qtyAcc) {
		this.qtyAcc = qtyAcc;
	}
	public void setuOMId(String uOMId) {
		this.uOMId = uOMId;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public void setStorageLocationId(String storageLocationId) {
		this.storageLocationId = storageLocationId;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setuOMName(String uOMName) {
		this.uOMName = uOMName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public void setStorageLocationName(String storageLocationName) {
		this.storageLocationName = storageLocationName;
	}
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
	}
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}
	public void setPlantDetails(Plant plantDetails) {
		this.plantDetails = plantDetails;
	}
	public void setStorageLocDetails(StorageLocation storageLocDetails) {
		this.storageLocDetails = storageLocDetails;
	}

	

}
