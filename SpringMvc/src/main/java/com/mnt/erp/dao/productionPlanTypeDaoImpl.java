package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.mnt.erp.bean.productionPlanTypeBean;

public class productionPlanTypeDaoImpl extends HibernateDaoSupport implements productionPlanTypeDao{
	List<Object[]> list=null;
	@Override
	public String saveProductionPlanType(Object object) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
		Serializable id=getHibernateTemplate().save(object);
		if(id!=null)
		{
			msg="S";
		}
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkProductionPlanType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  productionPlanTypeBean ag where ag.productionPlanType='"
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
	public List<Object[]> searchProductionPlanType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.productionPlanTypeId,e.productionPlanType from productionPlanTypeBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProductionPlanTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.productionPlanTypeId,e.productionPlanType from productionPlanTypeBean e where e.productionPlanTypeId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchProductionPlanType(String label,String operator,String searchName){
		try {

			String hql = "select e.productionPlanTypeId,e.productionPlanType from productionPlanTypeBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteProductionPlanType(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		productionPlanTypeBean pBean  = null;
		try {
			pBean= (productionPlanTypeBean) getHibernateTemplate().get(productionPlanTypeBean.class, id);
			getHibernateTemplate().delete(pBean);
			msg = "S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public String updateProductionPlanType(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			productionPlanTypeBean prBean=(productionPlanTypeBean) object;
			
			getHibernateTemplate().update(prBean);
			s = "S";
		} catch (Exception e) {
			s="F";
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectProductionPlanType() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.productionPlanTypeId,e.productionPlanType from productionPlanTypeBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProductionPlanType(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  productionPlanTypeBean ag where ag.productionPlanType='"
					+ type + "' and ag.productionPlanTypeId!='" + Id + "'";
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
