package com.mnt.erp.service;

import java.util.List;

public interface qualificationService {
	public String saveQualification(Object object,String userId,String userName);
	public long checkQualification(String type);
	public List<Object[]> searchQualification();
	public List<Object[]> searchQualificationWithId(int id);
	public List<Object[]> basicSearchQualification(String label,String operator,String searchName);
	public String deleteQualification(int id);
	public String updateQualification(Object object);
	public List<Object[]> selectQualification();
	public long updateCheckQualification(String type, int Id);

}
