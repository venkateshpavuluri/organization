/**

 *
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ItemCategory;
import com.mnt.erp.service.AuditLogService;
/**
 * @author Sailajach
   @version 1.0
   @build 0.0
 *
 */
public class ItemCategoryDaoImpl extends HibernateDaoSupport implements ItemCategoryDao
{
	@Autowired
	AuditLogService auditLogService;
	 String msg;
	 List<Object[]> list=null;
	 /*=============================Add Method===================================*/
		@Override
		public String addItemCategory(Object object,String userId,String userName) 
		{
			// TODO Auto-generated method stub
			try
			{
				
				ItemCategory itemCategory=(ItemCategory)object;
			Serializable id=getHibernateTemplate().save(itemCategory);
			if(id!=null)
			{
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
auditLogService.setAuditLogSave(userId,"A","Item Category","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
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
   /*=============================Search(All)  Method===================================*/
		@Override
		public List<Object[]> searchItemCategory()
		{
			// TODO Auto-generated method stub
			List<Object[]> objs=null;
			try
			{
				
				String searchQuery="select ic.itemCategoryId,ic.itemCategory from ItemCategory ic order by itemCategory";
		        objs=getHibernateTemplate().find(searchQuery);
	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				return objs;
		}
	/*=============================Search (WithId) Method===================================*/
		@Override
		public List<Object[]> searchItemCategoryWithId(int id)
		{
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try
			{
				
				String searchQuery1="select ic.itemCategoryId,ic.itemCategory from ItemCategory ic where ic.itemCategoryId="+id+"";
		         objects=getHibernateTemplate().find(searchQuery1);
		  
	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				return objects;
		}
	/*=============================Update Method===================================*/
		@Override
		public String updateItemCategory(Object object) 
		{
			// TODO Auto-generated method stub
			try
			{
				ItemCategory itemCategory=(ItemCategory)object;
				int id=itemCategory.getItemCategoryId();
				
				ItemCategory itemCategoryValues=(ItemCategory)getHibernateTemplate().get(ItemCategory.class,id);
				itemCategoryValues.setItemCategoryId(itemCategory.getItemCategoryId());
				itemCategoryValues.setItemCategory(itemCategory.getItemCategory());
			
				getHibernateTemplate().update(itemCategory);
				msg="S";
				
			}
			catch(Exception e)
			{
				msg="F";
				e.printStackTrace();
			}
			
			return msg;
	
		}
	 /*=============================Delete Method===================================*/
		@Override
		public String deleteItemCategory(int id) 
		{
			// TODO Auto-generated method stub
			ItemCategory itemCategory=null;
			try
			{
				itemCategory=(ItemCategory)getHibernateTemplate().get(ItemCategory.class,id);
				getHibernateTemplate().delete(itemCategory);
				msg="S";
			}
			catch(Exception e)
			{
				msg="F";
				e.printStackTrace();
			}
			return msg;
		}
		
	 /*=============================Add Duplicate Checking Method===================================*/
		@Override
		public int checkDuplicate(String checkItemCategory)
		{
			// TODO Auto-generated method stub
	
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from ItemCategory ic where ic.itemCategory='"+checkItemCategory+"'";
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
		    	   e.printStackTrace();
		       }
		return count.intValue();
		}
	 /*=============================Edit Duplicate Checking Method===================================*/
		@Override
		public int checkEditDuplicate(String checkItemCategory, int id) {
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from ItemCategory ic where ic.itemCategory='"+checkItemCategory+"' and ic.itemCategoryId!='"+id+"' ";
		    	  
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
		    	   e.printStackTrace();
		       }
		       return count.intValue();
		}
		@Override
		public List<Object[]> basicSearchItemCategory(String label,
				String operator, String searchName) {
			try {

				String hql = "select ic.itemCategoryId,ic.itemCategory from ItemCategory ic where ic."
						+ label + "" + operator + " ? ";

				Object[] parameters = { searchName };
				list = getHibernateTemplate().find(hql, parameters);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

}
