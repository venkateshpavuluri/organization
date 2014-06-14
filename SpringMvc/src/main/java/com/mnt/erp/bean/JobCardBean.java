package com.mnt.erp.bean;

import java.io.Serializable;


public class JobCardBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int jobCardId;
	private String prodBatchId;
	private String jobcardDate;
	
	
	public int getJobCardId() {
		return jobCardId;
	}
	public String getProdBatchId() {
		return prodBatchId;
	}
	public String getJobcardDate() {
		return jobcardDate;
	}
	public void setJobCardId(int jobCardId) {
		this.jobCardId = jobCardId;
	}
	public void setProdBatchId(String prodBatchId) {
		this.prodBatchId = prodBatchId;
	}
	public void setJobcardDate(String jobcardDate) {
		this.jobcardDate = jobcardDate;
	}
	

}
