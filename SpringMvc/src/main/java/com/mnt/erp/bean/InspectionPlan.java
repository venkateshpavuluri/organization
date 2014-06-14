package com.mnt.erp.bean;

import java.util.List;

public class InspectionPlan {
private int inspectionPlanId;
private int inspectionPlanIdEdit;
private String materialId;
private String inspLotOriginId;
private int aid;
private Material material;
private String materialName;
private InsplotOrigin insplotOrgin;
private String insplotOrginName;
//Basic search Properties
private String xmlLabel;
private String operations;
private String basicSearchId;

//Child Properties
private int[] inspectionEditt;
private int inspectionPlanLineId;
private String processDetailId;
private String inspCharacteristicId;
private String equipmentId;
private List<InspectionPlanLine> inspectionPlanLine;
private int inspectionPlanLineIdEdit;
private String processDetailIdEdit;
private String inspCharacteristicIdEdit;
private String equipmentIdEdit;
private EquipmentBean equipment;
private InspCharacteristic inspectionCharacteristic;
private String equipmentName;
private String inspectionCharName;
private ProcessDetailBean processDetailBean;
private String processDetailName;
public int getInspectionPlanId() {
	return inspectionPlanId;
}
public void setInspectionPlanId(int inspectionPlanId) {
	this.inspectionPlanId = inspectionPlanId;
}
public String getMaterialId() {
	return materialId;
}
public void setMaterialId(String materialId) {
	this.materialId = materialId;
}
public String getInspLotOriginId() {
	return inspLotOriginId;
}
public void setInspLotOriginId(String inspLotOriginId) {
	this.inspLotOriginId = inspLotOriginId;
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

public int getInspectionPlanIdEdit() {
	return inspectionPlanIdEdit;
}
public void setInspectionPlanIdEdit(int inspectionPlanIdEdit) {
	this.inspectionPlanIdEdit = inspectionPlanIdEdit;
}
public List<InspectionPlanLine> getInspectionPlanLine() {
	return inspectionPlanLine;
}
public void setInspectionPlanLine(List<InspectionPlanLine> inspectionPlanLine) {
	this.inspectionPlanLine = inspectionPlanLine;
}
public int getInspectionPlanLineIdEdit() {
	return inspectionPlanLineIdEdit;
}
public void setInspectionPlanLineIdEdit(int inspectionPlanLineIdEdit) {
	this.inspectionPlanLineIdEdit = inspectionPlanLineIdEdit;
}
public String getProcessDetailIdEdit() {
	return processDetailIdEdit;
}
public void setProcessDetailIdEdit(String processDetailIdEdit) {
	this.processDetailIdEdit = processDetailIdEdit;
}
public String getInspCharacteristicIdEdit() {
	return inspCharacteristicIdEdit;
}
public void setInspCharacteristicIdEdit(String inspCharacteristicIdEdit) {
	this.inspCharacteristicIdEdit = inspCharacteristicIdEdit;
}
public String getEquipmentIdEdit() {
	return equipmentIdEdit;
}
public void setEquipmentIdEdit(String equipmentIdEdit) {
	this.equipmentIdEdit = equipmentIdEdit;
}
public EquipmentBean getEquipment() {
	return equipment;
}
public void setEquipment(EquipmentBean equipment) {
	this.equipment = equipment;
}
public InspCharacteristic getInspectionCharacteristic() {
	return inspectionCharacteristic;
}
public void setInspectionCharacteristic(
		InspCharacteristic inspectionCharacteristic) {
	this.inspectionCharacteristic = inspectionCharacteristic;
}
public String getEquipmentName() {
	return equipmentName;
}
public void setEquipmentName(String equipmentName) {
	this.equipmentName = equipmentName;
}
public String getInspectionCharName() {
	return inspectionCharName;
}
public void setInspectionCharName(String inspectionCharName) {
	this.inspectionCharName = inspectionCharName;
}
public ProcessDetailBean getProcessDetailBean() {
	return processDetailBean;
}
public void setProcessDetailBean(ProcessDetailBean processDetailBean) {
	this.processDetailBean = processDetailBean;
}
public String getProcessDetailName() {
	return processDetailName;
}
public void setProcessDetailName(String processDetailName) {
	this.processDetailName = processDetailName;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public int getInspectionPlanLineId() {
	return inspectionPlanLineId;
}
public void setInspectionPlanLineId(int inspectionPlanLineId) {
	this.inspectionPlanLineId = inspectionPlanLineId;
}
public String getProcessDetailId() {
	return processDetailId;
}
public void setProcessDetailId(String processDetailId) {
	this.processDetailId = processDetailId;
}
public String getInspCharacteristicId() {
	return inspCharacteristicId;
}
public void setInspCharacteristicId(String inspCharacteristicId) {
	this.inspCharacteristicId = inspCharacteristicId;
}
public String getEquipmentId() {
	return equipmentId;
}
public void setEquipmentId(String equipmentId) {
	this.equipmentId = equipmentId;
}
public Material getMaterial() {
	return material;
}
public void setMaterial(Material material) {
	this.material = material;
}
public String getMaterialName() {
	return materialName;
}
public void setMaterialName(String materialName) {
	this.materialName = materialName;
}
public InsplotOrigin getInsplotOrgin() {
	return insplotOrgin;
}
public void setInsplotOrgin(InsplotOrigin insplotOrgin) {
	this.insplotOrgin = insplotOrgin;
}
public String getInsplotOrginName() {
	return insplotOrginName;
}
public void setInsplotOrginName(String insplotOrginName) {
	this.insplotOrginName = insplotOrginName;
}
public int[] getInspectionEditt() {
	return inspectionEditt;
}
public void setInspectionEditt(int[] inspectionEditt) {
	this.inspectionEditt = inspectionEditt;
}

}
