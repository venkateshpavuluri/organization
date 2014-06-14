/**
 * 
 */
package com.mnt.erp.service;

import java.util.Iterator;
import java.util.List;

import com.mnt.erp.bean.ProjectTask;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.dao.ProjectTaskDao;

/**
 * @author devi
 *
 */
public class ProjectTaskServiceImpl implements ProjectTaskService{
	String msg=null;
	List<Object[]> list=null;

	ProjectTaskDao PTaskDao;

	public ProjectTaskDao getPTaskDao() {
		return PTaskDao;
	}

	public void setPTaskDao(ProjectTaskDao pTaskDao) {
		PTaskDao = pTaskDao;
	}
	@Override
	public String saveProjectTask(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try
		{
			msg=PTaskDao.saveProjectTask(object, userId, userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	 public List<Object[]> getProjectIds(){
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
				 list = PTaskDao.getProjectIds();
				}
				catch(Exception e)
				{
					
				}
				return list; 
		 }
	 public List<Object[]> getProjectResourceIds(){
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
				 list = PTaskDao.getProjectResourceIds();
				}
				catch(Exception e)
				{
					
				}
				return list; 
		 }
	 @Override
		public List<Object[]> searchProjectTask() {
			// TODO Auto-generated method stub
			try
			{
				list=PTaskDao.searchProjectTask();
				
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
		@Override
		public List<Object[]> basicSearchProjectTask(String dbField,
				String operation, String basicSearchId) {
			// TODO Auto-generated method stub
			try
			{
				
				list=PTaskDao.basicSearchProjectTask(dbField, operation, basicSearchId);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return list;
		}

		@Override
		public String deleteChildRecords(Object object) {
			// TODO Auto-generated method stub
			try
			{
				msg=PTaskDao.deleteChildRecords(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public String deleteProjectTask(int projectId) {
			// TODO Auto-generated method stub
			try
			{
				msg=PTaskDao.deleteProjectTask(projectId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}
		@Override
		public List<ProjectTask> editProjectTaskDetails(int ptaskId) {
			// TODO Auto-generated method stub
			Iterator<Object[]> iterator=null;
			List<ProjectTask> task=null;
			try
			{
				task=PTaskDao.editProjectTaskDetails(ptaskId);
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return task;
		}

		@Override
		public String updateProjectTaskDetails(Object object) {
			// TODO Auto-generated method stub
			try
			{
				msg=PTaskDao.updateProjectTaskDetails(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}


}
