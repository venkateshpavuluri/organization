package com.mnt.erp.dao;

import java.util.List;

public interface ProductionPlanDao {

	
	public Long updateCheckProductionPlan(String fiscalYear,int fiscalYearId);

	public Long checkProductionPlan(String fiscalYear);
	
	public String saveProductionPlanDetails(Object object,String userId,String userName);

	public List<Object[]> searchProductionPlan();

	public List<Object> searchProductionPlanWithId(int id);

	public String updateProductionPlan(Object object);

	public String deleteProductionPlan(int id);
	
	public List<Object[]> selectPlant();
	
	public List<Object[]> selectProductionPlanType();
	
	public List<Object[]> selectStatus();
	
	public List<Object[]> selectProject();
	
	public List<Object[]> selectMaterial();
	
	public List<Object[]> selectUom();
	
	public List<Object[]> selectProductionOrderNums();
	
	public String deleteProductionPlanLine(int kk);
	
	public List<Object[]> basicSearchProductionPlan(String label,String operator,String searchName);
}
