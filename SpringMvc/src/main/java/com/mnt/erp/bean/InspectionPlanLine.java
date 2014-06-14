package com.mnt.erp.bean;

public class InspectionPlanLine {
private int inspectionPlanLineId;
private String processDetailId;
private String inspCharacteristicId;
private String equipmentId;

//Edit properties
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


}
