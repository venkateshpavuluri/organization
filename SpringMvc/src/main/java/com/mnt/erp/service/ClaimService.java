/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ClaimBean;


/**
 * @author devi
 *
 */
public interface ClaimService {
	public String saveClaim(Object object,String userId,String userName);
	 public List<Object[]> getClaimTypeIds();
	 public List<Object[]> getEmployeeIds();
	 public List<Object[]> getStatusIds();
	 public List<Object[]> searchClaim();
	public List<Object[]> basicSearchClaim(String dbField,String operation,String basicSearchId);
	public String deleteChildRecords(Object object);
	public String deleteClaim(int claimId);
	public List<ClaimBean> editClaimDetails(int claimId);
	public String updateClaimDetails(Object object);

}
