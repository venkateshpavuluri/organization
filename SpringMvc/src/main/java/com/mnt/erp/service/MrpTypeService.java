/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author sailajach
 * @version 1.0 25-01-2014
 * @build 0.0
 */
public interface MrpTypeService {
	public String addMrpType(Object object);
	public List<Object[]> searchMrpType();
	public List<Object[]> searchMrpTypeWithId(int id);
	public String updateMrpType(Object object);
	public String deleteMrpType(int id);
	public int checkDuplicate(String checkMrpType);
	public int checkEditDuplicate(String checkMrpType,int id);
	public List<Object[]> basicSearchMrpType(String label,String operator,String searchName);
	

}
