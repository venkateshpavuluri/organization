/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.CapacityCategory;

/**
 * @author anikesh
 *
 */
public interface CapacityCategoryService {
	public String saveCapacityCategoryDetails(Object object,String userId,String userName);
	public Long duplicateCapacityCategoryCheck(String capcategory);
	public List<Object[]> searchCapacityCategory();
	public List<Object[]> basicSearchCapacityCategory(String label,String operator,String searchName);
	public List<Object[]> searchCapacityCategoryWithName(String capcategoryname);
	public List<Object[]> selectCapacityCategoryNames();
	public List<Object[]> searchCapacityCategoryWithId(String capcategoryname);
	public String updateCapacityCategory(Object object);
	public Long updateDuplicateCheck(String capcategory, int capcategoryid);
	public String capcategoryDelete(int id);
}
