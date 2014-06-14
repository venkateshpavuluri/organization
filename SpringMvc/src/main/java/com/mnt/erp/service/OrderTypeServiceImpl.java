/**

 *
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.OrderTypeDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class OrderTypeServiceImpl implements OrderTypeService
{
	public OrderTypeDao otdao;
	String message;
	List<Object[]> objects=null;
	/*==========================Add Method==============================*/
	@Override
	public String addOrderType(Object object,String userId,String userName)
	{
		// TODO Auto-generated method stub
		 message=otdao.addOrderType(object,userId,userName);
			
		 return message;
	}
	/*==========================Getter and Setters Of Dao==============================*/

	public OrderTypeDao getOtdao()
	{
		return otdao;
	}
    public void setOtdao(OrderTypeDao otdao)
	{
		this.otdao = otdao;
	}
    /*==========================Search(All) Method==============================*/
    @Override
	public List<Object[]> searchOrderType()
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=otdao.searchOrderType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Search(With Id)Method==============================*/
	@Override
	public List<Object[]> searchOrderTypeWithId(int id) 
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=otdao.searchOrderTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updateOrderType(Object object)
	{
		// TODO Auto-generated method stub
		try
		{
			 message=otdao.updateOrderType(object);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Delete Method==============================*/
	@Override
	public String deleteOrderType(int id)
	{
		// TODO Auto-generated method stub
		try
		{
			message=otdao.deleteOrderType(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}

	/*==========================Add Duplicate Checking Method==============================*/
	@Override
	public int checkDuplicate(String checkOTType) 
	{
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=otdao.checkDuplicate(checkOTType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*==========================Edit Duplicate Checking Method==============================*/

	@Override
	public int checkEditDuplicate(String checkOTType, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=otdao.checkEditDuplicate(checkOTType,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}

	@Override
	public List<Object[]> basicSearchOrderType(String label, String operator,
			String searchName) {
		try {
			objects = otdao.basicSearchOrderType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

}
