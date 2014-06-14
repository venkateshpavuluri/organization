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
public interface RFQTypeService
{

	public String addRFQType(Object object,String userId,String userName);
	public List<Object[]> searchRFQType();
	public List<Object[]> searchRFQTypeWithId(int id);
	public String updateRFQType(Object object);
	public String deleteRFQType(int id);
	public int checkDuplicate(String checkRFQType);
	public int checkEditDuplicate(String checkRFQType,int id);
	public List<Object[]> basicSearchRFQType(String label,String operator,String searchName);
}
