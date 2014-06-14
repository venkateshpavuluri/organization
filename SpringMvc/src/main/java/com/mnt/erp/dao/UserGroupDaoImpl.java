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

import com.mnt.erp.bean.UserGroup;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 * 
 */
public class UserGroupDaoImpl extends HibernateDaoSupport implements
		UserGroupDao {
	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveUserGroupDetails(Object object, String userId,
			String userName) {
		try {

			UserGroup usergroup = (UserGroup) object;
			Serializable id = getHibernateTemplate().save(usergroup);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "User Group",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicateUserGroupCheck(String usergroup) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {

			sql = "select count(*) from UserGroup r where  r.usergroup='"
					+ usergroup + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Object[]> searchUserGroup() {

		try {

			String hql = "select r.usergroupId,r.usergroup from UserGroup r order by r.usergroup";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchUserGroupWithName(String usergroupname) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.usergroupId,r.usergroup from UserGroup r where r.usergroupId="
					+ usergroupname + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectUserGroupNames() {
		String sql = null;
		try {
			sql = "select r.usergroupId, r.usergroup from UserGroup r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchUserGroup(String label, String operator,
			String searchName) {
		try {
			String hql = "select r.usergroupId,r.usergroup from UserGroup r where r."
					+ label + "" + operator + " ? order by r.usergroup";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchUserGroupWithId(String id) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.usergroupId,r.usergroup from UserGroup r where r.usergroupId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateUserGroup(Object object) {
		try {
			UserGroup usergroup = (UserGroup) object;

			getHibernateTemplate().update(usergroup);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String usergroup, int usergroupid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from UserGroup r where  r.usergroup='"
					+ usergroup + "' and r.usergroupId!='" + usergroupid + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public String usergroupDelete(int id) {
		UserGroup usergroup = null;
		try {
			usergroup = (UserGroup) getHibernateTemplate().get(UserGroup.class,
					id);

			getHibernateTemplate().delete(usergroup);
			usergroup.getUsergroup();
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

}
