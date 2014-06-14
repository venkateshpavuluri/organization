/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.WFAction;

/**
 * @author A Nikesh
 *
 */
public interface WFActionDao {
	public String saveWFActionDetails(Object object,String userId,String userName);
	public Long duplicateWFActionCheck(String wfactionName,String wstep);
	public List<Object[]> selectStepIds();
	public List<Object[]> selectActionIds();
	public List<Object[]> searchWFAction();
	public List<Object[]> basicSearchWFAction(String label,String operator,String searchName);
	public List<Object[]> setWFActionAdvanceSearch(String wfstage);
	public List<Object[]> searchWFActionWithName(String wfactionname);
	public List<Object[]> selectWFActionNames();
	public List<Object[]> searchWFActionWithId(String wfactionname);
	public String updateWFAction(Object object);
	public Long updateDuplicateCheck(String wfaction,String wstep, String wfactionid);
	public String wfactionDelete(String id);

}
