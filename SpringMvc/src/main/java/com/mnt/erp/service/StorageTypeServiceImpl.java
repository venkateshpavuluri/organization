/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.StorageTypeDao;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public class StorageTypeServiceImpl implements StorageTypeService{
	
	StorageTypeDao storageTypeDao;
	List<Object[]> objects;
	String msg;


	public StorageTypeDao getStorageTypeDao() {
		return storageTypeDao;
	}
	public void setStorageTypeDao(StorageTypeDao storageTypeDao) {
		this.storageTypeDao = storageTypeDao;
	}
	public String saveStorageTypeDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=storageTypeDao.saveStorageTypeDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateStorageTypeCheck(String storagetype) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=storageTypeDao.duplicateStorageTypeCheck(storagetype);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchStorageType() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=storageTypeDao.searchStorageType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchStorageTypeWithName(String storagetypename) {
		List<Object[]> list=null;
		try
		{
			
			list=storageTypeDao.searchStorageTypeWithName(storagetypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectStorageTypeNames() {

		 try
		 {
			 objects=storageTypeDao.selectStorageTypeNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchStorageTypeWithId(String storagetypename) {
		List<Object[]> list=null;
		try
		{
			list=storageTypeDao.searchStorageTypeWithId(storagetypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateStorageType(Object object) {
		try
		{
	 msg=storageTypeDao.updateStorageType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String storagetype,int storagetypeid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=storageTypeDao.updateDuplicateCheck(storagetype, storagetypeid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String storagetypeDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=storageTypeDao.storagetypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchStorageType(String label,String operator,String searchName){
		try {
			objects = storageTypeDao.basicSearchStorageType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	

}
