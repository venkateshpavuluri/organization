/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.InterViewResult;
import com.mnt.erp.bean.InterViewSchedule;

/**
 * @author venkateshp
 *
 */
public class InterviewScheduleDaoImpl extends HibernateDaoSupport implements InterviewScheduleDao{
public static Logger logger=Logger.getLogger(InterviewScheduleDao.class);
	
	List<Object[]>  listOfobjects;
	String sql;
	String msg;
	public List<Object[]> searchIVSchedule() {
		// TODO Auto-generated method stub
		try
		{
			sql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i";
			listOfobjects=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
		logger.error(e.getMessage());	
		}
		return listOfobjects;
	}

	@Override
	public List<Object[]> basicSearchIVSchedule(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try
		{
			//int basicid=Integer.parseInt(basicSearchId);
			sql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i where i."
					+ dbField + "" + operation + " ? ";
			Object[] parameters = { basicSearchId };
			listOfobjects=getHibernateTemplate().find(sql,parameters);
			logger.info("with in dao list size iss=="+listOfobjects.size()+"==="+sql+"=="+dbField+"=="+operation+"=="+basicSearchId);
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return listOfobjects;
	}

	@Override
	public List<InterViewSchedule> editIVScheduleDetails(int deliveryNoteId) {
		// TODO Auto-generated method stub
		List<InterViewSchedule> interViewSchedules=null;
		try
		{
			sql="from com.mnt.erp.bean.InterViewSchedule i";
			interViewSchedules=getHibernateTemplate().find(sql);
			logger.info("with in edit size iss=="+interViewSchedules.size());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return interViewSchedules;
	}

	@Override
	public String updateIVScheduleDetails(Object object) {
		// TODO Auto-generated method stub]
		try
		{
			getHibernateTemplate().update(object);
			msg="S";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			msg="F";
		}
		return msg;
	}

	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try
		{
			List<InterViewResult> lsits=(List<InterViewResult>)object;
			getHibernateTemplate().deleteAll(lsits);
			msg="S";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			msg="F";
		}
		return msg;
	}

	@Override
	public String deleteIVSchedule(int deliveryId) {
		// TODO Auto-generated method stub
		try
		{
			InterViewSchedule interViewSchedule=new InterViewSchedule();
			interViewSchedule.setInterviewScheduleId(deliveryId);
			InterViewSchedule schedule=(InterViewSchedule)getHibernateTemplate().get(InterViewSchedule.class,deliveryId);
			List<InterViewResult> interViewResults=schedule.getIvResultDetails();
			
			getHibernateTemplate().deleteAll(interViewResults);
			getHibernateTemplate().delete(interViewSchedule);
			msg="S";
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			msg="F";
		}
		return msg;
	}

	@Override
	public List<Object[]> iVScheduleAdvance(String name) {
		 List<Object[]> list=null;
			try
			{
				
				String hql=null;
				if(name.equalsIgnoreCase("ALL"))
				{
					hql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i";

				}
				
				else
				{	
				hql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i where "+name.trim();
				//hql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i where i.applicantId=3";
				}
				logger.info("sql iss=="+hql+"=="+name);
			  list=getHibernateTemplate().find(hql);
				logger.info("advances result iss===="+list.size());
				
				
					return list;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
	}

	@Override
	public List<Object[]> iVSheduleSearch(String name) {
		List<Object[]> list=null;
		try
		{
			if (name.equalsIgnoreCase("ALL")) {
				sql ="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i";

			}

			if (!name.equalsIgnoreCase("ALL")) {
				sql ="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue,i.interviewScheduleId from com.mnt.erp.bean.InterViewSchedule i where i.interviewScheduleId='"
						+ name + "'";

			}
			logger.info("advanced search query iss=="+sql);
		list = getHibernateTemplate().find(sql);
	
		}
		catch(Exception e)
		{
			
		}
		return list;
	}




}
