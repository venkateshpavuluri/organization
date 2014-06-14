/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author devi
 *
 */
public interface breakTimeDao {
	public String saveBreakTime(Object shiftObject,String userId,String userName);
	public List<Object[]>searchBreakTimeWithId(int id);
	public List<Object[]>searchBreakTime();
	public List<Object[]>selectBreakTime();
	public String updateBreakTime(Object shiftupdate);
	public String deleteBreakTime(int id);
	public Long getBreakTimeCount(String name);
	public Long getBreakTimeCountedit(String name,int shiftid);
	public List<Object[]> basicSearchBreakTime(String label,String operator,String searchName);
	public List<Object[]> getOrganizationIds();
	public List<Object[]> getShiftIds();
}
