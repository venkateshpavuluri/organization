/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Kiran 
 * @version 1.0
 * @build 0.0
 *
 */
public class PurchaseOrderLine
{
	  /*============================Properties=========================*/
		private int purchaseOrderLineId;
		private int purchaseOrderId;
		private int lineNumber;
		private String materialId;
		private float unitPrice;
		private String currencyCode;
		private float quantity;
		private String uom;
		private float lineAmt;
		private float salesTaxAmt;
		private float vatTaxAmt;
		private float exciseAmt;
		private float frieghtCharges;
		private float pnfCharges;
		private String dueDate;
		private String createdBy;
		private String createdDateTime;
		private String modifiedBy;
		private String modifiedDateTime;
		private Currency currencyDetails;
		private String currencyName;
		
		
		
		
		

		/*WorkFlow Properties*/
	private Material materialDetails;
	private Uom uomDetails;
	private String materialName;
	private String uomName;	

	
	  /*============================Getters=========================*/
	
		public int getPurchaseOrderLineId() {
			return purchaseOrderLineId;
		}
		public int getPurchaseOrderId() {
			return purchaseOrderId;
		}
		public int getLineNumber() {
			return lineNumber;
		}
		public String getMaterialId() {
			return materialId;
		}
		public float getUnitPrice() {
			return unitPrice;
		}
		public String getCurrencyCode() {
			return currencyCode;
		}
		public float getQuantity() {
			return quantity;
		}
		public String getUom() {
			return uom;
		}
		public float getLineAmt() {
			return lineAmt;
		}
		public float getSalesTaxAmt() {
			return salesTaxAmt;
		}
		public float getVatTaxAmt() {
			return vatTaxAmt;
		}
		public float getExciseAmt() {
			return exciseAmt;
		}
		public float getFrieghtCharges() {
			return frieghtCharges;
		}
		public float getPnfCharges() {
			return pnfCharges;
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
	 /*============================Setters=========================*/
		
		public void setPurchaseOrderLineId(int purchaseOrderLineId) {
			this.purchaseOrderLineId = purchaseOrderLineId;
		}
		public void setPurchaseOrderId(int purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
		}
		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}
		public void setMaterialId(String materialId) {
			this.materialId = materialId;
		}
		public void setUnitPrice(float unitPrice) {
			this.unitPrice = unitPrice;
		}
		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
		public void setQuantity(float quantity) {
			this.quantity = quantity;
		}
		public void setUom(String uom) {
			this.uom = uom;
		}
		public void setLineAmt(float lineAmt) {
			this.lineAmt = lineAmt;
		}
		public void setSalesTaxAmt(float salesTaxAmt) {
			this.salesTaxAmt = salesTaxAmt;
		}
		public void setVatTaxAmt(float vatTaxAmt) {
			this.vatTaxAmt = vatTaxAmt;
		}
		public void setExciseAmt(float exciseAmt) {
			this.exciseAmt = exciseAmt;
		}
		public void setFrieghtCharges(float frieghtCharges) {
			this.frieghtCharges = frieghtCharges;
		}		
		public void setPnfCharges(float pnfCharges) {
			this.pnfCharges = pnfCharges;
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
		 * @return the materialDetails
		 */
		public Material getMaterialDetails() {
			return materialDetails;
		}
		/**
		 * @param materialDetails the materialDetails to set
		 */
		public void setMaterialDetails(Material materialDetails) {
			this.materialDetails = materialDetails;
		}
		/**
		 * @return the uomDetails
		 */
		public Uom getUomDetails() {
			return uomDetails;
		}
		/**
		 * @param uomDetails the uomDetails to set
		 */
		public void setUomDetails(Uom uomDetails) {
			this.uomDetails = uomDetails;
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
		
		
}
