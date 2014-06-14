package com.mnt.erp.dao;

import java.util.List;

public interface DefectTypeDao {
	public String saveDefectType(Object object,String userId,String userName);
	public List<Object[]>searchDefectTypeWithId(int id);
	public List<Object[]>searchDefectType();
	public List<Object[]>selectDefectType();
	public String updateDefectType(Object object);
	public String deleteDefectType(int id);
	public Long getDefectTypeCount(String name);
	public Long getDefectTypeCountedit(String name,int dtid);
	public List<Object[]> basicSearchDefectType(String label,String operator,String searchName);

}
