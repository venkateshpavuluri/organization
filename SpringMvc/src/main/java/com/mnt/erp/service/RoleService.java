/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.MaterialDisplay;
import com.mnt.erp.bean.Role;
import com.mnt.erp.dao.RoleDao;

/**
 * @author Nikesh
 *
 */
public interface RoleService {
	
	public String saveRoleDetails(Object object,String userId,String userName);
	public Long duplicateRoleCheck(String role);
	public List<Object[]> searchRole();
	public List<Object[]> basicSearchRole(String label,String operator,String searchName);
	public List<Object[]> searchRoleWithName(String rolename);
	public List<Object[]> selectRoleNames();
	public List<Object[]> searchRoleWithId(String rolename);
	public String updateRole(Object object);
	public Long updateDuplicateCheck(String role, String roleid);
	public String roleDelete(String id);
	

}
