/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
public class JobCategoryBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jcId;
	private int jobCategoryId;
	private String jobCategory;
	private int ejobCategoryId;
	private String ejobCategory;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	public int getJobCategoryId() {
		return jobCategoryId;
	}
	
	public int getEjobCategoryId() {
		return ejobCategoryId;
	}
	public String getEjobCategory() {
		return ejobCategory;
	}
	public int getJcId() {
		return jcId;
	}

	public void setJcId(int jcId) {
		this.jcId = jcId;
	}

	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getOperations() {
		return operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setJobCategoryId(int jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}
	
	public void setEjobCategoryId(int ejobCategoryId) {
		this.ejobCategoryId = ejobCategoryId;
	}
	public void setEjobCategory(String ejobCategory) {
		this.ejobCategory = ejobCategory;
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

}
