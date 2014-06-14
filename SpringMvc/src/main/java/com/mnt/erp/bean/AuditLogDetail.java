/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class AuditLogDetail {
	
	private int auditLogDetail_Id;
	private int auditLog_Id;
	private String oldValue;
	private String newValue;
	private int count;
	/**
	 * @return the auditLogDetail_Id
	 */
	public int getAuditLogDetail_Id() {
		return auditLogDetail_Id;
	}
	/**
	 * @param auditLogDetail_Id the auditLogDetail_Id to set
	 */
	public void setAuditLogDetail_Id(int auditLogDetail_Id) {
		this.auditLogDetail_Id = auditLogDetail_Id;
	}
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
	 * @return the oldValue
	 */
	public String getOldValue() {
		return oldValue;
	}
	/**
	 * @param oldValue the oldValue to set
	 */
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 * @return the newValue
	 */
	public String getNewValue() {
		return newValue;
	}
	/**
	 * @param newValue the newValue to set
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
