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
public interface ApplicantDao {
//public List<Object[]> setApplicantSearch(String name);
	
	public String saveApplicantDetails(Object object,String userId,String userName);

	public List<Object[]> getApplicantIds();

	public List<ApplicantBean> searchApplicants();

	public List<ApplicantBean> searchApplicantWithId(int id);

	public String updateApplicants(Object object);

	public String deleteApplicants(int id);

	public Long duplicateCheck(String fname);

	public Long updateDuplicateCheck(String fname, int aid);
	
	public List<Object[]> selectApplicantDetails();
	
	public List<ApplicantBean> basicSearchApplicants(String label, String operator,
			String searchName);

}
