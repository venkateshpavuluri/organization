/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author Naresh
 * @version 1.0 14-05-2014
 * 
 */
public class ProdOrderProcessBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int popId;
	private String prodOrderId;
	private String processDetailId;
	private String workCenterId;
	private String startDate;
	private String endDate;
	private String inspPoint;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private ProcessDetailBean processDetail;
	private ProductionOrderBean productionOrder;
	private WorkCenter workCenter;

	private Set<ProdOrderProcessEqp> popEqp;
	private List<ProdProcessEmpBean> popEmp;
	
	//Child Variables
	private int[] popEqpId;
	private int[] popEmpId;
	private String[] empId;
	private String[] equipmentId;
	private String[] uomId;
	private Double[] estimatedCost;
	private String empNo;
	private String eqpName;
	private String uomName;
	
	// Setter and Getter Methods

	public int getPopId() {
		return popId;
	}

	public String getProdOrderId() {
		return prodOrderId;
	}

	public String getProcessDetailId() {
		return processDetailId;
	}

	public String getWorkCenterId() {
		return workCenterId;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setPopId(int popId) {
		this.popId = popId;
	}

	public void setProdOrderId(String prodOrderId) {
		this.prodOrderId = prodOrderId;
	}

	public void setProcessDetailId(String processDetailId) {
		this.processDetailId = processDetailId;
	}

	public void setWorkCenterId(String workCenterId) {
		this.workCenterId = workCenterId;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getInspPoint() {
		return inspPoint;
	}

	public void setInspPoint(String inspPoint) {
		this.inspPoint = inspPoint;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public ProcessDetailBean getProcessDetail() {
		return processDetail;
	}

	public ProductionOrderBean getProductionOrder() {
		return productionOrder;
	}

	public WorkCenter getWorkCenter() {
		return workCenter;
	}

	public void setProcessDetail(ProcessDetailBean processDetail) {
		this.processDetail = processDetail;
	}

	public void setProductionOrder(ProductionOrderBean productionOrder) {
		this.productionOrder = productionOrder;
	}

	public void setWorkCenter(WorkCenter workCenter) {
		this.workCenter = workCenter;
	}

	public Set<ProdOrderProcessEqp> getPopEqp() {
		return popEqp;
	}

	public int[] getPopEqpId() {
		return popEqpId;
	}

	public int[] getPopEmpId() {
		return popEmpId;
	}

	public void setPopEqpId(int[] popEqpId) {
		this.popEqpId = popEqpId;
	}

	public void setPopEmpId(int[] popEmpId) {
		this.popEmpId = popEmpId;
	}

	public List<ProdProcessEmpBean> getPopEmp() {
		return popEmp;
	}

	public void setPopEqp(Set<ProdOrderProcessEqp> popEqp) {
		this.popEqp = popEqp;
	}

	public void setPopEmp(List<ProdProcessEmpBean> popEmp) {
		this.popEmp = popEmp;
	}

	public String[] getEmpId() {
		return empId;
	}

	public String[] getEquipmentId() {
		return equipmentId;
	}

	public String[] getUomId() {
		return uomId;
	}

	public Double[] getEstimatedCost() {
		return estimatedCost;
	}

	public void setEmpId(String[] empId) {
		this.empId = empId;
	}

	public void setEquipmentId(String[] equipmentId) {
		this.equipmentId = equipmentId;
	}

	public void setUomId(String[] uomId) {
		this.uomId = uomId;
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getEqpName() {
		return eqpName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public void setEqpName(String eqpName) {
		this.eqpName = eqpName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public void setEstimatedCost(Double[] estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

}
