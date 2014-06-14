/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Department;

/**
 * @author anikesh
 *
 */
public interface DepartmentDao {
	public String saveDepartmentDetails(Object object,String userId,String userName);
	public Long duplicateDepartmentCheck(String department);
	public List<Object[]> searchDepartment();
	public List<Object[]> basicSearchDepartment(String label,String operator,String searchName);
	public List<Object[]> searchDepartmentWithName(String departmentname);
	public List<Object[]> selectDepartmentNames();
	public List<Object[]> searchDepartmentWithId(String departmentname);
	public String updateDepartment(Object object);
	public Long updateDuplicateCheck(String department, int departmentid);
	public String departmentDelete(int id);
	

}
