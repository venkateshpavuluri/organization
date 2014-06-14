
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

import java.util.List;
import java.util.Set;

/**
 * This is Employee pojo.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class Employee {
	
	
private int employee_Id;
private int project_Id;
private String employeeNo;
private String project_IdEdit;

public int getProject_Id() {
	return project_Id;
}
private String fName;
private String lName;
private String mName;
private String gender;
private String dOB;
private String dOJ;
private String pAdd;
private String pCity;
private String pState;
private String pCountry;
private String tAdd;
private String tCity;
private String tState;
private String tCountry;
private String eMail;
private String ceMail;
private String phone;
private String mobile;
private String status;
private String org_Id;
private String department_Id;
private String employeeGroup_Id;
private String designationId;
private Set<EmployeeManager> employeeManager;
private Set<EmployeeProject> employeeProject;
private List<Project> projectDetails;
private int aid;


private String xmlLabel;
private String operations;
private String basicSearchId;


/*properties for dropdown*/

private String employees;

private String managers;

private String projects;

private String employeesEdit;
private String manageresEdit;
private String projectsEdit;
private String empName;
private String managerName;
private String projectName;

/*Edit properties*/

private int[] employeeManager_IdEditt;
private String employeeNoEdit;
private int employee_IdEdit;
private String fNameEdit;
private String lNameEdit;
private String mNameEdit;
private String genderEdit;
private String dOBEdit;
private String dOJEdit;
private String pAddEdit;
private String pCityEdit;
private String pStateEdit;
private String pCountryEdit;
private String tAddEdit;
private String tCityEdit;
private String tStateEdit;
private String tCountryEdit;
private String eMailEdit;
private String ceMailEdit;
private String phoneEdit;
private String mobileEdit;
private String statusEdit;
private String org_IdEdit;
private String department_IdEdit;
private String employeeGroup_IdEdit;
private String designationIdEdit;
//Employee Manager Properties


private int employeeManager_Id;
//private int employee_Id;
private String manager_Id;
private String startDate;
private String endDate;

private int employeeManager_IdEdit;
//private int employee_IdEdit;
private String manager_IdEdit;
private String startDateEdit;
private String endDateEdit;

private String[] startDatepro;
private String[] endDatepro;

private String[] startDateproEdit;
private String[] endDateproEdit;

private int[] employeeProject_IdEdit;


/*GetterMethods*/


public String[] getStartDateproEdit() {
	return startDateproEdit;
}

public int[] getEmployeeProject_IdEdit() {
	return employeeProject_IdEdit;
}

public void setEmployeeProject_IdEdit(int[] employeeProject_IdEdit) {
	this.employeeProject_IdEdit = employeeProject_IdEdit;
}

public String getCeMailEdit() {
	return ceMailEdit;
}
public void setCeMailEdit(String ceMailEdit) {
	this.ceMailEdit = ceMailEdit;
}
public void setStartDateproEdit(String[] startDateproEdit) {
	this.startDateproEdit = startDateproEdit;
}
public String[] getEndDateproEdit() {
	return endDateproEdit;
}
public void setEndDateproEdit(String[] endDateproEdit) {
	this.endDateproEdit = endDateproEdit;
}
public String[] getStartDatepro() {
	return startDatepro;
}
public String getCeMail() {
	return ceMail;
}
public void setCeMail(String ceMail) {
	this.ceMail = ceMail;
}
public Set<EmployeeProject> getEmployeeProject() {
	return employeeProject;
}
public void setEmployeeProject(Set<EmployeeProject> employeeProject) {
	this.employeeProject = employeeProject;
}
public void setStartDatepro(String[] startDatepro) {
	this.startDatepro = startDatepro;
}
public String[] getEndDatepro() {
	return endDatepro;
}
public void setEndDatepro(String[] endDatepro) {
	this.endDatepro = endDatepro;
}
public int getEmployee_Id() {
	return employee_Id;
}
public String getfName() {
	return fName;
}


public int getEmployeeManager_Id() {
	return employeeManager_Id;
}
public String getManager_Id() {
	return manager_Id;
}
public String getStartDate() {
	return startDate;
}
public String getEndDate() {
	return endDate;
}
public int getEmployeeManager_IdEdit() {
	return employeeManager_IdEdit;
}
public String getManager_IdEdit() {
	return manager_IdEdit;
}

