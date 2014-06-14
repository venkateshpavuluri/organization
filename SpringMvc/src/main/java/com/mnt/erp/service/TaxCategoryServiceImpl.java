/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.dao.TaxCategoryDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class TaxCategoryServiceImpl implements TaxCategoryService
{
	    TaxCategoryDao dao;
	    List<Object[]> objects;
	  /*=========================Getters and Setters Of Dao========================================*/
		public TaxCategoryDao getDao() 
		{
		return dao;
	    }
	    public void setDao(TaxCategoryDao dao)
		{
			this.dao = dao;
		}
	  /*==========================Tax Category Select Method==============================*/
		@Override
		public List<Object[]> selectTaxCtegory()
		{
			// TODO Auto-generated method stub
			List<Object[]> list=null;
			try
			{
				list=dao.selectTaxCtegory();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
		public String message;
	/*==========================Add Method==============================*/
		@Override
		public String addTaxCategory(Object object,String userId,String userName) 
		{
			// TODO Auto-generated method stub
			 message=dao.addTaxCategory(object, userId, userName);
			 return message;
				
		}
		public TaxCategoryDao getTcdao()
		{
			return dao;
		}
		public void setTcdao(TaxCategoryDao tcdao)
		{
			this.dao = dao;
		}
	/*==========================Search(All) Method==============================*/
		@Override
		public List<Object[]> searchTaxCategory()
		{
			// TODO Auto-generated method stub
			List<Object[]> list=null;
			try
			{
				list=dao.searchTaxCategory();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	/*==========================Search(With Id) Method==============================*/
		@Override
		public List<Object[]> searchTaxCategoryWithId(int id)
		{
			// TODO Auto-generated method stub
			List<Object[]> list=null;
			try
			{
				list=dao.searchTaxCategoryWithId(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	/*==========================Update Method==============================*/
		@Override
		public String updateTaxCategory(Object object)
		{
			// TODO Auto-generated method stub
			try
			{
				message=dao.updateTaxCategory(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*==========================Delete Method==============================*/
		@Override
		public String deleteTaxCategory(int id)
		{
			// TODO Auto-generated method stub
		  try
		  {
			  message=dao.deleteTaxCategory(id);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  return message;
		}
	/*==========================Add Duplicate Checking Method==============================*/
		@Override
		public int checkDuplicate(String checkTCType, String checkTCTypeCode)
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=dao.checkDuplicate(checkTCType, checkTCTypeCode);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
		
	/*==========================Edit Duplicate Checking Method==============================*/
		@Override
		public int checkEditDuplicate(String checkTCType, String checkTCTypeCode,int id)
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=dao.checkEditDuplicate(checkTCType, checkTCTypeCode,id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
		@Override
		public List<Object[]> basicSearchTaxCategory(String label,
				String operator, String searchName) {
			try {
				objects = dao.basicSearchTaxCategory(label, operator, searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return objects;
		}
	

}
