package com.mnt.erp.bean;
/**
 * @author Parvathi
 *
 */
public class EmpPerformanceKPI {
private int performanceReviewKPIId;
private String performanceReviewId;
private String kPIId;
private String rating;
private String comment;
private String evaluationBy;
private String kpiName;
private Employee employee;
private String empName;
private KPIBean kpibean;

//Edit properies
private int performanceReviewKPIIdEdit;
private String performanceReviewIdEdit;
private String kPIIdEdit;
private String ratingEdit;
private String commentEdit;
private String evaluationByEdit;
public int getPerformanceReviewKPIId() {
	return performanceReviewKPIId;
}
public void setPerformanceReviewKPIId(int performanceReviewKPIId) {
	this.performanceReviewKPIId = performanceReviewKPIId;
}
public String getPerformanceReviewId() {
	return performanceReviewId;
}
public void setPerformanceReviewId(String performanceReviewId) {
	this.performanceReviewId = performanceReviewId;
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
public String getKpiName() {
	return kpiName;
}
public void setKpiName(String kpiName) {
	this.kpiName = kpiName;
}
public int getPerformanceReviewKPIIdEdit() {
	return performanceReviewKPIIdEdit;
}
public void setPerformanceReviewKPIIdEdit(int performanceReviewKPIIdEdit) {
	this.performanceReviewKPIIdEdit = performanceReviewKPIIdEdit;
}
public String getPerformanceReviewIdEdit() {
	return performanceReviewIdEdit;
}
public void setPerformanceReviewIdEdit(String performanceReviewIdEdit) {
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
public KPIBean getKpibean() {
	return kpibean;
}
public void setKpibean(KPIBean kpibean) {
	this.kpibean = kpibean;
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
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
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


}
