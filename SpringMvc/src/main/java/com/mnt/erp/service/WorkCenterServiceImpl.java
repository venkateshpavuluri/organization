
/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.WorkCenterDao;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class WorkCenterServiceImpl implements WorkCenterService{
	List<Object[]> objects = null;
	

	public WorkCenterDao wcenterDao;
	
	public WorkCenterDao getWcenterDao() {
		return wcenterDao;
	}
	public void setWcenterDao(WorkCenterDao wcenterDao) {
		this.wcenterDao = wcenterDao;
	}
	
	String msg;
	public String saveWorkCenterDetails(Object object){
		msg=wcenterDao.saveWorkCenterDetails(object);
		return msg;
	}
	
	public List<Object[]> searchWorkCenter(){
		List<Object[]> list=null;
		try{
			list=wcenterDao.searchWorkCenter();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> searchWorkCenterWithId(int id){
		List<Object[]> list=null;
		try{
			list=wcenterDao.searchWorkCenterWithId(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;	
	}
	public String updateWorkCenter(Object object){
		
		String msg=null;
		try{
			msg=wcenterDao.updateWorkCenter(object);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return msg;	
	}
	
	public String deleteWorkCenter(int id){
		String msg=null;
		try{
			msg=wcenterDao.deleteWorkCenter(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return msg;
	}
	public int checkWorkCenter(String wname){
		int list=0;
		try{
			list=wcenterDao.checkWorkCenter(wname);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public int updateCheckWorkCenter(String wname, int id){
		
		int list=0;
		try{
			list=wcenterDao.updateCheckWorkCenter(wname, id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> basicSearchWorkCenter(String label, String operator,
			String searchName) {
		try {
			objects = wcenterDao.basicSearchWorkCenter(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> getShopIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = wcenterDao.getShopIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	}

