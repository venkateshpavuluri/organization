/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author A Nikesh
 *@version 1.0 31-10-2013
 *@build 0.0
 *
 */
public interface InsplotOriginService {
	public String saveInsplotOriginDetails(Object object,String userId,String userName);
	public Long duplicateInsplotOriginCheck(String insplotorigin);
	public List<Object[]> searchInsplotOrigin();
	public List<Object[]> searchInsplotOriginWithName(String insplotoriginname);
	public List<Object[]> selectInsplotOriginNames();
	public List<Object[]> searchInsplotOriginWithId(String insplotoriginname);
	public String updateInsplotOrigin(Object object);
	public Long updateDuplicateCheck(String insplotorigin, int insplotoriginid);
	public String insplotoriginDelete(int id);
	
	public List<Object[]> basicSearchInsplotOrigin(String label,String operator,String searchName);

}
