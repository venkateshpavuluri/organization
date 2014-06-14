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
public class RFQType
{
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	/*==========================Bean Properties===========================*/
		private int rfqTypeId;
		private String rfqType;
		private int aid;
	/*==========================Edit Properties===========================*/
		private int rfqTypeIdEditt;
		private String rfqTypeEditt;
	
	/*==========================Getter Methods===========================*/
		
		
		public int getRfqTypeId()
		{
			return rfqTypeId;
		}
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
		public String getRfqType()
		{
			return rfqType;
		}
		public int getAid()
		{
			return aid;
		}
		public int getRfqTypeIdEditt() 
		{
			return rfqTypeIdEditt;
		}
		public String getRfqTypeEditt() 
		{
			return rfqTypeEditt;
		}
	/*==========================Setter Methods===========================*/	
		
		public void setRfqTypeId(int rfqTypeId) 
		{
			this.rfqTypeId = rfqTypeId;
		}
		public void setRfqType(String rfqType)
		{
			this.rfqType = rfqType;
		}
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setRfqTypeIdEditt(int rfqTypeIdEditt)
		{
			this.rfqTypeIdEditt = rfqTypeIdEditt;
		}
		public void setRfqTypeEditt(String rfqTypeEditt) 
		{
			this.rfqTypeEditt = rfqTypeEditt;
		}
	
}
