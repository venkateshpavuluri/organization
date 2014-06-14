package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EquipmentCategoryDao;

public class EquipmentCategoryServiceImpl implements EquipmentCategoryService {

	EquipmentCategoryDao dao;

	public EquipmentCategoryDao getDao() {
		return dao;
	}

	public void setDao(EquipmentCategoryDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveEquipmentCategoryDetails(Object object) {
		// TODO Auto-generated method stub

		String ec = null;
		try {
			ec = dao.saveEquipmentCategoryDetails(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ec;
	}

	@Override
	public List<Object[]> searchEquipmentCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchEquipmentCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchEquipmentCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchEquipmentCategoryWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateEquipmentCategory(Object object) {
		// TODO Auto-generated method stub
		String ec = null;
		try {
			ec = dao.updateEquipmentCategory(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ec;
	}

	@Override
	public String deleteEquipmentCategory(int id) {
		// TODO Auto-generated method stub
		String ec = null;
		try {
			ec = dao.deleteEquipmentCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ec;
	}

	@Override
	public List<Object[]> selectEquipmentCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.selectEquipmentCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public long checkEquipmentCategory(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = dao.checkEquipmentCategory(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public long updateCheckEquipmentCategory(String type, int eqpId) {
		long count = 0;
		try {
			count = dao.updateCheckEquipmentCategory(type, eqpId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public List<Object[]> basicSearchEquipment(String label, String operator,
			String searchName){
		List<Object[]> list = null;
		try {
			list = dao.basicSearchEquipment(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
