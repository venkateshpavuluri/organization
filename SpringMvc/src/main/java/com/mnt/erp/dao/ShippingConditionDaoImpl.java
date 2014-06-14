/*
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.ShippingConditionBean;
import com.mnt.erp.service.AuditLogService;

/*
 * @author Naresh
 * @version 1.0 19-09-2013
 */
public class ShippingConditionDaoImpl extends HibernateDaoSupport implements
		ShippingConditionDao {

	List<Object[]> objects = null;
	List<Object> list = null;
	Iterator<Object> itr = null;
	String success = null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id = null;

	public int updateCheckScCount(String scName, int scId) {
		Long l = 0l;
		try {
			String sql = "select count(*) from ShippingConditionBean sc where  sc.shippingCondition ='"
					+ scName + "' and sc.shippingConditionId!='" + scId + "'";
			list = getHibernateTemplate().find(sql);
			itr = list.iterator();

			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				l = (Long) object;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.intValue();

	}

	public Long checkShippingCndCount(String scName) {

		Long l = 0l;
		try {
			String sql = "select count(*) from ShippingConditionBean sc where  sc.shippingCondition='"
					+ scName + "'";
			list = getHibernateTemplate().find(sql);
			itr = list.iterator();

			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public String saveShippingCondition(Object object, String userId,
			String userName) {

		try {
			ShippingConditionBean shipBean = (ShippingConditionBean) object;
			id = getHibernateTemplate().save(shipBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "ship", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchShippingCondition() {
		try {
			String hql = "select s.shippingConditionId,s.shippingCondition from ShippingConditionBean s order by s.shippingCondition";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchShippingConditionWithId(int id) {

		try {
			String hql = "select s.shippingConditionId,s.shippingCondition from ShippingConditionBean s where s.shippingConditionId="
					+ id + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	@Override
	public String updateShippingCondition(Object object) {
		try {
			ShippingConditionBean updateShipping = (ShippingConditionBean) object;
			getHibernateTemplate().update(updateShipping);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	@Override
	public String deleteShippingCondition(int id) {
		try {
			ShippingConditionBean deleteShipCnd = getHibernateTemplate().get(
					ShippingConditionBean.class, id);
			getHibernateTemplate().delete(deleteShipCnd);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectShippingCondition() {
		try {
			String hql = "select s.shippingConditionId,s.shippingCondition from ShippingConditionBean s";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicShipCnd(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.shippingConditionId,s.shippingCondition from ShippingConditionBean s where s."
					+ label + "" + operator + " ? order by s.shippingCondition";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
