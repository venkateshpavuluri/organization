package com.mnt.erp.service;

import java.util.List;

public interface MaintenanceOrderTypeService {
	
	public Long updateCheckMaintenanceOrderType(String maintenanceOrderType,int maintenanceOrderTypeId);

	public Long checkMaintenanceOrderType(String maintenanceOrderType);
	
	public String saveMaintenanceOrderTypeDetails(Object object);

	public List<Object[]> searchMaintenanceOrderType();

	public List<Object[]> searchMaintenanceOrderTypeWithId(int id);

	public String updateMaintenanceOrderType(Object object);

	public String deleteMaintenanceOrderType(int id);
	
	public List<Object[]> selectMaintenanceOrderType();
	
	public List<Object[]> basicSearchMaintenanceOrderType(String label,String operator,String searchName);

}
