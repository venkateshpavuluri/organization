/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WFStage;

/**
 * @author A Nikesh
 *
 */
public interface WFStageService {
	public String saveWFStageDetails(Object object,String userId,String userName);
	public Long duplicateWFStageCheck(String wfstage);
	public List<Object[]> selectProcessIds();
	public List<Object[]> searchWFStage();
	public List<Object[]> basicSearchWFStage(String label,String operator,String searchName);
	
	public List<Object[]> getWFStageAdvance(String columns,String opeator,String advanceSearchText);
	
	public List<Object[]> searchWFStageWithName(String wfstageName);
	public List<Object[]> selectWFStageNames();
	public List<Object[]> searchWFStageWithId(String wfstageName);
	public String updateWFStage(Object object);
	public Long updateDuplicateCheck(String wfstageName, String wfstageid);
	public String wfstageDelete(String id);
}
