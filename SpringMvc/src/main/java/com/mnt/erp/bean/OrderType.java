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
public class OrderType 
{
	/*==========================Bean Properties===========================*/
		private int orderTypeId;
		private String orderType;
		private int aid;
	/*=========================Edit Properties===========================*/	
		private int orderTypeIdEditt;
		private String orderTypeEditt;
	
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

		public int getOrderTypeId()
		{
			return orderTypeId;
		}

		public String getOrderType()
		{
			return orderType;
		}
		public int getAid()
		{
			return aid;
		}
		public int getOrderTypeIdEditt()
		{
			return orderTypeIdEditt;
		}
		public String getOrderTypeEditt()
		{
			return orderTypeEditt;
		}
		
	/*==========================Setter Methods===========================*/	
	
		public void setOrderTypeId(int orderTypeId) 
		{
			this.orderTypeId = orderTypeId;
		}
		public void setOrderType(String orderType)
		{
			this.orderType = orderType;
		}
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setOrderTypeIdEditt(int orderTypeIdEditt)
		{
			this.orderTypeIdEditt = orderTypeIdEditt;
		}
		public void setOrderTypeEditt(String orderTypeEditt)
		{
			this.orderTypeEditt = orderTypeEditt;
		}
		
	
}
