package com.mnt.erp.bean;

public class GetScheduleInterviewsBean {
    private String scheduleId;
    private String applicantName;
    private String scheduleDate;
    private String scheduleTime;
    private String interviewRound;
    private String assignTo;

    public String getScheduleId() {
	return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
	this.scheduleId = scheduleId;
    }

    public String getApplicantName() {
	return applicantName;
    }

    public void setApplicantName(String applicantName) {
	this.applicantName = applicantName;
    }

    public String getScheduleDate() {
	return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
	this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
	return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
	this.scheduleTime = scheduleTime;
    }

    public String getInterviewRound() {
	return interviewRound;
    }

    public void setInterviewRound(String interviewRound) {
	this.interviewRound = interviewRound;
    }

    public String getAssignTo() {
	return assignTo;
    }

    public void setAssignTo(String assignTo) {
	this.assignTo = assignTo;
    }

}
