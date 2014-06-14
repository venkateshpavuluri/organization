/**

 *@copyright MNTSOFT  


 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.ClaimDocumentsBean;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.PurchaseReq;

/**
 * @author pvenkateswarlu
 *@version 1.0 11-10-2013
 */
public interface WorkFlowListDao {
	/*==========PurchaseRequisition WorkFlow Methods==================================================*/
	public List<PurchaseReq> getPurchaseReqDetails(String userId);
	public List<Object[]> getpurReqWithStepDetails(String userId,int workListId,String workFlowListId);
	public String updatePurReqWorkFlow(Object object);
	public List<Object[]> displayPurchaseReqLineDetails(int purReqLineId);
	public List<Object[]> getActionAndComments(String stepId,int stepNo);
	/*==========PurchaseOrder WorkFlow Methods==================================================*/
	public List<Object[]> getPurchaseOrderDetails(String userId);
	public List<Object[]> getpurOrderWithStepDetails(String userId,
			int workListId, String workFlowListId);
	public List<Object[]> getpurOredrActionAndComments(String stepId, int stepNo);
	public List<Object[]> displayPurchaseOrderLineDetails(
			int purOrderLineId);
	public String updatePurOrderWorkFlow(Object object,String userId);
	public List<Object[]> getStepUser();
	public String saveWorkFlowListDaoDetails(Object object);
	
	//Vocher WorkFlow Methods
	public List<Object[]> getVoucherDetails(String userId);
	public List<Object[]> getVoucherWithStepDetails(String userId,
			int voucherId, String workFlowListId);
	public String updatevoucherWorkFlow(Object object, String userId);
	
	/*SalesOrder workflow*/	
	
	public List<Object[]> getSalesOrderDetails(String userId);
	public List<Object[]> getSalesOrderWithStepDetails(String userId,
			int voucherId, String workFlowListId);
	public List<Object[]> displaySalesOrderLineDetails(int salesOrderLineId);
	public String updateSalesOrderWorkFlow(Object object,String userId);
	/*EmployeeLeave WorkFlow*/
	public List<Object[]> getEmployeeLeaveDetails(String userId);
	public List<Object[]> getEmployeeLeaveWithStepDetails(String userId,int employeeId, String workFlowListId);
	public String updateEmployeeLeaveWorkFlow(Object object,String userId);
	
	/*Claim WorkFlow*/
	public List<Object[]> getClaimDetails(String userId);
	public List<Object[]> getClaimWithStepDetails(String userId,int employeeId, String workFlowListId);
	public List<String> getClaimDocDetails(int claimId);
	public String updateClaimWorkFlow(Object object,String userId);
	
}
