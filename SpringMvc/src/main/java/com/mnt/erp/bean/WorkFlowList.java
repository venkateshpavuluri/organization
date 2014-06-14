/**

 *@copyright MNTSOFT  

 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author pvenkateswarlu
 *@version 1.0 11-10-2013
 */
public class WorkFlowList implements Serializable {
	private String workFlowListId;
	private String userId;
	private String receivedFrom;
	private String receivedDTTM;
	private String workListId;
	private String workListContext;
	private String workListStatus;
	private String message;
	private String details;
	private String parentWorkListGuid;
	private String actionBy;
	private String actionType;
	private String actionCode;
	private String actionDTTM;
	private String actionComments;
	private String appCode;
	private String step;
	private String action;
	private String createdBy;
	private String createdDateTime;
	private String lastUpdatedBy;
	private String lastUpdatedDateTime;
	private PurchaseReq purchaseReql;
	private WFStep wfActionDetails;
	private Login userDetails;
	private String signature;
	private byte[] sign;
	
	
	
	
	
	
	
	/*VenkyProperties*/
	
	public byte[] getSign() {
		return sign;
	}
	public void setSign(byte[] sign) {
		this.sign = sign;
	}
	private PurchaseOrder purOrderDetails;
	
	
	
	/**
	 * @return the wfActionDetails
	 */
	
	/**
	 * @return the purOrderDetails
	 */
	
	
	public PurchaseOrder getPurOrderDetails() {
		return purOrderDetails;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @param purOrderDetails the purOrderDetails to set
	 */
	public void setPurOrderDetails(PurchaseOrder purOrderDetails) {
		this.purOrderDetails = purOrderDetails;
	}
	/**
	 * @return the userDetails
	 */
	public Login getUserDetails() {
		return userDetails;
	}
	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(Login userDetails) {
		this.userDetails = userDetails;
	}
	/**
	 * @return the purchaseReql
	 */

	/**
	 * @return the wfActionDetails
	 */
	public WFStep getWfActionDetails() {
		return wfActionDetails;
	}

	public PurchaseReq getPurchaseReql() {
		return purchaseReql;
	}
	public void setPurchaseReql(PurchaseReq purchaseReql) {
		this.purchaseReql = purchaseReql;
	}
	/**
	 * @param wfActionDetails the wfActionDetails to set
	 */
	public void setWfActionDetails(WFStep wfActionDetails) {
		this.wfActionDetails = wfActionDetails;
	}
	/**
	 * @param purchaseReql the purchaseReql to set
	 */
	
	/**
	 * @return the workFlowListId
	 */

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
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
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the receivedFrom
	 */
	public String getReceivedFrom() {
		return receivedFrom;
	}
	/**
	 * @param receivedFrom the receivedFrom to set
	 */
	public void setReceivedFrom(String receivedFrom) {
		this.receivedFrom = receivedFrom;
	}
	/**
	 * @return the receivedDTTM
	 */
	public String getReceivedDTTM() {
		return receivedDTTM;
	}
	/**
	 * @param receivedDTTM the receivedDTTM to set
	 */
	public void setReceivedDTTM(String receivedDTTM) {
		this.receivedDTTM = receivedDTTM;
	}
	
	

	/**
	 * @return the workListId
	 */
	public String getWorkListId() {
		return workListId;
	}
	/**
	 * @param workListId the workListId to set
	 */
	public void setWorkListId(String workListId) {
		this.workListId = workListId;
	}
	/**
	 * @return the workListContext
	 */
	public String getWorkListContext() {
		return workListContext;
	}
	/**
	 * @param workListContext the workListContext to set
	 */
	public void setWorkListContext(String workListContext) {
		this.workListContext = workListContext;
	}
	/**
	 * @return the workListStatus
	 */
	public String getWorkListStatus() {
		return workListStatus;
	}
	/**
	 * @param workListStatus the workListStatus to set
	 */
	public void setWorkListStatus(String workListStatus) {
		this.workListStatus = workListStatus;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the parentWorkListGuid
	 */
	public String getParentWorkListGuid() {
		return parentWorkListGuid;
	}
	/**
	 * @param parentWorkListGuid the parentWorkListGuid to set
	 */
	public void setParentWorkListGuid(String parentWorkListGuid) {
		this.parentWorkListGuid = parentWorkListGuid;
	}
	/**
	 * @return the actionBy
	 */
	public String getActionBy() {
		return actionBy;
	}
	/**
	 * @param actionBy the actionBy to set
	 */
	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}
	/**
	 * @return the actionType
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * @param actionType the actionType to set
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return actionCode;
	}
	/**
	 * @param actionCode the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	/**
	 * @return the actionDTTM
	 */
	public String getActionDTTM() {
		return actionDTTM;
	}
	/**
	 * @param actionDTTM the actionDTTM to set
	 */
	public void setActionDTTM(String actionDTTM) {
		this.actionDTTM = actionDTTM;
	}
	/**
	 * @return the actionComments
	 */
	public String getActionComments() {
		return actionComments;
	}
	/**
	 * @param actionComments the actionComments to set
	 */
	public void setActionComments(String actionComments) {
		this.actionComments = actionComments;
	}
	/**
	 * @return the appCode
	 */
	public String getAppCode() {
		return appCode;
	}
	/**
	 * @param appCode the appCode to set
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
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
	 * @return the createdDateTime
	 */
	public String getCreatedDateTime() {
		return createdDateTime;
	}
	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	/**
	 * @return the lastUpdatedDateTime
	 */
	public String getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}
	/**
	 * @param lastUpdatedDateTime the lastUpdatedDateTime to set
	 */
	public void setLastUpdatedDateTime(String lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

}
