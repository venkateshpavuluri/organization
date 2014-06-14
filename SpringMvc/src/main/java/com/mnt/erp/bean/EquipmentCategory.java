package com.mnt.erp.bean;

import java.io.Serializable;

public class EquipmentCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int equipmentCategoryId;
	private String equipmentCategory;
	private int equipmentCategoryIdEdit;
	private String equipmentCategoryEdit;
	
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


	public int getEquipmentCategoryId() {
		return equipmentCategoryId;
	}

	public void setEquipmentCategoryId(int equipmentCategoryId) {
		this.equipmentCategoryId = equipmentCategoryId;
	}

	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public int getEquipmentCategoryIdEdit() {
		return equipmentCategoryIdEdit;
	}

	public void setEquipmentCategoryIdEdit(int equipmentCategoryIdEdit) {
		this.equipmentCategoryIdEdit = equipmentCategoryIdEdit;
	}

	public String getEquipmentCategoryEdit() {
		return equipmentCategoryEdit;
	}

	public void setEquipmentCategoryEdit(String equipmentCategoryEdit) {
		this.equipmentCategoryEdit = equipmentCategoryEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
