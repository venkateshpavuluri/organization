/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.ApplicantBean;

/**
 * @author devi
 *
 */
public interface shortListDao {
	public List<Object[]> selectVacancyIds();
	
	public List<ApplicantBean> basicSearchApplicants(int searchName);
	public String shortListSave(String[] appId);

	
}
