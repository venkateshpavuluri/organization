/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Department;
import com.mnt.erp.dao.DepartmentDao;

/**
 * @author anikesh
 *
 */
public class DepartmentServiceImpl implements DepartmentService{
	DepartmentDao dao;
	List<Object[]> objects;
	String msg;

	public DepartmentDao getDao() {
		return dao;
	}

	public void setDao(DepartmentDao dao) {
		this.dao = dao;
	}
	public String saveDepartmentDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=dao.saveDepartmentDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateDepartmentCheck(String department) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateDepartmentCheck(department);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchDepartment() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchDepartment();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchDepartment(String label,String operator,String searchName){
		try {
			objects = dao.basicSearchDepartment(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> searchDepartmentWithName(String departmentname) {
		List<Object[]> list=null;
		try
		{
			System.out.println("department name in department service dao impl is   "+departmentname);
			list=dao.searchDepartmentWithName(departmentname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectDepartmentNames() {

		 try
		 {
			 objects=dao.selectDepartmentNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchDepartmentWithId(String departmentname) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchDepartmentWithId(departmentname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateDepartment(Object object) {
		try
		{
	 msg=dao.updateDepartment(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String department,int departmentid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(department, departmentid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String departmentDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.departmentDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
}
