package com.mnt.erp.bean;

public class GLFiscalYear {

	public int gLFiscalYear_Id;
	public String fiscalYear;
	public String calendarYear;
	public String startDate;
	public String endDate;
	public String fiscalYearClosed;
	public int aid;
	
	/*search properties*/
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	
	/*Edit properties*/
	
	public int gLFiscalYear_IdEdit;
	public String fiscalYearEdit;
	public String calendarYearEdit;
	public String startDateEdit;
	public String endDateEdit;
	public String fiscalYearClosedEdit;
	
	/*getter methods*/
	
	

	public String getFiscalYear() {
		return fiscalYear;
	}
	public String getCalendarYear() {
		return calendarYear;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getFiscalYearClosed() {
		return fiscalYearClosed;
	}
	public int getgLFiscalYear_IdEdit() {
		return gLFiscalYear_IdEdit;
	}
	
	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	
	public int getAid() {
		return aid;
	}
	public int getgLFiscalYear_Id() {
		return gLFiscalYear_Id;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public String getFiscalYearEdit() {
		return fiscalYearEdit;
	}
	public String getCalendarYearEdit() {
		return calendarYearEdit;
	}
	public String getStartDateEdit() {
		return startDateEdit;
	}
	public String getEndDateEdit() {
		return endDateEdit;
	}
	public String getFiscalYearClosedEdit() {
		return fiscalYearClosedEdit;
	}
	
	
	/*setter methods*/
	
	
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public void setCalendarYear(String calendarYear) {
		this.calendarYear = calendarYear;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setFiscalYearClosed(String fiscalYearClosed) {
		this.fiscalYearClosed = fiscalYearClosed;
	}
	public void setgLFiscalYear_IdEdit(int gLFiscalYear_IdEdit) {
		this.gLFiscalYear_IdEdit = gLFiscalYear_IdEdit;
	}
	public void setFiscalYearEdit(String fiscalYearEdit) {
		this.fiscalYearEdit = fiscalYearEdit;
	}
	public void setCalendarYearEdit(String calendarYearEdit) {
		this.calendarYearEdit = calendarYearEdit;
	}
	public void setStartDateEdit(String startDateEdit) {
		this.startDateEdit = startDateEdit;
	}
	public void setEndDateEdit(String endDateEdit) {
		this.endDateEdit = endDateEdit;
	}
	public void setFiscalYearClosedEdit(String fiscalYearClosedEdit) {
		this.fiscalYearClosedEdit = fiscalYearClosedEdit;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	
	public void setgLFiscalYear_Id(int gLFiscalYear_Id) {
		this.gLFiscalYear_Id = gLFiscalYear_Id;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	
}
