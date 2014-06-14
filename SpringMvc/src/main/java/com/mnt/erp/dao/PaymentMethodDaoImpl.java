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

import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
public class PaymentMethodDaoImpl extends HibernateDaoSupport implements
		PaymentMethodDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	String msg;

	/*
	 * =============================Add
	 * Method===================================
	 */
	@Override
	public String addPaymentMethods(Object object, String userId,
			String userName) {
		// TODO Auto-generated method stub
		try {

			PaymentMethod payment_Method = (PaymentMethod) object;
			Serializable id = getHibernateTemplate().save(payment_Method);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Payment Method",
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
	public List<Object[]> searchPaymentMethods() {
		// TODO Auto-generated method stub

		List<Object[]> objs = null;
		try {

			String searchQuery = "select pm.paymentMethodId,pm.paymentMethodName from PaymentMethod pm order by pm.paymentMethodName";
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
	public List<Object[]> searchPaymentMethodsWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String searchQuery1 = "select pm.paymentMethodId,pm.paymentMethodName from PaymentMethod pm where pm.paymentMethodId="
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
	public String updatePaymentMethods(Object object) {
		// TODO Auto-generated method stub
		try {
			PaymentMethod payment_Method = (PaymentMethod) object;
			int id = payment_Method.getPaymentMethodId();

			PaymentMethod paymentMethodValues = (PaymentMethod) getHibernateTemplate()
					.get(PaymentMethod.class, id);
			paymentMethodValues.setPaymentMethodId(payment_Method
					.getPaymentMethodId());
			paymentMethodValues.setPaymentMethodName(payment_Method
					.getPaymentMethodName());

			getHibernateTemplate().update(payment_Method);
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
	public String deletePaymentMethods(int id) {
		// TODO Auto-generated method stub
		PaymentMethod payment_Method = null;
		try {
			payment_Method = (PaymentMethod) getHibernateTemplate().get(
					PaymentMethod.class, id);
			getHibernateTemplate().delete(payment_Method);
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
	public int checkDuplicate(String checkPMethodName) {
		// TODO Auto-generated method stub

		Long count = null;
		try {
			final String hql = "select count(*) from PaymentMethod pm where pm.paymentMethodName='"
					+ checkPMethodName + "'";
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
	public int checkEditDuplicate(String checkPMethodName, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from PaymentMethod pm where pm.paymentMethodName='"
					+ checkPMethodName
					+ "' and pm.paymentMethodId!='"
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

	@Override
	public List<Object[]> basicSearchPaymentMethod(String label,
			String operator, String searchName) {
		try {

			String hql = "select pm.paymentMethodId,pm.paymentMethodName from PaymentMethod pm where pm."
					+ label + "" + operator + " ? order by pm.paymentMethodName";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
