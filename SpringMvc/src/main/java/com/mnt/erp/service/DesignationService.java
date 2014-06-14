/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Designation;

/**
 * @author anikesh
 *
 */
public interface DesignationService {

	public String saveDesignationDetails(Object object,String userId,String userName);
	public Long duplicateDesignationCheck(String designation);
	public List<Object[]> searchDesignation();
	public List<Object[]> basicSearchDesignation(String label,String operator,String searchName);
	public List<Object[]> searchDesignationWithName(String designationname);
	public List<Object[]> selectDesignationNames();
	public List<Object[]> searchDesignationWithId(String designationname);
	public String updateDesignation(Object object);
	public Long updateDuplicateCheck(String designation, int designationid);
	public String designationDelete(int id);
	
	
}
