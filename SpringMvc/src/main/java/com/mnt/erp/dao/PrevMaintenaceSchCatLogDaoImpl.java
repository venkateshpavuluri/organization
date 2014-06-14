/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;
import com.mnt.erp.bean.PrevMaintenanceSchCatLog;
import com.mnt.erp.bean.PrevMaintenanceSchCatLogSpare;
/**
 * @author venkateshp
 *@version 1.0 22-04-2014
 */
public class PrevMaintenaceSchCatLogDaoImpl extends HibernateDaoSupport implements PrevMaintenaceSchCatLogDao {
private static Logger logger=Logger.getLogger(PrevMaintenaceSchCatLogDaoImpl.class);
private 	String msg=null;
	private List<Object[]> listOfObjects=null; 
	private String sql=null;
	public String savePreMtSchCatLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
		Serializable id=getHibernateTemplate().save(object);
		if(id!=null)
		{
			msg="S";
		}
		else
		{
			msg="F";
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.error(e.getMessage());
			msg="F";
		}
		return msg;
	}

	@Override
	public List<Object[]> searchPreMtSchCatLog() {
		// TODO Auto-generated method stub
		try
		{
			sql="select p.prevMaintenanceSchCatLogId,p.maintenanceDT,p.maintainedBy,p.prevMtSchCats,p.statusDetails from com.mnt.erp.bean.PrevMaintenanceSchCatLog p";
			listOfObjects=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		return listOfObjects;
	}

	@Override
	public List<PrevMaintenanceSchCatLog> editPreMtSchCatLog(int maintenanceId) {
		// TODO Auto-generated method stub
		List<PrevMaintenanceSchCatLog>  catLogs=null;
		try
		{
			sql="from com.mnt.erp.bean.PrevMaintenanceSchCatLog p where p.prevMaintenanceSchCatLogId="+maintenanceId;
			catLogs=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return catLogs;
	}

	@Override
	public String deleteChilds(List<PrevMaintenanceSchCatLogSpare> object) {
		// TODO Auto-generated method stub
		try
		{
			getHibernateTemplate().deleteAll(object);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String updatePreMtSchCatLog(Object object) {
		// TODO Auto-generated method stub
		try
		{
			getHibernateTemplate().update(object);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deletePreMtSchCatLog(int id) {
		// TODO Auto-generated method stub
		try
		{
			PrevMaintenanceSchCatLog catLog=new PrevMaintenanceSchCatLog();
			catLog.setPrevMaintenanceSchCatLogId(id);
			PrevMaintenanceSchCatLog schCatLog=(PrevMaintenanceSchCatLog)getHibernateTemplate().get(PrevMaintenanceSchCatLog.class, id);
			List<PrevMaintenanceSchCatLogSpare> catLogSpares=schCatLog.getPrevMtSchCatLogSpares();
			getHibernateTemplate().deleteAll(catLogSpares);
			getHibernateTemplate().delete(catLog);
			msg="S";
		}
		catch(Exception e)
		{
			msg="F";
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
			sql="select p.prevMaintenanceSchCatLogId,p.maintenanceDT,p.maintainedBy,p.prevMtSchCats,p.statusDetails from com.mnt.erp.bean.PrevMaintenanceSchCatLog p where p."
					+ dbField + "" + operation +"?";
		logger.info("sql iss=="+sql);
		Object[] parameters = { basicSearchId };
			listOfObjects=getHibernateTemplate().find(sql,parameters);
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return listOfObjects;
	}

}
