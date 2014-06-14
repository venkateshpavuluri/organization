package com.mnt.erp.service;

import java.util.List;

public interface projectResourceService {
	
	public String saveProjectResource(Object shiftserviceobject,String userId,String userName);
	public List<Object[]>searchProjectResourceServiceWithId(int id);
	public List<Object[]>searchProjectResourceService();
	public List<Object[]>selectProjectResourceService();
	public String updateProjectResourceService(Object updateshiftservice);
	public String deleteProjectResourceService(int id);
	public Long getProjectResourcecount(int id);
	public Long getProjectResourcecountedit(String name,int shiftid);
	public List<Object[]> basicSearchProjectResource(String label,String operator,String searchName);
	public List<Object[]>selectEmployeeService();
	public List<Object[]>selectDesgService();
	public List<Object[]>selectPrtypeService();
	public List<Object[]>selectProjectService();
	public List<Object[]>selectUomService();

}
