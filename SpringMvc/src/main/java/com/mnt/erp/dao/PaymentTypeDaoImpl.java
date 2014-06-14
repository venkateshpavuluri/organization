/**
@Copyright MNTSOFT
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
import com.mnt.erp.bean.PaymentType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author sailajach
 * @version 1.0 10-12-2013
 * @Build 0.0
 *
 */
public class PaymentTypeDaoImpl extends HibernateDaoSupport implements PaymentTypeDao{
	@Autowired
	AuditLogService auditLogService;
	  String msg;
      List<Object[]> list=null;
   /*=============================Add Method===================================*/
      @Override
		public String addPaymentType(Object object,String userId,String userName)
		{
			// TODO Auto-generated method stub
			try
			{
				
				PaymentType payment_type=(PaymentType)object;
				Serializable id=getHibernateTemplate().save(payment_type);
				if (id != null) {

					Date date = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(userId, "A", "Payment Type",
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
	/*=============================Search(All) Method===================================*/
		@Override
		public List<Object[]> searchPaymentType()
		{
			// TODO Auto-generated method stub
			List<Object[]> objs=null;
		try
		{
			
			String searchQuery="select pt.paymentTypeId,pt.paymentType from PaymentType pt order by pt.paymentType";
	        objs=getHibernateTemplate().find(searchQuery);
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return objs;
		}
	/*=============================Search(With Id) Method===================================*/
		@Override
		public List<Object[]> searchPaymentTypeWithId(int id)
		{
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try
			{
				
				String searchQuery1="select pt.paymentTypeId,pt.paymentType from PaymentType pt where pt.paymentTypeId="+id+"";
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
		public String updatePaymentType(Object object)
		{
			// TODO Auto-generated method stub
			try
			{
				PaymentType payment_type=(PaymentType)object;
				int id=payment_type.getPaymentTypeId();
				
				PaymentType paymentTypeValues=(PaymentType)getHibernateTemplate().get(PaymentType.class,id);
				paymentTypeValues.setPaymentTypeId(payment_type.getPaymentTypeId());
				paymentTypeValues.setPaymentType(payment_type.getPaymentType());
			
				getHibernateTemplate().update(payment_type);
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
		public String deletePaymentType(int id)
		{
			// TODO Auto-generated method stub
			PaymentType payment_type=null;
			try
			{
				payment_type=(PaymentType)getHibernateTemplate().get(PaymentType.class,id);
				getHibernateTemplate().delete(payment_type);
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
		public int checkDuplicate(String checkPaymentType)
		{
			// TODO Auto-generated method stub
	
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from PaymentType pt where pt.paymentType='"+checkPaymentType+"'";
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
		public int checkEditDuplicate(String checkPaymentType, int id) 
		{
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from PaymentType pt where pt.paymentType='"+checkPaymentType+"' and pt.paymentTypeId!='"+id+"'";
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
		@Override
		public List<Object[]> basicSearchPaymentType(String label,
				String operator, String searchName) {
			try {

				String hql = "select pt.paymentTypeId,pt.paymentType from PaymentType pt where pt."
						+ label + "" + operator + " ? ";

				Object[] parameters = { searchName };
				list = getHibernateTemplate().find(hql, parameters);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		


}
