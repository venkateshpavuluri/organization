package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.projectPhaseDao;

public class projectPhaseServiceImpl implements projectPhaseService{
	projectPhaseDao ppDao;
	List<Object[]> list=null;
	List<Object[]> objects;

	public projectPhaseDao getPpDao() {
		return ppDao;
	}

	public void setPpDao(projectPhaseDao ppDao) {
		this.ppDao = ppDao;
	}
	public String saveProjectPhase(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = ppDao.saveProjectPhase(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkProjectPhase(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = ppDao.checkProjectPhase(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchProjectPhase() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = ppDao.searchProjectPhase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchProjectPhaseWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = ppDao.searchProjectPhaseWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchProjectPhase(String label,String operator,String searchName){
		try {
			list = ppDao.basicSearchProjectPhase(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteProjectPhase(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = ppDao.deleteProjectPhase(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateProjectPhase(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = ppDao.updateProjectPhase(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectProjectPhase() {
		// TODO Auto-generated method stub
		
		try {
			list =ppDao.searchProjectPhase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckProjectPhase(String type, int Id) {
		long count = 0;
		try {
			count = ppDao.updateCheckProjectPhase(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public List<Object[]> selectProjectService() {
        try{
			
			objects=ppDao.getProjectIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}


}
