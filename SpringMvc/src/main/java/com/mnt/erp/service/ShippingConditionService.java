/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/*
 * @author Naresh
 * @version 1.0 19-09-2013
 */
public interface ShippingConditionService {

	public int updateCheckScCount(String scName, int scId);

	public Long checkShippingCndCount(String scName);

	public String saveShippingCondition(Object object,String userId,String userName);

	public List<Object[]> searchShippingCondition();

	public List<Object[]> searchShippingConditionWithId(int id);

	public String updateShippingCondition(Object object);

	public String deleteShippingCondition(int id);

	public List<Object[]> selectShippingCondition();
	
	public List<Object[]> basicShipCnd(String label,String operator,String searchName);

}
