package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.InspectionPlan;
import com.mnt.erp.dao.InspectionPlanDao;


public class InspectionPlanServiceImpl implements InspectionPlanService{
	List<Object[]> objects = null;
	String sus=null;
	
	private InspectionPlanDao inspectionPlanDao;
	
	
	
	

	public InspectionPlanDao getInspectionPlanDao() {
		return inspectionPlanDao;
	}
	public void setInspectionPlanDao(InspectionPlanDao inspectionPlanDao) {
		this.inspectionPlanDao = inspectionPlanDao;
	}
	public Long checkInspectionPlan(String fiscalYear){
		Long l = inspectionPlanDao.checkInspectionPlan(fiscalYear);
		return l;
	}
	public Long updateCheckInspectionPlan(String fiscalYear,int fiscalYearId) {
		Long l = inspectionPlanDao.updateCheckInspectionPlan(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveInspectionPlanDetails(Object object) {
		try {
			sus = inspectionPlanDao.saveInspectionPlanDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchInspectionPlan() {
		
		try {
			objects = inspectionPlanDao.searchInspectionPlan();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<InspectionPlan> searchInspectionPlanWithId(int id) {
		List<InspectionPlan> list = null;
		try {
			list = inspectionPlanDao.searchInspectionPlanWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateInspectionPlan(Object object) {
		try {
			sus = inspectionPlanDao.updateInspectionPlan(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteInspectionPlan(int id) {
		try {
			sus = inspectionPlanDao.deleteInspectionPlan(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	
	public List<Object[]> selectEquipment() {
		
		try {
			objects = inspectionPlanDao.selectEquipment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectMaintenanceCategory() {
		
		try {
			objects = inspectionPlanDao.selectMaintenanceCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
public List<Object[]> selectMaintenanceType() {
		
		try {
			objects = inspectionPlanDao.selectMaintenanceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicSearchInspectionPlan(String label,String operator,String searchName){
		try {
			objects = inspectionPlanDao.basicSearchInspectionPlan(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteInspectionPlanDetail(int kk){
		String msg = null;
		try {
			msg = inspectionPlanDao.deleteInspectionPlanDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	
}
