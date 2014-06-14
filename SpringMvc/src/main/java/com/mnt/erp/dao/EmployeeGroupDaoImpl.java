/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.EmployeeGroup;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 *
 */
public class EmployeeGroupDaoImpl extends HibernateDaoSupport implements EmployeeGroupDao{

	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id=null;
	  @Autowired
		AuditLogService auditLogService;
	@Override
	public String saveEmployeeGroupDetails(Object object,String userId,String userName) {
		try
		{
			//System.out.println("in save of employeeGroup dao impl");
			EmployeeGroup employeeGroup=(EmployeeGroup)object;
			id=getHibernateTemplate().save(employeeGroup);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","empGroup","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
					msg ="S";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			msg="F";
		}
		return msg;
	}
	@Override
	public Long duplicateEmployeeGroupCheck(String employeeGroup) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from EmployeeGroup r where  r.employeeGroup='" + employeeGroup+ "'";
		 list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public List<Object[]> searchEmployeeGroup() {
	
	try
	{
		
		String hql="select r.employeeGroupId,r.employeeGroup from EmployeeGroup r order by order by r.employeeGroup";
		
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> basicSearchEmployeeGroup(String label, String operator,
			String searchName) {
		try {
System.out.println("in basic search of vehicle type");
			String hql = "select r.employeeGroupId,r.employeeGroup from EmployeeGroup r where r."
					+ label + "" + operator + " ? order by r.employeeGroup";
System.out.println("query in basic search is   "+hql);
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> searchEmployeeGroupWithName(String employeeGroupname) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.employeeGroupId,r.employeeGroup from EmployeeGroup r where r.employeeGroupId="+employeeGroupname+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectEmployeeGroupNames() {
		String sql=null;
	try
	{
	sql="select r.employeeGroupId, r.employeeGroup from EmployeeGroup r order by r.employeeGroup";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchEmployeeGroupWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		System.out.println("employeeGroup id in search employeeGroup with id   "+id);
		String hql="select r.employeeGroupId,r.employeeGroup from EmployeeGroup r where r.employeeGroupId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateEmployeeGroup(Object object) {
		try
		{
			EmployeeGroup employeeGroup=(EmployeeGroup)object;
		
	getHibernateTemplate().update(employeeGroup);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg ;
	}
	
	@Override
	public Long updateDuplicateCheck(String employeeGroup,int employeeGroupid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from EmployeeGroup r where  r.employeeGroup='" + employeeGroup +"' and r.employeeGroupId!='"+employeeGroupid+"'" ;
			 list = getHibernateTemplate().find(sql);
				iterator = list.iterator();

				while (iterator.hasNext()) {
					Object object = (Object) iterator.next();
					i = (Long) object;

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return i;
	}
	public String employeeGroupDelete(int id)
	{
		EmployeeGroup employeeGroup=null;
		try
		{
			employeeGroup=(EmployeeGroup)getHibernateTemplate().get(EmployeeGroup.class,id);
		
			getHibernateTemplate().delete(employeeGroup);
			employeeGroup.getEmployeeGroup();
			System.out.println(	"employeeGroup deleted    "+employeeGroup.getEmployeeGroup());
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg+","+employeeGroup.getEmployeeGroup();
	}

}
