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
import com.mnt.erp.bean.CustomerGroup;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
public class CustomerGroupDaoImpl extends HibernateDaoSupport implements
		CustomerGroupDao {
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
	public String addCustomerGroup(Object object, String userId, String userName) {
		// TODO Auto-generated method stub
		try {

			CustomerGroup cust_group = (CustomerGroup) object;
			id = getHibernateTemplate().save(cust_group);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "custGroup",
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
	public List<Object[]> searchCustomerGroup() {
		// TODO Auto-generated method stub
		List<Object[]> objs = null;
		try {

			String searchQuery = "select cg.custGroupId,cg.custGroup from CustomerGroup cg order by cg.custGroup";
			objs = getHibernateTemplate().find(searchQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	/*
	 * =============================Search (WithId)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchCustomerGroupWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {

			String searchQuery1 = "select cg.custGroupId,cg.custGroup from CustomerGroup cg where cg.custGroupId="
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
	public String updateCustomerGroup(Object object) {
		// TODO Auto-generated method stub
		try {
			CustomerGroup cust_group = (CustomerGroup) object;
			int id = cust_group.getCustGroupId();

			CustomerGroup custGroupValues = (CustomerGroup) getHibernateTemplate()
					.get(CustomerGroup.class, id);
			custGroupValues.setCustGroupId(cust_group.getCustGroupId());
			custGroupValues.setCustGroup(cust_group.getCustGroup());

			getHibernateTemplate().update(cust_group);

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
	public String customerGroupDelete(int id) {
		// TODO Auto-generated method stub
		CustomerGroup cust_group = null;
		try {
			// cust_group=(CustomerGroup)getHibernateTemplate().get(CustomerGroup.class,id);
			cust_group = new CustomerGroup();
			cust_group.setCustGroupId(id);
			getHibernateTemplate().delete(cust_group);
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
	public int checkDuplicate(String checkCustGroup) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from CustomerGroup cg where cg.custGroup='"
					+ checkCustGroup + "'";
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
	public int checkEditDuplicate(String checkCustGroup, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from CustomerGroup cg where cg.custGroup='"
					+ checkCustGroup + "' and cg.custGroupId!='" + id + "'  ";

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
	public List<Object[]> basicSearchCustomerGroup(String label,
			String operator, String searchName) {
		try {

			String hql = "select cg.custGroupId,cg.custGroup from CustomerGroup cg where cg."
					+ label + "" + operator + " ? order by cg.custGroup";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
