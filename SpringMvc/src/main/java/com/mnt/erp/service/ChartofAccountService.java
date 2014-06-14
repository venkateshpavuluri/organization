/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ChartofAccount;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface ChartofAccountService  
{

	public boolean saveChartofAccount(ChartofAccount chartofAccount,String userId,String userName);
	public int duplicateCheckChartofAccount(String chartofAccount,String id);
	public List<Object[]> getChartofAccountOrgId();
	public List<Object[]> basicSearchChartofAccount(String label, String operator,String searchName);
	public List<Object> editChartofAccount(int id);
	public boolean updateChartofAccount(ChartofAccount chartofAccount);
	public boolean deleteChartofAccount(int id);

	
}
