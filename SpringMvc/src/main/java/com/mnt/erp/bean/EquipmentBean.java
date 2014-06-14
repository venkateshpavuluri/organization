/**
 * 
 */
package com.mnt.erp.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author madhav
 *
 */
public class EquipmentBean {
	
	private int equipmentId;
	private String equipmentName;
	private String equipmentCategoryId;
	private String make;
	private String model;
	private String powerConsumptionInHours;
	private String productionCapacity;
	private String validFrom;
	private String validTo;
	private String workInstruction;
	private String equipmentCategory;
	
	
	//for saving document details
	private String[] docName;
	private CommonsMultipartFile[] file;
	
	

	

	//Instance variable for mapping
	private EquipmentCategory equipmentCategoryChild;

	// tabbing variable
	private int eId;

	// variables for searching
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	//Methods for Editing
	private int equipmentIdEdit;
	private String equipmentNameEdit;
	private String equipmentCategoryIdEdit;
	private String makeEdit;
	private String modelEdit;
	private String powerConsumptionInHoursEdit;
	private String productionCapacityEdit;
	private String validFromEdit;
	private String validToEdit;
	private String workInstructionEdit;
	private String equipmentCategoryEdit;
	
	
	private int eIdEdit;
	
	
	
	
	
	/**
	 * @return the eIdEdit
	 */
	public int geteIdEdit() {
		return eIdEdit;
	}

	/**
	 * @param eIdEdit the eIdEdit to set
	 */
	public void seteIdEdit(int eIdEdit) {
		this.eIdEdit = eIdEdit;
	}

	/**
	 * @return the equipmentCategoryEdit
	 */
	public String getEquipmentCategoryEdit() {
		return equipmentCategoryEdit;
	}

	/**
	 * @param equipmentCategoryEdit the equipmentCategoryEdit to set
	 */
	public void setEquipmentCategoryEdit(String equipmentCategoryEdit) {
		this.equipmentCategoryEdit = equipmentCategoryEdit;
	}

