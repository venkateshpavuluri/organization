/**
 @copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 * 
 */
public interface VendorReturnDao {

	public List<Object> vendorReturnAdvanceSearch(String name);

	public List<Object> setVendorReturnSearch(String name);

	public List<Object[]> getPurchaseOrderIds();

	public String addVendorReturn(Object object);

	public List<Object> searchVendorReturn();

	public List<Object> searchVendorReturnWithId(int id);

	public List<Object> basicSearchVendorReturn(String label, String operator,
			String searchName);

	public String deleteVendorReturn(int id);

	public List<Object> editVendorReturnWithId(int vrid);

	public String updateVendorReturn(Object object);

	public int checkDuplicate(String checkVrNo);

	public int checkEditDuplicate(String checkVrNo, int id);

	public String deleteVendorReturnLine(int kk);

	public List<Object[]> getRejQty(int poId,int grId,String mtId,String bNo);

	public boolean updateGRLQtyReturns(int grId, String matId, String bNo,
			float returnQty);
	public boolean updateGRLQtys(final int grId, final String matId,
			final String bNo, final float retQty,final float rejQty);

}
