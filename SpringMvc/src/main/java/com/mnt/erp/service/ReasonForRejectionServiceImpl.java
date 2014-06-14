/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ReasonForRejectionDao;

/**
 * @author Sailaja
 * @version 1.0 29-10-2013
 * @build 0.0
 *
 */
public class ReasonForRejectionServiceImpl implements ReasonForRejectionService {
	public ReasonForRejectionDao rfrDao;
	String message=null;
	/*======================Getter and Setters of Dao=====================*/
	
	public ReasonForRejectionDao getRfrDao() {
		return rfrDao;
	}

	public void setRfrDao(ReasonForRejectionDao rfrDao) {
		this.rfrDao = rfrDao;
	}
	/*======================Add Method=============================================*/
	@Override
	public String addReasonForRejection(Object object) {
		// TODO Auto-generated method stub
		 message=rfrDao.addReasonForRejection(object);
			
		 return message;
	}
	/*======================Search(All) Method=====================================*/
	@Override
	public List<Object[]> searchReasonForRejection() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=rfrDao.searchReasonForRejection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*======================Search(With Id) Method=================================*/
	@Override
	public List<Object[]> searchReasonForRejectionWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=rfrDao.searchReasonForRejectionWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==============================Update Method==================================*/
	@Override
	public String updateReasonForRejection(Object object) {
		// TODO Auto-generated method stub
		try
		{
	        message=rfrDao.updateReasonForRejection(object);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*======================Delete Method==========================================*/
	@Override
	public String deleteReasonForRejection(int id) {
		// TODO Auto-generated method stub
		try
		{
			message=rfrDao.deleteReasonForRejection(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*======================Add Duplicate Checking Method==========================*/
	@Override
	public int checkDuplicate(String checkReasonForRejection) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=rfrDao.checkDuplicate(checkReasonForRejection);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*======================Edit Duplicate Checking Method=========================*/
	@Override
	public int checkEditDuplicate(String checkReasonForRejection, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=rfrDao.checkEditDuplicate(checkReasonForRejection, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*======================Basic Search Method=====================================*/
	@Override
	public List<Object[]> basicSearchRFR(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects=null;
		try {
			objects = rfrDao.basicSearchRFR(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
