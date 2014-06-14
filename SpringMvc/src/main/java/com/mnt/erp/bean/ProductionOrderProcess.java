/**
 * @copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author sailajach
 * @version 1.0 05-02-2014
 * @build 0.0
 *
 */
public class ProductionOrderProcess {
	
	private int productionOrderProcessId;
	private String productionOrder;
	private String processdetailid;
	private String workCenter_Id;
	private String startDate;
	private String finishDate;
	private String processdescription;
	private String workCenterName;
	
	private String[] processDetail;
	private String[] workCenter;
	private String[] processDetailEditt;
	private String[] workCenterEditt;
	
	private String[] startedDate;
	private String[] finishedDate;
	private String[] startedDateEditt;
	private String[] finishedDateEditt;
	
	private String productionOrderProcessIdEditt;
	//private int[] productionOrderProcessIdEdit;
	
	private String productionOrderEditt;
	private String processdetailidEditt;
	private String workCenter_IdEditt;
	private String startDateEditt;
	private String finishDateEditt;
	
	private ProcessDetailBean processDetailBean;
	private ProductionOrderBean productionOrderBean;
	private WorkCenter workCenterBean;
	
	private int aid;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	private List<ProductionOrderProcess> popChild;
	
	/*=======================Setter & Getter Methods=====================*/
	public int getProductionOrderProcessId() {
		return productionOrderProcessId;
	}
	public void setProductionOrderProcessId(int productionOrderProcessId) {
		this.productionOrderProcessId = productionOrderProcessId;
	}
	public String getProductionOrder() {
		return productionOrder;
	}
	public void setProductionOrder(String productionOrder) {
		this.productionOrder = productionOrder;
	}
	public String getProcessdetailid() {
		return processdetailid;
	}
	public void setProcessdetailid(String processdetailid) {
		this.processdetailid = processdetailid;
	}
	public String getWorkCenter_Id() {
		return workCenter_Id;
	}
	public void setWorkCenter_Id(String workCenter_Id) {
		this.workCenter_Id = workCenter_Id;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	
	
	
	
	public String getProductionOrderProcessIdEditt() {
		return productionOrderProcessIdEditt;
	}
	public void setProductionOrderProcessIdEditt(
			String productionOrderProcessIdEditt) {
		this.productionOrderProcessIdEditt = productionOrderProcessIdEditt;
	}
	public String getProductionOrderEditt() {
		return productionOrderEditt;
	}
	public void setProductionOrderEditt(String productionOrderEditt) {
		this.productionOrderEditt = productionOrderEditt;
	}
	public String getProcessdetailidEditt() {
		return processdetailidEditt;
	}
	public void setProcessdetailidEditt(String processdetailidEditt) {
		this.processdetailidEditt = processdetailidEditt;
	}
	public String getWorkCenter_IdEditt() {
		return workCenter_IdEditt;
	}
	public void setWorkCenter_IdEditt(String workCenter_IdEditt) {
		this.workCenter_IdEditt = workCenter_IdEditt;
	}
	public String getStartDateEditt() {
		return startDateEditt;
	}
	public void setStartDateEditt(String startDateEditt) {
		this.startDateEditt = startDateEditt;
	}
	public String getFinishDateEditt() {
		return finishDateEditt;
	}
	public void setFinishDateEditt(String finishDateEditt) {
		this.finishDateEditt = finishDateEditt;
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
	public ProcessDetailBean getProcessDetailBean() {
		return processDetailBean;
	}
	public void setProcessDetailBean(ProcessDetailBean processDetailBean) {
		this.processDetailBean = processDetailBean;
	}
	public ProductionOrderBean getProductionOrderBean() {
		return productionOrderBean;
	}
	public void setProductionOrderBean(ProductionOrderBean productionOrderBean) {
		this.productionOrderBean = productionOrderBean;
	}
	public WorkCenter getWorkCenterBean() {
		return workCenterBean;
	}
	public void setWorkCenterBean(WorkCenter workCenterBean) {
		this.workCenterBean = workCenterBean;
	}
	public List<ProductionOrderProcess> getPopChild() {
		return popChild;
	}
	public void setPopChild(List<ProductionOrderProcess> popChild) {
		this.popChild = popChild;
	}
	public String getProcessdescription() {
		return processdescription;
	}
	public void setProcessdescription(String processdescription) {
		this.processdescription = processdescription;
	}
	public String getWorkCenterName() {
		return workCenterName;
	}
	public void setWorkCenterName(String workCenterName) {
		this.workCenterName = workCenterName;
	}
	public String[] getProcessDetail() {
		return processDetail;
	}
	public void setProcessDetail(String[] processDetail) {
		this.processDetail = processDetail;
	}
	public String[] getWorkCenter() {
		return workCenter;
	}
	public void setWorkCenter(String[] workCenter) {
		this.workCenter = workCenter;
	}
	public String[] getProcessDetailEditt() {
		return processDetailEditt;
	}
	public void setProcessDetailEditt(String[] processDetailEditt) {
		this.processDetailEditt = processDetailEditt;
	}
	public String[] getWorkCenterEditt() {
		return workCenterEditt;
	}
	public void setWorkCenterEditt(String[] workCenterEditt) {
		this.workCenterEditt = workCenterEditt;
	}
	public String[] getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(String[] startedDate) {
		this.startedDate = startedDate;
	}
	public String[] getFinishedDate() {
		return finishedDate;
	}
	public void setFinishedDate(String[] finishedDate) {
		this.finishedDate = finishedDate;
	}
	public String[] getStartedDateEditt() {
		return startedDateEditt;
	}
	public void setStartedDateEditt(String[] startedDateEditt) {
		this.startedDateEditt = startedDateEditt;
	}
	public String[] getFinishedDateEditt() {
		return finishedDateEditt;
	}
	public void setFinishedDateEditt(String[] finishedDateEditt) {
		this.finishedDateEditt = finishedDateEditt;
	}
	
	/*public int[] getProductionOrderProcessIdEdit() {
		return productionOrderProcessIdEdit;
	}
	public void setProductionOrderProcessIdEdit(int[] productionOrderProcessIdEdit) {
		this.productionOrderProcessIdEdit = productionOrderProcessIdEdit;
	}
	*/
	

}
