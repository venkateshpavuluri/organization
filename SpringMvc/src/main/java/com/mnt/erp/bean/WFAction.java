/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author A Nikesh
 *
 */
public class WFAction {
	private String wfactionId;
	private String wfactionStepGUID;
	private String wfstepName;
	private String wfactionAction;
	private String wActionId;
	private String wfactionName;
	private String wfactionNameSearch;
	private String wfactionType;
	private String wfactionCondition;
	private String wfactionDirection;
	private String wfactionGotoStep;
	private String wfactionEmail;
	private int wfactionWorkList;
	private String wfactionComments;
	private String wfactionMessage;
	private String wfactionMessageDetails;
	private String wfactionCreatedBy;
	private String wfactionCreateddate;
	private String wfactionUpdatedBy;
	private String wfactionupdateDate;
	private int aid;
	private WFStep wfstep;
	private WAction waction;
	

	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	//-------------------- advance search ----------
		private String firstLabel;
		private String secondLabel;
		private String operations1;
		private String advanceSearchText;
		private int advanceSearchHidden;
		
	private String wActionIdEdit;
	private String wfactionIdEdit;
	private String wfactionStepGUIDEdit;
	private String wfactionActionEdit;
	private String wfactionNameEdit;
	private String wfactionTypeEdit;
	private String wfactionConditionEdit;
	private String wfactionDirectionEdit;
	private String wfactionGotoStepEdit;
	private String wfactionEmailEdit;
	private int wfactionWorkListEdit;
	private String wfactionCommentsEdit;
	private String wfactionMessageEdit;
	private String wfactionMessageDetailsEdit;
	private String wfactionCreatedByEdit;
	private String wfactionCreateddateEdit;
	
	
	
	public String getwActionId() {
		return wActionId;
	}
	public void setwActionId(String wActionId) {
		this.wActionId = wActionId;
	}
	public String getWfactionId() {
		return wfactionId;
	}
	public void setWfactionId(String wfactionId) {
		this.wfactionId = wfactionId;
	}
	public String getWfactionStepGUID() {
		return wfactionStepGUID;
	}
	public void setWfactionStepGUID(String wfactionStepGUID) {
		this.wfactionStepGUID = wfactionStepGUID;
	}
	
	
	public String getWfstepName() {
		return wfstepName;
	}
	public void setWfstepName(String wfstepName) {
		this.wfstepName = wfstepName;
	}
	
	
	public String getWfactionAction() {
		return wfactionAction;
	}
	public void setWfactionAction(String wfactionAction) {
		this.wfactionAction = wfactionAction;
	}
	public String getWfactionNameSearch() {
		return wfactionNameSearch;
	}
	public void setWfactionNameSearch(String wfactionNameSearch) {
		this.wfactionNameSearch = wfactionNameSearch;
	}
	public String getWfactionName() {
		return wfactionName;
	}
	public void setWfactionName(String wfactionName) {
		this.wfactionName = wfactionName;
	}
	public String getWfactionType() {
		return wfactionType;
	}
	public void setWfactionType(String wfactionType) {
		this.wfactionType = wfactionType;
	}
	public String getWfactionCondition() {
		return wfactionCondition;
	}
	public void setWfactionCondition(String wfactionCondition) {
		this.wfactionCondition = wfactionCondition;
	}
	
	
	public String getWfactionDirection() {
		return wfactionDirection;
	}
	public void setWfactionDirection(String wfactionDirection) {
		this.wfactionDirection = wfactionDirection;
	}
	public String getWfactionGotoStep() {
		return wfactionGotoStep;
	}
	
	public void setWfactionGotoStep(String wfactionGotoStep) {
		this.wfactionGotoStep = wfactionGotoStep;
	}
	public String getWfactionEmail() {
		return wfactionEmail;
	}
	public void setWfactionEmail(String wfactionEmail) {
		this.wfactionEmail = wfactionEmail;
	}
	
