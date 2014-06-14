package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ValuationCategoryDao;

public class ValuationCategoryServiceImpl implements ValuationCategoryService {

	ValuationCategoryDao dao;
	List<Object[]> objects;

	public ValuationCategoryDao getDao() {
		return dao;
	}

	public void setDao(ValuationCategoryDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveValuationCategoryDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String vc = null;
		try {
			vc = dao.saveValuationCategoryDetails(object, userId, userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vc;
	}

	@Override
	public List<Object[]> searchValuationCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchValuationCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchValuationCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchValuationCategoryWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateValuationCategory(Object object) {
		// TODO Auto-generated method stub
		String vc = null;
		try {
			vc = dao.updateValuationCategory(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vc;
	}

	@Override
	public String deleteValuationCategory(int id) {
		// TODO Auto-generated method stub
		String vc = null;
		try {
			vc = dao.deleteValuationCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vc;
	}

	@Override
	public List<Object[]> selectValuationCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.selectValuationCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkValuationCategory(String type) {
		// TODO Auto-generated method stub
		int vc = 0;
		try {
			vc = dao.checkValuationCategory(type);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vc;
	}

	public int updateCheckValuationCategory(String value, int valueId) {
		int vc = 0;
		try {
			vc = dao.updateCheckValuationCategory(value, valueId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vc;
	}

	@Override
	public List<Object[]> basicSearchValuationCategory(String label,
			String operator, String searchName) {
		try {
			objects = dao.basicSearchValuationCategory(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

}
