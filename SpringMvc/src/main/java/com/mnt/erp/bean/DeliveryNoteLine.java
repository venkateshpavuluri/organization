/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 * 
 */
public class DeliveryNoteLine {

	private int deliveryNoteLineId;
	private int deliveryNoteId;
	private int materialId;
	private float quantity;
	private int uomId;
	private int storageLoacationId;
	private int salesOrderId;
	private String batchNo;

	/* RlationShip Properties */
	private Material materialDetails;
	private Uom uomDetails;
	private StorageLocation storageLocDetails;

	/**
	 * @return the materialDetails
	 */
	public Material getMaterialDetails() {
		return materialDetails;
	}

	/**
	 * @param materialDetails
	 *            the materialDetails to set
	 */
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
	}

	/**
	 * @return the uomDetails
	 */
	public Uom getUomDetails() {
		return uomDetails;
	}

	/**
	 * @param uomDetails
	 *            the uomDetails to set
	 */
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}

	/**
	 * @return the storageLocDetails
	 */
	public StorageLocation getStorageLocDetails() {
		return storageLocDetails;
	}

	/**
	 * @param storageLocDetails
	 *            the storageLocDetails to set
	 */
	public void setStorageLocDetails(StorageLocation storageLocDetails) {
		this.storageLocDetails = storageLocDetails;
	}

	/**
	 * @return the salesOrderId
	 */
	public int getSalesOrderId() {
		return salesOrderId;
	}

	/**
	 * @param salesOrderId
	 *            the salesOrderId to set
	 */
	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	/**
	 * @return the deliveryNoteLineId
	 */
	public int getDeliveryNoteLineId() {
		return deliveryNoteLineId;
	}

	/**
	 * @param deliveryNoteLineId
	 *            the deliveryNoteLineId to set
	 */
	public void setDeliveryNoteLineId(int deliveryNoteLineId) {
		this.deliveryNoteLineId = deliveryNoteLineId;
	}

	/**
	 * @return the deliveryNoteId
	 */
	public int getDeliveryNoteId() {
		return deliveryNoteId;
	}

	/**
	 * @param deliveryNoteId
	 *            the deliveryNoteId to set
	 */
	public void setDeliveryNoteId(int deliveryNoteId) {
		this.deliveryNoteId = deliveryNoteId;
	}

	/**
	 * @return the materialId
	 */
	public int getMaterialId() {
		return materialId;
	}

	/**
	 * @param materialId
	 *            the materialId to set
	 */
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the uomId
	 */
	public int getUomId() {
		return uomId;
	}

	/**
	 * @param uomId
	 *            the uomId to set
	 */
	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the storageLoacationId
	 */
	public int getStorageLoacationId() {
		return storageLoacationId;
	}

	/**
	 * @param storageLoacationId
	 *            the storageLoacationId to set
	 */
	public void setStorageLoacationId(int storageLoacationId) {
		this.storageLoacationId = storageLoacationId;
	}

}
