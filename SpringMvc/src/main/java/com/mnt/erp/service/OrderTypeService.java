/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public interface OrderTypeService
{
	
	public String addOrderType(Object object,String userId,String userName);
	public List<Object[]> searchOrderType();
	public List<Object[]> searchOrderTypeWithId(int id);
	public String updateOrderType(Object object);
	public String deleteOrderType(int id);
	public int checkDuplicate(String checkOTType);
	public int checkEditDuplicate(String checkOTType,int id);
	public List<Object[]> basicSearchOrderType(String label,String operator,String searchName);

}
