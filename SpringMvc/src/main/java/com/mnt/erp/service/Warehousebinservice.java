package com.mnt.erp.service;

import java.util.List;

public interface Warehousebinservice {
	public String saveWareHouseBin(Object object,String userId,String userName);
	public List<Object[]> searchWareHouseBinWithId(int id);
	public List<Object[]> searchWareHouseBin();
	public List<Object[]> selectWareHouseBinIds();
	public List<Object[]>selectstoragetype();
	public List<Object[]>selectWareHouseBinTypeIds();
	public List<Object[]>selectStorageSectionIds();
	public String updateWareHouseBin(Object object);
	public String deleteWareHouseBin(int id);
	public Long getWareHouseBinCount(String name);
	public Long geWareHouseBinedit(String name, int accountgroupid);
	public List<Object[]> basicSearchWareHouseBin(String label, String operator,
			String searchName);
}
