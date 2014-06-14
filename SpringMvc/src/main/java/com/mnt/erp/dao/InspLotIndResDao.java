/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Naresh
 *  @version 1.0 17-05-2014
 */
public interface InspLotIndResDao {
	
	public boolean saveInspLotIndRes(Object object);

	public List<Object[]> searchInspLotIndRes();
	
	public List<Object[]> advSearchInspLotIndRes(String advSearch);

	public List<Object> searchInspLotIndResWithId(int inspId);

	public boolean updateInspLotIndRes(Object object);

	public boolean deleteInspLotIndRes(int inspId);

	public boolean deleteInspLotIndResLine(int inspLineId);

	public List<Object[]> basicSearchInspLotIndRes(String label,
			String operator, Double searchName);

}
