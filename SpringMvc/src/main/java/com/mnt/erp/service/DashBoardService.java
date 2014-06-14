/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.GetPendingLeaveRequestBean;
import com.mnt.erp.bean.GetSalesOrderByYear;
import com.mnt.erp.bean.GetScheduleInterviewsBean;
import com.mnt.erp.bean.GoodsDeliveryInTheYear;
import com.mnt.erp.bean.InvoiceToCollect;
import com.mnt.erp.bean.InvoiceToPay;
import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.bean.PendingPo;
import com.mnt.erp.bean.ToBeReoredeMaterial;
import com.mnt.erp.bean.Top5OrderItems;

/**
 * @author venkateshp
 *
 */
public interface DashBoardService {
	public List<Object[]> getTotalStocks(int storageLocId);
	public List<PendingPo> getPendingPoDetails(String count);
	public List<GoodsDeliveryInTheYear> getGoodsinyear(String msg);
	public List<ToBeReoredeMaterial> getTobeReorederLevels(String msg); 
	public List<InvoiceToCollect> invoiceToCollect(String count);
	public List<InvoiceToPay> getInvoiceToPays(String count);
	public List<MatStockBean> getMatStockDetails();
	public List<Top5OrderItems> getTop5orderItems();
	public List<Top5OrderItems> allorderItems();
	public List<GetSalesOrderByYear> getSalesOrdersByYear(int year);
	public List<GetPendingLeaveRequestBean> getPendingLeaveRequest();
	public List<GetScheduleInterviewsBean> getScheduleInterviews();
}
