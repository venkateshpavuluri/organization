/**
@Copyright MNTSOFT
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
import com.mnt.erp.bean.WorkCenterCategory;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0 28-10-2013
 * @build 0.0
 * 
 * 
 */
public class WorkCenterCategoryDaoImpl extends HibernateDaoSupport implements
		WorkCenterCategoryDao {
	
	@Autowired
	AuditLogService auditLogService;
	String msg;

	/*
	 * =============================Add
	 * Method===================================
	 */

	@Override
	public String addWorkCenterCategory(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try {

			WorkCenterCategory wcCategory = (WorkCenterCategory) object;
			Serializable id=getHibernateTemplate().save(wcCategory);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Work Center Category",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;

	}

	/*
	 * =============================Search
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchWorkCenterCategory() {
		// TODO Auto-generated method stub
		List<Object[]> objs = null;
		try {

			String searchQuery = "select wcc.workCenterCategoryId,wcc.workCenterCategory from WorkCenterCategory wcc";
			objs = getHibernateTemplate().find(searchQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	/*
	 * =============================Search(With Id)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchWorkCenterCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String searchQuery1 = "select wcc.workCenterCategoryId,wcc.workCenterCategory from WorkCenterCategory wcc where wcc.workCenterCategoryId="
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
	public String updateWorkCenterCategory(Object object) {
		// TODO Auto-generated method stub
		try {
			WorkCenterCategory wccCategory = (WorkCenterCategory) object;
			int id = wccCategory.getWorkCenterCategoryId();

			WorkCenterCategory wccCategoryValues = (WorkCenterCategory) getHibernateTemplate()
					.get(WorkCenterCategory.class, id);
			wccCategoryValues.setWorkCenterCategoryId(wccCategory
					.getWorkCenterCategoryId());
			wccCategoryValues.setWorkCenterCategory(wccCategory
					.getWorkCenterCategory());

			getHibernateTemplate().update(wccCategory);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}

		return msg;
	}

	/*
	 * =============================Delete
	 * Method===================================
	 */
	@Override
	public String deleteWorkCenterCategory(int id) {
		// TODO Auto-generated method stub
		WorkCenterCategory wccCategory = null;
		try {
			wccCategory = (WorkCenterCategory) getHibernateTemplate().get(
					WorkCenterCategory.class, id);
			getHibernateTemplate().delete(wccCategory);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =============================Add Duplicate Checking
	 * Method===================================
	 */
	@Override
	public int checkDuplicate(String checkWorkCenterCategory) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from WorkCenterCategory wcc where wcc.workCenterCategory='"
					+ checkWorkCenterCategory + "'";
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
	public int checkEditDuplicate(String checkWorkCenterCategory, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from WorkCenterCategory wcc where wcc.workCenterCategory='"
					+ checkWorkCenterCategory
					+ "' and wcc.workCenterCategoryId!='" + id + "' ";

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
	 * =============================Basic Search
	 * Method===================================
	 */
	@Override
	public List<Object[]> basicSearchWCC(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String hql = "select wcc.workCenterCategoryId,wcc.workCenterCategory from WorkCenterCategory wcc where wcc."
					+ label + "" + operator + " ?  ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> WorkCeterCategoryIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {

			String hql = "select w.workCenterCategoryId,w.workCenterCategory from WorkCenterCategory w";

			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
