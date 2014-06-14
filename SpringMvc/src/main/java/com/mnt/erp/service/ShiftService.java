package com.mnt.erp.service;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

public interface ShiftService {
public String saveShiftService(Object shiftserviceobject,String userId,String userName);
public List<Object[]>searchShiftServiceWithId(int id);
public List<Object[]>searchShiftService();
public List<Object[]>selectShiftService();
public String updateShiftService(Object updateshiftservice);
public String deleteShiftService(int id);
public Long getShiftcount(String name);
public Long getShiftcountedit(String name,int shiftid);
public List<Object[]> basicSearchAccoutGroup(String label,String operator,String searchName);
}
