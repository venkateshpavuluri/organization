package com.mnt.erp.service;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

public interface InspectionMethodService {
	public String saveInspectionMethodService(Object object,String userId,String userName);
	public List<Object[]>searchInspectionMethodServiceWithId(int id);
	public List<Object[]>searchInspectionMethodService();
	public List<Object[]>selectInspectionMethodService();
	public String updateInspectionMethodService(Object object);
	public String deleteInspectionMethodService(int id);
	public Long getInspectionMethodCount(String name);
	public Long getInspectionMethodCountedit(String name,int imid);
	public List<Object[]> basicSearchInspectionMethod(String label,String operator,String searchName);
}
