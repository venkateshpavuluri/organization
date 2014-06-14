package com.mnt.erp.service;

import java.util.List;

public interface GLFiscalYearService {

	public Long updateCheckGLFiscalYear(String fiscalYear,int fiscalYearId);

	public Long checkGLFiscalYear(String fiscalYear);
	
	public String saveGLFiscalYearDetails(Object object,String userId,String userName);

	public List<Object[]> searchGLFiscalYear();

	public List<Object[]> searchGLFiscalYearWithId(int id);

	public String updateGLFiscalYear(Object object);

	public String deleteGLFiscalYear(int id);
	
	public List<Object[]> selectGLFiscalYear();
	
	public List<Object[]> basicSearchGLFiscalYear(String label,String operator,String searchName);

}
