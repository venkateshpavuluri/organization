package com.mnt.erp.bean;

import java.util.List;

/**
 * @author kirangangone
 * 
 */
public class CreditNoteDetail {
	
	
	

	
	/*Variable for Setters and Getters CreditNoteDetails */
	private int creditNoteId;
	private int creditNoteDetailId;
	private String materialId;
	private String qty;
	private String uomId;
	private String perUnit;
	private String netPrice;
	private String demitAmont;
	
	
	/*List Variables*/
	
	private Material materialDetails;
	private Uom uomDetails;
	
	
	/*Variable for Material Name And Uom Name*/
	private String materialName;
	private String uomName;
	
	
	
		
	/*Setters And Getters Method  For CreditNoteDetails Table*/
	
	
	
	
	public int getCreditNoteDetailId() {
		return creditNoteDetailId;
	}
	public int getCreditNoteId() {
		return creditNoteId;
	}
	public void setCreditNoteId(int creditNoteId) {
		this.creditNoteId = creditNoteId;
	}
	public void setCreditNoteDetailId(int creditNoteDetailId) {
		this.creditNoteDetailId = creditNoteDetailId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getUomId() {
		return uomId;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	public String getPerUnit() {
		return perUnit;
	}
	public void setPerUnit(String perUnit) {
		this.perUnit = perUnit;
	}
	public String getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	public String getDemitAmont() {
		return demitAmont;
	}
	public void setDemitAmont(String demitAmont) {
		this.demitAmont = demitAmont;
	}
	
	
	/*Setters and getters of List Variables*/
	
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
	
	
	
	/*Setters and Getters Methods for Material Name and Uom Name*/
	
	
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

}
