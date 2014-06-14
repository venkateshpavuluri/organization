/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author kirangangone
 * 
 */
public class CreditNote {
	
	
	
	/*Variable for Setter And Getters  CreditNote */
	private int creditNoteId;
	private String creditNoteNo;
	private String creditNoteDT;
	private String customerInvoiceId;
	private String vendorInvoiceId;
	
	
	/* Duplicate Check */
	private int creditNoteDuplicate;
	private int cnId;
	
	/*Variable for Setters and Getters CreditNoteDetails */
	
	private int[] creditNoteDetailId;
	private String[] materialId;
	private String[] qty;
	private String[] uomId;
	private String[] perUnit;
	private String[] netPrice;
	private String[] demitAmont;
	private String[] materialName;
	private String[] uomName;
	
	private String materialIdSelect;
	private String uomIdSelect;
	
	

	
	/* Variable For Basic Search And Advanced Search*/
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
		private String xmlLabelBasic;
		private String firstLabel;
		private String secondLabel;
		private String operations1;
		private String advanceSearchText;
		private int advanceSearchHidden;
	 
	 
	 
	 /*For Child Pojo List*/
	 
	
	private List<CreditNoteDetail> creditNoteDetail;
	 
	
	
	/*For Vendor And Customer Invoice detatils*/
	
	
    private CustomerInvoice customerInvoiceDetails; 
	private VendorInvoice vendorInvoiceDetails;
	
	
	/*Setters And Getters Method  For CreditNote Table*/
	


	

	public int getCreditNoteId() {
		return creditNoteId;
	}
	public void setCreditNoteId(int creditNoteId) {
		this.creditNoteId = creditNoteId;
	}
	public String getCreditNoteNo() {
		return creditNoteNo;
	}
	public void setCreditNoteNo(String creditNoteNo) {
		this.creditNoteNo = creditNoteNo;
	}
	public String getCreditNoteDT() {
		return creditNoteDT;
	}
	public void setCreditNoteDT(String creditNoteDT) {
		this.creditNoteDT = creditNoteDT;
	}
	public String getCustomerInvoiceId() {
		return customerInvoiceId;
	}
	public void setCustomerInvoiceId(String customerInvoiceId) {
		this.customerInvoiceId = customerInvoiceId;
	}
	public String getVendorInvoiceId() {
		return vendorInvoiceId;
	}
	public void setVendorInvoiceId(String vendorInvoiceId) {
		this.vendorInvoiceId = vendorInvoiceId;
	}
	
	
	
	/*Setters And Getters Method  For CreditNoteDetails Table*/
	
	
	
	public int[] getCreditNoteDetailId() {
		return creditNoteDetailId;
	}
	public void setCreditNoteDetailId(int[] creditNoteDetailId) {
		this.creditNoteDetailId = creditNoteDetailId;
	}
	public String[] getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}
	public String[] getQty() {
		return qty;
	}
	public void setQty(String[] qty) {
		this.qty = qty;
	}
	public String[] getUomId() {
		return uomId;
	}
	public void setUomId(String[] uomId) {
		this.uomId = uomId;
	}
	public String[] getPerUnit() {
		return perUnit;
	}
	public void setPerUnit(String[] perUnit) {
		this.perUnit = perUnit;
	}
	public String[] getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String[] netPrice) {
		this.netPrice = netPrice;
	}
	public String[] getDemitAmont() {
		return demitAmont;
	}
	public void setDemitAmont(String[] demitAmont) {
		this.demitAmont = demitAmont;
	}
	
	public String[] getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String[] materialName) {
		this.materialName = materialName;
	}
	public String[] getUomName() {
		return uomName;
	}
	public void setUomName(String[] uomName) {
		this.uomName = uomName;
	}
	
	public String getMaterialIdSelect() {
		return materialIdSelect;
	}
	public void setMaterialIdSelect(String materialIdSelect) {
		this.materialIdSelect = materialIdSelect;
	}
	
	public String getUomIdSelect() {
		return uomIdSelect;
	}
	public void setUomIdSelect(String uomIdSelect) {
		this.uomIdSelect = uomIdSelect;
	}
	
	
	/*Duplicate Check Setters And Getters Methods*/
	
	public int getCreditNoteDuplicate() {
		return creditNoteDuplicate;
	}
	public void setCreditNoteDuplicate(int creditNoteDuplicate) {
		this.creditNoteDuplicate = creditNoteDuplicate;
	}
	
	public int getCnId() {
		return cnId;
	}
	public void setCnId(int cnId) {
		this.cnId = cnId;
	}
	
	
	/* Advanced Search Setters and Getters Methods*/
	
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	
	
	 public String getXmlLabelBasic() {
			return xmlLabelBasic;
		}
		public void setXmlLabelBasic(String xmlLabelBasic) {
			this.xmlLabelBasic = xmlLabelBasic;
		}
		public String getFirstLabel() {
			return firstLabel;
		}
		public void setFirstLabel(String firstLabel) {
			this.firstLabel = firstLabel;
		}
		public String getSecondLabel() {
			return secondLabel;
		}
		public void setSecondLabel(String secondLabel) {
			this.secondLabel = secondLabel;
		}
		public String getOperations1() {
			return operations1;
		}
		public void setOperations1(String operations1) {
			this.operations1 = operations1;
		}
		public String getAdvanceSearchText() {
			return advanceSearchText;
		}
		public void setAdvanceSearchText(String advanceSearchText) {
			this.advanceSearchText = advanceSearchText;
		}
		public int getAdvanceSearchHidden() {
			return advanceSearchHidden;
		}
		public void setAdvanceSearchHidden(int advanceSearchHidden) {
			this.advanceSearchHidden = advanceSearchHidden;
		}
	
	/*Getters and Setters For Credit Note Details Pojo List*/
	
	public List<CreditNoteDetail> getCreditNoteDetail() {
		return creditNoteDetail;
	}
	public void setCreditNoteDetail(List<CreditNoteDetail> creditNoteDetail) {
		this.creditNoteDetail = creditNoteDetail;
	}
	
	

	/*Setters And Getters of Vendor And Customer Invoice detatils*/
	
	public CustomerInvoice getCustomerInvoiceDetails() {
		return customerInvoiceDetails;
	}
	public void setCustomerInvoiceDetails(CustomerInvoice customerInvoiceDetails) {
		this.customerInvoiceDetails = customerInvoiceDetails;
	}
	public VendorInvoice getVendorInvoiceDetails() {
		return vendorInvoiceDetails;
	}
	public void setVendorInvoiceDetails(VendorInvoice vendorInvoiceDetails) {
		this.vendorInvoiceDetails = vendorInvoiceDetails;
	}

}
