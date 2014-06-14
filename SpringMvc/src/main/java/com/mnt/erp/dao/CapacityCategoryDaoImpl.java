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

import com.mnt.erp.bean.CapacityCategory;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 *
 */
public class CapacityCategoryDaoImpl extends HibernateDaoSupport implements CapacityCategoryDao{
	
	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;
	@Override
	public String saveCapacityCategoryDetails(Object object,String userId,String userName) {
		try
		{
			CapacityCategory capcategory=(CapacityCategory)object;
			Serializable id=getHibernateTemplate().save(capcategory);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Code Group",
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
	public Long duplicateCapacityCategoryCheck(String capcategory) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from CapacityCategory r where  r.capcategory='" + capcategory+ "'";
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
	public List<Object[]> searchCapacityCategory() {
	
	try
	{
		
		String hql="select r.capcategoryId,r.capcategory from CapacityCategory r";
		
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> basicSearchCapacityCategory(String label, String operator,
			String searchName) {
		try {


			String hql = "select r.capcategoryId,r.capcategory from CapacityCategory r where r."
					+ label + "" + operator + " ? ";
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> searchCapacityCategoryWithName(String capcategoryname) {
		List<Object[]> objects=null;
	try
	{
		String hql="select r.capcategoryId,r.capcategory from CapacityCategory r where r.capcategoryId="+capcategoryname+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectCapacityCategoryNames() {
		String sql=null;
	try
	{
	sql="select r.capcategoryId, r.capcategory from CapacityCategory r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchCapacityCategoryWithId(String id) {
		List<Object[]> objects=null;
	try
	{
	
		String hql="select r.capcategoryId,r.capcategory from CapacityCategory r where r.capcategoryId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateCapacityCategory(Object object) {
		try
		{
			CapacityCategory capcategory=(CapacityCategory)object;
		
	getHibernateTemplate().update(capcategory);
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
	public Long updateDuplicateCheck(String capcategory,int capcategoryid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from CapacityCategory r where  r.capcategory='" + capcategory +"' and r.capcategoryId!='"+capcategoryid+"'" ;
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
	public String capcategoryDelete(int id)
	{
		CapacityCategory capcategory=null;
		try
		{
			capcategory=(CapacityCategory)getHibernateTemplate().get(CapacityCategory.class,id);
		
			getHibernateTemplate().delete(capcategory);
			capcategory.getCapcategory();
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}


}
