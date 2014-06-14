/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *
 */
public class Department {
	private int departmentId;
	private String department;
	private String departmentSearch;
	private int aid;
	
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	
	private int departmentIdEdit;
	private String departmentEdit;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartmentSearch() {
		return departmentSearch;
	}
	public void setDepartmentSearch(String departmentSearch) {
		this.departmentSearch = departmentSearch;
	}
	public int getDepartmentIdEdit() {
		return departmentIdEdit;
	}
	public void setDepartmentIdEdit(int departmentIdEdit) {
		this.departmentIdEdit = departmentIdEdit;
	}
	public String getDepartmentEdit() {
		return departmentEdit;
	}
	public void setDepartmentEdit(String departmentEdit) {
		this.departmentEdit = departmentEdit;
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
