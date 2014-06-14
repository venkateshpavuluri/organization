package com.mnt.erp.service;

import java.util.List;

public interface PayElementService {
	public String savePayElement(Object object,String userId,String userName);
	public long checkPayElement(String type);
	public List<Object[]> searchPayElement();
	public List<Object[]> searchPayElementWithId(int id);
	public List<Object[]> basicSearchPayElement(String label,String operator,String searchName);
	public String deletePayElement(int id);
	public String updatePayElement(Object object);
	public List<Object[]> selectPayElement();
	public long updateCheckPayElement(String type, int Id);
}
