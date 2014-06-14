/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author devi
 *
 */
public interface processTypeDao {
	public String saveProcessType(Object object);
	public long checkProcessType(String type);
	public List<Object[]> searchProcessType();
	public String deleteProcessType(int id);
	public List<Object[]> searchProcessTypeWithId(int id);
	public List<Object[]> basicSearchProcessType(String label,String operator,String searchName);
	public String updateProcessType(Object object);
	public List<Object[]> selectProcessType();
	public long updateCheckProcessType(String type, int Id);

}
