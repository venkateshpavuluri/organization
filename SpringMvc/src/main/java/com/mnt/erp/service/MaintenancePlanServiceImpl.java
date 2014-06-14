package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.MaintenancePlanDao;

public class MaintenancePlanServiceImpl implements MaintenancePlanService{

	
	List<Object[]> objects = null;
	String sus=null;
private MaintenancePlanDao mplanDao;

	

	public MaintenancePlanDao getMplanDao() {
	return mplanDao;
}
public void setMplanDao(MaintenancePlanDao mplanDao) {
	this.mplanDao = mplanDao;
}
public Long checkMaintenancePlanCout(String equipment,String planedDate){
		Long l = mplanDao.checkMaintenancePlanCout(equipment, planedDate);
		return l;
	}
public Long updateCheckMaintenancePlan(String equipment,String planedDate,int maintenancePlanId){
		Long l = mplanDao.updateCheckMaintenancePlan(equipment, planedDate, maintenancePlanId);
		return l;
	}
	
	public String saveMaintenancePlanDetails(Object object) {
		try {
			sus = mplanDao.saveMaintenancePlanDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchMaintenancePlan() {
		
		try {
			objects = mplanDao.searchMaintenancePlan();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchMaintenancePlanWithId(int id) {
		List<Object[]> list = null;
		try {
			list = mplanDao.searchMaintenancePlanWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateMaintenancePlan(Object object) {
		try {
			sus = mplanDao.updateMaintenancePlan(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteMaintenancePlan(int id) {
		try {
			sus = mplanDao.deleteMaintenancePlan(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectMaintenancePlan() {
		
		try {
			objects = mplanDao.selectMaintenancePlan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public List<Object[]> selectMaintenanceType(){
		try {
			objects = mplanDao.selectMaintenanceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectEquipment(){
		try {
			objects = mplanDao.selectEquipment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectShift(){
		try {
			objects = mplanDao.selectShift();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchMaintenancePlan(String label,String operator,String searchName){
		try {
			objects = mplanDao.basicSearchMaintenancePlan(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	
	
	
}
