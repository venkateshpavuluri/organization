/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.List;

/*
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public interface SchedulingTypeDao {
	
	public int updateCheckScCount(String shType,int shId);
	
	public Long checkSchedulingType(String shType);

	public String saveShedulingType(Object object);

	public List<Object[]> searchShedulingType();

	public List<Object[]> searchShedulingTypeWithId(int sId);

	public String updateShedulingType(Object object);

	public String deleteShedulingType(int sId);

	public List<Object[]> selectShedulingType();
	
	public List<Object[]> basicShedtype(String label,String operator,String searchName);

}
