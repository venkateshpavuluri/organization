/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.dao.shortListDao;

/**
 * @author devi
 *
 */
public class shortListServiceImpl implements shortListService{
	List<Object[]> objects = null;
	shortListDao shDao;
	public shortListDao getShDao() {
		return shDao;
	}
	public void setShDao(shortListDao shDao) {
		this.shDao = shDao;
	}
	@Override
	public List<Object[]> selectVacancyIds() {
		try {
			objects = shDao.selectVacancyIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	
	
	public List<ApplicantBean> basicSearchShortList(int searchName){
		List<ApplicantBean> organizations=null;
		try
		{
			organizations=shDao.basicSearchApplicants(searchName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return organizations;
		
	}
	@Override
	public String shortListSave(String[] appId) {
		String msg=null;
		try{
			msg=shDao.shortListSave(appId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
		
}
