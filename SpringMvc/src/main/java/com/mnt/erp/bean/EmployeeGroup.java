/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *
 */
public class EmployeeGroup {
	private int employeeGroupId;
	private String employeeGroup;
	private String employeeGroupSearch;
	private int aid;

	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	
	private int employeeGroupIdEdit;
	private String employeeGroupEdit;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public int getEmployeeGroupId() {
		return employeeGroupId;
	}
	public void setEmployeeGroupId(int employeeGroupId) {
		this.employeeGroupId = employeeGroupId;
	}
	public String getEmployeeGroup() {
		return employeeGroup;
	}
	public void setEmployeeGroup(String employeeGroup) {
		this.employeeGroup = employeeGroup;
	}
	public String getEmployeeGroupSearch() {
		return employeeGroupSearch;
	}
	public void setEmployeeGroupSearch(String employeeGroupSearch) {
		this.employeeGroupSearch = employeeGroupSearch;
	}
	public int getEmployeeGroupIdEdit() {
		return employeeGroupIdEdit;
	}
	public void setEmployeeGroupIdEdit(int employeeGroupIdEdit) {
		this.employeeGroupIdEdit = employeeGroupIdEdit;
	}
	public String getEmployeeGroupEdit() {
		return employeeGroupEdit;
	}
	public void setEmployeeGroupEdit(String employeeGroupEdit) {
		this.employeeGroupEdit = employeeGroupEdit;
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
	
	


}
