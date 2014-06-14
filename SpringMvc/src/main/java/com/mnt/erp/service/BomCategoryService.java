package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.bean.BomCategory;
import com.mnt.erp.bean.MaterialCategory;

/**
 * @author Gkiran
 */



public interface BomCategoryService {
	public String setBomCategorySave(BomCategory mm);
	
	public List<Object[]> getBomCategory(String bomCategory);
	public List<Object[]> getBomId(int id);
	public String updateBomCategory(Object object);
	public String bomCategoryDelete(int id);
	public Long checkDuplicateBomCategory(String name);
	public Long checkDuplicateBomCategoryUpdate(String name,int id);
	public List<Object[]> basicSearchBomCategory(String label, String operator,
			String searchName);
		
}
