/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeAttendance;
import com.mnt.erp.bean.ShiftBean;

/**
 * @author sailajach
 * @version 1.0 01-02-2014
 * @build 0.0
 *
 */
public class EmployeeAttendanceDaoImpl extends HibernateDaoSupport implements EmployeeAttendanceDao{
	
	String msg=null;
	Long count = null;
	List<Object[]> objects=null;
	private Logger logger=Logger.getLogger(EmployeeAttendanceDaoImpl.class);
	
    /*========================Add Method=======================================*/
	@Override
	public String addEmployeeAttendance(Object object) {
		// TODO Auto-generated method stub
		
		try{
		EmployeeAttendance empAttendance=(EmployeeAttendance)object;
		if(empAttendance.getOverTime()==null||empAttendance.getOverTime()=="")
		{
			empAttendance.setOverTime("0");
			
		}
		Serializable id=getHibernateTemplate().save(empAttendance);
		if(id!=null){
		 msg ="S";
		}
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
	
		return msg;
	}
	/*========================Search Method===================================*/
	@Override
	public List<Object[]> searchEmployeeAttendance() {
		// TODO Auto-generated method stub
		
		try
		{
			String query="select ea.empAttendanceId,ea.employeeBean,ea.date,ea.shiftBean,ea.inTime,ea.outTime,ea.attendance,ea.overTime from EmployeeAttendance ea";
			objects=getHibernateTemplate().find(query);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		
		return objects;
	}
	 /*========================Search(With Id) Method==========================*/
	@Override
	public List<Object[]> searchEmployeeAttendanceWithId(int id) {
		// TODO Auto-generated method stub
		try
		{
			String query="select ea.empAttendanceId,ea.employee_Id,ea.date,ea.shiftId,ea.inTime,ea.outTime,ea.attendance,ea.overTime from EmployeeAttendance ea where ea.empAttendanceId="+id+"";
			objects=getHibernateTemplate().find(query);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		
		return objects;
	}
    /*==========================Update Method==================================*/
	@Override
	public String updateEmployeeAttendance(Object object) {
		// TODO Auto-generated method stub
		try{
			
		
		EmployeeAttendance empAttendance=(EmployeeAttendance)object;
		int id=empAttendance.getEmpAttendanceId();
		
		EmployeeAttendance empAttendanceValues=(EmployeeAttendance)getHibernateTemplate().get(EmployeeAttendance.class,id);
		
		empAttendanceValues.setEmpAttendanceId(empAttendance.getEmpAttendanceId());
		empAttendanceValues.setEmployee_Id(empAttendance.getEmployee_Id());
		empAttendanceValues.setDate(empAttendance.getDate());
		empAttendanceValues.setShiftId(empAttendance.getShiftId());
		empAttendanceValues.setInTime(empAttendance.getInTime());
		empAttendanceValues.setOutTime(empAttendance.getOutTime());
		empAttendanceValues.setAttendance(empAttendance.getAttendance());
		if(empAttendance.getOverTime()==null||empAttendance.getOverTime()=="")
		{
			empAttendanceValues.setOverTime("0");
		}
		else
		{
			empAttendanceValues.setOverTime(empAttendance.getOverTime());
		}
		getHibernateTemplate().update(empAttendance);
		msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	 /*========================Delete Method===================================*/
	@Override
	public String deleteEmployeeAttendance(int id) {
		// TODO Auto-generated method stub
		EmployeeAttendance empAttendance=null;
		try
		{
			empAttendance=(EmployeeAttendance)getHibernateTemplate().get(EmployeeAttendance.class,id);
			empAttendance.setEmployeeBean(new Employee());
			empAttendance.setShiftBean(new ShiftBean());
			getHibernateTemplate().delete(empAttendance);
			msg="S";
					}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
		

	}
	/*=====================Add Duplicate Checking Method=========================*/
	@Override
	public int checkDuplicate(String checkEmployee,String checkDate,String checkShift) {
		// TODO Auto-generated method stub
	
	       try
	       { 
	    	   final String hql ="select count(*) from EmployeeAttendance ea where ea.employee_Id='"+checkEmployee+"' and ea.date='"+checkDate+"' and ea.shiftId='"+checkShift+"' ";
	    	 
	   		    count = (Long) getHibernateTemplate().execute(new HibernateCallback<Object>() {
	   					public Object doInHibernate(Session sesssion)throws HibernateException, SQLException
	   					{
	   						Query query = sesssion.createQuery(hql);
	   						query.setMaxResults(1);
	   						return query.uniqueResult();
	   					}
	   			});
	   		
	       }
	       catch(Exception e)
	       {
	    	 logger.error(e.getMessage());
	       }
	  return count.intValue();
	}
	/*=====================Edit Duplicate Checking Method=========================*/
	@Override
	public int checkEditDuplicate(String checkEmployee,String checkDate,String checkShift, int id) {

	       try
	       { 
	    	   final String hql ="select count(*) from EmployeeAttendance ea where ea.employee_Id='"+checkEmployee+"' and ea.date='"+checkDate+"' and ea.shiftId='"+checkShift+"' and ea.empAttendanceId!='"+id+"' ";
	    	  
	   		    count = (Long) getHibernateTemplate().execute(
	   				new HibernateCallback<Object>() {
	   					public Object doInHibernate(Session sesssion)
	   							throws HibernateException, SQLException {
	   						Query query = sesssion.createQuery(hql);
	   						query.setMaxResults(1);
	   						return query.uniqueResult();
	   					}
	   				});
	   		
	       }
	       catch(Exception e)
	       {
	    	  	 logger.error(e.getMessage());
	       }
	       return count.intValue();
	}
   /*============================Basic Search Method===============================*/
	@Override
	public List<Object[]> basicSearchEmployeeAttendance(String label,
			String operator, String searchName) {
		// TODO Auto-generated method stub
		try {

			String hql = "select ea.empAttendanceId,ea.employeeBean,ea.date,ea.shiftBean,ea.inTime,ea.outTime,ea.attendance,ea.overTime from EmployeeAttendance ea where ea."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
		  	 logger.error(e.getMessage());
		}
		return objects;
	}
	/*====================To get Employee Names=======================*/
	@Override
	public List<Object[]> getEmployeeNames() {
		// TODO Auto-generated method stub
		String query="select e.employee_Id,e.fName from Employee e";
		objects=getHibernateTemplate().find(query);
		return objects;
	}
	/*=====================To get Shift Names============================*/
	@Override
	public List<Object[]> getShifts() {
		// TODO Auto-generated method stub
		String query="select s.shiftId,s.shift from ShiftBean s";
		objects=getHibernateTemplate().find(query);
		return objects;
	}

}
