/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.ChartofAccount;

/**
 * @author kirangangone
 * @version 1.0
 *@build 0.0
 */
public interface ChartofAccountDao 
{
	
	public boolean saveChartofAccount(ChartofAccount chartofAccount,String userId,String userName);
	public int duplicateCheckChartofAccount(String chartofAccount,String id);
	public List<Object[]> getChartofAccountOrgId();
	public List<Object[]> basicSearchChartofAccount(String label, String operator,String searchName);
	public List<Object> editChartofAccount(int cId);
	public boolean updateChartofAccount(ChartofAccount chartofAccount);
	public boolean deleteChartofAccount(int id);

	}
