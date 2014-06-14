/**
 *@Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;
import com.mnt.erp.bean.PrevMaintenanceSchCatLog;
import com.mnt.erp.bean.PrevMaintenanceSchCatLogSpare;

/**
 * @author venkateshp
 * @version 1.0 22-04-2014
 */
public interface PrevMaintenaceSchCatLogDao {

	public String savePreMtSchCatLog(Object object);

	public List<Object[]> searchPreMtSchCatLog();

	public List<PrevMaintenanceSchCatLog> editPreMtSchCatLog(
			int maintenanceId);

	public String deleteChilds(List<PrevMaintenanceSchCatLogSpare> object);

	public String updatePreMtSchCatLog(Object object);

	public String deletePreMtSchCatLog(int id);

	public List<Object[]> preMtSchCatLogBasicSearch(String dbField,
			String operation, String basicSearchId);

}
