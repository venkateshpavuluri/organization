/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class Project {
	
	
	 private int projectId;
	 private int aid;
	 public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	private String projectName;
	 private String orgId;
	 private String salesOrderId;
	 private Organization orgDetails;
	 private Employee managerDetails;
	 private Status statusDetails;
	 private String managerName;
	 private String statusName;
	 private String startDT;
	 private String finishDT;
	 private String parentProject_Id;
	 private String projectManager;
	 private String status_Id;
	 private int projectIdEdit;
	 private String projectNameEdit;
	 private String orgidEdit;
	 private String startDTEdit;
	 private String finishDTEdit;
	 private String parentProject_IdEdit;
	 private String projectManagerEdit;
	 private String status_IdEdit;
	 private String salesOrderIdEdit;
	 private SalesOrderBean salesOrder;
	 
	 public String getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public String getSalesOrderIdEdit() {
		return salesOrderIdEdit;
	}
	public void setSalesOrderIdEdit(String salesOrderIdEdit) {
		this.salesOrderIdEdit = salesOrderIdEdit;
	}
	public String getStartDT() {
		return startDT;
	}
	public void setStartDT(String startDT) {
		this.startDT = startDT;
	}
	public String getFinishDT() {
		return finishDT;
	}
	public void setFinishDT(String finishDT) {
		this.finishDT = finishDT;
	}
	public String getParentProject_Id() {
		return parentProject_Id;
	}
	public void setParentProject_Id(String parentProject_Id) {
		this.parentProject_Id = parentProject_Id;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getStatus_Id() {
		return status_Id;
	}
	public void setStatus_Id(String status_Id) {
		this.status_Id = status_Id;
	}
	private int projectDuplicate;
	 
	 
	 
	 /* Variable For Basic Search And Advanced Search*/
		private String operations;
		private String basicSearchId;
		private String xmlLabelBasic;
		
		
		
	 
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the orgDetails
	 */
	public Organization getOrgDetails() {
		return orgDetails;
	}
	/**
	 * @param orgDetails the orgDetails to set
	 */
	public void setOrgDetails(Organization orgDetails) {
		this.orgDetails = orgDetails;
	}
	/**
	 * @return the projectDuplicate
	 */
	public int getProjectDuplicate() {
		return projectDuplicate;
	}
	/**
	 * @param projectDuplicate the projectDuplicate to set
	 */
	public void setProjectDuplicate(int projectDuplicate) {
		this.projectDuplicate = projectDuplicate;
	}
	 
	 
	 
	
/*For Basic Search Setter and Getter Methods*/
	
	
	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}
	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}
	/**
	 * @param basicSearchId the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	/**
	 * @return the xmlLabelBasic
	 */
	public String getXmlLabelBasic() {
		return xmlLabelBasic;
	}
	/**
	 * @param xmlLabelBasic the xmlLabelBasic to set
	 */
	public void setXmlLabelBasic(String xmlLabelBasic) {
		this.xmlLabelBasic = xmlLabelBasic;
	}
	public Employee getManagerDetails() {
		return managerDetails;
	}
	public void setManagerDetails(Employee managerDetails) {
		this.managerDetails = managerDetails;
	}
	public Status getStatusDetails() {
		return statusDetails;
	}
	public void setStatusDetails(Status statusDetails) {
		this.statusDetails = statusDetails;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public int getProjectIdEdit() {
		return projectIdEdit;
	}
	public void setProjectIdEdit(int projectIdEdit) {
		this.projectIdEdit = projectIdEdit;
	}
	public String getProjectNameEdit() {
		return projectNameEdit;
	}
	public void setProjectNameEdit(String projectNameEdit) {
		this.projectNameEdit = projectNameEdit;
	}
	public String getOrgidEdit() {
		return orgidEdit;
	}
	public void setOrgidEdit(String orgidEdit) {
		this.orgidEdit = orgidEdit;
	}
	public String getStartDTEdit() {
		return startDTEdit;
	}
	public void setStartDTEdit(String startDTEdit) {
		this.startDTEdit = startDTEdit;
	}
	public String getFinishDTEdit() {
		return finishDTEdit;
	}
	public void setFinishDTEdit(String finishDTEdit) {
		this.finishDTEdit = finishDTEdit;
	}
	public String getParentProject_IdEdit() {
		return parentProject_IdEdit;
	}
	public void setParentProject_IdEdit(String parentProject_IdEdit) {
		this.parentProject_IdEdit = parentProject_IdEdit;
	}
	public String getProjectManagerEdit() {
		return projectManagerEdit;
	}
	public void setProjectManagerEdit(String projectManagerEdit) {
		this.projectManagerEdit = projectManagerEdit;
	}
	public String getStatus_IdEdit() {
		return status_IdEdit;
	}
	public void setStatus_IdEdit(String status_IdEdit) {
		this.status_IdEdit = status_IdEdit;
	}
	public SalesOrderBean getSalesOrder() {
		return salesOrder;
	}
	public void setSalesOrder(SalesOrderBean salesOrder) {
		this.salesOrder = salesOrder;
	}
	
	 

}
