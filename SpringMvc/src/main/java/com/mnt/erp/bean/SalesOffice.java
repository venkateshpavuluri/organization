/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0 31-10-2013
 * @build 0.0
 *
 */
public class SalesOffice {
	/*=======================Bean Properties===================*/
	
	private int salesOfficeId;
	private String salesAreaId;
	private String salesArea;
	private String salesOffice;
	private int aid;
	private SalesAreaBean saBean;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
/*=======================Edit Properties=======================*/
	
	private int salesOfficeIdEditt;
	private String salesAreaIdEditt;
	private String salesOfficeEditt;
	
		
/*===========================Getters============================*/
	
	
	public int getSalesOfficeId() {
		return salesOfficeId;
	}
	public SalesAreaBean getSaBean() {
		return saBean;
	}
	

	public String getSalesAreaId() {
		return salesAreaId;
	}
	public String getSalesArea() {
		return salesArea;
	}
	public String getSalesOffice() {
		return salesOffice;
	}
	public int getAid() {
		return aid;
	}
	public int getSalesOfficeIdEditt() {
		return salesOfficeIdEditt;
	}
	public String getSalesAreaIdEditt() {
		return salesAreaIdEditt;
	}
	public String getSalesOfficeEditt() {
		return salesOfficeEditt;
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
	
/*==============================Setters===========================*/
	public void setSaBean(SalesAreaBean saBean) {
		this.saBean = saBean;
	}

	public void setSalesOfficeId(int salesOfficeId) {
		this.salesOfficeId = salesOfficeId;
	}
	
	public void setSalesAreaId(String salesAreaId) {
		this.salesAreaId = salesAreaId;
	}
	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
	}
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setSalesOfficeIdEditt(int salesOfficeIdEditt) {
		this.salesOfficeIdEditt = salesOfficeIdEditt;
	}
	public void setSalesAreaIdEditt(String salesAreaIdEditt) {
		this.salesAreaIdEditt = salesAreaIdEditt;
	}
	public void setSalesOfficeEditt(String salesOfficeEditt) {
		this.salesOfficeEditt = salesOfficeEditt;
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
