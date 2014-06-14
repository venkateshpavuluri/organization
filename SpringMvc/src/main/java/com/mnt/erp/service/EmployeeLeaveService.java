/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EmployeeLeave;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface EmployeeLeaveService  
{

	public boolean saveEmployeeLeave(EmployeeLeave employeeLeave);
	public int duplicateCheckEmployeeLeave(String employeeLeave,String id);
	public List<Object[]> getAllSelectId(String type);
	public List<Object[]> basicSearchEmployeeLeave(String label, String operator,String searchName);
	public List<Object> editEmployeeLeave(int id);
	public boolean updateEmployeeLeave(EmployeeLeave employeeLeave);
	public boolean deleteEmployeeLeave(int id);

	
}
