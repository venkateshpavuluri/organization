package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;



import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.physicalVerification;

/**
 * @author Gkiran
 */

public class AuditLogDaoImpl extends HibernateDaoSupport implements AuditLogDao{
  String success=null;
	List<Object[]> objs = null;
	
String msg;
	
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;

	@Override
	public String addAuditLog(Object object)
	{
		// TODO Auto-generated method stub
		
		try
		{
			
			AuditLog pv=(AuditLog)object;
	        Serializable id=getHibernateTemplate().save(pv);
	        
	       // String hql = "from physicalVerification po where po.verificationId=" + id;
	    	//String hql = "select po.verificationId,po.verificationLineId from physicalVerification po, where po.verificationId=" + id;
			//obj = getHibernateTemplate().find(hql);
			
		    msg ="Success";
		}
		catch(Exception e)
		{
			//System.out.println("exceptions in addAudit");
			e.printStackTrace();
			msg ="fail";
			return msg;
		}
		return msg;
	}
  
	
	
  @Override
	public String saveAuditLog(com.mnt.erp.bean.AuditLog mm) {
		
		try
		{
		Serializable id=getHibernateTemplate().save(mm);
		logger.info("saved Auditlog id iss=="+id);
			success ="success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return success;
			
		
		
		
	}
  
  
  
  @Override
	public String saveAuditLogForAdd(Object object)
	{
		// TODO Auto-generated method stub
		String msg;
		try
		{
			
			List<AuditLog> kk=(List<AuditLog>)object;
	         getHibernateTemplate().saveOrUpdateAll(kk);
	    	
		    msg ="success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			msg ="fail";
		
			return msg;
		}
		return msg;
	}
	@Override
	public List<Object[]> setAuditLogSearch(String auditLog) {
		String hql=null;
		
		
		if(auditLog.equalsIgnoreCase("ALL"))
		{
	    hql="select h.auditLog_Id,h.userId,h.operation  ,h.objectChanged,h.objectType,h.status,h.timeStamp,h.userName from AuditLog h ";
	    
/*	    select AuditLog_Id, User_Id, 
		case Operation
		when 'A' then 'ADD'
		when 'S' then 'SEARCH'
		when 'E' then 'EDIT'
		when 'M' then 'UPDATE'
		when 'D' then 'DELETE'
		END AS Operation, 
		ObjectChanged, ObjectType, ObjectId, Status, TimeStamp 
		from dbo.AuditLog 
		
		
		 hql="select auditLog_Id,userId,  CASE WHEN operation 'A' THEN 'ADD'" +
	    		" WHEN operation 'S' THEN 'SER'" +
	    		"WHEN operation  'E' THEN 'EDIT'" +
	    		"WHEN operation 'M' THEN 'UPDA'" +
	    		"WHEN operation 'D' THEN 'DEL',objectChanged,objectType,status,timeStamp from AuditLog ";
	    		
	    		
*/	    //System.out.println("AuditLog in Empty");
		}
		
		if(!auditLog.equalsIgnoreCase("ALL"))
		{	
	   hql="select h.auditLog_Id,h.userId,h.operation,h.objectChanged,h.objectType,h.status,h.timeStamp,h.userName from AuditLog h where h.operation='"+auditLog+"'";
		//System.out.println("Kiran Non Empty");
		}
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		/*for (Object[] objects : list) {
			System.out.println("with in the dao for Material Search=="+objects);
		}*/
		//System.out.println("with in the dao for Bom Search=="+list);
			return list;	
		
		
	}
	
	@Override
	public List<Object[]> basicSearchAuditLog(String label, String operator,
			String searchName) {
		try {

			String hql = "select h.auditLog_Id,h.userId,h.operation,h.objectChanged,h.objectType,h.status,h.timeStamp,h.userName from AuditLog h where h."
					+ label + "" + operator +"'"+searchName+"'";
			System.out.println("Hql"+hql);
			
			objs = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Object[]> setAuditLogSearch(int id) {
		//System.out.println("Kiran Came to Int");
		
		String hql="select h.auditLog_Id,h.userId,h.operation,h.objectChanged,h.objectType,h.status,h.timeStamp from AuditLog h where h.auditLog_Id="+id;
		
		
		 List<Object[]> list=getHibernateTemplate().find(hql);
			
			/*for (Object[] objects : list) {
				System.out.println("with in the dao for Material Search=="+objects);
			}*/
			//System.out.println("with in the dao for BomCategory Search kk=="+list);
				return list;
		
		
	}
	
	@Override
	public List<Object> setAuditLogDetailSearch(int id) {
		//System.out.println("Kiran Came to Int");
		
		String hql=" select h.auditLogDetails from AuditLog h where h.auditLog_Id="+id;
		
		
		 List<Object> list=getHibernateTemplate().find(hql);
			
			/*for (Object[] objects : list) {
				System.out.println("with in the dao for Material Search=="+objects);
			}*/
			//System.out.println("with in the dao for BomCategory Search kk=="+list);
				return list;
		
		
	}
	
	
	
	
	
	
	@Override
	public String updateAuditLog(Object object) {
		try
		{
			com.mnt.erp.bean.AuditLog auditLog=(com.mnt.erp.bean.AuditLog)object;
			 
			/*int id=bomCategory.getBomCategoryIdEdit();
			String bomCategoryvalue=bomCategory.getBomCategoryEdit();
		
			System.out.println(id+" in Update ");
			System.out.println("kkkk");
			
		
			bomCategory.setBomCategoryId(id);
			bomCategory.setBomCategory(bomCategoryvalue);*/
			
			
			
			getHibernateTemplate().update(auditLog);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "Audit Log Updated Successfully";
	}
	
	public String auditLogDelete(int id)
	{
		com.mnt.erp.bean.AuditLog auditLog=null;
		try
		{
			auditLog=(com.mnt.erp.bean.AuditLog)getHibernateTemplate().get(com.mnt.erp.bean.AuditLog .class,id);
			getHibernateTemplate().delete(auditLog);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Audit Log Deleted Successfully";
	}
	

	public Long checkDuplicateAuditLog(String mm) {
		  List<Object> list=null;
		  Iterator<Object> it=null;
			Long count=null;
			try
			{
		
			String hql="select count(*) from AuditLog h where h.operation='"+mm+"'";
			list=getHibernateTemplate().find(hql);
			it=list.iterator();
			for (Object object : list) {
				count=(Long)object;
				//System.out.println("kiran duplicae Bom    "+count);
			}
			//success =count;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return count;
				
				
		}
	
	
	public Long checkDuplicateAuditLogUpdate(String mm,int id) {
		  List<Object> list=null;
		  Iterator<Object> it=null;
			Long count=null;
			try
			{
		
			String hql="select count(*) from AuditLog h where h.operation='"+mm+"' AND h.AuditLog_Id!="+id;
			list=getHibernateTemplate().find(hql);
			it=list.iterator();
			for (Object object : list) {
				count=(Long)object;
				//System.out.println("kiran duplicae Bom    "+count);
			}
			//success =count;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return count;
				
				
		}
	
	
	
	
	
}
