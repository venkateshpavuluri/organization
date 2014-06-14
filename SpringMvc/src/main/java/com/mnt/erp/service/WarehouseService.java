/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;
/**
 * @author A Nikesh
 *@version 1.0 12-11-2013
 *@build 0.0
 *
 */
public interface WarehouseService {
	public String saveWareHouseDetails(Object object);
	public Long duplicateWareHouseCheck(String warehouse);
	public List<Object[]> selectCountryIds();
	public List<Object[]> searchWareHouse();
	public List<Object[]> basicSearchWareHouse(String label,String operator,String searchName);
	public List<Object[]> getWarehouseAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> selectWareHouseNames();
	public List<Object[]> searchWareHouseWithId(String warehousename);
	public String updateWareHouse(Object object);
	public Long updateDuplicateCheck(String WareHouse, int warehouseid);
	public String WareHouseDelete(int id);
}
