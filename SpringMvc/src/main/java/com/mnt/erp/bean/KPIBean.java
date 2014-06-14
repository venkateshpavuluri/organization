package com.mnt.erp.bean;

public class KPIBean {
    private int KPIId;
    private String KPI;
    private String minRate;
    private String maxRate;
    private String KPIGroup;
    private int KPIIdEdit;
    private String KPIEdit;
    private String minRateEdit;
    private String maxRateEdit;
    private String KPIGroupEdit;
    private KPIGroupBean kpiGroupBean;
    private int aid;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;

    public String getKPIGroupEdit() {
	return KPIGroupEdit;
    }

    public void setKPIGroupEdit(String kPIGroupEdit) {
	KPIGroupEdit = kPIGroupEdit;
    }

    public int getKPIId() {
	return KPIId;
    }

    public void setKPIId(int kPIId) {
	KPIId = kPIId;
    }

    public String getKPI() {
	return KPI;
    }

    public void setKPI(String kPI) {
	KPI = kPI;
    }

    public String getMinRate() {
	return minRate;
    }

    public void setMinRate(String minRate) {
	this.minRate = minRate;
    }

    public String getMaxRate() {
	return maxRate;
    }

    public void setMaxRate(String maxRate) {
	this.maxRate = maxRate;
    }

    public String getKPIGroup() {
	return KPIGroup;
    }

    public void setKPIGroup(String kPIGroup) {
	KPIGroup = kPIGroup;
    }

    public int getKPIIdEdit() {
	return KPIIdEdit;
    }

    public void setKPIIdEdit(int kPIIdEdit) {
	KPIIdEdit = kPIIdEdit;
    }

    public String getKPIEdit() {
	return KPIEdit;
    }

    public void setKPIEdit(String kPIEdit) {
	KPIEdit = kPIEdit;
    }

    public String getMinRateEdit() {
	return minRateEdit;
    }

    public void setMinRateEdit(String minRateEdit) {
	this.minRateEdit = minRateEdit;
    }

    public String getMaxRateEdit() {
	return maxRateEdit;
    }

    public void setMaxRateEdit(String maxRateEdit) {
	this.maxRateEdit = maxRateEdit;
    }

    public KPIGroupBean getKpiGroupBean() {
	return kpiGroupBean;
    }

    public void setKpiGroupBean(KPIGroupBean kpiGroupBean) {
	this.kpiGroupBean = kpiGroupBean;
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
