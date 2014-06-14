/**
@Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.PaymentTypeDao;

/**
 * @author sailajach
 *@version 1.0 10-12-2013
 * @Build 0.0
 * 
 */
public class PaymentTypeServiceImpl implements PaymentTypeService{
	public PaymentTypeDao ptdao;
	String message;
    List<Object[]> objects=null;
/*==========================Add Method==============================*/
	@Override
	public String addPaymentType(Object object,String userId,String userName)
	{
		// TODO Auto-generated method stub
		 message=ptdao.addPaymentType(object, userId, userName);
		 return message;
			
	}
/*==========================Getter and Setters Of Dao==============================*/
	public PaymentTypeDao getPtdao() {
		return ptdao;
	}

	public void setPtdao(PaymentTypeDao ptdao) {
		this.ptdao = ptdao;
	}
/*==========================Search(All) Method==============================*/
	@Override
	public List<Object[]> searchPaymentType()
	{
		// TODO Auto-generated method stub
		
			List<Object[]> list=null;
			try
			{
				list=ptdao.searchPaymentType();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
	}
	

	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<Object[]> searchPaymentTypeWithId(int id) 
	{
		// TODO Auto-generated method stub
			List<Object[]> list=null;
			try
			{
				list=ptdao.searchPaymentTypeWithId(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
	}
/*==========================Update Method==============================*/
	@Override
	public String updatePaymentType(Object object)
	{
		// TODO Auto-generated method stub
		try
		{
			message=ptdao.updatePaymentType(object);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
/*==========================Delete Method==============================*/
	@Override
	public String deletePaymentType(int id) 
	{
		// TODO Auto-generated method stub
		try
		{
			message=ptdao.deletePaymentType(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
/*==========================Add Duplicate Checking Method==============================*/
	@Override
	public int checkDuplicate(String checkPaymentType) 
	{
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=ptdao.checkDuplicate(checkPaymentType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
/*==========================Edit Duplicate Checking Method==============================*/
	@Override
	public int checkEditDuplicate(String checkPaymentType, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=ptdao.checkEditDuplicate(checkPaymentType,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchPaymentType(String label,
			String operator, String searchName) {
		// TODO Auto-generated method stub
			try {
				objects = ptdao.basicSearchPaymentType(label, operator, searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return objects;
		}

}
