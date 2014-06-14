/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author devi
 *
 */
public interface BreakTimeService {
	public String saveBreakTime(Object shiftserviceobject,String userId,String userName);
	public List<Object[]>searchBreakTimeServiceWithId(int id);
	public List<Object[]>searchBreakTimeService();
	public List<Object[]>selectBreakTimeService();
	public String updateBreakTimeService(Object updateshiftservice);
	public String deleteBreakTimeService(int id);
	public Long getBreakTimecount(String name);
	public Long getBreakTimecountedit(String name,int shiftid);
	public List<Object[]> basicSearchBreakTime(String label,String operator,String searchName);
	public List<Object[]>selectshiftservice();
	public List<Object[]>selectorgservice();
}
