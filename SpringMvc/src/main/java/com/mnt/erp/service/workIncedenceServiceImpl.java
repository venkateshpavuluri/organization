package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.workIncedenceDao;

public class workIncedenceServiceImpl implements workIncedenceService{
	List<Object[]> list = null;
	workIncedenceDao wdao;
	public workIncedenceDao getWdao() {
		return wdao;
	}
	public void setWdao(workIncedenceDao wdao) {
		this.wdao = wdao;
	}
	public String saveWorkIncedence(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = wdao.saveWorkIncedence(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkWorkIncedence(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = wdao.checkWorkIncedence(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchWorkIncedence() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = wdao.searchWorkIncedence();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchWorkIncedenceWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = wdao.searchWorkIncedenceWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchWorkIncedence(String label,String operator,String searchName){
		try {
			list = wdao.basicSearchWorkIncedence(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteWorkIncedence(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = wdao.deleteWorkIncedence(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateWorkIncedence(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = wdao.updateWorkIncedence(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectWorkIncedence() {
		// TODO Auto-generated method stub
		
		try {
			list = wdao.searchWorkIncedence();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckWorkIncedence(String type, int Id) {
		long count = 0;
		try {
			count = wdao.updateCheckWorkIncedence(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}
