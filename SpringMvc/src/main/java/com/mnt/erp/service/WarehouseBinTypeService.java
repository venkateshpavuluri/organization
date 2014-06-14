/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public interface WarehouseBinTypeService {
	public String saveWarehouseBinTypeDetails(Object object);
	public Long duplicateWarehouseBinTypeCheck(String warehousebintype);
	public List<Object[]> searchWarehouseBinType();
	public List<Object[]> searchWarehouseBinTypeWithName(String warehousebintypename);
	public List<Object[]> selectWarehouseBinTypeNames();
	public List<Object[]> searchWarehouseBinTypeWithId(String warehousebintypename);
	public String updateWarehouseBinType(Object object);
	public Long updateDuplicateCheck(String warehousebintype, int warehousebintypeid);
	public String warehousebintypeDelete(int id);
	
	public List<Object[]> basicSearchWarehouseBinType(String label,String operator,String searchName);
}
