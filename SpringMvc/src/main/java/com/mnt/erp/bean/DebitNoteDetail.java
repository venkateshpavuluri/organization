/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 02-01-2014
 */
public class DebitNoteDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int debitNoteDetailId;
	private int debitNoteId;
	private String materialId;
	private String quantity;
	private String uomId;
	private String perUnit;
	private String netPrice;
	private String debitAmount;
	private String materialName;
	private String uomName;
	
	private Material material;
	private Uom uom;
	
	//Edit Variables
	private int edebitNoteDetailId;
	private String ematerialId;
	private String equantity;
	private String euomId;
	private String eperUnit;
	private String enetPrice;
	private String edebitAmount;
	
	// Setter And Getter Methods
	
	public int getDebitNoteDetailId() {
		return debitNoteDetailId;
	}
	public int getDebitNoteId() {
		return debitNoteId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getUomId() {
		return uomId;
	}
	public Material getMaterial() {
		return material;
	}
	public Uom getUom() {
		return uom;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public String getPerUnit() {
		return perUnit;
	}
	public String getNetPrice() {
		return netPrice;
	}
	public String getDebitAmount() {
		return debitAmount;
	}
	public void setDebitNoteDetailId(int debitNoteDetailId) {
		this.debitNoteDetailId = debitNoteDetailId;
	}
	public void setDebitNoteId(int debitNoteId) {
		this.debitNoteId = debitNoteId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	public void setPerUnit(String perUnit) {
		this.perUnit = perUnit;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getUomName() {
		return uomName;
	}
	public int getEdebitNoteDetailId() {
		return edebitNoteDetailId;
	}
	public String getEmaterialId() {
		return ematerialId;
	}
	public String getEquantity() {
		return equantity;
	}
	public String getEuomId() {
		return euomId;
	}
	public String getEperUnit() {
		return eperUnit;
	}
	public String getEnetPrice() {
		return enetPrice;
	}
	public String getEdebitAmount() {
		return edebitAmount;
	}
	public void setEdebitNoteDetailId(int edebitNoteDetailId) {
		this.edebitNoteDetailId = edebitNoteDetailId;
	}
	public void setEmaterialId(String ematerialId) {
		this.ematerialId = ematerialId;
	}
	public void setEquantity(String equantity) {
		this.equantity = equantity;
	}
	public void setEuomId(String euomId) {
		this.euomId = euomId;
	}
	public void setEperUnit(String eperUnit) {
		this.eperUnit = eperUnit;
	}
	public void setEnetPrice(String enetPrice) {
		this.enetPrice = enetPrice;
	}
	public void setEdebitAmount(String edebitAmount) {
		this.edebitAmount = edebitAmount;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	
	
	

}
