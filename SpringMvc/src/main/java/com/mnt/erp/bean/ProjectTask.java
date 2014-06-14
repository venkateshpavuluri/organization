package com.mnt.erp.bean;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ProjectTaskDocument;
import com.mnt.erp.bean.projectResourceBean;

/**
 * 
 */

/**
 * @author devi
 *
 */
public class ProjectTask {
	private int projectTaskId;
	private int projectTaskResId;
	private String projectTask;
	private String projectId;
	private String plantStartDt;
	private String plantEndDt;
	private String actualStartDt;
	private String actualEndDt;
	private String durationHrs;
	private String predessor;
	private String percentComplete;
	private Boolean milestone;
	private List<ProjectTaskResource> projectTaskResources;
	private String projectResource_Id;
	private MultipartFile imageFile;
	private MultipartFile imageFileEdit;
	private String projectName;
	
	private String checkPrevious;
	
	/* Project Task Document Properties */
	private int projectTaskDocId;
	
	private String projectTaskDocument;
	private String documentPath;
	private MultipartFile[] file;
	
	/* RelationShip Properties */
	private Set<ProjectTaskDocument> PTaskDetails;
	private Project prjctDetails;
	
	/* Project Task Edit */
	
	private int projectTaskIdEdit;
	private String projectTaskEdit;
	private String projectIdEdit;
	private String projectNameEdit;
	private String plantStartDtEdit;
	private String plantEndDtEdit;
	private String actualStartDtEdit;
	private String actualEndDtEdit;
	private String durationHrsEdit;
	private String predessorEdit;
	private String percentCompleteEdit;
	private Boolean milestoneEdit;
	private String projectResource_IdEdit;
	
	
	/* Project Task document Edit */
	private String projectTaskDocIdEdit;
	
	private String projectTaskDocumentEdit;
	private String documentPathEdit;
	private MultipartFile[] fileEdit;
	

	/*Basic Search*/
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

				
		/*
		hide properties*/
		
		private int projectTaskHide;


		//Getters & Setters
		
			public String getProjectTask() {
			return projectTask;
		}




		public String getCheckPrevious() {
			return checkPrevious;
		}




		public void setCheckPrevious(String checkPrevious) {
			this.checkPrevious = checkPrevious;
		}




