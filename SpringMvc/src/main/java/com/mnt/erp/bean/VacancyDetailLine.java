/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class VacancyDetailLine {
	private int	vacancyDetailLineId;
	private int	vacancyId;
	private int	departmentId;
	private int noOfPositions;
	private int	skillId;
	private int	statusId;
	private String vacancyDetailNo;
	
	
	public String getVacancyDetailNo() {
		return vacancyDetailNo;
	}
	public void setVacancyDetailNo(String vacancyDetailNo) {
		this.vacancyDetailNo = vacancyDetailNo;
	}
	/*RlationShip Properties*/
	private Department deptDetails;
	private Status statusDetails;
	private Skill skillDetails;
	
	//generate getters & setters
	
	public int getVacancyDetailLineId() {
		return vacancyDetailLineId;
	}
	public void setVacancyDetailLineId(int vacancyDetailLineId) {
		this.vacancyDetailLineId = vacancyDetailLineId;
	}
	public int getVacancyId() {
		return vacancyId;
	}
	public void setVacancyId(int vacancyId) {
		this.vacancyId = vacancyId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getNoOfPositions() {
		return noOfPositions;
	}
	public void setNoOfPositions(int noOfPositions) {
		this.noOfPositions = noOfPositions;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
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
	
	
	


}
