/**
 * 
 */
package com.mnt.erp.bean;

import java.util.Set;

/**
 * @author venkateshp
 *
 */
public class DeliveryNote  {
	
private int	deliveryNoteId;
private String 	deliveryNoteDate;
private String	salesOrderId;
private String salesOrderName;
private String	totalWeight;
private String	uomId;
private String uomName;
private String	plannedGI;
private String	actualGI;
private String	noofPacks;
private String statusId;
private String statusName;
private int dnId;

/*DeliveryNoteLine Properties*/
private int deliveryNoteLine;
private String deliveryNote;
private String materialId;
private String dnluomid;
private String quantity;
private String storageLocation;
private String batchNo;


/*RelationShip Properties*/

private Set<DeliveryNoteLine> deliveryNotes;
private Uom uomDetails;
private Status statusDetails;
private SalesOrderBean salesOrderDetails;


/*DeliveryNote Edit Properties*/

private int	deliveryNoteIdEdit;
private String 	deliveryNoteDateEdit;
private String	salesOrderIdEdit;
private String	totalWeightEdit;
private String	uomIdEdit;
private String	plannedGIEdit;
private String	actualGIEdit;
private String	noofPacksEdit;
private String statusIdEdit;

/*DeliveryNoteLine Edit Properties*/
private String deliveryNoteLineidedit;
private String dnluomIdEdit;
private String dnluomNameEdit;
private String quantityEdit;
private String batchNoEdit;

private String storageLocationEdit;
private String storageLocNameEdit;
private String materialIdEdit;
private String materialNameEdit;

private String deliveryNoteEdit;



/*Basic Search*/
private String xmlLabel;
private String operations;
private String basicSearchId;

/*Advance Search*/
private String labels;
private String dbField;
private String asOpts;
private String advanceSearchText;
private int advanceSearchHidden;
	
	private int deliveryineidedit;
	
	/*
	hide properties*/
	
	private int deliveryhide;
	
	public int getDnId() {
		return dnId;
	}

	public void setDnId(int dnId) {
		this.dnId = dnId;
	}

	

	/**
	 * @return the deliveryineidedit
	 */
	public int getDeliveryineidedit() {
		return deliveryineidedit;
	}

