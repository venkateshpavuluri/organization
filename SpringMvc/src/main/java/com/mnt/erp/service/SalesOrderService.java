/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WorkFlowList;

/**
 * @author Naresh
 * @version 1.0 20-11-2013
 */
public interface SalesOrderService {

	public List<Object[]> selectCustomerIds();

	public List<Object[]> selectSalesGroupIds();

	public List<Object[]> selectOrderTypeIds();

	public List<Object[]> selectPaymentTermIds();

	public int updateCheckSalesOrder(String salesNo, int siId);
	
	public List<Object[]> advSearchSalesOrder(String labels,String opts,String advText);

	public Long checkSalesOrder(String salesNo);

	public String saveSalesOrder(Object object);

	public List<Object[]> searchSalesOrder();

	public List<Object> searchSalesOrderWithId(int sId);

	public String updateSalesOrder(Object object);
	public String saveWorkFlowListDaoDetails(WorkFlowList workFlowList);
	public String deleteSalesOrder(int dId);

	public String deleteSalesOrderLine(int slId);

	public String deleteSalesOrderSch(int scId);

	public List<Object[]> basicSearchSalesOrder(String label, String operator,
			String searchName);

	public List<Object[]> populateCurrencyIds();

	public List<Object[]> populateMaterialIds();

	public List<Object[]> populateUOMIds();
	
	public String getOrganizationId(String userId);
	public List<Object[]> getStepUsers();

}
