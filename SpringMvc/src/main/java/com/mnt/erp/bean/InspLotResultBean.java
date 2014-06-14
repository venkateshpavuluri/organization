/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 10-01-2014
 */
public class InspLotResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int inspLotResultId;
	private String inspLotNoId;
	private String startDate;
	private String endDate;
	private String inspected;
	private String accepted;
	private String nonConf;
	private String mean;
	private String stdValue;
	private boolean skip;
	private String inspDecisionId;
	private Double qualityScore;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private InspectionLotBean inspLotBean;
	private InspectionDecision inspDecision;
	private float acpInEdit;
	private float inspInEdit;
	private float nonCnfInEdit;
	
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;

	// Setter And Getter Methods

	public int getInspLotResultId() {
		return inspLotResultId;
	}

	public String getInspLotNoId() {
		return inspLotNoId;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getInspected() {
		return inspected;
	}

	public String getAccepted() {
		return accepted;
	}

	public String getNonConf() {
		return nonConf;
	}

	public String getMean() {
		return mean;
	}

	public String getStdValue() {
		return stdValue;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setInspLotResultId(int inspLotResultId) {
		this.inspLotResultId = inspLotResultId;
	}

	public void setInspLotNoId(String inspLotNoId) {
		this.inspLotNoId = inspLotNoId;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setInspected(String inspected) {
		this.inspected = inspected;
	}

	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}

	public String getInspDecisionId() {
		return inspDecisionId;
	}

	public Double getQualityScore() {
		return qualityScore;
	}

	public void setInspDecisionId(String inspDecisionId) {
		this.inspDecisionId = inspDecisionId;
	}

	public void setQualityScore(Double qualityScore) {
		this.qualityScore = qualityScore;
	}

	public void setNonConf(String nonConf) {
		this.nonConf = nonConf;
	}

	public InspectionDecision getInspDecision() {
		return inspDecision;
	}

	public void setInspDecision(InspectionDecision inspDecision) {
		this.inspDecision = inspDecision;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public InspectionLotBean getInspLotBean() {
		return inspLotBean;
	}


	public String getXmlLabel() {
		return xmlLabel;
	}

	public String getOperations() {
		return operations;
	}

	public float getAcpInEdit() {
		return acpInEdit;
	}

	public float getInspInEdit() {
		return inspInEdit;
	}

	public float getNonCnfInEdit() {
		return nonCnfInEdit;
	}

	public void setAcpInEdit(float acpInEdit) {
		this.acpInEdit = acpInEdit;
	}

	public String getLabels() {
		return labels;
	}

	public String getDbField() {
		return dbField;
	}

	public String getAsOpts() {
		return asOpts;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	public void setInspInEdit(float inspInEdit) {
		this.inspInEdit = inspInEdit;
	}

	public void setNonCnfInEdit(float nonCnfInEdit) {
		this.nonCnfInEdit = nonCnfInEdit;
	}

	public String getBasicSearchId() {
		return basicSearchId;
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

	public void setInspLotBean(InspectionLotBean inspLotBean) {
		this.inspLotBean = inspLotBean;
	}

	public void setStdValue(String stdValue) {
		this.stdValue = stdValue;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
}
