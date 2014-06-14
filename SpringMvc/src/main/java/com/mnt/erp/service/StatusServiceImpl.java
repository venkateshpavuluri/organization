package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.StatusDao;

/**
 * @author ybusireddy
 * @version 23-09-2013
 */

public class StatusServiceImpl implements StatusService {

	StatusDao dao;
	List<Object[]> objects;
	public StatusDao getDao() {
		return dao;
	}

	public void setDao(StatusDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveStatusDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String ss = null;
		try {
			ss = dao.saveStatusDetails(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public List<Object[]> searchStatus() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchStatusWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchStatusWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateStatus(Object object) {
		// TODO Auto-generated method stub
		String ss = null;
		try {
			ss = dao.updateStatus(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public String deleteStatus(int id) {
		// TODO Auto-generated method stub

		String is = null;
		try {
			is = dao.deleteStatus(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectStatusId() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.selectStatusId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkStatus(String type) {
		// TODO Auto-generated method stub
		int s = 0;
		try {
			s = dao.checkStatus(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public int updateCheckStatus(String status, int statusId) {
		int s = 0;
		try {
			s = dao.updateCheckStatus(status, statusId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Object[]> basicSearchStatus(String label, String operator,
			String searchName) {
		try {
			objects = dao.basicSearchStatus(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	public String getStatus(int statusId){
		// TODO Auto-generated method stub

				String is = null;
				try {
					is = dao.getStatus(statusId);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return is;
	}

}
