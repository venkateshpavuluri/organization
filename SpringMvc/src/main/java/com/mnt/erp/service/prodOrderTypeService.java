package com.mnt.erp.service;

import java.util.List;

public interface prodOrderTypeService {
	public String saveProdOrderType(Object object);
	public long checkProdOrderType(String type);
	public List<Object[]> searchProdOrderType();
	public List<Object[]> searchProdOrderTypeWithId(int id);
	public List<Object[]> basicSearchProdOrderType(String label,String operator,String searchName);
	public String deleteProdOrderType(int id);
	public String updateProdOrderType(Object object);
	public List<Object[]> selectProdOrderType();
	public long updateCheckProdOrderType(String type, int Id);
}
