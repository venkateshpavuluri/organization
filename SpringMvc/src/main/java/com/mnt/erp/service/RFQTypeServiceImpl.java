/**
 
 *
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.RFQTypeDao;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class RFQTypeServiceImpl implements RFQTypeService
{
		public RFQTypeDao rfqdao;
		String message;
		List<Object[]> objects=null;
	/*==========================Add Method==============================*/
		@Override
		public String addRFQType(Object object,String userId,String userName) 
		{
			// TODO Auto-generated method stub
			message=rfqdao.addRFQType(object, userId, userName);
			
			 return message;
		}
	/*==========================Getter and Setter of Dao ==============================*/
		public RFQTypeDao getRfqdao()
		{
			return rfqdao;
		}
	
		public void setRfqdao(RFQTypeDao rfqdao)
		{
			this.rfqdao = rfqdao;
		}
	/*==========================Search(All) Method==============================*/
		@Override
		public List<Object[]> searchRFQType()
		{
			// TODO Auto-generated method stub
			
			List<Object[]> list=null;
			try
			{
				list=rfqdao.searchRFQType();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	/*==========================Search(With Id) Method==============================*/
		@Override
		public List<Object[]> searchRFQTypeWithId(int id)
		{
			// TODO Auto-generated method stub
			List<Object[]> list=null;
			try
			{
				list=rfqdao.searchRFQTypeWithId(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
	/*==========================Update Method==============================*/
		@Override
		public String updateRFQType(Object object)
		{
			// TODO Auto-generated method stub
			try
			{
				message=rfqdao.updateRFQType(object);	
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*==========================Delte Method==============================*/
		@Override
		public String deleteRFQType(int id) 
		{
			// TODO Auto-generated method stub
			try
			{
				message=rfqdao.deleteRFQType(id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return message;
		}
	/*==========================Add Duplicate Checking Method==============================*/
		@Override
		public int checkDuplicate(String checkRFQType) 
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=rfqdao.checkDuplicate(checkRFQType);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
	/*==========================Edit Duplicate Checking Method==============================*/
		@Override
		public int checkEditDuplicate(String checkRFQType, int id)
		{
			// TODO Auto-generated method stub
			int list1=0;
			try
			{
				list1=rfqdao.checkEditDuplicate(checkRFQType,id);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list1;
		}
		@Override
		public List<Object[]> basicSearchRFQType(String label, String operator,
				String searchName) {
			try {
				objects = rfqdao.basicSearchRFQtype(label, operator, searchName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return objects;
		}

}
