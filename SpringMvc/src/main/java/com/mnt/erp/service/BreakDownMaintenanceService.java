/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0  16-04-2014
 */
public interface BreakDownMaintenanceService {
	
	public Long updateCheckBreakDown(String recNo, int recId);

	public Long checkBreakDownCout(String recNo);

	public boolean saveBreakDownDetails(Object object);

	public List<Object[]> searchBreakDown();

	public List<Object> searchBreakDownWithId(int recId);

	public boolean updateBreakDown(Object object);

	public boolean deleteBreakDown(int recId);

	public List<Object[]> basicSearchBreakDown(String label,
			String operator, String searchName);



}
