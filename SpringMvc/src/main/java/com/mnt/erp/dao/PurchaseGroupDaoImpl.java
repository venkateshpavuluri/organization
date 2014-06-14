/**
 @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.PurchaseGroup;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.controller.DeliveryNoteController;

/**
 * @author Sailaja
 * @version 1.0 26-10-2013
 * @build 0.0
 *
 */
public class PurchaseGroupDaoImpl extends HibernateDaoSupport implements PurchaseGroupDao{

	
	String msg=null;
	static Logger logger = Logger.getLogger(DeliveryNoteController.class);
	 List<Object[]> list=null;
	
	/*========================Add Method================================*/
	public String addPurchaseGroup(Object object) {
		// TODO Auto-generated method stub
		try
		{
			
			PurchaseGroup purchaseGroup=(PurchaseGroup)object;
			getHibernateTemplate().save(purchaseGroup);
			msg ="Purchase Group Details Successfully Saved";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	/*=========================Search(All) Method==============================*/
	@Override
	public List<Object[]> searchPurchaseGroup() {
		// TODO Auto-generated method stub
		List<Object[]> objs=null;
		try
		{
			String searchQuery="select pg.purchaseGroupId,pg.poBean,pg.purchaseGroup from PurchaseGroup pg order by purchaseGroup";
	        objs=getHibernateTemplate().find(searchQuery);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return objs;
	}
	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<PurchaseGroup> searchPurchaseGroupWithId(int id) {
		// TODO Auto-generated method stub
		List<PurchaseGroup> list=null;
		try
		{
			
			String searchQuery="from PurchaseGroup pg where pg.purchaseGroupId="+id+"";
	        list=getHibernateTemplate().find(searchQuery);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updatePurchaseGroup(Object object) {
		// TODO Auto-generated method stub
		try
		{
			PurchaseGroup purchaseUp=(PurchaseGroup)object;
			int id=purchaseUp.getPurchaseGroupId();
			
			PurchaseGroup purchaseGroupValues=(PurchaseGroup)getHibernateTemplate().get(PurchaseGroup.class,id);
			purchaseGroupValues.setPurOrg_Id(purchaseUp.getPurOrg_IdEditt());
			purchaseGroupValues.setPurchaseGroup(purchaseUp.getPurchaseGroupEditt());
			
			getHibernateTemplate().update(purchaseUp);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "Purchase Group Details Updated Successfully";
	}
	/*=========================Delete Method==============================*/
	@Override
	public String deletePurchaseGroup(int id) {
		// TODO Auto-generated method stub
		
	PurchaseGroup purchaseDel=null;
		try
		{
			
		purchaseDel=getHibernateTemplate().get(PurchaseGroup.class, id);
			getHibernateTemplate().delete(purchaseDel);
			purchaseDel.setPoBean(new PurchaseOrganization());
			return "Deleted";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Not Deleted";
		}
		
	}
	/*==========================Add Duplicate Checking Method==============================*/
	@Override
	public int checkDuplicate(String checkPurchaseGroup) {
		// TODO Auto-generated method stub
		Long count = null;
	       try
	       { 
	    	   final String hql ="select count(*) from PurchaseGroup pg where pg.purchaseGroup='"+checkPurchaseGroup+"'";
	   		    count = (Long) getHibernateTemplate().execute(new HibernateCallback<Object>()
	   		    		{
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
	/*==========================Edit Duplicate Checking Method==============================*/
	@Override
	public int checkEditDuplicate(String checkPurchaseGroup, int id) {
		// TODO Auto-generated method stub
		Long count = null;
	       try
	       { 
	    	   final String hql ="select count(*) from PurchaseGroup pg where pg.purchaseGroup='"+checkPurchaseGroup+"' and pg.purchaseGroupId!='"+id+"' ";
	   		    count = (Long) getHibernateTemplate().execute(new HibernateCallback<Object>()
	   		    		{
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
	public List<Object[]> basicSearchPurchaseGroup(String label,
			String operator, String searchName) {
		try {

			String hql = "select pg.purchaseGroupId,pg.poBean,pg.purchaseGroup from PurchaseGroup pg where pg."
					+ label + "" + operator + " ? ";
			
			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String addPurchaseGroup(Object object, String userId, String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
