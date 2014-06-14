/**
 * 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Privilege;
import com.mnt.erp.bean.UserRolePrivilege;
import com.mnt.erp.bean.Users;

/**
 * @author venkateshp
 * 
 */
public class UserRolePrivilegeDaoImpl extends HibernateDaoSupport implements
		UserRolePrivilegeDao {
	String hql;
	List<Object[]> list = null;
	static Logger logger = Logger.getLogger(UserRolePrivilegeDaoImpl.class);

	@Override
	public List<Users> getUsers(String roleId) {
		// TODO Auto-generated method stub
		List<Users> listofUsers = null;
		try {
			hql = "select u.usersDetails from UserRoles u where u.roleId='"
					+ roleId + "'";
			listofUsers = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listofUsers;
	}

	@Override
	public List<Object[]> getMenus() {

		try {
			// MenuItems
			hql = "select m.menuId,m.title,m.location from MenuItems m order by m.menuId";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Object[]> getPrivileges() {
		try {
			hql = "select m.privilegeid,m.privilege from Privilege m ";
			list = getHibernateTemplate().find(hql);
			logger.info("privileges aree==" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Privilege> getprivilegeNames(int menuId) {
		// TODO Auto-generated method stub
		List<Privilege> list = null;
		try {

			hql = "select o.privilegeDetails from ObjectPrivilege o  where o.menuId="
					+ menuId + "";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getMenusAndPrivilegs() {
		// TODO Auto-generated method stub
		try {
			hql = "select o.privilegeDetails,o.menuDetails from ObjectPrivilege o";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int saveUserRolePriviligeDetails(
			List<UserRolePrivilege> userRolePrivileges) {
		// TODO Auto-generated method stub
		int msg = 0;
		try {
			getHibernateTemplate().saveOrUpdateAll(userRolePrivileges);

			msg = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchUserRolePriviligeDetails() {
		// TODO Auto-generated method stub
		try {
			hql = "select distinct p.usersDetails,p.roleDetails from UserRolePrivilege p";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> basicSearchUserRolePriviligeDetails(String label,
			String operator, String searchName) {
		// TODO Auto-generated method stub
		try {
			hql = "select p.userRolePrivilegeId,p.usersDetails,p.roleDetails from UserRolePrivilege p where p."
					+ label + "" + operator + "'" + searchName + "'";

			// Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getIds(String name) {
		// TODO Auto-generated method stub
		String id = null;
		try {
			List<String> list = getHibernateTemplate().find(name);
			id = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> editUserRolePris(int id) {
		// TODO Auto-generated method stub
		try {
			hql = "select p.userRolePrivilegeId,p.usersDetails,p.roleDetails,p.menuDetails,p.privilegeDetails from UserRolePrivilege p where p.userRolePrivilegeId="
					+ id;
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteUserRolePris(String roleId, String userId) {
		// TODO Auto-generated method stub

		try {
			int suid = 0;

			hql = "delete from UserRolePrivilege u where u.roleId='" + roleId
					+ "' and u.userId='" + userId + "'";
			List list = getHibernateTemplate().executeFind(
					new HibernateCallback()

					{
						public String doInHibernate(
								org.hibernate.Session session)
								throws HibernateException {
							Query q = session.createQuery(hql);
							q.executeUpdate();

							return "S";
						}
					});
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public List<Privilege> getPrivilegeDetailsForEdit(String userId,
			String roleId, int menuId) {
		// TODO Auto-generated method stub
		List<Privilege> list = null;
		try {
			hql = "select p.privilegeDetails from UserRolePrivilege p where p.userId='"
					+ userId
					+ "' and p.roleId='"
					+ roleId
					+ "' and p.menuId="
					+ menuId;
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String deleteUserrolePriswithuidpid(String userId, String roleId) {
		// TODO Auto-generated method stub
		try {

			final String user = userId;
			final String role = roleId;
			return getHibernateTemplate().execute(new HibernateCallback() {
				@Override
				public String doInHibernate(org.hibernate.Session session) {
					Query query = session
							.createQuery("delete from UserRolePrivilege p where p.userId='"
									+ user + "' and p.roleId='" + role + "'");
					query.executeUpdate();

					return "success";
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "1";
	}

	@Override
	public Long userPrivDuplicateCheck(String userId, String roleId) {
		Long duid = 0l;
		List<Object> list = null;
		Iterator<Object> iterator = null;
		Object object = null;
		try {
			hql = "select count(*) from UserRolePrivilege u where  u.userId='"
					+ userId + "' and u.roleId='" + roleId + "'";
			list = getHibernateTemplate().find(hql);

			iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object) iterator.next();
				duid = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return duid;
	}

}
