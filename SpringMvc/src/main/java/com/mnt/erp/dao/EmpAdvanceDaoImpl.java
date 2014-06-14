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
import com.mnt.erp.bean.EmpAdvance;
import com.mnt.erp.service.AuditLogService;
public class EmpAdvanceDaoImpl extends HibernateDaoSupport implements EmpAdvanceDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;;
	List<Object[]> list=null;
	public String saveEmpAdvance(Object object,String userId,String userName)
	{ 
		
		try{
			
			EmpAdvance at=(EmpAdvance)object;
			
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
	
	public List<Object[]> searchEmpAdvance(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select at.empAdvanceId,at.loanType,at.employee,at.advanceAmount,at.currency,at.repayAmountPM,at.status from EmpAdvance at";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<Object[]> editEmpAdvanceWithId(int id){
		List<Object[]> objects=null;
		try
		{	
			
	      String hql="select at.empAdvanceId,at.loanTypeId,at.employeeId,at.advanceAmount,at.currencyId,at.repayAmountPM,at.statusId,at.description,at.payModeId,at.bankId,at.branch,at.isFixedAmount,at.fixedAmount,at.isEMI,at.noofInstallments,at.sTDT from EmpAdvance at where at.empAdvanceId="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateEmpAdvance(Object object){
		
		try
		{	
			EmpAdvance empAdvance=(EmpAdvance)object;
			
			int id=empAdvance.getEmpAdvanceId();
			
			//EmpAdvance agtype=(EmpAdvance)getHibernateTemplate().get(EmpAdvance.class,id);
			
			
			
			getHibernateTemplate().update(empAdvance);
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String EmpAdvanceDelete(int id){
		EmpAdvance at=null;
		
		try
		{
			at=(EmpAdvance)getHibernateTemplate().get(EmpAdvance.class,id);
			
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

	public int EmpAdvanceDuplicate(String EmpAdvance){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from EmpAdvance a where a.employeeId='"+EmpAdvance+"'";
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
	
	public int EmpAdvanceEditDuplicate(String EmpAdvance,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from EmpAdvance a where a.employeeId='"+EmpAdvance+"' and a.empAdvanceId!='"+id+"'";
	    	   System.out.println("the hql is:"+hql);
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
	public List<Object[]> basicSearchEmpAdvance(String label,
			String operator, String searchName) {
		try {

			String hql = "select at.empAdvanceId,at.loanType,at.employee,at.advanceAmount,at.currency,at.repayAmountPM,at.status from EmpAdvance at where at."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
