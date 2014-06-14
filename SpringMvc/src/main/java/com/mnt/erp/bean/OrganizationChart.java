package com.mnt.erp.bean;

public class OrganizationChart {
	private int organizationChartId;
	private String orgId;
	private String designationId;
	private String parentDesignationId;
	private int aid;
	private Organization organization;
	private String orgName;
	private Designation designation;
	private Designation parentDesignation;
	private String designationName;
	private String parentDesignationName;
	//Basic search properties
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	
	//Edit properties
	private int organizationChartIdEdit;
	private String orgIdEdit;
	private String designationIdEdit;
	public int getOrganizationChartId() {
		return organizationChartId;
	}
	public void setOrganizationChartId(int organizationChartId) {
		this.organizationChartId = organizationChartId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
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
	public int getOrganizationChartIdEdit() {
		return organizationChartIdEdit;
	}
	public void setOrganizationChartIdEdit(int organizationChartIdEdit) {
		this.organizationChartIdEdit = organizationChartIdEdit;
	}
	public String getOrgIdEdit() {
		return orgIdEdit;
	}
	public void setOrgIdEdit(String orgIdEdit) {
		this.orgIdEdit = orgIdEdit;
	}
	public String getDesignationIdEdit() {
		return designationIdEdit;
	}
	public void setDesignationIdEdit(String designationIdEdit) {
		this.designationIdEdit = designationIdEdit;
	}
	public String getParentDesignationId() {
		return parentDesignationId;
	}
	public void setParentDesignationId(String parentDesignationId) {
		this.parentDesignationId = parentDesignationId;
	}
	public String getParentDesignationName() {
		return parentDesignationName;
	}
	public void setParentDesignationName(String parentDesignationName) {
		this.parentDesignationName = parentDesignationName;
	}
	public Designation getParentDesignation() {
		return parentDesignation;
	}
	public void setParentDesignation(Designation parentDesignation) {
		this.parentDesignation = parentDesignation;
	}
    
}
