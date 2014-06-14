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


import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.bean.VacancyVendor;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class vacancyDaoImpl extends HibernateDaoSupport implements vacancyDao{
	String msg=null;
	List<Object[]> list=null;
	String sql=null;
	@Autowired
	AuditLogService auditLogService;
	Serializable id=null;
	
	static Logger logger=Logger.getLogger(DeliveryNoteDaoImpl.class);
	public String saveVacancy(Object object,String userId,String userName)
	{
		
		try
		{
			Vacancy vacancy=(Vacancy)object;
			id=getHibernateTemplate().save(vacancy);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","vacancy","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
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
	public List<Object[]> getVacancyIds() {
		// TODO Auto-generated method stub
		
		List<Object[]> list=null;
		try
		{
			sql="select o.vacancyDetailLineId,o.vacancyDetailNo from VacancyDetailLine o";
			 list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Object[]> searchVacancy() {
		// TODO Auto-generated method stub
		try
		{
			sql="select v.vacancyId,v.postedDate,v.vacancyNo from com.mnt.erp.bean.Vacancy v ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> basicSearchVacancy(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try
		{

			
			sql="select v.vacancyId,v.postedDate,v.vacancyNo from com.mnt.erp.bean.Vacancy v where v."
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
	public List<Vacancy> editVacancyDetails(int vacancyId) {
		// TODO Auto-generated method stub    

		List<Vacancy> vacancys=null;
		try
		{
			
			
			sql="from com.mnt.erp.bean.Vacancy v where v.vacancyId="+vacancyId+"";
			vacancys=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vacancys;
	}
	@Override
	public String updateVacancyDetails(Object object) {
		// TODO Auto-generated method stub
		String messagesg=null;
		try
		{
			Vacancy deliveryNote=(Vacancy)object;
			
			
					getHibernateTemplate().update(deliveryNote);
					messagesg="S";
		}
		catch(Exception e)
		{
			messagesg="S";
			e.printStackTrace();
		}
		return messagesg;
	}
	
	public String deleteVacancyData(Object object )
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
			List<VacancyDetailLine> integers=(List<VacancyDetailLine>)object;
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
	public String deleteVacancy(int vacancyId) {
		// TODO Auto-generated method stub
		Vacancy vacancy=null;
		try
		{
			Vacancy vacancy2=new Vacancy();
			vacancy2.setVacancyId(vacancyId);
			
			vacancy=(Vacancy)getHibernateTemplate().get(Vacancy.class,vacancyId);
			 Set<VacancyDetailLine> vacancyLines=vacancy.getVacancyDetails();
			 
			 
			getHibernateTemplate().deleteAll(vacancyLines);
			
		
			 getHibernateTemplate().delete(vacancy2);
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
	public List<Object[]> setVacancySearch(String name) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			if (name.equalsIgnoreCase("ALL")) {
				sql = "select d.vacancyId,d.postedDate,d.vacancyNo from com.mnt.erp.bean.Vacancy d";

			}

			if (!name.equalsIgnoreCase("ALL")) {
				sql = "select d.vacancyId,d.postedDate,d.vacancyNo from com.mnt.erp.bean.Vacancy d where d.vacancyId='"
						+ name + "'";

			}
		list = getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			
		}
		return list;
	}


	public List<Object[]> getEmployeeMailIds(){
		try
		{
			sql="select v.eMail,v.employee_Id from Employee v ";
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public String saveVacancyVendor(Object object)
	{
		
		try
		{
			VacancyVendor vacancys=(VacancyVendor)object;
	
			id=getHibernateTemplate().save(vacancys);
		
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}

}
