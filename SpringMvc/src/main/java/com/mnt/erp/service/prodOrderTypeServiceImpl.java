package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.prodOrderTypeDao;

public class prodOrderTypeServiceImpl implements prodOrderTypeService {
	List<Object[]> list = null;
	prodOrderTypeDao dao;
	public prodOrderTypeDao getDao() {
		return dao;
	}
	public void setDao(prodOrderTypeDao dao) {
		this.dao = dao;
	}
	
	public String saveProdOrderType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = dao.saveProdOrderType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkProdOrderType(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = dao.checkProdOrderType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchProdOrderType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchProdOrderType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchProdOrderTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = dao.searchProdOrderTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchProdOrderType(String label,String operator,String searchName){
		try {
			list = dao.basicSearchProdOrderType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteProdOrderType(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = dao.deleteProdOrderType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateProdOrderType(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = dao.updateProdOrderType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectProdOrderType() {
		// TODO Auto-generated method stub
		
		try {
			list = dao.selectProdOrderType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProdOrderType(String type, int Id) {
		long count = 0;
		try {
			count = dao.updateCheckProdOrderType(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
}
