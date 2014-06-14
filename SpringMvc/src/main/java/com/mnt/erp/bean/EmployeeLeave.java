/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class EmployeeLeave {

	
	private int employeeLeaveId;
	private String employeeId;
	private String leaveTypeId;
	private String reptMgrId;
	private String noOfAvailableCL;
	private String noOfAvailableCFL;
	private String startDate;
	private String sDayPart;
	private String endDate;
	private String eDayPart;
	private int recursiveHalf;
	private String reportingDate;
	private String reason;
	private String mobile;
	private String residence;
	private String otherNo;
	private String createdDate;
	private String createdBy;
	private String updatedDate;
	private String updatedBy;
	private String statusId;
	private String declineReason;
	private String approvedBy;
	private String narration;
	private String emailCCList;
	private String days;
	private String workFlowListId;
	private String step;
	private String comments;
	private String actionNames;
/*Relation Properties*/
	private LeaveTypeBean leaveTypeIdDetails;
	private Employee reptMgrIdDetails;
	private Employee employeeIdDetails;
	private Status status;
	/*Basic Search And Advanced Search*/
	private String xmlLabelBasic;
	private String operations;
	private String basicSearchId;
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the actionNames
	 */
	public String getActionNames() {
		return actionNames;
	}
	/**
	 * @param actionNames the actionNames to set
	 */
	public void setActionNames(String actionNames) {
		this.actionNames = actionNames;
	}
	/**
	 * @return the workFlowListId
	 */
	public String getWorkFlowListId() {
		return workFlowListId;
	}
	/**
	 * @param workFlowListId the workFlowListId to set
	 */
	public void setWorkFlowListId(String workFlowListId) {
		this.workFlowListId = workFlowListId;
	}
	/**
	 * @return the step
	 */
	public String getStep() {
		return step;
	}
	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		this.step = step;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the employeeLeaveId
	 */
	public int getEmployeeLeaveId() {
		return employeeLeaveId;
	}
	/**
	 * @param employeeLeaveId the employeeLeaveId to set
	 */
	public void setEmployeeLeaveId(int employeeLeaveId) {
		this.employeeLeaveId = employeeLeaveId;
	}
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the leaveTypeId
	 */
	public String getLeaveTypeId() {
		return leaveTypeId;
	}
	/**
	 * @param leaveTypeId the leaveTypeId to set
	 */
	public void setLeaveTypeId(String leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	/**
	 * @return the reptMgrId
	 */
	public String getReptMgrId() {
		return reptMgrId;
	}
	/**
	 * @param reptMgrId the reptMgrId to set
	 */
	public void setReptMgrId(String reptMgrId) {
		this.reptMgrId = reptMgrId;
	}
	/**
	 * @return the noOfAvailableCL
	 */
	public String getNoOfAvailableCL() {
		return noOfAvailableCL;
	}
	/**
	 * @param noOfAvailableCL the noOfAvailableCL to set
	 */
	public void setNoOfAvailableCL(String noOfAvailableCL) {
		this.noOfAvailableCL = noOfAvailableCL;
	}
	/**
	 * @return the noOfAvailableCFL
	 */
	public String getNoOfAvailableCFL() {
		return noOfAvailableCFL;
	}
	/**
	 * @param noOfAvailableCFL the noOfAvailableCFL to set
	 */
	public void setNoOfAvailableCFL(String noOfAvailableCFL) {
		this.noOfAvailableCFL = noOfAvailableCFL;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the sDayPart
	 */
	public String getsDayPart() {
		return sDayPart;
	}
	/**
	 * @param sDayPart the sDayPart to set
	 */
	public void setsDayPart(String sDayPart) {
		this.sDayPart = sDayPart;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the eDayPart
	 */
	public String geteDayPart() {
		return eDayPart;
	}
	/**
	 * @param eDayPart the eDayPart to set
	 */
	public void seteDayPart(String eDayPart) {
		this.eDayPart = eDayPart;
	}
	/**
	 * @return the recursiveHalf
	 */
	public int getRecursiveHalf() {
		return recursiveHalf;
	}
	/**
	 * @param recursiveHalf the recursiveHalf to set
	 */
	public void setRecursiveHalf(int recursiveHalf) {
		this.recursiveHalf = recursiveHalf;
	}
	/**
	 * @return the reportingDate
	 */
	public String getReportingDate() {
		return reportingDate;
	}
	/**
	 * @param reportingDate the reportingDate to set
	 */
	public void setReportingDate(String reportingDate) {
		this.reportingDate = reportingDate;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the residence
	 */
	public String getResidence() {
		return residence;
	}
	/**
	 * @param residence the residence to set
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}
	/**
	 * @return the otherNo
	 */
	public String getOtherNo() {
		return otherNo;
	}
	/**
	 * @param otherNo the otherNo to set
	 */
	public void setOtherNo(String otherNo) {
		this.otherNo = otherNo;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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
	/**
	 * @return the declineReason
	 */
	public String getDeclineReason() {
		return declineReason;
	}
	/**
	 * @param declineReason the declineReason to set
	 */
	public void setDeclineReason(String declineReason) {
		this.declineReason = declineReason;
	}
	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}
	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	/**
	 * @return the narration
	 */
	public String getNarration() {
		return narration;
	}
	/**
	 * @param narration the narration to set
	 */
	public void setNarration(String narration) {
		this.narration = narration;
	}
	/**
	 * @return the emailCCList
	 */
	public String getEmailCCList() {
		return emailCCList;
	}
	/**
	 * @param emailCCList the emailCCList to set
	 */
	public void setEmailCCList(String emailCCList) {
		this.emailCCList = emailCCList;
	}
	/**
	 * @return the days
	 */
	public String getDays() {
		return days;
	}
	/**
	 * @param days the days to set
	 */
	public void setDays(String days) {
		this.days = days;
	}
	/**
	 * @return the leaveTypeIdDetails
	 */
	public LeaveTypeBean getLeaveTypeIdDetails() {
		return leaveTypeIdDetails;
	}
	/**
	 * @param leaveTypeIdDetails the leaveTypeIdDetails to set
	 */
	public void setLeaveTypeIdDetails(LeaveTypeBean leaveTypeIdDetails) {
		this.leaveTypeIdDetails = leaveTypeIdDetails;
	}
	/**
	 * @return the reptMgrIdDetails
	 */
	public Employee getReptMgrIdDetails() {
		return reptMgrIdDetails;
	}
	/**
	 * @param reptMgrIdDetails the reptMgrIdDetails to set
	 */
	public void setReptMgrIdDetails(Employee reptMgrIdDetails) {
		this.reptMgrIdDetails = reptMgrIdDetails;
	}
	/**
	 * @return the employeeIdDetails
	 */
	public Employee getEmployeeIdDetails() {
		return employeeIdDetails;
	}
	/**
	 * @param employeeIdDetails the employeeIdDetails to set
	 */
	public void setEmployeeIdDetails(Employee employeeIdDetails) {
		this.employeeIdDetails = employeeIdDetails;
	}
	/**
	 * @return the xmlLabelBasic
	 */
	public String getXmlLabelBasic() {
		return xmlLabelBasic;
	}
	/**
	 * @param xmlLabelBasic the xmlLabelBasic to set
	 */
	public void setXmlLabelBasic(String xmlLabelBasic) {
		this.xmlLabelBasic = xmlLabelBasic;
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
	 * @return the advanceSearchText
	 */
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	/**
	 * @param advanceSearchText the advanceSearchText to set
	 */
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	/**
	 * @return the advanceSearchHidden
	 */
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	/**
	 * @param advanceSearchHidden the advanceSearchHidden to set
	 */
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	
	
	
	
	
}
