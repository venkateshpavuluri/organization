/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 24-01-2014
 */
public interface ProductionOrderService {

	public Long updateCheckProdOrder(String poNo, int poId);

	public Long checkProdOrderCout(String poNo);

	public boolean saveProdOrderDetails(Object object);

	public List<Object[]> searchProdOrder();

	public List<Object> searchProdOrderWithId(int poId);

	public boolean updateProdOrder(Object object);

	public boolean deleteProdOrder(int poId);

	public List<Object[]> basicSearchProdOrder(String label, String operator,
			String searchName);
}
