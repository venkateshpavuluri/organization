/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0 26-10-2013
 * @build 0.0
 *
 */
public class PurchaseGroup
{
	/*=======================Bean Properties===================*/
	
		private int purchaseGroupId;
		private String purOrg_Id;
		private String purOrg;
		private String purchaseGroup;
		private int aid;
		
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
	/*=======================Edit Properties===================*/
		
		private int purchaseGroupIdEditt;
		private String purOrg_IdEditt;
		private String purchaseGroupEditt;
		private PurchaseOrganization poBean;
		
		public String getPurOrg_IdEditt() {
			return purOrg_IdEditt;
		}
		public void setPurOrg_IdEditt(String purOrg_IdEditt) {
			this.purOrg_IdEditt = purOrg_IdEditt;
		}
		public int getPurchaseGroupId() {
			return purchaseGroupId;
		}
		public void setPurchaseGroupId(int purchaseGroupId) {
			this.purchaseGroupId = purchaseGroupId;
		}
		public String getPurOrg_Id() {
			return purOrg_Id;
		}
		public void setPurOrg_Id(String purOrg_Id) {
			this.purOrg_Id = purOrg_Id;
		}
		public String getPurOrg() {
			return purOrg;
		}
		public void setPurOrg(String purOrg) {
			this.purOrg = purOrg;
		}
		public String getPurchaseGroup() {
			return purchaseGroup;
		}
		public void setPurchaseGroup(String purchaseGroup) {
			this.purchaseGroup = purchaseGroup;
		}
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
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
		public int getPurchaseGroupIdEditt() {
			return purchaseGroupIdEditt;
		}
		public void setPurchaseGroupIdEditt(int purchaseGroupIdEditt) {
			this.purchaseGroupIdEditt = purchaseGroupIdEditt;
		}
		
		public String getPurchaseGroupEditt() {
			return purchaseGroupEditt;
		}
		public void setPurchaseGroupEditt(String purchaseGroupEditt) {
			this.purchaseGroupEditt = purchaseGroupEditt;
		}
		public PurchaseOrganization getPoBean() {
			return poBean;
		}
		public void setPoBean(PurchaseOrganization poBean) {
			this.poBean = poBean;
		}
	
	/*=======================Getters=========================*/
	

		
}
