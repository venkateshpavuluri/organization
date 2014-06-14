/*
@author Parvathi
@version 1.0   
@Date 20-3-2014
*/

package com.mnt.erp.bean;

import java.util.List;

public class RecruitmentPlan {
	private int recruitmentPlanId;
	private String vacancyId;
	private String recruitmentPlanDT;
	private int[] recPlanEditt;
	private InterviewRound interviewRound;
	private String interviewName;
	//Edit properties
	private int recruitmentPlanIdEdit;
	private String vacancyIdEdit;
	private String recruitmentPlanDTEdit;
	
	//Basic search properties
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	private List<RecruitmentPlanLine> recruitmentPlanLine;
	private int recruitmentPlanLineId;
	private String interviewRoundId;
	private String description;
	private Vacancy vacancy;
	private String vacancyNo;
	
	//child edit properties
	
	private int recruitmentPlanLineIdEdit;
	private String interviewRoundIdEdit;
	private String descriptionEdit;
	
	//getter methods
	public int getRecruitmentPlanId() {
		return recruitmentPlanId;
	}
	public String getVacancyId() {
		return vacancyId;
	}
	public String getRecruitmentPlanDT() {
		return recruitmentPlanDT;
	}
	public int getRecruitmentPlanIdEdit() {
		return recruitmentPlanIdEdit;
	}
	public String getVacancyIdEdit() {
		return vacancyIdEdit;
	}
	public String getRecruitmentPlanDTEdit() {
		return recruitmentPlanDTEdit;
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
	public List<RecruitmentPlanLine> getRecruitmentPlanLine() {
		return recruitmentPlanLine;
	}
	public int getRecruitmentPlanLineId() {
		return recruitmentPlanLineId;
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
	public String getInterviewRoundIdEdit() {
		return interviewRoundIdEdit;
	}
	public String getDescriptionEdit() {
		return descriptionEdit;
	}
	
	//setter methods
	
	public void setRecruitmentPlanId(int recruitmentPlanId) {
		this.recruitmentPlanId = recruitmentPlanId;
	}
	public void setVacancyId(String vacancyId) {
		this.vacancyId = vacancyId;
	}
	public void setRecruitmentPlanDT(String recruitmentPlanDT) {
		this.recruitmentPlanDT = recruitmentPlanDT;
	}
	public void setRecruitmentPlanIdEdit(int recruitmentPlanIdEdit) {
		this.recruitmentPlanIdEdit = recruitmentPlanIdEdit;
	}
	public void setVacancyIdEdit(String vacancyIdEdit) {
		this.vacancyIdEdit = vacancyIdEdit;
	}
	public void setRecruitmentPlanDTEdit(String recruitmentPlanDTEdit) {
		this.recruitmentPlanDTEdit = recruitmentPlanDTEdit;
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
	public void setRecruitmentPlanLine(List<RecruitmentPlanLine> recruitmentPlanLine) {
		this.recruitmentPlanLine = recruitmentPlanLine;
	}
	public void setRecruitmentPlanLineId(int recruitmentPlanLineId) {
		this.recruitmentPlanLineId = recruitmentPlanLineId;
	}
	public void setInterviewRoundId(String interviewRoundId) {
		this.interviewRoundId = interviewRoundId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRecruitmentPlanLineIdEdit(int recruitmentPlanLineIdEdit) {
		this.recruitmentPlanLineIdEdit = recruitmentPlanLineIdEdit;
	}
	public void setInterviewRoundIdEdit(String interviewRoundIdEdit) {
		this.interviewRoundIdEdit = interviewRoundIdEdit;
	}
	public void setDescriptionEdit(String descriptionEdit) {
		this.descriptionEdit = descriptionEdit;
	}
	public Vacancy getVacancy() {
		return vacancy;
	}
	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}
	public String getVacancyNo() {
		return vacancyNo;
	}
	public void setVacancyNo(String vacancyNo) {
		this.vacancyNo = vacancyNo;
	}
	public int[] getRecPlanEditt() {
		return recPlanEditt;
	}
	public void setRecPlanEditt(int[] recPlanEditt) {
		this.recPlanEditt = recPlanEditt;
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
