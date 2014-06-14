package com.mnt.erp.bean;

import java.io.Serializable;

public class ValuationCategory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int valuationCategoryId;
	private String valuationCategory;
	private int valuationCategoryIdEdit;
	private String valuationCategoryEdit;
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

	public int getValuationCategoryId() {
		return valuationCategoryId;
	}

	public void setValuationCategoryId(int valuationCategoryId) {
		this.valuationCategoryId = valuationCategoryId;
	}

	public String getValuationCategory() {
		return valuationCategory;
	}

	public void setValuationCategory(String valuationCategory) {
		this.valuationCategory = valuationCategory;
	}

	public int getValuationCategoryIdEdit() {
		return valuationCategoryIdEdit;
	}

	public void setValuationCategoryIdEdit(int valuationCategoryIdEdit) {
		this.valuationCategoryIdEdit = valuationCategoryIdEdit;
	}

	public String getValuationCategoryEdit() {
		return valuationCategoryEdit;
	}

	public void setValuationCategoryEdit(String valuationCategoryEdit) {
		this.valuationCategoryEdit = valuationCategoryEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
