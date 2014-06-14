/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 *@version 1.0 03-12-2013
 */
public class SalesPOLineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int SalesPOLineId;
	private int SalesPOId;
	private String materialId;
	private String curId;
	private String UOMId;
	private String quantity;
	private String unitPrice;
	private String lineAmount;
	private String dueDateChild;
	
	private Material material;
	private Currency currency;
	private Uom uom;
	
	//Edit Variables
	private int esalesPOLineId;
	private String ematerialId;
	private String ecurId;
	private String eUOMId;
	private String equantity;
	private String eunitPrice;
	private String elineAmount;
	private String edueDateChild;
	
	private String ematerialName;
	private String euomName;
	private String ecurrencyName; 
	
	
	// Setter And Getter Methods
	
	public int getSalesPOLineId() {
		return SalesPOLineId;
	}
	public int getSalesPOId() {
		return SalesPOId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public String getCurId() {
		return curId;
	}
	public String getUOMId() {
		return UOMId;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public String getLineAmount() {
		return lineAmount;
	}
	public String getDueDateChild() {
		return dueDateChild;
	}
	
	public void setSalesPOLineId(int salesPOLineId) {
		SalesPOLineId = salesPOLineId;
	}
	public void setSalesPOId(int salesPOId) {
		SalesPOId = salesPOId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public void setCurId(String curId) {
		this.curId = curId;
	}
	public void setUOMId(String uOMId) {
		UOMId = uOMId;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Material getMaterial() {
		return material;
	}
	public Currency getCurrency() {
		return currency;
	}
	public Uom getUom() {
		return uom;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setLineAmount(String lineAmount) {
		this.lineAmount = lineAmount;
	}
	public void setDueDateChild(String dueDateChild) {
		this.dueDateChild = dueDateChild;
	}

	public String getEmaterialId() {
		return ematerialId;
	}
	public String getEmaterialName() {
		return ematerialName;
	}
	public String getEuomName() {
		return euomName;
	}
	public String getEcurrencyName() {
		return ecurrencyName;
	}
	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}
	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}
	public void setEcurrencyName(String ecurrencyName) {
		this.ecurrencyName = ecurrencyName;
	}
	public String getEcurId() {
		return ecurId;
	}
	public String geteUOMId() {
		return eUOMId;
	}
	public String getEquantity() {
		return equantity;
	}
	public String getEunitPrice() {
		return eunitPrice;
	}
	public String getElineAmount() {
		return elineAmount;
	}
	public String getEdueDateChild() {
		return edueDateChild;
	}
	
	public void setEmaterialId(String ematerialId) {
		this.ematerialId = ematerialId;
	}
	public void setEcurId(String ecurId) {
		this.ecurId = ecurId;
	}
	public int getEsalesPOLineId() {
		return esalesPOLineId;
	}
	public void setEsalesPOLineId(int esalesPOLineId) {
		this.esalesPOLineId = esalesPOLineId;
	}
	public void seteUOMId(String eUOMId) {
		this.eUOMId = eUOMId;
	}
	public void setEquantity(String equantity) {
		this.equantity = equantity;
	}
	public void setEunitPrice(String eunitPrice) {
		this.eunitPrice = eunitPrice;
	}
	public void setElineAmount(String elineAmount) {
		this.elineAmount = elineAmount;
	}
	public void setEdueDateChild(String edueDateChild) {
		this.edueDateChild = edueDateChild;
	}
	
}
