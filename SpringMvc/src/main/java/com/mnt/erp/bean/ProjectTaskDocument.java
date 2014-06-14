/**
 * 
 */
package com.mnt.erp.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author devi
 *
 */
public class ProjectTaskDocument {
	
	private int projectTaskDocId;
	private int projectTaskId;
	private String projectTaskDocument;
	private String documentPath;
	private MultipartFile imageFile;
			
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	/**
	 * @return the projectTaskId
	 */
	public int getProjectTaskId() {
		return projectTaskId;
	}
	/**
	 * @param projectTaskId the projectTaskId to set
	 */
	public void setProjectTaskId(int projectTaskId) {
		this.projectTaskId = projectTaskId;
	}
	/**
	 * @return the projectTaskDocument
	 */
	public String getProjectTaskDocument() {
		return projectTaskDocument;
	}
	/**
	 * @param projectTaskDocument the projectTaskDocument to set
	 */
	public void setProjectTaskDocument(String projectTaskDocument) {
		this.projectTaskDocument = projectTaskDocument;
	}
	/**
	 * @return the documentPath
	 */
	public String getDocumentPath() {
		return documentPath;
	}
	/**
	 * @param documentPath the documentPath to set
	 */
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	public int getProjectTaskDocId() {
		return projectTaskDocId;
	}
	public void setProjectTaskDocId(int projectTaskDocId) {
		this.projectTaskDocId = projectTaskDocId;
	}
	
	
	
	

}
