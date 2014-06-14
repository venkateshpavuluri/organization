package com.mnt.erp.dao;

import java.util.List;

/**
 * @author ybusireddy
 * @version 20-09-2013
 */
public interface AssetGroupDao {

	public String saveAssetGroupDetails(Object object,String userId,String userName);

	public List<Object[]> searchAssetGroup();

	public List<Object[]> searchAssetGroupWithId(int id);

	public String updateAssetGroup(Object object);

	public String deleteAssetGroup(int id);

	public List<Object[]> selectAssetGroup();

	public int checkAssetGroupType(String type);

	public int updateCheckAssetGroupType(String type, int typeId);
	
	public List<Object[]> basicSearchAssetGroup(String label,String operator,String searchName);

}
