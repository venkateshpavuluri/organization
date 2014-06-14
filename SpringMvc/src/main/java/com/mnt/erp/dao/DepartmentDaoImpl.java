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

import com.mnt.erp.bean.Department;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id=null;
	  @Autowired
		AuditLogService auditLogService;
		
	@Override
	public String saveDepartmentDetails(Object object,String userId,String userName) {
		try
		{
			
			Department department=(Department)object;
			id=getHibernateTemplate().save(department);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Dept","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
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
	public Long duplicateDepartmentCheck(String department) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Department r where  r.department='" + department+ "'";
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
	public List<Object[]> searchDepartment() {
	
	try
	{
		
		String hql="select r.departmentId,r.department from Department r order by r.department";
		
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> basicSearchDepartment(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.departmentId,r.department from Department r where r."
					+ label + "" + operator + " ? order by r.department ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> searchDepartmentWithName(String departmentname) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.departmentId,r.department from Department r where r.departmentId="+departmentname+" order by r.department";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectDepartmentNames() {
		String sql=null;
	try
	{
	sql="select r.departmentId, r.department from Department r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchDepartmentWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.departmentId,r.department from Department r where r.departmentId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateDepartment(Object object) {
		try
		{
			Department department=(Department)object;
		
	getHibernateTemplate().update(department);
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
	public Long updateDuplicateCheck(String department,int departmentid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from Department r where  r.department='" + department +"' and r.departmentId!='"+departmentid+"'" ;
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
	public String departmentDelete(int id)
	{
		Department department=null;
		try
		{
			department=(Department)getHibernateTemplate().get(Department.class,id);
		
			getHibernateTemplate().delete(department);
			department.getDepartment();
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg+","+department.getDepartment();
	}

}
