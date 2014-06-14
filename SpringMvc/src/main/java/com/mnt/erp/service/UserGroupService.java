/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author anikesh
 *
 */
public interface UserGroupService {
	public String saveUserGroupDetails(Object object,String userId,String userName);
	public Long duplicateUserGroupCheck(String usergroup);
	public List<Object[]> searchUserGroup();
	public List<Object[]> searchUserGroupWithName(String usergroupname);
	public List<Object[]> selectUserGroupNames();
	public List<Object[]> basicSearchUserGroup(String label,String operator,String searchName);
	public List<Object[]> searchUserGroupWithId(String usergroupname);
	public String updateUserGroup(Object object);
	public Long updateDuplicateCheck(String usergroup, int usergroupid);
	public String usergroupDelete(int id);
}
