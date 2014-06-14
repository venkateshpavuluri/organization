/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;



/**
 * @author A Nikesh
 *
 */
public interface WFActionService {
	public String saveWFActionDetails(Object object,String userId,String userName);
	public Long duplicateWFActionCheck(String wfactionName,String wstep);
	public List<Object[]> selectStepIds();
	public List<Object[]> selectActionIds();
	public List<Object[]> searchWFAction();
	public List<Object[]> basicSearchWFAction(String label,String operator,String searchName);
	public List<Object[]> getWFActionAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> searchWFActionWithName(String wfactionname);
	public List<Object[]> selectWFActionNames();
	public List<Object[]> searchWFActionWithId(String wfactionname);
	public String updateWFAction(Object object);
	public Long updateDuplicateCheck(String wfaction,String wstep, String wfactionid);
	public String wfactionDelete(String id);
	

}
