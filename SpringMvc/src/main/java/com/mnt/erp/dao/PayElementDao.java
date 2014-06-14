package com.mnt.erp.dao;

import java.util.List;

public interface PayElementDao {
	public String savePayElement(Object object,String userid,String userName);
	public long checkPayElement(String type);
	public List<Object[]> searchPayElement();
	public String deletePayElement(int id);
	public List<Object[]> searchPayElementWithId(int id);
	public List<Object[]> basicSearchPayElement(String label,String operator,String searchName);
	public String updatePayElement(Object object);
	public List<Object[]> selectPayElement();
	public long updateCheckPayElement(String type,int Id);

}
