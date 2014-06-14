/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author sailajach
 * @version 1.0 01-02-2014
 * @build 0.0
 *
 */
public interface EmployeeAttendanceDao {
	
	public String addEmployeeAttendance(Object object);
	public List<Object[]> searchEmployeeAttendance();
	public List<Object[]> searchEmployeeAttendanceWithId(int id);
	public String updateEmployeeAttendance(Object object);
	public String deleteEmployeeAttendance(int id);
	public int checkDuplicate(String checkEmployee,String checkDate,String checkShift);
	public int checkEditDuplicate(String checkEmployee,String checkDate,String checkShift,int id);
	public List<Object[]> basicSearchEmployeeAttendance(String label,String operator,String searchName);
	
	public List<Object[]> getEmployeeNames();
	public List<Object[]> getShifts();

}
