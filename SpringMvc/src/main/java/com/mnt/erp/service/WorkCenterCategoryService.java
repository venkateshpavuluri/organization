/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 28-10-2013
 * @build 0.0
 * 
 */
public interface WorkCenterCategoryService {

	public String addWorkCenterCategory(Object object,String userId,String userName);

	public List<Object[]> searchWorkCenterCategory();

	public List<Object[]> searchWorkCenterCategoryWithId(int id);

	public String updateWorkCenterCategory(Object object);

	public String deleteWorkCenterCategory(int id);

	public int checkDuplicate(String checkWorkCenterCategory);

	public int checkEditDuplicate(String checkWorkCenterCategory, int id);

	public List<Object[]> basicSearchWCC(String label, String operator,
			String searchName);

	public List<Object[]> WorkCeterCategoryIdGet();

}
