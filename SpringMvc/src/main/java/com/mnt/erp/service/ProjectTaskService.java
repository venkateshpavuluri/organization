/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ProjectTask;
import com.mnt.erp.bean.Vacancy;

/**
 * @author devi
 *
 */
public interface ProjectTaskService {
	public String saveProjectTask(Object object,String userId,String userName);
	 public List<Object[]> getProjectIds();
	 public List<Object[]> getProjectResourceIds();
	 public List<Object[]> searchProjectTask();
	public List<Object[]> basicSearchProjectTask(String dbField,String operation,String basicSearchId);
	public String deleteChildRecords(Object object);
	public String deleteProjectTask(int projectId);
	public List<ProjectTask> editProjectTaskDetails(int ptaskId);
	public String updateProjectTaskDetails(Object object);
	
}
