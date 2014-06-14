package com.mnt.erp.service;

import java.util.List;

/**
 * @author ybusireddy
 * @version 19-09-2013
 */
public interface IndustryService {

	public String saveIndustryDetails(Object object,String userId,String userName);

	public List<Object[]> searchIndustry();

	public List<Object[]> searchIndustryWithId(int id);

	public String updateIndustry(Object object);

	public String deleteIndustry(int id);

	public List<Object[]> selectIndustryId();

	public int checkIndustryType(String type);

	public int updateCheckIndustryType(String indType, int indId);
	public List<Object[]> basicSearchIndustryType(String label,String operator,String searchName);

}
