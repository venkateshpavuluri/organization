/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author devi
 *
 */
public interface payModeService {
	public Long updateCheckPayMode(String payMode,int payModeId);

	public Long checkPayModeCount(String paymode);
	
	public String savePayModeDetails(Object object,String userId,String userName);

	public List<Object[]> searchPayMode();

	public List<Object[]> searchPayModeWithId(int id);

	public String updatePayMode(Object object);

	public String deletePayMode(int id);
	
	public List<Object[]> selectPayMode();
	
	public List<Object[]> basicSearchPayMode(String label,String operator,String searchName);


}
