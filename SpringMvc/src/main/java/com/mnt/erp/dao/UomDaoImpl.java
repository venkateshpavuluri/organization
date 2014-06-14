/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;

/**
 * This is Uom Dao Implementation.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class UomDaoImpl extends HibernateDaoSupport implements UomDao {
	@Autowired
	AuditLogService auditLogService;

	String msg;
	List<Object[]> list = null;

	public List<Object[]> selectUomDetails() {

		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select u.uom_Id,u.uom,u.uomCode from Uom u";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String saveUomDetails(Object object, String userId, String userName) {
		try {
			Uom uom = (Uom) object;
			Serializable id = getHibernateTemplate().save(uom);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "UOM", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	public List<Object[]> searchUom(int id) {
		List<Object[]> objects = null;
		try {
			String hql = "select u.uom_Id,u.uom,u.uomCode from Uom u order by u.uom";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> editUomWithId(int id) {
		List<Object[]> objects = null;
		try {
			String hql = "select u.uom_Id,u.uom,u.uomCode from Uom u where u.uom_Id="
					+ id + "";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public String updateUom(Object object) {

		try {
			Uom uom = (Uom) object;
			int id = uom.getEditUom_id();
			Uom uomlist = (Uom) getHibernateTemplate().get(Uom.class, id);
			uomlist.setUom_Id(uom.getEditUom_id());
			uomlist.setUom(uom.getEditUom());
			uomlist.setUomCode(uom.getEditUomCode());
			getHibernateTemplate().update(uomlist);
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;

	}

	public String uomDelete(int id) {
		Uom uom = null;
		try {
			uom = (Uom) getHibernateTemplate().get(Uom.class, id);

			getHibernateTemplate().delete(uom);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;

	}

	@Override
	public int uomDuplicate(String uomCheck, String uomCodeCheck) {
		Long count = null;
		try {
			final String hql = "select count(*) from Uom u where u.uom='"
					+ uomCheck + "' or u.uomCode='" + uomCodeCheck + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {

							org.hibernate.Query query = session
									.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}

					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	public int uomEditDuplicate(String uom, String uomCode, int id) {

		Long count = null;
		try {

			final String hql = "select count(*) from Uom u where u.uom='" + uom
					+ "' and u.uomCode='" + uomCode + "' and u.uom_Id!='" + id
					+ "'";

			System.out.println("the query is:" + hql);
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {

							org.hibernate.Query query = session
									.createQuery(hql);
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
	public List<Object[]> uomIdGet() {

		String hql = "select u.uom_Id,u.uom from Uom u";
		List<Object[]> listValues = getHibernateTemplate().find(hql);

		return listValues;
	}

	@Override
	public List<Object[]> basicSearchUOM(String label, String operator,
			String searchName) {
		try {

			String hql = "select u.uom_Id,u.uom,u.uomCode from Uom u where u."
					+ label + "" + operator + " ? order by u.uom";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
