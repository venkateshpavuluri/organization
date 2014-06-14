package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.MaterialCategory;

/**
 * @author Gkiran
 */

public class MaterialCategoryServiceImpl implements MaterialCategoryService {
	public MaterialCategory dao;

	public MaterialCategory getDao() {
		return dao;
	}

	public void setDao(MaterialCategory dao) {
		this.dao = dao;
	}

	List<Object[]> list = null;

	@Override
	public List<Object[]> selectMaterialCategoryDetails() {
		// TODO Auto-generated method stub
		try {
			list = dao.selectMaterialCategoryDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getMaterialCategory(String materialCategory) {
		try {

			list = dao.setMaterialCategorySearch(materialCategory);
		} catch (Exception e) {
			list = null;
			e.printStackTrace();

		}

		return list;
	}

	@Override
	public List<Object[]> getMaterialId(int id) {
		List<Object[]> list = dao.setMaterialCategorySearch(id);
		return list;
	}

	@Override
	public String updateMaterialCategory(Object object) {
		String msg = null;
		try {
			msg = dao.updateMaterialCategory(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String materialCategoryDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.materialCategoryDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String setMaterialCategorySave(com.mnt.erp.bean.MaterialCategory mm,
			String userId, String userName) {
		String success = dao.setMaterialCategory(mm, userId, userName);
		return success;

	}

	@Override
	public Long checkDuplicateMaterial(String name) {
		Long success = dao.checkDuplicateMaterial(name);
		return success;

	}

	@Override
	public Long checkDuplicateMaterialUpdate(String name, int id) {
		Long success = dao.checkDuplicateMaterialUpdate(name, id);
		return success;

	}

	public List<Object[]> basicSearchMaterialCategory(String label,
			String operator, String searchName) {
		try {
			list = dao.basicSearchMaterialCategory(label, operator, searchName);
		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

}
