/**

 *@copyright MNTSOFT  


 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ClaimBean;
import com.mnt.erp.bean.ClaimDocumentsBean;
import com.mnt.erp.bean.EmployeeLeave;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.PurchaseOrderLine;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.SalesOrderLineBean;
import com.mnt.erp.bean.Voucher;
/**
 * @author pvenkateswarlu
 *@version 1.0 11-10-2013
 */
public interface WorkFlowListService {
	
	/*==========PurchaseRequisition WorkFlow Methods==================================================*/
	
	public List<PurchaseReq> getPurchaseReqDetails(String userId);
	public List<Object[]> getpurReqWithStepDetails(String userId,int workListId,String workFlowListId);
	public String updatePurReqWorkFlow(Object object,String userId);
	public List<PurchaseReq> displayPurchaseReqLineDetails(int purReqLineId);
	public List<Object[]> getActionAndComments(String stepId,int stepNo);
	
	/*==========PurchaseOrder WorkFlow Methods==================================================*/
	public List<PurchaseOrder> getPurchaseOrderDetails(String userId);
	public List<Object[]> getpurOrderWithStepDetails(String userId,int workListId,String workFlowListId);
	public List<Object[]> getpurOredrActionAndComments(String stepId,int stepNo);
	public List<PurchaseOrderLine> displayPurchaseOrderLineDetails(int purOrderLineId);
	public String updatePurOrderWorkFlow(Object object,String userId);
	public List<Object[]> getStepUser();
	public String saveWorkFlowListDaoDetails(Object object);
	//Vocher WorkFlow Methods
		public List<Voucher> getVoucherDetails(String userId);
		public List<Object[]> getVoucherWithStepDetails(String userId,
				int voucherId, String workFlowListId);
		public String updatevoucherWorkFlow(Object object,String userId);
		//SalesOreder workFlow
		public List<SalesOrderBean> getSalesOrderDetails(String userId);
		public List<Object[]> getSalesOrderWithStepDetails(String userId,int workListId,String workFlowListId);
		public List<SalesOrderLineBean> displaySalesOrderLineDetails(int salesOrderLineId);
		public String updateSalesOrderWorkFlow(Object object, String userId);
		
		//Employee Leave workFlow
		public List<EmployeeLeave> getEmployeeLeaveDetails(String userId);
		public List<Object[]> getEmployeeLeaveWithStepDetails(String userId,int workListId,String workFlowListId);
		public String updateEmployeeLeaveWorkFlow(Object object, String userId);
	
		//Claim workFlow
		public List<ClaimBean> getClaimDetails(String userId);
		public List<Object[]> getClaimWithStepDetails(String userId,int workListId,String workFlowListId);
		public String updateClaimWorkFlow(Object object, String userId);
		public List<String> getClaimDocDetails(int claimId);
}
