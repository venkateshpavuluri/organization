/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 * 
 */
public class InterViewResult  {
	private int interviewResultId;
	private String irApplicantId;
	private String scheduleId;
	private String rating;
	private String nextRound;
	private String comments;
	private ApplicantBean applicantsDetails;

	
	
	



	/**
	 * @return the applicantsDetails
	 */
	public ApplicantBean getApplicantsDetails() {
		return applicantsDetails;
	}

	/**
	 * @param applicantsDetails the applicantsDetails to set
	 */
	public void setApplicantsDetails(ApplicantBean applicantsDetails) {
		this.applicantsDetails = applicantsDetails;
	}

	/**
	 * @return the interviewResultId
	 */
	public int getInterviewResultId() {
		return interviewResultId;
	}

	/**
	 * @param interviewResultId
	 *            the interviewResultId to set
	 */
	public void setInterviewResultId(int interviewResultId) {
		this.interviewResultId = interviewResultId;
	}

	
	
	
	/**
	 * @return the irApplicantId
	 */
	public String getIrApplicantId() {
		return irApplicantId;
	}

	/**
	 * @param irApplicantId the irApplicantId to set
	 */
	public void setIrApplicantId(String irApplicantId) {
		this.irApplicantId = irApplicantId;
	}


	

	/**
	 * @return the rating
	 */

 
	




	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}



	/**
	 * @return the scheduleId
	 */
	public String getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * @return the nextRound
	 */
	public String getNextRound() {
		return nextRound;
	}

	/**
	 * @param nextRound the nextRound to set
	 */
	public void setNextRound(String nextRound) {
		this.nextRound = nextRound;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}






}
