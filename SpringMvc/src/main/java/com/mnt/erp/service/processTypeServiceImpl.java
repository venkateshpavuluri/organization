package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.processTypeDao;

public class processTypeServiceImpl implements processTypeService {
	List<Object[]> list = null;
	processTypeDao processDao;
	public processTypeDao getProcessDao() {
		return processDao;
	}
	public void setProcessDao(processTypeDao processDao) {
		this.processDao = processDao;
	}
	public String saveProcessType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = processDao.saveProcessType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkProcessType(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = processDao.checkProcessType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchProcessType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = processDao.searchProcessType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchProcessTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = processDao.searchProcessTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchProcessType(String label,String operator,String searchName){
		try {
			list = processDao.basicSearchProcessType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteProcessType(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = processDao.deleteProcessType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateProcessType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = processDao.updateProcessType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectProcessType() {
		// TODO Auto-generated method stub
		
		try {
			list = processDao.searchProcessType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProcessType(String type, int Id) {
		long count = 0;
		try {
			count = processDao.updateCheckProcessType(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	
}
