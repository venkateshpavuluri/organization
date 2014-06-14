/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.dao.PaymentTermDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class PaymentTermServiceImpl  implements PaymentTermService
{
		public PaymentTermDao ptdao;
		String message;
        List<Object[]> objects=null;
	/*==========================Add Method==============================*/
		@Override
		public String addPaymentTerms(Object object,String userId,String userName)
		{
			// TODO Auto-generated method stub
			 message=ptdao.addPaymentTerms(object, userId, userName);
			 return message;
				
		}
	/*==========================Getter and Setters Of Dao==============================*/
		public PaymentTermDao getPtdao()
		{
			return ptdao;
			
		}
		public void setPtdao(PaymentTermDao ptdao)
		{
			this.ptdao = ptdao;
		} 
	/*==========================Search(All) Method==============================*/
		@Override
		public List<Object[]> searchPaymentTerms()
		{
			// TODO Auto-generated method stub
			
				List<Object[]> list=null;
				try
				{
					list=ptdao.searchPaymentTerms();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
		}
	/*==========================Search(With Id) Method==============================*/
		@Override
		public List<Object[]> searchPaymentTermsWithId(int id) 
		{
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
					list=ptdao.searchPaymentTermsWithId(id);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
		}
	/*==========================Update Method==============================*/
		@Override
		public String updatePaymentTerms(Object object)
		{
			// TODO Auto-generated method stub
			try
			{
				message=ptdao.updatePaymentTerms(object);	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*==========================Delete Method==============================*/
		@Override
		public String deletePaymentTerms(int id) 
		{
			// TODO Auto-generated method stub
			try
			{
				message=ptdao.deletePaymentTerms(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*==========================Add Duplicate Checking Method==============================*/
		@Override
		public int checkDuplicate(String checkPaymentTermName) 
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=ptdao.checkDuplicate(checkPaymentTermName);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
	/*==========================Edit Duplicate Checking Method==============================*/
		@Override
		public int checkEditDuplicate(String checkPaymentTermName, int id) {
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=ptdao.checkEditDuplicate(checkPaymentTermName,id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
		@Override
		public List<Object[]> basicSearchPaymentTerm(String label,
				String operator, String searchName) {
			
				try {
					objects = ptdao.basicSearchPaymentTerms(label, operator, searchName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				return objects;
			}
		}
	


	
	


