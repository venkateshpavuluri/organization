/**

 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author Kiran
 * @version 1.0 18-11-2013
   @build 0.0
 *
 */
public class PurchaseOrder 
{
     /*============================Properties============================*/

	

	 
		 private int purchaseOrderId;
		 private String purchaseOrderNo;
		 private String purchaseOrderDate;
		 private String purchaseOrderValue;
		 private String purchaseOrderStatus;
		 private String description;
		 private String vendorId;
		 private String quotationId;
		 private String paymentTerms;
		 private String memo;
		 private String currencyCode;
		 private String salesTaxAmt;
		 private String vatAmt;
		 private String exciseAmt;
		 private String frieghtCharges;
		 private String pnFCharges;
		 private String dueDate;
		 private String createdBy;
		 private String createdDateTime;
		 private String modifiedBy;
		 private String modifiedDateTime;
		 private String materialName;
		 private String uomName;
		 private String currencyName;
		 private int purchaseAddDuplicate;
		 private int purchaseAddDuplicateEdit;
		 private String purchaseGroupId;
		 private int checkChildData;
	
		 
		 
		 
		 
		 private int purchaseOrderIdEdit;
		 private String purchaseOrderNoEdit;
		 private String purchaseOrderDateEdit;
		 private String purchaseOrderValueEdit;
		 private String purchaseOrderStatusEdit;
		 private String descriptionEdit;
		 private String vendorIdEdit;
		 private String quotationIdEdit;
		 private String paymentTermsEdit;
		 private String memoEdit;
		 private String currencyCodeEdit;
		 private String salesTaxAmtEdit;
		 private String vatAmtEdit;
		 private String exciseAmtEdit;
		 private String frieghtChargesEdit;
		 private String pnFChargesEdit;
		 private String dueDateEdit;
		 private String createdByEdit;
		 private String createdDateTimeEdit;
		 private String modifiedByEdit;
		 private String modifiedDateTimeEdit;
		 private String materialNameEdit;
		 private String uomNameEdit;
		 private String currencyNameEdit;
		 private String purchaseGroupIdEdit;
		
	
	 

			private int[] purchaseOrderLineIdChild;
			private int[] lineNumberChild;
			public int getCheckChildData() {
				return checkChildData;
			}
			public void setCheckChildData(int checkChildData) {
				this.checkChildData = checkChildData;
			}
			private String[] materialIdChild;
			private float[] unitPriceChild;
			private String[] currencyCodeChild;
			private float[] quantityChild;
			private String[] uomChild;
			private float[] lineAmtChild;
			private float[] salesTaxAmtChild;
			private float[] vatTaxAmtChild;
			private float[] exciseAmtChild;
			private float[] frieghtChargesChild;
			private float[] pnfChargesChild;
			private String[] dueDateChild;
			private String[] createdByChild;
			private String[] createdDateTimeChild;
			private String[] modifiedByChild;
			private String[] modifiedDateTimeChild;
			private String[] materialNameChild;
			private String[] uomNameChild;
			private String[] currencyNameChild;
			
			private String uomChildL;
			private String currencyCodeChildL;
			private String materialIdChildL;
			private String currencyCodeNameChild;
			
			
			
			private String uomChildLEdit;
			private String currencyCodeChildLEdit;
			private String materialIdChildLEdit;
			private String currencyCodeNameChildEdit;
			
			private int[] purchaseOrderLineIdChildEdit;
			private int[] lineNumberChildEdit;
			private String[] materialIdChildEdit;
			private float[] unitPriceChildEdit;
			private String[] currencyCodeChildEdit;
			private float[] quantityChildEdit;
			private String[] uomChildEdit;
			private float[] lineAmtChildEdit;
			private String[] dueDateChildEdit;
			private float[] salesTaxAmtChildEdit;
			private float[] vatTaxAmtChildEdit;
			private float[] exciseAmtChildEdit;
			private float[] frieghtChargesChildEdit;
			private float[] pnfChargesChildEdit;
			
			private String[] createdByChildEdit;
			private String[] createdDateTimeChildEdit;
			private String[] modifiedByChildEdit;
			private String[] modifiedDateTimeChildEdit;
			private String[] materialNameChildEdit;
			private String[] uomNameChildEdit;
			private String[] currencyNameChildEdit;	
			
			List<PurchaseOrderLine> purchaseOrderLine;
			private int puId;
			private int puEditId;
			
			/*Basic Search And Advanced Search*/
			private String xmlLabelBasic;
			private String operations;
			private String basicSearchId;
			private String firstLabel;
			private String secondLabel;
			private String operations1;
			private String advanceSearchText;
			private int advanceSearchHidden;
			
			/*WorkFlow Properties*/
			private Vendor vendorDetails;
			private Quotation qutationDetails;
			private String vendorName;
			private String purStatus;
			private Status satatusDetails;
			private PaymentTerms paymentDetails;
			private String statusName;
			private String workFlowListId;
			private String actionNames;
			private String comments;
		private Currency currencyDetails;
	//private String currencyName;

		
	 /*=========================Child Pojo List===========================*/
		 private List<PurchaseOrderLine> poLine;
		 
		public List<PurchaseOrderLine> getPoLine() {
			return poLine;
		}
		public void setPoLine(List<PurchaseOrderLine> poLine) {
			this.poLine = poLine;
		}
		
