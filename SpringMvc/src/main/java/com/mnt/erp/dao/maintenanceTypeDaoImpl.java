package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.maintenanceTypeBean;

public class maintenanceTypeDaoImpl extends HibernateDaoSupport implements maintenanceTypeDao {
	List<Object[]> list = null;
	@Override
	public String saveMaintenanceType(Object object) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			Serializable id=getHibernateTemplate().save(object);
			if(id!=null){
				msg="S";
			}
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkMaintenanceType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  maintenanceTypeBean ag where ag.maintenanceType='"
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
	public List<Object[]> searchMaintenanceType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.maintenanceTypeId,e.maintenanceType from maintenanceTypeBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchMaintenanceTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.maintenanceTypeId,e.maintenanceType from maintenanceTypeBean e where e.maintenanceTypeId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchMaintenanceType(String label,String operator,String searchName){
		try {

			String hql = "select e.maintenanceTypeId,e.maintenanceType from maintenanceTypeBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteMaintenanceType(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		maintenanceTypeBean mainBean  = null;
		try {
			mainBean= (maintenanceTypeBean) getHibernateTemplate().get(maintenanceTypeBean.class, id);
			getHibernateTemplate().delete(mainBean);
			msg = "S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public String updateMaintenanceType(Object object) {
		// TODO Auto-generated method stub
		String msg = null;

		try {
			maintenanceTypeBean mBean=(maintenanceTypeBean) object;
			getHibernateTemplate().update(mBean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectMaintenanceType() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.maintenanceTypeId,e.maintenanceType from maintenanceTypeBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckMaintenanceType(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  maintenanceTypeBean ag where ag.maintenanceType='"
					+ type + "' and ag.maintenanceTypeId!='" + Id + "'";
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
