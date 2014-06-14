package com.mnt.erp.dao;

import java.util.List;

public interface SalesOrganizationDao {
	public String saveSalesOrg(Object object, String userId, String UserName);
	public List<Object[]>searchSalesOrgWithId(int id);
	public List<Object[]>searchSalesOrg();
	public List<Object[]>selectSalesOrg();
	public List<Object[]>selectOrg();
	public String updateSalesOrg(Object object);
	public String deleteSalesOrg(int id);
	public Long getSalesOrgCount(String name);
	public Long getSalesOrgCountedit(String name,int imid);
	public List<Object[]> basicSearchSalesOrg(String label,String operator,String searchName);
}
