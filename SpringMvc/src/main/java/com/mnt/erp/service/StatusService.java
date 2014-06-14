package com.mnt.erp.service;

import java.util.List;

/**
 * @author ybusireddy
 * @version 23-09-2013
 */

public interface StatusService {
	public String saveStatusDetails(Object object,String userId,String userName);

	public List<Object[]> searchStatus();

	public List<Object[]> searchStatusWithId(int id);

	public String updateStatus(Object object);

	public String deleteStatus(int id);

	public List<Object[]> selectStatusId();

	public int checkStatus(String type);

	public int updateCheckStatus(String status, int statusId);
	
	public List<Object[]> basicSearchStatus(String label,String operator,String searchName);
	public String getStatus(int statusId);

}
