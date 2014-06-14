/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
public interface InspLotIndResService {
	
	public boolean saveInspLotIndRes(Object object);

	public List<Object[]> searchInspLotIndRes();
	
	public List<Object[]> advSearchInspLotIndRes(String labels,String opts,String advText);

	public List<Object> searchInspLotIndResWithId(int inspId);

	public boolean updateInspLotIndRes(Object object);

	public boolean deleteInspLotIndRes(int inspId);

	public boolean deleteInspLotIndResLine(int inspLineId);

	public List<Object[]> basicSearchInspLotIndRes(String label,
			String operator, Double searchName);

}
