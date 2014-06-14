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

import com.mnt.erp.bean.SamplingType;
import com.mnt.erp.service.AuditLogService;

public class SamplingTypeDaoImpl extends HibernateDaoSupport implements SamplingTypeDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	List<Object[]> list=null;
	public String saveSamplingType(Object object,String userId,String userName)
	{ 
		
		try{
			
			SamplingType at=(SamplingType)object;
			
			Serializable id=getHibernateTemplate().save(at);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Sampling Type",
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
	
	public List<Object[]> searchSamplingType(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select at.samplingTypeId,at.samplingTypeName from SamplingType at order by at.samplingTypeName";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<Object[]> editSamplingTypeWithId(int id){
		List<Object[]> objects=null;
		try
		{	
			
	      String hql="select at.samplingTypeId,at.samplingTypeName from SamplingType at where at.samplingTypeId="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateSamplingType(Object object){
		
		try
		{	
			SamplingType SamplingType=(SamplingType)object;
		int id=SamplingType.getSamplingTypeIdEdit();
			
			SamplingType samtype=(SamplingType)getHibernateTemplate().get(SamplingType.class,id);
			
			samtype.setSamplingTypeId(SamplingType.getSamplingTypeIdEdit());
			
			samtype.setSamplingTypeName(SamplingType.getSamplingTypeNameEdit());
			
			getHibernateTemplate().update(samtype);
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String samplingTypeDelete(int id){
		SamplingType at=null;
		
		try
		{
			at=(SamplingType)getHibernateTemplate().get(SamplingType.class,id);
			
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

	public int samplingTypeDuplicate(String SamplingType){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from SamplingType a where a.samplingTypeName='"+SamplingType+"'";
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
	
	public int samplingTypeEditDuplicate(String SamplingType,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from SamplingType a where a.samplingTypeName='"+SamplingType+"' and a.samplingTypeId!='"+id+"'";
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
	public List<Object[]> basicSearchSamplingType(String label,
			String operator, String searchName) {
		try {

			String hql = "select at.samplingTypeId,at.samplingTypeName from SamplingType at where at."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
