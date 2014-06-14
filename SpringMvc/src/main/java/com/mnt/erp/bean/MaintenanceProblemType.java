/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class MaintenanceProblemType {
	private int maintenanceProblemType_Id;
	private String maintenanceProblemType;
	private int aid;

//Basic Search Properties

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

//Edit Properties
	private int maintenanceProblemType_IdEdit;
	private String maintenanceProblemTypeEdit;
	public int getMaintenanceProblemType_Id() {
		return maintenanceProblemType_Id;
	}
	public void setMaintenanceProblemType_Id(int maintenanceProblemType_Id) {
		this.maintenanceProblemType_Id = maintenanceProblemType_Id;
	}
	public String getMaintenanceProblemType() {
		return maintenanceProblemType;
	}
	public void setMaintenanceProblemType(String maintenanceProblemType) {
		this.maintenanceProblemType = maintenanceProblemType;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public int getMaintenanceProblemType_IdEdit() {
		return maintenanceProblemType_IdEdit;
	}
	public void setMaintenanceProblemType_IdEdit(int maintenanceProblemType_IdEdit) {
		this.maintenanceProblemType_IdEdit = maintenanceProblemType_IdEdit;
	}
	public String getMaintenanceProblemTypeEdit() {
		return maintenanceProblemTypeEdit;
	}
	public void setMaintenanceProblemTypeEdit(String maintenanceProblemTypeEdit) {
		this.maintenanceProblemTypeEdit = maintenanceProblemTypeEdit;
	}

}