	/**
	 * @param deliveryineidedit the deliveryineidedit to set
	 */
	public void setDeliveryineidedit(int deliveryineidedit) {
		this.deliveryineidedit = deliveryineidedit;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the salesOrderName
	 */
	public String getSalesOrderName() {
		return salesOrderName;
	}

	/**
	 * @param salesOrderName the salesOrderName to set
	 */
	public void setSalesOrderName(String salesOrderName) {
		this.salesOrderName = salesOrderName;
	}

	/**
	 * @return the salesOrderDetails
	 */
	public SalesOrderBean getSalesOrderDetails() {
		return salesOrderDetails;
	}

	/**
	 * @param salesOrderDetails the salesOrderDetails to set
	 */
	public void setSalesOrderDetails(SalesOrderBean salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	public String getBatchNoEdit() {
		return batchNoEdit;
	}

	public void setBatchNoEdit(String batchNoEdit) {
		this.batchNoEdit = batchNoEdit;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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

	public Set<DeliveryNoteLine> getDeliveryNotes() {
		return deliveryNotes;
	}

	public void setDeliveryNotes(Set<DeliveryNoteLine> deliveryNotes) {
		this.deliveryNotes = deliveryNotes;
	}

	public int getDeliveryNoteId() {
		return deliveryNoteId;
	}

	public void setDeliveryNoteId(int deliveryNoteId) {
		this.deliveryNoteId = deliveryNoteId;
	}

	public String getDeliveryNoteDate() {
		return deliveryNoteDate;
	}

	public void setDeliveryNoteDate(String deliveryNoteDate) {
		this.deliveryNoteDate = deliveryNoteDate;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getPlannedGI() {
		return plannedGI;
	}

	public void setPlannedGI(String plannedGI) {
		this.plannedGI = plannedGI;
	}

	public String getActualGI() {
		return actualGI;
	}

	public void setActualGI(String actualGI) {
		this.actualGI = actualGI;
	}

	public String getNoofPacks() {
		return noofPacks;
	}

	public void setNoofPacks(String noofPacks) {
		this.noofPacks = noofPacks;
	}

	

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public int getDeliveryNoteLine() {
		return deliveryNoteLine;
	}

	public void setDeliveryNoteLine(int deliveryNoteLine) {
		this.deliveryNoteLine = deliveryNoteLine;
	}

	

	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getDnluomid() {
		return dnluomid;
	}

	public void setDnluomid(String dnluomid) {
		this.dnluomid = dnluomid;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public void setUomIdEdit(String uomIdEdit) {
		this.uomIdEdit = uomIdEdit;
	}



	/**
	 * @return the deliveryNoteIdEdit
	 */
	public int getDeliveryNoteIdEdit() {
		return deliveryNoteIdEdit;
	}

	/**
	 * @param deliveryNoteIdEdit the deliveryNoteIdEdit to set
	 */
	public void setDeliveryNoteIdEdit(int deliveryNoteIdEdit) {
		this.deliveryNoteIdEdit = deliveryNoteIdEdit;
	}

	public String getDeliveryNoteDateEdit() {
		return deliveryNoteDateEdit;
	}

	public void setDeliveryNoteDateEdit(String deliveryNoteDateEdit) {
		this.deliveryNoteDateEdit = deliveryNoteDateEdit;
	}

	public String getSalesOrderIdEdit() {
		return salesOrderIdEdit;
	}

	public void setSalesOrderIdEdit(String salesOrderIdEdit) {
		this.salesOrderIdEdit = salesOrderIdEdit;
	}

	public String getTotalWeightEdit() {
		return totalWeightEdit;
	}

	public void setTotalWeightEdit(String totalWeightEdit) {
		this.totalWeightEdit = totalWeightEdit;
	}



	public String getUomIdEdit() {
		return uomIdEdit;
	}

	public String getPlannedGIEdit() {
		return plannedGIEdit;
	}

	public void setPlannedGIEdit(String plannedGIEdit) {
		this.plannedGIEdit = plannedGIEdit;
	}

	public String getActualGIEdit() {
		return actualGIEdit;
	}

	public void setActualGIEdit(String actualGIEdit) {
		this.actualGIEdit = actualGIEdit;
	}

	public String getNoofPacksEdit() {
		return noofPacksEdit;
	}

	public void setNoofPacksEdit(String noofPacksEdit) {
		this.noofPacksEdit = noofPacksEdit;
	}

	public String getStatusIdEdit() {
		return statusIdEdit;
	}

	public void setStatusIdEdit(String statusIdEdit) {
		this.statusIdEdit = statusIdEdit;
	}







	/**
	 * @return the deliveryNoteLineidedit
	 */
	public String getDeliveryNoteLineidedit() {
		return deliveryNoteLineidedit;
	}

	/**
	 * @param deliveryNoteLineidedit the deliveryNoteLineidedit to set
	 */
	public void setDeliveryNoteLineidedit(String deliveryNoteLineidedit) {
		this.deliveryNoteLineidedit = deliveryNoteLineidedit;
	}

	/**
	 * @return the dnluomIdEdit
	 */
	public String getDnluomIdEdit() {
		return dnluomIdEdit;
	}

	/**
	 * @param dnluomIdEdit the dnluomIdEdit to set
	 */
	public void setDnluomIdEdit(String dnluomIdEdit) {
		this.dnluomIdEdit = dnluomIdEdit;
	}

	/**
	 * @return the dnluomNameEdit
	 */
	public String getDnluomNameEdit() {
		return dnluomNameEdit;
	}

	/**
	 * @param dnluomNameEdit the dnluomNameEdit to set
	 */
	public void setDnluomNameEdit(String dnluomNameEdit) {
		this.dnluomNameEdit = dnluomNameEdit;
	}

	/**
	 * @return the quantityEdit
	 */
	public String getQuantityEdit() {
		return quantityEdit;
	}

	/**
	 * @param quantityEdit the quantityEdit to set
	 */
	public void setQuantityEdit(String quantityEdit) {
		this.quantityEdit = quantityEdit;
	}

	/**
	 * @return the storageLocationEdit
	 */
	public String getStorageLocationEdit() {
		return storageLocationEdit;
	}

	/**
	 * @param storageLocationEdit the storageLocationEdit to set
	 */
	public void setStorageLocationEdit(String storageLocationEdit) {
		this.storageLocationEdit = storageLocationEdit;
	}

	/**
	 * @return the storageLocNameEdit
	 */
	public String getStorageLocNameEdit() {
		return storageLocNameEdit;
	}

	/**
	 * @param storageLocNameEdit the storageLocNameEdit to set
	 */
	public void setStorageLocNameEdit(String storageLocNameEdit) {
		this.storageLocNameEdit = storageLocNameEdit;
	}

	/**
	 * @return the materialIdEdit
	 */
	public String getMaterialIdEdit() {
		return materialIdEdit;
	}

	/**
	 * @param materialIdEdit the materialIdEdit to set
	 */
	public void setMaterialIdEdit(String materialIdEdit) {
		this.materialIdEdit = materialIdEdit;
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

	/**
	 * @return the deliveryNoteEdit
	 */
	public String getDeliveryNoteEdit() {
		return deliveryNoteEdit;
	}

	/**
	 * @param deliveryNoteEdit the deliveryNoteEdit to set
	 */
	public void setDeliveryNoteEdit(String deliveryNoteEdit) {
		this.deliveryNoteEdit = deliveryNoteEdit;
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

	public String getAdvanceSearchText() {
		return advanceSearchText;
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

	public int getDeliveryhide() {
		return deliveryhide;
	}

	public void setDeliveryhide(int deliveryhide) {
		this.deliveryhide = deliveryhide;
	}
	
	


}
