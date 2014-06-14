/**
 * @Copyright MNTSOFT   
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 *@version 1.0 14-11-2013
 */
public class SalesQuotationLineBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int salesQuotationLineId;
	private int salesQuotationId;
	private String materialId;
	private String quantity;
	private String UOMId;
	private String currencyId;
	private String requiredDate;
	private String deliveryDate;
	private int perUnit;
	private float netPrice;
	private float lineAmount;
	private int count;
	private String umId;
	
	private int esalesQuotationLineId;
	private int esalesQuotationId;
	private String ematerialId;
	private String equantity;
	private String eUOMId;
	private String ecurrencyId;
	private String erequiredDate;
	private String edeliveryDate;
	private int eperUnit;
	private float enetPrice;
	private float elineAmount;
	
	private String ematerialName;
	private String euomName;
	private String ecurrencyName;
	
	private Material material;
	private Currency currency;
	private Uom uom;
	
	//Setter And Getter Methods
	
	public int getSalesQuotationLineId() {
		return salesQuotationLineId;
	}
	public void setSalesQuotationLineId(int salesQuotationLineId) {
		this.salesQuotationLineId = salesQuotationLineId;
	}
	public int getSalesQuotationId() {
		return salesQuotationId;
	}
	public void setSalesQuotationId(int salesQuotationId) {
		this.salesQuotationId = salesQuotationId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getUmId() {
		return umId;
	}
	public void setUmId(String umId) {
		this.umId = umId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUOMId() {
		return UOMId;
	}
	public void setUOMId(String UOMId) {
		this.UOMId = UOMId;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getPerUnit() {
		return perUnit;
	}
	public void setPerUnit(int perUnit) {
		this.perUnit = perUnit;
	}
	public float getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(float netPrice) {
		this.netPrice = netPrice;
	}
	public float getLineAmount() {
		return lineAmount;
	}
	public void setLineAmount(float lineAmount) {
		this.lineAmount = lineAmount;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Currency getCurrency() {
		return currency;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public int getEsalesQuotationLineId() {
		return esalesQuotationLineId;
	}
	public String getEmaterialName() {
		return ematerialName;
	}
	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}

	public String getEcurrencyName() {
		return ecurrencyName;
	}
	public void setEcurrencyName(String ecurrencyName) {
		this.ecurrencyName = ecurrencyName;
	}
	public void setEsalesQuotationLineId(int esalesQuotationLineId) {
		this.esalesQuotationLineId = esalesQuotationLineId;
	}
	public int getEsalesQuotationId() {
		return esalesQuotationId;
	}
	public void setEsalesQuotationId(int esalesQuotationId) {
		this.esalesQuotationId = esalesQuotationId;
	}
	public String getEmaterialId() {
		return ematerialId;
	}
	public void setEmaterialId(String ematerialId) {
		this.ematerialId = ematerialId;
	}
	public String getEquantity() {
		return equantity;
	}
	public void setEquantity(String equantity) {
		this.equantity = equantity;
	}
	public String geteUOMId() {
		return eUOMId;
	}
	public void seteUOMId(String eUOMId) {
		this.eUOMId = eUOMId;
	}
	public String getEcurrencyId() {
		return ecurrencyId;
	}
	public void setEcurrencyId(String ecurrencyId) {
		this.ecurrencyId = ecurrencyId;
	}
	public String getErequiredDate() {
		return erequiredDate;
	}
	public void setErequiredDate(String erequiredDate) {
		this.erequiredDate = erequiredDate;
	}
	public String getEdeliveryDate() {
		return edeliveryDate;
	}
	public void setEdeliveryDate(String edeliveryDate) {
		this.edeliveryDate = edeliveryDate;
	}
	public int getEperUnit() {
		return eperUnit;
	}
	public void setEperUnit(int eperUnit) {
		this.eperUnit = eperUnit;
	}
	public float getEnetPrice() {
		return enetPrice;
	}
	public void setEnetPrice(float enetPrice) {
		this.enetPrice = enetPrice;
	}
	public float getElineAmount() {
		return elineAmount;
	}
	public String getEuomName() {
		return euomName;
	}
	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}
	public void setElineAmount(float elineAmount) {
		this.elineAmount = elineAmount;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	

}
