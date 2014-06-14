package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.qualificationDao;

public class qualificationServiceImpl implements qualificationService{
	List<Object[]> list = null;
	qualificationDao qudao;
	public qualificationDao getQudao() {
		return qudao;
	}
	public void setQudao(qualificationDao qudao) {
		this.qudao = qudao;
	}
	public String saveQualification(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = qudao.saveQualification(object,userId,userName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	} 
	@Override
	public long checkQualification(String type) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = qudao.checkQualification(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}
	@Override
	public List<Object[]> searchQualification() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = qudao.searchQualification();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchQualificationWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = qudao.searchQualificationWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchQualification(String label,String operator,String searchName){
		try {
			list = qudao.basicSearchQualification(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@Override
	public String deleteQualification(int id) {
		// TODO Auto-generated method stub
		String ip = null;
		try {
			ip = qudao.deleteQualification(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public String updateQualification(Object object) {
		// TODO Auto-generated method stub

		String ip = null;
		try {
			ip = qudao.updateQualification(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ip;
	}
	@Override
	public List<Object[]> selectQualification() {
		// TODO Auto-generated method stub
		
		try {
			list = qudao.searchQualification();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckQualification(String type, int Id) {
		long count = 0;
		try {
			count = qudao.updateCheckQualification(type, Id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}
