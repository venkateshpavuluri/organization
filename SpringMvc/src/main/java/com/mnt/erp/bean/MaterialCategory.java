	/**
	 * @Copyright MNTSOFT 
	 */
	package com.mnt.erp.bean;
	/**
	 */
	
	/**
	 * @author Gkiran
	 * @version 1.0v
	 * @Date -09-2013
	 */
	import java.util.List;

	public class MaterialCategory {
	private int materialCategoryId;
	private String materialCategory;
	private String materialCategoryCode;
	private int materialCategoryIdEdit;
	private int duplicateMessage;
	private int duplicateMessageEdit;
	private String materialCategoryEditUpdate;
	private String materialCategoryEdit;
	private String materialCategoryCodeEdit;
	private List<Material> materials;
	
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
	 * @return the materialCategoryId
	 */
	public int getMaterialCategoryId() {
		return materialCategoryId;
	}
	/**
	 * @param materialCategoryId the materialCategoryId to set
	 */
	public void setMaterialCategoryId(int materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}
	/**
	 * @return the materialCategory
	 */
	public String getMaterialCategory() {
		return materialCategory;
	}
	/**
	 * @param materialCategory the materialCategory to set
	 */
	public void setMaterialCategory(String materialCategory) {
		this.materialCategory = materialCategory;
	}
	/**
	 * @return the materialCategoryCode
	 */
	public String getMaterialCategoryCode() {
		return materialCategoryCode;
	}
	/**
	 * @param materialCategoryCode the materialCategoryCode to set
	 */
	public void setMaterialCategoryCode(String materialCategoryCode) {
		this.materialCategoryCode = materialCategoryCode;
	}
	/**
	 * @return the materialCategoryIdEdit
	 */
	public int getMaterialCategoryIdEdit() {
		return materialCategoryIdEdit;
	}
	/**
	 * @param materialCategoryIdEdit the materialCategoryIdEdit to set
	 */
	public void setMaterialCategoryIdEdit(int materialCategoryIdEdit) {
		this.materialCategoryIdEdit = materialCategoryIdEdit;
	}
	/**
	 * @return the duplicateMessage
	 */
	public int getDuplicateMessage() {
		return duplicateMessage;
	}
	/**
	 * @param duplicateMessage the duplicateMessage to set
	 */
	public void setDuplicateMessage(int duplicateMessage) {
		this.duplicateMessage = duplicateMessage;
	}
	/**
	 * @return the duplicateMessageEdit
	 */
	public int getDuplicateMessageEdit() {
		return duplicateMessageEdit;
	}
	/**
	 * @param duplicateMessageEdit the duplicateMessageEdit to set
	 */
	public void setDuplicateMessageEdit(int duplicateMessageEdit) {
		this.duplicateMessageEdit = duplicateMessageEdit;
	}
	/**
	 * @return the materialCategoryEditUpdate
	 */
	public String getMaterialCategoryEditUpdate() {
		return materialCategoryEditUpdate;
	}
	/**
	 * @param materialCategoryEditUpdate the materialCategoryEditUpdate to set
	 */
	public void setMaterialCategoryEditUpdate(String materialCategoryEditUpdate) {
		this.materialCategoryEditUpdate = materialCategoryEditUpdate;
	}
	/**
	 * @return the materialCategoryEdit
	 */
	public String getMaterialCategoryEdit() {
		return materialCategoryEdit;
	}
	/**
	 * @param materialCategoryEdit the materialCategoryEdit to set
	 */
	public void setMaterialCategoryEdit(String materialCategoryEdit) {
		this.materialCategoryEdit = materialCategoryEdit;
	}
	/**
	 * @return the materialCategoryCodeEdit
	 */
	public String getMaterialCategoryCodeEdit() {
		return materialCategoryCodeEdit;
	}
	/**
	 * @param materialCategoryCodeEdit the materialCategoryCodeEdit to set
	 */
	public void setMaterialCategoryCodeEdit(String materialCategoryCodeEdit) {
		this.materialCategoryCodeEdit = materialCategoryCodeEdit;
	}
	/**
	 * @return the materials
	 */
	public List<Material> getMaterials() {
		return materials;
	}
	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
	
	

}
