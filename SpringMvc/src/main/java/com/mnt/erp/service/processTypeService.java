package com.mnt.erp.service;

import java.util.List;

public interface processTypeService {
	public String saveProcessType(Object object);
	public long checkProcessType(String type);
	public List<Object[]> searchProcessType();
	public List<Object[]> searchProcessTypeWithId(int id);
	public List<Object[]> basicSearchProcessType(String label,String operator,String searchName);
	public String deleteProcessType(int id);
	public String updateProcessType(Object object);
	public List<Object[]> selectProcessType();
	public long updateCheckProcessType(String type, int Id);
}
