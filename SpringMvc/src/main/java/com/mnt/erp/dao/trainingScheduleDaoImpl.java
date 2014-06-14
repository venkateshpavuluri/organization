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

import com.mnt.erp.bean.TrainingSchedule;
import com.mnt.erp.bean.TrainingScheduleDetail;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class trainingScheduleDaoImpl extends HibernateDaoSupport implements trainingScheduleDao{
	String msg=null;
	List<Object[]> list=null;
	String sql=null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id=null;
	
	static Logger logger=Logger.getLogger(trainingScheduleDaoImpl.class);
	public String saveTrainingSchedule(Object object,String userId,String userName)
	{
		
		try
		{
			TrainingSchedule tSchedule=(TrainingSchedule)object;
			id=getHibernateTemplate().save(tSchedule);
			
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","tSchedule","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
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
	
	@Override
	public List<Object[]> getTrainingCategoryIds() {
		// TODO Auto-generated method stub
		
		List<Object[]> list=null;
		try
		{
			sql="select o.trainingCategoryId,o.trainingCategory from TrainingCategory o";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<Object[]> getOrganizationIds() {
		// TODO Auto-generated method stub
		
		List<Object[]> list=null;
		try
		{
			sql="select o.orgId,o.orgName from Organization o";
			 list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Object[]> getEmployeeIds() {
		// TODO Auto-generated method stub
		
		List<Object[]> list=null;
		try
		{
			sql="select o.employee_Id,o.fName from Employee o";
			 list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchTrainingSchedule() {
		// TODO Auto-generated method stub
		try
		{
			sql="select v.trainingSchedule_Id,v.date,v.time,v.venue,v.triner,v.trainingDetails,v.orgDetails from com.mnt.erp.bean.TrainingSchedule v ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> basicSearchTrainingSchedule(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try
		{

			
			sql="select v.trainingSchedule_Id,v.date,v.time,v.venue,v.triner,v.trainingDetails,v.orgDetails from com.mnt.erp.bean.TrainingSchedule v where v."
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
	@Override
	public List<TrainingSchedule> editTrainingScheduleDetails(int tScheduleId) {
		// TODO Auto-generated method stub    

		List<TrainingSchedule> tSchedule=null;
		try
		{
			
			
			sql="from com.mnt.erp.bean.TrainingSchedule v where v.trainingSchedule_Id="+tScheduleId+"";
			tSchedule=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tSchedule;
	}
	@Override
	public String updateTrainingScheduleDetails(Object object) {
		// TODO Auto-generated method stub
		String messagesg=null;
		try
		{
			TrainingSchedule tsche=(TrainingSchedule)object;
					getHibernateTemplate().update(tsche);
					
					messagesg="S";
		}
		catch(Exception e)
		{
			messagesg="S";
			e.printStackTrace();
		}
		return messagesg;
	}
	
	public String deleteTrainingScheduleData(Object object )
	{
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try
		{
			List<TrainingScheduleDetail> integers=(List<TrainingScheduleDetail>)object;
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
	public String deleteTrainingSchedule(int tScheduleId) {
		// TODO Auto-generated method stub
		TrainingSchedule tsche=null;
		try
		{
			TrainingSchedule tSchedule=new TrainingSchedule();
			tSchedule.setTrainingSchedule_Id(tScheduleId);
			
			tsche=(TrainingSchedule)getHibernateTemplate().get(TrainingSchedule.class,tScheduleId);
			 List<TrainingScheduleDetail> tScheduleLines=tsche.getTrainScheduleDetails();
			 
			 
			getHibernateTemplate().deleteAll(tScheduleLines);
			
		
			 getHibernateTemplate().delete(tSchedule);
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
	public List<Object[]> setTrainingScheduleSearch(String name) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			if (name.equalsIgnoreCase("ALL")) {
				sql = "select v.trainingSchedule_Id,v.date,v.time,v.venue,v.triner,v.trainingDetails,v.orgDetails from com.mnt.erp.bean.TrainingSchedule v";

			}

			if (!name.equalsIgnoreCase("ALL")) {
				sql = "select v.trainingSchedule_Id,v.date,v.time,v.venue,v.triner,v.trainingDetails,v.orgDetails from com.mnt.erp.bean.TrainingSchedule vwhere d.trainingSchedule_Id='"
						+ name + "'";

			}
		list = getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			
		}
		return list;
	}



}
