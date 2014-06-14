/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author kirangangone
 * 
 */
public class GoodsIssue {

	private int goodsIssueId;
	private String goodsIssueNo;
	private String goodsIssueDate;
	private String deliveryNoteId;
	private String producionOrderId;
	private String postingDate;
	private String reasonForMovementId;
	private String reference;
	private String goodsIssueNoDuplicate;

	/* Basic Search And Advanced Search */
	private String xmlLabelBasic;
	private String operations;
	private String basicSearchId;
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	private int advanceBasicSearchHidden;

	private int[] goodsIssueLineId;
	private String[] materialId;
	private String[] qty;
	private String[] qtyAcc;
	private String[] uOMId;
	private String[] batchNo;
	private String[] plantId;
	private String[] storageLocationId;

	private String materialIdSelect;
	private String uOMIdSelect;
	private String plantIdSelect;
	private String storageLocationIdSelect;
	private String batchNoSelect;

	private String[] materialName;
	private String[] uOMName;
	private String[] plantName;
	private String[] storageLocationName;

	private ReasonForMovement reasonForMovementDetails;

	private List<GoodsIssueLine> goodsIssueLineDetails;

	/**
	 * @return the goodsIssueId
	 */
	public int getGoodsIssueId() {
		return goodsIssueId;
	}

	/**
	 * @param goodsIssueId
	 *            the goodsIssueId to set
	 */
	public void setGoodsIssueId(int goodsIssueId) {
		this.goodsIssueId = goodsIssueId;
	}

	/**
	 * @return the goodsIssueNo
	 */
	public String getGoodsIssueNo() {
		return goodsIssueNo;
	}

	/**
	 * @param goodsIssueNo
	 *            the goodsIssueNo to set
	 */
	public void setGoodsIssueNo(String goodsIssueNo) {
		this.goodsIssueNo = goodsIssueNo;
	}

	/**
	 * @return the goodsIssueDate
	 */
	public String getGoodsIssueDate() {
		return goodsIssueDate;
	}

	/**
	 * @param goodsIssueDate
	 *            the goodsIssueDate to set
	 */
	public void setGoodsIssueDate(String goodsIssueDate) {
		this.goodsIssueDate = goodsIssueDate;
	}

	/**
	 * @return the deliveryNoteId
	 */
	public String getDeliveryNoteId() {
		return deliveryNoteId;
	}

	/**
	 * @param deliveryNoteId
	 *            the deliveryNoteId to set
	 */
	public void setDeliveryNoteId(String deliveryNoteId) {
		this.deliveryNoteId = deliveryNoteId;
	}

	/**
	 * @return the producionOrderId
	 */
	public String getProducionOrderId() {
		return producionOrderId;
	}

	/**
	 * @param producionOrderId
	 *            the producionOrderId to set
	 */
	public void setProducionOrderId(String producionOrderId) {
		this.producionOrderId = producionOrderId;
	}

	/**
	 * @return the postingDate
	 */
	public String getPostingDate() {
		return postingDate;
	}

	/**
	 * @param postingDate
	 *            the postingDate to set
	 */
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	/**
	 * @return the reasonForMovementId
	 */
	public String getReasonForMovementId() {
		return reasonForMovementId;
	}

