/**
@Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0 28-10-2013
 * @build 0.0
 *
 */
public class WorkCenterCategory {

	/*==========================Bean Properties=======================*/
	private int workCenterCategoryId;
	private String workCenterCategory;
	private int aid;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	/*==========================Edit Properties=======================*/
	private int workCenterCategoryIdEditt;
	private String workCenterCategoryEditt;
   /*=======================Getters===================================*/
	public int getWorkCenterCategoryId() {
		return workCenterCategoryId;
	}
	public String getWorkCenterCategory() {
		return workCenterCategory;
	}
	
	public int getAid() {
		return aid;
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
	public int getWorkCenterCategoryIdEditt() {
		return workCenterCategoryIdEditt;
	}
	public String getWorkCenterCategoryEditt() {
		return workCenterCategoryEditt;
	}
	/*=======================Setters===================================*/
	public void setWorkCenterCategoryId(int workCenterCategoryId) {
		this.workCenterCategoryId = workCenterCategoryId;
	}
	public void setWorkCenterCategory(String workCenterCategory) {
		this.workCenterCategory = workCenterCategory;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public void setWorkCenterCategoryIdEditt(int workCenterCategoryIdEditt) {
		this.workCenterCategoryIdEditt = workCenterCategoryIdEditt;
	}
	public void setWorkCenterCategoryEditt(String workCenterCategoryEditt) {
		this.workCenterCategoryEditt = workCenterCategoryEditt;
	}
	
	
}
