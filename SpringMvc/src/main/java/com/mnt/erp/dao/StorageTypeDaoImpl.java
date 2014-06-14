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

import com.mnt.erp.bean.StorageType;
import com.mnt.erp.service.AuditLogService;
/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public class StorageTypeDaoImpl extends HibernateDaoSupport implements StorageTypeDao{
	
	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id=null;
	@Autowired
	AuditLogService auditLogService;
	@Override
	public String saveStorageTypeDetails(Object object,String userId, String userName) {
		try
		{
			
			StorageType storagetype=(StorageType)object;
			id = getHibernateTemplate().save(storagetype);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "StorageType", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
				
			}
			msg="S";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			msg="F";
		}
		return msg;
	}
	@Override
	public Long duplicateStorageTypeCheck(String storagetype) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from StorageType r where  r.storagetype='" + storagetype+ "'";
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
	public List<Object[]> searchStorageType() {
	
	try
	{
		
		String hql="select r.storagetypeId,r.storagetype from StorageType r";
		
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	
	public List<Object[]> searchStorageTypeWithName(String storagetypename) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.storagetypeId,r.storagetype from StorageType r where r.storagetypeId="+storagetypename+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectStorageTypeNames() {
		String sql=null;
	try
	{
	sql="select r.storagetypeId, r.storagetype from StorageType r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchStorageTypeWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.storagetypeId,r.storagetype from StorageType r where r.storagetypeId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateStorageType(Object object) {
		try
		{
			StorageType storagetype=(StorageType)object;
		
	getHibernateTemplate().update(storagetype);
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
	public Long updateDuplicateCheck(String storagetype,int storagetypeid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from StorageType r where  r.storagetype='" + storagetype +"' and r.storagetypeId!='"+storagetypeid+"'" ;
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
	public String storagetypeDelete(int id)
	{
		StorageType storagetype=null;
		try
		{
			storagetype=(StorageType)getHibernateTemplate().get(StorageType.class,id);
		
			getHibernateTemplate().delete(storagetype);
			storagetype.getStoragetype();
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg+","+storagetype.getStoragetype();
	}
	public List<Object[]> basicSearchStorageType(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.storagetypeId,r.storagetype from StorageType r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}



}
