/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.PaymentMethodDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class PaymentMethodServiceImpl implements PaymentMethodService
{
	public PaymentMethodDao pmdao;
	String message;
	List<Object[]> objects;
	/*==========================Add Method==============================*/
	@Override
	public String addPaymentMethods(Object object,String userId,String userName)
	{
		// TODO Auto-generated method stub
		 message=pmdao.addPaymentMethods(object, userId, userName);
		 return message;
					
	}
	/*==========================Getter and Setters Of Dao==============================*/
    public PaymentMethodDao getPmdao()
    {
		return pmdao;
	}
	public void setPmdao(PaymentMethodDao pmdao) 
	{
		this.pmdao = pmdao;
	}

	/*==========================Search(All) Method==============================*/

	@Override
	public List<Object[]> searchPaymentMethods()
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=pmdao.searchPaymentMethods();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Search(With Id) Method==============================*/
	@Override
	public List<Object[]> searchPaymentMethodsWithId(int id)
	{
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=pmdao.searchPaymentMethodsWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	/*==========================Update Method==============================*/
	@Override
	public String updatePaymentMethods(Object object) 
	{
		// TODO Auto-generated method stub
		try
		{
			message=pmdao.updatePaymentMethods(object);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Delete Method==============================*/
	@Override
	public String deletePaymentMethods(int id)
	{
		// TODO Auto-generated method stub
		try
		{
			message=pmdao.deletePaymentMethods(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return message;
	}
	/*==========================Add Duplicate Checking Method==============================*/
	@Override
	public int checkDuplicate(String checkPMethodName)
	{
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=pmdao.checkDuplicate(checkPMethodName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	/*==========================Edit Duplicate Checking Method==============================*/
	@Override
	public int checkEditDuplicate(String checkPMethodName, int id) {
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=pmdao.checkEditDuplicate(checkPMethodName,id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchPaymentMethod(String label,
			String operator, String searchName) {
		try {
			objects = pmdao.basicSearchPaymentMethod(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	

}
