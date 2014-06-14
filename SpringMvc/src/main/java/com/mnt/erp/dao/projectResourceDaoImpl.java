package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



import com.mnt.erp.bean.Designation;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ProjectResourceTypeBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.projectResourceBean;
import com.mnt.erp.service.AuditLogService;

public class projectResourceDaoImpl extends HibernateDaoSupport implements projectResourceDao{
	String brmessage;
	List<Object[]> list=null;
	Serializable id=null;
    @Autowired
	AuditLogService auditLogService;
	@Override
	public String saveProjectResource(Object btObject,String userId,String userName) {
		// TODO Auto-generated method stub
		try{
			projectResourceBean btbean=(projectResourceBean)btObject;
			id=getHibernateTemplate().save(btbean);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","projResource","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			brmessage="S";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@Override
public List<Object[]> selectProjectResource() {
	try{
		String hql="select s.projectResource_Id from projectResourceBean s";
		list=getHibernateTemplate().find(hql);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchProjectResourceWithId(int id ) {
	
		try{
			String hql="select s.projectResource_Id,s.employee,s.project,s.designation,s.stDate,s.endDate,s.prtype,s.stdCostHr,s.otCostHr,s.uom from projectResourceBean s where s.projectResource_Id="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchProjectResource() {
	try{
		String hql="select s.projectResource_Id,s.empBean,s.projectBean,s.desgBean,s.stDate,s.endDate,s.prtBean,s.stdCostHr,s.otCostHr,s.uomBean from projectResourceBean s";
		list=getHibernateTemplate().find(hql);
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public String updateProjectResource(Object btObject) {
		try{
			projectResourceBean btbean=(projectResourceBean)btObject;
			int id = btbean.getProjectResource_IdEdit();
			projectResourceBean btime = (projectResourceBean) getHibernateTemplate().get(
					projectResourceBean.class, id);
			
			btime.setProjectResource_Id(btbean.getProjectResource_IdEdit());
			 btime.setEmployee(btbean.getEmployeeEdit());
			 btime.setProject(btbean.getProject());
	         btime.setDesignation(btbean.getDesignationEdit());
	         btime.setStDate(btbean.getStDateEdit());
	         btime.setEndDate(btbean.getEndDateEdit());
	         btime.setPrtype(btbean.getPrtypeEdit());
	         btime.setStdCostHr(btbean.getStdCostHrEdit());
	         btime.setOtCostHr(btbean.getOtCostHrEdit());
	         btime.setUom(btbean.getUomEdit());
			
			getHibernateTemplate().update(btime);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}

	public String deleteProjectResource(int id) {
		
		try{
			projectResourceBean btbean=(projectResourceBean)getHibernateTemplate().get(projectResourceBean.class, id);
			btbean.setEmpBean(new Employee());
			btbean.setDesgBean(new Designation());
			btbean.setPrtBean(new ProjectResourceTypeBean());
			btbean.setProjectBean(new Project());
			btbean.setUomBean(new Uom());
			
			getHibernateTemplate().delete(btbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long getProjectResourceCount(int id) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from projectResourceBean s where  s.employee='"+id+"'";
			List<Object> list=getHibernateTemplate().find(sql);
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				Object object=(Object)iterator.next();
				p=(Long)object;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return p;
	}
	
	//@SuppressWarnings("unchecked")
	public Long getProjectResourceCountedit(String name,int id) {
		Iterator<Object> iterator=null;
		Long count=null;
		try{
			int ji=Integer.parseInt(name);
			final String	sql="select count(*) from projectResourceBean s where  s.employee="+ji+"and s.projectResource_Id!='"+id+"'";
				    
		count = (Long) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(
							org.hibernate.Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						org.hibernate.Query query = session
								.createQuery(sql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}

				});

		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> basicSearchProjectResource(String label, String operator,
			String searchName) {
		try {
System.out.println("emp id=="+searchName);
			String hql = "select s.projectResource_Id,s.empBean,s.projectBean,s.desgBean,s.stDate,s.endDate,s.prtBean,s.stdCostHr,s.otCostHr,s.uomBean from projectResourceBean s where s."
					+ label + "" + operator + "? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
			System.out.println("lis size iss==="+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getEmployeeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select o.employee_Id,o.fName from Employee o";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getProjectIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.projectId,s.projectName from Project s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<Object[]> getPrtypeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.projectResourceType_Id,s.projectResourceType from ProjectResourceTypeBean s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getDesgIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.designationId,s.designation from Designation s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getUomIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.uom_Id,s.uom from Uom s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
