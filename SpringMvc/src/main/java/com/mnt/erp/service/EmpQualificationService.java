package com.mnt.erp.service;

import java.util.List;

public interface EmpQualificationService {
	
	public Long updateCheckEmpQualification(String equipment,String planedDate,int maintenancePlanId);

	public Long checkEmpQualificationCout(String equipment,String planedDate);
	
	public String saveEmpQualificationDetails(Object object,String userId,String userName);

	public List<Object[]> searchEmpQualification();

	public List<Object[]> searchEmpQualificationWithId(int id);

	public String updateEmpQualification(Object object);

	public String deleteEmpQualification(int id);
	
	public List<Object[]> selectQualification();
	
	public List<Object[]> selectEmployee();
	
	
	
	public List<Object[]> basicSearchEmpQualification(String label,String operator,String searchName);
}
