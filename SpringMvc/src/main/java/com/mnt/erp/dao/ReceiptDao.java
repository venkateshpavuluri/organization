/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 21-01-2014
 */
public interface ReceiptDao {
	
	public Long updateCheckReceipt(String recNo, int recId);

	public Long checkReceiptCout(String recNo);

	public boolean saveReceiptDetails(Object object);

	public List<Object[]> searchReceipt();
	
	public List<Object[]> advSearchReceipt(String advSearch);

	public List<Object> searchReceiptWithId(int recId);

	public boolean updateReceipt(Object object);

	public boolean deleteReceipt(int recId);

	public List<Object[]> basicSearchReceipt(String label,
			String operator, String searchName);

}
