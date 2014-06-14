/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author venkateshp
 *
 */
public class PrevMaintenanceSchCatLog extends PrevMaintenanceSchCatLogSpare{
	private int prevMaintenanceSchCatLogId;
	private String prevMaintenanceSchCatId;
	private String maintenanceDT;
	private String maintainedBy;
	private String statusId;
	private Status statusDetails;
	private String prevMtName;
	private String statusName;

	/*Advance Search*/
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String advanceSearchHidden;
	private int aid;
	
	/*Relation Properties*/
	private List<PrevMaintenanceSchCatLogSpare> prevMtSchCatLogSpares;
	private PrevMaintenanceSchCat prevMtSchCats;
	
	
	
	/**
	 * @return the prevMtName
	 */
	public String getPrevMtName() {
		return prevMtName;
	}
	/**
	 * @param prevMtName the prevMtName to set
	 */
	public void setPrevMtName(String prevMtName) {
		this.prevMtName = prevMtName;
	}
	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * @return the statusDetails
	 */
	public Status getStatusDetails() {
		return statusDetails;
	}
	/**
	 * @param statusDetails the statusDetails to set
	 */
	public void setStatusDetails(Status statusDetails) {
		this.statusDetails = statusDetails;
	}
	/**
	 * @return the prevMtSchCatLogSpares
	 */
	public List<PrevMaintenanceSchCatLogSpare> getPrevMtSchCatLogSpares() {
		return prevMtSchCatLogSpares;
	}
	/**
	 * @param prevMtSchCatLogSpares the prevMtSchCatLogSpares to set
	 */
	public void setPrevMtSchCatLogSpares(
			List<PrevMaintenanceSchCatLogSpare> prevMtSchCatLogSpares) {
		this.prevMtSchCatLogSpares = prevMtSchCatLogSpares;
	}
	/**
	 * @return the prevMtSchCats
	 */
	public PrevMaintenanceSchCat getPrevMtSchCats() {
		return prevMtSchCats;
	}
	/**
	 * @param prevMtSchCats the prevMtSchCats to set
	 */
	public void setPrevMtSchCats(PrevMaintenanceSchCat prevMtSchCats) {
		this.prevMtSchCats = prevMtSchCats;
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
	 * @return the prevMaintenanceSchCatLogId
	 */
	public int getPrevMaintenanceSchCatLogId() {
		return prevMaintenanceSchCatLogId;
	}
	/**
	 * @param prevMaintenanceSchCatLogId the prevMaintenanceSchCatLogId to set
	 */
	public void setPrevMaintenanceSchCatLogId(int prevMaintenanceSchCatLogId) {
		this.prevMaintenanceSchCatLogId = prevMaintenanceSchCatLogId;
	}
	/**
	 * @return the prevMaintenanceSchCatId
	 */
	public String getPrevMaintenanceSchCatId() {
		return prevMaintenanceSchCatId;
	}
	/**
	 * @param prevMaintenanceSchCatId the prevMaintenanceSchCatId to set
	 */
	public void setPrevMaintenanceSchCatId(String prevMaintenanceSchCatId) {
		this.prevMaintenanceSchCatId = prevMaintenanceSchCatId;
	}
	/**
	 * @return the maintenanceDT
	 */
	public String getMaintenanceDT() {
		return maintenanceDT;
	}
	/**
	 * @param maintenanceDT the maintenanceDT to set
	 */
	public void setMaintenanceDT(String maintenanceDT) {
		this.maintenanceDT = maintenanceDT;
	}
	/**
	 * @return the maintainedBy
	 */
	public String getMaintainedBy() {
		return maintainedBy;
	}
	/**
	 * @param maintainedBy the maintainedBy to set
	 */
	public void setMaintainedBy(String maintainedBy) {
		this.maintainedBy = maintainedBy;
	}
	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}
	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	
	
	

}
