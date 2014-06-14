package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;

public interface BreakdownMaintenaceLogService {
	public String savebrkDownMaintenanceLog(Object object);
	public List<Object[]> searchBrkDownMtLogDt(); 
	public List<BreakDownMaintenanceLog> editBrkDownMtLogDetails(int maintenanceId);
	public String deleteChilds(List<BreakDownMaintenanceSpare> object);
	public String updateBrkDwnMtLog(Object object);
public String deleteBrkDwnMtLog(int id);
public List<Object[]> brkDwnMtLogBasicSearch(String dbField,String operation,String basicSearchId);
}
