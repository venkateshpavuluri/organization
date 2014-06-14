package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.PayElementDao;

public class PayElementServiceImpl implements PayElementService{
	PayElementDao dao;
	List<Object[]> list = null;
	public PayElementDao getDao() {
		return dao;
	}

	public void setDao(PayElementDao dao) {
		this.dao = dao;
	}
	@Override
	public String savePayElement(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = dao.savePayElement(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkPayElement(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = dao.checkPayElement(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchPayElement() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchPayElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchPayElementWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchPayElementWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchPayElement(String label,String operator,String searchName){
		try {
			list = dao.basicSearchPayElement(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deletePayElement(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = dao.deletePayElement(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updatePayElement(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = dao.updatePayElement(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectPayElement() {
		// TODO Auto-generated method stub
		
		try {
			list = dao.selectPayElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckPayElement(String type, int Id) {
		long count = 0;
		try {
			count = dao.updateCheckPayElement(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
}

