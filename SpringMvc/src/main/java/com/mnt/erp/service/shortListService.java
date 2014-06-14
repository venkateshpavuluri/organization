/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ApplicantBean;

/**
 * @author devi
 *
 */
public interface shortListService {
	public List<Object[]> selectVacancyIds();
	
	public List<ApplicantBean> basicSearchShortList(int searchName);
	public String shortListSave(String[] appId);
}
