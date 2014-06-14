package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.InspectionPlan;

public interface InspectionPlanService {
	public Long updateCheckInspectionPlan(String equipment,int id);

	public Long checkInspectionPlan(String equipment);
	
	public String saveInspectionPlanDetails(Object object);

	public List<Object[]> searchInspectionPlan();

	public List<InspectionPlan> searchInspectionPlanWithId(int id);

	public String updateInspectionPlan(Object object);

	public String deleteInspectionPlan(int id);
	
	public List<Object[]> selectEquipment();
	
	public List<Object[]> selectMaintenanceCategory();
	
	public List<Object[]> selectMaintenanceType();
	
	public String deleteInspectionPlanDetail(int kk);
	
	public List<Object[]> basicSearchInspectionPlan(String label,String operator,String searchName);
}
