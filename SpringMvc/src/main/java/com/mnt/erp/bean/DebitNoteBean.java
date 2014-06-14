/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 02-01-2014
 */

public class DebitNoteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int debitNoteId;
	private String debitNoteNo;
	private String debitNoteDT;
	private String custInvoiceId;
	private String vendorInvoiceId;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	private List<DebitNoteDetail> debitNoteDetail;
	private CustomerInvoice custInvoice;
	private VendorInvoice vendorInvoice;
	
	private String material_Id;
	private String uom_Id;
	
	
	//Edit Variables
	private int edebitNoteId;
	private String edebitNoteNo;
	private String edebitNoteDT;
	private String ecustInvoiceId;
	private String evendorInvoiceId;
	
	
	//Child variables
	
	private int[] debitNoteDetailId;
	private String[] materialId;
	private String[] quantity;
	private String[] uomId;
	public String getLabels() {
		return labels;
	}

	public String getDbField() {
		return dbField;
	}

	public String getAsOpts() {
		return asOpts;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	private String[] perUnit;
	private String[] netPrice;
	private String[] debitAmount;
	private String materialName;
	private String uomName;
	
	//Edit Child Variables
	private int[] edebitNoteDetailId;
	private String[] ematerialId;
	private String[] equantity;
	private String[] euomId;
	private String[] eperUnit;
	private String[] enetPrice;
	private String[] edebitAmount;

	// Setter And Getter Methods

	public int getDebitNoteId() {
		return debitNoteId;
	}

	public String getDebitNoteNo() {
		return debitNoteNo;
	}

	public String getDebitNoteDT() {
		return debitNoteDT;
	}

	public String getCustInvoiceId() {
		return custInvoiceId;
	}

	
	public String getXmlLabel() {
		return xmlLabel;
	}

	public String getOperations() {
		return operations;
	}

	public String getBasicSearchId() {
		return basicSearchId;
	}

	public void setDebitNoteId(int debitNoteId) {
		this.debitNoteId = debitNoteId;
	}

	public List<DebitNoteDetail> getDebitNoteDetail() {
		return debitNoteDetail;
	}

	public void setDebitNoteDetail(List<DebitNoteDetail> debitNoteDetail) {
		this.debitNoteDetail = debitNoteDetail;
	}

	public String getVendorInvoiceId() {
		return vendorInvoiceId;
	}

	public void setVendorInvoiceId(String vendorInvoiceId) {
		this.vendorInvoiceId = vendorInvoiceId;
	}

	public CustomerInvoice getCustInvoice() {
		return custInvoice;
	}

	public int getEdebitNoteId() {
		return edebitNoteId;
	}

	public String getEdebitNoteNo() {
		return edebitNoteNo;
	}

	public String getEdebitNoteDT() {
		return edebitNoteDT;
	}

	public String getEcustInvoiceId() {
		return ecustInvoiceId;
	}

	public String getEvendorInvoiceId() {
		return evendorInvoiceId;
	}

	public int[] getEdebitNoteDetailId() {
		return edebitNoteDetailId;
	}

	public String[] getEmaterialId() {
		return ematerialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String[] getEquantity() {
		return equantity;
	}

	public String[] getEuomId() {
		return euomId;
	}

	public String[] getEperUnit() {
		return eperUnit;
	}

	public String[] getEnetPrice() {
		return enetPrice;
	}

	public String[] getEdebitAmount() {
		return edebitAmount;
	}

	public void setEdebitNoteId(int edebitNoteId) {
		this.edebitNoteId = edebitNoteId;
	}

	public void setEdebitNoteNo(String edebitNoteNo) {
		this.edebitNoteNo = edebitNoteNo;
	}

	public void setEdebitNoteDT(String edebitNoteDT) {
		this.edebitNoteDT = edebitNoteDT;
	}

	public void setEcustInvoiceId(String ecustInvoiceId) {
		this.ecustInvoiceId = ecustInvoiceId;
	}

	public void setEvendorInvoiceId(String evendorInvoiceId) {
		this.evendorInvoiceId = evendorInvoiceId;
	}

	public void setEdebitNoteDetailId(int[] edebitNoteDetailId) {
		this.edebitNoteDetailId = edebitNoteDetailId;
	}

	public void setEmaterialId(String[] ematerialId) {
		this.ematerialId = ematerialId;
	}

	public void setEquantity(String[] equantity) {
		this.equantity = equantity;
	}

	public void setEuomId(String[] euomId) {
		this.euomId = euomId;
	}

	public void setEperUnit(String[] eperUnit) {
		this.eperUnit = eperUnit;
	}

	public void setEnetPrice(String[] enetPrice) {
		this.enetPrice = enetPrice;
	}

	public void setEdebitAmount(String[] edebitAmount) {
		this.edebitAmount = edebitAmount;
	}

	public VendorInvoice getVendorInvoice() {
		return vendorInvoice;
	}

	public void setCustInvoice(CustomerInvoice custInvoice) {
		this.custInvoice = custInvoice;
	}

	public void setVendorInvoice(VendorInvoice vendorInvoice) {
		this.vendorInvoice = vendorInvoice;
	}

	public void setDebitNoteNo(String debitNoteNo) {
		this.debitNoteNo = debitNoteNo;
	}

	public void setDebitNoteDT(String debitNoteDT) {
		this.debitNoteDT = debitNoteDT;
	}

	public void setCustInvoiceId(String custInvoiceId) {
		this.custInvoiceId = custInvoiceId;
	}

	

	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	public String getMaterial_Id() {
		return material_Id;
	}

	public String getUom_Id() {
		return uom_Id;
	}

	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}

	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}

	public int[] getDebitNoteDetailId() {
		return debitNoteDetailId;
	}

	public String[] getMaterialId() {
		return materialId;
	}

	public String[] getQuantity() {
		return quantity;
	}

	public String[] getUomId() {
		return uomId;
	}

	public String[] getPerUnit() {
		return perUnit;
	}

	public String[] getNetPrice() {
		return netPrice;
	}

	public String[] getDebitAmount() {
		return debitAmount;
	}

	public void setDebitNoteDetailId(int[] debitNoteDetailId) {
		this.debitNoteDetailId = debitNoteDetailId;
	}

	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}

	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}

	public void setUomId(String[] uomId) {
		this.uomId = uomId;
	}

	public void setPerUnit(String[] perUnit) {
		this.perUnit = perUnit;
	}

	public void setNetPrice(String[] netPrice) {
		this.netPrice = netPrice;
	}

	public void setDebitAmount(String[] debitAmount) {
		this.debitAmount = debitAmount;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

}
