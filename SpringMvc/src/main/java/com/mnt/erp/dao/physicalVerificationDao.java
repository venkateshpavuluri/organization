/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author kirangangone
 *
 */
public interface physicalVerificationDao {

	
	public List<Object>  addPhysicalVerification(Object object);
	public List<Object[]> basicSearchPV();
	public List<Object> editPVWithId(int cId);
	public List<Object[]> basicSearchPhysicalVerification(String label, String operator,String searchName); 
	public List<Object[]> setPhysicalVerificationAdvanceSearch(String purchase);
	public String updatePhysicalVerificationDao(Object object);
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
	public List<Object[]> getGoodsIdForOrg(String plant);
	public Double getTotalReceviedGood(String good,String materialId);
	
	
	
}
