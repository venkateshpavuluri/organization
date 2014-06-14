/**
@copyright MNT SOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author sailajach
 * @version 1.0 05-02-2014
 * @build 0.0
 *
 */
public interface ProductionOrderProcessService {
	public List<Object[]> getProductionOrderNo();
	public List<Object[]> getWorkCenterName();
	public List<Object[]> getProcessDetail();
	
	public String addProductionOrderProcess(Object obj);
	public List<Object[]> searchProductionOrderProcess();
	public List<Object> editProductionOrderProcessWithId(int popid);
	public String updateProductionOrderProcess(Object object);
    public String deleteProductionOrderProcess(int id);
    public String deleteProductionOrderProcessChild(int pLineId);
    public int checkDuplicate(String checkProductionOrderNo);
   	public int checkEditDuplicate(String checkProductionOrderNo,String id1);
    
	public List<Object[]> basicSearchProductionOrderProcess(String label, String operator,String searchName);

}
