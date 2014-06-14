/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.ReasonForMovement;

/**
 * @author Sailaja
 * @version 1.0 30-10-2013
 * @build 0.0
 *
 */
public class ReasonForMovementDaoImpl extends HibernateDaoSupport implements ReasonForMovementDao{
	String msg;
	  /*=============================Add Method===================================*/
		@Override
		public String addReasonForMovement(Object object) {
			// TODO Auto-generated method stub
			try
			{
				
				ReasonForMovement rfm=(ReasonForMovement)object;
				getHibernateTemplate().save(rfm);
			    msg ="S";
			}
			catch(Exception e)
			{
				msg="F";
				e.printStackTrace();
			}
			return msg;
		}
		/*=============================Search(All) Method===================================*/
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> searchReasonForMovement() {
			// TODO Auto-generated method stub
			List<Object[]> objs=null;
			try
			{
				
				String searchQuery="select rfm.reasonForMovementId,rfm.reasonForMovement from ReasonForMovement rfm order by reasonForMovement";
		        objs=getHibernateTemplate().find(searchQuery);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				return objs;
		}
		/*=============================Search(With Id) Method===================================*/
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> searchReasonForMovementWithId(int id) {
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try
			{
				
				String searchQuery1="select rfm.reasonForMovementId,rfm.reasonForMovement from ReasonForMovement rfm where rfm.reasonForMovementId="+id+"";
		         objects=getHibernateTemplate().find(searchQuery1);
		  

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				return objects;
		}
		/*=============================Update Method============================================*/
		@Override
		public String updateReasonForMovement(Object object) {
			// TODO Auto-generated method stub
			try
			{
				ReasonForMovement rfm=(ReasonForMovement)object;
				int id=rfm.getReasonForMovementId();
				
				ReasonForMovement rfmValues=(ReasonForMovement)getHibernateTemplate().get(ReasonForMovement.class,id);
				rfmValues.setReasonForMovementId(rfm.getReasonForMovementId());
				rfmValues.setReasonForMovement(rfm.getReasonForMovement());
			
				getHibernateTemplate().update(rfm);
				msg="S";
				
			}
			catch(Exception e)
			{
				msg="F";
				e.printStackTrace();
			}
			
			return msg;
		}
		/*=============================Delete Method============================================*/
		@Override
		public String deleteReasonForMovement(int id) {
			// TODO Auto-generated method stub
			ReasonForMovement rfm=null;
			try
			{
				rfm=(ReasonForMovement)getHibernateTemplate().get(ReasonForMovement.class,id);
				getHibernateTemplate().delete(rfm);
				msg="S";
			}
			catch(Exception e)
			{
				msg="F";
				e.printStackTrace();
			}
			return msg;

		}
		/*============================= Add Duplicate Check Method============================================*/
		@Override
		public int checkDuplicate(String checkReasonForMovement) {
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*)  from ReasonForMovement rfm where rfm.reasonForMovement='"+checkReasonForMovement+"'";
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
		/*============================= Edit Duplicate Check Method============================================*/
		@Override
		public int checkEditDuplicate(String checkReasonForMovement, int id) {
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from ReasonForMovement rfm where rfm.reasonForMovement='"+checkReasonForMovement+"' and rfm.reasonForMovementId!='"+id+"' ";
		    	  
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
		/*============================= Basic Search Method============================================*/
		@SuppressWarnings("unchecked")
		@Override
		public List<Object[]> basicSearchRFM(String label, String operator,
				String searchName) {
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try {

				String hql = "select rfm.reasonForMovementId,rfm.reasonForMovement from ReasonForMovement rfm where rfm."
						+ label + "" + operator + " ?  ";

				Object[] parameters = { searchName };
				objects = getHibernateTemplate().find(hql, parameters);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return objects;
		}

}
