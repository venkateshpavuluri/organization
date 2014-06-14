/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ConditionBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author madhav
 * 
 */
public class ConditionDaoImpl extends HibernateDaoSupport implements
		ConditionDao {

	// Instance variables
	String success;
	List<Object[]> objects = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public List<Object[]> selectCondition() {
		try {
			String hql = "select c.conditionId,c.condition from ConditionBean c ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	// Duplication checking in Update mode
	@Override
	public Long updateCheckCondition(String condition, int conditonId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from ConditionBean c where  c.condition ='"
					+ condition + "' and c.conditionId!='" + conditonId + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	// Duplication checking in addMode
	@Override
	public Long addCheckConditionType(String condition) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from ConditionBean c where  c.condition='"
					+ condition + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	// Method for Adding
	@Override
	public String saveCondition(Object object, String userId, String userName) {

		try {
			ConditionBean conditonBean = (ConditionBean) object;
			id = getHibernateTemplate().save(conditonBean);

			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Condition",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "F";

		}
		return "S";
	}

	// Method for Searching
	@Override
	public List<Object[]> searchCondition() {

		try {
			String hql = "select q.conditionId,q.condition,q.conditionTypeChild from ConditionBean q order by q.condition";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	// Searching with Id
	@Override
	public List<Object[]> searchConditoinWithId(int id) {

		try {
			String hql = "select q.conditionId,q.condition,q.conditionTypeId from ConditionBean q where q.conditionId="

					+ id + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	// Method for Updating
	@Override
	public String updateCondition(Object object) {

		try {
			ConditionBean conditionBeanUpdate = (ConditionBean) object;
			getHibernateTemplate().update(conditionBeanUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	@Override
	public String deleteCodition(int id) {

		try {
			ConditionBean deleteCondition = null;
			deleteCondition = new ConditionBean();
			deleteCondition.setConditionId(id);
			getHibernateTemplate().delete(deleteCondition);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";

		}
		return "S";
	}

	@Override
	public List<Object[]> selectConditionType() {

		try {
			String hql = "select ct.conditionTypeId,ct.conditionType from ConditionType ct ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> basicSearchCondition(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.conditionId,q.condition,q.conditionTypeChild from ConditionBean q where q."
					+ label + "" + operator + " ? order by q.condition";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
