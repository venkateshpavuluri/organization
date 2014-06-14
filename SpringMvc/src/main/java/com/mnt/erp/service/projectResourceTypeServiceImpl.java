package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.projectResourceTypeDao;

public class projectResourceTypeServiceImpl implements projectResourceTypeService{
	projectResourceTypeDao prtDao;
	List<Object[]> list = null;
	public projectResourceTypeDao getPrtDao() {
		return prtDao;
	}

	public void setPrtDao(projectResourceTypeDao prtDao) {
		this.prtDao = prtDao;
	}
	
	public String saveProjectResourceType(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = prtDao.saveProjectResourceType(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkProjectResourceType(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = prtDao.checkProjectResourceType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchProjectResourceType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = prtDao.searchProjectResourceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchProjectResourceTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = prtDao.searchProjectResourceTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchProjectResourceType(String label,String operator,String searchName){
		try {
			list = prtDao.basicSearchProjectResourceType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteProjectResourceType(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = prtDao.deleteProjectResourceType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateProjectResourceType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = prtDao.updateProjectResourceType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectProjectResourceType() {
		// TODO Auto-generated method stub
		
		try {
			list =prtDao.searchProjectResourceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProjectResourceType(String type, int Id) {
		long count = 0;
		try {
			count = prtDao.updateCheckProjectResourceType(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}


}
