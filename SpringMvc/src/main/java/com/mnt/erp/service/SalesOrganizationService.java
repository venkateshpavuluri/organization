package com.mnt.erp.service;

import java.util.List;

public interface SalesOrganizationService {
	public String saveSalesOrgService(Object object, String userId, String UserName);
	public List<Object[]>searchSalesOrgServiceWithId(int id);
	public List<Object[]>searchSalesOrgService();
	public List<Object[]>selectSalesOrgService();
	public List<Object[]>selectOrg();
	public String updateSalesOrgService(Object object); 
	public String deleteSalesOrgService(int id);
	public Long getSalesOrgCount(String name);
	public Long getSalesOrgCountedit(String name,int imid);
	public List<Object[]> basicSearchSalesOrg(String label,String operator,String searchName);

}
