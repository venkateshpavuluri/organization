/**
 *@Copyright MNTSOFT  
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 07-11-2013
 */
public interface SalesInquiryDao {

	public List<Object[]> selectCustomerIds();

	public List<Object[]> selectSalesGroupIds();

	public int updateCheckSalesInquiry(String salesNo, int siId);

	public Long checkSalesInquiry(String salesNo);

	public String saveSalesInquiry(Object object);

	public List<Object[]> searchSalesInquiry();
	
	public List<Object[]> advSearchSalesInquiry(String advSearch);

	public List<Object> searchSalesInquiryWithId(int sId);

	public String updateSalesInquiry(Object object);

	public String deleteSalesInquiry(int cId);

	public String deleteSalesLine(int id);

	public List<Object[]> basicSearchSalesInquiry(String label,
			String operator, String searchName);

	public List<Object[]> populateUOMIds();

	public List<Object[]> populateMaterialIds();

}
