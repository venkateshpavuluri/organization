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

import com.mnt.erp.bean.CostCenter;
import com.mnt.erp.service.AuditLogService;

public class CostCenterDaoImpl extends HibernateDaoSupport implements CostCenterDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	List<Object[]> list=null;
	public String saveCostCenter(Object object,String userId,String userName)
	{ 
		
		try{
			
			CostCenter at=(CostCenter)object;
			
			Serializable id=getHibernateTemplate().save(at);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Cost Center",
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
	
	public List<Object[]> searchCostCenter(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select at.costCenterId,at.costCenter from CostCenter at order by at.costCenter";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<Object[]> editCostCenterWithId(int id){
		List<Object[]> objects=null;
		try
		{	
			
	      String hql="select at.costCenterId,at.costCenter from CostCenter at where at.costCenterId="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateCostCenter(Object object){
		
		try
		{	
			CostCenter CostCenter=(CostCenter)object;
			
		int id=CostCenter.getCostCenterIdEdit();
			
			CostCenter costc=(CostCenter)getHibernateTemplate().get(CostCenter.class,id);
			
			costc.setCostCenterId(CostCenter.getCostCenterIdEdit());
			
			costc.setCostCenter(CostCenter.getCostCenterEdit());
			
			getHibernateTemplate().update(costc);
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String costCenterDelete(int id){
		CostCenter at=null;
		
		try
		{
			at=(CostCenter)getHibernateTemplate().get(CostCenter.class,id);
			
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

	public int costCenterDuplicate(String CostCenter){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from CostCenter a where a.costCenter='"+CostCenter+"'";
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
	
	public int costCenterEditDuplicate(String CostCenter,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from CostCenter a where a.costCenter='"+CostCenter+"' and a.costCenterId!='"+id+"'";
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
	public List<Object[]> basicSearchCostCenter(String label,
			String operator, String searchName) {
		try {

			String hql = "select at.costCenterId,at.costCenter from CostCenter at where at."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
