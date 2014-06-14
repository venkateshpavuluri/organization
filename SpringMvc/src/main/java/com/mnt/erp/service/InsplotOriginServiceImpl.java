/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.InsplotOriginDao;

/**
 * @author A Nikesh
 *@version 1.0 31-10-2013
 *@build 0.0
 *
 */
public class InsplotOriginServiceImpl implements InsplotOriginService{

	InsplotOriginDao inspDao;
	List<Object[]> objects;
	String msg;

	
	
	public InsplotOriginDao getInspDao() {
		return inspDao;
	}
	public void setInspDao(InsplotOriginDao inspDao) {
		this.inspDao = inspDao;
	}
	public String saveInsplotOriginDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=inspDao.saveInsplotOriginDetails(object, userId, userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateInsplotOriginCheck(String insplotorigin) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=inspDao.duplicateInsplotOriginCheck(insplotorigin);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchInsplotOrigin() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=inspDao.searchInsplotOrigin();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchInsplotOriginWithName(String insplotoriginname) {
		List<Object[]> list=null;
		try
		{
			System.out.println("insplotorigin name in insplotorigin service vehTypeDao impl is   "+insplotoriginname);
			list=inspDao.searchInsplotOriginWithName(insplotoriginname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectInsplotOriginNames() {

		 try
		 {
			 objects=inspDao.selectInsplotOriginNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchInsplotOriginWithId(String insplotoriginname) {
		List<Object[]> list=null;
		try
		{
			list=inspDao.searchInsplotOriginWithId(insplotoriginname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateInsplotOrigin(Object object) {
		try
		{
	 msg=inspDao.updateInsplotOrigin(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String insplotorigin,int insplotoriginid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=inspDao.updateDuplicateCheck(insplotorigin, insplotoriginid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String insplotoriginDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=inspDao.insplotoriginDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchInsplotOrigin(String label,String operator,String searchName){
		try {
			objects = inspDao.basicSearchInsplotOrigin(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
