/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0  16-04-2014
 */
public class BreakDownMaintenance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int breakdownMaintenace_Id;
	private String breakDownNo;
	private String department_Id;
	private String equipment_Id;
	private String problem;
	private String recordedDT;
    private String maintenanceProblemType_Id;
	private String status_Id;
	private int aid;
	private int breakhide;
	private int breakdupedit;
	private int breakdownMaintenace_IdEdit;
	private String department_IdEdit;
	private String equipment_IdEdit;
	private String problemEdit;
	private String recordedDTEdit;
    private String maintenanceProblemType_IdEdit;
	private String status_IdEdit;
	private String xmlLabel;
    private String operations;
    private String basicSearchId;
    private Department deptBean;
    private EquipmentBean equiBean;
    private MaintenanceProblemType mptBean;
    private Status statusBean;
    
    //Setter And Getter Methods
    
	public int getBreakdownMaintenace_Id() {
		return breakdownMaintenace_Id;
	}
	public void setBreakdownMaintenace_Id(int breakdownMaintenace_Id) {
		this.breakdownMaintenace_Id = breakdownMaintenace_Id;
	}
	public String getDepartment_Id() {
		return department_Id;
	}
	public void setDepartment_Id(String department_Id) {
		this.department_Id = department_Id;
	}
	public String getEquipment_Id() {
		return equipment_Id;
	}
	public void setEquipment_Id(String equipment_Id) {
		this.equipment_Id = equipment_Id;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getRecordedDT() {
		return recordedDT;
	}
	public void setRecordedDT(String recordedDT) {
		this.recordedDT = recordedDT;
	}
	public String getMaintenanceProblemType_Id() {
		return maintenanceProblemType_Id;
	}
	public void setMaintenanceProblemType_Id(String maintenanceProblemType_Id) {
		this.maintenanceProblemType_Id = maintenanceProblemType_Id;
	}
	public String getStatus_Id() {
		return status_Id;
	}
	public String getBreakDownNo() {
		return breakDownNo;
	}
	public void setBreakDownNo(String breakDownNo) {
		this.breakDownNo = breakDownNo;
	}
	public void setStatus_Id(String status_Id) {
		this.status_Id = status_Id;
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
	public Department getDeptBean() {
		return deptBean;
	}
	public void setDeptBean(Department deptBean) {
		this.deptBean = deptBean;
	}
	public EquipmentBean getEquiBean() {
		return equiBean;
	}
	public void setEquiBean(EquipmentBean equiBean) {
		this.equiBean = equiBean;
	}
	public MaintenanceProblemType getMptBean() {
		return mptBean;
	}
	public void setMptBean(MaintenanceProblemType mptBean) {
		this.mptBean = mptBean;
	}
	public Status getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(Status statusBean) {
		this.statusBean = statusBean;
	}
}
