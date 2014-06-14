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
public interface StorageTypeService {
	
	public String saveStorageTypeDetails(Object object,String userId,String userName);
	public Long duplicateStorageTypeCheck(String storagetype);
	public List<Object[]> searchStorageType();
	public List<Object[]> searchStorageTypeWithName(String storagetypename);
	public List<Object[]> selectStorageTypeNames();
	public List<Object[]> searchStorageTypeWithId(String storagetypename);
	public String updateStorageType(Object object);
	public Long updateDuplicateCheck(String storagetype, int storagetypeid);
	public String storagetypeDelete(int id);
	public List<Object[]> basicSearchStorageType(String label,String operator,String searchName);

}
