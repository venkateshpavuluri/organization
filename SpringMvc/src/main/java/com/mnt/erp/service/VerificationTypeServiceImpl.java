package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.dao.VerificationTypeDao;

public class VerificationTypeServiceImpl implements VerificationTypeService {
	String message;
	VerificationTypeDao vtdao;
	List<Object[]> objects;
	
	public VerificationTypeDao getVtdao() {
		return vtdao;
	}
	public void setVtdao(VerificationTypeDao vtdao) {
		this.vtdao = vtdao;
	}
	@Override
	public String saveVerificationTypeservice(Object object,String userId,String userName) {
		try {
			message = vtdao.saveVerificationType(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return message;
	}
	@Override
	public Long getVerificationTypeCount(String name) {
		Long id = 0L;
		try {
			id = vtdao.getVerificationTypeCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public List<Object[]> searchVerificationType() {
		try {
			objects = vtdao.searchVerificationType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> selectVerificationType() {
		try {
			objects = vtdao.selectVerificationTypeIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	@Override
	public String updateVerificationType(Object object) {
		try {
			message = vtdao.updateVerificationType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	@Override
	public String deleteVerificationType(int id) {
		try {
			message =vtdao.deleteVerificationType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	@Override
	public Long getVerificationTypeCountedit(String name, int verificationtypeid) {
		Long id = 0L;
		try {
			id = vtdao.getVerificationTypeCountedit(name, verificationtypeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public List<Object[]> basicSearchVerificationType(String label,
			String operator, String searchName) {
		try {
			objects = vtdao.basicSearchVerificationType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	@Override
	public List<Object[]> searchVerificationTypeWithId(int id) {
		try {
			objects = vtdao.searchVerificationtypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
