package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EmpQualificationDao;
import com.mnt.erp.dao.MaintenancePlanDao;

public class EmpQualificationServiceImpl implements EmpQualificationService{

	

	List<Object[]> objects = null;
	String sus=null;
private EmpQualificationDao empqdao;


public EmpQualificationDao getEmpqdao() {
	return empqdao;
}
public void setEmpqdao(EmpQualificationDao empqdao) {
	this.empqdao = empqdao;
}
public Long checkEmpQualificationCout(String equipment,String planedDate){
		Long l = empqdao.checkEmpQualificationCout(equipment, planedDate);
		return l;
	}
public Long updateCheckEmpQualification(String equipment,String planedDate,int maintenancePlanId){
		Long l = empqdao.updateCheckEmpQualification(equipment, planedDate, maintenancePlanId);
		return l;
	}
	
	public String saveEmpQualificationDetails(Object object,String userId,String userName) {
		try {
			sus = empqdao.saveEmpQualificationDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchEmpQualification() {
		
		try {
			objects = empqdao.searchEmpQualification();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchEmpQualificationWithId(int id) {
		List<Object[]> list = null;
		try {
			list = empqdao.searchEmpQualificationWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateEmpQualification(Object object) {
		try {
			sus = empqdao.updateEmpQualification(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteEmpQualification(int id) {
		try {
			sus = empqdao.deleteEmpQualification(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectQualification() {
		
		try {
			objects = empqdao.selectQualification();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public List<Object[]> selectEmployee(){
		try {
			objects = empqdao.selectEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicSearchEmpQualification(String label,String operator,String searchName){
		try {
			objects = empqdao.basicSearchEmpQualification(label,operator,searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	
	
}
