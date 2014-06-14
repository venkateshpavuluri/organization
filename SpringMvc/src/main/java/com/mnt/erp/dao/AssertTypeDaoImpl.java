/*
 * @Copyright MNTSOFT
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
import com.mnt.erp.bean.AssertTypeBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Naresh
 * @version 1.0 18-09-2013
 */
public class AssertTypeDaoImpl extends HibernateDaoSupport implements
		AssertTypeDao {
	String success;
	List<Object[]> objects = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	public Long updateCheckAssetType(String assetType, int assetId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from AssertTypeBean at where  at.assertTypeName ='"
					+ assetType + "' and at.assertTypeId!='" + assetId + "'";
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

	public Long checkAssetTypeCout(String assetType) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from AssertTypeBean at where  at.assertTypeName='"
					+ assetType + "'";
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

	public String saveAssertTypeDetails(Object object, String userId,
			String userName) {
		try {
			AssertTypeBean asstBean = (AssertTypeBean) object;
			id = getHibernateTemplate().save(asstBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Plant", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> searchAssertType() {

		try {
			String hql = "select q.assertTypeId,q.assertTypeName from AssertTypeBean q order by q.assertTypeName";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchAssertTypeWithId(int id) {
		try {
			String hql = "select q.assertTypeId,q.assertTypeName from AssertTypeBean q where q.assertTypeId="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateAssertType(Object object) {
		try {
			AssertTypeBean updateAssrt = (AssertTypeBean) object;
			getHibernateTemplate().update(updateAssrt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	public String deleteAssertType(int id) {

		try {
			AssertTypeBean deleteAssert = getHibernateTemplate().get(
					AssertTypeBean.class, id);
			getHibernateTemplate().delete(deleteAssert);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> selectAssetType() {
		String sql = null;
		try {
			sql = "select atb.assertTypeId, atb.assertTypeName from  AssertTypeBean atb";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchAssertType(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.assertTypeId,q.assertTypeName from AssertTypeBean q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

}
