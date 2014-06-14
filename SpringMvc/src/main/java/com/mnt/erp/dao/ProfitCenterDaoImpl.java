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

import com.mnt.erp.bean.ProfitCenter;
import com.mnt.erp.service.AuditLogService;

public class ProfitCenterDaoImpl extends HibernateDaoSupport implements ProfitCenterDao{
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	List<Object[]> list=null;
	public String saveProfitCenter(Object object,String userId,String userName)
	{ 
		
		try{
			
			ProfitCenter at=(ProfitCenter)object;
			
			Serializable id=getHibernateTemplate().save(at);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Profit Center",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		   } 
		catch(Exception e){
			msg="F";
			e.printStackTrace();
		   }
		
		return msg;
	}
	
	public List<Object[]> searchProfitCenter(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select at.profitCenterId,at.profitCenter from ProfitCenter at order by at.profitCenter";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<Object[]> editProfitCenterWithId(int id){
		List<Object[]> objects=null;
		try
		{	
			
	      String hql="select at.profitCenterId,at.profitCenter from ProfitCenter at where at.profitCenterId="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateProfitCenter(Object object){
		
		try
		{	
			ProfitCenter ProfitCenter=(ProfitCenter)object;
			
			int id=ProfitCenter.getProfitCenterIdEdit();
			
			ProfitCenter protype=(ProfitCenter)getHibernateTemplate().get(ProfitCenter.class,id);
			
			protype.setProfitCenterId(ProfitCenter.getProfitCenterIdEdit());
			
			protype.setProfitCenter(ProfitCenter.getProfitCenterEdit());
			
			getHibernateTemplate().update(protype);
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String profitCenterDelete(int id){
		ProfitCenter at=null;
		
		try
		{
			at=(ProfitCenter)getHibernateTemplate().get(ProfitCenter.class,id);
			
			getHibernateTemplate().delete(at);
			
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	
	}

	public int profitCenterDuplicate(String ProfitCenter){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from ProfitCenter a where a.profitCenter='"+ProfitCenter+"'";
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
	
	public int profitCenterEditDuplicate(String ProfitCenter,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from ProfitCenter a where a.profitCenter='"+ProfitCenter+"' and a.profitCenterId!='"+id+"'";
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
	public List<Object[]> basicSearchProfitCenter(String label,
			String operator, String searchName) {
		try {

			String hql = "select at.profitCenterId,at.profitCenter from ProfitCenter at where at."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
