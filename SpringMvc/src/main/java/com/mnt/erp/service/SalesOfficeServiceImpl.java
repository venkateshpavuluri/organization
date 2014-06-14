/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SalesOfficeDao;

/**
 * @author Sailaja
 * @version 1.0 31-10-2013
 * @build 0.0
 *
 */
public class SalesOfficeServiceImpl implements SalesOfficeService{
	public SalesOfficeDao soDao;
	/*===================Getter and Setters of Dao=============================*/
	public SalesOfficeDao getSoDao() {
		return soDao;
	}

	public void setSoDao(SalesOfficeDao soDao) {
		this.soDao = soDao;
	}
	/*==================================Add Method=============================*/
	String message=null;
	

	@Override
	public String addSalesOffice(Object object,String userid, String userName) {
		// TODO Auto-generated method stub
		 message=soDao.addSalesOffice(object,userid,userName);
			
		 return message;
	}
	/*==================================Search(All) Method=============================*/
	
	@Override
	public List<Object[]> searchSalesOffice() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=soDao.searchSalesOffice();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<Object[]> searchSalesOfficeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=soDao.searchSalesOfficeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updateSalesOffice(Object object) {
		// TODO Auto-generated method stub
		try
		{
	        message=soDao.updateSalesOffice(object);
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Delete Method==============================*/
	@Override
	public String deleteSalesOffice(int id) {
		// TODO Auto-generated method stub
		try
		{
			message=soDao.deleteSalesOffice(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Add Duplicate Check Method==============================*/
	@Override
	public int checkDuplicate(String checkSalesOffice) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=soDao.checkDuplicate(checkSalesOffice);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*==========================Edit Duplicate Check Method==============================*/
	@Override
	public int checkEditDuplicate(String checkSalesOffice, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=soDao.checkEditDuplicate(checkSalesOffice, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*=============================Basic Search Method===================================*/
	@Override
	public List<Object[]> basicSearchSales(String label, String operator,
			String searchName) {
		// TODO Auto-generated method stub
		List<Object[]> objects=null;
		try {
			objects = soDao.basicSearchSales(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	} 


}
