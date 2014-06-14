/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.StockCategory;
import com.mnt.erp.service.AuditLogService;

/**
 * @author pvenkateswarlu
 * @version 1.0 28-10-2013
 */
public class StockCategoryDaoImpl extends HibernateDaoSupport implements
		StockCategoryDao {
	@Autowired
	AuditLogService auditLogService;

	List<Object[]> list;
	String sql;

	@Override
	public String saveStockCategory(Object object, String userId,
			String userName) {
		// TODO Auto-generated method stub
		String vc = null;
		try {
			Serializable id = getHibernateTemplate().save(object);
			Date date = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);
			auditLogService.setAuditLogSave(userId, "A", "Stock Category",
					"ROW", String.valueOf(id), "1", modifiedDate, userName);
			vc = "S";
		} catch (Exception e) {
			vc = "F";
			e.printStackTrace();
		}

		return vc;
	}

	@Override
	public List<Object[]> searchStockCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.stockCategoryId,s.stockCategoryName from StockCategory s ORDER BY s.stockCategoryName";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Object[]> searchStockCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.stockCategoryId,s.stockCategoryName from StockCategory s where s.stockCategoryId="
					+ id + " ";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateStockCategory(Object object) {
		// TODO Auto-generated method stub
		String s = null;
		StockCategory stockCategory = null;
		try {
			stockCategory = (StockCategory) object;
			getHibernateTemplate().update(stockCategory);
			s = "S";
		} catch (Exception e) {
			s = "F";
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String deleteStockCategory(int id) {
		// TODO Auto-generated method stub
		String is = null;
		StockCategory stockCategory = null;
		try {
			stockCategory = new StockCategory();
			stockCategory.setStockCategoryId(id);
			getHibernateTemplate().delete(stockCategory);
			is = "S";
		} catch (Exception e) {
			is = "F";
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectStockCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.stockCategoryId,s.stockCategoryName from StockCategory s";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> basicSearchStockCategory(String label,
			String operator, String searchName) {
		try {

			String hql = "select s.stockCategoryId,s.stockCategoryName from StockCategory s where s."
					+ label + "" + operator + " ? ORDER BY s.stockCategoryName";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Long getStockCategoryDuplicateCount(String name) {
		// TODO Auto-generated method stub
		Iterator<Object> iterator = null;
		Long count = 0l;
		List<Object> list = null;
		try {
			sql = "select count(*) from StockCategory o where  o.stockCategoryName='"
					+ name + "'";
			list = getHibernateTemplate().find(sql);
			count = (Long) list.get(0);

			/*
			 * iterator = list.iterator();
			 * 
			 * while (iterator.hasNext()) { Object object = (Object)
			 * iterator.next(); i = (Long) object; }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public Long getStockCategoryCountedit(String name, int stockCategoryId) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  StockCategory s where s.stockCategoryName='"
					+ name
					+ "' and s.stockCategoryId!='"
					+ stockCategoryId
					+ "'";
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
