/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 07-11-2013
 */
public class SalesInquiryLineBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int salesInquiryLineId;
	private String salesInquiryId;
	private String materialId;
	private String quantity;
	private String UOMId;
	private String requiredDate;
	private String uomName;
	private int count;
	private String umId;
	
	private Material material;
	private Uom uom;

	private int esalesInquiryLineId;
	private String esalesInquiryId;
	private String ematerialId;
	private String ematerialName;
	private String equantity;
	private String eUOMId;
	private String eUomName;
	private String erequiredDate;
	
	// Setter And Getter Methods
	
	public String getEmaterialName() {
		return ematerialName;
	}

	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}

	public String geteUomName() {
		return eUomName;
	}

	public void seteUomName(String eUomName) {
		this.eUomName = eUomName;
	}


	public int getSalesInquiryLineId() {
		return salesInquiryLineId;
	}

	public void setSalesInquiryLineId(int salesInquiryLineId) {
		this.salesInquiryLineId = salesInquiryLineId;
	}

	public String getSalesInquiryId() {
		return salesInquiryId;
	}

	public void setSalesInquiryId(String salesInquiryId) {
		this.salesInquiryId = salesInquiryId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
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

	public String getUmId() {
		return umId;
	}

	public void setUmId(String umId) {
		this.umId = umId;
	}

	public void setUOMId(String UOMId) {
		this.UOMId = UOMId;
	}


	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public int getEsalesInquiryLineId() {
		return esalesInquiryLineId;
	}

	public void setEsalesInquiryLineId(int esalesInquiryLineId) {
		this.esalesInquiryLineId = esalesInquiryLineId;
	}

	public String getUomName() {
		return uomName;
	}

	public int getCount() {
		return count;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getEsalesInquiryId() {
		return esalesInquiryId;
	}

	public void setEsalesInquiryId(String esalesInquiryId) {
		this.esalesInquiryId = esalesInquiryId;
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

	public String getErequiredDate() {
		return erequiredDate;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public void setErequiredDate(String erequiredDate) {
		this.erequiredDate = erequiredDate;
	}

}
