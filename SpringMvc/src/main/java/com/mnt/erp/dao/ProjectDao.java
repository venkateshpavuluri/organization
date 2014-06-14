/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Project;

/**
 * @author kirangangone
 * @version 1.0
 *@build 0.0
 */
public interface ProjectDao 
{
	
	public boolean saveProject(Project code);
	public int duplicateCheckProject(String code,String id);
	public List<Object[]> getOrgId();
	public List<Object[]> basicSearchProject(String label, String operator,String searchName);
	public List<Object> editProject(int cId);
	public boolean updateProject(Project code);
	public boolean deleteProject(int id);
	public List<Object[]> getProjectId();
	public List<Object[]> getManagerId();
	public List<Object[]> getStatusId();
	public List<Object[]> getSalesOrder();
	
	}
