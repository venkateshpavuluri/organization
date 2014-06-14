/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 29-10-2013
 * @build 0.0
 *
 */
public class ReasonForRejection {
	
	/*=============================Bean Properties=======================*/
	   
	  private int reasonForRejectionId;
	  private String reasonForRejection;
	  private int aid;
	  private String xmlLabel;
	  private String operations;
	  private String basicSearchId;
	  
   /*=============================Editt Properties=======================*/
	   
	  private int reasonForRejectionIdEditt;
	  private String reasonForRejectionEditt;
	
  /*=============================Getters==================================*/

	    public int getReasonForRejectionId() {
			return reasonForRejectionId;
		}
		public String getReasonForRejection() {
			return reasonForRejection;
		}
		public int getAid() {
			return aid;
		}
		public String getXmlLabel() {
			return xmlLabel;
		}
		public String getOperations() {
			return operations;
		}
		public String getBasicSearchId() {
			return basicSearchId;
		}
		public int getReasonForRejectionIdEditt() {
			return reasonForRejectionIdEditt;
		}
		public String getReasonForRejectionEditt() {
			return reasonForRejectionEditt;
		}
 /*=======================================Setters==================================*/
		public void setReasonForRejectionId(int reasonForRejectionId) {
			this.reasonForRejectionId = reasonForRejectionId;
		}
		public void setReasonForRejection(String reasonForRejection) {
			this.reasonForRejection = reasonForRejection;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public void setXmlLabel(String xmlLabel) {
			this.xmlLabel = xmlLabel;
		}
		public void setOperations(String operations) {
			this.operations = operations;
		}
		public void setBasicSearchId(String basicSearchId) {
			this.basicSearchId = basicSearchId;
		}
		public void setReasonForRejectionIdEditt(int reasonForRejectionIdEditt) {
			this.reasonForRejectionIdEditt = reasonForRejectionIdEditt;
		}
		public void setReasonForRejectionEditt(String reasonForRejectionEditt) {
			this.reasonForRejectionEditt = reasonForRejectionEditt;
		}
		
		
}
