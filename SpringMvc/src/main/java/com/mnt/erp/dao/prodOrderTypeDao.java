package com.mnt.erp.dao;

import java.util.List;

public interface prodOrderTypeDao {
	public String saveProdOrderType(Object object);
	public long checkProdOrderType(String type);
	public List<Object[]> searchProdOrderType();
	public String deleteProdOrderType(int id);
	public List<Object[]> searchProdOrderTypeWithId(int id);
	public List<Object[]> basicSearchProdOrderType(String label,String operator,String searchName);
	public String updateProdOrderType(Object object);
	public List<Object[]> selectProdOrderType();
	public long updateCheckProdOrderType(String type, int Id);

}
