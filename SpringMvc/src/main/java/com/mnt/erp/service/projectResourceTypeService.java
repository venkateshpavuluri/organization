package com.mnt.erp.service;

import java.util.List;

public interface projectResourceTypeService {

	public String saveProjectResourceType(Object object,String userId,String userName);
	public long checkProjectResourceType(String type);
	public List<Object[]> searchProjectResourceType();
	public List<Object[]> searchProjectResourceTypeWithId(int id);
	public List<Object[]> basicSearchProjectResourceType(String label,String operator,String searchName);
	public String deleteProjectResourceType(int id);
	public String updateProjectResourceType(Object object);
	public List<Object[]> selectProjectResourceType();
	public long updateCheckProjectResourceType(String type, int Id);
}
