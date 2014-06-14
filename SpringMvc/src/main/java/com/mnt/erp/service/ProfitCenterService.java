/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author tparvathi
 *
 */
public interface ProfitCenterService {
	public String saveProfitCenter(Object object,String userId,String userName);

	public List<Object[]> searchProfitCenter(int id);

	public List<Object[]> editProfitCenterWithId(int id);

	public String updateProfitCenter(Object object);

	public String profitCenterDelete(int id);

	public int profitCenterDuplicate(String ProfitCenter);

	public int profitCenterEditDuplicate(String ProfitCenter,int id);

	public List<Object[]> basicSearchProfitCenter(String label,String operator,String searchName);
}
