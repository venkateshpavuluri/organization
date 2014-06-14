/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.WFStep;

/**
 * @author A Nikesh
 *
 */
public interface WFStepDao {
	public String saveWFStepDetails(Object object,String userId,String userName);
	public Long duplicateWFStepCheck(String sid,String wfstepName);
	public List<Object[]> selectStageIds();
	public List<Object[]> selectRoleIds();
	public List<Object[]> searchWFStep();
	public List<Object[]> basicSearchWFStep(String label,String operator,String searchName);
	public List<Object[]> setWFStepAdvanceSearch(String wfstage);
	public List<Object[]> searchWFStepWithName(String wfstepname);
	public List<Object[]> selectWFStepNames();
	public List<Object[]> searchWFStepWithId(String wfstepName);
	public String updateWFStep(Object object);
	public Long updateDuplicateCheck(String wfstepName, String wfstepid, String wfstageid);
	public String wfstepDelete(String id);
}
