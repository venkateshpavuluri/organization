/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 24-01-2014
 */
public class ProductionOrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int prodOrderId;
	private String prodOrderTypeId;
	private String prodOrderNo;
	private String prodOrderDate;
	private String plantId;
	private String materialId;
	private String uomId;
	private String salesOrderId;
	private String statusId;
	private String totQty;
	private String estStartDate;
	private String estEndDate;
	private String actStartDate;
	private String actEndDate;
	private String priority;
	private String desc;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private ProductionOrderType prodOrderType;
	private SalesOrderBean salesOrder;
	private Material material;
	private Plant plant;
	private Uom uom;
	private Status status;

	// Setter And Getter Methods

	public int getProdOrderId() {
		return prodOrderId;
	}

	public void setProdOrderId(int prodOrderId) {
		this.prodOrderId = prodOrderId;
	}

	public String getProdOrderTypeId() {
		return prodOrderTypeId;
	}

	public void setProdOrderTypeId(String prodOrderTypeId) {
		this.prodOrderTypeId = prodOrderTypeId;
	}

	public String getProdOrderNo() {
		return prodOrderNo;
	}

	public void setProdOrderNo(String prodOrderNo) {
		this.prodOrderNo = prodOrderNo;
	}

	public String getProdOrderDate() {
		return prodOrderDate;
	}

	public void setProdOrderDate(String prodOrderDate) {
		this.prodOrderDate = prodOrderDate;
	}

	public String getPlantId() {
		return plantId;
	}

	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public ProductionOrderType getProdOrderType() {
		return prodOrderType;
	}

	public void setProdOrderType(ProductionOrderType prodOrderType) {
		this.prodOrderType = prodOrderType;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getTotQty() {
		return totQty;
	}

	public void setTotQty(String totQty) {
		this.totQty = totQty;
	}

	public String getEstStartDate() {
		return estStartDate;
	}

	public void setEstStartDate(String estStartDate) {
		this.estStartDate = estStartDate;
	}

	public String getEstEndDate() {
		return estEndDate;
	}

	public void setEstEndDate(String estEndDate) {
		this.estEndDate = estEndDate;
	}

	public String getActStartDate() {
		return actStartDate;
	}

	public void setActStartDate(String actStartDate) {
		this.actStartDate = actStartDate;
	}

	public String getActEndDate() {
		return actEndDate;
	}

	public void setActEndDate(String actEndDate) {
		this.actEndDate = actEndDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public SalesOrderBean getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrderBean salesOrder) {
		this.salesOrder = salesOrder;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
