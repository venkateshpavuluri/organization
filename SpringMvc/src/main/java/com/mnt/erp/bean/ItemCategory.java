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
public class ItemCategory 
{
	/*==========================Bean Properties===========================*/
		private int itemCategoryId;
		private String itemCategory;
		private int aid;
	
	/*==========================Edit Properties===========================*/
		private int itemCategoryIdEditt;
		private String itemCategoryEditt;
		
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
		public int getItemCategoryId()
		{
			return itemCategoryId;
		}
		public String getItemCategory()
		{
			return itemCategory;
		}
		public int getAid()
		{
			return aid;
		}
		public int getItemCategoryIdEditt()
		{
			return itemCategoryIdEditt;
		}
		public String getItemCategoryEditt()
		{
			return itemCategoryEditt;
		}
	
	/*==========================Setter Methods===========================*/
	
		public void setItemCategoryId(int itemCategoryId)
		{
			this.itemCategoryId = itemCategoryId;
		}
		public void setItemCategory(String itemCategory)
		{
			this.itemCategory = itemCategory;
		}
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setItemCategoryIdEditt(int itemCategoryIdEditt)
		{
			this.itemCategoryIdEditt = itemCategoryIdEditt;
		}
		public void setItemCategoryEditt(String itemCategoryEditt)
		{
			this.itemCategoryEditt = itemCategoryEditt;
		}
		
	
}
