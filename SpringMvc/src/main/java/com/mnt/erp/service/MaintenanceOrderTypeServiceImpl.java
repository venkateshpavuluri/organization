package com.mnt.erp.service;


import java.util.List;
import com.mnt.erp.dao.MaintenanceOrderTypeDao;

public class MaintenanceOrderTypeServiceImpl implements MaintenanceOrderTypeService {

	List<Object[]> objects = null;
	String sus=null;
	public MaintenanceOrderTypeDao motDao;
	public MaintenanceOrderTypeDao getMotDao() {
		return motDao;
	}
	public void setMotDao(MaintenanceOrderTypeDao motDao) {
		this.motDao = motDao;
	}
	
	public Long checkMaintenanceOrderType(String maintenanceOrderType) {
		Long l = motDao.checkMaintenanceOrderType(maintenanceOrderType);

		return l;
	}
	public Long updateCheckMaintenanceOrderType(String maintenanceOrderType,int maintenanceOrderTypeId) {
		Long l = motDao.updateCheckMaintenanceOrderType(maintenanceOrderType, maintenanceOrderTypeId);
		return l;
	}
	
	public String saveMaintenanceOrderTypeDetails(Object object) {
		try {
			sus = motDao.saveMaintenanceOrderTypeDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchMaintenanceOrderType() {
		
		try {
			objects = motDao.searchMaintenanceOrderType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchMaintenanceOrderTypeWithId(int id) {
		List<Object[]> list = null;
		try {
			list = motDao.searchMaintenanceOrderTypeWithId(id);
					} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateMaintenanceOrderType(Object object) {
		try {
			sus = motDao.updateMaintenanceOrderType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteMaintenanceOrderType(int id) {
		try {
			sus = motDao.deleteMaintenanceOrderType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectMaintenanceOrderType(){
		
		try {
			objects = motDao.selectMaintenanceOrderType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchMaintenanceOrderType(String label,String operator,String searchName){
		try {
			objects = motDao.basicSearchMaintenanceOrderType(label, operator, searchName);
					} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
}
