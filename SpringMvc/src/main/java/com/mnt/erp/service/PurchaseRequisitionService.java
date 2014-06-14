/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface PurchaseRequisitionService {

	public String savePurchaseRequisitionDetails(Object object);

	public List<Object[]> searchPurchaseReq();

	public List<Object> editPurchaseReqWithId(int prid);

	public String updatePurchaseRequisition(Object object);

	public String deletePurchaseRequisition(int id);

	public int purchaseRequisitionDuplicate(String purReqNo);

	public int purchaseRquisitionEditDuplicate(String purReqNo, int id);

	public List<Object[]> basicSearchPurchaseReq(String label, String operator,
			String searchName);
	
	public String deletePuchseRequisitionLine(int kk);
	
	public List<Object[]> setPurchaseRequisitionAdvanceSearch(String name);
   
	public List<Object[]> getPurchaseRequisitionAdvance(String columns,String opeator,String advanceSearchText);
	
	 public List<Object[]> populateStorLocIds(int plantId);
	    
	public List<Object[]> selectPlantIds(int orgId);
	
	 public List<Object[]> getStepUser();
}
