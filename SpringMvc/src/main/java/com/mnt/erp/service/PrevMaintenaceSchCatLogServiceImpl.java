/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;
import com.mnt.erp.bean.PrevMaintenanceSchCatLog;
import com.mnt.erp.bean.PrevMaintenanceSchCatLogSpare;
import com.mnt.erp.dao.PrevMaintenaceSchCatLogDao;

/**
 * @author venkateshp
 *
 */
public class PrevMaintenaceSchCatLogServiceImpl implements PrevMaintenaceSchCatLogService {

	private static Logger logger=Logger.getLogger(PrevMaintenaceSchCatLogServiceImpl.class);
private	PrevMaintenaceSchCatLogDao schCatLogDao;
String msg=null;
private List<Object[]> lisOfObjects=null;
	
	
	
	/**
	 * @return the schCatLogDao
	 */
	public PrevMaintenaceSchCatLogDao getSchCatLogDao() {
		return schCatLogDao;
	}

	/**
	 * @param schCatLogDao the schCatLogDao to set
	 */
	public void setSchCatLogDao(PrevMaintenaceSchCatLogDao schCatLogDao) {
		this.schCatLogDao = schCatLogDao;
	}

	@Override
	public String savePreMtSchCatLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=schCatLogDao.savePreMtSchCatLog(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchPreMtSchCatLog() {
		// TODO Auto-generated method stub
		try
		{
			lisOfObjects=schCatLogDao.searchPreMtSchCatLog();
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return lisOfObjects;
	}

	@Override
	public List<PrevMaintenanceSchCatLog> editPreMtSchCatLog(int maintenanceId) {
		// TODO Auto-generated method stub
		List<PrevMaintenanceSchCatLog> schCatLogs=null;
		try
		{
			 schCatLogs=schCatLogDao.editPreMtSchCatLog(maintenanceId);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return schCatLogs;
	}

	@Override
	public String deleteChilds(List<PrevMaintenanceSchCatLogSpare> object) {
		
		// TODO Auto-generated method stub
		try
		{
			msg=schCatLogDao.deleteChilds(object);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return msg;
	}

	@Override
	public String updatePreMtSchCatLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=schCatLogDao.updatePreMtSchCatLog(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return msg;
	}

	@Override
	public String deletePreMtSchCatLog(int id) {
		// TODO Auto-generated method stub
		try
		{
			msg=schCatLogDao.deletePreMtSchCatLog(id);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> preMtSchCatLogBasicSearch(String dbField,
			String operation, String basicSearchId) {
		// TODO Auto-generated method stub
		try
		{
			lisOfObjects=schCatLogDao.preMtSchCatLogBasicSearch(dbField, operation, basicSearchId);
					
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return lisOfObjects;
	}

}
