
/*
 * @Copyright MNTSOFT
 * 
 */

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
import com.mnt.erp.bean.AgreementType;
import com.mnt.erp.service.AuditLogService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class AgreementTypeDaoImpl extends HibernateDaoSupport implements AgreementTypeDao{
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	List<Object[]> list=null;
	public String saveAgreementType(Object object,String userId,String userName)
	{ 
		
		try{
			
			AgreementType at=(AgreementType)object;
			
			Serializable id=getHibernateTemplate().save(at);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Agreement Type",
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
	
	public List<Object[]> searchAgreementType(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select at.agreementType_Id,at.agreementType from AgreementType at order by at.agreementType";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<Object[]> editAgreementTypeWithId(int id){
		List<Object[]> objects=null;
		try
		{	
			
	      String hql="select at.agreementType_Id,at.agreementType from AgreementType at where at.agreementType_Id="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateAgreementType(Object object){
		
		try
		{	
			AgreementType agreementType=(AgreementType)object;
			
			int id=agreementType.getEditAgreementType_Id();
			
			AgreementType agtype=(AgreementType)getHibernateTemplate().get(AgreementType.class,id);
			
			agtype.setAgreementType_Id(agreementType.getEditAgreementType_Id());
			
			agtype.setAgreementType(agreementType.getEditAgreementType());
			
			getHibernateTemplate().update(agtype);
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String agreementTypeDelete(int id){
		AgreementType at=null;
		
		try
		{
			at=(AgreementType)getHibernateTemplate().get(AgreementType.class,id);
			
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

	public int agreementTypeDuplicate(String agreementType){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from AgreementType a where a.agreementType='"+agreementType+"'";
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
	
	public int agreementTypeEditDuplicate(String agreementType,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from AgreementType a where a.agreementType='"+agreementType+"' and a.agreementType_Id!='"+id+"'";
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
	public List<Object[]> basicSearchAgreementType(String label,
			String operator, String searchName) {
		try {

			String hql = "select at.agreementType_Id,at.agreementType from AgreementType at where at."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
