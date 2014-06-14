package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.mnt.erp.bean.workIncedenceBean;

public class workIncedenceDaoImpl extends HibernateDaoSupport implements workIncedenceDao{
	List<Object[]> list = null;
	@Override
	public String saveWorkIncedence(Object object) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			getHibernateTemplate().save(object);
			msg = "Work Incedence details has been  saved Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkWorkIncedence(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  workIncedenceBean ag where ag.workIncedence='"
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
	public List<Object[]> searchWorkIncedence() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.workIncedenceId,e.workIncedence from workIncedenceBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchWorkIncedenceWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.workIncedenceId,e.workIncedence from workIncedenceBean e where e.workIncedenceId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchWorkIncedence(String label,String operator,String searchName){
		try {

			String hql = "select e.workIncedenceId,e.workIncedence from workIncedenceBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteWorkIncedence(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		workIncedenceBean workBean  = null;
		try {
			workBean= (workIncedenceBean) getHibernateTemplate().get(workIncedenceBean.class, id);
			getHibernateTemplate().delete(workBean);
			msg = "S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public String updateWorkIncedence(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			workIncedenceBean wBean=(workIncedenceBean) object;
			
			getHibernateTemplate().update(wBean);
			s = "Work Incedence  Details Updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectWorkIncedence() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.workIncedenceId,e.workIncedence from workIncedenceBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckWorkIncedence(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  workIncedenceBean ag where ag.workIncedence='"
					+ type + "' and ag.workIncedenceId!='" + Id + "'";
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
