
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.DeliveryType;
import com.mnt.erp.service.AuditLogService;

/**
 * This is DeliveryTypeDao Implementation.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class DeliveryTypeDaoImpl extends HibernateDaoSupport implements DeliveryTypeDao{
	@Autowired
	AuditLogService auditLogService;
	
	String msg=null;
	List<Object[]> list=null;
	Serializable id=null;
	public String saveDeliveryType(Object object,String userid, String userName)
	{
		try{
			DeliveryType dt=(DeliveryType)object;
			id=getHibernateTemplate().save(dt);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userid,"A","deliveryType","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	public List<Object[]> searchDeliveryType(int id)
	{
		List<Object[]> objects=null;
		try
		{
			String hql="select dt.deliveryType_Id,dt.deliveryType from DeliveryType dt order by dt.deliveryType";
	        objects=getHibernateTemplate().find(hql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> editDeliveryTypeWithId(int id)
	{
		List<Object[]> objects=null;
		try
		{			
		String hql="select dt.deliveryType_Id,dt.deliveryType from DeliveryType dt where dt.deliveryType_Id="+id+"";
	    objects=getHibernateTemplate().find(hql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	public String updateDeliveryType(Object object){
		
		try
		{	
			DeliveryType deliveryType=(DeliveryType)object;
			int id=deliveryType.getDeliveryType_Id();
			DeliveryType dttype=(DeliveryType)getHibernateTemplate().get(DeliveryType.class,id);
			dttype.setDeliveryType_Id(deliveryType.getDeliveryType_Id());
			dttype.setDeliveryType(deliveryType.getEditDeliveryType());
			getHibernateTemplate().update(dttype);
			msg="S";
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}
	public String deliveryTypeDelete(int id){
		DeliveryType dt=null;
		try
		{
			//dt=(DeliveryType)getHibernateTemplate().get(DeliveryType.class,id);
			dt=new DeliveryType();
			dt.setDeliveryType_Id(id);
			getHibernateTemplate().delete(dt);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	
	}	
	public int deliveryTypeDuplicate(String deliveryType){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from DeliveryType d where d.deliveryType='"+deliveryType+"'";
	   		    count = (Long) getHibernateTemplate().execute(
	   				new HibernateCallback<Object>(){
	   					public Object doInHibernate(org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query=session.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
	   					}
	   				
	   				});
	   		
	       }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return count.intValue();
	}
	
	public int delivertyTypeEditDuplicate(String deliveryType,int id){
		
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from DeliveryType d where d.deliveryType='"+deliveryType+"' and d.deliveryType_Id!='"+id+"'";
	    	   
	   		    count = (Long) getHibernateTemplate().execute(
	   				new HibernateCallback<Object>(){
	   					public Object doInHibernate(org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query=session.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
	   					}
	   				
	   				});
	   		
	       }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count.intValue();
		
	}
	@Override
	public List<Object[]> basicSearchDeliveryType(String label,
			String operator, String searchName) {
		try {

			String hql = "select dt.deliveryType_Id,dt.deliveryType from DeliveryType dt where dt."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	}
