/**

 *@copyright MNTSOFT  


 */
package com.mnt.erp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.mnt.erp.bean.ClaimBean;
import com.mnt.erp.bean.ClaimDocumentsBean;
import com.mnt.erp.bean.ClaimTypeBean;
import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeLeave;
import com.mnt.erp.bean.LeaveTypeBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.OrderType;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.PurchaseOrderLine;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.SalesOrderLineBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.Voucher;
import com.mnt.erp.bean.VoucherTypeBean;
import com.mnt.erp.bean.WFAction;
import com.mnt.erp.bean.WorkFlowList;
import com.mnt.erp.dao.WorkFlowListDao;

/**
 * @author pvenkateswarlu
 *@version 1.0 11-10-2013
 */
public class WorkFlowListServiceImpl implements WorkFlowListService {
	
	Logger logger=Logger.getLogger(WorkFlowListServiceImpl.class);

	private WorkFlowListDao dao;
	private List<Object[]> objects;
	private Object[] objectslist;
	private Iterator<Object[]> iterator;

	/**
	 * @return the dao
	 */
	public WorkFlowListDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(WorkFlowListDao dao) {
		this.dao = dao;
	}
	
	@Override
		// TODO Auto-generated method stub
	public List<PurchaseReq> getPurchaseReqDetails(String userId) {
		List<PurchaseReq> purchaseReqs = null;
		PurchaseReq purchaseReq = null;
		PurchaseReq req = null;

		Object object = null;
		purchaseReqs=dao.getPurchaseReqDetails(userId);
			
	
		return purchaseReqs;
	}
	@Override
	public List<Object[]> getpurReqWithStepDetails(String userId,
			int workListId, String workFlowListId) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.getpurReqWithStepDetails(userId, workListId,
					workFlowListId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updatePurReqWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		WorkFlowList workFlowList = null;
		PurchaseReq purchaseReq = null;
		String msg = null;
		try {
			purchaseReq = (PurchaseReq) object;
			workFlowList = new WorkFlowList();
			workFlowList.setWorkFlowListId(purchaseReq.getWorkFlowListId());
			workFlowList.setActionBy(userId);
			workFlowList.setActionComments(purchaseReq.getComments());
			workFlowList.setActionCode(purchaseReq.getActionNames());
			workFlowList.setActionType("PR");
			msg = dao.updatePurReqWorkFlow(workFlowList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<PurchaseReq> displayPurchaseReqLineDetails(int purReqLineId) {
		// TODO Auto-generated method stub
	
		List<PurchaseReq> list = null;
		List<Object[]> objects = null;
		Iterator<Object[]> iterator = null;
		Object[] objectsList = null;
		PurchaseReq purchaseReq = null;
		try {

			objects = dao.displayPurchaseReqLineDetails(purReqLineId);
			
			if(objects!=null)
			{

			iterator = objects.iterator();
			list = new ArrayList<PurchaseReq>();
			while (iterator.hasNext()) {
				// sql="select p.PurchaseReqLine_Id,p.qty,p.requiredDate,p.material.materialName,p.uomDetails.uom,p.statusDetails.status,p.plantDetails.plantName,p.storageLocationDetails.storageLocation from PurchaseReqLine p where p.PurchaseReqLine_Id="+purReqLineId+"";
				objectsList = (Object[]) iterator.next();
				purchaseReq = new PurchaseReq();
				purchaseReq.setPurchaseReqLine_Id((Integer) objectsList[0]);
				purchaseReq.setPurReqLineqty(Integer.parseInt(objectsList[1].toString()));
				purchaseReq.setPurReqLineReqDate((String) objectsList[2]);
				purchaseReq.setMaterialName((String) objectsList[3]);
				purchaseReq.setUomName((String) objectsList[4]);
				purchaseReq.setStatus((String) objectsList[5]);
				purchaseReq.setPlantName((String) objectsList[6]);
				purchaseReq.setStorageLocName((String) objectsList[7]);
				list.add(purchaseReq);
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getActionAndComments(String stepId, int stepNo) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.getActionAndComments(stepId, stepNo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderDetails(String userId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		PurchaseOrder purchaseOrder=null;
		List<PurchaseOrder> purchaseOrders=null;
		Vendor vendor=null;
		Status status=null;
		try
		{
			list=dao.getPurchaseOrderDetails(userId);
			purchaseOrders=new ArrayList<PurchaseOrder>();
			//sql="select p.purchaseOrderId,p.purchaseOrderNo,p.purchaseOrderDate,p.paymentTerms,p.memo,p.vendorDetails,p.satatusDetails,w.purchaseOrderValue,w.description,w.workFlowListId,w.step from WorkFlowList w com.mnt.erp.bean.PurchaseOrder p where w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='PO'";
			if(list!=null)
			{
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				objectslist=(Object[])iterator.next();
				purchaseOrder=new PurchaseOrder();
				purchaseOrder.setPurchaseOrderId((Integer)objectslist[0]);
				purchaseOrder.setPurchaseOrderNo((String)objectslist[1]);
				purchaseOrder.setPurchaseOrderDate((String)objectslist[2]);
				purchaseOrder.setPaymentTerms((String)objectslist[3]);
				purchaseOrder.setMemo((String)objectslist[4]);
				purchaseOrder.setDescription((String)objectslist[6]);
				purchaseOrder.setPurchaseOrderValue((String)objectslist[5]);
				vendor=(Vendor)objectslist[7];
				status=(Status)objectslist[8];
				purchaseOrder.setVendorName(vendor.getVendorName());
				purchaseOrder.setStatusName(status.getStatus());
				purchaseOrder.setWorkFlowListId((String)objectslist[9]);
				
				
				
				
				purchaseOrders.add(purchaseOrder);
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return purchaseOrders;
	}

	@Override
	public List<Object[]> getpurOrderWithStepDetails(String userId,
			int workListId, String workFlowListId) {
		// TODO Auto-generated method stub
		try
		{
			objects=dao.getpurOrderWithStepDetails(userId, workListId, workFlowListId);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> getpurOredrActionAndComments(String stepId, int stepNo) {
		// TODO Auto-generated method stub
		try
		{
			objects=dao.getpurOredrActionAndComments(stepId, stepNo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<PurchaseOrderLine> displayPurchaseOrderLineDetails(
			int purOrderLineId) {
		// TODO Auto-generated method stub
		List<PurchaseOrderLine > list = null;
		List<Object[]> objects = null;
		Iterator<Object[]> iterator = null;
		Object[] objectsList = null;
		PurchaseOrderLine purchaseOrder= null;
		try {

			objects = dao.displayPurchaseOrderLineDetails(purOrderLineId);
if(objects!=null)
{
			iterator = objects.iterator();
			list = new ArrayList<PurchaseOrderLine>();
			while (iterator.hasNext()) {
				// sql="select p.PurchaseReqLine_Id,p.qty,p.requiredDate,p.material.materialName,p.uomDetails.uom,p.statusDetails.status,p.plantDetails.plantName,p.storageLocationDetails.storageLocation from PurchaseReqLine p where p.PurchaseReqLine_Id="+purReqLineId+"";
				objectsList = (Object[]) iterator.next();
				purchaseOrder = new PurchaseOrderLine();
				purchaseOrder.setPurchaseOrderId((Integer)objectsList[0]);
			/*	purchaseOrder.setLineNumber((Integer)objectsList[1]);*/
				purchaseOrder.setUnitPrice((Float)objectsList[1]);
				purchaseOrder.setMaterialName((String)objectsList[2]);
				purchaseOrder.setUomName((String) objectsList[3]);
				purchaseOrder.setQuantity((Float)objectsList[4]);
				purchaseOrder.setLineAmt((Float)objectsList[5]);
				purchaseOrder.setDueDate((String)objectsList[6]);
				list.add(purchaseOrder);
			}
}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updatePurOrderWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.updatePurOrderWorkFlow(object, userId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String saveWorkFlowListDaoDetails(Object object){
		
		String list=null;
		try
		{
			list=dao.saveWorkFlowListDaoDetails(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
		}
		

	public List<Object[]> getStepUser(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=dao.getStepUser();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}

	@Override
	public List<Voucher> getVoucherDetails(String userId) {
		// TODO Auto-generated method stub
	
		Voucher voucher=null;
		List<Voucher> vouchers=null;
		
		try
		{
			objects=dao.getVoucherDetails(userId);
			if(objects!=null)
			{
				
				vouchers=new ArrayList<Voucher>();
//sql="select p.voucherId,p.voucherDT,p.employeeId,p.amount,p.voucherNo,p.voucherTypeIdDetails,p.satatusDetails,w.workFlowListId,w.step from WorkFlowList w ,com.mnt.erp.bean.Voucher p where w.workListId=p.voucherNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='VO'";						
			Iterator<Object[]> iterator=objects.iterator();
			while(iterator.hasNext())
			{
			 objectslist=(Object[])iterator.next();
				 voucher=new Voucher();
				 voucher.setVoucherId((Integer)objectslist[0]);
				 voucher.setVoucherDT((String)objectslist[1]);
				 voucher.setEmployeeId((String)objectslist[2]);
				 voucher.setAmount((String)objectslist[3]);
				 voucher.setVoucherNo((String)objectslist[4]);
				 VoucherTypeBean voucherTypeBean=(VoucherTypeBean)objectslist[5];
				 voucher.setVoucherTypeName(voucherTypeBean.getVouchertype());
				 Status status=(Status)objectslist[6];
				 voucher.setStatusName(status.getStatus());
				 voucher.setWorkFlowListId((String)objectslist[7]);
				 
				 logger.info("status Name iss=="+status.getStatus());
				 vouchers.add(voucher);
				 
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vouchers;
	}

	@Override
	public List<Object[]> getVoucherWithStepDetails(String userId,
			int voucherId, String workFlowListId) {
		// TODO Auto-generated method stub
		
		try
		{
			objects=dao.getVoucherWithStepDetails(userId, voucherId, workFlowListId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updatevoucherWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.updatevoucherWorkFlow(object, userId);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return msg;
	}

	@Override
	public List<SalesOrderBean> getSalesOrderDetails(String userId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		Iterator<Object[]> iterator=null;
		SalesOrderBean salesOrderBean=null;
		List<SalesOrderBean> orderBeans=null;
		try
		{
			list=dao.getSalesOrderDetails(userId);
		//sql="select p.salesOrderId,p.orderType,p.paymentTerm,p.salesGroup,p.uom,p.salesOrderNo,p.status,p.custPONumber,p.salesOrderDate,p.custPODate,p.netWeight,p.totalWeight,p.totalVolume,p.orderReason,p.priority,p.unloadingPoint,p.route,w.workFlowListId,w.step from WorkFlowList w,com.mnt.erp.bean.SalesOrder p where w.workListId=p.salesOrderNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='SO'";			
		if(list!=null)
		{
			orderBeans=new ArrayList<SalesOrderBean>();
			iterator=list.iterator();
			while(iterator.hasNext())
			{
				Object[] objects=(Object[])iterator.next();
				 salesOrderBean=new SalesOrderBean();
				 salesOrderBean.setSalesOrderId((Integer)objects[0]);
				 OrderType orderType=(OrderType)objects[1];
				 salesOrderBean.setOrderTypeId(orderType.getOrderType());
				 PaymentTerms  paymentTerms=(PaymentTerms)objects[2];
				 salesOrderBean.setPaymentTermId(paymentTerms.getPaymentTermName());
				 SalesGroup salesGroup=(SalesGroup)objects[3];
				 salesOrderBean.setSalesGroupId(salesGroup.getSalesGroup());
				 Uom uom=(Uom)objects[4];
				 salesOrderBean.setUom(uom.getUom());
				 salesOrderBean.setSalesOrderNo((String)objects[5]);
				Status status=(Status)objects[6];
				salesOrderBean.setStatusId(status.getStatus());
				salesOrderBean.setCustPONumber((String)objects[7]);
				salesOrderBean.setSalesOrderDate((String)objects[8]);
				salesOrderBean.setCustPODate((String)objects[9]);
				salesOrderBean.setNetWeight((String)objects[10]);
				salesOrderBean.setTotalWeight((String)objects[11]);
				salesOrderBean.setTotalVolume((String)objects[12]);
				salesOrderBean.setOrderReason((String)objects[13]);
				salesOrderBean.setPriority((String)objects[14]);
				salesOrderBean.setUnloadingPoint((String)objects[15]);
				salesOrderBean.setRoute((String)objects[16]);
				salesOrderBean.setWorkFlowListId((String)objects[17]);
				salesOrderBean.setStep((String)objects[18]);
				orderBeans.add(salesOrderBean);
			}
		}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return orderBeans;
	}

	@Override
	public List<Object[]> getSalesOrderWithStepDetails(String userId,
			int workListId, String workFlowListId) {
		List<Object[]> list=null;
		try
		{
			list=dao.getSalesOrderWithStepDetails(userId, workListId, workFlowListId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SalesOrderLineBean> displaySalesOrderLineDetails(
			int salesOrderLineId) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		Iterator<Object[]> iterator=null;
		SalesOrderLineBean orderLineBean=null;
		List<SalesOrderLineBean> salesOrderLineBeans=null;
		try
		{
			list=dao.displaySalesOrderLineDetails(salesOrderLineId);
			if(list!=null)
			{
				//sql=" select s.salesOrderLineId,s.material,s.quantity,s.uom,s.currency,s.custMaterailNo,s.netPrice,s.uPrice,s.tax,s.discount,s.totalAmt com.mnt.erp.bean.SalesOrderLineBean s where s.salesOrderLineId="+salesOrderLineId;		
				salesOrderLineBeans=new ArrayList<SalesOrderLineBean>();
				iterator=list.iterator();
				while(iterator.hasNext())
				{
				Object[]	objects=(Object[])iterator.next();
				orderLineBean=new SalesOrderLineBean();
				orderLineBean.setSalesOrderLineId((Integer)objects[0]);
				Material material=(Material)objects[1];
				orderLineBean.setMaterialId(material.getMaterialName());
				orderLineBean.setQuantity((String)objects[2]);
				Uom uom=(Uom)objects[3];
				orderLineBean.setUomId(uom.getUom());
				Currency currency=(Currency)objects[4];
				orderLineBean.setCurrencyId(currency.getCurrency());
				orderLineBean.setCustMaterailNo((String)objects[5]);
				orderLineBean.setNetPrice((String)objects[6]);
				orderLineBean.setuPrice((String)objects[7]);
				orderLineBean.setTax((String)objects[8]);
				orderLineBean.setTotalAmt((String)objects[10]);
				orderLineBean.setDiscount((String)objects[9]);
				salesOrderLineBeans.add(orderLineBean);
				}
			}
			
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return salesOrderLineBeans;
	}

	@Override
	public String updateSalesOrderWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.updateSalesOrderWorkFlow(object, userId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<EmployeeLeave> getEmployeeLeaveDetails(String userId) {
		// TODO Auto-generated method stub
		EmployeeLeave employeeLeave=null;
		List<EmployeeLeave> employeeLeaves=null;
		try
		{
			//sql = "select e.employeeLeaveId,e.employeeIdDetails,e.leaveTypeIdDetails,e.reptMgrIdDetails,e.noOfAvailableCL,e.noOfAvailableCFL.e.startDate,s.sDayPart,s.endDate,s.eDayPart,e.recursiveHalf,e.reportingDate,e.reason,e.mobile,e.residence,e.status,w.workFlowListId,w.step from WorkFlowList w,com.mnt.erp.bean.EmployeeLeave e where w.workListId=e.employeeId and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='EL' ";			
			objects=dao.getEmployeeLeaveDetails(userId);
		if(objects!=null)
		{
			iterator=objects.iterator();
			employeeLeaves=new ArrayList<EmployeeLeave>();
			while(iterator.hasNext())
			{
				objectslist=(Object[])iterator.next();
				employeeLeave=new EmployeeLeave();
				employeeLeave.setEmployeeLeaveId((Integer)objectslist[0]);
				Employee employee=(Employee)objectslist[1];
				employeeLeave.setEmployeeId(employee.getfName()+" "+employee.getmName()+" "+employee.getlName());
				LeaveTypeBean leaveTypeBean=(LeaveTypeBean)objectslist[2];
				employeeLeave.setLeaveTypeId(leaveTypeBean.getLeaveType());
				Employee employees=(Employee)objectslist[3];
				employeeLeave.setReptMgrId(employees.getfName()+" "+employees.getmName()+" "+employees.getlName());
				employeeLeave.setNoOfAvailableCL((String)objectslist[4]);
				employeeLeave.setNoOfAvailableCFL((String)objectslist[5]);
				employeeLeave.setStartDate((String)objectslist[6]);
				employeeLeave.setsDayPart((String)objectslist[7]);
				employeeLeave.setEndDate((String)objectslist[8]);
				employeeLeave.seteDayPart((String)objectslist[9]);
				employeeLeave.setRecursiveHalf((Integer)objectslist[10]);
				employeeLeave.setReportingDate((String)objectslist[11]);
				employeeLeave.setReason((String)objectslist[12]);
				employeeLeave.setMobile((String)objectslist[13]);
				employeeLeave.setResidence((String)objectslist[14]);
				Status status=(Status)objectslist[15];
				employeeLeave.setStatusId(status.getStatus());
				employeeLeave.setWorkFlowListId((String)objectslist[16]);
				employeeLeave.setStep((String)objectslist[17]);
				employeeLeaves.add(employeeLeave);
			}
		}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return employeeLeaves;
	}
	@Override
	public List<Object[]> getEmployeeLeaveWithStepDetails(String userId,
			int employeeId, String workFlowListId) {
		try {
			objects = dao.getEmployeeLeaveWithStepDetails(userId, employeeId,workFlowListId);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public String updateEmployeeLeaveWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.updateEmployeeLeaveWorkFlow(object, userId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<ClaimBean> getClaimDetails(String userId) {
		ClaimBean claimBean=null;
		List<ClaimBean> claimBeans=null;
		try {
			//sql = "select e.claimId,e.claimNo,e.claimTypeDetails,e.empDetails,e.amount,e.statusDetails,e.description,w.workFlowListId,w.step from com.mnt.erp.bean.WorkFlowList w,com.mnt.erp.bean.ClaimBean e where w.workListId=e.claimNo and w.userId='"+userId+"' and w.workListStatus='Queued' and w.workListContext='EL' ";
			objects = dao.getClaimDetails(userId);
			if(objects!=null)
			{
				claimBeans=new ArrayList<ClaimBean>();
				iterator=objects.iterator();
				while(iterator.hasNext())
				{
					objectslist=(Object[])iterator.next();
					claimBean=new ClaimBean();
					claimBean.setClaimId((Integer)objectslist[0]);
					claimBean.setClaimNo((String)objectslist[1]);
					ClaimTypeBean claimTypeBean=(ClaimTypeBean)objectslist[2];
					claimBean.setClaimTypeName(claimTypeBean.getClaimType());
					Employee employee=(Employee)objectslist[3];
					claimBean.setEmpName(employee.getfName()+" "+employee.getmName()+" "+employee.getlName());
					claimBean.setAmount((String)objectslist[4]);
					Status status=(Status)objectslist[5];
					claimBean.setStatusName(status.getStatus());
					claimBean.setWorkFlowListId((String)objectslist[6]);
					claimBean.setStep((String)objectslist[7]);
					claimBeans.add(claimBean);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception]
			logger.error(e.getMessage());
		}
		return claimBeans;
	}
	@Override
	public List<Object[]> getClaimWithStepDetails(String userId,
			int claimId, String workFlowListId) {
		try {
			// TODO Auto-generated method stub
			objects = dao.getClaimWithStepDetails(userId, claimId,
					workFlowListId);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
		}
		return objects;
	}

	@Override
	public String updateClaimWorkFlow(Object object, String userId) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.updateClaimWorkFlow(object, userId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<String> getClaimDocDetails(int claimId) {
		// TODO Auto-generated method stub
	

		return dao.getClaimDocDetails(claimId);
	}
	
}
