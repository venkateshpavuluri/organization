package com.mnt.erp.dao;

import java.util.List;

public interface defectClassDao {

	public String saveDefectClass(Object object);
	public long checkDefectClass(String type);
	public List<Object[]> searchDefectClass();
	public String deleteDefectClass(int id);
	public List<Object[]> searchDefectClassWithId(int id);
	public List<Object[]> basicSearchDefectClass(String label,String operator,String searchName);
	public String updateDefectClass(Object object);
	public List<Object[]> selectDefectClass();
	public long updateCheckDefectClass(String type, int Id);
}
