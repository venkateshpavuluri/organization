/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ReasonForMovementDao;

/**
 * @author Sailaja
 * @version 1.0 30-10-2013
 * @build 0.0
 *
 */
public class ReasonForMovementServiceImpl implements ReasonForMovementService{
	
	public ReasonForMovementDao rfmDao;
	String message=null;
	/*======================Getter and Setters of Dao=====================*/
	
	public ReasonForMovementDao getRfrDao() {
		return rfmDao;
	}

	public void setRfmDao(ReasonForMovementDao rfmDao) {
		this.rfmDao = rfmDao;
	}
	/*======================Add Method=============================================*/
	@Override
	public String addReasonForMovement(Object object) {
		// TODO Auto-generated method stub
		 message=rfmDao.addReasonForMovement(object);
			
		 return message;
	}
	/*======================Search(All) Method=====================================*/
	@Override
	public List<Object[]> searchReasonForMovement() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=rfmDao.searchReasonForMovement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*======================Search(With Id) Method=================================*/
	@Override
	public List<Object[]> searchReasonForMovementWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=rfmDao.searchReasonForMovementWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==============================Update Method==================================*/
	@Override
	public String updateReasonForMovement(Object object) {
		// TODO Auto-generated method stub
		try
		{
	        message=rfmDao.updateReasonForMovement(object);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*======================Delete Method==========================================*/
	@Override
	public String deleteReasonForMovement(int id) {
		// TODO Auto-generated method stub
		try
		{
			message=rfmDao.deleteReasonForMovement(id);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*======================Add Duplicate Checking Method==========================*/
	@Override
	public int checkDuplicate(String checkReasonForMovement) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=rfmDao.checkDuplicate(checkReasonForMovement);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*======================Edit Duplicate Checking Method=========================*/
	@Override
	public int checkEditDuplicate(String checkReasonForMovement, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=rfmDao.checkEditDuplicate(checkReasonForMovement, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*======================Basic Search Method=====================================*/
	@Override
	public List<Object[]> basicSearchRFM(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects=null;
		try {
			objects = rfmDao.basicSearchRFM(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}


}
