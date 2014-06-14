/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;
/**
 * @author Naresh
 * @version 1.0 18-09-2013
 */
public interface AssertTypeService {
	
	public Long updateCheckAssetType(String assetType,int assetId);

	public Long checkAssetTypeCout(String assetType);
	
	public String saveAssertTypeDetails(Object object,String userId,String userName);

	public List<Object[]> searchAssertType();

	public List<Object[]> searchAssertTypeWithId(int id);

	public String updateAssertType(Object object);

	public String deleteAssertType(int id);
	
	public List<Object[]> selectAssetType();
	
	public List<Object[]> basicSearchAssertType(String label,String operator,String searchName);

}
