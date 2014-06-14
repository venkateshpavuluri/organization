package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.SalesOrganizationBean;
import com.mnt.erp.service.AuditLogService;

public class SalesOrganizationDaoImpl extends HibernateDaoSupport implements
		SalesOrganizationDao {
	@Autowired
	AuditLogService auditLogService;

	String Salesorgmessage;
	List<Object[]> list = null;
	Serializable id = null;

	@Override
	public String saveSalesOrg(Object object, String userId, String UserName) {
		try {
			SalesOrganizationBean sorgBean = (SalesOrganizationBean) object;
			id = getHibernateTemplate().save(sorgBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "SalesOrg", "ROW",
						String.valueOf(id), "1", modifiedDate, UserName);
			}

			Salesorgmessage = "S";
		} catch (Exception e) {
			Salesorgmessage = "F";
			e.printStackTrace();

		}
		return Salesorgmessage;
	}

	@Override
	public List<Object[]> searchSalesOrgWithId(int id) {
		try {
			String hql = "select so.salesorgId,so.salesorganization,so.orgId from SalesOrganizationBean so where so.salesorgId="
					+ id + "";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchSalesOrg() {
		try {
			String hql = "select so.salesorgId,so.salesorganization,so.org from SalesOrganizationBean so order by so.salesorganization";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectSalesOrg() {
		try {
			String hql = "select so.salesorgId,so.salesorganization,so.orgId from SalesOrganizationBean so ";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectOrg() {
		try {
			String hql = "select o.orgId,o.orgName from Organization o ";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateSalesOrg(Object object) {
		try {
			SalesOrganizationBean soBean = (SalesOrganizationBean) object;
			getHibernateTemplate().update(soBean);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	@Override
	public String deleteSalesOrg(int id) {
		try {
			SalesOrganizationBean methodBean = (SalesOrganizationBean) getHibernateTemplate()
					.get(SalesOrganizationBean.class, id);
			methodBean.setOrg(new Organization());
			// methodBean.setSalesorgId(id);
			getHibernateTemplate().delete(methodBean);
		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	@Override
	public Long getSalesOrgCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from SalesOrganizationBean i where i.salesorganization='"
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
	public Long getSalesOrgCountedit(String name, int imid) {
		Iterator<Object> iterator = null;
		Long im = 1L;
		try {
			String sql = "select count(*) from SalesOrganizationBean i where i.salesorganization='"
					+ name + "'and i.salesorgId !='" + imid + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				im = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return im;
	}

	@Override
	public List<Object[]> basicSearchSalesOrg(String label, String operator,
			String searchName) {
		try {

			String hql = "select so.salesorgId,so.salesorganization,so.org from SalesOrganizationBean so where so."
					+ label
					+ ""
					+ operator
					+ " ? order by so.salesorganization";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