	/**
	 * @param reasonForMovementId
	 *            the reasonForMovementId to set
	 */
	public void setReasonForMovementId(String reasonForMovementId) {
		this.reasonForMovementId = reasonForMovementId;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the xmlLabelBasic
	 */
	public String getXmlLabelBasic() {
		return xmlLabelBasic;
	}

	/**
	 * @param xmlLabelBasic
	 *            the xmlLabelBasic to set
	 */
	public void setXmlLabelBasic(String xmlLabelBasic) {
		this.xmlLabelBasic = xmlLabelBasic;
	}

	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}

	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}

	/**
	 * @param basicSearchId
	 *            the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

	/**
	 * @return the firstLabel
	 */
	public String getFirstLabel() {
		return firstLabel;
	}

	/**
	 * @param firstLabel
	 *            the firstLabel to set
	 */
	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	/**
	 * @return the secondLabel
	 */
	public String getSecondLabel() {
		return secondLabel;
	}

	/**
	 * @param secondLabel
	 *            the secondLabel to set
	 */
	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	/**
	 * @return the operations1
	 */
	public String getOperations1() {
		return operations1;
	}

	/**
	 * @param operations1
	 *            the operations1 to set
	 */
	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}

	/**
	 * @return the advanceSearchText
	 */
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	/**
	 * @param advanceSearchText
	 *            the advanceSearchText to set
	 */
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	/**
	 * @return the advanceSearchHidden
	 */
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	/**
	 * @param advanceSearchHidden
	 *            the advanceSearchHidden to set
	 */
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	/**
	 * @return the goodsIssueLineId
	 */
	public int[] getGoodsIssueLineId() {
		return goodsIssueLineId;
	}

	/**
	 * @param goodsIssueLineId
	 *            the goodsIssueLineId to set
	 */
	public void setGoodsIssueLineId(int[] goodsIssueLineId) {
		this.goodsIssueLineId = goodsIssueLineId;
	}

	/**
	 * @return the materialId
	 */
	public String[] getMaterialId() {
		return materialId;
	}

	/**
	 * @param materialId
	 *            the materialId to set
	 */
	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}

	/**
	 * @return the qty
	 */
	public String[] getQty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setQty(String[] qty) {
		this.qty = qty;
	}

	/**
	 * @return the uOMId
	 */
	public String[] getuOMId() {
		return uOMId;
	}

	/**
	 * @param uOMId
	 *            the uOMId to set
	 */
	public void setuOMId(String[] uOMId) {
		this.uOMId = uOMId;
	}

	/**
	 * @return the batchNo
	 */
	public String[] getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo
	 *            the batchNo to set
	 */
	public void setBatchNo(String[] batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the plantId
	 */
	public String[] getPlantId() {
		return plantId;
	}

	/**
	 * @param plantId
	 *            the plantId to set
	 */
	public void setPlantId(String[] plantId) {
		this.plantId = plantId;
	}

	/**
	 * @return the storageLocationId
	 */
	public String[] getStorageLocationId() {
		return storageLocationId;
	}

	/**
	 * @param storageLocationId
	 *            the storageLocationId to set
	 */
	public void setStorageLocationId(String[] storageLocationId) {
		this.storageLocationId = storageLocationId;
	}

	/**
	 * @return the materialName
	 */
	public String[] getMaterialName() {
		return materialName;
	}

	/**
	 * @param materialName
	 *            the materialName to set
	 */
	public void setMaterialName(String[] materialName) {
		this.materialName = materialName;
	}

	/**
	 * @return the uOMName
	 */
	public String[] getuOMName() {
		return uOMName;
	}

	/**
	 * @param uOMName
	 *            the uOMName to set
	 */
	public void setuOMName(String[] uOMName) {
		this.uOMName = uOMName;
	}

	/**
	 * @return the plantName
	 */
	public String[] getPlantName() {
		return plantName;
	}

	/**
	 * @param plantName
	 *            the plantName to set
	 */
	public void setPlantName(String[] plantName) {
		this.plantName = plantName;
	}

	/**
	 * @return the storageLocationName
	 */
	public String[] getStorageLocationName() {
		return storageLocationName;
	}

	/**
	 * @param storageLocationName
	 *            the storageLocationName to set
	 */
	public void setStorageLocationName(String[] storageLocationName) {
		this.storageLocationName = storageLocationName;
	}

	/**
	 * @return the advanceBasicSearchHidden
	 */
	public int getAdvanceBasicSearchHidden() {
		return advanceBasicSearchHidden;
	}

	/**
	 * @param advanceBasicSearchHidden
	 *            the advanceBasicSearchHidden to set
	 */
	public void setAdvanceBasicSearchHidden(int advanceBasicSearchHidden) {
		this.advanceBasicSearchHidden = advanceBasicSearchHidden;
	}

	/**
	 * @return the goodsIssueNoDuplicate
	 */
	public String getGoodsIssueNoDuplicate() {
		return goodsIssueNoDuplicate;
	}

	/**
	 * @param goodsIssueNoDuplicate
	 *            the goodsIssueNoDuplicate to set
	 */
	public void setGoodsIssueNoDuplicate(String goodsIssueNoDuplicate) {
		this.goodsIssueNoDuplicate = goodsIssueNoDuplicate;
	}

	/**
	 * @return the goodsIssueLineDetails
	 */
	public List<GoodsIssueLine> getGoodsIssueLineDetails() {
		return goodsIssueLineDetails;
	}

	/**
	 * @param goodsIssueLineDetails
	 *            the goodsIssueLineDetails to set
	 */
	public void setGoodsIssueLineDetails(
			List<GoodsIssueLine> goodsIssueLineDetails) {
		this.goodsIssueLineDetails = goodsIssueLineDetails;
	}

	/**
	 * @return the materialIdSelect
	 */
	public String getMaterialIdSelect() {
		return materialIdSelect;
	}

	/**
	 * @param materialIdSelect
	 *            the materialIdSelect to set
	 */
	public void setMaterialIdSelect(String materialIdSelect) {
		this.materialIdSelect = materialIdSelect;
	}

	/**
	 * @return the uOMIdSelect
	 */
	public String getuOMIdSelect() {
		return uOMIdSelect;
	}

	/**
	 * @param uOMIdSelect
	 *            the uOMIdSelect to set
	 */
	public void setuOMIdSelect(String uOMIdSelect) {
		this.uOMIdSelect = uOMIdSelect;
	}

	/**
	 * @return the plantIdSelect
	 */
	public String getPlantIdSelect() {
		return plantIdSelect;
	}

	/**
	 * @param plantIdSelect
	 *            the plantIdSelect to set
	 */
	public void setPlantIdSelect(String plantIdSelect) {
		this.plantIdSelect = plantIdSelect;
	}

	/**
	 * @return the storageLocationIdSelect
	 */
	public String getStorageLocationIdSelect() {
		return storageLocationIdSelect;
	}

	/**
	 * @param storageLocationIdSelect
	 *            the storageLocationIdSelect to set
	 */
	public void setStorageLocationIdSelect(String storageLocationIdSelect) {
		this.storageLocationIdSelect = storageLocationIdSelect;
	}

	/**
	 * @return the reasonForMovementDetails
	 */
	public ReasonForMovement getReasonForMovementDetails() {
		return reasonForMovementDetails;
	}

	/**
	 * @param reasonForMovementDetails
	 *            the reasonForMovementDetails to set
	 */
	public void setReasonForMovementDetails(
			ReasonForMovement reasonForMovementDetails) {
		this.reasonForMovementDetails = reasonForMovementDetails;
	}

	/**
	 * @return the batchNoSelect
	 */
	public String getBatchNoSelect() {
		return batchNoSelect;
	}

	/**
	 * @param batchNoSelect
	 *            the batchNoSelect to set
	 */
	public void setBatchNoSelect(String batchNoSelect) {
		this.batchNoSelect = batchNoSelect;
	}

	/**
	 * @return the qtyAcc
	 */
	public String[] getQtyAcc() {
		return qtyAcc;
	}

	/**
	 * @param qtyAcc
	 *            the qtyAcc to set
	 */
	public void setQtyAcc(String[] qtyAcc) {
		this.qtyAcc = qtyAcc;
	}

}
