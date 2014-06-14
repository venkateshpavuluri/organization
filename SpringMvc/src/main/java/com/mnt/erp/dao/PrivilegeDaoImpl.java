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

import com.mnt.erp.bean.Privilege;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Administrator
 * 
 */
public class PrivilegeDaoImpl extends HibernateDaoSupport implements
		PrivilegeDao {
	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String savePrivilegeDetails(Object object, String userId,
			String userName) {
		try {

			Privilege privilege = (Privilege) object;
			Serializable id = getHibernateTemplate().save(privilege);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Privilege",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}
			msg = "S";
		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicatePrivilegeCheck(String privilege) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Privilege p where  p.privilege='"
					+ privilege + "'";
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
	public List<Object[]> searchPrivilege() {

		try {
			String hql = "select r.privilegeid,r.privilege from Privilege r";
			
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchPrivilege(String label, String operator,
			String searchName) {
		try {
			
			String hql = "select r.privilegeid,r.privilege from Privilege r where r."
					+ label + "" + operator + " ? ";
			
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchPrivilegeWithId(String id) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.privilegeid,r.privilege from Privilege r where r.privilegeid='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchPrivilegeWithName(String privilegename) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.privilegeid,r.privilege from Privilege r where r.privilegeid='"
					+ privilegename + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPrivilegeNames() {
		String sql = null;
		try {
			sql = "select r.privilegeid, r.privilege from Privilege r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public String updatePrivilege(Object object) {
		try {
			Privilege privilege = (Privilege) object;

			getHibernateTemplate().update(privilege);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String privilege, String privilegeid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Privilege r where  r.privilege='"
					+ privilege + "' and r.privilegeid!='" + privilegeid + "'";
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

	public String privilegeDelete(String id) {
		Privilege privilege = null;
		try {
			privilege = (Privilege) getHibernateTemplate().get(Privilege.class,
					id);

			getHibernateTemplate().delete(privilege);
			privilege.getPrivilege();
			System.out.println("privilege deleted    "
					+ privilege.getPrivilege());
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

}
