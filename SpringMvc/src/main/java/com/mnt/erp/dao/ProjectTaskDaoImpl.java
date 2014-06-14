/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ProjectTask;
import com.mnt.erp.bean.ProjectTaskDocument;
import com.mnt.erp.bean.ProjectTaskResource;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.bean.VacancyDetailLine;

import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class ProjectTaskDaoImpl extends HibernateDaoSupport implements ProjectTaskDao{
	String msg=null;
	List<Object[]> list=null;
	String sql=null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id=null;
	
	
	public String saveProjectTask(Object object,String userId,String userName)
	{
		
		try
		{
			ProjectTask ptask=(ProjectTask)object;
			id=getHibernateTemplate().save(ptask);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","ProjectTask","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}
	public List<Object[]> getProjectIds(){
		try
		{
			sql="select v.projectId,v.projectName from Project v ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> getProjectResourceIds(){
		try
		{
			sql="select v.projectResource_Id from projectResourceBean v ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchProjectTask() {
		// TODO Auto-generated method stub
		try
		{
			sql="select p.projectTaskId,p.projectTask,p.prjctDetails,p.plantStartDt,p.plantEndDt,p.actualStartDt,p.actualEndDt,p.durationHrs,p.predessor,p.percentComplete,p.milestone from com.mnt.erp.bean.ProjectTask p ";
			list=getHibernateTemplate().find(sql);
			
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

			
			sql="select p.projectTaskId,p.projectTask,p.prjctDetails,p.plantStartDt,p.plantEndDt,p.actualStartDt,p.actualEndDt,p.durationHrs,p.predessor,p.percentComplete,p.milestone from com.mnt.erp.bean.ProjectTask p where p."
					+ dbField + "" + operation + " ? ";
			Object[] parameters = { basicSearchId };
			list=getHibernateTemplate().find(sql,parameters);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try
		{
			List<ProjectTaskDocument> integers=(List<ProjectTaskDocument>)object;
			if(integers!=null)
			{
				getHibernateTemplate().deleteAll(integers);
				msg="child Rows Deleted Successfully";
			}
			
		}
		catch(Exception e)
		{
			msg="child Rows Did Not Deleted ";
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String deleteProjectTask(int projecttaskId) {
		// TODO Auto-generated method stub
		ProjectTask ptask=null;
		try
		{
			ProjectTask ptask2= new ProjectTask();
			ptask2.setProjectTaskId(projecttaskId);
		
			ptask=(ProjectTask)getHibernateTemplate().get(ProjectTask.class,projecttaskId);
			
			 Set<ProjectTaskDocument> ptaskDoc=ptask.getPTaskDetails();
			
			
			 getHibernateTemplate().deleteAll(ptaskDoc);
			 getHibernateTemplate().delete(ptask2);
			 msg="S";
			 
		}
		catch(Exception e)
		{
			 msg="F";
			e.printStackTrace();
			 
		}
		
		return msg;
	}
	@Override
	public List<ProjectTask> editProjectTaskDetails(int taskId) {
		// TODO Auto-generated method stub    

		List<ProjectTask> ptask=null;
		try
		{
			
			
			sql="from com.mnt.erp.bean.ProjectTask v where v.projectTaskId="+taskId+"";
			ptask=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ptask;
	}
	@Override
	public String updateProjectTaskDetails(Object object) {
		// TODO Auto-generated method stub
		String messagesg=null;
		try
		{
			ProjectTask ptask=(ProjectTask)object;
				getHibernateTemplate().update(ptask);
					messagesg="S";
		}
		catch(Exception e)
		{
			messagesg="S";
			e.printStackTrace();
		}
		return messagesg;
	}
}
