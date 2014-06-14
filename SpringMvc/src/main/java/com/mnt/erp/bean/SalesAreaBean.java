/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 31-10-2013
 */
public class SalesAreaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int saId;
	private int salesAreaId;
	private String salesArea;
	private String salesOrgId;
	private String salesOrgName;

	private int editSalesAreaId;
	private String editSalesArea;
	private String editSalesOrgId;
	private SalesOrganizationBean salesOrg;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	
	public String getSalesOrgName() {
		return salesOrgName;
	}

	public void setSalesOrgName(String salesOrgName) {
		this.salesOrgName = salesOrgName;
	}
	public int getSaId() {
		return saId;
	}

	public void setSaId(int saId) {
		this.saId = saId;
	}
	public SalesOrganizationBean getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(SalesOrganizationBean salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getSalesOrgId() {
		return salesOrgId;
	}

	public void setSalesOrgId(String salesOrgId) {
		this.salesOrgId = salesOrgId;
	}

	public int getEditSalesAreaId() {
		return editSalesAreaId;
	}

	public void setEditSalesAreaId(int editSalesAreaId) {
		this.editSalesAreaId = editSalesAreaId;
	}

	public String getEditSalesArea() {
		return editSalesArea;
	}

	public void setEditSalesArea(String editSalesArea) {
		this.editSalesArea = editSalesArea;
	}

	public String getEditSalesOrgId() {
		return editSalesOrgId;
	}

	public void setEditSalesOrgId(String editSalesOrgId) {
		this.editSalesOrgId = editSalesOrgId;
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

	public int getSalesAreaId() {
		return salesAreaId;
	}

	public void setSalesAreaId(int salesAreaId) {
		this.salesAreaId = salesAreaId;
	}

	public String getSalesArea() {
		return salesArea;
	}

	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
	}

}
