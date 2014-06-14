/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0
 *@build 0.0
 */
public interface PurchaseOrderDao 
{
	public String addPurchaseOrder(Object object) ;
	public List<Object[]> basicSearchPO();
	public List<Object> editPOWithId(int cId);
	public List<Object[]> basicSearchPurchase(String label, String operator,
			String searchName); 
	
	public List<Object[]> setPurchaseAdvanceSearch(String purchase);
	public String updatePurchaseOrderDao(Object object);
	public int updateCheckPurchase(String pno, int custId);

	public Long checkPurchase(String pno);
	
	public String deletePurchaseOrderLine(int id); 
	public String deletePurchaseOrder(int id); 
	public List<Object[]> purchaseOrderNumGet(String s);
	public List<Object[]> getStepUser();
	public String saveWorkFlowListDaoDetails(Object object);

	
}
