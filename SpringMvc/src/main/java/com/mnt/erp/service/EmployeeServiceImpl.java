
/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.dao.EmployeeDao;

/**
 * This is Employee pojo.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class EmployeeServiceImpl implements EmployeeService{
	
	
	List<Object[]> objects = null;
	public EmployeeDao edao;



	public EmployeeDao getEdao() {
		return edao;
	}
	public void setEdao(EmployeeDao edao) {
		this.edao = edao;
	}
	String sus;

	public Long checkEmployee(String employeeName) {
		Long l = edao.checkEmployee(employeeName);
		return l;
	}
	public Long updateCheckEmployee(String employeeName,int Id) {
		Long l = edao.updateCheckEmployee(employeeName, Id);
		return l;
	}
	
	public String saveEmployeeDetails(Object object,String userId,String userName) {
		try {
			sus = edao.saveEmployeeDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchEmployee() {
		
		try {
			objects = edao.searchEmployee();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Employee> searchEmployeeWithId(int id){
		List<Employee> list = null;
		try {
			list = edao.searchEmployeeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateEmployee(Object object) {
		try {
			sus = edao.updateEmployee(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteEmployee(int id) {
		try {
			sus = edao.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectEmployee() {
		List<Object[]> objects = null;
		try {
			objects = edao.selectEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> basicSearchEmployee(String label, String operator,
			String searchName) {
		List<Object[]> objects=null;
		try {
			objects = edao.basicSearchEmployee(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public List<Object[]> selectDepartmentDetails(){
		List<Object[]> list = null;
		
		try
		{
			list=edao.selectDepartmentDetails();
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}
	public List<Object[]> selectEmployeeGroupDetails(){
		
		List<Object[]> list = null;
	
		try
		{	 
			list=edao.selectEmployeeGroupDetails();
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}
	
	
public List<Object[]> selectEmployees(){
	List<Object[]> list = null;
	
	try
	{	 
		list=edao.selectEmployees();
	}
	catch(Exception e)

	{
		e.printStackTrace();
	}
		return list;
}
	
	public List<Object[]> selectProjects(){
		List<Object[]> list = null;
		
		try
		{	 
			list=edao.selectProjects();
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}
	public String deleteEmployeeManager(int kk){
		String msg = null;
		try {
			msg = edao.deleteEmployeeManager(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	public List<Object[]> selecDesignations(){
List<Object[]> list = null;
		
		try
		{	 
			list=edao.selecDesignations();
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}
	@Override
	public String deleteEmployeeProject(int pid) {
		String msg = null;
		try {
			msg = edao.deleteEmployeeProject(pid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
	

