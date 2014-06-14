/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author devi
 *
 */
public interface payModeDao {
	public Long updateCheckPayMode(String paymode,int payModeId);

	public Long checkPayModeCount(String assetType);
	
	public String savePayModeDetails(Object object,String userId,String userName);

	public List<Object[]> searchPayMode();

	public List<Object[]> searchPayModeWithId(int id);

	public String updatePayMode(Object object);

	public String deletePayMode(int id);
	
	public List<Object[]> selectPayMode();
	
	public List<Object[]> basicSearchPayMode(String label,String operator,String searchName);


}
