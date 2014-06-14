package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EmpAdvanceDao;

public class EmpAdvanceServiceImpl implements EmpAdvanceService{
	public EmpAdvanceDao empAdvanceDao;
	public String msg;
	List<Object[]> objects;

	
	/* getter methhods of EmpAdvanceDao */
	
	
	
	public String saveEmpAdvance(Object object,String userId,String userName){
     try{
		   msg=empAdvanceDao.saveEmpAdvance(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public EmpAdvanceDao getEmpAdvanceDao() {
		return empAdvanceDao;
	}
	public void setEmpAdvanceDao(EmpAdvanceDao empAdvanceDao) {
		this.empAdvanceDao = empAdvanceDao;
	}
	public List<Object[]> searchEmpAdvance(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=empAdvanceDao.searchEmpAdvance(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editEmpAdvanceWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=empAdvanceDao.editEmpAdvanceWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateEmpAdvance(Object object) {
		try
		{
	       msg=empAdvanceDao.updateEmpAdvance(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String EmpAdvanceDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=empAdvanceDao.EmpAdvanceDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int EmpAdvanceDuplicate(String EmpAdvance){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=empAdvanceDao.EmpAdvanceDuplicate(EmpAdvance);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int EmpAdvanceEditDuplicate(String EmpAdvance,int id){
		int list1=0;
		try
		{
			list1=empAdvanceDao.EmpAdvanceEditDuplicate(EmpAdvance, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchEmpAdvance(String label,
			String operator, String searchName) {
		try {
			objects = empAdvanceDao.basicSearchEmpAdvance(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
}
