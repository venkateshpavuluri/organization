package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.BomCategory;
import com.mnt.erp.bean.MaterialCategory;

/**
 * @author Gkiran
 */


public interface BomCategoryDao {
	
public String saveBomCategory(BomCategory mm);
public List<Object[]> setBomCategorySearch(String name);
public List<Object[]> setBomCategorySearch(int id);
public String updateBomCategory(Object object);
public String bomCategoryDelete(int id);
public Long checkDuplicateBomCategory(String name);
public List<Object[]> basicSearchBomCategory(String label,String operator,String searchName);


}
