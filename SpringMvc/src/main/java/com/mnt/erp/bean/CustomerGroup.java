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
public class CustomerGroup 
{
	
	/*==========================Bean Properties===========================*/
	
		private int custGroupId;
		private String custGroup;
		private int aid;
	/*==========================Edit Properties===========================*/
		private int custGroupIdEditt;
		private String custGroupEditt;
	/*==========================Getter Methods============================*/
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
		public int getAid()
		{
			return aid;
		}
		public int getCustGroupId()
		{
			return custGroupId;
		}
		public int getCustGroupIdEditt()
		{
			return custGroupIdEditt;
		}
		public String getCustGroup()
		{
			return custGroup;
		}
		public String getCustGroupEditt()
		{
			return custGroupEditt;
		}
	/*==========================Setter Methods===========================*/
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setCustGroupId(int custGroupId)
		{
			this.custGroupId = custGroupId;
		}
		public void setCustGroup(String custGroup)
		{
			this.custGroup = custGroup;
		}
		public void setCustGroupIdEditt(int custGroupIdEditt)
		{
			this.custGroupIdEditt = custGroupIdEditt;
		}
		public void setCustGroupEditt(String custGroupEditt)
		{
			this.custGroupEditt = custGroupEditt;
		}
}
