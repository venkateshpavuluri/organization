package com.mnt.erp.service;

import java.util.List;

public interface SalesGroupService {
	
public String saveSalesGroup(Object object, String userId, String userName);
	
	public List<Object[]> searchSalesGroup();
	
	public List<Object[]> editSalesGroupWithId(int id);
	
	public String updateSalesGroup(Object object);
	
	public String deleteSalesGroup(int id);
	
	public int salesGroupDuplicate(String deliveryType);
	
	public int salesGroupEditDuplicate(String deliveryType,int id);
	
	public List<Object[]> basicSearchSalesGroup(String label,String operator,String searchName);
	
	public List<Object[]> salesOfficeIdGet();

}
