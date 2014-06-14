/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Role;

/**
 * @author Nikesh
 *
 */
public interface RoleDao {
	public String saveRoleDetails(Object object,String userId,String userName);
	public Long duplicateRoleCheck(String role);
	public List<Object[]> searchRole();
	public List<Object[]> basicSearchRole(String label,String operator,String searchName);
	public List<Object[]> searchRoleWithId(String rolename);
	public List<Object[]> searchRoleWithName(String rolename);
	public List<Object[]> selectRoleNames();
	public String updateRole(Object object);
	public Long updateDuplicateCheck(String role, String roleid);
	public String roleDelete(String id);

}
