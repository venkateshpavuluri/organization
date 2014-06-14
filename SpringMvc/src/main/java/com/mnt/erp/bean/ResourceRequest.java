package com.mnt.erp.bean;

import java.util.List;



public class ResourceRequest {
	private int resourceReqId;
	private String resourceReqDate;
	private String employeeId;
	private String description;
	private String statusId;
	private String empName;
	private String statusName;
	
	//basic search properties
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	//Edit properties

	private int[] resReqEditt;
	public int[] getResReqEditt() {
		return resReqEditt;
	}
	public void setResReqEditt(int[] resReqEditt) {
		this.resReqEditt = resReqEditt;
	}
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	public void setRdstatusname(String rdstatusname) {
		this.rdstatusname = rdstatusname;
	}
	private int resourceReqIdEdit;
	private String resourceReqDateEdit;
	private String employeeIdEdit;
	private String descriptionEdit;
	private String statusIdEdit;
	
	private List<ResourceReqDetail> resourceReqDetail;
	private Employee employee;
	private Status status;
	
	//ResourceReqDetail properties

	private int resourceReqDetId;
	private int[] noOfPositions;
	private String jobDescription;
	private String requiredDate;
	private String priority;
	private String rdstatusId;
	
	
	//ResourceReqDetail Edit properties
	
	private int resourceReqDetIdEdit;
	private int[] noOfPositionsEdit;
	private String jobDescriptionEdit;
	private String requiredDateEdit;
	private String priorityEdit;
	public String getPriorityName() {
		return priorityName;
	}
	public String getRdstatusname() {
		return rdstatusname;
	}
	private String rdstatusIdEdit;
	private String priorityName;
	private String rdstatusname;
	
	
	
	//getter methods
	
	public int getResourceReqId() {
		return resourceReqId;
	}
	public String getResourceReqDate() {
		return resourceReqDate;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public String getDescription() {
		return description;
	}
	public String getStatusId() {
		return statusId;
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
	public int getResourceReqIdEdit() {
		return resourceReqIdEdit;
	}
	public String getResourceReqDateEdit() {
		return resourceReqDateEdit;
	}
	public String getEmployeeIdEdit() {
		return employeeIdEdit;
	}
	public String getDescriptionEdit() {
		return descriptionEdit;
	}
	public String getStatusIdEdit() {
		return statusIdEdit;
	}
	public List<ResourceReqDetail> getResourceReqDetail() {
		return resourceReqDetail;
	}
	public int getResourceReqDetId() {
		return resourceReqDetId;
	}
	public int[] getNoOfPositions() {
		return noOfPositions;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public String getPriority() {
		return priority;
	}
	public String getRdstatusId() {
		return rdstatusId;
	}
	public int getResourceReqDetIdEdit() {
		return resourceReqDetIdEdit;
	}
	public int[] getNoOfPositionsEdit() {
		return noOfPositionsEdit;
	}
	public String getJobDescriptionEdit() {
		return jobDescriptionEdit;
	}
	public String getRequiredDateEdit() {
		return requiredDateEdit;
	}
	public String getPriorityEdit() {
		return priorityEdit;
	}
	public String getRdstatusIdEdit() {
		return rdstatusIdEdit;
	}
	
	
	
	
	//setter methods
	
	
	
	
	
	public void setResourceReqId(int resourceReqId) {
		this.resourceReqId = resourceReqId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setResourceReqDate(String resourceReqDate) {
		this.resourceReqDate = resourceReqDate;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
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
	public void setResourceReqIdEdit(int resourceReqIdEdit) {
		this.resourceReqIdEdit = resourceReqIdEdit;
	}
	public void setResourceReqDateEdit(String resourceReqDateEdit) {
		this.resourceReqDateEdit = resourceReqDateEdit;
	}
	public void setEmployeeIdEdit(String employeeIdEdit) {
		this.employeeIdEdit = employeeIdEdit;
	}
	public void setDescriptionEdit(String descriptionEdit) {
		this.descriptionEdit = descriptionEdit;
	}
	public void setStatusIdEdit(String statusIdEdit) {
		this.statusIdEdit = statusIdEdit;
	}
	public void setResourceReqDetail(List<ResourceReqDetail> resourceReqDetail) {
		this.resourceReqDetail = resourceReqDetail;
	}
	public void setResourceReqDetId(int resourceReqDetId) {
		this.resourceReqDetId = resourceReqDetId;
	}
	public void setNoOfPositions(int[] noOfPositions) {
		this.noOfPositions = noOfPositions;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public void setRdstatusId(String rdstatusId) {
		this.rdstatusId = rdstatusId;
	}
	public void setResourceReqDetIdEdit(int resourceReqDetIdEdit) {
		this.resourceReqDetIdEdit = resourceReqDetIdEdit;
	}
	public void setNoOfPositionsEdit(int[] noOfPositionsEdit) {
		this.noOfPositionsEdit = noOfPositionsEdit;
	}
	public void setJobDescriptionEdit(String jobDescriptionEdit) {
		this.jobDescriptionEdit = jobDescriptionEdit;
	}
	public void setRequiredDateEdit(String requiredDateEdit) {
		this.requiredDateEdit = requiredDateEdit;
	}
	public void setPriorityEdit(String priorityEdit) {
		this.priorityEdit = priorityEdit;
	}
	public void setRdstatusIdEdit(String rdstatusIdEdit) {
		this.rdstatusIdEdit = rdstatusIdEdit;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
