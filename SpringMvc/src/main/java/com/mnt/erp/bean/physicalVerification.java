/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;
import java.util.Set;

/**
 * @author kirangangone
 *
 */
public class physicalVerification {

	
	
	/*
	 * Physical Verification 
	 */
	private int verificationId;
	private String verificationNo;
    private String verificationTypeId;
    private String orgId;
    private String plantId;
    private String storageLocaionId;
    private String verificationDate;
 	private Organization orgDetails;
 	private Plant plantDetails;
 	private StorageLocation storageLocDetails;
 	private VerificationtypeBean verfTypeDetails;
 	private int physicalVerificationAddDuplicate;
 	private int physicalVerificationEditDuplicate;
 	private  List<physicalVerification> physicalVerificationListType;
 	private  Set<physicalVerificationLine> physicalVerificationFk;
 	
 	private int pvId;
 	private int pvEditId;
 	
 	private String materialName;
 	private String uomName;
 	
 	
 	private int verificationIdEdit;
	private String verificationNoEdit;
    private String verificationTypeIdEdit;
    private String orgIdEdit;
    private String plantIdEdit;
    private String storageLocaionIdEdit;
    private String verificationDateEdit;
 	private Organization orgDetailsEdit;
 	private Plant plantDetailsEdit;
 	private StorageLocation storageLocDetailsEdit;
 	
 	
 	/*
 	 * Physical Verification Line 
 	 */
 	private int[] verificationLineIdChild; 
 	private String[] materialIdChild; 
 	private String[] batchNoChild; 
 	private String[] bookQtyChild; 
 	private String[] physicalQtyChild;
 	private String[] uomIdChild;
 	
 	
 	private int verificationLineId; 
 	private String materialId; 
 	private String batchNo; 
 	private String bookQty; 
 	private String physicalQty;
 	private String uomId;
 	
 	
 	
 	private int[] verificationLineIdChildEdit; 
 	private String[] materialIdChildEdit; 
 	private String[] batchNoChildEdit; 
 	private String[] bookQtyChildEdit; 
 	private String[] physicalQtyChildEdit;
 	private String[] uomIdChildEdit;
 	
 	
   /*
    * Basic And Advanced Search
    */
 	
 	
 	
 	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden; 
	
	
	
 	/*
 	 * Setter And Getters For Insert , Edit Physical Verification 
 	 */
 	
 	
 	
