/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 31-10-2013
 */
public interface SalesAreaService {
   
	public List<Object[]> selectSalesArea();
	 
	public Long updateCheckSalesArea(String salesArea, int salesId);

	public Long checkSalesAreaCout(String salesArea);

	public String saveSalesAreaDetails(Object object,String userId, String userName);

	public List<Object[]> searchSalesArea();

	public List<Object[]> searchSalesAreaWithId(int id);

	public String updateSalesArea(Object object);

	public String deleteSalesArea(int id);

	public List<Object[]> selectSalesOrg();

	public List<Object[]> basicSearchSalesArea(String label, String operator,
			String searchName);

}
