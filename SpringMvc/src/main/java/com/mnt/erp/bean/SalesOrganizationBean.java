package com.mnt.erp.bean;

public class SalesOrganizationBean {
	private int salesorgId;
	private String salesorganization;
	private String orgId;
	private int esalesorgId;
	private String esalesorganization;
	private String eorgId;
	private int sohide;
	private int sohideedit;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private Organization org;
	private String organizationname;
	
	
	public String getOrganizationname() {
		return organizationname;
	}
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	public int getSalesorgId() {
		return salesorgId;
	}
	public void setSalesorgId(int salesorgId) {
		this.salesorgId = salesorgId;
	}
	public String getSalesorganization() {
		return salesorganization;
	}
	public void setSalesorganization(String salesorganization) {
		this.salesorganization = salesorganization;
	}
	
	public int getEsalesorgId() {
		return esalesorgId;
	}
	public void setEsalesorgId(int esalesorgId) {
		this.esalesorgId = esalesorgId;
	}
	public String getEsalesorganization() {
		return esalesorganization;
	}
	public void setEsalesorganization(String esalesorganization) {
		this.esalesorganization = esalesorganization;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getEorgId() {
		return eorgId;
	}
	public void setEorgId(String eorgId) {
		this.eorgId = eorgId;
	}
	public int getSohide() {
		return sohide;
	}
	public void setSohide(int sohide) {
		this.sohide = sohide;
	}
	public int getSohideedit() {
		return sohideedit;
	}
	public void setSohideedit(int sohideedit) {
		this.sohideedit = sohideedit;
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
