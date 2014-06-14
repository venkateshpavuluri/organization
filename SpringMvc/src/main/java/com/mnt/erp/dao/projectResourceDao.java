package com.mnt.erp.dao;

import java.util.List;

public interface projectResourceDao {
	public String saveProjectResource(Object shiftObject,String userId,String userName);
	public List<Object[]>searchProjectResourceWithId(int id);
	public List<Object[]>searchProjectResource();
	public List<Object[]>selectProjectResource();
	public String updateProjectResource(Object shiftupdate);
	public String deleteProjectResource(int id);
	public Long getProjectResourceCount(int id);
	public Long getProjectResourceCountedit(String name,int shiftid);
	public List<Object[]> basicSearchProjectResource(String label,String operator,String searchName);
	public List<Object[]> getEmployeeIds();
	public List<Object[]> getProjectIds();
	public List<Object[]> getDesgIds();
	public List<Object[]> getPrtypeIds();
	public List<Object[]> getUomIds();

}
