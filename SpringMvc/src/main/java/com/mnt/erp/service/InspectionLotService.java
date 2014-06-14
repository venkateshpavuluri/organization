/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.GoodsReceiptLine;

/**
 * @author Naresh
 * @version 1.0 07-01-2014
 */
public interface InspectionLotService {

	public Long updateCheckInspectionLot(String inspNo, int inspId);

	public Long checkInspectionLotCout(String inspNo);

	public boolean saveInspectionLotDetails(Object object);

	public List<Object[]> searchInspectionLot();
	
	public List<Object[]> advSearchInspectionLot(String labels,String opts,String advText);

	public List<Object> searchInspectionLotWithId(int inspId);

	public boolean updateInspectionLot(Object object);

	public boolean deleteInspectionLot(int inspId);
	
	public boolean deleteInspectionLotEqp(int inspEqpId);

	public List<Object[]> basicSearchInspectionLot(String label,
			String operator, String searchName);
	
	public List<GoodsReceiptLine> getAvlQty(int matId, String batchNo);

}
