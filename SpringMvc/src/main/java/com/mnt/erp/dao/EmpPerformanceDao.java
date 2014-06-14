package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.EmpPerformance;

public interface EmpPerformanceDao {
	public Long updateCheckEmpPerformance(String performanceReview,int performanceReviewId);

	public Long checkEmpPerformance(String employee);
	
	public String saveEmpPerformanceDetails(Object object);

	public List<Object[]> searchEmpPerformance();

	public List<EmpPerformance> searchEmpPerformanceWithId(int id);

	public String updateEmpPerformance(Object object);

	public String deleteEmpPerformance(int id);
	
	public List<Object[]> selectEmployee();
	
	public List<Object[]> selectStatus();
	
	public List<Object[]> selectKpi();
	
	public String deleteEmpPerformanceDetail(int kk);
	
	public List<Object[]> basicSearchEmpPerformance(String label,String operator,String searchName);
}
