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
public class PaymentMethod 
{
	
	/*==========================Bean Properties===========================*/
		private int paymentMethodId;
		private String paymentMethodName;
		private int aid;
	
	/*==========================Edit Properties===========================*/
		private int paymentMethodIdEditt;
		private String paymentMethodNameEditt;
	
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
		public int getPaymentMethodId()
		{
			return paymentMethodId;
		}
		public String getPaymentMethodName()
		{
			return paymentMethodName;
		}
		
		public int getPaymentMethodIdEditt()
		{
			return paymentMethodIdEditt;
		}
		public String getPaymentMethodNameEditt()
		{
			return paymentMethodNameEditt;
		}
		public int getAid()
		{
			return aid;
		}
	/*==========================Setter Methods===========================*/	
		public void setPaymentMethodId(int paymentMethodId)
		{
			this.paymentMethodId = paymentMethodId;
		}
		public void setPaymentMethodName(String paymentMethodName)
		{
			this.paymentMethodName = paymentMethodName;
		}
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setPaymentMethodIdEditt(int paymentMethodIdEditt)
		{
			this.paymentMethodIdEditt = paymentMethodIdEditt;
		}
		public void setPaymentMethodNameEditt(String paymentMethodNameEditt) 
		{
			this.paymentMethodNameEditt = paymentMethodNameEditt;
		}
		
	
	

}
