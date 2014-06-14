/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 *
 */
public interface PurchaseOrderService
{
	public String addPurchaseOrder(Object object) ;
	public List<Object[]> basicSearchPO();
	public List<Object[]> basicSearchPurchase(String label, String operator,
			String searchName);
	public List<Object> editPOWithId(int id);
	public List<Object[]> getPurchaseAdvance(String columns,String opeator,String advanceSearchText);
	public String updatePurchaseOrder(Object object);
	public int updateCheckPurchase(String pno, int custId);

	public Long checkPurchase(String pno);
	public String deletePurchaseOrder(int id);
	public String deletePurchaseOrderLine(int id);
	public List<Object[]> purchaseOrderNumGet(String s);
	public String saveWorkFlowListDaoDetails(Object object);
	public List<Object[]> getStepUser();
}
