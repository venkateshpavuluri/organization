/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ClaimBean;
import com.mnt.erp.bean.ClaimDocumentsBean;
import com.mnt.erp.bean.ProjectTask;
import com.mnt.erp.bean.ProjectTaskDocument;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class ClaimDaoImpl extends HibernateDaoSupport implements ClaimDao{
	
	String msg=null;
	List<Object[]> list=null;
	String sql=null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id=null;
	
	
	public String saveClaim(Object object,String userId,String userName)
	{
		
		try
		{
			ClaimBean claim=(ClaimBean)object;
			id=getHibernateTemplate().save(claim);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Claim","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}
	public List<Object[]> getClaimTypeIds(){
		try
		{
			sql="select c.claimTypeId,c.claimType from ClaimTypeBean c ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> getEmployeeIds(){
		try
		{
			sql="select e.employee_Id ,e.fName from Employee e ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> getStatusIds(){
		try
		{
			sql="select s.statusId ,s.status from Status s ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchClaim() {
		// TODO Auto-generated method stub
		try
		{
			sql="select c.claimId,c.claimTypeDetails,c.claimNo,c.empDetails,c.amount,c.statusDetails,c.description from com.mnt.erp.bean.ClaimBean c ";
			list=getHibernateTemplate().find(sql);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> basicSearchClaim(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try
		{

			
			sql="select c.claimId,c.claimTypeDetails,c.claimNo,c.empDetails,c.amount,c.statusDetails,c.description from com.mnt.erp.bean.ClaimBean c  where c."
					+ dbField + "" + operation + " ? ";
			Object[] parameters = { basicSearchId };
			list=getHibernateTemplate().find(sql,parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try
		{
			List<ClaimDocumentsBean> integers=(List<ClaimDocumentsBean>)object;
			if(integers!=null)
			{
				getHibernateTemplate().deleteAll(integers);
				msg="child Rows Deleted Successfully";
			}
			
		}
		catch(Exception e)
		{
			msg="child Rows Did Not Deleted ";
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String deleteClaim(int claimId) {
		// TODO Auto-generated method stub
		ClaimBean claim=null;
		try
		{
			ClaimBean claim2= new ClaimBean();
			claim2.setClaimId(claimId);
				
			claim=(ClaimBean)getHibernateTemplate().get(ClaimBean.class,claimId);
			
			 Set<ClaimDocumentsBean> claimDoc=claim.getClaimDocDetails();
			
			
			 getHibernateTemplate().deleteAll(claimDoc);
			 getHibernateTemplate().delete(claim2);
			 msg="S";
			 
		}
		catch(Exception e)
		{
			 msg="F";
			e.printStackTrace();
			 
		}
		
		return msg;
	}
	@Override
	public List<ClaimBean> editClaimDetails(int claimId) {
		// TODO Auto-generated method stub    

		List<ClaimBean> claim=null;
		try
		{
			
			
			sql="from com.mnt.erp.bean.ClaimBean c where c.claimId="+claimId+"";
			claim=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return claim;
	}
	@Override
	public String updateClaimDetails(Object object) {
		// TODO Auto-generated method stub
		String messagesg=null;
		try
		{
			ClaimBean claim=(ClaimBean)object;
				getHibernateTemplate().update(claim);
					messagesg="S";
		}
		catch(Exception e)
		{
			messagesg="S";
			e.printStackTrace();
		}
		return messagesg;
	}

}
