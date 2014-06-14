package com.mnt.erp.service;

import java.util.List;

public interface ValuationCategoryService {

	public String saveValuationCategoryDetails(Object object,String userId,String userName);

	public List<Object[]> searchValuationCategory();

	public List<Object[]> searchValuationCategoryWithId(int id);

	public String updateValuationCategory(Object object);

	public String deleteValuationCategory(int id);

	public List<Object[]> selectValuationCategory();

	public int checkValuationCategory(String type);

	public int updateCheckValuationCategory(String value, int valueId);
	
	public List<Object[]> basicSearchValuationCategory(String label,String operator,String searchName);
}
