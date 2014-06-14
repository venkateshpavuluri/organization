package com.mnt.erp.dao;

/*
 @author Srinivas
 @version 1.0   
 */
import java.util.List;

public interface AccountGroupDao {
	public String saveAccountGroups(Object object,String userId,String userName);

	public List<Object[]> searchAccountGroupsWithId(int id);

	public List<Object[]> searchAccountGroups();

	public List<Object[]> selectAccountGroupIds();
	public List<Object[]>selectcoa();

	public String updateAccountGroups(Object object);

	public String deleteAccountGroups(int id);

	public Long getAccountgroupCount(String name);

	public Long getAccountgroupCountedit(String name, int accountgroupid);

	public List<Object[]> basicSearchAccoutGroup(String label, String operator,
			String searchName);
}
