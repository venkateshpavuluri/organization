package com.mnt.erp.service;

import java.util.List;

public interface workIncedenceService {
	public String saveWorkIncedence(Object object);
	public long checkWorkIncedence(String type);
	public List<Object[]> searchWorkIncedence();
	public List<Object[]> searchWorkIncedenceWithId(int id);
	public List<Object[]> basicSearchWorkIncedence(String label,String operator,String searchName);
	public String deleteWorkIncedence(int id);
	public String updateWorkIncedence(Object object);
	public List<Object[]> selectWorkIncedence();
	public long updateCheckWorkIncedence(String type, int Id);
}
