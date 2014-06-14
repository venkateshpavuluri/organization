package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.InspectionTypeDao;

public class InspectionTypeServiceImpl implements InspectionTypeService {

	InspectionTypeDao dao;
	List<Object[]> list = null;
	public InspectionTypeDao getDao() {
		return dao;
	}

	public void setDao(InspectionTypeDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveInspectionTypeDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = dao.saveInspectionTypeDetails(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}

	@Override
	public List<Object[]> searchInspectionType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchInspectionType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchInspectionTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchInspectionTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateInspectionType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = dao.updateInspectionType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}

	@Override
	public String deleteInspectionType(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = dao.deleteInspectionType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}

	@Override
	public List<Object[]> selectInspectionType() {
		// TODO Auto-generated method stub
		
		try {
			list = dao.selectInspectionType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public long checkInspectionType(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = dao.checkInspectionType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public long updateCheckInspectionType(String type, int Id) {
		long count = 0;
		try {
			count = dao.updateCheckInspectionType(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	public List<Object[]> basicSearchInspectionType(String label,String operator,String searchName){
		try {
			list = dao.basicSearchInspectionType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
