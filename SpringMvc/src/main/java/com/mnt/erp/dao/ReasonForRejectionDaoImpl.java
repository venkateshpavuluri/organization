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
import com.mnt.erp.bean.ReasonForRejection;

/**
 * @author Sailaja
 * @version 1.0 29-10-2013
 * @build 0.0
 *
 */
public class ReasonForRejectionDaoImpl extends HibernateDaoSupport implements ReasonForRejectionDao{
	String msg;
  /*=============================Add Method===================================*/
	@Override
	public String addReasonForRejection(Object object) {
		// TODO Auto-generated method stub
		try
		{
			
			ReasonForRejection rfr=(ReasonForRejection)object;
			getHibernateTemplate().save(rfr);
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
	public List<Object[]> searchReasonForRejection() {
		// TODO Auto-generated method stub
		List<Object[]> objs=null;
		try
		{
			
			String searchQuery="select rfr.reasonForRejectionId,rfr.reasonForRejection from ReasonForRejection rfr order by reasonForRejection";
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
	public List<Object[]> searchReasonForRejectionWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects=null;
		try
		{
			
			String searchQuery1="select rfr.reasonForRejectionId,rfr.reasonForRejection from ReasonForRejection rfr where rfr.reasonForRejectionId="+id+"";
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
	public String updateReasonForRejection(Object object) {
		// TODO Auto-generated method stub
		try
		{
			ReasonForRejection rfr=(ReasonForRejection)object;
			int id=rfr.getReasonForRejectionId();
			
			ReasonForRejection rfrValues=(ReasonForRejection)getHibernateTemplate().get(ReasonForRejection.class,id);
			rfrValues.setReasonForRejectionId(rfr.getReasonForRejectionId());
			rfrValues.setReasonForRejection(rfr.getReasonForRejection());
		
			getHibernateTemplate().update(rfr);
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
	public String deleteReasonForRejection(int id) {
		// TODO Auto-generated method stub
		ReasonForRejection rfr=null;
		try
		{
			rfr=(ReasonForRejection)getHibernateTemplate().get(ReasonForRejection.class,id);
			getHibernateTemplate().delete(rfr);
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
	public int checkDuplicate(String checkReasonForRejection) {
		// TODO Auto-generated method stub
		Long count = null;
	       try
	       { 
	    	   final String hql ="select count(*)  from ReasonForRejection rfr where rfr.reasonForRejection='"+checkReasonForRejection+"'";
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
	public int checkEditDuplicate(String checkReasonForRejection, int id) {
		// TODO Auto-generated method stub
		Long count = null;
	       try
	       { 
	    	   final String hql ="select count(*) from ReasonForRejection rfr where rfr.reasonForRejection='"+checkReasonForRejection+"' and rfr.reasonForRejectionId!='"+id+"' ";
	    	  
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
	public List<Object[]> basicSearchRFR(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects=null;
		try {

			String hql = "select rfr.reasonForRejectionId,rfr.reasonForRejection from ReasonForRejection rfr where rfr."
					+ label + "" + operator + " ?  ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
