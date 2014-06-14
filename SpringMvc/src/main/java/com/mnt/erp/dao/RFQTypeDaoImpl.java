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
import com.mnt.erp.bean.RFQType;
import com.mnt.erp.service.AuditLogService;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class RFQTypeDaoImpl extends HibernateDaoSupport implements RFQTypeDao
{
	
	@Autowired
	AuditLogService auditLogService;
	String msg;
	List<Object[]> list=null;
	/*=============================Add Method===================================*/
		@Override
		public String addRFQType(Object object,String userId,String userName)
		{
			// TODO Auto-generated method stub
			try
			{
				
				RFQType rfqType=(RFQType)object;
				Serializable id=getHibernateTemplate().save(rfqType);
				if (id != null) {

					Date date = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(userId, "A", "RFQ Type",
							"ROW", String.valueOf(id), "1", modifiedDate, userName);
					msg = "S";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}
	/*=============================Search(All) Method===================================*/
		@Override
		public List<Object[]> searchRFQType()
		{
			// TODO Auto-generated method stub
			List<Object[]> objs=null;
			try
			{
				
				String searchQuery="select rfq.rfqTypeId,rfq.rfqType from RFQType rfq";
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
		public List<Object[]> searchRFQTypeWithId(int id) 
		{
			// TODO Auto-generated method stub
			List<Object[]> objects=null;
			try
			{
				
				String searchQuery1="select rfq.rfqTypeId,rfq.rfqType from RFQType rfq where rfq.rfqTypeId="+id+"";
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
		public String updateRFQType(Object object)
		{
			// TODO Auto-generated method stub
			try
			{
				RFQType rfqType=(RFQType)object;
				int id=rfqType.getRfqTypeId();
				
				RFQType rfqTypeValues=(RFQType)getHibernateTemplate().get(RFQType.class,id);
				rfqTypeValues.setRfqTypeId(rfqType.getRfqTypeId());
				rfqTypeValues.setRfqType(rfqType.getRfqType());
			
				getHibernateTemplate().update(rfqType);
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
		public String deleteRFQType(int id)
		{
			// TODO Auto-generated method stub
			RFQType rfqType=null;
			try
			{
				rfqType=(RFQType)getHibernateTemplate().get(RFQType.class,id);
				getHibernateTemplate().delete(rfqType);
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
		public int checkDuplicate(String checkRFQType)
		{
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from RFQType rfq where rfq.rfqType='"+checkRFQType+"'";
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
		public int checkEditDuplicate(String checkRFQType, int id) 
		{
			// TODO Auto-generated method stub
			Long count = null;
		       try
		       { 
		    	   final String hql ="select count(*) from RFQType rfq where rfq.rfqType='"+checkRFQType+"' and rfq.rfqTypeId!='"+id+"'";
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
		public List<Object[]> basicSearchRFQtype(String label, String operator,
				String searchName) {
			try {

				String hql = "select rfq.rfqTypeId,rfq.rfqType from RFQType rfq where rfq."
						+ label + "" + operator + " ? ";

				Object[] parameters = { searchName };
				list = getHibernateTemplate().find(hql, parameters);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

}
