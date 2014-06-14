package com.mnt.erp.dao;

import java.util.List;

public interface ProductionBatchDao {

	public String saveProductionBatch(Object object,String userId,String userName);

	public List<Object[]> searchProductionBatchWithId(int id);

	public List<Object[]> searchProductionBatch();

	public List<Object[]> selectproductionorderIds();
	public List<Object[]>selectStatus();

	public String updateProductionBatch(Object object);

	public String deleteProductionBatch(int id);

	public Long getProductionBatchCount(String name);

	public Long getProductionBatchCountedit(String name, int accountgroupid);

	public List<Object[]> basicSearchProductionBatch(String label, String operator,
			String searchName);
}
