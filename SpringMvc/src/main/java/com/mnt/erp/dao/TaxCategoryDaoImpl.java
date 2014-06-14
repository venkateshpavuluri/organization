/**

 *
 */
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

import com.mnt.erp.bean.TaxCategory;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
public class TaxCategoryDaoImpl extends HibernateDaoSupport implements
		TaxCategoryDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	String msg = null;

	/*
	 * =============================TaxCategory Select
	 * Method===================================
	 */
	@Override
	public List<Object[]> selectTaxCtegory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String sql = "select t.taxCategoryId,t.taxCategory,t.taxCategoryCode from TaxCategory t";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * =============================Add
	 * Method===================================
	 */
	@Override
	public String addTaxCategory(Object object, String userId, String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			TaxCategory taxCat = (TaxCategory) object;
			Serializable id = getHibernateTemplate().save(taxCat);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Tax Category",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =============================Search(All)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchTaxCategory() {
		// TODO Auto-generated method stub
		List<Object[]> objs = null;
		String searchQuery = null;
		try {

			searchQuery = "select tc.taxCategoryId,tc.taxCategory,tc.taxCategoryCode from TaxCategory tc order by tc.taxCategory";
			objs = getHibernateTemplate().find(searchQuery);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			searchQuery = null;
		}
		return objs;
	}

	/*
	 * =============================Search(With Id)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchTaxCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String searchQuery1 = "select tc.taxCategoryId,tc.taxCategory,tc.taxCategoryCode from TaxCategory tc where tc.taxCategoryId="
					+ id + "";
			objects = getHibernateTemplate().find(searchQuery1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	/*
	 * =============================Update
	 * Method===================================
	 */
	@Override
	public String updateTaxCategory(Object object) {
		// TODO Auto-generated method stub
		try {
			TaxCategory taxCat = (TaxCategory) object;
			int id = taxCat.getTaxCategoryId();
			TaxCategory taxcategory = (TaxCategory) getHibernateTemplate().get(
					TaxCategory.class, id);
			taxcategory.setTaxCategoryId(taxCat.getTaxCategoryId());
			taxcategory.setTaxCategory(taxCat.getTaxCategory());
			taxcategory.setTaxCategoryCode(taxCat.getTaxCategoryCode());
			getHibernateTemplate().update(taxcategory);
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =============================Delete
	 * Method===================================
	 */
	@Override
	public String deleteTaxCategory(int id) {
		// TODO Auto-generated method stub
		TaxCategory taxCat = null;
		try {
			taxCat = (TaxCategory) getHibernateTemplate().get(
					TaxCategory.class, id);
			getHibernateTemplate().delete(taxCat);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =============================Add Duplicate Checking
	 * Method===================================
	 */
	@Override
	public int checkDuplicate(String checkTCType, String checkTCTypeCode) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from TaxCategory tc where tc.taxCategory='"
					+ checkTCType
					+ "'or tc.taxCategoryCode='"
					+ checkTCTypeCode + "'";
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

	/*
	 * =============================Edit Duplicate Checking
	 * Method===================================
	 */
	@Override
	public int checkEditDuplicate(String checkTCType, String checkTCTypeCode,
			int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from TaxCategory tc where tc.taxCategory='"
					+ checkTCType
					+ "' or tc.taxCategoryCode='"
					+ checkTCTypeCode + "' and tc.taxCategoryId!='" + id + "'";
			

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
		System.out.println("the count is:" + count.intValue());
		return count.intValue();
	}

	@Override
	public List<Object[]> basicSearchTaxCategory(String label, String operator,
			String searchName) {
		try {

			String hql = "select tc.taxCategoryId,tc.taxCategory,tc.taxCategoryCode from TaxCategory tc where tc."
					+ label + "" + operator + " ? order by tc.taxCategory";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
