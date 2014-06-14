/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0  14-05-2014
 *
 */
public class ProdProcessEmpBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int popEmpId;
	private int popId;
	private String empId;
	private String empNo;
	private Employee employee;
	
	//Setter and Getter Methods
	
	public int getPopEmpId() {
		return popEmpId;
	}
	public int getPopId() {
		return popId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setPopEmpId(int popEmpId) {
		this.popEmpId = popEmpId;
	}
	public void setPopId(int popId) {
		this.popId = popId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
