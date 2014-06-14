/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.GoodsDeliveryInTheYear;
import com.mnt.erp.bean.InvoiceToCollect;
import com.mnt.erp.bean.InvoiceToPay;
import com.mnt.erp.bean.PendingPo;
import com.mnt.erp.bean.ToBeReoredeMaterial;

/**
 * @author venkateshp
 *
 */
public interface DashBoardDao {
	public List<Object[]> getTotalStocks(int storageLocId);
	public List<PendingPo> getPendingPoDetails(String count);
	public List<GoodsDeliveryInTheYear> getGoodsinyear(String msg);
	public List<ToBeReoredeMaterial> getTobeReorederLevels(String msg);
	public List<InvoiceToCollect> invoiceToCollect(String count);
	public List<InvoiceToPay> getInvoiceToPays(String count);
	public List<Object[]> getMatStockDetails();
	public List<Object[]> getTop5orderItems();
	public List<Object[]> getSalesOrdersByYear(int year);
	public List<Object[]> allorderItems();
	public List<Object[]> getPendingLeaveRequest();
	public List<Object[]> getScheduleInterviews();
}