public List<Project> getProjectDetails() {
	return projectDetails;
}
public void setProjectDetails(List<Project> projectDetails) {
	this.projectDetails = projectDetails;
}
public String getStartDateEdit() {
	return startDateEdit;
}
public String getEndDateEdit() {
	return endDateEdit;
}
public String getlName() {
	return lName;
}
public String getmName() {
	return mName;
}
public String getGender() {
	return gender;
}
public String getdOB() {
	return dOB;
}
public String getdOJ() {
	return dOJ;
}
public String getpAdd() {
	return pAdd;
}

public void setProject_Id(int project_Id) {
	this.project_Id = project_Id;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getpCity() {
	return pCity;
}
public String getpState() {
	return pState;
}
public String getpCountry() {
	return pCountry;
}
public String gettAdd() {
	return tAdd;
}
public String gettCity() {
	return tCity;
}
public String gettState() {
	return tState;
}

public String getEmployees() {
	return employees;
}
public String getManagers() {
	return managers;
}
public String getProjects() {
	return projects;
}
public String gettCountry() {
	return tCountry;
}
public String geteMail() {
	return eMail;
}
public String getPhone() {
	return phone;
}
public String getMobile() {
	return mobile;
}



public int getEmployee_IdEdit() {
	return employee_IdEdit;
}
public String getfNameEdit() {
	return fNameEdit;
}
public String getlNameEdit() {
	return lNameEdit;
}
public String getmNameEdit() {
	return mNameEdit;
}
public String getGenderEdit() {
	return genderEdit;
}
public String getdOBEdit() {
	return dOBEdit;
}


public String getdOJEdit() {
	return dOJEdit;
}
public String getpAddEdit() {
	return pAddEdit;
}
public String getpCityEdit() {
	return pCityEdit;
}
public String getpStateEdit() {
	return pStateEdit;
}
public String getpCountryEdit() {
	return pCountryEdit;
}
public String gettAddEdit() {
	return tAddEdit;
}
public String gettCityEdit() {
	return tCityEdit;
}
public String gettStateEdit() {
	return tStateEdit;
}
public String gettCountryEdit() {
	return tCountryEdit;
}
public String geteMailEdit() {
	return eMailEdit;
}
public String getPhoneEdit() {
	return phoneEdit;
}
public String getMobileEdit() {
	return mobileEdit;
}
public String getStatusEdit() {
	return statusEdit;
}
public String getStatus() {
	return status;
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

/*Setter Methods*/




public void setEmployee_Id(int employee_Id) {
	this.employee_Id = employee_Id;
}
public void setfName(String fName) {
	this.fName = fName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public void setmName(String mName) {
	this.mName = mName;
}
public void setGender(String gender) {
	this.gender = gender;
}
public void setdOB(String dOB) {
	this.dOB = dOB;
}

public Set<EmployeeManager> getEmployeeManager() {
	return employeeManager;
}
public void setEmployeeManager(Set<EmployeeManager> employeeManager) {
	this.employeeManager = employeeManager;
}
public void setdOJ(String dOJ) {
	this.dOJ = dOJ;
}
public void setpAdd(String pAdd) {
	this.pAdd = pAdd;
}
public void setpCity(String pCity) {
	this.pCity = pCity;
}
public void setpState(String pState) {
	this.pState = pState;
}
public void setpCountry(String pCountry) {
	this.pCountry = pCountry;
}
public void settAdd(String tAdd) {
	this.tAdd = tAdd;
}
public void settCity(String tCity) {
	this.tCity = tCity;
}
public void settState(String tState) {
	this.tState = tState;
}
public void settCountry(String tCountry) {
	this.tCountry = tCountry;
}


public void setEmployeeManager_Id(int employeeManager_Id) {
	this.employeeManager_Id = employeeManager_Id;
}
public void setManager_Id(String manager_Id) {
	this.manager_Id = manager_Id;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public void setEmployeeManager_IdEdit(int employeeManager_IdEdit) {
	this.employeeManager_IdEdit = employeeManager_IdEdit;
}
public void setManager_IdEdit(String manager_IdEdit) {
	this.manager_IdEdit = manager_IdEdit;
}
public void setStartDateEdit(String startDateEdit) {
	this.startDateEdit = startDateEdit;
}
public void setEndDateEdit(String endDateEdit) {
	this.endDateEdit = endDateEdit;
}
public void seteMail(String eMail) {
	this.eMail = eMail;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public void setStatus(String status) {
	this.status = status;
}
public void setEmployee_IdEdit(int employee_IdEdit) {
	this.employee_IdEdit = employee_IdEdit;
}
public void setfNameEdit(String fNameEdit) {
	this.fNameEdit = fNameEdit;
}
public void setlNameEdit(String lNameEdit) {
	this.lNameEdit = lNameEdit;
}
public void setmNameEdit(String mNameEdit) {
	this.mNameEdit = mNameEdit;
}
public void setGenderEdit(String genderEdit) {
	this.genderEdit = genderEdit;
}
public void setdOBEdit(String dOBEdit) {
	this.dOBEdit = dOBEdit;
}
public void setdOJEdit(String dOJEdit) {
	this.dOJEdit = dOJEdit;
}
public void setpAddEdit(String pAddEdit) {
	this.pAddEdit = pAddEdit;
}
public void setpCityEdit(String pCityEdit) {
	this.pCityEdit = pCityEdit;
}
public void setpStateEdit(String pStateEdit) {
	this.pStateEdit = pStateEdit;
}
public void setpCountryEdit(String pCountryEdit) {
	this.pCountryEdit = pCountryEdit;
}
public void settAddEdit(String tAddEdit) {
	this.tAddEdit = tAddEdit;
}
public void settCityEdit(String tCityEdit) {
	this.tCityEdit = tCityEdit;
}
public void settStateEdit(String tStateEdit) {
	this.tStateEdit = tStateEdit;
}
public void settCountryEdit(String tCountryEdit) {
	this.tCountryEdit = tCountryEdit;
}
public void seteMailEdit(String eMailEdit) {
	this.eMailEdit = eMailEdit;
}
public void setPhoneEdit(String phoneEdit) {
	this.phoneEdit = phoneEdit;
}
public void setMobileEdit(String mobileEdit) {
	this.mobileEdit = mobileEdit;
}
public void setStatusEdit(String statusEdit) {
	this.statusEdit = statusEdit;
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

public String getOrg_Id() {
	return org_Id;
}
public void setOrg_Id(String org_Id) {
	this.org_Id = org_Id;
}
public String getDepartment_Id() {
	return department_Id;
}
public void setDepartment_Id(String department_Id) {
	this.department_Id = department_Id;
}
public String getEmployeeGroup_Id() {
	return employeeGroup_Id;
}
public void setEmployeeGroup_Id(String employeeGroup_Id) {
	this.employeeGroup_Id = employeeGroup_Id;
}

public String getOrg_IdEdit() {
	return org_IdEdit;
}
public void setOrg_IdEdit(String org_IdEdit) {
	this.org_IdEdit = org_IdEdit;
}
public String getDepartment_IdEdit() {
	return department_IdEdit;
}
public void setDepartment_IdEdit(String department_IdEdit) {
	this.department_IdEdit = department_IdEdit;
}
public String getEmployeeGroup_IdEdit() {
	return employeeGroup_IdEdit;
}
public void setEmployeeGroup_IdEdit(String employeeGroup_IdEdit) {
	this.employeeGroup_IdEdit = employeeGroup_IdEdit;
}
public void setEmployees(String employees) {
	this.employees = employees;
}
public void setManagers(String managers) {
	this.managers = managers;
}
public void setProjects(String projects) {
	this.projects = projects;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getManagerName() {
	return managerName;
}
public void setManagerName(String managerName) {
	this.managerName = managerName;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getEmployeesEdit() {
	return employeesEdit;
}
public void setEmployeesEdit(String employeesEdit) {
	this.employeesEdit = employeesEdit;
}
public String getManageresEdit() {
	return manageresEdit;
}
public void setManageresEdit(String manageresEdit) {
	this.manageresEdit = manageresEdit;
}
public String getProjectsEdit() {
	return projectsEdit;
}
public void setProjectsEdit(String projectsEdit) {
	this.projectsEdit = projectsEdit;
}
public String getProject_IdEdit() {
	return project_IdEdit;
}
public void setProject_IdEdit(String project_IdEdit) {
	this.project_IdEdit = project_IdEdit;
}
public int[] getEmployeeManager_IdEditt() {
	return employeeManager_IdEditt;
}
public void setEmployeeManager_IdEditt(int[] employeeManager_IdEditt) {
	this.employeeManager_IdEditt = employeeManager_IdEditt;
}
public String getEmployeeNo() {
	return employeeNo;
}
public void setEmployeeNo(String employeeNo) {
	this.employeeNo = employeeNo;
}
public String getEmployeeNoEdit() {
	return employeeNoEdit;
}
public void setEmployeeNoEdit(String employeeNoEdit) {
	this.employeeNoEdit = employeeNoEdit;
}
public String getDesignationId() {
	return designationId;
}
public void setDesignationId(String designationId) {
	this.designationId = designationId;
}
public String getDesignationIdEdit() {
	return designationIdEdit;
}
public void setDesignationIdEdit(String designationIdEdit) {
	this.designationIdEdit = designationIdEdit;
}


}