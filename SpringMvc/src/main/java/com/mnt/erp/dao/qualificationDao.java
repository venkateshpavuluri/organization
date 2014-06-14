package com.mnt.erp.dao;

import java.util.List;

public interface qualificationDao {
	public String saveQualification(Object object,String userId,String userName);
	public long checkQualification(String type);
	public List<Object[]> searchQualification();
	public String deleteQualification(int id);
	public List<Object[]> searchQualificationWithId(int id);
	public List<Object[]> basicSearchQualification(String label,String operator,String searchName);
	public String updateQualification(Object object);
	public List<Object[]> selectQualification();
	public long updateCheckQualification(String type, int Id);

}
