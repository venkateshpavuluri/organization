/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

/**
 * @author Gkiran
 * @version 1.0v
 * @Date 10-09-2013
 */

public class BomCategory {

	private int bomCategoryId;
	private int duplicateMessageBomCategory;
	private int duplicateMessageBomCategoryUpdate;
	private int bomCategoryIdEdit;
	private String bomCategoryEdit;
	private String bomCategory;
	private String bomCategoryEditUpdate;

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

	/**
	 * @return the duplicateMessageBomCategory
	 */
	public int getDuplicateMessageBomCategory() {
		return duplicateMessageBomCategory;
	}

	/**
	 * @param duplicateMessageBomCategory
	 *            the duplicateMessageBomCategory to set
	 */
	public void setDuplicateMessageBomCategory(int duplicateMessageBomCategory) {
		this.duplicateMessageBomCategory = duplicateMessageBomCategory;
	}

	public int getBomCategoryIdEdit() {
		return bomCategoryIdEdit;
	}

	public void setBomCategoryIdEdit(int bomCategoryIdEdit) {
		this.bomCategoryIdEdit = bomCategoryIdEdit;
	}

	public String getBomCategoryEdit() {
		return bomCategoryEdit;
	}

	public void setBomCategoryEdit(String bomCategoryEdit) {
		this.bomCategoryEdit = bomCategoryEdit;
	}

	public int getBomCategoryId() {
		return bomCategoryId;
	}

	public void setBomCategoryId(int bomCategoryId) {
		this.bomCategoryId = bomCategoryId;
	}

	public String getBomCategory() {
		return bomCategory;
	}

	public void setBomCategory(String bomCategory) {
		this.bomCategory = bomCategory;
	}

	/**
	 * @return the bomCategoryEditUpdate
	 */
	public String getBomCategoryEditUpdate() {
		return bomCategoryEditUpdate;
	}

	/**
	 * @param bomCategoryEditUpdate
	 *            the bomCategoryEditUpdate to set
	 */
	public void setBomCategoryEditUpdate(String bomCategoryEditUpdate) {
		this.bomCategoryEditUpdate = bomCategoryEditUpdate;
	}

	/**
	 * @return the duplicateMessageBomCategoryUpdate
	 */
	public int getDuplicateMessageBomCategoryUpdate() {
		return duplicateMessageBomCategoryUpdate;
	}

	/**
	 * @param duplicateMessageBomCategoryUpdate
	 *            the duplicateMessageBomCategoryUpdate to set
	 */
	public void setDuplicateMessageBomCategoryUpdate(
			int duplicateMessageBomCategoryUpdate) {
		this.duplicateMessageBomCategoryUpdate = duplicateMessageBomCategoryUpdate;
	}

}
