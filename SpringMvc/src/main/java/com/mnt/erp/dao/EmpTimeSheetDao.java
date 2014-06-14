package com.mnt.erp.dao;
import java.util.List;

public interface EmpTimeSheetDao {
	public String saveEmpTimeSheet(Object shiftObject,String userId,String userName);
	public List<Object[]>searchEmpTimeSheetWithId(int id);
	public List<Object[]>searchEmpTimeSheet();
	public List<Object[]>selectEmpTimeSheet();
	public String updateEmpTimeSheet(Object shiftupdate);
	public String deleteEmpTimeSheet(int id);
	public Long getEmpTimeSheetCount(String name);
	public Long getEmpTimeSheetCountEdit(String name,int shiftid);
	public List<Object[]> basicSearchEmpTimeSheet(String label,String operator,String searchName);
	public List<Object[]> getEmployeeIds();
	public List<Object[]> getActivityIds();


}