		/*=========================Getters====================================*/
		
		public int getPurchaseOrderId() {
			return purchaseOrderId;
		}
		public String getPurchaseOrderNo() {
			return purchaseOrderNo;
		}
		public String getPurchaseOrderDate() {
			return purchaseOrderDate;
		}
		public String getPurchaseOrderValue() {
			return purchaseOrderValue;
		}
		public String getPurchaseOrderStatus() {
			return purchaseOrderStatus;
		}
		public String getDescription() {
			return description;
		}
		public String getVendorId() {
			return vendorId;
		}
		public String getQuotationId() {
			return quotationId;
		}
		public String getPaymentTerms() {
			return paymentTerms;
		}
		public String getMemo() {
			return memo;
		}
		public String getCurrencyCode() {
			return currencyCode;
		}
		public String getSalesTaxAmt() {
			return salesTaxAmt;
		}
		public String getVatAmt() {
			return vatAmt;
		}
		public String getExciseAmt() {
			return exciseAmt;
		}
		public String  getFrieghtCharges() {
			return frieghtCharges;
		}
		public String getPnFCharges() {
			return pnFCharges;
		}
		public String getDueDate() {
			return dueDate;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public String getCreatedDateTime() {
			return createdDateTime;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public String getModifiedDateTime() {
			return modifiedDateTime;
		}
			
		
		
		
		
		
		
		
	/*==========================Setters=============================*/
	
	
	
		public void setPurchaseOrderId(int purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
		}
		public void setPurchaseOrderNo(String purchaseOrderNo) {
			this.purchaseOrderNo = purchaseOrderNo;
		}
		public void setPurchaseOrderDate(String purchaseOrderDate) {
			this.purchaseOrderDate = purchaseOrderDate;
		}
		public void setPurchaseOrderValue(String purchaseOrderValue) {
			this.purchaseOrderValue = purchaseOrderValue;
		}
		public void setPurchaseOrderStatus(String purchaseOrderStatus) {
			this.purchaseOrderStatus = purchaseOrderStatus;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setVendorId(String vendorId) {
			this.vendorId = vendorId;
		}
		public void setQuotationId(String quotationId) {
			this.quotationId = quotationId;
		}
		public void setPaymentTerms(String paymentTerms) {
			this.paymentTerms = paymentTerms;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
		public void setSalesTaxAmt(String salesTaxAmt) {
			this.salesTaxAmt = salesTaxAmt;
		}
		public void setVatAmt(String vatAmt) {
			this.vatAmt = vatAmt;
		}
		public void setExciseAmt(String exciseAmt) {
			this.exciseAmt = exciseAmt;
		}
		public void setFrieghtCharges(String frieghtCharges) {
			this.frieghtCharges = frieghtCharges;
		}
		public void setPnFCharges(String pnFCharges) {
			this.pnFCharges = pnFCharges;
		}
		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public void setCreatedDateTime(String createdDateTime) {
			this.createdDateTime = createdDateTime;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public void setModifiedDateTime(String modifiedDateTime) {
			this.modifiedDateTime = modifiedDateTime;
		}
		
		
		
		
	
		
		
		/**
		 * @return the materialName
		 */
		public String getMaterialName() {
			return materialName;
		}
		/**
		 * @param materialName the materialName to set
		 */
		public void setMaterialName(String materialName) {
			this.materialName = materialName;
		}
		/**
		 * @return the uomName
		 */
		public String getUomName() {
			return uomName;
		}
		/**
		 * @param uomName the uomName to set
		 */
		public void setUomName(String uomName) {
			this.uomName = uomName;
		}
		/**
		 * @return the currencyName
		 */
		public String getCurrencyName() {
			return currencyName;
		}
		/**
		 * @param currencyName the currencyName to set
		 */
		public void setCurrencyName(String currencyName) {
			this.currencyName = currencyName;
		}
		/**
		 * @return the vendorDetails
		 */
		public Vendor getVendorDetails() {
			return vendorDetails;
		}
		/**
		 * @param vendorDetails the vendorDetails to set
		 */
		public void setVendorDetails(Vendor vendorDetails) {
			this.vendorDetails = vendorDetails;
		}
		/**
		 * @return the qutationDetails
		 */
		public Quotation getQutationDetails() {
			return qutationDetails;
		}
		/**
		 * @param qutationDetails the qutationDetails to set
		 */
		public void setQutationDetails(Quotation qutationDetails) {
			this.qutationDetails = qutationDetails;
		}
		/**
		 * @return the vendorName
		 */
		public String getVendorName() {
			return vendorName;
		}
		/**
		 * @param vendorName the vendorName to set
		 */
		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}
		/**
		 * @return the purStatus
		 */
		public String getPurStatus() {
			return purStatus;
		}
		/**
		 * @param purStatus the purStatus to set
		 */
		public void setPurStatus(String purStatus) {
			this.purStatus = purStatus;
		}
		/**
		 * @return the satatusDetails
		 */
		public Status getSatatusDetails() {
			return satatusDetails;
		}
		/**
		 * @param satatusDetails the satatusDetails to set
		 */
		public void setSatatusDetails(Status satatusDetails) {
			this.satatusDetails = satatusDetails;
		}
		/**
		 * @return the statusName
		 */
		public String getStatusName() {
			return statusName;
		}
		/**
		 * @param statusName the statusName to set
		 */
		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}
		/**
		 * @return the workFlowListId
		 */
		public String getWorkFlowListId() {
			return workFlowListId;
		}
		/**
		 * @param workFlowListId the workFlowListId to set
		 */
		public void setWorkFlowListId(String workFlowListId) {
			this.workFlowListId = workFlowListId;
		}
		/**
		 * @return the actionNames
		 */
		public String getActionNames() {
			return actionNames;
		}
		/**
		 * @param actionNames the actionNames to set
		 */
		public void setActionNames(String actionNames) {
			this.actionNames = actionNames;
		}
		/**
		 * @return the comments
		 */
		public String getComments() {
			return comments;
		}
		/**
		 * @param comments the comments to set
		 */
		public void setComments(String comments) {
			this.comments = comments;
		}
		/**
		 * @return the currencyDetails
		 */
		public Currency getCurrencyDetails() {
			return currencyDetails;
		}
		/**
		 * @param currencyDetails the currencyDetails to set
		 */
		public void setCurrencyDetails(Currency currencyDetails) {
			this.currencyDetails = currencyDetails;
		}
		/**
		 * @return the purchaseOrderLine
		 */
		public List<PurchaseOrderLine> getPurchaseOrderLine() {
			return purchaseOrderLine;
		}
		/**
		 * @param purchaseOrderLine the purchaseOrderLine to set
		 */
		public void setPurchaseOrderLine(List<PurchaseOrderLine> purchaseOrderLine) {
			this.purchaseOrderLine = purchaseOrderLine;
		}
		/**
		 * @return the purchaseOrderLineIdChild
		 */
		public int[] getPurchaseOrderLineIdChild() {
			return purchaseOrderLineIdChild;
		}
		/**
		 * @param purchaseOrderLineIdChild the purchaseOrderLineIdChild to set
		 */
		public void setPurchaseOrderLineIdChild(int[] purchaseOrderLineIdChild) {
			this.purchaseOrderLineIdChild = purchaseOrderLineIdChild;
		}
		/**
		 * @return the lineNumberChild
		 */
		public int[] getLineNumberChild() {
			return lineNumberChild;
		}
		/**
		 * @param lineNumberChild the lineNumberChild to set
		 */
		public void setLineNumberChild(int[] lineNumberChild) {
			this.lineNumberChild = lineNumberChild;
		}
		/**
		 * @return the materialIdChild
		 */
		public String[] getMaterialIdChild() {
			return materialIdChild;
		}
		/**
		 * @param materialIdChild the materialIdChild to set
		 */
		public void setMaterialIdChild(String[] materialIdChild) {
			this.materialIdChild = materialIdChild;
		}
		/**
		 * @return the unitPriceChild
		 */
		public float[] getUnitPriceChild() {
			return unitPriceChild;
		}
		/**
		 * @param unitPriceChild the unitPriceChild to set
		 */
		public void setUnitPriceChild(float[] unitPriceChild) {
			this.unitPriceChild = unitPriceChild;
		}
		/**
		 * @return the currencyCodeChild
		 */
		public String[] getCurrencyCodeChild() {
			return currencyCodeChild;
		}
		/**
		 * @param currencyCodeChild the currencyCodeChild to set
		 */
		public void setCurrencyCodeChild(String[] currencyCodeChild) {
			this.currencyCodeChild = currencyCodeChild;
		}
		/**
		 * @return the quantityChild
		 */
		public float[] getQuantityChild() {
			return quantityChild;
		}
		/**
		 * @param quantityChild the quantityChild to set
		 */
		public void setQuantityChild(float[] quantityChild) {
			this.quantityChild = quantityChild;
		}
		/**
		 * @return the uomChild
		 */
		public String[] getUomChild() {
			return uomChild;
		}
		/**
		 * @param uomChild the uomChild to set
		 */
		public void setUomChild(String[] uomChild) {
			this.uomChild = uomChild;
		}
		/**
		 * @return the lineAmtChild
		 */
		public float[] getLineAmtChild() {
			return lineAmtChild;
		}
		/**
		 * @param lineAmtChild the lineAmtChild to set
		 */
		public void setLineAmtChild(float[] lineAmtChild) {
			this.lineAmtChild = lineAmtChild;
		}
		/**
		 * @return the salesTaxAmtChild
		 */
		public float[] getSalesTaxAmtChild() {
			return salesTaxAmtChild;
		}
		/**
		 * @param salesTaxAmtChild the salesTaxAmtChild to set
		 */
		public void setSalesTaxAmtChild(float[] salesTaxAmtChild) {
			this.salesTaxAmtChild = salesTaxAmtChild;
		}
		/**
		 * @return the vatTaxAmtChild
		 */
		public float[] getVatTaxAmtChild() {
			return vatTaxAmtChild;
		}
		/**
		 * @param vatTaxAmtChild the vatTaxAmtChild to set
		 */
		public void setVatTaxAmtChild(float[] vatTaxAmtChild) {
			this.vatTaxAmtChild = vatTaxAmtChild;
		}
		/**
		 * @return the exciseAmtChild
		 */
		public float[] getExciseAmtChild() {
			return exciseAmtChild;
		}
		/**
		 * @param exciseAmtChild the exciseAmtChild to set
		 */
		public void setExciseAmtChild(float[] exciseAmtChild) {
			this.exciseAmtChild = exciseAmtChild;
		}
		/**
		 * @return the frieghtChargesChild
		 */
		public float[] getFrieghtChargesChild() {
			return frieghtChargesChild;
		}
		/**
		 * @param frieghtChargesChild the frieghtChargesChild to set
		 */
		public void setFrieghtChargesChild(float[] frieghtChargesChild) {
			this.frieghtChargesChild = frieghtChargesChild;
		}
		/**
		 * @return the pnfChargesChild
		 */
		public float[] getPnfChargesChild() {
			return pnfChargesChild;
		}
		/**
		 * @param pnfChargesChild the pnfChargesChild to set
		 */
		public void setPnfChargesChild(float[] pnfChargesChild) {
			this.pnfChargesChild = pnfChargesChild;
		}
		/**
		 * @return the dueDateChild
		 */
		public String[] getDueDateChild() {
			return dueDateChild;
		}
		/**
		 * @param dueDateChild the dueDateChild to set
		 */
		public void setDueDateChild(String[] dueDateChild) {
			this.dueDateChild = dueDateChild;
		}
		/**
		 * @return the createdByChild
		 */
		public String[] getCreatedByChild() {
			return createdByChild;
		}
		/**
		 * @param createdByChild the createdByChild to set
		 */
		public void setCreatedByChild(String[] createdByChild) {
			this.createdByChild = createdByChild;
		}
		/**
		 * @return the createdDateTimeChild
		 */
		public String[] getCreatedDateTimeChild() {
			return createdDateTimeChild;
		}
		/**
		 * @param createdDateTimeChild the createdDateTimeChild to set
		 */
		public void setCreatedDateTimeChild(String[] createdDateTimeChild) {
			this.createdDateTimeChild = createdDateTimeChild;
		}
		/**
		 * @return the modifiedByChild
		 */
		public String[] getModifiedByChild() {
			return modifiedByChild;
		}
		/**
		 * @param modifiedByChild the modifiedByChild to set
		 */
		public void setModifiedByChild(String[] modifiedByChild) {
			this.modifiedByChild = modifiedByChild;
		}
		/**
		 * @return the modifiedDateTimeChild
		 */
		public String[] getModifiedDateTimeChild() {
			return modifiedDateTimeChild;
		}
		/**
		 * @param modifiedDateTimeChild the modifiedDateTimeChild to set
		 */
		public void setModifiedDateTimeChild(String[] modifiedDateTimeChild) {
			this.modifiedDateTimeChild = modifiedDateTimeChild;
		}
		/**
		 * @return the materialNameChild
		 */
		public String[] getMaterialNameChild() {
			return materialNameChild;
		}
		/**
		 * @param materialNameChild the materialNameChild to set
		 */
		public void setMaterialNameChild(String[] materialNameChild) {
			this.materialNameChild = materialNameChild;
		}
		/**
		 * @return the uomNameChild
		 */
		public String[] getUomNameChild() {
			return uomNameChild;
		}
		/**
		 * @param uomNameChild the uomNameChild to set
		 */
		public void setUomNameChild(String[] uomNameChild) {
			this.uomNameChild = uomNameChild;
		}
		/**
		 * @return the currencyNameChild
		 */
		public String[] getCurrencyNameChild() {
			return currencyNameChild;
		}
		/**
		 * @param currencyNameChild the currencyNameChild to set
		 */
		public void setCurrencyNameChild(String[] currencyNameChild) {
			this.currencyNameChild = currencyNameChild;
		}
		/**
		 * @return the puId
		 */
		public int getPuId() {
			return puId;
		}
		/**
		 * @param puId the puId to set
		 */
		public void setPuId(int puId) {
			this.puId = puId;
		}
		/**
		 * @return the puEditId
		 */
		public int getPuEditId() {
			return puEditId;
		}
		/**
		 * @param puEditId the puEditId to set
		 */
		public void setPuEditId(int puEditId) {
			this.puEditId = puEditId;
		}
		/**
		 * @return the purchaseOrderIdEdit
		 */
		public int getPurchaseOrderIdEdit() {
			return purchaseOrderIdEdit;
		}
		/**
		 * @param purchaseOrderIdEdit the purchaseOrderIdEdit to set
		 */
		public void setPurchaseOrderIdEdit(int purchaseOrderIdEdit) {
			this.purchaseOrderIdEdit = purchaseOrderIdEdit;
		}
		/**
		 * @return the purchaseOrderNoEdit
		 */
		public String getPurchaseOrderNoEdit() {
			return purchaseOrderNoEdit;
		}
		/**
		 * @param purchaseOrderNoEdit the purchaseOrderNoEdit to set
		 */
		public void setPurchaseOrderNoEdit(String purchaseOrderNoEdit) {
			this.purchaseOrderNoEdit = purchaseOrderNoEdit;
		}
		/**
		 * @return the purchaseOrderDateEdit
		 */
		public String getPurchaseOrderDateEdit() {
			return purchaseOrderDateEdit;
		}
		/**
		 * @param purchaseOrderDateEdit the purchaseOrderDateEdit to set
		 */
		public void setPurchaseOrderDateEdit(String purchaseOrderDateEdit) {
			this.purchaseOrderDateEdit = purchaseOrderDateEdit;
		}
		/**
		 * @return the purchaseOrderValueEdit
		 */
		public String getPurchaseOrderValueEdit() {
			return purchaseOrderValueEdit;
		}
		/**
		 * @param purchaseOrderValueEdit the purchaseOrderValueEdit to set
		 */
		public void setPurchaseOrderValueEdit(String purchaseOrderValueEdit) {
			this.purchaseOrderValueEdit = purchaseOrderValueEdit;
		}
		/**
		 * @return the purchaseOrderStatusEdit
		 */
		public String getPurchaseOrderStatusEdit() {
			return purchaseOrderStatusEdit;
		}
		/**
		 * @param purchaseOrderStatusEdit the purchaseOrderStatusEdit to set
		 */
		public void setPurchaseOrderStatusEdit(String purchaseOrderStatusEdit) {
			this.purchaseOrderStatusEdit = purchaseOrderStatusEdit;
		}
		/**
		 * @return the descriptionEdit
		 */
		public String getDescriptionEdit() {
			return descriptionEdit;
		}
		/**
		 * @param descriptionEdit the descriptionEdit to set
		 */
		public void setDescriptionEdit(String descriptionEdit) {
			this.descriptionEdit = descriptionEdit;
		}
		/**
		 * @return the vendorIdEdit
		 */
		public String getVendorIdEdit() {
			return vendorIdEdit;
		}
		/**
		 * @param vendorIdEdit the vendorIdEdit to set
		 */
		public void setVendorIdEdit(String vendorIdEdit) {
			this.vendorIdEdit = vendorIdEdit;
		}
		/**
		 * @return the quotationIdEdit
		 */
		public String getQuotationIdEdit() {
			return quotationIdEdit;
		}
		/**
		 * @param quotationIdEdit the quotationIdEdit to set
		 */
		public void setQuotationIdEdit(String quotationIdEdit) {
			this.quotationIdEdit = quotationIdEdit;
		}
		/**
		 * @return the paymentTermsEdit
		 */
		public String getPaymentTermsEdit() {
			return paymentTermsEdit;
		}
		/**
		 * @param paymentTermsEdit the paymentTermsEdit to set
		 */
		public void setPaymentTermsEdit(String paymentTermsEdit) {
			this.paymentTermsEdit = paymentTermsEdit;
		}
		/**
		 * @return the memoEdit
		 */
		public String getMemoEdit() {
			return memoEdit;
		}
		/**
		 * @param memoEdit the memoEdit to set
		 */
		public void setMemoEdit(String memoEdit) {
			this.memoEdit = memoEdit;
		}
		/**
		 * @return the currencyCodeEdit
		 */
		public String getCurrencyCodeEdit() {
			return currencyCodeEdit;
		}
		/**
		 * @param currencyCodeEdit the currencyCodeEdit to set
		 */
		public void setCurrencyCodeEdit(String currencyCodeEdit) {
			this.currencyCodeEdit = currencyCodeEdit;
		}
		/**
		 * @return the salesTaxAmtEdit
		 */
		public String getSalesTaxAmtEdit() {
			return salesTaxAmtEdit;
		}
		/**
		 * @param salesTaxAmtEdit the salesTaxAmtEdit to set
		 */
		public void setSalesTaxAmtEdit(String salesTaxAmtEdit) {
			this.salesTaxAmtEdit = salesTaxAmtEdit;
		}
		/**
		 * @return the vatAmtEdit
		 */
		public String getVatAmtEdit() {
			return vatAmtEdit;
		}
		/**
		 * @param vatAmtEdit the vatAmtEdit to set
		 */
		public void setVatAmtEdit(String vatAmtEdit) {
			this.vatAmtEdit = vatAmtEdit;
		}
		/**
		 * @return the exciseAmtEdit
		 */
		public String getExciseAmtEdit() {
			return exciseAmtEdit;
		}
		/**
		 * @param exciseAmtEdit the exciseAmtEdit to set
		 */
		public void setExciseAmtEdit(String exciseAmtEdit) {
			this.exciseAmtEdit = exciseAmtEdit;
		}
		/**
		 * @return the frieghtChargesEdit
		 */
		public String getFrieghtChargesEdit() {
			return frieghtChargesEdit;
		}
		/**
		 * @param frieghtChargesEdit the frieghtChargesEdit to set
		 */
		public void setFrieghtChargesEdit(String frieghtChargesEdit) {
			this.frieghtChargesEdit = frieghtChargesEdit;
		}
		/**
		 * @return the pnFChargesEdit
		 */
		public String getPnFChargesEdit() {
			return pnFChargesEdit;
		}
		/**
		 * @param pnFChargesEdit the pnFChargesEdit to set
		 */
		public void setPnFChargesEdit(String pnFChargesEdit) {
			this.pnFChargesEdit = pnFChargesEdit;
		}
		/**
		 * @return the dueDateEdit
		 */
		public String getDueDateEdit() {
			return dueDateEdit;
		}
		/**
		 * @param dueDateEdit the dueDateEdit to set
		 */
		public void setDueDateEdit(String dueDateEdit) {
			this.dueDateEdit = dueDateEdit;
		}
		/**
		 * @return the createdByEdit
		 */
		public String getCreatedByEdit() {
			return createdByEdit;
		}
		/**
		 * @param createdByEdit the createdByEdit to set
		 */
		public void setCreatedByEdit(String createdByEdit) {
			this.createdByEdit = createdByEdit;
		}
		/**
		 * @return the createdDateTimeEdit
		 */
		public String getCreatedDateTimeEdit() {
			return createdDateTimeEdit;
		}
		/**
		 * @param createdDateTimeEdit the createdDateTimeEdit to set
		 */
		public void setCreatedDateTimeEdit(String createdDateTimeEdit) {
			this.createdDateTimeEdit = createdDateTimeEdit;
		}
		/**
		 * @return the modifiedByEdit
		 */
		public String getModifiedByEdit() {
			return modifiedByEdit;
		}
		/**
		 * @param modifiedByEdit the modifiedByEdit to set
		 */
		public void setModifiedByEdit(String modifiedByEdit) {
			this.modifiedByEdit = modifiedByEdit;
		}
		/**
		 * @return the modifiedDateTimeEdit
		 */
		public String getModifiedDateTimeEdit() {
			return modifiedDateTimeEdit;
		}
		/**
		 * @param modifiedDateTimeEdit the modifiedDateTimeEdit to set
		 */
		public void setModifiedDateTimeEdit(String modifiedDateTimeEdit) {
			this.modifiedDateTimeEdit = modifiedDateTimeEdit;
		}
		/**
		 * @return the materialNameEdit
		 */
		public String getMaterialNameEdit() {
			return materialNameEdit;
		}
		/**
		 * @param materialNameEdit the materialNameEdit to set
		 */
		public void setMaterialNameEdit(String materialNameEdit) {
			this.materialNameEdit = materialNameEdit;
		}
		/**
		 * @return the uomNameEdit
		 */
		public String getUomNameEdit() {
			return uomNameEdit;
		}
		/**
		 * @param uomNameEdit the uomNameEdit to set
		 */
		public void setUomNameEdit(String uomNameEdit) {
			this.uomNameEdit = uomNameEdit;
		}
		/**
		 * @return the currencyNameEdit
		 */
		public String getCurrencyNameEdit() {
			return currencyNameEdit;
		}
		/**
		 * @param currencyNameEdit the currencyNameEdit to set
		 */
		public void setCurrencyNameEdit(String currencyNameEdit) {
			this.currencyNameEdit = currencyNameEdit;
		}
		/**
		 * @return the purchaseOrderLineIdChildEdit
		 */
		public int[] getPurchaseOrderLineIdChildEdit() {
			return purchaseOrderLineIdChildEdit;
		}
		/**
		 * @param purchaseOrderLineIdChildEdit the purchaseOrderLineIdChildEdit to set
		 */
		public void setPurchaseOrderLineIdChildEdit(int[] purchaseOrderLineIdChildEdit) {
			this.purchaseOrderLineIdChildEdit = purchaseOrderLineIdChildEdit;
		}
		/**
		 * @return the lineNumberChildEdit
		 */
		public int[] getLineNumberChildEdit() {
			return lineNumberChildEdit;
		}
		/**
		 * @param lineNumberChildEdit the lineNumberChildEdit to set
		 */
		public void setLineNumberChildEdit(int[] lineNumberChildEdit) {
			this.lineNumberChildEdit = lineNumberChildEdit;
		}
		/**
		 * @return the materialIdChildEdit
		 */
		public String[] getMaterialIdChildEdit() {
			return materialIdChildEdit;
		}
		/**
		 * @param materialIdChildEdit the materialIdChildEdit to set
		 */
		public void setMaterialIdChildEdit(String[] materialIdChildEdit) {
			this.materialIdChildEdit = materialIdChildEdit;
		}
		/**
		 * @return the unitPriceChildEdit
		 */
		public float[] getUnitPriceChildEdit() {
			return unitPriceChildEdit;
		}
		/**
		 * @param unitPriceChildEdit the unitPriceChildEdit to set
		 */
		public void setUnitPriceChildEdit(float[] unitPriceChildEdit) {
			this.unitPriceChildEdit = unitPriceChildEdit;
		}
		/**
		 * @return the currencyCodeChildEdit
		 */
		public String[] getCurrencyCodeChildEdit() {
			return currencyCodeChildEdit;
		}
		/**
		 * @param currencyCodeChildEdit the currencyCodeChildEdit to set
		 */
		public void setCurrencyCodeChildEdit(String[] currencyCodeChildEdit) {
			this.currencyCodeChildEdit = currencyCodeChildEdit;
		}
		/**
		 * @return the quantityChildEdit
		 */
		public float[] getQuantityChildEdit() {
			return quantityChildEdit;
		}
		/**
		 * @param quantityChildEdit the quantityChildEdit to set
		 */
		public void setQuantityChildEdit(float[] quantityChildEdit) {
			this.quantityChildEdit = quantityChildEdit;
		}
		/**
		 * @return the uomChildEdit
		 */
		public String[] getUomChildEdit() {
			return uomChildEdit;
		}
		/**
		 * @param uomChildEdit the uomChildEdit to set
		 */
		public void setUomChildEdit(String[] uomChildEdit) {
			this.uomChildEdit = uomChildEdit;
		}
		/**
		 * @return the lineAmtChildEdit
		 */
		public float[] getLineAmtChildEdit() {
			return lineAmtChildEdit;
		}
		/**
		 * @param lineAmtChildEdit the lineAmtChildEdit to set
		 */
		public void setLineAmtChildEdit(float[] lineAmtChildEdit) {
			this.lineAmtChildEdit = lineAmtChildEdit;
		}
		/**
		 * @return the salesTaxAmtChildEdit
		 */
		public float[] getSalesTaxAmtChildEdit() {
			return salesTaxAmtChildEdit;
		}
		/**
		 * @param salesTaxAmtChildEdit the salesTaxAmtChildEdit to set
		 */
		public void setSalesTaxAmtChildEdit(float[] salesTaxAmtChildEdit) {
			this.salesTaxAmtChildEdit = salesTaxAmtChildEdit;
		}
		/**
		 * @return the vatTaxAmtChildEdit
		 */
		public float[] getVatTaxAmtChildEdit() {
			return vatTaxAmtChildEdit;
		}
		/**
		 * @param vatTaxAmtChildEdit the vatTaxAmtChildEdit to set
		 */
		public void setVatTaxAmtChildEdit(float[] vatTaxAmtChildEdit) {
			this.vatTaxAmtChildEdit = vatTaxAmtChildEdit;
		}
		/**
		 * @return the exciseAmtChildEdit
		 */
		public float[] getExciseAmtChildEdit() {
			return exciseAmtChildEdit;
		}
		/**
		 * @param exciseAmtChildEdit the exciseAmtChildEdit to set
		 */
		public void setExciseAmtChildEdit(float[] exciseAmtChildEdit) {
			this.exciseAmtChildEdit = exciseAmtChildEdit;
		}
		/**
		 * @return the frieghtChargesChildEdit
		 */
		public float[] getFrieghtChargesChildEdit() {
			return frieghtChargesChildEdit;
		}
		/**
		 * @param frieghtChargesChildEdit the frieghtChargesChildEdit to set
		 */
		public void setFrieghtChargesChildEdit(float[] frieghtChargesChildEdit) {
			this.frieghtChargesChildEdit = frieghtChargesChildEdit;
		}
		/**
		 * @return the pnfChargesChildEdit
		 */
		public float[] getPnfChargesChildEdit() {
			return pnfChargesChildEdit;
		}
		/**
		 * @param pnfChargesChildEdit the pnfChargesChildEdit to set
		 */
		public void setPnfChargesChildEdit(float[] pnfChargesChildEdit) {
			this.pnfChargesChildEdit = pnfChargesChildEdit;
		}
		/**
		 * @return the dueDateChildEdit
		 */
		public String[] getDueDateChildEdit() {
			return dueDateChildEdit;
		}
		/**
		 * @param dueDateChildEdit the dueDateChildEdit to set
		 */
		public void setDueDateChildEdit(String[] dueDateChildEdit) {
			this.dueDateChildEdit = dueDateChildEdit;
		}
		/**
		 * @return the createdByChildEdit
		 */
		public String[] getCreatedByChildEdit() {
			return createdByChildEdit;
		}
		/**
		 * @param createdByChildEdit the createdByChildEdit to set
		 */
		public void setCreatedByChildEdit(String[] createdByChildEdit) {
			this.createdByChildEdit = createdByChildEdit;
		}
		/**
		 * @return the createdDateTimeChildEdit
		 */
		public String[] getCreatedDateTimeChildEdit() {
			return createdDateTimeChildEdit;
		}
		/**
		 * @param createdDateTimeChildEdit the createdDateTimeChildEdit to set
		 */
		public void setCreatedDateTimeChildEdit(String[] createdDateTimeChildEdit) {
			this.createdDateTimeChildEdit = createdDateTimeChildEdit;
		}
		/**
		 * @return the modifiedByChildEdit
		 */
		public String[] getModifiedByChildEdit() {
			return modifiedByChildEdit;
		}
		/**
		 * @param modifiedByChildEdit the modifiedByChildEdit to set
		 */
		public void setModifiedByChildEdit(String[] modifiedByChildEdit) {
			this.modifiedByChildEdit = modifiedByChildEdit;
		}
		/**
		 * @return the modifiedDateTimeChildEdit
		 */
		public String[] getModifiedDateTimeChildEdit() {
			return modifiedDateTimeChildEdit;
		}
		/**
		 * @param modifiedDateTimeChildEdit the modifiedDateTimeChildEdit to set
		 */
		public void setModifiedDateTimeChildEdit(String[] modifiedDateTimeChildEdit) {
			this.modifiedDateTimeChildEdit = modifiedDateTimeChildEdit;
		}
		/**
		 * @return the materialNameChildEdit
		 */
		public String[] getMaterialNameChildEdit() {
			return materialNameChildEdit;
		}
		/**
		 * @param materialNameChildEdit the materialNameChildEdit to set
		 */
		public void setMaterialNameChildEdit(String[] materialNameChildEdit) {
			this.materialNameChildEdit = materialNameChildEdit;
		}
		/**
		 * @return the uomNameChildEdit
		 */
		public String[] getUomNameChildEdit() {
			return uomNameChildEdit;
		}
		/**
		 * @param uomNameChildEdit the uomNameChildEdit to set
		 */
		public void setUomNameChildEdit(String[] uomNameChildEdit) {
			this.uomNameChildEdit = uomNameChildEdit;
		}
		/**
		 * @return the currencyNameChildEdit
		 */
		public String[] getCurrencyNameChildEdit() {
			return currencyNameChildEdit;
		}
		/**
		 * @param currencyNameChildEdit the currencyNameChildEdit to set
		 */
		public void setCurrencyNameChildEdit(String[] currencyNameChildEdit) {
			this.currencyNameChildEdit = currencyNameChildEdit;
		}
		public String getUomChildL() {
			return uomChildL;
		}
		public void setUomChildL(String uomChildL) {
			this.uomChildL = uomChildL;
		}
		public String getCurrencyCodeChildL() {
			return currencyCodeChildL;
		}
		public void setCurrencyCodeChildL(String currencyCodeChildL) {
			this.currencyCodeChildL = currencyCodeChildL;
		}
		public String getMaterialIdChildL() {
			return materialIdChildL;
		}
		public void setMaterialIdChildL(String materialIdChildL) {
			this.materialIdChildL = materialIdChildL;
		}
		public String getCurrencyCodeNameChild() {
			return currencyCodeNameChild;
		}
		public void setCurrencyCodeNameChild(String currencyCodeNameChild) {
			this.currencyCodeNameChild = currencyCodeNameChild;
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
		
		/**
		 * @return the uomChildLEdit
		 */
		public String getUomChildLEdit() {
			return uomChildLEdit;
		}
		/**
		 * @param uomChildLEdit the uomChildLEdit to set
		 */
		public void setUomChildLEdit(String uomChildLEdit) {
			this.uomChildLEdit = uomChildLEdit;
		}
		/**
		 * @return the currencyCodeChildLEdit
		 */
		public String getCurrencyCodeChildLEdit() {
			return currencyCodeChildLEdit;
		}
		/**
		 * @param currencyCodeChildLEdit the currencyCodeChildLEdit to set
		 */
		public void setCurrencyCodeChildLEdit(String currencyCodeChildLEdit) {
			this.currencyCodeChildLEdit = currencyCodeChildLEdit;
		}
		/**
		 * @return the materialIdChildLEdit
		 */
		public String getMaterialIdChildLEdit() {
			return materialIdChildLEdit;
		}
		/**
		 * @param materialIdChildLEdit the materialIdChildLEdit to set
		 */
		public void setMaterialIdChildLEdit(String materialIdChildLEdit) {
			this.materialIdChildLEdit = materialIdChildLEdit;
		}
		/**
		 * @return the currencyCodeNameChildEdit
		 */
		public String getCurrencyCodeNameChildEdit() {
			return currencyCodeNameChildEdit;
		}
		/**
		 * @param currencyCodeNameChildEdit the currencyCodeNameChildEdit to set
		 */
		public void setCurrencyCodeNameChildEdit(String currencyCodeNameChildEdit) {
			this.currencyCodeNameChildEdit = currencyCodeNameChildEdit;
		}
		/**
		 * @return the purchaseAddDuplicate
		 */
		public int getPurchaseAddDuplicate() {
			return purchaseAddDuplicate;
		}
		/**
		 * @param purchaseAddDuplicate the purchaseAddDuplicate to set
		 */
		public void setPurchaseAddDuplicate(int purchaseAddDuplicate) {
			this.purchaseAddDuplicate = purchaseAddDuplicate;
		}
		/**
		 * @return the purchaseAddDuplicateEdit
		 */
		public int getPurchaseAddDuplicateEdit() {
			return purchaseAddDuplicateEdit;
		}
		/**
		 * @param purchaseAddDuplicateEdit the purchaseAddDuplicateEdit to set
		 */
		public void setPurchaseAddDuplicateEdit(int purchaseAddDuplicateEdit) {
			this.purchaseAddDuplicateEdit = purchaseAddDuplicateEdit;
		}
		/**
		 * @return the paymentDetails
		 */
		public PaymentTerms getPaymentDetails() {
			return paymentDetails;
		}
		/**
		 * @param paymentDetails the paymentDetails to set
		 */
		public void setPaymentDetails(PaymentTerms paymentDetails) {
			this.paymentDetails = paymentDetails;
		}
		public int getAdvanceSearchHidden() {
			return advanceSearchHidden;
		}
		public void setAdvanceSearchHidden(int advanceSearchHidden) {
			this.advanceSearchHidden = advanceSearchHidden;
		}
		public String getXmlLabelBasic() {
			return xmlLabelBasic;
		}
		public void setXmlLabelBasic(String xmlLabelBasic) {
			this.xmlLabelBasic = xmlLabelBasic;
		}
		public String getPurchaseGroupId() {
			return purchaseGroupId;
		}
		public void setPurchaseGroupId(String purchaseGroupId) {
			this.purchaseGroupId = purchaseGroupId;
		}
		public String getPurchaseGroupIdEdit() {
			return purchaseGroupIdEdit;
		}
		public void setPurchaseGroupIdEdit(String purchaseGroupIdEdit) {
			this.purchaseGroupIdEdit = purchaseGroupIdEdit;
		}
		
		

	
}
