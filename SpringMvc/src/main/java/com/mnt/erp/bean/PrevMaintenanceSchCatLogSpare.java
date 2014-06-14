/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class PrevMaintenanceSchCatLogSpare {
	private int prevMtSchCatLogSpareId;
	private int PrevMtSchCatLogId;
	private String materialId;
	private String quantity;
	private String uomId;
	private String prevMtSchCatLogSpareIdEdit;

	private String brDnMaintenaceLogIdEdit;
	private String materialIdEdit;
	private String quantityEdit;
	private String uomIdEdit;
	private String materialName;
	private String uomName;
	
	/*RelationShip Properties*/
	private Material materials;
	private Uom uomDetails;
	
	
	/**
	 * @return the brDnMaintenaceLogIdEdit
	 */
	public String getBrDnMaintenaceLogIdEdit() {
		return brDnMaintenaceLogIdEdit;
	}
	/**
	 * @param brDnMaintenaceLogIdEdit the brDnMaintenaceLogIdEdit to set
	 */
	public void setBrDnMaintenaceLogIdEdit(String brDnMaintenaceLogIdEdit) {
		this.brDnMaintenaceLogIdEdit = brDnMaintenaceLogIdEdit;
	}
	/**
	 * @return the materialIdEdit
	 */
	public String getMaterialIdEdit() {
		return materialIdEdit;
	}
	/**
	 * @param materialIdEdit the materialIdEdit to set
	 */
	public void setMaterialIdEdit(String materialIdEdit) {
		this.materialIdEdit = materialIdEdit;
	}
	/**
	 * @return the quantityEdit
	 */
	public String getQuantityEdit() {
		return quantityEdit;
	}
	/**
	 * @param quantityEdit the quantityEdit to set
	 */
	public void setQuantityEdit(String quantityEdit) {
		this.quantityEdit = quantityEdit;
	}
	/**
	 * @return the uomIdEdit
	 */
	public String getUomIdEdit() {
		return uomIdEdit;
	}
	/**
	 * @param uomIdEdit the uomIdEdit to set
	 */
	public void setUomIdEdit(String uomIdEdit) {
		this.uomIdEdit = uomIdEdit;
	}
	/**
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * @return the uomName
	 */
	public String getUomName() {
		return uomName;
	}
	/**
	 * @param uomName the uomName to set
	 */
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	/**
	 * @return the prevMtSchCatLogSpareIdEdit
	 */
	public String getPrevMtSchCatLogSpareIdEdit() {
		return prevMtSchCatLogSpareIdEdit;
	}
	/**
	 * @param prevMtSchCatLogSpareIdEdit the prevMtSchCatLogSpareIdEdit to set
	 */
	public void setPrevMtSchCatLogSpareIdEdit(String prevMtSchCatLogSpareIdEdit) {
		this.prevMtSchCatLogSpareIdEdit = prevMtSchCatLogSpareIdEdit;
	}
	/**
	 * @return the materials
	 */
	public Material getMaterials() {
		return materials;
	}
	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(Material materials) {
		this.materials = materials;
	}
	/**
	 * @return the uomDetails
	 */
	public Uom getUomDetails() {
		return uomDetails;
	}
	/**
	 * @param uomDetails the uomDetails to set
	 */
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}
	/**
	 * @return the prevMtSchCatLogSpareId
	 */
	public int getPrevMtSchCatLogSpareId() {
		return prevMtSchCatLogSpareId;
	}
	/**
	 * @param prevMtSchCatLogSpareId the prevMtSchCatLogSpareId to set
	 */
	public void setPrevMtSchCatLogSpareId(int prevMtSchCatLogSpareId) {
		this.prevMtSchCatLogSpareId = prevMtSchCatLogSpareId;
	}
	/**
	 * @return the prevMtSchCatLogId
	 */
	public int getPrevMtSchCatLogId() {
		return PrevMtSchCatLogId;
	}
	/**
	 * @param prevMtSchCatLogId the prevMtSchCatLogId to set
	 */
	public void setPrevMtSchCatLogId(int prevMtSchCatLogId) {
		PrevMtSchCatLogId = prevMtSchCatLogId;
	}
	/**
	 * @return the materialId
	 */
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the uomId
	 */
	public String getUomId() {
		return uomId;
	}
	/**
	 * @param uomId the uomId to set
	 */
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	
	

}
