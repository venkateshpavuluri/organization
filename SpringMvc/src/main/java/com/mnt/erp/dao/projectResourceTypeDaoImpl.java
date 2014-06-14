package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ProjectResourceTypeBean;
import com.mnt.erp.service.AuditLogService;


public class projectResourceTypeDaoImpl extends HibernateDaoSupport implements projectResourceTypeDao{
	
	List<Object[]> list = null;
	Serializable id=null;
    @Autowired
	AuditLogService auditLogService;
	@Override
	public String saveProjectResourceType(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			id=getHibernateTemplate().save(object);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","projResourceType","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkProjectResourceType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  ProjectResourceTypeBean ag where ag.projectResourceType='"
					+ type + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProjectResourceType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.projectResourceType_Id,e.projectResourceType from ProjectResourceTypeBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProjectResourceTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.projectResourceType_Id,e.projectResourceType from ProjectResourceTypeBean e where e.projectResourceType_Id='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchProjectResourceType(String label,String operator,String searchName){
		try {

			String hql = "select e.projectResourceType_Id,e.projectResourceType from ProjectResourceTypeBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteProjectResourceType(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		ProjectResourceTypeBean prBean  = null;
		try {
			prBean= (ProjectResourceTypeBean) getHibernateTemplate().get(ProjectResourceTypeBean.class, id);
			getHibernateTemplate().delete(prBean);
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String updateProjectResourceType(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			ProjectResourceTypeBean ptBean=(ProjectResourceTypeBean) object;
			
			getHibernateTemplate().update(ptBean);
			s = "Project resource type Details Updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectProjectResourceType() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.projectResourceType_Id,e.projectResourceType from ProjectResourceTypeBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProjectResourceType(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  ProjectResourceTypeBean ag where ag.projectResourceType='"
					+ type + "' and ag.projectResourceType_Id!='" + Id + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}



}
