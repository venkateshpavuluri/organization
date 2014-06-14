/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;
import java.util.Set;

/**
 * @author kirangangone
 *
 */
public class AuditLog {

	private int auditLog_Id;
	private String userId;
	private String operation;
	private String objectChanged;
	private String objectType;
	private String status;
	private String timeStamp;
	private String objectId;
	private String userName;
	
	private int auditLog_IdEdit;
	private String userIdEdit;
	private String operationEdit;
	private String objectChangedEdit;
	private String objectTypeEdit;
	private String statusEdit;
	private String timeStampEdit;
	  private int duplicateMessageAuditLog;
	  private int duplicateMessageAuditLogUpdate;
	  private List<AuditLogDetail> auditLogDetail;
	   private  Set<AuditLogDetail> auditLogDetails;
	  
	  private String xmlLabel;
		private String operations;
		private String basicSearchId;
	/**
	 * @return the auditLog_Id
	 */
	public int getAuditLog_Id() {
		return auditLog_Id;
	}
	/**
	 * @param auditLog_Id the auditLog_Id to set
	 */
	public void setAuditLog_Id(int auditLog_Id) {
		this.auditLog_Id = auditLog_Id;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * @return the objectChanged
	 */
	public String getObjectChanged() {
		return objectChanged;
	}
	/**
	 * @param objectChanged the objectChanged to set
	 */
	public void setObjectChanged(String objectChanged) {
		this.objectChanged = objectChanged;
	}
	/**
	 * @return the objectType
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * @param objectType the objectType to set
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the duplicateMessageAuditLog
	 */
	public int getDuplicateMessageAuditLog() {
		return duplicateMessageAuditLog;
	}
	/**
	 * @param duplicateMessageAuditLog the duplicateMessageAuditLog to set
	 */
	public void setDuplicateMessageAuditLog(int duplicateMessageAuditLog) {
		this.duplicateMessageAuditLog = duplicateMessageAuditLog;
	}
	/**
	 * @return the duplicateMessageAuditLogUpdate
	 */
	public int getDuplicateMessageAuditLogUpdate() {
		return duplicateMessageAuditLogUpdate;
	}
	/**
	 * @param duplicateMessageAuditLogUpdate the duplicateMessageAuditLogUpdate to set
	 */
	public void setDuplicateMessageAuditLogUpdate(int duplicateMessageAuditLogUpdate) {
		this.duplicateMessageAuditLogUpdate = duplicateMessageAuditLogUpdate;
	}
	/**
	 * @return the auditLog_IdEdit
	 */
	public int getAuditLog_IdEdit() {
		return auditLog_IdEdit;
	}
	/**
	 * @param auditLog_IdEdit the auditLog_IdEdit to set
	 */
	public void setAuditLog_IdEdit(int auditLog_IdEdit) {
		this.auditLog_IdEdit = auditLog_IdEdit;
	}
	/**
	 * @return the userIdEdit
	 */
	public String getUserIdEdit() {
		return userIdEdit;
	}
	/**
	 * @param userIdEdit the userIdEdit to set
	 */
	public void setUserIdEdit(String userIdEdit) {
		this.userIdEdit = userIdEdit;
	}
	/**
	 * @return the operationEdit
	 */
	public String getOperationEdit() {
		return operationEdit;
	}
	/**
	 * @param operationEdit the operationEdit to set
	 */
	public void setOperationEdit(String operationEdit) {
		this.operationEdit = operationEdit;
	}
	/**
	 * @return the objectChangedEdit
	 */
	public String getObjectChangedEdit() {
		return objectChangedEdit;
	}
	/**
	 * @param objectChangedEdit the objectChangedEdit to set
	 */
	public void setObjectChangedEdit(String objectChangedEdit) {
		this.objectChangedEdit = objectChangedEdit;
	}
	/**
	 * @return the objectTypeEdit
	 */
	public String getObjectTypeEdit() {
		return objectTypeEdit;
	}
	/**
	 * @param objectTypeEdit the objectTypeEdit to set
	 */
	public void setObjectTypeEdit(String objectTypeEdit) {
		this.objectTypeEdit = objectTypeEdit;
	}
	/**
	 * @return the statusEdit
	 */
	public String getStatusEdit() {
		return statusEdit;
	}
	/**
	 * @param statusEdit the statusEdit to set
	 */
	public void setStatusEdit(String statusEdit) {
		this.statusEdit = statusEdit;
	}
	/**
	 * @return the timeStampEdit
	 */
	public String getTimeStampEdit() {
		return timeStampEdit;
	}
	/**
	 * @param timeStampEdit the timeStampEdit to set
	 */
	public void setTimeStampEdit(String timeStampEdit) {
		this.timeStampEdit = timeStampEdit;
	}
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/**
	 * @return the auditLogDetail
	 */
	public List<AuditLogDetail> getAuditLogDetail() {
		return auditLogDetail;
	}
	/**
	 * @param auditLogDetail the auditLogDetail to set
	 */
	public void setAuditLogDetail(List<AuditLogDetail> auditLogDetail) {
		this.auditLogDetail = auditLogDetail;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<AuditLogDetail> getAuditLogDetails() {
		return auditLogDetails;
	}
	public void setAuditLogDetails(Set<AuditLogDetail> auditLogDetails) {
		this.auditLogDetails = auditLogDetails;
	}
	
	
	
	
	
	
}
