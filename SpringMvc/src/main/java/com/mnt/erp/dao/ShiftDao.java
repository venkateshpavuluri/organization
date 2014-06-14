package com.mnt.erp.dao;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

public interface ShiftDao {
	public String saveShift(Object shiftObject,String userId,String userName);
	public List<Object[]>searchShiftWithId(int id);
	public List<Object[]>searchShift();
	public List<Object[]>selectShift();
	public String updateShift(Object shiftupdate);
	public String deleteShift(int id);
	public Long getShiftCount(String name);
	public Long getShiftCountedit(String name,int shiftid);
	public List<Object[]> basicSearchShift(String label,String operator,String searchName);
}
