/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Privilege;

/**
 * @author A Nikesh
 *
 */
public interface PrivilegeDao {
	public String savePrivilegeDetails(Object object,String userId,String userName);
	public Long duplicatePrivilegeCheck(String privilege);
	public List<Object[]> searchPrivilege();
	public List<Object[]> basicSearchPrivilege(String label,String operator,String searchName);
	public List<Object[]> selectPrivilegeNames();
	public List<Object[]> searchPrivilegeWithId(String privilegename);
	public List<Object[]> searchPrivilegeWithName(String privilegename);
	public String updatePrivilege(Object object);
	public Long updateDuplicateCheck(String privilege, String privilegeid);
	public String privilegeDelete(String id);
}
