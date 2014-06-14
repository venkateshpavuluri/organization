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
public interface CustomerGroupService 
{
	
	public String addCustomerGroup(Object object,String userId,String userName);
	public List<Object[]> searchCustomerGroup();
	public List<Object[]> searchCustomerGroupWithId(int id);
	public String updateCustomerGroup(Object object);
	public String CustomerGroupDelete(int id);
	public int checkDuplicate(String checkCustGroup);
	public int checkEditDuplicate(String checkCustGroup,int id);
	public List<Object[]> basicSearchCustomerGroup(String label,String operator,String searchName);
}
