package com.mnt.erp.bean;

public class ActivityBean {
    private int activityId;
    private String activity;
    //Edit details
    private String activityIdEdit;
    private String activityEdit;
    private int aid;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;

    public int getActivityId() {
	return activityId;
    }

    public void setActivityId(int activityId) {
	this.activityId = activityId;
    }

    public String getActivity() {
	return activity;
    }

    public void setActivity(String activity) {
	this.activity = activity;
    }

    public String getActivityIdEdit() {
	return activityIdEdit;
    }

    public void setActivityIdEdit(String activityIdEdit) {
	this.activityIdEdit = activityIdEdit;
    }

    public String getActivityEdit() {
	return activityEdit;
    }

    public void setActivityEdit(String activityEdit) {
	this.activityEdit = activityEdit;
    }

    public int getAid() {
	return aid;
    }

    public void setAid(int aid) {
	this.aid = aid;
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
}
