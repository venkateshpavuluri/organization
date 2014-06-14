package com.mnt.erp.bean;


public class EmployeeManager {
private int employeeManager_Id;
private String employee_Id;
private String manager_Id;
private String project_Id;
private String startDate;
private String endDate;

//Edit properties
private int employeeManager_IdEdit;
private int employee_IdEdit;
private String manager_IdEdit;
private String startDateEdit;
private String endDateEdit;
private String project_IdEdit;

private String empName;
private String managerName;
private String projectName;
private Project projectDetails;

private Employee managerDetails;

private String employees;
private String managers;
private String projects;
private String employeesEdit;
private String manageresEdit;
private String projectsEdit;


//get methods
public int getEmployeeManager_Id() {
	return employeeManager_Id;
}
public String getEmployee_Id() {
	return employee_Id;
}
public String getManager_Id() {
	return manager_Id;
}
public String getStartDate() {
	return startDate;
}

public int getEmployeeManager_IdEdit() {
	return employeeManager_IdEdit;
}
public int getEmployee_IdEdit() {
	return employee_IdEdit;
}
public String getManager_IdEdit() {
	return manager_IdEdit;
}
public String getStartDateEdit() {
	return startDateEdit;
}
public String getEndDateEdit() {
	return endDateEdit;
}

public String getProject_Id() {
	return project_Id;
}
public String getEndDate() {
	return endDate;
}

//set methods

public void setEmployeeManager_Id(int employeeManager_Id) {
	this.employeeManager_Id = employeeManager_Id;
}
public void setEmployee_Id(String employee_Id) {
	this.employee_Id = employee_Id;
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
public void setEmployee_IdEdit(int employee_IdEdit) {
	this.employee_IdEdit = employee_IdEdit;
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
public void setProject_Id(String project_Id) {
	this.project_Id = project_Id;
}
public Project getProjectDetails() {
	return projectDetails;
}
public void setProjectDetails(Project projectDetails) {
	this.projectDetails = projectDetails;
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
public Employee getManagerDetails() {
	return managerDetails;
}
public void setManagerDetails(Employee managerDetails) {
	this.managerDetails = managerDetails;
}
public String getEmployees() {
	return employees;
}
public void setEmployees(String employees) {
	this.employees = employees;
}
public String getManagers() {
	return managers;
}
public void setManagers(String managers) {
	this.managers = managers;
}
public String getProjects() {
	return projects;
}
public void setProjects(String projects) {
	this.projects = projects;
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



}
