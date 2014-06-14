package com.mnt.erp.service;

import java.util.List;

public interface EmpAdvanceService {
	public String saveEmpAdvance(Object object,String userId,String userName);

	public List<Object[]> searchEmpAdvance(int id);

	public List<Object[]> editEmpAdvanceWithId(int id);

	public String updateEmpAdvance(Object object);

	public String EmpAdvanceDelete(int id);

	public int EmpAdvanceDuplicate(String EmpAdvance);

	public int EmpAdvanceEditDuplicate(String EmpAdvance,int id);

	public List<Object[]> basicSearchEmpAdvance(String label,String operator,String searchName);

}
