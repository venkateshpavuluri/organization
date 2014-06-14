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

import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.service.AuditLogService;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class PaymentTermDaoImpl extends HibernateDaoSupport implements PaymentTermDao
{
	@Autowired
	AuditLogService auditLogService;
        String msg;
        List<Object[]> list=null;
     /*=============================Add Method===================================*/
        @Override
		public String addPaymentTerms(Object object,String userId,String userName)
		{
			// TODO Auto-generated method stub
			try
			{
			
				PaymentTerms payment_term=(PaymentTerms)object;
				Serializable id=getHibernateTemplate().save(payment_term);
				if (id != null) {

					Date date = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(userId, "A", "Payment Term",
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
		public List<Object[]> searchPaymentTerms()
		{
			// TODO Auto-generated method stub
			List<Object[]> objs=null;
		try
		{
			
			String searchQuery="select pt.paymentTermId,pt.paymentTermName from PaymentTerms pt order by pt.paymentTermName";
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
		public List<Object[]> searchPaymentTermsWithId(int id)
		{
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try
			{
				
				String searchQuery1="select pt.paymentTermId,pt.paymentTermName from PaymentTerms pt where pt.paymentTermId="+id+"";
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
		public String updatePaymentTerms(Object object)
		{
			// TODO Auto-generated method stub
			try
			{
				PaymentTerms payment_term=(PaymentTerms)object;
				int id=payment_term.getPaymentTermId();
				
				PaymentTerms paymentTermValues=(PaymentTerms)getHibernateTemplate().get(PaymentTerms.class,id);
				paymentTermValues.setPaymentTermId(payment_term.getPaymentTermId());
				paymentTermValues.setPaymentTermName(payment_term.getPaymentTermName());
			
				getHibernateTemplate().update(payment_term);
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
		public String deletePaymentTerms(int id)
		{
			// TODO Auto-generated method stub
			PaymentTerms payment_term=null;
			try
			{
				payment_term=(PaymentTerms)getHibernateTemplate().get(PaymentTerms.class,id);
				getHibernateTemplate().delete(payment_term);
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
		public int checkDuplicate(String checkPaymentTermName)
		{
			// TODO Auto-generated method stub
	
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from PaymentTerms pt where pt.paymentTermName='"+checkPaymentTermName+"'";
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
		public int checkEditDuplicate(String checkPaymentTermName, int id) 
		{
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from PaymentTerms pt where pt.paymentTermName='"+checkPaymentTermName+"' and pt.paymentTermId!='"+id+"'";
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
		public List<Object[]> basicSearchPaymentTerms(String label,
				String operator, String searchName) {
			try {

				String hql = "select pt.paymentTermId,pt.paymentTermName from PaymentTerms pt where pt."
						+ label + "" + operator + " ? ";

				Object[] parameters = { searchName };
				list = getHibernateTemplate().find(hql, parameters);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		

}
