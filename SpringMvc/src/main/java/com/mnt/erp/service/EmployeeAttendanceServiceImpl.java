/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.mnt.erp.dao.EmployeeAttendanceDao;

/**
 * @author sailajach
 * @version 1.0 01-02-2014
 * @build 0.0
 *
 */
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService{

	public EmployeeAttendanceDao empAttendancedao;
	String message;
	int addList,editList=0;
	List<Object[]> objects=null;
	private Logger logger=Logger.getLogger(EmployeeAttendanceServiceImpl.class);
	
	/*==========================Getter and Setter Of Dao==============================*/

	public EmployeeAttendanceDao getEmpAttendancedao() {
		return empAttendancedao;
	}

	public void setEmpAttendancedao(EmployeeAttendanceDao empAttendancedao) {
		this.empAttendancedao = empAttendancedao;
	}
	/*====================================Add Method=================================*/
	@Override
	public String addEmployeeAttendance(Object object) {
		// TODO Auto-generated method stub
		message=empAttendancedao.addEmployeeAttendance(object);
		return message;
	}
	/*===============================Search(All) Method=================================*/
	@Override
	public List<Object[]> searchEmployeeAttendance() {
		// TODO Auto-generated method stub
		try
		{
			objects=empAttendancedao.searchEmployeeAttendance();
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return objects;
	}
	/*==============================Search(With Id) Method=================================*/
	@Override
	public List<Object[]> searchEmployeeAttendanceWithId(int id) {
		// TODO Auto-generated method stub
		try
		{
			objects=empAttendancedao.searchEmployeeAttendanceWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	/*===================================Update Method=================================*/
	@Override
	public String updateEmployeeAttendance(Object object) {
		// TODO Auto-generated method stub
		try
		{
	        message=empAttendancedao.updateEmployeeAttendance(object);	
	    }
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return message;
	}
	/*==================================Delete Method=================================*/
	@Override
	public String deleteEmployeeAttendance(int id) {
		// TODO Auto-generated method stub
		try
		{
			message=empAttendancedao.deleteEmployeeAttendance(id);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return message;
	}
	/*===========================Add Duplicate Checking Method=========================*/
	@Override
	public int checkDuplicate(String checkEmployee,String checkDate,String checkShift) {
		// TODO Auto-generated method stub
		
		try
		{
			addList=empAttendancedao.checkDuplicate(checkEmployee,checkDate,checkShift);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return addList;
	}
	/*========================Edit Duplicate Checking Method===========================*/
	@Override
	public int checkEditDuplicate(String checkEmployee,String checkDate,String checkShift, int id) {
		// TODO Auto-generated method stub
		
		try
		{
			editList=empAttendancedao.checkEditDuplicate(checkEmployee,checkShift,checkDate, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return editList;
	}
	/*==========================Basic Search Method===================================*/
	@Override
	public List<Object[]> basicSearchEmployeeAttendance(String label,
			String operator, String searchName) {
		// TODO Auto-generated method stub
		try {
			objects = empAttendancedao.basicSearchEmployeeAttendance(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objects;
	}
	
/*==============================To get Employee Names====================================*/
	@Override
	public List<Object[]> getEmployeeNames() {
		// TODO Auto-generated method stub
	try
	{
		objects = empAttendancedao.getEmployeeNames();
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
		
	}
	return objects;
	}
/*================================To get Shifts====================================*/
	@Override
	public List<Object[]> getShifts() {
		// TODO Auto-generated method stub
	try
	{
		objects=empAttendancedao.getShifts();
		
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return objects;
	}

}
