/**

 *@copyright MNTSOFT  

 */
package com.mnt.erp.dao;

/**

 *@copyright MNTSOFT  


 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ClaimBean;
import com.mnt.erp.bean.ClaimDocumentsBean;
import com.mnt.erp.bean.EmployeeLeave;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.Voucher;

import com.mnt.erp.bean.WorkFlowList;

/**
 * @author pvenkateswarlu
 *@version 1.0 11-10-2013
 */
public class WorkFlowListDaoImpl extends HibernateDaoSupport implements WorkFlowListDao  {

	public static Logger logger=Logger.getLogger(WorkFlowListDaoImpl.class);
	
	
	String sql=null;
	List<Object[]> list=null;
	
	@Override
	public List<PurchaseReq> getPurchaseReqDetails(String userId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		String sql=null;
		List<PurchaseReq> listpr=null;
		PurchaseReq req=null;
		try
		                                                  
		{//w.purchaseReql,
			sql="select w.workFlowListId,w.step,w.workListId from WorkFlowList w where w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='PR'";
			listpr=new ArrayList<PurchaseReq>();
			list=getHibernateTemplate().find(sql);
		Iterator<Object[]> iterator=list.iterator();
		while(iterator.hasNext())
		{
			
			Object[] objects=(Object[])iterator.next();
			String workflowid=(String)objects[0];
			String step=(String)objects[1];
			
			String workid=(String)objects[2];
			
			String sql1="from PurchaseReq p where p.purchaseReqNo='"+workid+"'";
			List<PurchaseReq> list2=getHibernateTemplate().find(sql1);
	
			Iterator<PurchaseReq> iterator2=list2.iterator();
			while(iterator2.hasNext())
			{
				req=new PurchaseReq();
				PurchaseReq purchaseReq=(PurchaseReq)iterator2.next();
				purchaseReq.setWorkFlowListId(workflowid);
				purchaseReq.setStepId(step);
				purchaseReq.setOrgName(purchaseReq.getOrganization().getOrgName());
				purchaseReq.setStatus(purchaseReq.getStatusDetails().getStatus());
				listpr.add(purchaseReq);
			}
			
		}
		
			
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listpr;
	}

	@Override
	public List<Object[]> getpurReqWithStepDetails(String userId,int workListId,String workFlowListId) {
		List<Object[]> list=null;
		String sql=null;
		try
		                                                      //,p.statusDetaial,p.organization
		{//and p.purchaseReq_Id="+workListId+" 

			sql="select  p.purchaseReq_Id,p.purchaseReqNo,p.requestedBy,p.requestedDate,p.reqDate,p.description,p.refNo,p.organization,p.statusDetails,w.wfActionDetails,w.workFlowListId,w.actionComments,w.step  from WorkFlowList w,PurchaseReq p where w.workListId=p.purchaseReqNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='PR' and w.workFlowListId='"+workFlowListId+"'";
			list=getHibernateTemplate().find(sql);
		
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public String updatePurReqWorkFlow(Object object) {
		// TODO Auto-generated method stub
		WorkFlowList workFlowList=null;
		String msg=null;
	
		try
		{
			workFlowList=(WorkFlowList)object;
			
getHibernateTemplate().findByNamedQueryAndNamedParam("workflow",new String[]{"WorkflowlistId","LoggedUserId","ActionComments","ActionType","ActionCode","Signature","RetVal"}, new Object[]{workFlowList.getWorkFlowListId(),workFlowList.getActionBy(),workFlowList.getActionComments(),workFlowList.getActionType(),workFlowList.getActionCode(),null,1});
			msg="WorkFlow Details Updated Successfully";
			
		}
		catch(Exception e)
		{
	
			e.printStackTrace();
		}
		return msg;
	}


	@Override
	public List<Object[]> displayPurchaseReqLineDetails(int purReqLineId) {
		// TODO Auto-generated method stub
		String sql=null;
		List<Object[]> objects=null;
		try
		{
			sql="select p.purchaseReqLine_Id,p.qty,p.requiredDate,p.material.materialName,p.uomDetails.uom,p.statusDetails.status,p.plantDetails.plantName,p.storageLocationDetails.storageLocation from PurchaseReqLine p where p.purchaseReqId="+purReqLineId+"";
			objects=getHibernateTemplate().find(sql);

		}
		catch(Exception e)
		{
			e.printStackTrace();	
			
		}
		return objects;
	}


	@Override
	public List<Object[]> getActionAndComments(String stepId, int stepNo) {
		// TODO Auto-generated method stub
		List<Object[]>  list=null;
		try
		{
		list= getHibernateTemplate().findByNamedQueryAndNamedParam("getActionComments",new String[]{"CurrentStepId","CurrentStep"},new Object[]{stepId,stepNo});
		}
			
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getPurchaseOrderDetails(String userId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		String sql=null;
		try
		                                                  
		{
			sql="select p.purchaseOrderId,p.purchaseOrderNo,p.purchaseOrderDate,p.paymentTerms,p.memo,p.purchaseOrderValue,p.description,p.vendorDetails,p.satatusDetails,w.workFlowListId,w.step from WorkFlowList w ,PurchaseOrder p where w.workListId=p.purchaseOrderNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='PO'";		
			list=getHibernateTemplate().find(sql);	
	
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getpurOrderWithStepDetails(String userId,
			int workListId, String workFlowListId) {
		// TODO Auto-generated method stub
		String sql=null;
		List<Object[]> list=null;
		try
		{
			sql="select  p.purchaseOrderId,p.purchaseOrderNo,p.purchaseOrderDate,p.paymentTerms,p.memo,p.purchaseOrderValue,p.description,p.vendorDetails,p.satatusDetails,w.wfActionDetails,w.workFlowListId,w.actionComments,w.step from WorkFlowList w ,PurchaseOrder p where p.purchaseOrderId="+workListId+" and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='PO'and w.workFlowListId='"+workFlowListId+"'";
			list=getHibernateTemplate().find(sql);
			logger.info("with in dao=="+list); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getpurOredrActionAndComments(String stepId, int stepNo) {
		// TODO Auto-generated method stub
		List<Object[]>  list=null;
		try
		{
			
		list= getHibernateTemplate().findByNamedQueryAndNamedParam("getActionComments",new String[]{"CurrentStepId","CurrentStep"},new Object[]{stepId,stepNo});
		}
			
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> displayPurchaseOrderLineDetails(
			int purOrderLineId) {
		String sql=null;
		List<Object[]> objects=null;
		try
		{
			
			sql="select purchaseOrderId,p.unitPrice,p.materialDetails.materialName,p.uomDetails.uom,p.quantity,p.lineAmt,p.dueDate from PurchaseOrderLine p where p.purchaseOrderId="+purOrderLineId+"";
			objects=getHibernateTemplate().find(sql);
			

		}
		catch(Exception e)
		{
			e.printStackTrace();	//
			
		}
		return objects;
	}

	@Override
	public String updatePurOrderWorkFlow(Object object,String userId) {
		// TODO Auto-generated method stub
		PurchaseOrder purchaseOrder=null;
		String msg=null;
		try
		{
			purchaseOrder=(PurchaseOrder)object;
			getHibernateTemplate().findByNamedQueryAndNamedParam("workflow",new String[]{"WorkflowlistId","LoggedUserId","ActionComments","ActionType","ActionCode","Signature","RetVal"}, new Object[]{purchaseOrder.getWorkFlowListId() ,userId,purchaseOrder.getComments(),"PO",purchaseOrder.getActionNames(),null,1});
			msg="WorkFlow Details Updated Successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	
	
	String msg;
	public String saveWorkFlowListDaoDetails(Object object){
		
	
			try
			{
				WorkFlowList wf=(WorkFlowList)object;
				getHibernateTemplate().save(object);
				msg ="WorkFlowList Saved Successfully";
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
            return msg;
		}
	
	
	
	public List<Object[]> getStepUser(){
		List<Object[]> list=null;
		String sql=null;
		try
		                                                      //,p.statusDetaial,p.organization
		{
			
		
			//sql="select p.purchaseReqNo,p.requestedBy,p.requestedDate,p.requiredDate,p.description,p.refNo from PurchaseReq p";
			sql="select w.wfstepid,u.userId from UserRoles u, WFStep w where u.roleId= w.wfstepAssignedTo and w.wfstepStep=1"; 
		
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	
	
	//Here We get the voucher Details based on workflowlistId 
	public List<Object[]> getVoucherDetails(String userId) {
		// TODO Auto-generated method stub
		String sql=null;
		List<Object[]> list=null; //,p.voucherTypeIdDetails,p.satatusDetails
		try
		{
			logger.info("user Id iss=="+userId);
			sql="select p.voucherId,p.voucherDT,p.employeeId,p.amount,p.voucherNo,p.voucherTypeIdDetails,p.statusDetails,w.workFlowListId,w.step from WorkFlowList w,com.mnt.erp.bean.Voucher p where w.workListId=p.voucherNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='VO'";		
			list=getHibernateTemplate().find(sql);	
			logger.info("voucher size in dao iss=="+list.size());
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getVoucherWithStepDetails(String userId,
			int voucherId, String workFlowListId) {
		// TODO Auto-generated method stub
		
		try
		{
			sql="select  p.voucherId,p.voucherDT,p.employeeId,p.amount,p.voucherNo,p.voucherTypeIdDetails,p.statusDetails,w.wfActionDetails,w.workFlowListId,w.step from WorkFlowList w ,com.mnt.erp.bean.Voucher p where p.voucherId="+voucherId+" and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='VO'and w.workFlowListId='"+workFlowListId+"'";		
			list=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public String updatevoucherWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		Voucher voucher=null;
		String msg=null;
		try
		{
			voucher=(Voucher)object;
			
			getHibernateTemplate().findByNamedQueryAndNamedParam("workflow",new String[]{"WorkflowlistId","LoggedUserId","ActionComments","ActionType","ActionCode","Signature","RetVal"}, new Object[]{voucher.getWorkFlowListId() ,userId,voucher.getComments(),"VO",voucher.getActionNames(),voucher.getSignature(),1});
			msg="WorkFlow Details Updated Successfully";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<Object[]> getSalesOrderDetails(String userId) {
		// TODO Auto-generated method stub
		try
		{
			sql="select p.salesOrderId,p.orderType,p.paymentTerm,p.salesGroup,p.uomBean,p.salesOrderNo,p.status,p.custPONumber,p.salesOrderDate,p.custPODate,p.netWeight,p.totalWeight,p.totalVolume,p.orderReason,p.priority,p.unloadingPoint,p.route,w.workFlowListId,w.step from WorkFlowList w,com.mnt.erp.bean.SalesOrderBean p where w.workListId=p.salesOrderNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='SO'";		
			list=getHibernateTemplate().find(sql);	
			logger.info("salesOrder list size iss==="+list.size());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Object[]> getSalesOrderWithStepDetails(String userId,
			int workListId, String workFlowListId) {
		List<Object[]> list=null;
		try {
			// TODO Auto-generated method stub
			sql="select p.salesOrderId,p.orderType,p.paymentTerm,p.salesGroup,p.uomBean,p.salesOrderNo,p.status,p.custPONumber,p.salesOrderDate,p.custPODate,p.netWeight,p.totalWeight,p.totalVolume,p.orderReason,p.priority,p.unloadingPoint,p.route,w.workFlowListId,w.step,w.wfActionDetails from WorkFlowList w,com.mnt.erp.bean.SalesOrderBean p where w.workListId=p.salesOrderNo and p.salesOrderId="+workListId+" and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='SO' and  w.workFlowListId='"+workFlowListId+"'";	
			list = getHibernateTemplate().find(sql);
			logger.info("with in dao==" + list.size());
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Object[]> displaySalesOrderLineDetails(int salesOrderLineId) {
		// TODO Auto-generated method stub
		try
		{
			sql=" select s.salesOrderLineId,s.material,s.quantity,s.uom,s.currency,s.custMaterailNo,s.netPrice,s.uPrice,s.tax,s.discount,s.totalAmt from com.mnt.erp.bean.SalesOrderLineBean s where s.salesOrderId="+salesOrderLineId;
		list=getHibernateTemplate().find(sql);
		logger.debug("sales line details aree=="+list.size());
		
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateSalesOrderWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		try
		{
			SalesOrderBean salesOrderBean=(SalesOrderBean)object;
			logger.debug("workFlow list id is=="+salesOrderBean.getWorkFlowListId()+"==comments=="+salesOrderBean.getComments());
			getHibernateTemplate().findByNamedQueryAndNamedParam("workflow",new String[]{"WorkflowlistId","LoggedUserId","ActionComments","ActionType","ActionCode","Signature","RetVal"}, new Object[]{salesOrderBean.getWorkFlowListId() ,userId,salesOrderBean.getComments(),"SO",salesOrderBean.getActionNames(),null,1});
			msg="SalesOrder Work Flow Updated Successfully";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getEmployeeLeaveDetails(String userId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try {
			sql = "select e.employeeLeaveId,e.employeeIdDetails,e.leaveTypeIdDetails,e.reptMgrIdDetails,e.noOfAvailableCL,e.noOfAvailableCFL,e.startDate,e.sDayPart,e.endDate,e.eDayPart,e.recursiveHalf,e.reportingDate,e.reason,e.mobile,e.residence,e.status,w.workFlowListId,w.step from com.mnt.erp.bean.WorkFlowList w,com.mnt.erp.bean.EmployeeLeave e where w.workListId=e.employeeLeaveId and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='EL' ";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getEmployeeLeaveWithStepDetails(String userId,
			int employeeLeaveId, String workFlowListId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try {
			sql = "select e.employeeLeaveId,e.employeeIdDetails,e.leaveTypeIdDetails,e.reptMgrIdDetails,e.noOfAvailableCL,e.noOfAvailableCFL,e.startDate,e.sDayPart,e.endDate,e.eDayPart,e.recursiveHalf,e.reportingDate,e.reason,e.mobile,e.residence,e.status,w.workFlowListId,w.step,w.wfActionDetails from com.mnt.erp.bean.WorkFlowList w,com.mnt.erp.bean.EmployeeLeave e where w.workListId=e.employeeLeaveId and e.employeeLeaveId="
					+ employeeLeaveId
					+ " and w.userId='"
					+ userId
					+ "' and w.workListStatus='Queued' and w.workListContext='EL' and  w.workFlowListId='"
					+ workFlowListId + "'";
			list=getHibernateTemplate().find(sql);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateEmployeeLeaveWorkFlow(Object object, String userId) {
		try {
			// TODO Auto-generated method stub
			EmployeeLeave employeeLeave = (EmployeeLeave) object;
			logger.debug("workFlow list id is=="
					+ employeeLeave.getWorkFlowListId() + "==comments=="
					+ employeeLeave.getComments());
			getHibernateTemplate().findByNamedQueryAndNamedParam(
					"workflow",
					new String[] { "WorkflowlistId", "LoggedUserId",
							"ActionComments", "ActionType", "ActionCode",
							"Signature", "RetVal" },
					new Object[] { employeeLeave.getWorkFlowListId(), userId,
							employeeLeave.getComments(), "EL",
							employeeLeave.getActionNames(), null, 1 });
			msg = "SalesOrder Work Flow Updated Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<Object[]> getClaimDetails(String userId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try {
			sql = "select e.claimId,e.claimNo,e.claimTypeDetails,e.empDetails,e.amount,e.statusDetails,e.description,w.workFlowListId,w.step from com.mnt.erp.bean.WorkFlowList w,com.mnt.erp.bean.ClaimBean e where w.workListId=e.claimNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='CL' ";
			list = getHibernateTemplate().find(sql);
			logger.info("size iss=-="+list.size()+"==="+sql);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> getClaimWithStepDetails(String userId,
			int claimNo, String workFlowListId) {
		try {
			// TODO Auto-generated method stub
			logger.info("worklist id iss=="+workFlowListId);
			sql = "select e.claimId,e.claimNo,e.claimTypeDetails,e.empDetails,e.amount,e.statusDetails,e.description,w.workFlowListId,w.step,w.wfActionDetails from com.mnt.erp.bean.WorkFlowList w,com.mnt.erp.bean.ClaimBean e where w.workListId=e.claimNo and e.claimNo="
					+ claimNo
					+ " and w.userId='"
					+ userId
					+ "' and w.workListStatus='Queued' and w.workListContext='CL' and  w.workFlowListId='"
					+ workFlowListId + "'";
			list = getHibernateTemplate().find(sql);
			logger.info("step details=="+claimNo+"=="+list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public String updateClaimWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		try {
			// TODO Auto-generated method stub
			ClaimBean claim = (ClaimBean) object;
			logger.debug("workFlow list id is=="
					+ claim.getWorkFlowListId() + "==comments=="
					+ claim.getComments());
			getHibernateTemplate().findByNamedQueryAndNamedParam(
					"workflow",
					new String[] { "WorkflowlistId", "LoggedUserId",
							"ActionComments", "ActionType", "ActionCode",
							"Signature", "RetVal" },
					new Object[] { claim.getWorkFlowListId(), userId,
							claim.getComments(), "CL",
							claim.getActionNames(), null, 1 });
			msg = "ClaimFlow Updated Successfully";
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		return msg;
	}
	@Override
	public List<String> getClaimDocDetails(int claimId) {
		// TODO Auto-generated method stub
		List<String> claimDocumentsBeans=null;
		try
		{
			sql="select c.documentPath from com.mnt.erp.bean.ClaimDocumentsBean c where c.claimId="+claimId;
			claimDocumentsBeans=getHibernateTemplate().find(sql);
			logger.info("docpath size iss=="+claimDocumentsBeans.size()+"=="+sql);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		e.printStackTrace();
		}
		return claimDocumentsBeans;
	}

}
