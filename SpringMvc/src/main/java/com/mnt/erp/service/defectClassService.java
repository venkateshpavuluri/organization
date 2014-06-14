package com.mnt.erp.service;

import java.util.List;

public interface defectClassService {
	public String saveDefectClass(Object object);
	public long checkDefectClass(String type);
	public List<Object[]> searchDefectClass();
	public List<Object[]> searchDefectClassWithId(int id);
	public List<Object[]> basicSearchDefectClass(String label,String operator,String searchName);
	public String deleteDefectClass(int id);
	public String updateDefectClass(Object object);
	public List<Object[]> selectDefectClass();
	public long updateCheckDefectClass(String type, int Id);
}
