
/*
@author Parvathi
@version 1.0   
@Date 20-3-2014
*/

package com.mnt.erp.bean;

public class RecruitmentPlanLine {
private int recruitmentPlanLineId;
private String recruitmentPlanId;
private String interviewRoundId;
private String description;
private InterviewRound interviewRound;
private String interviewName;
//Edit properties
private int recruitmentPlanLineIdEdit;
private String recruitmentPlanIdEdit;
private String interviewRoundIdEdit;
private String descriptionEdit;

//setter methods

public void setRecruitmentPlanLineId(int recruitmentPlanLineId) {
	this.recruitmentPlanLineId = recruitmentPlanLineId;
}
public void setRecruitmentPlanId(String recruitmentPlanId) {
	this.recruitmentPlanId = recruitmentPlanId;
}
public void setInterviewRoundId(String interviewRoundId) {
	this.interviewRoundId = interviewRoundId;
}
public void setDescription(String description) {
	this.description = description;
}

public void setRecruitmentPlanIdEdit(String recruitmentPlanIdEdit) {
	this.recruitmentPlanIdEdit = recruitmentPlanIdEdit;
}
public void setInterviewRoundIdEdit(String interviewRoundIdEdit) {
	this.interviewRoundIdEdit = interviewRoundIdEdit;
}
public void setDescriptionEdit(String descriptionEdit) {
	this.descriptionEdit = descriptionEdit;
}

//getter methods
public int getRecruitmentPlanLineId() {
	return recruitmentPlanLineId;
}
public String getRecruitmentPlanId() {
	return recruitmentPlanId;
}
public String getInterviewRoundId() {
	return interviewRoundId;
}
public String getDescription() {
	return description;
}

public int getRecruitmentPlanLineIdEdit() {
	return recruitmentPlanLineIdEdit;
}
public void setRecruitmentPlanLineIdEdit(int recruitmentPlanLineIdEdit) {
	this.recruitmentPlanLineIdEdit = recruitmentPlanLineIdEdit;
}
public String getRecruitmentPlanIdEdit() {
	return recruitmentPlanIdEdit;
}
public String getInterviewRoundIdEdit() {
	return interviewRoundIdEdit;
}
public String getDescriptionEdit() {
	return descriptionEdit;
}
public InterviewRound getInterviewRound() {
	return interviewRound;
}
public void setInterviewRound(InterviewRound interviewRound) {
	this.interviewRound = interviewRound;
}
public String getInterviewName() {
	return interviewName;
}
public void setInterviewName(String interviewName) {
	this.interviewName = interviewName;
}









}
