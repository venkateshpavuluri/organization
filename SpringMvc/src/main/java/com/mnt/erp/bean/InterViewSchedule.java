/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;


/**
 * @author venkateshp
 * 
 */
public class InterViewSchedule extends InterViewResult {
	private int interviewScheduleId;
	private String vacancyDetailId;
	private String applicantId;
	private String scheduledDate;
	private String scheduledTime;
	private String interviewRoundId;
	private String assignedTo;
	private String venue;
	private String vacancyNo;
	private String empName;
	private String applicanName;
	private String iVRoundName;
	
	private String interviewResultIdEdit;
	private String irApplicantIdEdit;
	private String ratingEdit;
	private String nextRoundEdit;
	private String commentsEdit;
	private String nextRoundNameEdit;
	private String aid;
	

	/*Advance Search*/
	private String firstLabel;
		private String secondLabel;
		private String operations1;
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

/**
		 * @return the firstLabel
		 */
		public String getFirstLabel() {
			return firstLabel;
		}

		/**
		 * @param firstLabel the firstLabel to set
		 */
		public void setFirstLabel(String firstLabel) {
			this.firstLabel = firstLabel;
		}

		/**
		 * @return the secondLabel
		 */
		public String getSecondLabel() {
			return secondLabel;
		}

		/**
		 * @param secondLabel the secondLabel to set
		 */
		public void setSecondLabel(String secondLabel) {
			this.secondLabel = secondLabel;
		}

		/**
		 * @return the operations1
		 */
		public String getOperations1() {
			return operations1;
		}

		/**
		 * @param operations1 the operations1 to set
		 */
		public void setOperations1(String operations1) {
			this.operations1 = operations1;
		}

/**
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}

/**
	 * @return the nextRoundNameEdit
	 */
	public String getNextRoundNameEdit() {
		return nextRoundNameEdit;
	}

	/**
	 * @param nextRoundNameEdit the nextRoundNameEdit to set
	 */
	public void setNextRoundNameEdit(String nextRoundNameEdit) {
		this.nextRoundNameEdit = nextRoundNameEdit;
	}

/**
	 * @return the interviewResultIdEdit
	 */
	public String getInterviewResultIdEdit() {
		return interviewResultIdEdit;
	}

	/**
	 * @param interviewResultIdEdit the interviewResultIdEdit to set
	 */
	public void setInterviewResultIdEdit(String interviewResultIdEdit) {
		this.interviewResultIdEdit = interviewResultIdEdit;
	}

/**
	 * @return the irApplicantIdEdit
	 */
	public String getIrApplicantIdEdit() {
		return irApplicantIdEdit;
	}

	/**
	 * @param irApplicantIdEdit the irApplicantIdEdit to set
	 */
	public void setIrApplicantIdEdit(String irApplicantIdEdit) {
		this.irApplicantIdEdit = irApplicantIdEdit;
	}

	/**
	 * @return the ratingEdit
	 */
	public String getRatingEdit() {
		return ratingEdit;
	}

	/**
	 * @param ratingEdit the ratingEdit to set
	 */
	public void setRatingEdit(String ratingEdit) {
		this.ratingEdit = ratingEdit;
	}

	/**
	 * @return the nextRoundEdit
	 */
	public String getNextRoundEdit() {
		return nextRoundEdit;
	}

	/**
	 * @param nextRoundEdit the nextRoundEdit to set
	 */
	public void setNextRoundEdit(String nextRoundEdit) {
		this.nextRoundEdit = nextRoundEdit;
	}

	/**
	 * @return the commentsEdit
	 */
	public String getCommentsEdit() {
		return commentsEdit;
	}

	/**
	 * @param commentsEdit the commentsEdit to set
	 */
	public void setCommentsEdit(String commentsEdit) {
		this.commentsEdit = commentsEdit;
	}

	/*	database relationship properties */
	private Employee employees;
	private ApplicantBean applicant;
	private InterviewRound interviewRound;
	private VacancyDetailLine vacancyDetails;
	private List<InterViewResult> ivResultDetails;
	
	private String advanceSearchText;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private int advanceSearchHidden;
	

	/**
	 * @return the vacancyNo
	 */
	public String getVacancyNo() {
		return vacancyNo;
	}