		public String getProjectName() {
			return projectName;
		}


		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}


		public MultipartFile getImageFile() {
			return imageFile;
		}


		public void setImageFile(MultipartFile imageFile) {
			this.imageFile = imageFile;
		}


		public MultipartFile getImageFileEdit() {
			return imageFileEdit;
		}


		public void setImageFileEdit(MultipartFile imageFileEdit) {
			this.imageFileEdit = imageFileEdit;
		}


		public int getProjectTaskResId() {
			return projectTaskResId;
		}


		public void setProjectTaskResId(int projectTaskResId) {
			this.projectTaskResId = projectTaskResId;
		}


		public Project getPrjctDetails() {
			return prjctDetails;
		}


		public void setPrjctDetails(Project prjctDetails) {
			this.prjctDetails = prjctDetails;
		}


		public int getProjectTaskId() {
			return projectTaskId;
		}


		public void setProjectTaskId(int projectTaskId) {
			this.projectTaskId = projectTaskId;
		}


		public String getProjectId() {
			return projectId;
		}


		public void setProjectId(String projectId) {
			this.projectId = projectId;
		}


		public String getPlantStartDt() {
			return plantStartDt;
		}


		public void setPlantStartDt(String plantStartDt) {
			this.plantStartDt = plantStartDt;
		}


		public String getPlantEndDt() {
			return plantEndDt;
		}


		public void setPlantEndDt(String plantEndDt) {
			this.plantEndDt = plantEndDt;
		}


		public String getActualStartDt() {
			return actualStartDt;
		}


		public void setActualStartDt(String actualStartDt) {
			this.actualStartDt = actualStartDt;
		}


		public String getActualEndDt() {
			return actualEndDt;
		}


		public void setActualEndDt(String actualEndDt) {
			this.actualEndDt = actualEndDt;
		}


		public String getPercentComplete() {
			return percentComplete;
		}


		public void setPercentComplete(String percentComplete) {
			this.percentComplete = percentComplete;
		}


		public int getProjectTaskIdEdit() {
			return projectTaskIdEdit;
		}


		public void setProjectTaskIdEdit(int projectTaskIdEdit) {
			this.projectTaskIdEdit = projectTaskIdEdit;
		}


		public String getProjectIdEdit() {
			return projectIdEdit;
		}


		public void setProjectIdEdit(String projectIdEdit) {
			this.projectIdEdit = projectIdEdit;
		}


		public String getPlantStartDtEdit() {
			return plantStartDtEdit;
		}


		public void setPlantStartDtEdit(String plantStartDtEdit) {
			this.plantStartDtEdit = plantStartDtEdit;
		}


		public String getPlantEndDtEdit() {
			return plantEndDtEdit;
		}


		public void setPlantEndDtEdit(String plantEndDtEdit) {
			this.plantEndDtEdit = plantEndDtEdit;
		}


		public String getActualStartDtEdit() {
			return actualStartDtEdit;
		}


		public void setActualStartDtEdit(String actualStartDtEdit) {
			this.actualStartDtEdit = actualStartDtEdit;
		}


		public String getActualEndDtEdit() {
			return actualEndDtEdit;
		}


		public void setActualEndDtEdit(String actualEndDtEdit) {
			this.actualEndDtEdit = actualEndDtEdit;
		}


		public String getPercentCompleteEdit() {
			return percentCompleteEdit;
		}


		public void setPercentCompleteEdit(String percentCompleteEdit) {
			this.percentCompleteEdit = percentCompleteEdit;
		}


		public void setProjectTask(String projectTask) {
			this.projectTask = projectTask;
		}


		public String getDurationHrs() {
			return durationHrs;
		}


		public void setDurationHrs(String durationHrs) {
			this.durationHrs = durationHrs;
		}


		public String getPredessor() {
			return predessor;
		}


		public void setPredessor(String predessor) {
			this.predessor = predessor;
		}


	


		

		public String getProjectResource_Id() {
			return projectResource_Id;
		}


		public void setProjectResource_Id(String projectResource_Id) {
			this.projectResource_Id = projectResource_Id;
		}


		public String getProjectTaskDocument() {
			return projectTaskDocument;
		}


		public void setProjectTaskDocument(String projectTaskDocument) {
			this.projectTaskDocument = projectTaskDocument;
		}


		public String getDocumentPath() {
			return documentPath;
		}


		public void setDocumentPath(String documentPath) {
			this.documentPath = documentPath;
		}


		public MultipartFile[] getFile() {
			return file;
		}


		public void setFile(MultipartFile[] file) {
			this.file = file;
		}


		
			
		public List<ProjectTaskResource> getProjectTaskResources() {
			return projectTaskResources;
		}


		public void setProjectTaskResources(
				List<ProjectTaskResource> projectTaskResources) {
			this.projectTaskResources = projectTaskResources;
		}


		public String getProjectTaskEdit() {
			return projectTaskEdit;
		}


		public void setProjectTaskEdit(String projectTaskEdit) {
			this.projectTaskEdit = projectTaskEdit;
		}


	


		public String getProjectNameEdit() {
			return projectNameEdit;
		}


		public void setProjectNameEdit(String projectNameEdit) {
			this.projectNameEdit = projectNameEdit;
		}


		


		public Set<ProjectTaskDocument> getPTaskDetails() {
			return PTaskDetails;
		}


		public void setPTaskDetails(Set<ProjectTaskDocument> pTaskDetails) {
			PTaskDetails = pTaskDetails;
		}


		public String getDurationHrsEdit() {
			return durationHrsEdit;
		}


		public void setDurationHrsEdit(String durationHrsEdit) {
			this.durationHrsEdit = durationHrsEdit;
		}


		public String getPredessorEdit() {
			return predessorEdit;
		}


		public void setPredessorEdit(String predessorEdit) {
			this.predessorEdit = predessorEdit;
		}


				


		public Boolean getMilestone() {
			return milestone;
		}


		public void setMilestone(Boolean milestone) {
			this.milestone = milestone;
		}


		public Boolean getMilestoneEdit() {
			return milestoneEdit;
		}


		public void setMilestoneEdit(Boolean milestoneEdit) {
			this.milestoneEdit = milestoneEdit;
		}


		public String getProjectResource_IdEdit() {
			return projectResource_IdEdit;
		}


		public void setProjectResource_IdEdit(String projectResource_IdEdit) {
			this.projectResource_IdEdit = projectResource_IdEdit;
		}


	


		


		public int getProjectTaskDocId() {
			return projectTaskDocId;
		}


		public void setProjectTaskDocId(int projectTaskDocId) {
			this.projectTaskDocId = projectTaskDocId;
		}


	

		public String getProjectTaskDocIdEdit() {
			return projectTaskDocIdEdit;
		}


		public void setProjectTaskDocIdEdit(String projectTaskDocIdEdit) {
			this.projectTaskDocIdEdit = projectTaskDocIdEdit;
		}


		public String getProjectTaskDocumentEdit() {
			return projectTaskDocumentEdit;
		}


		public void setProjectTaskDocumentEdit(String projectTaskDocumentEdit) {
			this.projectTaskDocumentEdit = projectTaskDocumentEdit;
		}


		public String getDocumentPathEdit() {
			return documentPathEdit;
		}


		public void setDocumentPathEdit(String documentPathEdit) {
			this.documentPathEdit = documentPathEdit;
		}


		public MultipartFile[] getFileEdit() {
			return fileEdit;
		}


		public void setFileEdit(MultipartFile[] fileEdit) {
			this.fileEdit = fileEdit;
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


		public int getProjectTaskHide() {
			return projectTaskHide;
		}


		public void setProjectTaskHide(int projectTaskHide) {
			this.projectTaskHide = projectTaskHide;
		}
		 
	
	
}
