package com.mnt.erp.dao;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

public interface InspectionMethodDao {
	public String saveInspectionMethod(Object object,String userId,String userName);
	public List<Object[]>searchInspectionMethodWithId(int id);
	public List<Object[]>searchInspectionMethod();
	public List<Object[]>selectInspectionMethod();
	public String updateInspectionMethod(Object object);
	public String deleteInspectionMethod(int id);
	public Long getInspectionMethodCount(String name);
	public Long getInspectionMethodCountedit(String name,int imid);
	public List<Object[]> basicSearchInspectionMethod(String label,String operator,String searchName);

}
