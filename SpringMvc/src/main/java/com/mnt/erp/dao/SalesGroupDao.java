package com.mnt.erp.dao;

import java.util.List;

public interface SalesGroupDao {
	
	public String saveSalesGroup(Object object, String userId, String userName);
    
	public List<Object[]> searchSalesGroup();

	public List<Object[]> editSalesGroupWithId(int id);

	public String updateSalesGroup(Object object);

	public String salesGroupDelete(int id);

	public int salesGroupDuplicate(String salesGroup);

	public int salesGroupEditDuplicate(String salesGroup,int id);

	public List<Object[]> basicSearchSalesGroup(String label,String operator,String searchName);
	
	public List<Object[]> salesOfficeIdGet();
}
