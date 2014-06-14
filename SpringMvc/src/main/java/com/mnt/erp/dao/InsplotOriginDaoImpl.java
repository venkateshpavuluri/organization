/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.service.AuditLogService;

/**
 *@author A Nikesh
 *@version 1.0 31-10-2013
 *@build 0.0
 *
 */
public class InsplotOriginDaoImpl extends HibernateDaoSupport implements InsplotOriginDao{
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	String sql=null;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Override
	public String saveInsplotOriginDetails(Object object,String userId,String userName) {
		try
		{
			
			InsplotOrigin insplotorigin=(InsplotOrigin)object;
			Serializable id=getHibernateTemplate().save(insplotorigin);

			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Insp Lot Orgin",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
					
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
			
		}
		return msg;
	}
	@Override
	public Long duplicateInsplotOriginCheck(String insplotorigin) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from InsplotOrigin r where  r.insplotorigin='" + insplotorigin+ "'";
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
	public List<Object[]> searchInsplotOrigin() {
	
	try
	{
	
		String hql="select r.insplotoriginId,r.insplotorigin from InsplotOrigin r order by r.insplotorigin";
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	
	public List<Object[]> searchInsplotOriginWithName(String insplotoriginname) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.insplotoriginId,r.insplotorigin from InsplotOrigin r where r.insplotoriginId="+insplotoriginname+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectInsplotOriginNames() {
		String sql=null;
	try
	{
	sql="select r.insplotoriginId, r.insplotorigin from InsplotOrigin r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchInsplotOriginWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.insplotoriginId,r.insplotorigin from InsplotOrigin r where r.insplotoriginId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateInsplotOrigin(Object object) {
		try
		{
			InsplotOrigin insplotorigin=(InsplotOrigin)object;
			getHibernateTemplate().update(insplotorigin);
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
	public Long updateDuplicateCheck(String insplotorigin,int insplotoriginid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from InsplotOrigin r where  r.insplotorigin='" + insplotorigin +"' and r.insplotoriginId!='"+insplotoriginid+"'" ;
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
	public String insplotoriginDelete(int id)
	{
		InsplotOrigin insplotorigin=null;
		try
		{
			insplotorigin=(InsplotOrigin)getHibernateTemplate().get(InsplotOrigin.class,id);
		
			getHibernateTemplate().delete(insplotorigin);
			insplotorigin.getInsplotorigin();
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchInsplotOrigin(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.insplotoriginId,r.insplotorigin from InsplotOrigin r where r."
					+ label + "" + operator + " ? order by r.insplotorigin";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}


}
