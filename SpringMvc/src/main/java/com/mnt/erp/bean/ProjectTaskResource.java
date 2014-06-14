
package com.mnt.erp.bean;

public class ProjectTaskResource {
	private int projectTaskResourceId;
	private String projectTaskId;
	private String projectResourceId;
	
	private ProjectTask prjctTaskDetails;
	private projectResourceBean PRDetails;
		
		
	public ProjectTask getPrjctTaskDetails() {
		return prjctTaskDetails;
	}
	public void setPrjctTaskDetails(ProjectTask prjctTaskDetails) {
		this.prjctTaskDetails = prjctTaskDetails;
	}
	public projectResourceBean getPRDetails() {
		return PRDetails;
	}
	public void setPRDetails(projectResourceBean pRDetails) {
		PRDetails = pRDetails;
	}
	/**
	 * @return the projectTaskResourceId
	 */
	public int getProjectTaskResourceId() {
		return projectTaskResourceId;
	}
	/**
	 * @param projectTaskResourceId the projectTaskResourceId to set
	 */
	public void setProjectTaskResourceId(int projectTaskResourceId) {
		this.projectTaskResourceId = projectTaskResourceId;
	}
	/**
	 * @return the projectTaskId
	 */
	public String getProjectTaskId() {
		return projectTaskId;
	}
	/**
	 * @param projectTaskId the projectTaskId to set
	 */
	public void setProjectTaskId(String projectTaskId) {
		this.projectTaskId = projectTaskId;
	}
	/**
	 * @return the projectResourceId
	 */
	public String getProjectResourceId() {
		return projectResourceId;
	}
	/**
	 * @param projectResourceId the projectResourceId to set
	 */
	public void setProjectResourceId(String projectResourceId) {
		this.projectResourceId = projectResourceId;
	}
	
	
	
	

}
