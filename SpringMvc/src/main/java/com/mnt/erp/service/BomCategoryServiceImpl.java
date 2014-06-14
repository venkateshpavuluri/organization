package com.mnt.erp.service;

import java.io.Serializable;
import java.util.List;

import com.mnt.erp.dao.BomCategoryDaoImpl;

/**
 * @author Gkiran
 */

public class BomCategoryServiceImpl implements BomCategoryService, Serializable {

	private com.mnt.erp.dao.BomCategoryDaoImpl dao;

	public BomCategoryDaoImpl getDao() {
		return dao;
	}

	public void setDao(BomCategoryDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Object[]> getBomCategory(String bomCategory) {
		List<Object[]> list = dao.setBomCategorySearch(bomCategory);
		return list;
	}

	@Override
	public List<Object[]> getBomId(int id) {
		List<Object[]> list = dao.setBomCategorySearch(id);
		return list;
	}

	@Override
	public String updateBomCategory(Object object) {
		String msg = null;
		try {
			msg = dao.updateBomCategory(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String bomCategoryDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.bomCategoryDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String setBomCategorySave(com.mnt.erp.bean.BomCategory mm) {
		String success = dao.saveBomCategory(mm);
		return success;

	}

	public Long checkDuplicateBomCategory(String name) {
		Long success = dao.checkDuplicateBomCategory(name);
		return success;

	}

	public Long checkDuplicateBomCategoryUpdate(String name, int id) {
		Long success = dao.checkDuplicateBomCategoryUpdate(name, id);
		return success;

	}

	public List<Object[]> basicSearchBomCategory(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {
			objs = dao.basicSearchBomCategory(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}

}
