
/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.StockCategory;
/**
 * @author pvenkateswarlu
 * @version 1.0 28-10-2013
 */
public interface StockCategoryService {
	public String saveStockCategory(Object object,String userId,String userName);
	public Long getStockCategoryDuplicateCount(String name);
	public List<StockCategory> searchStockCategoryWithId(int id);
	public List<StockCategory> searchStockCategory();
	public List<Object[]> selectStockCategory();
	public String updateStockCategory(Object object);
	public String deleteStockCategory(int id);
	public Long getStockCategoryCountedit(String name,int verificationtypeid);
	public List<StockCategory> basicSearchStockCategory(String label,String operator,String searchName);
}
