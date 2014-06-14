/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author anikesh
 *
 */
public interface FunctionDao {
	public String saveFunctionDetails(Object object,String userId,String userName);
	public Long duplicateFunctionCheck(String functionname);
	public List<Object[]> searchFunction();
	public List<Object[]> selectFunctionNames();
	public List<Object[]> basicSearchFunction(String label,String operator,String searchName);
	public List<Object[]> searchFunctionWithId(String functionname);
	public String updateFunction(Object object);
	public Long updateDuplicateCheck(String function, int functionid);
	public String functionDelete(int id);
}
