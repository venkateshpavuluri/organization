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
public interface BillingTypeService {
	public String saveBillingTypeDetails(Object object);
	public Long duplicateBillingTypeCheck(String billingtype);
	public List<Object[]> searchBillingType();
	public List<Object[]> searchBillingTypeWithName(String billingtypename);
	public List<Object[]> selectBillingTypeNames();
	public List<Object[]> searchBillingTypeWithId(String billingtypename);
	public String updateBillingType(Object object);
	public Long updateDuplicateCheck(String billingtype, int billingtypeid);
	public String billingtypeDelete(int id);
	
	public List<Object[]> basicSearchBillingType(String label,String operator,String searchName);

}
