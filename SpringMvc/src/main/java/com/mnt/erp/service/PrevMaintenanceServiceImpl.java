package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.PrevMaintenance;
import com.mnt.erp.dao.PrevMaintenanceDao;

public class PrevMaintenanceServiceImpl implements PrevMaintenanceService{
	List<Object[]> objects = null;
	String sus=null;
	
	private PrevMaintenanceDao prevMaintenanceDao;
	
	
	
	public PrevMaintenanceDao getPrevMaintenanceDao() {
		return prevMaintenanceDao;
	}
	public void setPrevMaintenanceDao(PrevMaintenanceDao prevMaintenanceDao) {
		this.prevMaintenanceDao = prevMaintenanceDao;
	}
	public Long checkPrevMaintenance(String fiscalYear){
		Long l = prevMaintenanceDao.checkPrevMaintenance(fiscalYear);
		return l;
	}
	public Long updateCheckPrevMaintenance(String fiscalYear,int fiscalYearId) {
		Long l = prevMaintenanceDao.updateCheckPrevMaintenance(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String savePrevMaintenanceDetails(Object object) {
		try {
			sus = prevMaintenanceDao.savePrevMaintenanceDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchPrevMaintenance() {
		
		try {
			objects = prevMaintenanceDao.searchPrevMaintenance();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<PrevMaintenance> searchPrevMaintenanceWithId(int id) {
		List<PrevMaintenance> list = null;
		try {
			list = prevMaintenanceDao.searchPrevMaintenanceWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updatePrevMaintenance(Object object) {
		try {
			sus = prevMaintenanceDao.updatePrevMaintenance(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deletePrevMaintenance(int id) {
		try {
			sus = prevMaintenanceDao.deletePrevMaintenance(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	
	public List<Object[]> selectEquipment() {
		
		try {
			objects = prevMaintenanceDao.selectEquipment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectMaintenanceCategory() {
		
		try {
			objects = prevMaintenanceDao.selectMaintenanceCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
public List<Object[]> selectMaintenanceType() {
		
		try {
			objects = prevMaintenanceDao.selectMaintenanceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicSearchPrevMaintenance(String label,String operator,String searchName){
		try {
			objects = prevMaintenanceDao.basicSearchPrevMaintenance(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deletePrevMaintenanceDetail(int kk){
		String msg = null;
		try {
			msg = prevMaintenanceDao.deletePrevMaintenanceDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	

}
