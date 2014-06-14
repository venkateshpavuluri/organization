/**

 *
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ItemCategoryDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class ItemCategoryServiceImpl implements ItemCategoryService
{
	public ItemCategoryDao icdao;
	String message;
	List<Object[]> objects=null;
	/*==========================Add Method==============================*/
	@Override
	public String addItemCategory(Object object,String userId,String userName) 
	{
		// TODO Auto-generated method stub
		 message=icdao.addItemCategory(object,userId,userName);
			
		 return message;
	}
	/*==========================Getter and Setter Of Dao==============================*/
	public ItemCategoryDao getIcdao() 
	{
		return icdao;
	}

	public void setIcdao(ItemCategoryDao icdao) 
	{
		this.icdao = icdao;
	}
	/*==========================Search(All)Method==============================*/
	@Override
	public List<Object[]> searchItemCategory() 
	{
		// TODO Auto-generated method stub

		List<Object[]> list=null;
		try
		{
			list=icdao.searchItemCategory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<Object[]> searchItemCategoryWithId(int id)
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=icdao.searchItemCategoryWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updateItemCategory(Object object)
	{
		// TODO Auto-generated method stub
		try
		{
	        message=icdao.updateItemCategory(object);	
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Delete Method==============================*/
	@Override
	public String deleteItemCategory(int id)
	{
		// TODO Auto-generated method stub
		try
		{
			message=icdao.deleteItemCategory(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Add Duplicate Check Method==============================*/
	@Override
	public int checkDuplicate(String checkItemCategory)
	{
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=icdao.checkDuplicate(checkItemCategory);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*==========================Edit Duplicate Check Method==============================*/
	@Override
	public int checkEditDuplicate(String checkItemCategory, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=icdao.checkEditDuplicate(checkItemCategory, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchItemCategory(String label,
			String operator, String searchName) {
		try {
			objects =icdao.basicSearchItemCategory(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

}
