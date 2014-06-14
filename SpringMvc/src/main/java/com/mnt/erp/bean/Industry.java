package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author ybusireddy
 * @version 19-09-2013
 */

public class Industry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int industryTypeId;
	private String industryType;
	private int industryTypeIdEdit;
	private String industryTypeEdit;
	
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

	public int getIndustryTypeId() {
		return industryTypeId;
	}

	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public int getIndustryTypeIdEdit() {
		return industryTypeIdEdit;
	}

	public void setIndustryTypeIdEdit(int industryTypeIdEdit) {
		this.industryTypeIdEdit = industryTypeIdEdit;
	}

	public String getIndustryTypeEdit() {
		return industryTypeEdit;
	}

	public void setIndustryTypeEdit(String industryTypeEdit) {
		this.industryTypeEdit = industryTypeEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
