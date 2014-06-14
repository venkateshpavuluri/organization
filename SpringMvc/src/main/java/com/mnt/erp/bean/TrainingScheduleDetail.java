/**
 * 
 */
package com.mnt.erp.bean;

import java.util.Set;

/**
 * @author devi
 *
 */
public class TrainingScheduleDetail {
	private int trainingScheduleDet_Id;
	private int trainingSchedule_Id;
	private int employeeId;
	private String empName;
	
	
	
	//RelationShip Properties
           private Employee empDetails;



		public String getEmpName() {
			return empName;
		}



		public void setEmpName(String empName) {
			this.empName = empName;
		}



		public int getTrainingScheduleDet_Id() {
			return trainingScheduleDet_Id;
		}



		public void setTrainingScheduleDet_Id(int trainingScheduleDet_Id) {
			this.trainingScheduleDet_Id = trainingScheduleDet_Id;
		}



		public int getTrainingSchedule_Id() {
			return trainingSchedule_Id;
		}



		public void setTrainingSchedule_Id(int trainingSchedule_Id) {
			this.trainingSchedule_Id = trainingSchedule_Id;
		}






		public int getEmployeeId() {
			return employeeId;
		}



		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}



		public Employee getEmpDetails() {
			return empDetails;
		}



		public void setEmpDetails(Employee empDetails) {
			this.empDetails = empDetails;
		}
           

           
           
}
