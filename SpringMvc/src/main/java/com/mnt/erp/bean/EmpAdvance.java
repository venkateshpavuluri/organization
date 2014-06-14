package com.mnt.erp.bean;

public class EmpAdvance {
private int empAdvanceId;
private String loanTypeId;
private String employeeId;
private String advanceAmount;
private String currencyId;
private String repayAmountPM;
private String statusId;
private String description;
private String payModeId;
private String bankId;
private String branch;
private Boolean isFixedAmount;
private String fixedAmount;
private Boolean isEMI;
private String noofInstallments;
private String sTDT;
private int aid;
private Employee employee;
private String empName;
private Status status;
private String statusName;
private Currency currency;
private String currencyName;
private LoanTypeBean loanType;
private String loanTypeName;

//Basic search properties
private String xmlLabel;
private String operations;
private String basicSearchId;

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
public int getEmpAdvanceId() {
	return empAdvanceId;
}
public void setEmpAdvanceId(int empAdvanceId) {
	this.empAdvanceId = empAdvanceId;
}
public String getLoanTypeId() {
	return loanTypeId;
}
public void setLoanTypeId(String loanTypeId) {
	this.loanTypeId = loanTypeId;
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getAdvanceAmount() {
	return advanceAmount;
}
public void setAdvanceAmount(String advanceAmount) {
	this.advanceAmount = advanceAmount;
}
public String getCurrencyId() {
	return currencyId;
}
public void setCurrencyId(String currencyId) {
	this.currencyId = currencyId;
}
public String getRepayAmountPM() {
	return repayAmountPM;
}
public void setRepayAmountPM(String repayAmountPM) {
	this.repayAmountPM = repayAmountPM;
}
public String getStatusId() {
	return statusId;
}
public void setStatusId(String statusId) {
	this.statusId = statusId;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPayModeId() {
	return payModeId;
}
public void setPayModeId(String payModeId) {
	this.payModeId = payModeId;
}
public String getBankId() {
	return bankId;
}
public void setBankId(String bankId) {
	this.bankId = bankId;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}

public String getFixedAmount() {
	return fixedAmount;
}
public void setFixedAmount(String fixedAmount) {
	this.fixedAmount = fixedAmount;
}

public Boolean getIsFixedAmount() {
	return isFixedAmount;
}
public void setIsFixedAmount(Boolean isFixedAmount) {
	this.isFixedAmount = isFixedAmount;
}
public Boolean getIsEMI() {
	return isEMI;
}
public void setIsEMI(Boolean isEMI) {
	this.isEMI = isEMI;
}
public String getNoofInstallments() {
	return noofInstallments;
}
public void setNoofInstallments(String noofInstallments) {
	this.noofInstallments = noofInstallments;
}
public String getsTDT() {
	return sTDT;
}
public void setsTDT(String sTDT) {
	this.sTDT = sTDT;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public String getStatusName() {
	return statusName;
}
public void setStatusName(String statusName) {
	this.statusName = statusName;
}
public Currency getCurrency() {
	return currency;
}
public void setCurrency(Currency currency) {
	this.currency = currency;
}
public String getCurrencyName() {
	return currencyName;
}
public void setCurrencyName(String currencyName) {
	this.currencyName = currencyName;
}
public LoanTypeBean getLoanType() {
	return loanType;
}
public void setLoanType(LoanTypeBean loanType) {
	this.loanType = loanType;
}
public String getLoanTypeName() {
	return loanTypeName;
}
public void setLoanTypeName(String loanTypeName) {
	this.loanTypeName = loanTypeName;
}

}
