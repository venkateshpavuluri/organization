/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Function;
import com.mnt.erp.bean.UserGroup;
import com.mnt.erp.bean.UserOrganizationBean;
import com.mnt.erp.bean.UserRoles;
import com.mnt.erp.bean.Users;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 * 
 */
public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {
	@Autowired
	AuditLogService auditLogService;

	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;

	@Override
	public String saveUsersDetails(Object object, String usernId,
			String userName) {
		try {
			// System.out.println("in save of users dao impl");
			Users users = (Users) object;
			Serializable uid = getHibernateTemplate().save(users);
			if (uid != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(usernId, "A", "Users", "ROW",
						String.valueOf(uid), "1", modifiedDate, userName);
			}

			UserRoles userRoles = new UserRoles();
			Iterator<String> iterator = null;
			iterator = users.getRoleName().iterator();
			String userId = uid.toString();
			while (iterator.hasNext()) {
				String usersid = (String) iterator.next();
				userRoles.setUserId(userId);
				userRoles.setRoleId(usersid);

				getHibernateTemplate().save(userRoles);
			}
			UserOrganizationBean usbean = new UserOrganizationBean();
			Iterator<String> iter = null;
			iter = users.getOrganizationId().iterator();

			while (iter.hasNext()) {
				String usersid = (String) iter.next();
				usbean.setUserid(userId);

				usbean.setOrgid(usersid);

				getHibernateTemplate().save(usbean);
			}

			msg = "success";
		} catch (Exception e) {

			e.printStackTrace();
			msg = "failure";
		}
		return msg;
	}

	@Override
	public String saveUserRoles(Object object) {
		try {

			Users users = (Users) object;
			UserRoles userRoles = new UserRoles();
			Iterator<String> iterator = null;
			iterator = users.getRoleNameEdit().iterator();
			String userId = users.getUser_Id();
			while (iterator.hasNext()) {
				String roleId = (String) iterator.next();
				userRoles.setUserId(userId);
				userRoles.setRoleId(roleId);

				getHibernateTemplate().save(userRoles);
			}

			msg = "Users Details Updated Successfully";
		} catch (Exception e) {
			msg = "UsersRoles Details Did Not Updated";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public String saveUserOrganization(Object object) {
		try {
			Users users = (Users) object;
			UserOrganizationBean userorg = new UserOrganizationBean();
			Iterator<String> iterator = null;
			iterator = users.getOrganizationIdEdit().iterator();
			String userId = users.getUser_Id();
			while (iterator.hasNext()) {
				String roleId = (String) iterator.next();
				userorg.setUserid(userId);
				userorg.setOrgid(roleId);

				getHibernateTemplate().save(userorg);
			}

			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long duplicateUsersCheck(String userNames) {

		Long i = 0l;
		try {
			sql = "select count(*) from Users r where  r.userName='"
					+ userNames + "'";
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
	public List<Object[]> selectRoleIds() {
		String sql = null;
		try {
			sql = "select r.roleid, r.role from Role r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> selectUserGroupIds() {
		String sql = null;
		try {
			sql = "select ug.usergroupId, ug.usergroup from UserGroup ug";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> selectFunctionIds() {
		String sql = null;
		try {
			sql = "select f.functionId, f.functionName from Function f";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> selectOrganizationIds() {
		String sql = null;
		try {
			sql = "select o.orgId, o.orgName from Organization o";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Users> searchUsers() {
		List<Users> listl = null;
		List<Users> displays = new ArrayList<Users>();
		Users userssearch = null;
		try {
			String hql = "from Users u order by u.userName";

			listl = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listl;
	}

	public List<Users> searchUsersWithName(String usersname) {
		List<Users> objects = null;
		try {
			String hql = "from Users u where u.userName='" + usersname
					+ "' order by u.userName";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectUsersNames() {
		String sql = null;
		try {
			sql = "select u.user_Id,u.userName from Users u";
			;
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Users> searchUsersWithId(String id) {
		List<Users> objects = null;
		try {

			String hql = "from Users u where u.user_Id='" + id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateUsers(Object object) {
		try {
			Users users = (Users) object;

			getHibernateTemplate().update(users);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String users, String usersid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Users u where u.userName='" + users
					+ "' and u.user_Id!='" + usersid + "'";
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

	public String usersDelete(String id) {
		Users users = null;
		try {
			users = (Users) getHibernateTemplate().get(Users.class, id);

			users.setUsergroupBean(new UserGroup());
			users.setFunctionBean(new Function());
			getHibernateTemplate().delete(users);
			users.getUserName();
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	public String userRolesDelete(String userid) {
		UserRoles userRole = null;
		final List<UserRoles> listl = null;
		final String uid = userid;
		try {

			getHibernateTemplate().executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(org.hibernate.Session session)
						throws HibernateException, SQLException {
					String hql = "delete from UserRoles ur where ur.userId='"
							+ uid + "'";
					Query query = session.createQuery(hql);
					query.executeUpdate();
					return listl;
				}
			});

		} catch (Exception e) {
			msg = "UserRole Details Did Not Deleted";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String userOrganizationDelete(String id) {
		UserOrganizationBean userbean = null;
		final List<UserOrganizationBean> listl = null;
		final String uid = id;
		try {

			getHibernateTemplate().executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(org.hibernate.Session session)
						throws HibernateException, SQLException {
					String hql = "delete from UserOrganizationBean ur where ur.userid='"
							+ uid + "'";
					Query query = session.createQuery(hql);
					query.executeUpdate();
					return listl;
				}
			});

		} catch (Exception e) {
			msg = "UserOrganization Details Did Not Deleted";
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public List<Object[]> getThemeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.theme_Id,s.theme from ThemeBean s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
