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

import com.mnt.erp.bean.ValuationCategory;
import com.mnt.erp.service.AuditLogService;

public class ValuationCategoryDaoImpl extends HibernateDaoSupport implements
		ValuationCategoryDao {
	@Autowired
	AuditLogService auditLogService;
	
	String msg=null;
	List<Object[]> list = null;
	@Override
	public String saveValuationCategoryDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
	
		try {
			Serializable id=getHibernateTemplate().save(object);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Valuatiion Category",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public List<Object[]> searchValuationCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select v.valuationCategoryId,v.valuationCategory from ValuationCategory v order by v.valuationCategory";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchValuationCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select v.valuationCategoryId,v.valuationCategory from ValuationCategory v where v.valuationCategoryId="
					+ id + "";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateValuationCategory(Object object) {
		// TODO Auto-generated method stub
		String s = "updateSuccess";

		try {
			ValuationCategory valuationCategory = (ValuationCategory) object;
			getHibernateTemplate().update(valuationCategory);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteValuationCategory(int id) {
		// TODO Auto-generated method stub
	
		ValuationCategory valuationCategory = null;
		try {
			valuationCategory = (ValuationCategory) getHibernateTemplate().get(
					ValuationCategory.class, id);
			getHibernateTemplate().delete(valuationCategory);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> selectValuationCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select v.valuationCategoryId,v.valuationCategory from ValuationCategory v";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkValuationCategory(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  ValuationCategory ag where ag.valuationCategory='"
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
		return count.intValue();
	}

	public int updateCheckValuationCategory(String value, int valueId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  ValuationCategory ag where ag.valuationCategory='"
					+ value + "' and ag.valuationCategoryId!='" + valueId + "'";
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
		return count.intValue();
	}

	@Override
	public List<Object[]> basicSearchValuationCategory(String label,
			String operator, String searchName) {
		try {

			String hql = "select v.valuationCategoryId,v.valuationCategory from ValuationCategory v where v."
					+ label + "" + operator + " ? order by v.valuationCategory";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
