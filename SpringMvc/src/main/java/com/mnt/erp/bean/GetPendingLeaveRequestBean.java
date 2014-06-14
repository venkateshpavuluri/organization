package com.mnt.erp.bean;

public class GetPendingLeaveRequestBean {
    private String employee;
    private String department;
    private String leaveType;
    private String mobile;
    private String statusId;

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getEmployee() {
	return employee;
    }

    public void setEmployee(String employee) {
	this.employee = employee;
    }

    public String getDepartment() {
	return department;
    }

    public void setDepartment(String department) {
	this.department = department;
    }

    public String getLeaveType() {
	return leaveType;
    }

    public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }
}
