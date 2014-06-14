/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WFProcess;

/**
 * @author Administrator
 *
 */

public interface WFProcessService {
	public String saveWFProcessDetails(Object object,String userId,String userName);
	public Long duplicateWFProcessCheck(String wfprocess);
	public List<Object[]> searchWFProcess();
	public List<Object[]> basicSearchWFProcess(String label,String operator,String searchName);
	public List<Object[]> searchWFProcessWithName(String wfprocessname);
	public List<Object[]> selectWFProcessNames();
	public List<Object[]> searchWFProcessWithId(String wfprocessname);
	public String updateWFProcess(Object object);
	public Long updateDuplicateCheck(String wfprocess, String wfprocessid);
	public String wfprocessDelete(String id);
}
