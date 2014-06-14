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

import com.mnt.erp.bean.Role;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Nikesh
 * 
 */
public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveRoleDetails(Object object, String userId, String userName) {
		try {
			
			Role role = (Role) object;
			Serializable id = getHibernateTemplate().save(role);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Role", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicateRoleCheck(String role) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Role r where  r.role='" + role + "'";
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
	public List<Object[]> searchRole() {

		try {
			String hql = "select r.roleid,r.role,r.adgroup from Role r order by r.role";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchRole(String label, String operator,
			String searchName) {
		try {
		
			String hql = "select r.roleid,r.role,r.adgroup from Role r where r."
					+ label + "" + operator + " ? order by r.role";
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchRoleWithName(String rolename) {
		List<Object[]> objects = null;
		try {
			
			String hql = "select r.roleid,r.role,r.adgroup from Role r where r.roleid='"
					+ rolename + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectRoleNames() {
		String sql = null;
		try {
			sql = "select r.roleid, r.role from Role r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchRoleWithId(String id) {
		List<Object[]> objects = null;
		try {
			
			String hql = "select r.roleid,r.role,r.adgroup from Role r where r.roleid='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateRole(Object object) {
		try {
			Role role = (Role) object;

			getHibernateTemplate().update(role);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String role, String roleid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Role r where  r.role='" + role
					+ "' and r.roleid!='" + roleid + "'";
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

	public String roleDelete(String id) {
		Role role = null;
		try {
			role = (Role) getHibernateTemplate().get(Role.class, id);

			getHibernateTemplate().delete(role);
			role.getRole();
			
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

}
