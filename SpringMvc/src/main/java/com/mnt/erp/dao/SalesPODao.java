/**
 * @Copyright MNTSOFT   
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 04-12-2013
 */
public interface SalesPODao {
	
	public List<Object[]> selectCustomerIds();

	public List<Object[]> selectSalesQuotationIds();
	
	public List<Object[]> selectPaymentTermIds();
	
	public List<Object[]> selectStatusIds();

	public int updateCheckSalesPO(String salesNo, int siId);

	public Long checkSalesPO(String salesNo);

	public String saveSalesPO(Object object);
	
	public List<Object[]> advSearchSalesPO(String advSearch);

	public List<Object[]> searchSalesPO();

	public List<Object> searchSalesPOWithId(int sId);

	public String updateSalesPO(Object object);

	public String deleteSalesPO(int cId);
	public String deleteSalesPOLine(int sId);

	public List<Object[]> basicSearchSalesPO(String label,
			String operator, String searchName);

	public List<Object[]> populateCurrencyIds();

	public List<Object[]> populateMaterialIds();

	public List<Object[]> populateUOMIds();

	public List<Object> editSalesQuotationWithId(int sId);
	

}
