/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0 08-11-2013
 * @build 0.0
 *
 */
public class BomLine {
	
	

	/*======================Bean Properties=====================*/
	private int bomLineId; 
	private int bomId;
	private String material_Id;
	private int quantity;
	private String uom_Id;
	private int explosionLevel;
	private int predessor;
	private String parentMaterial;
	 
	
	/*=======================Edit Properties====================*/
	private int bomLineIdEditt; 
	private int bomIdEditt;
	private String material_IdEditt;
	private int quantityEditt;
	private String uom_IdEditt;
	private int explosionLevelEditt;
	private int predessorEditt;
	private String parentMaterialEditt;
	
	/*=================OtherObjects*========================/
	 * 
	 */
	
	private Material materialDetails;
	private Material parentMaterialDetails;
	private Uom uomDetails;
	private String materialName;
	private String uomName;
	private String parentMaterialName;
	
	public Material getMaterialDetails() {
		return materialDetails;
	}
	public void setMaterialDetails(Material materialDetails) {
		this.materialDetails = materialDetails;
	}
	public Uom getUomDetails() {
		return uomDetails;
	}
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	

	public String getParentMaterialName() {
		return parentMaterialName;
	}
	public void setParentMaterialName(String parentMaterialName) {
		this.parentMaterialName = parentMaterialName;
	}
	
	
	/*=======================Getters===========================*/
	

	public Material getParentMaterialDetails() {
		return parentMaterialDetails;
	}
	public void setParentMaterialDetails(Material parentMaterialDetails) {
		this.parentMaterialDetails = parentMaterialDetails;
	}
	public int getBomLineId() {
		return bomLineId;
	}
	public int getBomId() {
		return bomId;
	}
	public String getMaterial_Id() {
		return material_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getUom_Id() {
		return uom_Id;
	}
	public int getExplosionLevel() {
		return explosionLevel;
	}
	public int getPredessor() {
		return predessor;
	}
	public int getBomLineIdEditt() {
		return bomLineIdEditt;
	}
	public int getBomIdEditt() {
		return bomIdEditt;
	}
	public String getMaterial_IdEditt() {
		return material_IdEditt;
	}
	public int getQuantityEditt() {
		return quantityEditt;
	}
	public String getUom_IdEditt() {
		return uom_IdEditt;
	}
	public int getExplosionLevelEditt() {
		return explosionLevelEditt;
	}
	public int getPredessorEditt() {
		return predessorEditt;
	}

	public String getParentMaterial() {
		return parentMaterial;
	}
	public String getParentMaterialEditt() {
		return parentMaterialEditt;
	}
	/*=======================Setters===========================*/
	public void setBomLineId(int bomLineId) {
		this.bomLineId = bomLineId;
	}
	public void setBomId(int bomId) {
		this.bomId = bomId;
	}
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}
	public void setExplosionLevel(int explosionLevel) {
		this.explosionLevel = explosionLevel;
	}
	public void setPredessor(int predessor) {
		this.predessor = predessor;
	}
	public void setBomLineIdEditt(int bomLineIdEditt) {
		this.bomLineIdEditt = bomLineIdEditt;
	}
	public void setBomIdEditt(int bomIdEditt) {
		this.bomIdEditt = bomIdEditt;
	}
	public void setMaterial_IdEditt(String material_IdEditt) {
		this.material_IdEditt = material_IdEditt;
	}
	public void setQuantityEditt(int quantityEditt) {
		this.quantityEditt = quantityEditt;
	}
	public void setUom_IdEditt(String uom_IdEditt) {
		this.uom_IdEditt = uom_IdEditt;
	}
	public void setExplosionLevelEditt(int explosionLevelEditt) {
		this.explosionLevelEditt = explosionLevelEditt;
	}
	public void setPredessorEditt(int predessorEditt) {
		this.predessorEditt = predessorEditt;
	}
	public void setParentMaterial(String parentMaterial) {
		this.parentMaterial = parentMaterial;
	}
	public void setParentMaterialEditt(String parentMaterialEditt) {
		this.parentMaterialEditt = parentMaterialEditt;
	}
	
	

}
