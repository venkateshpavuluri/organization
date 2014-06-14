package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SamplingTypeDao;

public class SamplingTypeServiceImpl implements SamplingTypeService{
	public SamplingTypeDao samplingTypeDao;
	String msg;
	

	public SamplingTypeDao getSamplingTypeDao() {
		return samplingTypeDao;
	}
	public void setSamplingTypeDao(SamplingTypeDao samplingTypeDao) {
		this.samplingTypeDao = samplingTypeDao;
	}
	public String saveSamplingType(Object object,String userId,String userName){
     try{
		   msg=samplingTypeDao.saveSamplingType(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public List<Object[]> searchSamplingType(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=samplingTypeDao.searchSamplingType(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editSamplingTypeWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=samplingTypeDao.editSamplingTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateSamplingType(Object object) {
		try
		{
	       msg=samplingTypeDao.updateSamplingType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String samplingTypeDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=samplingTypeDao.samplingTypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int samplingTypeDuplicate(String SamplingType){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=samplingTypeDao.samplingTypeDuplicate(SamplingType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int samplingTypeEditDuplicate(String SamplingType,int id){
		int list1=0;
		try
		{
			list1=samplingTypeDao.samplingTypeEditDuplicate(SamplingType, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchSamplingType(String label,
			String operator, String searchName) {
		List<Object[]> objects=null;
		try {
			objects = samplingTypeDao.basicSearchSamplingType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	
}