	public int getWfactionWorkList() {
		return wfactionWorkList;
	}
	public void setWfactionWorkList(int wfactionWorkList) {
		this.wfactionWorkList = wfactionWorkList;
	}
	public String getWfactionComments() {
		return wfactionComments;
	}
	public void setWfactionComments(String wfactionComments) {
		this.wfactionComments = wfactionComments;
	}
	public String getWfactionMessage() {
		return wfactionMessage;
	}
	public void setWfactionMessage(String wfactionMessage) {
		this.wfactionMessage = wfactionMessage;
	}
	public String getWfactionMessageDetails() {
		return wfactionMessageDetails;
	}
	public void setWfactionMessageDetails(String wfactionMessageDetails) {
		this.wfactionMessageDetails = wfactionMessageDetails;
	}
	public String getWfactionCreatedBy() {
		return wfactionCreatedBy;
	}
	public void setWfactionCreatedBy(String wfactionCreatedBy) {
		this.wfactionCreatedBy = wfactionCreatedBy;
	}
	public String getWfactionCreateddate() {
		return wfactionCreateddate;
	}
	public void setWfactionCreateddate(String wfactionCreateddate) {
		this.wfactionCreateddate = wfactionCreateddate;
	}
	public String getWfactionUpdatedBy() {
		return wfactionUpdatedBy;
	}
	public void setWfactionUpdatedBy(String wfactionUpdatedBy) {
		this.wfactionUpdatedBy = wfactionUpdatedBy;
	}
	public String getWfactionupdateDate() {
		return wfactionupdateDate;
	}
	public void setWfactionupdateDate(String wfactionupdateDate) {
		this.wfactionupdateDate = wfactionupdateDate;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public WFStep getWfstep() {
		return wfstep;
	}
	public void setWfstep(WFStep wfstep) {
		this.wfstep = wfstep;
	}
	public String getWfactionIdEdit() {
		return wfactionIdEdit;
	}
	public void setWfactionIdEdit(String wfactionIdEdit) {
		this.wfactionIdEdit = wfactionIdEdit;
	}
	public String getWfactionStepGUIDEdit() {
		return wfactionStepGUIDEdit;
	}
	public void setWfactionStepGUIDEdit(String wfactionStepGUIDEdit) {
		this.wfactionStepGUIDEdit = wfactionStepGUIDEdit;
	}
	
	public String getWfactionActionEdit() {
		return wfactionActionEdit;
	}
	public void setWfactionActionEdit(String wfactionActionEdit) {
		this.wfactionActionEdit = wfactionActionEdit;
	}
	public String getWfactionNameEdit() {
		return wfactionNameEdit;
	}
	public void setWfactionNameEdit(String wfactionNameEdit) {
		this.wfactionNameEdit = wfactionNameEdit;
	}
	public String getWfactionTypeEdit() {
		return wfactionTypeEdit;
	}
	public void setWfactionTypeEdit(String wfactionTypeEdit) {
		this.wfactionTypeEdit = wfactionTypeEdit;
	}
	public String getWfactionConditionEdit() {
		return wfactionConditionEdit;
	}
	public void setWfactionConditionEdit(String wfactionConditionEdit) {
		this.wfactionConditionEdit = wfactionConditionEdit;
	}
	
	public String getWfactionDirectionEdit() {
		return wfactionDirectionEdit;
	}
	public void setWfactionDirectionEdit(String wfactionDirectionEdit) {
		this.wfactionDirectionEdit = wfactionDirectionEdit;
	}
	public String getWfactionGotoStepEdit() {
		return wfactionGotoStepEdit;
	}
	public void setWfactionGotoStepEdit(String wfactionGotoStepEdit) {
		this.wfactionGotoStepEdit = wfactionGotoStepEdit;
	}
	public String getWfactionEmailEdit() {
		return wfactionEmailEdit;
	}
	public void setWfactionEmailEdit(String wfactionEmailEdit) {
		this.wfactionEmailEdit = wfactionEmailEdit;
	}
	public int getWfactionWorkListEdit() {
		return wfactionWorkListEdit;
	}
	public void setWfactionWorkListEdit(int wfactionWorkListEdit) {
		this.wfactionWorkListEdit = wfactionWorkListEdit;
	}
	public String getWfactionCommentsEdit() {
		return wfactionCommentsEdit;
	}
	public void setWfactionCommentsEdit(String wfactionCommentsEdit) {
		this.wfactionCommentsEdit = wfactionCommentsEdit;
	}
	public String getWfactionMessageEdit() {
		return wfactionMessageEdit;
	}
	public void setWfactionMessageEdit(String wfactionMessageEdit) {
		this.wfactionMessageEdit = wfactionMessageEdit;
	}
	public String getWfactionMessageDetailsEdit() {
		return wfactionMessageDetailsEdit;
	}
	public void setWfactionMessageDetailsEdit(String wfactionMessageDetailsEdit) {
		this.wfactionMessageDetailsEdit = wfactionMessageDetailsEdit;
	}
	public String getWfactionCreatedByEdit() {
		return wfactionCreatedByEdit;
	}
	public void setWfactionCreatedByEdit(String wfactionCreatedByEdit) {
		this.wfactionCreatedByEdit = wfactionCreatedByEdit;
	}
	public String getWfactionCreateddateEdit() {
		return wfactionCreateddateEdit;
	}
	public void setWfactionCreateddateEdit(String wfactionCreateddateEdit) {
		this.wfactionCreateddateEdit = wfactionCreateddateEdit;
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
	public String getwActionIdEdit() {
		return wActionIdEdit;
	}
	public void setwActionIdEdit(String wActionIdEdit) {
		this.wActionIdEdit = wActionIdEdit;
	}
	public WAction getWaction() {
		return waction;
	}
	public void setWaction(WAction waction) {
		this.waction = waction;
	}

	
	
	
}
