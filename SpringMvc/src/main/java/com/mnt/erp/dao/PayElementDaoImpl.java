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


import com.mnt.erp.bean.PayElementBean;
import com.mnt.erp.service.AuditLogService;

public class PayElementDaoImpl extends HibernateDaoSupport implements PayElementDao 
{
	List<Object[]> list = null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id=null;
	@Override
	public String savePayElement(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			id=getHibernateTemplate().save(object);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","payElement","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkPayElement(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  PayElementBean ag where ag.payelement='"
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
	@Override
	public List<Object[]> searchPayElement() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.payelementId,e.payelement,e.payelementType from PayElementBean e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchPayElementWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.payelementId,e.payelement,e.payelementType from PayElementBean e where e.payelementId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchPayElement(String label,String operator,String searchName){
		try {

			String hql = "select e.payelementId,e.payelement,e.payelementType from PayElementBean e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String deletePayElement(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		PayElementBean payelement  = null;
		try {
			payelement= (PayElementBean) getHibernateTemplate().get(PayElementBean.class, id);
			getHibernateTemplate().delete(payelement);
			msg = "Payelement Details Deleted Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String updatePayElement(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			PayElementBean payelement=(PayElementBean) object;
			
			getHibernateTemplate().update(payelement);
			s = "updateSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectPayElement() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.payelementId,e.payelement,e.payelementType from PayElementBean e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckPayElement(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  PayElementBean ag where ag.payelement='"
					+ type + "' and ag.payelementId!='" + Id + "'";
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