	/**
	 * @param vacancyNo the vacancyNo to set
	 */
	public void setVacancyNo(String vacancyNo) {
		this.vacancyNo = vacancyNo;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the applicanName
	 */
	public String getApplicanName() {
		return applicanName;
	}

	/**
	 * @param applicanName the applicanName to set
	 */
	public void setApplicanName(String applicanName) {
		this.applicanName = applicanName;
	}

	/**
	 * @return the iVRoundName
	 */
	public String getiVRoundName() {
		return iVRoundName;
	}

	/**
	 * @param iVRoundName the iVRoundName to set
	 */
	public void setiVRoundName(String iVRoundName) {
		this.iVRoundName = iVRoundName;
	}

	/**
	 * @return the vacancyDetails
	 */
	public VacancyDetailLine getVacancyDetails() {
		return vacancyDetails;
	}

	/**
	 * @param vacancyDetails the vacancyDetails to set
	 */
	public void setVacancyDetails(VacancyDetailLine vacancyDetails) {
		this.vacancyDetails = vacancyDetails;
	}

	/**
	 * @return the ivResultDetails
	 */
	public List<InterViewResult> getIvResultDetails() {
		return ivResultDetails;
	}

	/**
	 * @param ivResultDetails the ivResultDetails to set
	 */
	public void setIvResultDetails(List<InterViewResult> ivResultDetails) {
		this.ivResultDetails = ivResultDetails;
	}

	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * @return the employees
	 */
	public Employee getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	/**
	 * @return the applicant
	 */
	public ApplicantBean getApplicant() {
		return applicant;
	}

	/**
	 * @param applicant the applicant to set
	 */
	public void setApplicant(ApplicantBean applicant) {
		this.applicant = applicant;
	}

	/**
	 * @return the interviewRound
	 */
	public InterviewRound getInterviewRound() {
		return interviewRound;
	}

	/**
	 * @param interviewRound the interviewRound to set
	 */
	public void setInterviewRound(InterviewRound interviewRound) {
		this.interviewRound = interviewRound;
	}

	
	

	/**
	 * @return the advanceSearchHidden
	 */
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	/**
	 * @param advanceSearchHidden the advanceSearchHidden to set
	 */
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	/**
	 * @return the xmlLabel
	 */
	public String getXmlLabel() {
		return xmlLabel;
	}

	/**
	 * @param xmlLabel the xmlLabel to set
	 */
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}

	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}

	/**
	 * @param basicSearchId the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

	/**
	 * @return the advanceSearchText
	 */
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	/**
	 * @param advanceSearchText the advanceSearchText to set
	 */
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}



	/**
	 * @return the interviewScheduleId
	 */
	public int getInterviewScheduleId() {
		return interviewScheduleId;
	}

	/**
	 * @param interviewScheduleId the interviewScheduleId to set
	 */
	public void setInterviewScheduleId(int interviewScheduleId) {
		this.interviewScheduleId = interviewScheduleId;
	}

	/**
	 * @return the vacancyDetailId
	 */
	public String getVacancyDetailId() {
		return vacancyDetailId;
	}

	/**
	 * @param vacancyDetailId
	 *            the vacancyDetailId to set
	 */
	public void setVacancyDetailId(String vacancyDetailId) {
		this.vacancyDetailId = vacancyDetailId;
	}

	/**
	 * @return the applicantId
	 */
	public String getApplicantId() {
		return applicantId;
	}

	/**
	 * @param applicantId
	 *            the applicantId to set
	 */
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	/**
	 * @return the scheduledDate
	 */
	public String getScheduledDate() {
		return scheduledDate;
	}

	/**
	 * @param scheduledDate
	 *            the scheduledDate to set
	 */
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	/**
	 * @return the scheduledTime
	 */
	public String getScheduledTime() {
		return scheduledTime;
	}

	/**
	 * @param scheduledTime
	 *            the scheduledTime to set
	 */
	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	/**
	 * @return the interviewRoundId
	 */
	public String getInterviewRoundId() {
		return interviewRoundId;
	}

	/**
	 * @param interviewRoundId
	 *            the interviewRoundId to set
	 */
	public void setInterviewRoundId(String interviewRoundId) {
		this.interviewRoundId = interviewRoundId;
	}

	/**
	 * @return the assignedTo
	 */
	public String getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo
	 *            the assignedTo to set
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

}
