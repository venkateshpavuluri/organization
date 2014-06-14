/**
@copyright MNTSOFT
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

import com.mnt.erp.bean.SalesAreaBean;
import com.mnt.erp.bean.SalesOffice;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0 31-10-2013
 * @build 0.0
 * 
 */
public class SalesOfficeDaoImpl extends HibernateDaoSupport implements
		SalesOfficeDao {
	String msg;
	@Autowired
	AuditLogService auditLogService;

	/*
	 * =============================Add
	 * Method===================================
	 */

	@Override
	public String addSalesOffice(Object object, String userId, String userName) {
		// TODO Auto-generated method stub
		try {
			Serializable id = null;
			SalesOffice so = (SalesOffice) object;
			id = getHibernateTemplate().save(so);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "salesOffice",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
			msg="F";
		}
		return msg;

	}

	/*
	 * =============================Search
	 * Method===================================
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchSalesOffice() {
		// TODO Auto-generated method stub
		List<Object[]> objs = null;
		try {

			String searchQuery = "select so.salesOfficeId,so.salesOffice,so.saBean from SalesOffice so order by so.salesOffice";
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchSalesOfficeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String searchQuery1 = "select so.salesOfficeId,so.salesOffice,so.salesAreaId from SalesOffice so where so.salesOfficeId="
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
	public String updateSalesOffice(Object object) {
		// TODO Auto-generated method stub
		try {
			SalesOffice so = (SalesOffice) object;
			int id = so.getSalesOfficeId();

			SalesOffice sOValues = (SalesOffice) getHibernateTemplate().get(
					SalesOffice.class, id);
			sOValues.setSalesAreaId(sOValues.getSalesAreaIdEditt());
			sOValues.setSalesOffice(sOValues.getSalesOfficeEditt());

			getHibernateTemplate().update(so);

		} catch (Exception e) {
			e.printStackTrace();

			return "F";
		}

		return "S";
	}

	/*
	 * =============================Delete
	 * Method===================================
	 */
	@Override
	public String deleteSalesOffice(int id) {
		// TODO Auto-generated method stub

		try {
			SalesOffice so = getHibernateTemplate().get(SalesOffice.class, id);
			so.setSaBean(new SalesAreaBean());
			getHibernateTemplate().delete(so);
			return "S";
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

	}

	/*
	 * =============================Add Duplicate Checking
	 * Method===================================
	 */
	@Override
	public int checkDuplicate(String checkSalesOffice) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from SalesOffice so where so.salesOffice='"
					+ checkSalesOffice + "'";
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
	public int checkEditDuplicate(String checkSalesOffice, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from SalesOffice so where so.salesOffice='"
					+ checkSalesOffice
					+ "' and so.salesOfficeId!='"
					+ id
					+ "' ";

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
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> basicSearchSales(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String hql = "select so.salesOfficeId,so.salesOffice,so.saBean from SalesOffice so where so."
					+ label + "" + operator + " ?  order by so.salesOffice";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
}
