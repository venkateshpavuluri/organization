/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.BreakDownMaintenance;
import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;

/**
 * @author venkateshp
 * @version 1.0 22-04-2014
 */
public class BrkDownMaintenanceLogDaoImpl extends HibernateDaoSupport implements BrkDownMaintenanceLogDao {
private Logger logger=Logger.getLogger(BrkDownMaintenanceLogDaoImpl.class);

	String msg=null;
	String sql=null;
	List<Object[]> listOfObjects=null;
	public String saveBrkDownMaintenanceLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			Serializable id=getHibernateTemplate().save(object);
			if(id!=null)
			{
				msg="S";
			}
		}
		catch(Exception e)
		{
			msg="F";
			logger.error(e.getMessage());
		}
		return msg;
	}
	@Override
	public List<Object[]> searchBrkDownMtLogDt() {
		// TODO Auto-generated method stub
		try
		{
			sql="select b.brkdownMaintenaceLogId,b.logNo,b.startDt,b.endDt,b.repairedBy,b.brkdwnMiant from com.mnt.erp.bean.BreakDownMaintenanceLog b";
			listOfObjects=getHibernateTemplate().find(sql);
		
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return listOfObjects;
	}
	@Override
	public List<BreakDownMaintenanceLog> editBrkDownMtLogDetails(int maintenanceId) {
		// TODO Auto-generated method stub
		List<BreakDownMaintenanceLog>  maintenanceLogs=null;
		try
		{
			sql="from com.mnt.erp.bean.BreakDownMaintenanceLog b where b.brkdownMaintenaceLogId="+maintenanceId;
			maintenanceLogs=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return maintenanceLogs;
	}
	@Override
	public String deleteChilds(
			List<BreakDownMaintenanceSpare> object) {
		// TODO Auto-generated method stub
		try
		{
			getHibernateTemplate().deleteAll(object);
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
	public String updateBrkDwnMtLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			getHibernateTemplate().update(object);
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
	public String deleteBrkDwnMtLog(int id) {
		// TODO Auto-generated method stub
		try
		{
			BreakDownMaintenanceLog maintenanceSpare=new BreakDownMaintenanceLog();
			maintenanceSpare.setBrkdownMaintenaceLogId(id);
			BreakDownMaintenanceLog logs=(BreakDownMaintenanceLog)getHibernateTemplate().get(BreakDownMaintenanceLog.class,id);
			List<BreakDownMaintenanceSpare> listOfSpares=logs.getBrkDownMtSpare();
			getHibernateTemplate().deleteAll(listOfSpares);
			getHibernateTemplate().delete(maintenanceSpare);
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
	public List<Object[]> brkDwnMtLogBasicSearch(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try
		{
		
			sql="select b.brkdownMaintenaceLogId,b.logNo,b.startDt,b.endDt,b.repairedBy,b.brkdwnMiant from com.mnt.erp.bean.BreakDownMaintenanceLog b where b."
					+ dbField + "" + operation + basicSearchId;
			//Object[] parameters = { basicSearchId };
			listOfObjects=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listOfObjects;
	}
	
	

}
