/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author madhav
 *
 */
public interface ConditionTypeDao {
	
	public Long updateCheckConditionType(String conditionType,int conditionTypeId);

	public Long addCheckConditionType(String conditionType);
	
	public String saveConditionType(Object object,String userId,String userName);

	public List<Object[]> searchConditionType();

	public List<Object[]> searchConditionTypeWithId(int id);

	public String updateConditionType(Object object);

	public String deleteConditionType(int id);
	
	public List<Object[]> basicSearchConditionType(String label,String operator,String searchName);

}
