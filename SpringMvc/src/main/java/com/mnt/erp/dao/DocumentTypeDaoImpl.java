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
import com.mnt.erp.bean.DocumentType;
import com.mnt.erp.service.AuditLogService;

public class DocumentTypeDaoImpl extends HibernateDaoSupport implements DocumentTypeDao{
	
	String msg=null;
	@Autowired
	AuditLogService auditLogService;
	public String saveDocumentType(Object object,String userId,String userName)
	{
		
		try{
			DocumentType dt=(DocumentType)object;
			Serializable id=getHibernateTemplate().save(dt);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Code Group",
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
	public List<Object[]> searchDocumentType()
	{
		List<Object[]> objects=null;
		try
		{
			String hql="select documentType_Id,documentType from DocumentType order by documentType";
	        objects=getHibernateTemplate().find(hql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> editDocumentTypeWithId(int id)
	{
		List<Object[]> objects=null;
		try
		{			
		String hql="select documentType_Id,documentType from DocumentType where documentType_Id="+id+"";
	    objects=getHibernateTemplate().find(hql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	public String updateDocumentType(Object object){
		try
		{	
			DocumentType documentType=(DocumentType)object;
			int id=documentType.getDocumentType_IdEdit();
			DocumentType dttype=(DocumentType)getHibernateTemplate().get(DocumentType.class,id);
			dttype.setDocumentType_Id(documentType.getDocumentType_IdEdit());
			dttype.setDocumentType(documentType.getDocumentTypeEdit());
			getHibernateTemplate().update(dttype);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}
	public String deleteDocumentType(int id){
		DocumentType dt=null;
		try
		{
			dt=(DocumentType)getHibernateTemplate().get(DocumentType.class,id);
			
			getHibernateTemplate().delete(dt);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		return msg;
	
	}	
	public int documentTypeDuplicate(String documentType){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from DocumentType d where d.documentType='"+documentType+"'";
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
	
	public int documentTypeEditDuplicate(String documentType,int id){
		
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from DocumentType d where d.documentType='"+documentType+"' and d.documentType_Id!='"+id+"'";
	    	   
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
	public List<Object[]> basicSearchAssertType(String label, String operator,
			String searchName) {
		List<Object[]> objects = null;
		try {

			String hql = "select documentType_Id,documentType from DocumentType q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	
		
	}
}
