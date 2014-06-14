package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.DefectClassBean;


public class defectClassDaoImpl extends HibernateDaoSupport implements defectClassDao {
	List<Object[]> list=null;
	@Override
	public String saveDefectClass(Object object) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			getHibernateTemplate().save(object);
			msg = "Defect class details has been  saved Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkDefectClass(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  DefectClassBean ag where ag.defectClass='"
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
	public List searchDefectClass() {
		// TODO Auto-generated method stub
		List list = null;
		try {
			String q = "select e.defectClassId,e.defectClass from DefectClassBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchDefectClassWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.defectClassId,e.defectClass from DefectClassBean e where e.defectClassId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchDefectClass(String label,String operator,String searchName){
		try {

			String hql = "select e.defectClassId,e.defectClass from DefectClassBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteDefectClass(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		DefectClassBean dBean  = null;
		try {
			dBean= (DefectClassBean) getHibernateTemplate().get(DefectClassBean.class, id);
			getHibernateTemplate().delete(dBean);
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String updateDefectClass(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			DefectClassBean wBean=(DefectClassBean) object;
			
			getHibernateTemplate().update(wBean);
			s = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectDefectClass() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.defectClassId,e.defectClass from DefectClassBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckDefectClass(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  DefectClassBean ag where ag.defectClass='"
					+ type + "' and ag.defectClassId!='" + Id + "'";
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
