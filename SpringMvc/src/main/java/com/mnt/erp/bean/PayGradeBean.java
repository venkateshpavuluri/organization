/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
public class PayGradeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pgId;
	private int payGradeId;
	private String payGrade;
	private int epayGradeId;
	private String epayGrade;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	public int getPgId() {
		return pgId;
	}
	public int getPayGradeId() {
		return payGradeId;
	}
	public String getPayGrade() {
		return payGrade;
	}
	public int getEpayGradeId() {
		return epayGradeId;
	}
	public String getEpayGrade() {
		return epayGrade;
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
	public void setPgId(int pgId) {
		this.pgId = pgId;
	}
	public void setPayGradeId(int payGradeId) {
		this.payGradeId = payGradeId;
	}
	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}
	public void setEpayGradeId(int epayGradeId) {
		this.epayGradeId = epayGradeId;
	}
	public void setEpayGrade(String epayGrade) {
		this.epayGrade = epayGrade;
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
