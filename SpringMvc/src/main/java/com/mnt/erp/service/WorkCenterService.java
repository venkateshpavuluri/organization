
/*
 * @Copyright MNTSOFT
 * 
 */


package com.mnt.erp.service;

import java.util.List;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface WorkCenterService {

 
	public String saveWorkCenterDetails(Object object);
	
	public List<Object[]> searchWorkCenter();
	
	public List<Object[]> searchWorkCenterWithId(int id);
	public String updateWorkCenter(Object object);
	
	public String deleteWorkCenter(int id);
	
	public int checkWorkCenter(String wname);

	public int updateCheckWorkCenter(String wname, int id);
	
	public List<Object[]> getShopIds();
	public List<Object[]> basicSearchWorkCenter(String label,String operator,String searchName);
}
