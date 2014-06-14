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

import com.mnt.erp.bean.OrderType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
public class OrderTypeDaoImpl extends HibernateDaoSupport implements
		OrderTypeDao {
	@Autowired
	AuditLogService auditLogService;

	String msg;
	List<Object[]> list = null;
	Serializable id = null;

	/*
	 * =============================Add
	 * Method===================================
	 */
	@Override
	public String addOrderType(Object object, String userId, String userName) {
		// TODO Auto-generated method stub
		try {

			OrderType order_type = (OrderType) object;
			id = getHibernateTemplate().save(order_type);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "orderType",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	/*
	 * =============================Search(All)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchOrderType() {
		// TODO Auto-generated method stub
		List<Object[]> objs = null;
		try {

			String searchQuery = "select ot.orderTypeId,ot.orderType from OrderType ot order by ot.orderType";
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
	public List<Object[]> searchOrderTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String searchQuery1 = "select ot.orderTypeId,ot.orderType from OrderType ot where ot.orderTypeId="
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
	public String updateOrderType(Object object) {
		// TODO Auto-generated method stub
		try {
			OrderType order_type = (OrderType) object;
			int id = order_type.getOrderTypeId();

			OrderType orderTypeValues = (OrderType) getHibernateTemplate().get(
					OrderType.class, id);
			orderTypeValues.setOrderTypeId(order_type.getOrderTypeId());
			orderTypeValues.setOrderType(order_type.getOrderType());

			getHibernateTemplate().update(order_type);

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
	public String deleteOrderType(int id) {
		// TODO Auto-generated method stub
		OrderType order_type = null;
		try {
			// order_type=(OrderType)getHibernateTemplate().get(OrderType.class,id);
			order_type = new OrderType();
			order_type.setOrderTypeId(id);
			getHibernateTemplate().delete(order_type);
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
	public int checkDuplicate(String checkOTType) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from OrderType ot where ot.orderType='"
					+ checkOTType + "'";
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
	public int checkEditDuplicate(String checkOTType, int id) {

		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from OrderType ot where ot.orderType='"
					+ checkOTType + "' and ot.orderTypeId!='" + id + "' ";
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
	public List<Object[]> basicSearchOrderType(String label, String operator,
			String searchName) {
		try {

			String hql = "select ot.orderTypeId,ot.orderType from OrderType ot where ot."
					+ label + "" + operator + " ? order by ot.orderType";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
