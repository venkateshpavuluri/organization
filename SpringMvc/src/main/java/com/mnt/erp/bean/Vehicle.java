/**
copyright MNT Soft
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *@version 1.0 29-10-2013
 *@build 0.0
 *
 */
public class Vehicle {
	private int vehicleId;
	private String vehicleTypeId;
	private String vehicleType;
	private String vehicleMade;
	private String vehicleModel;
	private String driverId;
	private String registrationNum;
	private String permit;
	private String advetisementTax;
	private String roadTax;
	private String professionalTax;
	private String insurance;
	private String fitness;
	private String pollution;
	private String createDate;
	private VehicleType vehicleTypeobj;
	
	private int aid;
	
	
	
	private int vehicleIdEdit;
	private String vehicleTypeIdEdit;
	private String vehicleMadeEdit;
	private String vehicleModelEdit;
	private String driverIdEdit;
	private String registrationNumEdit;
	private String permitEdit;
	private String advetisementTaxEdit;
	private String roadTaxEdit;
	private String professionalTaxEdit;
	private String insuranceEdit;
	private String fitnessEdit;
	private String pollutionEdit;
	private String createDateEdit;
	
	
	
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	
	//-------------------- advance search ----------
		private String firstLabel;
		private String secondLabel;
		private String operations1;
		private String advanceSearchText;
		private int advanceSearchHidden;
		
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleTypeId() {
		return vehicleTypeId;
	}
	public void setVehicleTypeId(String vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	
	
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleMade() {
		return vehicleMade;
	}
	public void setVehicleMade(String vehicleMade) {
		this.vehicleMade = vehicleMade;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public String getAdvetisementTax() {
		return advetisementTax;
	}
	public void setAdvetisementTax(String advetisementTax) {
		this.advetisementTax = advetisementTax;
	}
	public String getRoadTax() {
		return roadTax;
	}
	public void setRoadTax(String roadTax) {
		this.roadTax = roadTax;
	}
	public String getProfessionalTax() {
		return professionalTax;
	}
	public void setProfessionalTax(String professionalTax) {
		this.professionalTax = professionalTax;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getFitness() {
		return fitness;
	}
	public void setFitness(String fitness) {
		this.fitness = fitness;
	}
	public String getPollution() {
		return pollution;
	}
	public void setPollution(String pollution) {
		this.pollution = pollution;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	
	
	
	public int getVehicleIdEdit() {
		return vehicleIdEdit;
	}
	public void setVehicleIdEdit(int vehicleIdEdit) {
		this.vehicleIdEdit = vehicleIdEdit;
	}
	
	public String getVehicleTypeIdEdit() {
		return vehicleTypeIdEdit;
	}
	public void setVehicleTypeIdEdit(String vehicleTypeIdEdit) {
		this.vehicleTypeIdEdit = vehicleTypeIdEdit;
	}
	public String getVehicleMadeEdit() {
		return vehicleMadeEdit;
	}
	public void setVehicleMadeEdit(String vehicleMadeEdit) {
		this.vehicleMadeEdit = vehicleMadeEdit;
	}
	public String getVehicleModelEdit() {
		return vehicleModelEdit;
	}
	public void setVehicleModelEdit(String vehicleModelEdit) {
		this.vehicleModelEdit = vehicleModelEdit;
	}
	public String getDriverIdEdit() {
		return driverIdEdit;
	}
	public void setDriverIdEdit(String driverIdEdit) {
		this.driverIdEdit = driverIdEdit;
	}
	public String getRegistrationNumEdit() {
		return registrationNumEdit;
	}
	public void setRegistrationNumEdit(String registrationNumEdit) {
		this.registrationNumEdit = registrationNumEdit;
	}
	public String getPermitEdit() {
		return permitEdit;
	}
	public void setPermitEdit(String permitEdit) {
		this.permitEdit = permitEdit;
	}
	public String getAdvetisementTaxEdit() {
		return advetisementTaxEdit;
	}
	public void setAdvetisementTaxEdit(String advetisementTaxEdit) {
		this.advetisementTaxEdit = advetisementTaxEdit;
	}
	public String getRoadTaxEdit() {
		return roadTaxEdit;
	}
	public void setRoadTaxEdit(String roadTaxEdit) {
		this.roadTaxEdit = roadTaxEdit;
	}
	public String getProfessionalTaxEdit() {
		return professionalTaxEdit;
	}
	public void setProfessionalTaxEdit(String professionalTaxEdit) {
		this.professionalTaxEdit = professionalTaxEdit;
	}
	public String getInsuranceEdit() {
		return insuranceEdit;
	}
	public void setInsuranceEdit(String insuranceEdit) {
		this.insuranceEdit = insuranceEdit;
	}
	public String getFitnessEdit() {
		return fitnessEdit;
	}
	public void setFitnessEdit(String fitnessEdit) {
		this.fitnessEdit = fitnessEdit;
	}
	public String getPollutionEdit() {
		return pollutionEdit;
	}
	public void setPollutionEdit(String pollutionEdit) {
		this.pollutionEdit = pollutionEdit;
	}
	public String getCreateDateEdit() {
		return createDateEdit;
	}
	public void setCreateDateEdit(String createDateEdit) {
		this.createDateEdit = createDateEdit;
	}
	public VehicleType getVehicleTypeobj() {
		return vehicleTypeobj;
	}
	public void setVehicleTypeobj(VehicleType vehicleTypeobj) {
		this.vehicleTypeobj = vehicleTypeobj;
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
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getFirstLabel() {
		return firstLabel;
	}
	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}
	public String getSecondLabel() {
		return secondLabel;
	}
	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}
	public String getOperations1() {
		return operations1;
	}
	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	
	
	
	
}
