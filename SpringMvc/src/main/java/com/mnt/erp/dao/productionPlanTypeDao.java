package com.mnt.erp.dao;

import java.util.List;

public interface productionPlanTypeDao {
	public String saveProductionPlanType(Object object);
	public long checkProductionPlanType(String type);
	public List<Object[]> searchProductionPlanType();
	public String deleteProductionPlanType(int id);
	public List<Object[]> searchProductionPlanTypeWithId(int id);
	public List<Object[]> basicSearchProductionPlanType(String label,String operator,String searchName);
	public String updateProductionPlanType(Object object);
	public List<Object[]> selectProductionPlanType();
	public long updateCheckProductionPlanType(String type, int Id);

}
