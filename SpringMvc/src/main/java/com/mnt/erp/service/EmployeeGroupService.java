/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EmployeeGroup;

/**
 * @author anikesh
 *
 */
public interface EmployeeGroupService {
	public String saveEmployeeGroupDetails(Object object,String userId,String userName);
	public Long duplicateEmployeeGroupCheck(String employeeGroup);
	public List<Object[]> searchEmployeeGroup();
	public List<Object[]> basicSearchEmployeeGroup(String label,String operator,String searchName);
	public List<Object[]> searchEmployeeGroupWithName(String employeeGroupname);
	public List<Object[]> selectEmployeeGroupNames();
	public List<Object[]> searchEmployeeGroupWithId(String employeeGroupname);
	public String updateEmployeeGroup(Object object);
	public Long updateDuplicateCheck(String employeeGroup, int employeeGroupid);
	public String employeeGroupDelete(int id);
	
	
}
