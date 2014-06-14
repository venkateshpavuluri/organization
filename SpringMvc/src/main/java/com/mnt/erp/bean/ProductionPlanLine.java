package com.mnt.erp.bean;



/*
@author Parvathi
@version 1.0   
*/
public class ProductionPlanLine {

	private int productionPlanLine_Id;
	private int productionPlan_Id;
	private String material_Id;
	private String qty;
	private String uOM_Id;
	private String startDT;
	private String finishDT;
	private String productionOrder_Id;
	
	
	
	private Material material;
	private Uom uom;
	private ProductionOrderBean productionOrder;
	private String materialName;
	private String uomName;
	private String productionOrderNumber;
	
	
	//Edit Properties
	private int productionPlanLine_IdEdit;
	private int productionPlan_IdEdit;
	private String material_IdEdit;
	private String qtyEdit;
	private String uOM_IdEdit;
	private String startDTEdit;
	private String finishDTEdit;
	private String productionOrder_IdEdit;
	
	
	//getter methods
	public int getProductionPlanLine_Id() {
		return productionPlanLine_Id;
	}
	public int getProductionPlan_Id() {
		return productionPlan_Id;
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
	public Material getMaterial() {
		return material;
	}
	public Uom getUom() {
		return uom;
	}
	public ProductionOrderBean getProductionOrder() {
		return productionOrder;
	}
	public String getMaterialName() {
		return materialName;
	}
	public String getUomName() {
		return uomName;
	}
	public String getProductionOrderNumber() {
		return productionOrderNumber;
	}
	public int getProductionPlanLine_IdEdit() {
		return productionPlanLine_IdEdit;
	}
	public int getProductionPlan_IdEdit() {
		return productionPlan_IdEdit;
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
	
	
	public void setProductionPlanLine_Id(int productionPlanLine_Id) {
		this.productionPlanLine_Id = productionPlanLine_Id;
	}
	public void setProductionPlan_Id(int productionPlan_Id) {
		this.productionPlan_Id = productionPlan_Id;
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
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public void setProductionOrder(ProductionOrderBean productionOrder) {
		this.productionOrder = productionOrder;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public void setProductionOrderNumber(String productionOrderNumber) {
		this.productionOrderNumber = productionOrderNumber;
	}
	public void setProductionPlanLine_IdEdit(int productionPlanLine_IdEdit) {
		this.productionPlanLine_IdEdit = productionPlanLine_IdEdit;
	}
	public void setProductionPlan_IdEdit(int productionPlan_IdEdit) {
		this.productionPlan_IdEdit = productionPlan_IdEdit;
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
	

	
	
	
	
	
	
	
	
	
}
