package com.mnt.erp.bean;

public class ProjectPhaseBean {
	private int projectPhase_Id;
	private String projectPhase;
	private String project;
	private int aid;
	
	private int projectPhase_IdEdit;
	private String projectPhaseEdit;
	private String projectEdit;
	

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private Project projectBean;
	
	public String getProjectEdit() {
		return projectEdit;
	}

	public void setProjectEdit(String projectEdit) {
		this.projectEdit = projectEdit;
	}
	public int getProjectPhase_Id() {
		return projectPhase_Id;
	}

	public void setProjectPhase_Id(int projectPhase_Id) {
		this.projectPhase_Id = projectPhase_Id;
	}

	public String getProjectPhase() {
		return projectPhase;
	}

	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getProjectPhase_IdEdit() {
		return projectPhase_IdEdit;
	}

	public void setProjectPhase_IdEdit(int projectPhase_IdEdit) {
		this.projectPhase_IdEdit = projectPhase_IdEdit;
	}

	public String getProjectPhaseEdit() {
		return projectPhaseEdit;
	}

	public void setProjectPhaseEdit(String projectPhaseEdit) {
		this.projectPhaseEdit = projectPhaseEdit;
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

	public Project getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}

	
	
}
