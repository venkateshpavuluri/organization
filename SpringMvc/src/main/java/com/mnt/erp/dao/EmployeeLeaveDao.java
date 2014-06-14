/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.EmployeeLeave;

/**
 * @author kirangangone
 * @version 1.0
 *@build 0.0
 */
public interface EmployeeLeaveDao 
{
	
	public boolean saveEmployeeLeave(EmployeeLeave code);
	public int duplicateCheckEmployeeLeave(String code,String id);
	public List<Object[]> getAllSelectId(String type);
	public List<Object[]> basicSearchEmployeeLeave(String label, String operator,String searchName);
	public List<Object> editEmployeeLeave(int cId);
	public boolean updateEmployeeLeave(EmployeeLeave code);
	public boolean deleteEmployeeLeave(int id);
}
