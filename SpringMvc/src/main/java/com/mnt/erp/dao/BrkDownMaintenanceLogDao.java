/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;

/**
 * @author venkateshp
 * @version 1.0 22-04-2014
 */
public interface BrkDownMaintenanceLogDao {
	public String saveBrkDownMaintenanceLog(Object object);

	public List<Object[]> searchBrkDownMtLogDt();

	public List<BreakDownMaintenanceLog> editBrkDownMtLogDetails(
			int maintenanceId);

	public String deleteChilds(List<BreakDownMaintenanceSpare> object);

	public String updateBrkDwnMtLog(Object object);

	public String deleteBrkDwnMtLog(int id);

	public List<Object[]> brkDwnMtLogBasicSearch(String dbField,
			String operation, String basicSearchId);

}
