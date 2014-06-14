/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.util.List;
/**
 * @author pvenkateswarlu
 * @version 1.0 28-10-2013
 */
public interface StockCategoryDao {
	public String saveStockCategory(Object object,String userId,String userName);
	public Long getStockCategoryDuplicateCount(String name);
	public List<Object[]> searchStockCategoryWithId(int id);
	public List<Object[]> searchStockCategory();
	public List<Object[]> selectStockCategory();
	public String updateStockCategory(Object object);
	public String deleteStockCategory(int id);
	public Long getStockCategoryCountedit(String name,int verificationtypeid);
	public List<Object[]> basicSearchStockCategory(String label,String operator,String searchName);
}
