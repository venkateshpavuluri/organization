/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Naresh
 * @version 1.0 20-11-2013
 */
public class SalesOrderLineBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int salesOrderLineId;
	private int salesOrderId;
	private String materialId;
	private String uomId;
	private String currencyId;
	private String quantity;
	private String custMaterailNo;
	private String netPrice;
	private String uPrice;
	private String tax;
	private String discount;
	private String totalAmt;
	Set<SalesOrderSchLineBean> salesSearchLine;
	
	//Edit variables
	private int esalesOrderLineId;
	private int esalesOrderId;
	private String ematerialId;
	private String euomId;
	private String ecurrencyId;
	private String equantity;
	private String ecustMaterailNo;
	private String enetPrice;
	private String euPrice;
	private String etax;
	private String ediscount;
	private String etotalAmt;
	
	private String ematerialName;
	private String euomName;
	private String ecurrencyName;
	
	
	private Material material;
	private Currency currency;
	private Uom uom;
	
	// Setter And Getter Methods
	
	public int getSalesOrderLineId() {
		return salesOrderLineId;
	}
	public void setSalesOrderLineId(int salesOrderLineId) {
		this.salesOrderLineId = salesOrderLineId;
	}
	public int getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getUomId() {
		return uomId;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getQuantity() {
		return quantity;
	}
	public Set<SalesOrderSchLineBean> getSalesSearchLine() {
		return salesSearchLine;
	}
	public void setSalesSearchLine(Set<SalesOrderSchLineBean> salesSearchLine) {
		this.salesSearchLine = salesSearchLine;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCustMaterailNo() {
		return custMaterailNo;
	}
	public void setCustMaterailNo(String custMaterailNo) {
		this.custMaterailNo = custMaterailNo;
	}
	public String getNetPrice() {
		return netPrice;
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
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public String getuPrice() {
		return uPrice;
	}
	public String getTax() {
		return tax;
	}
	public String getDiscount() {
		return discount;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public String getEtax() {
		return etax;
	}
	public String getEdiscount() {
		return ediscount;
	}
	public String getEtotalAmt() {
		return etotalAmt;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	public void setEtax(String etax) {
		this.etax = etax;
	}
	public void setEdiscount(String ediscount) {
		this.ediscount = ediscount;
	}
	public void setEtotalAmt(String etotalAmt) {
		this.etotalAmt = etotalAmt;
	}
	public String getEuPrice() {
		return euPrice;
	}
	public void setuPrice(String uPrice) {
		this.uPrice = uPrice;
	}
	public void setEuPrice(String euPrice) {
		this.euPrice = euPrice;
	}
	public int getEsalesOrderLineId() {
		return esalesOrderLineId;
	}
	public String getEmaterialName() {
		return ematerialName;
	}
	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}
	public String getEuomName() {
		return euomName;
	}
	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}
	public String getEcurrencyName() {
		return ecurrencyName;
	}
	public void setEcurrencyName(String ecurrencyName) {
		this.ecurrencyName = ecurrencyName;
	}
	public void setEsalesOrderLineId(int esalesOrderLineId) {
		this.esalesOrderLineId = esalesOrderLineId;
	}
	public int getEsalesOrderId() {
		return esalesOrderId;
	}
	public void setEsalesOrderId(int esalesOrderId) {
		this.esalesOrderId = esalesOrderId;
	}
	public String getEmaterialId() {
		return ematerialId;
	}
	public void setEmaterialId(String ematerialId) {
		this.ematerialId = ematerialId;
	}
	public String getEuomId() {
		return euomId;
	}
	public void setEuomId(String euomId) {
		this.euomId = euomId;
	}
	public String getEcurrencyId() {
		return ecurrencyId;
	}
	public void setEcurrencyId(String ecurrencyId) {
		this.ecurrencyId = ecurrencyId;
	}
	public String getEquantity() {
		return equantity;
	}
	public void setEquantity(String equantity) {
		this.equantity = equantity;
	}
	public String getEcustMaterailNo() {
		return ecustMaterailNo;
	}
	public void setEcustMaterailNo(String ecustMaterailNo) {
		this.ecustMaterailNo = ecustMaterailNo;
	}
	public String getEnetPrice() {
		return enetPrice;
	}
	public void setEnetPrice(String enetPrice) {
		this.enetPrice = enetPrice;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	
	

}
