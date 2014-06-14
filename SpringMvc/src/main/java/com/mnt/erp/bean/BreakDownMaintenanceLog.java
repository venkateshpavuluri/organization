/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author venkateshp
 *
 */
public class BreakDownMaintenanceLog extends BreakDownMaintenanceSpare {
	private int brkdownMaintenaceLogId;
	private String brkdownMaintenaceId;
	private String logNo;
	private String startDt;
	private String endDt;
	private String repairedBy;
	private List<BreakDownMaintenanceSpare> brkDownMtSpare;
	private BreakDownMaintenance brkdwnMiant;
	private String maintenanceName;
	
	private String brDnMaintenaceSpareIdEdit; 
	private String brDnMaintenaceLogIdEdit;
	private String materialIdEdit;
	private String quantityEdit;
	private String uomIdEdit;
	private String materialName;
	private String uomName;
	/*Advance Search*/
    	private String firstLabel;
		private String secondLabel;
		private String operations1;
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
		private String advanceSearchHidden;
		private int aid;
		

		
		
		
		
		
	
		/**
		 * @return the brDnMaintenaceSpareIdEdit
		 */
		public String getBrDnMaintenaceSpareIdEdit() {
			return brDnMaintenaceSpareIdEdit;
		}
		/**
		 * @param brDnMaintenaceSpareIdEdit the brDnMaintenaceSpareIdEdit to set
		 */
		public void setBrDnMaintenaceSpareIdEdit(String brDnMaintenaceSpareIdEdit) {
			this.brDnMaintenaceSpareIdEdit = brDnMaintenaceSpareIdEdit;
		}
		/**
		 * @return the brDnMaintenaceLogIdEdit
		 */
		public String getBrDnMaintenaceLogIdEdit() {
			return brDnMaintenaceLogIdEdit;
		}
		/**
		 * @param brDnMaintenaceLogIdEdit the brDnMaintenaceLogIdEdit to set
		 */
		public void setBrDnMaintenaceLogIdEdit(String brDnMaintenaceLogIdEdit) {
			this.brDnMaintenaceLogIdEdit = brDnMaintenaceLogIdEdit;
		}
		/**
		 * @return the materialIdEdit
		 */
		public String getMaterialIdEdit() {
			return materialIdEdit;
		}
		/**
		 * @param materialIdEdit the materialIdEdit to set
		 */
		public void setMaterialIdEdit(String materialIdEdit) {
			this.materialIdEdit = materialIdEdit;
		}
		/**
		 * @return the quantityEdit
		 */
		public String getQuantityEdit() {
			return quantityEdit;
		}
		/**
		 * @param quantityEdit the quantityEdit to set
		 */
		public void setQuantityEdit(String quantityEdit) {
			this.quantityEdit = quantityEdit;
		}
		/**
		 * @return the uomIdEdit
		 */
		public String getUomIdEdit() {
			return uomIdEdit;
		}
		/**
		 * @param uomIdEdit the uomIdEdit to set
		 */
		public void setUomIdEdit(String uomIdEdit) {
			this.uomIdEdit = uomIdEdit;
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
		 * @return the maintenanceName
		 */
		public String getMaintenanceName() {
			return maintenanceName;
		}
		/**
		 * @param maintenanceName the maintenanceName to set
		 */
		public void setMaintenanceName(String maintenanceName) {
			this.maintenanceName = maintenanceName;
		}
		/**
		 * @return the brkdwnMiant
		 */
		public BreakDownMaintenance getBrkdwnMiant() {
			return brkdwnMiant;
		}
		/**
		 * @param brkdwnMiant the brkdwnMiant to set
		 */
		public void setBrkdwnMiant(BreakDownMaintenance brkdwnMiant) {
			this.brkdwnMiant = brkdwnMiant;
		}
		/**
		 * @return the brkDownMtSpare
		 */
		public List<BreakDownMaintenanceSpare> getBrkDownMtSpare() {
			return brkDownMtSpare;
		}
		/**
		 * @param brkDownMtSpare the brkDownMtSpare to set
		 */
		public void setBrkDownMtSpare(List<BreakDownMaintenanceSpare> brkDownMtSpare) {
			this.brkDownMtSpare = brkDownMtSpare;
		}
		/**
		 * @return the aid
		 */
		public int getAid() {
			return aid;
		}
		/**
		 * @param aid the aid to set
		 */
		public void setAid(int aid) {
			this.aid = aid;
		}
		/**
		 * @return the advanceSearchHidden
		 */
		public String getAdvanceSearchHidden() {
			return advanceSearchHidden;
		}
		/**
		 * @param advanceSearchHidden the advanceSearchHidden to set
		 */
		public void setAdvanceSearchHidden(String advanceSearchHidden) {
			this.advanceSearchHidden = advanceSearchHidden;
		}
		/**
		 * @return the basicSearchId
		 */
		public String getBasicSearchId() {
			return basicSearchId;
		}
		/**
		 * @param basicSearchId the basicSearchId to set
		 */
		public void setBasicSearchId(String basicSearchId) {
			this.basicSearchId = basicSearchId;
		}
		/**
		 * @return the operations
		 */
		public String getOperations() {
			return operations;
		}
		/**
		 * @param operations the operations to set
		 */
		public void setOperations(String operations) {
			this.operations = operations;
		}
		/**
		 * @return the xmlLabel
		 */
		public String getXmlLabel() {
			return xmlLabel;
		}
		/**
		 * @param xmlLabel the xmlLabel to set
		 */
		public void setXmlLabel(String xmlLabel) {
			this.xmlLabel = xmlLabel;
		}
		/**
		 * @return the brkdownMaintenaceLogId
		 */
		public int getBrkdownMaintenaceLogId() {
			return brkdownMaintenaceLogId;
		}
		/**
		 * @param brkdownMaintenaceLogId the brkdownMaintenaceLogId to set
		 */
		public void setBrkdownMaintenaceLogId(int brkdownMaintenaceLogId) {
			this.brkdownMaintenaceLogId = brkdownMaintenaceLogId;
		}
		/**
		 * @return the brkdownMaintenaceId
		 */
		public String getBrkdownMaintenaceId() {
			return brkdownMaintenaceId;
		}
		/**
		 * @param brkdownMaintenaceId the brkdownMaintenaceId to set
		 */
		public void setBrkdownMaintenaceId(String brkdownMaintenaceId) {
			this.brkdownMaintenaceId = brkdownMaintenaceId;
		}
		/**
		 * @return the logNo
		 */
		public String getLogNo() {
			return logNo;
		}
		/**
		 * @param logNo the logNo to set
		 */
		public void setLogNo(String logNo) {
			this.logNo = logNo;
		}
		/**
		 * @return the startDt
		 */
		public String getStartDt() {
			return startDt;
		}
		/**
		 * @param startDt the startDt to set
		 */
		public void setStartDt(String startDt) {
			this.startDt = startDt;
		}
		/**
		 * @return the endDt
		 */
		public String getEndDt() {
			return endDt;
		}
		/**
		 * @param endDt the endDt to set
		 */
		public void setEndDt(String endDt) {
			this.endDt = endDt;
		}
		/**
		 * @return the repairedBy
		 */
		public String getRepairedBy() {
			return repairedBy;
		}
		/**
		 * @param repairedBy the repairedBy to set
		 */
		public void setRepairedBy(String repairedBy) {
			this.repairedBy = repairedBy;
		}
		/**
		 * @return the firstLabel
		 */
		public String getFirstLabel() {
			return firstLabel;
		}
		/**
		 * @param firstLabel the firstLabel to set
		 */
		public void setFirstLabel(String firstLabel) {
			this.firstLabel = firstLabel;
		}
		/**
		 * @return the secondLabel
		 */
		public String getSecondLabel() {
			return secondLabel;
		}
		/**
		 * @param secondLabel the secondLabel to set
		 */
		public void setSecondLabel(String secondLabel) {
			this.secondLabel = secondLabel;
		}
		/**
		 * @return the operations1
		 */
		public String getOperations1() {
			return operations1;
		}
		/**
		 * @param operations1 the operations1 to set
		 */
		public void setOperations1(String operations1) {
			this.operations1 = operations1;
		}
	

	
	
	

}
