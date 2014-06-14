/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class BreakDownMaintenanceSpare {
	private int brDnMaintenaceSpareId; 
	private String brDnMaintenaceLogId;
	private String materialId;
	private String quantity;
	private String uomId;
	
	/*Relation properties*/
	private Material materialDetails;
	private Uom uomDetails;
	


	/**
	 * @return the brDnMaintenaceSpareId
	 */
	public int getBrDnMaintenaceSpareId() {
		return brDnMaintenaceSpareId;
	}
	/**
	 * @param brDnMaintenaceSpareId the brDnMaintenaceSpareId to set
	 */
	public void setBrDnMaintenaceSpareId(int brDnMaintenaceSpareId) {
		this.brDnMaintenaceSpareId = brDnMaintenaceSpareId;
	}
	/**
	 * @return the brDnMaintenaceLogId
	 */
	public String getBrDnMaintenaceLogId() {
		return brDnMaintenaceLogId;
	}
	/**
	 * @param brDnMaintenaceLogId the brDnMaintenaceLogId to set
	 */
	public void setBrDnMaintenaceLogId(String brDnMaintenaceLogId) {
		this.brDnMaintenaceLogId = brDnMaintenaceLogId;
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
	/**
	 * @return the materialDetails
	 */
	public Material getMaterialDetails() {
		return materialDetails;
	}
	/**
	 * @param materialDetails the materialDetails to set
	 */
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
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

	
	

	
	
	

}