	/**
	 * @return the verificationId
	 */
	public int getVerificationId() {
		return verificationId;
	}
	/**
	 * @param verificationId the verificationId to set
	 */
	public void setVerificationId(int verificationId) {
		this.verificationId = verificationId;
	}
	/**
	 * @return the verificationNo
	 */
	public String getVerificationNo() {
		return verificationNo;
	}
	/**
	 * @param verificationNo the verificationNo to set
	 */
	public void setVerificationNo(String verificationNo) {
		this.verificationNo = verificationNo;
	}
	/**
	 * @return the verificationTypeId
	 */
	public String getVerificationTypeId() {
		return verificationTypeId;
	}
	/**
	 * @param verificationTypeId the verificationTypeId to set
	 */
	public void setVerificationTypeId(String verificationTypeId) {
		this.verificationTypeId = verificationTypeId;
	}
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the plantId
	 */
	public String getPlantId() {
		return plantId;
	}
	/**
	 * @param plantId the plantId to set
	 */
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	/**
	 * @return the storageLocaionId
	 */
	public String getStorageLocaionId() {
		return storageLocaionId;
	}
	/**
	 * @param storageLocaionId the storageLocaionId to set
	 */
	public void setStorageLocaionId(String storageLocaionId) {
		this.storageLocaionId = storageLocaionId;
	}
	/**
	 * @return the verificationDate
	 */
	public String getVerificationDate() {
		return verificationDate;
	}
	/**
	 * @param verificationDate the verificationDate to set
	 */
	public void setVerificationDate(String verificationDate) {
		this.verificationDate = verificationDate;
	}
	/**
	 * @return the orgDetails
	 */
	public Organization getOrgDetails() {
		return orgDetails;
	}
	/**
	 * @param orgDetails the orgDetails to set
	 */
	public void setOrgDetails(Organization orgDetails) {
		this.orgDetails = orgDetails;
	}
	/**
	 * @return the plantDetails
	 */
	public Plant getPlantDetails() {
		return plantDetails;
	}
	/**
	 * @param plantDetails the plantDetails to set
	 */
	public void setPlantDetails(Plant plantDetails) {
		this.plantDetails = plantDetails;
	}
	/**
	 * @return the storageLocDetails
	 */
	public StorageLocation getStorageLocDetails() {
		return storageLocDetails;
	}
	/**
	 * @param storageLocDetails the storageLocDetails to set
	 */
	public void setStorageLocDetails(StorageLocation storageLocDetails) {
		this.storageLocDetails = storageLocDetails;
	}
	/**
	 * @return the verificationIdEdit
	 */
	public int getVerificationIdEdit() {
		return verificationIdEdit;
	}
	/**
	 * @param verificationIdEdit the verificationIdEdit to set
	 */
	public void setVerificationIdEdit(int verificationIdEdit) {
		this.verificationIdEdit = verificationIdEdit;
	}
	/**
	 * @return the verificationNoEdit
	 */
	public String getVerificationNoEdit() {
		return verificationNoEdit;
	}
	/**
	 * @param verificationNoEdit the verificationNoEdit to set
	 */
	public void setVerificationNoEdit(String verificationNoEdit) {
		this.verificationNoEdit = verificationNoEdit;
	}
	/**
	 * @return the verificationTypeIdEdit
	 */
	public String getVerificationTypeIdEdit() {
		return verificationTypeIdEdit;
	}
	/**
	 * @param verificationTypeIdEdit the verificationTypeIdEdit to set
	 */
	public void setVerificationTypeIdEdit(String verificationTypeIdEdit) {
		this.verificationTypeIdEdit = verificationTypeIdEdit;
	}
	/**
	 * @return the orgIdEdit
	 */
	public String getOrgIdEdit() {
		return orgIdEdit;
	}
	/**
	 * @param orgIdEdit the orgIdEdit to set
	 */
	public void setOrgIdEdit(String orgIdEdit) {
		this.orgIdEdit = orgIdEdit;
	}
	/**
	 * @return the plantIdEdit
	 */
	public String getPlantIdEdit() {
		return plantIdEdit;
	}
	/**
	 * @param plantIdEdit the plantIdEdit to set
	 */
	public void setPlantIdEdit(String plantIdEdit) {
		this.plantIdEdit = plantIdEdit;
	}
	/**
	 * @return the storageLocaionIdEdit
	 */
	public String getStorageLocaionIdEdit() {
		return storageLocaionIdEdit;
	}
	/**
	 * @param storageLocaionIdEdit the storageLocaionIdEdit to set
	 */
	public void setStorageLocaionIdEdit(String storageLocaionIdEdit) {
		this.storageLocaionIdEdit = storageLocaionIdEdit;
	}
	/**
	 * @return the verificationDateEdit
	 */
	public String getVerificationDateEdit() {
		return verificationDateEdit;
	}
	/**
	 * @param verificationDateEdit the verificationDateEdit to set
	 */
	public void setVerificationDateEdit(String verificationDateEdit) {
		this.verificationDateEdit = verificationDateEdit;
	}
	/**
	 * @return the orgDetailsEdit
	 */
	public Organization getOrgDetailsEdit() {
		return orgDetailsEdit;
	}
	/**
	 * @param orgDetailsEdit the orgDetailsEdit to set
	 */
	public void setOrgDetailsEdit(Organization orgDetailsEdit) {
		this.orgDetailsEdit = orgDetailsEdit;
	}
	/**
	 * @return the plantDetailsEdit
	 */
	public Plant getPlantDetailsEdit() {
		return plantDetailsEdit;
	}
	/**
	 * @param plantDetailsEdit the plantDetailsEdit to set
	 */
	public void setPlantDetailsEdit(Plant plantDetailsEdit) {
		this.plantDetailsEdit = plantDetailsEdit;
	}
	/**
	 * @return the storageLocDetailsEdit
	 */
	public StorageLocation getStorageLocDetailsEdit() {
		return storageLocDetailsEdit;
	}
	/**
	 * @param storageLocDetailsEdit the storageLocDetailsEdit to set
	 */
	public void setStorageLocDetailsEdit(StorageLocation storageLocDetailsEdit) {
		this.storageLocDetailsEdit = storageLocDetailsEdit;
	}
	
	
	
	
	/*
	 * Physical Verification Line
	 */
	
	
	
