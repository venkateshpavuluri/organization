/**
 
 *
 */
package com.mnt.erp.bean;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class TaxCategory
{
	
	/*==========================Bean Properties===========================*/
		private int taxCategoryId;
		private String taxCategory;
		private String taxCategoryCode;
		private int aid;
	/*==========================Edit Properties===========================*/
		private int taxCategoryIdEdit;
		private String taxCategoryEdit;
		private String taxCategoryCodeEdit;
	
	/*==========================Getter Methods===========================*/
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
		
		
		
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
		public int getTaxCategoryId()
		{
			return taxCategoryId;
		}
		public String getTaxCategory()
		{
			return taxCategory;
		}
		public String getTaxCategoryCode()
		{
			return taxCategoryCode;
		}
		public int getAid()
		{
			return aid;
		}
		public int getTaxCategoryIdEdit() 
		{
			return taxCategoryIdEdit;
		}
		public String getTaxCategoryEdit() 
		{
			return taxCategoryEdit;
		}
		public String getTaxCategoryCodeEdit() 
		{
			return taxCategoryCodeEdit;
		}
		
	/*==========================Setter Methods===========================*/
		
		public void setTaxCategoryId(int taxCategoryId)
		{
			this.taxCategoryId = taxCategoryId;
		}
		public void setTaxCategory(String taxCategory) 
		{
			this.taxCategory = taxCategory;
		}
		public void setTaxCategoryCode(String taxCategoryCode)
		{
			this.taxCategoryCode = taxCategoryCode;
		}
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setTaxCategoryIdEdit(int taxCategoryIdEdit)
		{
			this.taxCategoryIdEdit = taxCategoryIdEdit;
		}
		public void setTaxCategoryEdit(String taxCategoryEdit)
		{
			this.taxCategoryEdit = taxCategoryEdit;
		}
		public void setTaxCategoryCodeEdit(String taxCategoryCodeEdit)
		{
			this.taxCategoryCodeEdit = taxCategoryCodeEdit;
		}
		
}
