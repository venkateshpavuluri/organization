/**

 *
 */
package com.mnt.erp.dao;

import java.util.List;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public interface TaxCategoryDao 
{
	public List<Object[]> selectTaxCtegory();
	public String addTaxCategory(Object object,String userId,String userName);
	public List<Object[]> searchTaxCategory();
	public List<Object[]> searchTaxCategoryWithId(int id);
	public String updateTaxCategory(Object object);
	public String deleteTaxCategory(int id);
	public int checkDuplicate(String checkTCType,String checkTCTypeCode);
	public int checkEditDuplicate(String checkTCType,String checkTCTypeCode,int id);
	public List<Object[]> basicSearchTaxCategory(String label,String operator,String searchName);
}
