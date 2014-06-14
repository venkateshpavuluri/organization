/**
 * 
 */
package com.mnt.erp.bean;

import java.util.Set;

/**
 * @author devi
 *
 */
public class Vacancy {
	private int	vacancyId;
	private String 	postedDate;
	private String vacancyNo;
	private String employee; 
	private String vendorId;
	private String vendorName;
	private String vendorEmail;
	private String vendorEmailId;
	
	public String getVendorEmailId() {
		return vendorEmailId;
	}

	public void setVendorEmailId(String vendorEmailId) {
		this.vendorEmailId = vendorEmailId;
	}




	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}




	/*VacancyLine Properties*/
	private int vacancyDetailLine;
	private String vacancy;
	private String departmentId;
	private String department;
	private String skillId;
	private String skill;
	private String noOfPositions;
	private String statusId;
	private String status;
	private String vacancyDetailNo;


	/*RelationShip Properties*/

	private Set<VacancyDetailLine> vacancyDetails;
	private Department deptDetails;
	private Status statusDetails;
	private Skill skillDetails;


	/*Vacancy Edit Properties*/

	private int	vacancyIdEdit;
	private String 	postedDateEdit;
	private String vacancyNoEdit;
	
	/*VacancyDetailLine Edit Properties*/
	private String vacancyLineidedit;
	
	private String departmentIdEdit;
	private String departmentEdit;
	private String skillIdEdit;
	private String skillEdit;
	private String noOfPositionsEdit;
	private String statusIdEdit;
	private String statusEdit;
 
	private String vacancyEdit;
	private String vacancyDetailNoEdit;
	
	/*Basic Search*/
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

				
		/*
		hide properties*/
		
		private int vacancyhide;
		
		
		public String getVacancyNo() {
			return vacancyNo;
		}

		public void setVacancyNo(String vacancyNo) {
			this.vacancyNo = vacancyNo;
		}

		public String getVacancyNoEdit() {
			return vacancyNoEdit;
		}

		public void setVacancyNoEdit(String vacancyNoEdit) {
			this.vacancyNoEdit = vacancyNoEdit;
		}


	public String getVacancyDetailNo() {
		return vacancyDetailNo;
	}

	public void setVacancyDetailNo(String vacancyDetailNo) {
		this.vacancyDetailNo = vacancyDetailNo;
	}

	public String getVacancyDetailNoEdit() {
		return vacancyDetailNoEdit;
	}

	public void setVacancyDetailNoEdit(String vacancyDetailNoEdit) {
		this.vacancyDetailNoEdit = vacancyDetailNoEdit;
	}


		
		//generate getters & setters
		

		public int getVacancyId() {
			return vacancyId;
		}

		public void setVacancyId(int vacancyId) {
			this.vacancyId = vacancyId;
		}

		public String getPostedDate() {
			return postedDate;
		}

		public void setPostedDate(String postedDate) {
			this.postedDate = postedDate;
		}

		public int getVacancyDetailLine() {
			return vacancyDetailLine;
		}

		public void setVacancyDetailLine(int vacancyDetailLine) {
			this.vacancyDetailLine = vacancyDetailLine;
		}

		public String getVacancy() {
			return vacancy;
		}

		public void setVacancy(String vacancy) {
			this.vacancy = vacancy;
		}

	

		
		

		public Set<VacancyDetailLine> getVacancyDetails() {
			return vacancyDetails;
		}

		public void setVacancyDetails(Set<VacancyDetailLine> vacancyDetails) {
			this.vacancyDetails = vacancyDetails;
		}

		public Department getDeptDetails() {
			return deptDetails;
		}

		public void setDeptDetails(Department deptDetails) {
			this.deptDetails = deptDetails;
		}

		public Status getStatusDetails() {
			return statusDetails;
		}

		public void setStatusDetails(Status statusDetails) {
			this.statusDetails = statusDetails;
		}

		public Skill getSkillDetails() {
			return skillDetails;
		}

		public void setSkillDetails(Skill skillDetails) {
			this.skillDetails = skillDetails;
		}

		public int getVacancyIdEdit() {
			return vacancyIdEdit;
		}

		public void setVacancyIdEdit(int vacancyIdEdit) {
			this.vacancyIdEdit = vacancyIdEdit;
		}

		public String getPostedDateEdit() {
			return postedDateEdit;
		}

		public void setPostedDateEdit(String postedDateEdit) {
			this.postedDateEdit = postedDateEdit;
		}

		

		public String getVacancyLineidedit() {
			return vacancyLineidedit;
		}

		public void setVacancyLineidedit(String vacancyLineidedit) {
			this.vacancyLineidedit = vacancyLineidedit;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		

		public String getDepartmentEdit() {
			return departmentEdit;
		}

		public void setDepartmentEdit(String departmentEdit) {
			this.departmentEdit = departmentEdit;
		}

		

		

		public String getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}

		public String getSkillId() {
			return skillId;
		}

		public void setSkillId(String skillId) {
			this.skillId = skillId;
		}

		public String getNoOfPositions() {
			return noOfPositions;
		}

		public void setNoOfPositions(String noOfPositions) {
			this.noOfPositions = noOfPositions;
		}

		public String getStatusId() {
			return statusId;
		}

		public void setStatusId(String statusId) {
			this.statusId = statusId;
		}

		public String getDepartmentIdEdit() {
			return departmentIdEdit;
		}

		public void setDepartmentIdEdit(String departmentIdEdit) {
			this.departmentIdEdit = departmentIdEdit;
		}

		public String getSkillIdEdit() {
			return skillIdEdit;
		}

		public void setSkillIdEdit(String skillIdEdit) {
			this.skillIdEdit = skillIdEdit;
		}

		public String getNoOfPositionsEdit() {
			return noOfPositionsEdit;
		}

		public void setNoOfPositionsEdit(String noOfPositionsEdit) {
			this.noOfPositionsEdit = noOfPositionsEdit;
		}

		public String getStatusIdEdit() {
			return statusIdEdit;
		}

		public void setStatusIdEdit(String statusIdEdit) {
			this.statusIdEdit = statusIdEdit;
		}

		public String getSkill() {
			return skill;
		}

		public void setSkill(String skill) {
			this.skill = skill;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getSkillEdit() {
			return skillEdit;
		}

		public void setSkillEdit(String skillEdit) {
			this.skillEdit = skillEdit;
		}

		public String getStatusEdit() {
			return statusEdit;
		}

		public void setStatusEdit(String statusEdit) {
			this.statusEdit = statusEdit;
		}

		public String getVacancyEdit() {
			return vacancyEdit;
		}

		public void setVacancyEdit(String vacancyEdit) {
			this.vacancyEdit = vacancyEdit;
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

		
		public int getVacancyhide() {
			return vacancyhide;
		}

		public void setVacancyhide(int vacancyhide) {
			this.vacancyhide = vacancyhide;
		}

		public String getVendorId() {
			return vendorId;
		}

		public void setVendorId(String vendorId) {
			this.vendorId = vendorId;
		}

		public String getVendorName() {
			return vendorName;
		}

		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}

		public String getVendorEmail() {
			return vendorEmail;
		}

		public void setVendorEmail(String vendorEmail) {
			this.vendorEmail = vendorEmail;
		}
		
		
		
		


}
