/**
 *@Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 05-02-2014
 */
public class InspOperationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int inspOperationId;
	private String inspTypeId;
	private String operationNo;
	private String materialId;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private InspectionType inspType;
	private Material material;
	private List<InspOperationStep> inspOprStep;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	//Child Variables
	private int[] inspOperStepId;
	private String[] inspOperStepNo;
	private String[] noOfSamples;

	// Setter And Getter Methods
	

	public List<InspOperationStep> getInspOprStep() {
		return inspOprStep;
	}

	public int[] getInspOperStepId() {
		return inspOperStepId;
	}

	public String[] getInspOperStepNo() {
		return inspOperStepNo;
	}

	public String[] getNoOfSamples() {
		return noOfSamples;
	}

	public void setInspOperStepId(int[] inspOperStepId) {
		this.inspOperStepId = inspOperStepId;
	}

	public void setInspOperStepNo(String[] inspOperStepNo) {
		this.inspOperStepNo = inspOperStepNo;
	}

	public void setNoOfSamples(String[] noOfSamples) {
		this.noOfSamples = noOfSamples;
	}

	public void setInspOprStep(List<InspOperationStep> inspOprStep) {
		this.inspOprStep = inspOprStep;
	}

	public InspectionType getInspType() {
		return inspType;
	}

	public Material getMaterial() {
		return material;
	}

	public void setInspType(InspectionType inspType) {
		this.inspType = inspType;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getInspOperationId() {
		return inspOperationId;
	}

	public String getInspTypeId() {
		return inspTypeId;
	}

	public String getOperationNo() {
		return operationNo;
	}

	public String getMaterialId() {
		return materialId;
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

	public void setInspOperationId(int inspOperationId) {
		this.inspOperationId = inspOperationId;
	}

	public void setInspTypeId(String inspTypeId) {
		this.inspTypeId = inspTypeId;
	}

	public void setOperationNo(String operationNo) {
		this.operationNo = operationNo;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	public void setOperations(String operations) {
		this.operations = operations;
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

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
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

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

}
