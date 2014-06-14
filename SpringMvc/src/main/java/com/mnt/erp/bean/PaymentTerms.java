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
public class PaymentTerms
{
	
	/*==========================Bean Properties===========================*/
		private int paymentTermId;
		private String paymentTermName;
		private int aid;
	
	/*==========================Edit Properties===========================*/
		private int paymentTermIdEditt;
		private String paymentTermNameEditt;
	
	
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
		public int getPaymentTermId()
		{
			return paymentTermId;
		}
		public String getPaymentTermName() 
		{
			return paymentTermName;
		}
		public int getAid() {
			return aid;
		}
		public int getPaymentTermIdEditt()
		{
			return paymentTermIdEditt;
		}
		public String getPaymentTermNameEditt()
		{
			return paymentTermNameEditt;
		}
	
	
	/*==========================Setter Methods===========================*/
		
		public void setPaymentTermId(int paymentTermId) 
		{
			this.paymentTermId = paymentTermId;
		}
		public void setPaymentTermName(String paymentTermName)
		{
			this.paymentTermName = paymentTermName;
		}
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setPaymentTermIdEditt(int paymentTermIdEditt)
		{
			this.paymentTermIdEditt = paymentTermIdEditt;
		}
		public void setPaymentTermNameEditt(String paymentTermNameEditt) 
		{
			this.paymentTermNameEditt = paymentTermNameEditt;
		}
	
	
}
