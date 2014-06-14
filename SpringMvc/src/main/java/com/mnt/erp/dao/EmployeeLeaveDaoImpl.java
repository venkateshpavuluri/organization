/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.EmployeeLeave;

/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 *
 */
public class EmployeeLeaveDaoImpl extends HibernateDaoSupport implements EmployeeLeaveDao
{
	String msg;
	
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;
	boolean flag=false;

	@Override
	public boolean saveEmployeeLeave(EmployeeLeave employeeLeave)
	{
	try
		{
			Serializable id=getHibernateTemplate().save(employeeLeave);
			if(id!=null){
		    flag=true;
			}
		}
		catch(Exception e)
		{
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public int duplicateCheckEmployeeLeave(String employeeLeave, String Id) {
		try {
			String sql = null;
			if(!Id.equals(""))
			{
			sql="select count(*) from EmployeeLeave cb where  cb.startDate='"
					+ employeeLeave + "' and cb.employeeLeaveId!="+Id;
			
			}
			else
			{
				sql="select count(*) from EmployeeLeave cb where  cb.startDate='"
						+ employeeLeave + "'";
			}
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.intValue();

	}
	
	
/*For Selecting EmployeeLeaveGroup Id And EmployeeLeaveGroup  */
	
	public List<Object[]> getAllSelectId(String type){
		List<Object[]> list=null;
		String sql=null;     
		try
		{
			if(type.equalsIgnoreCase("leaveTypeIdDetails"))
			{
				sql="select k.leaveTypeId"
						+ " ,k.leaveType from LeaveTypeBean k "; 
			}
			if(type.equalsIgnoreCase("reptMgrIdDetails") || type.equalsIgnoreCase("employeeIdDetails"))
			{ 
				sql="select k.employee_Id,k.fName from Employee k "; 
			}
			if(type.equalsIgnoreCase("status"))
			{ 
				sql="select k.statusId,k.status from Status k "; 
			}
			
			
			
			
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<Object[]> basicSearchEmployeeLeave(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		String hql="";
		try {
				if(label.equals("") && operator.equals("") && searchName.equals(""))
				{
					hql = "select "
							+ "c.employeeLeaveId,c.leaveTypeIdDetails,c.reptMgrIdDetails,c.employeeIdDetails,c.employeeId,c.leaveTypeId,"
							+ "c.reptMgrId,c.noOfAvailableCL,c.noOfAvailableCFL,c.startDate,"
							+ "c.sDayPart,c.endDate,c.eDayPart,c.recursiveHalf,"
							+ "c.reportingDate,c.reason,c.mobile,c.residence,c.otherNo,"
							+ "c.createdDate,c.createdBy,c.updatedDate,c.updatedBy,"
							+ "c.statusId,c.declineReason,c.approvedBy,c.narration,"
							+ "c.emailCCList,c.days from EmployeeLeave c ";
					objs = getHibernateTemplate().find(hql);
				}
				else
				{
					hql = "select "
							+ "c.employeeLeaveId,c.leaveTypeIdDetails,c.reptMgrIdDetails,c.employeeIdDetails,c.employeeId,c.leaveTypeId,"
							+ "c.reptMgrId,c.noOfAvailableCL,c.noOfAvailableCFL,c.startDate,"
							+ "c.sDayPart,c.endDate,c.eDayPart,c.recursiveHalf,"
							+ "c.reportingDate,c.reason,c.mobile,c.residence,c.otherNo,"
							+ "c.createdDate,c.createdBy,c.updatedDate,c.updatedBy,"
							+ "c.statusId,c.declineReason,c.approvedBy,c.narration,"
							+ "c.emailCCList,c.days from EmployeeLeave c where c."
					+ label + "" + operator + " ? ";
			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	
	public List<Object> editEmployeeLeave(int Id) {
		try {
			String hql = "from EmployeeLeave c where c.employeeLeaveId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public boolean updateEmployeeLeave(EmployeeLeave employeeLeave) {
		boolean flag =false;
		try {
			getHibernateTemplate().update(employeeLeave);
			flag=true;

		} catch (Exception e) {
		
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	
	
	public boolean deleteEmployeeLeave(int id) {
		boolean flag=false;
		EmployeeLeave employeeLeave = null;
		try {
			employeeLeave=new EmployeeLeave();
			employeeLeave.setEmployeeLeaveId(id);		
		    getHibernateTemplate().delete(employeeLeave);
			
		flag=true;
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
			
		}
		return flag;
	}
	

	
	
	

	
}
