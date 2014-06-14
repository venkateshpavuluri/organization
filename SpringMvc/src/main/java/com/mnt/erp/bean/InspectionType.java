package com.mnt.erp.bean;

import java.io.Serializable;

public class InspectionType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int inspectionTypeId;
	private String inspectionType;
	private int inspectionTypeIdEdit;
	private String inspectionTypeEdit;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	
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

	public int getInspectionTypeId() {
		return inspectionTypeId;
	}

	public void setInspectionTypeId(int inspectionTypeId) {
		this.inspectionTypeId = inspectionTypeId;
	}

	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	public int getInspectionTypeIdEdit() {
		return inspectionTypeIdEdit;
	}

	public void setInspectionTypeIdEdit(int inspectionTypeIdEdit) {
		this.inspectionTypeIdEdit = inspectionTypeIdEdit;
	}

	public String getInspectionTypeEdit() {
		return inspectionTypeEdit;
	}

	public void setInspectionTypeEdit(String inspectionTypeEdit) {
		this.inspectionTypeEdit = inspectionTypeEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
}
