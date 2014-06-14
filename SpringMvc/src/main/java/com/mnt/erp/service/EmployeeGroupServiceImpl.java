/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EmployeeGroup;
import com.mnt.erp.dao.EmployeeGroupDao;

/**
 * @author anikesh
 *
 */
public class EmployeeGroupServiceImpl implements EmployeeGroupService{
	EmployeeGroupDao dao;
	List<Object[]> objects;
	String msg;

	public EmployeeGroupDao getDao() {
		return dao;
	}

	public void setDao(EmployeeGroupDao dao) {
		this.dao = dao;
	}
	public String saveEmployeeGroupDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=dao.saveEmployeeGroupDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateEmployeeGroupCheck(String employeeGroup) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateEmployeeGroupCheck(employeeGroup);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchEmployeeGroup() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchEmployeeGroup();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchEmployeeGroup(String label,String operator,String searchName){
		try {
			objects = dao.basicSearchEmployeeGroup(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchEmployeeGroupWithName(String employeeGroupname) {
		List<Object[]> list=null;
		try
		{
			System.out.println("employeeGroup name in employeeGroup service dao impl is   "+employeeGroupname);
			list=dao.searchEmployeeGroupWithName(employeeGroupname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectEmployeeGroupNames() {

		 try
		 {
			 objects=dao.selectEmployeeGroupNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchEmployeeGroupWithId(String employeeGroupname) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchEmployeeGroupWithId(employeeGroupname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateEmployeeGroup(Object object) {
		try
		{
	 msg=dao.updateEmployeeGroup(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String employeeGroup,int employeeGroupid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(employeeGroup, employeeGroupid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String employeeGroupDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.employeeGroupDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

}
