package com.mnt.erp.service;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

public interface AccountGroupService {
	public String saveAccountGroupservice(Object object,String userId,String userName);
	public List<Object[]> searchAccountGroupsWithId(int id);
	public List<Object[]> searchAccountGroups();
	public List<Object[]> selectAccountGroupids();
	public List<Object[]> selectcoa();
	public String updateAccountGroups(Object object);
	public String deleteAccountGroups(int id);
	public Long getAccountgroupCount(String name);
	public Long getAccountgroupCountedit(String name,int accountgroupid);
	public List<Object[]> basicSearchAccoutGroup(String label,String operator,String searchName);
}
