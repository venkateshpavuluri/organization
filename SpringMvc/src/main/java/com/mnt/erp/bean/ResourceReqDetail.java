package com.mnt.erp.bean;

public class ResourceReqDetail {
private int resourceReqDetId;
private int resourceReqId;
private int noOfPositions;
private String jobDescription;
private String requiredDate;
private String priority;
private String statusId;
private String priorityName;
private String rdstatusname;
private String rdstatusId;
private String rdstatusIdEdit;
private Status status;

//Edit properties

public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public String getPriorityName() {
	return priorityName;
}
public void setPriorityName(String priorityName) {
	this.priorityName = priorityName;
}
public String getRdstatusname() {
	return rdstatusname;
}
public void setRdstatusname(String rdstatusname) {
	this.rdstatusname = rdstatusname;
}
private int resourceReqDetIdEdit;
private int resourceReqIdEdit;
private int noOfPositionsEdit;
private String jobDescriptionEdit;
private String requiredDateEdit;
private String priorityEdit;
private String statusIdEdit;


//getter methods


public int getResourceReqDetId() {
	return resourceReqDetId;
}
public int getResourceReqId() {
	return resourceReqId;
}
public int getNoOfPositions() {
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
public String getStatusId() {
	return statusId;
}
public int getResourceReqDetIdEdit() {
	return resourceReqDetIdEdit;
}
public int getResourceReqIdEdit() {
	return resourceReqIdEdit;
}
public int getNoOfPositionsEdit() {
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
public String getStatusIdEdit() {
	return statusIdEdit;
}

//setter methods



public void setResourceReqDetId(int resourceReqDetId) {
	this.resourceReqDetId = resourceReqDetId;
}
public void setResourceReqId(int resourceReqId) {
	this.resourceReqId = resourceReqId;
}
public void setNoOfPositions(int noOfPositions) {
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
public void setStatusId(String statusId) {
	this.statusId = statusId;
}
public void setResourceReqDetIdEdit(int resourceReqDetIdEdit) {
	this.resourceReqDetIdEdit = resourceReqDetIdEdit;
}
public void setResourceReqIdEdit(int resourceReqIdEdit) {
	this.resourceReqIdEdit = resourceReqIdEdit;
}
public void setNoOfPositionsEdit(int noOfPositionsEdit) {
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
public void setStatusIdEdit(String statusIdEdit) {
	this.statusIdEdit = statusIdEdit;
}
public String getRdstatusId() {
	return rdstatusId;
}
public void setRdstatusId(String rdstatusId) {
	this.rdstatusId = rdstatusId;
}
public String getRdstatusIdEdit() {
	return rdstatusIdEdit;
}
public void setRdstatusIdEdit(String rdstatusIdEdit) {
	this.rdstatusIdEdit = rdstatusIdEdit;
}








}
