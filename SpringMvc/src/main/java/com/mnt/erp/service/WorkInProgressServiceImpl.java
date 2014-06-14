/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.dao.WorkInProgressDao;

/**
 * @author Naresh
 *  @version 1.0  17-04-2014
 */
public class WorkInProgressServiceImpl implements WorkInProgressService{

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;
	Long l = 0l;
	
	@Autowired
	WorkInProgressDao wipDao;

	@Override
	public Long updateCheckWIP(String wipNo, int wipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long checkWIPCout(String wip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveWIPDetails(Object object) {
		try {
			flag = wipDao.saveWIPDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchWIP() {
		try {
			objects = wipDao.searchWIP();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchWIPWithId(int wipId) {
		try {
			obj = wipDao.searchWIPWithId(wipId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateWIP(Object object) {
		try {
			flag = wipDao.updateWIP(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteWIP(int wipId) {
		try {
			flag = wipDao.deleteWIP(wipId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchWIP(String label, String operator,
			String searchName) {
		try {
			objects = wipDao.basicSearchWIP(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	

}