	/**
	 * @return the physicalVerificationAddDuplicate
	 */
	public int getPhysicalVerificationAddDuplicate() {
		return physicalVerificationAddDuplicate;
	}
	/**
	 * @param physicalVerificationAddDuplicate the physicalVerificationAddDuplicate to set
	 */
	public void setPhysicalVerificationAddDuplicate(
			int physicalVerificationAddDuplicate) {
		this.physicalVerificationAddDuplicate = physicalVerificationAddDuplicate;
	}
	/**
	 * @return the verificationLineIdChild
	 */
	public int[] getVerificationLineIdChild() {
		return verificationLineIdChild;
	}
	/**
	 * @param verificationLineIdChild the verificationLineIdChild to set
	 */
	public void setVerificationLineIdChild(int[] verificationLineIdChild) {
		this.verificationLineIdChild = verificationLineIdChild;
	}
	/**
	 * @return the materialIdChild
	 */
	public String[] getMaterialIdChild() {
		return materialIdChild;
	}
	/**
	 * @param materialIdChild the materialIdChild to set
	 */
	public void setMaterialIdChild(String[] materialIdChild) {
		this.materialIdChild = materialIdChild;
	}
	/**
	 * @return the batchNoChild
	 */
	public String[] getBatchNoChild() {
		return batchNoChild;
	}
	/**
	 * @param batchNoChild the batchNoChild to set
	 */
	public void setBatchNoChild(String[] batchNoChild) {
		this.batchNoChild = batchNoChild;
	}
	/**
	 * @return the bookQtyChild
	 */
	public String[] getBookQtyChild() {
		return bookQtyChild;
	}
	/**
	 * @param bookQtyChild the bookQtyChild to set
	 */
	public void setBookQtyChild(String[] bookQtyChild) {
		this.bookQtyChild = bookQtyChild;
	}
	/**
	 * @return the physicalQtyChild
	 */
	public String[] getPhysicalQtyChild() {
		return physicalQtyChild;
	}
	/**
	 * @param physicalQtyChild the physicalQtyChild to set
	 */
	public void setPhysicalQtyChild(String[] physicalQtyChild) {
		this.physicalQtyChild = physicalQtyChild;
	}
	/**
	 * @return the uomIdChild
	 */
	public String[] getUomIdChild() {
		return uomIdChild;
	}
	/**
	 * @param uomIdChild the uomIdChild to set
	 */
	public void setUomIdChild(String[] uomIdChild) {
		this.uomIdChild = uomIdChild;
	}
	/**
	 * @return the verificationLineId
	 */
	public int getVerificationLineId() {
		return verificationLineId;
	}
	/**
	 * @param verificationLineId the verificationLineId to set
	 */
	public void setVerificationLineId(int verificationLineId) {
		this.verificationLineId = verificationLineId;
	}
	/**
	 * @return the materialId
	 */
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}
	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	/**
	 * @return the bookQty
	 */
	public String getBookQty() {
		return bookQty;
	}
	/**
	 * @param bookQty the bookQty to set
	 */
	public void setBookQty(String bookQty) {
		this.bookQty = bookQty;
	}
	/**
	 * @return the physicalQty
	 */
	public String getPhysicalQty() {
		return physicalQty;
	}
	/**
	 * @param physicalQty the physicalQty to set
	 */
	public void setPhysicalQty(String physicalQty) {
		this.physicalQty = physicalQty;
	}
	/**
	 * @return the uomId
	 */
	public String getUomId() {
		return uomId;
	}
	/**
	 * @param uomId the uomId to set
	 */
	public void setUomId(String uomId) {
		this.uomId = uomId;
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
	 * @return the uomName
	 */
	public String getUomName() {
		return uomName;
	}
	/**
	 * @param uomName the uomName to set
	 */
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	/**
	 * @return the physicalVerificationFk
	 */
	public Set<physicalVerificationLine> getPhysicalVerificationFk() {
		return physicalVerificationFk;
	}
	/**
	 * @param physicalVerificationFk the physicalVerificationFk to set
	 */
	public void setPhysicalVerificationFk(
			Set<physicalVerificationLine> physicalVerificationFk) {
		this.physicalVerificationFk = physicalVerificationFk;
	}
	/**
	 * @return the pvId
	 */
	public int getPvId() {
		return pvId;
	}
	/**
	 * @param pvId the pvId to set
	 */
	public void setPvId(int pvId) {
		this.pvId = pvId;
	}
	
	
	
	
	
	/*
	 * Basic And Advanced Search Getter and Setter Methods
	 */
	/**
	 * @return the xmlLabel
	 */
	public String getXmlLabel() {
		return xmlLabel;
	}
	/**
	 * @param xmlLabel the xmlLabel to set
	 */
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
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
	 * @param basicSearchId the basicSearchId to set
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
	 * @param firstLabel the firstLabel to set
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
	 * @param secondLabel the secondLabel to set
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
	 * @param operations1 the operations1 to set
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
	 * @param advanceSearchText the advanceSearchText to set
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
	 * @param advanceSearchHidden the advanceSearchHidden to set
	 */
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	/**
	 * @return the verfTypeDetails
	 */
	public VerificationtypeBean getVerfTypeDetails() {
		return verfTypeDetails;
	}
	/**
	 * @param verfTypeDetails the verfTypeDetails to set
	 */
	public void setVerfTypeDetails(VerificationtypeBean verfTypeDetails) {
		this.verfTypeDetails = verfTypeDetails;
	}
	/**
	 * @return the pvEditId
	 */
	public int getPvEditId() {
		return pvEditId;
	}
	/**
	 * @param pvEditId the pvEditId to set
	 */
	public void setPvEditId(int pvEditId) {
		this.pvEditId = pvEditId;
	}
	/**
	 * @return the verificationLineIdChildEdit
	 */
	public int[] getVerificationLineIdChildEdit() {
		return verificationLineIdChildEdit;
	}
	/**
	 * @param verificationLineIdChildEdit the verificationLineIdChildEdit to set
	 */
	public void setVerificationLineIdChildEdit(int[] verificationLineIdChildEdit) {
		this.verificationLineIdChildEdit = verificationLineIdChildEdit;
	}
	/**
	 * @return the materialIdChildEdit
	 */
	public String[] getMaterialIdChildEdit() {
		return materialIdChildEdit;
	}
	/**
	 * @param materialIdChildEdit the materialIdChildEdit to set
	 */
	public void setMaterialIdChildEdit(String[] materialIdChildEdit) {
		this.materialIdChildEdit = materialIdChildEdit;
	}
	/**
	 * @return the batchNoChildEdit
	 */
	public String[] getBatchNoChildEdit() {
		return batchNoChildEdit;
	}
	/**
	 * @param batchNoChildEdit the batchNoChildEdit to set
	 */
	public void setBatchNoChildEdit(String[] batchNoChildEdit) {
		this.batchNoChildEdit = batchNoChildEdit;
	}
	/**
	 * @return the bookQtyChildEdit
	 */
	public String[] getBookQtyChildEdit() {
		return bookQtyChildEdit;
	}
	/**
	 * @param bookQtyChildEdit the bookQtyChildEdit to set
	 */
	public void setBookQtyChildEdit(String[] bookQtyChildEdit) {
		this.bookQtyChildEdit = bookQtyChildEdit;
	}
	/**
	 * @return the physicalQtyChildEdit
	 */
	public String[] getPhysicalQtyChildEdit() {
		return physicalQtyChildEdit;
	}
	/**
	 * @param physicalQtyChildEdit the physicalQtyChildEdit to set
	 */
	public void setPhysicalQtyChildEdit(String[] physicalQtyChildEdit) {
		this.physicalQtyChildEdit = physicalQtyChildEdit;
	}
	/**
	 * @return the uomIdChildEdit
	 */
	public String[] getUomIdChildEdit() {
		return uomIdChildEdit;
	}
	/**
	 * @param uomIdChildEdit the uomIdChildEdit to set
	 */
	public void setUomIdChildEdit(String[] uomIdChildEdit) {
		this.uomIdChildEdit = uomIdChildEdit;
	}
	public int getPhysicalVerificationEditDuplicate() {
		return physicalVerificationEditDuplicate;
	}
	public void setPhysicalVerificationEditDuplicate(
			int physicalVerificationEditDuplicate) {
		this.physicalVerificationEditDuplicate = physicalVerificationEditDuplicate;
	}
	public List<physicalVerification> getPhysicalVerificationListType() {
		return physicalVerificationListType;
	}
	public void setPhysicalVerificationListType(
			List<physicalVerification> physicalVerificationListType) {
		this.physicalVerificationListType = physicalVerificationListType;
	}
	
 	
	
	
	
	
	
 	
 	
 	

}
