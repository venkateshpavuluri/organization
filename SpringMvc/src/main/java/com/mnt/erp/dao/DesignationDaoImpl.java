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

import com.mnt.erp.bean.Designation;
import com.mnt.erp.bean.Designation;
import com.mnt.erp.bean.Designation;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 *
 */
public class DesignationDaoImpl extends HibernateDaoSupport implements DesignationDao{
	
	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id=null;
	  @Autowired
		AuditLogService auditLogService;
		
	@Override
	public String saveDesignationDetails(Object object,String userId,String userName) {
		try
		{
			//System.out.println("in save of designation dao impl");
			Designation designation=(Designation)object;
			id=getHibernateTemplate().save(designation);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Desg","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
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
	public Long duplicateDesignationCheck(String designation) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Designation r where  r.designation='" + designation+ "'";
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
	public List<Object[]> searchDesignation() {
	
	try
	{
		
		String hql="select r.designationId,r.designation from Designation r order by r.designation";
		
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> basicSearchDesignation(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.designationId,r.designation from Designation r where r."
					+ label + "" + operator + " ? order by r.designation";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> searchDesignationWithName(String designationname) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.designationId,r.designation from Designation r where r.designationId="+designationname+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectDesignationNames() {
		String sql=null;
	try
	{
	sql="select r.designationId, r.designation from Designation r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchDesignationWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.designationId,r.designation from Designation r where r.designationId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateDesignation(Object object) {
		try
		{
			Designation designation=(Designation)object;
		
	getHibernateTemplate().update(designation);
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
	public Long updateDuplicateCheck(String designation,int designationid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from Designation r where  r.designation='" + designation +"' and r.designationId!='"+designationid+"'" ;
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
	public String designationDelete(int id)
	{
		Designation designation=null;
		try
		{
			designation=(Designation)getHibernateTemplate().get(Designation.class,id);
		
			getHibernateTemplate().delete(designation);
			designation.getDesignation();
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg+","+designation.getDesignation();
	}

}
