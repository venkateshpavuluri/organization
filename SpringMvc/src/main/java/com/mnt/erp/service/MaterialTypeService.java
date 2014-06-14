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
public interface MaterialTypeService 
{
	
	public List<Object[]> selectMaterialType();
	public String addMaterialTypeDetails(Object object,String userId,String userName);
	public List<Object[]> searchMaterialType();
	public List<Object[]> searchMaterialTypeWithId(int id);
	public String updateMaterialType(Object object);
	public String materialTypeDelete(int id);
	public int checkDuplicate(String checkMTType,String checkMTTypeCode);
	public int checkEditDuplicate(String checkMTType,String checkMTTypeCode,int id);
	public List<Object[]> basicSearchMaterialType(String label,String operator,String searchName);
}
