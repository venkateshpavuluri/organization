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
import com.mnt.erp.bean.VendGroup;
import com.mnt.erp.service.AuditLogService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class VendorGroupDaoImpl extends HibernateDaoSupport implements
		VendorGroupDao {
	@Autowired
	AuditLogService auditLogService;
	String msg = null;
	List<Object[]> list = null;

	public String saveVendorGroup(Object object, String userId, String userName) {

		try {
			VendGroup vg = (VendGroup) object;
			Serializable id = getHibernateTemplate().save(vg);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Vendor Group",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	public List<Object[]> searchVendorGroup(int id) {
		List<Object[]> objects = null;
		try {
			String hql = "select v.vendorGroup_Id,v.vendorGroup,v.vendorGroupCode from VendGroup v order by v.vendorGroup";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> editVendorGroupWithId(int id) {
		List<Object[]> objects = null;
		try {
			String hql = "select v.vendorGroup_Id,v.vendorGroup,v.vendorGroupCode from VendGroup v where v.vendorGroup_Id="
					+ id + "";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public String updateVendorGroup(Object object) {
		try {
			VendGroup vendGroup = (VendGroup) object;
			int id = vendGroup.getEditVendorGroup_Id();
			VendGroup vtype = (VendGroup) getHibernateTemplate().get(
					VendGroup.class, id);
			vtype.setVendorGroup_Id(vendGroup.getEditVendorGroup_Id());
			vtype.setVendorGroup(vendGroup.getEditVendorGroup());
			vtype.setVendorGroupCode(vendGroup.getEditVendorGroupCode());
			getHibernateTemplate().update(vtype);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}

		return msg;

	}

	public String vendorGroupDelete(int id) {
		VendGroup at = null;
		try {
			at = (VendGroup) getHibernateTemplate().get(VendGroup.class, id);

			getHibernateTemplate().delete(at);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;

	}

	public int vendorDuplicate(String vendorGroupCheck,
			String vendorGroupCodeCheck) {
		Long count = null;
		try {
	
			
			final String hql = "select count(*) from VendGroup v where v.vendorGroup='"
					+ vendorGroupCheck+ "' or v.vendorGroupCode='"+ vendorGroupCodeCheck + "'";
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

	public int vendorEditDuplicate(String vendorGroupCheck,
			String vendorGroupCodeCheck, int id) {

		Long count = null;
		try {
			final String hql = "select count(*) from VendGroup v where v.vendorGroup='"
					+ vendorGroupCheck+ "' or v.vendorGroupCode='"+ vendorGroupCodeCheck+ "' and v.vendorGroup_Id!='"
					+ id
					+ "'";

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

	@Override
	public List<Object[]> getVendorGroupIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;

		try {
			sql = "select c.vendorGroup_Id,c.vendorGroup from  VendGroup c";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> basicSearchVendorGroup(String label, String operator,
			String searchName) {
		try {

			String hql = "select v.vendorGroup_Id,v.vendorGroup,v.vendorGroupCode from VendGroup v where v."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
