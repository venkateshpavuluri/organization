package com.mnt.erp.service;

import java.util.List;

public interface maintenanceTypeService {
	public String saveMaintenanceType(Object object);
	public long checkMaintenanceType(String type);
	public List<Object[]> searchMaintenanceType();
	public List<Object[]> searchMaintenanceTypeWithId(int id);
	public List<Object[]> basicSearchMaintenanceType(String label,String operator,String searchName);
	public String deleteMaintenanceType(int id);
	public String updateMaintenanceType(Object object);
	public List<Object[]> selectMaintenanceType();
	public long updateCheckMaintenanceType(String type, int Id);
}
