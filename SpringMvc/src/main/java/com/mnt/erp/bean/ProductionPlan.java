package com.mnt.erp.bean;

import java.util.List;



/*
@author Parvathi
@version 1.0   
*/
public class ProductionPlan {

	private int productionPlan_Id;
	private String productionPlanType_Id;
	private String planDate;
	private String plant_Id;
	private String project_Id;
	private String status_Id;
	private int aid;

	private productionPlanTypeBean productionPlanType;
	private Plant plant;
	private Project project;
	private Status status;
	private Material meterial;
	private Uom uom;
	private ProductionOrderBean productionOrder;
	private String productionPlanTypeName;
	private String plantName;
	private String projectName;
	private String statusName;
	private String materialName;
	private String uomName;
	
	
	//ProductionPlanLine properties
	
	private List<ProductionPlanLine> productionPlanLine;
	private int productionPlanLine_Id;
	private String material_Id;
	private String qty;
	private String uOM_Id;
	private String startDT;
	private String finishDT;
	private String productionOrder_Id;
	private String productionOrderNumber;
	
	//ProductionPlanLine Edit properties
	
	public String getProductionOrderNumber() {
		return productionOrderNumber;
	}
	public void setProductionOrderNumber(String productionOrderNumber) {
		this.productionOrderNumber = productionOrderNumber;
	}
	private int productionPlanLine_IdEdit;
	private int[] productionPlanLine_IdEditt;
	private String material_IdEdit;
	private String qtyEdit;
	private String uOM_IdEdit;
	private String startDTEdit;
	private String finishDTEdit;
	private String productionOrder_IdEdit;
	
	//Edit Properties
	private int productionPlan_IdEdit;
	private String productionPlanType_IdEdit;
	private String planDateEdit;
	private String plant_IdEdit;
	private String project_IdEdit;
	private String status_IdEdit;
	
	//Basic Search Properties
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	
	//getter methods
	
