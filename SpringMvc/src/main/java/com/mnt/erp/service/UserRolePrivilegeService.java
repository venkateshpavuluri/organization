/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Privilege;
import com.mnt.erp.bean.UserRolePrivilege;
import com.mnt.erp.bean.Users;

/**
 * @author venkateshp
 *
 */
public interface UserRolePrivilegeService {
	public List<Users> getUsers(String roleId );
	public List<Object[]> getMenus();
	public List<Object[]> getPrivileges();
	public List<Privilege> getprivilegeNames(int menuId);
	public List<Object[]> getMenusAndPrivilegs();
	public int saveUserRolePriviligeDetails(
			List<UserRolePrivilege> userRolePrivileges);
	
	public List<UserRolePrivilege> searchUserRolePriviligeDetails();
	public List<UserRolePrivilege> basicSearchUserRolePriviligeDetails(String label, String operator,
			String searchName);
	
	public String  getIds(String name);
	
	public List<Object[]> editUserRolePris(int id);
	
	public int deleteUserRolePris(String roleId,String userId);
	public List<Privilege> getPrivilegeDetailsForEdit(String userid,String roleId,int menuId);
	public String deleteUserrolePriswithuidpid(String userId,String roleId);
	public Long userPrivDuplicateCheck(String userId, String roleId);

}
