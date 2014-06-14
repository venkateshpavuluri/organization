package com.mnt.erp.dao;

import java.util.List;

public interface InspectionTypeDao {
	public String saveInspectionTypeDetails(Object object,String userId,String userName);

	public List<Object[]> searchInspectionType();

	public List<Object[]> searchInspectionTypeWithId(int id);

	public String updateInspectionType(Object object);

	public String deleteInspectionType(int id);

	public List<Object[]> selectInspectionType();

	public long checkInspectionType(String type);

	public long updateCheckInspectionType(String type, int Id);
	public List<Object[]> basicSearchInspectionType(String label,String operator,String searchName);

}
