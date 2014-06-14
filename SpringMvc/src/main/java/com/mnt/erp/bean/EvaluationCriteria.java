package com.mnt.erp.bean;

import java.util.List;

public class EvaluationCriteria {
private int evaluationCriteriaId;
private String evaluationCriteria;
private String weightingFactor;
private int aid;
private int[] eveCriteriaEditt;

//Edit properties
private int evaluationCriteriaIdEdit;
private String evaluationCriteriaEdit;
private String weightingFactorEdit;

//child properties
private List<EvaluationSubCriteria> evaluationSubCriterias;

private int evaluationSubCriteriaId;
private String evaluationSubCriteria;
private String score;


// edit variables
private int evaluationSubCriteriaIdEdit;
private String evaluationSubCriteriaEdit;
private String scoreEdit;
//basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;
public int getEvaluationCriteriaId() {
	return evaluationCriteriaId;
}
public void setEvaluationCriteriaId(int evaluationCriteriaId) {
	this.evaluationCriteriaId = evaluationCriteriaId;
}
public String getEvaluationCriteria() {
	return evaluationCriteria;
}
public void setEvaluationCriteria(String evaluationCriteria) {
	this.evaluationCriteria = evaluationCriteria;
}
public String getWeightingFactor() {
	return weightingFactor;
}
public void setWeightingFactor(String weightingFactor) {
	this.weightingFactor = weightingFactor;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public int getEvaluationCriteriaIdEdit() {
	return evaluationCriteriaIdEdit;
}
public void setEvaluationCriteriaIdEdit(int evaluationCriteriaIdEdit) {
	this.evaluationCriteriaIdEdit = evaluationCriteriaIdEdit;
}
public String getEvaluationCriteriaEdit() {
	return evaluationCriteriaEdit;
}
public void setEvaluationCriteriaEdit(String evaluationCriteriaEdit) {
	this.evaluationCriteriaEdit = evaluationCriteriaEdit;
}
public String getWeightingFactorEdit() {
	return weightingFactorEdit;
}
public void setWeightingFactorEdit(String weightingFactorEdit) {
	this.weightingFactorEdit = weightingFactorEdit;
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
public List<EvaluationSubCriteria> getEvaluationSubCriterias() {
	return evaluationSubCriterias;
}
public void setEvaluationSubCriterias(
		List<EvaluationSubCriteria> evaluationSubCriterias) {
	this.evaluationSubCriterias = evaluationSubCriterias;
}
public int getEvaluationSubCriteriaId() {
	return evaluationSubCriteriaId;
}
public void setEvaluationSubCriteriaId(int evaluationSubCriteriaId) {
	this.evaluationSubCriteriaId = evaluationSubCriteriaId;
}
public String getEvaluationSubCriteria() {
	return evaluationSubCriteria;
}
public void setEvaluationSubCriteria(String evaluationSubCriteria) {
	this.evaluationSubCriteria = evaluationSubCriteria;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public int getEvaluationSubCriteriaIdEdit() {
	return evaluationSubCriteriaIdEdit;
}
public void setEvaluationSubCriteriaIdEdit(int evaluationSubCriteriaIdEdit) {
	this.evaluationSubCriteriaIdEdit = evaluationSubCriteriaIdEdit;
}
public String getEvaluationSubCriteriaEdit() {
	return evaluationSubCriteriaEdit;
}
public void setEvaluationSubCriteriaEdit(String evaluationSubCriteriaEdit) {
	this.evaluationSubCriteriaEdit = evaluationSubCriteriaEdit;
}
public String getScoreEdit() {
	return scoreEdit;
}
public void setScoreEdit(String scoreEdit) {
	this.scoreEdit = scoreEdit;
}
public int[] getEveCriteriaEditt() {
	return eveCriteriaEditt;
}
public void setEveCriteriaEditt(int[] eveCriteriaEditt) {
	this.eveCriteriaEditt = eveCriteriaEditt;
}


}
