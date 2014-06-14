/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author pvenkateswarlu
 * @version 1.0 19-09-2013
 */
public class OrganizationType {
	private int orgTypeId;
	private String orgType;
	private int orgTypeIdEdit;
	private String orgTypeEdit;
	private int aid;

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

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	/**
	 * @return the orgTypeIdEdit
	 */
	public int getOrgTypeIdEdit() {
		return orgTypeIdEdit;
	}

	/**
	 * @param orgTypeIdEdit
	 *            the orgTypeIdEdit to set
	 */
	public void setOrgTypeIdEdit(int orgTypeIdEdit) {
		this.orgTypeIdEdit = orgTypeIdEdit;
	}

	/**
	 * @return the orgTypeEdit
	 */
	public String getOrgTypeEdit() {
		return orgTypeEdit;
	}

	/**
	 * @param orgTypeEdit
	 *            the orgTypeEdit to set
	 */
	public void setOrgTypeEdit(String orgTypeEdit) {
		this.orgTypeEdit = orgTypeEdit;
	}

	/**
	 * @return the orgTypeId
	 */
	public int getOrgTypeId() {
		return orgTypeId;
	}

	/**
	 * @param orgTypeId
	 *            the orgTypeId to set
	 */
	public void setOrgTypeId(int orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	/**
	 * @return the orgType
	 */
	public String getOrgType() {
		return orgType;
	}

	/**
	 * @param orgType
	 *            the orgType to set
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}
