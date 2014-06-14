package com.mnt.erp.service;

import java.util.List;

public interface ProductionBatchService {
	public String saveProductionBatchservice(Object object,String userId,String userName);
	public List<Object[]> searchProductionBatchWithId(int id);
	public List<Object[]> searchProductionBatch();
	public List<Object[]> selectProductionOrderIds();
	public List<Object[]> selectStatusIds();
	public String updateProductionBatch(Object object);
	public String deleteProductionBatch(int id);
	public Long getProductionBatchCount(String name);
	public Long getProductionBatchCountedit(String name,int accountgroupid);
	public List<Object[]> basicSearchProductionBatch(String label,String operator,String searchName);
}
