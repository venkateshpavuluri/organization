/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author madhav
 * 
 */
public interface ConditionService {

	public List<Object[]> selectCondition();

	public Long updateCheckCondition(String salesArea, int salesId);

	public Long addCheckConditionType(String salesArea);

	public String saveCondition(Object object,String userId,String userName);

	public List<Object[]> searchCondition();

	public List<Object[]> searchConditoinWithId(int id);

	public String updateCondition(Object object);

	public String deleteCodition(int id);

	public List<Object[]> selectConditionType();

	public List<Object[]> basicSearchCondition(String label, String operator,
			String searchName);

}
