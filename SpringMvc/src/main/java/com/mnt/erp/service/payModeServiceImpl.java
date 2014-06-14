/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.payModeDao;

/**
 * @author devi
 *
 */
public class payModeServiceImpl implements payModeService{
	public String msg;
	List<Object[]> objects;

	payModeDao pmDao;

	public payModeDao getPmDao() {
		return pmDao;
	}

	public void setPmDao(payModeDao pmDao) {
		this.pmDao = pmDao;
	}
	
	public Long checkPayModeCount(String paymode) {
		Long l = pmDao.checkPayModeCount(paymode);
		return l;
	}
	public Long updateCheckPayMode(String paymode,int paymodeId) {
		Long l = pmDao.updateCheckPayMode(paymode, paymodeId);
		return l;
	}
	
	public String savePayModeDetails(Object object,String userId,String userName) {
		try {
			msg = pmDao.savePayModeDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	public List<Object[]> searchPayMode() {
		
		try {
			objects = pmDao.searchPayMode();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchPayModeWithId(int id) {
		List<Object[]> list = null;
		try {
			list = pmDao.searchPayModeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updatePayMode(Object object) {
		try {
			msg = pmDao.updatePayMode(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String deletePayMode(int id) {
		try {
			msg = pmDao.deletePayMode(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	public List<Object[]> selectPayMode() {
		
		try {
			objects =pmDao.selectPayMode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchPayMode(String label,String operator,String searchName){
		try {
			objects = pmDao.basicSearchPayMode(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
