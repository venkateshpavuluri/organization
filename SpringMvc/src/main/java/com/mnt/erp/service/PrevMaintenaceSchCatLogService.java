package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;
import com.mnt.erp.bean.PrevMaintenanceSchCatLog;
import com.mnt.erp.bean.PrevMaintenanceSchCatLogSpare;

public interface PrevMaintenaceSchCatLogService {
	public String savePreMtSchCatLog(Object object);

	public List<Object[]> searchPreMtSchCatLog();

	public List<PrevMaintenanceSchCatLog> editPreMtSchCatLog(int maintenanceId);

	public String deleteChilds(List<PrevMaintenanceSchCatLogSpare> object);

	public String updatePreMtSchCatLog(Object object);

	public String deletePreMtSchCatLog(int id);

	public List<Object[]> preMtSchCatLogBasicSearch(String dbField,
			String operation, String basicSearchId);

}
