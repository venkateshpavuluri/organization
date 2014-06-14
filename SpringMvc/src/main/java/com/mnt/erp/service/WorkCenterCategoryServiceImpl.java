/**
/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.WorkCenterCategoryDao;

/**
 * @author Sailaja
 * @version 1.0 28-10-2013
 * @build 0.0
 * 
 */
public class WorkCenterCategoryServiceImpl implements WorkCenterCategoryService {

	public WorkCenterCategoryDao wccDao;

	/* ===================Getter and Setters of Dao============================= */
	public WorkCenterCategoryDao getWccDao() {
		return wccDao;
	}

	public void setWccDao(WorkCenterCategoryDao wccDao) {
		this.wccDao = wccDao;
	}

	/* ==================================Add Method============================= */
	String message = null;

	@Override
	public String addWorkCenterCategory(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		message = wccDao.addWorkCenterCategory(object, userId, userName);
		return message;
	}

	/*
	 * ==================================Search(All)
	 * Method=============================
	 */

	@Override
	public List<Object[]> searchWorkCenterCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = wccDao.searchWorkCenterCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * ==========================Search(With Id)
	 * Method==============================
	 */
	@Override
	public List<Object[]> searchWorkCenterCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = wccDao.searchWorkCenterCategoryWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* ==========================Update Method============================== */
	@Override
	public String updateWorkCenterCategory(Object object) {
		// TODO Auto-generated method stub
		try {
			message = wccDao.updateWorkCenterCategory(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	/* ==========================Delete Method============================== */
	@Override
	public String deleteWorkCenterCategory(int id) {
		// TODO Auto-generated method stub
		try {
			message = wccDao.deleteWorkCenterCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	/*
	 * ==========================Add Duplicate Check
	 * Method==============================
	 */
	@Override
	public int checkDuplicate(String checkWorkCenterCategory) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = wccDao.checkDuplicate(checkWorkCenterCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	/*
	 * ==========================Edit Duplicate Check
	 * Method==============================
	 */
	@Override
	public int checkEditDuplicate(String checkWorkCenterCategory, int id) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = wccDao.checkEditDuplicate(checkWorkCenterCategory, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	/*
	 * =============================Basic Search
	 * Method===================================
	 */
	@Override
	public List<Object[]> basicSearchWCC(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {
			objects = wccDao.basicSearchWCC(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> WorkCeterCategoryIdGet() {
		List<Object[]> list = null;
		list = wccDao.WorkCeterCategoryIdGet();
		return list;
	}

}
