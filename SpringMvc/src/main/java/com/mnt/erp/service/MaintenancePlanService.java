package com.mnt.erp.service;

import java.util.List;

public interface MaintenancePlanService {

	public Long updateCheckMaintenancePlan(String equipment,String planedDate,int maintenancePlanId);

	public Long checkMaintenancePlanCout(String equipment,String planedDate);
	
	public String saveMaintenancePlanDetails(Object object);

	public List<Object[]> searchMaintenancePlan();

	public List<Object[]> searchMaintenancePlanWithId(int id);

	public String updateMaintenancePlan(Object object);

	public String deleteMaintenancePlan(int id);
	
	public List<Object[]> selectMaintenancePlan();
	
	public List<Object[]> selectMaintenanceType();
	
    public List<Object[]> selectEquipment();
	
	public List<Object[]> selectShift();
	
	public List<Object[]> basicSearchMaintenancePlan(String label,String operator,String searchName);
	
}
