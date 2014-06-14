package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.maintenanceTypeDao;

public class maintenanceTypeServiceImpl implements maintenanceTypeService{
	List<Object[]> list = null;
	maintenanceTypeDao mdao;
	public maintenanceTypeDao getMdao() {
		return mdao;
	}
	public void setMdao(maintenanceTypeDao mdao) {
		this.mdao = mdao;
	}
	
	public String saveMaintenanceType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = mdao.saveMaintenanceType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkMaintenanceType(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = mdao.checkMaintenanceType(type);
			} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchMaintenanceType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = mdao.searchMaintenanceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchMaintenanceTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = mdao.searchMaintenanceTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchMaintenanceType(String label,String operator,String searchName){
		try {
			list = mdao.basicSearchMaintenanceType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteMaintenanceType(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = mdao.deleteMaintenanceType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateMaintenanceType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = mdao.updateMaintenanceType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectMaintenanceType() {
		// TODO Auto-generated method stub
		
		try {
			list = mdao.searchMaintenanceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckMaintenanceType(String type, int Id) {
		long count = 0;
		try {
			count = mdao.updateCheckMaintenanceType(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	
}
