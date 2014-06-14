/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 */
public interface ItemCategoryService 
{
	public String addItemCategory(Object object,String userId,String userName);
	public List<Object[]> searchItemCategory();
	public List<Object[]> searchItemCategoryWithId(int id);
	public String updateItemCategory(Object object);
	public String deleteItemCategory(int id);
	public int checkDuplicate(String checkItemCategory);
	public int checkEditDuplicate(String checkItemCategory,int id);
	public List<Object[]> basicSearchItemCategory(String label,String operator,String searchName);

}
