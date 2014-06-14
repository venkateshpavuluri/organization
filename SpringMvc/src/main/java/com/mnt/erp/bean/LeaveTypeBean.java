/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 *
 */
public class LeaveTypeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ltId;
	private int leaveTypeId;
	private String leaveType;
	private int eleaveTypeId;
	private String eleaveType;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	public int getLeaveTypeId() {
		return leaveTypeId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public int getEleaveTypeId() {
		return eleaveTypeId;
	}
	public String getEleaveType() {
		return eleaveType;
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
	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public int getLtId() {
		return ltId;
	}
	public void setLtId(int ltId) {
		this.ltId = ltId;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public void setEleaveTypeId(int eleaveTypeId) {
		this.eleaveTypeId = eleaveTypeId;
	}
	public void setEleaveType(String eleaveType) {
		this.eleaveType = eleaveType;
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
	

}
