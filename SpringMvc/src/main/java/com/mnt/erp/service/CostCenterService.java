package com.mnt.erp.service;

import java.util.List;

public interface CostCenterService {
	public String saveCostCenter(Object object,String userId,String userName);

	public List<Object[]> searchCostCenter(int id);

	public List<Object[]> editCostCenterWithId(int id);

	public String updateCostCenter(Object object);

	public String costCenterDelete(int id);

	public int costCenterDuplicate(String CostCenter);

	public int costCenterEditDuplicate(String CostCenter,int id);

	public List<Object[]> basicSearchCostCenter(String label,String operator,String searchName);
}
