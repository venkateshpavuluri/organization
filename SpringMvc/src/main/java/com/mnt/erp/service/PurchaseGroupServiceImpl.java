/**
 @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.PurchaseGroup;
import com.mnt.erp.dao.PurchaseGroupDao;

/**
 * @author Sailaja	
 * @version 1.0 26-10-2013
 * @build 0.0
 *
 */

public class PurchaseGroupServiceImpl implements PurchaseGroupService{
	
	
	public PurchaseGroupDao pgDao;
	List<Object[]> list=null;
	  List<Object[]> objects=null;
	/*==========================Dao getter and Setter Methods==============================*/
	

	public PurchaseGroupDao getPgDao() {
		return pgDao;
	}

	public void setPgDao(PurchaseGroupDao pgDao) {
		this.pgDao = pgDao;
	}
	/*==========================Add Method==============================*/
   String message=null;
	@Override
	public String addPurchaseGroup(Object object) {
		// TODO Auto-generated method stub
		
			 message=pgDao.addPurchaseGroup(object);
			 return message;
		}
	
	/*==========================Search(All) Method==============================*/
	@Override
	public List<Object[]> searchPurchaseGroup() {
		// TODO Auto-generated method stub
		
		try
		{
			list=pgDao.searchPurchaseGroup();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<PurchaseGroup> searchPurchaseGroupWithId(int id) {
		// TODO Auto-generated method stub
		List<PurchaseGroup> lists=null;
		try
		{
			lists=pgDao.searchPurchaseGroupWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lists;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updatePurchaseGroup(Object object) {
		// TODO Auto-generated method stub
		try
		{
			 message=pgDao.updatePurchaseGroup(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Delete Method==============================*/
	@Override
	public String deletePurchaseGroup(int id) {
		// TODO Auto-generated method stub
		try
		{
			 message=pgDao.deletePurchaseGroup(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Add Duplicate Checking Method==============================*/
	@Override
	public int checkDuplicate(String checkPurchaseGroup) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=pgDao.checkDuplicate(checkPurchaseGroup);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*==========================Edit Duplicate Checking Method==============================*/
	@Override
	public int checkEditDuplicate(String checkPurchaseGroup, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=pgDao.checkEditDuplicate(checkPurchaseGroup,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public List<Object[]> basicSearchPurchaseGroup(String label,
			String operator, String searchName) {
		// TODO Auto-generated method stub
		try {
			objects = pgDao.basicSearchPurchaseGroup(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objects;
	}
	}


