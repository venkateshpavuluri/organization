/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.StorageLocation;

/**
 * @author pvenkateswarlu
 * @version 1.0 23-09-2013
 */
public interface StorageLocationDao {
	
    public List<Object[]> storageAdvanceSearch(String name);
	
	public List<Object[]> setStorageSearch(String name);
	
	public String saveStoragLocation(Object object,String userId,String userName);

	public List<Object[]> searchStorageLocation();

	public List<StorageLocation> searchStorageWithId(int id);

	public List<Object[]> getStorageIds();

	public String deleteStorageLoc(Object object);

	public String updateStorageLocation(Object object);

	public Long duplicateCheck(String storageLocation);

	public Long updateDuplicateCheck(String storageLocation,int storageLocationId);
	
	public List<Object[]> basicSearchStorageLoc(String label,
			String operator, String searchName);

}
