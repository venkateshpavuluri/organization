/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.BillingType;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public class BillingTypeDaoImpl extends HibernateDaoSupport implements BillingTypeDao{
	
	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Override
	public String saveBillingTypeDetails(Object object) {
		try
		{
			BillingType billingtype=(BillingType)object;
			Serializable id=getHibernateTemplate().save(billingtype);
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
	@Override
	public Long duplicateBillingTypeCheck(String billingtype) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from BillingType r where  r.billingtype='" + billingtype+ "'";
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
	public List<Object[]> searchBillingType() {
	
	try
	{
		
		String hql="select r.billingtypeId,r.billingtype from BillingType r";
		
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	
	public List<Object[]> searchBillingTypeWithName(String billingtypename) {
		List<Object[]> objects=null;
	try
	{
		
		String hql="select r.billingtypeId,r.billingtype from BillingType r where r.billingtypeId="+billingtypename+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectBillingTypeNames() {
		String sql=null;
	try
	{
	sql="select r.billingtypeId, r.billingtype from BillingType r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchBillingTypeWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		System.out.println("billingtype id in search billingtype with id   "+id);
		String hql="select r.billingtypeId,r.billingtype from BillingType r where r.billingtypeId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateBillingType(Object object) {
		try
		{
			BillingType billingtype=(BillingType)object;
		
	getHibernateTemplate().update(billingtype);
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
	public Long updateDuplicateCheck(String billingtype,int billingtypeid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from BillingType r where  r.billingtype='" + billingtype +"' and r.billingtypeId!='"+billingtypeid+"'" ;
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
	public String billingtypeDelete(int id)
	{
		BillingType billingtype=null;
		try
		{
			billingtype=(BillingType)getHibernateTemplate().get(BillingType.class,id);
		
			getHibernateTemplate().delete(billingtype);
			billingtype.getBillingtype();
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchBillingType(String label, String operator,
			String searchName) {
		try {
System.out.println("in basic search of billing type");
			String hql = "select r.billingtypeId,r.billingtype from BillingType r where r."
					+ label + "" + operator + " ? ";
System.out.println("query in basic search is   "+hql);
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}


}
