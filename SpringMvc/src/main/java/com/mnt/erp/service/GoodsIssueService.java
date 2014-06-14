/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.MatStockBean;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 * 
 */
public interface GoodsIssueService {

	public String saveGoodsIssue(Object object);

	public List<Object> editGoodsIssueWithId(int cId);

	public List<Object[]> basicSearchGoodsIssue(String label, String operator,
			String searchName, String advBasic);

	public boolean updateGoodsIssue(Object object, AuditLog a, int alength);

	public int checkGoodsIssue(String checkValue, String id);

	public boolean deleteGoodsIssue(int id, String mainOrSub);

	public double getAvailableQuantity(String material, String batchNo,
			String storageLocation);

	public boolean saveOrUpdateMatStock(Object object);

	public List<MatStockBean> getAvlQty(int matId, int stlId, String batchId);

	public List<MatStockBean> getMatStock(int mtId, int slId, String bNo);
}
