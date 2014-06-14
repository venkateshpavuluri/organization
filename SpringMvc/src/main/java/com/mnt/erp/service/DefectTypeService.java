package com.mnt.erp.service;

import java.util.List;

public interface DefectTypeService {
	public String saveDefectTypeService(Object object,String  userId,String userName);
	public List<Object[]>searchDefectTypeServiceWithId(int id);
	public List<Object[]>searchDefectTypeService();
	public List<Object[]>selectDefectTypeService();
	public String updateDefectTypeService(Object object);
	public String deleteDefectTypeService(int id);
	public Long getDefectTypeCount(String name);
	public Long getDefectTypeCountedit(String name,int dtid);
	public List<Object[]> basicSearchDefectType(String label,String operator,String searchName);

}
