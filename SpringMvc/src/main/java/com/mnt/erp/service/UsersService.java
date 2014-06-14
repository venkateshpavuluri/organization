/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Users;

/**
 * @author anikesh
 *
 */
public interface UsersService {
	public String saveUsersDetails(Object object,String userId,String userName);
	public String saveUserRoles(Object object);
	public String saveUserOrganization(Object object);
	public Long duplicateUsersCheck(String users);
	public List<Object[]> selectRoleIds();
	public List<Object[]> selectUserGroupIds();
	public List<Object[]> selectFunctionIds();
	public List<Object[]> selectOrganizationIds();
	public List<Users> searchUsers();
	public List<Users> searchUsersWithName(String usersName);
	public List<Object[]> selectUsersNames();
	public List<Users> searchUsersWithId(String usersname);
	public String updateUsers(Object object);
	
	public Long updateDuplicateCheck(String users, String usersid);
	public String usersDelete(String id);
	public String userRolesDelete(String id);
	public String userOrganizationDelete(String id);
	public List<Object[]>selectThemeService();
}
