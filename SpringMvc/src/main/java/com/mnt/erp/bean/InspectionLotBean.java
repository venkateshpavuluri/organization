/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 07-01-2014
 */
public class InspectionLotBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int inspLotNoId;
	private String inspLotNo;
	private String plantId;
	private String materialId;
	private String inspTypeId;
	private String inspLotOriginId;
	private String statusId;
	private String refNo;
	private String subRefNo;
	private String quantity;
	private String uomId;
	private String desc;
	private String batchNo;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String avalQty;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	private Material material;
	private Plant plant;
	private Uom uom;
	private InspectionType inspType;
	private InsplotOrigin inspLotOrg;
	private Status status;
	private List<InspLotEqpBean> inspLotEqpList;
	
	//child variables
	private int[] inspLotEqpId;
	private String[] equipmentId;
	private String eqpName;
	
	//Setter And Getter Methods
	
	public int getInspLotNoId() {
		return inspLotNoId;
	}
	public String getInspLotNo() {
		return inspLotNo;
	}
	public String getPlantId() {
		return plantId;
	}
	public String getMaterialId() {
		return materialId;
	}
	public String getInspTypeId() {
		return inspTypeId;
	}
	public String getInspLotOriginId() {
		return inspLotOriginId;
	}
	public String getRefNo() {
		return refNo;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getUomId() {
		return uomId;
	}
	
	public String getDesc() {
		return desc;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getSubRefNo() {
		return subRefNo;
	}
	public void setSubRefNo(String subRefNo) {
		this.subRefNo = subRefNo;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setInspLotNoId(int inspLotNoId) {
		this.inspLotNoId = inspLotNoId;
	}
	public String getAvalQty() {
		return avalQty;
	}
	public void setAvalQty(String avalQty) {
		this.avalQty = avalQty;
	}
	public String getLabels() {
		return labels;
	}
	public String getDbField() {
		return dbField;
	}
	public String getAsOpts() {
		return asOpts;
	}
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	public void setDbField(String dbField) {
		this.dbField = dbField;
	}
	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public void setInspLotNo(String inspLotNo) {
		this.inspLotNo = inspLotNo;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public void setInspTypeId(String inspTypeId) {
		this.inspTypeId = inspTypeId;
	}
	public void setInspLotOriginId(String inspLotOriginId) {
		this.inspLotOriginId = inspLotOriginId;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<InspLotEqpBean> getInspLotEqpList() {
		return inspLotEqpList;
	}
	public int[] getInspLotEqpId() {
		return inspLotEqpId;
	}
	public String[] getEquipmentId() {
		return equipmentId;
	}
	public String getEqpName() {
		return eqpName;
	}
	public void setInspLotEqpList(List<InspLotEqpBean> inspLotEqpList) {
		this.inspLotEqpList = inspLotEqpList;
	}
	public void setInspLotEqpId(int[] inspLotEqpId) {
		this.inspLotEqpId = inspLotEqpId;
	}
	public void setEquipmentId(String[] equipmentId) {
		this.equipmentId = equipmentId;
	}
	public void setEqpName(String eqpName) {
		this.eqpName = eqpName;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	public Material getMaterial() {
		return material;
	}
	public Plant getPlant() {
		return plant;
	}
	public Uom getUom() {
		return uom;
	}
	public InspectionType getInspType() {
		return inspType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public InsplotOrigin getInspLotOrg() {
		return inspLotOrg;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public void setInspType(InspectionType inspType) {
		this.inspType = inspType;
	}
	public void setInspLotOrg(InsplotOrigin inspLotOrg) {
		this.inspLotOrg = inspLotOrg;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	
	
	

}
