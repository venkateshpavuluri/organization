/**
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

import com.mnt.erp.bean.SalesAreaBean;
import com.mnt.erp.bean.SalesOrganizationBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Naresh
 * @version 1.0 31-10-2013
 */
public class SalesAreaDaoImpl extends HibernateDaoSupport implements
		SalesAreaDao {
	String success;
	List<Object[]> objects = null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id = null;

	@Override
	public Long updateCheckSalesArea(String salesArea, int salesId) {
		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from SalesAreaBean at where  at.salesArea ='"
					+ salesArea + "' and at.salesAreaId!='" + salesId + "'";
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
	public Long checkSalesAreaCout(String salesArea) {
		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from SalesAreaBean at where  at.salesArea='"
					+ salesArea + "'";
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
	public String saveSalesAreaDetails(Object object, String userId,
			String userName) {

		try {
			SalesAreaBean salesBean = (SalesAreaBean) object;
			id = getHibernateTemplate().save(salesBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "SalesOrg", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "F";

		}
		return "S";
	}

	@Override
	public List<Object[]> searchSalesArea() {
		try {
			String hql = "select q.salesAreaId,q.salesArea,q.salesOrg from SalesAreaBean q order by q.salesArea";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchSalesAreaWithId(int id) {
		try {
			String hql = "select q.salesAreaId,q.salesArea,q.salesOrgId from SalesAreaBean q where q.salesAreaId="

					+ id + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateSalesArea(Object object) {
		try {
			SalesAreaBean salesBeanUpdate = (SalesAreaBean) object;
			getHibernateTemplate().update(salesBeanUpdate);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";
		}
		return "S";
	}

	@Override
	public String deleteSalesArea(int id) {
		try {
			SalesAreaBean deleteSales = getHibernateTemplate().get(
					SalesAreaBean.class, id);
			deleteSales.setSalesOrg(new SalesOrganizationBean());
			getHibernateTemplate().delete(deleteSales);

		} catch (Exception e) {
			e.printStackTrace();
			return "F";

		}
		return "S";
	}

	@Override
	public List<Object[]> selectSalesOrg() {
		try {
			String hql = "select so.salesorgId,so.salesorganization from SalesOrganizationBean so ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	@Override
	public List<Object[]> basicSearchSalesArea(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.salesAreaId,q.salesArea,q.salesOrg from SalesAreaBean q where q."
					+ label + "" + operator + " ? order by q.salesArea";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesArea() {
		// TODO Auto-generated method stub
		try {
			String hql = "select sa.salesAreaId,sa.salesArea from SalesAreaBean sa ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

}
