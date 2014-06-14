/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.StorageLocation;

/**
 * @author pvenkateswarlu
 * @version 1.0 23-09-2013
 */

public interface StorageLocationService {

	public List<Object[]> getStorageAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> getStorage(String storage);
	
	public String saveStoragLocation(Object object,String userId,String userName);

	public List<StorageLocation> searchStorageLocation();

	public List<StorageLocation> searchStorageWithId(int id);

	public List<Object[]> getStorageIds();

	public String deleteStorageLoc(Object objec);

	public String updateStorageLocation(Object object);

	public Long duplicateCheck(String storageLocation);

	public Long updateDuplicateCheck(String storageLocation,
			int storageLocationId);
	public List<StorageLocation> basicSearchStorageLoc(String label,
			String operator, String searchName);
}
