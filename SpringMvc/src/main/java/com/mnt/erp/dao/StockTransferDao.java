/**
 *@Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.MatStockBean;

/**
 * @author Naresh
 * @version 1.0 29-11-2013
 */
public interface StockTransferDao {

	public List<Object[]> selectOrgIds();

	public List<Object[]> selectPlantIds(int orgId);

	public List<Object[]> populateStorLocIds(int plantId);

	public int updateCheckStockTransfer(String salesNo, int siId);

	public Long checkStockTransfer(String salesNo);

	public String saveStockTransfer(Object object);

	public List<Object[]> searchStockTransfer();
	
	public List<Object[]> advSearchStockTransfer(String search);

	public List<Object> searchStockTransferWithId(int sId);

	public String updateStockTransfer(Object object);

	public String deleteStockTransfer(int cId);

	public String deleteStockTransferLine(int sId);

	public List<Object[]> basicSearchStockTransfer(String label,
			String operator, String searchName);

	public List<Object[]> populateUOMIds();

	public List<Object[]> populateMaterialIds(int storLocId);

	public List<Object[]> populateStorLocIds();

	public List<Object[]> selectPlantIds();

	public List<Object[]> getBatchNOs(int materialId,String slId);

	public List<MatStockBean> getAvlQty(int matId, int stlId, String batchId);

	public List<MatStockBean> getMatStock(int mtId, int slId, String bNo);

	public boolean saveOrUpdateMatStock(Object object);
	
	public boolean updateMatStock(float qty,int mtId, int slId, String bNo);
	
	public List<Object[]> selectBatchNos();

}
