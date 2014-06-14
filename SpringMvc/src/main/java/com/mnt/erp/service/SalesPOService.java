/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 04-12-2013
 */
public interface SalesPOService {

	public List<Object[]> selectCustomerIds();

	public List<Object[]> selectSalesQuotationIds();

	public List<Object[]> selectPaymentTermIds();

	public List<Object[]> selectStatusIds();

	public int updateCheckSalesPO(String salesNo, int siId);

	public List<Object[]> advSearchSalesPO(String labels, String opts,
			String advText);

	public Long checkSalesPO(String salesNo);

	public String saveSalesPO(Object object);

	public String deleteSalesPOLine(int sId);

	public List<Object[]> searchSalesPO();

	public List<Object> searchSalesPOWithId(int sId);

	public String updateSalesPO(Object object);

	public String deleteSalesPO(int cId);

	public List<Object[]> basicSearchSalesPO(String label, String operator,
			String searchName);

	public List<Object[]> populateCurrencyIds();

	public List<Object[]> populateMaterialIds();

	public List<Object[]> populateUOMIds();

	public List<Object> editSalesQuotationWithId(int sId);

}
