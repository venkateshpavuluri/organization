/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author A Nikesh
 *
 */
public class WFStage {
	
	private String wfstageId;
	private String wfstageProcessGUID;
	private String wfprocessname;
	private String wfstageStage;
	private String wfstageName;
	private String wfstageNameSearch;
	private String wfstageDescription;
	private String wfstageType;
	private String wfstageCreatedBy;
	private String wfstageCreatedDate;
	private String wfstageUpdatedBy;
	private String wfstageUpdatedDate;
	private WFProcess wfprocess;
	int aid;

	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	//-------------------- advance search ----------
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	
	
	private String wfstageIdEdit;
	private String wfstageProcessGUIDEdit;
	private String wfstageStageEdit;
	private String wfstageNameEdit;
	private String wfstageDescriptionEdit;
	private String wfstageTypeEdit;
	private String wfstageCreatedByEdit;
	private String wfstageCreatedDateEdit;
	
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getWfstageId() {
		return wfstageId;
	}
	public void setWfstageId(String wfstageId) {
		this.wfstageId = wfstageId;
	}
	public String getWfstageProcessGUID() {
		return wfstageProcessGUID;
	}
	public void setWfstageProcessGUID(String wfstageProcessGUID) {
		this.wfstageProcessGUID = wfstageProcessGUID;
	}
	
	
	public String getWfprocessname() {
		return wfprocessname;
	}
	public void setWfprocessname(String wfprocessname) {
		this.wfprocessname = wfprocessname;
	}
	
	public String getWfstageStage() {
		return wfstageStage;
	}
	public void setWfstageStage(String wfstageStage) {
		this.wfstageStage = wfstageStage;
	}
	public String getWfstageName() {
		return wfstageName;
	}
	public void setWfstageName(String wfstageName) {
		this.wfstageName = wfstageName;
	}
	
	public String getWfstageNameSearch() {
		return wfstageNameSearch;
	}
	public void setWfstageNameSearch(String wfstageNameSearch) {
		this.wfstageNameSearch = wfstageNameSearch;
	}
	public String getWfstageDescription() {
		return wfstageDescription;
	}
	public void setWfstageDescription(String wfstageDescription) {
		this.wfstageDescription = wfstageDescription;
	}
	public String getWfstageType() {
		return wfstageType;
	}
	public void setWfstageType(String wfstageType) {
		this.wfstageType = wfstageType;
	}
	public String getWfstageCreatedBy() {
		return wfstageCreatedBy;
	}
	public void setWfstageCreatedBy(String wfstageCreatedBy) {
		this.wfstageCreatedBy = wfstageCreatedBy;
	}
	public String getWfstageCreatedDate() {
		return wfstageCreatedDate;
	}
	public void setWfstageCreatedDate(String wfstageCreatedDate) {
		this.wfstageCreatedDate = wfstageCreatedDate;
	}
	public String getWfstageUpdatedBy() {
		return wfstageUpdatedBy;
	}
	public void setWfstageUpdatedBy(String wfstageUpdatedBy) {
		this.wfstageUpdatedBy = wfstageUpdatedBy;
	}
	public String getWfstageUpdatedDate() {
		return wfstageUpdatedDate;
	}
	public void setWfstageUpdatedDate(String wfstageUpdatedDate) {
		this.wfstageUpdatedDate = wfstageUpdatedDate;
	}
	
		
	
	public WFProcess getWfprocess() {
		return wfprocess;
	}
	public void setWfprocess(WFProcess wfprocess) {
		this.wfprocess = wfprocess;
	}
	public String getWfstageIdEdit() {
		return wfstageIdEdit;
	}
	public void setWfstageIdEdit(String wfstageIdEdit) {
		this.wfstageIdEdit = wfstageIdEdit;
	}
	public String getWfstageProcessGUIDEdit() {
		return wfstageProcessGUIDEdit;
	}
	public void setWfstageProcessGUIDEdit(String wfstageProcessGUIDEdit) {
		this.wfstageProcessGUIDEdit = wfstageProcessGUIDEdit;
	}
	
	public String getWfstageStageEdit() {
		return wfstageStageEdit;
	}
	public void setWfstageStageEdit(String wfstageStageEdit) {
		this.wfstageStageEdit = wfstageStageEdit;
	}
	public String getWfstageNameEdit() {
		return wfstageNameEdit;
	}
	public void setWfstageNameEdit(String wfstageNameEdit) {
		this.wfstageNameEdit = wfstageNameEdit;
	}
	public String getWfstageDescriptionEdit() {
		return wfstageDescriptionEdit;
	}
	public void setWfstageDescriptionEdit(String wfstageDescriptionEdit) {
		this.wfstageDescriptionEdit = wfstageDescriptionEdit;
	}
	public String getWfstageTypeEdit() {
		return wfstageTypeEdit;
	}
	public void setWfstageTypeEdit(String wfstageTypeEdit) {
		this.wfstageTypeEdit = wfstageTypeEdit;
	}
	public String getWfstageCreatedByEdit() {
		return wfstageCreatedByEdit;
	}
	public void setWfstageCreatedByEdit(String wfstageCreatedByEdit) {
		this.wfstageCreatedByEdit = wfstageCreatedByEdit;
	}
	public String getWfstageCreatedDateEdit() {
		return wfstageCreatedDateEdit;
	}
	public void setWfstageCreatedDateEdit(String wfstageCreatedDateEdit) {
		this.wfstageCreatedDateEdit = wfstageCreatedDateEdit;
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
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getFirstLabel() {
		return firstLabel;
	}
	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}
	public String getSecondLabel() {
		return secondLabel;
	}
	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}
	public String getOperations1() {
		return operations1;
	}
	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	
	
	
	//======================================================
	
	
	
}
