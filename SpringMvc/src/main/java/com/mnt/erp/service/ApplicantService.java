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
public interface ApplicantService {
    
	//public List<Object[]> getApplicant(String applicant);
	
	public String saveApplicantDetails(Object object,String userId,String userName);

	public List<Object[]> getApplicantIds();

	public List<ApplicantBean> searchApplicants();

	public List<ApplicantBean> searchApplicantWithId(int id);

	public String updateApplicant(Object object);

	public String deleteApplicant(int id);

	public Long duplicateCheck(String fname);

	public Long updateDuplicateCheck(String orgName, int orgId);
	
	public List<Object[]> selectApplicantDetails();
	
	public List<ApplicantBean> basicSearchApplicant(String label, String operator,
			String searchName);

}
