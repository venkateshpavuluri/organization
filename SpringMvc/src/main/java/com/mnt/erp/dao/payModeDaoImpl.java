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

import com.mnt.erp.bean.PayModeBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class payModeDaoImpl extends HibernateDaoSupport implements payModeDao{
	String success;
	List<Object[]> objects = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	public Long updateCheckPayMode(String payMode, int payModeId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from PayModeBean at where  at.payMode ='"
					+ payMode + "' and at.payMode_Id!='" + payModeId + "'";
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

	public Long checkPayModeCount(String paymode) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from PayModeBean at where  at.payMode='"
					+ paymode + "'";
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

	public String savePayModeDetails(Object object, String userId,
			String userName) {
		try {
			PayModeBean payBean = (PayModeBean) object;
			id = getHibernateTemplate().save(payBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "PayMode", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> searchPayMode() {

		try {
			String hql = "select q.payMode_Id,q.payMode from PayModeBean q order by q.payMode";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchPayModeWithId(int id) {
		try {
			String hql = "select q.payMode_Id,q.payMode from PayModeBean q where q.payMode_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updatePayMode(Object object) {
		try {
			PayModeBean updatepay = (PayModeBean) object;
			getHibernateTemplate().update(updatepay);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	public String deletePayMode(int id) {

		try {
			PayModeBean deletepay = getHibernateTemplate().get(
					PayModeBean.class, id);
			getHibernateTemplate().delete(deletepay);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> selectPayMode() {
		String sql = null;
		try {
			sql = "select atb.payMode_Id, atb.payMode from  PayModeBean atb";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchPayMode(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.payMode_Id,q.payMode from PayModeBean q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

}
