/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;
import java.util.Set;

/**
 * @author devi
 *
 */
public class TrainingSchedule {
	private int trainingSchedule_Id;
	private String date;
	private String time;
    private String venue;
    private String triner;
    private String trainingCategoryId;
    private String trainingCategory;
    private String org_Id;
    private String org_Name;
    
    
	//Training Schedule Detail Properties
    private int trainingScheduleDet_Id;
    private String employeeId;
    private String empName;
    
    
    //RelationShip Properties
    private List <TrainingScheduleDetail> trainScheduleDetails;
    private Organization orgDetails;
    private TrainingCategory trainingDetails;
    private Employee empDetails;
    
    //Edit Properties
    private int trainingSchedule_IdEdit;
	private String dateEdit;
	private String timeEdit;
    private String venueEdit;
    private String trainerEdit;
    private String trainingCategoryIdEdit;
    private String trainingCategoryEdit;
    private String org_IdEdit;
    private String org_NameEdit;
    
    
    private String trainingScheduleDet_IdEdit;
    private String employeeIdEdit;
    private String empNameEdit;
    

	/*Basic Search*/
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

				
		/*
		hide properties*/
		
		private int tSchedulehide;
		
		//getters & setters
		


		public int getTrainingSchedule_Id() {
			return trainingSchedule_Id;
		}


		public void setTrainingSchedule_Id(int trainingSchedule_Id) {
			this.trainingSchedule_Id = trainingSchedule_Id;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		public String getVenue() {
			return venue;
		}


		public void setVenue(String venue) {
			this.venue = venue;
		}


		


		public String getTrainingCategoryId() {
			return trainingCategoryId;
		}


		public void setTrainingCategoryId(String trainingCategoryId) {
			this.trainingCategoryId = trainingCategoryId;
		}


		public String getTrainingCategory() {
			return trainingCategory;
		}


		public void setTrainingCategory(String trainingCategory) {
			this.trainingCategory = trainingCategory;
		}


		public String getOrg_Id() {
			return org_Id;
		}


		public void setOrg_Id(String org_Id) {
			this.org_Id = org_Id;
		}


		public String getOrg_Name() {
			return org_Name;
		}


		public void setOrg_Name(String org_Name) {
			this.org_Name = org_Name;
		}


		public int getTrainingScheduleDet_Id() {
			return trainingScheduleDet_Id;
		}


		public void setTrainingScheduleDet_Id(int trainingScheduleDet_Id) {
			this.trainingScheduleDet_Id = trainingScheduleDet_Id;
		}


		public String getEmployeeId() {
			return employeeId;
		}


		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}


		public String getEmpName() {
			return empName;
		}


		public void setEmpName(String empName) {
			this.empName = empName;
		}


		

	


		public List<TrainingScheduleDetail> getTrainScheduleDetails() {
			return trainScheduleDetails;
		}


		public void setTrainScheduleDetails(
				List<TrainingScheduleDetail> trainScheduleDetails) {
			this.trainScheduleDetails = trainScheduleDetails;
		}


		public Organization getOrgDetails() {
			return orgDetails;
		}


		public void setOrgDetails(Organization orgDetails) {
			this.orgDetails = orgDetails;
		}


		public TrainingCategory getTrainingDetails() {
			return trainingDetails;
		}


		public void setTrainingDetails(TrainingCategory trainingDetails) {
			this.trainingDetails = trainingDetails;
		}


		public Employee getEmpDetails() {
			return empDetails;
		}


		public void setEmpDetails(Employee empDetails) {
			this.empDetails = empDetails;
		}


		


		

		public String getDateEdit() {
			return dateEdit;
		}


		public void setDateEdit(String dateEdit) {
			this.dateEdit = dateEdit;
		}


		public String getTimeEdit() {
			return timeEdit;
		}


		public void setTimeEdit(String timeEdit) {
			this.timeEdit = timeEdit;
		}


		public String getVenueEdit() {
			return venueEdit;
		}


		public void setVenueEdit(String venueEdit) {
			this.venueEdit = venueEdit;
		}


		public String getTrainingCategoryIdEdit() {
			return trainingCategoryIdEdit;
		}


		public void setTrainingCategoryIdEdit(String trainingCategoryIdEdit) {
			this.trainingCategoryIdEdit = trainingCategoryIdEdit;
		}


		public String getTrainingCategoryEdit() {
			return trainingCategoryEdit;
		}


		public void setTrainingCategoryEdit(String trainingCategoryEdit) {
			this.trainingCategoryEdit = trainingCategoryEdit;
		}


		public String getOrg_IdEdit() {
			return org_IdEdit;
		}


		public void setOrg_IdEdit(String org_IdEdit) {
			this.org_IdEdit = org_IdEdit;
		}


		public String getOrg_NameEdit() {
			return org_NameEdit;
		}


		public void setOrg_NameEdit(String org_NameEdit) {
			this.org_NameEdit = org_NameEdit;
		}


	


		public int getTrainingSchedule_IdEdit() {
			return trainingSchedule_IdEdit;
		}


		public void setTrainingSchedule_IdEdit(int trainingSchedule_IdEdit) {
			this.trainingSchedule_IdEdit = trainingSchedule_IdEdit;
		}


		public String getTrainingScheduleDet_IdEdit() {
			return trainingScheduleDet_IdEdit;
		}


		public void setTrainingScheduleDet_IdEdit(String trainingScheduleDet_IdEdit) {
			this.trainingScheduleDet_IdEdit = trainingScheduleDet_IdEdit;
		}


		public String getEmployeeIdEdit() {
			return employeeIdEdit;
		}


		public void setEmployeeIdEdit(String employeeIdEdit) {
			this.employeeIdEdit = employeeIdEdit;
		}


		public String getEmpNameEdit() {
			return empNameEdit;
		}


		public void setEmpNameEdit(String empNameEdit) {
			this.empNameEdit = empNameEdit;
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


		public int gettSchedulehide() {
			return tSchedulehide;
		}


		public void settSchedulehide(int tSchedulehide) {
			this.tSchedulehide = tSchedulehide;
		}


		public String getTriner() {
			return triner;
		}


		public void setTriner(String triner) {
			this.triner = triner;
		}


		public String getTrainerEdit() {
			return trainerEdit;
		}


		public void setTrainerEdit(String trainerEdit) {
			this.trainerEdit = trainerEdit;
		}


		    
    
		
		
    
}
