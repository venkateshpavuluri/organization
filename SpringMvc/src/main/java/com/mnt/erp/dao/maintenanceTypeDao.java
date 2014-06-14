package com.mnt.erp.dao;

import java.util.List;

public interface maintenanceTypeDao {
	public String saveMaintenanceType(Object object);
	public long checkMaintenanceType(String type);
	public List<Object[]> searchMaintenanceType();
	public String deleteMaintenanceType(int id);
	public List<Object[]> searchMaintenanceTypeWithId(int id);
	public List<Object[]> basicSearchMaintenanceType(String label,String operator,String searchName);
	public String updateMaintenanceType(Object object);
	public List<Object[]> selectMaintenanceType();
	public long updateCheckMaintenanceType(String type, int Id);

}
