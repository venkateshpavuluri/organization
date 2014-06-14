package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ProcessTypeBean;


public class processTypeDaoImpl extends HibernateDaoSupport implements processTypeDao{
	List<Object[]> list = null;
	@Override
	public String saveProcessType(Object object) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			Serializable id=getHibernateTemplate().save(object);
			if(id!=null){
			msg = "S";
			}
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkProcessType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  ProcessTypeBean ag where ag.processtype='"
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
	public List<Object[]> searchProcessType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.processtypeid,e.processtype from ProcessTypeBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProcessTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.processtypeid,e.processtype from ProcessTypeBean e where e.processtypeid='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchProcessType(String label,String operator,String searchName){
		try {

			String hql = "select e.processtypeid,e.processtype from ProcessTypeBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteProcessType(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		ProcessTypeBean processBean  = null;
		try {
			processBean= (ProcessTypeBean) getHibernateTemplate().get(ProcessTypeBean.class, id);
			getHibernateTemplate().delete(processBean);
			msg = "S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public String updateProcessType(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			ProcessTypeBean processBean=(ProcessTypeBean) object;
			
			getHibernateTemplate().update(processBean);
			s = "Process Type  Details Updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectProcessType() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.processtypeid,e.processtype from ProcessTypeBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProcessType(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  ProcessTypeBean ag where ag.processtype='"
					+ type + "' and ag.processtypeid!='" + Id + "'";
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
