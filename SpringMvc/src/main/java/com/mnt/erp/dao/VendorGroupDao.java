
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.util.List;

/**
 * This is VendorGroup Dao interface.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface VendorGroupDao {

	public String saveVendorGroup(Object object,String userId,String userName);
	
	public List<Object[]> searchVendorGroup(int id);
	
	public List<Object[]> editVendorGroupWithId(int id);
	
	public String updateVendorGroup(Object object);
	
	public String vendorGroupDelete(int id);
	
	public int vendorDuplicate(String vendorGroupCheck,String vendorGroupCodeCheck);
	
	public int vendorEditDuplicate(String vendorGroupCheck,String vendorGroupCodeCheck,int id);
	public List<Object[]> getVendorGroupIds();
	
	public List<Object[]> basicSearchVendorGroup(String label,String operator,String searchName);
	
}
