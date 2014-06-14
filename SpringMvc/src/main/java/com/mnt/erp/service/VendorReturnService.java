/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 */
public interface VendorReturnService {
	public List<Object> getVendorReturnAdvance(String columns, String opeator,
			String advanceSearchText);

	public List<Object> getVendorReturn(String vendorReturn);

	public List<Object[]> getPurchaseOrderIds();

	public String addVendorReturn(Object object);

	public List<Object> searchVendorReturn();

	public List<Object> searchVendorReturnWithId(int id);

	public List<Object> basicSearchVendorReturn(String label, String operator,
			String searchName);

	public String deleteVendorReturn(int id);

	public List<Object> editVendorReturnWithId(int qid);

	public String updateVendorReturn(Object object);

	public int checkDuplicate(String checkVrNo);

	public int checkEditDuplicate(String checkVrNo, int id);

	public String deleteVendorReturnLine(int kk);

	public List<Object[]> getRejQty(int poId,int grId,String mtId,String bNo);

	public boolean updateGRLQtyReturns(final int grId,final String matId,final String bNo,
			final float returnQty);
	public boolean updateGRLQtys(final int grId, final String matId,
			final String bNo, final float retQty,final float rejQty);

}
