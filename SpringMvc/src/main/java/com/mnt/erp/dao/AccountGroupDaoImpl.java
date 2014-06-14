package com.mnt.erp.dao;

/*
 @author Srinivas
 @version 1.0   
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.service.AuditLogService;

public class AccountGroupDaoImpl extends HibernateDaoSupport implements
		AccountGroupDao {
	String msg;
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;

	public String saveAccountGroups(Object object, String userId,
			String userName) {
		try {
			AccountGroupBean accountgroupbean = (AccountGroupBean) object;
			Serializable id = getHibernateTemplate().save(accountgroupbean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Account Group",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}

		return msg;

	}

	public List<Object[]> searchAccountGroups() {
		try {
			String hql = "select ag.accountgroupid,ag.accountgroup,ag.coabean from AccountGroupBean ag order by ag.accountgroup";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> searchAccountGroupsWithId(int id) {
		try {
			String hql1 = "select ag.accountgroupid,ag.accountgroup,ag.coaid from AccountGroupBean ag where ag.accountgroupid="
					+ id + "";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectAccountGroupIds() {
		// TODO Auto-generated method stub
		try {
			String hql = "select ags.accountgroupid,ags.accountgroup,ags.coabean from AccountGroupBean ags";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateAccountGroups(Object object) {
		// TODO Auto-generated method stub
		try {
			AccountGroupBean accountGroupBean = (AccountGroupBean) object;
			getHibernateTemplate().update(accountGroupBean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteAccountGroups(int id) {
		// TODO Auto-generated method stub
		try {
			AccountGroupBean accountGroupBean = new AccountGroupBean();
			accountGroupBean.setAccountgroupid(id);
			getHibernateTemplate().delete(accountGroupBean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getAccountgroupCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from AccountGroupBean ab where ab.accountgroup='"
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
	public Long getAccountgroupCountedit(String name, int accountgroupid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from AccountGroupBean ab where ab.accountgroup='"
					+ name + "'and ab.accountgroupid!='" + accountgroupid + "'";
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

	public List<Object[]> basicSearchAccoutGroup(String label, String operator,
			String searchName) {
		try {

			String hql = "select ag.accountgroupid,ag.accountgroup from AccountGroupBean ag where ag."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectcoa() {
		try {
			String hql = "select p.coaId,p.coa from ChartofAccount p";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
