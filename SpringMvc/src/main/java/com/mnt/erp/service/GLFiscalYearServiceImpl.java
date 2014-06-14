package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.AssertTypeDao;
import com.mnt.erp.dao.GLFiscalYearDao;

public class GLFiscalYearServiceImpl implements GLFiscalYearService {
	List<Object[]> objects = null;
	String sus=null;
	public GLFiscalYearDao glfDao;


	

	public GLFiscalYearDao getGlfDao() {
		return glfDao;
	}
	public void setGlfDao(GLFiscalYearDao glfDao) {
		this.glfDao = glfDao;
	}
	public Long checkGLFiscalYear(String fiscalYear){
		Long l = glfDao.checkGLFiscalYear(fiscalYear);
		return l;
	}
	public Long updateCheckGLFiscalYear(String fiscalYear,int fiscalYearId) {
		Long l = glfDao.updateCheckGLFiscalYear(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveGLFiscalYearDetails(Object object,String userId,String userName) {
		try {
			sus = glfDao.saveGLFiscalYearDetails(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchGLFiscalYear() {
		
		try {
			objects = glfDao.searchGLFiscalYear();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchGLFiscalYearWithId(int id) {
		List<Object[]> list = null;
		try {
			list = glfDao.searchGLFiscalYearWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateGLFiscalYear(Object object) {
		try {
			sus = glfDao.updateGLFiscalYear(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteGLFiscalYear(int id) {
		try {
			sus = glfDao.deleteGLFiscalYear(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectGLFiscalYear() {
		
		try {
			objects = glfDao.selectGLFiscalYear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchGLFiscalYear(String label,String operator,String searchName){
		try {
			objects = glfDao.basicSearchGLFiscalYear(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
