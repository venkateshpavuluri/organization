/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.MRPType;

/**
 * @author sailajach
 * @version 1.0 25-01-2014
 * @build 0.0
 *
 */
public class MrpTypeDaoImpl extends HibernateDaoSupport implements MrpTypeDao {
	String msg=null;
	 List<Object[]> list=null;
	 /*=============================Add Method===================================*/
		@Override
		public String addMrpType(Object object) 
		{
			// TODO Auto-generated method stub
			try
			{
				
				MRPType mrpType=(MRPType)object;
				Serializable id=getHibernateTemplate().save(mrpType);
			  if(id!=null){
				  msg="S";
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
		public List<Object[]> searchMrpType()
		{
			// TODO Auto-generated method stub
			List<Object[]> objs=null;
			try
			{
				
				String searchQuery="select mrt.mrpTypeId,mrt.mrpType from MRPType mrt";
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
		public List<Object[]> searchMrpTypeWithId(int id)
		{
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try
			{
				
				String searchQuery1="select mrt.mrpTypeId,mrt.mrpType from MRPType mrt where mrt.mrpTypeId="+id+"";
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
		public String updateMrpType(Object object) 
		{
			// TODO Auto-generated method stub
			try
			{
				MRPType mrpType=(MRPType)object;
				int id=mrpType.getMrpTypeId();
				
				MRPType mrpTypeValues=(MRPType)getHibernateTemplate().get(MRPType.class,id);
				mrpTypeValues.setMrpTypeId(mrpType.getMrpTypeId());
				mrpTypeValues.setMrpType(mrpType.getMrpType());
			
				getHibernateTemplate().update(mrpType);
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
		public String deleteMrpType(int id) 
		{
			// TODO Auto-generated method stub
			MRPType mrpType=null;
			try
			{
				mrpType=(MRPType)getHibernateTemplate().get(MRPType.class,id);
				getHibernateTemplate().delete(mrpType);
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
		public int checkDuplicate(String checkMrpType)
		{
			// TODO Auto-generated method stub
	
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from MRPType mrt where mrt.mrpType='"+checkMrpType+"'";
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
		public int checkEditDuplicate(String checkMrpType, int id) {
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from MRPType mrt where mrt.mrpType='"+checkMrpType+"' and mrt.mrpTypeId!='"+id+"' ";
		    	  
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
		public List<Object[]> basicSearchMrpType(String label,
				String operator, String searchName) {
			try {

				String hql = "select mrt.mrpTypeId,mrt.mrpType from MRPType mrt where mrt."
						+ label + "" + operator + " ? ";

				Object[] parameters = { searchName };
				list = getHibernateTemplate().find(hql, parameters);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}


}
