/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 16-04-2014
 */
public class WorkInProgressBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int wipId;
	private String jobcardId;
	private String workDay;
	private String shiftId;
	private String workcenterId;
	private String equipmentId;
	private String empId;
	private String uomId;
	private String qtyPlanned;
	private String qtyManufactured;

	private Double qtyAccepted;
	private Double qtyRejected;
	private Double qtyRework;
	private Double qtyRerun;
	private Double toBeInspected;
	private Double electricalMain;
	private Double mechanicalmain;
	private Double idleTime;
	private Double setUpTime;
	private Double waitingTime;
	private Double unloadingTime;
	private Double other;
	private String remarks;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private ShiftBean shiftBean;
	private WorkCenter workBean;
	private EquipmentBean eqipBean;
	private Uom uomBean;
	private JobCardBean jobCardBean;

	// private Employee empBean;

	// Setter And Getter Methods

	public int getWipId() {
		return wipId;
	}

	public String getJobcardId() {
		return jobcardId;
	}

	public String getWorkDay() {
		return workDay;
	}

	public String getShiftId() {
		return shiftId;
	}

	public String getWorkcenterId() {
		return workcenterId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public String getEmpId() {
		return empId;
	}

	public String getQtyPlanned() {
		return qtyPlanned;
	}

	public String getQtyManufactured() {
		return qtyManufactured;
	}

	public String getXmlLabel() {
		return xmlLabel;
	}

	public String getOperations() {
		return operations;
	}

	public String getBasicSearchId() {
		return basicSearchId;
	}

	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

	public String getUomId() {
		return uomId;
	}

	public ShiftBean getShiftBean() {
		return shiftBean;
	}

	public WorkCenter getWorkBean() {
		return workBean;
	}

	public JobCardBean getJobCardBean() {
		return jobCardBean;
	}

	public void setJobCardBean(JobCardBean jobCardBean) {
		this.jobCardBean = jobCardBean;
	}

	public EquipmentBean getEqipBean() {
		return eqipBean;
	}

	public Uom getUomBean() {
		return uomBean;
	}

	public void setShiftBean(ShiftBean shiftBean) {
		this.shiftBean = shiftBean;
	}

	public void setWorkBean(WorkCenter workBean) {
		this.workBean = workBean;
	}

	public void setEqipBean(EquipmentBean eqipBean) {
		this.eqipBean = eqipBean;
	}

	public void setUomBean(Uom uomBean) {
		this.uomBean = uomBean;
	}

	public void setWipId(int wipId) {
		this.wipId = wipId;
	}

	public void setJobcardId(String jobcardId) {
		this.jobcardId = jobcardId;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public void setWorkcenterId(String workcenterId) {
		this.workcenterId = workcenterId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setQtyPlanned(String qtyPlanned) {
		this.qtyPlanned = qtyPlanned;
	}

	public void setQtyManufactured(String qtyManufactured) {
		this.qtyManufactured = qtyManufactured;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public Double getQtyAccepted() {
		return qtyAccepted;
	}

	public Double getQtyRejected() {
		return qtyRejected;
	}

	public Double getQtyRework() {
		return qtyRework;
	}

	public Double getQtyRerun() {
		return qtyRerun;
	}

	public Double getToBeInspected() {
		return toBeInspected;
	}

	public Double getElectricalMain() {
		return electricalMain;
	}

	public Double getMechanicalmain() {
		return mechanicalmain;
	}

	public Double getIdleTime() {
		return idleTime;
	}

	public Double getSetUpTime() {
		return setUpTime;
	}

	public Double getWaitingTime() {
		return waitingTime;
	}

	public Double getUnloadingTime() {
		return unloadingTime;
	}

	public Double getOther() {
		return other;
	}

	public void setQtyAccepted(Double qtyAccepted) {
		this.qtyAccepted = qtyAccepted;
	}

	public void setQtyRejected(Double qtyRejected) {
		this.qtyRejected = qtyRejected;
	}

	public void setQtyRework(Double qtyRework) {
		this.qtyRework = qtyRework;
	}

	public void setQtyRerun(Double qtyRerun) {
		this.qtyRerun = qtyRerun;
	}

	public void setToBeInspected(Double toBeInspected) {
		this.toBeInspected = toBeInspected;
	}

	public void setElectricalMain(Double electricalMain) {
		this.electricalMain = electricalMain;
	}

	public void setMechanicalmain(Double mechanicalmain) {
		this.mechanicalmain = mechanicalmain;
	}

	public void setIdleTime(Double idleTime) {
		this.idleTime = idleTime;
	}

	public void setSetUpTime(Double setUpTime) {
		this.setUpTime = setUpTime;
	}

	public void setWaitingTime(Double waitingTime) {
		this.waitingTime = waitingTime;
	}

	public void setUnloadingTime(Double unloadingTime) {
		this.unloadingTime = unloadingTime;
	}

	public void setOther(Double other) {
		this.other = other;
	}

	/*
	 * public Employee getEmpBean() { return empBean; }
	 * 
	 * public void setEmpBean(Employee empBean) { this.empBean = empBean; }
	 */

}
