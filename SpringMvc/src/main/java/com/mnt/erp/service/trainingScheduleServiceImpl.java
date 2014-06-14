/**
 * 
 */
package com.mnt.erp.service;

import java.util.Iterator;
import java.util.List;

import com.mnt.erp.bean.TrainingSchedule;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.dao.trainingScheduleDao;

/**
 * @author devi
 *
 */
public class trainingScheduleServiceImpl implements TrainingScheduleService{
	trainingScheduleDao tScheduleDao;
	String msg=null;
	List<Object[]> list=null;

	public trainingScheduleDao gettScheduleDao() {
		return tScheduleDao;
	}

	public void settScheduleDao(trainingScheduleDao tScheduleDao) {
		this.tScheduleDao = tScheduleDao;
	}
	
	@Override
	public List<Object[]> getTrainingCategoryIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = tScheduleDao.getTrainingCategoryIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> getEmployeeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = tScheduleDao.getEmployeeIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> getOrganizationIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = tScheduleDao.getOrganizationIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String saveTrainingSchedule(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try
		{
			msg=tScheduleDao.saveTrainingSchedule(object, userId, userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchTrainingSchedule() {
		// TODO Auto-generated method stub
		try
		{
			
			list=tScheduleDao.searchTrainingSchedule();
					
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
			
			
			list=tScheduleDao.basicSearchTrainingSchedule(dbField, operation, basicSearchId);
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
		Iterator<Object[]> iterator=null;
		List<TrainingSchedule> tsche=null;
		try
		{
			tsche=tScheduleDao.editTrainingScheduleDetails(tScheduleId);
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tsche;
	}

	@Override
	public String updateTrainingScheduleDetails(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=tScheduleDao.updateTrainingScheduleDetails(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteChildRecords(Object object) {
		// TODO Auto-generated method stub
		try
		{
			msg=tScheduleDao.deleteChildRecords(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteTrainingSchedule(int tScheduleId) {
		// TODO Auto-generated method stub
		try
		{
			msg=tScheduleDao.deleteTrainingSchedule(tScheduleId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	
	@Override
	public List<Object[]> getTrainingSchedule(String tsche) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		 list = tScheduleDao.setTrainingScheduleSearch(tsche);
		}
		catch(Exception e)
		{
			
		}
		return list;
	}


}
