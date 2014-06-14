/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

/**
 * @author kirangangone
 *
 */
public interface physicalVerificationService {

	
	public List<Object>  addPhysicalVerification(Object object) ;
	public List<Object[]> basicSearchPV();
	public List<Object[]> basicSearchPhysicalVerification(String label, String operator,
			String searchName);
	public List<Object> editPVWithId(int id);
	public List<Object[]> getPhysicalVerificationAdvance(String columns,String opeator,String advanceSearchText);
	public String updatePhysicalVerification(Object object);
	public int updateCheckPhysicalVerification(String pno, int custId);

	public Long checkPhysicalVerification(String pno);
	public String deletePhysicalVerificationLine(int id);
	
	public List<Object[]> uomIdGet();
	public List<Object[]> materialIdGet();
	public List<Object[]> verificationTypeIdSelect();
	public List<Object[]> orgIdSelect();
	public List<Object[]> plantIdSelect();
	public List<Object[]> storageLocationIdSelect();
	public List<Object[]> getplantIdForOrg(String org);
	public List<Object[]> getLocationIdForOrg(String plant);
	public List<Object[]> getGoodsIdForOrg(String goods);
	public Double getTotalReceviedGood(String goods,String materialId);
	
	
	
	
	
}
