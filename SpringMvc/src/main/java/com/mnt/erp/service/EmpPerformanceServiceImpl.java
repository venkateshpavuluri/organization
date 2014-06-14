package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EmpPerformance;
import com.mnt.erp.dao.EmpPerformanceDao;

public class EmpPerformanceServiceImpl  implements EmpPerformanceService{
	List<Object[]> objects = null;
	String sus=null;
	
	private EmpPerformanceDao empPerformanceDao;
	
	
	
	public EmpPerformanceDao getEmpPerformanceDao() {
		return empPerformanceDao;
	}
	public void setEmpPerformanceDao(EmpPerformanceDao EmpPerformanceDao) {
		this.empPerformanceDao = EmpPerformanceDao;
	}
	public Long checkEmpPerformance(String employee){
		Long l = empPerformanceDao.checkEmpPerformance(employee);
		return l;
	}
	public Long updateCheckEmpPerformance(String fiscalYear,int fiscalYearId) {
		Long l = empPerformanceDao.updateCheckEmpPerformance(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveEmpPerformanceDetails(Object object) {
		try {
			sus = empPerformanceDao.saveEmpPerformanceDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchEmpPerformance() {
		
		try {
			objects = empPerformanceDao.searchEmpPerformance();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<EmpPerformance> searchEmpPerformanceWithId(int id) {
		List<EmpPerformance> list = null;
		try {
			list = empPerformanceDao.searchEmpPerformanceWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateEmpPerformance(Object object) {
		try {
			sus = empPerformanceDao.updateEmpPerformance(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteEmpPerformance(int id) {
		try {
			sus = empPerformanceDao.deleteEmpPerformance(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	
	public List<Object[]> selectEmployee() {
		
		try {
			objects = empPerformanceDao.selectEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectKpi() {
		
		try {
			objects = empPerformanceDao.selectKpi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
public List<Object[]> selectStatus() {
		
		try {
			objects = empPerformanceDao.selectStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicSearchEmpPerformance(String label,String operator,String searchName){
		try {
			objects = empPerformanceDao.basicSearchEmpPerformance(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteEmpPerformanceDetail(int kk){
		String msg = null;
		try {
			msg = empPerformanceDao.deleteEmpPerformanceDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	
}
