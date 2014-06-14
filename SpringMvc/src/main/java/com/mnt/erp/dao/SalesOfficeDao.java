/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 31-10-2013
 * @build 0.0
 *
 */
public interface SalesOfficeDao {
	
	
	public String addSalesOffice(Object object,String userId, String userName);
	public List<Object[]> searchSalesOffice();
	public List<Object[]> searchSalesOfficeWithId(int id);
	public String updateSalesOffice(Object object);
	public String deleteSalesOffice(int id);
	public int checkDuplicate(String checkSalesOffice);
	public int checkEditDuplicate(String checkSalesOffice,int id);
	public List<Object[]> basicSearchSales(String label,String operator,String searchName);

}
