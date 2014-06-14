/**
 * 
 */
package com.mnt.erp.bean;

import java.util.Set;

/**
 * @author A Nikesh
 *
 */
public class WFStep {
	private String wfstepid;
	private String wfstepStageGUID;
	private String wfstageName;
	private String wfstepStep;
	private String wfstepName;
	private String wfstepNameSearch;
	private String wfstepType;
	private String wfstepStatus;
	private String wfstepAssignedTo;
	private String role;
	private String wfstepCreatedBy;
	private String wfstepCreatedDate;
	private String wfstepUpdatedBy;
	private String wfstepUpdatedDate;
	private int aid;
	private WFStage wfstage;
	private Role rolebean;

	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	//-------------------- advance search ----------
		private String firstLabel;
		private String secondLabel;
		private String operations1;
		private String advanceSearchText;
		private int advanceSearchHidden;
		
	
	private String wfstepidEdit;
	private String wfstepStageGUIDEdit;
	
	private String wfstepStepEdit;
	private String wfstepNameEdit;
	private String wfstepTypeEdit;
	private String wfstepStatusEdit;
	private String wfstepAssignedToEdit;
	private String wfstepCreatedByEdit;
	private String wfstepCreatedDateEdit;
	
	
	private Set<WFAction> wfActionDetailski;
	
	
	
	
	public Set<WFAction> getWfActionDetailski() {
		return wfActionDetailski;
	}
	public void setWfActionDetailski(Set<WFAction> wfActionDetailski) {
		this.wfActionDetailski = wfActionDetailski;
	}
	
	
	
	public String getWfstepid() {
		return wfstepid;
	}
	public void setWfstepid(String wfstepid) {
		this.wfstepid = wfstepid;
	}
	
	
	public String getWfstepStageGUID() {
		return wfstepStageGUID;
	}
	public void setWfstepStageGUID(String wfstepStageGUID) {
		this.wfstepStageGUID = wfstepStageGUID;
	}
	public String getWfstageName() {
		return wfstageName;
	}
	public void setWfstageName(String wfstageName) {
		this.wfstageName = wfstageName;
	}
	
	public String getWfstepStep() {
		return wfstepStep;
	}
	public void setWfstepStep(String wfstepStep) {
		this.wfstepStep = wfstepStep;
	}
	public String getWfstepName() {
		return wfstepName;
	}
	public void setWfstepStatus(String wfstepStatus) {
		this.wfstepStatus = wfstepStatus;
	}
	public void setWfstepStepEdit(String wfstepStepEdit) {
		this.wfstepStepEdit = wfstepStepEdit;
	}
	public void setWfstepStatusEdit(String wfstepStatusEdit) {
		this.wfstepStatusEdit = wfstepStatusEdit;
	}
	public void setWfstepName(String wfstepName) {
		this.wfstepName = wfstepName;
	}
	
	public String getWfstepNameSearch() {
		return wfstepNameSearch;
	}
	public void setWfstepNameSearch(String wfstepNameSearch) {
		this.wfstepNameSearch = wfstepNameSearch;
	}
	public String getWfstepType() {
		return wfstepType;
	}
	public void setWfstepType(String wfstepType) {
		this.wfstepType = wfstepType;
	}
	
	
	public String getWfstepStatus() {
		return wfstepStatus;
	}
	public String getWfstepAssignedTo() {
		return wfstepAssignedTo;
	}
	public void setWfstepAssignedTo(String wfstepAssignedTo) {
		this.wfstepAssignedTo = wfstepAssignedTo;
	}
	public String getWfstepCreatedBy() {
		return wfstepCreatedBy;
	}
	public void setWfstepCreatedBy(String wfstepCreatedBy) {
		this.wfstepCreatedBy = wfstepCreatedBy;
	}
	public String getWfstepCreatedDate() {
		return wfstepCreatedDate;
	}
	public void setWfstepCreatedDate(String wfstepCreatedDate) {
		this.wfstepCreatedDate = wfstepCreatedDate;
	}
	public String getWfstepUpdatedBy() {
		return wfstepUpdatedBy;
	}
	public void setWfstepUpdatedBy(String wfstepUpdatedBy) {
		this.wfstepUpdatedBy = wfstepUpdatedBy;
	}
	public String getWfstepUpdatedDate() {
		return wfstepUpdatedDate;
	}
	public void setWfstepUpdatedDate(String wfstepUpdatedDate) {
		this.wfstepUpdatedDate = wfstepUpdatedDate;
	}

	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public WFStage getWfstage() {
		return wfstage;
	}
	public void setWfstage(WFStage wfstage) {
		this.wfstage = wfstage;
	}
	
	public Role getRolebean() {
		return rolebean;
	}
	public void setRolebean(Role rolebean) {
		this.rolebean = rolebean;
	}
	
	
	
	//================edit=============//
	
	
	
	
	
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
	public String getWfstepidEdit() {
		return wfstepidEdit;
	}
	public void setWfstepidEdit(String wfstepidEdit) {
		this.wfstepidEdit = wfstepidEdit;
	}
	public String getWfstepStageGUIDEdit() {
		return wfstepStageGUIDEdit;
	}
	public void setWfstepStageGUIDEdit(String wfstepStageGUIDEdit) {
		this.wfstepStageGUIDEdit = wfstepStageGUIDEdit;
	}
	
	public String getWfstepStepEdit() {
		return wfstepStepEdit;
	}
	public String getWfstepNameEdit() {
		return wfstepNameEdit;
	}
	public void setWfstepNameEdit(String wfstepNameEdit) {
		this.wfstepNameEdit = wfstepNameEdit;
	}
	public String getWfstepTypeEdit() {
		return wfstepTypeEdit;
	}
	public void setWfstepTypeEdit(String wfstepTypeEdit) {
		this.wfstepTypeEdit = wfstepTypeEdit;
	}
	
	public String getWfstepStatusEdit() {
		return wfstepStatusEdit;
	}
	public String getWfstepAssignedToEdit() {
		return wfstepAssignedToEdit;
	}
	public void setWfstepAssignedToEdit(String wfstepAssignedToEdit) {
		this.wfstepAssignedToEdit = wfstepAssignedToEdit;
	}
	
	
	public String getWfstepCreatedByEdit() {
		return wfstepCreatedByEdit;
	}
	public void setWfstepCreatedByEdit(String wfstepCreatedByEdit) {
		this.wfstepCreatedByEdit = wfstepCreatedByEdit;
	}
	public String getWfstepCreatedDateEdit() {
		return wfstepCreatedDateEdit;
	}
	public void setWfstepCreatedDateEdit(String wfstepCreatedDateEdit) {
		this.wfstepCreatedDateEdit = wfstepCreatedDateEdit;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	//==============Advance Search===========
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

	
	
	
	
	

}
