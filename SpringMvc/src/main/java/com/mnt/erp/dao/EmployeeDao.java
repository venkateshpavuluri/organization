
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Employee;

/**
 * This is Employee Dao.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface EmployeeDao {
	
	public Long updateCheckEmployee(String employeeName,int Id);

	public Long checkEmployee(String employeeName);
	
	public String saveEmployeeDetails(Object object,String userId,String userName);

	public List<Object[]> searchEmployee();

	public List<Employee> searchEmployeeWithId(int id);

	public String updateEmployee(Object object);

	public String deleteEmployee(int id);
	
	public List<Object[]> selectDepartmentDetails();
	
	public List<Object[]> selectEmployeeGroupDetails();
	
	public List<Object[]> selectEmployee();
	
	public List<Object[]> selectEmployees();
	
	public List<Object[]> selectProjects();
	
	public List<Object[]> selecDesignations(); 
	public String deleteEmployeeManager(int kk);
	public String deleteEmployeeProject(int pid);
	
	public List<Object[]> basicSearchEmployee(String label,String operator,String searchName);

}
