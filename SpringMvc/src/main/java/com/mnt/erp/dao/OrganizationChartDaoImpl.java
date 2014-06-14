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
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Designation;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.OrganizationChart;

/**
 * @author tparvathi
 *
 */
public class OrganizationChartDaoImpl extends HibernateDaoSupport implements OrganizationChartDao {
	/*Autowired
	AuditLogService auditLogService;*/
	String msg=null;;
	List<Object[]> list=null;
	public String saveOrganizationChart(Object object,String userId,String userName)
	{ 
		
		try{
			
			OrganizationChart at=(OrganizationChart)object;
			
			Serializable id=getHibernateTemplate().save(at);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				//auditLogService.setAuditLogSave(userId, "A", "Agreement Type",
						//"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		   } 
		catch(Exception e){
			msg="F";
			e.printStackTrace();
		   }
		return msg;
	}
	
	public List<Object[]> searchOrganizationChart(int id){
		
		List<Object[]> objects=null;
		try
		{
			String hql="select o.organizationChartId,o.organization,o.designation,o.parentDesignation from OrganizationChart o";
			
	        objects=getHibernateTemplate().find(hql);
	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}
	
	
	public List<Object[]> editOrganizationChartWithId(int id){
		List<Object[]> objects=null;
		try
		{	
			
	      String hql="select at.organizationChartId,at.orgId,at.designationId,at.parentDesignationId from OrganizationChart at where at.organizationChartId="+id+"";
	      
	      objects=getHibernateTemplate().find(hql);
	      
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;

	}
	
	public String updateOrganizationChart(Object object){
		
		try
		{	
			OrganizationChart OrganizationChart=(OrganizationChart)object;
			
			int id=OrganizationChart.getOrganizationChartId();
			
			//OrganizationChart agtype=(OrganizationChart)getHibernateTemplate().get(OrganizationChart.class,id);
			
			
			
			getHibernateTemplate().update(OrganizationChart);
			
			msg="S";
			
			
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;

	}
	public String OrganizationChartDelete(int id){
		OrganizationChart at=null;
		
		try
		{
			at=(OrganizationChart)getHibernateTemplate().get(OrganizationChart.class,id);
			at.setOrganization(new Organization());
			at.setDesignation(new Designation());
			
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

	public int OrganizationChartDuplicate(String org,String designation,String parentDesignation){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from OrganizationChart a where a.orgId='"+org+"' and a.designationId='"+designation+"' and a.parentDesignationId='"+parentDesignation+"'";
	    	   System.out.println("the hql query is:"+hql);
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
	
	public int OrganizationChartEditDuplicate(String org,String designation,String parentDesignation,int id){
		Long count=null;
		try
	       { 
	    	   final String hql = "select count(*) from OrganizationChart a where a.orgId='"+org+"' and a.designationId='"+designation+"' and a.parentDesignationId='"+parentDesignation+"' and a.organizationChartId!='"+id+"'";
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
	public List<Object[]> basicSearchOrganizationChart(String label,
			String operator, String searchName) {
		try {

			String hql = "select o.organizationChartId,o.organization,o.designation,o.parentDesignation from OrganizationChart o where o."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
}
