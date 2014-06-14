/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

/**
 * This is Uom Service Interface.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface UomService {

	public String saveUomDetails(Object object,String userId,String userName);

	public List<Object[]> searchUom(int id);

	public List<Object[]> editUomWithId(int id);

	public String updateUom(Object object);

	public String deleteUom(int id);

	public int uomDuplicate(String uomCheck, String uomCodeCheck);

	public int uomEditDuplicate(String uom, String uomCode, int id);

	public List<Object[]> selectUomDetails();

	public List<Object[]> uomIdGet();
	
	public List<Object[]> basicSearchUOM(String label,String operator,String searchName);
}
