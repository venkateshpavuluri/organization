/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 14-11-2013
 */
public interface SalesQuotationDao {

	public List<Object[]> selectCustomerIds();

	public List<Object[]> selectSalesInquiryIds();

	public int updateCheckSalesQuotation(String salesNo, int siId);

	public Long checkSalesQuotation(String salesNo);

	public String saveSalesQuotation(Object object);

	public List<Object[]> searchSalesQuotation();
	
	public List<Object[]> advSearchSalesQuotation(String advSearch);

	public List<Object> searchSalesQuotationWithId(int sId);

	public String updateSalesQuotation(Object object);

	public String deleteSalesQuotation(int cId);
	
	public String deleteSalesQuotLine(int sId);

	public List<Object[]> basicSearchSalesQuotation(String label,
			String operator, String searchName);

	public List<Object[]> populateCurrencyIds();

	public List<Object[]> populateMaterialIds();

	public List<Object[]> populateUOMIds();

	public List<Object> editSalesInquiryWithId(int sId);

}
