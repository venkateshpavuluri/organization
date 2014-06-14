/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

/**
 * This is AgreementType pojo.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class AgreementType {

	private int agreementType_Id;
	private String agreementType;
	private int aid;
	private int eid;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	/* Edit Properties */

	private int editAgreementType_Id;
	private String editAgreementType;

	/* getter methods of AgreementType */

	public int getEid() {
		return eid;
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

	public int getAid() {
		return aid;
	}

	public String getAgreementType() {
		return agreementType;
	}

	public int getAgreementType_Id() {
		return agreementType_Id;
	}

	public int getEditAgreementType_Id() {
		return editAgreementType_Id;
	}

	public String getEditAgreementType() {
		return editAgreementType;
	}

	/* setter methods of AgreementType */

	public void setEid(int eid) {
		this.eid = eid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setEditAgreementType_Id(int editAgreementType_Id) {
		this.editAgreementType_Id = editAgreementType_Id;
	}

	public void setEditAgreementType(String editAgreementType) {
		this.editAgreementType = editAgreementType;
	}

	public void setAgreementType_Id(int agreementType_Id) {
		this.agreementType_Id = agreementType_Id;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

}
