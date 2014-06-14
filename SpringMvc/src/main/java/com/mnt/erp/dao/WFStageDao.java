/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.WFStage;

/**
 * @author A Nikesh
 *
 */
public interface WFStageDao {
	public String saveWFStageDetails(Object object,String userId,String userName);
	public Long duplicateWFStageCheck(String wfstage);
	public List<Object[]> selectProcessIds();
	public List<Object[]> searchWFStage();
	public List<Object[]> basicSearchWFStage(String label,String operator,String searchName);
	public List<Object[]> searchWFStageWithName(String wfstagename);
	public List<Object[]> selectWFStageNames();
	public List<Object[]> searchWFStageWithId(String wfstageName);
	public String updateWFStage(Object object);
	public Long updateDuplicateCheck(String wfstageName, String wfstageid);
	public String wfstageDelete(String id);
	public List<Object[]> setWFStageAdvanceSearch(String wfstage);
	
}
