/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.MatStockBean;

/**
 * @author Naresh
 * @version 1.0 10-01-2014
 */
public interface InspLotResultDao {

	public boolean getLotQty(int inspId, float inspected);

	public List<Object> getMaterialId(int inspid);

	public float getStock(int materalId);

	public List<Object> getGoodsQty(int matId, String batchNo);
	
	public boolean updateMaterial(float stock, int matId);
	
	public List<MatStockBean> getMatStock(int mtId,int slId,String bNo);
	
	public boolean saveOrUpdateMatStock(Object object);
	
	public boolean updateGoodsReceiptLine(float totQtyInsp,float totQtyAcp,float totQtyRej,int matId,String batchNo);

	public boolean saveInspLotResultDetails(Object object);

	public List<Object[]> searchInspLotResult();
	
	public List<Object[]> advSearchInspLotResult(String advSearch);

	public List<Object> searchInspLotResultWithId(int inspId);

	public boolean updateInspLotResult(Object object);

	public boolean deleteInspLotResult(int inspId);

	public List<Object[]> basicSearchInspLotResult(String label,
			String operator, String searchName);

}
