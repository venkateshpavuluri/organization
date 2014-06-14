/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.util.List;

/**
 * This is Uom Dao interface.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface UomDao {

	public String saveUomDetails(Object object,String userId,String userName);

	public List<Object[]> searchUom(int id);

	public List<Object[]> editUomWithId(int id);

	public String updateUom(Object object);

	public String uomDelete(int id);

	public int uomDuplicate(String uomCheck, String uomCodeCheck);

	public int uomEditDuplicate(String uom, String uomCode, int id);

	public List<Object[]> selectUomDetails();

	public List<Object[]> uomIdGet();
	
	public List<Object[]> basicSearchUOM(String label,String operator,String searchName);
}
