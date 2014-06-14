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

import com.mnt.erp.bean.ConditionType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author madhav
 * 
 */
public class ConditionTypeDaoImpl extends HibernateDaoSupport implements
		ConditionTypeDao {

	// Member variables
	String success;
	List<Object[]> objects = null;

	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	// Method for Checking duplicates in Update Form
	@Override
	public Long updateCheckConditionType(String conditionType,
			int conditionTypeId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from ConditionType ct where  ct.conditionType ='"
					+ conditionType
					+ "' and ct.conditionTypeId!='"
					+ conditionTypeId + "'";
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

	@Override
	public Long addCheckConditionType(String conditionType) {
		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from ConditionType ct where  ct.conditionType='"
					+ conditionType + "'";
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

	// Method add implementation for Adding Condition Type
	@Override
	public String saveConditionType(Object object, String userId,
			String userName) {

		try {
			ConditionType ctBean = (ConditionType) object;
			id = getHibernateTemplate().save(ctBean);

			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "conditionType",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "F";

		}
		return "S";

	}

	// Condition Type for Searching
	@Override
	public List<Object[]> searchConditionType() {
		try {
			String hql = "select q.conditionTypeId,q.conditionType from ConditionType q order by q.conditionType";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	// Searching With Id
	@Override
	public List<Object[]> searchConditionTypeWithId(int id) {
		try {
			String hql = "select q.conditionTypeId,q.conditionType from ConditionType q where q.conditionTypeId="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	// Method for Updating Condition Type
	@Override
	public String updateConditionType(Object object) {
		try {
			ConditionType updatect = (ConditionType) object;
			getHibernateTemplate().update(updatect);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	// Method for Deleting Record
	@Override
	public String deleteConditionType(int id) {
		try {
			ConditionType deleteCT = null;
			deleteCT = new ConditionType();
			deleteCT.setConditionTypeId(id);
			getHibernateTemplate().delete(deleteCT);
			return "S";
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

	}

	// Basic Search for Condition Type
	@Override
	public List<Object[]> basicSearchConditionType(String label,
			String operator, String searchName) {
		try {

			String hql = "select q.conditionTypeId,q.conditionType from ConditionType q where q."
					+ label + "" + operator + " ? order by q.conditionType";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