	/**
	 * @return the equipmentCategory
	 */
	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	/**
	 * @param equipmentCategory the equipmentCategory to set
	 */
	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}
	
	/**
	 * @return the equipmentIdEdit
	 */
	public int getEquipmentIdEdit() {
		return equipmentIdEdit;
	}

	/**
	 * @param equipmentIdEdit the equipmentIdEdit to set
	 */
	public void setEquipmentIdEdit(int equipmentIdEdit) {
		this.equipmentIdEdit = equipmentIdEdit;
	}

	/**
	 * @return the equipmentNameEdit
	 */
	public String getEquipmentNameEdit() {
		return equipmentNameEdit;
	}

	/**
	 * @param equipmentNameEdit the equipmentNameEdit to set
	 */
	public void setEquipmentNameEdit(String equipmentNameEdit) {
		this.equipmentNameEdit = equipmentNameEdit;
	}

	/**
	 * @return the equipmentCategoryIdEdit
	 */
	public String getEquipmentCategoryIdEdit() {
		return equipmentCategoryIdEdit;
	}

	/**
	 * @param equipmentCategoryIdEdit the equipmentCategoryIdEdit to set
	 */
	public void setEquipmentCategoryIdEdit(String equipmentCategoryIdEdit) {
		this.equipmentCategoryIdEdit = equipmentCategoryIdEdit;
	}

	/**
	 * @return the makeEdit
	 */
	public String getMakeEdit() {
		return makeEdit;
	}

	/**
	 * @param makeEdit the makeEdit to set
	 */
	public void setMakeEdit(String makeEdit) {
		this.makeEdit = makeEdit;
	}

	/**
	 * @return the modelEdit
	 */
	public String getModelEdit() {
		return modelEdit;
	}

	

	/**
	 * @param modelEdit the modelEdit to set
	 */
	public void setModelEdit(String modelEdit) {
		this.modelEdit = modelEdit;
	}

	/**
	 * @return the powerConsumptionInHoursEdit
	 */
	public String getPowerConsumptionInHoursEdit() {
		return powerConsumptionInHoursEdit;
	}

	/**
	 * @param powerConsumptionInHoursEdit the powerConsumptionInHoursEdit to set
	 */
	public void setPowerConsumptionInHoursEdit(String powerConsumptionInHoursEdit) {
		this.powerConsumptionInHoursEdit = powerConsumptionInHoursEdit;
	}

	/**
	 * @return the productionCapacityEdit
	 */
	public String getProductionCapacityEdit() {
		return productionCapacityEdit;
	}

	/**
	 * @return the docName
	 */
	public String[] getDocName() {
		return docName;
	}

	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String[] docName) {
		this.docName = docName;
	}

	/**
	 * @return the file
	 */
	public CommonsMultipartFile[] getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(CommonsMultipartFile[] file) {
		this.file = file;
	}

	/**
	 * @param productionCapacityEdit the productionCapacityEdit to set
	 */
	public void setProductionCapacityEdit(String productionCapacityEdit) {
		this.productionCapacityEdit = productionCapacityEdit;
	}

	/**
	 * @return the validFromEdit
	 */
	public String getValidFromEdit() {
		return validFromEdit;
	}

	/**
	 * @param validFromEdit the validFromEdit to set
	 */
	public void setValidFromEdit(String validFromEdit) {
		this.validFromEdit = validFromEdit;
	}

	/**
	 * @return the validToEdit
	 */
	public String getValidToEdit() {
		return validToEdit;
	}

	/**
	 * @param validToEdit the validToEdit to set
	 */
	public void setValidToEdit(String validToEdit) {
		this.validToEdit = validToEdit;
	}

	/**
	 * @return the workInstructionEdit
	 */
	public String getWorkInstructionEdit() {
		return workInstructionEdit;
	}

	/**
	 * @param workInstructionEdit the workInstructionEdit to set
	 */
	public void setWorkInstructionEdit(String workInstructionEdit) {
		this.workInstructionEdit = workInstructionEdit;
	}



	/**
	 * @return the equipmentId
	 */
	public int getEquipmentId() {
		return equipmentId;
	}

	/**
	 * @param equipmentId the equipmentId to set
	 */
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * @return the equipmentName
	 */
	public String getEquipmentName() {
		return equipmentName;
	}

	/**
	 * @param equipmentName the equipmentName to set
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	/**
	 * @return the equipmentCategoryId
	 */
	public String getEquipmentCategoryId() {
		return equipmentCategoryId;
	}

	/**
	 * @param equipmentCategoryId the equipmentCategoryId to set
	 */
	public void setEquipmentCategoryId(String equipmentCategoryId) {
		this.equipmentCategoryId = equipmentCategoryId;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the powerConsumptionInHours
	 */
	public String getPowerConsumptionInHours() {
		return powerConsumptionInHours;
	}

	/**
	 * @param powerConsumptionInHours the powerConsumptionInHours to set
	 */
	public void setPowerConsumptionInHours(String powerConsumptionInHours) {
		this.powerConsumptionInHours = powerConsumptionInHours;
	}

	/**
	 * @return the productionCapacity
	 */
	public String getProductionCapacity() {
		return productionCapacity;
	}

	/**
	 * @param productionCapacity the productionCapacity to set
	 */
	public void setProductionCapacity(String productionCapacity) {
		this.productionCapacity = productionCapacity;
	}

	/**
	 * @return the validFrom
	 */
	public String getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validTo
	 */
	public String getValidTo() {
		return validTo;
	}

	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

	/**
	 * @return the workInstruction
	 */
	public String getWorkInstruction() {
		return workInstruction;
	}

	/**
	 * @param workInstruction the workInstruction to set
	 */
	public void setWorkInstruction(String workInstruction) {
		this.workInstruction = workInstruction;
	}

	

	/**
	 * @return the eId
	 */
	public int geteId() {
		return eId;
	}

	/**
	 * @param eId the eId to set
	 */
	public void seteId(int eId) {
		this.eId = eId;
	}

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
	 * @return the equipmentCategoryChild
	 */
	public EquipmentCategory getEquipmentCategoryChild() {
		return equipmentCategoryChild;
	}

	/**
	 * @param equipmentCategoryChild the equipmentCategoryChild to set
	 */
	public void setEquipmentCategoryChild(EquipmentCategory equipmentCategoryChild) {
		this.equipmentCategoryChild = equipmentCategoryChild;
	}

	

}