	public int getProductionPlan_Id() {
		return productionPlan_Id;
	}
	public String getProductionPlanType_Id() {
		return productionPlanType_Id;
	}
	public String getPlanDate() {
		return planDate;
	}
	public String getPlant_Id() {
		return plant_Id;
	}
	public String getProject_Id() {
		return project_Id;
	}
	public String getStatus_Id() {
		return status_Id;
	}
	public int getAid() {
		return aid;
	}
	public productionPlanTypeBean getProductionPlanType() {
		return productionPlanType;
	}
	public Plant getPlant() {
		return plant;
	}
	public Project getProject() {
		return project;
	}
	public Status getStatus() {
		return status;
	}
	public Material getMeterial() {
		return meterial;
	}
	public Uom getUom() {
		return uom;
	}
	public String getProductionPlanTypeName() {
		return productionPlanTypeName;
	}
	public String getPlantName() {
		return plantName;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getStatusName() {
		return statusName;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getUomName() {
		return uomName;
	}
	public int getProductionPlan_IdEdit() {
		return productionPlan_IdEdit;
	}
	public String getProductionPlanType_IdEdit() {
		return productionPlanType_IdEdit;
	}
	public String getPlanDateEdit() {
		return planDateEdit;
	}
	public String getPlant_IdEdit() {
		return plant_IdEdit;
	}
	public String getProject_IdEdit() {
		return project_IdEdit;
	}
	public String getStatus_IdEdit() {
		return status_IdEdit;
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
	
	public ProductionOrderBean getProductionOrder() {
		return productionOrder;
	}
	public List<ProductionPlanLine> getProductionPlanLine() {
		return productionPlanLine;
	}
	public int getProductionPlanLine_Id() {
		return productionPlanLine_Id;
	}
	public String getMaterial_Id() {
		return material_Id;
	}
	public String getQty() {
		return qty;
	}
	public String getuOM_Id() {
		return uOM_Id;
	}
	public String getStartDT() {
		return startDT;
	}
	public String getFinishDT() {
		return finishDT;
	}
	public String getProductionOrder_Id() {
		return productionOrder_Id;
	}
	public int getProductionPlanLine_IdEdit() {
		return productionPlanLine_IdEdit;
	}
	public String getMaterial_IdEdit() {
		return material_IdEdit;
	}
	public String getQtyEdit() {
		return qtyEdit;
	}
	public String getuOM_IdEdit() {
		return uOM_IdEdit;
	}
	public String getStartDTEdit() {
		return startDTEdit;
	}
	public String getFinishDTEdit() {
		return finishDTEdit;
	}
	public String getProductionOrder_IdEdit() {
		return productionOrder_IdEdit;
	}
	
	
	
	
	
	
	
	
	
	
	//setter methods
	

	public void setProductionPlan_Id(int productionPlan_Id) {
		this.productionPlan_Id = productionPlan_Id;
	}
	public void setProductionPlanType_Id(String productionPlanType_Id) {
		this.productionPlanType_Id = productionPlanType_Id;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public void setPlant_Id(String plant_Id) {
		this.plant_Id = plant_Id;
	}
	public void setProject_Id(String project_Id) {
		this.project_Id = project_Id;
	}
	public void setStatus_Id(String status_Id) {
		this.status_Id = status_Id;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setProductionPlanType(productionPlanTypeBean productionPlanType) {
		this.productionPlanType = productionPlanType;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setMeterial(Material meterial) {
		this.meterial = meterial;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public void setProductionPlanTypeName(String productionPlanTypeName) {
		this.productionPlanTypeName = productionPlanTypeName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public void setProductionPlan_IdEdit(int productionPlan_IdEdit) {
		this.productionPlan_IdEdit = productionPlan_IdEdit;
	}
	public void setProductionPlanType_IdEdit(String productionPlanType_IdEdit) {
		this.productionPlanType_IdEdit = productionPlanType_IdEdit;
	}
	public void setPlanDateEdit(String planDateEdit) {
		this.planDateEdit = planDateEdit;
	}
	public void setPlant_IdEdit(String plant_IdEdit) {
		this.plant_IdEdit = plant_IdEdit;
	}
	
	public void setProductionOrder(ProductionOrderBean productionOrder) {
		this.productionOrder = productionOrder;
	}
	public void setProject_IdEdit(String project_IdEdit) {
		this.project_IdEdit = project_IdEdit;
	}
	public void setStatus_IdEdit(String status_IdEdit) {
		this.status_IdEdit = status_IdEdit;
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
	public void setProductionPlanLine(List<ProductionPlanLine> productionPlanLine) {
		this.productionPlanLine = productionPlanLine;
	}
	public void setProductionPlanLine_Id(int productionPlanLine_Id) {
		this.productionPlanLine_Id = productionPlanLine_Id;
	}
	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public void setuOM_Id(String uOM_Id) {
		this.uOM_Id = uOM_Id;
	}
	public void setStartDT(String startDT) {
		this.startDT = startDT;
	}
	public void setFinishDT(String finishDT) {
		this.finishDT = finishDT;
	}
	public void setProductionOrder_Id(String productionOrder_Id) {
		this.productionOrder_Id = productionOrder_Id;
	}
	public void setProductionPlanLine_IdEdit(int productionPlanLine_IdEdit) {
		this.productionPlanLine_IdEdit = productionPlanLine_IdEdit;
	}
	public void setMaterial_IdEdit(String material_IdEdit) {
		this.material_IdEdit = material_IdEdit;
	}
	public void setQtyEdit(String qtyEdit) {
		this.qtyEdit = qtyEdit;
	}
	public void setuOM_IdEdit(String uOM_IdEdit) {
		this.uOM_IdEdit = uOM_IdEdit;
	}
	public void setStartDTEdit(String startDTEdit) {
		this.startDTEdit = startDTEdit;
	}
	public void setFinishDTEdit(String finishDTEdit) {
		this.finishDTEdit = finishDTEdit;
	}
	public void setProductionOrder_IdEdit(String productionOrder_IdEdit) {
		this.productionOrder_IdEdit = productionOrder_IdEdit;
	}
	public int[] getProductionPlanLine_IdEditt() {
		return productionPlanLine_IdEditt;
	}
	public void setProductionPlanLine_IdEditt(int[] productionPlanLine_IdEditt) {
		this.productionPlanLine_IdEditt = productionPlanLine_IdEditt;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
