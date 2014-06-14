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
import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesOffice;
import com.mnt.erp.service.AuditLogService;

public class SalesGroupDaoImpl extends HibernateDaoSupport implements
		SalesGroupDao {

	String msg;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	public String saveSalesGroup(Object object, String userId, String userName) {
		try {
			SalesGroup dt = (SalesGroup) object;
			id = getHibernateTemplate().save(dt);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Sales Group",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	public List<Object[]> searchSalesGroup() {
		List<Object[]> objects = null;
		try {
			String hql = "select s.salesGroup_Id,s.salesGroup,s.soffice from SalesGroup s order by s.salesGroup";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> editSalesGroupWithId(int id) {
		List<Object[]> objects = null;
		try {
			String hql = "select salesGroup_Id,salesOfficeId,salesGroup from SalesGroup where salesGroup_Id="
					+ id + "";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateSalesGroup(Object object) {
		try {
			SalesGroup salesGroup = (SalesGroup) object;
			int id = salesGroup.getSalesGroup_IdEdit();

			SalesGroup sgtype = (SalesGroup) getHibernateTemplate().get(
					SalesGroup.class, id);
			sgtype.setSalesGroup_Id(salesGroup.getSalesGroup_IdEdit());
			sgtype.setSalesOfficeId(salesGroup.getSalesOfficeIdEdit());
			sgtype.setSalesGroup(salesGroup.getSalesGroupEdit());
			getHibernateTemplate().update(sgtype);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

		return "S";
	}

	public String salesGroupDelete(int id) {

		try {
			SalesGroup dt = (SalesGroup) getHibernateTemplate().get(
					SalesGroup.class, id);

			dt.setSoffice(new SalesOffice());
			getHibernateTemplate().delete(dt);
			return "S";
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}

	}

	public int salesGroupDuplicate(String salesGroup) {
		Long count = null;
		try {
			final String hql = "select count(*) from SalesGroup d where d.salesGroup='"
					+ salesGroup + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
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

	public int salesGroupEditDuplicate(String salesGroup, int id) {

		Long count = null;
		try {
			final String hql = "select count(*) from SalesGroup d where d.salesGroup='"
					+ salesGroup + "' and d.salesGroup_Id!='" + id + "'";

			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
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

	public List<Object[]> basicSearchSalesGroup(String label, String operator,
			String searchName) {
		List<Object[]> objects = null;
		try {

			String hql = "select s.salesGroup_Id,s.salesGroup,s.soffice from SalesGroup s where s."
					+ label + "" + operator + " ? order by s.salesGroup";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> salesOfficeIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String hql = "select s.salesOfficeId,s.salesOffice from SalesOffice s";

		list = getHibernateTemplate().find(hql);
		return list;
	}

}
