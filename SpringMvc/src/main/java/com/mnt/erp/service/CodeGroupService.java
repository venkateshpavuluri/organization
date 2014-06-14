package com.mnt.erp.service;

import java.util.List;

public interface CodeGroupService {
	
	public Long updateCheckCodeGroup(String codeGroup,int codeGroupId);

	public Long checkCodeGroupCout(String codeGroup);
	
	public String saveCodeGroupDetails(Object object,String userId,String userName);

	public List<Object[]> searchCodeGroup();

	public List<Object[]> searchCodeGroupWithId(int id);

	public String updateCodeGroup(Object object);

	public String deleteCodeGroup(int id);
	
	public List<Object[]> selectCodeGroup();
	
	public List<Object[]> basicSearchCodeGroup(String label,String operator,String searchName);

}
