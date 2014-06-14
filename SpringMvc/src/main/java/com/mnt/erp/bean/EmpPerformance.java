package com.mnt.erp.bean;

import java.util.List;
/**
 * @author Parvathi
 *
 */
public class EmpPerformance {
	private int performanceReviewId;
	private String employeeId;
	private String periodFrom;
	private String periodTo;
	private String statusId;
	private Employee employee;
	private Status status;
	private String empName;
	private String statusName;
	private String kpiName;
	private String comment;
	private String evaluationBy;
	private int aid;
	private int[] empPerEditt;
	private String xmlLabel;
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
	private String operations;
	private String basicSearchId;
	
	//Child properties
	List<EmpPerformanceKPI> empPerformanceKPI;
	private int performanceReviewKPIId;
	private String kPIId;
	private String rating;
	
	//Edit properies
	private int performanceReviewKPIIdEdit;
	private int performanceReviewIdEdit;
	private String kPIIdEdit;
	private String ratingEdit;
	private String commentEdit;
	private String evaluationByEdit;
	public int getPerformanceReviewId() {
		return performanceReviewId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getEvaluationBy() {
		return evaluationBy;
	}
	public void setEvaluationBy(String evaluationBy) {
		this.evaluationBy = evaluationBy;
	}
	public String getCommentEdit() {
		return commentEdit;
	}
	public void setCommentEdit(String commentEdit) {
		this.commentEdit = commentEdit;
	}
	public String getEvaluationByEdit() {
		return evaluationByEdit;
	}
	public void setEvaluationByEdit(String evaluationByEdit) {
		this.evaluationByEdit = evaluationByEdit;
	}
	public void setPerformanceReviewId(int performanceReviewId) {
		this.performanceReviewId = performanceReviewId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPeriodFrom() {
		return periodFrom;
	}
	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}

	public String getPeriodTo() {
		return periodTo;
	}
	public void setPeriodTo(String periodTo) {
		this.periodTo = periodTo;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
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

	public List<EmpPerformanceKPI> getEmpPerformanceKPI() {
		return empPerformanceKPI;
	}
	public void setEmpPerformanceKPI(List<EmpPerformanceKPI> empPerformanceKPI) {
		this.empPerformanceKPI = empPerformanceKPI;
	}
	public int getPerformanceReviewKPIId() {
		return performanceReviewKPIId;
	}
	public void setPerformanceReviewKPIId(int performanceReviewKPIId) {
		this.performanceReviewKPIId = performanceReviewKPIId;
	}
	public String getkPIId() {
		return kPIId;
	}
	public void setkPIId(String kPIId) {
		this.kPIId = kPIId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getPerformanceReviewKPIIdEdit() {
		return performanceReviewKPIIdEdit;
	}
	public void setPerformanceReviewKPIIdEdit(int performanceReviewKPIIdEdit) {
		this.performanceReviewKPIIdEdit = performanceReviewKPIIdEdit;
	}
	
	public int getPerformanceReviewIdEdit() {
		return performanceReviewIdEdit;
	}
	public void setPerformanceReviewIdEdit(int performanceReviewIdEdit) {
		this.performanceReviewIdEdit = performanceReviewIdEdit;
	}
	public String getkPIIdEdit() {
		return kPIIdEdit;
	}
	public void setkPIIdEdit(String kPIIdEdit) {
		this.kPIIdEdit = kPIIdEdit;
	}
	public String getRatingEdit() {
		return ratingEdit;
	}
	public void setRatingEdit(String ratingEdit) {
		this.ratingEdit = ratingEdit;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int[] getEmpPerEditt() {
		return empPerEditt;
	}
	public void setEmpPerEditt(int[] empPerEditt) {
		this.empPerEditt = empPerEditt;
	}
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	
	
}
