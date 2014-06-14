package com.mnt.erp.bean;

public class EmployeeTimeSheet {
	private int employeeTimeSheet_Id;
	
	private String timeSheetDT;
	private String timeSpent;
    private String employee;
	private String activity;
	private int aid;
	private int emphide;
	private int empdupedit;
	
	private String xmlLabel;
    private String operations;
    private String basicSearchId;
    
    private Employee empBean;
    private ActivityBean activityBean;
	public int getEmployeeTimeSheet_Id() {
		return employeeTimeSheet_Id;
	}
	public void setEmployeeTimeSheet_Id(int employeeTimeSheet_Id) {
		this.employeeTimeSheet_Id = employeeTimeSheet_Id;
	}
	
	public String getTimeSheetDT() {
		return timeSheetDT;
	}
	public void setTimeSheetDT(String timeSheetDT) {
		this.timeSheetDT = timeSheetDT;
	}
	
	public String getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(String timeSpent) {
		this.timeSpent = timeSpent;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getEmphide() {
		return emphide;
	}
	public void setEmphide(int emphide) {
		this.emphide = emphide;
	}
	public int getEmpdupedit() {
		return empdupedit;
	}
	public void setEmpdupedit(int empdupedit) {
		this.empdupedit = empdupedit;
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
	public Employee getEmpBean() {
		return empBean;
	}
	public void setEmpBean(Employee empBean) {
		this.empBean = empBean;
	}
	public ActivityBean getActivityBean() {
		return activityBean;
	}
	public void setActivityBean(ActivityBean activityBean) {
		this.activityBean = activityBean;
	}
    
    
    
    

}
