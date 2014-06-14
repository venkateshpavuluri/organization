/**
 @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.PurchaseGroup;

/**
 * @author Sailaja
 * @version 1.0 26-10-2013
 * @build 0.0
 *
 */
public interface PurchaseGroupDao
{
	public String addPurchaseGroup(Object object);
	public List<Object[]> searchPurchaseGroup();
	public List<PurchaseGroup> searchPurchaseGroupWithId(int id);
	public String updatePurchaseGroup(Object object);
	public String deletePurchaseGroup(int id);
	public int checkDuplicate(String checkPurchaseGroup);
	public int checkEditDuplicate(String checkPurchaseGroup,int id);
	public List<Object[]> basicSearchPurchaseGroup(String label,String operator,String searchName);
}
