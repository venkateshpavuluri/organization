/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;
import com.mnt.erp.dao.BrkDownMaintenanceLogDao;

/**
 * @author venkateshp
 *
 */
public class BrkdownMaintenaceLogServiceImpl implements BreakdownMaintenaceLogService {

	BrkDownMaintenanceLogDao maintenanceLogDao;
	List<Object[]> listOfObjects=null;
	String msg=null;
	
	/**
	 * @return the maintenanceLogDao
	 */
	public BrkDownMaintenanceLogDao getMaintenanceLogDao() {
		return maintenanceLogDao;
	}
	/**
	 * @param maintenanceLogDao the maintenanceLogDao to set
	 */
	public void setMaintenanceLogDao(BrkDownMaintenanceLogDao maintenanceLogDao) {
		this.maintenanceLogDao = maintenanceLogDao;
	}
	private static Logger  logger=Logger.getLogger(BrkdownMaintenaceLogServiceImpl.class);


	@Override
	public String savebrkDownMaintenanceLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=maintenanceLogDao.saveBrkDownMaintenanceLog(object);
		}
		catch(Exception e)
		{
			
		}
		return msg;
	}
	@Override
	public List<Object[]> searchBrkDownMtLogDt() {
		// TODO Auto-generated method stub
		try
		{
			listOfObjects=maintenanceLogDao.searchBrkDownMtLogDt();
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return listOfObjects;
	}
	@Override
	public List<BreakDownMaintenanceLog> editBrkDownMtLogDetails(int maintenanceId) {
		// TODO Auto-generated method stub
		List<BreakDownMaintenanceLog> maintenanceLogs=null;
		try
		{
			maintenanceLogs=maintenanceLogDao.editBrkDownMtLogDetails(maintenanceId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return maintenanceLogs;
	}
	@Override
	public String deleteChilds(
			List<BreakDownMaintenanceSpare> object) {
		// TODO Auto-generated method stub
		try
		{
			msg=maintenanceLogDao.deleteChilds(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String updateBrkDwnMtLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=maintenanceLogDao.updateBrkDwnMtLog(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String deleteBrkDwnMtLog(int id) {
		// TODO Auto-generated method stub
		try
		{
			msg=maintenanceLogDao.deleteBrkDwnMtLog(id);
		}
		catch(Exception e)
		{
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
		listOfObjects=maintenanceLogDao.brkDwnMtLogBasicSearch(dbField, operation, basicSearchId);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listOfObjects;
	}


}
