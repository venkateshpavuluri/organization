/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author sailajach
 * @version 1.0 01-02-2014
 * @build 0.0
 *
 */
public class EmployeeAttendance {
	
	private int empAttendanceId;
	private String employee_Id;
	private String date;
	private String shiftId;
	private String inTime;
	private String outTime;
	private String attendance;
	private String overTime;
	
	private String fName;
	private String shift;
	private int aid;
	
	
	private int empAttendanceIdEditt;
	private String employee_IdEditt;
	private String dateEditt;
	private String shiftIdEditt;
	private String inTimeEditt;
	private String outTimeEditt;
	private String attendanceEditt;
	private String overTimeEditt;
	private String fNameEditt;
	
	private String shiftEditt;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	private Employee employeeBean;
	private ShiftBean shiftBean;
	
    /*==============================Getter & Setter Methods===========================*/
	
	public int getEmpAttendanceId() {
		return empAttendanceId;
	}
	public void setEmpAttendanceId(int empAttendanceId) {
		this.empAttendanceId = empAttendanceId;
	}
	public String getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getShiftId() {
		return shiftId;
	}
	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getEmpAttendanceIdEditt() {
		return empAttendanceIdEditt;
	}
	public void setEmpAttendanceIdEditt(int empAttendanceIdEditt) {
		this.empAttendanceIdEditt = empAttendanceIdEditt;
	}
	public String getEmployee_IdEditt() {
		return employee_IdEditt;
	}
	public void setEmployee_IdEditt(String employee_IdEditt) {
		this.employee_IdEditt = employee_IdEditt;
	}
	public String getShiftIdEditt() {
		return shiftIdEditt;
	}
	public void setShiftIdEditt(String shiftIdEditt) {
		this.shiftIdEditt = shiftIdEditt;
	}
	public String getInTimeEditt() {
		return inTimeEditt;
	}
	public void setInTimeEditt(String inTimeEditt) {
		this.inTimeEditt = inTimeEditt;
	}
	public String getOutTimeEditt() {
		return outTimeEditt;
	}
	public void setOutTimeEditt(String outTimeEditt) {
		this.outTimeEditt = outTimeEditt;
	}
	public String getAttendanceEditt() {
		return attendanceEditt;
	}
	public void setAttendanceEditt(String attendanceEditt) {
		this.attendanceEditt = attendanceEditt;
	}
	public String getOverTimeEditt() {
		return overTimeEditt;
	}
	public void setOverTimeEditt(String overTimeEditt) {
		this.overTimeEditt = overTimeEditt;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateEditt() {
		return dateEditt;
	}
	public void setDateEditt(String dateEditt) {
		this.dateEditt = dateEditt;
	}
	public Employee getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}
	public ShiftBean getShiftBean() {
		return shiftBean;
	}
	public void setShiftBean(ShiftBean shiftBean) {
		this.shiftBean = shiftBean;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfNameEditt() {
		return fNameEditt;
	}
	public void setfNameEditt(String fNameEditt) {
		this.fNameEditt = fNameEditt;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getShiftEditt() {
		return shiftEditt;
	}
	public void setShiftEditt(String shiftEditt) {
		this.shiftEditt = shiftEditt;
	}
	
}
