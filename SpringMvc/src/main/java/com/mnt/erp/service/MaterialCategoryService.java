package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.MaterialCategory;

/**
 * @author Gkiran
 */



public interface MaterialCategoryService {
	public List<Object[]> selectMaterialCategoryDetails();

    public String setMaterialCategorySave(MaterialCategory mm,String userId,String userName);
    public Long checkDuplicateMaterial(String name);
    public Long checkDuplicateMaterialUpdate(String name,int id); 
    public List<Object[]> getMaterialCategory(String materialCategory);
	public List<Object[]> getMaterialId(int id);
	public String updateMaterialCategory(Object object);
	public String materialCategoryDelete(int id);
	public List<Object[]> basicSearchMaterialCategory(String label,
			String operator, String searchName);
}
