/**

 *
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.CustomerGroupDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class CustomerGroupServiceImpl implements CustomerGroupService
{
		public CustomerGroupDao cgdao;
		String message;
		List<Object[]> objects;
	/*=====================Add Method=================================*/
		@Override
		public String addCustomerGroup(Object object,String userId,String userName)
		{
			 message=cgdao.addCustomerGroup(object,userId,userName);
			 return message;
		}
	/*=========================Getters and Setters Of Dao =======================*/
		public CustomerGroupDao getCgdao() 
		{
			return cgdao;
		}
	
		public void setCgdao(CustomerGroupDao cgdao)
		{
			this.cgdao = cgdao;
		}
	/*=========================Search(All) Method =======================*/
		@Override
		public List<Object[]> searchCustomerGroup()
		{
			List<Object[]> list=null;
			try
			{
				list=cgdao.searchCustomerGroup();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	/*=========================Search(With id) Method =======================*/
		@Override
		public List<Object[]> searchCustomerGroupWithId(int id)
		{
			List<Object[]> list=null;
			try
			{
				list=cgdao.searchCustomerGroupWithId(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	/*=========================Update Method=======================*/
		@Override
		public String updateCustomerGroup(Object object)
		{
			try
			{
		      message=cgdao.updateCustomerGroup(object);	
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*=========================Delete Method =======================*/
		@Override
		public String CustomerGroupDelete(int id)
		{
			try
			{
				message=cgdao.customerGroupDelete(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*=========================Add Duplicate Checking Method=======================*/
		@Override
		public int checkDuplicate(String checkCustGroup)
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=cgdao.checkDuplicate(checkCustGroup);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
	/*=========================Edit Duplicate Checking Method =======================*/
		@Override
		public int checkEditDuplicate(String checkCustGroup, int id) 
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=cgdao.checkEditDuplicate(checkCustGroup,id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
		@Override
		public List<Object[]> basicSearchCustomerGroup(String label,
				String operator, String searchName) {
			try {
				objects = cgdao.basicSearchCustomerGroup(label, operator, searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return objects;
		}

}
