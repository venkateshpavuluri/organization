/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.bean.Project;;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface ProjectService  
{

	public boolean saveProject(Project project);
	public int duplicateCheckProject(String project,String id);
	public List<Object[]> getOrgId();
	public List<Object[]> basicSearchProject(String label, String operator,String searchName);
	public List<Object> editProject(int id);
	public boolean updateProject(Project project);
	public boolean deleteProject(int id);
	public List<Object[]> getProjectId();
	public List<Object[]> getManagerId();
	public List<Object[]> getStatusId();
	public List<Object[]> getSalesOrder();

	
}
