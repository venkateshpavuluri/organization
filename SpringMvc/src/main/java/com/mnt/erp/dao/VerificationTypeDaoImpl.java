package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.VerificationtypeBean;
import com.mnt.erp.service.AuditLogService;

public class VerificationTypeDaoImpl extends HibernateDaoSupport implements
		VerificationTypeDao {
	@Autowired
	AuditLogService auditLogService;
	String message = null;
	List<Object[]> list = null;

	@Override
	public String saveVerificationType(Object object, String userId,
			String userName) {
		try {
			VerificationtypeBean verificationtypeBean = (VerificationtypeBean) object;

			Serializable id = getHibernateTemplate().save(verificationtypeBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Verification Type", "ROW", String.valueOf(id), "1",
						modifiedDate, userName);
				message = "S";
			} else {
				message = "F";
			}
		} catch (Exception e) {
			message = "F";
			e.printStackTrace();

		}

		return message;

	}

	@Override
	public Long getVerificationTypeCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from VerificationtypeBean vb where vb.verificationtype='"
					+ name + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Object[]> searchVerificationType() {
		try {
			String hql = "select vb.verificationtypeid,vb.verificationtype from VerificationtypeBean vb vb.verificationtype";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectVerificationTypeIds() {
		try {
			String hql = "select vb.verificationtypeid,vb.verificationtype from VerificationtypeBean vb";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateVerificationType(Object object) {
		try {
			VerificationtypeBean vBean = (VerificationtypeBean) object;

			getHibernateTemplate().update(vBean);
			message = "S";

		} catch (Exception e) {
			message = "F";
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String deleteVerificationType(int id) {
		try {
			VerificationtypeBean vBean = (VerificationtypeBean) getHibernateTemplate()
					.get(VerificationtypeBean.class, id);
			getHibernateTemplate().delete(vBean);
			message = "S";
		} catch (Exception e) {
			message = "F";
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Long getVerificationTypeCountedit(String name, int verificationtypeid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from VerificationtypeBean vb where vb.verificationtype='"
					+ name
					+ "'and vb.verificationtypeid!='"
					+ verificationtypeid + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Object[]> basicSearchVerificationType(String label,
			String operator, String searchName) {
		try {

			String hql = "select vb.verificationtypeid,vb.verificationtype from VerificationtypeBean vb where vb."
					+ label + "" + operator + " ? ORDER BY vb.verificationtype";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchVerificationtypeWithId(int id) {
		try {
			String hql1 = "select vb.verificationtypeid,vb.verificationtype from VerificationtypeBean vb where vb.verificationtypeid="
					+ id + "";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
