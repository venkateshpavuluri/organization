package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.mnt.erp.bean.ProductionOrderType;

public class prodOrderTypeDaoImpl extends HibernateDaoSupport implements prodOrderTypeDao{

	List<Object[]> list = null;
	@Override
	public String saveProdOrderType(Object object) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			getHibernateTemplate().save(object);
			msg = "Production order details has been  saved Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkProdOrderType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  ProductionOrderType ag where ag.prodOrderType='"
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
	public List<Object[]> searchProdOrderType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.prodOrderTypeId,e.prodOrderType from ProductionOrderType e order by e.prodOrderType";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchProdOrderTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.prodOrderTypeId,e.prodOrderType from ProductionOrderType e where e.prodOrderTypeId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchProdOrderType(String label,String operator,String searchName){
		try {

			String hql = "select e.prodOrderTypeId,e.prodOrderType from ProductionOrderType e where e."
					+ label + "" + operator + " ? order by e.prodOrderType";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteProdOrderType(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		ProductionOrderType prodOrderBean  = null;
		try {
			prodOrderBean= (ProductionOrderType) getHibernateTemplate().get(ProductionOrderType.class, id);
			getHibernateTemplate().delete(prodOrderBean);
			msg = "S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	public String updateProdOrderType(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			ProductionOrderType prodOrderBean=(ProductionOrderType) object;
			
			getHibernateTemplate().update(prodOrderBean);
			s = "Production Order Details Updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectProdOrderType() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.prodOrderTypeId,e.prodOrderType from ProductionOrderType e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProdOrderType(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  ProductionOrderType ag where ag.prodOrderType='"
					+ type + "' and ag.prodOrderTypeId!='" + Id + "'";
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
