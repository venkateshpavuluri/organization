package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Parvathi
 * @version 1.0 04-1-2014
 */
public interface CodeGroupDao {
	
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
