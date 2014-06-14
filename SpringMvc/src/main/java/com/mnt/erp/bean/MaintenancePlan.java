package com.mnt.erp.bean;

/*
@author Parvathi 
@version 1.0   
*/
public class MaintenancePlan {
	
	private int maintenancePlan_Id;
	private String maintenanceType_Id;
	private String plant_Id;
	private String equipment_Id;
	private String plannedDT;
	private String shift_Id;
	private String description;
	private String status_Id;
	private maintenanceTypeBean mainTypeBean;
	private Plant plant;
	private ShiftBean shift;
	private EquipmentBean equipmentBean;
	private Status status;
	private String maintenanceTypeName;
	private String plantName;
	private String shiftName;
	private String statusName;
	private String equipmentName;
	private int aid;
	
	//Edit Properties
	
	private int maintenancePlan_IdEdit;
	private String maintenanceType_IdEdit;
	private String plant_IdEdit;
	private String equipment_IdEdit;
	private String plannedDTEdit;
	private String shift_IdEdit;
	private String descriptionEdit;
	private String status_IdEdit;
	
	//Basic Search Properties
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	//getter methods
	
	public int getMaintenancePlan_Id() {
		return maintenancePlan_Id;
	}
	public String getMaintenanceType_Id() {
		return maintenanceType_Id;
	}
	public String getPlant_Id() {
		return plant_Id;
	}
	public String getEquipment_Id() {
		return equipment_Id;
	}
	public String getPlannedDT() {
		return plannedDT;
	}
	public String getShift_Id() {
		return shift_Id;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus_Id() {
		return status_Id;
	}
	public int getMaintenancePlan_IdEdit() {
		return maintenancePlan_IdEdit;
	}
	public String getMaintenanceType_IdEdit() {
		return maintenanceType_IdEdit;
	}
	public String getPlant_IdEdit() {
		return plant_IdEdit;
	}
	public String getEquipment_IdEdit() {
		return equipment_IdEdit;
	}
	public String getPlannedDTEdit() {
		return plannedDTEdit;
	}
	public String getShift_IdEdit() {
		return shift_IdEdit;
	}
	public String getDescriptionEdit() {
		return descriptionEdit;
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
	
	
	

	public String getMaintenanceTypeName() {
		return maintenanceTypeName;
	}
	public String getPlantName() {
		return plantName;
	}
	public String getShiftName() {
		return shiftName;
	}
	public String getStatusName() {
		return statusName;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public int getAid() {
		return aid;
	}
	public maintenanceTypeBean getMainTypeBean() {
		return mainTypeBean;
	}
	public Plant getPlant() {
		return plant;
	}
	public ShiftBean getShift() {
		return shift;
	}
	public EquipmentBean getEquipmentBean() {
		return equipmentBean;
	}
	public Status getStatus() {
		return status;
	}
	//setter methods
	public void setMaintenancePlan_Id(int maintenancePlan_Id) {
		this.maintenancePlan_Id = maintenancePlan_Id;
	}
	public void setMaintenanceType_Id(String maintenanceType_Id) {
		this.maintenanceType_Id = maintenanceType_Id;
	}
	public void setPlant_Id(String plant_Id) {
		this.plant_Id = plant_Id;
	}
	public void setEquipment_Id(String equipment_Id) {
		this.equipment_Id = equipment_Id;
	}
	public void setPlannedDT(String plannedDT) {
		this.plannedDT = plannedDT;
	}
	public void setShift_Id(String shift_Id) {
		this.shift_Id = shift_Id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatus_Id(String status_Id) {
		this.status_Id = status_Id;
	}
	public void setMaintenancePlan_IdEdit(int maintenancePlan_IdEdit) {
		this.maintenancePlan_IdEdit = maintenancePlan_IdEdit;
	}
	public void setMaintenanceType_IdEdit(String maintenanceType_IdEdit) {
		this.maintenanceType_IdEdit = maintenanceType_IdEdit;
	}
	public void setPlant_IdEdit(String plant_IdEdit) {
		this.plant_IdEdit = plant_IdEdit;
	}
	public void setEquipment_IdEdit(String equipment_IdEdit) {
		this.equipment_IdEdit = equipment_IdEdit;
	}
	public void setPlannedDTEdit(String plannedDTEdit) {
		this.plannedDTEdit = plannedDTEdit;
	}
	public void setShift_IdEdit(String shift_IdEdit) {
		this.shift_IdEdit = shift_IdEdit;
	}
	public void setDescriptionEdit(String descriptionEdit) {
		this.descriptionEdit = descriptionEdit;
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
	public void setMainTypeBean(maintenanceTypeBean mainTypeBean) {
		this.mainTypeBean = mainTypeBean;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public void setShift(ShiftBean shift) {
		this.shift = shift;
	}
	public void setEquipmentBean(EquipmentBean equipmentBean) {
		this.equipmentBean = equipmentBean;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setMaintenanceTypeName(String maintenanceTypeName) {
		this.maintenanceTypeName = maintenanceTypeName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
