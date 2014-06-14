/**
 * 
 */
package com.mnt.erp.bean;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author devi
 *
 */
public class ClaimBean {
	private int claimId;
	private String claimTypeId;
	private String claimNo;
	private String employeeId;
	private String amount;
	private String statusId;
	private String description;
	private MultipartFile imageFile;
	private MultipartFile imageFileEdit;
	private String claimTypeName;
	private String empName;
	private String statusName;
	
	/*Claim Documents Properties */
	private int claimDocId;
	private String documentPath;
	private MultipartFile[] file;
	
	/* RelationShip Properties */
	    private Set<ClaimDocumentsBean> claimDocDetails;
		private ClaimTypeBean claimTypeDetails;
		private Employee empDetails;
		private Status statusDetails;
		
		/*Basic Search*/
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
		
		private String workFlowListId;
		private String step;
		private String comments;
		private String actionNames;
					
			/*
			hide properties*/
			private int claimHide;
			private String checkPrevious;
		//Getters & Setters
			public int getClaimId() {
				return claimId;
			}
			/**
			 * @return the workFlowListId
			 */
			public String getWorkFlowListId() {
				return workFlowListId;
			}

			/**
			 * @param workFlowListId the workFlowListId to set
			 */
			public void setWorkFlowListId(String workFlowListId) {
				this.workFlowListId = workFlowListId;
			}

			/**
			 * @return the step
			 */
			public String getStep() {
				return step;
			}

			/**
			 * @param step the step to set
			 */
			public void setStep(String step) {
				this.step = step;
			}

			/**
			 * @return the comments
			 */
			public String getComments() {
				return comments;
			}

			/**
			 * @param comments the comments to set
			 */
			public void setComments(String comments) {
				this.comments = comments;
			}

			/**
			 * @return the actionNames
			 */
			public String getActionNames() {
				return actionNames;
			}

			/**
			 * @param actionNames the actionNames to set
			 */
			public void setActionNames(String actionNames) {
				this.actionNames = actionNames;
			}

			public void setClaimId(int claimId) {
				this.claimId = claimId;
			}

			public String getClaimTypeId() {
				return claimTypeId;
			}

			public void setClaimTypeId(String claimTypeId) {
				this.claimTypeId = claimTypeId;
			}

			public String getClaimNo() {
				return claimNo;
			}

			public void setClaimNo(String claimNo) {
				this.claimNo = claimNo;
			}

			public String getEmployeeId() {
				return employeeId;
			}

			public void setEmployeeId(String employeeId) {
				this.employeeId = employeeId;
			}

			

			public String getStatusId() {
				return statusId;
			}

			public void setStatusId(String statusId) {
				this.statusId = statusId;
			}

			

			public String getAmount() {
				return amount;
			}

			public void setAmount(String amount) {
				this.amount = amount;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
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

			public String getClaimTypeName() {
				return claimTypeName;
			}

			public void setClaimTypeName(String claimTypeName) {
				this.claimTypeName = claimTypeName;
			}

			public String getEmpName() {
				return empName;
			}

			public void setEmpName(String empName) {
				this.empName = empName;
			}

			public String getStatusName() {
				return statusName;
			}

			public void setStatusName(String statusName) {
				this.statusName = statusName;
			}

			public int getClaimDocId() {
				return claimDocId;
			}

			public void setClaimDocId(int claimDocId) {
				this.claimDocId = claimDocId;
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

			public ClaimTypeBean getClaimTypeDetails() {
				return claimTypeDetails;
			}

			public void setClaimTypeDetails(ClaimTypeBean claimTypeDetails) {
				this.claimTypeDetails = claimTypeDetails;
			}

			public Employee getEmpDetails() {
				return empDetails;
			}

			public void setEmpDetails(Employee empDetails) {
				this.empDetails = empDetails;
			}

			public Status getStatusDetails() {
				return statusDetails;
			}

			public void setStatusDetails(Status statusDetails) {
				this.statusDetails = statusDetails;
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

			public int getClaimHide() {
				return claimHide;
			}

			public void setClaimHide(int claimHide) {
				this.claimHide = claimHide;
			}

			public Set<ClaimDocumentsBean> getClaimDocDetails() {
				return claimDocDetails;
			}

			public void setClaimDocDetails(Set<ClaimDocumentsBean> claimDocDetails) {
				this.claimDocDetails = claimDocDetails;
			}

			public String getCheckPrevious() {
				return checkPrevious;
			}

			public void setCheckPrevious(String checkPrevious) {
				this.checkPrevious = checkPrevious;
			}
			
			
			

}
