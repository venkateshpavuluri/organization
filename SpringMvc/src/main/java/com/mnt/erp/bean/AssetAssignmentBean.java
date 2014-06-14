package com.mnt.erp.bean;

public class AssetAssignmentBean {
	private int assetasgmntId;
	private String employeeId;
	private String employeename;
	private String assignedon;
	private String returnedon;
	private int assetasgmntIdedit;
	private String employeeIdedit;
	private String assignedonedit;
	private String returnedonedit;
	private String employeenameedit;
	private Employee employeebean;

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeenameedit() {
		return employeenameedit;
	}

	public void setEmployeenameedit(String employeenameedit) {
		this.employeenameedit = employeenameedit;
	}

	public Employee getEmployeebean() {
		return employeebean;
	}

	public void setEmployeebean(Employee employeebean) {
		this.employeebean = employeebean;
	}

	public int getAssetasgmntId() {
		return assetasgmntId;
	}

	public void setAssetasgmntId(int assetasgmntId) {
		this.assetasgmntId = assetasgmntId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAssignedon() {
		return assignedon;
	}

	public void setAssignedon(String assignedon) {
		this.assignedon = assignedon;
	}

	public String getReturnedon() {
		return returnedon;
	}

	public void setReturnedon(String returnedon) {
		this.returnedon = returnedon;
	}

	public int getAssetasgmntIdedit() {
		return assetasgmntIdedit;
	}

	public void setAssetasgmntIdedit(int assetasgmntIdedit) {
		this.assetasgmntIdedit = assetasgmntIdedit;
	}

	public String getEmployeeIdedit() {
		return employeeIdedit;
	}

	public void setEmployeeIdedit(String employeeIdedit) {
		this.employeeIdedit = employeeIdedit;
	}

	public String getAssignedonedit() {
		return assignedonedit;
	}

	public void setAssignedonedit(String assignedonedit) {
		this.assignedonedit = assignedonedit;
	}

	public String getReturnedonedit() {
		return returnedonedit;
	}

	public void setReturnedonedit(String returnedonedit) {
		this.returnedonedit = returnedonedit;
	}

}
