package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Gkiran
 */

public interface MaterialCategory {
	public List<Object[]> selectMaterialCategoryDetails();

	public String setMaterialCategory(com.mnt.erp.bean.MaterialCategory mm,String userId,String userName);

	public List<Object[]> setMaterialCategorySearch(String name);

	public List<Object[]> setMaterialCategorySearch(int id);

	public String updateMaterialCategory(Object object);

	public String materialCategoryDelete(int id);

	public Long checkDuplicateMaterial(String name);

	public Long checkDuplicateMaterialUpdate(String name, int id);

	public List<Object[]> basicSearchMaterialCategory(String label,
			String operator, String searchName);

}
